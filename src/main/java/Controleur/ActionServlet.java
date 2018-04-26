/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Actions.*;
import fr.insalyon.dasi.dao.JpaUtil;

/**
 *
 * @author mleral
 */
public class ActionServlet extends HttpServlet{
    @Override
    protected void service( HttpServletRequest req, HttpServletResponse resp){
        String choix = req.getParameter("todo");
        switch(choix){
            case "inscription" : {
                Action action = new ActionInscription();
                action.run(req);
                //Serialize(req); => resp
                //appel classe serialization pour mettre reponse en forme
                break;
            }
            case "connexion" : {
                Action action = new ActionConnexion();
                action.run(req);
                
                break;
            }
           case "reinitialisation" : {
                Action action = new ActionReinitialisation();
                action.run(req);
                
                break;
            }
           case "envoyer" : {
                Action action = new ActionEnvoyerDemande();
                action.run(req);
                
                break;
            }
           case "interventionClient" : {
                Action action = new ActionAfficherInterventionClient();
                action.run(req);
                
                break;
            }
           case "completerAttestation" : {
                Action action = new ActionFillAtestation();
                action.run(req);
                
                break;
            }
           case "interventionEmploye" : {
                Action action = new ActionAfficherInterventionEmploye();
                action.run(req);
                
                break;
            }
           case "interventionsFinies" : {
                Action action = new ActionInterventionsFinie();
                action.run(req);
                
                break;
            }
           case "interventionJour" : {
                Action action = new ActionInterventionJour();
                action.run(req);
                
                break;
            }
        
        }
    }
    @Override
    public void init(){
        JpaUtil.init();
    }
    @Override
    public void destroy(){
        JpaUtil.destroy();
    }
}
