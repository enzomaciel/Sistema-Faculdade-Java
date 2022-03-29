package tela;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import faculdade.Aluno;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextArea;

public class LoginAluno extends JFrame {
	private String nome;
	private JLabel lblNomeAluno;
	private JTable table;
	private JTextField txtSenhaNova;
	private JPanel panel;
	private JLabel lblSimbolo;
	private JLabel lblNumero;
	private JLabel lblLetraMaiscula;
	private JLabel lblCaracteres;
	private JButton btnVoltar;
	private JLabel lbllabel2;
	private JLabel lblLabel2;
	private JLabel lblMatricula;
	private JLabel lblCpf;
	private JTextArea textArea;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAluno frame = new LoginAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 451);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAlterarSenha = new JButton("Alterar Senha");
		btnAlterarSenha.setBackground(new Color(255, 255, 255));
		btnAlterarSenha.setFont(new Font("Montserrat", Font.BOLD, 13));
		btnAlterarSenha.setForeground(new Color(128, 0, 0));
		btnAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
			}
		});
		btnAlterarSenha.setBounds(10, 107, 216, 23);
		contentPane.add(btnAlterarSenha);
		
		lblNomeAluno = new JLabel("Nome");
		lblNomeAluno.setForeground(new Color(255, 255, 255));
		lblNomeAluno.setFont(new Font("Montserrat", Font.BOLD, 26));
		lblNomeAluno.setBounds(10, 13, 491, 60);
		contentPane.add(lblNomeAluno);
		
		table = new JTable();
		table.setBounds(85, 314, 54, -26);
		contentPane.add(table);
		
		panel = new JPanel();
		panel.setForeground(new Color(128, 0, 0));
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(10, 135, 216, 153);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		txtSenhaNova = new JTextField();
		txtSenhaNova.setFont(new Font("Montserrat", Font.BOLD, 11));
		txtSenhaNova.setForeground(new Color(128, 0, 0));
		txtSenhaNova.setCaretColor(new Color(128, 0, 0));
		txtSenhaNova.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Tratarsenha(txtSenhaNova.getText());
			}
		});
		txtSenhaNova.setBounds(10, 77, 196, 20);
		panel.add(txtSenhaNova);
		txtSenhaNova.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnSalvar.setFont(new Font("Montserrat", Font.BOLD, 13));
		btnSalvar.setForeground(new Color(128, 0, 0));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarSenha();
			}
		});
		btnSalvar.setBounds(10, 108, 196, 23);
		panel.add(btnSalvar);
		
		JLabel lblSenha = new JLabel("Digite a nova Senha");
		lblSenha.setBackground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Montserrat", Font.BOLD, 11));
		lblSenha.setForeground(new Color(192, 192, 192));
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setBounds(10, 11, 181, 14);
		panel.add(lblSenha);
		
		lblSimbolo = new JLabel("Simbolo");
		lblSimbolo.setForeground(new Color(192, 192, 192));
		lblSimbolo.setFont(new Font("Montserrat", Font.BOLD, 11));
		lblSimbolo.setBackground(new Color(128, 0, 0));
		lblSimbolo.setBounds(10, 36, 66, 12);
		panel.add(lblSimbolo);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Montserrat", Font.BOLD, 11));
		lblNumero.setForeground(new Color(192, 192, 192));
		lblNumero.setBounds(10, 54, 66, 12);
		panel.add(lblNumero);
		
		lblLetraMaiscula = new JLabel("Letra maiscula");
		lblLetraMaiscula.setFont(new Font("Montserrat", Font.BOLD, 11));
		lblLetraMaiscula.setForeground(new Color(192, 192, 192));
		lblLetraMaiscula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLetraMaiscula.setBounds(86, 36, 120, 12);
		panel.add(lblLetraMaiscula);
		
		lblCaracteres = new JLabel("8 caracteres");
		lblCaracteres.setForeground(new Color(192, 192, 192));
		lblCaracteres.setFont(new Font("Montserrat", Font.BOLD, 11));
		lblCaracteres.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCaracteres.setBounds(96, 54, 110, 12);
		panel.add(lblCaracteres);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Inicio main = new Inicio();
				main.setVisible(true);
				main.setLocationRelativeTo(null);
			}
		});
		btnVoltar.setFont(new Font("Montserrat", Font.BOLD, 13));
		btnVoltar.setBackground(new Color(255, 255, 255));
		btnVoltar.setForeground(new Color(128, 0, 0));
		btnVoltar.setBounds(10, 363, 216, 23);
		contentPane.add(btnVoltar);
		
		lbllabel2 = new JLabel("Matricula:");
		lbllabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllabel2.setForeground(new Color(255, 255, 255));
		lbllabel2.setFont(new Font("Montserrat", Font.BOLD, 13));
		lbllabel2.setBounds(293, 84, 112, 23);
		contentPane.add(lbllabel2);
		
		lblLabel2 = new JLabel("Cpf:");
		lblLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLabel2.setForeground(Color.WHITE);
		lblLabel2.setFont(new Font("Montserrat", Font.BOLD, 13));
		lblLabel2.setBounds(293, 118, 112, 23);
		contentPane.add(lblLabel2);
		
		lblMatricula = new JLabel("");
		lblMatricula.setForeground(Color.WHITE);
		lblMatricula.setFont(new Font("Montserrat", Font.BOLD, 13));
		lblMatricula.setBounds(415, 84, 210, 23);
		contentPane.add(lblMatricula);
		
		lblCpf = new JLabel("");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Montserrat", Font.BOLD, 13));
		lblCpf.setBounds(415, 118, 210, 23);
		contentPane.add(lblCpf);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Montserrat", Font.BOLD, 13));
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setBackground(new Color(128, 0, 0));
		textArea.setBounds(409, 152, 216, 234);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Materias:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(293, 153, 112, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnCadastrarmateria = new JButton("CadastrarMateria");
		btnCadastrarmateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarMateria cadastrar = new CadastrarMateria();
				String nome = lblNomeAluno.getText();
				String matricula = lblMatricula.getText();
				cadastrar.exportar(nome, matricula );
				cadastrar.verMaterias();
				cadastrar.verMateriasAcumuladas();
				cadastrar.setVisible(true);
				cadastrar.setLocationRelativeTo(null);
				
			}
		});
		btnCadastrarmateria.setForeground(new Color(128, 0, 0));
		btnCadastrarmateria.setFont(new Font("Montserrat", Font.BOLD, 13));
		btnCadastrarmateria.setBackground(Color.WHITE);
		btnCadastrarmateria.setBounds(10, 73, 216, 23);
		contentPane.add(btnCadastrarmateria);
		
	}
	public void exportar(Aluno aluno) {
		lblNomeAluno.setText(aluno.getNome());
		lblMatricula.setText(aluno.getMatricula());
		lblCpf.setText(aluno.getCpf());
		
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void alterarSenha() {
		String caminhoAluno ="C:\\Users\\mmaci\\Documents\\Estudo\\Curso de Java Se e Banco de Dados\\Aulas\\Sistema_Faculdade\\src\\bancoDados\\bancoAluno.txt";
		String caminhoAlunoTemp = "C:\\Users\\mmaci\\Documents\\Estudo\\Curso de Java Se e Banco de Dados\\Aulas\\Sistema_Faculdade\\src\\bancoDados\\bancoAlunotemp.txt";
		if(testarCaminho(caminhoAluno, caminhoAlunoTemp)) {
			String nome = lblNomeAluno.getText();
			JOptionPane.showMessageDialog(null, nome);
			try {
				BufferedReader br = new BufferedReader(new FileReader(caminhoAluno));
				BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoAlunoTemp));
				String senhaNova = txtSenhaNova.getText();
				
				while(br.ready()) {
					String linha = br.readLine();
					String matriculaTemp = linha.substring(linha.indexOf("%") + 1, linha.indexOf("&"));
					String senhaTemp = linha.substring(linha.indexOf("&") + 1, linha.indexOf("*"));
					String nomeTemp = linha.substring(linha.indexOf("!")+1, linha.indexOf("@"));
					String cpfTemp = linha.substring(linha.indexOf("@")+1, linha.indexOf("#"));
					String nomePaiTemp = linha.substring(linha.indexOf("#")+1, linha.indexOf("$"));
					String nomeMaeTemp = linha.substring(linha.indexOf("$")+1, linha.indexOf("%"));
					String cidadeTemp = linha.substring(linha.lastIndexOf("*")+1, linha.lastIndexOf("!"));
					String estadoTemp = linha.substring(linha.lastIndexOf("!")+1);
					if(nomeTemp.equals(nome)) {
						bw.write("!"+nomeTemp+"@"+cpfTemp+"#"+nomePaiTemp+"$"+nomeMaeTemp+"%"+matriculaTemp+"&"+senhaNova+"*"+cidadeTemp+"!"+estadoTemp);
						bw.newLine();
					}else {
						bw.write("!"+nomeTemp+"@"+cpfTemp+"#"+nomePaiTemp+"$"+nomeMaeTemp+"%"+matriculaTemp+"&"+senhaTemp+"*"+cidadeTemp+"!"+estadoTemp);
						bw.newLine();
					}
				}
				br.close();
				bw.close();
				
				BufferedReader br2 = new BufferedReader(new FileReader(caminhoAlunoTemp));
				BufferedWriter bw2 = new BufferedWriter(new FileWriter(caminhoAluno));
				int id2 = 0;
				
				while(br2.ready()) {
					String linha2 = br2.readLine();
					id2++;
					bw2.write(id2+linha2);
					bw2.newLine();
				}
				bw2.close();
				br2.close();
				JOptionPane.showMessageDialog(null, "Finalizado");
			}catch (Exception e) {
			}
		}
	}
	public static boolean testarCaminho(String caminho1, String caminho2) {
		File cam = new File(caminho1);
		File cam2 = new File(caminho2);
		if(cam.exists() && cam2.exists()) {
			return true;
			
		} else
			try {
				if(cam.createNewFile() && cam2.createNewFile()) {
					return true;
				}else {
					return false;
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		return false;
	}
	public void Tratarsenha(String a1) {
		//verificar se possui letra maiscula
		String num = "0123456789";
		String letra = "QWERTYUIOPASDFGHJKLÇZXCVBNM";
		String simbolo = ".,?!@#$%&*";
		a1.trim();
		int cont =0, cont2 =0,cont3=0,cont4=0;
		// verificando se possui um numero na senha
		for(int i = 0; i<num.length(); i++) {
			String num2 = num.charAt(i)+"";
			for(int j = 0; j<a1.length(); j++) {
				String aux = a1.charAt(j)+"";
				if(aux.equals(num2)) {
					cont++;
				}
			}
		}
		//verificando se possui um simbolo na senha
		for(int i = 0; i<simbolo.length(); i++) {
			String simbolo2 = simbolo.charAt(i)+"";
			for(int j = 0; j<a1.length(); j++) {
				String aux = a1.charAt(j)+"";
				if(aux.equals(simbolo2)) {
					cont2++;
				}
			}
		}
		//verificando se possui um letra maiscula
		for(int i = 0; i<letra.length(); i++) {
			String letra2 = letra.charAt(i)+"";
			for(int j = 0; j<a1.length(); j++) {
				String aux = a1.charAt(j)+"";
				if(aux.equals(letra2)) {
					cont3++;
				}
			}
		}
		//verificando se possui 8 caracteres
		if(a1.length() >= 8) {
			cont4++;
		}
		
		if(cont > 0) {
			lblNumero.setForeground(new Color(255,255, 255));
			if(cont2>0) {
				lblSimbolo.setForeground(new Color(255,255, 255));
				if(cont3>0) {
					lblLetraMaiscula.setForeground(new Color(255,255, 255));
					if(cont4 > 0) {
						lblCaracteres.setForeground(new Color(255, 255, 255));
					}else{
						lblCaracteres.setForeground(new Color(255, 0, 0));
					}
				}else {
					lblLetraMaiscula.setForeground(new Color(255,0, 0));
				}
			}else {
				lblSimbolo.setForeground(new Color(255,0, 0));
			}
		}else{
			lblNumero.setForeground(new Color(255,0, 0));
		}
	}
	public void materias() {
		String caminhoMateria = "C:\\Users\\mmaci\\Documents\\Estudo\\Curso de Java Se e Banco de Dados\\Aulas\\Sistema_Faculdade\\src\\bancoDados\\bancoMateria.txt";
		if (testarCaminho(caminhoMateria, caminhoMateria)) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(caminhoMateria));
				while (br.ready()) {
					String linha = br.readLine();
					String materia = linha.substring(linha.indexOf("!") + 1, linha.indexOf("@"));
					textArea.append(materia + "\n");
				}
				br.close();

			} catch (Exception e) {

			}
		}
	}
}
