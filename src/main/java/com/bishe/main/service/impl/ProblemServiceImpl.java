package com.bishe.main.service.impl;

import com.bishe.main.dao.ProblemMapper;
import com.bishe.main.entity.Problem;
import com.bishe.main.service.ProblemService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/4/14 17:13
 */
@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemMapper problemMapper;

    private static final Integer pageSize = 20;

    @Override
    public Page<Problem> getProblem(Integer pageNum) {
        Page<Problem> problemPage = PageHelper.startPage(pageNum, pageSize);
        List<Problem> problems = problemMapper.getProblem();
        return problemPage;
    }

    @Override
    public Problem getProblemById(Long id) {
        return problemMapper.selectByPrimaryKey(id);
    }
}
