package tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import faculdade.Aluno;
import faculdade.Professor;
import javax.swing.JFormattedTextField;
import java.awt.Toolkit;

public class Inicio extends JFrame {

	private JPanel jLoginPanel;
	private JFormattedTextField txtMatricula;
	private JTextField txtSenha;
	private boolean aux;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Inicio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mmaci\\Downloads\\livro-de-capa-preta-fechado.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 692, 504);
		jLoginPanel = new JPanel();
		jLoginPanel.setBackground(new Color(255, 255, 255));
		jLoginPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jLoginPanel);
		jLoginPanel.setLayout(null);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBackground(new Color(128, 0, 0));
		lblMatricula.setForeground(new Color(128, 0, 0));
		lblMatricula.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblMatricula.setHorizontalAlignment(SwingConstants.LEFT);
		lblMatricula.setBounds(374, 135, 116, 14);
		jLoginPanel.add(lblMatricula);
		
		txtMatricula = new JFormattedTextField();
		txtMatricula.setForeground(new Color(128, 0, 0));
		txtMatricula.setFont(new Font("Montserrat", Font.BOLD, 13));
		txtMatricula.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(128, 0, 0)));
		txtMatricula.setBounds(374, 152, 219, 25);
		jLoginPanel.add(txtMatricula);
		try {
			txtMatricula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
		}catch(java.text.ParseException ex) {
			ex.printStackTrace();
		}
		txtMatricula.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBackground(new Color(128, 0, 0));
		lblSenha.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblSenha.setForeground(new Color(128, 0, 0));
		lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenha.setBounds(374, 198, 116, 14);
		jLoginPanel.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setForeground(new Color(128, 0, 0));
		txtSenha.setFont(new Font("Montserrat", Font.BOLD, 13));
		txtSenha.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(128, 0, 0)));
		txtSenha.setColumns(10);
		txtSenha.setBounds(374, 213, 219, 25);
		jLoginPanel.add(txtSenha);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String caminhoAluno ="C:\\Users\\mmaci\\Documents\\Estudo\\Curso de Java Se e Banco de Dados\\Aulas\\Sistema_Faculdade\\src\\bancoDados\\bancoAluno.txt";
				String caminhoProfessor = "C:\\Users\\mmaci\\Documents\\Estudo\\Curso de Java Se e Banco de Dados\\Aulas\\Sistema_Faculdade\\src\\bancoDados\\bancoProfessor.txt";
				if(testarCaminho(caminhoAluno, caminhoProfessor)) {
					String matricula = txtMatricula.getText();
					String senha  = txtSenha.getText();
					try {
						BufferedReader br = new BufferedReader(new FileReader(caminhoAluno));
						while(br.ready()) {
							String linha = br.readLine();
							String matriculaTemp = linha.substring(linha.indexOf("%") + 1, linha.indexOf("&"));
							String senhaTemp = linha.substring(linha.indexOf("&") + 1, linha.indexOf("*"));
							String nomeTemp = linha.substring(linha.indexOf("!")+1, linha.indexOf("@"));
							String idTemp = linha.substring(0, linha.indexOf("!"));
							String cpfTemp = linha.substring(linha.indexOf("@")+1, linha.indexOf("#"));
							String nomePaiTemp = linha.substring(linha.indexOf("#")+1, linha.indexOf("$"));
							String nomeMaeTemp = linha.substring(linha.indexOf("$")+1, linha.indexOf("%"));
							String cidadeTemp = linha.substring(linha.lastIndexOf("*")+1, linha.lastIndexOf("!"));
							String estadoTemp = linha.substring(linha.lastIndexOf("!")+1);
							if(matriculaTemp.equals(matricula)) {
								if(senhaTemp.equals(senha)) {
									Aluno aluno = new Aluno();
									aluno.setMatricula(matriculaTemp);
									aluno.setSenha(senhaTemp);
									aluno.setNome(nomeTemp);
									aluno.setId(idTemp);
									aluno.setCpf(cpfTemp);
									aluno.setNomePai(nomePaiTemp);
									aluno.setNomeMae(nomeMaeTemp);
									aluno.setCidade(cidadeTemp);
									aluno.setEstado(estadoTemp);
									LoginAluno loginAluno = new LoginAluno();
									loginAluno.setVisible(true);
									loginAluno.setLocationRelativeTo(null);
									loginAluno.exportar(aluno);
									loginAluno.materias();
									dispose();	
								}
							}
						}
						br.close();
						BufferedReader br2 = new BufferedReader(new FileReader(caminhoProfessor));
						while(br2.ready()) {
							String linha = br2.readLine();
							String matriculaTemp = linha.substring(linha.indexOf("%") + 1, linha.indexOf("&"));
							String senhaTemp = linha.substring(linha.indexOf("&") + 1, linha.indexOf("*"));
							String nomeTemp = linha.substring(linha.indexOf("!")+1, linha.indexOf("@"));
							String idTemp = linha.substring(0, linha.indexOf("!"));
							String cpfTemp = linha.substring(linha.indexOf("@")+1, linha.indexOf("#"));
							String materiaTemp = linha.substring(linha.indexOf("#")+1, linha.indexOf("$"));
							String cidadeTemp = linha.substring(linha.lastIndexOf("*")+1, linha.lastIndexOf("!"));
							String estadoTemp = linha.substring(linha.lastIndexOf("!")+1);
							if(matriculaTemp.equals(matricula)) {
								if(senhaTemp.equals(senha)) {
									Professor professor = new Professor();
									professor.setMatricula(matriculaTemp);
									professor.setSenha(senhaTemp);
									professor.setNome(nomeTemp);
									professor.setId(idTemp);
									professor.setCpf(cpfTemp);
									professor.setMateria(materiaTemp);
									professor.setCidade(cidadeTemp);
									professor.setEstado(estadoTemp);

									LoginProfessor loginProfessor = new LoginProfessor();
									loginProfessor.setVisible(true);
									loginProfessor.setLocationRelativeTo(null);
									loginProfessor.exportar(professor);
									dispose();
								}
							}
						}
						br2.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
				
				
			}
		});
		btnLogin.setBackground(new Color(128, 0, 0));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Montserrat", Font.BOLD, 11));
		btnLogin.setBorder(null);
		btnLogin.setBounds(374, 256, 76, 32);
		jLoginPanel.add(btnLogin);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 290, 492);
		jLoginPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrar-se");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 25));
		lblNewLabel.setBounds(49, 191, 183, 59);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(53, 237, 59, 2);
		panel.add(panel_1);
		
		JButton btnRegistrar = new JButton("Registrar Aluno");
		btnRegistrar.setBounds(34, 271, 220, 23);
		panel.add(btnRegistrar);
		btnRegistrar.setBackground(new Color(255, 255, 255));
		btnRegistrar.setForeground(new Color(128, 0, 0));
		btnRegistrar.setFont(new Font("Montserrat", Font.BOLD, 11));
		btnRegistrar.setBorder(null);
		
		JButton btnRegistrarProfessor = new JButton("Registrar Professor");
		btnRegistrarProfessor.setBounds(34, 305, 220, 23);
		panel.add(btnRegistrarProfessor);
		btnRegistrarProfessor.setBackground(new Color(255, 255, 255));
		btnRegistrarProfessor.setForeground(new Color(128, 0, 0));
		btnRegistrarProfessor.setFont(new Font("Montserrat", Font.BOLD, 11));
		btnRegistrarProfessor.setBorder(null);
		
		JLabel lblFaculdadeBrasil = new JLabel("Faculdade Brasil");
		lblFaculdadeBrasil.setBounds(300, 27, 353, 68);
		jLoginPanel.add(lblFaculdadeBrasil);
		lblFaculdadeBrasil.setForeground(new Color(128, 0, 0));
		lblFaculdadeBrasil.setFont(new Font("Montserrat ExtraBold", Font.PLAIN, 35));
		lblFaculdadeBrasil.setHorizontalAlignment(SwingConstants.CENTER);
		btnRegistrarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarProfessor professor = new RegistrarProfessor();
				professor.setVisible(true);
				professor.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarAluno aluno =  new RegistrarAluno();
				aluno.setVisible(true);
				aluno.setLocationRelativeTo(null);
				dispose();
			}
		});
		
	}
	public boolean isAux() {
		return aux;
	}

	public void setAux(boolean aux) {
		this.aux = aux;
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
}
