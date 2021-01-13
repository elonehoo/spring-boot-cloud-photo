package com.inet.code.service.impl;

import cn.hutool.core.lang.Validator;
import com.inet.code.entity.dto.PhotoInsertDomain;
import com.inet.code.entity.po.Photo;
import com.inet.code.mapper.PhotoMapper;
import com.inet.code.result.Result;
import com.inet.code.service.PhotoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inet.code.utils.FileUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.UUID;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HCY
 * @since 2020-12-24
 */
@Service
public class PhotoServiceImpl extends ServiceImpl<PhotoMapper, Photo> implements PhotoService {

    @Resource
    private PhotoMapper photoMapper;


    /**
     * 通过手机号码查询所有的图片集合
     *
     * @author HCY
     * @since 2020/12/24 下午 03:25
     * @param mobile: 手机号码
     * @param path: URL路径
     * @return com.inet.code.result.Result
     */
    @Override
    public Result getListPhoto(String mobile, String path) {
        return new Result().result200(
                 photoMapper.getList(mobile)
                ,path);
    }

    /**
     * 新增手机号码照片
     *
     * @author HCY
     * @since 2020/12/24 下午 03:41
     * @param photoInsertDomain: 新增图片的实体类
     * @param path: URL路径
     * @return com.inet.code.result.Result
    */
    @Override
    public Result getInsertPhoto(PhotoInsertDomain photoInsertDomain, String path) {
       return null;
    }

    /**
     * 删除照片
     *
     * @author HCY
     * @since 2020/12/24 下午 04:00
     * @param photoId: 照片序号
     * @param path: URL路径
     * @return com.inet.code.result.Result
     */
    @Override
    public Result getDeletePhoto(String photoId, String path) {
        if (this.removeById(photoId)) {
            return new Result().result200("删除成功",path);
        }
        return new Result().result500("删除失败",path);
    }
}
