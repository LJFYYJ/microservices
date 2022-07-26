package com.bit.jinggong.service.trade.feign.fallback;

import com.bit.jinggong.common.base.result.R;
import com.bit.jinggong.service.base.dto.CourseDto;
import com.bit.jinggong.service.trade.feign.EduCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EduCourseServiceFallback implements EduCourseService {
    @Override
    public CourseDto getCourseDtoById(String courseId) {
        log.info("熔断保护");
        return null;
    }

    @Override
    public R updateBuyCountById(String courseId) {
        log.error("熔断器被执行");
        return R.error();
    }
}
