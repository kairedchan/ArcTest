package com.greatmap.arc.simple;

import com.greatmap.arc.entity.TDataChange;
import com.greatmap.arc.entity.TDataTableName;
import com.greatmap.arc.mapper.bak.TResultStrMapper;
import com.greatmap.arc.mapper.recode.TDataChangeMapper;
import com.greatmap.arc.mapper.recode.TDataTableNameMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SampleTest {

//    @Autowired
    TDataChangeMapper tDataChangeMapper;

    @Autowired
    TResultStrMapper tResultStrMapper;

    @Autowired
    TDataTableNameMapper tDataTableNameMapper;
    
    @Test
    public void testSelect() {
        List<String> tResultStrs = tResultStrMapper.getTableName();
        
        System.out.println(tResultStrs.toString());

//        System.out.println(tDataChangeMapper.selectList(null));
        
        System.out.println(tDataTableNameMapper.getAllDate());
//        List<TDataChange> tDataChanges = tDataChangeMapper.selectList(null);
    }

}
