package com.oddle.app.services;
import com.oddle.app.models.entities.BaseModel;

public interface BaseService<T extends BaseModel> extends CreateService<T>, DeleteService<T> {
}
