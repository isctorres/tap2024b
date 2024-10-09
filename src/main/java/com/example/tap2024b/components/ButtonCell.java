package com.example.tap2024b.components;

import com.example.tap2024b.models.ClienteDAO;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

public class ButtonCell extends TableCell<ClienteDAO,String> {
    Button btnCelda;

    public ButtonCell(){
        btnCelda = new Button("Editar");
    }

    @Override
    protected void updateItem(String s, boolean b) {
        super.updateItem(s, b);
        if( !b ){
            this.setGraphic(btnCelda);
        }
    }
}
