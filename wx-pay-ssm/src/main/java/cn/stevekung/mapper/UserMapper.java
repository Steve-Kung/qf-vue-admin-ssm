package cn.stevekung.mapper;

import cn.stevekung.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    public List<String> getUserTels();
    public User getUserByuserTel(String userTel);

    public User getUserByUserTelAndUserPwd(Map<String, String> map);
}
