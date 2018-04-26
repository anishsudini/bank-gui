import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class CreateAccountPane extends JPanel
{
	ArrayList <BankAccount> accounts;
	
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
	
	public CreateAccountPane(ArrayList <BankAccount> a)
	{
		accounts = a;
		
		setSize(400, 300);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblName = new JLabel("Name: ");
		add(lblName, gbc);
		
		gbc.gridx++;
		JTextField txtName = new JTextField();
		txtName.setPreferredSize(new Dimension(80, 30));
		add(txtName, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		JLabel lblDeposit = new JLabel("Intial Deposit: ");
		add(lblDeposit, gbc);
		
		gbc.gridx++;
		JTextField txtDeposit = new JTextField();
		txtDeposit.setPreferredSize(new Dimension(80, 30));
		add(txtDeposit, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		JLabel accType = new JLabel("Account Type: ");
		add(accType, gbc);
		
		gbc.gridx++;
		String[] accountType = {"Checking", "Savings"};
		JList <String> accountTypeList = new JList <String> (accountType);
		JScrollPane scroll = new JScrollPane(accountTypeList);
		scroll.setPreferredSize(new Dimension(80, 30));
		add(scroll, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		JButton add = new JButton("Submit");
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
				
				if(txtName.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Enter a Name");
					txtName.setText("");
					txtDeposit.setText("");
				}
				
				if(txtDeposit.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Enter an Amount");
					txtName.setText("");
					txtDeposit.setText("");
				}
				
				if(accountTypeList.getSelectedValue() == "Checking")
				{
					CheckingAccount account = new CheckingAccount(txtName.getText(), Double.parseDouble(txtDeposit.getText()), OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTION);
					accounts.add(account);
					System.out.println(accounts);
					JOptionPane.showMessageDialog(null, "Account Created Successfully");
				}
				
				else if(accountTypeList.getSelectedValue() == "Savings")
				{
					SavingsAccount account1 = new SavingsAccount(txtName.getText(), Double.parseDouble(txtDeposit.getText()), rate, MIN_BAL, MIN_BAL_FEE);
					accounts.add(account1);
					System.out.println(accounts);
					JOptionPane.showMessageDialog(null, "Acount Created Successfully");
				}
				
				txtName.setText("");
				txtDeposit.setText("");
			}
	
		});
		add(add, gbc);
	}
	
}
