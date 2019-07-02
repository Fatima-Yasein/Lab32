package Task2;

public class Troubleshooter implements Builder,Role
{
    Person person = new Person();

    @Override
    public Builder setName(String name)
    {
        this.person.setName(name);
        return this;
    }

    @Override
    public Builder setSSN(String SSN)
    {
        this.person.setSSN(SSN);
        return this;
    }

    @Override
    public Builder setBD(String BD) {
        this.person.setBD(BD);
        return this;

    }

    @Override
    public Builder setGender(String gender) {
        this.person.setGender(gender);
        return this;

    }

    @Override
    public Builder setAge(double age) {
        this.person.setAge(age);
        return this;

    }

    @Override
    public Builder setExperience(double experience) {
        this.person.setExperience(experience);
        return this;

    }


    @Override
    public Person build() {
        return this.person;
    }

    @Override
    public Builder setRole()
    {
        this.person.setRole(returnJob());
        return this;
    }

    @Override
    public String returnJob() {
        return "Troubleshooter";
    }
}
