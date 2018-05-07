/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serialization;

import com.google.gson.JsonObject;
import fr.insalyon.dasi.entities.Person;

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
        return jsonPersonne;
    }

}
