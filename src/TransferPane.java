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

public class TransferPane extends JPanel
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
	
	public TransferPane(ArrayList <BankAccount> a)
	{
		accounts = a;
		
		setSize(400, 300);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblAccNum = new JLabel("Depositing Account Number: ");
		add(lblAccNum, gbc);
		
		gbc.gridx++;
		JTextField txtAccNum = new JTextField();
		txtAccNum.setPreferredSize(new Dimension(80, 30));
		add(txtAccNum, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		JLabel lblAccNum1 = new JLabel("Withdrawing Account Number: ");
		add(lblAccNum1, gbc);
		
		gbc.gridx++;
		JTextField txtAccNum1 = new JTextField();
		txtAccNum1.setPreferredSize(new Dimension(80, 30));
		add(txtAccNum1, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		JLabel lblTransfer = new JLabel("Transfer Amount: ");
		add(lblTransfer, gbc);
		
		gbc.gridx++;
		JTextField txtTransfer = new JTextField();
		txtTransfer.setPreferredSize(new Dimension(80, 30));
		add(txtTransfer, gbc);
		
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
				
				if(accounts.size() < 2)
				{
					JOptionPane.showMessageDialog(null , "Transfer Not Possible Please Create At-Least 2 Accounts");
					txtAccNum.setText("");
					txtAccNum1.setText("");
					txtTransfer.setText("");
				}
				
				String strAccNum = txtAccNum.getText();
				String strAccNum1 = txtAccNum1.getText();
				
				if(!isInteger(strAccNum) || !isInteger(strAccNum1))
				{
					JOptionPane.showMessageDialog(null, "Please Enter Valid Account Numbers");
					txtAccNum.setText("");
					txtAccNum1.setText("");
					txtTransfer.setText("");
				}
				
				String strDeposit = txtTransfer.getText();
				
				if(!isNumeric(strDeposit))
				{
					JOptionPane.showMessageDialog(null, "Please Enter a Valid Amount");
					txtAccNum.setText("");
					txtAccNum1.setText("");
					txtTransfer.setText("");
				}
				
				int accNum = Integer.parseInt(txtAccNum.getText());
				int accNum1 = Integer.parseInt(txtAccNum1.getText());
				double amount = Double.parseDouble(txtTransfer.getText());
				
				BankAccount tempAccount = null;
				
				BankAccount tempAccount1 = null;
				
				for(int i = 0; i < accounts.size(); i++)
				{
					if(accounts.get(i).getAccountNumber() == accNum)
					{		
						tempAccount = accounts.get(i);
						
						for(int j = 0; j < accounts.size(); j++)
						{
							if(accounts.get(j).getAccountNumber() == accNum1)
							{
								tempAccount1 = accounts.get(j);
								
								try
								{
									tempAccount1.transfer(tempAccount, amount);
									JOptionPane.showMessageDialog(null, "Transfer Successful");
									txtAccNum.setText("");
									txtAccNum1.setText("");
									txtTransfer.setText("");
								}
								
								catch(IllegalArgumentException a)
								{
									JOptionPane.showMessageDialog(null, "Transfer Failed");
									txtAccNum.setText("");
									txtAccNum1.setText("");
									txtTransfer.setText("");
								}
							}
						}
					}
				}
			}
			
		});
		add(add, gbc);
	}

}
