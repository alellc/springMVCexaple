package aula114.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import aula114.springmvc.service.EmployeeService;
import aula114.springmvc.domain.Contact;

import java.util.List;
import java.util.ArrayList;

@Controller
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;
  
  @RequestMapping("/show")
  public String show (Model model,@RequestParam("clave") String id){
    /*System.out.println("Prueba"+id);*/
    Contact c = employeeService.show(id);
    model.addAttribute("aContact",c);
    return "show";
  }
  
  @RequestMapping("/employee")
  public String consulta(Model model){
    List<String> list = employeeService.listIdEmployee();
    model.addAttribute("list",list);
    return "consulta";
  }
}
