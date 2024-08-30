/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import dao.InventoryUtils;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Sadini Kavindya
 */
public class OpenPdf {
    public static void OpenById(String ID){
    try{
     if((new File(InventoryUtils.billPath+ID+".pdf")).exists()){ 
         Process p=Runtime
                 .getRuntime()
                 .exec("rundll32 url.dll,FileProtocolHandler "+InventoryUtils.billPath+""+ID+".pdf");
     }  
     else{
         JOptionPane.showMessageDialog(null,"File is not Exsist");
     }  
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    }
}

