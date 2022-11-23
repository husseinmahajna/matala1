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
public class TaskList implements Serializable {
    private String Name;
    private ArrayList<Task> Tasks;

    public TaskList(String Name, ArrayList<Task> Tasks) {
        this.Name = Name;
        this.Tasks = Tasks;
    }
  public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public ArrayList<Task> getTasks() {
        return Tasks;
    }

    public void setTasks(ArrayList<Task> Tasks) {
        this.Tasks = Tasks;
    }
}
