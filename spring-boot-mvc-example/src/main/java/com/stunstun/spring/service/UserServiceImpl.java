package com.stunstun.spring.service;

import com.stunstun.spring.ResourceNotFoundException;
import com.stunstun.spring.domain.User;
import com.stunstun.spring.domain.UserRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

/**
 * @author minhyeok
 */
@Component("userService")
public class UserServiceImpl implements  UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(ObjectProvider<UserRepository> repositoryProvider) {
        this.userRepository = repositoryProvider.getIfUnique();
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        if (!userRepository.exists(user.getId()))
            throw new ResourceNotFoundException();
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.exists(id))
            throw new ResourceNotFoundException();
        userRepository.delete(id);
    }
}
