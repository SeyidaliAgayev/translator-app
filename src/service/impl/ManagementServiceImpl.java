package service.impl;

import enums.ExceptionEnums;
import exceptions.AppExceptions;
import service.ManagementServiceInter;

import java.util.InputMismatchException;

import static util.MenuUtil.*;

public class ManagementServiceImpl implements ManagementServiceInter {
    StartServiceImpl startService = new StartServiceImpl();
    @Override
    public void management() {

        while (true) {
            try {
                int menuOption = entryMenu();
                switch (menuOption) {
                    case 0:
                        startService.exit();
                        break;
                    case 1:
                        startService.start();
                        break;
                    case 2:
                        startService.addWord();
                        break;
                    case 3:
                        startService.seeHistory();
                        break;
                    default:
                        if (menuOption != 0 || menuOption != 1 || menuOption != 2 || menuOption != 3) {
                            throw new AppExceptions(ExceptionEnums.ILLEGAL_CHARACTER_EXCEPTION);
                        }
                }
            } catch (AppExceptions | InputMismatchException exception) {
                System.err.println(exception.getMessage());
            }
        }
    }
}
