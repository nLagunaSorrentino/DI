package es.studium.TiendecitaCRUD;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Articulos extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args)  
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Articulos frame = new Articulos();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Articulos()
	{
		setLayout(new FlowLayout());
		setTitle("Tiendecita - Artículos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblArtculos = new JLabel("Art\u00EDculos");
		lblArtculos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblArtculos.setBounds(182, 13, 72, 30);
		contentPane.add(lblArtculos);

		JButton btnNewButton = new JButton("Alta");
		btnNewButton.setBounds(32, 79, 103, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new AltaArticulo();

			}
		});
		contentPane.add(btnNewButton);


		JButton btnNewButton_1 = new JButton("Modificaci\u00F3n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new ModificacionArticulo();
			}
		});
		btnNewButton_1.setBounds(295, 79, 103, 30);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Consulta");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new ConsultaArticulos();
				setVisible(false);  //  *
			}
		});
		btnNewButton_2.setBounds(32, 142, 103, 30);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Baja");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new BajaArticulo();
			}
		});
		btnNewButton_3.setBounds(295, 142, 103, 30);
		contentPane.add(btnNewButton_3);

		JButton btnSalir = new JButton("Volver");
		btnSalir.setBounds(323, 215, 97, 25);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				new Tiendecita();
			}
		});

		setVisible(true);
	}
}
