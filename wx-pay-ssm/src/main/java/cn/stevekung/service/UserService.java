package cn.stevekung.service;

import cn.stevekung.dto.ResultDTO;
import cn.stevekung.pojo.User;

public interface UserService {
    public User getUserByuserTel(String userTel);
    public ResultDTO<User> login(String userTel, String userPwd);
}
