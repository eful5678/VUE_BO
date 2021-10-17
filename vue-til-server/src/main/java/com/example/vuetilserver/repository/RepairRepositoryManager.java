package com.example.vuetilserver.repository;

import com.example.vuetilserver.dto.RepairDto;

public interface RepairRepositoryManager {

    RepairDto.insert insert(RepairDto.insertParam insertParam);
}
