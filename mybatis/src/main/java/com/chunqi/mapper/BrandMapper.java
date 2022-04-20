package com.chunqi.mapper;

import com.chunqi.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    //查看全部
    public List<Brand> selectAll();

    //通过id查看全部
    public List<Brand> selectById(int id);

    //单独或者复数查询
    public List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

    //通过对象查询
    public List<Brand> selectByCondition(Brand brand);

    //通过map查询
    public List<Brand> selectByCondition(Map map);

    //动态sql 通过对象查询
    List<Brand> selectByStatus(Brand brand);

    //添加数据
    void addAll(Brand brand);

    //修改数据
    void update(Brand brand);

    //通过id删除数据
    void deleteById(int id);

    //删除多条数据
    void deleteByIds(@Param("ids") int[] ids);

}

