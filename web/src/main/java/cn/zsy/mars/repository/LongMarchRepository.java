package cn.zsy.mars.repository;

import cn.zsy.mars.entity.LongMarchEntity;

import java.util.List;

public interface LongMarchRepository {


    int count(LongMarchEntity longMarchEntity) throws Exception;

    /**
     * 查询
     *
     * @param longMarchEntity
     * @return
     */
    List<LongMarchEntity> query(LongMarchEntity longMarchEntity) throws Exception;

    /**
     * 分页查询
     *
     * @return
     * @throws Exception
     */
    List<LongMarchEntity> queryPage() throws Exception;

    /**
     * 增加
     *
     * @param longMarchEntity
     */
    void insert(LongMarchEntity longMarchEntity) throws Exception;

    /**
     * 修改
     *
     * @param longMarchEntity
     */
    void update(LongMarchEntity longMarchEntity) throws Exception;

    /**
     * 删除
     *
     * @param ids
     */
    void delete(List<Long> ids) throws Exception;

}
