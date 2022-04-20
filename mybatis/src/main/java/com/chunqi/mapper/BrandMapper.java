package com.chunqi.mapper;

import com.chunqi.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    public List<Brand> selectAll();

    public List<Brand> selectById(int id);

    public List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

    public List<Brand> selectByCondition(Brand brand);

    public List<Brand> selectByCondition(Map map);

}

