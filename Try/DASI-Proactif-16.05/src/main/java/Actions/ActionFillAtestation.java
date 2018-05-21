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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author mleral
 */
public class ActionFillAtestation extends Action {
        @Override
        public void run(HttpServletRequest req) {
        System.out.println("DS Fill Attestation");
        Intervention intervention;
        HttpSession session = req.getSession();
        String type = req.getParameter("Statut");
        String description = req.getParameter("Commentaire");
        
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm yyyy-MM-dd");
        Date dateFin = new Date();
        try {
            dateFin = sdf.parse(req.getParameter("heure")+" "+req.getParameter("date"));
        } catch (ParseException ex) {
            Logger.getLogger(ActionInscription.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (type.equals("Livraison")){
            String objet = req.getParameter("champObjet");
            String entreprise = req.getParameter("champEntreprise");
            System.out.println("objet:" + objet + "entr: " + entreprise);
            intervention = new InterventionLivraison(objet, entreprise, description, dateFin);
            
        } else if (type.equals("Animal")) {
            String animal=req.getParameter("champAnimal");
            intervention = new InterventionAnimal(animal, description, dateFin);
        } else {
            intervention = new InterventionIncident(description, dateFin);
        }
        
        
        
        if (s.fillAttestation(intervention)) {
            req.setAttribute("status", "success");
            intervention.setSuccess(true);
        } else {
            req.setAttribute("status", "fail");
        }
    }
}
