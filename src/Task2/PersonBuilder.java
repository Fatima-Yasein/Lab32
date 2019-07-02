package Task2;

public class PersonBuilder
{
    Person person = new Person();

    public PersonBuilder setName(String name)
    {
        this.person.setName(name);

        return this;
    }

    public PersonBuilder setSSN(String SSN)
    {
        this.person.setSSN(SSN);

        return this;
    }

    public PersonBuilder setBD(String BD)
    {
        this.person.setBD(BD);

        return this;
    }

    public PersonBuilder setGender(String gender)
    {
        this.person.setGender(gender);

        return this;
    }

    public PersonBuilder setAge(double age)
    {
        this.person.setAge(age);

        return this;
    }

    public PersonBuilder setExperience(double experience)
    {
        this.person.setExperience(experience);

        return this;
    }


    public Person build()
    {
        return this.person;
    }


}
