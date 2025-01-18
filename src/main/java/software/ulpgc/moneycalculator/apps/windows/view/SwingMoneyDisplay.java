package software.ulpgc.moneycalculator.apps.windows.view;

import javax.swing.*;

public class SwingMoneyDisplay extends JLabel implements Display {
    @Override
    public void show(String money) {
        this.setText(money);
    }
}
