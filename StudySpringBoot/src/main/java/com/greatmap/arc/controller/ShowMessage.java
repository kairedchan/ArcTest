package com.greatmap.arc.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greatmap.arc.entity.DataChange;
import com.greatmap.arc.service.IDataChangeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Company: 武汉天耀宏图科技有限公司
 * Project name: ArcTest
 * Create Time: 2021-01-11
 *
 * @author 陈凯红 chenkaihong@greatemap.com.cn
 * Description
 **/
@RestController
@RequestMapping("/showData")
public class ShowMessage {

    @Autowired
    private IDataChangeService dataChangeService;

    @RequestMapping("/list")
    @ApiOperation("查询修改记录")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pageIndex", defaultValue = "1", value = "页数"),
        @ApiImplicitParam(name = "pageSize", defaultValue = "100", value = "每页大小")
    })
    public R show(@RequestParam(defaultValue = "1") String pageIndex,
                  @RequestParam(defaultValue = "100") String pageSize) {
        System.out.println(String.format("接受参数:%s,%s", pageIndex, pageSize));
        IPage<DataChange> dataChangePage = new Page<>(Long.valueOf(pageIndex), Long.valueOf(pageSize));

        QueryWrapper<DataChange> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("change_date");
        dataChangeService.page(dataChangePage, wrapper);
        return R.ok(dataChangePage);
    }

}
