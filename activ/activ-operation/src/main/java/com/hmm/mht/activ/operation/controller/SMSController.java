package com.hmm.mht.activ.operation.controller;

import cn.hutool.core.date.SystemClock;
import cn.hutool.core.util.RandomUtil;
import com.hmm.mht.activ.common.constant.CacheConstants;
import com.hmm.mht.activ.common.result.BR;
import com.hmm.mht.activ.common.result.R;
import com.hmm.mht.activ.entity.sms.SMSCode;
import com.hmm.mht.activ.operation.utils.DateUtils;
import com.hmm.mht.activ.operation.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.Null;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hmm
 * @date 2021/6/9 22:49
 * @Description:
 */

@RestController
@AllArgsConstructor
@RequestMapping("/sms")
@Api(value = "sms", tags = "短讯服务")
@Slf4j
public class SMSController {

    private HttpServletRequest httpServletRequest;

    private RedisUtils redisUtils;

    private String getCodeCacheKey(String phone) {
        return CacheConstants.GLOBALLY + CacheConstants.DEFAULT_CODE_KEY + phone;
    }

    /*produces：它的作用是指定返回值类型，不但可以设置返回值类型还可以设定返回值的字符编码；
    consumes： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;*/
    @ApiOperation(value = "发送短信", consumes = CacheConstants.CODE_CONSUMES)
//    @GetMapping(value = "/send/{telphone}", consumes = CacheConstants.CODE_CONSUMES)
    @GetMapping(value = "/send/{telphone}")
    @Transactional
    public R<Null> send(@ApiParam("手机号码") @PathVariable("telphone") String telphone) {

        //判断是否已发送短信
        //
        //发送短信
        //    验证手机是否在白名单
        //          return R.failed(BR.USER_NOT_EXIST_ERROR);
        //    生成验证码
        //    发送短信
        //    返回

        //手机号//验证码//过期时间//发送次数//重新发送过期时间


        SMSCode smsCode = redisUtils.hmget(getCodeCacheKey(telphone), SMSCode.class);

        if (smsCode != null) {
//            判断是否为当日数据
            if (DateUtils.isToday(smsCode.getCreateTime())) {

                if (smsCode.getSendNum() > CacheConstants.CODE_MAX_SEND) {
                    //判断是否达到最大次数
                    return R.failed(BR.USER_CODE_MAX_SEND_ERROR);
                } else if ((SystemClock.now() - smsCode.getReTryExpireTIme()) < CacheConstants.CODE_EXPIRE_TIME_RETRY) {
                    //是否达到尝试时间
                    return R.failed(BR.USER_CODE_FREQUENT_ERROR);
                } else {
                    smsCode.sendPrefixExec();
                }
            } else {
                smsCode = null;
            }
        }

        if (smsCode == null) {
            smsCode = SMSCode.builder().phone(telphone).build();
        }

        String otpCode = RandomUtil.randomNumbers(CacheConstants.CODE_LENGTH);
        smsCode.setCode(otpCode);

        //TODO 调用发送短信sdk
//        xxx.send(telphone, otpCode);

        //=========
        if (redisUtils.hmset(getCodeCacheKey(telphone), smsCode, smsCode.getExpire())) {
            return R.ok();
        } else {
            return R.failed(BR.USER_CODE_UNKNOWN_ERROR);
        }

    }

    @GetMapping(value = "/verify/{telphone}", consumes = CacheConstants.CODE_CONSUMES)
    @ResponseBody
    public R<Null> verify(@PathVariable("telphone") String telphone) {
//        验证码是否过期
//        return R.failed(BR.USER_CODE_EXPIRES_ERROR);
//
////        验证码是否正确
//        return R.failed(BR.USER_CODE_FAIL_ERROR);
        return R.ok();

    }


}
