package com.annaru.queue.service;


import com.annaru.queue.model.SysLog;
import com.annaru.queue.result.PageParams;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 系统日志表
 *
 * @author TuMinglong
 * @date 2018-12-11 11:35:15
 */
public interface ISysLogService extends IService<SysLog> {

    /**
     * 多表页面信息查询
     *
     * @param params
     * @return
     */
    PageParams selectDataGrid(Map<String, Object> params);

    /**
     * 多表信息查询
     *
     * @param par
     * @return
     */
    List<SysLog> selectSysLogList(Map<String, Object> par);


}

