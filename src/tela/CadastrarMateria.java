package tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import faculdade.Aluno;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarMateria extends JFrame {

	private JPanel contentPane;
	private JTextField txtCadastroMaterias;
	private JLabel lblNomeAluno;
	private JLabel lblMatricula;
	private JButton btnIncluir;
	private JTextArea txtMateriasDisponiveis;
	private JTextArea txtMateriasAcumuladas;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarMateria frame = new CadastrarMateria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastrarMateria() {
		setBounds(100, 100, 785, 452);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNomeAluno = new JLabel("Nome");
		lblNomeAluno.setFont(new Font("Montserrat", Font.BOLD, 26));
		lblNomeAluno.setForeground(new Color(255, 255, 255));
		lblNomeAluno.setBounds(24, 22, 552, 33);
		contentPane.add(lblNomeAluno);

		JLabel lblNewLabel_1 = new JLabel("Materias para cursar:");
		lblNewLabel_1.setFont(new Font("Montserrat", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(24, 125, 171, 17);
		contentPane.add(lblNewLabel_1);

		txtMateriasDisponiveis = new JTextArea();
		txtMateriasDisponiveis.setEditable(false);
		txtMateriasDisponiveis.setFont(new Font("Montserrat", Font.BOLD, 13));
		txtMateriasDisponiveis.setBackground(new Color(128, 0, 0));
		txtMateriasDisponiveis.setForeground(new Color(255, 255, 255));
		txtMateriasDisponiveis.setBounds(24, 153, 152, 213);
		contentPane.add(txtMateriasDisponiveis);

		JLabel lblNewLabel_1_1 = new JLabel("Inserir Materia:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Montserrat", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(215, 127, 139, 17);
		contentPane.add(lblNewLabel_1_1);

		txtCadastroMaterias = new JTextField();
		txtCadastroMaterias.setForeground(new Color(128, 0, 0));
		txtCadastroMaterias.setFont(new Font("Montserrat", Font.BOLD, 13));
		txtCadastroMaterias.setBounds(213, 155, 141, 20);
		contentPane.add(txtCadastroMaterias);
		txtCadastroMaterias.setColumns(10);

		btnIncluir = new JButton("Inserir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirMateria();
			}
		});
		btnIncluir.setFont(new Font("Montserrat", Font.BOLD, 13));
		btnIncluir.setBackground(new Color(255, 255, 255));
		btnIncluir.setForeground(new Color(128, 0, 0));
		btnIncluir.setBounds(364, 154, 89, 23);
		contentPane.add(btnIncluir);

		txtMateriasAcumuladas = new JTextArea();
		txtMateriasAcumuladas.setEditable(false);
		txtMateriasAcumuladas.setFont(new Font("Montserrat", Font.BOLD, 13));
		txtMateriasAcumuladas.setForeground(new Color(255, 255, 255));
		txtMateriasAcumuladas.setBackground(new Color(128, 0, 0));
		txtMateriasAcumuladas.setBounds(484, 153, 239, 233);
		contentPane.add(txtMateriasAcumuladas);

		JLabel lblNewLabel_1_1_1 = new JLabel("Materias Cadastradas:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Montserrat", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(485, 127, 188, 17);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblMatricula_2 = new JLabel("Matricula:");
		lblMatricula_2.setFont(new Font("Montserrat", Font.BOLD, 13));
		lblMatricula_2.setForeground(new Color(255, 255, 255));
		lblMatricula_2.setBounds(24, 66, 79, 14);
		contentPane.add(lblMatricula_2);

		lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Montserrat", Font.BOLD, 13));
		lblMatricula.setForeground(Color.WHITE);
		lblMatricula.setBounds(113, 66, 219, 14);
		contentPane.add(lblMatricula);
	}

	public void exportar(String nome, String matricula) {
		lblNomeAluno.setText(nome);
		lblMatricula.setText(matricula);
	}

	public void verMaterias() {
		String caminhoProfessor = "C:\\Users\\mmaci\\Documents\\Estudo\\Curso de Java Se e Banco de Dados\\Aulas\\Sistema_Faculdade\\src\\bancoDados\\bancoProfessor.txt";
		if (testarCaminho(caminhoProfessor, caminhoProfessor)) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(caminhoProfessor));
				while (br.ready()) {
					String linha = br.readLine();
					String materia = linha.substring(linha.indexOf("#") + 1, linha.indexOf("$"));
					txtMateriasDisponiveis.append(materia + "\n");
				}
				br.close();

			} catch (Exception e) {

			}
		}
	}

	public static boolean testarCaminho(String caminho1, String caminho2) {
		File cam = new File(caminho1);
		File cam2 = new File(caminho2);
		if (cam.exists() && cam2.exists()) {
			return true;

		} else
			try {
				if (cam.createNewFile() && cam2.createNewFile()) {
					return true;
				} else {
					return false;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		return false;
	}

	public void inserirMateria() {
		String caminhoProfessor = "C:\\Users\\mmaci\\Documents\\Estudo\\Curso de Java Se e Banco de Dados\\Aulas\\Sistema_Faculdade\\src\\bancoDados\\bancoProfessor.txt";
		String caminhoMateria = "C:\\Users\\mmaci\\Documents\\Estudo\\Curso de Java Se e Banco de Dados\\Aulas\\Sistema_Faculdade\\src\\bancoDados\\bancoMateria.txt";
		String materiatxt = null;
		String matriculatxt = null;
		int cont = 0;
		if(testarCaminho(caminhoProfessor, caminhoMateria)) {
			String materiaTemp = txtCadastroMaterias.getText();
			materiaTemp.trim();
			try {
				BufferedReader br = new BufferedReader(new FileReader(caminhoProfessor));
				while(br.ready()) {
					String linha = br.readLine();
					materiatxt = linha.substring(linha.indexOf("#")+1 , linha.indexOf("$"));
					matriculatxt = linha.substring(linha.indexOf("%")+1, linha.indexOf("&"));
					if(materiaTemp.equals(materiatxt)) {
						cont++;		
					}
				}
				BufferedReader br2 = new BufferedReader(new FileReader(caminhoMateria));
				while(br2.ready()) {
					String linha2 = br2.readLine();
					String materiatxt2 = linha2.substring(linha2.indexOf("!")+1 , linha2.indexOf("@"));
					if(materiaTemp.equals(materiatxt2)) {
						cont++;
					}else {
						
					}
				}
				if(cont == 2) {
					JOptionPane.showMessageDialog(null, "você já possui essa materia");
				}else if(cont ==1) {
					BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoMateria, true));
					String matricula = lblMatricula.getText();
					String nomeAluno = lblNomeAluno.getText();
					bw.write(matriculatxt + "!" + materiaTemp + "@"+ nomeAluno+ "#" + matricula);
					bw.newLine();
					bw.close();
					txtMateriasAcumuladas.append(materiaTemp + "\n");
				}else{
					JOptionPane.showMessageDialog(null, "Materia inexistente");
				}
			} catch (Exception e) {
				
			}
		}
	}
	public void verMateriasAcumuladas() {
		String caminhoMateria = "C:\\Users\\mmaci\\Documents\\Estudo\\Curso de Java Se e Banco de Dados\\Aulas\\Sistema_Faculdade\\src\\bancoDados\\bancoMateria.txt";
		if (testarCaminho(caminhoMateria, caminhoMateria)) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(caminhoMateria));
				while (br.ready()) {
					String linha = br.readLine();
					String materia = linha.substring(linha.indexOf("!") + 1, linha.indexOf("@"));
					txtMateriasAcumuladas.append(materia + "\n");
				}
				br.close();

			} catch (Exception e) {

			}
		}
	}
}
