import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class Main{
    public static void main(String[] args) {
        MyFrame frame = new MyFrame("GUI");
        frame.setSize(250, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); 
    }
}

class MyFrame extends JFrame{
    private static final String[] FACES = new String[]{"+1", "+2", "+3",};
    private JLabel label;
    private Counter counter;
    private JButton resetButton, a;
    private JPanel facesPanel;
    private GridLayout layout;

    public MyFrame(String title){
        super(title);

        this.getContentPane().setLayout(new BorderLayout());

        counter = new Counter(); 

        label = new JLabel("" + counter.getValue());
		label.setFont(label.getFont().deriveFont(24.0f));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        this.add(label, BorderLayout.CENTER);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(new MyactionListenerReset());
        this.add(resetButton, BorderLayout.PAGE_START);

        facesPanel = new JPanel();
        layout = new GridLayout(0, 3);
        layout.setHgap(5);
        layout.setVgap(5);
        facesPanel.setLayout(layout);

        for(int i = 0; i<FACES.length; i++){
            a = new JButton(FACES[i]);
            a.addActionListener(new Plus());
            if(i==0){
                a.setActionCommand("1");
            }
            else if(i==1){
                a.setActionCommand("2");
            }
            else if(i==2){
                a.setActionCommand("3");
            }
            facesPanel.add(a);
        }
        this.add(facesPanel, BorderLayout.PAGE_END);  
    }

    class Plus implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String action = e.getActionCommand();
            if(action.equals("1")) {
                counter.count(1);
                label.setText("" + counter.getValue());
            }
            else if(action.equals("2")) {
                counter.count(2);
                label.setText("" + counter.getValue());
            }
            else if(action.equals("3")) {
                counter.count(3);
                label.setText("" + counter.getValue());
            }
        }
    }

    class MyactionListenerReset implements ActionListener{
        public void actionPerformed(ActionEvent e){
            counter.reset();
            label.setText("" + counter.getValue());
        }
    }
}
    