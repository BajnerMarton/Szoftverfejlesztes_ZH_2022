import java.sql.*;
import java.util.List;


//Simple Java class to manage database connection
public class DatabaseLoader {

    private Connection loaderConn;
    public void createDatabase(List<Schoolarship> schoolarshipList)
    {
        try
        {
            Connection conn = DriverManager.getConnection("jdbc:derby:SchoolarshipsDB;create=false");
            Statement stmt = conn.createStatement();

            System.out.println("Adatbázis létrehozva...");

            System.out.println("Adattáblák létrehozva! Feltöltés...");
            for(int i = 0; i < schoolarshipList.size(); i++)
            {
                String funds = schoolarshipList.get(i).getFunds().substring(1);
                if(schoolarshipList.get(i).getLocation().startsWith("$"))
                    schoolarshipList.get(i).setLocation(schoolarshipList.get(i).getLocation().substring(1));

                String sqlQuery = "INSERT INTO Schoolarships VALUES (" + schoolarshipList.get(i).getId() + ", '" + schoolarshipList.get(i).getTitle() + "', '" + schoolarshipList.get(i).getDegrees() + "', '" + funds + "', '" + schoolarshipList.get(i).getDate() + "', '" + schoolarshipList.get(i).getLocation() + "')";

                stmt.executeUpdate(sqlQuery);
            }
            System.out.println("Adattáblák feltöltve!");
            conn.close();
            loaderConn = conn;

        }catch(Exception ex)
        {
            System.out.println("SQL Hiba!");
            System.out.println(ex.getMessage());
        }


    }

    public Connection connectToDatabase(String link, String user, String pass)
    {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(link, user, pass);
        } catch (SQLException e) {
            System.out.println("SQL Hiba!");
        }

        return conn;
    }

    public void Query(String queryStr)
    {
        try {
            System.out.println("Lekérdezés...");
            if (loaderConn != null) {
                Statement stmt = loaderConn.createStatement();
                ResultSet resultSet = stmt.executeQuery(queryStr);
                while (resultSet.next()) {
                    //Handle data from sql query
                    System.out.println("ID: " + resultSet.getInt(0));
                    System.out.println("Title: " + resultSet.getString(1));
                    System.out.println("Degrees: " + resultSet.getString(2));
                    System.out.println("Funds: " + resultSet.getString(3));
                    System.out.println("Date: " + resultSet.getString(4));
                    System.out.println("Location: " + resultSet.getString(5));
                }
            }
                loaderConn.close();
            }catch(Exception ex)
            {
                System.out.println("SQL Hiba!");
            }

    }

}
