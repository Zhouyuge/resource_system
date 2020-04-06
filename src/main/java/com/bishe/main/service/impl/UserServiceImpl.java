package com.bishe.main.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.PageUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.bishe.main.dao.DailyPointMapper;
import com.bishe.main.dao.UserMapper;
import com.bishe.main.entity.DailyPoint;
import com.bishe.main.entity.User;
import com.bishe.main.entity.UserExample;
import com.bishe.main.ro.LoginRo;
import com.bishe.main.service.RedisService;
import com.bishe.main.service.UserService;
import com.bishe.main.util.*;
import com.bishe.main.vo.DailyPointVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Kirito
 * @Date 2019/11/15 16:23
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisService redisService;

    private static final String REDIS_USER_SESSION_KEY = "REDIS_USER_SESSION";

    private static final String SSO_SESSION_EXPIRE = "30";

    @Autowired
    private UserMapper userMapper;

    @Override
    public void logout(String token){
        redisService.remove(REDIS_USER_SESSION_KEY + ":" + token);
    }

    @Override
    public String queryUserByToken(String token) {
        // 根据token从redis中查询用户信息
        JSONObject json = (JSONObject)redisService.get(REDIS_USER_SESSION_KEY + ":" + token);
        // 判断是否为空
        if (json == null) {
            return null;
        }

        String jsonStr = JSONUtil.toJsonStr(json);
        // 更新过期时间
        redisService.remove(REDIS_USER_SESSION_KEY + ":" + token);
        redisService.set(REDIS_USER_SESSION_KEY + ":" + token, JSONUtil.parse(json), Long.parseLong(SSO_SESSION_EXPIRE));

        return jsonStr;
    }

    private static Integer pageSize = 10;

    @Autowired
    private DailyPointMapper dailyPointMapper;

    @Override
    public Page<DailyPointVO> getAllDailyPointVO(Integer pageNum) {
        Page<DailyPointVO> dailyPointVOPage = PageHelper.startPage(pageNum, pageSize);
        List<DailyPointVO> dailyPointVOS = dailyPointMapper.selectAll();
        dailyPointVOS = dailyPointVOS.stream().map(e -> {
           e.setPrettyTime(PrettyTimeUtil.getPrettyTime(e.getCreateTime()).replaceAll(" ", ""));
           return e;
        }).collect(Collectors.toList());
        return dailyPointVOPage;
    }

    @Override
    public List<DailyPointVO> getDailyPointVOByUserId(String userId) {
        List<DailyPointVO> dailyPointVOS = dailyPointMapper.selectByUserId(userId);
        dailyPointVOS = dailyPointVOS.stream().map(e -> {
            e.setPrettyTime(PrettyTimeUtil.getPrettyTime(e.getCreateTime()).replaceAll(" ", ""));
            return e;
        }).collect(Collectors.toList());
        return dailyPointVOS;    }

    @Override
    public int deleteDailyPointById(Integer id) {
        return dailyPointMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int addDailyPoint(DailyPointVO dailyPointVO, String userId) {
        DailyPoint dailyPoint = new DailyPoint();
        AutoMapperUtil.mapping(dailyPointVO, dailyPoint);
        dailyPoint.setUserId(userId);
        dailyPoint.setShareNum(0);
        dailyPoint.setAgreeNum(0);
        dailyPoint.setCreateTime(new Date());
        dailyPoint.setCommentNum(0);
        return dailyPointMapper.insertSelective(dailyPoint);
    }

    @Override
    public int pageCount() {
        return dailyPointMapper.selectAll().size() / pageSize + 1;
    }

    @Override
    public User getUserByPrimaryKey(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateUserInfo(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userMapper.selectByExample(new UserExample());
       // 将用户密码制空
        users = users.stream().map(e -> {
            e.setUserPassword("");
            return e;
        }).collect(Collectors.toList());
        return users;
    }

    @Override
    public LoginRo registerUser(String email, String password) {
        UserExample userExample = new UserExample();
        userExample.or().andUserEmalEqualTo(email);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() > 0) {
            return LoginRo.EXSIT;       //注册失败：该用户已经存在
        }
        User user = new User();
        user.setUserName(email);
        user.setUserEmal(email);
        user.setUserPassword(AESUtil.encrypt(password));
        user.setUserId(UUID.randomUUID().toString());
        user.setUserHeadPic("http://localhost:10086/img/h_img/default.jpg");
        user.setUserCreateTime(DateTime.now().toSqlDate());

        int result = userMapper.insertSelective(user);
        if (result < 0) {
            return LoginRo.ERROR;
        }
        LoginRo.SUCCESS_MSG.setMsg("注册成功！");
        return LoginRo.SUCCESS_MSG;
    }

    @Override
    public LoginRo updateUser(User user, String token) {
        if(user == null) {
            return LoginRo.ERROR;
        }

        LoginRo loginRo = LoginRo.SUCCESS_MSG;
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i > 0) {
            //更新成功情况下，更新缓存
            String userId = user.getUserId();
            //获取更新后的全部用户信息
            user = userMapper.selectByPrimaryKey(userId);
            redisService.set(REDIS_USER_SESSION_KEY + ":" + token, JsonUtils.objToJson(user), Long.parseLong(SSO_SESSION_EXPIRE));
            LoginRo.SUCCESS_MSG.setMsg(token);
        }
        return loginRo;
    }

    @Override
    public User getUser(User user) {
        String password = user.getUserPassword();
        User currentUser = userMapper.selectByEmail(user.getUserEmal());
        if(currentUser == null) {
            return null;
        }
        boolean flag = LoginUtil.Validatelogon(currentUser, password);
        if (flag) {
            currentUser.setUserPassword("");
            return currentUser;
        }
        return null;
    }

    @Override
    public User getUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

}
