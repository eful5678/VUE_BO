package com.example.vuetilserver.api;

import com.example.vuetilserver.dto.EmployeeDto;
import com.example.vuetilserver.service.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class EmployeeController {

    private final EmpService empService;

    @GetMapping("/empList")
    public List<EmployeeDto.empList> empList(@ModelAttribute EmployeeDto.empListParam empListParam){

        return empService.empList(empListParam);
    }
}
