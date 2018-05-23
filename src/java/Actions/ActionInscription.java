/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import static com.oracle.jrockit.jfr.ContentType.Address;
import fr.insalyon.dasi.entities.Address;
import fr.insalyon.dasi.entities.Client;
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
public class ActionInscription extends Action {

    @Override
    public void run(HttpServletRequest req) {
        HttpSession session = req.getSession();
        boolean res = false;
        System.out.println("Ds ActionInscription");
        String honorific = req.getParameter("civilite");
        String prenom = req.getParameter("firstName");
        String nom = req.getParameter("lastName");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateNaissance = new Date();
        try {
            dateNaissance = sdf.parse(req.getParameter("birthdate"));
        } catch (ParseException ex) {
            Logger.getLogger(ActionInscription.class.getName()).log(Level.SEVERE, null, ex);
        }
        String num = req.getParameter("phonenumber");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        char[] mdp = password.toCharArray();
        
        String adresse1 = req.getParameter("address1");
        String adresse2 = req.getParameter("address2");
        String zipCode = req.getParameter("zipCode");
        String ville = req.getParameter("city");
        String pays = req.getParameter("country");
        
        Address adresse = new Address(adresse1,adresse2,zipCode,ville,pays);
        Person person = new Client(honorific, prenom, nom, dateNaissance, num, email,adresse);
        
        if (s.register(person, mdp)) {
            req.setAttribute("status", "success");
           // session.setAttribute("utilisateur", person);
        }
        else req.setAttribute("status", "fail");
        
    }
}
