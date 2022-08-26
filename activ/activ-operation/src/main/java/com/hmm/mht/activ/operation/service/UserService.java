package com.hmm.mht.activ.operation.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hmm.mht.activ.entity.user.User;

import java.util.List;

/**
 * 用户表
 */
public interface UserService extends IService<User> {

    /**
     * 查询所有的 用户表
     *
     * @return {@link User}
     */
    List<User> findAll();

    /**
     * 通过ID查询单个用户表
     *
     * @param id ID
     * @return {@link User}
     */
    User findById(String id);

    /**
     * 分页查询用户表
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link User}
     */
    IPage<User> findByPage(int pageNum, int pageSize);

    /**
     * 新增用户表
     *
     * @param user 用户表
     */
    int insert(User user);

    /**
     * 修改用户表
     *
     * @param user 用户表
     */
    int update(User user);

    /**
     * 通过ID删除单个用户表
     *
     * @param id ID
     */
    int deleteById(String id);

}