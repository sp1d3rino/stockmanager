/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author sp1d3r
 */
public class Utils {

    private static Utils _instance;

    public Utils() {

        _instance = this;
    }

    public static Utils getInstance() {

        if (_instance == null) {
            _instance = new Utils();
        }

        return _instance;
    }

    public void showErrorDialog(Component c, String msg, String title) {
        JOptionPane.showMessageDialog(c, msg,
                title,
                JOptionPane.ERROR_MESSAGE);

    }

    public boolean changeFieldBackground(Object o, boolean result) {

        if (o instanceof JTextField) {
            JTextField tf = (JTextField) o;
            if (tf.getText().isEmpty()) {
                tf.setBackground(Color.red);
                result = false;
            } else {
                tf.setBackground(Color.white);
            }
        } else if (o instanceof JFormattedTextField) {
            JFormattedTextField tf = (JFormattedTextField) o;
            if (tf.getText().isEmpty()) {
                tf.setBackground(Color.red);
                result = false;
            } else {
                tf.setBackground(Color.white);
            }

        }

        return result;
    }

}
