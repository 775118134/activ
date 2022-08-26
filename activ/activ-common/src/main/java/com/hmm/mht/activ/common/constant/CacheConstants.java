package com.hmm.mht.activ.common.constant;

/**
 * @author hmm
 * @date 2021/6/16 11:47
 * @Description:
 */
public interface CacheConstants {

    /**
     * 全局缓存，比如:
     * <p/>
     * {@code @Cacheable(value = CacheConstants.GLOBALLY+CacheConstants.ACTIVITY_DETAILS, key = "#activityId  + '_activity'", unless = "#result == null")}
     */
    String GLOBALLY = "b-a:";

    /**
     * 活动信息缓存
     */
    String ACTIVITY_DETAILS = "activity_details";

    /**
     * 奖品信息缓存
     */
    String ITEM_DETAILS = "item_details";

    /**
     * 用户信息缓存
     */
    String USER_DETAILS = "user_details";

    /**
     * 订单信息缓存
     */
    String ORDER_DETAILS = "order_details";

    /**
     * 查找所有
     */
    String FIND_ALL = "find_all";

    /**
     * 客户端信息
     */
    String CLIENT_DETAILS_KEY = "activ:client:details";

    /**
     * 事件key
     */
    String EVENT_KEY = "event_key";

    /**
     * 参数缓存
     */
    String PARAMS_DETAILS = "params_details";

    /**
     * 验证码前缀
     */
    String DEFAULT_CODE_KEY = "default_code_key:";

    /**
     * 验证码处理内容类型
     */
    String CODE_CONSUMES = "application/abcde";

    /**
     * 验证码长度
     */
    int CODE_LENGTH = 4;

    /**
     * 验证码有效期(毫秒)
     */
    int CODE_TIME = 10 * 1000 * 60;

    /**
     * 验证码有效期(毫秒)
     */
    int CODE_EXPIRE_TIME = 10 * 1000 * 60;
    /**
     * 验证码重新发送时长(毫秒)
     */
    int CODE_EXPIRE_TIME_RETRY = 1000 * 60;
    /**
     * 验证码每日发送最大次数
     */
    int CODE_MAX_SEND = 6;

}
