package com.hmm.mht.activ.operation.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hmm.mht.activ.entity.order.Order;

import java.util.List;

/**
 * 订单表
 */
public interface OrderService extends IService<Order> {

    /**
     * 查询所有的 订单表
     *
     * @return {@link Order}
     */
    List<Order> findAll();

    /**
     * 通过ID查询单个订单表
     *
     * @param id ID
     * @return {@link Order}
     */
    Order findById(String id);

    /**
     * 分页查询订单表
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link Order}
     */
    IPage<Order> findByPage(int pageNum, int pageSize);

    /**
     * 新增订单表
     *
     * @param order 订单表
     */
    int insert(Order order);

    /**
     * 修改订单表
     *
     * @param order 订单表
     */
    int update(Order order);

    /**
     * 通过ID删除单个订单表
     *
     * @param id ID
     */
    int deleteById(String id);

}