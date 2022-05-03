import java.util.ArrayList;
import java.util.List;

public class Main {
 //C2 pad
    //Jegyzetek:
//Szoftverfejlesztés ZH k12 2022/2
//Keresztúri Gergő
//X7PT4C

//Ez a program Google Gson 2.8.2 könyvtárat használ, futtatás előtt szükséges
//hozzáadni a dependencies tulajdonságokhoz .jar fájlt ha nem ezt a
//projektet futtatja, nem IntelliJ fejlesztőkörnyezettel.

    //Runnable Java main class
    public static void main(String[] args)
    {
        System.out.println("Üdvözlöm az alkalmazásban!");
        System.out.println("Fájl tartalmának beolvasása...");
        FileLoader fileLoader = new FileLoader(); //File loader module
        List<Schoolarship> schoolarships = fileLoader.getDataFromCsv("Universities_Schoolarships_All_Around_the_World.csv");
        //2.feladat:
        DatabaseLoader dbLoader = new DatabaseLoader(); //Database loader module
        dbLoader.createDatabase(schoolarships);
        dbLoader.Query("SELECT * FROM Schoolarships");



    }



}
