/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author mleral
 */
public class ActionConnexion extends Action {
        @Override
        public void run(HttpServletRequest req){
                String nom = req.getParameter("prenom");
                    //mettre 
                    // https://www.tutorialspoint.com/servlets/servlets-form-data.htm
                    
            
            
            //s.register();
        }
}
