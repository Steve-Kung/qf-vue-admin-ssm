package cn.stevekung.service;

import cn.stevekung.mapper.UserMapper;
import cn.stevekung.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers() {
        return userMapper.getUsers();
    }
}
