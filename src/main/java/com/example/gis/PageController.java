package com.example.gis;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class PageController {
    @RequestMapping("getlayers")
    public String getAliens(Model model) {
        String plainClientCredentials = "admin:geoserver";
        Base64.Encoder encoder = Base64.getEncoder();
        String base64ClientCredentials = new String(encoder.encode(plainClientCredentials.getBytes()));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64ClientCredentials);
        // headers.add("accept", "text/html");
        HttpEntity<String> request = new HttpEntity<String>(headers);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/geoserver/rest/layers";
        ResponseEntity<Root> response = restTemplate.exchange(url, HttpMethod.GET, request, Root.class);
       Layers list =  response.getBody().getLayers();
       
        
        model.addAttribute("title", "List of layers");
        model.addAttribute("list", list.layer);
        return "index";
    }
}