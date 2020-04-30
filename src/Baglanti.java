
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Baglanti {
 
 private String kullanici_adi="sa";
 private String parola="Szb0804.";

 private String db_ismi="yazilimprojesii";

 private String host="localhost";

 private int port=1433;
 
 private Connection con=null;
 
 private Statement statement=null;
 
 private PreparedStatement preparedstatement=null;
 
 /*public void preparedClsnGtr(String ad){
     
     
     String sorgu="SELECT*FROM tbPersonal where NameSurname="?"";
     try {
         preparedstatement=con.prepareStatement(sorgu);
         preparedstatement.setString(1, ad);
         
         ResultSet rs=preparedstatement.executeQuery();
         
         while(rs.next()){
             String nsn=rs.getString("NameSurname");
             int level=rs.getInt("Level");
             int signature=rs.getInt("İmza");
             int password=rs.getInt("Password");
             
             System.out.println(nsn+level+signature+password);
             
         }
         
         
     } catch (SQLException ex) {
         Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
     }
     
     
     
     
     
     
     
 }*/
 public int[] preparedCalisanAra(int imza){
  
  String sorgu="Select İmza,Password FROM tbPersonal where İmza=?";
  int[] a=new int[2];
     try {
         preparedstatement=con.prepareStatement(sorgu);
         preparedstatement.setInt(1, imza);
         
         ResultSet rs=preparedstatement.executeQuery();
         while(rs.next()){
           int i=rs.getInt("İmza");
           int p=rs.getInt("Password");
         
           a[0]=i;
           a[1]=p;
           
          
           
           
           
         }
     } catch (SQLException ex) {
         Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
        
     }
     return a;
    
  }
 
 
 public void preparedCalisanGetir(int id){
  
    String sorgu="SELECT*FROM tbPersonal where PersonalId=?";
     try {
         preparedstatement=con.prepareStatement(sorgu);
         preparedstatement.setInt(1, id);
         
         ResultSet rs=preparedstatement.executeQuery();
         
         while(rs.next()){
             String nsn=rs.getString("NameSurname");
             int level=rs.getInt("Level");
             int signature=rs.getInt("İmza");
             int password=rs.getInt("Password");
             
             System.out.println(nsn+level+signature+password);
             
         }
         
         
     } catch (SQLException ex) {
         Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
     }
    
    
    
    
} 
 
public void calisanEkle(){
    
     try {
         statement=con.createStatement();
         String nsn="osman emre balta";
         int l=3;
         int s=158796;
         int pass=154236;
         
         String sorgu="insert into tbPersonal(NameSurname,Level,İmza,Password) VALUES("+"'"+ nsn +"',"+ l +","+ s +","+ pass +")" ;
         
         statement.executeUpdate(sorgu);
         
                 
     } catch (SQLException ex) {
         Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
     }
    
    
}
 
public void calisanSil(){
    
     try {
         statement=con.createStatement();
         String sorgu="DELETE from tbPersonal where İmza=158796 " ;
         
         statement.executeUpdate(sorgu);
         
         
         
     } catch (SQLException ex) {
         Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
     }
    
    
    
    
    
}
 
public void calisanArama(){
     
     String sorgu="SELECT*FROM tbPersonal";
     
     try {
         statement=con.createStatement();
         ResultSet rs=statement.executeQuery(sorgu);
         
         while(rs.next()){
             
             
             String nsn=rs.getString("NameSurname");
             int parola=rs.getInt("Password");
             
             System.out.println(nsn);
             
             
             
             
         }
         
         
         
     } catch (SQLException ex) {
         Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
     }
     
     
     
 }

 
 public Baglanti(){
     
  //String url="jdbc:sqlserver://"+host+":"+port+"/"+db_ismi;
    String url="jdbc:sqlserver://localhost:1433/yazilimprojesii";
  
     try{
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     }catch(ClassNotFoundException ex){
      System.out.println("Driver Bulunamadı");
     }
  
     try {
         con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databasename=yazilimprojesii; user=sa ; password=Szb0804. ;");
         System.out.println("Bağlantı başarılı");
     } catch (SQLException ex) {
         //System.out.println("Bağlantı başarısız");
         ex.printStackTrace();
     }
    
 
}
 public static void main(String[] args){
     
     Baglanti b=new Baglanti();
     //System.out.println("silmedem önce");
     //b.calisanArama();
     //b.calisanSil();
     //System.out.println("sildikten sonra");
     //b.calisanArama();
     //b.preparedCalisanGetir(5);
     
     
 }
    
 }


