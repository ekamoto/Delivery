/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author hisamoto
 */
public class JanelaLogin extends javax.swing.JFrame {

	private JanelaPrincipal janelaPrincipal;
	private static JTextField campo2;
	private static String valor2;
   
    /**
     * Creates new form login
     */
    public JanelaLogin() {
        initComponents();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuario = new javax.swing.JTextField();
        //usuario.setFocusable(false);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        senha = new javax.swing.JPasswordField();
        //senha.setFocusable(false);
        
//        usuario.setText("Usuário");
//        usuario.addMouseListener(new MouseListener() {
//			
//			@Override
//			public void mouseReleased(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mousePressed(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//		
//				
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//				
//				if(usuario.getText().equals("Usuário")||usuario.getText().equals("")) {
//					
//					usuario.setText("Usuário");
//				}
//				usuario.setFocusable(false);
//			}
//			
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				
//				// TODO Auto-generated method stub
////				if(usuario.getText().equals("Usuário")) {
////					
////					usuario.setText("");
////				}
//			}
//			
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				if(usuario.getText().equals("Usuário")||usuario.getText().equals("")) {
//					
//					usuario.setText("");
//					
//					System.out.println("clicou");
//					usuario.setFocusable(true);
//					
//				}
//			}
//		});
//        
//        usuario.addFocusListener(new FocusListener() {
//			
//			@Override
//			public void focusLost(FocusEvent arg0) {
//				// TODO Auto-generated method stub
//				System.out.println("opa");
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void focusGained(FocusEvent arg0) {
//				// TODO Auto-generated method stub
//				System.out.println("opa2");
//				// TODO Auto-generated method stub
//				if(usuario.getText().equals("Usuário")) {
//					
//					usuario.setText("");
//				}
//				
//			}
//		});
//        
//        senha.setText("Senha");
//        
//        senha.addMouseListener(new MouseListener() {
//			
//			@Override
//			public void mouseReleased(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mousePressed(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//				
//				if(senha.getText().equals("Senha")||senha.getText().equals("")) {
//					
//					senha.setText("Senha");
//				}
//			}
//			
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				
//				// TODO Auto-generated method stub
//				if(senha.getText().equals("Senha")) {
//					
//					senha.setText("");
//				}
//			}
//			
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				
//			}
//		});
//        
//        senha.addFocusListener(new FocusListener() {
//			
//			@Override
//			public void focusLost(FocusEvent arg0) {
//				// TODO Auto-generated method stub
//				System.out.println("opa");
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void focusGained(FocusEvent arg0) {
//				// TODO Auto-generated method stub
//				System.out.println("opa2");
//				// TODO Auto-generated method stub
//				if(senha.getText().equals("Senha")) {
//					
//					senha.setText("");
//				}
//				
//			}
//		});

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        usuario.setName("senha"); // NOI18N
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        
        Font fontUsuario = new Font("TimesRoman", Font.BOLD, 15);
        
        jLabel1.setText("Usuário");
        jLabel1.setFont(fontUsuario);

        Font fontSenha = new Font("TimesRoman", Font.BOLD, 15);
        
        jLabel2.setText("Senha");
        jLabel2.setFont(fontSenha);

        jButton1.setText("Acesso");
        
        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        jLabel3.setText("Delivery");
        Font font = new Font("TimesRoman", Font.BOLD, 30);
        jLabel3.setFont(font);

        senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(73)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel1)
        						.addComponent(jLabel2))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(usuario, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
        						.addComponent(senha, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(177, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(39)
        			.addComponent(jLabel3)
        			.addGap(41)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(usuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel1))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(jButton1)
        			.addContainerGap(142, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);
        
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String usuarioAdmin = usuario.getText();
       String senhaAdmin = senha.getText();
       if(usuarioAdmin.equals("ekamoto") && senhaAdmin.equals("senha123")) {
            this.dispose();
            String[] args = null;
            this.janelaPrincipal = new JanelaPrincipal();     
       } else {
           JOptionPane.showMessageDialog(null, "Usuário ou Senha incorretos!");
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void start() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	JanelaLogin teste = new JanelaLogin();
            	teste.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField usuario;
    
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField senha;
    // End of variables declaration//GEN-END:variables
}