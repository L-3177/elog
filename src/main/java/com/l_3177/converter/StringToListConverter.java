package com.l_3177.converter;

import com.l_3177.PersonEntity;
import com.l_3177.util.JsonUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class StringToListConverter implements Converter<String, List<PersonEntity>> {

    @Override
    @SuppressWarnings("unchecked")
    public List<PersonEntity> convert(String s) {
        List<PersonEntity> list = new ArrayList<PersonEntity>();
        try {
            list = JsonUtils.parseToCollection(s, List.class,PersonEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
