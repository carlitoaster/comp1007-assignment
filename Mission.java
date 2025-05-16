public class Mission{
    //class fields
    private String missionName;
    private String missionCode;
    private String destinationPlanet;
    private int launchYear;
    private Double successRate;
    private Boolean mannedMission;

    //with Parameter constructor
    public Mission(String MissionName, String MissionCode, String DestinationPlanet, int LaunchYear, double SuccessRate, boolean MannedMission)
    {
        this.missionName = MissionName;
        this.missionCode = MissionCode;
        this.destinationPlanet = DestinationPlanet;
        this.launchYear = LaunchYear;
        this.successRate = SuccessRate;
        this.mannedMission = MannedMission;
    }
    
    //accessors(getters)
    public String getMissionName()
    {
        return this.missionName;
    }
    public String getMissionCode()
    {
        return this.missionCode;
    }
    public String getDestinationPlanet()
    {
        return this.destinationPlanet;
    }
    public int getLaunchYear()
    {
        return this.launchYear;
    }
    public double getSuccessRate()
    {
        return this.successRate;
    }
    public Boolean getMannedMission()
    {
        return this.mannedMission;
    }

    //setters(Mutators)
    public void setMissionName(String missionName)
    {
        if (!missionName.isEmpty())
        {
            this.missionName = missionName;
        }
    }
    public void setMissionCode(String missionCode)
    {
        if (!missionCode.isEmpty())
        {
            this.missionCode = missionCode;
        }
    }
    public void setDestinationPlanet(String destinationPlanet)
    {
        if (!destinationPlanet.isEmpty())
        {
            this.destinationPlanet = destinationPlanet;
        }   
    }
    public void setLaunchYear(int launchYear)
    {
        if (launchYear>=1900 && launchYear<=2100)
        {
            this.launchYear = launchYear;
        }
    }
    public void setSuccessRate(double successRate)
    {
        if ((successRate)>=0 && launchYear<=100)
        {
            this.successRate = successRate;
        }
    }
    public void setMannedMission(boolean mannedMission)
    {
        this.mannedMission = mannedMission;
    }

    //methods 

    public boolean equals(Object inObject)
    {
        boolean isEqual = false;
        Mission inMission = null;
        if (inObject instanceof Mission)
        {
            inMission = (Mission)inObject;
            if (missionName.equals(inMission.getMissionName()))
                if (missionCode.equals(inMission.getMissionCode()))
                    if (destinationPlanet.equals(inMission.getDestinationPlanet()))
                        if (launchYear == inMission.getLaunchYear())
                            if (successRate == inMission.getSuccessRate())
                                if (mannedMission.equals(inMission.getMannedMission()))
                                    isEqual = true;
        }
        return isEqual;
    }
    public String missionToString()
    {
        String missionString;
        missionString = "Mission name:" + missionName
        + "\n Mission code:" + missionCode
        + "\n Destination planet:" + destinationPlanet
        + "\n launch year:" + launchYear
        + "\n Success rate:" + successRate
        + "\n Manned mission status: " + mannedMission;
        return missionString;
    }
     
}
