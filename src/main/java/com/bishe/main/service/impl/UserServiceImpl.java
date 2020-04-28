package com.bishe.main.service.impl;

import com.bishe.main.entity.User;
import com.bishe.main.entity.result.CodeMsg;
import com.bishe.main.exception.RunException;
import com.bishe.main.mapper.UserMapper;
import com.bishe.main.service.UserService;
import com.bishe.main.util.AESUtil;
import com.bishe.main.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kirito
 * @Date 2020/4/24 9:45
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(UserVO user) {
        String userAccount = user.getUserAccount();
        String password = user.getUserPassword();
        return verifyAccount(userAccount, password);
    }

    public User verifyAccount(String account, String password){
        // 数据库中查询的User
        User targetUser = userMapper.selectByAccount(account);
        CodeMsg codeMsg = new CodeMsg(500, "");
        if(targetUser != null) {
            // 将密码解密
            String targetPassword = AESUtil.decrypt(targetUser.getUserPassword());
            // 匹配返回用户信息， 不匹配则抛出异常信息
            if (password.equals(targetPassword)) {
                return targetUser;
            }
            codeMsg.setMsg("密码错误");
            throw new RunException(codeMsg);
        }
        codeMsg.setMsg("用户不存在");
        throw new RunException(codeMsg);
    }
}
