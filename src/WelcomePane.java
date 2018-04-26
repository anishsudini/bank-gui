import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePane extends JPanel
{
	
	public WelcomePane()
	{
		setSize(400, 300);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblWelcome = new JLabel("Welcome to the Bank Account Mangement System");
		lblWelcome.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblWelcome.setForeground(Color.WHITE);
		add(lblWelcome, gbc);
		
		BufferedImage bankjpg = null;
		
		try
		{
			bankjpg = ImageIO.read(new File("Bank Picture.jpg"));
		}
		
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		
		JLabel lblHome = new JLabel(new ImageIcon(bankjpg));
		add(lblHome, gbc);
	}
	

}
