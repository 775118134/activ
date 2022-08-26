package com.hmm.mht.activ.operation.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hmm.mht.activ.common.result.R;
import com.hmm.mht.activ.entity.order.Order;
import com.hmm.mht.activ.operation.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 订单表
 */
@RestController
@RequestMapping("/orders")
@Api(tags = "订单信息")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/findAll")
    @ApiOperation("查询所有的 订单表")
    public R<List<Order>> findAll() {
        return R.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation("通过ID查询单个订单表")
    public R<Order> findById(@ApiParam("ID") @PathVariable("id") String id) {
        return R.ok(orderService.findById(id));
    }

    @GetMapping
    @ApiOperation("分页查询订单表")
    public R<IPage<Order>> findByPage(@ApiParam("页号") @RequestParam(defaultValue = "1") Integer pageNum,
                                      @ApiParam("每页大小") @RequestParam(defaultValue = "10") Integer pageSize) {
        return R.ok(orderService.findByPage(pageNum, pageSize));
    }

    @PostMapping
    @ApiOperation("新增订单表")
    public R<Boolean> insert(@RequestBody Order order) {
        return R.ok(orderService.insert(order) > 0);
    }

    @PutMapping
    @ApiOperation("修改订单表")
    public R<Boolean> update(@RequestBody Order order) {
        return R.ok(orderService.update(order) > 0);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("通过ID删除单个订单表")
    public R<Boolean> deleteById(@ApiParam("ID") @PathVariable("id") String id) {
        return R.ok(orderService.deleteById(id) > 0);
    }
}
