package enums;

public enum MenuEnums {
    START("[1].Start\n"),
    ADD("[2].Add Word\n"),
    SEE("[3].See History\n"),
    EXIT("[0]. EXIT!\n");
    private final String menuOption;

    MenuEnums(String menuOption) {
        this.menuOption = menuOption;
    }

    public String getMenuOption() {
        return menuOption;
    }
}
