package com.bishe.main.service.impl;

import com.bishe.main.dao.ResumeMapper;
import com.bishe.main.entity.Resume;
import com.bishe.main.service.WorkService;
import com.bishe.main.util.AutoMapperUtil;
import com.bishe.main.util.PDFUtil;
import com.bishe.main.vo.SelfDetailVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Kirito
 * @Date 2020/1/7 17:11
 */
@Service
public class WorkServiceImpl implements WorkService {
    private static Logger log = LoggerFactory.getLogger(WorkServiceImpl.class);

    @Autowired
    private ResumeMapper resumeMapper;
    /**
     * 生成简历
     * @param selfDetailVO
     * @param userId
     * @return
     */
    @Override
    public Integer generatorPdf(SelfDetailVO selfDetailVO, String userId) {
        PDFUtil pdfUtil = new PDFUtil();
        try {
            pdfUtil.writeCharpter(selfDetailVO);
        }catch (Exception e) {
            e.printStackTrace();
            log.error("生成pdf错误");
            return 500;
        }
        Resume resume = new Resume();
        AutoMapperUtil.mapping(selfDetailVO, resume);
        resume.setUserId(userId);
        resume.setCreateTime(new Date());
        resume.setEditTime(new Date());
        resumeMapper.insertSelective(resume);
        return 200;
    }
}
