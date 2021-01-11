package com.greatmap.arc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ckh
 * @since 2021-01-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_data_change")
public class DataChange implements Serializable {

    private static final long serialVersionUID = 1L;

    public DataChange(Long id, Integer changeType, String tableName, String dataCtid, LocalDateTime changeDate) {
        this.id = id;
        this.changeType = changeType;
        this.tableName = tableName;
        this.dataCtid = dataCtid;
        this.changeDate = changeDate;
    }

    /**
     * 数据的主键
     */
    private Long id;

    /**
     * 数据的修改类型: 1为删除, 2为新增
     */
    private Integer changeType;

    /**
     * 改动的表的名称
     */
    private String tableName;

    /**
     * 修改的数据的唯一标识符
     */
    private String dataCtid;

    /**
     * 数据的修改时间
     */
    private LocalDateTime changeDate;


}
