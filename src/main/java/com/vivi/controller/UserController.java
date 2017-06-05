
package com.vivi.controller;

import com.vivi.model.User;
import com.vivi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author vivi
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/registr", method = RequestMethod.GET)
    public ModelAndView registrar(Model model) {
        ModelAndView modelAndView = new ModelAndView("registr");
        modelAndView.addObject("User", new User());
        return modelAndView;
    }

    @RequestMapping(value = "/registr", method = RequestMethod.POST)
    public String registrar(@ModelAttribute(value = "user") User user) {
       
        
        userService.create(user);
        return "redirect:/HB/index";
    }

}
