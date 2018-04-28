/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import fr.insalyon.dasi.services.Service;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author mleral
 */
public abstract class Action {
    protected Service s;
    public abstract void run(HttpServletRequest req);
    
}
