/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.locadorabsl.telas;

import br.com.locadorabsl.dal.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class TelaFuncionario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaFuncionario
     */
    public TelaFuncionario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

    private void pesquisar() {
        String sql = "select * from funcionario where id_func=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TxtFunId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                TxtFunNom.setText(rs.getString(2));
                TxtFunEnd.setText(rs.getString(3));
                TxtFunTel.setText(rs.getString(4));
                TxtFunFun.setText(rs.getString(5));
                TxtFunCpf.setText(rs.getString(6));
                TxtFunSal.setText(rs.getString(7));
            } else {
                JOptionPane.showMessageDialog(null, "Funcionário não cadastrado");
                limpar();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void adicionar() {
        String sql = "insert into funcionario(nome, endereco, telefone, funcao, cpf, salario) values(?,?,?,?,?,?)";
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja adicionar este funcionário?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, TxtFunNom.getText());
                pst.setString(2, TxtFunEnd.getText());
                pst.setString(3, TxtFunTel.getText());
                pst.setString(4, TxtFunFun.getText());
                pst.setString(5, TxtFunCpf.getText());
                pst.setString(6, TxtFunSal.getText());
                // validação dos campos obrigatórios
                if ((((TxtFunNom.getText().isEmpty()) || (TxtFunEnd.getText().isEmpty()))
                        || (TxtFunTel.getText().isEmpty())) || (TxtFunFun.getText().isEmpty()) || (TxtFunCpf.getText().isEmpty()) || (TxtFunSal.getText().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
                } else {

                    // a linha abaixo atualiza com os dados do formulario
                    int adicionado = pst.executeUpdate();
                    if (adicionado > 0);
                    {
                        JOptionPane.showMessageDialog(null, "Funcionário adicionado com sucesso");
                        limpar();
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void editar() {
        String sql = "update funcionario set nome=?, endereco=?, telefone=?, funcao=?, cpf=?, salario=? where id_func=?";
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja editar este funcionário?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, TxtFunNom.getText());
                pst.setString(2, TxtFunEnd.getText());
                pst.setString(3, TxtFunTel.getText());
                pst.setString(4, TxtFunFun.getText());
                pst.setString(5, TxtFunCpf.getText());
                pst.setString(6, TxtFunSal.getText());
                pst.setString(7, TxtFunId.getText());

                if ((((TxtFunNom.getText().isEmpty()))
                        || (TxtFunEnd.getText().isEmpty())) || (TxtFunTel.getText().isEmpty()) || (TxtFunFun.getText().isEmpty()) || (TxtFunCpf.getText().isEmpty()) || (TxtFunSal.getText().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
                } else {
                    int adicionado = pst.executeUpdate();

                    if (adicionado > 0) {
                        JOptionPane.showMessageDialog(null, "Dados do funcionário alterados com sucesso");
                        limpar();

                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void remover() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este funcionário?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from funcionario where id_func=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, TxtFunId.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso");
                    limpar();
                    

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }
    
    private void limpar(){
        TxtFunId.setText(null);
        TxtFunNom.setText(null);
        TxtFunEnd.setText(null);
        TxtFunTel.setText(null);
        TxtFunFun.setText(null);
        TxtFunCpf.setText(null);
        TxtFunSal.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TxtFunId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtFunCpf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtFunNom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtFunEnd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtFunTel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtFunFun = new javax.swing.JTextField();
        BtnFunIns = new javax.swing.JButton();
        BtnFunPes = new javax.swing.JButton();
        BtnFunEdi = new javax.swing.JButton();
        BtnFunExc = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        TxtFunSal = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Funcionario");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ID Funcionário:");

        TxtFunId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFunIdActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("CPF:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Nome:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Endereço:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Telefone:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Função:");

        BtnFunIns.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/adicionarnovo.png"))); // NOI18N
        BtnFunIns.setToolTipText("Inserir");
        BtnFunIns.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnFunIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFunInsActionPerformed(evt);
            }
        });

        BtnFunPes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/pesquisar.png"))); // NOI18N
        BtnFunPes.setToolTipText("Pesquisar");
        BtnFunPes.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnFunPes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFunPesActionPerformed(evt);
            }
        });

        BtnFunEdi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/editar.png"))); // NOI18N
        BtnFunEdi.setToolTipText("Editar");
        BtnFunEdi.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnFunEdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFunEdiActionPerformed(evt);
            }
        });

        BtnFunExc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/excluir.png"))); // NOI18N
        BtnFunExc.setToolTipText("Excluir");
        BtnFunExc.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnFunExc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFunExcActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Salário:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(BtnFunIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(BtnFunPes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(BtnFunEdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(BtnFunExc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtFunTel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TxtFunSal, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxtFunCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxtFunNom)
                        .addComponent(TxtFunEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxtFunId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TxtFunFun, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(TxtFunId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtFunNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtFunEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxtFunTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TxtFunFun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtFunCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TxtFunSal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnFunIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnFunEdi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(BtnFunPes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnFunExc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        setBounds(0, 0, 671, 557);
    }// </editor-fold>//GEN-END:initComponents

    private void TxtFunIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFunIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFunIdActionPerformed

    private void BtnFunInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFunInsActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_BtnFunInsActionPerformed

    private void BtnFunPesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFunPesActionPerformed
        // TODO add your handling code here:
        pesquisar();
    }//GEN-LAST:event_BtnFunPesActionPerformed

    private void BtnFunEdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFunEdiActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_BtnFunEdiActionPerformed

    private void BtnFunExcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFunExcActionPerformed
        // TODO add your handling code here:
        remover();
    }//GEN-LAST:event_BtnFunExcActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnFunEdi;
    private javax.swing.JButton BtnFunExc;
    private javax.swing.JButton BtnFunIns;
    private javax.swing.JButton BtnFunPes;
    private javax.swing.JTextField TxtFunCpf;
    private javax.swing.JTextField TxtFunEnd;
    private javax.swing.JTextField TxtFunFun;
    private javax.swing.JTextField TxtFunId;
    private javax.swing.JTextField TxtFunNom;
    private javax.swing.JTextField TxtFunSal;
    private javax.swing.JTextField TxtFunTel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
