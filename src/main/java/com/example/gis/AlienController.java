package com.example.gis;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ch.qos.logback.core.encoder.Encoder;

@RestController
public class AlienController {
    @RequestMapping("/aliens")
    public List<Layer> getAliens() {
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
        System.out.println(response.getBody().getLayers());
        List<String> aliens = new ArrayList<String>();
        aliens.add("ayush");
        aliens.add("syuh");

        return response.getBody().getLayers().getLayer();
    }
}