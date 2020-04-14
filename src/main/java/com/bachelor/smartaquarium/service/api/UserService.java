package com.bachelor.smartaquarium.service.api;

import com.bachelor.smartaquarium.entity.User;
import com.bachelor.smartaquarium.service.api.Request.UpdateUserRequest;
import org.springframework.lang.Nullable;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    @Nullable
    User get(long id);

    @Nullable
    User add(User user);

    void delete(long id);

    User update(long id, UpdateUserRequest request);
}
