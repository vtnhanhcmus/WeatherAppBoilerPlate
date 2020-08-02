package com.oddle.app.models.repositories;

import com.oddle.app.models.entities.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T extends BaseModel> extends JpaRepository<T, Long> {
}
