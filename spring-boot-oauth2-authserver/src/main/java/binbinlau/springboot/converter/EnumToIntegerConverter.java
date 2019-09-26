package binbinlau.springboot.converter;

import binbinlau.springboot.oauth2.enums.EStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @Author LiuBin
 * @Date 2019/9/24 19:34
 **/
@Converter
public class EnumToIntegerConverter implements AttributeConverter<EStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(EStatus anEnum) {
        return EStatus.getValue(anEnum);
    }

    @Override
    public EStatus convertToEntityAttribute(Integer i) {
        return EStatus.getEStatus(i);
    }
}
