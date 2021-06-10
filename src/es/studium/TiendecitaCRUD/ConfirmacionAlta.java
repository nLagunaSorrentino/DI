package es.studium.TiendecitaCRUD;



import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmacionAlta extends JDialog
{

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			ConfirmacionAlta dialog = new ConfirmacionAlta();
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
	public ConfirmacionAlta()
	{
		setBounds(100, 100, 450, 238);
		getContentPane().setLayout(null);
		{
			setTitle("Alta realizada");
	//		setLayout(new FlowLayout());
			JButton okButton = new JButton("Aceptar");
			okButton.setBounds(302, 129, 94, 39);
			getContentPane().add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
			okButton.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					setVisible(false);				
				}
			});
		}
		{
			JLabel lblNewLabel = new JLabel("El registro ha sido dado de alta \r\ncorrectamente.");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel.setBounds(42, 36, 354, 88);
			getContentPane().add(lblNewLabel);
		}
		setVisible(true);
	}

}
