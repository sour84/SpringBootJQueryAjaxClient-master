package com.javasampleapproach.jqueryajax.controller;

//import org.osgi.service.useradmin.User;


import com.javasampleapproach.jqueryajax.model.ContactEntity;
import com.javasampleapproach.jqueryajax.repository.ContactRepository;
import com.javasampleapproach.jqueryajax.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created for JavaStudy.ru on 28.02.2016.
 */

@Controller
//@RestController
public class ORMController {


    @Autowired
    private  ContactService contactService;

//    private List<ContactEntity> contactEntities = contactService.findAll();
//    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
//    public String viewPersonList(Model model) {
//
//        model.addAttribute("persons", contactEntities);
//
//        return "personList";
//    }

//    @RequestMapping(value = "/all", method = RequestMethod.GET)
//    public List<ContactEntity> retrieveAllStudents() {
//        return contactService.findAll();
//    }

    @RequestMapping(value = "/queryFindAllUsersJPA", method = RequestMethod.GET)
    public ModelAndView queryFindAllUsersJPA() {
        List<ContactEntity> contact = contactService.findAll();
        return new ModelAndView("person", "resultObject", contact);

    }

    @RequestMapping(value ="/result", method = RequestMethod.POST)
    public ModelAndView result(@ModelAttribute("lastName")String lastName){
        List<ContactEntity> contact= contactService.findByLastName(lastName);
        return new ModelAndView("person", "resultObject", contact);
    }

    @RequestMapping(value = "/newContact", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        ContactEntity contactEntity = new ContactEntity();
        model.addObject("contactEntity", contactEntity);
        model.setViewName("new-employee");
        return model;
    }

    @RequestMapping(value = "/saveContact", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute ContactEntity contactEntity) {
        contactService.save(contactEntity);
     return queryFindAllUsersJPA();
    }
    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("id"));
        contactService.delete(contactId);
        return queryFindAllUsersJPA();
    }

   @RequestMapping(value = "/edit", method = RequestMethod.GET)
   public ModelAndView editArticle(HttpServletRequest request) {
       int contactId = Integer.parseInt(request.getParameter("id"));
       ModelAndView model = new ModelAndView();
       ContactEntity contactEntity = contactService.findById(contactId);
       model.addObject("contactEntity", contactEntity);
       model.setViewName("new-employee");
       return model;
   }


}