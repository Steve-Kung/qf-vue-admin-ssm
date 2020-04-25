package cn.stevekung.service;

import cn.stevekung.dto.ResultDTO;
import cn.stevekung.mapper.UserMapper;
import cn.stevekung.pojo.User;
import cn.stevekung.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User getUserByuserTel(String userTel) {
        return userMapper.getUserByuserTel(userTel);
    }

    @Override
    public ResultDTO<User> login(String userTel, String userPwd) {
        ResultDTO resultDTO = null;

        //因为需要传递两个参数到映射文件，因此把参数存入到map
        Map<String, String> map = new HashMap<>();
        map.put("userTel", userTel);
        map.put("userPwd", userPwd);
        User user = userMapper.getUserByUserTelAndUserPwd(map);


//        User user = userMapper.getUserByuserTel(userTel);
        if (user != null) {
//            if (userPwd.equals(user.getUserPwd())){

//            resultDTO.setResult(true);
//            resultDTO.setMessage("登入成功");
            resultDTO = ResultUtil.successResult(user, "登入成功");
        } else{
//            resultDTO.setResult(false);
//            resultDTO.setMessage("用户电话或者密码错误");

            resultDTO = ResultUtil.errorResult(user,"用户电话或者密码错误");
        }
        return resultDTO;
    }
}
