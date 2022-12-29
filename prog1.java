import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class prog1 
{
    public static void main(String[] args) 
    {
        StringBuilder strbild = new StringBuilder();
        try (BufferedReader bufread = new BufferedReader(new FileReader("Task1.txt"))) 
        {
            String txt;
            while ((txt = bufread.readLine()) != null) 
            {
                strbild.append(txt);
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        String str = strbild.toString();
        System.out.println(str);

        str = str.replace("{", "").replace("}", "");
        String[] str2 = str.split(", ");
    
        Map<String, String> map = new HashMap<String, String>();
        for (String item : str2)
        {
            String[] strnew = item.split(":");
            for (int i = 0; i < str2.length; i++)
            {
                map.put(strnew[0], strnew[1]);
            }
        }

        StringBuilder WHERE = new StringBuilder();
        for (Map.Entry<String, String> i : map.entrySet())
        {
            if (i.getValue().equals("\"null\""))
            {
                continue;
            }
            WHERE.append(i.getKey()).append(" = ").append(i.getValue()).append(" and ");
        }
        WHERE.delete(WHERE.length() - 5, WHERE.length());
        
        System.out.println("select * from students WHERE " + WHERE);
    }
}
