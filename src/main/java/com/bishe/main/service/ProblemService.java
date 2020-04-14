package com.bishe.main.service;

import com.bishe.main.entity.Problem;
import com.github.pagehelper.Page;

/**
 * @author Kirito
 * @Date 2020/4/14 17:12
 */
public interface ProblemService {
    Page<Problem> getProblem(Integer pageNum);

    Problem getProblemById(Long id);
}
