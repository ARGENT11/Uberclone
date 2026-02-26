

import ConcreteClasses.AppMenu;
import ConcreteClasses.Authentication;

public class Main {
    public static void main(String[] args) {
        AppMenu appMenu = new AppMenu(new Authentication());
        appMenu.run();
    }
}