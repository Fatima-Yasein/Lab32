package Task1;


public class LicenseFactory
{
    public static License getInstance(LicenseType licenseType) throws Exception
    {
        switch (licenseType)
        {
            case MOTORCYCLE:
                return new Motorcycles();

            case SCOOTERS:
                return new Scooters();

            case CONSTRUCTION:
                return new Construction();

            case AGRICULTURE:
                return new Agriculture();

            case MANUAL_GEAR:
                return new ManualGear();

            case AUTOMATIC_GEAR:
                return new AutomaticGear();

            case TAXI:
                return new Taxi();

            case MINIBUS:
                return new Minibus();

            case TRAILERS:
                return new Trailers();

            case BUSES:
                return new Buses();

            case DISABLED_PEOPLE:
                return new DisabledPeople();

        }

        throw new Exception("“Undefined License Type");
    }
}
