package es.studium.TiendecitaCRUD;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class AltaTicket extends JFrame
{

	private JPanel contentPane;
	private TextField textField_1;
	private TextField textField_2;

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
					AltaTicket frame = new AltaTicket();
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
	public AltaTicket()
	{
		setTitle("Tiendecita - Tickets");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnSalir = new JButton("Volver");
		btnSalir.setBounds(323, 215, 97, 25);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				new Tickets();

			}
		});
		
		JLabel lblNewLabel = new JLabel("Fecha");
		lblNewLabel.setBounds(32, 86, 79, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblPrecio = new JLabel("Art\u00EDculos");
		lblPrecio.setBounds(32, 115, 79, 16);
		contentPane.add(lblPrecio);
		
		TextField txtFecha = new TextField();  // campo para fecha ticket
		txtFecha.setBounds(116, 82, 192, 22);
		contentPane.add(txtFecha);
		
		textField_1 = new TextField();  // campo para articulos
		textField_1.setColumns(10);
		textField_1.setBounds(116, 112, 192, 22);
		contentPane.add(textField_1);
		
		JLabel lblCantidad = new JLabel("Total");
		lblCantidad.setBounds(32, 147, 79, 16);
		contentPane.add(lblCantidad);
		
		textField_2 = new TextField();  // campo para el total
		textField_2.setColumns(10);
		textField_2.setBounds(116, 144, 192, 22);
		contentPane.add(textField_2);
		
		JLabel lblArtculos = new JLabel("Alta");
		lblArtculos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblArtculos.setBounds(190, 13, 39, 30);
		contentPane.add(lblArtculos);
		
		JButton btnNewButton = new JButton("Alta");
		btnNewButton.setBounds(164, 198, 103, 30);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 					//REVISAR LA QUERY Y LA CONEXION !
			{

				Connection conexion=conectar(); //Conexión para extraer los inserts o datos dentro de cada fila de la DB
				Statement stmt;
				try
				{
					stmt = conexion.createStatement();	//query para los inserts 
				String query = "INSERT INTO tickets VALUES(null,'"+txtFecha.getText()+"','" +textField_1.getText()+"','" + Integer.parseInt(textField_2.getText())+"');"; 
					stmt.executeUpdate(query);
					stmt.close(); //cerramos los recursos y la conexion
					conexion.close(); //
					System.out.println("El alta del ticket ha sido realizada correctamente.");
					new ConfirmacionAlta();
				} catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		}); 

		
		
		
	/*	JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setToolTipText("");
		comboBox.setBounds(116, 83, 39, 22);
		contentPane.add(comboBox);
		comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4..." }));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("");
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(164, 83, 66, 22);
		contentPane.add(comboBox_1);
		comboBox_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4","5","6","7","8","9","10","11","12" }));
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setToolTipText("");
		comboBox_2.setEditable(true);
		comboBox_2.setBounds(242, 83, 66, 22);
		contentPane.add(comboBox_2);
		comboBox_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2021", "2020", "2019", "2018" }));*/
		
		
		setVisible(true);
	}
	
	public Connection conectar()
	{
		String DB_URL = "jdbc:mysql://localhost:3306/tiendecita?serverTimezone=GMT"; //conexion con mysql
		String DB_USER = "root";  // root y pass necesarios para acceder a datos (luego entraremos con un admin o usuario ya creado)
		String DB_PASS = "grupostudium";

		Connection conexion = null;
//		try
//		{
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try
		{
			conexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			System.out.println("La conexión se ha realizado correctamente.");
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("La conexión no se ha realizado correctamente.");
		}
		return conexion;
	}
}
