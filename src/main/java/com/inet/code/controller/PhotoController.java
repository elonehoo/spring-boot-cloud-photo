package com.inet.code.controller;


import cn.hutool.bloomfilter.BitMapBloomFilter;
import cn.hutool.bloomfilter.bitMap.BitMap;
import com.baomidou.mybatisplus.extension.api.R;
import com.inet.code.entity.dto.PhotoInsertDomain;
import com.inet.code.entity.po.Photo;
import com.inet.code.result.Result;
import com.inet.code.service.PhotoService;
import com.inet.code.utils.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author WSQ
 * @since 2020-12-24
 */
@RestController
@RequestMapping("/base")
@CrossOrigin
@Api(tags = {"图片的基本操作"})
public class PhotoController {

    @Resource
    private PhotoService photoService;

    /**
     * 查看该手机号码所有的图片
     *
     * @author WSQ
     * @since 2020/12/24 下午 03:35
     * @param mobile: 手机号码
     * @return com.inet.code.result.Result
    */
    @ApiOperation("查看该手机号码所有的图片")
    @ApiImplicitParams({
            @ApiImplicitParam(name="mobile",value="手机号码",dataType="String", paramType = "query"),
    })
    @GetMapping("/listPhoto")
    public Result getPhoto(@RequestParam(value = "mobile",defaultValue = "") String mobile){
        return photoService.getListPhoto(
                 mobile
                ,"/cloud/base/photo");
    }

    /**
     * 新增图片
     *
     * @author HCY
     * @since 2020/12/24 下午 03:54
     * @return com.inet.code.result.Result
    */
    @ApiOperation("新增图片")
    @PostMapping("/photo")
    public Result postPhoto(@RequestBody PhotoInsertDomain photoInsertDomain){
        String path = "/cloud/base/photo";
//        return new Result().result200(photoInsertDomain.getFile(),path);
       //base64格式前头
        String dataPrix = "";
        //实体部分数据
        String data = "";
        String file = photoInsertDomain.getFile();
        if(file==null||"".equals(file)){
            return new Result().result401("上传失败，上传图片数据为空",path);
        }else {
            //将字符串分成数组
            String [] d = file.split("base64,");
            if(d != null && d.length == 2){
                dataPrix = d[0];
                data = d[1];
            }else {
                return new Result().result401("上传失败，数据不合法",path);
            }
        }
        //图片后缀，用以识别哪种格式数据
        String suffix = "";
        //data:image/jpeg;base64,base64编码的jpeg图片数据
        if("data:image/jpeg;".equalsIgnoreCase(dataPrix)){
            suffix = ".jpg";
        }else if("data:image/x-icon;".equalsIgnoreCase(dataPrix)){
            //data:image/x-icon;base64,base64编码的icon图片数据
            suffix = ".ico";
        }else if("data:image/gif;".equalsIgnoreCase(dataPrix)){
            //data:image/gif;base64,base64编码的gif图片数据
            suffix = ".gif";
        }else if("data:image/png;".equalsIgnoreCase(dataPrix)){
            //data:image/png;base64,base64编码的png图片数据
            suffix = ".png";
        }else if ("data:image/jpg;".equalsIgnoreCase(dataPrix)){
            suffix = ".jpg";
        }else {
            return new Result().result401("上传图片格式不合法",path);
        }
        String uuid =  UUID.randomUUID().toString();
        String tempFileName=uuid+suffix;
        //新生成的图片
        String imgFilePath = FileUtils.UPLOAD_REST_FILE_PATH + "/" + tempFileName;
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            //Base64解码
            byte[] b = decoder.decode(data.replace(" ","").replaceAll("\r\n|\r|\n", "")) ;
            for(int i=0;i<b.length;++i) {
                if(b[i]<0) {
                    //调整异常数据
                    b[i]+=256;
                }
            }
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            String imgUrl=FileUtils.REST_URL + tempFileName;
            Photo photo = new Photo();
            photo.setPhotoMobile(photoInsertDomain.getPhotoMobile());
            photo.setPhotoUrl(imgUrl);
            if (photoService.save(photo)) {
                return new Result().result200("成功",path);
            }else {
                return new Result().result500("失败",path);
            }
        } catch (Exception e) {
            return new Result().result500(e.getMessage(),path);
        }
    }

    /**
     * 删除图片
     *
     * @author WSQ
     * @since 2020/12/24 下午 04:08
     * @param photoId: 图片序号
     * @return com.inet.code.result.Result
    */
    @ApiOperation("删除图片")
    @ApiImplicitParams({
            @ApiImplicitParam(name="photoId",value="图片序号",dataType="String", paramType = "query"),
    })
    @DeleteMapping("/delPhoto")
    public Result deletePhoto(@RequestParam(value = "photoId",defaultValue = "") String photoId){
        return photoService.getDeletePhoto(
                 photoId
                ,"/cloud/base/photo");
    }

}
