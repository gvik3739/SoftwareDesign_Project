package randoop;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    @Test
    public void test001() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test001");
        model.Reservation reservation0 = null;
        java.time.LocalDateTime localDateTime1 = null;
        command.ExtendReservationCommand extendReservationCommand3 = new command.ExtendReservationCommand(reservation0, localDateTime1, "Research Grant");
        // The following exception was thrown during execution in test generation
        try {
            extendReservationCommand3.execute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        java.time.LocalDateTime localDateTime11 = reservation10.getEndTime();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str12 = reservation10.getEquipmentId();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime11);
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        service.RegistrationService registrationService0 = new service.RegistrationService();
        // The following exception was thrown during execution in test generation
        try {
            model.User user7 = registrationService0.registerUser("hi!", "R001", "hi!", "hi!", "", false);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Password must contain uppercase, lowercase, digit, and symbol.");
        } catch (java.lang.IllegalArgumentException e) {
        // Expected exception.
        }
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        java.time.LocalDateTime localDateTime11 = null;
        reservation10.setStartTime(localDateTime11);
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        model.Reservation reservation0 = null;
        java.time.LocalDateTime localDateTime1 = null;
        command.ExtendReservationCommand extendReservationCommand3 = new command.ExtendReservationCommand(reservation0, localDateTime1, "Research Grant");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean4 = extendReservationCommand3.canExecute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        command.CommandManager commandManager0 = new command.CommandManager();
        java.lang.Class<?> wildcardClass1 = commandManager0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        util.SystemClock systemClock0 = util.SystemClock.getInstance();
        util.Observer observer1 = null;
        systemClock0.attach(observer1);
        util.Observer observer3 = null;
        systemClock0.attach(observer3);
        // The following exception was thrown during execution in test generation
        try {
            systemClock0.tick();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock0);
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        reservation10.forfeitDeposit();
        java.lang.String str12 = reservation10.getReservationId();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str13 = reservation10.getEquipmentId();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        model.Payment payment8 = new model.Payment("R001", "R001", "hi!", (double) '4', "", "P001", "P001", "");
        double double9 = payment8.getAmount();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 52.0d + "'", double9 == 52.0d);
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        command.CommandManager commandManager0 = new command.CommandManager();
        java.util.List<command.ReservationCommand> reservationCommandList1 = commandManager0.getHistory();
        model.Reservation reservation2 = null;
        java.time.LocalDateTime localDateTime3 = null;
        command.ExtendReservationCommand extendReservationCommand5 = new command.ExtendReservationCommand(reservation2, localDateTime3, "Research Grant");
        java.lang.String str6 = extendReservationCommand5.getErrorMessage();
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean7 = commandManager0.execute((command.ReservationCommand) extendReservationCommand5);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationCommandList1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "" + "'", str6.equals(""));
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        reservation10.forfeitDeposit();
        java.lang.String str12 = reservation10.getReservationId();
        model.Guest guest18 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment19 = null;
        util.SystemClock systemClock20 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime21 = systemClock20.now();
        util.SystemClock systemClock22 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime23 = systemClock22.now();
        model.Reservation reservation25 = new model.Reservation("P001", (model.User) guest18, equipment19, localDateTime21, localDateTime23, 10.0d);
        util.SystemClock systemClock26 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime27 = systemClock26.now();
        command.ModifyReservationCommand modifyReservationCommand29 = new command.ModifyReservationCommand(reservation10, localDateTime21, localDateTime27, "");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean30 = modifyReservationCommand29.canExecute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock26);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime27);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        model.Reservation reservation0 = null;
        java.time.LocalDateTime localDateTime1 = null;
        command.ExtendReservationCommand extendReservationCommand3 = new command.ExtendReservationCommand(reservation0, localDateTime1, "Research Grant");
        java.lang.String str4 = extendReservationCommand3.getErrorMessage();
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean5 = extendReservationCommand3.canExecute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "" + "'", str4.equals(""));
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        data.MaintainEquipment maintainEquipment0 = new data.MaintainEquipment();
        java.util.List<model.Equipment> equipmentList1 = null;
        maintainEquipment0.equipmentList = equipmentList1;
        model.Equipment[] equipmentArray3 = new model.Equipment[] {};
        java.util.ArrayList<model.Equipment> equipmentList4 = new java.util.ArrayList<model.Equipment>();
        boolean boolean5 = java.util.Collections.addAll((java.util.Collection<model.Equipment>) equipmentList4, equipmentArray3);
        maintainEquipment0.equipmentList = equipmentList4;
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipmentArray3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean5 + "' != '" + false + "'", boolean5 == false);
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        data.MaintainEquipment maintainEquipment0 = new data.MaintainEquipment();
        model.Equipment[] equipmentArray1 = new model.Equipment[] {};
        java.util.ArrayList<model.Equipment> equipmentList2 = new java.util.ArrayList<model.Equipment>();
        boolean boolean3 = java.util.Collections.addAll((java.util.Collection<model.Equipment>) equipmentList2, equipmentArray1);
        maintainEquipment0.equipmentList = equipmentList2;
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipmentArray1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        data.MaintainUser maintainUser0 = new data.MaintainUser();
        model.User user2 = maintainUser0.findByEmail("P001");
        model.Guest guest7 = new model.Guest("", "Research Grant", "", "hi!");
        model.Guest guest13 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment14 = null;
        util.SystemClock systemClock15 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime16 = systemClock15.now();
        util.SystemClock systemClock17 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime18 = systemClock17.now();
        model.Reservation reservation20 = new model.Reservation("P001", (model.User) guest13, equipment14, localDateTime16, localDateTime18, 10.0d);
        model.Guest guest25 = new model.Guest("hi!", "hi!", "", "hi!");
        model.Guest guest31 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment32 = null;
        util.SystemClock systemClock33 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime34 = systemClock33.now();
        util.SystemClock systemClock35 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime36 = systemClock35.now();
        model.Reservation reservation38 = new model.Reservation("P001", (model.User) guest31, equipment32, localDateTime34, localDateTime36, 10.0d);
        model.User[] userArray39 = new model.User[] { guest7, guest13, guest25, guest31 };
        java.util.ArrayList<model.User> userList40 = new java.util.ArrayList<model.User>();
        boolean boolean41 = java.util.Collections.addAll((java.util.Collection<model.User>) userList40, userArray39);
        maintainUser0.users = userList40;
        // The following exception was thrown during execution in test generation
        try {
            maintainUser0.update("hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(user2);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime18);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock33);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime34);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime36);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(userArray39);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + true + "'", boolean41 == true);
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        model.Reservation reservation0 = null;
        java.time.LocalDateTime localDateTime1 = null;
        command.ExtendReservationCommand extendReservationCommand3 = new command.ExtendReservationCommand(reservation0, localDateTime1, "Research Grant");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str4 = extendReservationCommand3.getDescription();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        util.SystemClock systemClock7 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime8 = systemClock7.now();
        util.SystemClock systemClock9 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime10 = systemClock9.now();
        model.Reservation reservation12 = new model.Reservation("P001", (model.User) guest5, equipment6, localDateTime8, localDateTime10, 10.0d);
        double double13 = reservation12.getDepositAmount();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock9);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double13 + "' != '" + 10.0d + "'", double13 == 10.0d);
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        service.BillingService billingService0 = new service.BillingService();
        // The following exception was thrown during execution in test generation
        try {
            double double3 = billingService0.calculateFeeWithDeposit(1.0d, false);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: Pricing strategy not set");
        } catch (java.lang.IllegalStateException e) {
        // Expected exception.
        }
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        reservation10.forfeitDeposit();
        java.lang.String str12 = reservation10.getReservationId();
        boolean boolean13 = reservation10.isDepositForfeited();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str14 = reservation10.getEquipmentId();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        java.time.LocalDateTime localDateTime11 = reservation10.getStartTime();
        java.lang.Class<?> wildcardClass12 = reservation10.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass12);
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        model.Faculty faculty5 = new model.Faculty("", "P001", "hi!", "R001", true);
        boolean boolean6 = faculty5.isApproved();
        java.lang.String str7 = faculty5.getName();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        service.BillingService billingService0 = new service.BillingService();
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy1 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str2 = researchGrantPaymentStrategy1.getMethodName();
        boolean boolean4 = researchGrantPaymentStrategy1.processPayment(0.0d);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy1);
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy6 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str7 = researchGrantPaymentStrategy6.getMethodName();
        boolean boolean9 = researchGrantPaymentStrategy6.processPayment(0.0d);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy6);
        // The following exception was thrown during execution in test generation
        try {
            double double11 = billingService0.getHourlyRate();
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: Pricing strategy not set");
        } catch (java.lang.IllegalStateException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str2 + "' != '" + "Research Grant" + "'", str2.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Research Grant" + "'", str7.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        service.RegistrationService registrationService0 = new service.RegistrationService();
        // The following exception was thrown during execution in test generation
        try {
            model.User user7 = registrationService0.registerUser("", "hi!", "ACTIVE", "ACTIVE", "R001", true);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Password must contain uppercase, lowercase, digit, and symbol.");
        } catch (java.lang.IllegalArgumentException e) {
        // Expected exception.
        }
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        reservation10.forfeitDeposit();
        java.lang.String str12 = reservation10.getReservationId();
        model.Guest guest18 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment19 = null;
        util.SystemClock systemClock20 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime21 = systemClock20.now();
        util.SystemClock systemClock22 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime23 = systemClock22.now();
        model.Reservation reservation25 = new model.Reservation("P001", (model.User) guest18, equipment19, localDateTime21, localDateTime23, 10.0d);
        util.SystemClock systemClock26 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime27 = systemClock26.now();
        command.ModifyReservationCommand modifyReservationCommand29 = new command.ModifyReservationCommand(reservation10, localDateTime21, localDateTime27, "");
        java.lang.String str30 = modifyReservationCommand29.getErrorMessage();
        // The following exception was thrown during execution in test generation
        try {
            modifyReservationCommand29.execute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock26);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime27);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str30 + "' != '" + "" + "'", str30.equals(""));
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        factory.UserFactory userFactory0 = new factory.UserFactory();
        // The following exception was thrown during execution in test generation
        try {
            model.User user7 = userFactory0.createUser("R001", "Student", "", "ACTIVE", "Faculty", true);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid user type: R001");
        } catch (java.lang.IllegalArgumentException e) {
        // Expected exception.
        }
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        service.ReservationService reservationService2 = new service.ReservationService("Research Grant", "ACTIVE");
        java.util.List<model.Reservation> reservationList4 = reservationService2.getReservationsForEquipment("Guest");
        java.util.List<model.Reservation> reservationList6 = reservationService2.getReservationsForEquipment("Research Grant");
        java.lang.Class<?> wildcardClass7 = reservationService2.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        model.Equipment equipment3 = new model.Equipment("R001", "", "Researcher");
        boolean boolean4 = equipment3.isAvailable();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        java.time.LocalDateTime localDateTime11 = reservation10.getEndTime();
        reservation10.markArrived();
        model.Equipment equipment13 = reservation10.getEquipment();
        util.SystemClock systemClock14 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime15 = systemClock14.now();
        command.ExtendReservationCommand extendReservationCommand17 = new command.ExtendReservationCommand(reservation10, localDateTime15, "Researcher");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(equipment13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime15);
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        data.MaintainEquipment maintainEquipment0 = new data.MaintainEquipment();
        java.util.List<model.Equipment> equipmentList1 = null;
        maintainEquipment0.equipmentList = equipmentList1;
        // The following exception was thrown during execution in test generation
        try {
            model.Equipment equipment4 = maintainEquipment0.findById("hi!");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        model.Student student4 = new model.Student("Research Grant", "hi!", "", "Guest");
        model.Equipment equipment5 = null;
        model.Guest guest11 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment12 = null;
        util.SystemClock systemClock13 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime14 = systemClock13.now();
        util.SystemClock systemClock15 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime16 = systemClock15.now();
        model.Reservation reservation18 = new model.Reservation("P001", (model.User) guest11, equipment12, localDateTime14, localDateTime16, 10.0d);
        model.Guest guest24 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment25 = null;
        java.time.LocalDateTime localDateTime26 = null;
        java.time.LocalDateTime localDateTime27 = null;
        model.Reservation reservation29 = new model.Reservation("", (model.User) guest24, equipment25, localDateTime26, localDateTime27, 1.0d);
        reservation29.forfeitDeposit();
        java.lang.String str31 = reservation29.getReservationId();
        model.Guest guest37 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment38 = null;
        util.SystemClock systemClock39 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime40 = systemClock39.now();
        util.SystemClock systemClock41 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime42 = systemClock41.now();
        model.Reservation reservation44 = new model.Reservation("P001", (model.User) guest37, equipment38, localDateTime40, localDateTime42, 10.0d);
        util.SystemClock systemClock45 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime46 = systemClock45.now();
        command.ModifyReservationCommand modifyReservationCommand48 = new command.ModifyReservationCommand(reservation29, localDateTime40, localDateTime46, "");
        strategy.PaymentStrategy paymentStrategy51 = null;
        command.MakeReservationCommand makeReservationCommand52 = new command.MakeReservationCommand((model.User) student4, equipment5, localDateTime14, localDateTime46, "P001", "Student", paymentStrategy51);
        // The following exception was thrown during execution in test generation
        try {
            makeReservationCommand52.execute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str31 + "' != '" + "" + "'", str31.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock39);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock45);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime46);
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        service.RegistrationService registrationService0 = new service.RegistrationService();
        // The following exception was thrown during execution in test generation
        try {
            model.User user7 = registrationService0.registerUser("ACTIVE", "ACTIVE", "hi!", "R001", "Researcher", false);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Password must contain uppercase, lowercase, digit, and symbol.");
        } catch (java.lang.IllegalArgumentException e) {
        // Expected exception.
        }
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        service.ReservationService reservationService2 = new service.ReservationService("hi!", "Guest");
        model.Guest guest8 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment9 = null;
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        model.Reservation reservation13 = new model.Reservation("", (model.User) guest8, equipment9, localDateTime10, localDateTime11, 1.0d);
        reservation13.forfeitDeposit();
        java.lang.String str15 = reservation13.getReservationId();
        model.Guest guest21 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment22 = null;
        util.SystemClock systemClock23 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime24 = systemClock23.now();
        util.SystemClock systemClock25 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime26 = systemClock25.now();
        model.Reservation reservation28 = new model.Reservation("P001", (model.User) guest21, equipment22, localDateTime24, localDateTime26, 10.0d);
        util.SystemClock systemClock29 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime30 = systemClock29.now();
        command.ModifyReservationCommand modifyReservationCommand32 = new command.ModifyReservationCommand(reservation13, localDateTime24, localDateTime30, "");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean33 = reservationService2.cancelReservation(reservation13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str15 + "' != '" + "" + "'", str15.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime24);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock25);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime26);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock29);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime30);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        model.Reservation reservation0 = null;
        command.CancelReservationCommand cancelReservationCommand2 = new command.CancelReservationCommand(reservation0, "");
        // The following exception was thrown during execution in test generation
        try {
            cancelReservationCommand2.execute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy0 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str1 = researchGrantPaymentStrategy0.getMethodName();
        boolean boolean3 = researchGrantPaymentStrategy0.processPayment(0.0d);
        java.lang.String str4 = researchGrantPaymentStrategy0.getMethodName();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str1 + "' != '" + "Research Grant" + "'", str1.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + true + "'", boolean3 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "Research Grant" + "'", str4.equals("Research Grant"));
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        model.Payment payment8 = new model.Payment("R001", "R001", "hi!", (double) '4', "", "P001", "P001", "");
        java.lang.String str9 = payment8.getStatus();
        java.lang.String str10 = payment8.getReservationId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "P001" + "'", str9.equals("P001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "R001" + "'", str10.equals("R001"));
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        data.MaintainReservation maintainReservation0 = new data.MaintainReservation();
        java.lang.String str1 = maintainReservation0.nextId();
        maintainReservation0.load("Research Grant");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean8 = maintainReservation0.hasOverlap("ACTIVE", "Guest", "", "P001");
            org.junit.Assert.fail("Expected exception of type java.time.format.DateTimeParseException; message: Text 'Guest' could not be parsed at index 0");
        } catch (java.time.format.DateTimeParseException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str1 + "' != '" + "R001" + "'", str1.equals("R001"));
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        service.ReservationService reservationService2 = new service.ReservationService("Guest", "P001");
        model.Guest guest8 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment9 = null;
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        model.Reservation reservation13 = new model.Reservation("", (model.User) guest8, equipment9, localDateTime10, localDateTime11, 1.0d);
        reservation13.forfeitDeposit();
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean15 = reservationService2.cancelReservation(reservation13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        model.Student student4 = new model.Student("Research Grant", "hi!", "", "Guest");
        java.lang.String str5 = student4.getPassword();
        double double6 = student4.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "" + "'", str5.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 10.0d + "'", double6 == 10.0d);
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        model.Student student4 = new model.Student("Research Grant", "hi!", "", "Guest");
        java.lang.String str5 = student4.getUserType();
        java.lang.String str6 = student4.getUserType();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "Student" + "'", str5.equals("Student"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Student" + "'", str6.equals("Student"));
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        command.CommandManager commandManager0 = new command.CommandManager();
        commandManager0.printHistory();
        model.Student student6 = new model.Student("Research Grant", "hi!", "", "Guest");
        model.Equipment equipment7 = null;
        model.Guest guest13 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment14 = null;
        util.SystemClock systemClock15 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime16 = systemClock15.now();
        util.SystemClock systemClock17 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime18 = systemClock17.now();
        model.Reservation reservation20 = new model.Reservation("P001", (model.User) guest13, equipment14, localDateTime16, localDateTime18, 10.0d);
        model.Guest guest26 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment27 = null;
        java.time.LocalDateTime localDateTime28 = null;
        java.time.LocalDateTime localDateTime29 = null;
        model.Reservation reservation31 = new model.Reservation("", (model.User) guest26, equipment27, localDateTime28, localDateTime29, 1.0d);
        reservation31.forfeitDeposit();
        java.lang.String str33 = reservation31.getReservationId();
        model.Guest guest39 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment40 = null;
        util.SystemClock systemClock41 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime42 = systemClock41.now();
        util.SystemClock systemClock43 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime44 = systemClock43.now();
        model.Reservation reservation46 = new model.Reservation("P001", (model.User) guest39, equipment40, localDateTime42, localDateTime44, 10.0d);
        util.SystemClock systemClock47 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime48 = systemClock47.now();
        command.ModifyReservationCommand modifyReservationCommand50 = new command.ModifyReservationCommand(reservation31, localDateTime42, localDateTime48, "");
        strategy.PaymentStrategy paymentStrategy53 = null;
        command.MakeReservationCommand makeReservationCommand54 = new command.MakeReservationCommand((model.User) student6, equipment7, localDateTime16, localDateTime48, "P001", "Student", paymentStrategy53);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean55 = commandManager0.execute((command.ReservationCommand) makeReservationCommand54);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime18);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str33 + "' != '" + "" + "'", str33.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock43);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime44);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock47);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime48);
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        reservation10.forfeitDeposit();
        java.lang.String str12 = reservation10.getReservationId();
        model.Guest guest18 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment19 = null;
        util.SystemClock systemClock20 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime21 = systemClock20.now();
        util.SystemClock systemClock22 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime23 = systemClock22.now();
        model.Reservation reservation25 = new model.Reservation("P001", (model.User) guest18, equipment19, localDateTime21, localDateTime23, 10.0d);
        util.SystemClock systemClock26 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime27 = systemClock26.now();
        command.ModifyReservationCommand modifyReservationCommand29 = new command.ModifyReservationCommand(reservation10, localDateTime21, localDateTime27, "");
        // The following exception was thrown during execution in test generation
        try {
            modifyReservationCommand29.execute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock26);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime27);
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy0 = new strategy.ResearchGrantPaymentStrategy();
        boolean boolean2 = researchGrantPaymentStrategy0.processPayment((double) (-1));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        data.MaintainUser maintainUser0 = new data.MaintainUser();
        model.Guest guest6 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        java.time.LocalDateTime localDateTime9 = null;
        model.Reservation reservation11 = new model.Reservation("", (model.User) guest6, equipment7, localDateTime8, localDateTime9, 1.0d);
        java.lang.String str12 = guest6.getUserType();
        model.Guest guest18 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment19 = null;
        java.time.LocalDateTime localDateTime20 = null;
        java.time.LocalDateTime localDateTime21 = null;
        model.Reservation reservation23 = new model.Reservation("", (model.User) guest18, equipment19, localDateTime20, localDateTime21, 1.0d);
        model.Guest guest28 = new model.Guest("hi!", "hi!", "", "hi!");
        model.Guest guest34 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment35 = null;
        java.time.LocalDateTime localDateTime36 = null;
        java.time.LocalDateTime localDateTime37 = null;
        model.Reservation reservation39 = new model.Reservation("", (model.User) guest34, equipment35, localDateTime36, localDateTime37, 1.0d);
        java.lang.String str40 = guest34.getUserType();
        model.User[] userArray41 = new model.User[] { guest6, guest18, guest28, guest34 };
        java.util.ArrayList<model.User> userList42 = new java.util.ArrayList<model.User>();
        boolean boolean43 = java.util.Collections.addAll((java.util.Collection<model.User>) userList42, userArray41);
        maintainUser0.users = userList42;
        java.util.List<model.User> userList45 = maintainUser0.users;
        java.util.List<model.User> userList46 = maintainUser0.users;
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "Guest" + "'", str12.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str40 + "' != '" + "Guest" + "'", str40.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(userArray41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + true + "'", boolean43 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(userList45);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(userList46);
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        model.Payment payment8 = new model.Payment("Student", "Research Grant", "Guest", 10.0d, "Student", "", "hi!", "ACTIVE");
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        service.ReservationService reservationService2 = new service.ReservationService("Research Grant", "ACTIVE");
        java.util.List<model.Reservation> reservationList4 = reservationService2.getReservationsForEquipment("Guest");
        model.Guest guest10 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment11 = null;
        java.time.LocalDateTime localDateTime12 = null;
        java.time.LocalDateTime localDateTime13 = null;
        model.Reservation reservation15 = new model.Reservation("", (model.User) guest10, equipment11, localDateTime12, localDateTime13, 1.0d);
        model.Researcher researcher22 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str23 = researcher22.getPassword();
        boolean boolean24 = researcher22.isApproved();
        model.Equipment equipment25 = null;
        util.SystemClock systemClock26 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime27 = systemClock26.now();
        java.time.LocalDateTime localDateTime28 = systemClock26.now();
        model.Guest guest34 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment35 = null;
        util.SystemClock systemClock36 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime37 = systemClock36.now();
        util.SystemClock systemClock38 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime39 = systemClock38.now();
        model.Reservation reservation41 = new model.Reservation("P001", (model.User) guest34, equipment35, localDateTime37, localDateTime39, 10.0d);
        model.Reservation reservation43 = new model.Reservation("", (model.User) researcher22, equipment25, localDateTime28, localDateTime39, (double) (byte) -1);
        model.Researcher researcher50 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str51 = researcher50.getPassword();
        boolean boolean52 = researcher50.isApproved();
        model.Equipment equipment53 = null;
        util.SystemClock systemClock54 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime55 = systemClock54.now();
        java.time.LocalDateTime localDateTime56 = systemClock54.now();
        model.Guest guest62 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment63 = null;
        util.SystemClock systemClock64 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime65 = systemClock64.now();
        util.SystemClock systemClock66 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime67 = systemClock66.now();
        model.Reservation reservation69 = new model.Reservation("P001", (model.User) guest62, equipment63, localDateTime65, localDateTime67, 10.0d);
        model.Reservation reservation71 = new model.Reservation("", (model.User) researcher50, equipment53, localDateTime56, localDateTime67, (double) (byte) -1);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean72 = reservationService2.modifyReservation(reservation15, localDateTime39, localDateTime56);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str23 + "' != '" + "Research Grant" + "'", str23.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + false + "'", boolean24 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock26);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime27);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime28);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock36);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime37);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock38);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime39);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str51 + "' != '" + "Research Grant" + "'", str51.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + false + "'", boolean52 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock54);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime56);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock64);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime65);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock66);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime67);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        model.Reservation reservation0 = null;
        java.time.LocalDateTime localDateTime1 = null;
        command.ExtendReservationCommand extendReservationCommand3 = new command.ExtendReservationCommand(reservation0, localDateTime1, "Research Grant");
        java.lang.String str4 = extendReservationCommand3.getErrorMessage();
        java.lang.String str5 = extendReservationCommand3.getErrorMessage();
        // The following exception was thrown during execution in test generation
        try {
            extendReservationCommand3.execute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "" + "'", str4.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "" + "'", str5.equals(""));
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        data.MaintainReservation maintainReservation0 = new data.MaintainReservation();
        java.util.List<model.Reservation> reservationList1 = maintainReservation0.reservations;
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList1);
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        service.BillingService billingService0 = new service.BillingService();
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy1 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str2 = researchGrantPaymentStrategy1.getMethodName();
        boolean boolean4 = researchGrantPaymentStrategy1.processPayment(0.0d);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy1);
        // The following exception was thrown during execution in test generation
        try {
            double double8 = billingService0.calculateFeeWithDeposit((double) (short) 100, false);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: Pricing strategy not set");
        } catch (java.lang.IllegalStateException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str2 + "' != '" + "Research Grant" + "'", str2.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        service.BillingService billingService0 = new service.BillingService();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str1 = billingService0.getPaymentMethodName();
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: Payment strategy not set");
        } catch (java.lang.IllegalStateException e) {
        // Expected exception.
        }
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        java.time.LocalDateTime localDateTime11 = reservation10.getEndTime();
        java.lang.String str12 = reservation10.getReservationId();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str13 = reservation10.getEquipmentId();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        model.Reservation reservation0 = null;
        command.CancelReservationCommand cancelReservationCommand2 = new command.CancelReservationCommand(reservation0, "");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean3 = cancelReservationCommand2.canExecute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        util.SystemClock systemClock7 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime8 = systemClock7.now();
        util.SystemClock systemClock9 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime10 = systemClock9.now();
        model.Reservation reservation12 = new model.Reservation("P001", (model.User) guest5, equipment6, localDateTime8, localDateTime10, 10.0d);
        java.lang.String str13 = guest5.getUserType();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock9);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "Guest" + "'", str13.equals("Guest"));
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        service.RegistrationService registrationService0 = new service.RegistrationService();
        // The following exception was thrown during execution in test generation
        try {
            model.User user7 = registrationService0.registerUser("P001", "R001", "R001", "P001", "P001", true);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Password must contain uppercase, lowercase, digit, and symbol.");
        } catch (java.lang.IllegalArgumentException e) {
        // Expected exception.
        }
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        data.MaintainUser maintainUser0 = new data.MaintainUser();
        model.User user2 = maintainUser0.findByEmail("R001");
        model.User user4 = maintainUser0.findById("Guest");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(user2);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(user4);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        java.time.LocalDateTime localDateTime11 = reservation10.getEndTime();
        reservation10.markArrived();
        java.lang.String str13 = reservation10.getStatus();
        model.Guest guest19 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment20 = null;
        java.time.LocalDateTime localDateTime21 = null;
        java.time.LocalDateTime localDateTime22 = null;
        model.Reservation reservation24 = new model.Reservation("", (model.User) guest19, equipment20, localDateTime21, localDateTime22, 1.0d);
        reservation24.forfeitDeposit();
        java.lang.String str26 = reservation24.getReservationId();
        model.Guest guest32 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment33 = null;
        util.SystemClock systemClock34 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime35 = systemClock34.now();
        util.SystemClock systemClock36 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime37 = systemClock36.now();
        model.Reservation reservation39 = new model.Reservation("P001", (model.User) guest32, equipment33, localDateTime35, localDateTime37, 10.0d);
        util.SystemClock systemClock40 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime41 = systemClock40.now();
        command.ModifyReservationCommand modifyReservationCommand43 = new command.ModifyReservationCommand(reservation24, localDateTime35, localDateTime41, "");
        command.ExtendReservationCommand extendReservationCommand45 = new command.ExtendReservationCommand(reservation10, localDateTime41, "Researcher");
        java.lang.String str46 = reservation10.getReservationId();
        java.time.LocalDateTime localDateTime47 = reservation10.getEndTime();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "ACTIVE" + "'", str13.equals("ACTIVE"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str26 + "' != '" + "" + "'", str26.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock34);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock36);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime37);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str46 + "' != '" + "" + "'", str46.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime47);
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        service.BillingService billingService0 = new service.BillingService();
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean2 = billingService0.processPayment(10.0d);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: Payment strategy not set");
        } catch (java.lang.IllegalStateException e) {
        // Expected exception.
        }
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        service.BillingService billingService0 = new service.BillingService();
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy1 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str2 = researchGrantPaymentStrategy1.getMethodName();
        boolean boolean4 = researchGrantPaymentStrategy1.processPayment(0.0d);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy1);
        // The following exception was thrown during execution in test generation
        try {
            double double8 = billingService0.calculateFeeWithDeposit((double) (byte) -1, false);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: Pricing strategy not set");
        } catch (java.lang.IllegalStateException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str2 + "' != '" + "Research Grant" + "'", str2.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        model.Reservation reservation0 = null;
        java.time.LocalDateTime localDateTime1 = null;
        command.ExtendReservationCommand extendReservationCommand3 = new command.ExtendReservationCommand(reservation0, localDateTime1, "Research Grant");
        java.lang.String str4 = extendReservationCommand3.getErrorMessage();
        java.lang.String str5 = extendReservationCommand3.getErrorMessage();
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean6 = extendReservationCommand3.canExecute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "" + "'", str4.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "" + "'", str5.equals(""));
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        data.MaintainUser maintainUser0 = new data.MaintainUser();
        model.User user2 = maintainUser0.findByEmail("P001");
        java.util.List<model.User> userList3 = maintainUser0.users;
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(user2);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(userList3);
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        model.Student student4 = new model.Student("", "Guest", "", "Student");
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        model.Researcher researcher5 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str6 = researcher5.getPassword();
        boolean boolean7 = researcher5.isApproved();
        java.lang.String str8 = researcher5.getEmail();
        boolean boolean9 = researcher5.isApproved();
        java.lang.Class<?> wildcardClass10 = researcher5.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Research Grant" + "'", str6.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Research Grant" + "'", str8.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        model.Payment payment8 = new model.Payment("R001", "R001", "hi!", (double) '4', "", "P001", "P001", "");
        java.lang.String str9 = payment8.getPaymentId();
        java.lang.String str10 = payment8.getPaymentId();
        java.lang.String str11 = payment8.getUserId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "R001" + "'", str9.equals("R001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "R001" + "'", str10.equals("R001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "hi!" + "'", str11.equals("hi!"));
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        data.MaintainEquipment maintainEquipment0 = new data.MaintainEquipment();
        maintainEquipment0.load("Research Grant");
        model.Equipment equipment4 = maintainEquipment0.findById("Researcher");
        model.Equipment equipment6 = maintainEquipment0.findById("hi!");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(equipment4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(equipment6);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        model.Researcher researcher6 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str7 = researcher6.getPassword();
        boolean boolean8 = researcher6.isApproved();
        model.Equipment equipment9 = null;
        util.SystemClock systemClock10 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime11 = systemClock10.now();
        java.time.LocalDateTime localDateTime12 = systemClock10.now();
        model.Guest guest18 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment19 = null;
        util.SystemClock systemClock20 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime21 = systemClock20.now();
        util.SystemClock systemClock22 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime23 = systemClock22.now();
        model.Reservation reservation25 = new model.Reservation("P001", (model.User) guest18, equipment19, localDateTime21, localDateTime23, 10.0d);
        model.Reservation reservation27 = new model.Reservation("", (model.User) researcher6, equipment9, localDateTime12, localDateTime23, (double) (byte) -1);
        double double28 = researcher6.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Research Grant" + "'", str7.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double28 + "' != '" + 20.0d + "'", double28 == 20.0d);
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        reservation10.forfeitDeposit();
        java.lang.String str12 = reservation10.getReservationId();
        model.Guest guest18 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment19 = null;
        util.SystemClock systemClock20 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime21 = systemClock20.now();
        util.SystemClock systemClock22 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime23 = systemClock22.now();
        model.Reservation reservation25 = new model.Reservation("P001", (model.User) guest18, equipment19, localDateTime21, localDateTime23, 10.0d);
        util.SystemClock systemClock26 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime27 = systemClock26.now();
        command.ModifyReservationCommand modifyReservationCommand29 = new command.ModifyReservationCommand(reservation10, localDateTime21, localDateTime27, "");
        java.lang.String str30 = modifyReservationCommand29.getDescription();
        // The following exception was thrown during execution in test generation
        try {
            modifyReservationCommand29.execute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock26);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime27);
        // Regression assertion (captures the current behavior of the code)
        // Date-agnostic: snapshot date captured at generation time drifts every day
        org.junit.Assert.assertTrue("description should start with 'Modify reservation'", str30.startsWith("Modify reservation"));
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        util.SystemClock systemClock7 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime8 = systemClock7.now();
        util.SystemClock systemClock9 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime10 = systemClock9.now();
        model.Reservation reservation12 = new model.Reservation("P001", (model.User) guest5, equipment6, localDateTime8, localDateTime10, 10.0d);
        model.Guest guest18 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment19 = null;
        util.SystemClock systemClock20 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime21 = systemClock20.now();
        util.SystemClock systemClock22 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime23 = systemClock22.now();
        model.Reservation reservation25 = new model.Reservation("P001", (model.User) guest18, equipment19, localDateTime21, localDateTime23, 10.0d);
        command.ExtendReservationCommand extendReservationCommand27 = new command.ExtendReservationCommand(reservation12, localDateTime23, "Student");
        model.Guest guest33 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment34 = null;
        util.SystemClock systemClock35 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime36 = systemClock35.now();
        util.SystemClock systemClock37 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime38 = systemClock37.now();
        model.Reservation reservation40 = new model.Reservation("P001", (model.User) guest33, equipment34, localDateTime36, localDateTime38, 10.0d);
        reservation12.setEndTime(localDateTime38);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock9);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime36);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock37);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime38);
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        data.MaintainPayment maintainPayment0 = new data.MaintainPayment();
        java.lang.String str1 = maintainPayment0.nextId();
        java.util.List<model.Payment> paymentList2 = maintainPayment0.payments;
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str1 + "' != '" + "P001" + "'", str1.equals("P001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(paymentList2);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        data.MaintainUser maintainUser0 = new data.MaintainUser();
        data.MaintainUser maintainUser1 = new data.MaintainUser();
        model.Guest guest7 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment8 = null;
        java.time.LocalDateTime localDateTime9 = null;
        java.time.LocalDateTime localDateTime10 = null;
        model.Reservation reservation12 = new model.Reservation("", (model.User) guest7, equipment8, localDateTime9, localDateTime10, 1.0d);
        java.lang.String str13 = guest7.getUserType();
        model.Guest guest19 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment20 = null;
        java.time.LocalDateTime localDateTime21 = null;
        java.time.LocalDateTime localDateTime22 = null;
        model.Reservation reservation24 = new model.Reservation("", (model.User) guest19, equipment20, localDateTime21, localDateTime22, 1.0d);
        model.Guest guest29 = new model.Guest("hi!", "hi!", "", "hi!");
        model.Guest guest35 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment36 = null;
        java.time.LocalDateTime localDateTime37 = null;
        java.time.LocalDateTime localDateTime38 = null;
        model.Reservation reservation40 = new model.Reservation("", (model.User) guest35, equipment36, localDateTime37, localDateTime38, 1.0d);
        java.lang.String str41 = guest35.getUserType();
        model.User[] userArray42 = new model.User[] { guest7, guest19, guest29, guest35 };
        java.util.ArrayList<model.User> userList43 = new java.util.ArrayList<model.User>();
        boolean boolean44 = java.util.Collections.addAll((java.util.Collection<model.User>) userList43, userArray42);
        maintainUser1.users = userList43;
        java.util.List<model.User> userList46 = maintainUser1.users;
        maintainUser0.users = userList46;
        maintainUser0.load("Researcher");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "Guest" + "'", str13.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str41 + "' != '" + "Guest" + "'", str41.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(userArray42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + true + "'", boolean44 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(userList46);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        model.Guest guest6 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment7 = null;
        util.SystemClock systemClock8 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime9 = systemClock8.now();
        util.SystemClock systemClock10 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime11 = systemClock10.now();
        model.Reservation reservation13 = new model.Reservation("P001", (model.User) guest6, equipment7, localDateTime9, localDateTime11, 10.0d);
        model.Guest guest19 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment20 = null;
        util.SystemClock systemClock21 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime22 = systemClock21.now();
        util.SystemClock systemClock23 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime24 = systemClock23.now();
        model.Reservation reservation26 = new model.Reservation("P001", (model.User) guest19, equipment20, localDateTime22, localDateTime24, 10.0d);
        command.ExtendReservationCommand extendReservationCommand28 = new command.ExtendReservationCommand(reservation13, localDateTime24, "Student");
        model.Researcher researcher35 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str36 = researcher35.getPassword();
        boolean boolean37 = researcher35.isApproved();
        model.Equipment equipment38 = null;
        util.SystemClock systemClock39 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime40 = systemClock39.now();
        java.time.LocalDateTime localDateTime41 = systemClock39.now();
        model.Guest guest47 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment48 = null;
        util.SystemClock systemClock49 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime50 = systemClock49.now();
        util.SystemClock systemClock51 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime52 = systemClock51.now();
        model.Reservation reservation54 = new model.Reservation("P001", (model.User) guest47, equipment48, localDateTime50, localDateTime52, 10.0d);
        model.Reservation reservation56 = new model.Reservation("", (model.User) researcher35, equipment38, localDateTime41, localDateTime52, (double) (byte) -1);
        model.UsageRecord usageRecord58 = new model.UsageRecord("Researcher", localDateTime24, localDateTime41, "Faculty");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime9);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime24);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str36 + "' != '" + "Research Grant" + "'", str36.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean37 + "' != '" + false + "'", boolean37 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock39);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock49);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime50);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock51);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime52);
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        java.time.LocalDateTime localDateTime11 = reservation10.getEndTime();
        java.lang.String str12 = reservation10.getReservationId();
        util.SystemClock systemClock13 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime14 = systemClock13.now();
        model.Student student19 = new model.Student("Research Grant", "hi!", "", "Guest");
        model.Equipment equipment20 = null;
        model.Guest guest26 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment27 = null;
        util.SystemClock systemClock28 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime29 = systemClock28.now();
        util.SystemClock systemClock30 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime31 = systemClock30.now();
        model.Reservation reservation33 = new model.Reservation("P001", (model.User) guest26, equipment27, localDateTime29, localDateTime31, 10.0d);
        model.Guest guest39 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment40 = null;
        java.time.LocalDateTime localDateTime41 = null;
        java.time.LocalDateTime localDateTime42 = null;
        model.Reservation reservation44 = new model.Reservation("", (model.User) guest39, equipment40, localDateTime41, localDateTime42, 1.0d);
        reservation44.forfeitDeposit();
        java.lang.String str46 = reservation44.getReservationId();
        model.Guest guest52 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment53 = null;
        util.SystemClock systemClock54 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime55 = systemClock54.now();
        util.SystemClock systemClock56 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime57 = systemClock56.now();
        model.Reservation reservation59 = new model.Reservation("P001", (model.User) guest52, equipment53, localDateTime55, localDateTime57, 10.0d);
        util.SystemClock systemClock60 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime61 = systemClock60.now();
        command.ModifyReservationCommand modifyReservationCommand63 = new command.ModifyReservationCommand(reservation44, localDateTime55, localDateTime61, "");
        strategy.PaymentStrategy paymentStrategy66 = null;
        command.MakeReservationCommand makeReservationCommand67 = new command.MakeReservationCommand((model.User) student19, equipment20, localDateTime29, localDateTime61, "P001", "Student", paymentStrategy66);
        command.ModifyReservationCommand modifyReservationCommand69 = new command.ModifyReservationCommand(reservation10, localDateTime14, localDateTime29, "Guest");
        java.lang.String str70 = reservation10.getStatus();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock28);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime29);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock30);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime31);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str46 + "' != '" + "" + "'", str46.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock54);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock56);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime57);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock60);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime61);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str70 + "' != '" + "ACTIVE" + "'", str70.equals("ACTIVE"));
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        java.time.LocalDateTime localDateTime11 = reservation10.getEndTime();
        reservation10.markArrived();
        java.lang.String str13 = reservation10.getStatus();
        model.Guest guest19 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment20 = null;
        java.time.LocalDateTime localDateTime21 = null;
        java.time.LocalDateTime localDateTime22 = null;
        model.Reservation reservation24 = new model.Reservation("", (model.User) guest19, equipment20, localDateTime21, localDateTime22, 1.0d);
        reservation24.forfeitDeposit();
        java.lang.String str26 = reservation24.getReservationId();
        model.Guest guest32 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment33 = null;
        util.SystemClock systemClock34 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime35 = systemClock34.now();
        util.SystemClock systemClock36 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime37 = systemClock36.now();
        model.Reservation reservation39 = new model.Reservation("P001", (model.User) guest32, equipment33, localDateTime35, localDateTime37, 10.0d);
        util.SystemClock systemClock40 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime41 = systemClock40.now();
        command.ModifyReservationCommand modifyReservationCommand43 = new command.ModifyReservationCommand(reservation24, localDateTime35, localDateTime41, "");
        command.ExtendReservationCommand extendReservationCommand45 = new command.ExtendReservationCommand(reservation10, localDateTime41, "Researcher");
        java.lang.String str46 = reservation10.getReservationId();
        java.lang.String str47 = reservation10.getStatus();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "ACTIVE" + "'", str13.equals("ACTIVE"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str26 + "' != '" + "" + "'", str26.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock34);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock36);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime37);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str46 + "' != '" + "" + "'", str46.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str47 + "' != '" + "ACTIVE" + "'", str47.equals("ACTIVE"));
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        model.Student student4 = new model.Student("Research Grant", "hi!", "", "Guest");
        model.Equipment equipment5 = null;
        model.Guest guest11 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment12 = null;
        util.SystemClock systemClock13 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime14 = systemClock13.now();
        util.SystemClock systemClock15 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime16 = systemClock15.now();
        model.Reservation reservation18 = new model.Reservation("P001", (model.User) guest11, equipment12, localDateTime14, localDateTime16, 10.0d);
        model.Guest guest24 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment25 = null;
        java.time.LocalDateTime localDateTime26 = null;
        java.time.LocalDateTime localDateTime27 = null;
        model.Reservation reservation29 = new model.Reservation("", (model.User) guest24, equipment25, localDateTime26, localDateTime27, 1.0d);
        reservation29.forfeitDeposit();
        java.lang.String str31 = reservation29.getReservationId();
        model.Guest guest37 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment38 = null;
        util.SystemClock systemClock39 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime40 = systemClock39.now();
        util.SystemClock systemClock41 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime42 = systemClock41.now();
        model.Reservation reservation44 = new model.Reservation("P001", (model.User) guest37, equipment38, localDateTime40, localDateTime42, 10.0d);
        util.SystemClock systemClock45 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime46 = systemClock45.now();
        command.ModifyReservationCommand modifyReservationCommand48 = new command.ModifyReservationCommand(reservation29, localDateTime40, localDateTime46, "");
        strategy.PaymentStrategy paymentStrategy51 = null;
        command.MakeReservationCommand makeReservationCommand52 = new command.MakeReservationCommand((model.User) student4, equipment5, localDateTime14, localDateTime46, "P001", "Student", paymentStrategy51);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str53 = makeReservationCommand52.getDescription();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str31 + "' != '" + "" + "'", str31.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock39);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock45);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime46);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        reservation10.forfeitDeposit();
        java.lang.String str12 = reservation10.getReservationId();
        double double13 = reservation10.getDepositAmount();
        command.CancelReservationCommand cancelReservationCommand15 = new command.CancelReservationCommand(reservation10, "ACTIVE");
        double double16 = reservation10.getDepositAmount();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double13 + "' != '" + 1.0d + "'", double13 == 1.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 1.0d + "'", double16 == 1.0d);
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        util.SystemClock systemClock7 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime8 = systemClock7.now();
        util.SystemClock systemClock9 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime10 = systemClock9.now();
        model.Reservation reservation12 = new model.Reservation("P001", (model.User) guest5, equipment6, localDateTime8, localDateTime10, 10.0d);
        model.Guest guest18 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment19 = null;
        util.SystemClock systemClock20 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime21 = systemClock20.now();
        util.SystemClock systemClock22 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime23 = systemClock22.now();
        model.Reservation reservation25 = new model.Reservation("P001", (model.User) guest18, equipment19, localDateTime21, localDateTime23, 10.0d);
        command.ExtendReservationCommand extendReservationCommand27 = new command.ExtendReservationCommand(reservation12, localDateTime23, "Student");
        boolean boolean28 = reservation12.hasArrived();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock9);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + false + "'", boolean28 == false);
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        service.BillingService billingService0 = new service.BillingService();
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy1 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str2 = researchGrantPaymentStrategy1.getMethodName();
        boolean boolean4 = researchGrantPaymentStrategy1.processPayment(0.0d);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy1);
        // The following exception was thrown during execution in test generation
        try {
            double double6 = billingService0.getDeposit();
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: Pricing strategy not set");
        } catch (java.lang.IllegalStateException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str2 + "' != '" + "Research Grant" + "'", str2.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        model.Reservation reservation0 = null;
        java.time.LocalDateTime localDateTime1 = null;
        command.ExtendReservationCommand extendReservationCommand3 = new command.ExtendReservationCommand(reservation0, localDateTime1, "Research Grant");
        java.lang.String str4 = extendReservationCommand3.getErrorMessage();
        // The following exception was thrown during execution in test generation
        try {
            extendReservationCommand3.execute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "" + "'", str4.equals(""));
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        factory.UserFactory userFactory0 = new factory.UserFactory();
        // The following exception was thrown during execution in test generation
        try {
            model.User user7 = userFactory0.createUser("R001", "Researcher", "Guest", "", "", false);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Invalid user type: R001");
        } catch (java.lang.IllegalArgumentException e) {
        // Expected exception.
        }
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        model.Student student4 = new model.Student("Research Grant", "hi!", "", "Guest");
        java.lang.String str5 = student4.getPassword();
        java.lang.String str6 = student4.getUserType();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "" + "'", str5.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Student" + "'", str6.equals("Student"));
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        data.MaintainPayment maintainPayment0 = new data.MaintainPayment();
        model.Payment[] paymentArray1 = new model.Payment[] {};
        java.util.ArrayList<model.Payment> paymentList2 = new java.util.ArrayList<model.Payment>();
        boolean boolean3 = java.util.Collections.addAll((java.util.Collection<model.Payment>) paymentList2, paymentArray1);
        maintainPayment0.payments = paymentList2;
        maintainPayment0.load("ACTIVE");
        maintainPayment0.load("Guest");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(paymentArray1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        model.Payment payment8 = new model.Payment("R001", "R001", "hi!", (double) '4', "", "P001", "P001", "");
        java.lang.String str9 = payment8.getPaymentId();
        java.lang.String str10 = payment8.getUserId();
        java.lang.String str11 = payment8.getPaymentMethod();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "R001" + "'", str9.equals("R001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "hi!" + "'", str10.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "" + "'", str11.equals(""));
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        model.LabManager labManager4 = new model.LabManager("hi!", "hi!", "ACTIVE", "ACTIVE");
        model.Equipment equipment8 = labManager4.addEquipment("R001", "Guest", "P001");
        java.lang.String str9 = equipment8.getName();
        equipment8.enable();
        java.lang.String str11 = equipment8.getStatus();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipment8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Guest" + "'", str9.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "AVAILABLE" + "'", str11.equals("AVAILABLE"));
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        command.CommandManager commandManager0 = new command.CommandManager();
        commandManager0.printHistory();
        java.util.List<command.ReservationCommand> reservationCommandList2 = commandManager0.getHistory();
        model.Guest guest8 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment9 = null;
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        model.Reservation reservation13 = new model.Reservation("", (model.User) guest8, equipment9, localDateTime10, localDateTime11, 1.0d);
        java.time.LocalDateTime localDateTime14 = reservation13.getEndTime();
        reservation13.markArrived();
        java.lang.String str16 = reservation13.getStatus();
        model.Guest guest22 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment23 = null;
        java.time.LocalDateTime localDateTime24 = null;
        java.time.LocalDateTime localDateTime25 = null;
        model.Reservation reservation27 = new model.Reservation("", (model.User) guest22, equipment23, localDateTime24, localDateTime25, 1.0d);
        reservation27.forfeitDeposit();
        java.lang.String str29 = reservation27.getReservationId();
        model.Guest guest35 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment36 = null;
        util.SystemClock systemClock37 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime38 = systemClock37.now();
        util.SystemClock systemClock39 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime40 = systemClock39.now();
        model.Reservation reservation42 = new model.Reservation("P001", (model.User) guest35, equipment36, localDateTime38, localDateTime40, 10.0d);
        util.SystemClock systemClock43 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime44 = systemClock43.now();
        command.ModifyReservationCommand modifyReservationCommand46 = new command.ModifyReservationCommand(reservation27, localDateTime38, localDateTime44, "");
        command.ExtendReservationCommand extendReservationCommand48 = new command.ExtendReservationCommand(reservation13, localDateTime44, "Researcher");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean49 = commandManager0.execute((command.ReservationCommand) extendReservationCommand48);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationCommandList2);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str16 + "' != '" + "ACTIVE" + "'", str16.equals("ACTIVE"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str29 + "' != '" + "" + "'", str29.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock37);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime38);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock39);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock43);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime44);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        util.SystemClock systemClock7 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime8 = systemClock7.now();
        util.SystemClock systemClock9 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime10 = systemClock9.now();
        model.Reservation reservation12 = new model.Reservation("P001", (model.User) guest5, equipment6, localDateTime8, localDateTime10, 10.0d);
        java.lang.String str13 = reservation12.getReservationId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock9);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "P001" + "'", str13.equals("P001"));
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        data.MaintainEquipment maintainEquipment0 = new data.MaintainEquipment();
        maintainEquipment0.load("Research Grant");
        model.Equipment equipment4 = maintainEquipment0.findById("Faculty");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(equipment4);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        data.MaintainUser maintainUser0 = new data.MaintainUser();
        model.Guest guest6 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        java.time.LocalDateTime localDateTime9 = null;
        model.Reservation reservation11 = new model.Reservation("", (model.User) guest6, equipment7, localDateTime8, localDateTime9, 1.0d);
        java.lang.String str12 = guest6.getUserType();
        model.Guest guest18 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment19 = null;
        java.time.LocalDateTime localDateTime20 = null;
        java.time.LocalDateTime localDateTime21 = null;
        model.Reservation reservation23 = new model.Reservation("", (model.User) guest18, equipment19, localDateTime20, localDateTime21, 1.0d);
        model.Guest guest28 = new model.Guest("hi!", "hi!", "", "hi!");
        model.Guest guest34 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment35 = null;
        java.time.LocalDateTime localDateTime36 = null;
        java.time.LocalDateTime localDateTime37 = null;
        model.Reservation reservation39 = new model.Reservation("", (model.User) guest34, equipment35, localDateTime36, localDateTime37, 1.0d);
        java.lang.String str40 = guest34.getUserType();
        model.User[] userArray41 = new model.User[] { guest6, guest18, guest28, guest34 };
        java.util.ArrayList<model.User> userList42 = new java.util.ArrayList<model.User>();
        boolean boolean43 = java.util.Collections.addAll((java.util.Collection<model.User>) userList42, userArray41);
        maintainUser0.users = userList42;
        // The following exception was thrown during execution in test generation
        try {
            maintainUser0.update("Student");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "Guest" + "'", str12.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str40 + "' != '" + "Guest" + "'", str40.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(userArray41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + true + "'", boolean43 == true);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        data.MaintainPayment maintainPayment0 = new data.MaintainPayment();
        model.Payment[] paymentArray1 = new model.Payment[] {};
        java.util.ArrayList<model.Payment> paymentList2 = new java.util.ArrayList<model.Payment>();
        boolean boolean3 = java.util.Collections.addAll((java.util.Collection<model.Payment>) paymentList2, paymentArray1);
        maintainPayment0.payments = paymentList2;
        java.util.List<model.Payment> paymentList5 = maintainPayment0.payments;
        java.util.List<model.Payment> paymentList6 = maintainPayment0.payments;
        java.lang.String str7 = maintainPayment0.nextId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(paymentArray1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(paymentList5);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(paymentList6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "P001" + "'", str7.equals("P001"));
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        service.ReservationService reservationService2 = new service.ReservationService("hi!", "Guest");
        java.util.List<model.Reservation> reservationList3 = reservationService2.getAllReservations();
        reservationService2.printCommandHistory();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList3);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        model.LabManager labManager4 = new model.LabManager("hi!", "hi!", "ACTIVE", "ACTIVE");
        model.Equipment equipment8 = labManager4.addEquipment("R001", "Guest", "P001");
        java.lang.String str9 = equipment8.getName();
        equipment8.disable();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipment8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Guest" + "'", str9.equals("Guest"));
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        data.MaintainEquipment maintainEquipment0 = new data.MaintainEquipment();
        model.Equipment equipment2 = maintainEquipment0.findById("ACTIVE");
        java.util.List<model.Equipment> equipmentList3 = maintainEquipment0.getAvailableEquipment();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(equipment2);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipmentList3);
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        data.MaintainReservation maintainReservation0 = new data.MaintainReservation();
        java.lang.String str1 = maintainReservation0.nextId();
        maintainReservation0.load("Research Grant");
        java.lang.String str4 = maintainReservation0.nextId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str1 + "' != '" + "R001" + "'", str1.equals("R001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "R001" + "'", str4.equals("R001"));
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        data.MaintainPayment maintainPayment0 = new data.MaintainPayment();
        model.Payment[] paymentArray1 = new model.Payment[] {};
        java.util.ArrayList<model.Payment> paymentList2 = new java.util.ArrayList<model.Payment>();
        boolean boolean3 = java.util.Collections.addAll((java.util.Collection<model.Payment>) paymentList2, paymentArray1);
        maintainPayment0.payments = paymentList2;
        java.util.List<model.Payment> paymentList5 = maintainPayment0.payments;
        maintainPayment0.load("Student");
        java.lang.String str8 = maintainPayment0.nextId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(paymentArray1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(paymentList5);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "P001" + "'", str8.equals("P001"));
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        reservation10.markArrived();
        reservation10.forfeitDeposit();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str13 = reservation10.getEquipmentId();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        model.Researcher researcher7 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str8 = researcher7.getPassword();
        boolean boolean9 = researcher7.isApproved();
        model.Equipment equipment10 = null;
        util.SystemClock systemClock11 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime12 = systemClock11.now();
        java.time.LocalDateTime localDateTime13 = systemClock11.now();
        model.Guest guest19 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment20 = null;
        util.SystemClock systemClock21 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime22 = systemClock21.now();
        util.SystemClock systemClock23 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime24 = systemClock23.now();
        model.Reservation reservation26 = new model.Reservation("P001", (model.User) guest19, equipment20, localDateTime22, localDateTime24, 10.0d);
        model.Reservation reservation28 = new model.Reservation("", (model.User) researcher7, equipment10, localDateTime13, localDateTime24, (double) (byte) -1);
        model.Guest guest34 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment35 = null;
        java.time.LocalDateTime localDateTime36 = null;
        java.time.LocalDateTime localDateTime37 = null;
        model.Reservation reservation39 = new model.Reservation("", (model.User) guest34, equipment35, localDateTime36, localDateTime37, 1.0d);
        reservation39.forfeitDeposit();
        java.lang.String str41 = reservation39.getReservationId();
        model.Guest guest47 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment48 = null;
        util.SystemClock systemClock49 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime50 = systemClock49.now();
        util.SystemClock systemClock51 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime52 = systemClock51.now();
        model.Reservation reservation54 = new model.Reservation("P001", (model.User) guest47, equipment48, localDateTime50, localDateTime52, 10.0d);
        util.SystemClock systemClock55 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime56 = systemClock55.now();
        command.ModifyReservationCommand modifyReservationCommand58 = new command.ModifyReservationCommand(reservation39, localDateTime50, localDateTime56, "");
        model.UsageRecord usageRecord60 = new model.UsageRecord("P001", localDateTime13, localDateTime50, "Student");
        java.lang.String str61 = usageRecord60.getOperationStatus();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Research Grant" + "'", str8.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime24);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str41 + "' != '" + "" + "'", str41.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock49);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime50);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock51);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime52);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime56);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str61 + "' != '" + "Student" + "'", str61.equals("Student"));
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        model.Guest guest4 = new model.Guest("Faculty", "Faculty", "Faculty", "hi!");
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        reservation10.forfeitDeposit();
        java.lang.String str12 = reservation10.getReservationId();
        double double13 = reservation10.getDepositAmount();
        command.CancelReservationCommand cancelReservationCommand15 = new command.CancelReservationCommand(reservation10, "ACTIVE");
        model.User user16 = reservation10.getUser();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double13 + "' != '" + 1.0d + "'", double13 == 1.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(user16);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        reservation10.forfeitDeposit();
        java.lang.String str12 = reservation10.getReservationId();
        java.lang.String str13 = reservation10.getReservationId();
        model.User user14 = reservation10.getUser();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "" + "'", str13.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(user14);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        strategy.InstitutionalAccountPaymentStrategy institutionalAccountPaymentStrategy0 = new strategy.InstitutionalAccountPaymentStrategy();
        boolean boolean2 = institutionalAccountPaymentStrategy0.processPayment((double) 10.0f);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        reservation10.forfeitDeposit();
        java.lang.String str12 = reservation10.getReservationId();
        boolean boolean13 = reservation10.isDepositForfeited();
        java.time.LocalDateTime localDateTime14 = reservation10.getStartTime();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str15 = reservation10.getEquipmentId();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime14);
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        service.ReservationService reservationService2 = new service.ReservationService("hi!", "Guest");
        java.util.List<model.Reservation> reservationList3 = reservationService2.getAllReservations();
        model.Guest guest9 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        java.time.LocalDateTime localDateTime12 = null;
        model.Reservation reservation14 = new model.Reservation("", (model.User) guest9, equipment10, localDateTime11, localDateTime12, 1.0d);
        java.time.LocalDateTime localDateTime15 = reservation14.getEndTime();
        model.Student student20 = new model.Student("Research Grant", "hi!", "", "Guest");
        model.Equipment equipment21 = null;
        model.Guest guest27 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment28 = null;
        util.SystemClock systemClock29 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime30 = systemClock29.now();
        util.SystemClock systemClock31 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime32 = systemClock31.now();
        model.Reservation reservation34 = new model.Reservation("P001", (model.User) guest27, equipment28, localDateTime30, localDateTime32, 10.0d);
        model.Guest guest40 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment41 = null;
        java.time.LocalDateTime localDateTime42 = null;
        java.time.LocalDateTime localDateTime43 = null;
        model.Reservation reservation45 = new model.Reservation("", (model.User) guest40, equipment41, localDateTime42, localDateTime43, 1.0d);
        reservation45.forfeitDeposit();
        java.lang.String str47 = reservation45.getReservationId();
        model.Guest guest53 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment54 = null;
        util.SystemClock systemClock55 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime56 = systemClock55.now();
        util.SystemClock systemClock57 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime58 = systemClock57.now();
        model.Reservation reservation60 = new model.Reservation("P001", (model.User) guest53, equipment54, localDateTime56, localDateTime58, 10.0d);
        util.SystemClock systemClock61 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime62 = systemClock61.now();
        command.ModifyReservationCommand modifyReservationCommand64 = new command.ModifyReservationCommand(reservation45, localDateTime56, localDateTime62, "");
        strategy.PaymentStrategy paymentStrategy67 = null;
        command.MakeReservationCommand makeReservationCommand68 = new command.MakeReservationCommand((model.User) student20, equipment21, localDateTime30, localDateTime62, "P001", "Student", paymentStrategy67);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean69 = reservationService2.extendReservation(reservation14, localDateTime62);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock29);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime30);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock31);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime32);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str47 + "' != '" + "" + "'", str47.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime56);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock57);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime58);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock61);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime62);
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        strategy.DebitPaymentStrategy debitPaymentStrategy0 = new strategy.DebitPaymentStrategy();
        boolean boolean2 = debitPaymentStrategy0.processPayment((double) 0);
        java.lang.String str3 = debitPaymentStrategy0.getMethodName();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "Debit" + "'", str3.equals("Debit"));
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        service.BillingService billingService0 = new service.BillingService();
        strategy.FacultyPricingStrategy facultyPricingStrategy1 = new strategy.FacultyPricingStrategy();
        billingService0.setPricingStrategy((strategy.PricingStrategy) facultyPricingStrategy1);
        double double3 = billingService0.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double3 + "' != '" + 15.0d + "'", double3 == 15.0d);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        util.SystemClock systemClock0 = util.SystemClock.getInstance();
        util.Observer observer1 = null;
        systemClock0.attach(observer1);
        util.Observer observer3 = null;
        systemClock0.attach(observer3);
        // The following exception was thrown during execution in test generation
        try {
            systemClock0.notifyObservers((java.lang.Object) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock0);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        command.CommandManager commandManager0 = new command.CommandManager();
        commandManager0.printHistory();
        commandManager0.printHistory();
        java.util.List<command.ReservationCommand> reservationCommandList3 = commandManager0.getHistory();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationCommandList3);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        model.Researcher researcher7 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str8 = researcher7.getPassword();
        boolean boolean9 = researcher7.isApproved();
        model.Equipment equipment10 = null;
        util.SystemClock systemClock11 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime12 = systemClock11.now();
        java.time.LocalDateTime localDateTime13 = systemClock11.now();
        model.Guest guest19 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment20 = null;
        util.SystemClock systemClock21 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime22 = systemClock21.now();
        util.SystemClock systemClock23 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime24 = systemClock23.now();
        model.Reservation reservation26 = new model.Reservation("P001", (model.User) guest19, equipment20, localDateTime22, localDateTime24, 10.0d);
        model.Reservation reservation28 = new model.Reservation("", (model.User) researcher7, equipment10, localDateTime13, localDateTime24, (double) (byte) -1);
        model.Guest guest34 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment35 = null;
        java.time.LocalDateTime localDateTime36 = null;
        java.time.LocalDateTime localDateTime37 = null;
        model.Reservation reservation39 = new model.Reservation("", (model.User) guest34, equipment35, localDateTime36, localDateTime37, 1.0d);
        reservation39.forfeitDeposit();
        java.lang.String str41 = reservation39.getReservationId();
        model.Guest guest47 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment48 = null;
        util.SystemClock systemClock49 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime50 = systemClock49.now();
        util.SystemClock systemClock51 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime52 = systemClock51.now();
        model.Reservation reservation54 = new model.Reservation("P001", (model.User) guest47, equipment48, localDateTime50, localDateTime52, 10.0d);
        util.SystemClock systemClock55 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime56 = systemClock55.now();
        command.ModifyReservationCommand modifyReservationCommand58 = new command.ModifyReservationCommand(reservation39, localDateTime50, localDateTime56, "");
        model.UsageRecord usageRecord60 = new model.UsageRecord("P001", localDateTime13, localDateTime50, "Student");
        java.time.LocalDateTime localDateTime61 = usageRecord60.getStartTime();
        java.lang.String str62 = usageRecord60.getRecordId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Research Grant" + "'", str8.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime24);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str41 + "' != '" + "" + "'", str41.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock49);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime50);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock51);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime52);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime56);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime61);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str62 + "' != '" + "P001" + "'", str62.equals("P001"));
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        command.CommandManager commandManager0 = new command.CommandManager();
        java.util.List<command.ReservationCommand> reservationCommandList1 = commandManager0.getHistory();
        model.Reservation reservation2 = null;
        command.CancelReservationCommand cancelReservationCommand4 = new command.CancelReservationCommand(reservation2, "");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean5 = commandManager0.execute((command.ReservationCommand) cancelReservationCommand4);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationCommandList1);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        java.time.LocalDateTime localDateTime11 = reservation10.getEndTime();
        reservation10.markArrived();
        java.time.LocalDateTime localDateTime13 = reservation10.getEndTime();
        java.lang.String str14 = reservation10.getStatus();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str14 + "' != '" + "ACTIVE" + "'", str14.equals("ACTIVE"));
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        service.BillingService billingService0 = new service.BillingService();
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy1 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str2 = researchGrantPaymentStrategy1.getMethodName();
        boolean boolean4 = researchGrantPaymentStrategy1.processPayment(0.0d);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy1);
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy6 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str7 = researchGrantPaymentStrategy6.getMethodName();
        boolean boolean9 = researchGrantPaymentStrategy6.processPayment(0.0d);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy6);
        boolean boolean12 = billingService0.processPayment((double) 10.0f);
        // The following exception was thrown during execution in test generation
        try {
            double double15 = billingService0.calculateFeeWithDeposit((-1.0d), true);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: Pricing strategy not set");
        } catch (java.lang.IllegalStateException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str2 + "' != '" + "Research Grant" + "'", str2.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Research Grant" + "'", str7.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        java.time.LocalDateTime localDateTime11 = reservation10.getEndTime();
        reservation10.markArrived();
        java.lang.String str13 = reservation10.getStatus();
        model.Guest guest19 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment20 = null;
        java.time.LocalDateTime localDateTime21 = null;
        java.time.LocalDateTime localDateTime22 = null;
        model.Reservation reservation24 = new model.Reservation("", (model.User) guest19, equipment20, localDateTime21, localDateTime22, 1.0d);
        reservation24.forfeitDeposit();
        java.lang.String str26 = reservation24.getReservationId();
        model.Guest guest32 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment33 = null;
        util.SystemClock systemClock34 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime35 = systemClock34.now();
        util.SystemClock systemClock36 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime37 = systemClock36.now();
        model.Reservation reservation39 = new model.Reservation("P001", (model.User) guest32, equipment33, localDateTime35, localDateTime37, 10.0d);
        util.SystemClock systemClock40 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime41 = systemClock40.now();
        command.ModifyReservationCommand modifyReservationCommand43 = new command.ModifyReservationCommand(reservation24, localDateTime35, localDateTime41, "");
        command.ExtendReservationCommand extendReservationCommand45 = new command.ExtendReservationCommand(reservation10, localDateTime41, "Researcher");
        model.Equipment equipment46 = reservation10.getEquipment();
        java.lang.String str47 = reservation10.getUserId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "ACTIVE" + "'", str13.equals("ACTIVE"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str26 + "' != '" + "" + "'", str26.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock34);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock36);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime37);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(equipment46);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str47 + "' != '" + "hi!" + "'", str47.equals("hi!"));
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        double double11 = guest5.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double11 + "' != '" + 30.0d + "'", double11 == 30.0d);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        model.Researcher researcher5 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str6 = researcher5.getPassword();
        java.lang.String str7 = researcher5.getUserType();
        boolean boolean8 = researcher5.isApproved();
        java.lang.String str9 = researcher5.getEmail();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Research Grant" + "'", str6.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Researcher" + "'", str7.equals("Researcher"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Research Grant" + "'", str9.equals("Research Grant"));
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        service.ReservationService reservationService2 = new service.ReservationService("Research Grant", "ACTIVE");
        model.Guest guest8 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment9 = null;
        java.time.LocalDateTime localDateTime10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        model.Reservation reservation13 = new model.Reservation("", (model.User) guest8, equipment9, localDateTime10, localDateTime11, 1.0d);
        java.time.LocalDateTime localDateTime14 = reservation13.getEndTime();
        reservation13.markArrived();
        java.time.LocalDateTime localDateTime16 = reservation13.getEndTime();
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean17 = reservationService2.cancelReservation(reservation13);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime16);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        data.MaintainUser maintainUser0 = new data.MaintainUser();
        maintainUser0.load("Researcher");
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        model.Guest guest4 = new model.Guest("", "Research Grant", "", "hi!");
        java.lang.String str5 = guest4.getName();
        double double6 = guest4.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "" + "'", str5.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 30.0d + "'", double6 == 30.0d);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        reservation10.forfeitDeposit();
        java.lang.String str12 = reservation10.getReservationId();
        double double13 = reservation10.getDepositAmount();
        command.CancelReservationCommand cancelReservationCommand15 = new command.CancelReservationCommand(reservation10, "ACTIVE");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean16 = cancelReservationCommand15.canExecute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double13 + "' != '" + 1.0d + "'", double13 == 1.0d);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        model.Payment payment8 = new model.Payment("R001", "R001", "hi!", (double) '4', "", "P001", "P001", "");
        java.lang.String str9 = payment8.getTimestamp();
        java.lang.String str10 = payment8.getReservationId();
        java.lang.String str11 = payment8.getPaymentId();
        java.lang.String str12 = payment8.getTimestamp();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "P001" + "'", str9.equals("P001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "R001" + "'", str10.equals("R001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "R001" + "'", str11.equals("R001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "P001" + "'", str12.equals("P001"));
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        data.MaintainReservation maintainReservation0 = new data.MaintainReservation();
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean5 = maintainReservation0.hasOverlap("hi!", "", "Student", "Student");
            org.junit.Assert.fail("Expected exception of type java.time.format.DateTimeParseException; message: Text '' could not be parsed at index 0");
        } catch (java.time.format.DateTimeParseException e) {
        // Expected exception.
        }
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        model.Payment payment8 = new model.Payment("ACTIVE", "Researcher", "ACTIVE", (double) 1.0f, "", "P001", "Faculty", "ACTIVE");
        java.lang.String str9 = payment8.getUserId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "ACTIVE" + "'", str9.equals("ACTIVE"));
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        model.Faculty faculty5 = new model.Faculty("", "P001", "hi!", "R001", true);
        java.lang.String str6 = faculty5.getUserType();
        java.lang.String str7 = faculty5.getUserType();
        boolean boolean8 = faculty5.isApproved();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Faculty" + "'", str6.equals("Faculty"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Faculty" + "'", str7.equals("Faculty"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        model.Payment payment8 = new model.Payment("P001", "", "ACTIVE", (double) 0, "ACTIVE", "Student", "Research Grant", "Researcher");
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        model.LabManager labManager4 = new model.LabManager("hi!", "hi!", "ACTIVE", "ACTIVE");
        model.Equipment equipment8 = new model.Equipment("Student", "", "Faculty");
        labManager4.enableEquipment(equipment8);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        reservation10.forfeitDeposit();
        java.lang.String str12 = reservation10.getReservationId();
        double double13 = reservation10.getDepositAmount();
        command.CancelReservationCommand cancelReservationCommand15 = new command.CancelReservationCommand(reservation10, "ACTIVE");
        java.lang.String str16 = cancelReservationCommand15.getErrorMessage();
        java.lang.String str17 = cancelReservationCommand15.getDescription();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double13 + "' != '" + 1.0d + "'", double13 == 1.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str16 + "' != '" + "" + "'", str16.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str17 + "' != '" + "Cancel reservation " + "'", str17.equals("Cancel reservation "));
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        java.time.LocalDateTime localDateTime11 = reservation10.getEndTime();
        reservation10.markArrived();
        java.lang.String str13 = reservation10.getStatus();
        model.Guest guest19 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment20 = null;
        java.time.LocalDateTime localDateTime21 = null;
        java.time.LocalDateTime localDateTime22 = null;
        model.Reservation reservation24 = new model.Reservation("", (model.User) guest19, equipment20, localDateTime21, localDateTime22, 1.0d);
        reservation24.forfeitDeposit();
        java.lang.String str26 = reservation24.getReservationId();
        model.Guest guest32 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment33 = null;
        util.SystemClock systemClock34 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime35 = systemClock34.now();
        util.SystemClock systemClock36 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime37 = systemClock36.now();
        model.Reservation reservation39 = new model.Reservation("P001", (model.User) guest32, equipment33, localDateTime35, localDateTime37, 10.0d);
        util.SystemClock systemClock40 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime41 = systemClock40.now();
        command.ModifyReservationCommand modifyReservationCommand43 = new command.ModifyReservationCommand(reservation24, localDateTime35, localDateTime41, "");
        command.ExtendReservationCommand extendReservationCommand45 = new command.ExtendReservationCommand(reservation10, localDateTime41, "Researcher");
        model.Equipment equipment46 = reservation10.getEquipment();
        boolean boolean47 = reservation10.hasArrived();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "ACTIVE" + "'", str13.equals("ACTIVE"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str26 + "' != '" + "" + "'", str26.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock34);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock36);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime37);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(equipment46);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean47 + "' != '" + true + "'", boolean47 == true);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        model.Faculty faculty5 = new model.Faculty("", "P001", "hi!", "R001", true);
        double double6 = faculty5.getHourlyRate();
        java.lang.String str7 = faculty5.getUserType();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 15.0d + "'", double6 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Faculty" + "'", str7.equals("Faculty"));
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        model.Reservation reservation0 = null;
        java.time.LocalDateTime localDateTime1 = null;
        command.ExtendReservationCommand extendReservationCommand3 = new command.ExtendReservationCommand(reservation0, localDateTime1, "Research Grant");
        java.lang.String str4 = extendReservationCommand3.getErrorMessage();
        java.lang.String str5 = extendReservationCommand3.getErrorMessage();
        java.lang.String str6 = extendReservationCommand3.getErrorMessage();
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean7 = extendReservationCommand3.canExecute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "" + "'", str4.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "" + "'", str5.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "" + "'", str6.equals(""));
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        model.Researcher researcher5 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str6 = researcher5.getPassword();
        boolean boolean7 = researcher5.isApproved();
        java.lang.String str8 = researcher5.getPassword();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Research Grant" + "'", str6.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Research Grant" + "'", str8.equals("Research Grant"));
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        reservation10.markArrived();
        model.Guest guest17 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment18 = null;
        java.time.LocalDateTime localDateTime19 = null;
        java.time.LocalDateTime localDateTime20 = null;
        model.Reservation reservation22 = new model.Reservation("", (model.User) guest17, equipment18, localDateTime19, localDateTime20, 1.0d);
        java.time.LocalDateTime localDateTime23 = reservation22.getEndTime();
        java.lang.String str24 = reservation22.getReservationId();
        util.SystemClock systemClock25 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime26 = systemClock25.now();
        model.Student student31 = new model.Student("Research Grant", "hi!", "", "Guest");
        model.Equipment equipment32 = null;
        model.Guest guest38 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment39 = null;
        util.SystemClock systemClock40 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime41 = systemClock40.now();
        util.SystemClock systemClock42 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime43 = systemClock42.now();
        model.Reservation reservation45 = new model.Reservation("P001", (model.User) guest38, equipment39, localDateTime41, localDateTime43, 10.0d);
        model.Guest guest51 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment52 = null;
        java.time.LocalDateTime localDateTime53 = null;
        java.time.LocalDateTime localDateTime54 = null;
        model.Reservation reservation56 = new model.Reservation("", (model.User) guest51, equipment52, localDateTime53, localDateTime54, 1.0d);
        reservation56.forfeitDeposit();
        java.lang.String str58 = reservation56.getReservationId();
        model.Guest guest64 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment65 = null;
        util.SystemClock systemClock66 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime67 = systemClock66.now();
        util.SystemClock systemClock68 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime69 = systemClock68.now();
        model.Reservation reservation71 = new model.Reservation("P001", (model.User) guest64, equipment65, localDateTime67, localDateTime69, 10.0d);
        util.SystemClock systemClock72 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime73 = systemClock72.now();
        command.ModifyReservationCommand modifyReservationCommand75 = new command.ModifyReservationCommand(reservation56, localDateTime67, localDateTime73, "");
        strategy.PaymentStrategy paymentStrategy78 = null;
        command.MakeReservationCommand makeReservationCommand79 = new command.MakeReservationCommand((model.User) student31, equipment32, localDateTime41, localDateTime73, "P001", "Student", paymentStrategy78);
        command.ModifyReservationCommand modifyReservationCommand81 = new command.ModifyReservationCommand(reservation22, localDateTime26, localDateTime41, "Guest");
        reservation10.setStartTime(localDateTime41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str24 + "' != '" + "" + "'", str24.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock25);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime26);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime43);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str58 + "' != '" + "" + "'", str58.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock66);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime67);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock68);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime69);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock72);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime73);
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        service.ReservationService reservationService2 = new service.ReservationService("Guest", "P001");
        model.Student student7 = new model.Student("Research Grant", "hi!", "", "Guest");
        model.Equipment equipment8 = null;
        model.Guest guest14 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment15 = null;
        util.SystemClock systemClock16 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime17 = systemClock16.now();
        util.SystemClock systemClock18 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime19 = systemClock18.now();
        model.Reservation reservation21 = new model.Reservation("P001", (model.User) guest14, equipment15, localDateTime17, localDateTime19, 10.0d);
        model.Guest guest27 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment28 = null;
        java.time.LocalDateTime localDateTime29 = null;
        java.time.LocalDateTime localDateTime30 = null;
        model.Reservation reservation32 = new model.Reservation("", (model.User) guest27, equipment28, localDateTime29, localDateTime30, 1.0d);
        reservation32.forfeitDeposit();
        java.lang.String str34 = reservation32.getReservationId();
        model.Guest guest40 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment41 = null;
        util.SystemClock systemClock42 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime43 = systemClock42.now();
        util.SystemClock systemClock44 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime45 = systemClock44.now();
        model.Reservation reservation47 = new model.Reservation("P001", (model.User) guest40, equipment41, localDateTime43, localDateTime45, 10.0d);
        util.SystemClock systemClock48 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime49 = systemClock48.now();
        command.ModifyReservationCommand modifyReservationCommand51 = new command.ModifyReservationCommand(reservation32, localDateTime43, localDateTime49, "");
        strategy.PaymentStrategy paymentStrategy54 = null;
        command.MakeReservationCommand makeReservationCommand55 = new command.MakeReservationCommand((model.User) student7, equipment8, localDateTime17, localDateTime49, "P001", "Student", paymentStrategy54);
        model.Equipment equipment59 = new model.Equipment("R001", "", "Researcher");
        java.lang.String str60 = equipment59.getDescription();
        equipment59.markUnderMaintenance();
        java.lang.String str62 = equipment59.getName();
        model.Guest guest68 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment69 = null;
        util.SystemClock systemClock70 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime71 = systemClock70.now();
        util.SystemClock systemClock72 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime73 = systemClock72.now();
        model.Reservation reservation75 = new model.Reservation("P001", (model.User) guest68, equipment69, localDateTime71, localDateTime73, 10.0d);
        model.Guest guest81 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment82 = null;
        util.SystemClock systemClock83 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime84 = systemClock83.now();
        util.SystemClock systemClock85 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime86 = systemClock85.now();
        model.Reservation reservation88 = new model.Reservation("P001", (model.User) guest81, equipment82, localDateTime84, localDateTime86, 10.0d);
        command.ExtendReservationCommand extendReservationCommand90 = new command.ExtendReservationCommand(reservation75, localDateTime86, "Student");
        util.SystemClock systemClock91 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime92 = systemClock91.now();
        java.time.LocalDateTime localDateTime93 = systemClock91.now();
        java.time.LocalDateTime localDateTime94 = systemClock91.now();
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy95 = new strategy.ResearchGrantPaymentStrategy();
        boolean boolean96 = reservationService2.makeReservation((model.User) student7, equipment59, localDateTime86, localDateTime94, (strategy.PaymentStrategy) researchGrantPaymentStrategy95);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock18);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime19);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str34 + "' != '" + "" + "'", str34.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime43);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock44);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime45);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock48);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime49);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str60 + "' != '" + "" + "'", str60.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str62 + "' != '" + "" + "'", str62.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock70);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime71);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock72);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime73);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock83);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime84);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock85);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime86);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock91);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime92);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime93);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime94);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean96 + "' != '" + false + "'", boolean96 == false);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        service.BillingService billingService0 = new service.BillingService();
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy1 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str2 = researchGrantPaymentStrategy1.getMethodName();
        boolean boolean4 = researchGrantPaymentStrategy1.processPayment(0.0d);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy1);
        // The following exception was thrown during execution in test generation
        try {
            double double6 = billingService0.getHourlyRate();
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: Pricing strategy not set");
        } catch (java.lang.IllegalStateException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str2 + "' != '" + "Research Grant" + "'", str2.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test129");
        data.MaintainPayment maintainPayment0 = new data.MaintainPayment();
        model.Payment[] paymentArray1 = new model.Payment[] {};
        java.util.ArrayList<model.Payment> paymentList2 = new java.util.ArrayList<model.Payment>();
        boolean boolean3 = java.util.Collections.addAll((java.util.Collection<model.Payment>) paymentList2, paymentArray1);
        maintainPayment0.payments = paymentList2;
        java.util.List<model.Payment> paymentList5 = maintainPayment0.payments;
        maintainPayment0.load("Student");
        maintainPayment0.load("Faculty");
        maintainPayment0.load("P001");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(paymentArray1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(paymentList5);
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test130");
        data.MaintainEquipment maintainEquipment0 = new data.MaintainEquipment();
        java.util.List<model.Equipment> equipmentList1 = null;
        maintainEquipment0.equipmentList = equipmentList1;
        // The following exception was thrown during execution in test generation
        try {
            maintainEquipment0.update("Debit");
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test131");
        service.BillingService billingService0 = new service.BillingService();
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy1 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str2 = researchGrantPaymentStrategy1.getMethodName();
        boolean boolean4 = researchGrantPaymentStrategy1.processPayment(0.0d);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy1);
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy6 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str7 = researchGrantPaymentStrategy6.getMethodName();
        boolean boolean9 = researchGrantPaymentStrategy6.processPayment(0.0d);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy6);
        boolean boolean12 = billingService0.processPayment((double) (byte) 1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str2 + "' != '" + "Research Grant" + "'", str2.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Research Grant" + "'", str7.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test132");
        model.Researcher researcher5 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str6 = researcher5.getPassword();
        double double7 = researcher5.getHourlyRate();
        java.lang.String str8 = researcher5.getUserType();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Research Grant" + "'", str6.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double7 + "' != '" + 20.0d + "'", double7 == 20.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Researcher" + "'", str8.equals("Researcher"));
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test133");
        model.Faculty faculty5 = new model.Faculty("", "P001", "hi!", "R001", true);
        java.lang.String str6 = faculty5.getUserType();
        double double7 = faculty5.getHourlyRate();
        java.lang.String str8 = faculty5.getUserType();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Faculty" + "'", str6.equals("Faculty"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double7 + "' != '" + 15.0d + "'", double7 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Faculty" + "'", str8.equals("Faculty"));
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test134");
        service.BillingService billingService0 = new service.BillingService();
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy1 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str2 = researchGrantPaymentStrategy1.getMethodName();
        boolean boolean4 = researchGrantPaymentStrategy1.processPayment(0.0d);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy1);
        service.BillingService billingService6 = new service.BillingService();
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy7 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str8 = researchGrantPaymentStrategy7.getMethodName();
        boolean boolean10 = researchGrantPaymentStrategy7.processPayment(0.0d);
        billingService6.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy7);
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy12 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str13 = researchGrantPaymentStrategy12.getMethodName();
        boolean boolean15 = researchGrantPaymentStrategy12.processPayment(0.0d);
        billingService6.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy12);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy12);
        boolean boolean19 = researchGrantPaymentStrategy12.processPayment((double) 100.0f);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str2 + "' != '" + "Research Grant" + "'", str2.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Research Grant" + "'", str8.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "Research Grant" + "'", str13.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test135");
        service.ReservationService reservationService2 = new service.ReservationService("Research Grant", "ACTIVE");
        java.util.List<model.Reservation> reservationList4 = reservationService2.getReservationsForEquipment("Guest");
        java.util.List<model.Reservation> reservationList6 = reservationService2.getReservationsForEquipment("Research Grant");
        java.lang.String str7 = reservationService2.getLastError();
        model.Guest guest13 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment14 = null;
        util.SystemClock systemClock15 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime16 = systemClock15.now();
        util.SystemClock systemClock17 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime18 = systemClock17.now();
        model.Reservation reservation20 = new model.Reservation("P001", (model.User) guest13, equipment14, localDateTime16, localDateTime18, 10.0d);
        model.Guest guest26 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment27 = null;
        java.time.LocalDateTime localDateTime28 = null;
        java.time.LocalDateTime localDateTime29 = null;
        model.Reservation reservation31 = new model.Reservation("", (model.User) guest26, equipment27, localDateTime28, localDateTime29, 1.0d);
        java.time.LocalDateTime localDateTime32 = reservation31.getEndTime();
        reservation31.markArrived();
        java.lang.String str34 = reservation31.getStatus();
        model.Guest guest40 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment41 = null;
        java.time.LocalDateTime localDateTime42 = null;
        java.time.LocalDateTime localDateTime43 = null;
        model.Reservation reservation45 = new model.Reservation("", (model.User) guest40, equipment41, localDateTime42, localDateTime43, 1.0d);
        reservation45.forfeitDeposit();
        java.lang.String str47 = reservation45.getReservationId();
        model.Guest guest53 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment54 = null;
        util.SystemClock systemClock55 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime56 = systemClock55.now();
        util.SystemClock systemClock57 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime58 = systemClock57.now();
        model.Reservation reservation60 = new model.Reservation("P001", (model.User) guest53, equipment54, localDateTime56, localDateTime58, 10.0d);
        util.SystemClock systemClock61 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime62 = systemClock61.now();
        command.ModifyReservationCommand modifyReservationCommand64 = new command.ModifyReservationCommand(reservation45, localDateTime56, localDateTime62, "");
        command.ExtendReservationCommand extendReservationCommand66 = new command.ExtendReservationCommand(reservation31, localDateTime62, "Researcher");
        model.Researcher researcher73 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str74 = researcher73.getPassword();
        boolean boolean75 = researcher73.isApproved();
        model.Equipment equipment76 = null;
        util.SystemClock systemClock77 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime78 = systemClock77.now();
        java.time.LocalDateTime localDateTime79 = systemClock77.now();
        model.Guest guest85 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment86 = null;
        util.SystemClock systemClock87 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime88 = systemClock87.now();
        util.SystemClock systemClock89 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime90 = systemClock89.now();
        model.Reservation reservation92 = new model.Reservation("P001", (model.User) guest85, equipment86, localDateTime88, localDateTime90, 10.0d);
        model.Reservation reservation94 = new model.Reservation("", (model.User) researcher73, equipment76, localDateTime79, localDateTime90, (double) (byte) -1);
        java.time.LocalDateTime localDateTime95 = reservation94.getEndTime();
        boolean boolean96 = reservationService2.modifyReservation(reservation20, localDateTime62, localDateTime95);
        java.util.List<model.Reservation> reservationList97 = reservationService2.getAllReservations();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime18);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime32);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str34 + "' != '" + "ACTIVE" + "'", str34.equals("ACTIVE"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str47 + "' != '" + "" + "'", str47.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime56);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock57);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime58);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock61);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime62);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str74 + "' != '" + "Research Grant" + "'", str74.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean75 + "' != '" + false + "'", boolean75 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock77);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime78);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime79);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock87);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime88);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock89);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime90);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime95);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean96 + "' != '" + false + "'", boolean96 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList97);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test136");
        model.Equipment equipment3 = new model.Equipment("R001", "", "Researcher");
        java.lang.String str4 = equipment3.getDescription();
        equipment3.markUnderMaintenance();
        java.lang.String str6 = equipment3.getCurrentStateName();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "" + "'", str4.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Maintenance" + "'", str6.equals("Maintenance"));
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test137");
        model.Student student4 = new model.Student("Research Grant", "hi!", "", "Guest");
        model.Equipment equipment5 = null;
        model.Guest guest11 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment12 = null;
        util.SystemClock systemClock13 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime14 = systemClock13.now();
        util.SystemClock systemClock15 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime16 = systemClock15.now();
        model.Reservation reservation18 = new model.Reservation("P001", (model.User) guest11, equipment12, localDateTime14, localDateTime16, 10.0d);
        model.Guest guest24 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment25 = null;
        java.time.LocalDateTime localDateTime26 = null;
        java.time.LocalDateTime localDateTime27 = null;
        model.Reservation reservation29 = new model.Reservation("", (model.User) guest24, equipment25, localDateTime26, localDateTime27, 1.0d);
        reservation29.forfeitDeposit();
        java.lang.String str31 = reservation29.getReservationId();
        model.Guest guest37 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment38 = null;
        util.SystemClock systemClock39 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime40 = systemClock39.now();
        util.SystemClock systemClock41 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime42 = systemClock41.now();
        model.Reservation reservation44 = new model.Reservation("P001", (model.User) guest37, equipment38, localDateTime40, localDateTime42, 10.0d);
        util.SystemClock systemClock45 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime46 = systemClock45.now();
        command.ModifyReservationCommand modifyReservationCommand48 = new command.ModifyReservationCommand(reservation29, localDateTime40, localDateTime46, "");
        strategy.PaymentStrategy paymentStrategy51 = null;
        command.MakeReservationCommand makeReservationCommand52 = new command.MakeReservationCommand((model.User) student4, equipment5, localDateTime14, localDateTime46, "P001", "Student", paymentStrategy51);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean53 = makeReservationCommand52.canExecute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str31 + "' != '" + "" + "'", str31.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock39);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock45);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime46);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test138");
        model.Student student4 = new model.Student("Available", "", "Student", "P001");
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test139");
        model.Payment payment8 = new model.Payment("R001", "R001", "hi!", (double) '4', "", "P001", "P001", "");
        java.lang.String str9 = payment8.getPaymentId();
        java.lang.String str10 = payment8.getUserId();
        java.lang.String str11 = payment8.getType();
        java.lang.String str12 = payment8.getPaymentId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "R001" + "'", str9.equals("R001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "hi!" + "'", str10.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "" + "'", str11.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "R001" + "'", str12.equals("R001"));
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test140");
        model.LabManager labManager4 = new model.LabManager("P001", "Faculty", "Faculty", "Faculty");
        java.lang.String str5 = labManager4.getUserType();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "LabManager" + "'", str5.equals("LabManager"));
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test141");
        model.Reservation reservation0 = null;
        command.CancelReservationCommand cancelReservationCommand2 = new command.CancelReservationCommand(reservation0, "");
        java.lang.String str3 = cancelReservationCommand2.getErrorMessage();
        java.lang.String str4 = cancelReservationCommand2.getErrorMessage();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "" + "'", str3.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "" + "'", str4.equals(""));
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test142");
        data.MaintainReservation maintainReservation0 = new data.MaintainReservation();
        java.lang.String str1 = maintainReservation0.nextId();
        data.MaintainReservation maintainReservation2 = new data.MaintainReservation();
        java.lang.String str3 = maintainReservation2.nextId();
        java.util.List<model.Reservation> reservationList4 = maintainReservation2.reservations;
        maintainReservation0.reservations = reservationList4;
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str1 + "' != '" + "R001" + "'", str1.equals("R001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "R001" + "'", str3.equals("R001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList4);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test143");
        service.ReservationService reservationService2 = new service.ReservationService("hi!", "Guest");
        reservationService2.printCommandHistory();
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test144");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        java.time.LocalDateTime localDateTime11 = reservation10.getEndTime();
        java.lang.String str12 = reservation10.getReservationId();
        util.SystemClock systemClock13 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime14 = systemClock13.now();
        model.Student student19 = new model.Student("Research Grant", "hi!", "", "Guest");
        model.Equipment equipment20 = null;
        model.Guest guest26 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment27 = null;
        util.SystemClock systemClock28 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime29 = systemClock28.now();
        util.SystemClock systemClock30 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime31 = systemClock30.now();
        model.Reservation reservation33 = new model.Reservation("P001", (model.User) guest26, equipment27, localDateTime29, localDateTime31, 10.0d);
        model.Guest guest39 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment40 = null;
        java.time.LocalDateTime localDateTime41 = null;
        java.time.LocalDateTime localDateTime42 = null;
        model.Reservation reservation44 = new model.Reservation("", (model.User) guest39, equipment40, localDateTime41, localDateTime42, 1.0d);
        reservation44.forfeitDeposit();
        java.lang.String str46 = reservation44.getReservationId();
        model.Guest guest52 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment53 = null;
        util.SystemClock systemClock54 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime55 = systemClock54.now();
        util.SystemClock systemClock56 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime57 = systemClock56.now();
        model.Reservation reservation59 = new model.Reservation("P001", (model.User) guest52, equipment53, localDateTime55, localDateTime57, 10.0d);
        util.SystemClock systemClock60 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime61 = systemClock60.now();
        command.ModifyReservationCommand modifyReservationCommand63 = new command.ModifyReservationCommand(reservation44, localDateTime55, localDateTime61, "");
        strategy.PaymentStrategy paymentStrategy66 = null;
        command.MakeReservationCommand makeReservationCommand67 = new command.MakeReservationCommand((model.User) student19, equipment20, localDateTime29, localDateTime61, "P001", "Student", paymentStrategy66);
        command.ModifyReservationCommand modifyReservationCommand69 = new command.ModifyReservationCommand(reservation10, localDateTime14, localDateTime29, "Guest");
        java.lang.String str70 = modifyReservationCommand69.getDescription();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock28);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime29);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock30);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime31);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str46 + "' != '" + "" + "'", str46.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock54);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock56);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime57);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock60);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime61);
        // Regression assertion (captures the current behavior of the code)
        // Date-agnostic: snapshot date captured at generation time drifts every day
        org.junit.Assert.assertTrue("description should start with 'Modify reservation'", str70.startsWith("Modify reservation"));
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test145");
        data.MaintainEquipment maintainEquipment0 = new data.MaintainEquipment();
        maintainEquipment0.load("Research Grant");
        model.Equipment equipment4 = maintainEquipment0.findById("");
        java.util.List<model.Equipment> equipmentList5 = maintainEquipment0.getAvailableEquipment();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(equipment4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipmentList5);
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test146");
        model.Equipment equipment3 = new model.Equipment("R001", "", "Researcher");
        model.EquipmentState equipmentState4 = equipment3.getState();
        equipment3.disable();
        java.lang.String str6 = equipment3.getDescription();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipmentState4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "" + "'", str6.equals(""));
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test147");
        service.BillingService billingService0 = new service.BillingService();
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy1 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str2 = researchGrantPaymentStrategy1.getMethodName();
        boolean boolean4 = researchGrantPaymentStrategy1.processPayment(0.0d);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy1);
        service.BillingService billingService6 = new service.BillingService();
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy7 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str8 = researchGrantPaymentStrategy7.getMethodName();
        boolean boolean10 = researchGrantPaymentStrategy7.processPayment(0.0d);
        billingService6.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy7);
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy12 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str13 = researchGrantPaymentStrategy12.getMethodName();
        boolean boolean15 = researchGrantPaymentStrategy12.processPayment(0.0d);
        billingService6.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy12);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy12);
        boolean boolean19 = researchGrantPaymentStrategy12.processPayment(100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str2 + "' != '" + "Research Grant" + "'", str2.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Research Grant" + "'", str8.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "Research Grant" + "'", str13.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + true + "'", boolean19 == true);
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test148");
        model.Payment payment8 = new model.Payment("R001", "R001", "hi!", (double) '4', "", "P001", "P001", "");
        java.lang.String str9 = payment8.getStatus();
        java.lang.String str10 = payment8.getTimestamp();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "P001" + "'", str9.equals("P001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "P001" + "'", str10.equals("P001"));
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test149");
        model.Faculty faculty5 = new model.Faculty("", "P001", "hi!", "R001", true);
        boolean boolean6 = faculty5.isApproved();
        boolean boolean7 = faculty5.isApproved();
        boolean boolean8 = faculty5.isApproved();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test150");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        reservation10.forfeitDeposit();
        java.lang.String str12 = reservation10.getReservationId();
        boolean boolean13 = reservation10.isDepositForfeited();
        java.time.LocalDateTime localDateTime14 = reservation10.getStartTime();
        boolean boolean15 = reservation10.isDepositForfeited();
        java.time.LocalDateTime localDateTime16 = reservation10.getStartTime();
        java.lang.String str17 = reservation10.getReservationId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str17 + "' != '" + "" + "'", str17.equals(""));
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test151");
        data.MaintainReservation maintainReservation0 = new data.MaintainReservation();
        java.lang.String str1 = maintainReservation0.nextId();
        service.ReservationService reservationService4 = new service.ReservationService("Research Grant", "ACTIVE");
        java.util.List<model.Reservation> reservationList6 = reservationService4.getReservationsForEquipment("Guest");
        maintainReservation0.reservations = reservationList6;
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean12 = maintainReservation0.hasOverlap("", "Available", "hi!", "LabManager");
            org.junit.Assert.fail("Expected exception of type java.time.format.DateTimeParseException; message: Text 'Available' could not be parsed at index 0");
        } catch (java.time.format.DateTimeParseException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str1 + "' != '" + "R001" + "'", str1.equals("R001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList6);
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test152");
        data.MaintainPayment maintainPayment0 = new data.MaintainPayment();
        model.Payment[] paymentArray1 = new model.Payment[] {};
        java.util.ArrayList<model.Payment> paymentList2 = new java.util.ArrayList<model.Payment>();
        boolean boolean3 = java.util.Collections.addAll((java.util.Collection<model.Payment>) paymentList2, paymentArray1);
        maintainPayment0.payments = paymentList2;
        java.util.List<model.Payment> paymentList5 = maintainPayment0.payments;
        maintainPayment0.load("Student");
        maintainPayment0.load("Faculty");
        java.util.List<model.Payment> paymentList10 = maintainPayment0.payments;
        data.MaintainPayment maintainPayment11 = new data.MaintainPayment();
        model.Payment[] paymentArray12 = new model.Payment[] {};
        java.util.ArrayList<model.Payment> paymentList13 = new java.util.ArrayList<model.Payment>();
        boolean boolean14 = java.util.Collections.addAll((java.util.Collection<model.Payment>) paymentList13, paymentArray12);
        maintainPayment11.payments = paymentList13;
        data.MaintainPayment maintainPayment16 = new data.MaintainPayment();
        model.Payment[] paymentArray17 = new model.Payment[] {};
        java.util.ArrayList<model.Payment> paymentList18 = new java.util.ArrayList<model.Payment>();
        boolean boolean19 = java.util.Collections.addAll((java.util.Collection<model.Payment>) paymentList18, paymentArray17);
        maintainPayment16.payments = paymentList18;
        java.util.List<model.Payment> paymentList21 = maintainPayment16.payments;
        maintainPayment11.payments = paymentList21;
        maintainPayment0.payments = paymentList21;
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(paymentArray1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(paymentList5);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(paymentList10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(paymentArray12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean14 + "' != '" + false + "'", boolean14 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(paymentArray17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean19 + "' != '" + false + "'", boolean19 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(paymentList21);
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test153");
        model.Researcher researcher7 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str8 = researcher7.getPassword();
        boolean boolean9 = researcher7.isApproved();
        model.Equipment equipment10 = null;
        util.SystemClock systemClock11 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime12 = systemClock11.now();
        java.time.LocalDateTime localDateTime13 = systemClock11.now();
        model.Guest guest19 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment20 = null;
        util.SystemClock systemClock21 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime22 = systemClock21.now();
        util.SystemClock systemClock23 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime24 = systemClock23.now();
        model.Reservation reservation26 = new model.Reservation("P001", (model.User) guest19, equipment20, localDateTime22, localDateTime24, 10.0d);
        model.Reservation reservation28 = new model.Reservation("", (model.User) researcher7, equipment10, localDateTime13, localDateTime24, (double) (byte) -1);
        model.Guest guest34 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment35 = null;
        java.time.LocalDateTime localDateTime36 = null;
        java.time.LocalDateTime localDateTime37 = null;
        model.Reservation reservation39 = new model.Reservation("", (model.User) guest34, equipment35, localDateTime36, localDateTime37, 1.0d);
        reservation39.forfeitDeposit();
        java.lang.String str41 = reservation39.getReservationId();
        model.Guest guest47 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment48 = null;
        util.SystemClock systemClock49 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime50 = systemClock49.now();
        util.SystemClock systemClock51 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime52 = systemClock51.now();
        model.Reservation reservation54 = new model.Reservation("P001", (model.User) guest47, equipment48, localDateTime50, localDateTime52, 10.0d);
        util.SystemClock systemClock55 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime56 = systemClock55.now();
        command.ModifyReservationCommand modifyReservationCommand58 = new command.ModifyReservationCommand(reservation39, localDateTime50, localDateTime56, "");
        model.UsageRecord usageRecord60 = new model.UsageRecord("P001", localDateTime13, localDateTime50, "Student");
        java.time.LocalDateTime localDateTime61 = usageRecord60.getEndTime();
        int int62 = usageRecord60.getDurationMinutes();
        java.time.LocalDateTime localDateTime63 = usageRecord60.getEndTime();
        java.lang.String str64 = usageRecord60.getOperationStatus();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Research Grant" + "'", str8.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime24);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str41 + "' != '" + "" + "'", str41.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock49);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime50);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock51);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime52);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime56);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime61);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int62 + "' != '" + 0 + "'", int62 == 0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime63);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str64 + "' != '" + "Student" + "'", str64.equals("Student"));
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test154");
        strategy.InstitutionalAccountPaymentStrategy institutionalAccountPaymentStrategy0 = new strategy.InstitutionalAccountPaymentStrategy();
        boolean boolean2 = institutionalAccountPaymentStrategy0.processPayment((double) (byte) 100);
        java.lang.String str3 = institutionalAccountPaymentStrategy0.getMethodName();
        java.lang.String str4 = institutionalAccountPaymentStrategy0.getMethodName();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "Institutional Account" + "'", str3.equals("Institutional Account"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "Institutional Account" + "'", str4.equals("Institutional Account"));
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test155");
        model.Researcher researcher7 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str8 = researcher7.getPassword();
        boolean boolean9 = researcher7.isApproved();
        model.Equipment equipment10 = null;
        util.SystemClock systemClock11 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime12 = systemClock11.now();
        java.time.LocalDateTime localDateTime13 = systemClock11.now();
        model.Guest guest19 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment20 = null;
        util.SystemClock systemClock21 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime22 = systemClock21.now();
        util.SystemClock systemClock23 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime24 = systemClock23.now();
        model.Reservation reservation26 = new model.Reservation("P001", (model.User) guest19, equipment20, localDateTime22, localDateTime24, 10.0d);
        model.Reservation reservation28 = new model.Reservation("", (model.User) researcher7, equipment10, localDateTime13, localDateTime24, (double) (byte) -1);
        model.Guest guest34 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment35 = null;
        java.time.LocalDateTime localDateTime36 = null;
        java.time.LocalDateTime localDateTime37 = null;
        model.Reservation reservation39 = new model.Reservation("", (model.User) guest34, equipment35, localDateTime36, localDateTime37, 1.0d);
        reservation39.forfeitDeposit();
        java.lang.String str41 = reservation39.getReservationId();
        model.Guest guest47 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment48 = null;
        util.SystemClock systemClock49 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime50 = systemClock49.now();
        util.SystemClock systemClock51 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime52 = systemClock51.now();
        model.Reservation reservation54 = new model.Reservation("P001", (model.User) guest47, equipment48, localDateTime50, localDateTime52, 10.0d);
        util.SystemClock systemClock55 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime56 = systemClock55.now();
        command.ModifyReservationCommand modifyReservationCommand58 = new command.ModifyReservationCommand(reservation39, localDateTime50, localDateTime56, "");
        model.UsageRecord usageRecord60 = new model.UsageRecord("P001", localDateTime13, localDateTime50, "Student");
        java.time.LocalDateTime localDateTime61 = usageRecord60.getStartTime();
        int int62 = usageRecord60.getDurationMinutes();
        java.time.LocalDateTime localDateTime63 = usageRecord60.getEndTime();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Research Grant" + "'", str8.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime24);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str41 + "' != '" + "" + "'", str41.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock49);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime50);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock51);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime52);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime56);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime61);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int62 + "' != '" + 0 + "'", int62 == 0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime63);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test156");
        model.Student student4 = new model.Student("Research Grant", "hi!", "", "Guest");
        java.lang.String str5 = student4.getName();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "Research Grant" + "'", str5.equals("Research Grant"));
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test157");
        model.HeadLabCoordinator headLabCoordinator0 = model.HeadLabCoordinator.getInstance();
        model.LabManager labManager5 = headLabCoordinator0.createLabManagerAccount("P001", "ACTIVE", "Modify reservation  to 2026-03-25 18:41 \u2192 2026-03-25 18:41", "Faculty");
        java.lang.String str6 = labManager5.getManagerId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(headLabCoordinator0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(labManager5);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Faculty" + "'", str6.equals("Faculty"));
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test158");
        model.Guest guest4 = new model.Guest("Modify reservation  to 2026-03-25 18:41 \u2192 2026-03-25 18:41", "Faculty", "Available", "Cancel reservation ");
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test159");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        reservation10.forfeitDeposit();
        java.lang.String str12 = reservation10.getReservationId();
        reservation10.markArrived();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test160");
        service.ReservationService reservationService2 = new service.ReservationService("hi!", "Guest");
        java.util.List<model.Reservation> reservationList4 = reservationService2.getReservationsForUser("hi!");
        java.util.List<model.Reservation> reservationList5 = reservationService2.getAllReservations();
        java.lang.String str6 = reservationService2.getLastError();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList5);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "" + "'", str6.equals(""));
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test161");
        model.Student student4 = new model.Student("Researcher", "P001", "R001", "");
        double double5 = student4.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double5 + "' != '" + 10.0d + "'", double5 == 10.0d);
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test162");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        reservation10.forfeitDeposit();
        java.lang.String str12 = reservation10.getReservationId();
        boolean boolean13 = reservation10.isDepositForfeited();
        model.User user14 = reservation10.getUser();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(user14);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test163");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        java.time.LocalDateTime localDateTime11 = reservation10.getEndTime();
        java.lang.String str12 = reservation10.getReservationId();
        util.SystemClock systemClock13 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime14 = systemClock13.now();
        model.Student student19 = new model.Student("Research Grant", "hi!", "", "Guest");
        model.Equipment equipment20 = null;
        model.Guest guest26 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment27 = null;
        util.SystemClock systemClock28 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime29 = systemClock28.now();
        util.SystemClock systemClock30 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime31 = systemClock30.now();
        model.Reservation reservation33 = new model.Reservation("P001", (model.User) guest26, equipment27, localDateTime29, localDateTime31, 10.0d);
        model.Guest guest39 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment40 = null;
        java.time.LocalDateTime localDateTime41 = null;
        java.time.LocalDateTime localDateTime42 = null;
        model.Reservation reservation44 = new model.Reservation("", (model.User) guest39, equipment40, localDateTime41, localDateTime42, 1.0d);
        reservation44.forfeitDeposit();
        java.lang.String str46 = reservation44.getReservationId();
        model.Guest guest52 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment53 = null;
        util.SystemClock systemClock54 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime55 = systemClock54.now();
        util.SystemClock systemClock56 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime57 = systemClock56.now();
        model.Reservation reservation59 = new model.Reservation("P001", (model.User) guest52, equipment53, localDateTime55, localDateTime57, 10.0d);
        util.SystemClock systemClock60 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime61 = systemClock60.now();
        command.ModifyReservationCommand modifyReservationCommand63 = new command.ModifyReservationCommand(reservation44, localDateTime55, localDateTime61, "");
        strategy.PaymentStrategy paymentStrategy66 = null;
        command.MakeReservationCommand makeReservationCommand67 = new command.MakeReservationCommand((model.User) student19, equipment20, localDateTime29, localDateTime61, "P001", "Student", paymentStrategy66);
        command.ModifyReservationCommand modifyReservationCommand69 = new command.ModifyReservationCommand(reservation10, localDateTime14, localDateTime29, "Guest");
        // The following exception was thrown during execution in test generation
        try {
            modifyReservationCommand69.execute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock28);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime29);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock30);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime31);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str46 + "' != '" + "" + "'", str46.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock54);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock56);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime57);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock60);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime61);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test164");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        java.time.LocalDateTime localDateTime11 = reservation10.getEndTime();
        java.lang.String str12 = reservation10.getReservationId();
        reservation10.setStatus("Available");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test165");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        boolean boolean11 = reservation10.isDepositForfeited();
        java.time.LocalDateTime localDateTime12 = reservation10.getStartTime();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime12);
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test166");
        service.ReservationService reservationService2 = new service.ReservationService("Research Grant", "ACTIVE");
        java.util.List<model.Reservation> reservationList4 = reservationService2.getReservationsForEquipment("Guest");
        java.util.List<model.Reservation> reservationList6 = reservationService2.getReservationsForEquipment("Research Grant");
        model.Guest guest12 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment13 = null;
        util.SystemClock systemClock14 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime15 = systemClock14.now();
        util.SystemClock systemClock16 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime17 = systemClock16.now();
        model.Reservation reservation19 = new model.Reservation("P001", (model.User) guest12, equipment13, localDateTime15, localDateTime17, 10.0d);
        model.Guest guest25 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment26 = null;
        util.SystemClock systemClock27 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime28 = systemClock27.now();
        util.SystemClock systemClock29 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime30 = systemClock29.now();
        model.Reservation reservation32 = new model.Reservation("P001", (model.User) guest25, equipment26, localDateTime28, localDateTime30, 10.0d);
        command.ExtendReservationCommand extendReservationCommand34 = new command.ExtendReservationCommand(reservation19, localDateTime30, "Student");
        model.Guest guest40 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment41 = null;
        util.SystemClock systemClock42 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime43 = systemClock42.now();
        util.SystemClock systemClock44 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime45 = systemClock44.now();
        model.Reservation reservation47 = new model.Reservation("P001", (model.User) guest40, equipment41, localDateTime43, localDateTime45, 10.0d);
        model.Guest guest53 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment54 = null;
        util.SystemClock systemClock55 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime56 = systemClock55.now();
        util.SystemClock systemClock57 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime58 = systemClock57.now();
        model.Reservation reservation60 = new model.Reservation("P001", (model.User) guest53, equipment54, localDateTime56, localDateTime58, 10.0d);
        command.ExtendReservationCommand extendReservationCommand62 = new command.ExtendReservationCommand(reservation47, localDateTime58, "Student");
        model.Guest guest68 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment69 = null;
        util.SystemClock systemClock70 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime71 = systemClock70.now();
        util.SystemClock systemClock72 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime73 = systemClock72.now();
        model.Reservation reservation75 = new model.Reservation("P001", (model.User) guest68, equipment69, localDateTime71, localDateTime73, 10.0d);
        model.Guest guest81 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment82 = null;
        util.SystemClock systemClock83 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime84 = systemClock83.now();
        util.SystemClock systemClock85 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime86 = systemClock85.now();
        model.Reservation reservation88 = new model.Reservation("P001", (model.User) guest81, equipment82, localDateTime84, localDateTime86, 10.0d);
        command.ExtendReservationCommand extendReservationCommand90 = new command.ExtendReservationCommand(reservation75, localDateTime86, "Student");
        boolean boolean91 = reservationService2.modifyReservation(reservation19, localDateTime58, localDateTime86);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock27);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime28);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock29);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime30);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime43);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock44);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime45);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime56);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock57);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime58);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock70);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime71);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock72);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime73);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock83);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime84);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock85);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime86);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean91 + "' != '" + false + "'", boolean91 == false);
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test167");
        model.Faculty faculty5 = new model.Faculty("Research Grant", "LabManager", "Researcher", "LabManager", true);
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test168");
        model.Equipment equipment3 = new model.Equipment("Student", "", "Faculty");
        java.lang.String str4 = equipment3.getName();
        java.lang.String str5 = equipment3.getCurrentStateName();
        boolean boolean6 = equipment3.canReserve();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "" + "'", str4.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "Available" + "'", str5.equals("Available"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test169");
        strategy.FacultyPricingStrategy facultyPricingStrategy0 = new strategy.FacultyPricingStrategy();
        double double1 = facultyPricingStrategy0.getRate();
        double double2 = facultyPricingStrategy0.getRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double1 + "' != '" + 15.0d + "'", double1 == 15.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 15.0d + "'", double2 == 15.0d);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test170");
        model.Payment payment8 = new model.Payment("R001", "R001", "hi!", (double) '4', "", "P001", "P001", "");
        java.lang.String str9 = payment8.getStatus();
        java.lang.String str10 = payment8.getUserId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "P001" + "'", str9.equals("P001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "hi!" + "'", str10.equals("hi!"));
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test171");
        data.MaintainPayment maintainPayment0 = new data.MaintainPayment();
        model.Payment[] paymentArray1 = new model.Payment[] {};
        java.util.ArrayList<model.Payment> paymentList2 = new java.util.ArrayList<model.Payment>();
        boolean boolean3 = java.util.Collections.addAll((java.util.Collection<model.Payment>) paymentList2, paymentArray1);
        maintainPayment0.payments = paymentList2;
        maintainPayment0.load("ACTIVE");
        java.lang.String str7 = maintainPayment0.nextId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(paymentArray1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean3 + "' != '" + false + "'", boolean3 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "P001" + "'", str7.equals("P001"));
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test172");
        data.MaintainEquipment maintainEquipment0 = new data.MaintainEquipment();
        java.util.List<model.Equipment> equipmentList1 = maintainEquipment0.getAvailableEquipment();
        model.Equipment equipment3 = maintainEquipment0.findById("P001");
        data.MaintainEquipment maintainEquipment4 = new data.MaintainEquipment();
        maintainEquipment4.load("Research Grant");
        java.util.List<model.Equipment> equipmentList7 = maintainEquipment4.getAvailableEquipment();
        maintainEquipment0.equipmentList = equipmentList7;
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipmentList1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(equipment3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipmentList7);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test173");
        service.ReservationService reservationService2 = new service.ReservationService("hi!", "Guest");
        java.util.List<model.Reservation> reservationList4 = reservationService2.getReservationsForUser("hi!");
        factory.UserFactory userFactory5 = new factory.UserFactory();
        model.LabManager labManager10 = userFactory5.createLabManager("", "Researcher", "P001", "R001");
        model.Equipment equipment14 = new model.Equipment("Student", "", "Faculty");
        java.lang.String str15 = equipment14.getName();
        util.SystemClock systemClock16 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime17 = systemClock16.now();
        java.time.LocalDateTime localDateTime18 = systemClock16.now();
        util.SystemClock systemClock19 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime20 = systemClock19.now();
        java.time.LocalDateTime localDateTime21 = systemClock19.now();
        java.time.LocalDateTime localDateTime22 = systemClock19.now();
        service.BillingService billingService23 = new service.BillingService();
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy24 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str25 = researchGrantPaymentStrategy24.getMethodName();
        boolean boolean27 = researchGrantPaymentStrategy24.processPayment(0.0d);
        billingService23.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy24);
        java.lang.String str29 = researchGrantPaymentStrategy24.getMethodName();
        java.lang.String str30 = researchGrantPaymentStrategy24.getMethodName();
        boolean boolean31 = reservationService2.makeReservation((model.User) labManager10, equipment14, localDateTime18, localDateTime22, (strategy.PaymentStrategy) researchGrantPaymentStrategy24);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(labManager10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str15 + "' != '" + "" + "'", str15.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime18);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock19);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str25 + "' != '" + "Research Grant" + "'", str25.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + true + "'", boolean27 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str29 + "' != '" + "Research Grant" + "'", str29.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str30 + "' != '" + "Research Grant" + "'", str30.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test174");
        command.CommandManager commandManager0 = new command.CommandManager();
        commandManager0.printHistory();
        java.util.List<command.ReservationCommand> reservationCommandList2 = commandManager0.getHistory();
        model.Reservation reservation3 = null;
        java.time.LocalDateTime localDateTime4 = null;
        command.ExtendReservationCommand extendReservationCommand6 = new command.ExtendReservationCommand(reservation3, localDateTime4, "Research Grant");
        java.lang.String str7 = extendReservationCommand6.getErrorMessage();
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean8 = commandManager0.execute((command.ReservationCommand) extendReservationCommand6);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationCommandList2);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test175");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        reservation10.forfeitDeposit();
        java.lang.String str12 = reservation10.getReservationId();
        boolean boolean13 = reservation10.isDepositForfeited();
        java.time.LocalDateTime localDateTime14 = reservation10.getStartTime();
        boolean boolean15 = reservation10.isDepositForfeited();
        java.time.LocalDateTime localDateTime16 = reservation10.getStartTime();
        double double17 = reservation10.getDepositAmount();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double17 + "' != '" + 1.0d + "'", double17 == 1.0d);
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test176");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        util.SystemClock systemClock7 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime8 = systemClock7.now();
        util.SystemClock systemClock9 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime10 = systemClock9.now();
        model.Reservation reservation12 = new model.Reservation("P001", (model.User) guest5, equipment6, localDateTime8, localDateTime10, 10.0d);
        model.Guest guest18 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment19 = null;
        java.time.LocalDateTime localDateTime20 = null;
        java.time.LocalDateTime localDateTime21 = null;
        model.Reservation reservation23 = new model.Reservation("", (model.User) guest18, equipment19, localDateTime20, localDateTime21, 1.0d);
        reservation23.markArrived();
        reservation23.forfeitDeposit();
        model.Guest guest31 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment32 = null;
        java.time.LocalDateTime localDateTime33 = null;
        java.time.LocalDateTime localDateTime34 = null;
        model.Reservation reservation36 = new model.Reservation("", (model.User) guest31, equipment32, localDateTime33, localDateTime34, 1.0d);
        java.time.LocalDateTime localDateTime37 = reservation36.getEndTime();
        java.lang.String str38 = reservation36.getReservationId();
        util.SystemClock systemClock39 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime40 = systemClock39.now();
        model.Student student45 = new model.Student("Research Grant", "hi!", "", "Guest");
        model.Equipment equipment46 = null;
        model.Guest guest52 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment53 = null;
        util.SystemClock systemClock54 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime55 = systemClock54.now();
        util.SystemClock systemClock56 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime57 = systemClock56.now();
        model.Reservation reservation59 = new model.Reservation("P001", (model.User) guest52, equipment53, localDateTime55, localDateTime57, 10.0d);
        model.Guest guest65 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment66 = null;
        java.time.LocalDateTime localDateTime67 = null;
        java.time.LocalDateTime localDateTime68 = null;
        model.Reservation reservation70 = new model.Reservation("", (model.User) guest65, equipment66, localDateTime67, localDateTime68, 1.0d);
        reservation70.forfeitDeposit();
        java.lang.String str72 = reservation70.getReservationId();
        model.Guest guest78 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment79 = null;
        util.SystemClock systemClock80 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime81 = systemClock80.now();
        util.SystemClock systemClock82 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime83 = systemClock82.now();
        model.Reservation reservation85 = new model.Reservation("P001", (model.User) guest78, equipment79, localDateTime81, localDateTime83, 10.0d);
        util.SystemClock systemClock86 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime87 = systemClock86.now();
        command.ModifyReservationCommand modifyReservationCommand89 = new command.ModifyReservationCommand(reservation70, localDateTime81, localDateTime87, "");
        strategy.PaymentStrategy paymentStrategy92 = null;
        command.MakeReservationCommand makeReservationCommand93 = new command.MakeReservationCommand((model.User) student45, equipment46, localDateTime55, localDateTime87, "P001", "Student", paymentStrategy92);
        command.ModifyReservationCommand modifyReservationCommand95 = new command.ModifyReservationCommand(reservation36, localDateTime40, localDateTime55, "Guest");
        reservation23.setEndTime(localDateTime40);
        reservation12.setEndTime(localDateTime40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock9);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime37);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str38 + "' != '" + "" + "'", str38.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock39);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock54);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock56);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime57);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str72 + "' != '" + "" + "'", str72.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock80);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime81);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock82);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime83);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock86);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime87);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test177");
        service.BillingService billingService0 = new service.BillingService();
        strategy.FacultyPricingStrategy facultyPricingStrategy1 = new strategy.FacultyPricingStrategy();
        billingService0.setPricingStrategy((strategy.PricingStrategy) facultyPricingStrategy1);
        strategy.StudentPricingStrategy studentPricingStrategy3 = new strategy.StudentPricingStrategy();
        double double4 = studentPricingStrategy3.getRate();
        billingService0.setPricingStrategy((strategy.PricingStrategy) studentPricingStrategy3);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str6 = billingService0.getPaymentMethodName();
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: Payment strategy not set");
        } catch (java.lang.IllegalStateException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 10.0d + "'", double4 == 10.0d);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test178");
        service.BillingService billingService0 = new service.BillingService();
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy1 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str2 = researchGrantPaymentStrategy1.getMethodName();
        boolean boolean4 = researchGrantPaymentStrategy1.processPayment(0.0d);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy1);
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy6 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str7 = researchGrantPaymentStrategy6.getMethodName();
        boolean boolean9 = researchGrantPaymentStrategy6.processPayment(0.0d);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy6);
        // The following exception was thrown during execution in test generation
        try {
            double double11 = billingService0.getDeposit();
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: Pricing strategy not set");
        } catch (java.lang.IllegalStateException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str2 + "' != '" + "Research Grant" + "'", str2.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Research Grant" + "'", str7.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test179");
        model.LabManager labManager4 = new model.LabManager("hi!", "hi!", "ACTIVE", "ACTIVE");
        model.Equipment equipment8 = labManager4.addEquipment("R001", "Guest", "P001");
        java.lang.String str9 = equipment8.getName();
        equipment8.enable();
        boolean boolean11 = equipment8.canReserve();
        model.LabManager labManager16 = new model.LabManager("hi!", "hi!", "ACTIVE", "ACTIVE");
        model.Equipment equipment20 = labManager16.addEquipment("R001", "Guest", "P001");
        java.lang.String str21 = equipment20.getName();
        equipment20.enable();
        java.lang.String str23 = equipment20.getCurrentStateName();
        model.EquipmentState equipmentState24 = equipment20.getState();
        equipment8.setState(equipmentState24);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipment8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Guest" + "'", str9.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipment20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str21 + "' != '" + "Guest" + "'", str21.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str23 + "' != '" + "Available" + "'", str23.equals("Available"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipmentState24);
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test180");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        java.lang.String str11 = guest5.getUserType();
        java.lang.String str12 = guest5.getUserType();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "Guest" + "'", str11.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "Guest" + "'", str12.equals("Guest"));
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test181");
        model.Payment payment8 = new model.Payment("R001", "R001", "hi!", (double) '4', "", "P001", "P001", "");
        java.lang.String str9 = payment8.getPaymentId();
        java.lang.String str10 = payment8.getPaymentId();
        java.lang.String str11 = payment8.getStatus();
        java.lang.String str12 = payment8.getStatus();
        java.lang.String str13 = payment8.getStatus();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "R001" + "'", str9.equals("R001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "R001" + "'", str10.equals("R001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "P001" + "'", str11.equals("P001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "P001" + "'", str12.equals("P001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "P001" + "'", str13.equals("P001"));
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test182");
        model.Guest guest4 = new model.Guest("ACTIVE", "hi!", "", "Modify reservation  to 2026-03-25 18:41 \u2192 2026-03-25 18:41");
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test183");
        model.Guest guest4 = new model.Guest("", "ACTIVE", "AVAILABLE", "ACTIVE");
        double double5 = guest4.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double5 + "' != '" + 30.0d + "'", double5 == 30.0d);
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test184");
        data.MaintainEquipment maintainEquipment0 = new data.MaintainEquipment();
        java.util.List<model.Equipment> equipmentList1 = maintainEquipment0.getAvailableEquipment();
        maintainEquipment0.load("Researcher");
        model.LabManager labManager8 = new model.LabManager("hi!", "hi!", "ACTIVE", "ACTIVE");
        model.Equipment equipment12 = labManager8.addEquipment("R001", "Guest", "P001");
        java.lang.String str13 = equipment12.getName();
        equipment12.enable();
        java.lang.String str15 = equipment12.getCurrentStateName();
        model.Equipment[] equipmentArray16 = new model.Equipment[] { equipment12 };
        java.util.ArrayList<model.Equipment> equipmentList17 = new java.util.ArrayList<model.Equipment>();
        boolean boolean18 = java.util.Collections.addAll((java.util.Collection<model.Equipment>) equipmentList17, equipmentArray16);
        maintainEquipment0.equipmentList = equipmentList17;
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipmentList1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipment12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "Guest" + "'", str13.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str15 + "' != '" + "Available" + "'", str15.equals("Available"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipmentArray16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean18 + "' != '" + true + "'", boolean18 == true);
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test185");
        model.Researcher researcher6 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str7 = researcher6.getPassword();
        boolean boolean8 = researcher6.isApproved();
        model.Equipment equipment9 = null;
        util.SystemClock systemClock10 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime11 = systemClock10.now();
        java.time.LocalDateTime localDateTime12 = systemClock10.now();
        model.Guest guest18 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment19 = null;
        util.SystemClock systemClock20 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime21 = systemClock20.now();
        util.SystemClock systemClock22 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime23 = systemClock22.now();
        model.Reservation reservation25 = new model.Reservation("P001", (model.User) guest18, equipment19, localDateTime21, localDateTime23, 10.0d);
        model.Reservation reservation27 = new model.Reservation("", (model.User) researcher6, equipment9, localDateTime12, localDateTime23, (double) (byte) -1);
        java.time.LocalDateTime localDateTime28 = reservation27.getEndTime();
        reservation27.markArrived();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Research Grant" + "'", str7.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime28);
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test186");
        model.Payment payment8 = new model.Payment("R001", "R001", "hi!", (double) '4', "", "P001", "P001", "");
        java.lang.String str9 = payment8.getPaymentId();
        java.lang.String str10 = payment8.getPaymentId();
        java.lang.String str11 = payment8.getPaymentMethod();
        java.lang.String str12 = payment8.getReservationId();
        double double13 = payment8.getAmount();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "R001" + "'", str9.equals("R001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "R001" + "'", str10.equals("R001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "" + "'", str11.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "R001" + "'", str12.equals("R001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double13 + "' != '" + 52.0d + "'", double13 == 52.0d);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test187");
        model.HeadLabCoordinator headLabCoordinator0 = model.HeadLabCoordinator.getInstance();
        model.LabManager labManager5 = headLabCoordinator0.createLabManagerAccount("P001", "ACTIVE", "Modify reservation  to 2026-03-25 18:41 \u2192 2026-03-25 18:41", "Faculty");
        model.Equipment equipment9 = labManager5.addEquipment("Maintenance", "Debit", "LabManager");
        model.Equipment equipment13 = new model.Equipment("R001", "", "Researcher");
        labManager5.markEquipmentUnderMaintenance(equipment13);
        model.HeadLabCoordinator headLabCoordinator15 = model.HeadLabCoordinator.getInstance();
        model.LabManager labManager20 = headLabCoordinator15.createLabManagerAccount("P001", "ACTIVE", "Modify reservation  to 2026-03-25 18:41 \u2192 2026-03-25 18:41", "Faculty");
        model.Equipment equipment24 = labManager20.addEquipment("Maintenance", "Debit", "LabManager");
        model.Equipment equipment28 = new model.Equipment("R001", "", "Researcher");
        labManager20.markEquipmentUnderMaintenance(equipment28);
        labManager5.markEquipmentUnderMaintenance(equipment28);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(headLabCoordinator0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(labManager5);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipment9);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(headLabCoordinator15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(labManager20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipment24);
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test188");
        service.BillingService billingService0 = new service.BillingService();
        strategy.FacultyPricingStrategy facultyPricingStrategy1 = new strategy.FacultyPricingStrategy();
        billingService0.setPricingStrategy((strategy.PricingStrategy) facultyPricingStrategy1);
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str3 = billingService0.getPaymentMethodName();
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: Payment strategy not set");
        } catch (java.lang.IllegalStateException e) {
        // Expected exception.
        }
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test189");
        factory.UserFactory userFactory0 = new factory.UserFactory();
        model.LabManager labManager5 = userFactory0.createLabManager("Guest", "Faculty", "Faculty", "Faculty");
        model.LabManager labManager10 = userFactory0.createLabManager("AVAILABLE", "LabManager", "Modify reservation  to 2026-03-25 18:41 \u2192 2026-03-25 18:41", "LabManager");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(labManager5);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(labManager10);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test190");
        model.Faculty faculty5 = new model.Faculty("Research Grant", "Available", "LabManager", "Faculty", true);
        boolean boolean6 = faculty5.isApproved();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + true + "'", boolean6 == true);
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test191");
        model.Researcher researcher6 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str7 = researcher6.getPassword();
        boolean boolean8 = researcher6.isApproved();
        model.Equipment equipment9 = null;
        util.SystemClock systemClock10 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime11 = systemClock10.now();
        java.time.LocalDateTime localDateTime12 = systemClock10.now();
        model.Guest guest18 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment19 = null;
        util.SystemClock systemClock20 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime21 = systemClock20.now();
        util.SystemClock systemClock22 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime23 = systemClock22.now();
        model.Reservation reservation25 = new model.Reservation("P001", (model.User) guest18, equipment19, localDateTime21, localDateTime23, 10.0d);
        model.Reservation reservation27 = new model.Reservation("", (model.User) researcher6, equipment9, localDateTime12, localDateTime23, (double) (byte) -1);
        model.User user28 = reservation27.getUser();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Research Grant" + "'", str7.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(user28);
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test192");
        service.ReservationService reservationService2 = new service.ReservationService("Research Grant", "ACTIVE");
        java.util.List<model.Reservation> reservationList4 = reservationService2.getReservationsForEquipment("Guest");
        model.Guest guest10 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment11 = null;
        java.time.LocalDateTime localDateTime12 = null;
        java.time.LocalDateTime localDateTime13 = null;
        model.Reservation reservation15 = new model.Reservation("", (model.User) guest10, equipment11, localDateTime12, localDateTime13, 1.0d);
        reservation15.markArrived();
        reservation15.forfeitDeposit();
        model.Guest guest23 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment24 = null;
        java.time.LocalDateTime localDateTime25 = null;
        java.time.LocalDateTime localDateTime26 = null;
        model.Reservation reservation28 = new model.Reservation("", (model.User) guest23, equipment24, localDateTime25, localDateTime26, 1.0d);
        java.time.LocalDateTime localDateTime29 = reservation28.getEndTime();
        java.lang.String str30 = reservation28.getReservationId();
        util.SystemClock systemClock31 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime32 = systemClock31.now();
        model.Student student37 = new model.Student("Research Grant", "hi!", "", "Guest");
        model.Equipment equipment38 = null;
        model.Guest guest44 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment45 = null;
        util.SystemClock systemClock46 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime47 = systemClock46.now();
        util.SystemClock systemClock48 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime49 = systemClock48.now();
        model.Reservation reservation51 = new model.Reservation("P001", (model.User) guest44, equipment45, localDateTime47, localDateTime49, 10.0d);
        model.Guest guest57 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment58 = null;
        java.time.LocalDateTime localDateTime59 = null;
        java.time.LocalDateTime localDateTime60 = null;
        model.Reservation reservation62 = new model.Reservation("", (model.User) guest57, equipment58, localDateTime59, localDateTime60, 1.0d);
        reservation62.forfeitDeposit();
        java.lang.String str64 = reservation62.getReservationId();
        model.Guest guest70 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment71 = null;
        util.SystemClock systemClock72 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime73 = systemClock72.now();
        util.SystemClock systemClock74 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime75 = systemClock74.now();
        model.Reservation reservation77 = new model.Reservation("P001", (model.User) guest70, equipment71, localDateTime73, localDateTime75, 10.0d);
        util.SystemClock systemClock78 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime79 = systemClock78.now();
        command.ModifyReservationCommand modifyReservationCommand81 = new command.ModifyReservationCommand(reservation62, localDateTime73, localDateTime79, "");
        strategy.PaymentStrategy paymentStrategy84 = null;
        command.MakeReservationCommand makeReservationCommand85 = new command.MakeReservationCommand((model.User) student37, equipment38, localDateTime47, localDateTime79, "P001", "Student", paymentStrategy84);
        command.ModifyReservationCommand modifyReservationCommand87 = new command.ModifyReservationCommand(reservation28, localDateTime32, localDateTime47, "Guest");
        reservation15.setEndTime(localDateTime32);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean89 = reservationService2.cancelReservation(reservation15);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime29);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str30 + "' != '" + "" + "'", str30.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock31);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime32);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock46);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime47);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock48);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime49);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str64 + "' != '" + "" + "'", str64.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock72);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime73);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock74);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime75);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock78);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime79);
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test193");
        model.Student student4 = new model.Student("Research Grant", "hi!", "", "Guest");
        model.Equipment equipment5 = null;
        model.Guest guest11 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment12 = null;
        util.SystemClock systemClock13 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime14 = systemClock13.now();
        util.SystemClock systemClock15 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime16 = systemClock15.now();
        model.Reservation reservation18 = new model.Reservation("P001", (model.User) guest11, equipment12, localDateTime14, localDateTime16, 10.0d);
        model.Guest guest24 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment25 = null;
        java.time.LocalDateTime localDateTime26 = null;
        java.time.LocalDateTime localDateTime27 = null;
        model.Reservation reservation29 = new model.Reservation("", (model.User) guest24, equipment25, localDateTime26, localDateTime27, 1.0d);
        reservation29.forfeitDeposit();
        java.lang.String str31 = reservation29.getReservationId();
        model.Guest guest37 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment38 = null;
        util.SystemClock systemClock39 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime40 = systemClock39.now();
        util.SystemClock systemClock41 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime42 = systemClock41.now();
        model.Reservation reservation44 = new model.Reservation("P001", (model.User) guest37, equipment38, localDateTime40, localDateTime42, 10.0d);
        util.SystemClock systemClock45 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime46 = systemClock45.now();
        command.ModifyReservationCommand modifyReservationCommand48 = new command.ModifyReservationCommand(reservation29, localDateTime40, localDateTime46, "");
        strategy.PaymentStrategy paymentStrategy51 = null;
        command.MakeReservationCommand makeReservationCommand52 = new command.MakeReservationCommand((model.User) student4, equipment5, localDateTime14, localDateTime46, "P001", "Student", paymentStrategy51);
        java.lang.String str53 = makeReservationCommand52.getErrorMessage();
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str54 = makeReservationCommand52.getDescription();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str31 + "' != '" + "" + "'", str31.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock39);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock45);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime46);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str53 + "' != '" + "" + "'", str53.equals(""));
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test194");
        model.Payment payment8 = new model.Payment("", "Available", "Researcher", (double) (short) 0, "LabManager", "Faculty", "R001", "ACTIVE");
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test195");
        data.MaintainUser maintainUser0 = new data.MaintainUser();
        model.User user2 = maintainUser0.findByEmail("P001");
        model.Guest guest7 = new model.Guest("", "Research Grant", "", "hi!");
        model.Guest guest13 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment14 = null;
        util.SystemClock systemClock15 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime16 = systemClock15.now();
        util.SystemClock systemClock17 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime18 = systemClock17.now();
        model.Reservation reservation20 = new model.Reservation("P001", (model.User) guest13, equipment14, localDateTime16, localDateTime18, 10.0d);
        model.Guest guest25 = new model.Guest("hi!", "hi!", "", "hi!");
        model.Guest guest31 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment32 = null;
        util.SystemClock systemClock33 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime34 = systemClock33.now();
        util.SystemClock systemClock35 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime36 = systemClock35.now();
        model.Reservation reservation38 = new model.Reservation("P001", (model.User) guest31, equipment32, localDateTime34, localDateTime36, 10.0d);
        model.User[] userArray39 = new model.User[] { guest7, guest13, guest25, guest31 };
        java.util.ArrayList<model.User> userList40 = new java.util.ArrayList<model.User>();
        boolean boolean41 = java.util.Collections.addAll((java.util.Collection<model.User>) userList40, userArray39);
        maintainUser0.users = userList40;
        model.User user44 = maintainUser0.findById("hi!");
        maintainUser0.load("Debit");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(user2);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime18);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock33);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime34);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime36);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(userArray39);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + true + "'", boolean41 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(user44);
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test196");
        service.ReservationService reservationService2 = new service.ReservationService("Guest", "P001");
        reservationService2.printCommandHistory();
        reservationService2.printCommandHistory();
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test197");
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy0 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str1 = researchGrantPaymentStrategy0.getMethodName();
        java.lang.String str2 = researchGrantPaymentStrategy0.getMethodName();
        boolean boolean4 = researchGrantPaymentStrategy0.processPayment((double) 0.0f);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str1 + "' != '" + "Research Grant" + "'", str1.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str2 + "' != '" + "Research Grant" + "'", str2.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test198");
        service.BillingService billingService0 = new service.BillingService();
        strategy.FacultyPricingStrategy facultyPricingStrategy1 = new strategy.FacultyPricingStrategy();
        billingService0.setPricingStrategy((strategy.PricingStrategy) facultyPricingStrategy1);
        double double5 = billingService0.calculateFeeWithDeposit((double) '#', true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double5 + "' != '" + 525.0d + "'", double5 == 525.0d);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test199");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        java.time.LocalDateTime localDateTime11 = reservation10.getEndTime();
        java.lang.String str12 = reservation10.getReservationId();
        util.SystemClock systemClock13 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime14 = systemClock13.now();
        model.Student student19 = new model.Student("Research Grant", "hi!", "", "Guest");
        model.Equipment equipment20 = null;
        model.Guest guest26 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment27 = null;
        util.SystemClock systemClock28 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime29 = systemClock28.now();
        util.SystemClock systemClock30 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime31 = systemClock30.now();
        model.Reservation reservation33 = new model.Reservation("P001", (model.User) guest26, equipment27, localDateTime29, localDateTime31, 10.0d);
        model.Guest guest39 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment40 = null;
        java.time.LocalDateTime localDateTime41 = null;
        java.time.LocalDateTime localDateTime42 = null;
        model.Reservation reservation44 = new model.Reservation("", (model.User) guest39, equipment40, localDateTime41, localDateTime42, 1.0d);
        reservation44.forfeitDeposit();
        java.lang.String str46 = reservation44.getReservationId();
        model.Guest guest52 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment53 = null;
        util.SystemClock systemClock54 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime55 = systemClock54.now();
        util.SystemClock systemClock56 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime57 = systemClock56.now();
        model.Reservation reservation59 = new model.Reservation("P001", (model.User) guest52, equipment53, localDateTime55, localDateTime57, 10.0d);
        util.SystemClock systemClock60 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime61 = systemClock60.now();
        command.ModifyReservationCommand modifyReservationCommand63 = new command.ModifyReservationCommand(reservation44, localDateTime55, localDateTime61, "");
        strategy.PaymentStrategy paymentStrategy66 = null;
        command.MakeReservationCommand makeReservationCommand67 = new command.MakeReservationCommand((model.User) student19, equipment20, localDateTime29, localDateTime61, "P001", "Student", paymentStrategy66);
        command.ModifyReservationCommand modifyReservationCommand69 = new command.ModifyReservationCommand(reservation10, localDateTime14, localDateTime29, "Guest");
        // The following exception was thrown during execution in test generation
        try {
            java.lang.String str70 = reservation10.getEquipmentId();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock28);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime29);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock30);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime31);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str46 + "' != '" + "" + "'", str46.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock54);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock56);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime57);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock60);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime61);
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test200");
        service.ReservationService reservationService2 = new service.ReservationService("Research Grant", "ACTIVE");
        java.util.List<model.Reservation> reservationList4 = reservationService2.getReservationsForEquipment("Guest");
        java.util.List<model.Reservation> reservationList6 = reservationService2.getReservationsForEquipment("Research Grant");
        java.util.List<model.Reservation> reservationList8 = reservationService2.getReservationsForUser("AVAILABLE");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList8);
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test201");
        data.MaintainEquipment maintainEquipment0 = new data.MaintainEquipment();
        model.Equipment equipment2 = maintainEquipment0.findById("ACTIVE");
        maintainEquipment0.load("Cancel reservation ");
        model.Equipment equipment6 = maintainEquipment0.findById("Research Grant");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(equipment2);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(equipment6);
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test202");
        data.MaintainReservation maintainReservation0 = new data.MaintainReservation();
        java.lang.String str1 = maintainReservation0.nextId();
        java.util.List<model.Reservation> reservationList2 = maintainReservation0.reservations;
        maintainReservation0.load("Researcher");
        java.lang.String str5 = maintainReservation0.nextId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str1 + "' != '" + "R001" + "'", str1.equals("R001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList2);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "R001" + "'", str5.equals("R001"));
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test203");
        util.SystemClock systemClock0 = util.SystemClock.getInstance();
        util.Observer observer1 = null;
        systemClock0.attach(observer1);
        util.Observer observer3 = null;
        systemClock0.detach(observer3);
        model.Equipment equipment8 = new model.Equipment("Student", "", "Faculty");
        model.Equipment equipment12 = new model.Equipment("R001", "", "Researcher");
        model.EquipmentState equipmentState13 = equipment12.getState();
        equipment8.setState(equipmentState13);
        model.LabManager labManager19 = new model.LabManager("hi!", "hi!", "ACTIVE", "ACTIVE");
        model.Equipment equipment23 = labManager19.addEquipment("R001", "Guest", "P001");
        java.lang.String str24 = equipment23.getName();
        equipment23.enable();
        model.Equipment equipment29 = new model.Equipment("R001", "", "Researcher");
        model.EquipmentState equipmentState30 = equipment29.getState();
        equipment23.setState(equipmentState30);
        equipment8.setState(equipmentState30);
        // The following exception was thrown during execution in test generation
        try {
            systemClock0.notifyObservers((java.lang.Object) equipment8);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipmentState13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipment23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str24 + "' != '" + "Guest" + "'", str24.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipmentState30);
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test204");
        factory.UserFactory userFactory0 = new factory.UserFactory();
        model.LabManager labManager5 = userFactory0.createLabManager("hi!", "Institutional Account", "P001", "Available");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(labManager5);
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test205");
        strategy.InstitutionalAccountPaymentStrategy institutionalAccountPaymentStrategy0 = new strategy.InstitutionalAccountPaymentStrategy();
        java.lang.String str1 = institutionalAccountPaymentStrategy0.getMethodName();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str1 + "' != '" + "Institutional Account" + "'", str1.equals("Institutional Account"));
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test206");
        data.MaintainEquipment maintainEquipment0 = new data.MaintainEquipment();
        maintainEquipment0.load("Research Grant");
        java.util.List<model.Equipment> equipmentList3 = maintainEquipment0.getAvailableEquipment();
        maintainEquipment0.load("Institutional Account");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipmentList3);
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test207");
        model.Researcher researcher7 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str8 = researcher7.getPassword();
        boolean boolean9 = researcher7.isApproved();
        model.Equipment equipment10 = null;
        util.SystemClock systemClock11 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime12 = systemClock11.now();
        java.time.LocalDateTime localDateTime13 = systemClock11.now();
        model.Guest guest19 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment20 = null;
        util.SystemClock systemClock21 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime22 = systemClock21.now();
        util.SystemClock systemClock23 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime24 = systemClock23.now();
        model.Reservation reservation26 = new model.Reservation("P001", (model.User) guest19, equipment20, localDateTime22, localDateTime24, 10.0d);
        model.Reservation reservation28 = new model.Reservation("", (model.User) researcher7, equipment10, localDateTime13, localDateTime24, (double) (byte) -1);
        model.Guest guest34 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment35 = null;
        java.time.LocalDateTime localDateTime36 = null;
        java.time.LocalDateTime localDateTime37 = null;
        model.Reservation reservation39 = new model.Reservation("", (model.User) guest34, equipment35, localDateTime36, localDateTime37, 1.0d);
        reservation39.forfeitDeposit();
        java.lang.String str41 = reservation39.getReservationId();
        model.Guest guest47 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment48 = null;
        util.SystemClock systemClock49 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime50 = systemClock49.now();
        util.SystemClock systemClock51 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime52 = systemClock51.now();
        model.Reservation reservation54 = new model.Reservation("P001", (model.User) guest47, equipment48, localDateTime50, localDateTime52, 10.0d);
        util.SystemClock systemClock55 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime56 = systemClock55.now();
        command.ModifyReservationCommand modifyReservationCommand58 = new command.ModifyReservationCommand(reservation39, localDateTime50, localDateTime56, "");
        model.UsageRecord usageRecord60 = new model.UsageRecord("P001", localDateTime13, localDateTime50, "Student");
        java.time.LocalDateTime localDateTime61 = usageRecord60.getEndTime();
        java.time.LocalDateTime localDateTime62 = usageRecord60.getEndTime();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Research Grant" + "'", str8.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime24);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str41 + "' != '" + "" + "'", str41.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock49);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime50);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock51);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime52);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime56);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime61);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime62);
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test208");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        java.time.LocalDateTime localDateTime11 = reservation10.getStartTime();
        reservation10.markArrived();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime11);
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test209");
        command.CommandManager commandManager0 = new command.CommandManager();
        model.Reservation reservation1 = null;
        command.CancelReservationCommand cancelReservationCommand3 = new command.CancelReservationCommand(reservation1, "Student");
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean4 = commandManager0.execute((command.ReservationCommand) cancelReservationCommand3);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test210");
        model.LabManager labManager4 = new model.LabManager("hi!", "hi!", "ACTIVE", "ACTIVE");
        model.Equipment equipment8 = labManager4.addEquipment("R001", "Guest", "P001");
        java.lang.String str9 = equipment8.getName();
        equipment8.enable();
        java.lang.String str11 = equipment8.getCurrentStateName();
        java.lang.String str12 = equipment8.getName();
        boolean boolean13 = equipment8.isAvailable();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipment8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Guest" + "'", str9.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "Available" + "'", str11.equals("Available"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "Guest" + "'", str12.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean13 + "' != '" + true + "'", boolean13 == true);
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test211");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        boolean boolean11 = reservation10.isDepositForfeited();
        boolean boolean12 = reservation10.hasArrived();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + false + "'", boolean11 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test212");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        java.time.LocalDateTime localDateTime11 = reservation10.getEndTime();
        java.lang.String str12 = reservation10.getReservationId();
        util.SystemClock systemClock13 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime14 = systemClock13.now();
        model.Student student19 = new model.Student("Research Grant", "hi!", "", "Guest");
        model.Equipment equipment20 = null;
        model.Guest guest26 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment27 = null;
        util.SystemClock systemClock28 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime29 = systemClock28.now();
        util.SystemClock systemClock30 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime31 = systemClock30.now();
        model.Reservation reservation33 = new model.Reservation("P001", (model.User) guest26, equipment27, localDateTime29, localDateTime31, 10.0d);
        model.Guest guest39 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment40 = null;
        java.time.LocalDateTime localDateTime41 = null;
        java.time.LocalDateTime localDateTime42 = null;
        model.Reservation reservation44 = new model.Reservation("", (model.User) guest39, equipment40, localDateTime41, localDateTime42, 1.0d);
        reservation44.forfeitDeposit();
        java.lang.String str46 = reservation44.getReservationId();
        model.Guest guest52 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment53 = null;
        util.SystemClock systemClock54 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime55 = systemClock54.now();
        util.SystemClock systemClock56 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime57 = systemClock56.now();
        model.Reservation reservation59 = new model.Reservation("P001", (model.User) guest52, equipment53, localDateTime55, localDateTime57, 10.0d);
        util.SystemClock systemClock60 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime61 = systemClock60.now();
        command.ModifyReservationCommand modifyReservationCommand63 = new command.ModifyReservationCommand(reservation44, localDateTime55, localDateTime61, "");
        strategy.PaymentStrategy paymentStrategy66 = null;
        command.MakeReservationCommand makeReservationCommand67 = new command.MakeReservationCommand((model.User) student19, equipment20, localDateTime29, localDateTime61, "P001", "Student", paymentStrategy66);
        command.ModifyReservationCommand modifyReservationCommand69 = new command.ModifyReservationCommand(reservation10, localDateTime14, localDateTime29, "Guest");
        java.lang.String str70 = modifyReservationCommand69.getErrorMessage();
        // The following exception was thrown during execution in test generation
        try {
            modifyReservationCommand69.execute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock28);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime29);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock30);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime31);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str46 + "' != '" + "" + "'", str46.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock54);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock56);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime57);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock60);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime61);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str70 + "' != '" + "" + "'", str70.equals(""));
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test213");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        java.time.LocalDateTime localDateTime11 = reservation10.getEndTime();
        reservation10.markArrived();
        model.Equipment equipment13 = reservation10.getEquipment();
        reservation10.setStatus("P001");
        reservation10.markArrived();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(equipment13);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test214");
        model.Equipment equipment3 = new model.Equipment("ACTIVE", "", "");
        model.EquipmentState equipmentState4 = equipment3.getState();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipmentState4);
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test215");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        reservation10.markArrived();
        reservation10.forfeitDeposit();
        model.Guest guest18 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment19 = null;
        java.time.LocalDateTime localDateTime20 = null;
        java.time.LocalDateTime localDateTime21 = null;
        model.Reservation reservation23 = new model.Reservation("", (model.User) guest18, equipment19, localDateTime20, localDateTime21, 1.0d);
        java.time.LocalDateTime localDateTime24 = reservation23.getEndTime();
        java.lang.String str25 = reservation23.getReservationId();
        util.SystemClock systemClock26 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime27 = systemClock26.now();
        model.Student student32 = new model.Student("Research Grant", "hi!", "", "Guest");
        model.Equipment equipment33 = null;
        model.Guest guest39 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment40 = null;
        util.SystemClock systemClock41 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime42 = systemClock41.now();
        util.SystemClock systemClock43 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime44 = systemClock43.now();
        model.Reservation reservation46 = new model.Reservation("P001", (model.User) guest39, equipment40, localDateTime42, localDateTime44, 10.0d);
        model.Guest guest52 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment53 = null;
        java.time.LocalDateTime localDateTime54 = null;
        java.time.LocalDateTime localDateTime55 = null;
        model.Reservation reservation57 = new model.Reservation("", (model.User) guest52, equipment53, localDateTime54, localDateTime55, 1.0d);
        reservation57.forfeitDeposit();
        java.lang.String str59 = reservation57.getReservationId();
        model.Guest guest65 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment66 = null;
        util.SystemClock systemClock67 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime68 = systemClock67.now();
        util.SystemClock systemClock69 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime70 = systemClock69.now();
        model.Reservation reservation72 = new model.Reservation("P001", (model.User) guest65, equipment66, localDateTime68, localDateTime70, 10.0d);
        util.SystemClock systemClock73 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime74 = systemClock73.now();
        command.ModifyReservationCommand modifyReservationCommand76 = new command.ModifyReservationCommand(reservation57, localDateTime68, localDateTime74, "");
        strategy.PaymentStrategy paymentStrategy79 = null;
        command.MakeReservationCommand makeReservationCommand80 = new command.MakeReservationCommand((model.User) student32, equipment33, localDateTime42, localDateTime74, "P001", "Student", paymentStrategy79);
        command.ModifyReservationCommand modifyReservationCommand82 = new command.ModifyReservationCommand(reservation23, localDateTime27, localDateTime42, "Guest");
        reservation10.setEndTime(localDateTime27);
        model.Equipment equipment84 = reservation10.getEquipment();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime24);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str25 + "' != '" + "" + "'", str25.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock26);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime27);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock43);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime44);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str59 + "' != '" + "" + "'", str59.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock67);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime68);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock69);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime70);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock73);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime74);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(equipment84);
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test216");
        strategy.CreditCardPaymentStrategy creditCardPaymentStrategy0 = new strategy.CreditCardPaymentStrategy();
        boolean boolean2 = creditCardPaymentStrategy0.processPayment(30.0d);
        boolean boolean4 = creditCardPaymentStrategy0.processPayment((double) (byte) 1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test217");
        model.LabManager labManager4 = new model.LabManager("R001", "AVAILABLE", "Student", "P001");
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test218");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        java.time.LocalDateTime localDateTime11 = reservation10.getEndTime();
        reservation10.markArrived();
        model.Equipment equipment13 = reservation10.getEquipment();
        reservation10.setStatus("P001");
        model.User user16 = reservation10.getUser();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(equipment13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(user16);
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test219");
        model.Researcher researcher5 = new model.Researcher("R001", "", "R001", "AVAILABLE", false);
        boolean boolean6 = researcher5.isApproved();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test220");
        model.LabManager labManager4 = new model.LabManager("hi!", "hi!", "ACTIVE", "ACTIVE");
        model.Equipment equipment8 = labManager4.addEquipment("R001", "Guest", "P001");
        java.lang.String str9 = equipment8.getName();
        equipment8.enable();
        java.lang.String str11 = equipment8.getCurrentStateName();
        java.lang.String str12 = equipment8.getName();
        java.lang.String str13 = equipment8.getDescription();
        java.lang.String str14 = equipment8.getLabLocation();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipment8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Guest" + "'", str9.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "Available" + "'", str11.equals("Available"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "Guest" + "'", str12.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "Guest" + "'", str13.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str14 + "' != '" + "P001" + "'", str14.equals("P001"));
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test221");
        model.Student student4 = new model.Student("Research Grant", "hi!", "", "Guest");
        model.Equipment equipment5 = null;
        model.Guest guest11 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment12 = null;
        util.SystemClock systemClock13 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime14 = systemClock13.now();
        util.SystemClock systemClock15 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime16 = systemClock15.now();
        model.Reservation reservation18 = new model.Reservation("P001", (model.User) guest11, equipment12, localDateTime14, localDateTime16, 10.0d);
        model.Guest guest24 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment25 = null;
        java.time.LocalDateTime localDateTime26 = null;
        java.time.LocalDateTime localDateTime27 = null;
        model.Reservation reservation29 = new model.Reservation("", (model.User) guest24, equipment25, localDateTime26, localDateTime27, 1.0d);
        reservation29.forfeitDeposit();
        java.lang.String str31 = reservation29.getReservationId();
        model.Guest guest37 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment38 = null;
        util.SystemClock systemClock39 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime40 = systemClock39.now();
        util.SystemClock systemClock41 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime42 = systemClock41.now();
        model.Reservation reservation44 = new model.Reservation("P001", (model.User) guest37, equipment38, localDateTime40, localDateTime42, 10.0d);
        util.SystemClock systemClock45 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime46 = systemClock45.now();
        command.ModifyReservationCommand modifyReservationCommand48 = new command.ModifyReservationCommand(reservation29, localDateTime40, localDateTime46, "");
        strategy.PaymentStrategy paymentStrategy51 = null;
        command.MakeReservationCommand makeReservationCommand52 = new command.MakeReservationCommand((model.User) student4, equipment5, localDateTime14, localDateTime46, "P001", "Student", paymentStrategy51);
        java.lang.String str53 = student4.getIdNumber();
        java.lang.String str54 = student4.getPassword();
        java.lang.String str55 = student4.getPassword();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str31 + "' != '" + "" + "'", str31.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock39);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock45);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime46);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str53 + "' != '" + "Guest" + "'", str53.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str54 + "' != '" + "" + "'", str54.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str55 + "' != '" + "" + "'", str55.equals(""));
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test222");
        model.Researcher researcher7 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str8 = researcher7.getPassword();
        boolean boolean9 = researcher7.isApproved();
        model.Equipment equipment10 = null;
        util.SystemClock systemClock11 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime12 = systemClock11.now();
        java.time.LocalDateTime localDateTime13 = systemClock11.now();
        model.Guest guest19 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment20 = null;
        util.SystemClock systemClock21 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime22 = systemClock21.now();
        util.SystemClock systemClock23 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime24 = systemClock23.now();
        model.Reservation reservation26 = new model.Reservation("P001", (model.User) guest19, equipment20, localDateTime22, localDateTime24, 10.0d);
        model.Reservation reservation28 = new model.Reservation("", (model.User) researcher7, equipment10, localDateTime13, localDateTime24, (double) (byte) -1);
        model.Guest guest34 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment35 = null;
        java.time.LocalDateTime localDateTime36 = null;
        java.time.LocalDateTime localDateTime37 = null;
        model.Reservation reservation39 = new model.Reservation("", (model.User) guest34, equipment35, localDateTime36, localDateTime37, 1.0d);
        reservation39.forfeitDeposit();
        java.lang.String str41 = reservation39.getReservationId();
        model.Guest guest47 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment48 = null;
        util.SystemClock systemClock49 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime50 = systemClock49.now();
        util.SystemClock systemClock51 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime52 = systemClock51.now();
        model.Reservation reservation54 = new model.Reservation("P001", (model.User) guest47, equipment48, localDateTime50, localDateTime52, 10.0d);
        util.SystemClock systemClock55 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime56 = systemClock55.now();
        command.ModifyReservationCommand modifyReservationCommand58 = new command.ModifyReservationCommand(reservation39, localDateTime50, localDateTime56, "");
        model.UsageRecord usageRecord60 = new model.UsageRecord("P001", localDateTime13, localDateTime50, "Student");
        int int61 = usageRecord60.getDurationMinutes();
        java.time.LocalDateTime localDateTime62 = usageRecord60.getStartTime();
        java.time.LocalDateTime localDateTime63 = usageRecord60.getStartTime();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Research Grant" + "'", str8.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime24);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str41 + "' != '" + "" + "'", str41.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock49);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime50);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock51);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime52);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime56);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int61 + "' != '" + 0 + "'", int61 == 0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime62);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime63);
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test223");
        model.Payment payment8 = new model.Payment("Research Grant", "Debit", "Available", (double) 1L, "", "R001", "Research Grant", "Maintenance");
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test224");
        model.Researcher researcher7 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str8 = researcher7.getPassword();
        boolean boolean9 = researcher7.isApproved();
        model.Equipment equipment10 = null;
        util.SystemClock systemClock11 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime12 = systemClock11.now();
        java.time.LocalDateTime localDateTime13 = systemClock11.now();
        model.Guest guest19 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment20 = null;
        util.SystemClock systemClock21 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime22 = systemClock21.now();
        util.SystemClock systemClock23 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime24 = systemClock23.now();
        model.Reservation reservation26 = new model.Reservation("P001", (model.User) guest19, equipment20, localDateTime22, localDateTime24, 10.0d);
        model.Reservation reservation28 = new model.Reservation("", (model.User) researcher7, equipment10, localDateTime13, localDateTime24, (double) (byte) -1);
        model.Guest guest34 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment35 = null;
        java.time.LocalDateTime localDateTime36 = null;
        java.time.LocalDateTime localDateTime37 = null;
        model.Reservation reservation39 = new model.Reservation("", (model.User) guest34, equipment35, localDateTime36, localDateTime37, 1.0d);
        reservation39.forfeitDeposit();
        java.lang.String str41 = reservation39.getReservationId();
        model.Guest guest47 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment48 = null;
        util.SystemClock systemClock49 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime50 = systemClock49.now();
        util.SystemClock systemClock51 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime52 = systemClock51.now();
        model.Reservation reservation54 = new model.Reservation("P001", (model.User) guest47, equipment48, localDateTime50, localDateTime52, 10.0d);
        util.SystemClock systemClock55 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime56 = systemClock55.now();
        command.ModifyReservationCommand modifyReservationCommand58 = new command.ModifyReservationCommand(reservation39, localDateTime50, localDateTime56, "");
        model.UsageRecord usageRecord60 = new model.UsageRecord("P001", localDateTime13, localDateTime50, "Student");
        java.time.LocalDateTime localDateTime61 = usageRecord60.getEndTime();
        java.lang.String str62 = usageRecord60.getRecordId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Research Grant" + "'", str8.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + false + "'", boolean9 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime24);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str41 + "' != '" + "" + "'", str41.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock49);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime50);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock51);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime52);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime56);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime61);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str62 + "' != '" + "P001" + "'", str62.equals("P001"));
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test225");
        model.Equipment equipment3 = new model.Equipment("Student", "", "Faculty");
        model.Equipment equipment7 = new model.Equipment("R001", "", "Researcher");
        model.EquipmentState equipmentState8 = equipment7.getState();
        equipment3.setState(equipmentState8);
        model.LabManager labManager14 = new model.LabManager("hi!", "hi!", "ACTIVE", "ACTIVE");
        model.Equipment equipment18 = labManager14.addEquipment("R001", "Guest", "P001");
        java.lang.String str19 = equipment18.getName();
        equipment18.enable();
        model.Equipment equipment24 = new model.Equipment("R001", "", "Researcher");
        model.EquipmentState equipmentState25 = equipment24.getState();
        equipment18.setState(equipmentState25);
        equipment3.setState(equipmentState25);
        boolean boolean28 = equipment3.canReserve();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipmentState8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipment18);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str19 + "' != '" + "Guest" + "'", str19.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipmentState25);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean28 + "' != '" + true + "'", boolean28 == true);
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test226");
        model.Guest guest4 = new model.Guest("hi!", "hi!", "", "hi!");
        java.lang.String str5 = guest4.getUserType();
        java.lang.String str6 = guest4.getIdNumber();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str5 + "' != '" + "Guest" + "'", str5.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "hi!" + "'", str6.equals("hi!"));
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test227");
        command.CommandManager commandManager0 = new command.CommandManager();
        commandManager0.printHistory();
        java.util.List<command.ReservationCommand> reservationCommandList2 = commandManager0.getHistory();
        java.util.List<command.ReservationCommand> reservationCommandList3 = commandManager0.getHistory();
        model.Guest guest9 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment10 = null;
        java.time.LocalDateTime localDateTime11 = null;
        java.time.LocalDateTime localDateTime12 = null;
        model.Reservation reservation14 = new model.Reservation("", (model.User) guest9, equipment10, localDateTime11, localDateTime12, 1.0d);
        java.time.LocalDateTime localDateTime15 = reservation14.getEndTime();
        java.lang.String str16 = reservation14.getReservationId();
        util.SystemClock systemClock17 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime18 = systemClock17.now();
        model.Student student23 = new model.Student("Research Grant", "hi!", "", "Guest");
        model.Equipment equipment24 = null;
        model.Guest guest30 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment31 = null;
        util.SystemClock systemClock32 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime33 = systemClock32.now();
        util.SystemClock systemClock34 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime35 = systemClock34.now();
        model.Reservation reservation37 = new model.Reservation("P001", (model.User) guest30, equipment31, localDateTime33, localDateTime35, 10.0d);
        model.Guest guest43 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment44 = null;
        java.time.LocalDateTime localDateTime45 = null;
        java.time.LocalDateTime localDateTime46 = null;
        model.Reservation reservation48 = new model.Reservation("", (model.User) guest43, equipment44, localDateTime45, localDateTime46, 1.0d);
        reservation48.forfeitDeposit();
        java.lang.String str50 = reservation48.getReservationId();
        model.Guest guest56 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment57 = null;
        util.SystemClock systemClock58 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime59 = systemClock58.now();
        util.SystemClock systemClock60 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime61 = systemClock60.now();
        model.Reservation reservation63 = new model.Reservation("P001", (model.User) guest56, equipment57, localDateTime59, localDateTime61, 10.0d);
        util.SystemClock systemClock64 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime65 = systemClock64.now();
        command.ModifyReservationCommand modifyReservationCommand67 = new command.ModifyReservationCommand(reservation48, localDateTime59, localDateTime65, "");
        strategy.PaymentStrategy paymentStrategy70 = null;
        command.MakeReservationCommand makeReservationCommand71 = new command.MakeReservationCommand((model.User) student23, equipment24, localDateTime33, localDateTime65, "P001", "Student", paymentStrategy70);
        command.ModifyReservationCommand modifyReservationCommand73 = new command.ModifyReservationCommand(reservation14, localDateTime18, localDateTime33, "Guest");
        java.lang.String str74 = modifyReservationCommand73.getErrorMessage();
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean75 = commandManager0.execute((command.ReservationCommand) modifyReservationCommand73);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationCommandList2);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationCommandList3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str16 + "' != '" + "" + "'", str16.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime18);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock32);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime33);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock34);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str50 + "' != '" + "" + "'", str50.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock58);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime59);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock60);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime61);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock64);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime65);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str74 + "' != '" + "" + "'", str74.equals(""));
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test228");
        service.BillingService billingService0 = new service.BillingService();
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy1 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str2 = researchGrantPaymentStrategy1.getMethodName();
        boolean boolean4 = researchGrantPaymentStrategy1.processPayment(0.0d);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy1);
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy6 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str7 = researchGrantPaymentStrategy6.getMethodName();
        boolean boolean9 = researchGrantPaymentStrategy6.processPayment(0.0d);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy6);
        // The following exception was thrown during execution in test generation
        try {
            double double12 = billingService0.calculateFee((double) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: Pricing strategy not set");
        } catch (java.lang.IllegalStateException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str2 + "' != '" + "Research Grant" + "'", str2.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Research Grant" + "'", str7.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test229");
        data.MaintainUser maintainUser0 = new data.MaintainUser();
        data.MaintainUser maintainUser1 = new data.MaintainUser();
        model.Guest guest7 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment8 = null;
        java.time.LocalDateTime localDateTime9 = null;
        java.time.LocalDateTime localDateTime10 = null;
        model.Reservation reservation12 = new model.Reservation("", (model.User) guest7, equipment8, localDateTime9, localDateTime10, 1.0d);
        java.lang.String str13 = guest7.getUserType();
        model.Guest guest19 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment20 = null;
        java.time.LocalDateTime localDateTime21 = null;
        java.time.LocalDateTime localDateTime22 = null;
        model.Reservation reservation24 = new model.Reservation("", (model.User) guest19, equipment20, localDateTime21, localDateTime22, 1.0d);
        model.Guest guest29 = new model.Guest("hi!", "hi!", "", "hi!");
        model.Guest guest35 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment36 = null;
        java.time.LocalDateTime localDateTime37 = null;
        java.time.LocalDateTime localDateTime38 = null;
        model.Reservation reservation40 = new model.Reservation("", (model.User) guest35, equipment36, localDateTime37, localDateTime38, 1.0d);
        java.lang.String str41 = guest35.getUserType();
        model.User[] userArray42 = new model.User[] { guest7, guest19, guest29, guest35 };
        java.util.ArrayList<model.User> userList43 = new java.util.ArrayList<model.User>();
        boolean boolean44 = java.util.Collections.addAll((java.util.Collection<model.User>) userList43, userArray42);
        maintainUser1.users = userList43;
        java.util.List<model.User> userList46 = maintainUser1.users;
        maintainUser0.users = userList46;
        model.User user49 = maintainUser0.findById("hi!");
        model.User user51 = maintainUser0.findByEmail("R001");
        model.User user53 = maintainUser0.findById("Maintenance");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "Guest" + "'", str13.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str41 + "' != '" + "Guest" + "'", str41.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(userArray42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + true + "'", boolean44 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(userList46);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(user49);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(user51);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(user53);
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test230");
        model.HeadLabCoordinator headLabCoordinator0 = model.HeadLabCoordinator.getInstance();
        model.LabManager labManager5 = headLabCoordinator0.createLabManagerAccount("P001", "ACTIVE", "Modify reservation  to 2026-03-25 18:41 \u2192 2026-03-25 18:41", "Faculty");
        model.Equipment equipment9 = labManager5.addEquipment("Maintenance", "Debit", "LabManager");
        model.Equipment equipment13 = new model.Equipment("R001", "", "Researcher");
        labManager5.markEquipmentUnderMaintenance(equipment13);
        java.lang.String str15 = equipment13.getLabLocation();
        java.lang.String str16 = equipment13.getEquipmentId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(headLabCoordinator0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(labManager5);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipment9);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str15 + "' != '" + "Researcher" + "'", str15.equals("Researcher"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str16 + "' != '" + "R001" + "'", str16.equals("R001"));
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test231");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        reservation10.forfeitDeposit();
        java.lang.String str12 = reservation10.getReservationId();
        java.lang.String str13 = reservation10.getReservationId();
        reservation10.forfeitDeposit();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "" + "'", str13.equals(""));
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test232");
        data.MaintainUser maintainUser0 = new data.MaintainUser();
        model.Guest guest6 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        java.time.LocalDateTime localDateTime9 = null;
        model.Reservation reservation11 = new model.Reservation("", (model.User) guest6, equipment7, localDateTime8, localDateTime9, 1.0d);
        java.lang.String str12 = guest6.getUserType();
        model.Guest guest18 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment19 = null;
        java.time.LocalDateTime localDateTime20 = null;
        java.time.LocalDateTime localDateTime21 = null;
        model.Reservation reservation23 = new model.Reservation("", (model.User) guest18, equipment19, localDateTime20, localDateTime21, 1.0d);
        model.Guest guest28 = new model.Guest("hi!", "hi!", "", "hi!");
        model.Guest guest34 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment35 = null;
        java.time.LocalDateTime localDateTime36 = null;
        java.time.LocalDateTime localDateTime37 = null;
        model.Reservation reservation39 = new model.Reservation("", (model.User) guest34, equipment35, localDateTime36, localDateTime37, 1.0d);
        java.lang.String str40 = guest34.getUserType();
        model.User[] userArray41 = new model.User[] { guest6, guest18, guest28, guest34 };
        java.util.ArrayList<model.User> userList42 = new java.util.ArrayList<model.User>();
        boolean boolean43 = java.util.Collections.addAll((java.util.Collection<model.User>) userList42, userArray41);
        maintainUser0.users = userList42;
        java.util.List<model.User> userList45 = maintainUser0.users;
        model.User user47 = maintainUser0.findByEmail("AVAILABLE");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "Guest" + "'", str12.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str40 + "' != '" + "Guest" + "'", str40.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(userArray41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + true + "'", boolean43 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(userList45);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(user47);
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test233");
        factory.UserFactory userFactory0 = new factory.UserFactory();
        model.User user7 = userFactory0.createUser("Guest", "Researcher", "Student", "P001", "Cancel reservation ", false);
        model.LabManager labManager12 = userFactory0.createLabManager("Cancel reservation ", "Guest", "Researcher", "ACTIVE");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(user7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(labManager12);
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test234");
        command.CommandManager commandManager0 = new command.CommandManager();
        commandManager0.printHistory();
        java.util.List<command.ReservationCommand> reservationCommandList2 = commandManager0.getHistory();
        java.util.List<command.ReservationCommand> reservationCommandList3 = commandManager0.getHistory();
        commandManager0.printHistory();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationCommandList2);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationCommandList3);
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test235");
        service.ReservationService reservationService2 = new service.ReservationService("Research Grant", "ACTIVE");
        java.util.List<model.Reservation> reservationList4 = reservationService2.getReservationsForEquipment("Guest");
        java.util.List<model.Reservation> reservationList6 = reservationService2.getReservationsForEquipment("Research Grant");
        java.lang.String str7 = reservationService2.getLastError();
        model.Guest guest13 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment14 = null;
        java.time.LocalDateTime localDateTime15 = null;
        java.time.LocalDateTime localDateTime16 = null;
        model.Reservation reservation18 = new model.Reservation("", (model.User) guest13, equipment14, localDateTime15, localDateTime16, 1.0d);
        reservation18.forfeitDeposit();
        java.lang.String str20 = reservation18.getReservationId();
        boolean boolean21 = reservation18.isDepositForfeited();
        util.SystemClock systemClock22 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime23 = systemClock22.now();
        java.time.LocalDateTime localDateTime24 = systemClock22.now();
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean25 = reservationService2.extendReservation(reservation18, localDateTime24);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str20 + "' != '" + "" + "'", str20.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + true + "'", boolean21 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime24);
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test236");
        model.Payment payment8 = new model.Payment("ACTIVE", "Researcher", "ACTIVE", (double) 1.0f, "", "P001", "Faculty", "ACTIVE");
        java.lang.String str9 = payment8.getReservationId();
        java.lang.String str10 = payment8.getStatus();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Researcher" + "'", str9.equals("Researcher"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "P001" + "'", str10.equals("P001"));
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test237");
        service.ReservationService reservationService2 = new service.ReservationService("hi!", "Guest");
        java.util.List<model.Reservation> reservationList3 = reservationService2.getAllReservations();
        java.util.List<model.Reservation> reservationList4 = reservationService2.getAllReservations();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(reservationList4);
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test238");
        model.LabManager labManager4 = new model.LabManager("hi!", "hi!", "ACTIVE", "ACTIVE");
        model.Equipment equipment8 = labManager4.addEquipment("R001", "Guest", "P001");
        java.lang.String str9 = equipment8.getName();
        equipment8.enable();
        java.lang.String str11 = equipment8.getCurrentStateName();
        java.lang.String str12 = equipment8.getName();
        java.lang.String str13 = equipment8.getLabLocation();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipment8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Guest" + "'", str9.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "Available" + "'", str11.equals("Available"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "Guest" + "'", str12.equals("Guest"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "P001" + "'", str13.equals("P001"));
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test239");
        model.Researcher researcher5 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str6 = researcher5.getPassword();
        boolean boolean7 = researcher5.isApproved();
        java.lang.String str8 = researcher5.getUserType();
        java.lang.String str9 = researcher5.getUserType();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Research Grant" + "'", str6.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Researcher" + "'", str8.equals("Researcher"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Researcher" + "'", str9.equals("Researcher"));
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test240");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        util.SystemClock systemClock7 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime8 = systemClock7.now();
        util.SystemClock systemClock9 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime10 = systemClock9.now();
        model.Reservation reservation12 = new model.Reservation("P001", (model.User) guest5, equipment6, localDateTime8, localDateTime10, 10.0d);
        java.time.LocalDateTime localDateTime13 = reservation12.getStartTime();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock9);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime13);
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test241");
        data.MaintainEquipment maintainEquipment0 = new data.MaintainEquipment();
        java.util.List<model.Equipment> equipmentList1 = maintainEquipment0.getAvailableEquipment();
        model.Equipment equipment3 = maintainEquipment0.findById("P001");
        java.util.List<model.Equipment> equipmentList4 = maintainEquipment0.equipmentList;
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipmentList1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(equipment3);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipmentList4);
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test242");
        model.Guest guest5 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment6 = null;
        java.time.LocalDateTime localDateTime7 = null;
        java.time.LocalDateTime localDateTime8 = null;
        model.Reservation reservation10 = new model.Reservation("", (model.User) guest5, equipment6, localDateTime7, localDateTime8, 1.0d);
        java.time.LocalDateTime localDateTime11 = reservation10.getEndTime();
        reservation10.markArrived();
        java.lang.String str13 = reservation10.getStatus();
        model.Researcher researcher21 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str22 = researcher21.getPassword();
        boolean boolean23 = researcher21.isApproved();
        model.Equipment equipment24 = null;
        util.SystemClock systemClock25 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime26 = systemClock25.now();
        java.time.LocalDateTime localDateTime27 = systemClock25.now();
        model.Guest guest33 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment34 = null;
        util.SystemClock systemClock35 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime36 = systemClock35.now();
        util.SystemClock systemClock37 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime38 = systemClock37.now();
        model.Reservation reservation40 = new model.Reservation("P001", (model.User) guest33, equipment34, localDateTime36, localDateTime38, 10.0d);
        model.Reservation reservation42 = new model.Reservation("", (model.User) researcher21, equipment24, localDateTime27, localDateTime38, (double) (byte) -1);
        model.Guest guest48 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment49 = null;
        java.time.LocalDateTime localDateTime50 = null;
        java.time.LocalDateTime localDateTime51 = null;
        model.Reservation reservation53 = new model.Reservation("", (model.User) guest48, equipment49, localDateTime50, localDateTime51, 1.0d);
        reservation53.forfeitDeposit();
        java.lang.String str55 = reservation53.getReservationId();
        model.Guest guest61 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment62 = null;
        util.SystemClock systemClock63 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime64 = systemClock63.now();
        util.SystemClock systemClock65 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime66 = systemClock65.now();
        model.Reservation reservation68 = new model.Reservation("P001", (model.User) guest61, equipment62, localDateTime64, localDateTime66, 10.0d);
        util.SystemClock systemClock69 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime70 = systemClock69.now();
        command.ModifyReservationCommand modifyReservationCommand72 = new command.ModifyReservationCommand(reservation53, localDateTime64, localDateTime70, "");
        model.UsageRecord usageRecord74 = new model.UsageRecord("P001", localDateTime27, localDateTime64, "Student");
        int int75 = usageRecord74.getDurationMinutes();
        java.lang.String str76 = usageRecord74.getRecordId();
        java.time.LocalDateTime localDateTime77 = usageRecord74.getStartTime();
        reservation10.setStartTime(localDateTime77);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(localDateTime11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "ACTIVE" + "'", str13.equals("ACTIVE"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str22 + "' != '" + "Research Grant" + "'", str22.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + false + "'", boolean23 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock25);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime26);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime27);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime36);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock37);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime38);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str55 + "' != '" + "" + "'", str55.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock63);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime64);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock65);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime66);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock69);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime70);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int75 + "' != '" + 0 + "'", int75 == 0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str76 + "' != '" + "P001" + "'", str76.equals("P001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime77);
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test243");
        model.Researcher researcher5 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str6 = researcher5.getUserType();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Researcher" + "'", str6.equals("Researcher"));
    }

    @Test
    public void test244() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test244");
        model.Student student4 = new model.Student("Research Grant", "hi!", "", "Guest");
        model.Equipment equipment5 = null;
        model.Guest guest11 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment12 = null;
        util.SystemClock systemClock13 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime14 = systemClock13.now();
        util.SystemClock systemClock15 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime16 = systemClock15.now();
        model.Reservation reservation18 = new model.Reservation("P001", (model.User) guest11, equipment12, localDateTime14, localDateTime16, 10.0d);
        model.Guest guest24 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment25 = null;
        java.time.LocalDateTime localDateTime26 = null;
        java.time.LocalDateTime localDateTime27 = null;
        model.Reservation reservation29 = new model.Reservation("", (model.User) guest24, equipment25, localDateTime26, localDateTime27, 1.0d);
        reservation29.forfeitDeposit();
        java.lang.String str31 = reservation29.getReservationId();
        model.Guest guest37 = new model.Guest("", "Research Grant", "", "hi!");
        model.Equipment equipment38 = null;
        util.SystemClock systemClock39 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime40 = systemClock39.now();
        util.SystemClock systemClock41 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime42 = systemClock41.now();
        model.Reservation reservation44 = new model.Reservation("P001", (model.User) guest37, equipment38, localDateTime40, localDateTime42, 10.0d);
        util.SystemClock systemClock45 = util.SystemClock.getInstance();
        java.time.LocalDateTime localDateTime46 = systemClock45.now();
        command.ModifyReservationCommand modifyReservationCommand48 = new command.ModifyReservationCommand(reservation29, localDateTime40, localDateTime46, "");
        strategy.PaymentStrategy paymentStrategy51 = null;
        command.MakeReservationCommand makeReservationCommand52 = new command.MakeReservationCommand((model.User) student4, equipment5, localDateTime14, localDateTime46, "P001", "Student", paymentStrategy51);
        java.lang.String str53 = makeReservationCommand52.getErrorMessage();
        java.lang.String str54 = makeReservationCommand52.getErrorMessage();
        // The following exception was thrown during execution in test generation
        try {
            makeReservationCommand52.execute();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str31 + "' != '" + "" + "'", str31.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock39);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(systemClock45);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(localDateTime46);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str53 + "' != '" + "" + "'", str53.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str54 + "' != '" + "" + "'", str54.equals(""));
    }

    @Test
    public void test245() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test245");
        model.Payment payment8 = new model.Payment("ACTIVE", "Researcher", "ACTIVE", (double) 1.0f, "", "P001", "Faculty", "ACTIVE");
        java.lang.String str9 = payment8.getPaymentMethod();
        java.lang.String str10 = payment8.getPaymentMethod();
        java.lang.String str11 = payment8.getType();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "" + "'", str10.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "ACTIVE" + "'", str11.equals("ACTIVE"));
    }

    @Test
    public void test246() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test246");
        model.Equipment equipment3 = new model.Equipment("Student", "", "Faculty");
        model.Equipment equipment7 = new model.Equipment("R001", "", "Researcher");
        model.EquipmentState equipmentState8 = equipment7.getState();
        equipment3.setState(equipmentState8);
        model.EquipmentState equipmentState10 = equipment3.getState();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipmentState8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(equipmentState10);
    }

    @Test
    public void test247() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test247");
        strategy.ResearcherPricingStrategy researcherPricingStrategy0 = new strategy.ResearcherPricingStrategy();
        double double1 = researcherPricingStrategy0.getRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double1 + "' != '" + 20.0d + "'", double1 == 20.0d);
    }

    @Test
    public void test248() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test248");
        service.BillingService billingService0 = new service.BillingService();
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy1 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str2 = researchGrantPaymentStrategy1.getMethodName();
        boolean boolean4 = researchGrantPaymentStrategy1.processPayment(0.0d);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy1);
        boolean boolean7 = researchGrantPaymentStrategy1.processPayment((double) (short) 100);
        boolean boolean9 = researchGrantPaymentStrategy1.processPayment((double) (byte) 100);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str2 + "' != '" + "Research Grant" + "'", str2.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test249() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test249");
        model.HeadLabCoordinator headLabCoordinator0 = model.HeadLabCoordinator.getInstance();
        model.LabManager labManager5 = headLabCoordinator0.createLabManagerAccount("Student", "ACTIVE", "R001", "Faculty");
        model.LabManager labManager10 = headLabCoordinator0.createLabManagerAccount("Maintenance", "AVAILABLE", "AVAILABLE", "");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(headLabCoordinator0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(labManager5);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(labManager10);
    }

    @Test
    public void test250() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test250");
        model.Faculty faculty5 = new model.Faculty("AVAILABLE", "Researcher", "AVAILABLE", "P001", true);
    }

    @Test
    public void test251() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test251");
        service.BillingService billingService0 = new service.BillingService();
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy1 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str2 = researchGrantPaymentStrategy1.getMethodName();
        boolean boolean4 = researchGrantPaymentStrategy1.processPayment(0.0d);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy1);
        service.BillingService billingService6 = new service.BillingService();
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy7 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str8 = researchGrantPaymentStrategy7.getMethodName();
        boolean boolean10 = researchGrantPaymentStrategy7.processPayment(0.0d);
        billingService6.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy7);
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy12 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str13 = researchGrantPaymentStrategy12.getMethodName();
        boolean boolean15 = researchGrantPaymentStrategy12.processPayment(0.0d);
        billingService6.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy12);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy12);
        java.lang.String str18 = billingService0.getPaymentMethodName();
        // The following exception was thrown during execution in test generation
        try {
            double double20 = billingService0.calculateFee((double) (-1L));
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: Pricing strategy not set");
        } catch (java.lang.IllegalStateException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str2 + "' != '" + "Research Grant" + "'", str2.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Research Grant" + "'", str8.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "Research Grant" + "'", str13.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str18 + "' != '" + "Research Grant" + "'", str18.equals("Research Grant"));
    }

    @Test
    public void test252() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test252");
        service.RegistrationService registrationService0 = new service.RegistrationService();
        // The following exception was thrown during execution in test generation
        try {
            model.User user7 = registrationService0.registerUser("Debit", "hi!", "hi!", "Maintenance", "P001", false);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: Password must contain uppercase, lowercase, digit, and symbol.");
        } catch (java.lang.IllegalArgumentException e) {
        // Expected exception.
        }
    }

    @Test
    public void test253() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test253");
        model.Researcher researcher5 = new model.Researcher("Research Grant", "Research Grant", "Research Grant", "hi!", false);
        java.lang.String str6 = researcher5.getPassword();
        double double7 = researcher5.getHourlyRate();
        boolean boolean8 = researcher5.isApproved();
        double double9 = researcher5.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Research Grant" + "'", str6.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double7 + "' != '" + 20.0d + "'", double7 == 20.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 20.0d + "'", double9 == 20.0d);
    }

    @Test
    public void test254() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test254");
        data.MaintainPayment maintainPayment0 = new data.MaintainPayment();
        java.lang.String str1 = maintainPayment0.nextId();
        model.Payment payment10 = new model.Payment("R001", "R001", "hi!", (double) '4', "", "P001", "P001", "");
        java.lang.String str11 = payment10.getPaymentId();
        java.lang.String str12 = payment10.getPaymentId();
        java.lang.String str13 = payment10.getStatus();
        model.Payment[] paymentArray14 = new model.Payment[] { payment10 };
        java.util.ArrayList<model.Payment> paymentList15 = new java.util.ArrayList<model.Payment>();
        boolean boolean16 = java.util.Collections.addAll((java.util.Collection<model.Payment>) paymentList15, paymentArray14);
        maintainPayment0.payments = paymentList15;
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str1 + "' != '" + "P001" + "'", str1.equals("P001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "R001" + "'", str11.equals("R001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "R001" + "'", str12.equals("R001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "P001" + "'", str13.equals("P001"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(paymentArray14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
    }

    @Test
    public void test255() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test255");
        service.BillingService billingService0 = new service.BillingService();
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy1 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str2 = researchGrantPaymentStrategy1.getMethodName();
        boolean boolean4 = researchGrantPaymentStrategy1.processPayment(0.0d);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy1);
        service.BillingService billingService6 = new service.BillingService();
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy7 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str8 = researchGrantPaymentStrategy7.getMethodName();
        boolean boolean10 = researchGrantPaymentStrategy7.processPayment(0.0d);
        billingService6.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy7);
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy12 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str13 = researchGrantPaymentStrategy12.getMethodName();
        boolean boolean15 = researchGrantPaymentStrategy12.processPayment(0.0d);
        billingService6.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy12);
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy12);
        java.lang.String str18 = billingService0.getPaymentMethodName();
        strategy.ResearchGrantPaymentStrategy researchGrantPaymentStrategy19 = new strategy.ResearchGrantPaymentStrategy();
        java.lang.String str20 = researchGrantPaymentStrategy19.getMethodName();
        java.lang.String str21 = researchGrantPaymentStrategy19.getMethodName();
        boolean boolean23 = researchGrantPaymentStrategy19.processPayment((double) (-1L));
        billingService0.setPaymentStrategy((strategy.PaymentStrategy) researchGrantPaymentStrategy19);
        // The following exception was thrown during execution in test generation
        try {
            double double26 = billingService0.calculateFee((double) (byte) -1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: Pricing strategy not set");
        } catch (java.lang.IllegalStateException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str2 + "' != '" + "Research Grant" + "'", str2.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Research Grant" + "'", str8.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "Research Grant" + "'", str13.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str18 + "' != '" + "Research Grant" + "'", str18.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str20 + "' != '" + "Research Grant" + "'", str20.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str21 + "' != '" + "Research Grant" + "'", str21.equals("Research Grant"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
    }

    @Test
    public void test256() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test256");
        strategy.DebitPaymentStrategy debitPaymentStrategy0 = new strategy.DebitPaymentStrategy();
        boolean boolean2 = debitPaymentStrategy0.processPayment((double) 0);
        boolean boolean4 = debitPaymentStrategy0.processPayment(100.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean2 + "' != '" + true + "'", boolean2 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + true + "'", boolean4 == true);
    }
}

