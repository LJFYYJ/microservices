package com.bit.jinggong.service.edu.feign.fallback;

import com.bit.jinggong.common.base.result.R;
import com.bit.jinggong.service.edu.feign.VodMediaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class VodMediaServiceFallBack implements VodMediaService {

    @Override
    public R removeVideo(String vodId) {
        log.info("熔断保护");
        return R.error();
    }

    @Override
    public R removeVideoByIdList(List<String> videoIdList) {
        log.info("熔断保护");
        return R.error();
    }


}
