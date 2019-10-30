package supergenius.springboot.converter;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author LiuBin
 * @Date 2019/9/24 17:28
 **/
@Converter
public class SetToStringConverter implements AttributeConverter<Set<Object>, String> {
    @Override
    public String convertToDatabaseColumn(Set<Object> strings) {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
            jsonStr = mapperObj.writeValueAsString(strings);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    @Override
    public Set<Object> convertToEntityAttribute(String s) {
        ObjectMapper mapperObj = new ObjectMapper();
        Set<Object> resultSet = new HashSet<>();
        try {
            resultSet = mapperObj.readValue(s, new TypeReference<Set<Object>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
