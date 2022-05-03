import java.sql.*;
import java.util.List;


//Simple Java class to manage database connection
public class DatabaseLoader {

    private Connection loaderConn;
    public void createDatabase(List<Schoolarship> schoolarshipList)
    {
        try
        {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/", "admin", "admin");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE DATABASE Schoolarships_DB");
            System.out.println("Adatbázis létrehozva...");
            stmt.executeUpdate("CREATE TABLE Schoolarships ( ID INT PRIMARY KEY, TITLE VARCHAR(500), DEGREES VARCHAR(500), FUNDS VARCHAR(50), DATE VARCHAR(50), LOCATION VARCHAR(50))");
            System.out.println("Adattáblák létrehozva! Feltöltés...");
            for(int i = 0; i < schoolarshipList.size(); i++)
            {
                String sqlQuery = "INSERT INTO Schoolarships VALUES (" + schoolarshipList.get(i).getId() + ", '" + schoolarshipList.get(i).getTitle() + "', '" + schoolarshipList.get(i).getDegrees() + "', '" + schoolarshipList.get(i).getFunds() + "', " + schoolarshipList.get(i).getDate() + "', '" + schoolarshipList.get(i).getLocation() + "');";
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
