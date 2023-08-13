package Rcp;

import actions.ApplicationActions;
import actions.ButtonActions;
import actions.MenuActions;

import java.io.IOException;

public class Temp {

    public static void main(String[] args) throws IOException {

        ApplicationActions app= new ApplicationActions();

        app.gotoHomeSite();
        //MenuActions.click("GİRİŞ Yap");
        MenuActions.click("Kurumsal", "Hakkımızda");
    }
}
