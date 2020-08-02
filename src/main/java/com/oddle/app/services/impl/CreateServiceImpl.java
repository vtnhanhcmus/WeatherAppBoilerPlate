package com.oddle.app.services.impl;

import com.oddle.app.models.entities.BaseModel;
import com.oddle.app.models.exceptions.DataExistException;
import com.oddle.app.models.repositories.BaseRepository;
import com.oddle.app.services.CreateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CreateServiceImpl<T extends BaseModel> implements CreateService<T> {

    private final BaseRepository<T> baseRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public T insert(T data) {

        T exist = baseRepository.getOne(data.getId());
        if (exist != null){
            throw new DataExistException("record is exist");
        }

        return baseRepository.save(data);
    }
}
