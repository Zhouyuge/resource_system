package com.bishe.main.service.impl;

import com.bishe.main.dao.MoreauChapMapper;
import com.bishe.main.dao.MoreauContentMapper;
import com.bishe.main.dao.MoreauMapper;
import com.bishe.main.entity.Moreau;
import com.bishe.main.entity.MoreauContent;
import com.bishe.main.service.MoreauService;
import com.bishe.main.vo.MoreauVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/3/31 19:35
 */
@Service
public class MoreauServiceImpl implements MoreauService {

    @Autowired
    private MoreauContentMapper moreauContentMapper;

    @Autowired
    private MoreauMapper moreauMapper;

    @Autowired
    private MoreauChapMapper moreauChapMapper;
    @Override
    public List<MoreauVO> getMoreauVOByMoreauId(Integer moreauId) {
        return moreauChapMapper.selectByMoreauId(moreauId);
    }

    @Override
    public List<Moreau> getAllMoreaus() {
        return moreauMapper.selectAll();
    }

    @Override
    public MoreauContent getMoreauContent(Integer id) {
        return moreauContentMapper.selectByPrimaryKey(id);
    }
}
