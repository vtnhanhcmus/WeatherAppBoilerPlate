package com.oddle.app.services;

import com.oddle.app.models.entities.BaseModel;

public interface DeleteService<T extends BaseModel> {
    void delete(T data);
}
