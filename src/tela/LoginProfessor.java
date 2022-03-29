package tela;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import faculdade.Professor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class LoginProfessor extends JFrame {

	private JPanel contentPane;
	private JLabel lblMatricula;
	private JLabel lblcpf;
	private JLabel lblNomeProfessor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginProfessor frame = new LoginProfessor();
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
	public LoginProfessor() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 803, 462);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnProcurarAluno = new JButton("Procurar Aluno");
		btnProcurarAluno.setBorder(null);
		btnProcurarAluno.setFont(new Font("Montserrat", Font.BOLD, 13));
		btnProcurarAluno.setBackground(new Color(255, 255, 255));
		btnProcurarAluno.setForeground(new Color(128, 0, 0));
		btnProcurarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProcurarAluno procurarAluno = new ProcurarAluno();
				procurarAluno.setVisible(true);
				procurarAluno.setLocationRelativeTo(null);
			}
		});
		btnProcurarAluno.setBounds(10, 113, 168, 27);
		contentPane.add(btnProcurarAluno);
		
		JButton btnRemoverAluno = new JButton("Remover aluno");
		btnRemoverAluno.setBorder(null);
		btnRemoverAluno.setFont(new Font("Montserrat", Font.BOLD, 13));
		btnRemoverAluno.setForeground(new Color(128, 0, 0));
		btnRemoverAluno.setBackground(new Color(255, 255, 255));
		btnRemoverAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoverAluno removerAluno = new RemoverAluno();
				removerAluno.setVisible(true);
				removerAluno.setLocationRelativeTo(null);
			}
		});
		btnRemoverAluno.setBounds(10, 151, 168, 27);
		contentPane.add(btnRemoverAluno);
		
		lblNomeProfessor = new JLabel("Nome");
		lblNomeProfessor.setFont(new Font("Montserrat", Font.BOLD, 26));
		lblNomeProfessor.setForeground(new Color(255, 255, 255));
		lblNomeProfessor.setBounds(12, 13, 735, 53);
		contentPane.add(lblNomeProfessor);
		
		JLabel lblLabel = new JLabel("Matricula:");
		lblLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLabel.setForeground(new Color(255, 255, 255));
		lblLabel.setFont(new Font("Montserrat", Font.BOLD, 13));
		lblLabel.setBounds(345, 113, 88, 14);
		contentPane.add(lblLabel);
		
		JLabel lbllabel2 = new JLabel("Cpf:");
		lbllabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllabel2.setForeground(Color.WHITE);
		lbllabel2.setFont(new Font("Montserrat", Font.BOLD, 13));
		lbllabel2.setBounds(345, 144, 88, 14);
		contentPane.add(lbllabel2);
		
		lblcpf = new JLabel("");
		lblcpf.setForeground(Color.WHITE);
		lblcpf.setFont(new Font("Montserrat", Font.BOLD, 13));
		lblcpf.setBounds(442, 144, 182, 14);
		contentPane.add(lblcpf);
		
		lblMatricula = new JLabel("");
		lblMatricula.setForeground(Color.WHITE);
		lblMatricula.setFont(new Font("Montserrat", Font.BOLD, 13));
		lblMatricula.setBounds(442, 114, 88, 14);
		contentPane.add(lblMatricula);
		
		JButton btnCadastrarNota = new JButton("Cadastrar Nota");
		btnCadastrarNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCadastrarNota.setBorder(null);
		btnCadastrarNota.setForeground(new Color(128, 0, 0));
		btnCadastrarNota.setFont(new Font("Montserrat", Font.BOLD, 13));
		btnCadastrarNota.setBackground(Color.WHITE);
		btnCadastrarNota.setBounds(10, 189, 168, 27);
		contentPane.add(btnCadastrarNota);
		
		JButton btnListarAlunos = new JButton("Listar Alunos");
		btnListarAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerAlunos verAlunos = new VerAlunos();
				verAlunos.setVisible(true);
				verAlunos.setLocationRelativeTo(null);
				verAlunos.exportar(lblMatricula.getText());
				
			}
		});
		btnListarAlunos.setBorder(null);
		btnListarAlunos.setForeground(new Color(128, 0, 0));
		btnListarAlunos.setFont(new Font("Montserrat", Font.BOLD, 13));
		btnListarAlunos.setBackground(Color.WHITE);
		btnListarAlunos.setBounds(10, 227, 168, 27);
		contentPane.add(btnListarAlunos);
		
		JLabel lblAlunos = new JLabel("Alunos:");
		lblAlunos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlunos.setForeground(Color.WHITE);
		lblAlunos.setFont(new Font("Montserrat", Font.BOLD, 13));
		lblAlunos.setBounds(346, 179, 88, 14);
		contentPane.add(lblAlunos);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setFont(new Font("Montserrat", Font.BOLD, 13));
		textArea.setCaretColor(new Color(255, 255, 255));
		textArea.setBackground(new Color(128, 0, 0));
		textArea.setBounds(443, 180, 320, 232);
		contentPane.add(textArea);
	}
	public void exportar(Professor professor) {
		lblNomeProfessor.setText(professor.getNome());
		lblMatricula.setText(professor.getMatricula());
		lblcpf.setText(professor.getCpf());
		
	}
}
