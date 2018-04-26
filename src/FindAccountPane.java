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

public class FindAccountPane extends JPanel
{
	ArrayList <BankAccount> accounts;
	
	public FindAccountPane(ArrayList <BankAccount> a)
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
		JButton find = new JButton("Find Account");
		find.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				BankAccount tempAccount = null;
				
				boolean trash = true;
				
				if(accounts.size() == 0)
				{
					JOptionPane.showMessageDialog(null, "Please Create At-Least One Account");
					txtName.setText("");
					trash = false;
				}
				
				for(int i = 0; i < accounts.size(); i++)
				{
					if(accounts.get(i).getName().equals(txtName.getText()))
					{
						tempAccount = accounts.get(i);
						JOptionPane.showMessageDialog(null, tempAccount.toString()); 
						trash = false;
					}
					
					for(int j = i + 1; j < accounts.size(); j++)
					{
						if(accounts.get(j).getName().equals(txtName.getText()))
						{
							tempAccount = accounts.get(j);
							JOptionPane.showMessageDialog(null, tempAccount.toString());    
							txtName.setText("");
							trash = false;
						}
					}
				}
				
				if(trash)
				{
					JOptionPane.showMessageDialog(null, "Account Doesn't Exist");
					txtName.setText("");
				}
				
			}
			
		});
		add(find, gbc);
		
		
	}
}
