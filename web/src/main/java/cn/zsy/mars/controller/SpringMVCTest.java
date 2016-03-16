package cn.zsy.mars.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {

    private static final String SUCCESS = "success";



    /**
     * 了解:
     *
     * @CookieValue: 映射一个 Cookie 值. 属性同 @RequestParam
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
        System.out.println("testCookieValue: sessionId: " + sessionId);
        return SUCCESS;
    }

    /**
     * 了解: 映射请求头信息 用法同 @RequestParam
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(
            @RequestHeader(value = "Accept-Language") String al) {
        System.out.println("testRequestHeader, Accept-Language: " + al);
        return SUCCESS;
    }

    /**
     * @RequestParam 来映射请求参数.
     * value 值即请求参数的参数名
     * required 该参数是否必须. 默认为 true
     * defaultValue 请求参数的默认值
     */
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(
            @RequestParam(value = "username") String un,
            @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
        System.out.println("testRequestParam, username: " + un + ", age: " + age);
        return SUCCESS;
    }


    /**
     * Rest 风格的 URL. 以 CRUD 为例: 新增: /order POST 修改: /order/1 PUT update?id=1 获取:
     * /order/1 GET get?id=1 删除: /order/1 DELETE delete?id=1
     * <p>
     * 如何发送 PUT 请求和 DELETE 请求呢 ? 1. 需要配置 HiddenHttpMethodFilter 2. 需要发送 POST 请求
     * 3. 需要在发送 POST 请求时携带一个 name="_method" 的隐藏域, 值为 DELETE 或 PUT
     * <p>
     * 在 SpringMVC 的目标方法中如何得到 id 呢? 使用 @PathVariable 注解
     */
    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
    public String testRestPut(@PathVariable Integer id) {
        System.out.println("testRest Put: " + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable Integer id) {
        System.out.println("testRest Delete: " + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest", method = RequestMethod.POST)
    public String testRest() {
        System.out.println("testRest POST");
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
    public String testRest(@PathVariable Integer id) {
        System.out.println("testRest GET: " + id);
        return SUCCESS;
    }


    /**
     * @param id
     * @return
     * @PathVariable 可以来映射 URL 中的占位符到目标方法的参数中.
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println("testPathVariable: " + id);
        return SUCCESS;
    }


    @RequestMapping("/testAntPath/*/abc")
    public String testAntPath() {
        System.out.println("testAntPath");
        return SUCCESS;
    }

    /**
     * 了解: 可以使用 params 和 headers 来更加精确的映射请求. params 和 headers 支持简单的表达式.
     *
     * @return
     */
    @RequestMapping(value = "/testParamsAndHeaders", params = {"username",
            "age!=10"}, headers = {"Accept-Language=zh-CN,zh;q=0.8"})
    public String testParamsAndHeaders() {
        System.out.println("testParamsAndHeaders");
        return SUCCESS;
    }


    /**
     * 常用: 使用 method 属性来指定请求方式
     */
    @RequestMapping(value = "/testMethod", method = {RequestMethod.POST, RequestMethod.GET})
    public String testMethod() {
        System.out.println("testMethod");
        return SUCCESS;
    }

    /**
     * 1. @RequestMapping 除了修饰方法, 还可来修饰类 2. 1). 类定义处: 提供初步的请求映射信息。相对于 WEB 应用的根目录
     * 2). 方法处: 提供进一步的细分映射信息。 相对于类定义处的 URL。若类定义处未标注 @RequestMapping，则方法处标记的 URL
     * 相对于 WEB 应用的根目录
     */
    @RequestMapping("/testRequestMapping")
    public String testRequestMapping() {
        System.out.println("testRequestMapping");
        return SUCCESS;
    }

}
