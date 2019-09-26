package binbinlau.springboot.oauth2.enums;

/**
 *
 * @Author LiuBin
 * @Date 2019/9/24  19:33
 * @Param
 * @return
 **/
public enum EStatus {
    Enable(1),
    Disable(0),
    Init(10);

    int value;
    EStatus(int val) {
        this.value = val;
    }

    public static Integer getValue(EStatus eStatus) {
        return eStatus.value;
    }

    public static EStatus getEStatus(Integer value) {
        EStatus[] estates = values();
        for (int i = 0; i < estates.length; i++) {
            if (value == estates[i].value) {
                return estates[i];
            }
        }
        return EStatus.Disable;
    }
}
