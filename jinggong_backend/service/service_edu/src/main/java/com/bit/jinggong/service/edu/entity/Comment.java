package com.bit.jinggong.service.edu.entity;

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
 * 评论
 * </p>
 *
 * @author YhmWrh
 * @since 2021-01-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("edu_comment")
@ApiModel(value="Comment对象", description="评论")
public class Comment extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "课程id")
    private String courseId;

    @ApiModelProperty(value = "讲师id")
    private String teacherId;

    @ApiModelProperty(value = "会员id")
    private String memberId;

    @ApiModelProperty(value = "会员昵称")
    private String nickname;

    @ApiModelProperty(value = "会员头像")
    private String avatar;

    @ApiModelProperty(value = "评论内容")
    private String content;


}
