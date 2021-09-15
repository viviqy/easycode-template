package com.fairychar.simple.web.controller;


import com.fairychar.bag.pojo.vo.HttpResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fairychar.simple.pojo.dto.CustomerDTO;
import com.fairychar.simple.pojo.query.CustomerQuery;
import com.fairychar.simple.service.interfaces.ICustomerService;
import org.springframework.web.bind.annotation.*;
import java.io.Serializable;
import java.util.List;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;

/**
 * (Customer)表服务接口类
 *
 * @author chiyo
 * @since 2021-09-15 12:49:46
 */
@RestController
@RequestMapping("customer")
@Api(tags="接口")
public class CustomerController {
    /**
    * 服务类
    */
    @Autowired
    @Qualifier("customerService")
    private ICustomerService customerService;

    @SneakyThrows
    @PostMapping("count")
    @ApiOperation(value = "条件查询匹配数据总数", notes = "string类型模糊匹配,非string为全等匹配")
    public ResponseEntity<HttpResult<Integer>> count(@ApiParam("查询条件") @RequestBody CustomerQuery query) {
        int count = this.customerService.count(query);
        return ResponseEntity.ok(HttpResult.ok(count));
    }

    @SneakyThrows
    @PostMapping("match")
    @ApiOperation(value = "条件查询所有数据", notes = "string类型模糊匹配,非string为全等匹配")
    public ResponseEntity<HttpResult<List<CustomerDTO>>> matchAll(@ApiParam("查询条件") @RequestBody CustomerQuery query) {
        List<CustomerDTO> list = this.customerService.queryAll(query);
        return ResponseEntity.ok(HttpResult.ok(list));
    }

    @SneakyThrows
    @PostMapping("pageMatch")
    @ApiOperation(value = "分页条件查询所有数据", notes = "string类型模糊匹配,非string为全等匹配")
    public ResponseEntity<HttpResult<IPage<CustomerDTO>>> pageMatch(@ApiParam("查询条件") @RequestBody CustomerQuery query,@ApiParam("分页参数") Page page) {
        IPage<CustomerDTO> pageAll = this.customerService.pageAll(page, query);
        return ResponseEntity.ok(HttpResult.ok(pageAll));
    }

    @SneakyThrows
    @PostMapping("page")
    @ApiOperation(value = "分页查询所有数据", notes = "字段全等匹配方式查询")
    public ResponseEntity<HttpResult<IPage<CustomerDTO>>> findAll(@ApiParam("查询实体") @RequestBody CustomerQuery query,@ApiParam("分页对象") Page page) {
        return ResponseEntity.ok(HttpResult.ok(this.customerService.page(page, query)));
    }

    @SneakyThrows
    @GetMapping("/{id}")
    @ApiOperation(value = "通过主键查询单条数据")
    public ResponseEntity<HttpResult<CustomerDTO>> findOne(@PathVariable @ApiParam("主键") Serializable id) {
        return ResponseEntity.ok(HttpResult.ok(this.customerService.findOne(id)));
    }

    @SneakyThrows
    @PostMapping
    @ApiOperation(value = "新增数据")
    public ResponseEntity<HttpResult<Boolean>> insert(@RequestBody @ApiParam("实体对象") CustomerQuery query) {
        boolean result=this.customerService.save(query);
        return ResponseEntity.ok(HttpResult.ok(result));
    }
    
    @SneakyThrows
    @PostMapping("saveBatch")
    @ApiOperation(value = "批量新增数据")
    public ResponseEntity<HttpResult<Boolean>> batchInsert(@RequestBody @ApiParam("实体对象") List<CustomerQuery> queries) {
        boolean result=this.customerService.saveBatch(queries);
        return ResponseEntity.ok(HttpResult.ok(result));
    }

    @SneakyThrows
    @PutMapping
    @ApiOperation(value = "修改数据")
    public ResponseEntity<HttpResult<Boolean>> updateById(@RequestBody @ApiParam("实体对象") CustomerQuery query) {
        boolean result=this.customerService.updateById(query);
        return ResponseEntity.ok(HttpResult.ok(result));
    }

    @SneakyThrows
    @PutMapping("batch")
    @ApiOperation(value = "批量修改数据")
    public ResponseEntity<HttpResult<Boolean>> updateBatch(@RequestBody @ApiParam("实体对象") List<CustomerQuery> queries) {
        boolean result=this.customerService.updateBatchById(queries);
        return ResponseEntity.ok(HttpResult.ok(result));
    }
    
    @SneakyThrows
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除数据")
    public ResponseEntity<HttpResult<Boolean>> remove(@PathVariable("id") @ApiParam("主键") Serializable id) {
        return ResponseEntity.ok(HttpResult.ok(this.customerService.removeById(id)));
    }
    
    @SneakyThrows
    @DeleteMapping("batch")
    @ApiOperation(value = "通过id数组批量删除数据")
    public ResponseEntity<HttpResult<Boolean>> removeBatch(@ApiParam("主键数组") List<Serializable> idList) {
        return ResponseEntity.ok(HttpResult.ok(this.customerService.removeBatch(idList)));
    }
    
    @SneakyThrows
    @GetMapping("batch")
    @ApiOperation(value = "通过id数组批量查询数据")
    public ResponseEntity<HttpResult<List<CustomerDTO>>> findBatch(@ApiParam("主键数组") List<Serializable> idList) {
        List<CustomerDTO> list = this.customerService.findBatch(idList);
        return ResponseEntity.ok(HttpResult.ok(list));
    }
}
