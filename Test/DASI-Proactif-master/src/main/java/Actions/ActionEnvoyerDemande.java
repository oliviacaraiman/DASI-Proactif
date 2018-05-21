/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import fr.insalyon.dasi.entities.Intervention;
import fr.insalyon.dasi.entities.InterventionAnimal;
import fr.insalyon.dasi.entities.InterventionIncident;
import fr.insalyon.dasi.entities.InterventionLivraison;
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
public class ActionEnvoyerDemande extends Action {

    @Override
    public void run(HttpServletRequest req) {
        Intervention intervention;
        HttpSession session = req.getSession();
        String type = req.getParameter("type");
        String description = req.getParameter("description");
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm yyyy-MM-dd");
        Date dateDebut = new Date();
        try {
            dateDebut = sdf.parse(req.getParameter("heure")+" "+req.getParameter("date"));
        } catch (ParseException ex) {
            Logger.getLogger(ActionInscription.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (type.equals("Livraison")){
            String objet = req.getParameter("champObjet");
            String entreprise = req.getParameter("champEntreprise");
            System.out.println("objet:" + objet + "entr: " + entreprise);
            intervention = new InterventionLivraison(objet, entreprise, description, dateDebut);
            
        } else if (type.equals("Animal")) {
            String animal=req.getParameter("champAnimal");
            intervention = new InterventionAnimal(animal, description, dateDebut);
        } else {
            intervention = new InterventionIncident(description, dateDebut);
        }
        
        Person utilisateur = (Person)session.getAttribute("utilisateur");
        Long idUtilisateur = utilisateur.getId();
        
        if (s.createAndAssignIntervention(intervention, idUtilisateur)) {
            req.setAttribute("status", "success");
        } else {
            req.setAttribute("status", "fail");
        }
    }
}
