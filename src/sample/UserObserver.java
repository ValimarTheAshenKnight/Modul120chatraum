package sample;

import javafx.scene.control.TextArea;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by d.buetikofer on 27.04.2017.
 */
public class UserObserver extends TextArea implements Observer{
    @Override
    public void update(Observable observable, Object o) {
        User u = (User) observable;
        this.setText(u.getName());
    }
}
