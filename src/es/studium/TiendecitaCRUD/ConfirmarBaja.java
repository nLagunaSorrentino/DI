package es.studium.TiendecitaCRUD;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ConfirmarBaja extends JDialog
{


	BajaArticulo baja = new BajaArticulo();
	
	public static void main(String[] args)
	{
		try
		{
			ConfirmarBaja dialog = new ConfirmarBaja();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfirmarBaja()
	{
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
		setTitle("Confirmar baja");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00BFEst\u00E1 seguro/a de que desea");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(90, 59, 231, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblAplicarEstasModificaciones = new JLabel("dar de baja este registro?");
		lblAplicarEstasModificaciones.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAplicarEstasModificaciones.setBounds(90, 78, 231, 23);
		getContentPane().add(lblAplicarEstasModificaciones);
		
		JLabel lblLaInformacinAnterior = new JLabel("La informaci\u00F3n no se podr\u00E1 recuperar.");
		lblLaInformacinAnterior.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLaInformacinAnterior.setBounds(90, 114, 259, 30);
		getContentPane().add(lblLaInformacinAnterior);
		{
			JButton okButton = new JButton("Aceptar");
			okButton.setBounds(238, 173, 96, 38);
			getContentPane().add(okButton);
			okButton.setActionCommand("Aceptar");
			getRootPane().setDefaultButton(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
			Connection conexion=conectar(); //Conexión para extraer los select o datos dentro de cada fila de la DB
			Statement stmt;
			try
			{
				
				stmt = conexion.createStatement();	//query para los select 
				String query = "DELETE FROM articulos WHERE idArticulo = "+ baja.choice.getSelectedItem();
				stmt.executeUpdate(query);
				System.out.println(query);
				stmt.close(); //cerramos los recursos y la conexion
				conexion.close(); //
				System.out.println("La baja ha sido realizada correctamente.");
				new BajaRealizada();
				setVisible(false);

			} catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
				}
			});
		}
		{
			JButton cancelButton = new JButton("Cancelar");
			cancelButton.setBounds(90, 173, 96, 38);
			getContentPane().add(cancelButton);
			cancelButton.setActionCommand("Cancelar");
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
