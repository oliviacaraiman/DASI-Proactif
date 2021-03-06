/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import fr.insalyon.dasi.entities.Employee;
import fr.insalyon.dasi.entities.Intervention;
import fr.insalyon.dasi.entities.InterventionAnimal;
import fr.insalyon.dasi.entities.InterventionLivraison;
import fr.insalyon.dasi.entities.Person;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author olivi
 */
public class JsonConverter {

    public JsonConverter() {
    }

    public static JsonObject personToJson(Person p) {

        JsonObject jsonPersonne = new JsonObject();
        jsonPersonne.addProperty("civilite", p.getHonorific());
        jsonPersonne.addProperty("nom", p.getFirstName());
        jsonPersonne.addProperty("prenom", p.getLastName());
        jsonPersonne.addProperty("mail", p.getEmail());
        return jsonPersonne;
    }
    
    public static JsonArray interventionsClientToJson(List<Intervention> liste) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm dd/MM/yyyy");
        JsonArray jsonListe = new JsonArray();
        for(Intervention i : liste) {
            JsonObject jsonIntervention = new JsonObject();
            jsonIntervention.addProperty("type", i.getType());
            jsonIntervention.addProperty("date", sdf.format(i.getStartDate()));
            jsonIntervention.addProperty("employe", i.getEmployee().getFirstName() +" "+ i.getEmployee().getLastName());
            jsonIntervention.addProperty("description", i.getDescription());
            if (i.getEndDate() != null) {
                jsonIntervention.addProperty("statut", "Fini");
                jsonIntervention.addProperty("dateFin", sdf.format(i.getEndDate()));
            } else {
                jsonIntervention.addProperty("statut", "En cours");
                jsonIntervention.addProperty("dateFin", "");
            }
            
            if (i instanceof InterventionLivraison) {
                String objet = ((InterventionLivraison) i).getSubject();
                jsonIntervention.addProperty("objet", objet);
                String entreprise = ((InterventionLivraison) i).getCompany();
                jsonIntervention.addProperty("entreprise", entreprise);
            } else if (i instanceof InterventionAnimal) {
                String animal = ((InterventionAnimal) i).getAnimal();
                jsonIntervention.addProperty("animal", animal);
            }
            jsonListe.add(jsonIntervention);
        }
        return jsonListe;
    }
    
    public static JsonObject coordonnesEmployeToJson(Person e) {
        JsonObject jsonCoordonnesEmploye = new JsonObject();
        jsonCoordonnesEmploye.addProperty("latEmp", e.getAddress().getGeoCoords().lat);
        jsonCoordonnesEmploye.addProperty("longEmp", e.getAddress().getGeoCoords().lng);
        return jsonCoordonnesEmploye;
    }
    
     public static JsonObject interventionToDoByEmployeToJson(Intervention i) {
         
         SimpleDateFormat sdf = new SimpleDateFormat("hh:mm dd/MM/yyyy");
         JsonObject jsonIntervention = new JsonObject();
         jsonIntervention.addProperty("type", i.getType());
         jsonIntervention.addProperty("id", i.getId());
            jsonIntervention.addProperty("date", sdf.format(i.getStartDate()));
            jsonIntervention.addProperty("client", i.getClient().getFirstName() +" "+ i.getClient().getLastName());
            jsonIntervention.addProperty("description", i.getDescription());

            if (i instanceof InterventionLivraison) {
                String objet = ((InterventionLivraison) i).getSubject();
                jsonIntervention.addProperty("objet", objet);
                String entreprise = ((InterventionLivraison) i).getCompany();
                jsonIntervention.addProperty("entreprise", entreprise);
            } else if (i instanceof InterventionAnimal) {
                
                String animal = ((InterventionAnimal) i).getAnimal();
                System.out.println("ici:" +animal);
                jsonIntervention.addProperty("animal", animal);
            }
        
        return jsonIntervention;
    }
    
    public static JsonArray interventionsJourToJson(List<Intervention> liste) {
        JsonArray jsonListe = new JsonArray();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm dd/MM/yyyy");
        for(Intervention i : liste) {
            JsonObject jsonInterventionsJour = new JsonObject();
            jsonInterventionsJour.addProperty("lat", i.getClient().getAddress().getGeoCoords().lat);
            jsonInterventionsJour.addProperty("long", i.getClient().getAddress().getGeoCoords().lng);
            jsonInterventionsJour.addProperty("type", i.getType());
            jsonInterventionsJour.addProperty("date", sdf.format(i.getStartDate()));
            jsonInterventionsJour.addProperty("client", i.getClient().getFirstName() +" "+ i.getClient().getLastName());
            jsonInterventionsJour.addProperty("description", i.getDescription());
            if (i.getEndDate() != null) {
                jsonInterventionsJour.addProperty("statut", "Fini");
                jsonInterventionsJour.addProperty("dateFin", sdf.format(i.getEndDate()));
            } else {
                jsonInterventionsJour.addProperty("statut", "En cours");
                jsonInterventionsJour.addProperty("dateFin", "");
            }
            
            if (i instanceof InterventionLivraison) {
                String objet = ((InterventionLivraison) i).getSubject();
                jsonInterventionsJour.addProperty("objet", objet);
                String entreprise = ((InterventionLivraison) i).getCompany();
                jsonInterventionsJour.addProperty("entreprise", entreprise);
            } else if (i instanceof InterventionAnimal) {
                String animal = ((InterventionAnimal) i).getAnimal();
                jsonInterventionsJour.addProperty("animal", animal);
            }

            jsonListe.add(jsonInterventionsJour);
        }
        return jsonListe;
    }public static JsonArray interventionsEmployeToJson(List<Intervention> liste) {
        System.out.println("liste: " + liste.size());
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm dd/MM/yyyy");
        JsonArray jsonListe = new JsonArray();
       // JsonObject jsonIntervention = new JsonObject();
        for(Intervention i : liste) {
            JsonObject jsonIntervention = new JsonObject();
            jsonIntervention.addProperty("type", i.getType());
            jsonIntervention.addProperty("date", sdf.format(i.getStartDate()));
            jsonIntervention.addProperty("client", i.getClient().getFirstName() +" "+ i.getClient().getLastName());
            jsonIntervention.addProperty("description", i.getDescription());
            if (i.getEndDate() != null) {
                jsonIntervention.addProperty("statut", "Fini");
                jsonIntervention.addProperty("dateFin", sdf.format(i.getEndDate()));
            } else {
                jsonIntervention.addProperty("statut", "En cours");
                jsonIntervention.addProperty("dateFin", "");
            }
            
            if (i instanceof InterventionLivraison) {
                String objet = ((InterventionLivraison) i).getSubject();
                jsonIntervention.addProperty("objet", objet);
                String entreprise = ((InterventionLivraison) i).getCompany();
                jsonIntervention.addProperty("entreprise", entreprise);
            } else if (i instanceof InterventionAnimal) {
                String animal = ((InterventionAnimal) i).getAnimal();
                jsonIntervention.addProperty("animal", animal);
            }
            
            
            jsonListe.add(jsonIntervention);
        }
        System.out.println("ksmlka: " +jsonListe.size());
        return jsonListe;
    }
    
}
