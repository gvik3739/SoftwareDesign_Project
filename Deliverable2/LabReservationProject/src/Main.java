import model.HeadLabCoordinator;
import model.LabManager;
import model.User;
import service.RegistrationService;
import util.SystemClock;
import model.Equipment;

public class Main {
    public static void main(String[] args) {
        RegistrationService registrationService = new RegistrationService();

        User student = registrationService.registerUser(
                "student",
                "Ali",
                "ali@example.com",
                "Strong@123",
                "123456789",
                true
        );

        System.out.println("Created user type: " + student.getUserType());
        System.out.println("Hourly rate: " + student.getHourlyRate());

        SystemClock c1 = SystemClock.getInstance();
        SystemClock c2 = SystemClock.getInstance();
        System.out.println("Same SystemClock instance? " + (c1 == c2));
        System.out.println("Current time: " + c1.now());

        HeadLabCoordinator h1 = HeadLabCoordinator.getInstance();
        HeadLabCoordinator h2 = HeadLabCoordinator.getInstance();
        System.out.println("Same HeadLabCoordinator instance? " + (h1 == h2));

        LabManager manager = h1.createLabManagerAccount(
                "Manager1",
                "manager@example.com",
                "Admin@123",
                "LM001"
        );

        System.out.println("Created manager type: " + manager.getUserType());
        System.out.println("Manager ID: " + manager.getManagerId());

        Equipment microscope = manager.addEquipment(
                "EQ001",
                "Digital Microscope",
                "Lab A"
        );

        System.out.println("Equipment ID: " + microscope.getEquipmentId());
        System.out.println("Description: " + microscope.getDescription());
        System.out.println("Location: " + microscope.getLabLocation());
        System.out.println("Initial state: " + microscope.getCurrentStateName());
        System.out.println("Available? " + microscope.isAvailable());

        manager.disableEquipment(microscope);
        System.out.println("After disable: " + microscope.getCurrentStateName());
        System.out.println("Available? " + microscope.isAvailable());

        manager.enableEquipment(microscope);
        System.out.println("After enable: " + microscope.getCurrentStateName());
        System.out.println("Available? " + microscope.isAvailable());

        manager.markEquipmentUnderMaintenance(microscope);
        System.out.println("After maintenance: " + microscope.getCurrentStateName());
        System.out.println("Available? " + microscope.isAvailable());

        manager.enableEquipment(microscope);
        System.out.println("After maintenance finished: " + microscope.getCurrentStateName());
        System.out.println("Available? " + microscope.isAvailable());


    }
}