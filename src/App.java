import com.processes.store.Store;
import com.processes.thread.Client;
import com.processes.thread.Farmer;
import com.processes.util.Colors;

public class App {
    public static void main(String[] args) throws Exception {
        Store store = new Store();

        Farmer paco = new Farmer("Paco", store);
        Farmer ramon = new Farmer("Ramon", store);

        Client faustino = new Client(store, "Faustino", 5);
        Client gentleman = new Client(store, "Mr.Gentleman", 10);
        Client loquendo = new Client(store, "Loquendo", 5);

        paco.start();
        ramon.start();

        faustino.start();
        gentleman.start();
        loquendo.start();

        try {
            paco.join();
            ramon.join();
            faustino.join();
            gentleman.join();
            loquendo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Colors.ANSI_YELLOW + "\n" + "________________________________________________________________________________" +  Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_YELLOW + "________________________________________________________________________________" +  Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_YELLOW + "\t\t\t\t" + "Store Closed" + Colors.ANSI_RESET);
    }
}
