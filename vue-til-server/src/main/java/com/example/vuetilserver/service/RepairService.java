package com.example.vuetilserver.service;

import com.example.vuetilserver.dto.RepairDto;

import java.util.List;

public interface RepairService {

    List<RepairDto.repairList> list(RepairDto.repairListParam repairListParam);
}
