package com.annaru.queue.quartz.controller;

import com.annaru.queue.quartz.model.ScheduleJobLogEntity;
import com.annaru.queue.quartz.service.IScheduleJobLogService;
import com.annaru.queue.result.PageParams;
import com.annaru.queue.result.ResultMap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * @Description 定时任务日志
 * @Author TuMinglong
 * @Date 2019/1/18 15:59
 **/
@RestController
@RequestMapping("/sys/scheduleLog")
public class ScheduleJobLogController {
    @Autowired
    private IScheduleJobLogService scheduleJobLogService;

    /**
     * 定时任务日志列表
     */
    @GetMapping("/list")
    @RequiresPermissions("sys/schedule/log")
    public ResultMap list(@RequestParam Map<String, Object> params) {
        PageParams page = scheduleJobLogService.queryPage(params);

        return ResultMap.ok().put("page", page);
    }

    /**
     * 定时任务日志信息
     */
    @GetMapping("/info/{logId}")
    public ResultMap info(@PathVariable("logId") Long logId) {
        ScheduleJobLogEntity log = scheduleJobLogService.getById(logId);

        return ResultMap.ok().put("log", log);
    }
}
