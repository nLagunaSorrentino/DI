package es.studium.TiendecitaCRUD;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;


public class Tiendecita extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static Tiendecita frame = new Tiendecita();

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
	//				Tiendecita frame = new Tiendecita();
					frame.setVisible(true);  // *
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
	public Tiendecita()
	{
		setTitle("Tiendecita - Men\u00FA Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMenPrincipal = new JLabel("Men\u00FA Principal");
		lblMenPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMenPrincipal.setBounds(159, 13, 115, 31);
		panel.add(lblMenPrincipal);
		
		JButton btnNewButton = new JButton("Art\u00EDculos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);  //  *
				new Articulos();
				
			}
		});
		btnNewButton.setBounds(80, 112, 97, 25);
		panel.add(btnNewButton);
		
		JButton btnTickets = new JButton("Tickets");
		btnTickets.setBounds(245, 112, 97, 25);
		panel.add(btnTickets);
		btnTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);  //  *
				new Tickets();
			
			}
		});
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(313, 205, 97, 25);
		panel.add(btnNewButton_1);
		
		setVisible(true);
	}
}
