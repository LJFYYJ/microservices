package com.bit.jinggong.service.statistics.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bit.jinggong.common.base.result.R;
import com.bit.jinggong.service.statistics.entity.Daily;
import com.bit.jinggong.service.statistics.feign.UcenterMemberService;
import com.bit.jinggong.service.statistics.mapper.DailyMapper;
import com.bit.jinggong.service.statistics.service.DailyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 网站统计日数据 服务实现类
 * </p>
 *
 * @author YhmWrh
 * @since 2021-01-10
 */
@Service
public class DailyServiceImpl extends ServiceImpl<DailyMapper, Daily> implements DailyService {
    @Autowired
    private UcenterMemberService ucenterMemberService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createStatisticsByDay(String day) {

        //如果当日统计信息已存在，则删除记录
        QueryWrapper<Daily> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("date_calculated", day);
        baseMapper.delete(queryWrapper);

        //远程获取了注册用户数的统计结果
        R r = ucenterMemberService.countRegisterNum(day);
        Integer registerNum = (Integer)r.getData().get("registerNum");

        int loginNum = RandomUtils.nextInt(100, 200);
        int videoViewNum = RandomUtils.nextInt(100, 200);
        int courseNum = RandomUtils.nextInt(100, 200);

        //创建统计数据对象
        Daily daily = new Daily();
        daily.setRegisterNum(registerNum);
        daily.setLoginNum(loginNum);
        daily.setVideoViewNum(videoViewNum);
        daily.setCourseNum(courseNum);
        daily.setDateCalculated(day);
        baseMapper.insert(daily);
    }

    @Override
    public Map<String, Map<String, Object>> getChartData(String begin, String end) {

//        学员登录数统计
        Map<String, Object> registerNum = this.getChartDataByType(begin, end, "register_num");
//        学员注册数统计
        Map<String, Object> loginNum = this.getChartDataByType(begin, end, "login_num");
//        课程播放数统计
        Map<String, Object> videoViewNum = this.getChartDataByType(begin, end, "video_view_num");
//        每日新增课程数统计
        Map<String, Object> courseNum = this.getChartDataByType(begin, end, "course_num");

        Map<String, Map<String, Object>> map = new HashMap<>();
        map.put("registerNum", registerNum);
        map.put("loginNum", loginNum);
        map.put("videoViewNum", videoViewNum);
        map.put("courseNum", courseNum);

        return map;
    }

    /**
     * 根据时间和要查询的列查询数据
     * @param begin
     * @param end
     * @param type 要查询的列名
     * @return
     */
    private Map<String, Object> getChartDataByType(String begin, String end, String type){

        Map<String, Object> map = new HashMap<>();

        List<String> xList = new ArrayList<>(); //日期列表
        List<Integer> yList = new ArrayList<>(); //数据列表

        QueryWrapper<Daily> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("date_calculated", type);
        queryWrapper.between("date_calculated", begin, end);

        List<Map<String, Object>> mapsData = baseMapper.selectMaps(queryWrapper);
        for (Map<String, Object> data : mapsData) {
            String dateCalculated = (String)data.get("date_calculated");
            xList.add(dateCalculated);

            Integer count = (Integer)data.get(type);
            yList.add(count);
        }

        map.put("xData", xList);
        map.put("yData", yList);
        return map;
    }
}
