package com.inet.code.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

/**
 * 新增图片的实体类
 *
 * @author HCY
 * @since 2020/12/24 下午 03:36
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("新增图片的实体类")
public class PhotoInsertDomain {
    /**
     * 图片
     */
    @ApiModelProperty("图片文件")
    private String file;

    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    private String photoMobile;
}
