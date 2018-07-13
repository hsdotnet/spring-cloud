package com.hcr.springcloud.api.service.base.service;

import com.hcr.springcloud.common.dto.DeptDTO;
import com.hcr.springcloud.common.util.Result;

import java.util.List;

public interface DeptService {
    Result<DeptDTO> getDeptById(int deptId);

    Result<List<DeptDTO>> getDepts();
}
