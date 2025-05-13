import java.io.*;
import java.util.*;
public class MissionController
{
    private Mission[] missions;
    private int missionCount = 0;
    private int astronautCount = 0;
    private String fileName;
    private Astronaut[] astronauts;
    private Scanner sc = new Scanner(System.in);
    
    public void loadDataFromCSV()
    {
        System.out.println("which file to load data from?");
        fileName = sc.nextLine();
        try
        {
            FileInputStream fis = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);

            String line = reader.readLine();
            while(line!= null)
            {
                String[] parts = line.split(",");
                int lineLength = parts.length;
                if (lineLength >=6)
                {
                    try
                    {
                        //mission fields
                        String missionName = parts[0];
                        String missionCode = parts[1];
                        String destinationPlanet = parts[2];
                        int launchYear = Integer.parseInt(parts[3]);
                        double successRate = Double.parseDouble(parts[4]);
                        boolean mannedMission = Boolean.parseBoolean(parts[5]);
                        missions[missionCount] = new Mission(missionName,missionCode,destinationPlanet,launchYear,successRate,mannedMission);
                        missionCount++;
                        //Astronaut fields
                        String name = parts[6];
                        String role = parts[7];
                        int age =  Integer.parseInt(parts[8]);
                        String nationality = parts[9];
                        astronauts[astronautCount] = new Astronaut(name,role,age,nationality);
                        missionCount++;
               
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("skipping invalid line at line: " + line);
                    }

                }
            }
            reader.close();
            System.out.println("imported " + missionCount + "missions");
            System.out.println("imported " + astronautCount + "astronauts");
        }
        catch(FileNotFoundException e)
            {
                System.out.println("File not found: " + fileName);
            }
        catch(IOException e)
            {
                System.out.println("Error reading file: " + fileName);
            }
    }
    public void viewMissions()
    {
        for (int i =0;i<missionCount;i++)
        {
            System.out.println(missions[i].missionToString());
        }
    }
}