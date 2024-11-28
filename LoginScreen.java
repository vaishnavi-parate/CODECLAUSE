import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginScreen() {
        setTitle("Hospital Information System - Login");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 50, 100, 30);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 50, 150, 30);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 30);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 150, 30);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 100, 30);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (username.equals("admin") && password.equals("password")) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    new MainDashboard().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials.");
                }
            }
        });
    }

    public static void main(String[] args) {
        new LoginScreen().setVisible(true);
    }
}
