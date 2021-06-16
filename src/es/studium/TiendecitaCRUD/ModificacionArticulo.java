package es.studium.TiendecitaCRUD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ModificacionArticulo extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	Choice choice = new Choice();
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_4;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try {
					ModificacionArticulo frame = new ModificacionArticulo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ModificacionArticulo()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Modificaci\u00F3n");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(138, 11, 87, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Descripci\u00F3n");
		lblNewLabel_1.setBounds(46, 156, 87, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setBounds(46, 181, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Cantidad");
		lblNewLabel_3.setBounds(43, 206, 66, 14);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setBounds(46, 118, 46, 14);
		contentPane.add(lblNewLabel_4);

		textField = new JTextField(); //Descripcion
		textField.setBounds(151, 152, 140, 20);
		contentPane.add(textField);
		textField.setColumns(10);


		textField_1 = new JTextField();
		textField_1.setBounds(151, 183, 140, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(151, 214, 140, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField(); //ID
		textField_3.setBounds(151, 115, 140, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		choice.setBounds(120, 62, 158, 20);
		contentPane.add(choice);

		btnNewButton = new JButton("Modificar");
		btnNewButton.setBounds(317, 157, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ConfirmacionModificacion.main(null);

				//				Connection con = conectar();
				//			//	modificar(con, textField, textField_1, textField_2);
				//				
				//				int id = Integer.parseInt(textField_3.getText());
				//				String descripcion = textField.getText();
				//				int precio = Integer.parseInt(textField_1.getText());
				//				int cantidad = Integer.parseInt(textField_2.getText());
				//				
				//				// Ejecutar el UPDATE
				//				String sqlUpdate = "UPDATE articulos SET descripcionArticulo = '" + descripcion 
				//						+ "', precioArticulo = '" 
				//						+ precio + "', cantidadArticulo = '" + cantidad
				//						+ "'  WHERE idArticulo = '" + id + "'";
				//				System.out.println(sqlUpdate);
				//				setVisible(false);
				//				//		frmEditar.setVisible(true);
				//				try
				//				{
				//					// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
				//					Statement stmt = con.createStatement();
				//					stmt.executeUpdate(sqlUpdate);
				//					System.out.println("Actualizacion completada correctamente...");
				//					stmt.close();
				//				} catch (SQLException ex)
				//				{
				//					System.out.println("ERROR:al modificar");
				//					ex.printStackTrace();
				//				}
				//
			}


		});

		btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.setBounds(317, 213, 89, 23);
		contentPane.add(btnNewButton_1);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);

			}
		});


		choice.add("Selecciona un artículo");

		choice.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie){
				Object fuente = ie.getItem();
				if(fuente.equals(choice.getSelectedItem())) {

					Connection conect = conectar();
					// Sacar el id del elemento elegido
					int id = Integer.parseInt(choice.getSelectedItem().split("-")[0]);
					mostrarDatos(conect, id);	
					// textField.setText(choice.getSelectedItem());



				}else {
					textField.setText("");
				}

			}
		});

		// Conectar a la base de datos
		Connection con = conectar();
		// Sacar los datos de la tabla edificios
		// Rellenar el Choice
		String sqlSelect = "SELECT * FROM articulos";
		try
		{
			// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
			while (rs.next())
			{
				choice.add(rs.getInt("idArticulo") + "-" + rs.getString("descripcionArticulo") + ", "
						+ rs.getInt("precioArticulo") + "-" + rs.getInt("cantidadArticulo"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException ex)
		{
			System.out.println("ERROR:al consultar");
			ex.printStackTrace();
		}



	}




	public Connection conectar()
	{
		String DB_URL = "jdbc:mysql://localhost:3306/tiendecita?serverTimezone=GMT"; //conexion con mysql
		String DB_USER = "root";  // root y pass necesarios para acceder a datos (luego entraremos con un admin o usuario ya creado)
		String DB_PASS = "grupostudium;";

		Connection conexion = null;
		//	try
		//{
		//		Class.forName("com.mysql.cj.jdbc.Driver");
		//		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block



			//e.printStackTrace();
		}
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

	public void mostrarDatos(Connection con, int id)
	{
		String sqlSelect = "SELECT * FROM articulos WHERE idArticulo = " + id;
		try
		{

			// Creamos un STATEMENT para una consulta SQL INSERT.
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(sqlSelect);
			while (rs.next())
			{
				String idTxt = rs.getString("idArticulo");
				textField_3.setText((idTxt));				
				String descripcion = rs.getString("descripcionArticulo");
				textField.setText((descripcion));
				String precio = rs.getString("precioArticulo");
				textField_1.setText((precio));
				String cantidad = rs.getString("cantidadArticulo");
				textField_2.setText((cantidad));

			}
			sta.close();
			con.close();
		} catch (SQLException ex)
		{
			System.out.println("ERROR:al hacer un Delete");
			ex.printStackTrace();
		}


		try {

			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//	public void modificar(Connection con,JTextField campo_id ,JTextField campo_2,JTextField campo_3,JTextField campo_4) {
	//
	//		int id = Integer.parseInt(campo_id.getText());
	//		String descripcion = campo_2.getText();
	//		int precio = Integer.parseInt(campo_3.getText());
	//		int cantidad = Integer.parseInt(campo_4.getText());
	//
	//		// Ejecutar el UPDATE
	//		String sqlUpdate = "UPDATE articulos SET descripcionArticulo = '" + descripcion 
	//				+ "', precioArticulo = '" 
	//				+ precio + "', cantidadArticulo = '" + cantidad
	//				+ "'  WHERE idArticulo = '" + id + "'";
	//		System.out.println(sqlUpdate);
	//		setVisible(false);
	//		//		frmEditar.setVisible(true);
	//		try
	//		{
	//			// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
	//			Statement stmt = con.createStatement();
	//			stmt.executeUpdate(sqlUpdate);
	//			System.out.println("Actualizacion completada correctamente...");
	//			stmt.close();
	//		} catch (SQLException ex)
	//		{
	//			System.out.println("ERROR:al modificar");
	//			ex.printStackTrace();
	//		}
	//
	//	}
}