/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mtl1;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author WIN10
 */
public class Task implements Serializable {
    private String name , description;
    private int important;
   private boolean done;
   private Date endDate;

    public Task(String name, String description, int important, boolean done, Date endDate) {
        this.name = name;
        this.description = description;
        this.important = important;
        this.done = done;
        this.endDate = endDate;
    }
public Task(){
    
}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImportant() {
        return important;
    }

    public void setImportant(int important) {
        this.important = important;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Task{" + "name=" + name + ", description=" + description + ", important=" + important + ", done=" + done + ", endDate=" + endDate + '}';
    }
    
    
}
