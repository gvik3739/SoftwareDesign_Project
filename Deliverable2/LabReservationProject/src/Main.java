import model.Equipment;
import model.EquipmentSensorSystem;
import model.HeadLabCoordinator;
import model.LabManager;
import model.Reservation;
import model.UsageRecord;
import model.User;
import service.LateArrivalObserver;
import service.RegistrationService;
import service.SensorUpdateObserver;
import util.SystemClock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

        Equipment microscope = new Equipment("EQ001", "Microscope", "Lab A");
        Reservation reservation = new Reservation(
                "R001",
                student,
                microscope,
                LocalDateTime.now().minusMinutes(30),
                LocalDateTime.now().plusHours(1),
                student.getHourlyRate()
        );

        List<Reservation> reservations = new ArrayList<>();
        reservations.add(reservation);

        LateArrivalObserver lateArrivalObserver = new LateArrivalObserver(reservations);
        c1.attach(lateArrivalObserver);
        c1.tick();

        EquipmentSensorSystem sensorSystem = new EquipmentSensorSystem();
        SensorUpdateObserver sensorUpdateObserver = new SensorUpdateObserver();
        sensorSystem.attach(sensorUpdateObserver);

        sensorSystem.sendStatusUpdate(microscope, "IN_USE");

        UsageRecord usageRecord = new UsageRecord(
                "UR001",
                LocalDateTime.now().minusMinutes(40),
                LocalDateTime.now(),
                "Completed Successfully"
        );

        sensorSystem.sendUsageUpdate(microscope, usageRecord);
    }
}
