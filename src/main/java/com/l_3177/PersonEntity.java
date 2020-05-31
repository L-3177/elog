package com.l_3177;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PersonEntity {


    public PersonEntity() {
    }

    public PersonEntity( String name, String cardNo) {
        this.name = name;
        this.cardNo = cardNo;
    }


    @Excel(name="姓名")
    @JsonProperty("secName")
    private String name;

    @Excel(name="身份证",width = 30)
    @JsonProperty("idNo")
    private String cardNo;

}
