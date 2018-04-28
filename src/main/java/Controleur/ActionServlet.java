/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Actions.Action;
import Actions.ActionAfficherInterventionClient;
import Actions.ActionAfficherInterventionEmploye;
import Actions.ActionConnexion;
import Actions.ActionEnvoyerDemande;
import Actions.ActionFillAtestation;
import Actions.ActionInscription;
import Actions.ActionInterventionJour;
import Actions.ActionInterventionsFinie;
import Actions.ActionReinitialisation;
import fr.insalyon.dasi.dao.JpaUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author olivi
 */
@WebServlet(name = "ActionServlet", urlPatterns = {"/ActionServlet"})
public class ActionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ActionServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActionServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        */
        
         String choix = request.getParameter("todo");
        switch(choix){
            case "inscription" : {
                Action action = new ActionInscription();
                action.run(request);
                //Serialize(request); => resp
                //appel classe serialization pour mettre reponse en forme
                break;
            }
            case "connexion" : {
                Action action = new ActionConnexion();
                action.run(request);
                
                break;
            }
           case "reinitialisation" : {
                Action action = new ActionReinitialisation();
                action.run(request);
                
                break;
            }
           case "envoyer" : {
                Action action = new ActionEnvoyerDemande();
                action.run(request);
                
                break;
            }
           case "interventionClient" : {
                Action action = new ActionAfficherInterventionClient();
                action.run(request);
                
                break;
            }
           case "completerAttestation" : {
                Action action = new ActionFillAtestation();
                action.run(request);
                
                break;
            }
           case "interventionEmploye" : {
                Action action = new ActionAfficherInterventionEmploye();
                action.run(request);
                
                break;
            }
           case "interventionsFinies" : {
                Action action = new ActionInterventionsFinie();
                action.run(request);
                
                break;
            }
           case "interventionJour" : {
                Action action = new ActionInterventionJour();
                action.run(request);
                
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
