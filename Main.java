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
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); 
    }
}
class MyFrame extends JFrame{
    private static final String[] FACES = new String[]{"1", "2", "3",};
    private JLabel label;
    private Counter counter;
    private JTextField textField;

    public MyFrame(String title){
        super(title);

        this.getContentPane().setLayout(new BorderLayout());

        counter = new Counter(); 

        label = new JLabel("" + counter.getValue());
		label.setFont(label.getFont().deriveFont(24.0f));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        this.add(label, BorderLayout.CENTER);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new MyactionListenerReset());
        this.add(resetButton, BorderLayout.PAGE_START);

        JPanel facesPanel = new JPanel();
        GridLayout layout = new GridLayout(0, 3);
        layout.setHgap(3);
        layout.setVgap(1);
        
        facesPanel.setLayout(layout);

        for(String face : FACES){
            facesPanel.add(new JButton(face));
        }
        this.add(facesPanel, BorderLayout.PAGE_END);

        
    }
    class MyactionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            counter.count();
            label.setText("" + counter.getValue());
       }
    }
    class MyactionListenerReset implements ActionListener{
        public void actionPerformed(ActionEvent e){
            counter.reset();
            label.setText("" + counter.getValue());
        }
    }

}
    