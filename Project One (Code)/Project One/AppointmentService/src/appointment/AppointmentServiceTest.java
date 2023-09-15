package appointment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class AppointmentServiceTest {

    private AppointmentService appointmentService;

    @BeforeEach
    public void setup() {
        appointmentService = new AppointmentService();
    }

    @Test
    public void testAddAppointment() {
        // test adding a valid appointment
        String appointmentID = "A123456789";
        Date appointmentDate = new Date();
        String description = "Checkup";

        Appointment appointment = new Appointment(appointmentID, appointmentDate, description);
        appointmentService.addAppointment(appointment);

        // verify appointment was added
        Assertions.assertEquals(1, appointmentService.getAppointments().size());
        Assertions.assertEquals(appointment, appointmentService.getAppointments().get(0));
    }

    @Test
    public void testAddDuplicateAppointmentID() {
        // test adding two appointments w/ same appointment ID
        String appointmentID = "A123456789";
        Date appointmentDate1 = new Date(); 
        String description1 = "Checkup";

        Date appointmentDate2 = new Date();
        String description2 = "Meeting";

        Appointment appointment1 = new Appointment(appointmentID, appointmentDate1, description1);
        Appointment appointment2 = new Appointment(appointmentID, appointmentDate2, description2);

        // add the first appointment
        appointmentService.addAppointment(appointment1);

        // verify first appointment is added successfully
        Assertions.assertEquals(1, appointmentService.getAppointments().size());

        // add the second appointment with the same appointment ID
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment2);
        });

        // verify second appointment was not added
        Assertions.assertEquals(1, appointmentService.getAppointments().size());
    }

    @Test
    public void testDeleteAppointment() {
        // test deleting an appointment
        String appointmentID = "A123456789";
        Date appointmentDate = new Date();
        String description = "Checkup";

        Appointment appointment = new Appointment(appointmentID, appointmentDate, description);
        appointmentService.addAppointment(appointment);

        // verify appointment was added
        Assertions.assertEquals(1, appointmentService.getAppointments().size());

        // delete appointment
        appointmentService.deleteAppointment(appointmentID);

        // verify appointment was deleted
        Assertions.assertEquals(0, appointmentService.getAppointments().size());
    }
}
