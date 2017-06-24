package cn.zsy.mars.controller;

import cn.zsy.mars.entity.Person;
import cn.zsy.mars.utils.TestSlfFj;
import org.junit.Test;

import java.lang.reflect.Field;


public class SpringMVCTestTest {

    @Test
    public void testTestMethod() throws Exception {
        String className = TestSlfFj.class.getClass().getSimpleName();
//        System.out.println(className);
//        System.out.println(Object.class.getClass().getSimpleName());
//        System.out.println(TestSlfFj.class.getDeclaredFields());
        for (Field field :Person.class.getDeclaredFields()) {
            // 获取属性名称
            String fieldName = field.getName();
            System.out.println(fieldName);
        }
    }
}