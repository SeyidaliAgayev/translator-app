package util;
import static enums.MenuEnums.*;
import static util.InputUtil.*;
public class MenuUtil {
    public static int entryMenu() {
        System.out.println(START.getMenuOption() +
        ADD.getMenuOption() +
        SEE.getMenuOption() +
        EXIT.getMenuOption()
        );
        return inputRequiredInt("Choose an option: ");
    }
}
