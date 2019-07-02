package Task2;

public class Test
{
    public static void main(String[] args) throws Exception
    {

//        PersonBuilder personBuilder = new PersonBuilder();
//
//        Person person = personBuilder.setName("Ahmed").setAge(20).setGender("Male").setBD("10/10/1999").setSSN("1222222").setExperience(0).build();
//
//        System.out.println("Name is: "+ person.getName());
//        System.out.println("Age is: "+ person.getAge());

        Builder personBuilder = (Builder) RoleFactory.getInstance(RoleType.DOCTOR);

        Person person = personBuilder.setName("Ahmed").setAge(20).setGender("Male").setBD("10/10/1999").setSSN("1222222").setExperience(0).setRole().build();

        System.out.println("Name is: "+ person.getName());
        System.out.println("Age is: "+ person.getAge());
        System.out.println("Role is: "+ person.getRole());



    }
}
