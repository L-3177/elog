package com.l_3177;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) 
public class PersonEntity {


    public PersonEntity() {
    }

    public PersonEntity( String name, String cardNo) {
        this.name = name;
        this.cardNo = cardNo;
    }


    @Excel(name="姓名")
    @JsonProperty("casName")
    private String name;

    @Excel(name="身份证",width = 30)
    @JsonProperty("casNum")
    private String cardNo;

    @Excel(name="邮箱",width = 25)
    @JsonProperty("casEmail")
    private String email;

    @Excel(name="单面电话",width = 20)
    @JsonProperty("casMobPho")
    private String phone;

    @Excel(name="催收手别")
    @JsonProperty("casClCount")
    private String count;

}
