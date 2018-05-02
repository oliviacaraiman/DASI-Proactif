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
                String mail = req.getParameter("login");
                String mdp = req.getParameter("password");
                System.out.println("mail : " + mail);
                System.out.println("mdp : " + mdp);
            //s.register();
        }
}
