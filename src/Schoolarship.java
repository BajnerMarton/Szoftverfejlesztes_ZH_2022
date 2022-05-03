//Simple Java class to represent received data as an Object
public class Schoolarship {
    private int id;
    private String title;
    private String degrees;
    private String funds;
    private String date;
    private String location;

    //Constructor
    public Schoolarship(int _id, String _title, String _degrees, String _funds, String _date, String _location)
    {
        this.id = _id;
        this.title = _title;
        this.degrees = _degrees;
        this.funds = _funds;
        this.date = _date;
        this.location = _location;
    }

    //Getters and Setters, automatically generated, just in case..
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDegrees() {
        return degrees;
    }

    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

    public String getFunds() {
        return funds;
    }

    public void setFunds(String funds) {
        this.funds = funds;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
