package com.example.demo.main;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("test")
@Api(value = "test", description = "test api coded by leo jiang")
public class TestController {

    @RequestMapping(value="hello", method= RequestMethod.GET)
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @ApiOperation(value="打招呼", notes="输出success")
    public String show(String stuName) {
        return "success";
    }

    @RequestMapping(value="{id}", method=RequestMethod.POST)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value="查询ID", notes="输出success")
    public String show1( String id) {
        return "{result:\"success\"}";
    }
}