package com.inet.code.mapper;

import com.inet.code.entity.po.Photo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inet.code.entity.vo.PhotoView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HCY
 * @since 2020-12-24
 */
@Mapper
public interface PhotoMapper extends BaseMapper<Photo> {

    /**
     * 通过手机号码查询用户的所有图片
     *
     * @author HCY
     * @since 2020/12/24 下午 03:30
     * @param mobile: 手机号码
     * @return java.util.List<com.inet.code.entity.vo.PhotoView>
    */
    List<PhotoView> getList(String mobile);
}
