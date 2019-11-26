package com.bishe.main;

import com.bishe.main.dto.BlogRestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author Kirito
 * @Date 2019/11/26 9:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.bishe.main.dao")
public class RestTest {
    @Test
    public void test(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8082/kirito/blogs/3593738f-32b7-4864-8497-98b1c9dfef15";
        Map<String, Object> modelMap = restTemplate.getForObject(url, Map.class);
        System.out.println(modelMap.get("success"));
        List<BlogRestDto> blogRestDtos = (List)modelMap.get("blogDtos");
        System.out.println(blogRestDtos.toString());
    }
}
