package todolist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.exit;

public class Cadastrar {

    @FXML
    private Button button_incio;

    @FXML
    private TextField idnome;

    @FXML
    private LocalDate idData;

    @FXML
    private TextField idNif;

    @FXML
    private TextField idBi;

    @FXML
    private TextField idTelefone;

    @FXML
    private TextField idProfissao;

    @FXML
    private TextField idcategoria;

    @FXML
    private Button button_registarCadastro;
    @FXML
    private Label Idclose;
    @FXML
    private Button cancelarCadastro;

    @FXML
    private Label smscadastro;

    @FXML
    void CancelarOnAction() throws IOException {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("mainwindows.fxml"));
        Parent root=loader.load();
        Controller controller = loader.getController();
        Stage window = (Stage) cancelarCadastro.getScene().getWindow();
        window.setScene(new Scene(root));

    }
    @FXML
    void enter_inicio()  throws IOException {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("mainwindows.fxml"));
        Parent root=loader.load();
        Controller controller = loader.getController();
        Stage window = (Stage) button_incio.getScene().getWindow();
        window.setScene(new Scene(root));

    }



   @FXML
    void LogarCadastro(ActionEvent event) {
       Bdconnection connectionNow = new Bdconnection();
       Connection connectBd = connectionNow.getConnection();

       String nome= idnome.getText();

       String  data_nasc = String.valueOf(idData.getMonthValue());
       int  nif= idNif.getPrefColumnCount();
       String bi=idBi.getText();
       int telefone=idTelefone.getPrefColumnCount();
       String profissao=idProfissao.getText();
       String categoria=idcategoria.getText();

       if (nome.isEmpty() || data_nasc.isEmpty() || profissao.isEmpty() || categoria.isEmpty()) {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setHeaderText(null);
           alert.setContentText("Entre a DATA");
           alert.showAndWait();

       } else {

           clean();

       }
    }
    @FXML
    private void clean() {
        idnome.setText(null);
        //idData.setValueof(null);
        idNif.setText(null);
        idBi.setText(null);

    }








    @FXML
    void CloseOnAction(MouseEvent event) {
        Stage stage = (Stage) Idclose.getScene().getWindow();
        exit(1);
    }

}
