package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ViewFormulario {

	public JFrame frmNovaMensagem;
	public JTextField txtDestinatarios;
	public JTextField txtAssunto;
	public JTextPane txtMensagem;
	public JButton btnEnviar;
	public JLabel lblDestinatario;
	public JLabel lblAssunto;
	public JLabel lblMensagem;     
	
	public void checkBtn() {
		boolean valorDestinatarios = !txtDestinatarios.getText().trim().isEmpty();
		boolean valorAssunto = !txtAssunto.getText().trim().isEmpty();
		boolean valorMensagem = !txtMensagem.getText().trim().isEmpty();
		
		if(valorDestinatarios == true && valorAssunto == true && valorMensagem == true) {
			btnEnviar.setEnabled(true);
		}else {
			btnEnviar.setEnabled(false);
		}
	}	
	
	public ViewFormulario() {
		initialize();
	}
	
	public static void main(String[] args) {
		 try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(ViewFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(ViewFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(ViewFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(ViewFormulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	      
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new ViewFormulario().frmNovaMensagem.setVisible(true);
	            }
	        });
	}


	private void initialize() {
		frmNovaMensagem = new JFrame();
		frmNovaMensagem.setResizable(false);
		frmNovaMensagem.setBackground(Color.DARK_GRAY);
		frmNovaMensagem.getContentPane().setBackground(Color.DARK_GRAY);
		frmNovaMensagem.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Matheus\\Downloads\\email icon.png"));
		frmNovaMensagem.setTitle("Nova Mensagem");
		frmNovaMensagem.setBounds(100, 100, 550, 410);
		frmNovaMensagem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNovaMensagem.getContentPane().setLayout(null);
		
		// Label "Destinatário: "
		lblDestinatario = new JLabel("Destinat\u00E1rio:");
		lblDestinatario.setForeground(Color.WHITE);
		lblDestinatario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDestinatario.setBounds(10, -7, 89, 39);
		frmNovaMensagem.getContentPane().add(lblDestinatario);
				
		// Preenchimento do e-mail destinatário
		txtDestinatarios = new JTextField();
		txtDestinatarios.setBackground(Color.LIGHT_GRAY);
		txtDestinatarios.setForeground(Color.BLACK);
		txtDestinatarios.addMouseMotionListener(null);
		txtDestinatarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDestinatarios.setBounds(10, 20, 516, 29);
		frmNovaMensagem.getContentPane().add(txtDestinatarios);
		txtDestinatarios.setColumns(10);
		txtDestinatarios.getDocument().addDocumentListener(new DocumentListener() {
					public void insertUpdate(DocumentEvent e) {
						checkBtn();
					}
					public void removeUpdate(DocumentEvent e) {
						checkBtn();
					}

					public void changedUpdate(DocumentEvent e) {
						checkBtn();
					}
				});
		
		// Label "Assunto: "
		lblAssunto = new JLabel("Assunto: ");
		lblAssunto.setForeground(Color.WHITE);
		lblAssunto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAssunto.setBounds(10, 42, 58, 39);
		frmNovaMensagem.getContentPane().add(lblAssunto);

		// Preenchimento do assunto do e-mail
		txtAssunto = new JTextField();
		txtAssunto.setForeground(Color.BLACK);
		txtAssunto.setBackground(Color.LIGHT_GRAY);
		txtAssunto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAssunto.setBounds(10, 69, 516, 29);
		frmNovaMensagem.getContentPane().add(txtAssunto);
		txtAssunto.setColumns(10);
		txtAssunto.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				checkBtn();
			}
			public void removeUpdate(DocumentEvent e) {
				checkBtn();
			}

			public void changedUpdate(DocumentEvent e) {
				checkBtn();
			}
		});
		// Label "Digite sua mensagem: "
		lblMensagem = new JLabel("Digite sua mensagem: ");
		lblMensagem.setForeground(Color.WHITE);
		lblMensagem.setVerticalAlignment(SwingConstants.TOP);
		lblMensagem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMensagem.setBounds(10, 102, 162, 17);
		frmNovaMensagem.getContentPane().add(lblMensagem);

		// Preenchimento da Mensagem do e-mail
		txtMensagem = new JTextPane();
		txtMensagem.setBackground(Color.LIGHT_GRAY);
		txtMensagem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMensagem.setBounds(10, 118, 516, 201);
		frmNovaMensagem.getContentPane().add(txtMensagem);
		txtMensagem.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				checkBtn();
			}
			public void removeUpdate(DocumentEvent e) {
				checkBtn();
			}

			public void changedUpdate(DocumentEvent e) {
				checkBtn();
			}
		});
		
		// Botão de enviar o e-mail
		btnEnviar = new JButton("Enviar");
		btnEnviar.setForeground(Color.BLACK);
		btnEnviar.setBackground(Color.LIGHT_GRAY);
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEnviar.setBounds(10, 329, 148, 34);
		frmNovaMensagem.getContentPane().add(btnEnviar);
		btnEnviar.setEnabled(false);
		
		// Adicionando a função de envio do formulário
		btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	 Properties propriedade = new Properties();
                 propriedade.setProperty("mail.smtp.host","smtp.gmail.com");
                 propriedade.setProperty("mail.smtp.starttls.enable","true");
                 propriedade.setProperty("mail.smtp.port","587");
                 propriedade.setProperty("mail.smtp.auth","true");
                 
                 
                 Session sessao = Session.getDefaultInstance(propriedade);
                 
                 String emailLogin = "apsredes2022@gmail.com";
                 String senhaEmail = "Wescley1990";
                 // Lembrar
                 String destinatario = txtDestinatarios.getText();
                 String assunto = txtAssunto.getText();
                 String mensagem = txtMensagem.getText();
                 
                 
                 MimeMessage mail = new MimeMessage(sessao);
                         
                 try {
                     mail.setFrom(new InternetAddress (emailLogin));
                     mail.addRecipient(Message.RecipientType.TO, new InternetAddress (destinatario));
                     mail.setSubject(assunto);
                     mail.setText(mensagem);
                     
                     Transport transporte = sessao.getTransport("smtp");
                     transporte.connect(emailLogin, senhaEmail);
                     transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
                     transporte.close();
                     txtDestinatarios.setText("");
                     txtAssunto.setText("");
                     txtMensagem.setText("");
                     JOptionPane.showMessageDialog(null, "Correio Enviado!");
                     
                 } catch (AddressException ex) {
                     Logger.getLogger(ViewFormulario.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (MessagingException ex) {
                     Logger.getLogger(ViewFormulario.class.getName()).log(Level.SEVERE, null, ex);
                 }         
            }
        });
	}
}
