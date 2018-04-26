import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteAccountPane extends JPanel
{
	ArrayList <BankAccount> accounts;
	
	private static boolean isInteger(String str)
	{
		try
		{
			Integer.parseInt(str);
			return true;
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
	}
	
	public DeleteAccountPane(ArrayList <BankAccount> a)
	{
		accounts = a;
		
		setSize(400, 300);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblAccNum = new JLabel("Account Number: ");
		add(lblAccNum, gbc);
		
		gbc.gridx++;
		JTextField txtAccNum = new JTextField();
		txtAccNum.setPreferredSize(new Dimension(80, 30));
		add(txtAccNum, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		JButton remove = new JButton("Delete");
		remove.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				if(txtAccNum.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Enter an Account Number");
					txtAccNum.setText("");
				}
				
				if(accounts.size() == 0)
				{
					JOptionPane.showMessageDialog(null, "Please Create At-Least One Account");
					txtAccNum.setText("");
				}
				
				int accNum = Integer.parseInt(txtAccNum.getText());
				
				for(int i = 0; i < accounts.size(); i++)
				{
					if(accounts.get(i).getAccountNumber() == accNum)
					{
						accounts.remove(i);
						JOptionPane.showMessageDialog(txtAccNum, "Account Removed Successfully");
						txtAccNum.setText("");
					}
					
					else if(accounts.get(i).getAccountNumber() != accNum)
					{
						JOptionPane.showMessageDialog(txtAccNum, "Account Doesn't Exist");
						txtAccNum.setText("");
					}
				}
				
			}
			
		});
		add(remove, gbc);
	}

}
