package com.bit.jinggong.service.trade.feign;

import com.bit.jinggong.service.base.dto.MemberDto;
import com.bit.jinggong.service.trade.feign.fallback.UcenterMemberServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "service-ucenter", fallback = UcenterMemberServiceFallback.class)
public interface UcenterMemberService {

    @GetMapping("/api/ucenter/member/inner/get-member-dto/{memberId}")
    MemberDto getMemberDtoByMemberId(@PathVariable(value = "memberId") String memberId);
}
