package es.studium.TiendecitaCRUD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class ConsultaTicket extends JFrame
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
					ConsultaTicket frame = new ConsultaTicket();
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
	public ConsultaTicket()
	{
		setTitle("Tiendecita - Tickets");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 66, 408, 2);
		contentPane.add(separator);
		
		JLabel lblArtculos = new JLabel("Art\u00EDculos");
		lblArtculos.setBounds(162, 52, 56, 16);
		contentPane.add(lblArtculos);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(339, 52, 56, 16);
		contentPane.add(lblTotal);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(78, 52, 56, 16);
		contentPane.add(lblFecha);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(24, 52, 56, 16);
		contentPane.add(lblId);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 213, 168, 22);
		comboBox.setEditable(true);
		contentPane.add(comboBox);
		comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar ticket ...", "Folios dinA4", "Carpetas 002 aut", "Lápiz stabilo 202" }));
		
		JLabel lblNewLabel = new JLabel("Consulta");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(175, 23, 76, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(323, 215, 97, 25);
		contentPane.add(btnVolver);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(12, 70, 408, 130);
		contentPane.add(textPane);
		
		
	}
}
