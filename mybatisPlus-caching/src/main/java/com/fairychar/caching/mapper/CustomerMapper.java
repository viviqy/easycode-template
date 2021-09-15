package com.fairychar.caching.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fairychar.caching.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Customer)表数据库访问层
 *
 * @author chiyo
 * @since 2021-09-15 12:53:42
 */
public interface CustomerMapper extends BaseMapper<Customer> {
    
    /**
    * 条件匹配查询Customer所有数据
    * @param customer {@link Customer}查询条件
    * @return 查询结果 {@link Customer}
    */
    List<Customer> queryAll(Customer customer);
    
    /**
    * 条件匹配分页查询Customer所有数据
    * @param page 分页参数
    * @param customer {@link Customer}查询条件
    * @return 查询结果 {@link Customer}
    */
    IPage<Customer> pageAll(@Param("page") Page page,@Param("customer") Customer customer);
    
    /**
    * 条件匹配查询Customer匹配数据总数
    * @param customer {@link Customer}查询条件
    * @return 总数
    */
    int count(Customer customer);
}
