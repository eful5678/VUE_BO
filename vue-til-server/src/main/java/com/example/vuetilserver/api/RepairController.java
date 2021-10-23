package com.example.vuetilserver.api;

import com.example.vuetilserver.dto.RepairDto;
import com.example.vuetilserver.service.RepairService;
import com.example.vuetilserver.util.GlobalUtil;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repair")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class RepairController {

    private final RepairService repairService;

    @GetMapping("/list")
    public List<RepairDto.repairList> list(@ModelAttribute RepairDto.repairListParam repairListParam){

        return repairService.list(repairListParam);
    }

    @PostMapping("/insert")
    public RepairDto.insert insert(@RequestBody RepairDto.insertParam insertParam){
        GlobalUtil.checkValidation(insertParam);
        return repairService.insert(insertParam);
    }
}
