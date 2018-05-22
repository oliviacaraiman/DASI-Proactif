/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import java.util.List;
import fr.insalyon.dasi.entities.Intervention;
import fr.insalyon.dasi.entities.Person;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mleral
 */
public class ActionInterventionsFinie extends Action {

    @Override
    public void run(HttpServletRequest req) {
        HttpSession session = req.getSession();
        Person utilisateur = (Person) session.getAttribute("utilisateur");
        Long idUtilisateur = utilisateur.getId();
        List<Intervention> interventions = s.getFinishedInterventionsByEmployee(idUtilisateur);
        if (interventions.size() > 0) {
            req.setAttribute("statusInterventions", "success");
            session.setAttribute("interventions", interventions);
        } else {
            req.setAttribute("statusInterventions", "fail");
        }
    }
}
