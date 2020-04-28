package com.bishe.main.mapper;

import com.bishe.main.entity.Material;
import com.bishe.main.vo.MaterialVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MaterialMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Material record);

    int insertSelective(Material record);

    Material selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);

    @Select({"<script>",
            "select m.id, m.material_name, m.category_id, m.material_speci, m.material_packing, ",
            "m.material_content, m.material_info, m.material_img, m.create_time, c.category_name ",
            "from tb_material m, tb_material_category c ",
            "where 1 = 1 ",
            "and m.category_id = c.id ",
            "<when test = 'str != null'>",
            "and m.material_name like concat('%', #{str}, '%')",
            "</when>",
            "</script>"})
    List<MaterialVO> getMaterials(@Param("str") String str);
}