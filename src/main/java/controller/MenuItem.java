package controller;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MenuItem extends GridPane {
    private Integer name = null;

    public MenuItem(int i) {
        // TODO Auto-generated constructor stub
        this.name = i;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }
}