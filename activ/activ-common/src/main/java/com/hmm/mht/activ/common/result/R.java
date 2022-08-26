package com.hmm.mht.activ.common.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hmm.mht.activ.common.constant.CommonConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 响应信息主体
 */
@Builder
@Accessors(chain = true)
@ApiModel(value = "响应信息主体")
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class R<T> implements CR {
    private static final long serialVersionUID = 1L;

//    @Tolerate
//    public R() {
//
//    }

    @ApiModelProperty(value = "返回标记：成功标记=1，失败标记=0")
    @Builder.Default
    private int status = CommonConstants.SUCCESS;

    @ApiModelProperty(value = "数据")
    private T data;

    @ApiModelProperty(value = "响应详细描述信息")
    private String subMsg;

    @ApiModelProperty(value = "响应时间戳")
    @Builder.Default
    private long timestamp = System.currentTimeMillis();

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @JsonIgnore
    @Builder.Default
    private BR br = BR.SUCCESS;

    public static <T> R<T> ok() {
        return R.<T>builder().build();
    }

    public static <T> R<T> ok(T data) {
        return R.<T>builder().data(data).build();
    }


    public static <T> R<T> ok(T data, String subMsg) {
        return R.<T>builder().data(data).subMsg(subMsg).build();
    }

    public static <T> R<T> failed() {
        return R.<T>builder().status(CommonConstants.FAIL).br(BR.UNKNOWN_ERROR).build();
    }

    public static <T> R<T> failed(T data) {
        return R.<T>builder().status(CommonConstants.FAIL).br(BR.UNKNOWN_ERROR).data(data).build();
    }

    public static <T> R<T> failed(String subMsg) {
        return R.<T>builder().status(CommonConstants.FAIL).br(BR.UNKNOWN_ERROR).subMsg(subMsg).build();
    }

    public static <T> R<T> failed(BR br) {
        return R.<T>builder().status(CommonConstants.FAIL).br(br).build();
    }

    public static <T> R<T> failed(BR br, T data) {
        return R.<T>builder().status(CommonConstants.FAIL).br(br).data(data).build();
    }

    public static <T> R<T> failed(BR br, String subMsg) {
        return R.<T>builder().status(CommonConstants.FAIL).br(br).subMsg(subMsg).build();
    }

    public static <T> R<T> failed(BR br, T data, String subMsg) {
        return R.<T>builder().status(CommonConstants.FAIL).br(br).data(data).subMsg(subMsg).build();
    }

    @Override
    public int getCode() {
        return br.getCode();
    }

    @Override
    public String getMsg() {
        return br.getMsg();
    }

}
