package cn.zsy.mars.repository.impl;

import cn.zsy.mars.entity.LongMarchEntity;
import cn.zsy.mars.mapper.LongMarchMapper;
import cn.zsy.mars.repository.LongMarchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LongMarchRepositoryImpl implements LongMarchRepository {

    @Autowired
    private LongMarchMapper longMarchMapper;

    @Override
    public int count(LongMarchEntity longMarchEntity) throws Exception {
        return longMarchMapper.count(longMarchEntity);
    }

    @Override
    public List<LongMarchEntity> query(LongMarchEntity longMarchEntity) throws Exception {
        return longMarchMapper.query(longMarchEntity);
    }

    @Override
    public List<LongMarchEntity> queryPage() throws Exception {
        return longMarchMapper.queryPage();
    }

    @Override
    public void insert(LongMarchEntity longMarchEntity) throws Exception {
        longMarchMapper.insert(longMarchEntity);
    }

    @Override
    public void update(LongMarchEntity longMarchEntity) throws Exception {
        longMarchMapper.update(longMarchEntity);
    }

    @Override
    public void delete(List<Long> ids) throws Exception {
        longMarchMapper.delete(ids);
    }

}
