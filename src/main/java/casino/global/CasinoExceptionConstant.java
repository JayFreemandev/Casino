package casino.global;

public class CasinoExceptionConstant {
    private CasinoExceptionConstant() {
        throw new IllegalStateException(UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE);
    }

    public static final String INVALID_CHIP_COLOR =  "잘못된 칩 종류 입니다!";
    public static final String UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE = "생성할 수 없는 Utility 클래스입니다.";
}
