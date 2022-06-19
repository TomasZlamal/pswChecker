
package pswChecker;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mainClass{
    private JTextArea input;
    private JTextArea output;
    private JFrame f;
    private g2dClass ge = new g2dClass(71, 70, 71);
    private Timer timer = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String inputProcess = input.getText();
            if(inputProcess.equals("")){
                output.setText("Enter a password to start!");
                f.remove(ge);
                ge = new g2dClass(150, 150, 150);
                f.add(ge);
            }
            else
            {
                String result;
                int passwordScore = 0;
                int passwordMultiplier = 1;
                Pattern reg = Pattern.compile("[^A-Za-z0-9]");
                Matcher m = reg.matcher(inputProcess);
                passwordMultiplier = checkStringHasNum(inputProcess);
                passwordScore = passwordScore + inputProcess.length();
                if(m.find()) passwordMultiplier = passwordMultiplier * 3;
                final int Finalnumber = passwordScore * passwordMultiplier;
                if(Finalnumber == 0) {
                    result = "Enter a password to start!";
                }
                else if(Finalnumber < 30) {
                    result = "Password strength is: very weak";
                    f.remove(ge);
                    ge = new g2dClass(108, 0, 0);
                    f.add(ge);
                }
                else if(Finalnumber < 100){ 
                    result = "Password strength is: weak";
                    f.remove(ge);
                    ge = new g2dClass(195, 0, 20);
                    f.add(ge);
                }
                else if(Finalnumber < 200) {
                    result = "Password strength is: average";
                    f.remove(ge);
                    ge = new g2dClass(186, 87, 20);
                    f.add(ge);
                }
                else if(Finalnumber < 400){
                    result = "Password strength is: strong";
                    f.remove(ge);
                    ge = new g2dClass(17, 187, 20);
                    f.add(ge);
                }
                else if(Finalnumber < 700) {
                    result = "Password strength is: very strong";
                    f.remove(ge);
                    ge = new g2dClass(17, 82, 20);
                    f.add(ge);
                }
                else if(Finalnumber < 1000) {
                    result = "Password strength is: unbreakable";
                    f.remove(ge);
                    ge = new g2dClass(0, 40, 0);
                    f.add(ge);
                }
                else if(Finalnumber >= 1000) {
                    result = "Password strength is: redundantly strong";
                    f.remove(ge);
                    ge = new g2dClass(0, 0, 0);
                    f.add(ge);
                }
                else result = "an error has occured.";
                output.setText(result + ", score: " + Finalnumber);}

    }});
    private static int checkStringHasNum(String str) {
        char ch;
        int multiplier = 1;
        boolean hasFoundNum = false;
        boolean hasFoundUp = false;
        boolean hasFoundDown = false;
        for(int i=0;i < str.length();i++) {
            ch = str.charAt(i);
            if( Character.isDigit(ch) && !hasFoundNum) {
                multiplier = multiplier * 2;
                hasFoundNum = true;
            }
            if (Character.isUpperCase(ch) && !hasFoundUp) {
                multiplier = multiplier * 2;
                hasFoundUp = true;
        }
        if (Character.isLowerCase(ch) && !hasFoundDown) {
            multiplier = multiplier * 2;
            hasFoundDown = true;
        }
        }
        return multiplier;
    }
    public static void main(String[]args){

        mainClass m = new mainClass();
    }
    public mainClass(){
        int width = 500;
        int height = 300;
        input = new JTextArea("Type here!");
        f = new JFrame();
        f.setSize(width, height);
        f.setTitle("Password Checker");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        input.setBounds(90, 121, 300, 25);
        input.setFont(new Font("Courier", Font.BOLD,20));
        f.add(input);
        output = new JTextArea();
        output.setBounds(40, 180, 500, 50);
        output.setEnabled(false);
        output.setOpaque(false);
        output.setBackground(new Color(0,0,0,0));
        output.setForeground(new Color(0, 0, 0));
        output.setFont(new Font("Courier", Font.BOLD,20));
        input.setOpaque(false);
        input.setEnabled(true);
        input.setBackground(new Color(0,0,0,0));
        f.add(output);
        f.add(ge);
        f.setForeground(Color.BLACK);
        f.setVisible(true);
        timer.start();
    }
}