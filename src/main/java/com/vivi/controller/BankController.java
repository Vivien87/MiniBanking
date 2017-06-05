
package com.vivi.controller;

import com.vivi.model.Account;
import com.vivi.model.User;
import com.vivi.service.BankService;
import com.vivi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author vivi
 */
@Controller
@RequestMapping(value = "/HB")
@SessionAttributes({"session_user"})
public class BankController {

    @Autowired
    UserService userService;
    @Autowired
    BankService bankService;

    @RequestMapping(value = "/index")
    public String registrar(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); 
        User user = userService.getUserByUsername(name);

        model.addAttribute("session_user", user);
        return "home";
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.GET)
    public String transferencia() {
        return "home_transfer";
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public String transferenciaPost(
            @RequestParam("idAccountOrign") long idAccountOrign,
            @RequestParam("idAccountDestin") long idAccountDestin,
            @RequestParam("money") float money,
            Model m
    ) {
        Account accountOrig = bankService.getAccountById(idAccountOrign);
        Account accountDestin = bankService.getAccountById(idAccountDestin);
        if (accountDestin != null) {
            if (bankService.transfer(accountOrig, accountDestin, money)) {
                m.addAttribute("ok", "Exit");
            } else {
                m.addAttribute("ok", "Fail");
            }
        }
        else{
            m.addAttribute("ok", "Account destination no exist.");
        }

        return "home_transfer";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "newjsp";
    }

}
