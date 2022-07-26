package com.bit.jinggong.service.statistics.feign;

import com.bit.jinggong.common.base.result.R;
import com.bit.jinggong.service.statistics.feign.fallback.UcenterMemberServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-ucenter", fallback = UcenterMemberServiceFallBack.class)
public interface UcenterMemberService {

    @GetMapping("/admin/ucenter/member/count-register-num/{day}")
    R countRegisterNum(@PathVariable("day") String day);
}
