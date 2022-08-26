package com.hmm.mht.activ.operation.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hmm.mht.activ.common.result.R;
import com.hmm.mht.activ.entity.activity.Activity;
import com.hmm.mht.activ.operation.service.ActivityService;
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
 * 活动信息
 */
@RestController
@RequestMapping("/activitys")
@Api(tags = "活动信息")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping("/findAll")
    @ApiOperation("查询所有的 ")
    public R<List<Activity>> findAll() {
        return R.ok(activityService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation("通过ID查询单个")
    public R<Activity> findById(@ApiParam("ID") @PathVariable("id") String id) {
        return R.ok(activityService.findById(id));
    }

    @GetMapping
    @ApiOperation("分页查询")
    public R<IPage<Activity>> findByPage(@ApiParam("页号") @RequestParam(defaultValue = "1") Integer pageNum,
                                         @ApiParam("每页大小") @RequestParam(defaultValue = "10") Integer pageSize) {
        return R.ok(activityService.findByPage(pageNum, pageSize));
    }

    @PostMapping
    @ApiOperation("新增")
    public R<Boolean> insert(@RequestBody Activity activity) {
        return R.ok(activityService.insert(activity) > 0);
    }

    @PutMapping
    @ApiOperation("修改")
    public R<Boolean> update(@RequestBody Activity activity) {
        return R.ok(activityService.update(activity) > 0);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("通过ID删除单个")
    public R<Boolean> deleteById(@ApiParam("ID") @PathVariable("id") String id) {
        return R.ok(activityService.deleteById(id) > 0);
    }
}
