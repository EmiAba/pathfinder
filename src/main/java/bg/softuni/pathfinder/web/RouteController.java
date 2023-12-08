package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.Level;
import bg.softuni.pathfinder.model.dto.AddRouteBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/routes")
public class RouteController {

    @GetMapping("/add")
    public ModelAndView addRoute(){
     ModelAndView modelAndView=  new ModelAndView("add-route");
     modelAndView.addObject("levels", Level.getEnumsAsList());
             return modelAndView;
    }


    @PostMapping("/add")
    public ModelAndView addRoute(AddRouteBindingModel addRouteBindingModel){

        System.out.println( "emi");



        return  new ModelAndView("add-route");
    }




}
