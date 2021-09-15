package com.fairychar.feign.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fairychar.feign.mapper.CustomerMapper;
import com.fairychar.feign.entity.Customer;
import com.fairychar.feign.pojo.query.CustomerQuery;
import com.fairychar.feign.pojo.dto.CustomerDTO;
import com.fairychar.feign.service.interfaces.ICustomerService;
import com.fairychar.feign.service.structure.CustomerStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import java.io.Serializable;
import org.springframework.transaction.annotation.Transactional;

/**
 * (Customer)表服务实现类
 *
 * @author chiyo
 * @since 2021-09-15 12:56:02
 */
@Service("customerService")
@Transactional(rollbackFor = Exception.class)
public class CustomerService extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CustomerStructure customerStructure;
    
    /**
    * 条件匹配查询Customer所有数据
    * @param customerQuery {@link CustomerQuery}查询条件
    * @return 查询结果 {@link CustomerDTO}
    */
    @Override
    public List<CustomerDTO> queryAll(CustomerQuery customerQuery){
        Customer entity = this.customerStructure.queryToEntity(customerQuery);
        List<Customer> list = this.customerMapper.queryAll(entity);
        return this.customerStructure.entitiesToDtos(list);
    }
    
    /**
    * 条件匹配分页查询Customer所有数据
    * @param page 分页参数
    * @param customerQuery {@link CustomerQuery}查询条件
    * @return 查询结果 {@link CustomerDTO}
    */
    @Override
    public IPage<CustomerDTO> pageAll(Page page,CustomerQuery customerQuery){
        Customer entity = this.customerStructure.queryToEntity(customerQuery);
        IPage<Customer> queries = this.customerMapper.pageAll(page,entity);
        List<CustomerDTO> dtos = this.customerStructure.entitiesToDtos(queries.getRecords());
        Page<CustomerDTO> resultPage = new Page<>(queries.getCurrent(),queries.getSize(),queries.getTotal());
        resultPage.setRecords(dtos);
        return resultPage;
    }

    /**
     * 插入
     * @param customerQuery {@link CustomerQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean save(CustomerQuery customerQuery) {
        Customer entity = this.customerStructure.queryToEntity(customerQuery);
        return this.save(entity);
    }

    /**
     * 更新
     * @param customerQuery {@link CustomerQuery}查询条件
     * @return 是否成功
     */
    @Override
    public boolean updateById(CustomerQuery customerQuery) {
        Customer entity = this.customerStructure.queryToEntity(customerQuery);
        return this.updateById(entity);
    }

    /**
     * 分页查询(全等匹配)
     * @param page 分页对象
     * @param customerQuery {@link CustomerQuery}查询条件
     * @return 查询结果 {@link CustomerDTO}
     */
    @Override
    public IPage<CustomerDTO> page(Page page, CustomerQuery customerQuery){
        Customer entity = this.customerStructure.queryToEntity(customerQuery);
        return this.page(page,new QueryWrapper<>(entity));
    }
    
    /**
     * 条件查询匹配总数
     * @param customerQuery {@link CustomerQuery}查询条件
     * @return 总数
     */
    @Override
    public int count(CustomerQuery customerQuery){
        Customer entity = this.customerStructure.queryToEntity(customerQuery);
        return this.customerMapper.count(entity);
    }

    /**
     * 根据id查询一个对象
     * @param id id
     * @return 查询结果 {@link CustomerDTO}
     */
    @Override
    public CustomerDTO findOne(Serializable id) {
        CustomerDTO one = this.customerStructure.entityToDto(this.getById(id));
        return one;
    }
    
    /**
     * 批量新增
     * @param batch 新增数据 
     * @return 是否成功
     */
    @Override
    public boolean saveBatch(List<CustomerQuery> batch){
        List<Customer> entities = this.customerStructure.queriesToEntities(batch);
        return this.saveBatch(entities);
    }
}
