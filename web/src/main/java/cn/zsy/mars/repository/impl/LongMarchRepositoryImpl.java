package cn.zsy.mars.repository.impl;

import cn.zsy.mars.entity.LongMarchEntity;
import cn.zsy.mars.mapper.LongMarchMapper;
import cn.zsy.mars.repository.LongMarchRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
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
    public List<LongMarchEntity> queryPage(LongMarchEntity longMarchEntity) throws Exception {
        //获取第1页，10条内容，默认查询总数count
//        PageHelper.startPage(1, 10);
        PageHelper.startPage(4, 2);

        //紧跟着的第一个select方法会被分页
        List<LongMarchEntity> list = longMarchMapper.query(longMarchEntity);
        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(list);
        return page.getList();
    }

    @Override
    public int insert(LongMarchEntity longMarchEntity) throws Exception {
        return longMarchMapper.insert(longMarchEntity);
    }

    @Override
    public int insertMySQL(LongMarchEntity longMarchEntity) throws Exception {
        return longMarchMapper.insertMysql(longMarchEntity);
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
