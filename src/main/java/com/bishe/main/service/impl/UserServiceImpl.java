package com.bishe.main.service.impl;

import cn.hutool.core.util.PageUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.bishe.main.dao.DailyPointMapper;
import com.bishe.main.entity.DailyPoint;
import com.bishe.main.service.RedisService;
import com.bishe.main.service.UserService;
import com.bishe.main.util.AutoMapperUtil;
import com.bishe.main.util.PrettyTimeUtil;
import com.bishe.main.vo.DailyPointVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
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
}
