package cn.zsy.mars.service.impl;


import cn.zsy.mars.entity.LongMarchEntity;
import cn.zsy.mars.repository.LongMarchRepository;
import cn.zsy.mars.service.LongMarchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LongMarchServiceImpl implements LongMarchService {

    @Autowired
    LongMarchRepository longMarchRepository;

    @Override
    public int count() throws Exception {
        LongMarchEntity longMarchEntity = new LongMarchEntity();
        return longMarchRepository.count(longMarchEntity);
    }

    @Override
    public List<LongMarchEntity> query(LongMarchEntity longMarchEntity) throws Exception {
        List<LongMarchEntity> longMarchEntityList = longMarchRepository.query(longMarchEntity);
        return longMarchEntityList;
    }

    @Override
    public List<LongMarchEntity> queryPage(LongMarchEntity longMarchEntity) throws Exception {
        return longMarchRepository.queryPage(longMarchEntity);
    }

    @Override
    public int insert(LongMarchEntity longMarchEntity) throws Exception {
        return longMarchRepository.insert(longMarchEntity);
    }

    @Override
    public int insertMySQL(LongMarchEntity longMarchEntity) throws Exception {
        return longMarchRepository.insertMySQL(longMarchEntity);
    }

    @Override
    public void update(LongMarchEntity longMarchEntity) throws Exception {
        longMarchRepository.update(longMarchEntity);
    }

    @Override
    public void delete(List<Long> ids) throws Exception {
        longMarchRepository.delete(ids);
    }
}
