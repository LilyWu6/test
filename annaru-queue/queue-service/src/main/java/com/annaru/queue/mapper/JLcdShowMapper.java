package com.annaru.queue.mapper;

import com.annaru.queue.model.JLcdShow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * @Description 叫号表
 * @Author jyehui
 * @Date  2020-02-03 18:46:29
 */
public interface JLcdShowMapper extends BaseMapper<JLcdShow> {

    /**
    * 多表页面信息查询
    * @param page
    * @return
    */
    IPage<JLcdShow> selectDataPage(Page page);

}
