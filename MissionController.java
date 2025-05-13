import java.io.*;
import java.util.*;
public class MissionController
{
    private Mission[] missions;
    private int missionCount;
    String fileName;
    
    public void loadMissionsFromFile(String fileName)
    {
        try
        {
            FileInputStream fis = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);
        }
        catch(FileNotFoundException e)
            {
                System.out.println("File not found: " + fileName);
            }
        catch(IOException e)
            {
                System.out.println("Error reading file: " + fileName);
            }
        reader.close();
    }
}