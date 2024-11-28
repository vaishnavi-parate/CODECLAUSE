import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    public void addPatient(Patient patient) {
        String query = "INSERT INTO patients (name, age, gender, address, contact, emergency_contact, medical_history) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, patient.getName());
            stmt.setInt(2, patient.getAge());
            stmt.setString(3, patient.getGender());
            stmt.setString(4, patient.getAddress());
            stmt.setString(5, patient.getContact());
            stmt.setString(6, patient.getEmergencyContact());
            stmt.setString(7, patient.getMedicalHistory());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Patient> getAllPatients() {
        String query = "SELECT * FROM patients";
        List<Patient> patients = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient(
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("gender"),
                    rs.getString("address"),
                    rs.getString("contact"),
                    rs.getString("emergency_contact"),
                    rs.getString("medical_history")
                );
                patient.setPatientId(rs.getInt("patient_id"));
                patients.add(patient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patients;
    }
}
