import java.io.BufferedReader;
import java.io.InputStreamReader;
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

    // A program az adatbázis kezeléshez DERBY-t használ.

    public static List<Schoolarship> schoolarships = new ArrayList<>();

    //Runnable Java main class
    public static void main(String[] args)
    {
        System.out.println("Üdvözlöm az alkalmazásban!");
        System.out.println("Fájl tartalmának beolvasása...");
        FileLoader fileLoader = new FileLoader(); //File loader module
        schoolarships = fileLoader.getDataFromJson("Universities_Schoolarships_All_Around_the_World.json");
        //2.feladat:
        DatabaseLoader dbLoader = new DatabaseLoader(); //Database loader module
        dbLoader.createDatabase(schoolarships);
        dbLoader.Query("SELECT * FROM Schoolarships");
        //3.feladat:

        try {
            System.out.println("Mi a alapján szeretne keresni?");
            System.out.println("1 - ID");
            System.out.println("2 - Cím");
            System.out.println("3 - Képzések");
            System.out.println("4 - Ösztöndíjak");
            System.out.println("5 - Dátum");
            System.out.println("6 - Helyszín");
            System.out.println("7 - Semmi");
            System.out.print("Válasz: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int response = Integer.valueOf(reader.readLine());
            switch(response)
            {
                case 1:
                {
                    System.out.print("Kulcsszó: ");
                    String keyword = reader.readLine();
                    search("ID", keyword);
                }break;

                case 2:
                {
                    System.out.print("Kulcsszó: ");
                    String keyword = reader.readLine();
                    search("TITLE", keyword);
                }break;

                case 3:
                {
                    System.out.print("Kulcsszó: ");
                    String keyword = reader.readLine();
                    search("DEGREES", keyword);

                }break;

                case 4:
                {
                    System.out.print("Kulcsszó: ");
                    String keyword = reader.readLine();
                    search("FUNDS", keyword);
                }break;

                case 5:
                {
                    System.out.print("Kulcsszó: ");
                    String keyword = reader.readLine();
                    search("DATE", keyword);
                }break;

                case 6:
                {
                    System.out.print("Kulcsszó: ");
                    String keyword = reader.readLine();
                    search("LOCATION", keyword);
                }break;

                case 7:
                {
                    System.out.print("Rendben!");
                }break;

                default:
                {
                    System.out.print("Kérem válaszoljon a kérdésre!");
                }break;
            }
        }catch(Exception ex)
        {
            System.out.println("Kérem válaszoljon a kérdésre!");

        }

        System.out.println("Program vége - Viszontlátásra!");
    }

    public static void search(String condition, String keyword)
    {
        for(int i = 0; i < schoolarships.size(); i++)
        {
            switch (condition)
            {
                case "ID":
                {
                    if(schoolarships.get(i).getId() == Integer.valueOf(keyword))
                    {
                        System.out.println("ID: " + schoolarships.get(i).getId());
                        System.out.println("Cím: " + schoolarships.get(i).getTitle());
                        System.out.println("Képzések: " + schoolarships.get(i).getDegrees());
                        System.out.println("Ösztöndíjak: " + schoolarships.get(i).getFunds());
                        System.out.println("Dátum: " + schoolarships.get(i).getDate());
                        System.out.println("Helyszín: " + schoolarships.get(i).getLocation());
                    }
                }break;

                case "TITLE":
                {
                    if(schoolarships.get(i).getTitle().contains(keyword))
                    {
                        System.out.println("ID: " + schoolarships.get(i).getId());
                        System.out.println("Cím: " + schoolarships.get(i).getTitle());
                        System.out.println("Képzések: " + schoolarships.get(i).getDegrees());
                        System.out.println("Ösztöndíjak: " + schoolarships.get(i).getFunds());
                        System.out.println("Dátum: " + schoolarships.get(i).getDate());
                        System.out.println("Helyszín: " + schoolarships.get(i).getLocation());
                    }
                }break;

                case "DEGREES":
                {
                    if(schoolarships.get(i).getDegrees().contains(keyword))
                    {
                        System.out.println("ID: " + schoolarships.get(i).getId());
                        System.out.println("Cím: " + schoolarships.get(i).getTitle());
                        System.out.println("Képzések: " + schoolarships.get(i).getDegrees());
                        System.out.println("Ösztöndíjak: " + schoolarships.get(i).getFunds());
                        System.out.println("Dátum: " + schoolarships.get(i).getDate());
                        System.out.println("Helyszín: " + schoolarships.get(i).getLocation());
                    }
                }break;

                case "FUNDS":
                {
                    if(schoolarships.get(i).getFunds().contains(keyword))
                    {
                        System.out.println("ID: " + schoolarships.get(i).getId());
                        System.out.println("Cím: " + schoolarships.get(i).getTitle());
                        System.out.println("Képzések: " + schoolarships.get(i).getDegrees());
                        System.out.println("Ösztöndíjak: " + schoolarships.get(i).getFunds());
                        System.out.println("Dátum: " + schoolarships.get(i).getDate());
                        System.out.println("Helyszín: " + schoolarships.get(i).getLocation());
                    }
                }break;

                case "DATE":
                {
                    if(schoolarships.get(i).getDate().contains(keyword))
                    {
                        System.out.println("ID: " + schoolarships.get(i).getId());
                        System.out.println("Cím: " + schoolarships.get(i).getTitle());
                        System.out.println("Képzések: " + schoolarships.get(i).getDegrees());
                        System.out.println("Ösztöndíjak: " + schoolarships.get(i).getFunds());
                        System.out.println("Dátum: " + schoolarships.get(i).getDate());
                        System.out.println("Helyszín: " + schoolarships.get(i).getLocation());
                    }
                }break;

                case "LOCATION":
                {
                    if(schoolarships.get(i).getLocation().contains(keyword))
                    {
                        System.out.println("ID: " + schoolarships.get(i).getId());
                        System.out.println("Cím: " + schoolarships.get(i).getTitle());
                        System.out.println("Képzések: " + schoolarships.get(i).getDegrees());
                        System.out.println("Ösztöndíjak: " + schoolarships.get(i).getFunds());
                        System.out.println("Dátum: " + schoolarships.get(i).getDate());
                        System.out.println("Helyszín: " + schoolarships.get(i).getLocation());
                    }
                }break;
            }
        }
        System.out.println("Keresés végrehajtva!");
    }

}
