package com.hcr.springcloud.common.dto;

import java.util.Date;

public class UserDTO {
    private int userId;
    private String userName;
    private String realName;
    private int sex;
    private int age;
    private Date birthday;
    private int deptId;
    private String email;
    private String address;
    private String remark;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", birthday=" + birthday +
                ", deptId=" + deptId +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
