import com.processes.store.Store;
import com.processes.thread.Client;
import com.processes.thread.Farmer;
import com.processes.util.Colors;

public class App {

    public static void main(String[] args) {
        
        Store store = new Store(5);

        Farmer paco = new Farmer("Paco", store, 5);

        Client faustino = new Client(store, "Faustino", 5);

        paco.start();
        faustino.start();

        try {
            paco.join();
            faustino.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Colors.ANSI_YELLOW + "\n" + "________________________________________________________________________________" +  Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_YELLOW + "________________________________________________________________________________" +  Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_YELLOW + "\t\t\t\t" + "Store Closed" + Colors.ANSI_RESET);

    }
    
}
