import javax.swing.*;

public class TelaCliente extends JFrame{
	
	private JPanel painel;
	private JLabel lbNome;
	private JLabel lbCpf;
	private JLabel lbDataNasc;
	private JLabel lbCel;
	private JLabel lbEmail;
	
	private JLabel lbPagamento;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtDataNasc;
	private JTextField txtCel;
	private JTextField txtEmail;
	
	private JComboBox<String> cbPagamento;
	private String pagamento[] = {"Cartão de Crédito", "Cartão de Débito", "Pix", "Dinheiro"};
	
	private JButton botaoCadastrar; 
	
	public TelaCliente(){
		super("Cadastro de Cliente");
		painel = new JPanel();
		add(painel);
		
		lbNome = new JLabel("Nome: ");
		painel.add(lbNome);
		txtNome = new JTextField(30);
		painel.add(txtNome);
	
		lbCpf = new JLabel("CPF: ");
		painel.add(lbCpf);
		txtCpf = new JTextField(11);
		painel.add(txtCpf);
		
		lbDataNasc = new JLabel("Data de Nascimento: ");
		painel.add(lbDataNasc);
		txtDataNasc = new JTextField(8);
		painel.add(txtDataNasc);
		
		lbCel = new JLabel("Celular: ");
		painel.add(lbCel);
		txtCel = new JTextField(11);
		painel.add(txtCel);
		
		lbEmail = new JLabel("E-mail: ");
		painel.add(lbEmail);
		txtEmail = new JTextField(30);
		painel.add(txtEmail);
		
		lbPagamento = new JLabel("Forma de Pagamento: ");
		painel.add(lbPagamento);
		cbPagamento = new JComboBox<>(pagamento);
		painel.add(cbPagamento);
		
		botaoCadastrar = new JButton ("Cadastrar");
		painel.add(botaoCadastrar);
		
		
		setSize(500, 350);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	}
	
}