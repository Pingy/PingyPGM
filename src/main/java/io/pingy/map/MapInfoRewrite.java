package io.pingy.map;

import java.util.List;

/**
 * Created by thlappy on 9/16/2016.
 */
public class MapInfoRewrite {

    private String mapName;
    private String author;
    private String proto;
    private String version;
    private String objective;
    private String limit;
    private String mapGamemode;
    private List mapContributers;

    public void setMapName(String mapName){
        this.mapName = mapName;
    }
    public String getMapName(){
        return  mapName;
    }

    public void setMapGamemode(String mapGamemode) { this.mapGamemode = mapGamemode; }
    public String getMapGamemode(){ return mapGamemode; }

    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return author;
    }

    public void setProto(String proto){
        this.proto = proto;
    }
    public String getProto(){
        return proto;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    public String getVersion() {
        return version;
    }

    public void setObjective(String objective){
        this.objective = objective;
    }
    public String getObjective(){
        return objective;
    }

    public void setLimit(String limit){
        this.limit = limit;
    }
    public String getLimit(){
        return limit;
    }
}
