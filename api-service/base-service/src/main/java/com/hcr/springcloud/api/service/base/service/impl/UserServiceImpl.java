package com.hcr.springcloud.api.service.base.service.impl;

import com.hcr.springcloud.api.service.base.service.UserService;
import com.hcr.springcloud.common.dto.UserDTO;
import com.hcr.springcloud.common.util.Result;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final List<UserDTO> users = new ArrayList<UserDTO>();

    public UserServiceImpl() {
        UserDTO user1 = new UserDTO();
        user1.setUserId(1);
        user1.setUserName("admin");
        user1.setAge(12);
        user1.setBirthday(new Date());
        user1.setAddress("上海市长宁区");
        user1.setDeptId(1);
        user1.setEmail("524857526@qq.com");
        user1.setRealName("管理员");
        user1.setRemark("无");
        user1.setSex(1);
        users.add(user1);

        UserDTO user2 = new UserDTO();
        user2.setUserId(2);
        user2.setUserName("test");
        user2.setAge(23);
        user2.setBirthday(new Date());
        user2.setAddress("上海市普陀区");
        user2.setDeptId(3);
        user2.setEmail("8387451112@qq.com");
        user2.setRealName("测试");
        user2.setRemark("测试人员");
        user2.setSex(1);
        users.add(user1);
    }

    @Override
    public Result<UserDTO> getUserInfo(String userName, String password) {
        for (UserDTO user : users) {
            if (user.getUserName().equals(userName)) {
                return Result.success(user);
            }
        }

        return Result.error("未找到对应的用户信息");
    }

    @Override
    public Result<UserDTO> getUserInfoById(int userId) {
        for (UserDTO user : users) {
            if (user.getUserId() == userId) {
                return Result.success(user);
            }
        }

        return Result.error("未找到对应的用户信息");
    }

    @Override
    public Result<UserDTO> getUserInfoByUserName(String userName) {
        for (UserDTO user : users) {
            if (user.getUserName().equals(userName)) {
                return Result.success(user);
            }
        }

        return Result.error("未找到对应的用户信息");
    }

    @Override
    public Result<List<UserDTO>> getUsers(int deptId, String userName, String email) {
        return Result.success(users);
    }
}
