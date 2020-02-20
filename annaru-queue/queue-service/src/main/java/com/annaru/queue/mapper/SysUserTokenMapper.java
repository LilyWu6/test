package com.annaru.queue.mapper;


import com.annaru.queue.model.SysUserToken;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 系统用户Token Mapper 接口
 * </p>
 *
 * @author TuMinglong
 * @since 2018-06-11
 */
public interface SysUserTokenMapper extends BaseMapper<SysUserToken> {

    SysUserToken selectByToken(String token);
}
