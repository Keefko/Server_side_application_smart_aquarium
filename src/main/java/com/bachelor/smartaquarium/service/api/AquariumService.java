package com.bachelor.smartaquarium.service.api;

import com.bachelor.smartaquarium.entity.Aquarium;
import com.bachelor.smartaquarium.service.api.Request.UpdateAquariumRequest;
import org.springframework.lang.Nullable;

import java.util.List;

public interface AquariumService {

    List<Aquarium> getAquariums();

    @Nullable
    Aquarium get(long id);

    @Nullable
    Aquarium add(Aquarium aquarium);

    void delete(long id);

    Aquarium update(long id, UpdateAquariumRequest request);
}
