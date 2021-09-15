package com.fairychar.feign.service.interfaces;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.feign.entity.Customer;
import com.fairychar.feign.pojo.dto.CustomerDTO;
import com.fairychar.feign.pojo.query.CustomerQuery;
import java.util.List;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;

/**
 * (Customer)表服务接口
 *
 * @author chiyo
 * @since 2021-09-15 12:56:02
 */
public interface ICustomerService extends IService<Customer> {
    /**
    * 条件匹配查询Customer所有数据
    * @param customerQuery {@link CustomerQuery}查询条件
    * @return 查询结果 {@link CustomerDTO}
    */
    List<CustomerDTO> queryAll(CustomerQuery customerQuery);
    
   /**
    * 条件匹配分页查询Customer所有数据
    * @param page 分页参数
    * @param customerQuery {@link CustomerQuery}查询条件
    * @return 查询结果 {@link CustomerDTO}
    */
    IPage<CustomerDTO> pageAll(Page page,CustomerQuery customerQuery);
 
    /**
     * 插入
     * @param customerQuery {@link CustomerQuery}插入query
     * @return 是否成功
     */
    boolean save(CustomerQuery customerQuery);

    /**
     * 更新
     * @param customerQuery {@link CustomerQuery}更新query
     * @return 是否成功
     */
    boolean updateById(CustomerQuery customerQuery);

    /**
     * 分页查询(全等匹配)
     * @param page 分页对象
     * @param customerQuery {@link CustomerQuery}查询条件
     * @return 查询结果 {@link CustomerDTO}
     */
    IPage<CustomerDTO> page(Page page, CustomerQuery customerQuery);

    /**
     * 根据id查询一个对象
     * @param id id
     * @return 查询结果 {@link CustomerDTO}
     */
    CustomerDTO findOne(Serializable id);

    /**
     * 条件查询总数
     * @param customerQuery {@link CustomerQuery}查询条件
     * @return 总数
     */
    int count(CustomerQuery customerQuery);
    
    /**
     * 批量新增
     * @param batch 新增数据 
     * @return 是否成功
     */
    boolean saveBatch(List<CustomerQuery> batch);

}
