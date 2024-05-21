import database.PolyBayDatabase;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        PolyBayDatabase poly1 = new PolyBayDatabase("localhost", 3306, "poly_bay", "Marel","M@relsig@n152");
        
    }
    
}
