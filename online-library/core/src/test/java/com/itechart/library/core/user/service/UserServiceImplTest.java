package com.itechart.library.core.user.service;

import com.google.common.collect.Iterables;
import com.itechart.library.core.CommonTransactionalSpringTest;
import com.itechart.library.core.user.User;
import com.itechart.library.core.user.UserFilter;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


public class UserServiceImplTest extends CommonTransactionalSpringTest {
    private static final long TEST_USER_ID = 1;
    private static final String TEST_USER_LOGIN = "admin";
    private static final String TEST_ROLE = "ROLE_ADMIN";

    @Autowired
    UserService userService;

    @Test
    public void testFindByLogin() throws Exception {
        User user = userService.findByLogin(TEST_USER_LOGIN);
        Assert.assertNotNull(user);
    }

    @Test
    public void testFind() throws Exception {
        PageRequest pageRequest = buildPage(0);

        UserFilter userFilter = new UserFilter();
        userFilter.setLogin("ad*n");

        Page<User> page = userService.find(userFilter, pageRequest);
        Assert.assertNotEquals(0, page.getTotalElements());
        Assert.assertFalse(page.getContent().isEmpty());
    }

    @Test
    public void testBlockAndActivateUser() throws Exception {
        userService.blockUser(TEST_USER_ID);

        User user = userService.findByLogin(TEST_USER_LOGIN);
        Assert.assertEquals(User.Status.BLOCKED, user.getStatus());

        userService.activateUser(TEST_USER_ID);
        user = userService.findByLogin(TEST_USER_LOGIN);
        Assert.assertEquals(User.Status.ACTIVE, user.getStatus());
    }

    @Test
    public void testFindAll() throws Exception {
        PageRequest pageRequest = buildPage(0);

        Page<User> page = userService.findAll(pageRequest);
        Assert.assertNotNull(page);
        Assert.assertNotEquals(0, page.getTotalElements());
        Assert.assertNotEquals(0, page.getTotalPages());
        Assert.assertFalse(page.getContent().isEmpty());

        pageRequest = buildPage(page.getTotalPages() + 1);

        page = userService.findAll(pageRequest);
        Assert.assertNotNull(page);
        Assert.assertNotEquals(0, page.getTotalElements());
        Assert.assertNotEquals(0, page.getTotalPages());
        Assert.assertTrue(page.getContent().isEmpty());
    }

    @Test
    public void testFindByRole() {
        Iterable<User> admins = userService.findByRole(TEST_ROLE);
        Assert.assertFalse(Iterables.isEmpty(admins));
    }

    @Test
    public void testCreate() {
        CreateUserInfo userInfo = new CreateUserInfo("login", "pass", "last", "first");
        User user = userService.create(userInfo);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
        Assert.assertTrue(user.getId() > 0);

        Assert.assertEquals(userInfo.getLogin(), user.getLogin());
        assertUserInfo(userInfo, user);

        User foundUser = userService.find(user.getId());
        Assert.assertNotNull(foundUser);
    }

    private void assertUserInfo(UserInfo userInfo, User user) {
        Assert.assertEquals(userInfo.getPassword(), user.getPassword());
        Assert.assertEquals(userInfo.getLastName(), user.getLastName());
        Assert.assertEquals(userInfo.getFirstName(), user.getFirstName());
    }

    @Test
    public void testUpdate() {
        UserInfo userInfo = new UserInfo("pass", "last", "first");
        User user = userService.update(TEST_USER_ID, userInfo);
        Assert.assertNotNull(user);
        Assert.assertEquals(TEST_USER_ID, user.getId().longValue());

        assertUserInfo(userInfo, user);
    }
}