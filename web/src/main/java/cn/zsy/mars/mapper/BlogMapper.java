package cn.zsy.mars.mapper;

import cn.zsy.mars.entity.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface BlogMapper {

    Blog selectBlogById(int id);

    int selectBlogCount();

    Map<String, Object> selectBlogByIdWithMap(int id);

    List<Blog> selectBlogList(String old);

    List<Blog> selectBlogByNameAndOld(Blog blog);

    List<Blog> selectBlogByName(@Param("vo") Blog blog);

    boolean insertBlog(Blog blog);

    boolean deleteBlog(int id);

    boolean updateBlog(Blog blog);

}
