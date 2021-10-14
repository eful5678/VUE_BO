package com.example.vuetilserver.service;

import com.example.vuetilserver.dto.RepairDto;
import com.example.vuetilserver.repository.RepairRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepairServiceImpl implements RepairService{

    private final RepairRepositorySupport repairRepositorySupport;

    @Override
    public List<RepairDto.repairList> list(RepairDto.repairListParam repairListParam) {
        return repairRepositorySupport.list(repairListParam);
    }
}
