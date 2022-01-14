/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bmtprojesi;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


   


public class FXMLDocumentController implements Initializable {
     @FXML
    private TextField kadi;

    @FXML
    private PasswordField sifre;

    @FXML
    private Button giris;

    @FXML
    private Button exit;
    Connection con;
    ResultSet rs;
    PreparedStatement pst;
    Stage stage;
    @FXML
    ImageView myImageView;

    @FXML
    public void baglanti() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("deneme");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bmt", "bmt", "12345678");
            System.out.println("bağlandı");

        } catch (Exception e) {
            System.out.println("veri tabanına bağlanamadı");
        }

    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {
      String kullaniciadi = kadi.getText();
        String Sifre = sifre.getText();
        if(kullaniciadi.isEmpty() || Sifre.isEmpty()){
           JOptionPane.showMessageDialog(null, "kullanıcı adı veya şifre alanı boş bırakılamaz");
           System.exit(0);
       }else{
       sqlkomutlari giris = new sqlkomutlari();
       giris.kullanici(kullaniciadi, Sifre);
        System.out.println(kullaniciadi + " " + sifre);}
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
    
       
    

