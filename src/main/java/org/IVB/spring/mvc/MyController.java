package org.IVB.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {

    //url мапится на метод
    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails() {
        return "ask-emp-details-view";
    }

//    @RequestMapping("/showDetails")
//    public String showEmpDetails() {
//        return "show-emp-details-view";
//    }

    //request содержит всю инфо о запросе
//    @RequestMapping("/showDetails")
//    public String showEmpDetails(HttpServletRequest request, Model model) {
//        //извлекли введенное имя
//        String empName = request.getParameter("employeeName");
//
//        //изменили введенное имя
//        empName = "Mr. " + empName;
//
//        //добавили в модель, привязав к атрибуту
//        model.addAttribute("attributeName", empName);
//        return "show-emp-details-view";
//    }

    //связь поля формы с методом из контроллера
    @RequestMapping("/showDetails")
    public String showEmpDetails(@RequestParam("employeeName")
                                     String empName, Model model) {
        //изменили введенное имя
        empName = "Mr. "+empName+"!";

        //добавили в модель, привязав к атрибуту
        model.addAttribute("attributeName", empName);
        return "show-emp-details-view";
    }
}
