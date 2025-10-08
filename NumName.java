import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumName implements ActionListener {
    private static JFrame frame;
    private static JPanel panel;
    private static JLabel label, numname;
    private static JTextField num;
    private static JButton enter;
    
    public void numNameFrame() {
        frame = new JFrame("Number Name Conversion");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(3);
        
        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        
        label = new JLabel("Enter a number between 1 and 999999");
        label.setBounds(10, 20, 350, 25);
        panel.add(label);
        
        num = new JTextField(6);
        num.setBounds(10, 50, 165, 25);
        panel.add(num);
        
        enter = new JButton("Enter");
        enter.setBounds(25, 100, 80, 25);
        enter.addActionListener(this);
        panel.add(enter);
        
        numname = new JLabel();
        numname.setBounds(10, 150, 500, 25);
        panel.add(numname);
        
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        int num = Integer.parseInt(this.num.getText());
        NumberNames obj = new NumberNames(num);
        obj.rev();
        String s = obj.print();
        numname.setText(s);
    }
}