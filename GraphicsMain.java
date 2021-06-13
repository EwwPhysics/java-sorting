import javax.swing.JFrame;
import javax.swing.JPanel;


public class GraphicsMain extends JFrame{
        public static void main(String[] args) {
          GraphicsMain window = new GraphicsMain();
          JPanel panel = new JPanel();
          panel.add(new Sorting());
          window.setTitle("Sorting Visualization");
          window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          window.setContentPane(panel);
          window.pack();
          window.setLocationRelativeTo(null);
          window.setVisible(true);
      }
}
