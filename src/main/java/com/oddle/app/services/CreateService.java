package com.oddle.app.services;

import com.oddle.app.models.entities.BaseModel;

public interface CreateService<T extends BaseModel> {
    T insert(T data);
}
