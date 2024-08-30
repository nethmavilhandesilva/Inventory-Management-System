package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class tables {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            //st.executeUpdate("create table appuser(appuser_pk int AUTO_INCREMENT primary key,userRole varchar(50),name varchar(200),mobileNumber varchar(50),email varchar(200),password varchar(50),address varchar(200),status varchar(50)");
            //  st.executeUpdate("insert into appuser (userRole,name,mobileNumber,email,password,address,status)values('Super Admin','Super Admin','12345','superadmin@testemail.com','admin','SriLanka','Active')");
            // st.executeUpdate("create table category(category_pk int AUTO_INCREMENT primary key,name varchar(200))");
           // st.executeUpdate("create table product(product_pk int AUTO_INCREMENT primary key,name varchar(200),quantity int,price int,description varchar(500),category_fk int)");
           //st.executeUpdate("create table customer(customer_pk int AUTO_INCREMENT primary key,name varchar(200),mobileNumber varchar(50),email varchar(200))");
            st.executeUpdate("create table orderDetail(orderr_pk int AUTO_INCREMENT primary key,orderID varchar(200),customer_fk int,orderDate varchar(200),totalPaid int)");
            
            JOptionPane.showMessageDialog(null, "Table Created SuccessFully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
            }
        }
    }
}
