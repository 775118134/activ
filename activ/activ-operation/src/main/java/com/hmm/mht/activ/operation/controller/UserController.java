package com.hmm.mht.activ.operation.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hmm.mht.activ.common.result.R;
import com.hmm.mht.activ.entity.user.User;
import com.hmm.mht.activ.operation.service.UserService;
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
 * 用户表
 */
@RestController
@RequestMapping("/users")
@Api(tags = "用户信息")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    @ApiOperation("查询所有的 用户表")
    public R<List<User>> findAll() {
        return R.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation("通过ID查询单个用户表")
    public R<User> findById(@ApiParam("ID") @PathVariable("id") String id) {
        return R.ok(userService.findById(id));
    }

    @GetMapping
    @ApiOperation("分页查询用户表")
    public R<IPage<User>> findByPage(@ApiParam("页号") @RequestParam(defaultValue = "1") Integer pageNum,
                                     @ApiParam("每页大小") @RequestParam(defaultValue = "10") Integer pageSize) {
        return R.ok(userService.findByPage(pageNum, pageSize));
    }

    @PostMapping
    @ApiOperation("新增用户表")
    public R<Boolean> insert(@RequestBody User user) {
        return R.ok(userService.insert(user) > 0);
    }

    @PutMapping
    @ApiOperation("修改用户表")
    public R<Boolean> update(@RequestBody User user) {
        return R.ok(userService.update(user) > 0);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("通过ID删除单个用户表")
    public R<Boolean> deleteById(@ApiParam("ID") @PathVariable("id") String id) {
        return R.ok(userService.deleteById(id) > 0);
    }
}
