package com.bishe.main.mapper;

import com.bishe.main.entity.Stock;
import com.bishe.main.vo.StockVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StockMapper {
    int deleteByPrimaryKey(Integer stockId);

    int insert(Stock record);

    int insertSelective(Stock record);

    Stock selectByPrimaryKey(Integer stockId);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);


    @Delete("delete from tb_stock where resource_id = #{resourceId, jdbcType=INTEGER}")
    int deleteByResouceId(Integer resourceId);

    @Select("select m.*, s.* " +
            "from tb_material m, tb_stock s " +
            "where m.id = s.resource_id and s.resource_id = #{resourceId} ")
    StockVO selectByResourceId(@Param("resourceId") Integer id);

    @Select("select m.*, s.* " +
            "from tb_material m, tb_stock s " +
            "where m.id = s.resource_id ")
    List<StockVO> selectAll();

    @Select("select m.*, s.* " +
            "from tb_material m, tb_stock s " +
            "where m.id = s.resource_id and m.material_name like concat('%', #{str, jdbcType=VARCHAR} ,'%') ")
    List<StockVO> selectByStr(@Param("str") String str);

}