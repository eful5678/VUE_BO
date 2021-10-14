package com.example.vuetilserver.repository;

import com.example.vuetilserver.dto.RepairDto;

import java.util.List;

public interface RepairRepositorySupport {

    List<RepairDto.repairList> list(RepairDto.repairListParam repairListParam);
}
