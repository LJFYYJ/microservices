package com.bit.jinggong.service.trade.feign;

import com.bit.jinggong.service.base.dto.CourseDto;
import com.bit.jinggong.service.trade.feign.fallback.EduCourseServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.bit.jinggong.common.base.result.R;

@Service
@FeignClient(value = "service-edu", fallback = EduCourseServiceFallback.class)
public interface EduCourseService {

    @GetMapping("/api/edu/course/inner/get-course-dto/{courseId}")
    CourseDto getCourseDtoById(@PathVariable(value = "courseId") String courseId);

    @GetMapping("/api/edu/course/inner/update-buy-count/{id}")
    R updateBuyCountById(String courseId);
}
