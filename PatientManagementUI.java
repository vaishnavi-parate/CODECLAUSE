import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PatientManagementUI extends JFrame {
    private PatientDAO patientDAO;

    public PatientManagementUI() {
        setTitle("Patient Management");
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        patientDAO = new PatientDAO();

        JButton addPatientButton = new JButton("Add Patient");
        addPatientButton.setBounds(50, 50, 200, 50);
        add(addPatientButton);

        JTextArea displayArea = new JTextArea();
        displayArea.setBounds(50, 150, 700, 300);
        add(displayArea);

        JButton loadPatientsButton = new JButton("Load Patients");
        loadPatientsButton.setBounds(300, 50, 200, 50);
        add(loadPatientsButton);

        addPatientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Enter Patient Name:");
                int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Patient Age:"));
                String gender = JOptionPane.showInputDialog("Enter Gender:");
                String address = JOptionPane.showInputDialog("Enter Address:");
                String contact = JOptionPane.showInputDialog("Enter Contact:");
                String emergencyContact = JOptionPane.showInputDialog("Enter Emergency Contact:");
                String medicalHistory = JOptionPane.showInputDialog("Enter Medical History:");
                
                Patient patient = new Patient(name, age, gender, address, contact, emergencyContact, medicalHistory);
                patientDAO.addPatient(patient);
                JOptionPane.showMessageDialog(null, "Patient added successfully!");
            }
        });

        loadPatientsButton.addActionListener(e -> {
            List<Patient> patients = patientDAO.getAllPatients();
            StringBuilder sb = new StringBuilder();
            for (Patient patient : patients) {
                sb.append("ID: ").append(patient.getPatientId())
                  .append(", Name: ").append(patient.getName())
                  .append(", Age: ").append(patient.getAge())
                  .append("\n");
            }
            displayArea.setText(sb.toString());
        });
    }
}
