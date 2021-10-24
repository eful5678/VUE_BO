package com.example.vuetilserver.repository;

import com.example.vuetilserver.domain.Repair;
import com.example.vuetilserver.dto.RepairDto;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class RepairRepositoryManagerImpl implements RepairRepositoryManager {
    @NonNull
    private final EntityManager entityManager;

    @Override
    public RepairDto.insert insert(RepairDto.insertParam insertParam) {

        final Repair repair = Repair.create(insertParam).get();
        entityManager.persist(repair);



        return new RepairDto.insert(repair);
    }
}
