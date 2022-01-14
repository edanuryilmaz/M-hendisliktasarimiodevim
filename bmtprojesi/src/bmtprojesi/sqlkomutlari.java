
package bmtprojesi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;

public class sqlkomutlari {
    
     PreparedStatement pst;
     String kullanici;
    ResultSet rs;
         Connection con;
     String[]  kullanicilar ={"admin"};
     
    @FXML
    private Label kullanicibilgi;
    @FXML
                
    void baglanti(){
        
        try {
            System.out.println("try içinde ");
            Class.forName("com.mysql.jdbc.Driver");
               System.out.println(" con öncesi deneme");
                con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/bmt", "bmt", "12345678");
            System.out.println("bağlandı");
             
        } catch (Exception e) {
            System.out.println("bağlantı sağlanamadı");
        }
            
    }
    String kullanici(String kullaniciadi,String sifre) throws SQLException{
     
 //**************************************
        
            try {
               
                baglanti();
                System.out.println("denemeeeee");
          pst=con.prepareStatement("select * from kullanici where kullaniciadi=? and sifre=?");
         pst.setString(1, kullaniciadi);
          pst.setString(2, sifre);
           rs=pst.executeQuery();
           
        if(rs.next()){
                try{  
                      Bmtprojesi.setRoot("admin");
                      //stokislemleri stok=new stokislemleri();
                    } catch (Exception e) {
                 JOptionPane.showMessageDialog(null,"(ADMİN) fxml dosyası açılmadı");

                   }     }
                                 
             con.close();
            } 
            catch (Exception e) {
        }  
        return kullanici;
    }
}
