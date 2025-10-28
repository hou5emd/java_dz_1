package ru.inno.java.model;

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

    public String getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Integer getAge() {
        return age;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setId(String id) {
        validateId(id);
        this.id = id;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setLogin(String login) {
        validateLogin(login);
        this.login = login;
    }

    public void setPassword(String password) {
        validatePassword(password, this.confirmPassword);
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        validatePassword(this.password, confirmPassword);
        this.confirmPassword = confirmPassword;
    }

    public void setLastName(String lastName) {
        validateName(lastName, "Фамилия");
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        validateName(firstName, "Имя");
        this.firstName = firstName;
    }

    public void setPatronymic(String patronymic) {
        if (patronymic != null && !patronymic.isEmpty())
            validateName(patronymic, "Отчество");
        this.patronymic = patronymic;
    }

    public void setAge(Integer age) {
        if (age != null && age < 0)
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        this.age = age;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + "|" + createdAt + "|" + login + "|" + password + "|" + confirmPassword + "|"
                + lastName + "|" + firstName + "|" + (patronymic == null ? "" : patronymic) + "|"
                + (age == null ? "" : age) + "|" + isWorker;
    }

    private void validateId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID не может быть пустым");
        }
        if (!id.matches("[A-Za-z0-9-]+")) {
            throw new IllegalArgumentException("ID должен состоять из букв, цифр и дефисов");
        }
    }

    private void validateLogin(String login) {
        if (login == null || login.isEmpty()) {
            throw new IllegalArgumentException("Логин не может быть пустым");
        }
        if (login.length() >= 20) {
            throw new IllegalArgumentException("Логин должен быть меньше 20 символов");
        }
        if (!login.matches("(?=.*[A-Za-z_])[A-Za-z0-9_]+")) {
            throw new IllegalArgumentException(
                    "Логин должен содержать буквы/подчеркивание и может включать цифры");
        }
    }

    private void validatePassword(String password, String confirmPassword) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Пароль не может быть пустым");
        }
        if (password.length() >= 20) {
            throw new IllegalArgumentException("Пароль должен быть меньше 20 символов");
        }
        if (!password.matches("(?=.*[0-9])(?=.*[A-Za-z_])[A-Za-z0-9_]+")) {
            throw new IllegalArgumentException(
                    "Пароль должен содержать буквы/подчеркивание и цифры");
        }
        if (confirmPassword == null || !password.equals(confirmPassword)) {
            throw new IllegalArgumentException("Пароль и подтверждение пароля должны совпадать");
        }
    }

    private void validateName(String value, String fieldTitle) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(fieldTitle + " не может быть пустым");
        }
        if (!value.matches("[A-Za-zА-Яа-яЁё]+")) {
            throw new IllegalArgumentException(fieldTitle + " должен состоять только из букв");
        }
    }
}

