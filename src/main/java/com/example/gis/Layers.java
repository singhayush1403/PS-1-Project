package com.example.gis;

import java.util.List;

public class Layers {
    List<Layer> layer;
    public void setLayer(List<Layer> layer){
        this.layer = layer;
    }
    public List<Layer> getLayer(){
        return this.layer;
    }
}

class Layer{
    private String name;

    private String href;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setHref(String href){
        this.href = href;
    }
    public String getHref(){
        return this.href;
    }
}
