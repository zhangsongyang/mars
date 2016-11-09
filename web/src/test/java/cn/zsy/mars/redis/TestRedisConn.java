package cn.zsy.mars.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class TestRedisConn {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() {
        System.out.println("+++++++++++++");
        String str = stringRedisTemplate.opsForValue().get("zhangsongyang");
        Map<Object, Object> map = stringRedisTemplate.opsForHash().entries("website");
        List<String> list = stringRedisTemplate.opsForList().range("listname", 0, -1);
        Set<String> set = stringRedisTemplate.opsForSet().members("language");
        System.out.println("++++++++++++++==" + str);
        System.out.println("+++++++++++++" + map.get("google"));
        System.out.println("%%%%%%%%%%%%%%" + list.toString());
        System.out.println("^^^^^^^^^^^^^^" + set.toString());
    }

}
