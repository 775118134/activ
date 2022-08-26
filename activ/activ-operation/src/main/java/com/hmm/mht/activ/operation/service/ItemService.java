package com.hmm.mht.activ.operation.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hmm.mht.activ.entity.item.Item;

import java.util.List;

/**
 * 奖品表
 */
public interface ItemService extends IService<Item> {

    /**
     * 查询所有的 奖品表
     *
     * @return {@link Item}
     */
    List<Item> findAll();

    /**
     * 通过ID查询单个奖品表
     *
     * @param id ID
     * @return {@link Item}
     */
    Item findById(String id);

    /**
     * 分页查询奖品表
     *
     * @param pageNum  页号
     * @param pageSize 每页大小
     * @return {@link Item}
     */
    IPage<Item> findByPage(int pageNum, int pageSize);

    /**
     * 新增奖品表
     *
     * @param item 奖品表
     */
    int insert(Item item);

    /**
     * 修改奖品表
     *
     * @param item 奖品表
     */
    int update(Item item);

    /**
     * 通过ID删除单个奖品表
     *
     * @param id ID
     */
    int deleteById(String id);

}