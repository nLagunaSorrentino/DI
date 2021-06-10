package es.studium.TiendecitaCRUD;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;

public class ConfirmacionModificacion extends JDialog
{

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			ConfirmacionModificacion dialog = new ConfirmacionModificacion();
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
	public ConfirmacionModificacion()
	{
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
		setTitle("Confirmar modificación");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00BFEst\u00E1 seguro/a de que desea");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(90, 59, 231, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblAplicarEstasModificaciones = new JLabel("aplicar estas modificaciones?");
		lblAplicarEstasModificaciones.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAplicarEstasModificaciones.setBounds(90, 78, 231, 23);
		getContentPane().add(lblAplicarEstasModificaciones);
		
		JLabel lblLaInformacinAnterior = new JLabel("La informaci\u00F3n anterior se perder\u00E1.");
		lblLaInformacinAnterior.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLaInformacinAnterior.setBounds(90, 114, 243, 16);
		getContentPane().add(lblLaInformacinAnterior);
		{
			JButton okButton = new JButton("Aceptar");
			okButton.setBounds(220, 173, 83, 38);
			getContentPane().add(okButton);
			okButton.setActionCommand("Aceptar");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancelar");
			cancelButton.setBounds(111, 173, 83, 38);
			getContentPane().add(cancelButton);
			cancelButton.setActionCommand("Cancelar");
		}
	}
}
