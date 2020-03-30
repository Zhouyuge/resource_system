package com.bishe.main.service;

import com.bishe.main.entity.Resume;
import com.bishe.main.vo.SelfDetailVO;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/1/7 17:10
 * 工作Service
 */
public interface WorkService {
    Integer generatorPdf(SelfDetailVO selfDetailVO, String userId);

    List<Resume> getUserResumeList(String userId);

    Resume getResumeById(Integer id);

    int updateResume(Resume resume);

    int deleteResume(Integer id);

    int addResume(Resume resume);
}
