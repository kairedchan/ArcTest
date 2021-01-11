package com.greatmap.arc.entity;

import lombok.Data;

/**
 * Company: 武汉天耀宏图科技有限公司
 * Project name: ArcTest
 * Create Time: 2021-01-11
 *
 * @author 陈凯红 chenkaihong@greatemap.com.cn
 * Description
 **/
@Data
public class ResultData {

    public String id;
    public String data;

    public ResultData() {
    }

    public ResultData(String id, String data) {
        this.id = id;
        this.data = data;
    }
}
