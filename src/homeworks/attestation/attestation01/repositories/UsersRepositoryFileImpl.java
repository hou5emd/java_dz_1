package homeworks.attestation.attestation01.repositories;

import homeworks.attestation.attestation01.model.User;
import homeworks.attestation.attestation01.support.DuplicateUserIdException;
import homeworks.attestation.attestation01.support.UserNotFoundException;
import homeworks.attestation.attestation01.support.UserFileReadWriteException;
import homeworks.attestation.attestation01.support.UserParseException;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class UsersRepositoryFileImpl implements UsersRepository {
    private static final String FILE_NAME = "users.txt";
    private final Path filePath;

    public UsersRepositoryFileImpl() {
        this(Paths.get(FILE_NAME));
    }

    public UsersRepositoryFileImpl(Path filePath) {
        this.filePath = filePath;
        if (!Files.exists(this.filePath)) {
            try {
                if (this.filePath.getParent() != null && !Files.exists(this.filePath.getParent())) {
                    Files.createDirectories(this.filePath.getParent());
                }
                Files.createFile(this.filePath);
            } catch (IOException e) {
                throw new UserFileReadWriteException("Ошибка создания файла пользователей", e);
            }
        }
    }

    private List<User> readAllUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                users.add(mapFromString(line));
            }
        } catch (IOException e) {
            throw new UserFileReadWriteException("Ошибка чтения файла пользователей", e);
        }
        return users;
    }

    private void writeAllUsers(List<User> users) {
        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            for (User user : users) {
                writer.write(user.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new UserFileReadWriteException("Ошибка записи файла пользователей", e);
        }
    }

    private User mapFromString(String line) {
        String[] parts = line.split("\\|");
        if (parts.length < 10)
            throw new UserParseException("Некорректная строка пользователя: " + line);
        try {
            return new User(parts[0], LocalDateTime.parse(parts[1]), parts[2], parts[3], parts[4],
                    parts[5], parts[6], parts[7].isEmpty() ? null : parts[7],
                    parts[8].isEmpty() ? null : Integer.valueOf(parts[8]),
                    Boolean.parseBoolean(parts[9]));
        } catch (Exception ex) {
            throw new UserParseException("Ошибка парсинга строки пользователя: " + line, ex);
        }
    }

    @Override
    public void create(User user) {
        List<User> users = readAllUsers();
        boolean exists = users.stream().anyMatch(u -> u.getId().equals(user.getId()));
        if (exists) {
            throw new DuplicateUserIdException("Пользователь с таким ID уже существует");
        }
        users.add(user);
        writeAllUsers(users);
    }

    @Override
    public User findById(String id) {
        return readAllUsers().stream().filter(u -> u.getId().equals(id)).findFirst()
                .orElseThrow(() -> new UserNotFoundException(
                        "Пользователя с заданным идентификатором не существует"));
    }

    @Override
    public List<User> findAll() {
        return readAllUsers();
    }

    @Override
    public void update(User user) {
        List<User> users = readAllUsers();
        boolean found = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                users.set(i, user);
                found = true;
                break;
            }
        }
        if (!found) {
            users.add(user);
        }
        writeAllUsers(users);
    }

    @Override
    public void deleteById(String id) {
        List<User> users = readAllUsers();
        boolean removed = users.removeIf(u -> u.getId().equals(id));
        if (!removed)
            throw new UserNotFoundException(
                    "Пользователя с заданным идентификатором не существует");
        writeAllUsers(users);
    }

    @Override
    public void deleteAll() {
        writeAllUsers(new ArrayList<>());
    }

    @Override
    public List<User> findByAge(int age) {
        return readAllUsers().stream().filter(u -> u.getAge() != null && u.getAge() == age)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> findByIsWorker(boolean isWorker) {
        return readAllUsers().stream().filter(u -> u.isWorker() == isWorker)
                .collect(Collectors.toList());
    }
}

