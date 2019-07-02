package Task1;

public class DisabledPeople implements License
{
    @Override
    public String checkLicense()
    {
        return "This is A disabled people car license";
    }
}