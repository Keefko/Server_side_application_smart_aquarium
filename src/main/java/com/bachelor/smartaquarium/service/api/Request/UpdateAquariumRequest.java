package com.bachelor.smartaquarium.service.api.Request;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class UpdateAquariumRequest {

    @NotNull
    private String name;

    @NotNull
    private int type;

    @NotNull
    private int status;

    public UpdateAquariumRequest(@NotNull String name, @NotNull int type, @NotNull int status) {
        this.name = name;
        this.type = type;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateAquariumRequest that = (UpdateAquariumRequest) o;
        return type == that.type &&
                status == that.status &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, status);
    }
}
