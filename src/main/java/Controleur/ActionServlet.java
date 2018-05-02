/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Actions.*;
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
        response.setContentType("text/html;charset=UTF-8");
       // PrintWriter out;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ActionServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActionServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

        try {   
        String choix = request.getParameter("action");
       
        System.out.println("Dans controleur -> OK " + choix);
        switch(choix){
            case "inscription" : {
                System.out.println("Dans inscription -> OK");
                Action action = new ActionInscription();
                action.run(request);
                response.setContentType("text/html;charset=UTF-8");
                out.println("success");
                //Serialize(request); => resp
                //appel classe serialization pour mettre reponse en forme
                
                break;
            }
            case "connexion" : {
                System.out.println("Dans connexion -> OK");
                Action action = new ActionConnexion();
                action.run(request);
                response.setContentType("text/html;charset=UTF-8");
                //out = response.getWriter();
                out.println("success");
                break;
            }
//           case "reinitialisation" : {
//                Action action = new ActionReinitialisation();
//                action.run(request);
//                
//                break;
//            }
//           case "envoyer" : {
//                Action action = new ActionEnvoyerDemande();
//                action.run(request);
//                
//                break;
//            }
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
