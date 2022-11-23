/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package mtl1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author WIN10
 */
public class Mtl1 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc=new Scanner(System.in); 
        File F = new File("C:\\Users\\WIN10\\Documents\\NetBeansProjects\\mtl1\\src\\mtl1\\db.dat");
       //creating data base file 
       F.createNewFile();
        FileOutputStream fos=new FileOutputStream(F,true);
        FileInputStream fis=new FileInputStream(F);
         ObjectOutputStream oos=new ObjectOutputStream(fos);
         ObjectInputStream ois=new ObjectInputStream(fis);
        
        //////
       while(true){
            boolean goback=false;
           System.out.print("Enter 1 To Login \n Enter 2 To Reister\n ");
           String mainchoise = sc.nextLine();
        if(mainchoise.equals("1")){//login
        User u1=new User();
        System.out.print("Enter Email- ");  
        u1.setEmail( sc.nextLine());
        System.out.print("Enter Password- ");  
        u1.setPassword( sc.nextLine());
        // recieving data 
        
        

        while(true){
            User u;
            try{
            u = (User)ois.readObject();
            } catch(Exception e){System.out.print("There is no such email\n");goback=true;break;}
            if(u1.getEmail().equals(u.getEmail())){
               u1=u ;break;
            }
        }
        
        if(goback)continue;
        //validating the data
         System.out.print("Enter 1 To Add Task \n Enter 2 To Add TaskList \n Enter 3 To Delete TaskList \n Enter 4 To Show TaskList- ");  
         int choise=sc.nextInt();
         if(choise==1){
             Task t = new Task();
             System.out.print("Enter Task Name- ");  
             String tempinput=sc.nextLine();
        t.setName(tempinput);
        System.out.print("Enter Task Description - "); 
        tempinput=sc.nextLine();
        t.setDescription(tempinput);
        System.out.print("Enter importance number (between 1 to 3 )- ");
        int tempnum=0;
        try{
         tempnum=sc.nextInt();
        } catch(Exception e){System.out.print("invalid format");}
        t.setImportant(tempnum);
        System.out.print("Enter Expected Finish Date - ");  
            SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
           try{ 
        t.setEndDate( formatter1.parse(sc.nextLine()) );
           }catch(ParseException e){System.out.print("wrong date format");}
        System.out.print("Enter yes if Done and no if Not- ");  
        String temp=sc.nextLine();
       if(temp.toUpperCase().equals("YES"))
           t.setDone(true);
       else t.setDone(false);
       
        //getting new task details
          System.out.print("Enter The Name of the TaskList you want to add the new task to");  
          String tempname=sc.nextLine();
          boolean found=false;
          for(int i=0;i<u1.getTl().size();i++)
              if(u1.getTl().get(i).getName().equals(tempname)){
                    u1.getTl().get(i).getTasks().add(t);found=true;
              }
          if(!found){
             ArrayList<Task> templist= new ArrayList<Task>();
             templist.add(t);
              u1.getTl().add(new TaskList(tempname,templist));
          }
              

          
          }
         //add task 
         
         
         if(choise==2){
               System.out.print("Enter The Name of the TaskList you want to add");  
          String tempname=sc.nextLine();
             for (int i = 0; i <u1.getTl().size(); i++) {
                 if(u1.getTl().get(i).getName().equals(tempname)){
                     System.out.print("The task list name you have entered already exist");
                     break;
                 }
                 else if(i==u1.getTl().size()-1) 
                     u1.getTl().add(new TaskList(tempname,new ArrayList<Task>()));
             }
         }
         //add tasklist
         if(choise==3){
                 System.out.print("Enter The Name of the TaskList you want to delete");  
          String tempname=sc.nextLine();
             for (int i = 0; i <u1.getTl().size(); i++) {
                 if(u1.getTl().get(i).getName().equals(tempname)){
                     u1.getTl().remove(i);
                     break;
                 }
                 else if(i==u1.getTl().size()-1) 
                     System.out.print("The task list name you have entered does not exist");
             }
         }  
         
         //delete tasklist
         if(choise==4){
              System.out.print("Enter The Name of the TaskList you want to show");  
          String tempname=sc.nextLine();
          if(u1.getTl()!=null&&u1.getTl().size()>0)
          u1.ShowTaskList(tempname);
          else System.out.print("There is no Lists");
         }
         //show tasklist
break;
        
        } else if(mainchoise.equals("2")){//register
           User u1=new User();
        System.out.print("Enter Name- ");  
        u1.setName( sc.nextLine());
        System.out.print("Enter Password- "); 
        u1.setPassword( sc.nextLine());
         System.out.print("Enter Email- "); 
        u1.setEmail( sc.nextLine());
         System.out.print("Enter Family- "); 
        u1.setFamily( sc.nextLine());
        //details of the new user
       

        while(true){
            User u;
            try{
            u = (User)ois.readObject();
            } catch(Exception e){oos.writeObject(u1);oos.close();break;}
            if(u1.getEmail().equals(u.getEmail())){
                System.out.print("The email already exist\n");
                goback=true;break;
            }
        }
        
        }
                if(!goback)break;

        }

    }
    
    }
    

