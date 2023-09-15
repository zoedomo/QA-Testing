package appointment;

import java.util.Date;

public class Appointment {
    private static final int MAX_APPOINTMENT_ID_LENGTH = 10;
    private static final int MAX_DESCRIPTION_LENGTH = 50;

    private final String appointmentID;
    private final Date appointmentDate;
    private final String description;

    public Appointment(String appointmentID, Date appointmentDate, String description) {
        if (appointmentID == null || appointmentID.isEmpty() || appointmentID.length() > MAX_APPOINTMENT_ID_LENGTH) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        this.appointmentID = appointmentID;

        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        this.appointmentDate = appointmentDate;

        if (description == null || description.isEmpty() || description.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }
    
    
    // appointmentDate is in the future
    public boolean isAppointmentDateValid() {
        Date currentDate = new Date();
        return !appointmentDate.before(currentDate);
    }
}
