
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.internal.LinkedTreeMap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

//Simple Java class to manage file handling
public class FileLoader {



    public List<Schoolarship> getDataFromCsv(String filename)
    {
        try
        {
            List<Schoolarship> schoolarships = new ArrayList<>();
            BufferedReader reader =  new BufferedReader(new FileReader(filename));
            if(reader != null)
            {
                reader.readLine();
                String line;
                while ((line = reader.readLine()) != null)
                {
                    String[] words = line.split(",");
                    //Handling data from file
                    int id = Integer.valueOf(words[0]);
                    String title = words[1];
                    String[] degreesArray = words[2].split(",");
                    String degrees = "";
                    for(int i=0; i < degreesArray.length; i++)
                    {
                        degrees = degrees+degreesArray[i] + " ";
                    }
                    String funds = words[3];
                    String date = words[4];
                    String location = words[5];
                    Schoolarship newSchoolarship = new Schoolarship(id,title,degrees, funds, date, location);
                    schoolarships.add(newSchoolarship);

                }
                return schoolarships;
            }
        }catch (Exception ex)
        {
            System.out.println("Fájl beolvasási hiba!");
        }
        return null;
    }

    public void getDataFromXML(String filename)
    {
        try
        {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(new File(filename));
            doc.getDocumentElement().normalize();
            NodeList list = doc.getElementsByTagName("");
            for(int i = 0; i < list.getLength(); i++)
            {
                Node node = list.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element elem = (Element) node;
                    //Handling data from file
                    //String ghId = elem.getElementsByTagName("ghId").item(0).getTextContent();
                }
            }
        }catch (Exception ex)
        {
            System.out.println("Fájl beolvasási hiba!");
        }
    }

    public List<Schoolarship> getDataFromJson(String filename)
    {
        try {
            List<Schoolarship> schoolarships = new ArrayList<>();
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            //Handling data from file


            return schoolarships;
        }catch (Exception ex)
        {
            System.out.println("Fájl beolvasási hiba!");
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
