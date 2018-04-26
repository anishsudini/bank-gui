import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainFrame extends JFrame
{
	public JFrame frame = this;
		
	ArrayList <BankAccount> accounts = new ArrayList <BankAccount> ();
	
	public MainFrame()
	{
		CardLayout cl = new CardLayout();
		JPanel overall= new JPanel();
		overall.setLayout(cl);
		
		overall.add(new WelcomePane(), "WelcomePane");
		overall.add(new CreateAccountPane(accounts), "CreateAccountPane");	
		overall.add(new DeleteAccountPane(accounts), "DeleteAccountPane");	
		overall.add(new FindAccountPane(accounts), "FindAccountPane");	
		overall.add(new DepositPane(accounts), "DepositPane");	
		overall.add(new WithdrawPane(accounts), "WithdrawPane");	
		overall.add(new TransferPane(accounts), "TransferPane");
		overall.add(new GetBalancePane(accounts), "GetBalancePane");	
		
		setBounds(600, 200, 656, 700);
		cl.show(overall, "WelcomePane");
		
		JMenuBar menu = new JMenuBar();
		
		JMenu homeMenu = new JMenu("Home");
		
		JMenuItem openMenuItem = new JMenuItem("Home Screen");
		openMenuItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(overall, "WelcomePane");
			}
			
		});
		homeMenu.add(openMenuItem);
		
		menu.add(homeMenu);
		
		JMenu accountsMenu = new JMenu("Accounts");
		
		JMenuItem openMenuItem1 = new JMenuItem("Create Account");
		openMenuItem1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(overall, "CreateAccountPane");
			}
	
		});
		accountsMenu.add(openMenuItem1);
		
		JMenuItem openMenuItem2 = new JMenuItem("Delete Account");
		openMenuItem2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				cl.show(overall, "DeleteAccountPane");
			}
	
		});
		accountsMenu.add(openMenuItem2);
		
		JMenuItem openMenuItem3 = new JMenuItem("Find Account");
		openMenuItem3.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "FindAccountPane");
			}
	
		});
		accountsMenu.add(openMenuItem3);
		
		menu.add(accountsMenu);
		
		JMenu transactionMenu = new JMenu("Transactions");
		
		JMenuItem openMenuItem4 = new JMenuItem("Deposit");
		openMenuItem4.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "DepositPane");
			}
	
		});
		transactionMenu.add(openMenuItem4);
		
		JMenuItem openMenuItem5 = new JMenuItem("Withdraw");
		openMenuItem5.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "WithdrawPane");
			}
	
		});
		transactionMenu.add(openMenuItem5);
		
		JMenuItem openMenuItem6 = new JMenuItem("Transfer");
		openMenuItem6.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "TransferPane");
			}
	
		});
		transactionMenu.add(openMenuItem6);
		
		JMenuItem openMenuItem7 = new JMenuItem("Get Balance");
		openMenuItem7.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				cl.show(overall, "GetBalancePane");
			}
	
		});
		transactionMenu.add(openMenuItem7);
		
		menu.add(transactionMenu);
		add(overall);
		frame.setJMenuBar(menu);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) 
	{
		new MainFrame();
	}

}
