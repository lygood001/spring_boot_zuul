package com.dms.bootapp.domain.sys;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class FileUploadDo implements Serializable {

    private  String FileType;
    private  String BIZID;
    private  String BIZTABLE;
    private  String VFILENAMEEXTE;
    private  String VFILEPATH;
    private  String VFILENAME;
    private  String Remake;
    private  String ID;
}
