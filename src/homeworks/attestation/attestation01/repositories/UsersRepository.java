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

