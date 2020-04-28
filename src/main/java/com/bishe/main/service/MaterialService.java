package com.bishe.main.service;

import com.bishe.main.entity.Material;
import com.bishe.main.vo.MaterialVO;
import com.github.pagehelper.Page;

/**
 * @author Kirito
 * @Date 2020/4/25 10:34
 */
public interface MaterialService {
    Page<MaterialVO> getMaterialVOs(String str, Integer pageNum);

    Long getCount();

    Integer insertMaterial(Material material);

    Integer updateMaterial(MaterialVO material);

    Integer deleteMaterial(Integer id);

    MaterialVO getMaterial(Integer id);

}
