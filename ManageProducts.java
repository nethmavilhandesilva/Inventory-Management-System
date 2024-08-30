
import dao.ConnectionProvider;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class ManageProducts extends javax.swing.JFrame {
    private int productpk=0;
    private int totalQuantity=0;

  
    public ManageProducts() {
        initComponents();
        setLocationRelativeTo(null);
    }
    private void getAllCategory(){
    try{
        Connection con=ConnectionProvider.getCon();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from category");
        comboBoxCategory.removeAllItems();
        while(rs.next()){
            comboBoxCategory.addItem(rs.getString("category_pk")+"-"+rs.getString("name"));
        }
    }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null,e);
    }    
    }
    private boolean validateFields(String formType){
        if(formType.equals("edit")&&!txtName.getText().equals("")&&!txtPrice.getText().equals("")&&!txtDescription.getText().equals(""))
        {
            return false;
        }    
        else if(formType.equals("new")&&!txtName.getText().equals("")&&!txtPrice.getText().equals("")&&!txtDescription.getText().equals("")&&!txtQuantity.getText().equals(""))
        {
            return false;
        }    
        else
            return true;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboBoxCategory = new javax.swing.JComboBox<>();
        btSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Manage Products");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 6, -1, -1));

        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Quantity", "Price", "Description", "CategoryID", "CategoryName"
            }
        ));
        tableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProduct);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 53, 470, 506));

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblName.setText("Name");
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 71, -1, -1));

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 99, 355, -1));

        lblQuantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblQuantity.setText("Quantity");
        getContentPane().add(lblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 139, -1, -1));

        txtQuantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        getContentPane().add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 173, 355, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Price");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 213, -1, -1));

        txtPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 247, 346, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Description");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 287, -1, -1));

        txtDescription.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 321, 355, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Category");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 361, -1, -1));

        comboBoxCategory.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        comboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(comboBoxCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 395, 355, -1));

        btSave.setText("Save");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 453, -1, -1));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(566, 453, -1, -1));

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(656, 453, -1, -1));

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(746, 453, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/All_page_Background.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
    getAllCategory();
    DefaultTableModel model=(DefaultTableModel)tableProduct.getModel();
    try{
        Connection con=ConnectionProvider.getCon();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from product inner join category on product.category_fk=category.category_pk");
        while(rs.next()){
            model.addRow(new Object[]{rs.getString("product_pk"),rs.getString("name"),rs.getString("quantity"),rs.getString("price"),rs.getString("Description"),rs.getString("category_fk"),rs.getString(8)});
        }
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
    btnUpdate.setEnabled(false);
    }//GEN-LAST:event_formComponentShown

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
    setVisible(false);
   
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
    setVisible(false);
    new ManageProducts().setVisible(true);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
    String name=txtName.getText();
    String quantity=txtQuantity.getText();
    String price=txtPrice.getText();
    String description=txtDescription.getText();
    String category=(String)comboBoxCategory.getSelectedItem();
    String categoryId[]=category.split("-",0);
    if(validateFields("new")){
        JOptionPane.showMessageDialog(null,"All fields are required");
    }
    else{
        try{
            Connection con=ConnectionProvider.getCon();
            PreparedStatement ps=con.prepareStatement("insert into product(name,quantity,price,description,category_fk)values(?,?,?,?,?)");
              ps.setString(1, name);
              ps.setString(2, quantity);
              ps.setString(3, price);
              ps.setString(4, description);
              ps.setString(5, categoryId[0]);
              ps.executeUpdate();
              JOptionPane.showMessageDialog(null,"Product added sucessfully");
              setVisible(false);
              new ManageProducts(). setVisible(true);
              
                   
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    }//GEN-LAST:event_btSaveActionPerformed

    private void tableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductMouseClicked
       int index=tableProduct.getSelectedRow();
       TableModel model =tableProduct.getModel();
       String id=model.getValueAt(index, 0).toString();
       productpk=Integer.parseInt(id);
       
       String name=model.getValueAt(index, 1).toString();
       txtName.setText(name);
       
       String quantity=model.getValueAt(index, 2).toString();
       totalQuantity=0;
       lblQuantity.setText("Add Quantity");
       totalQuantity=Integer.parseInt(quantity);
       
       String price=model.getValueAt(index,3).toString();
       txtPrice.setText(price);
       
       String description=model.getValueAt(index, 4).toString();
       txtDescription.setText(description);
       
       comboBoxCategory.removeAllItems();
       String categoryId=model.getValueAt(index,5).toString();
       String categoryName=model.getValueAt(index,6).toString();
       comboBoxCategory.addItem(categoryId +"-"+categoryName);
       
        try{
        Connection con=ConnectionProvider.getCon();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from category");
       
        while(rs.next()){
            if(Integer.parseInt(categoryId)!=rs.getInt(1))
            comboBoxCategory.addItem(rs.getString("category_pk")+"-"+rs.getString("name"));
        }
        }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null,e);
    }    
    btSave.setEnabled(false);
    btnUpdate.setEnabled(true);
    }//GEN-LAST:event_tableProductMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
     String name=txtName.getText();
    String quantity=txtQuantity.getText();
    String price=txtPrice.getText();
    String description=txtDescription.getText();
    String category=(String)comboBoxCategory.getSelectedItem();
    String categoryId[]=category.split("-",0);
    if(validateFields("edit")){
        JOptionPane.showMessageDialog(null,"All fields are required");
    }
    else{
        try{
            if(!quantity.equals("")){
                totalQuantity=totalQuantity+Integer.parseInt(quantity);
            }
            Connection con=ConnectionProvider.getCon();
            PreparedStatement ps=con.prepareStatement("update product set name=?,quantity=?,price=?,description=?,category_fk=? where product_pk=?");
              ps.setString(1, name);
              ps.setInt(2, totalQuantity);
              ps.setString(3, price);
              ps.setString(4, description);
              ps.setString(5, categoryId[0]);
              ps.setInt(6,productpk);
              ps.executeUpdate();
              JOptionPane.showMessageDialog(null,"Product updated sucessfully");
              setVisible(false);
              new ManageProducts(). setVisible(true);
              
                   
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }    
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void comboBoxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCategoryActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ManageProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ManageProducts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSave;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboBoxCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JTable tableProduct;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
