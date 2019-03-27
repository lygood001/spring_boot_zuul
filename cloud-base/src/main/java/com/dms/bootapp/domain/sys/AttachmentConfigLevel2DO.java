package com.dms.bootapp.domain.sys;

import com.dms.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * attachment config level2 (规范审查通过)(内置表内置数据)
 *
 * @author WSD
 * @email 939459508@qq.com
 * @date 2019-01-24 14:05:14
 */
@Component
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AttachmentConfigLevel2DO extends BaseDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //文件类别
    private String vFileType;
    //文件分类
    private String vClassType;
    //文件类别名称
    private String vFileTypeName;
    //文件磁盘路径
    private String vClassFilePath;
    //文件尺寸/大小(KB)
    private String vFileSize;
    //分辨率-长，单位px
    private String nPxLength;
    //分辨率-宽，单位px
    private String nPxWidth;
    //最多能插入几条
    private String nLimit;
    //备注
    private String vRemark;

}
