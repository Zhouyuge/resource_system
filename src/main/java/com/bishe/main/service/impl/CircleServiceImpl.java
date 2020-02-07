package com.bishe.main.service.impl;

import com.bishe.main.dao.CircleMapper;
import com.bishe.main.dao.UserMapper;
import com.bishe.main.entity.Circle;
import com.bishe.main.entity.CircleExample;
import com.bishe.main.entity.User;
import com.bishe.main.entity.UserExample;
import com.bishe.main.enums.CircleTypeEnum;
import com.bishe.main.service.CircleService;
import com.bishe.main.util.AutoMapperUtil;
import com.bishe.main.vo.CircleVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/2/4 19:55
 */
@Service
public class CircleServiceImpl implements CircleService {
    @Autowired
    private CircleMapper circleMapper;

    @Autowired
    private UserMapper userMapper;

    private final Integer pageSize = 10;

    /**
     * 分页查询圈子信息
     * @param pageNum
     * @return
     */
    @Override
    public Page<Circle> getCircleVOs(Integer pageNum) {
        Page<Circle> circleVOS = PageHelper.startPage(pageNum, pageSize);
        List<Circle> circles = circleMapper.selectByExample(new CircleExample());
        return circleVOS;
    }

    /**
     * 分页分类查找类型Id
     * @param typeId
     * @param pageNum
     * @return
     */
    @Override
    public Page<Circle> getCircleVOSByTypeId(Integer typeId, Integer pageNum) {
        Page<Circle> circleVOS = PageHelper.startPage(pageNum, pageSize);
        CircleExample circleExample = new CircleExample();
        circleExample.or().andCircleTypeEqualTo(typeId);
        List<Circle> circles = circleMapper.selectByExample(circleExample);
        return circleVOS;
    }

    /**
     * 根据Id获取圈子详情
     * @param id
     * @return
     */
    @Override
    public CircleVO getCircleVOById(Integer id) {
        Circle circle = circleMapper.selectByPrimaryKey(id);
        User user = userMapper.selectByPrimaryKey(circle.getCircleUserId());
        CircleVO circleVO = new CircleVO();

        AutoMapperUtil.mapping(circle, circleVO);

        circleVO.setTypeValue(getTypeName(circleVO.getCircleType()));
        circleVO.setUserName(user.getUserName());
        circleVO.setUserHeadPic(user.getUserHeadPic());
        return circleVO;
    }

    private  String getTypeName(Integer id) {
        switch (id) {
            case 1:
                return CircleTypeEnum.STYDU.getValue();
            case 2:
                return CircleTypeEnum.WORK.getValue();
            case 3:
                return CircleTypeEnum.FACTORY.getValue();
            case 4:
                return CircleTypeEnum.NGEE.getValue();
            case 5:
                return CircleTypeEnum.COMPETE.getValue();
            case 6:
                return CircleTypeEnum.LIFE.getValue();
            case 7:
                return CircleTypeEnum.STUDY_ABORD.getValue();
        }
        return null;
    }
}
