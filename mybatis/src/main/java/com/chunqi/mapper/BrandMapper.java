package com.chunqi.mapper;

import com.chunqi.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    //�鿴ȫ��
    public List<Brand> selectAll();

    //ͨ��id�鿴ȫ��
    public List<Brand> selectById(int id);

    //�������߸�����ѯ
    public List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

    //ͨ�������ѯ
    public List<Brand> selectByCondition(Brand brand);

    //ͨ��map��ѯ
    public List<Brand> selectByCondition(Map map);

    //��̬sql ͨ�������ѯ
    List<Brand> selectByStatus(Brand brand);

    //�������
    void addAll(Brand brand);

    //�޸�����
    void update(Brand brand);

    //ͨ��idɾ������
    void deleteById(int id);

    //ɾ����������
    void deleteByIds(@Param("ids") int[] ids);

}

