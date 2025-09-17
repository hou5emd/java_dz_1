# Attestation 01

## Вывот консоли тесты
```
mvn test -f "/home/andrey/git/java_
first/dz_1/dz-one/pom.xml"
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< homeworks:homeworks >-------------------------
[INFO] Building homeworks 1.0.0
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ homeworks ---
[INFO] skip non existing resourceDirectory /home/andrey/git/java_first/dz_1/dz-one/src/main/resources
[INFO] 
[INFO] --- compiler:3.11.0:compile (default-compile) @ homeworks ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ homeworks ---
[INFO] skip non existing resourceDirectory /home/andrey/git/java_first/dz_1/dz-one/src/test/resources
[INFO] 
[INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ homeworks ---
[INFO] Changes detected - recompiling the module! :source
[INFO] Compiling 1 source file with javac [debug release 17] to target/test-classes
[INFO] 
[INFO] --- surefire:3.2.5:test (default-test) @ homeworks ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running test.java.homeworks.attestation.attestation01.UsersRepositoryFileImplTest
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.086 s -- in test.java.homeworks.attestation.attestation01.UsersRepositoryFileImplTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.417 s
[INFO] Finished at: 2025-09-17T18:50:12+05:00
[INFO] ------------------------------------------------------------------------
```

### Вывод консоли main
```
 andrey@ZenbookINP  ~/git/java_first/dz_1/dz-one   homeworks/homework013 ±✚   cd /home/andrey/git/java_first/dz_
1/dz-one ; /usr/bin/env /usr/lib/jvm/java-21-openjdk-amd64/bin/java @/tmp/cp_e9fbr5xnl0qsepq6pweqcwd4m.argfile homew
orks.attestation.attestation01.App 
Всего пользователей: 3
Найден пользователь по id: userTwo2
Возраст после обновления: 26
Пользователи 30 лет: 1
Пользователи-работники: 1
После удаления u3 количество: 2
Ожидаемое исключение при поиске удаленного пользователя: Пользователя с заданным идентификатором не существует
После очистки количество: 0
```

## pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>homeworks</groupId>
    <artifactId>homeworks</artifactId>
    <version>1.0.0</version>
    <name>homeworks</name>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <junit.jupiter.version>5.8.1</junit.jupiter.version>
        <junit.platform.version>1.8.1</junit.platform.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>${junit.jupiter.version}</version>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>${junit.jupiter.version}</version>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-params</artifactId>
            <version>${junit.jupiter.version}</version>
        </dependency>
        <dependency>
            <groupId>org.junit.platform</groupId>
            <artifactId>junit-platform-suite</artifactId>
            <version>${junit.platform.version}</version>
        </dependency>
    </dependencies>

    <build>
        <sourceDirectory>src</sourceDirectory>
        <testSourceDirectory>src/test/java</testSourceDirectory>

        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.11.0</version>
                <configuration>
                    <release>17</release>
                    <source>${maven.compiler.source}</source>
                    <target>${maven.compiler.target}</target>
                    <encoding>${project.build.sourceEncoding}</encoding>
                </configuration>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.2.5</version>
                <configuration>
                    <useModulePath>false</useModulePath>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>
```

## App.java

```java
package homeworks.attestation.attestation01;

import homeworks.attestation.attestation01.model.User;
import homeworks.attestation.attestation01.repositories.UsersRepository;
import homeworks.attestation.attestation01.repositories.UsersRepositoryFileImpl;
import homeworks.attestation.attestation01.support.UserNotFoundException;
import java.time.LocalDateTime;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

