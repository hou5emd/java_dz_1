package ru.inno.java;


import ru.inno.java.model.User;
import ru.inno.java.repositories.UsersRepository;
import ru.inno.java.repositories.UsersRepositoryFileImpl;
import ru.inno.java.support.UserNotFoundException;
import java.time.LocalDateTime;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        UsersRepository repo = new UsersRepositoryFileImpl(
                Path.of("./users.txt"));

        repo.deleteAll();

        User u1 = new User(UUID.randomUUID().toString(), LocalDateTime.now(), "user_one",
                "Pass_123", "Pass_123", "Иванов", "Иван", "Иванович", 25, true);

        User u2 = new User(UUID.randomUUID().toString(), LocalDateTime.now(), "userTwo2",
                "Qwe_456", "Qwe_456", "Петров", "Петр", null, 30, false);

        User u3 = new User(UUID.randomUUID().toString(), LocalDateTime.now(), "masha_3",
                "Zxc_789", "Zxc_789", "Сидорова", "Мария", "Игоревна", null, true);

        repo.create(u1);
        repo.create(u2);
        repo.create(u3);

        List<User> all = repo.findAll();
        System.out.println("Всего пользователей: " + all.size());

        User found = repo.findById(u2.getId());
        System.out.println("Найден пользователь по id: " + found.getLogin());

        User updatedU1 = new User(u1.getId(), u1.getCreatedAt(), u1.getLogin(),
                u1.getPassword(), u1.getConfirmPassword(), u1.getLastName(),
                u1.getFirstName(), u1.getPatronymic(), 26, false);
        repo.update(updatedU1);

        User afterUpdate = repo.findById(u1.getId());
        System.out.println("Возраст после обновления: " + afterUpdate.getAge());

        System.out.println("Пользователи 30 лет: " + repo.findByAge(30).size());
        System.out.println("Пользователи-работники: " + repo.findByIsWorker(true).size());

        repo.deleteById(u3.getId());
        System.out.println("После удаления u3 количество: " + repo.findAll().size());

        try {
            repo.findById(u3.getId());
        } catch (UserNotFoundException e) {
            System.out.println(
                    "Ожидаемое исключение при поиске удаленного пользователя: "
                            + e.getMessage());
        }

        repo.deleteAll();
        System.out.println("После очистки количество: " + repo.findAll().size());
    }
}


