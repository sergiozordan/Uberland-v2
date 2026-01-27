import javax.swing.*;

public class TelaVeiculos extends JFrame {

	private JPanel painel;
	
	private JLabel lbPlaca;
    private JLabel lbChassi;
    private JLabel lbCor;
    private JLabel lbCapacidade;
    private JLabel lbAno;
    private JLabel lbMarca;
    private JLabel lbModelo;
    private JLabel lbCategoria;
    private JLabel lbQtdeMalas;
    
    private JTextField txtPlaca;
    private JTextField txtChassi;
    private JTextField txtCor;
    private JTextField txtCapacidade;
    private JTextField txtAno;
    private JTextField txtMarca;
    private JTextField txtModelo;
    
    private JComboBox <String> cbCategoria;
    private String categoria[] = {"UberX", "UberComfort", "UberBlack"};
    private JComboBox <Integer> cbQtdeMalas;
    private Integer qtdeMalas[] = {0,1,2,3,4,5,6};
    
    private JCheckBox cbArCondicionado;
    private JCheckBox cbConfortoBasico;
    private JCheckBox cbEspacoExtra;
    private JCheckBox cbArDualZone;
    private JCheckBox cbBancoReclinavel;
    private JCheckBox cbRodasLigaLeve;
    private JCheckBox cbInteriorPremium;
    
    
    
    private JButton botaoCadastrar;
    
    public TelaVeiculos() {
    	super("Cadastro de Veiculos");
    	painel = new JPanel();
    	add(painel);
    	
    	lbPlaca = new JLabel("Placa: ");
    	painel.add(lbPlaca);
    	txtPlaca = new JTextField(7);
    	painel.add(txtPlaca);
    	
    	lbChassi = new JLabel("Chassi: ");
    	painel.add(lbChassi);
    	txtChassi = new JTextField(17);
    	painel.add(txtChassi);
    	
    	lbCor = new JLabel("Cor: ");
    	painel.add(lbCor);
    	txtCor = new JTextField(15);
    	painel.add(txtCor);
    	
    	lbCapacidade = new JLabel("Capacidade: ");
    	painel.add(lbCapacidade);
    	txtCapacidade = new JTextField(4);
    	painel.add(txtCapacidade);
    	
    	lbAno = new JLabel("Ano: ");
    	painel.add(lbAno);
    	txtAno = new JTextField(4);
    	painel.add(txtAno);
    	
    	lbMarca = new JLabel("Marca: ");
    	painel.add(lbMarca);
    	txtMarca = new JTextField(15);
    	painel.add(txtMarca);
    	
    	lbModelo = new JLabel("Modelo: ");
    	painel.add(lbModelo);
    	txtModelo = new JTextField(15);
    	painel.add(txtModelo);
    	
    	lbCategoria = new JLabel("Categoria: ");
    	painel.add(lbCategoria);
    	cbCategoria = new JComboBox<>(categoria);
    	painel.add(cbCategoria);
    	
    	cbArCondicionado = new JCheckBox("Ar Condicionado");
    	painel.add(cbArCondicionado);
    	cbConfortoBasico = new JCheckBox("Ar Conforto Basico");
    	painel.add(cbConfortoBasico);
    	cbEspacoExtra =new JCheckBox("Espaço Extra"); 
    	painel.add(cbEspacoExtra);
    	cbArDualZone = new JCheckBox("Ar Dual Zone");
    	painel.add(cbArDualZone);
    	cbBancoReclinavel = new JCheckBox("Banco Reclinavel");
    	painel.add(cbBancoReclinavel);
    	cbRodasLigaLeve = new JCheckBox("Rodas Liga Leve");
    	painel.add(cbRodasLigaLeve);
    	cbInteriorPremium = new JCheckBox("Interior Premium");
    	painel.add(cbInteriorPremium);
    	
    	lbQtdeMalas = new JLabel("Qtde de Malas: ");
    	painel.add(lbQtdeMalas);
    	cbQtdeMalas = new JComboBox<>(qtdeMalas);
    	painel.add(cbQtdeMalas);
    	
    	botaoCadastrar = new JButton("Cadastrar");
    	painel.add(botaoCadastrar);
    	
    	setSize(680, 350);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
    }
    
}
