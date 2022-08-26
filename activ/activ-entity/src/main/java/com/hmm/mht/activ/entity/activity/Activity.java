package com.hmm.mht.activ.entity.activity;

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
 *
 */
@Data
@TableName("`activity`")
@ApiModel("活动")
public class Activity implements Serializable {
    /**
     * 活动ID
     */
    @TableId
//    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(name = "id", value = "活动ID")
    @TableField("id")
    private String id;
    /**
     * 活动名称
     */
    @ApiModelProperty(name = "name", value = "活动名称")
    @TableField("name")
    private String name;
    /**
     * 开始时间
     */
    @ApiModelProperty(name = "startTime", value = "开始时间")
    @TableField("start_time")
    private Date startTime;
    /**
     * 结束时间
     */
    @ApiModelProperty(name = "endTime", value = "结束时间")
    @TableField("end_time")
    private Date endTime;
    /**
     * 描述 json格式
     */
    @ApiModelProperty(name = "desc", value = "描述 json格式")
    @TableField("`desc`")
    private String desc;
    /**
     * 是否需要通知下游：0-不需要通知；1-需要通知
     */
    @ApiModelProperty(name = "notityFlag", value = "是否需要通知下游：0-不需要通知；1-需要通知")
    @TableField("notity_flag")
    private String notityFlag;
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