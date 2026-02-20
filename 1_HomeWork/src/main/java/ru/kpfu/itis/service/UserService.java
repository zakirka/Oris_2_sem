package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.itis.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(String name) {
        return userRepository.save(new User(null, name));
    }

    public User get(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
