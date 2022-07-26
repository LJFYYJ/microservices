package com.bit.jinggong.service.statistics.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.bit.jinggong.service.base.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 网站统计日数据
 * </p>
 *
 * @author YhmWrh
 * @since 2021-01-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("statistics_daily")
@ApiModel(value="Daily对象", description="网站统计日数据")
public class Daily extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "统计日期")
    private String dateCalculated;

    @ApiModelProperty(value = "注册人数")
    private Integer registerNum;

    @ApiModelProperty(value = "登录人数")
    private Integer loginNum;

    @ApiModelProperty(value = "每日播放视频数")
    private Integer videoViewNum;

    @ApiModelProperty(value = "每日新增课程数")
    private Integer courseNum;


}
