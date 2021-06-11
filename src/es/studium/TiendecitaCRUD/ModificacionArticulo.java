package es.studium.TiendecitaCRUD;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPopupMenu;

import java.awt.Choice;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;


public class ModificacionArticulo extends JFrame
{


	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	Choice choice = new Choice();
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ModificacionArticulo frame = new ModificacionArticulo();
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
	public ModificacionArticulo()
	{
		setTitle("Tiendecita - Artículos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArtculos = new JLabel("Modificación");
		lblArtculos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblArtculos.setBounds(170, 13, 97, 30);
		contentPane.add(lblArtculos);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.setBounds(164, 198, 103, 30);
		contentPane.add(btnNewButton);
		
		JButton btnSalir = new JButton("Volver");
		btnSalir.setBounds(323, 215, 97, 25);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				new Articulos();
			}
		});
		
		textField = new JTextField("");  //descripcion
		textField.setBounds(116, 83, 192, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		choice.setBounds(114, 45, 217, 22);
		contentPane.add(choice);
		textField.setText(choice.getSelectedItem());
		choice.addItemListener(new ItemListener(){
			  public void itemStateChanged(ItemEvent ie){

			    textField.setText(choice.getSelectedItem());
			  }
			});
		
		JLabel lblNewLabel = new JLabel("Descripci\u00F3n");
		lblNewLabel.setBounds(32, 86, 79, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(32, 115, 79, 16);
		contentPane.add(lblPrecio);
		
		textField_1 = new JTextField("");  //  precio
		textField_1.setColumns(10);
		textField_1.setBounds(116, 112, 192, 22);
		contentPane.add(textField_1);
		textField_1.setText(choice.getSelectedItem());
		choice.addItemListener(new ItemListener(){
			  public void itemStateChanged(ItemEvent ie){

			    textField_1.setText(choice.getSelectedItem());
			  }
			});
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(32, 147, 79, 16);
		contentPane.add(lblCantidad);
		
		textField_2 = new JTextField(104);  //cantidad
		textField_2.setColumns(10);
		textField_2.setBounds(116, 144, 192, 22);
		contentPane.add(textField_2);
		textField_2.setText(choice.getSelectedItem());
		choice.addItemListener(new ItemListener(){
			  public void itemStateChanged(ItemEvent ie){

			    textField_2.setText(choice.getSelectedItem());
			  }
			});
		
		// un desplegable en el que el usuario podrá escribir para buscar en el CRUD
	/*	JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(116, 45, 192, 22);
		contentPane.add(comboBox);
//		comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar artículo ...", "Folios dinA4", "Carpetas 002 aut", "Lápiz stabilo 202" }));
	*/	
		
	
		Connection conexion=conectar(); //Conexión para extraer los inserts o datos dentro de cada fila de la DB
		Statement stmt;
		try
		{
			stmt = conexion.createStatement();	//query para los inserts 
			String query = "SELECT * FROM articulos"; 
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next())  // mientras tengamos registros en el resultset
			{
				choice.add(rs.getInt("idArticulo")+"-"+rs.getString("descripcionArticulo")+","+rs.getInt("cantidadArticulo")+","+rs.getInt("precioArticulo"));
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
/*	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}*/
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
