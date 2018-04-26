import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DepositPane extends JPanel
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
	
	private static boolean isNumeric(String str)
	{
		try
		{
			Double.parseDouble(str);
			return true;
		}
		
		catch(IllegalArgumentException e)
		{
			return false;
		}
	}
	
	public DepositPane(ArrayList <BankAccount> a)
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
		JLabel lblDeposit = new JLabel("Deposit Amount: ");
		add(lblDeposit, gbc);
		
		gbc.gridx++;
		JTextField txtDeposit = new JTextField();
		txtDeposit.setPreferredSize(new Dimension(80, 30));
		add(txtDeposit, gbc);
		

		gbc.gridx = 0;
		gbc.gridy++;
		JButton add = new JButton("Complete Transaction");
		add.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				double OVER_DRAFT_FEE = 15;
				double rate = 0.0025; 
				double TRANSACTION_FEE = 1.5; 
				double MIN_BAL = 300;
				double MIN_BAL_FEE = 10;
				int FREE_TRANSACTION = 10;
				
				String strAccNum = txtAccNum.getText();
				
				if(!isInteger(strAccNum))
				{
					JOptionPane.showMessageDialog(null, "Please Enter a Valid Account Number");
					txtAccNum.setText("");
					txtDeposit.setText("");
				}
				
				String strDeposit = txtDeposit.getText();
				
				if(!isNumeric(strDeposit))
				{
					JOptionPane.showMessageDialog(null, "Please Enter a Valid Amount");
					txtAccNum.setText("");
					txtDeposit.setText("");
				}
				
				if(accounts.size() == 0)
				{
					JOptionPane.showMessageDialog(null, "Please Create At-Least One Account");
					txtAccNum.setText("");
					txtDeposit.setText("");
				}
				
				int accNum = Integer.parseInt(txtAccNum.getText());
				double deposit = Double.parseDouble(txtDeposit.getText());
				
				BankAccount tempAccount = null;
				
				for(int i = 0; i < accounts.size(); i++)
				{
					if(accounts.get(i).getAccountNumber() == accNum)
					{		
						tempAccount = accounts.get(i);
						
						try
						{
							tempAccount.deposit(deposit);
							JOptionPane.showMessageDialog(null, "Deposit Successful");
							txtAccNum.setText("");
							txtDeposit.setText("");
						}
						
						catch(IllegalArgumentException a)
						{                                                                                                                                                                                                                                                                                     
							JOptionPane.showMessageDialog(null, "Deposit Failed"); 
							txtAccNum.setText("");
							txtDeposit.setText("");
						}
					}
				}
				
				
			}
			
		});
		add(add, gbc);
	}

}
