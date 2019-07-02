package Task2;

public class RoleFactory
{
    public static Role getInstance(RoleType roleType) throws Exception
    {
        switch (roleType)
        {
            case SOLDIER:
                return new Soldire();
            case ENGINEER:
                return new Engineer();
            case DOCTOR:
                return new Doctor();
            case COOKER:
                return new Cooker();
            case BUILDER:
                return new BuilderClass();
            case PILOT:
                return new Pilot();
            case TROUBLESHOOTER:
                return new Troubleshooter();
            case SINGER:
                return new Singer();
            case DESIGNER:
                return new Designer();
        }
        throw  new Exception("Unlisted job Role");
    }
}
// still did not make the classes
//yes
