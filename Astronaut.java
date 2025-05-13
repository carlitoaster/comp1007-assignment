public class Astronaut 
{
    private String name;
    private String role;
    private int age;
    private String nationality;

    //Mutators(setters)
    public void setName(String name)
    {
        if (!name.isEmpty())
        {     
            this.name = name;
        }
    }
    public void setRole(String role)
    {
        this.role = role;
    }
    public void setAge(int age)
    {
        if (age>0)  
        {
            this.age = age; 
        }
    }
    public void setNationality(String nationality)
    {
        if (!nationality.isEmpty())
        {
            this.nationality = nationality;
        }   
    }

    //Accessors(getters)
    public String getName()
    {
        return this.name;
    }
    public String getRole()
    {
        return this.role;
    }
    public int getAge()
    {
        return this.age;
    }
    public String getNationality()
    {
        return this.nationality;
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
