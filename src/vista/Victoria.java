package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Victoria extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JuegoGrafico jg;
	public boolean volverJugar = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Victoria dialog = new Victoria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Victoria() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel gifVictoria = new JLabel("");
		gifVictoria.setBounds(61, 13, 342, 147);
		gifVictoria.setIcon(new ImageIcon("F:\\Primero\\Programacion\\Proyectos\\JuegoParejas\\src\\imagenes\\victoria.gif"));
		contentPanel.add(gifVictoria);
		JButton reinicio = new JButton("Volver a jugar");
		reinicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				volverJugar = true;
				setVisible(false);
			}
		});
		reinicio.setBounds(73, 192, 140, 34);
		contentPanel.add(reinicio);
		
		JButton cerrar = new JButton("Cerrar");
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volverJugar = false;
				setVisible(false);
			}
		});
		cerrar.setBounds(225, 192, 140, 34);
		contentPanel.add(cerrar);
	}
}
