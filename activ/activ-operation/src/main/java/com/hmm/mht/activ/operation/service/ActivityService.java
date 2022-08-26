package com.hmm.mht.activ.operation.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hmm.mht.activ.entity.activity.Activity;

import java.util.List;

/**
 *
 */
public interface ActivityService extends IService<Activity> {

    /**
     * 查询所有的
     *
     * @return {@link Activity}
     */
    List<Activity> findAll();

    /**
     * 通过ID查询单个
     *
     * @param id ID
     * @return {@link Activity}
     */
    Activity findById(String id);

    /**
     * 分页查询
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link Activity}
     */
    IPage<Activity> findByPage(int pageNum, int pageSize);

    /**
     * 新增
     *
     * @param activity
     */
    int insert(Activity activity);

    /**
     * 修改
     *
     * @param activity
     */
    int update(Activity activity);

    /**
     * 通过ID删除单个
     *
     * @param id ID
     */
    int deleteById(String id);

}