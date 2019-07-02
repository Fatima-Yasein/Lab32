package Task1;

public class Test
{
    public static void main(String[] args) throws Exception
    {
        License license = LicenseFactory.getInstance(LicenseType.AGRICULTURE);
        System.out.println(" For Agriculture ==> "+ license.checkLicense());

        license = LicenseFactory.getInstance(LicenseType.TAXI);
        System.out.println(" For Taxi ==> "+ license.checkLicense());

    }
}
