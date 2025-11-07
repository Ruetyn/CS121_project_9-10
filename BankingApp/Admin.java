import java.io.Serializable;

public class Admin extends User implements Serializable {
        public Admin() {
                setUserName("admin");
                setPIN("0000");
        } // end Admin()

        @Override
        public String menu() {
                return "\n--- Admin Menu ---\n" + "0) Exit this menu\n" + "1) Full customer report\n" + "2) Add user\n" + "3) Apply interest to savings accounts\n" + "Action: ";
        } // end menu()

        @Override
        public void start() {
                // Admin functionality handled by Bank.startAdmin()
        } // end start()

        @Override
        public String getReport() {
                return "Admin user: " + getUserName();
        } // end getReport()
} // end class Admin
