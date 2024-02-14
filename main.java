import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class Input extends JFrame implements ActionListener {
    static JTextField text;
    static JTextArea output;
    static JFrame frame;
    static JButton button;
    static JLabel label;
    Input()
    {
    }

    public static void main(String[] args) {
        frame = new JFrame("Bin2Dec");
        label = new JLabel("nothing entered");
        button =new JButton("convert");

        Input input = new Input();

        button.addActionListener(input);

        text  = new JTextField("Enter up to 8 binary digits", 16);

        output = new JTextArea("Result:");

        JPanel panel = new JPanel();

        Font font = new Font("Monospace", Font.ITALIC, 14);

        text.setFont(font);
        label.setFont(font);

        panel.add(text);
        panel.add(label);
        panel.add(button);
        panel.add(output);

        panel.setLayout(new BorderLayout());
        int width = 1000;
        int height = 500;
        text.setBounds(width/2 -100, 50, 200, 30);
        label.setBounds(width/2 - 100, 100, 500, 30);
        button.setBounds(width/2 + 100, 50, 100, 30);
        output.setBounds(50, 250, width - 100, 30);
        

        frame.add(panel);

        frame.setSize(width, height);

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
        String steps = "";
        int len = charString.length();
        int decimal = 0;
        
        for(int i = 0; i < len; i++) {
            char binaryChar = charString.charAt(i);
            int binaryDigit = Character.getNumericValue(binaryChar);
            int dec = binaryDigit * (int) Math.pow(2,  (len - 1) - i);
            decimal += dec;
            steps += binaryDigit + " * 2^{" + ((len - 1) - i) + "} + "; //from Microsoft Copilot
        }
    
        steps = steps.substring(0, steps.length() - 3); //from Microsoft Copilot
        output.setText(charString + " = " + steps + " = " + decimal);
    
        return decimal;
    }
    
}