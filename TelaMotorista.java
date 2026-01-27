import javax.swing.*;

public class TelaMotorista extends JFrame {
	
	private JPanel painel;
	private JLabel lbNome;
	private JLabel lbCpf;
	private JLabel lbDataNasc;
	private JLabel lbEnd;
	private JLabel lbCnh;
	private JLabel lbNomeSocial;
	
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtDataNasc;
	private JTextField txtEnd;
	private JTextField txtCnh;
	private JTextField txtNomeSocial;
	
	private JCheckBox cbAtivo; 
	
	private JButton botaoCadastrarVeiculo;
	private JButton botaoCadastrar;
	
	public TelaMotorista() {
		super("Cadastro de Motorista");
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
		
		lbEnd = new JLabel("Endereço: ");
		painel.add(lbEnd);
		txtEnd = new JTextField(30);
		painel.add(txtEnd);
		
		lbCnh = new JLabel("CNH: ");
		painel.add(lbCnh);
		txtCnh = new JTextField(11);
		painel.add(txtCnh);
		
		lbNomeSocial = new JLabel("Nome Social: ");
		painel.add(lbNomeSocial);
		txtNomeSocial = new JTextField(11);
		painel.add(txtNomeSocial);
		
		cbAtivo = new JCheckBox ("Motorista Ativo");
		painel.add(cbAtivo);
		
		botaoCadastrarVeiculo = new JButton ("Cadastrar Veiculo");
		painel.add(botaoCadastrarVeiculo);
		
		botaoCadastrar = new JButton ("Cadastrar");
		painel.add(botaoCadastrar);
		
		setSize(500, 350);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
		
		
	}
	

}
