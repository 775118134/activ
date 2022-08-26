package com.hmm.mht.activ.common.result;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author hmm
 * @date 2021/6/10 15:29
 * @Description: * CR -> Common Response
 * * 响应主体基础类
 */
public interface CR extends Serializable {
    @ApiModelProperty(value = "响应状态码")
    int getCode();

    @ApiModelProperty(value = "响应描述信息")
    String getMsg();
}
