package com.inet.code.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 展示图片的实体类
 *
 * @author WSQ
 * @since 2020/12/24 下午 03:27
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("展示图片的实体类")
public class PhotoView implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 图片的主键(UUID)
     */
    @ApiModelProperty("图片的主键")
    private String photoId;

    /**
     * 图片的URL路径
     */
    @ApiModelProperty("图片的URL路径")
    private String photoUrl;
}
