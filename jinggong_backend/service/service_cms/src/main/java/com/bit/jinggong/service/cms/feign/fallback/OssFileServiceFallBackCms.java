package com.bit.jinggong.service.cms.feign.fallback;

import com.bit.jinggong.common.base.result.R;
import com.bit.jinggong.service.cms.feign.OssFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OssFileServiceFallBackCms implements OssFileService {

    @Override
    public R removeFile(String url) {
        log.info("熔断保护");
        return R.error();
    }

}
