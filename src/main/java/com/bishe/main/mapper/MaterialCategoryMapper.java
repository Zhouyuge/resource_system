package com.bishe.main.mapper;

import com.bishe.main.entity.MaterialCategory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MaterialCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MaterialCategory record);

    int insertSelective(MaterialCategory record);

    MaterialCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterialCategory record);

    int updateByPrimaryKey(MaterialCategory record);

    @Select("select id, category_name, category_content, category_count, create_time, use_repeat " +
            "from " +
            "tb_material_category")
    List<MaterialCategory> getMaterialCategorys();

    @Select("select id, category_name, category_content, category_count, create_time, use_repeat " +
            "from " +
            "tb_material_category " +
            "where " +
            "category_name like concat('%', #{str} ,'%')")
    List<MaterialCategory> getMaterialCategorysByLike(@Param("str") String str);
}