package es.studium.TiendecitaCRUD;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Tickets extends JFrame
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Tickets frame = new Tickets();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tickets()
	{
		setTitle("Tiendecita - Tickets");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArtculos = new JLabel("Tickets");
		lblArtculos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblArtculos.setBounds(182, 13, 72, 30);
		contentPane.add(lblArtculos);
		
		JButton btnNewButton = new JButton("Alta");
		btnNewButton.setBounds(58, 111, 103, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Consulta");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(267, 111, 103, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnSalir = new JButton("Volver");
		btnSalir.setBounds(323, 215, 97, 25);
		contentPane.add(btnSalir);
	}
}
