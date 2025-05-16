import java.io.*;
import java.util.*;
public class MissionController
{
    private Mission[] missionArray = new Mission[20];
    private Astronaut[] astronautArray = new Astronaut[20];
    private int missionCount = 0;
    private int astronautCount = 0;
    private String fileName;
    private Scanner sc; 

    public MissionController(Scanner sc) 
    {
        loadDataFromCSV(fileName);
        this.sc = sc;
    }

    public void loadDataFromCSV(String fileName)
    {
        boolean isHeader = true;
        try
        {
            FileInputStream fis = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);

            String line = reader.readLine();
            
            while(line!= null)
            {
                if (isHeader)
                {
                    isHeader = false;
                    continue;
                }

                String[] parts = line.split(",");
                int lineLength = parts.length;
                if (lineLength ==9)
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
                        missionArray[missionCount++] = new Mission(missionName,missionCode,destinationPlanet,launchYear,successRate,mannedMission);
                        
                        // Parse astronauts
                        String[] astronautEntries = parts[6].split("\\|");

                        for (int i = 0; i < astronautEntries.length; i++) {
                            String[] details = astronautEntries[i].split(":");
                            String name = details[0];
                            String role = details[1];
                            int age = Integer.parseInt(details[2]);
                            String nationality = details[3];
                            astronautArray[astronautCount++] = new Astronaut(name, role, age, nationality, missionCode);
                        }
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("skipping invalid line at line: " + line);
                    }

                }
            }
            reader.close();
            System.out.println("imported " + missionCount + "missions");
            System.out.println("imported " + astronautCount + "astronautArray");
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
            System.out.println(missionArray[i].missionToString());
        }
    }
    public void viewMannedMissions()
    {
        for (int i = 0;i<missionCount;i++)
        {
            if (missionArray[i].getMannedMission()==true)
            {
                System.out.println(missionArray[i].missionToString());
            }
        }
    }
    public void viewUnmannedMissions()
    {
        for (int i = 0;i<missionCount;i++)
        {
            if (missionArray[i].getMannedMission()==false)
            {
                System.out.println(missionArray[i].missionToString());
            }
        }
    }
    public void viewMissionAstronauts()
    {
        System.out.println("Enter mission code of mission");
        String missionCode = sc.nextLine();
        for (int i = 0;i<astronautCount;i++)
        {
            if (astronautArray[i].getMissionCode().equals(missionCode))
            {
                System.out.println("astronaut " + (i+1) + " : " + astronautArray[i].astronautToString());
            }
        }
        
    }
    public void viewMissionSuccessRateSummary()
    {
        double sum = 0;
        double min = missionArray[0].getSuccessRate();
        double max = missionArray[0].getSuccessRate();
        double curr;
        for (int i =0;i<missionCount;i++)
        {
            curr = missionArray[i].getSuccessRate();
            sum += curr;
            if (curr<min)
            {
                min = curr;
            }
            if (curr> max)
            {
                max = curr;
            }
        }
        double average = sum/missionCount;
        System.out.println("highest success rate is: " + max);
        System.out.println("lowest success rate is: " + min);
        System.out.println("average success rate is: " + average);
        
    }
    public void viewAstronautsByNationality()
    {
        System.out.println("What nationality of astronauts you would like to view?");
        String nationality = sc.nextLine();
        for (int i = 0;i<astronautCount;i++)
        {
            if (astronautArray[i].getNationality().equals(nationality))
            {
                System.out.println(astronautArray[i].astronautToString());
            }
        }
    }
    public void addMission()
    {
        System.out.println("\nAdd New Mission");
              // Get and validate mission name
        String name;
        do 
        {
            System.out.print("Enter mission name: ");
            name = sc.nextLine().trim();
            if (name.isEmpty()) 
            {
                System.out.println("Mission name cannot be empty. Please try again.");
            }
        } while (name.isEmpty());

        // Get and validate mission code
        String code;
        do 
        {
            System.out.print("Enter mission code: ");
            code = sc.nextLine().trim();
            if (code.isEmpty()) 
            {
                System.out.println("Mission code cannot be empty. Please try again.");
            }
        } while (code.isEmpty());

        // Get and validate destination planet
        String destination;
        do 
        {
            System.out.print("Enter destination planet: ");
            destination = sc.nextLine().trim();
            if (destination.isEmpty()) 
            {
                System.out.println("Destination cannot be empty. Please try again.");
            }
        } while (destination.isEmpty());

        // Get and validate launch year
        int launchYear;
        while (true) {
            try 
            {
                System.out.print("Enter launch year (1900-2100): ");
                launchYear = Integer.parseInt(sc.nextLine());
                if (launchYear >= 1900 && launchYear <= 2100) {
                    break;
                }
                System.out.println("Launch year must be between 1900 and 2100.");
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid year format. Please enter a number.");
            }
        }

        // Get and validate success rate
        double successRate;
        while (true) {
            try 
            {
                System.out.print("Enter success rate (0-100): ");
                successRate = Double.parseDouble(sc.nextLine());
                if (successRate >= 0 && successRate <= 100) {
                    break;
                }
                System.out.println("Success rate must be between 0 and 100.");
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Invalid percentage format. Please enter a number.");
            }
        }

        // Get and validate manned status
        boolean mannedMission;
        while (true) 
        {
            System.out.print("Is this a manned mission? (y/n): ");
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("y")) 
            {
                mannedMission = true;
                break;
            } 
            else if (input.equals("n")) 
            {
                mannedMission = false;
                break;
            }
            else
            {
                System.out.println("Please enter 'y' or 'n'.");
            }
        }
        missionCount++;
        missionArray[missionCount] = new Mission(name, code, destination, launchYear, successRate, mannedMission);
        System.out.println("Mission added successfully!");
    }
    public void editExistingMission()
    {
        if (missionCount == 0) 
        {
            System.out.println("No missions available to edit.");
            return;
        }

        System.out.println("Enter mission code of mission you would like to edit: ");
        String code = sc.nextLine().trim();
        
        for (int i = 0; i < missionCount; i++) 
        {
            if (missionArray[i].getMissionCode().equals(code)) 
            {
                Mission missionToEdit = missionArray[i];
                
                System.out.println("\nEditing Mission: " + missionToEdit.getMissionName());
                System.out.println("Current details:");
                System.out.println(missionToEdit.missionToString()); 
                
                // Edit Mission Name
                System.out.print("\nEnter new mission name (or press Enter to keep current): ");
                String newName = sc.nextLine().trim();
                if (!newName.isEmpty()) 
                {
                    missionToEdit.setMissionName(newName);
                }
                
                // Edit Destination Planet
                System.out.print("\nEnter new destination planet (or press Enter to keep current): ");
                String newDestination = sc.nextLine().trim();
                if (!newDestination.isEmpty()) 
                {
                    missionToEdit.setDestinationPlanet(newDestination);
                }
                
                // Edit Launch Year
                boolean validYear = false;
                while (!validYear) {
                    System.out.print("\nEnter new launch year (1900-2100) or -1 to keep current: ");
                    try 
                    {
                        String yearInput = sc.nextLine().trim();
                        if (yearInput.equals("-1") || yearInput.isEmpty()) 
                        {
                            validYear = true;
                        } 
                        else 
                        {
                            int newYear = Integer.parseInt(yearInput);
                            missionToEdit.setLaunchYear(newYear);
                            validYear = true;
                        }
                    } 
                    catch (NumberFormatException e) 
                    {
                        System.out.println("Please enter a valid year (1900-2100).");
                    } 
                    catch (IllegalArgumentException e) 
                    {
                        System.out.println(e.getMessage());
                    }
                }
                
                // Edit Success Rate
                boolean validRate = false;
                while (!validRate) 
                {
                    System.out.print("\nEnter new success rate (0-100) or -1 to keep current: ");
                    try 
                    {
                        String rateInput = sc.nextLine().trim();
                        if (rateInput.equals("-1") || rateInput.isEmpty()) 
                        {
                            validRate = true;
                        } 
                        else 
                        {
                            double newRate = Double.parseDouble(rateInput);
                            missionToEdit.setSuccessRate(newRate);
                            validRate = true;
                        }
                    } 
                    catch (NumberFormatException e) 
                    {
                        System.out.println("Please enter a valid number (0-100).");
                    } 
                    catch (IllegalArgumentException e) 
                    {
                        System.out.println(e.getMessage());
                    }
                }
                
                // Edit Manned Status
                boolean validStatus = false;
                while (!validStatus) 
                {
                    System.out.print("\nUpdate manned status? (y/n/Enter to keep current): ");
                    String statusInput = sc.nextLine().trim().toLowerCase();
                    if (statusInput.isEmpty()) 
                    {
                        validStatus = true;
                    } 
                    else if (statusInput.equals("y")) 
                    {
                        missionToEdit.setMannedMission(true);
                        validStatus = true;
                    } 
                    else if (statusInput.equals("n"))
                    {
                        missionToEdit.setMannedMission(false);
                        validStatus = true;
                    }
                    else 
                    {
                        System.out.println("Please enter 'y', 'n', or press Enter to skip.");
                    }
                }
                
                System.out.println("\nMission updated successfully!");
                System.out.println("Updated details:");
                System.out.println(missionToEdit.missionToString());
            }
        }
    }
}