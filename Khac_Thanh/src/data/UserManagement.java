package data;
    
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class UserManagement {
    private static final String RED = "\033[0;31m";
    private static final String RESET = "\u001B[0m";
    
    private Scanner SC = new Scanner(System.in);    
    private ArrayList<User> list = new ArrayList<>();
    private Validation check = new Validation();
    //CONSTRUCTOR
    public UserManagement(){        
        User macdinh = new User("thanhcqb2048", "emtoidoimuoi","Thanh Nguyen", "0382293846", "thanhcqb2048@gmail.com", "Cat Que, Hoai Duc", "12/04/2003");
        list.add(macdinh);
    }
    //INPUT:
    public void input(){
        User temp = new User();
        System.out.print("Account: ");
        temp.userName = check.inputUserName();
        System.out.print("Password: ");
        temp.passWord = check.inputString();
        System.out.print("Name: ");
        temp.name = check.inputName();
        System.out.print("Phone number: ");
        temp.phone = check.inputPhoneNumber();
        System.out.print("Email: ");
        temp.email = check.inputEmail();
        System.out.print("Address: ");
        temp.address = check.inputString();
        System.out.print("Birthday: ");
        temp.dob = check.inputDate();
        list.add(temp);
    }

    public void output(){
        System.out.printf("|%20s|%10s|%20s|%11s|%25s||%10s|%8s\n", 
                            "userName", "passWord", "name", "phone", "email", "address", "dob");
        for(User i : list){
            System.out.println(i.toString());
        }
    }
    //LOGIN: 
    //Input account
    //Input password
    public void login(){
        System.out.print("Account: ");
        String account = check.inputString();
        System.out.print("Password: ");
        String password = check.inputString();
        //Kiểm tra xem có user đó có tồn tại không. Nếu có, trả về
        User save = findUserByUsername(account);
        if(save == null){
            System.out.println(RED + "Invalid username" + RESET);
            return;
        }      
        if(password.equals(save.passWord)){
            changePassword(save);
        }
        else{
            System.out.println(RED + "Password is incorrect" + RESET);
        }
            
    }
    public User findUserByUsername(String username){
        for(User i : list){
            if(i.userName.equalsIgnoreCase(username)){
                return i; 
            }
        }        
        return null;
    }
    
    public void changePassword(User i){
        System.out.println("------------ Welcome -------------");
        System.out.println("Hi " + i.getName() + ", do you want change your password? Y/N: ");
        if(!check.inputYN()){
            return;
        }
        while(true){
            System.out.println("");
            System.out.print("Old password: ");
            String old = check.inputString();
            System.out.print("New password: ");
            String newP = check.inputString();
            System.out.print("Renew password: ");
            String confirm = check.inputString();  
            //Check
            if (old.equals(i.passWord)) {
                if(newP.equals(confirm)){
                    System.out.println("Change password succesfully");
                    i.setPassWord(newP);
                    return;
                }
                else{
                    System.out.println(RED + "Password does not match" + RESET);
                    continue;
                }
            }else{
                System.out.println(RED + "Password is incorrect" + RESET);
            }
        }
        
    }
    
}
