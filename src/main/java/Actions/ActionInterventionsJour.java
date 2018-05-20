/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import fr.insalyon.dasi.entities.Intervention;
import fr.insalyon.dasi.entities.Person;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mleral
 */
public class ActionInterventionsJour extends Action {

    @Override
    public void run(HttpServletRequest req) {
        HttpSession session = req.getSession();
//        Person employe = (Person) session.getAttribute("employe");
//        Long idEmploye = employe.getId();
        Date date = new Date();
        List<Intervention> interventionsJour = s.getInterventionsByDay(date);
        if (interventionsJour.size() > 0) {
            req.setAttribute("status", "success");
            session.setAttribute("interventionsJour", interventionsJour);
        } else {
            req.setAttribute("status", "fail");
        }
    }
}
