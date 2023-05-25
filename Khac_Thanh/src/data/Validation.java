package data;

import java.text.SimpleDateFormat;
import java.util.LinkedHashSet;
import java.util.Scanner;


public class Validation {
    Scanner SC = new Scanner(System.in);
    private LinkedHashSet<String> listUsername = new LinkedHashSet<>();
    private  static final String RED = "\033[0;31m";
    private static final String RESET = "\u001B[0m";
    
    public String inputUserName(){
        while(true){
            String name = SC.nextLine().trim();
            if(listUsername.contains(name.toLowerCase())){
                System.out.println(RED +"Username " + name + "already exists");
                System.out.print("Please enter again: "+ RESET);
                continue;
            }
                if(name.matches("^[a-zA-Z][a-zA-Z0-9-_]+$")){
                listUsername.add(name.toLowerCase());
                return name;
            }else if(!name.matches("^[A-Za-z].*")){
                System.err.println("User should be start with letter");
            }else{
                System.err.println("Username contains only letter, digit,'-' and '_' ");
            }
             System.out.print(RED +"Please enter again: "+ RESET);
        }
    }
    public String inputString(){
        while(true){
            String name = SC.nextLine().trim();
            if(name.isEmpty()){
                System.out.println(RED + "Invalid!!");
                System.out.print("Please enter again: "+ RESET);
                continue;
            }
            return name;
        }
    }
    public String inputName(){
        while(true){
            String name = SC.nextLine().trim();
            if(name.matches("[a-zA-Z\\s]+")){
                return nomalization(name);
            }
            System.out.println(RED + "Invalid!");
            System.out.print(RED + "Please enter again: "+ RESET);
        }
    }
    public String inputPhoneNumber(){
        while(true){
            String phone = SC.nextLine().trim();
            try{
                if(phone.matches("[0-9]{10,11}")){
                    return phone;
                }
            }catch(Exception e){
                System.out.println(e);
            }
            System.out.println(RED + "Phone number should be 10 or 11 numbers");
            System.out.print(RED + "Please enter again: "+ RESET);
        }
    }
    public String inputEmail(){
        while(true){
            String email = SC.nextLine().trim();
            if(email.matches("[a-zA-Z0-9]+@[a-zA-Z]+\\.com")){
                return email;
            }
            System.out.println(RED + "Invalid!");
            System.out.print(RED + "Please enter again: "+ RESET);
    
        }
    }
    public String inputDate(){
        while(true){
            String date = SC.nextLine().trim();
            if(date.matches("[\\d]{2}/[\\d]{2}/[\\d]{4}")){
                return date;
            }
            System.out.println(RED + "Invalid");
            System.out.print(RED + "Please enter again with format dd/mm/yyyy: "+ RESET);            
        }
    }
    
    public int inputPositiveInteger(int min, int max){
        while(true){
            try{
                int n = Integer.parseInt(SC.nextLine().trim());
                if(n < min || n > max){
                    System.out.println("Please enter in range " + min + " - " + max);
                }
                return n;
            }catch(NumberFormatException e){
                System.out.println(RED + "Invalid!");
                System.out.print(RED + "Please enter again: "+ RESET);    
            }
        }
    }
    
    public boolean inputYN(){
        while(true){
            String input = SC.nextLine().trim().toLowerCase();
            if(input.equals("y")){
                return true;
            }
            if(input.equals("n")){
                return false;
            }
            System.out.println(RED + "Invalid!" );
            System.out.println("Please choose Y or N" + RESET);
        }
    }
    public String nomalization(String str){
        str = str.trim();
        String save[] = str.split("\\s+");
        for (int i = 0; i < save.length; i++) {
            save[i] = save[i].substring(0,1).toUpperCase() + save[i].substring(1).toLowerCase();
        }
        str = String.join(" ", save);
        return str;
    }
}
