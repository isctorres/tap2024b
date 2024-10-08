package com.example.tap2024b.vistas;

import com.example.tap2024b.models.ClienteDAO;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.Text;

public class FormCliente extends Stage {

    private TextField txtNomCte;
    private TextField txtEmailCte;
    private TextField txtTelCte;
    private Button btnGuardar;
    private VBox vBox;

    private ClienteDAO objCte;
    private Scene escena;
    public FormCliente(){
        objCte = new ClienteDAO();
        CrearUI();
        this.setTitle("Agregar Cliente :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        txtNomCte = new TextField();
        txtNomCte.setPromptText("Nombre del cliente");
        txtEmailCte = new TextField();
        txtEmailCte.setPromptText("Email del Cliente");
        txtTelCte = new TextField();
        txtTelCte.setPromptText("Telefono del cliente");
        btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(actionEvent -> GuardarCliente());
        vBox = new VBox(txtNomCte,txtEmailCte,txtTelCte,btnGuardar);
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);
        escena = new Scene(vBox, 300, 150);
    }

    private void GuardarCliente() {
    }


}
