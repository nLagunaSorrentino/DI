package es.studium.TiendecitaCRUD;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JButton;

public class BajaArticulo extends JFrame
{

	private JPanel contentPane;
	public Choice choice = new Choice();
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
					BajaArticulo frame = new BajaArticulo();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}


	public BajaArticulo()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBajaArtculos = new JLabel("Baja Art\u00EDculos");
		lblBajaArtculos.setBounds(175, 13, 98, 16);
		contentPane.add(lblBajaArtculos);

	//	Choice choice = new Choice();
		choice.setBounds(151, 96, 154, 22);
		contentPane.add(choice);
		Connection conexion=conectar(); //Conexión para extraer los select o datos dentro de cada fila de la DB
		Statement stmt;
		try
		{
			stmt = conexion.createStatement();	//query para los select 
			String query = "SELECT * FROM articulos"; 
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next())  // mientras tengamos registros en el resultset
			{
//				choice.add(rs.getString("descripcionArticulo"));
				choice.add(rs.getInt("idArticulo")+"");
			}
			rs.close();
			stmt.close(); //cerramos los recursos y la conexion
			conexion.close(); //
			//		System.out.println("El alta ha sido realizada correctamente.");

		} catch (SQLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	

		JLabel lblArticulo = new JLabel("Articulo");
		lblArticulo.setBounds(78, 96, 56, 16);
		contentPane.add(lblArticulo);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(323, 215, 97, 25);
		contentPane.add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);

			}
		});

		JButton btnDarDeBaja = new JButton("Dar de baja");
		btnDarDeBaja.setBounds(173, 154, 122, 25);
		contentPane.add(btnDarDeBaja);
		btnDarDeBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				new ConfirmarBaja();

			}
		});


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
