package com.inet.code.entity.po;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 云相册实体类
 * </p>
 *
 * @author WSQ
 * @since 2020-12-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tbl_photo")
public class Photo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 图片的主键(UUID)
     */
    @TableId(value = "photo_id",type = IdType.ASSIGN_UUID)
    private String photoId;

    /**
     * 图片的URL路径
     */
    @TableField(value = "photo_url")
    private String photoUrl;

    /**
     * 手机号码
     */
    @TableField(value = "photo_mobile")
    private String photoMobile;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_modified",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtModified;


}
