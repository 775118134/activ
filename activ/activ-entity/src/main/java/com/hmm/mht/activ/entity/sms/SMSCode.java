package com.hmm.mht.activ.entity.sms;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.SystemClock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hmm
 * @date 2021/6/17 16:21
 * @Description: 过期时间为当日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@RedisHash("SMSCode")
@Builder
//@RedisHash
public class SMSCode implements Serializable {
    /**
     * 手机号
     */
//    @Id
    private String phone;
    /**
     * 验证码
     */
    private String code;
    /**
     * 重新发送过期时间
     */
    @Builder.Default
    private long reTryExpireTIme = SystemClock.now();
    /**
     * 验证码过期时间
     */
    @Builder.Default
    private long expireTIme = SystemClock.now();
    /**
     * 最大发送次数
     */
    @Builder.Default
    private int sendNum = 1;
    /**
     * 创建时间
     */
    @Builder.Default
    private Date createTime = new DateTime();
    /**
     * 过期时间
     */
//    @TimeToLive
    @Builder.Default
    private long expire = DateUtil.between(new Date(), DateUtil.endOfDay(new Date()), DateUnit.SECOND);

    public void sendPrefixExec() {
        ++sendNum;
        reTryExpireTIme = SystemClock.now();
        expireTIme = SystemClock.now();
    }
}
