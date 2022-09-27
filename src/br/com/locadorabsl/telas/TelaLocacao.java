/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.locadorabsl.telas;

import br.com.locadorabsl.dal.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class TelaLocacao extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaLocacao
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaLocacao() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

//    private void pesquisar() {
//    String sql = "select * from locacao where id_locacao=?";
//    try{
//        pst=conexao.prepareStatement(sql);
//        pst.setString(1,TxtLocId.getText());
//        rs=pst.executeQuery();
//        if (rs.next()) {
//        TxtLocCpf.setText(rs.getString(2));
//        TxtLocVei.setText(rs.getString(3));
//        TxtLocVal.setText(rs.getString(4));
//        TxtLocFun.setText(rs.getString(5));
//        TxtLocPer.setText(rs.getString(6));
//        } else{
//            JOptionPane.showMessageDialog(null, "Locação não cadastrada");
//            TxtLocId.setText(null);
//            TxtLocCpf.setText(null);
//            TxtLocVei.setText(null);
//            TxtLocVal.setText(null);
//            TxtLocFun.setText(null);
//            TxtLocPer.setText(null);      
//        
//        }
//    }catch (Exception e ){
//        JOptionPane.showMessageDialog(null, e);
//    } 
//}
    private void adicionar() {
        String sql = "insert into locacao(cpf_cliente, veiculo, periodo, valor, funcionario) values(?,?,?,?,?)";
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja adicionar esta locação?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, TxtLocCpf.getText());
                pst.setString(2, TxtLocVei.getText());
                pst.setString(3, TxtLocPer.getText());
                pst.setString(4, TxtLocVal.getText());
                pst.setString(5, TxtLocFun.getText());
                // validação dos campos obrigatórios
                if ((((TxtLocCpf.getText().isEmpty()) || (TxtLocVei.getText().isEmpty()))
                        || (TxtLocVal.getText().isEmpty())) || (TxtLocFun.getText().isEmpty()) || (TxtLocPer.getText().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
                } else {

                    // a linha abaixo atualiza com os dados do formulario
                    int adicionado = pst.executeUpdate();
                    if (adicionado > 0);
                    {
                        JOptionPane.showMessageDialog(null, "Locação adicionada com sucesso");
                        limpar();
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void editar() {
        String sql = "update locacao set cpf_cliente=?, veiculo=?, periodo=?, valor=?, funcionario=? where id_locacao=?";
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja editar esta locação?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, TxtLocCpf.getText());
                pst.setString(2, TxtLocVei.getText());
                pst.setString(3, TxtLocPer.getText());
                pst.setString(4, TxtLocVal.getText());
                pst.setString(5, TxtLocFun.getText());
                pst.setString(6, TxtLocId.getText());

                if ((((TxtLocCpf.getText().isEmpty()) || (TxtLocVei.getText().isEmpty()))
                        || (TxtLocVal.getText().isEmpty())) || (TxtLocFun.getText().isEmpty()) || (TxtLocPer.getText().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
                } else {
                    int adicionado = pst.executeUpdate();

                    if (adicionado > 0) {
                        JOptionPane.showMessageDialog(null, "Dados da locação alterados com sucesso");
                        limpar();

                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void remover() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esta locação?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from locacao where id_locacao=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, TxtLocId.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Locação removida com sucesso");
                    limpar();
                    

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }
    
    private void limpar(){
        TxtLocId.setText(null);
        TxtLocCpf.setText(null);
        TxtLocVei.setText(null);
        TxtLocVal.setText(null);
        TxtLocFun.setText(null);
        TxtLocPer.setText(null);
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
        TxtLocId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtLocCpf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtLocVei = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtLocVal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtLocFun = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtLocPer = new javax.swing.JTextField();
        BtnLocIns = new javax.swing.JButton();
        BtnLocEdi = new javax.swing.JButton();
        BtnLocExc = new javax.swing.JButton();
        BtnLocPes = new javax.swing.JButton();
        BtnBusCpf = new javax.swing.JButton();
        BtnLocLim = new javax.swing.JButton();
        BtnBusVei = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Locação");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ID");

        TxtLocId.setEditable(false);
        TxtLocId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtLocIdActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("CPF");

        TxtLocCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtLocCpfActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Veículo");

        TxtLocVei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtLocVeiActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Período");

        TxtLocVal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtLocValActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Valor");

        TxtLocFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtLocFunActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Funcionário");

        BtnLocIns.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/adicionarnovo.png"))); // NOI18N
        BtnLocIns.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnLocIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLocInsActionPerformed(evt);
            }
        });

        BtnLocEdi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/editar.png"))); // NOI18N
        BtnLocEdi.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnLocEdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLocEdiActionPerformed(evt);
            }
        });

        BtnLocExc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/excluir.png"))); // NOI18N
        BtnLocExc.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnLocExc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLocExcActionPerformed(evt);
            }
        });

        BtnLocPes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/pesquisar.png"))); // NOI18N
        BtnLocPes.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnLocPes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLocPesActionPerformed(evt);
            }
        });

        BtnBusCpf.setText("Buscar CPF");
        BtnBusCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBusCpfActionPerformed(evt);
            }
        });

        BtnLocLim.setText("Limpar Campos");
        BtnLocLim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLocLimActionPerformed(evt);
            }
        });

        BtnBusVei.setText("Buscar Veículo");
        BtnBusVei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBusVeiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(BtnLocIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(BtnLocPes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(BtnLocEdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(BtnLocExc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 95, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtLocVal)
                            .addComponent(TxtLocFun, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtLocPer, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtLocId, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtLocVei, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtLocCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BtnBusCpf)
                                    .addComponent(BtnBusVei)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(BtnLocLim)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtLocId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtLocCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBusCpf))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtLocVei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnBusVei)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(TxtLocPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxtLocVal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtLocFun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(BtnLocLim)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnLocExc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnLocPes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnLocIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnLocEdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );

        setBounds(0, 0, 671, 557);
    }// </editor-fold>//GEN-END:initComponents

    private void TxtLocIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtLocIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtLocIdActionPerformed

    private void TxtLocVeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtLocVeiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtLocVeiActionPerformed

    private void BtnLocInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLocInsActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_BtnLocInsActionPerformed

    private void BtnLocEdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLocEdiActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_BtnLocEdiActionPerformed

    private void BtnLocExcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLocExcActionPerformed
        // TODO add your handling code here:
        remover();
    }//GEN-LAST:event_BtnLocExcActionPerformed

    private void BtnLocPesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLocPesActionPerformed
        // TODO add your handling code here:
        TelaBuscaLocacao tela = new TelaBuscaLocacao();
        tela.setVisible(true);
    }//GEN-LAST:event_BtnLocPesActionPerformed

    private void BtnBusCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBusCpfActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaBuscaCPF().setVisible(true);
            }
        });

    }//GEN-LAST:event_BtnBusCpfActionPerformed

    private void TxtLocFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtLocFunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtLocFunActionPerformed

    private void TxtLocCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtLocCpfActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_TxtLocCpfActionPerformed

    private void TxtLocValActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtLocValActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtLocValActionPerformed

    private void BtnBusVeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBusVeiActionPerformed
        // TODO add your handling code here:
        TelaBuscaVeiCurto tela = new TelaBuscaVeiCurto();
        tela.setVisible(true);
    }//GEN-LAST:event_BtnBusVeiActionPerformed

    private void BtnLocLimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLocLimActionPerformed
        // TODO add your handling code here:
        TxtLocId.setText(null);
        TxtLocCpf.setText(null);
        TxtLocVei.setText(null);
        TxtLocVal.setText(null);
        TxtLocFun.setText(null);
        TxtLocPer.setText(null);
    }//GEN-LAST:event_BtnLocLimActionPerformed

    public static void clienteSelecionado(String cpf) {
        System.out.println("CPF ::: " + cpf);
        TxtLocCpf.setText(cpf);
    }

    public static void veiculoSelecionado(String veiculo) {
        TxtLocVei.setText(veiculo);
    }

    public static void locIdSelecionado(int id) {
        TxtLocId.setText(String.valueOf(id));
    }

    public static void periodoSelecionado(String periodo) {
        TxtLocPer.setText(periodo);
    }

    public static void valorSelecionado(float valor) {
        TxtLocVal.setText(String.valueOf(valor));
    }

    public static void funcionarioSelecionado(String funcionario) {
        TxtLocFun.setText(funcionario);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBusCpf;
    private javax.swing.JButton BtnBusVei;
    private javax.swing.JButton BtnLocEdi;
    private javax.swing.JButton BtnLocExc;
    private javax.swing.JButton BtnLocIns;
    private javax.swing.JButton BtnLocLim;
    private javax.swing.JButton BtnLocPes;
    private static javax.swing.JTextField TxtLocCpf;
    private static javax.swing.JTextField TxtLocFun;
    private static javax.swing.JTextField TxtLocId;
    private static javax.swing.JTextField TxtLocPer;
    private static javax.swing.JTextField TxtLocVal;
    private static javax.swing.JTextField TxtLocVei;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
