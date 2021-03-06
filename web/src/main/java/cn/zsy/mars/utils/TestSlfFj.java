package cn.zsy.mars.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSlfFj {

    private static final Logger logger = LoggerFactory.getLogger(TestSlfFj.class);

    public static void main(String[] args) {
        logger.error("asdf");
        logger.debug("This is debug message");
        logger.info("This is info message");
        logger.warn("This is warn message");
        logger.error("This is error message");
        Object[] array =  new String[]{"x", "y"};
        logger.info("{} is {}", array);
        logger.info("{1,2} is {}", "2");
    }

}
