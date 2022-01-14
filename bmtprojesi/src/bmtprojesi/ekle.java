
package bmtprojesi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class ekle {
      @FXML
    private TextField tc;

    @FXML
    private TextField telno;

    @FXML
    private TextField soyad;

    @FXML
    private TextField ad;

    @FXML
    private TextField kan;

    @FXML
    private Button ekle;
      ResultSet rs;
     PreparedStatement pst;
    Connection con;
      @FXML
       void baglanti() throws SQLException{
        
        try {
            System.out.println("try içinde ");
            Class.forName("com.mysql.jdbc.Driver");
               System.out.println(" con öncesi deneme");
                con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/Otomasyon", "stokotomasyon", "12345678");
            System.out.println("bağlandı");
             
        } catch (Exception e) {
            System.out.println("bağlantı sağlanamadı");
        }
            
    }
    
    @FXML
    void ekle() throws SQLException{
        String isim=ad.getText();
        String soyisim=soyad.getText();
        String tcno=tc.getText();
        String tel=telno.getText();
        String kangrubu=kan.getText();
       try {
            baglanti();
            System.out.println("denemeeeee");
            pst = con.prepareStatement("select * from urunler where UrunlerID=?");
            rs = pst.executeQuery();
            if(rs.next()){
                Statement rs_st = con.createStatement();
            rs_st.executeUpdate("INSERT INTO kisi (tcno,kullaniciadi,isim,soyisim,kangrubu,yakıntel) VALUES ('" + tcno + "','"
                     + "','" + isim + "','" + soyisim + "','" + kangrubu + "','"+ tel);
            con.close();
            }
            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ÜRÜN EKLEME İŞLEMİ GERÇEKLEŞTİRİLEMEDİ");
        }

    }
}