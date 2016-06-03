package cn.zsy.mars.repository.impl;

import cn.zsy.mars.entity.Blog;
import cn.zsy.mars.mapper.BlogMapper;
import cn.zsy.mars.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;


@Repository
public class BaseRepositoryImpl implements BaseRepository {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BlogMapper blogMapper;


    public void save() {
        System.out.println("BaseRepositoryImpl....." + dataSource.getClass());
//        Blog blog = blogMapper.selectBlogById(1);
//        System.out.println(blog.toString());
//        System.out.println("-----------------------------------");
//        int count = blogMapper.selectBlogCount();
//        System.out.println("----count: " + count);
//        System.out.println("-----------------------------------");
//        Map<String, Object> map = blogMapper.selectBlogByIdWithMap(2);
//        System.out.println("----map: " + map.toString() + "\t" + map.get("name"));
//        System.out.println("-----------------------------------");
//        List<Blog> blogs = blogMapper.selectBlogList("2");
//        System.out.println("----blogs: " + blogs.toString() + "\tsize: " + blogs.size());
//        System.out.println("-----------------------------------");
        Blog blog1 = new Blog();
        blog1.setName("谢世会");
        blog1.setOld("26");
        List<Blog> blogs1 = blogMapper.selectBlogByNameAndOld(blog1);
        System.out.println("----blogs1: " + blogs1.toString() + "\tsize: " + blogs1.size());
        System.out.println("-----------------------------------");
//        Blog blog2 = new Blog();
//        blog2.setName("谢世会");
//        List<Blog> blogs2 = blogMapper.selectBlogByName(blog2);
//        System.out.println("----blogs2: " + blogs2.toString() + "\tsize: " + blogs2.size());
//        System.out.println("-----------------------------------");
//        Blog blog3 = new Blog();
//        blog3.setName("github");
//        blog3.setOld("18");
//        boolean flag = blogMapper.insertBlog(blog3);
//        System.out.println("------flag:>" + flag);
//        System.out.println("-----------------------------------------");
//        boolean flag1 = blogMapper.deleteBlog(6);
//        System.out.println("------flag1:>" + flag1);
//        System.out.println("-----------------------------------------");
//        Blog blog4 = new Blog();
//        blog4.setId(4);
//        blog4.setName("Github");
//        blog4.setOld("27");
//        boolean flag2 = blogMapper.updateBlog(blog4);
//        System.out.println("------flag2:>" + flag2);
        System.out.println("-------------------------------------------");
        Blog blog = new Blog();
//        blog.setId(1);
        blog.setOld("27");
//        blog.setName("谢世会");
        List<Blog> blogsA = blogMapper.selectBlog(blog);
        System.out.println(blogsA.toString());
    }

}
