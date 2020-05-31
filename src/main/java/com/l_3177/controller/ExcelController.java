package com.l_3177.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.l_3177.PersonEntity;
import com.l_3177.core.ResultEnum;
import com.l_3177.exception.CustomException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class ExcelController implements Serializable {

    @Value("${export-path}")
    private String path;


//      把数据写成excel表格
    @RequestMapping("/export")
    public void exportExcel(@RequestParam(value = "json") List<PersonEntity> list, HttpServletResponse response) throws Exception {

        if(CollectionUtils.isEmpty(list)){
            throw new CustomException(ResultEnum.ParamException.getCode(),ResultEnum.ParamException.getMsg());
        }

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("持卡人信息", "sheet1")
                , PersonEntity.class, list);

        File file = new File(path+System.currentTimeMillis()+".xlsx");
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream os = new FileOutputStream(file);
        workbook.write(os);
        os.close();

        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(System.currentTimeMillis()+".xlsx", "UTF-8"));

        FileInputStream fis = new FileInputStream(file);
        StreamUtils.copy(fis, response.getOutputStream());
        fis.close();
        file.delete();

    }
}
