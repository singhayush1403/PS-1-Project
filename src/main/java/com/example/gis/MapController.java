package com.example.gis;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MapController {
    @RequestMapping("/map")
    String getMap(@RequestParam("name") String name,Model model){
        String[] arr = name.split(":");
       model.addAttribute("server", arr[0]);
       model.addAttribute("layername", arr[1]);
        model.addAttribute("name", name);
        return "OpenLayers map preview";
    }
}