package com.bishe.main.controller;

import com.bishe.main.entity.Resume;
import com.bishe.main.entity.User;
import com.bishe.main.service.WorkService;
import com.bishe.main.util.MapUtil;
import com.bishe.main.vo.SelfDetailVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
/**
 * @author Kirito
 * @Date 2020/1/7 19:12
 */
@RestController
@RequestMapping("/work/api")
public class WorkController {
    @Autowired
    private WorkService workService;

    @PostMapping("/resume")
    @ApiOperation("生成简历")
    public Map<String, Object> generatorResume(@RequestBody SelfDetailVO selfDetailVO, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        User user = (User)request.getSession().getAttribute("user");
        String userId = user.getUserId();
        Integer code = workService.generatorPdf(selfDetailVO, userId);
        if (code == 200) {
            resultMap = MapUtil.sucMsg("简历生成成功！");
        } else {
            resultMap = MapUtil.errMsg("简历生成出错！");
        }
        return resultMap;
    }
}
