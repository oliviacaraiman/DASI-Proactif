/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import fr.insalyon.dasi.entities.Intervention;
import fr.insalyon.dasi.entities.Person;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mleral
 */
public class ActionAfficherInterventionEmploye extends Action {
        @Override
        public void run(HttpServletRequest req){
                //String nom = req.getParameter("prenom");
                    //mettre 
                    // https://www.tutorialspoint.com/servlets/servlets-form-data.htm
                HttpSession session = req.getSession();  
                Person utilisateur = (Person) session.getAttribute("utilisateur");
                Long idUtilisateur = utilisateur.getId();
                
                Intervention intervention = s.getInterventionToDoByEmployee(idUtilisateur);
                if (!intervention.getType().equals("Générique")) {
                    req.setAttribute("statusInterventions", "success");
                    session.setAttribute("interventions", intervention);
                } else {
                    req.setAttribute("statusInterventions", "fail");
                }
                
            //s.register();
        }
}
