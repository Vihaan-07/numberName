import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class ProjectLogin{
    private static JFrame login;
    private static JPanel panel;
    private static JLabel user, pass, access;
    private static JTextField usernameInput;
    private static JPasswordField passwordInput;
    private static JButton enter;
    private boolean flag;

    public void loginPage() {
        ProjectLogin obj = new ProjectLogin();
        obj.loginFrame();
    }

    public void loginFrame() {
        login = new JFrame("Login");
        login.setSize(350, 350);
        login.setDefaultCloseOperation(3);

        panel = new JPanel();
        panel.setLayout(null);
        login.add(panel);

        user = new JLabel("Username");
        user.setBounds(10,20,80,25);
        panel.add(user);

        usernameInput = new JTextField(20);
        usernameInput.setBounds(100 ,20, 165, 25); 
        panel.add(usernameInput);

        pass = new JLabel("Password");
        pass.setBounds(10,50,80,25);
        panel.add(pass);

        passwordInput = new JPasswordField(20);
        passwordInput.setBounds(100, 50, 165, 25);
        panel.add(passwordInput);

        enter = new JButton("Enter");
        enter.setBounds(100,100, 80, 25);
        panel.add(enter);

        enter.addActionListener(ae ->
            {
                String userlist[]= {"access1","access2", "access3"}; 
                String passlist[]= {"pass1", "pass2", "pass3"};     

                String user = usernameInput.getText();
                String pass = passwordInput.getText();
                flag = false;

                for(int i = 0; i<userlist.length;i++) {
                    if(userlist[i].equals(user) && passlist[i].equals(pass)) {
                        access.setText("Access Granted");
                        flag = true;

                        NumName nn = new NumName();
                        nn.numNameFrame();
                    }
                }
                if(flag == false) {
                    access.setText("Access Denied");
                }
            });

        access = new JLabel();
        access.setBounds(100, 150, 100, 25);
        panel.add(access);

        login.setVisible(true);
    }

}