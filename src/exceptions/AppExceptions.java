package exceptions;

import enums.ExceptionEnums;

public class AppExceptions extends RuntimeException{
    public AppExceptions(ExceptionEnums exceptionEnums){
        super(exceptionEnums.getMessage());
    }
}
