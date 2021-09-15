package com.fairychar.simple.pojo.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
/**
 * (Customer)表实体类
 *
 * @author chiyo
 * @since 2021-09-15 12:49:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@ApiModel("CustomerDTO")
public class CustomerDTO implements Serializable {
  
    @ApiModelProperty(" 主键")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Integer id;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("分组数量")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer groupByCount;


}
