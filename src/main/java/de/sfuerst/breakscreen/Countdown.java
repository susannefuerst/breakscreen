package main.java.de.sfuerst.breakscreen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.WindowConstants;


@SuppressWarnings("serial")
public class Countdown extends JFrame {
 
  // Countdown mit 42 Sekunden
  public static int counterValue = 42;
  public static Timer timer;
  public static JLabel label;
 
  public Countdown() {
    initGUI();
  }
 
  // GUI-Erzeugen
  private void initGUI(){
    BorderLayout thisLayout = new BorderLayout();
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    this.getContentPane().setLayout(thisLayout);
    label = new JLabel();
    label.setText(String.valueOf(counterValue));
    this.getContentPane().add(label, BorderLayout.CENTER);
    this.setTitle("Countdown Example");
      this.pack();
      this.setVisible(true);
  }
 

  public static void main(String[] args) {
    // GUI erzeugen
    new Countdown();
   
    // Timer erzeugen, jede 1000 Millisekunden (= 1 Sekunde)
    // Methode actionPerformed aufrufen.
    Countdown.timer = new Timer(1000, new ActionListener() {
     
      public void actionPerformed(ActionEvent e) {
        // 1 Sekunde abziehen
        Countdown.counterValue--;
       
        // Zahl in Label darstellen
        Countdown.label.setText(String.valueOf(counterValue));
       
        // Falls Zähler = 0, Countdown abgelaufen!
        if(Countdown.counterValue == 0){
          System.out.println("Counterdown ausgelaufen!");
         
          // Timer stoppen
          Countdown.timer.stop();
        }
      }
    });
       
    // Timer starten
    timer.start();
  }
}
