package com.java8.demo1.controller;

import com.java8.demo1.model.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.java8.demo1.controller
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2019/1/10.
 */

@Api("环境变量的添加")
@RestController
public class EnvController {


    @Value("${test1:456}")
    private String test1;



    @GetMapping("/env")
    public String getEnv(){
        Person person = null;
        if (ObjectUtils.allNotNull(person,person.name)){
            return "aaaa";
        }
        return "bbbb";
    }

}
