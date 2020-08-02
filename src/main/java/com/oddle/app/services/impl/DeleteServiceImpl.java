package com.oddle.app.services.impl;

import com.oddle.app.models.entities.BaseModel;
import com.oddle.app.models.exceptions.DataExistException;
import com.oddle.app.models.repositories.BaseRepository;
import com.oddle.app.services.DeleteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DeleteServiceImpl<T extends BaseModel> implements DeleteService<T> {

    private final BaseRepository<T> baseRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(T data) {
        T exist = baseRepository.getOne(data.getId());
        if (exist != null){
            baseRepository.delete(exist);
        }
        throw new DataExistException("record not exist");
    }

}
