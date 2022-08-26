package com.hmm.mht.activ.operation.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmm.mht.activ.common.constant.CacheConstants;
import com.hmm.mht.activ.entity.item.Item;
import com.hmm.mht.activ.operation.dao.ItemDAO;
import com.hmm.mht.activ.operation.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ItemServiceImpl extends ServiceImpl<ItemDAO, Item> implements ItemService {

    @Autowired
    private ItemDAO itemDAO;

    @Transactional(readOnly = true)
    @Override
    @Cacheable(value = CacheConstants.GLOBALLY + CacheConstants.ITEM_DETAILS, unless = "#result == null")
    public List<Item> findAll() {
        return itemDAO.selectList(null);
    }

    @Transactional(readOnly = true)
    @Override
    @Cacheable(value = CacheConstants.GLOBALLY + CacheConstants.ITEM_DETAILS, key = "#id", unless = "#result == null")
    public Item findById(String id) {
        return itemDAO.selectById(id);
    }

    @Transactional(readOnly = true)
    @Override
    @Cacheable(value = CacheConstants.GLOBALLY + CacheConstants.ITEM_DETAILS, key = "#pageNum  + '_' + #pageSize", unless = "#result == null")
    public IPage<Item> findByPage(int pageNum, int pageSize) {
        return itemDAO.selectPage(new Page<>(pageNum, pageSize), null);
    }

    @Override
    @CacheEvict(value = CacheConstants.GLOBALLY + CacheConstants.ITEM_DETAILS, allEntries = true)
    public int insert(Item item) {
        return itemDAO.insert(item);
    }

    @Override
    @CacheEvict(value = CacheConstants.GLOBALLY + CacheConstants.ITEM_DETAILS, allEntries = true)
    public int update(Item item) {
        return itemDAO.updateById(item);
    }

    @Override
    @CacheEvict(value = CacheConstants.GLOBALLY + CacheConstants.ITEM_DETAILS, allEntries = true)
    public int deleteById(String id) {
        return itemDAO.deleteById(id);
    }

}