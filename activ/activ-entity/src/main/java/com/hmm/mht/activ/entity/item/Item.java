package com.hmm.mht.activ.entity.item;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 奖品表
 */
@Data
@TableName("`item`")
@ApiModel("奖品")
public class Item implements Serializable {
    /**
     *
     */
    @TableId
    @ApiModelProperty(name = "id", value = "")
    @TableField("id")
    private String id;
    /**
     * 活动ID
     */
    @ApiModelProperty(name = "activId", value = "活动ID")
    @TableField("activ_id")
    private String activId;
    /**
     * 奖品名称
     */
    @ApiModelProperty(name = "name", value = "奖品名称")
    @TableField("name")
    private String name;
    /**
     * 奖品分组
     */
    @ApiModelProperty(name = "group", value = "奖品分组")
    @TableField("group")
    private String group;
    /**
     * 商品总量
     */
    @ApiModelProperty(name = "total", value = "商品总量")
    @TableField("total")
    private Integer total;
    /**
     * 剩余数量
     */
    @ApiModelProperty(name = "remain", value = "剩余数量")
    @TableField("remain")
    private Integer remain;
    /**
     * 中奖权重
     */
    @ApiModelProperty(name = "weight", value = "中奖权重")
    @TableField("weight")
    private BigDecimal weight;
    /**
     * 描述 json格式
     */
    @ApiModelProperty(name = "desc", value = "描述 json格式")
    @TableField("desc")
    private String desc;
    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createTime", value = "创建时间")
    @TableField("create_time")
    private Date createTime;
    /**
     * 是否删除：0-正常；1-已删除
     */
    @ApiModelProperty(name = "delFlag", value = "是否删除：0-正常；1-已删除")
    @TableField("del_flag")
    @TableLogic
    private String delFlag;
}