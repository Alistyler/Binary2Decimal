import java.awt.event.*;
import javax.swing.*;

class input extends JFrame implements ActionListener {
    static JTextField text;
    static JFrame frame;
    static JButton button;
    static JLabel label;
    input()
    {
    }

    public static void main(String[] args) {
        frame = new JFrame("Bin2Dec");
        label = new JLabel("nothing entered");
        button =new JButton("convert");

        input input = new input();

        button.addActionListener(input);

        text  = new JTextField("Enter up to 8 binary digits", 16);

        JPanel panel = new JPanel();

        panel.add(text);
        panel.add(label);
        panel.add(button);

        frame.add(panel);

        frame.setSize(1000, 1000);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("convert")) {
            if (length()) {
                if (matches()) {
                    label.setText(text.getText());
                    bin2dec();
                } else {
                    label.setText("Error: Do not enter anything other than 0 or 1!");
                }
            } else {
                label.setText("Error: Enter up to 8 binary digits!");
            }
        }
    }
    

    public boolean length() {
        String charString = text.getText();
        boolean length = true;
        int stringLen = charString.length();

        for(int i = 0; i < stringLen; i++) {
            if(i > 8) {
                return length = false;
            }
        }
        return length;
    }

    public boolean matches() {
        String charString = text.getText();
        boolean match = false;
        String binaryString = "[01]+";
    
        if (charString.matches(binaryString)) {
            return match = true;
        } else {
            return match;
        }
    }
    

    public int bin2dec() {
        String charString = text.getText();
        int len = charString.length();
        int decimal = 0;
        
        for(int i = 0; i < len; i++) {
            char binaryChar = charString.charAt(i);
            int binaryDigit = Character.getNumericValue(binaryChar);
            int dec = binaryDigit * (int) Math.pow(2,  (len - 1) - i);
            decimal += dec;
        }

        System.out.println(decimal + " = " + charString);
        System.out.println(len);

        return decimal;
    }
}