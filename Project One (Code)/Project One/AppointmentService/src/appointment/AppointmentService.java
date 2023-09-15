package appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    private List<Appointment> appointments;

    public AppointmentService() {
        this.appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment appointment) {
        if (appointment != null) {
            String appointmentID = appointment.getAppointmentID();
            if (isAppointmentIDUnique(appointmentID)) {
                appointments.add(appointment);
            } else {
                throw new IllegalArgumentException("Appointment ID must be unique.");
            }
        }
    }

    private boolean isAppointmentIDUnique(String appointmentID) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentID().equals(appointmentID)) {
                return false;
            }
        }
        return true;
    }

    public void deleteAppointment(String appointmentID) {
        Appointment appointmentToRemove = null;
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentID().equals(appointmentID)) {
                appointmentToRemove = appointment;
                break;
            }
        }
        if (appointmentToRemove != null) {
            appointments.remove(appointmentToRemove);
        } else {
            throw new IllegalArgumentException("Appointment with ID " + appointmentID + " not found.");
        }
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}

