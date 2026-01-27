import javax.swing.*;

public class TelaCorrida extends JFrame {
	
	private JPanel painel;
	
	private JLabel lbOrigem;
	private JLabel lbDestino;
	private JLabel lbCategoria;
	private JLabel lbPagamento;
	
	private JTextField txtOrigem;
	private JTextField txtDestino;
	
	private JComboBox<String> cbCategoria;
	private String categoria[] = {"UberX", "UberComfort", "UberBlack"};
	
	private JComboBox<String> cbPagamento;
	private String pagamento[] = {"Cartão de Crédito", "Cartão de Débito", "Pix", "Dinheiro"};
	
	private JButton botaosolicitar;
	
	
	public TelaCorrida() {
		super ("Cadastro de Corrida");
		painel = new JPanel();
		add(painel);
		
		lbOrigem = new JLabel("Origem:");
		painel.add(lbOrigem);
		txtOrigem = new JTextField(15);
		painel.add(txtOrigem);
		
		lbDestino = new JLabel("Destino:");
		painel.add(lbDestino);
		txtDestino = new JTextField(15);
		painel.add(txtDestino);
		
		lbCategoria = new JLabel("Categoria:");
		painel.add(lbCategoria);
		cbCategoria = new JComboBox<>(categoria);
		painel.add(cbCategoria);
		
		lbPagamento = new JLabel("Pagamento:");
		painel.add(lbPagamento);
		cbPagamento = new JComboBox<>(pagamento);
		painel.add(cbPagamento);
	
		botaosolicitar = new JButton("Solicitar Corrida");
		painel.add(botaosolicitar);
		
		setSize(680, 350);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
		
		
	}
	
}
