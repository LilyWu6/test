package com.annaru.queue.service.impl;

import com.annaru.queue.mapper.SysRoleResourceMapper;
import com.annaru.queue.model.SysRoleResource;
import com.annaru.queue.service.ISysRoleResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色资源表
 *
 * @author TuMinglong
 * @date 2018-12-11 11:35:15
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleResourceServiceImpl extends ServiceImpl<SysRoleResourceMapper, SysRoleResource> implements ISysRoleResourceService {

    @Override
    public List<Long> selectResourceIdListByRoleId(Long roleId) {
        return this.baseMapper.selectResourceIdListByRoleId(roleId);
    }

    @Override
    public void saveOrUpdateRoleResource(Long roleId, List<Long> resourceIdList) {
        //先删除角色与菜单关系
        Map<String, Object> params = new HashMap<>();
        params.put("role_id", roleId);
        this.removeByMap(params);
        if (resourceIdList.isEmpty() || resourceIdList.size() == 0) {
            return;
        }
        //保存角色与菜单关系
        List<SysRoleResource> list = new ArrayList<>(resourceIdList.size());
        for (Long resourceId : resourceIdList) {
            SysRoleResource sysRoleResource = new SysRoleResource();
            sysRoleResource.setRoleId(roleId);
            sysRoleResource.setResourceId(resourceId);
            list.add(sysRoleResource);
        }
        this.saveBatch(list);
    }

    @Override
    public void deleteBatch(Long[] roleIds) {
        this.baseMapper.deleteBatch(roleIds);
    }

    @Override
    public List<SysRoleResource> selectResourceList(Map<String, Object> params) {
        return this.baseMapper.selectResourceList(params);
    }

    @Override
    public List<SysRoleResource> selectResourceNodeListByRoleId(Long roleId) {
        return this.baseMapper.selectResourceNodeListByRoleId(roleId);
    }

}
