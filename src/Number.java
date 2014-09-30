import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Number extends JFrame {
	JTextArea display = new JTextArea();
	final String[] NUMMER = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "C" };
	final String[] TECKEN = { "+", "-", "*", "/", "=" };
	String op = new String();
	int tal1;
	int tal2;
	int summa;

	Number() {
		super("Räknare");
		setLayout(new BorderLayout());

		JPanel norr = new JPanel();
		add(norr, BorderLayout.NORTH);
		norr.add(display);

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(4, 3));

		KnappLyss kl = new KnappLyss(); // Skapa ett nytt objekt
		for (int x = 0; x < 11; x++) {
			JButton b = new JButton(NUMMER[x]);
			center.add(b);
			b.addActionListener(kl);
		}
		add(center, BorderLayout.CENTER);

		JPanel höger = new JPanel();
		höger.setLayout(new GridLayout(5,1));
		add(höger, BorderLayout.EAST);

		for (int x = 0; x < 5; x++) {
			JButton tecken = new JButton(TECKEN[x]);
			höger.add(tecken);
			tecken.addActionListener(kl);
		}

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocation(350, 400);
		setSize(350, 250);
	}

	public class KnappLyss implements ActionListener {
		public void actionPerformed(ActionEvent ave) {
			JButton b = (JButton) ave.getSource(); // När man tryckt på knappen
													// så anropas denna och tar
													// fram vilken knapp som
													// trycktes
			String str = display.getText();
			String knappText = b.getText();
			if (knappText == "C") {
				str = "";
			} else if (knappText == "+") {
				tal1 = Integer.parseInt(display.getText());
				op = knappText;
				str = "";
			} else if (knappText == "-") {
				tal1 = Integer.parseInt(display.getText());
				op = knappText;
				str = "";
			} else if (knappText == "*") {
				tal1 = Integer.parseInt(display.getText());
				op = knappText;
				str = "";
			} else if (knappText == "/") {
				tal1 = Integer.parseInt(display.getText());
				op = knappText;
				str = "";
			} else if (knappText == "=") {
				tal2 = Integer.parseInt(display.getText());
				if (op == "+") {
					summa = tal1 + tal2;
				} else if (op == "-") {
					summa = tal1 - tal2;
				} else if (op == "*") {
					summa = tal1 * tal2;
				} else if (op == "/") {
					summa = tal1 / tal2;
				}
				str = Integer.toString(summa);
				tal1 = 0;
				tal2 = 0;
			} else {
				str += knappText;
			}
			display.setText(str);
		}
	}

	public static void main(String[] args) {
		Number mini = new Number();
	}

}
