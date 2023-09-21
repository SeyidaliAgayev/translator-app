package enums;

public enum ExceptionEnums {
    ILLEGAL_CHARACTER_EXCEPTION("Wrong input inserted!"),
    ILLEGAL_POINT_EXCEPTION("Point should be more than 0!");
    private final String message;

    ExceptionEnums(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
