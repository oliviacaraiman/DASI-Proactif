/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import static com.oracle.jrockit.jfr.ContentType.Address;
import fr.insalyon.dasi.entities.Address;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author mleral
 */
public class ActionInscription extends Action {
        @Override
        public void run(HttpServletRequest req){
                boolean res=false;
                
                String honorific = req.getParameter("honorific");
                String prenom = req.getParameter("firstName");
                String nom = req.getParameter("lastName");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                
            try {
                Date d = sdf.parse(req.getParameter("birthdate"));
            } catch (ParseException ex) {
                Logger.getLogger(ActionInscription.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                String num = req.getParameter("phonenumber");
                String email = req.getParameter("email");
                //Address A = req.getParameter("address");
                
                req.setAttribute("Resultat", res);
                    //mettre 
                    // https://www.tutorialspoint.com/servlets/servlets-form-data.htm
                    
            
            
            //s.register();
        }
}
