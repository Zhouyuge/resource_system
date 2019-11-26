package com.bishe.main.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateTime;
import com.bishe.main.dao.SelectTitleMapper;
import com.bishe.main.dao.TakeTitleMapper;
import com.bishe.main.dto.TitleDto;
import com.bishe.main.entity.*;
import com.bishe.main.service.TitleService;
import com.bishe.main.util.AutoMapperUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kirito
 * @Date 2019/11/20 15:22
 */
@Service
public class TitileServiceImpl implements TitleService {
    @Autowired
    private  SelectTitleMapper selectTitleMapper;

    @Autowired
    private  TakeTitleMapper takeTitleMapper;

    private static Integer rightCount = 0;

    private static Integer wrongCount = 0;
    /**
     *
     * @param uId 用户Id
     * @return
     */

    public List<TitleDto> getTitleDtos(String uId) {
        TakeTitleExample takeTitleExample = new TakeTitleExample();
        takeTitleExample.or().andUserIdEqualTo(uId);
        List<TakeTitleWithBLOBs> takeTitles = takeTitleMapper.selectByExampleWithBLOBs(takeTitleExample);
        if (takeTitles.size() == 1) {
            SelectTitleExample.Criteria criteria = null;
            SelectTitleExample selectTitleExample = new SelectTitleExample();
            if (Strings.isNotEmpty(takeTitles.get(0).getRightTitleId())) {
                String[] rightId = takeTitles.get(0).getRightTitleId().split(",");
                List<Integer> rightIds = Arrays.asList(Convert.toIntArray(rightId));
                criteria = selectTitleExample.or().andTitleIdNotIn(rightIds);  //选出除正确题错误提之外的题 TODO...
                rightCount = rightId.length;
            }

            if (Strings.isNotEmpty(takeTitles.get(0).getWrongTitleId())) {
                String[] wrongId = takeTitles.get(0).getWrongTitleId().split(",");
                List<Integer> wrongIds = Arrays.asList(Convert.toIntArray(wrongId));
                selectTitleExample.or(criteria.andTitleIdNotIn(wrongIds));  //选出除错误题之外的题
                wrongCount = wrongId.length;
            }
                List<TitleDto> titleDtos = new ArrayList<>();
                AutoMapperUtil.mappingList(selectTitleMapper.selectByExample(selectTitleExample), titleDtos, TitleDto.class);
                return titleDtos.subList(0, 20);

        }
        return null;
    }

    @Override
    public int updateTitle(List<TitleDto> titleDtos, String userId) {
        TakeTitleExample takeTitleExample = new TakeTitleExample();
        takeTitleExample.or().andUserIdEqualTo(userId);
        List<TakeTitleWithBLOBs> takeTitles = takeTitleMapper.selectByExampleWithBLOBs(takeTitleExample);

        TakeTitleWithBLOBs takeTitle = takeTitles.get(0);

        int rNum = 0;   //做对题数

        for (TitleDto titleDto : titleDtos) {
            SelectTitle selectTitle = selectTitleMapper.selectByPrimaryKey(titleDto.getTitleId());  //获取题目
            if (titleDto.getAns().equals(selectTitle.getTitleAnswer())) {   //当检测的答案相同
                if (StringUtils.isEmpty(takeTitle.getRightTitleId())) {     //客户还未答题情况下
                    takeTitle.setRightTitleId(titleDto.getTitleId().toString());
                } else {                                                    //客户已经答题过情况下
                    takeTitle.setRightTitleId(takeTitle.getRightTitleId() + "," + titleDto.getTitleId().toString());
                }
                rNum ++;
                selectTitle.setTitleRight(selectTitle.getTitleRight() + 1); //做对人数+1
            } else {
                if (StringUtils.isEmpty(takeTitle.getWrongTitleId())) {     //客户还未答题情况下
                    takeTitle.setWrongTitleId(titleDto.getTitleId().toString());
                } else {                                                    //客户已经答题过情况下
                    takeTitle.setWrongTitleId(takeTitle.getWrongTitleId() + "," + titleDto.getTitleId().toString());
                }
            }
            selectTitle.setTitleCount(selectTitle.getTitleCount() + 1);     //做过次数+1
            selectTitleMapper.updateByPrimaryKey(selectTitle);
        }
        takeTitleMapper.updateByPrimaryKeySelective(takeTitle);
        return rNum;
    }

    public void insertTake(String userId) {
        TakeTitle takeTitle = new TakeTitle();
        takeTitle.setUserId(userId);
        takeTitle.setTakeEditTime(DateTime.now().toSqlDate());
        takeTitleMapper.insert((TakeTitleWithBLOBs) takeTitle);
    }

    /**
     * 获取已做过题总量
     * @return
     */
    @Override
    public Integer getDoTitleCount(String userId) {
        TakeTitleExample takeTitleExample = new TakeTitleExample();
        takeTitleExample.or().andUserIdEqualTo(userId);
        List<TakeTitleWithBLOBs> takeTitles = takeTitleMapper.selectByExampleWithBLOBs(takeTitleExample);
        if (takeTitles == null || takeTitles.size() == 0) {
            insertTake(userId);
            return 0;
        }
        return takeTitles.get(0).getRightTitleId().split(",").length
                + takeTitles.get(0).getWrongTitleId().split(",").length;
    }
}
