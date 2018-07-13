package com.hcr.springcloud.api.service.base.controller;

import com.hcr.springcloud.api.service.base.service.DeptService;
import com.hcr.springcloud.common.dto.DeptDTO;
import com.hcr.springcloud.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/getDeptById")
    public Result<DeptDTO> getDeptById(int deptId) {
        return deptService.getDeptById(deptId);
    }

    @GetMapping("/getDepts")
    public Result<List<DeptDTO>> getDepts() {
        return deptService.getDepts();
    }
}
