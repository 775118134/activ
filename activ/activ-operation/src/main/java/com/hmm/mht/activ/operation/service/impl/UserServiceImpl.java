package com.hmm.mht.activ.operation.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmm.mht.activ.common.constant.CacheConstants;
import com.hmm.mht.activ.entity.user.User;
import com.hmm.mht.activ.operation.dao.UserDAO;
import com.hmm.mht.activ.operation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserDAO, User> implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional(readOnly = true)
    @Override
    @Cacheable(value = CacheConstants.GLOBALLY + CacheConstants.USER_DETAILS, unless = "#result == null")
    public List<User> findAll() {
        return userDAO.selectList(null);
    }

    @Transactional(readOnly = true)
    @Override
    @Cacheable(value = CacheConstants.GLOBALLY + CacheConstants.USER_DETAILS, key = "#id", unless = "#result == null")
    public User findById(String id) {
        return userDAO.selectById(id);
    }

    @Transactional(readOnly = true)
    @Override
    @Cacheable(value = CacheConstants.GLOBALLY + CacheConstants.USER_DETAILS, key = "#pageNum  + '_' + #pageSize", unless = "#result == null")
    public IPage<User> findByPage(int pageNum, int pageSize) {
        return userDAO.selectPage(new Page<>(pageNum, pageSize), null);
    }

    @Override
    @CacheEvict(value = CacheConstants.GLOBALLY + CacheConstants.USER_DETAILS, allEntries = true)
    public int insert(User user) {
        return userDAO.insert(user);
    }

    @Override
    @CacheEvict(value = CacheConstants.GLOBALLY + CacheConstants.USER_DETAILS, allEntries = true)
    public int update(User user) {
        return userDAO.updateById(user);
    }

    @Override
    @CacheEvict(value = CacheConstants.GLOBALLY + CacheConstants.USER_DETAILS, allEntries = true)
    public int deleteById(String id) {
        return userDAO.deleteById(id);
    }

}