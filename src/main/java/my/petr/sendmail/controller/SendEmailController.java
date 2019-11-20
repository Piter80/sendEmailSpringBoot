package my.petr.sendmail.controller;

import my.petr.sendmail.dto.EmailModel;
import my.petr.sendmail.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SendEmailController {
  @Autowired
  SendEmailService service;

  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public String getHome(){
    return "formInsertEmail";
  }


  @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
  public String insertEmail(@ModelAttribute("formEmail") EmailModel emailEntities, Model model){

    String emailAddress = emailEntities.getRecipientEmail();
    boolean check = service.sendEmail(emailAddress);
    if (check){
      return "index";
    }else {
      model.addAttribute("invalidCredentials",true);
      return "formInsertEmail";
    }
  }
}
