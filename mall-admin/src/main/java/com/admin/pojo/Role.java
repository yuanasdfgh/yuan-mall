package com.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 后台用户角色表
 * </p>
 *
 * @author yuan
 * @since 2022-09-03
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("role")
@ApiModel(value = "Role对象", description = "后台用户角色表")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("后台用户数量")
    @TableField("admin_count")
    private Integer adminCount;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("启用状态：0->禁用；1->启用")
    @TableField("status")
    private Integer status;

    @TableField("sort")
    private Integer sort;
}
