package tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;

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
import javax.swing.SwingConstants;

public class ProcurarAluno extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatriculaAluno;
	private JLabel lblNome;
	private JLabel lblMatricula;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JLabel lblNomePai;
	private JLabel lblNomeDaMae;
	private JLabel lblNome_2;
	private JLabel lblMatricula_2;
	private JLabel lblCidade_2;
	private JLabel lblEstado_2;
	private JLabel lblNomeDoPai;
	private JLabel lblNomeDaMe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProcurarAluno frame = new ProcurarAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProcurarAluno() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 716, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMatriculaAluno = new JLabel("Digite a matricula do aluno");
		lblMatriculaAluno.setForeground(new Color(255, 255, 255));
		lblMatriculaAluno.setFont(new Font("Montserrat", Font.BOLD, 13));
		lblMatriculaAluno.setBounds(249, 59, 201, 16);
		contentPane.add(lblMatriculaAluno);
		
		txtMatriculaAluno = new JTextField();
		txtMatriculaAluno.setBounds(249, 88, 201, 22);
		contentPane.add(txtMatriculaAluno);
		txtMatriculaAluno.setColumns(10);
		
		JButton btnProcurarAluno = new JButton("Procurar");
		btnProcurarAluno.setForeground(new Color(128, 0, 0));
		btnProcurarAluno.setBackground(new Color(255, 255, 255));
		btnProcurarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procurar();	
				
			}
		});
		
		btnProcurarAluno.setFont(new Font("Montserrat", Font.BOLD, 13));
		btnProcurarAluno.setBounds(249, 123, 201, 25);
		contentPane.add(btnProcurarAluno);
		
		lblNome = new JLabel("");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Montserrat", Font.BOLD, 12));
		lblNome.setBounds(155, 174, 295, 16);
		contentPane.add(lblNome);
		
		lblMatricula = new JLabel("");
		lblMatricula.setForeground(new Color(255, 255, 255));
		lblMatricula.setFont(new Font("Montserrat", Font.BOLD, 12));
		lblMatricula.setBounds(155, 203, 295, 16);
		contentPane.add(lblMatricula);
		
		lblCidade = new JLabel("");
		lblCidade.setForeground(new Color(255, 255, 255));
		lblCidade.setFont(new Font("Montserrat", Font.BOLD, 12));
		lblCidade.setBounds(155, 232, 295, 16);
		contentPane.add(lblCidade);
		
		lblEstado = new JLabel("");
		lblEstado.setForeground(new Color(255, 255, 255));
		lblEstado.setFont(new Font("Montserrat", Font.BOLD, 12));
		lblEstado.setBounds(155, 261, 295, 16);
		contentPane.add(lblEstado);
		
		lblNomePai = new JLabel("");
		lblNomePai.setForeground(new Color(255, 255, 255));
		lblNomePai.setFont(new Font("Montserrat", Font.BOLD, 12));
		lblNomePai.setBounds(155, 290, 295, 16);
		contentPane.add(lblNomePai);
		
		lblNomeDaMae = new JLabel("");
		lblNomeDaMae.setForeground(new Color(255, 255, 255));
		lblNomeDaMae.setFont(new Font("Montserrat", Font.BOLD, 12));
		lblNomeDaMae.setBounds(155, 319, 295, 16);
		contentPane.add(lblNomeDaMae);
		
		lblNome_2 = new JLabel("Nome:");
		lblNome_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome_2.setForeground(Color.WHITE);
		lblNome_2.setFont(new Font("Montserrat", Font.BOLD, 12));
		lblNome_2.setBounds(51, 176, 94, 16);
		contentPane.add(lblNome_2);
		
		lblMatricula_2 = new JLabel("Matricula:");
		lblMatricula_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMatricula_2.setForeground(Color.WHITE);
		lblMatricula_2.setFont(new Font("Montserrat", Font.BOLD, 12));
		lblMatricula_2.setBounds(51, 205, 94, 16);
		contentPane.add(lblMatricula_2);
		
		lblCidade_2 = new JLabel("Cidade:");
		lblCidade_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade_2.setForeground(Color.WHITE);
		lblCidade_2.setFont(new Font("Montserrat", Font.BOLD, 12));
		lblCidade_2.setBounds(51, 234, 94, 16);
		contentPane.add(lblCidade_2);
		
		lblEstado_2 = new JLabel("Estado:");
		lblEstado_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado_2.setForeground(Color.WHITE);
		lblEstado_2.setFont(new Font("Montserrat", Font.BOLD, 12));
		lblEstado_2.setBounds(51, 263, 94, 16);
		contentPane.add(lblEstado_2);
		
		lblNomeDoPai = new JLabel("Nome do Pai:");
		lblNomeDoPai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeDoPai.setForeground(Color.WHITE);
		lblNomeDoPai.setFont(new Font("Montserrat", Font.BOLD, 12));
		lblNomeDoPai.setBounds(27, 292, 118, 16);
		contentPane.add(lblNomeDoPai);
		
		lblNomeDaMe = new JLabel("Nome da M\u00E3e:");
		lblNomeDaMe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeDaMe.setForeground(Color.WHITE);
		lblNomeDaMe.setFont(new Font("Montserrat", Font.BOLD, 12));
		lblNomeDaMe.setBounds(27, 317, 118, 16);
		contentPane.add(lblNomeDaMe);
	}
		public void procurar() {
			String caminhoAluno ="C:\\Users\\mmaci\\Documents\\Estudo\\Curso de Java Se e Banco de Dados\\Aulas\\Sistema_Faculdade\\src\\bancoDados\\bancoAluno.txt";
			String caminhoProfessor = "C:\\Users\\mmaci\\Documents\\Estudo\\Curso de Java Se e Banco de Dados\\Aulas\\Sistema_Faculdade\\src\\bancoDados\\bancoProfessor.txt";
			if(testarCaminho(caminhoAluno, caminhoProfessor)) {
				String matricula = txtMatriculaAluno.getText();
				try {
					BufferedReader br = new BufferedReader(new FileReader(caminhoAluno));
					while(br.ready()) {
						String linha = br.readLine();
						String matriculaTemp = linha.substring(linha.indexOf("%") + 1, linha.indexOf("&"));
						String nomeTemp = linha.substring(linha.indexOf("!")+1, linha.indexOf("@"));
						String nomePaiTemp = linha.substring(linha.indexOf("#")+1, linha.indexOf("$"));
						String nomeMaeTemp = linha.substring(linha.indexOf("$")+1, linha.indexOf("%"));
						String cidadeTemp = linha.substring(linha.lastIndexOf("*")+1, linha.lastIndexOf("!"));
						String estadoTemp = linha.substring(linha.lastIndexOf("!")+1);
						if(matriculaTemp.equals(matricula)) {
								lblNome.setText(nomeTemp);
								lblMatricula.setText(matriculaTemp);
								lblNomeDaMae.setText(nomeMaeTemp);
								lblNomePai.setText(nomePaiTemp);
								lblCidade.setText(cidadeTemp);
								lblEstado.setText(estadoTemp);
						}
					}
					br.close();
				}catch (Exception e) {
				}
			}
				
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
