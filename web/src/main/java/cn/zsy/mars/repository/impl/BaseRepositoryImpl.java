package cn.zsy.mars.repository.impl;


import cn.zsy.mars.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;


@Repository
public class BaseRepositoryImpl implements BaseRepository {

	@Autowired
	private DataSource dataSource;
	
	
    public void save() {
        System.out.println("BaseRepositoryImpl....." + dataSource.getClass());
    }

}
