package com.itechart.library.core.user.service;

import com.itechart.library.core.entity.service.AbstractEntityService;
import com.itechart.library.core.user.User;
import com.itechart.library.core.user.UserFilter;
import com.itechart.library.core.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends AbstractEntityService<User> implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public User findByLogin(String login) {
        return getRepository().findFirstByLogin(login);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> find(UserFilter filter, Pageable pageable) {
        return getRepository().findAll(UserRepository.Predicates.byFilter(filter), pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<User> findByRole(String role) {
        return getRepository().findByRole(role);
    }

    @Override
    @Transactional
    public void blockUser(long userId) {
        changeStatus(userId, User.Status.ACTIVE, User.Status.BLOCKED);
    }

    @Override
    @Transactional
    public void activateUser(long userId) {
        changeStatus(userId, User.Status.BLOCKED, User.Status.ACTIVE);
    }

    private void changeStatus(long userId, User.Status currentStatus, User.Status targetStatus) {
        User user = getRepository().findOne(userId);
        if (user.getStatus() == currentStatus) {
            user.setStatus(targetStatus);
            getRepository().save(user);
        }
    }

    @Override
    protected UserRepository getRepository() {
        return userRepository;
    }
}
