package com.hmm.mht.activ.operation.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmm.mht.activ.common.constant.CacheConstants;
import com.hmm.mht.activ.entity.activity.Activity;
import com.hmm.mht.activ.operation.dao.ActivityDAO;
import com.hmm.mht.activ.operation.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hmm
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ActivityServiceImpl extends ServiceImpl<ActivityDAO, Activity> implements ActivityService {

    @Autowired
    private ActivityDAO activityDAO;

    @Transactional(readOnly = true)
    @Override
    @Cacheable(value = CacheConstants.GLOBALLY + CacheConstants.ACTIVITY_DETAILS, unless = "#result == null")
    public List<Activity> findAll() {
        return activityDAO.selectList(null);
    }

    @Transactional(readOnly = true)
    @Override
    @Cacheable(value = CacheConstants.GLOBALLY + CacheConstants.ACTIVITY_DETAILS, key = "#id", unless = "#result == null")
    public Activity findById(String id) {
        return activityDAO.selectById(id);
    }

    @Transactional(readOnly = true)
    @Override
    @Cacheable(value = CacheConstants.GLOBALLY + CacheConstants.ACTIVITY_DETAILS, key = "#pageNum  + '_' + #pageSize", unless = "#result == null")
    public IPage<Activity> findByPage(int pageNum, int pageSize) {
        return activityDAO.selectPage(new Page<>(pageNum, pageSize), null);
    }

    @Override
    @CacheEvict(value = CacheConstants.GLOBALLY + CacheConstants.ACTIVITY_DETAILS, allEntries = true)
    public int insert(Activity activity) {
        return activityDAO.insert(activity);
    }

    @Override
    @CacheEvict(value = CacheConstants.GLOBALLY + CacheConstants.ACTIVITY_DETAILS, allEntries = true)
    public int update(Activity activity) {
        return activityDAO.updateById(activity);
    }

    @Override
    @CacheEvict(value = CacheConstants.GLOBALLY + CacheConstants.ACTIVITY_DETAILS, allEntries = true)
    public int deleteById(String id) {
        return activityDAO.deleteById(id);
    }

}