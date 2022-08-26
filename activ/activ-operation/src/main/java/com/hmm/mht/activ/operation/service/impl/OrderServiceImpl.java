package com.hmm.mht.activ.operation.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmm.mht.activ.common.constant.CacheConstants;
import com.hmm.mht.activ.entity.order.Order;
import com.hmm.mht.activ.operation.dao.OrderDAO;
import com.hmm.mht.activ.operation.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl extends ServiceImpl<OrderDAO, Order> implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Transactional(readOnly = true)
    @Override
    @Cacheable(value = CacheConstants.GLOBALLY + CacheConstants.ORDER_DETAILS, unless = "#result == null")
    public List<Order> findAll() {
        return orderDAO.selectList(null);
    }

    @Transactional(readOnly = true)
    @Override
    @Cacheable(value = CacheConstants.GLOBALLY + CacheConstants.ORDER_DETAILS, key = "#id", unless = "#result == null")
    public Order findById(String id) {
        return orderDAO.selectById(id);
    }

    @Transactional(readOnly = true)
    @Override
    @Cacheable(value = CacheConstants.GLOBALLY + CacheConstants.ORDER_DETAILS, key = "#pageNum  + '_' + #pageSize", unless = "#result == null")
    public IPage<Order> findByPage(int pageNum, int pageSize) {
        return orderDAO.selectPage(new Page<>(pageNum, pageSize), null);
    }

    @Override
    @CacheEvict(value = CacheConstants.GLOBALLY + CacheConstants.ORDER_DETAILS, allEntries = true)
    public int insert(Order order) {
        return orderDAO.insert(order);
    }

    @Override
    @CacheEvict(value = CacheConstants.GLOBALLY + CacheConstants.ORDER_DETAILS, allEntries = true)
    public int update(Order order) {
        return orderDAO.updateById(order);
    }

    @Override
    @CacheEvict(value = CacheConstants.GLOBALLY + CacheConstants.ORDER_DETAILS, allEntries = true)
    public int deleteById(String id) {
        return orderDAO.deleteById(id);
    }

}