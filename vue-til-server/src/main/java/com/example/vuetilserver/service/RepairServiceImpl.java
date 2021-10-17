package com.example.vuetilserver.service;

import com.example.vuetilserver.dto.RepairDto;
import com.example.vuetilserver.repository.RepairRepositoryManager;
import com.example.vuetilserver.repository.RepairRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RepairServiceImpl implements RepairService{

    private final RepairRepositorySupport repairRepositorySupport;
    private final RepairRepositoryManager repairRepositoryManager;

    @Override
    public List<RepairDto.repairList> list(RepairDto.repairListParam repairListParam) {
        return repairRepositorySupport.list(repairListParam);
    }

    @Override
    public RepairDto.insert insert(RepairDto.insertParam insertParam) {

        RepairDto.insert Container = repairRepositoryManager.insert(insertParam);

        return Container;
    }
}
