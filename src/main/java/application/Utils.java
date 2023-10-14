package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Utils {

    public static <T> ObservableList<T> createObservableList(List<T> data) {
        return FXCollections.observableArrayList(data);
    }

}
