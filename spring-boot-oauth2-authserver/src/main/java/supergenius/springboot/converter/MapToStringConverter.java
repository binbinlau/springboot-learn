package supergenius.springboot.converter;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author LiuBin
 * @Date 2019/9/24 15:26
 **/
//@Converter(autoApply = true) //应用到所有符合的实体属性上
@Converter
public class MapToStringConverter implements AttributeConverter<Map<String, Object>, String> {

    @Override
    public String convertToDatabaseColumn(Map<String, Object> stringObjectMap) {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
            jsonStr = mapperObj.writeValueAsString(stringObjectMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String s) {
        ObjectMapper mapperObj = new ObjectMapper();
        Map<String, Object> resultMap = new HashMap<>();
        try {
            resultMap = mapperObj.readValue(s, new TypeReference<HashMap<String, Object>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultMap;
    }
}
