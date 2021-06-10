package es.studium.TiendecitaCRUD;


import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class AltaArticulo extends JFrame
{

	private JPanel contentPane;
	private JTextField textField; //descripcion
	private JTextField textField_1; // precio
	private JTextField textField_2; //cantidad
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
					AltaArticulo frame = new AltaArticulo();
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
	public AltaArticulo()
	{
		setTitle("Tiendecita - Artículos");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblArtculos = new JLabel("Alta");
		lblArtculos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblArtculos.setBounds(190, 13, 39, 30);
		contentPane.add(lblArtculos);

		JButton btnNewButton = new JButton("Alta");    // Conexion Altas
		btnNewButton.setBounds(164, 198, 103, 30);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{

				Connection conexion=conectar(); //Conexión para extraer los inserts o datos dentro de cada fila de la DB
				Statement stmt;
				try
				{
					stmt = conexion.createStatement();	//query para los inserts 
					String query = "INSERT INTO articulos VALUES(null,'"+textField.getText()+"','" + Integer.parseInt(textField_1.getText())+"','" + Integer.parseInt(textField_2.getText())+"');"; 
					stmt.executeUpdate(query);
					stmt.close(); //cerramos los recursos y la conexion
					conexion.close(); //
					System.out.println("El alta ha sido realizada correctamente.");
					new ConfirmacionAlta();
				} catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});

		JButton btnSalir = new JButton("Volver");
		btnSalir.setBounds(323, 215, 97, 25);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);

			}
		});
		//textfield descripcion
		textField = new JTextField();
		textField.setBounds(116, 83, 192, 22);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Descripci\u00F3n");
		lblNewLabel.setBounds(32, 86, 79, 16);
		contentPane.add(lblNewLabel);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(32, 115, 79, 16);
		contentPane.add(lblPrecio);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(116, 112, 192, 22);
		contentPane.add(textField_1);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(32, 147, 79, 16);
		contentPane.add(lblCantidad);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(116, 144, 192, 22);
		contentPane.add(textField_2);

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

