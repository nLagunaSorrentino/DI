package es.studium.TiendecitaCRUD;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BajaRealizada extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			BajaRealizada dialog = new BajaRealizada();
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
	public BajaRealizada()
	{
		setBounds(100, 100, 450, 238);
		getContentPane().setLayout(null);
		{
			setTitle("Baja realizada");
			JButton okButton = new JButton("Aceptar");
			okButton.setBounds(302, 129, 94, 39);
			getContentPane().add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					setVisible(false);

				}
			});
		}
		{
			JLabel lblNewLabel = new JLabel("El registro se ha dado de baja \r\ncorrectamente.");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel.setBounds(46, 36, 337, 88);
			getContentPane().add(lblNewLabel);
		}
		setVisible(true);
	}

}
