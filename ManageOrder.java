
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import common.OpenPdf;
import dao.ConnectionProvider;
import dao.InventoryUtils;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.table.TableModel;

public class ManageOrder extends javax.swing.JFrame {

    private int customerpk = 0;
    private int productpk = 0;
    private int findTotalPrice = 0;
    private String orderID = "";
    private int finalTotalPrice;

    public ManageOrder() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void clearProductFields() {
        productpk = 0;
        txtProductName.setText("");
        txtProductPrice.setText("");
        txtProductDescription.setText("");
        txtOrderQuantity.setText("");
    }

    public String getUniqueId(String prefix) {
        return prefix + System.nanoTime();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomer = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCart = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCustomerMobileNumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCustomerEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtProductPrice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtProductDescription = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtOrderQuantity = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        lblFinalTotalPrice = new javax.swing.JLabel();
        btnSaveOrderDetails = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        jLabel1.setText("Manage Order");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 9, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Customer List");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 66, -1, -1));

        tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Mobile Number", "Email"
            }
        ));
        tableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCustomer);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 443, 226));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Product List");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, -1, -1));

        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Description", "Category ID", "Category Name"
            }
        ));
        tableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableProduct);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 420, 226));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Cart");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 70, -1, -1));

        tableCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Quantity", "Price", "Description", "SubTotal"
            }
        ));
        tableCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCartMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableCart);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 90, 470, 230));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Selected Customer");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Name");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        txtCustomerName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 430, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Mobile Number");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        txtCustomerMobileNumber.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCustomerMobileNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerMobileNumberActionPerformed(evt);
            }
        });
        getContentPane().add(txtCustomerMobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 430, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Email");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, -1, -1));

        txtCustomerEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCustomerEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txtCustomerEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 430, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Selected Product");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Product Name");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, -1, -1));

        txtProductName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 400, 430, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Product Price");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, -1, -1));

        txtProductPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtProductPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 430, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Product Description");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, -1, -1));

        txtProductDescription.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtProductDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 540, 430, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Order Quantity");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 590, -1, -1));

        txtOrderQuantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtOrderQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 620, 430, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Add To Cart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 660, 430, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Total Amount RS:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 330, -1, -1));

        lblFinalTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFinalTotalPrice.setText("00000");
        getContentPane().add(lblFinalTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 330, -1, -1));

        btnSaveOrderDetails.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSaveOrderDetails.setText("Save Order Details");
        btnSaveOrderDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveOrderDetailsActionPerformed(evt);
            }
        });
        getContentPane().add(btnSaveOrderDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 400, 440, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 470, 440, -1));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setText("Close");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 550, 430, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Orders_background.png"))); // NOI18N
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 1360, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        txtCustomerName.setEditable(false);
        txtCustomerMobileNumber.setEditable(false);
        txtCustomerEmail.setEditable(false);

        txtProductName.setEditable(false);
        txtProductPrice.setEditable(false);
        txtProductDescription.setEditable(false);

        DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
        DefaultTableModel productModel = (DefaultTableModel) tableProduct.getModel();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select*from customer");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("customer_pk"), rs.getString("name"), rs.getString("mobileNumber"), rs.getString("email")});
            }
            rs = st.executeQuery("select*from product inner join category on product.category_fk=category.category_pk");
            while (rs.next()) {
                productModel.addRow(new Object[]{rs.getString("product_pk"), rs.getString("name"), rs.getString("price"), rs.getString("quantity"), rs.getString("description"), rs.getString("category_fk"), rs.getString(8)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_formComponentShown

    private void txtCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerNameActionPerformed

    private void txtCustomerMobileNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerMobileNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerMobileNumberActionPerformed

    private void txtCustomerEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerEmailActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setVisible(false);
        new ManageOrder().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerMouseClicked
        int index = tableCustomer.getSelectedRow();
        TableModel model = tableCustomer.getModel();
        String id = model.getValueAt(index, 0).toString();
        customerpk = Integer.parseInt(id);

        String name = model.getValueAt(index, 1).toString();
        txtCustomerName.setText(name);

        String mobileNumber = model.getValueAt(index, 2).toString();
        txtCustomerMobileNumber.setText(mobileNumber);

        String Email = model.getValueAt(index, 3).toString();
        txtCustomerEmail.setText(Email);

    }//GEN-LAST:event_tableCustomerMouseClicked

    private void tableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductMouseClicked
        int index = tableProduct.getSelectedRow();
        TableModel model = tableProduct.getModel();
        String id = model.getValueAt(index, 0).toString();
        productpk = Integer.parseInt(id);

        String productName = model.getValueAt(index, 1).toString();
        txtProductName.setText(productName);

        String ProductPrice = model.getValueAt(index, 2).toString();
        txtProductPrice.setText(ProductPrice);

        String ProductDescription = model.getValueAt(index, 3).toString();
        txtProductDescription.setText(ProductDescription);


    }//GEN-LAST:event_tableProductMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String noOfUnits = txtOrderQuantity.getText();
        if (!noOfUnits.equals("")) {
            String ProductName = txtProductName.getText();
            String ProductDescription = txtProductDescription.getText();
            String ProductPrice = txtProductPrice.getText();

            int totalPrice = Integer.parseInt(txtOrderQuantity.getText()) * Integer.parseInt(ProductPrice);

            int checkStock = 0;
            int checkProductAlreadyExistInCart = 0;

            try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select*from product where product_pk=" + productpk + "");
                while (rs.next()) {
                    if (rs.getInt("quantity") >= Integer.parseInt(noOfUnits)) {
                        checkStock = 1;
                    } else {
                        JOptionPane.showMessageDialog(null, "Product is out of stock. Only" + rs.getInt("quantity") + "Left");

                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            if (checkStock == 1) {
                DefaultTableModel model = (DefaultTableModel) tableCart.getModel();
                if (tableCart.getRowCount() != 0) {
                    for (int i = 0; i < tableCart.getRowCount(); i++) {
                        if (Integer.parseInt(model.getValueAt(i, 0).toString()) == productpk) {
                            checkProductAlreadyExistInCart = 1;
                            JOptionPane.showMessageDialog(null, "Product Already Exsist In Cart");
                        }

                    }
                }

                if (checkProductAlreadyExistInCart == 0) {
                    model.addRow(new Object[]{productpk, ProductName, noOfUnits, ProductPrice, ProductDescription, totalPrice});
                    finalTotalPrice = finalTotalPrice + totalPrice;
                    lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
                    JOptionPane.showMessageDialog(null, "Added Successfully");
                }
                clearProductFields();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No of Quantity and products field is required");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCartMouseClicked
        int index = tableCart.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to remove this product", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            TableModel model = tableCart.getModel();
            String subTotal = model.getValueAt(index, 5).toString();
            finalTotalPrice = finalTotalPrice - Integer.parseInt(subTotal);
            lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
            ((DefaultTableModel) tableCart.getModel()).removeRow(index);

        }
    }//GEN-LAST:event_tableCartMouseClicked

    private void btnSaveOrderDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveOrderDetailsActionPerformed
        if (finalTotalPrice != 0 && !txtCustomerName.getText().equals("")) {
            orderID = getUniqueId("Bill-");
            DefaultTableModel dtm = (DefaultTableModel) tableCart.getModel();
            if (tableCart.getRowCount() != 0) {
                for (int i = 0; i < tableCart.getRowCount(); i++) {
                    try {
                        Connection con = ConnectionProvider.getCon();
                        Statement st = con.createStatement();
                        st.executeUpdate("update product set quantity=quantity-" + Integer.parseInt(dtm.getValueAt(i, 2).toString()) + " where product_pk=" + Integer.parseInt(dtm.getValueAt(i, 0).toString()));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }

            try {
                SimpleDateFormat myFormat=new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal=Calendar.getInstance();
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps=con.prepareStatement("insert into orderDetail(orderID,customer_fk,orderDate,totalPaid)values(?,?,?,?)");
                ps.setString(1, orderID);
                ps.setInt(2,customerpk);
                ps.setString(3,myFormat.format(cal.getTime()));
                ps.setInt(4,finalTotalPrice);
                ps.executeUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
            //Create Document
            com.itextpdf.text.Document doc=new com.itextpdf.text.Document();
            try{
                SimpleDateFormat myFormat=new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal=Calendar.getInstance();
                PdfWriter.getInstance(doc,new FileOutputStream(InventoryUtils.billPath+""+orderID+".pdf"));
                doc.open();
                Paragraph projectName=new Paragraph("                                                                Inventory Management System\n");
                doc.add(projectName);
                Paragraph starLine=new Paragraph("*************************************************************************************************************************************************************************");
                doc.add(starLine);
                Paragraph details=new Paragraph("\torder ID: "+orderID+"\nDate: "+myFormat.format(cal.getTime())+"\nTotal paid: "+finalTotalPrice);
                doc.add(details);
                doc.add(starLine);
               PdfPTable tb1=new PdfPTable(5);
               PdfPCell nameCell=new PdfPCell(new Phrase("Name"));
               PdfPCell descriptionCell=new PdfPCell(new Phrase("Description"));
               PdfPCell priceCell=new PdfPCell(new Phrase("Price Per Unit"));
               PdfPCell quantityCell=new PdfPCell(new Phrase("Quantity"));
               PdfPCell subTotalPriceCell=new PdfPCell(new Phrase("Sub Total Price"));
               
               BaseColor backgroundColor=new BaseColor(255,204,51);
               nameCell.setBackgroundColor(backgroundColor); 
               descriptionCell.setBackgroundColor(backgroundColor); 
               priceCell.setBackgroundColor(backgroundColor); 
               quantityCell.setBackgroundColor(backgroundColor); 
               subTotalPriceCell.setBackgroundColor(backgroundColor); 
               
               tb1.addCell(nameCell);
               tb1.addCell(descriptionCell);
               tb1.addCell(priceCell);
               tb1.addCell(quantityCell);
               tb1.addCell(subTotalPriceCell);
               
               for(int i=0;i<tableCart.getRowCount();i++){
                   tb1.addCell(tableCart.getValueAt(i,1).toString());
                   tb1.addCell(tableCart.getValueAt(i,4).toString());
                   tb1.addCell(tableCart.getValueAt(i,3).toString());
                   tb1.addCell(tableCart.getValueAt(i,2).toString());
                   tb1.addCell(tableCart.getValueAt(i,5).toString());
                   
               }
               doc.add(tb1);
               doc.add(starLine);
               Paragraph thanksMsg=new Paragraph("Thank You,Please visit again.");
               doc.add(thanksMsg);
               //openPDF
               OpenPdf.OpenById(orderID);
            }
            catch(Exception e){
             JOptionPane.showMessageDialog(null,e);   
            }
            doc.close();
            setVisible(false);    
            new ManageOrder().setVisible(true);
                
            
       }
        else{
            JOptionPane.showMessageDialog(null,"Please add some product to cart or select customer");
        } 
    }//GEN-LAST:event_btnSaveOrderDetailsActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveOrderDetails;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFinalTotalPrice;
    private javax.swing.JTable tableCart;
    private javax.swing.JTable tableCustomer;
    private javax.swing.JTable tableProduct;
    private javax.swing.JTextField txtCustomerEmail;
    private javax.swing.JTextField txtCustomerMobileNumber;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtOrderQuantity;
    private javax.swing.JTextField txtProductDescription;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    // End of variables declaration//GEN-END:variables
}
