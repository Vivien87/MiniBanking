
package com.vivi.controller;

import com.vivi.model.User;
import com.vivi.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author vivi
 */
@Controller
@RequestMapping(value = "/HB/Admin")
@SessionAttributes({"session_user"})
public class AdminController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/Users")
    public String administrarUsuarios(Model m) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); 
        User user = userService.getUserByUsername(name);
        m.addAttribute("session_user", user);
        m.addAttribute("lst", userService.getAll());
        return "admin_users";
    }

    
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value = "id") long id, Model m) {
        m.addAttribute("user", userService.getUserById(id));
        return "admin_users_edit";
    }

    
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute(value = "User") User user, HttpSession session) {
        User us = userService.getUserById(user.getUserId());

        us.setUsername(user.getUsername());
        us.setPassword(user.getPassword());
        us.setEmail(user.getEmail());
        us.getAccount().setBalance(user.getAccount().getBalance());

        userService.update(us);
        return "redirect:/HB/Admin/Users";
    }

  
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String remove(@RequestParam(value = "id") long id, Model m) {

        User user = userService.getUserById(id);
        userService.delete(user);
        return "redirect:/HB/Admin/Users";
    }

}
