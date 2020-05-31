package com.l_3177.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    private JsonUtils() {
    }

    /**
     * Serialize any Java value as a String.
     */
    public static String generate(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    /**
     * Deserialize JSON content from given JSON content String.
     */
    public static <T> T parse(String content, Class<T> valueType) throws IOException {
        return mapper.readValue(content, valueType);
    }


    /**
     *  json转换成集合
     * @param content
     * @param collectionClass
     * @param eleClasses
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T parseToCollection(String content,Class<T> collectionClass, Class<?>... eleClasses) throws IOException {
        JavaType javaType = mapper.getTypeFactory().constructParametricType(collectionClass, eleClasses);
        return mapper.readValue(content, javaType);
    }

}
