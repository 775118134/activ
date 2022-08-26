package com.hmm.mht.activ.common.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
@ApiModel("响应状态机")
//@SwaggerDisplayEnum(valueName = "响应状态机")
public enum BR implements CR {
    SUCCESS(10000, "success"),
    PARAMETER_VALIDATION_ERROR(10001, "参数不合法"),
    FAST_ACCESS_ERROR(90000, "访问太快"),
    UNKNOWN_ERROR(90001, "未知错误"),
    UNPERIOD_ERROR(90002, "活动已过期或还未开始"),

    //20000开头为用户信息相关错误定义
    USER_NOT_EXIST_ERROR(20001, "用户不存在"),
    //20100开头为用户验证码发送相关错误定义
    USER_CODE_UNKNOWN_ERROR(20101, "验证码内部错误"),
    USER_CODE_FAIL_ERROR(20102, "验证码错误"),
    USER_CODE_FREQUENT_ERROR(20103, "验证码发送频繁"),
    USER_CODE_EXPIRES_ERROR(20104, "验证码已过期"),
    USER_CODE_MAX_SEND_ERROR(20105, "已达到单日验证码发送上限"),

    //30000开头为交易信息错误定义
    STOCK_NOT_ENOUGH_ERROR(30001, "库存不足"),
    MQ_SEND_FAIL_ERROR(30002, "库存异步消息不足"),
    RATE_LIMIT_ERROR(30003, "活动太火爆，请稍后再试");

    @ApiModelProperty(value = "响应状态码")
    private int code;
    @ApiModelProperty(value = "响应描述信息")
    private String msg;

}
