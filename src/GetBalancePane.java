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

public class GetBalancePane extends JPanel
{
	ArrayList <BankAccount> accounts;
	
	public GetBalancePane(ArrayList <BankAccount> a)
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
		JButton find = new JButton("Calculate Balance");
		find.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(accounts.size() == 0)
				{
					JOptionPane.showMessageDialog(null, "Please Create At-Least 1 Account");
					txtAccNum.setText("");
				}
				
				int accNum = Integer.parseInt(txtAccNum.getText());
				
				BankAccount tempAccount = null;
				
				boolean t1 = true;
				
				for(int i = 0; i < accounts.size(); i++)
				{
					if(accounts.get(i).getAccountNumber() == accNum)
					{
						tempAccount = accounts.get(i);
						String balance = String.valueOf("$" + tempAccount.getBalance());
						JOptionPane.showMessageDialog(null, balance);
						t1 = false;
						txtAccNum.setText("");
					}
				}
				
				if(t1)
				{
					JOptionPane.showMessageDialog(null, "Account Not Found");
					txtAccNum.setText("");
				}
			}
			
		});
		add(find, gbc);

	}
}
