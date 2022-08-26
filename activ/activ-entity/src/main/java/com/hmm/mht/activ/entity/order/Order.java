package com.hmm.mht.activ.entity.order;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单表
 */
@Data
@TableName("`order`")
@ApiModel("订单")
public class Order implements Serializable {
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
     * 用户信息
     */
    @ApiModelProperty(name = "userId", value = "用户信息")
    @TableField("user_id")
    private String userId;
    /**
     * 奖品ID
     */
    @ApiModelProperty(name = "itemId", value = "奖品ID")
    @TableField("item_id")
    private String itemId;
    /**
     * 数量
     */
    @ApiModelProperty(name = "num", value = "数量")
    @TableField("num")
    private Integer num;
    /**
     * 创建时间
     */
    @ApiModelProperty(name = "actionTime", value = "创建时间")
    @TableField("action_time")
    private Date actionTime;
    /**
     * 是否需要通知下游：0-不需要通知；1-需要通知
     */
    @ApiModelProperty(name = "notityFlag", value = "是否需要通知下游：0-不需要通知；1-需要通知")
    @TableField("notity_flag")
    private String notityFlag;
    /**
     * 是否通知：0-未通知；1-已通知
     */
    @ApiModelProperty(name = "notity", value = "是否通知：0-未通知；1-已通知")
    @TableField("notity")
    private String notity;
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