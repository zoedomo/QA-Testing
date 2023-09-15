package appointment;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class AppointmentTest {

    @Test
    public void testValidAppointment() {
        // test valid appointment creation
        String appointmentID = "A123456789";
        Date appointmentDate = getDateInFuture(2);
        String description = "Dentist Checkup";

        Appointment appointment = new Appointment(appointmentID, appointmentDate, description);

        // verify appointment properties
        Assertions.assertEquals(appointmentID, appointment.getAppointmentID());
        Assertions.assertEquals(appointmentDate, appointment.getAppointmentDate());
        Assertions.assertEquals(description, appointment.getDescription());
        Assertions.assertTrue(appointment.isAppointmentDateValid());
    }

    @Test
    public void testInvalidAppointmentID() {
        // test invalid appointmentID
        String appointmentID = "A1234567890"; // 11 characters, max is 10
        Date appointmentDate = getDateInFuture(3);
        String description = "Meeting";

        // verify exception is thrown
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(appointmentID, appointmentDate, description);
        });
    }

    @Test
    public void testInvalidAppointmentDate() {
        // test invalid appointmentDate
        String appointmentID = "A123456789";
        Date appointmentDate = getDateInPast(1);
        String description = "Event";

        // verify exception is thrown
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(appointmentID, appointmentDate, description);
        });
    }

    @Test
    public void testInvalidDescription() {
        // test invalid description
        String appointmentID = "A123456789";
        Date appointmentDate = getDateInFuture(5);
        String description = "This is a very long description that exceeds the maximum allowed length of 50 characters.";

        // verify exception is thrown
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(appointmentID, appointmentDate, description);
        });
    }

    private Date getDateInFuture(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    private Date getDateInPast(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -days);
        return calendar.getTime();
    }
}
