package com.bit.jinggong.service.cms.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bit.jinggong.service.cms.entity.Ad;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bit.jinggong.service.cms.entity.vo.AdVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 广告推荐 Mapper 接口
 * </p>
 *
 * @author YhmWrh
 * @since 2021-01-09
 */
public interface AdMapper extends BaseMapper<Ad> {

    List<AdVo> selectPageByQueryWrapper(Page<AdVo> pageParam,  @Param(Constants.WRAPPER) QueryWrapper<AdVo> queryWrapper);
}
