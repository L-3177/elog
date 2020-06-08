package com.l_3177.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.l_3177.PersonEntity;
import com.l_3177.core.ResultEnum;
import com.l_3177.exception.CustomException;
import com.l_3177.util.JsonUtils;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExcelController implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Value("${export-path}")
    private String path;


//      把数据写成excel表格
    @PostMapping("/export")
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
    //      把数据写成excel表格
        @GetMapping("/exportFromFile")
        public void exportExcelFromFile ( HttpServletRequest request, HttpServletResponse response) throws Exception {
            
            File json = new File("/root/RemoteWorking/src/main/resources/static/res/123.json");
            List<PersonEntity> list = new ArrayList<PersonEntity>();
            try {
                list = JsonUtils.parseFileToCollection(json, List.class,PersonEntity.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
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
