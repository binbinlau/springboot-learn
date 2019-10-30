package supergenius.springboot.oauth2.enums;

import supergenius.springboot.converter.BaseEnumConverter;

import java.util.Objects;

/**
 * @Author LiuBin
 * @Date 2019/9/24  19:33
 * @Param
 * @return
 **/
public enum EStatus implements BaseEnum<Integer> {
    enable(1),
    disable(0),
    init(10);

    private Integer value;

    private EStatus(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    //获取枚举实例
    public static EStatus get(int value) {
        for (EStatus e : EStatus.values()) {
            if (Objects.equals(value, e.getValue())) {
                return e;
            }
        }
        return null;
    }

    public static class Convert extends BaseEnumConverter<EStatus, Integer> {
    }
}
