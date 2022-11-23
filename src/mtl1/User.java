/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mtl1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author WIN10
 */
public class User implements Serializable{
    private String Name,Family,email,password;
    private ArrayList<TaskList> tl;

    public User(String Name, String Family, String email, String password, ArrayList<TaskList> tl) {
        this.Name = Name;
        this.Family = Family;
        this.email = email;
        this.password = password;
        this.tl = tl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getFamily() {
        return Family;
    }

    public void setFamily(String Family) {
        this.Family = Family;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<TaskList> getTl() {
        return tl;
    }

    public void setTl(ArrayList<TaskList> tl) {
        this.tl = tl;
    }
 
    
public User(){
    
}
public void ShowTaskList(String name){
    for (int i = 0; i < this.getTl().size(); i++) {
        if(this.tl.get(i).getName().equals(name)){
            for (int j = 0; j < this.tl.get(i).getTasks().size(); j++) 
                this.tl.get(i).getTasks().get(j).toString();
            break;
        }
        else if(i== this.getTl().size()-1) System.out.print("There is no such list");
    }
}
   
    
    
    
}
