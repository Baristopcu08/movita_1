package actions;

import controls.ButtonControl;

public class ButtonActions {

    public static void click(String label) {
        ButtonControl.fromLabel(label)
                .click();
    }

}
