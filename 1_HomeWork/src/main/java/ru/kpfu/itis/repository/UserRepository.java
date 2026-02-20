package ru.kpfu.itis.repository;

import ru.kpfu.itis.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private Map<Long, User> db = new HashMap<>();
    private long count = 1;
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(count++);
        }
        db.put(user.getId(), user);
        return user;
    }
    public User findById(Long id) {
        return db.get(id);
    }

    public List<User> findAll() {
        return new ArrayList<>(db.values());
    }

    public void deleteById(Long id) {
        db.remove(id);
    }

}

