package com.bachelor.smartaquarium.service.api.Request;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class UpdateUserRequest {

    @NotNull
    private String password;

    @NotNull
    private String email;

    public UpdateUserRequest(@NotNull String password, @NotNull String email) {
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateUserRequest that = (UpdateUserRequest) o;
        return password.equals(that.password) &&
                email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, email);
    }
}
