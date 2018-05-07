/**
 * @Title:  HelloController.java
 * @Package com.rh.spring.boot.blog.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author RH
 * @date  2018年4月8日 下午5:29:46
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
*/
package com.rh.spring.boot.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author RH
 * @date 2018年4月8日 下午5:29:46
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World !";
    }
}
