package com.hmm.mht.activ.entity.user;

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
 * 用户表
 */
@Data
@TableName("`user`")
@ApiModel("用户")
public class User implements Serializable {
    /**
     * 唯一
     */
    @TableId
    @ApiModelProperty(name = "id", value = "唯一")
    @TableField("id")
    private String id;
    /**
     * 活动ID
     */
    @ApiModelProperty(name = "activId", value = "活动ID")
    @TableField("activ_id")
    private String activId;
    /**
     * 用户ID：脱敏加密生成，唯一
     */
    @ApiModelProperty(name = "userId", value = "用户ID：脱敏加密生成，唯一")
    @TableField("user_id")
    private String userId;
    /**
     * 身份证号码
     */
    @ApiModelProperty(name = "idcard", value = "身份证号码")
    @TableField("idcard")
    private String idcard;
    /**
     * 手机号
     */
    @ApiModelProperty(name = "mobild", value = "手机号")
    @TableField("mobild")
    private String mobild;
    /**
     * 属性 json格式
     */
    @ApiModelProperty(name = "attribute", value = "属性 json格式")
    @TableField("attribute")
    private String attribute;
    /**
     * 描述
     */
    @ApiModelProperty(name = "comment", value = "描述")
    @TableField("comment")
    private String comment;
    /**
     * 入库标识
     */
    @ApiModelProperty(name = "tag", value = "入库标识")
    @TableField("tag")
    private String tag;
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