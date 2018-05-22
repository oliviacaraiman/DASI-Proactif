/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import fr.insalyon.dasi.entities.Intervention;
import fr.insalyon.dasi.entities.Person;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mleral
 */
public class ActionFillAtestation extends Action {

    @Override
    public void run(HttpServletRequest req) {
        HttpSession session = req.getSession();
        Person utilisateur = (Person) session.getAttribute("utilisateur");
        Long idUtilisateur = utilisateur.getId();

        Intervention intervention = s.getInterventionToDoByEmployee(idUtilisateur);
        intervention.setComment(req.getParameter("commentaire"));
        intervention.setSuccess(((req.getParameter("statut")).equals("succes")));
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm yyyy-MM-dd");
        Date dateFin = new Date();
        try {
            dateFin = sdf.parse(req.getParameter("heure") + " " + req.getParameter("date"));
        } catch (ParseException ex) {
            Logger.getLogger(ActionInscription.class.getName()).log(Level.SEVERE, null, ex);
        }
        intervention.setEndDate(dateFin);
        if (s.fillAttestation(intervention)) {
            req.setAttribute("status", "success");
            // session.setAttribute("intervention", intervention);
        } else {
            req.setAttribute("status", "fail");
        }

    }
}
