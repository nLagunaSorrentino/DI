package es.studium.TiendecitaCRUD;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class ConsultaArticulos extends JFrame
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
					ConsultaArticulos frame = new ConsultaArticulos();
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
	public ConsultaArticulos()
	{
		setTitle("Tiendecita - Artículos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 66, 408, 2);
		contentPane.add(separator);
		
		JLabel lblArtculos = new JLabel("Precio");
		lblArtculos.setBounds(221, 52, 56, 16);
		contentPane.add(lblArtculos);
		
		JLabel lblTotal = new JLabel("Cantidad");
		lblTotal.setBounds(339, 52, 56, 16);
		contentPane.add(lblTotal);
		
		JLabel lblFecha = new JLabel("Descripci\u00F3n");
		lblFecha.setBounds(89, 52, 76, 16);
		contentPane.add(lblFecha);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(24, 52, 56, 16);
		contentPane.add(lblId);
		
	/*	JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 213, 168, 22);
		comboBox.setEditable(true);
		contentPane.add(comboBox);
		comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar artículo ...", "Folios dinA4", "Carpetas 002 aut", "Lápiz stabilo 202" }));
	*/	
		JLabel lblNewLabel = new JLabel("Consulta");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(175, 23, 76, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(323, 215, 97, 25);
		contentPane.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			setVisible(false);
			new Articulos();
		}
	});
		
	/*	JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(12, 70, 408, 130);
		contentPane.add(textPane);*/
		List list = new List();
		list.setBounds(23, 71, 383, 135);
		contentPane.add(list);
		Connection conexion=conectar(); //Conexión para extraer los select o datos dentro de cada fila de la DB
		Statement stmt;
		try
		{
			stmt = conexion.createStatement();	//query para los select 
			String query = "SELECT * FROM articulos"; 
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next())  // mientras tengamos registros en el resultset
			{
				list.add(rs.getInt("idArticulo")+"                      "+rs.getString("descripcionArticulo")+"                      "+rs.getInt("precioArticulo")+"                      "+rs.getInt("cantidadArticulo"));
			}
			
			stmt.close(); //cerramos los recursos y la conexion
			conexion.close(); //
	//		System.out.println("El alta ha sido realizada correctamente.");
	
		} catch (SQLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		
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