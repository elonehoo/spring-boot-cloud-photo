package com.inet.code.service;

import com.inet.code.entity.dto.PhotoInsertDomain;
import com.inet.code.entity.po.Photo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.inet.code.result.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HCY
 * @since 2020-12-24
 */
public interface PhotoService extends IService<Photo> {

    /**
     * 通过手机号码查询所有的图片集合
     *
     * @author HCY
     * @since 2020/12/24 下午 03:25
     * @param mobile: 手机号码
     * @param path: URL路径
     * @return com.inet.code.result.Result
    */
    Result getListPhoto(String mobile, String path);

    /**
     * 新增手机号码照片
     *
     * @author HCY
     * @since 2020/12/24 下午 03:40
     * @param photoInsertDomain: 新增图片的实体类
     * @param path: URL路径
     * @return com.inet.code.result.Result
    */
    Result getInsertPhoto(PhotoInsertDomain photoInsertDomain, String path);

    /**
     * 删除照片
     *
     * @author HCY
     * @since 2020/12/24 下午 04:00
     * @param photoId: 照片序号
     * @param path: URL路径
     * @return com.inet.code.result.Result
    */
    Result getDeletePhoto(String photoId, String path);
}
