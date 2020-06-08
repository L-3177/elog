package com.l_3177.task;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.l_3177.PersonEntity;
import com.l_3177.PhoneDataEntity;
import com.l_3177.util.HttpUtils;
import com.l_3177.util.JsonUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Async
public class GetPhoneTask {



    public void getPhone(File file){

        ImportParams params = new ImportParams();
        List<PersonEntity> list = null;
        list = ExcelImportUtil.importExcel(file, PersonEntity.class, params);

        try {
            for (int i = 0; i < list.size(); i++){
                System.out.println("获取第"+i+"个数据");
                PersonEntity entity = list.get(i);
                Map<String, String> param = new HashMap<>(1);
                param.put("sfzmhm",entity.getCardNo());
                String content = HttpUtils.postFormParams("http://gzjjwx.gzjd.gov.cn/BusinessApi/CxyAPIServerWithAuthToken/index.php?/emember/RemoteUsrRegNew/getUserPhone"
                        , param);
                    PhoneDataEntity phoneDataEntity = JsonUtils.parse(content, PhoneDataEntity.class);
                    entity.setJjPhone(phoneDataEntity.getData().toString());
            }
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams()
                    , PersonEntity.class, list);
            FileOutputStream os = new FileOutputStream(file);
            workbook.write(os);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("全部数据获取成功。");
    }

}
