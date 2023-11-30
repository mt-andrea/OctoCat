/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kati
 */
public class Szo {
    private int szoID;
    private String lecke;
    private String idegenNyelv;
    private String idegenSzo;
    private String magyar;
    
    public Szo(int szoID, String lecke, String idegenNyelv, String idegenSzo, String magyar){
          this.szoID = szoID;
          this.lecke =lecke;
          this.idegenNyelv = idegenNyelv;
          this.idegenSzo = idegenSzo;
          this.magyar = magyar;
    }
    public int getSzoID(){
        return szoID;
    }
    public String getLecke(){
        return lecke;
    }
    public String getIdegenNyelv(){
        return idegenNyelv;
    }
    public String getIdegenSzo(){
        return idegenSzo;
    }
    public String getMagyar(){
        return magyar;
    }
    
          
    
    
}