public class App {
        public static void main(String[] args) {
                UsersRepository repo = new UsersRepositoryFileImpl(Path.of("src/homeworks/attestation/attestation01/users.txt"));

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
```

## model/User.java

```java
package homeworks.attestation.attestation01.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class User {
    private String id;
    private LocalDateTime createdAt;
    private String login;
    private String password;
    private String confirmPassword;
    private String lastName;
    private String firstName;
    private String patronymic;
    private Integer age;
    private boolean isWorker;

    public User(String id, LocalDateTime createdAt, String login, String password,
            String confirmPassword, String lastName, String firstName, String patronymic,
            Integer age, boolean isWorker) {
        validateId(id);
        this.id = id;
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
        validateLogin(login);
        this.login = login;
        validatePassword(password, confirmPassword);
        this.password = password;
        this.confirmPassword = confirmPassword;
        validateName(lastName, "Фамилия");
        this.lastName = lastName;
        validateName(firstName, "Имя");
        this.firstName = firstName;
        if (patronymic != null && !patronymic.isEmpty()) {
            validateName(patronymic, "Отчество");
        }
        this.patronymic = patronymic;
        if (age != null && age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = age;
        this.isWorker = isWorker;
    }

    public String getId() { return id; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public String getLogin() { return login; }
    public String getPassword() { return password; }
    public String getConfirmPassword() { return confirmPassword; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getPatronymic() { return patronymic; }
    public Integer getAge() { return age; }
    public boolean isWorker() { return isWorker; }

    public void setId(String id) { validateId(id); this.id = id; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setLogin(String login) { validateLogin(login); this.login = login; }
    public void setPassword(String password) { validatePassword(password, this.confirmPassword); this.password = password; }
    public void setConfirmPassword(String confirmPassword) { validatePassword(this.password, confirmPassword); this.confirmPassword = confirmPassword; }
    public void setLastName(String lastName) { validateName(lastName, "Фамилия"); this.lastName = lastName; }
    public void setFirstName(String firstName) { validateName(firstName, "Имя"); this.firstName = firstName; }
    public void setPatronymic(String patronymic) { if (patronymic != null && !patronymic.isEmpty()) validateName(patronymic, "Отчество"); this.patronymic = patronymic; }
    public void setAge(Integer age) { if (age != null && age < 0) throw new IllegalArgumentException("Возраст не может быть отрицательным"); this.age = age; }
    public void setWorker(boolean worker) { isWorker = worker; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return id + "|" + createdAt + "|" + login + "|" + password + "|" + confirmPassword + "|" + lastName + "|" + firstName + "|" + (patronymic == null ? "" : patronymic) + "|" + (age == null ? "" : age) + "|" + isWorker;
    }

    private void validateId(String id) {
        if (id == null || id.isEmpty()) throw new IllegalArgumentException("ID не может быть пустым");
        if (!id.matches("[A-Za-z0-9-]+")) throw new IllegalArgumentException("ID должен состоять из букв, цифр и дефисов");
    }

    private void validateLogin(String login) {
        if (login == null || login.isEmpty()) throw new IllegalArgumentException("Логин не может быть пустым");
        if (login.length() >= 20) throw new IllegalArgumentException("Логин должен быть меньше 20 символов");
        if (!login.matches("(?=.*[A-Za-z_])[A-Za-z0-9_]+")) throw new IllegalArgumentException("Логин должен содержать буквы/подчеркивание и может включать цифры");
    }

    private void validatePassword(String password, String confirmPassword) {
        if (password == null || password.isEmpty()) throw new IllegalArgumentException("Пароль не может быть пустым");
        if (password.length() >= 20) throw new IllegalArgumentException("Пароль должен быть меньше 20 символов");
        if (!password.matches("(?=.*[0-9])(?=.*[A-Za-z_])[A-Za-z0-9_]+")) throw new IllegalArgumentException("Пароль должен содержать буквы/подчеркивание и цифры");
        if (confirmPassword == null || !password.equals(confirmPassword)) throw new IllegalArgumentException("Пароль и подтверждение пароля должны совпадать");
    }

    private void validateName(String value, String fieldTitle) {
        if (value == null || value.isEmpty()) throw new IllegalArgumentException(fieldTitle + " не может быть пустым");
        if (!value.matches("[A-Za-zА-Яа-яЁё]+")) throw new IllegalArgumentException(fieldTitle + " должен состоять только из букв");
    }
}
```

## repositories/UsersRepository.java

```java
package homeworks.attestation.attestation01.repositories;

import homeworks.attestation.attestation01.model.User;
import java.util.List;

public interface UsersRepository {
    void create(User user);
    User findById(String id);
    List<User> findAll();
    void update(User user);
    void deleteById(String id);
    void deleteAll();
    List<User> findByAge(int age);
    List<User> findByIsWorker(boolean isWorker);
}
```

## repositories/UsersRepositoryFileImpl.java

```java
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

    public UsersRepositoryFileImpl() { this(Paths.get(FILE_NAME)); }

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
        if (parts.length < 10) throw new UserParseException("Некорректная строка пользователя: " + line);
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
        if (exists) { throw new DuplicateUserIdException("Пользователь с таким ID уже существует"); }
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
    public List<User> findAll() { return readAllUsers(); }

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
        if (!found) { users.add(user); }
        writeAllUsers(users);
    }

    @Override
    public void deleteById(String id) {
        List<User> users = readAllUsers();
        boolean removed = users.removeIf(u -> u.getId().equals(id));
        if (!removed) throw new UserNotFoundException(
                "Пользователя с заданным идентификатором не существует");
        writeAllUsers(users);
    }

    @Override
    public void deleteAll() { writeAllUsers(new ArrayList<>()); }

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
```


## support/DuplicateUserIdException.java
```java
package homeworks.attestation.attestation01.support;

public class DuplicateUserIdException extends RuntimeException {
    public DuplicateUserIdException(String message) { super(message); }
}
```

## support/UserNotFoundException.java
```java
package homeworks.attestation.attestation01.support;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) { super(message); }
}
```

## support/UserFileReadWriteException.java

```java
package homeworks.attestation.attestation01.support;

public class UserFileReadWriteException extends RuntimeException {
    public UserFileReadWriteException(String message, Throwable cause) { super(message, cause); }
}
```

## support/UserParseException.java

```java
package homeworks.attestation.attestation01.support;

public class UserParseException extends RuntimeException {
    public UserParseException(String message) { super(message); }
    public UserParseException(String message, Throwable cause) { super(message, cause); }
}
```

## Tests — UsersRepositoryFileImplTest.java

```java
package test.java.homeworks.attestation.attestation01;

import homeworks.attestation.attestation01.model.User;
import homeworks.attestation.attestation01.repositories.UsersRepository;
import homeworks.attestation.attestation01.repositories.UsersRepositoryFileImpl;
import homeworks.attestation.attestation01.support.DuplicateUserIdException;
import homeworks.attestation.attestation01.support.UserNotFoundException;
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
        usersFile = tempDir.resolve("src/homeworks/attestation/attestation01/users.txt");
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
```
