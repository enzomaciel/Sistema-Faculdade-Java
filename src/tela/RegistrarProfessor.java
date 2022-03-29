package tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class RegistrarProfessor extends JFrame {

	private JTextField txtName;
	private JTextField txtCpf;
	private JTextField txtNameDad;
	private JTextField txtNameMom;
	private JLabel lblMatricula;
	private JLabel lblSenha;
	private JTextField txtSenha;
	private JLabel lblCidade;
	private JTextField txtCidade;
	private JLabel lblEstado;
	private JTextField txtEstado;
	private static JButton btnRegistrar;
	public boolean aux = false;
	private JFormattedTextField txtDataDeNascimento;
	private JLabel txtSenhaNumero;
	private JLabel txtSenhaCaractere;
	private JLabel txtSimbolo;
	private JLabel txtLetra;
	private JFormattedTextField txtMatricula;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarProfessor frame = new RegistrarProfessor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RegistrarProfessor() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 768, 469);
		JPanel contentPane = new JPanel();
		contentPane.setForeground(new Color(128, 0, 0));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrarProfessor = new JLabel("Registrar Professor");
		lblRegistrarProfessor.setBackground(new Color(255, 255, 255));
		lblRegistrarProfessor.setForeground(new Color(128, 0, 0));
		lblRegistrarProfessor.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarProfessor.setFont(new Font("Montserrat ExtraBold", Font.BOLD, 30));
		lblRegistrarProfessor.setBounds(192, 35, 368, 64);
		contentPane.add(lblRegistrarProfessor);
		
		JLabel lblName = new JLabel("Nome Completo:");
		lblName.setFont(new Font("Montserrat", Font.BOLD, 11));
		lblName.setForeground(new Color(128, 0, 0));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(106, 105, 141, 14);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String aux = txtName.getText();
				if(tratarNome(aux)) {
					txtName.setBackground(new Color(255,255,255));
				}else {
					txtName.setBackground(new Color(255, 0 ,0));
				}
			}
		});
		txtName.setForeground(new Color(128, 0, 0));
		txtName.setSelectionColor(new Color(5, 219, 242));
		txtName.setBounds(257, 102, 267, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBorder(null);
		lblCpf.setForeground(new Color(128, 0, 0));
		lblCpf.setFont(new Font("Montserrat", Font.BOLD, 11));
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setBounds(119, 130, 128, 14);
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setForeground(new Color(128, 0, 0));
		txtCpf.setSelectionColor(new Color(5, 219, 242));
		txtCpf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String aux = txtCpf.getText();
				if(tratarCpf(aux)) {
					txtCpf.setBackground(new Color(255,255,255));
				}else if(aux.equals("")) {
					txtCpf.setBackground(new Color(255,255,255));
				}else {
					txtCpf.setBackground(new Color(255,0,0));
				}
				
				
			}
		});
		txtCpf.setColumns(10);
		txtCpf.setBounds(257, 127, 267, 20);
		contentPane.add(txtCpf);
		
		JLabel lblMateria = new JLabel("Materia:");
		lblMateria.setFont(new Font("Montserrat", Font.BOLD, 11));
		lblMateria.setForeground(new Color(128, 0, 0));
		lblMateria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMateria.setBounds(119, 155, 128, 14);
		contentPane.add(lblMateria);
		
		txtNameDad = new JTextField();
		txtNameDad.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String aux = txtNameDad.getText();
				if(tratarNome(aux)) {
					txtNameDad.setBackground(new Color(255,255,255));
				}else {
					txtNameDad.setBackground(new Color(255, 0 ,0));
				}
			}
		});
		txtNameDad.setSelectionColor(new Color(5, 219, 242));
		txtNameDad.setForeground(new Color(128, 0, 0));
		txtNameDad.setColumns(10);
		txtNameDad.setBounds(257, 152, 267, 20);
		contentPane.add(txtNameDad);
		
		JLabel lblNameMom = new JLabel("Nome da M\u00E3e:");
		lblNameMom.setFont(new Font("Montserrat", Font.BOLD, 11));
		lblNameMom.setForeground(new Color(128, 0, 0));
		lblNameMom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNameMom.setBounds(106, 180, 141, 14);
		contentPane.add(lblNameMom);
		
		txtNameMom = new JTextField();
		txtNameMom.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String aux = txtNameDad.getText();
				if(tratarNome(aux)) {
					txtNameMom.setBackground(new Color(255,255,255));
				}else {
					txtNameMom.setBackground(new Color(255, 0 ,0));
				}
			}
		});
		txtNameMom.setSelectionColor(new Color(5, 219, 242));
		txtNameMom.setForeground(new Color(128, 0, 0));
		txtNameMom.setColumns(10);
		txtNameMom.setBounds(257, 177, 267, 20);
		contentPane.add(txtNameMom);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Montserrat", Font.BOLD, 11));
		lblDataDeNascimento.setForeground(new Color(128, 0, 0));
		lblDataDeNascimento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataDeNascimento.setBounds(79, 205, 168, 14);
		contentPane.add(lblDataDeNascimento);
		
		txtDataDeNascimento = new JFormattedTextField();
		txtDataDeNascimento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String aux = txtDataDeNascimento.getText();
				if(aux.length() == 10) {
					txtDataDeNascimento.setBackground(new Color(255,255,255));
				}else{
					txtDataDeNascimento.setBackground(new Color(255,0,0));
				}
			}
		});
		txtDataDeNascimento.setSelectionColor(new Color(5, 219, 242));
		txtDataDeNascimento.setForeground(new Color(128, 0, 0));
		txtDataDeNascimento.setColumns(10);
		txtDataDeNascimento.setBounds(257, 202, 267, 20);
		contentPane.add(txtDataDeNascimento);
		try {
			txtDataDeNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
		}catch(java.text.ParseException ex) {
			ex.printStackTrace();
		}
		lblMatricula = new JLabel("Matricula: ");
		lblMatricula.setForeground(new Color(128, 0, 0));
		lblMatricula.setFont(new Font("Montserrat", Font.BOLD, 11));
		lblMatricula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMatricula.setBounds(79, 230, 168, 14);
		contentPane.add(lblMatricula);
		
		txtMatricula = new JFormattedTextField();
		txtMatricula.setBounds(257, 333, 267, 20);
		txtMatricula.setSelectionColor(new Color(5, 219, 242));
		txtMatricula.setForeground(new Color(128, 0, 0));
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(257, 227, 267, 20);
		try {
			txtMatricula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
		}catch(java.text.ParseException ex) {
			ex.printStackTrace();
		}
		contentPane.add(txtMatricula);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Montserrat", Font.BOLD, 11));
		lblSenha.setForeground(new Color(128, 0, 0));
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setBounds(79, 255, 168, 14);
		contentPane.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String aux = txtSenha.getText();
				Tratarsenha(aux);
			}
		});
		txtSenha.setForeground(new Color(128, 0, 0));
		txtSenha.setSelectionColor(new Color(5, 219, 242));
		txtSenha.setColumns(10);
		txtSenha.setBounds(257, 252, 267, 20);
		
		contentPane.add(txtSenha);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Montserrat", Font.BOLD, 11));
		lblCidade.setForeground(new Color(128, 0, 0));
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setBounds(79, 318, 168, 14);
		contentPane.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String aux = txtCidade.getText();
				if(tratarNome(aux)) {
					txtCidade.setBackground(new Color(255,255,255));
				}else {
					txtCidade.setBackground(new Color(255, 0 ,0));
				}
			}
		});
		txtCidade.setForeground(new Color(128, 0, 0));
		txtCidade.setSelectionColor(new Color(5, 219, 242));
		txtCidade.setColumns(10);
		txtCidade.setBounds(257, 315, 267, 20);
		contentPane.add(txtCidade);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Montserrat", Font.BOLD, 11));
		lblEstado.setForeground(new Color(128, 0, 0));
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setBounds(79, 349, 168, 14);
		contentPane.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String aux = txtEstado.getText();
				if(tratarNome(aux)) {
					txtEstado.setBackground(new Color(255,255,255));
				}else {
					txtEstado.setBackground(new Color(255, 0 ,0));
				}
			}
		});
		txtEstado.setForeground(new Color(128, 0, 0));
		txtEstado.setSelectionColor(new Color(5, 219, 242));
		txtEstado.setColumns(10);
		txtEstado.setBounds(257, 346, 267, 20);
		contentPane.add(txtEstado);
		
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Montserrat", Font.BOLD, 11));
		btnRegistrar.setBackground(new Color(128, 0, 0));
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.setBorder(null);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(salvar()) {
						inserirMateria();
						dispose();
						Inicio main = new Inicio();
						main.setVisible(true);
						main.setLocationRelativeTo(null);	
					}else {
						
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
					
				
			}
		});
		btnRegistrar.setBounds(435, 377, 89, 23);
		contentPane.add(btnRegistrar);
		
		txtSimbolo = new JLabel("Simbolos");
		txtSimbolo.setBackground(new Color(255, 255, 255));
		txtSimbolo.setFont(new Font("Montserrat", Font.BOLD, 11));
		txtSimbolo.setHorizontalAlignment(SwingConstants.LEFT);
		txtSimbolo.setForeground(new Color(0, 0, 0));
		txtSimbolo.setBounds(257, 274, 94, 14);
		contentPane.add(txtSimbolo);
		
		txtLetra = new JLabel("Letra Maiscula");
		txtLetra.setFont(new Font("Montserrat", Font.BOLD, 11));
		txtLetra.setHorizontalAlignment(SwingConstants.LEFT);
		txtLetra.setForeground(new Color(0, 0, 0));
		txtLetra.setBounds(257, 290, 94, 14);
		contentPane.add(txtLetra);
		
		txtSenhaNumero = new JLabel("Numeros");
		txtSenhaNumero.setFont(new Font("Montserrat", Font.BOLD, 11));
		txtSenhaNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSenhaNumero.setForeground(new Color(0, 0, 0));
		txtSenhaNumero.setBounds(435, 290, 89, 14);
		contentPane.add(txtSenhaNumero);
		
		txtSenhaCaractere = new JLabel("8 Caracteres");
		txtSenhaCaractere.setFont(new Font("Montserrat", Font.BOLD, 11));
		txtSenhaCaractere.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSenhaCaractere.setForeground(new Color(0, 0, 0));
		txtSenhaCaractere.setBounds(435, 274, 89, 14);
		contentPane.add(txtSenhaCaractere);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Inicio main = new Inicio();
				main.setVisible(true);
				main.setLocationRelativeTo(null);
			}
		});
		btnVoltar.setBackground(new Color(128, 0, 0));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBorder(null);
		btnVoltar.setFont(new Font("Montserrat", Font.BOLD, 11));
		btnVoltar.setBounds(25, 27, 89, 23);
		contentPane.add(btnVoltar);
	}
	public boolean testarCaminho(String caminho1, String caminho2) {
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
	public boolean salvar() throws Exception {
		String caminhoProfessor ="C:\\Users\\mmaci\\Documents\\Estudo\\Curso de Java Se e Banco de Dados\\Aulas\\Sistema_Faculdade\\src\\bancoDados\\bancoProfessor.txt";
		String caminhoProfessorTemp = "C:\\Users\\mmaci\\Documents\\Estudo\\Curso de Java Se e Banco de Dados\\Aulas\\Sistema_Faculdade\\src\\bancoDados\\bancoProfessortemp.txt";
		
			if(testarCaminho(caminhoProfessor , caminhoProfessorTemp)) {
				String nomeTemp = txtName.getText();
				String cpfTemp = txtCpf.getText();
				String nomePaiTemp = txtNameDad.getText();
				String nomeMaeTemp = txtNameMom.getText();
				String matriculaTemp = txtMatricula.getText();
				String senhaTemp = txtSenha.getText();
				String cidadeTemp = txtCidade.getText();
				String estadoTemp = txtEstado.getText();
				
				if(formularioTest(nomeTemp, cpfTemp,nomePaiTemp,nomeMaeTemp,matriculaTemp,senhaTemp,cidadeTemp,estadoTemp)) {
					BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoProfessor,true));
					BufferedReader br = new BufferedReader(new FileReader(caminhoProfessor));
					int id2 = 0;
					while(br.ready()) {
						String linha = br.readLine();
						int id = Integer.parseInt(linha.substring(0, linha.indexOf("!")));
						if(id > id2) {
							id2 = id;
						}
					}
					id2++;
					bw.write(id2+"!"+nomeTemp+"@"+cpfTemp+"#"+nomePaiTemp+"$"+nomeMaeTemp+"%"+matriculaTemp+"&"+senhaTemp+"*"+cidadeTemp+"!"+estadoTemp);
					bw.newLine();
					br.close();
					bw.close();
					return true;
					
				}else{
					JOptionPane.showMessageDialog(null, "item em branco");
					return false;
				}
			}
			JOptionPane.showMessageDialog(null, "Erro ao salvar");
			return false;
	}
	public boolean formularioTest(String a1, String a2, String a3, String a4, String a5, String a6, String a7, String a8) {
		if(a1.equals(null) || a2.equals(null) || a3.equals(null) || a4.equals(null) || a5.equals(null) || a6.equals(null) || a7.equals(null) || a8.equals(null) ) {
			return false;
		}
		return true;
	}
	public boolean tratarNome(String a1) {
		a1.trim();
		String caracter = "1234567890!@#$%&*()?.,^´`{][}";
		int cont = 0;
		
		for(int i = 0; i<a1.length();i++) {
			for(int j = 0; j<caracter.length();j++) {
				if(a1.charAt(i) == caracter.charAt(j)) {
					cont++;
				}
			}
		}
		if(cont == 0){
			return true;
		}else{
			return false;
		}
	}
	public boolean tratarCpf(String a1) {
		a1.trim();
		a1.toLowerCase();
		String a2;
		a2 = a1;
		String num = "1234567890.-";
		String caracter ="qwertyuiopasdfghjklçzxcvbnm!@#$%&*()?,^´`{][}";
		
		for(int i = 0; i<num.length();i++) {
			String num2 = num.charAt(i)+"";
			while(a2.contains(num2)) {
				a2 = a2.replace(num2, "");
			}
		}
		switch (a1.length()){
		case 11:
			if(a2.length() == 0 && a1.length() == 11) {
				String cpfFormat = a1.substring(0,3) + "." + a1.substring(3,6)+"."+a1.substring(6,9)+"-"+a1.substring(9);
				txtCpf.setText(cpfFormat);
				return true;		
			}else {
				return false;
			}
		case 14:
			if(a2.length() == 0 && a1.length()==14) {
				txtCpf.setText(a1);
				return true;
			}else {
				return false;
			}
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
			txtSenhaNumero.setForeground(new Color(255,255, 255));
			if(cont2>0) {
				txtSimbolo.setForeground(new Color(255,255, 255));
				if(cont3>0) {
					txtLetra.setForeground(new Color(255,255, 255));
					if(cont4 > 0) {
						txtSenhaCaractere.setForeground(new Color(255, 255, 255));
					}else{
					}
				}else {
				}
			}else {
			}
		}else{
		}
	}
	public void inserirMateria() {
		String caminhoAluno = "C:\\Users\\mmaci\\Documents\\Estudo\\Curso de Java Se e Banco de Dados\\Aulas\\Sistema_Faculdade\\src\\bancoDados\\bancoAluno.txt";
		String caminhoProfessor = "C:\\Users\\mmaci\\Documents\\Estudo\\Curso de Java Se e Banco de Dados\\Aulas\\Sistema_Faculdade\\src\\bancoDados\\bancoProfessor.txt";
		String caminhoMateria = "C:\\Users\\mmaci\\Documents\\Estudo\\Curso de Java Se e Banco de Dados\\Aulas\\Sistema_Faculdade\\src\\bancoDados\\bancoMateria.txt";
		if(testarCaminho(caminhoAluno, caminhoProfessor)) {
			if(testarCaminho(caminhoMateria, caminhoMateria)) {
				try {
					BufferedReader br = new BufferedReader(new FileReader(caminhoAluno));
					BufferedReader br2 = new BufferedReader(new FileReader(caminhoProfessor));
					BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoMateria));
					
					while(br2.ready()) {
						String linha = br2.readLine();
						String matProfessor = linha.substring(linha.indexOf("%")+1 , linha.indexOf("&"));
						String materia = linha.substring(linha.indexOf("#")+1 , linha.indexOf("$"));
						while(br.ready()) {
							String linha2 = br.readLine();
							String matAluno = linha.substring(linha.indexOf("%")+1 , linha.indexOf("&"));
							bw.write(matProfessor + "!" + materia + "@" + matAluno + "#" + "null" + "$" + "null" + "%" + "null" + "&" + "media" );
							bw.newLine();
						}
					}
					bw.close();
					br.close();
					br2.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
}



