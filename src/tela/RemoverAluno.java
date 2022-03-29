package tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.JobAttributes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class RemoverAluno extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JLabel lblSucesso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverAluno frame = new RemoverAluno();
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
	public RemoverAluno() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 781, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setForeground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Digite a matricula do aluno para remover");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(152, 54, 460, 52);
		contentPane.add(lblTitulo);
		
		txtNome = new JTextField();
		txtNome.setForeground(new Color(128, 0, 0));
		txtNome.setFont(new Font("Montserrat", Font.BOLD, 15));
		txtNome.setBounds(223, 119, 319, 25);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setForeground(new Color(128, 0, 0));
		btnRemover.setFont(new Font("Montserrat", Font.BOLD, 14));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
				
			}
		});
		btnRemover.setBounds(223, 165, 319, 40);
		contentPane.add(btnRemover);
		
		lblSucesso = new JLabel("");
		lblSucesso.setForeground(new Color(255, 255, 255));
		lblSucesso.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblSucesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblSucesso.setBounds(265, 252, 225, 52);
		contentPane.add(lblSucesso);
	}
	public void remover() {
		String caminhoAluno ="C:\\Users\\mmaci\\Documents\\Estudo\\Curso de Java Se e Banco de Dados\\Aulas\\Sistema_Faculdade\\src\\bancoDados\\bancoAluno.txt";
		String caminhoAlunoTemp = "C:\\Users\\mmaci\\Documents\\Estudo\\Curso de Java Se e Banco de Dados\\Aulas\\Sistema_Faculdade\\src\\bancoDados\\bancoAlunotemp.txt";
		if(testarCaminho(caminhoAluno, caminhoAlunoTemp)) {
			String matricula = txtNome.getText();
			try {
				BufferedReader br = new BufferedReader(new FileReader(caminhoAluno));
				BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoAlunoTemp));
				
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
					if(matriculaTemp.equals(matricula)) {
							
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
				lblSucesso.setText("Removido com sucesso");
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
