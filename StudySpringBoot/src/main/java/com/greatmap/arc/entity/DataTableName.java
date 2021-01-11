package com.greatmap.arc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 表名库,存储所有的表名
 * </p>
 *
 * @author ckh
 * @since 2021-01-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_data_table_name")
public class DataTableName implements Serializable {

    private static final long serialVersionUID = 1L;

    public DataTableName(Long id, String tableName) {
        this.id = id;
        this.tableName = tableName;
    }

    /**
     * 主键
     */
    private Long id;

    /**
     * 表的名称
     */
    private String tableName;


}
