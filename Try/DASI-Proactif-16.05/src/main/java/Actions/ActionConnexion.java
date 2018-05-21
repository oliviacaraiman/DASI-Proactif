/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import fr.insalyon.dasi.entities.Person;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mleral
 */
public class ActionConnexion extends Action {
        @Override
        public void run(HttpServletRequest req){
            HttpSession session = req.getSession();
                String mail = req.getParameter("login");
                String mdp = req.getParameter("password");
                
                Person personne;
                personne = s.login(mail, mdp.toCharArray());
                if (personne == null) {
                    req.setAttribute("status", "fail");
                    session.setAttribute("utilisateur", null);
                }else {
                    req.setAttribute("status", "success");
                    session.setAttribute("utilisateur", personne);
                }
                
            //s.register();
        }
}
