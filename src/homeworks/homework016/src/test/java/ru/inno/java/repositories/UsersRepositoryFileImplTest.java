package ru.inno.java.repositories;

import ru.inno.java.model.User;
import ru.inno.java.repositories.UsersRepository;
import ru.inno.java.repositories.UsersRepositoryFileImpl;
import ru.inno.java.support.DuplicateUserIdException;
import ru.inno.java.support.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class UsersRepositoryFileImplTest {

    @TempDir
    Path tempDir;

    private UsersRepository repo;
    private Path usersFile;

    @BeforeEach
    void setup() {
        usersFile = tempDir.resolve("src/main/java/ru/inno/java/users.txt");
        repo = new UsersRepositoryFileImpl(usersFile);
    }

    private User sampleUser(String id) {
        return new User(
                id,
                LocalDateTime.now(),
                "login_" + id.substring(0, 5),
                "Pass_123",
                "Pass_123",
                "Иванов",
                "Иван",
                null,
                20,
                true
        );
    }

    @Test
    void createAndFindByIdAndFindAll() {
        User u1 = sampleUser(UUID.randomUUID().toString());
        User u2 = sampleUser(UUID.randomUUID().toString());

        repo.create(u1);
        repo.create(u2);

        assertEquals(2, repo.findAll().size());
        assertEquals(u1.getLogin(), repo.findById(u1.getId()).getLogin());
    }

    @Test
    void updateExistingUser() {
        User u1 = sampleUser(UUID.randomUUID().toString());
        repo.create(u1);

        User updated = new User(
                u1.getId(),
                u1.getCreatedAt(),
                u1.getLogin(),
                u1.getPassword(),
                u1.getConfirmPassword(),
                u1.getLastName(),
                u1.getFirstName(),
                u1.getPatronymic(),
                33,
                false
        );
        repo.update(updated);

        assertEquals(33, repo.findById(u1.getId()).getAge());
        assertFalse(repo.findById(u1.getId()).isWorker());
    }

    @Test
    void deleteByIdAndExceptionOnMissing() {
        User u1 = sampleUser(UUID.randomUUID().toString());
        repo.create(u1);
        assertEquals(1, repo.findAll().size());

        repo.deleteById(u1.getId());
        assertEquals(0, repo.findAll().size());

        assertThrows(UserNotFoundException.class, () -> repo.findById(u1.getId()));
    }

    @Test
    void duplicateIdThrows() {
        String id = UUID.randomUUID().toString();
        User u1 = sampleUser(id);
        User u2 = sampleUser(id);

        repo.create(u1);
        assertThrows(DuplicateUserIdException.class, () -> repo.create(u2));
    }
}


