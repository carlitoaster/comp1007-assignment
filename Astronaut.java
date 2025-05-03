public class Astronaut 
{
    private String name;
    private String role;
    private int age;
    private String nationality;

    //Mutators(setters)
    public void setName(String pName)
    {
        name = pName;
    }
    public void setRole(String pRole)
    {
        role = pRole;
    }
    public void setAge(int pAge)
    {
        age = pAge;
    }

    //Accessors(getters)
    public String getName()
    {
        return name;
    }
    public String getRole()
    {
        return role;
    }
    public int getAge()
    {
        return age;
    }
    public String getNationality()
    {
        return nationality;
    }

    //methods
    public boolean equals(Object inObject)
    {
        boolean isEqual = false;
        Astronaut inAstronaut = null;
        if (inObject instanceof Astronaut)
        {
            inAstronaut = (Astronaut)inObject;
            if (name.equals(inAstronaut.getName()))
                if (role.equals(inAstronaut.getRole()))
                    if (age == inAstronaut.getAge())
                        if (nationality.equals(inAstronaut.getNationality()))
                        isEqual = true;
        }
        return isEqual;
    }
    
    public String toString()
    {
        String astronautString = "name is " + name + 
        "\n role is " + role + 
        "\n age is " + age +
        "\n nationality is " + nationality;
        return astronautString;
    }
}
