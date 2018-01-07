package com.example.typing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.typing.dto.DepartmentList;
import com.example.typing.dto.DepartmentList.Department;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentList departmentList;

    @GetMapping(path = "/department")
    public List<Department> getDepartment() {
        return this.departmentList.getDepartmentList();
    }

}
