/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Actions.*;
import Serialization.JsonConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import fr.insalyon.dasi.dao.JpaUtil;
import fr.insalyon.dasi.entities.Person;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        HttpSession session = request.getSession();
        JsonConverter converter = new JsonConverter();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        response.setContentType("application/json ;charset=UTF-8");
       // PrintWriter out;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
     

        try {   
        String choix = request.getParameter("action");
        JsonObject status = new JsonObject();
        switch(choix){
            case "inscription" : {
                Action action = new ActionInscription();
                action.run(request);
                status.addProperty("status", (String) request.getAttribute("status"));
                JsonObject container = new JsonObject();
                container.add("status",status);
                out.println(gson.toJson(container));
                out.close();
                break;
            }
            case "connexion" : {
                Action action = new ActionConnexion();
                action.run(request);
                JsonObject container = new JsonObject();
                String stat = (String) request.getAttribute("status");
                System.out.println(stat);
                status.addProperty("status", stat);
                if (stat.equals("success")) {
                    System.out.println("CONNEXION");
                    container.add("utilisateur",converter.personToJson((Person) session.getAttribute("utilisateur")));
                }
                container.add("status",status);
                out.println(gson.toJson(container));
                out.close();
                break;
            }
           case "reinitialisation" : {
                Action action = new ActionReinitialisation();
                action.run(request);
                status.addProperty("status", (String) request.getAttribute("status"));
                JsonObject container = new JsonObject();
                container.add("status",status);
                out.println(gson.toJson(container));
                out.close();
                break;
            }
           case "demanderIntervention" : {
                Action action = new ActionEnvoyerDemande();
                action.run(request);
                System.out.println("DS demandeInte");
                status.addProperty("status", (String) request.getAttribute("status"));
                JsonObject container = new JsonObject();
                container.add("status",status);
                out.println(gson.toJson(container));
                out.close();
                break;
            }
//           case "interventionClient" : {
//                Action action = new ActionAfficherInterventionClient();
//                action.run(request);
//                
//                break;
//            }
//           case "completerAttestation" : {
//                Action action = new ActionFillAtestation();
//                action.run(request);
//                
//                break;
//            }
//           case "interventionEmploye" : {
//                Action action = new ActionAfficherInterventionEmploye();
//                action.run(request);
//                
//                break;
//            }
//           case "interventionsFinies" : {
//                Action action = new ActionInterventionsFinie();
//                action.run(request);
//                
//                break;
//            }
//           case "interventionJour" : {
//                Action action = new ActionInterventionJour();
//                action.run(request);
//                
//                break;
//            }
        
           }
        }
         catch (Exception e) {}
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        JpaUtil.init();
    }

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
        JpaUtil.destroy();
    }

}
