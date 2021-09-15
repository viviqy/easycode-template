package com.fairychar.simple.entity;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableField;
/**
 * (Customer)表实体类
 *
 * @author chiyo
 * @since 2021-09-15 12:49:46
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@ApiModel("Customer")
public class Customer extends Model<Customer> {
    @ApiModelProperty(" 主键")
    @TableId(type = IdType.AUTO,value = "id")
    private Integer id;
    @ApiModelProperty("用户名")
    @TableField(value = "`username`")
    private String username;
    @ApiModelProperty("密码")
    @TableField(value = "`password`")
    private String password;
    @TableField(exist = false)
    @ApiModelProperty("分组数量匹配字段,和原表无关")
    private Integer groupByCount;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    

    /**
    * id -  主键
    */
    public final static String ID = "id";

    /**
    * username - 用户名
    */
    public final static String USERNAME = "username";

    /**
    * password - 密码
    */
    public final static String PASSWORD = "password";

}
