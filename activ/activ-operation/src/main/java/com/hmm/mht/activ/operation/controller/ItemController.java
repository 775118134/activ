package com.hmm.mht.activ.operation.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hmm.mht.activ.common.result.R;
import com.hmm.mht.activ.entity.item.Item;
import com.hmm.mht.activ.operation.service.ItemService;
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
 * 奖品表
 */
@RestController
@RequestMapping("/items")
@Api(tags = "奖品信息")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/findAll")
    @ApiOperation("查询所有的 奖品表")
    public R<List<Item>> findAll() {
        return R.ok(itemService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation("通过ID查询单个奖品表")
    public R<Item> findById(@ApiParam("ID") @PathVariable("id") String id) {
        return R.ok(itemService.findById(id));
    }

    @GetMapping
    @ApiOperation("分页查询奖品表")
    public R<IPage<Item>> findByPage(@ApiParam("页号") @RequestParam(defaultValue = "1") Integer pageNum,
                                     @ApiParam("每页大小") @RequestParam(defaultValue = "10") Integer pageSize) {
        return R.ok(itemService.findByPage(pageNum, pageSize));
    }

    @PostMapping
    @ApiOperation("新增奖品表")
    public R<Boolean> insert(@RequestBody Item item) {
        return R.ok(itemService.insert(item) > 0);
    }

    @PutMapping
    @ApiOperation("修改奖品表")
    public R<Boolean> update(@RequestBody Item item) {
        return R.ok(itemService.update(item) > 0);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("通过ID删除单个奖品表")
    public R<Boolean> deleteById(@ApiParam("ID") @PathVariable("id") String id) {
        return R.ok(itemService.deleteById(id) > 0);
    }
}
