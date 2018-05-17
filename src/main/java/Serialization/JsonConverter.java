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
        System.out.println("liste: " + liste.size());
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
    
    
}
