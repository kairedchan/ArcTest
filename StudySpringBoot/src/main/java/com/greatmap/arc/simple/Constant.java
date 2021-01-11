package com.greatmap.arc.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Company: 武汉天耀宏图科技有限公司
 * Project name: ArcTest
 * Create Time: 2021-01-08
 *
 * @author 陈凯红 chenkaihong@greatemap.com.cn
 * Description
 **/
public class Constant {
    
    public static String pgTableNameStr = "pg_statistic,pg_foreign_table,pg_authid,pg_user_mapping,pg_subscription,pg_largeobject,pg_type,pg_attribute,pg_proc,pg_class,pg_attrdef,pg_constraint,pg_inherits,pg_index,pg_operator,pg_opfamily,pg_opclass,pg_am,pg_amop,pg_amproc,pg_language,pg_largeobject_metadata,pg_aggregate,pg_statistic_ext,pg_rewrite,pg_trigger,pg_event_trigger,pg_description,pg_cast,pg_enum,pg_namespace,pg_conversion,pg_depend,pg_database,pg_db_role_setting,pg_tablespace,pg_pltemplate,pg_auth_members,pg_shdepend,pg_shdescription,pg_ts_config,pg_ts_config_map,pg_ts_dict,pg_ts_parser,pg_ts_template,pg_extension,pg_foreign_data_wrapper,pg_foreign_server,pg_policy,pg_replication_origin,pg_default_acl,pg_init_privs,pg_seclabel,pg_shseclabel,pg_collation,pg_partitioned_table,pg_range,pg_transform,pg_sequence,pg_publication,pg_publication_rel,pg_subscription_rel,sql_features,sql_implementation_info,sql_languages,sql_packages,sql_parts,sql_sizing,sql_sizing_profiles";
    public static List<String> PGTABLE_NAME = new ArrayList<>();

    public static Integer DELETE_CODE = 1;
    public static Integer INSERT_CODE = 2;
    // 数据库每次插入大小限制
    public static Integer INSERT_SIZE = 1000;

    
    static {
        PGTABLE_NAME = Arrays.asList(pgTableNameStr.split(","));
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    
}
