package com.example.tap2024b.vistas;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;
import org.kordamp.bootstrapfx.scene.layout.Panel;

public class Loteria extends Stage {

    private HBox hBoxMain, hBoxButtons;
    private VBox vbxTablilla, vbxMazo;
    private Button btnAnterior, btnSiguiente, btnIniciar;
    private Label lblTimer;
    private GridPane gdpTablilla;
    private ImageView imvMazo;
    private Scene escena;
    private String[] arImages = {"barril.jpeg","botella.jpeg","catrin.jpeg","chavorruco.jpeg","concha.jpeg","luchador.jpeg","maceta.jpeg","rosa.jpeg","tacos.jpeg","venado.jpeg"};
    private Button[][] arBtnTab;

    private Panel pnlPrincipal;

    public Loteria(){
        CrearUI();
        this.setTitle("Loteria Mexicana :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI(){
        ImageView imvAnt, imvSig;
        imvAnt = new ImageView(new Image(getClass().getResource("/images/last.png").toString()));
        imvAnt.setFitHeight(50);
        imvAnt.setFitWidth(50);
        imvSig = new ImageView(new Image(getClass().getResource("/images/next.png").toString()));
        imvSig.setFitWidth(50);
        imvSig.setFitHeight(50);

        gdpTablilla = new GridPane();
        CrearTablilla();

        btnAnterior = new Button();
        btnAnterior.setGraphic(imvAnt);
        btnSiguiente = new Button();
        btnSiguiente.setGraphic(imvSig);

        hBoxButtons = new HBox(btnAnterior,btnSiguiente);
        vbxTablilla = new VBox(gdpTablilla,hBoxButtons);

        CrearMazo();

        hBoxMain = new HBox(vbxTablilla, vbxMazo);
        pnlPrincipal = new Panel("Loteria Mexicana :)");
        pnlPrincipal.getStyleClass().add("panel-success");
        pnlPrincipal.setBody(hBoxMain);
        hBoxMain.setSpacing(20);
        hBoxMain.setPadding(new Insets(20));
        escena = new Scene(pnlPrincipal, 800, 600);
        escena.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        escena.getStylesheets().add(getClass().getResource("/styles/loteria.css").toExternalForm());
    }

    private void CrearMazo() {
        lblTimer = new Label("00:00");
        imvMazo = new ImageView(getClass().getResource("/images/dorso.jpeg").toString());
        imvMazo.setFitHeight(450);
        imvMazo.setFitWidth(300);
        btnIniciar = new Button("Iniciar Juego");
        btnIniciar.getStyleClass().setAll("btn-sm","btn-danger");
        vbxMazo = new VBox(lblTimer,imvMazo,btnIniciar);
        vbxMazo.setSpacing(10);
    }

    private void CrearTablilla() {
        arBtnTab = new Button[4][4];
        Image img;
        ImageView imv;
        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j < 4; j++) {
                img = new Image(getClass().getResource("/images/barril.jpeg").toString());
                imv = new ImageView(img);
                imv.setFitWidth(70);
                imv.setFitHeight(120);
                arBtnTab[j][i] = new Button();
                arBtnTab[j][i].setGraphic(imv);
                gdpTablilla.add(arBtnTab[j][i],j,i);
            }
        }
    }

}
