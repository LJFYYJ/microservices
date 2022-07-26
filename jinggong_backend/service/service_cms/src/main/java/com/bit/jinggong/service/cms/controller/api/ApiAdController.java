package com.bit.jinggong.service.cms.controller.api;

import com.bit.jinggong.common.base.result.R;
import com.bit.jinggong.service.cms.entity.Ad;
import com.bit.jinggong.service.cms.service.AdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin //解决跨域问题
@Api(description = "广告推荐")
@RestController
@RequestMapping("/api/cms/ad")
@Slf4j
public class ApiAdController {

    @Autowired
    private AdService adService;

    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation("根据推荐位id显示广告推荐")
    @GetMapping("list/{adTypeId}")
    public R listByAdTypeId(@ApiParam(value = "推荐位id", required = true) @PathVariable String adTypeId) {

        List<Ad> adList = adService.selectByAdTypeId(adTypeId);
        return R.ok().data("items", adList);
    }

}
