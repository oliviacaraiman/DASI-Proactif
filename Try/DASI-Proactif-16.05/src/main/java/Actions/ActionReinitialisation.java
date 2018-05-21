/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author mleral
 */
public class ActionReinitialisation extends Action {

    @Override
    public void run(HttpServletRequest req) {
        String mail = req.getParameter("mail");
        if (s.resetPassword(mail)) {
            req.setAttribute("status", "success");
        } else {
            req.setAttribute("status", "fail");
        }
    }
}
