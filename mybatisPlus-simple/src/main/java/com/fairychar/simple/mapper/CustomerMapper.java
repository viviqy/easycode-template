package com.fairychar.simple.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fairychar.simple.entity.Customer;
import java.util.List;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * (Customer)表数据库访问层
 *
 * @author chiyo
 * @since 2021-09-15 12:49:46
 */
public interface CustomerMapper extends BaseMapper<Customer> {
    
    /**
    * 条件匹配查询Customer所有数据
    * @param customer {@link Customer}查询条件
    * @return 查询结果 {@link Customer}
    */
    List<Customer> queryAll(@Param("e") Customer customer);
    
    /**
    * 条件匹配分页查询Customer所有数据
    * @param page 分页参数
    * @param customer {@link Customer}查询条件
    * @return 查询结果 {@link Customer}
    */
    IPage<Customer> pageAll(@Param("page") Page page,@Param("e") Customer customer);
    
    /**
    * 条件匹配查询Customer匹配数据总数
    * @param customer {@link Customer}查询条件
    * @return 总数
    */
    int count(@Param("e") Customer customer);
    
    /**
     * @param fields 分组字段集
     * @return {@link Customer}数据集
     */
    List<Customer> countGroupBy(@Param("fields") String fields);
}
