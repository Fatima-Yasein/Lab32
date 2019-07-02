package Task2;

public interface Builder
{
    Builder setName(String name);
    Builder setSSN(String SSN);
    Builder setBD(String BD);
    Builder setGender(String gender);
    Builder setAge(double age);
    Builder setExperience(double experience);
    Person build();
    Builder setRole();

}
