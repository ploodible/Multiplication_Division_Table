import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Practical extends JFrame implements ActionListener{
JFrame jf = new JFrame();
Container cp = jf.getContentPane();
JLabel mod = new JLabel("Enter the multiplier/divisor:");
JTextField muldiv = new JTextField(4);
JLabel sums = new JLabel("Enter number of sums:");
JTextField nSums = new JTextField(4);
JTextArea Table = new JTextArea("", 15, 45);
JButton randButton = new JButton("Randomise");
JRadioButton mul = new JRadioButton("Multiplication");
JRadioButton div = new JRadioButton("Division");
ButtonGroup group = new ButtonGroup();
JButton fillButton = new JButton("Fill table");
JButton clearButton = new JButton("Clear table");
JPanel Jtop = new JPanel();
JPanel Jmid = new JPanel();
JPanel JBot = new JPanel(); 
JPanel JRadioPanel = new JPanel();
JPanel jButtonPanel = new JPanel();
JPanel JTextPanel = new JPanel();
JPanel spacingPanel = new JPanel();
JPanel JBorderbot = new JPanel();
public int flag = 1;
public Integer rMod, rSums;
BoxLayout LM = new BoxLayout(cp, BoxLayout.PAGE_AXIS);

    public static void main(String[] args) {
        Practical prac = new Practical("Division and Multiplication Table");        
    }

    void createTable(Integer i, Integer j)
    {
        int k=1;
        if(Table.getText()!="")
        {
            Table.setText("");
        }
        if(flag==1)
        {
            while(k!=j+1)
            {  
                //System.out.println(k);
                Table.append(k + "x" + i + "=" + k*i + "\n");
                k++;
            }
        }
        else
        {
            if(rMod==0)
            {
                Table.setText("Invalid divisor value: Zero may not be used as a divisor.");
            }
            else
            {
                while(k!=j+1)
                {  
                    //System.out.println(k);
                    Table.append(i*k + "/" + i + "=" + k + "\n");
                    k++;   
                }
            }  
        }   
        
    }

    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() instanceof JButton)
        {
        JButton source = (JButton) evt.getSource();
            if(source.getText() == "Randomise")
            {
                //Table.setText("Random");
                Random r1 = new Random();
                Random r2 = new Random();
                rMod = r1.nextInt((12-2)+1)+2;
                rSums = r2.nextInt((12-2)+1)+2;
                muldiv.setText(rMod.toString());
                nSums.setText(rSums.toString());     
            }
            else if(source.getText() == "Fill table")
            {
                //Table.setText("Fill");
                rMod = Integer.parseInt(muldiv.getText());
                rSums = Integer.parseInt(nSums.getText());
                createTable(rMod, rSums);

            }
            else if(source.getText() == "Clear table")
            {
                //Table.setText("Clear");
                Table.setText("");
            }
        }
        else {
            JRadioButton source = (JRadioButton) evt.getSource();
            if(source.getText() == "Multiplication")
            {
                //Table.setText("Multiply");
                flag = 1;
            }
            else if(source.getText() == "Division")
            {
                //Table.setText("Divide");
                flag = 0;
            }
        }
    }

    Practical(String title){

        jf.setTitle(title);
        jf.setSize(670,380);
        jf.setLocation(725, 350);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);

        cp.setLayout(LM);

        cp.add(Jtop);
        Jtop.setLayout(new FlowLayout(FlowLayout.CENTER));
        Jtop.add(mod);
        Jtop.add(Box.createRigidArea(new Dimension(10, 0)));
        Jtop.add(muldiv);
        Jtop.add(Box.createRigidArea(new Dimension(10, 0)));
        Jtop.add(sums);
        Jtop.add(Box.createRigidArea(new Dimension(10, 0)));
        Jtop.add(nSums);
        Jtop.add(Box.createRigidArea(new Dimension(10, 0)));
        Jtop.add(randButton);

        cp.add(Jmid);
        Jmid.add(JTextPanel);
        Jmid.add(JRadioPanel);
        JRadioPanel.setLayout(new BoxLayout(JRadioPanel, BoxLayout.PAGE_AXIS));
        JTextPanel.add(Table);
        JRadioPanel.add(mul);
        JRadioPanel.add(div);
        mul.setSelected(true);
        group.add(mul);
        group.add(div);

        cp.add(JBot);
        JBot.setLayout(new BoxLayout(JBot, BoxLayout.LINE_AXIS));
        JBot.add(fillButton);
        JBot.add(Box.createRigidArea(new Dimension(20, 0)));
        JBot.add(clearButton);

        cp.add(JBorderbot);                                                                 //    This is to make the spacing 
        JBorderbot.add(Box.createRigidArea(new Dimension(100, 0)));           //    more similar to the given GUI

        randButton.addActionListener(this);
        fillButton.addActionListener(this);
        clearButton.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        jf.setVisible(true);


    }


    }
