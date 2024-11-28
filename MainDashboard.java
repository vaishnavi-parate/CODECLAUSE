import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainDashboard extends JFrame {
    public MainDashboard() {
        setTitle("Hospital Information System - Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JButton patientManagementButton = new JButton("Manage Patients");
        patientManagementButton.setBounds(200, 50, 200, 50);
        add(patientManagementButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(200, 200, 200, 50);
        add(exitButton);

        patientManagementButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PatientManagementUI().setVisible(true);
                dispose();
            }
        });

        exitButton.addActionListener(e -> System.exit(0));
    }
}
