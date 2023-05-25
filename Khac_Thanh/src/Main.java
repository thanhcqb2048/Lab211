import data.UserManagement;
import data.Validation;
public class Main {
    public static void main(String[] args) {
        UserManagement mana = new UserManagement();
        Validation check = new Validation();
        int choice;
        do {
            System.out.println("============ Login Program ============");
            System.out.println("1. Add User");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println("Please choice one option: ");
            choice = check.inputPositiveInteger(1, 3);
            switch(choice){
                case 1: System.out.println("------------ Add User ------------");
                        mana.input();
                        mana.output();
                        break;
                case 2: System.out.println("------------ Login ------------");
                        mana.login();
                        break;
            }
        } while (choice != 3);
        
        
    }
}
