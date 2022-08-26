package com.hmm.mht.activ.operation.config;

import cn.hutool.core.date.SystemClock;
import com.hmm.mht.activ.entity.activity.Activity;
import com.hmm.mht.activ.operation.service.ActivityService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author hmm
 * @date 2021/6/22 15:22
 * @Description: 验证每次请求是否在活动时间内
 */
@Component
@Configuration
@Data
public class MhtActiveVerify {
    @Value("${mht-active}")
    private String activeId;

    private long startTime;
    private long endTime;
    private String name;

    @Autowired
    private ActivityService activityService;

    @PostConstruct
    private void init() throws Exception {
        Activity activity = activityService.findById(activeId);
        if (activity == null) {
            throw new Exception("not find activity by id");
        }
        this.startTime = activity.getStartTime().getTime();
        this.endTime = activity.getEndTime().getTime();
        this.name = activity.getName();
    }

    public boolean verify() {
        return endTime > SystemClock.now() && SystemClock.now() > startTime;

    }

}
