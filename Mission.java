public class Mission{
    //class fields
    private String missionName;
    private String missionCode;
    private String destinationPlanet;
    private int launchYear;
    private Double successRate;
    private Boolean mannedMission;

    //with Parameter constructor
    public Mission(String pMissionName, String pMissionCode, String pDestinationPlanet, int pLaunchYear, double pSuccessRate, boolean pMannedMission)
    {
        this.missionName = pMissionName;
        this.missionCode = pMissionCode;
        this.destinationPlanet = pDestinationPlanet;
        this.launchYear = pLaunchYear;
        this.successRate = pSuccessRate;
        this.mannedMission = pMannedMission;

    }
    //accessors(getters)
    public String getMissionName()
    {
        return missionName;
    }
    public String getMissionCode()
    {
        return missionCode;
    }
    public String getDestinationPlanet()
    {
        return destinationPlanet;
    }
    public int getLaunchYear()
    {
        return launchYear;
    }
    public double getSuccessRate()
    {
        return successRate;
    }
    public Boolean getMannedMission()
    {
        return mannedMission;
    }

    //setters(Mutators)
    public void setMissionName(String pMissionName)
    {
        missionName = pMissionName;
    }
    public void setMissionCode(String pMissionCode)
    {
        missionCode = pMissionCode;
    }
    public void setDestinationPlanet(String pDestinationPlanet)
    {
        destinationPlanet = pDestinationPlanet;
    }
    public void setLaunchYear(int pLaunchYear)
    {
        launchYear = pLaunchYear;
    }
    public void setSuccessRate(double pSuccessRate)
    {
        successRate = pSuccessRate;
    }
    public void setMannedMission(boolean pMannedMission)
    {
        mannedMission = pMannedMission;
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
    public String toString()
    {
        String missionString;
        missionString = "Mission name is " + missionName
        + "\n Mission code is " + missionCode
        + "\n Destination planet is " + destinationPlanet
        + "\n launch year is " + launchYear
        + "\n Success rate is " + successRate
        + "\n Manned mission status" + mannedMission;
        return missionString;
    }
     
}
