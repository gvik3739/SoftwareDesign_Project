package randoop;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ErrorTest0 {

    public static boolean debug = false;

    @Test
    public void test01() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test01");
        util.SystemClock systemClock0 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime1 = systemClock0.now();
        java.time.LocalDateTime localDateTime2 = systemClock0.now();
        strategy.FacultyPricingStrategy facultyPricingStrategy3 = new strategy.FacultyPricingStrategy();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        systemClock0.notifyObservers((java.lang.Object) facultyPricingStrategy3);
    }

    @Test
    public void test02() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test02");
        data.MaintainPayment maintainPayment0 = new data.MaintainPayment();
        java.lang.String str1 = maintainPayment0.nextId();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        maintainPayment0.update("Researcher");
    }

    @Test
    public void test03() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test03");
        data.MaintainPayment maintainPayment0 = new data.MaintainPayment();
        model.Payment[] paymentArray1 = new model.Payment[] {};
        java.util.ArrayList<model.Payment> paymentList2 = new java.util.ArrayList<model.Payment>();
        boolean boolean3 = java.util.Collections.addAll((java.util.Collection<model.Payment>) paymentList2, paymentArray1);
        maintainPayment0.payments = paymentList2;
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        maintainPayment0.update("R001");
    }

    @Test
    public void test04() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test04");
        util.SystemClock systemClock0 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime1 = systemClock0.now();
        java.time.LocalDateTime localDateTime2 = systemClock0.now();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        systemClock0.tick();
    }

    @Test
    public void test05() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test05");
        data.MaintainPayment maintainPayment0 = new data.MaintainPayment();
        model.Payment[] paymentArray1 = new model.Payment[] {};
        java.util.ArrayList<model.Payment> paymentList2 = new java.util.ArrayList<model.Payment>();
        boolean boolean3 = java.util.Collections.addAll((java.util.Collection<model.Payment>) paymentList2, paymentArray1);
        maintainPayment0.payments = paymentList2;
        java.util.List<model.Payment> paymentList5 = maintainPayment0.payments;
        maintainPayment0.load("Student");
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        maintainPayment0.update("Researcher");
    }

    @Test
    public void test06() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test06");
        data.MaintainReservation maintainReservation0 = new data.MaintainReservation();
        java.lang.String str1 = maintainReservation0.nextId();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        maintainReservation0.update("R001");
    }

    @Test
    public void test07() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test07");
        data.MaintainEquipment maintainEquipment0 = new data.MaintainEquipment();
        java.util.List<model.Equipment> equipmentList1 = maintainEquipment0.getAvailableEquipment();
        model.Equipment equipment3 = maintainEquipment0.findById("P001");
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        maintainEquipment0.update("Modify reservation  to 2026-03-25 18:41 \u2192 2026-03-25 18:41");
    }

    @Test
    public void test08() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test08");
        data.MaintainPayment maintainPayment0 = new data.MaintainPayment();
        model.Payment[] paymentArray1 = new model.Payment[] {};
        java.util.ArrayList<model.Payment> paymentList2 = new java.util.ArrayList<model.Payment>();
        boolean boolean3 = java.util.Collections.addAll((java.util.Collection<model.Payment>) paymentList2, paymentArray1);
        maintainPayment0.payments = paymentList2;
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        maintainPayment0.update("Guest");
    }

    @Test
    public void test09() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test09");
        data.MaintainReservation maintainReservation0 = new data.MaintainReservation();
        java.lang.String str1 = maintainReservation0.nextId();
        java.util.List<model.Reservation> reservationList2 = maintainReservation0.reservations;
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        maintainReservation0.update("Faculty");
    }

    @Test
    public void test10() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test10");
        util.SystemClock systemClock0 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime1 = systemClock0.now();
        model.HeadLabCoordinator headLabCoordinator2 = model.HeadLabCoordinator.getInstance();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        systemClock0.notifyObservers((java.lang.Object) headLabCoordinator2);
    }

    @Test
    public void test11() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test11");
        data.MaintainReservation maintainReservation0 = new data.MaintainReservation();
        java.lang.String str1 = maintainReservation0.nextId();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        maintainReservation0.update("Modify reservation  to 2026-03-25 18:41 \u2192 2026-03-25 18:41");
    }

    @Test
    public void test12() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test12");
        data.MaintainEquipment maintainEquipment0 = new data.MaintainEquipment();
        maintainEquipment0.load("Research Grant");
        model.Equipment equipment4 = maintainEquipment0.findById("Faculty");
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        maintainEquipment0.update("Research Grant");
    }

    @Test
    public void test13() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test13");
        data.MaintainPayment maintainPayment0 = new data.MaintainPayment();
        model.Payment[] paymentArray1 = new model.Payment[] {};
        java.util.ArrayList<model.Payment> paymentList2 = new java.util.ArrayList<model.Payment>();
        boolean boolean3 = java.util.Collections.addAll((java.util.Collection<model.Payment>) paymentList2, paymentArray1);
        maintainPayment0.payments = paymentList2;
        maintainPayment0.load("ACTIVE");
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        maintainPayment0.update("Guest");
    }

    @Test
    public void test14() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test14");
        data.MaintainReservation maintainReservation0 = new data.MaintainReservation();
        java.lang.String str1 = maintainReservation0.nextId();
        service.ReservationService reservationService4 = new service.ReservationService("Research Grant", "ACTIVE");
        java.util.List<model.Reservation> reservationList6 = reservationService4.getReservationsForEquipment("Guest");
        maintainReservation0.reservations = reservationList6;
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        maintainReservation0.update("Institutional Account");
    }

    @Test
    public void test15() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test15");
        data.MaintainPayment maintainPayment0 = new data.MaintainPayment();
        model.Payment[] paymentArray1 = new model.Payment[] {};
        java.util.ArrayList<model.Payment> paymentList2 = new java.util.ArrayList<model.Payment>();
        boolean boolean3 = java.util.Collections.addAll((java.util.Collection<model.Payment>) paymentList2, paymentArray1);
        maintainPayment0.payments = paymentList2;
        java.util.List<model.Payment> paymentList5 = maintainPayment0.payments;
        maintainPayment0.load("Student");
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        maintainPayment0.update("R001");
    }

    @Test
    public void test16() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test16");
        util.SystemClock systemClock0 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime1 = systemClock0.now();
        java.time.LocalDateTime localDateTime2 = systemClock0.now();
        java.time.LocalDateTime localDateTime3 = systemClock0.now();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        systemClock0.tick();
    }

    @Test
    public void test17() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test17");
        util.SystemClock systemClock0 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime1 = systemClock0.now();
        // during test generation this statement threw an exception of type java.lang.NullPointerException in error
        systemClock0.notifyObservers((java.lang.Object) true);
    }
}

