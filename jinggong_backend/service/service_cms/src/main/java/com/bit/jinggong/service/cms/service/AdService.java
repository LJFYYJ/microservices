package com.bit.jinggong.service.cms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bit.jinggong.service.cms.entity.Ad;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bit.jinggong.service.cms.entity.vo.AdVo;

import java.util.List;

/**
 * <p>
 * 广告推荐 服务类
 * </p>
 *
 * @author YhmWrh
 * @since 2021-01-09
 */
public interface AdService extends IService<Ad> {

    IPage<AdVo> selectPage(Long page, Long limit);

    boolean removeAdImageById(String id);

    List<Ad> selectByAdTypeId(String adTypeId);
}
