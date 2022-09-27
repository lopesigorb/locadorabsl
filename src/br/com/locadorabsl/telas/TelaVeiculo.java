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
public class TelaVeiculo extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaVeiculo
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaVeiculo() {
        initComponents();
        conexao = ModuloConexao.conector();
    }

//    private void pesquisar() {
//        String sql = "Select * from veiculo where id_veiculo = ?";
//        try {
//            pst = conexao.prepareStatement(sql);
//            pst.setString(1, TxtVeiId.getText());
//            rs = pst.executeQuery();
//            if (rs.next()) {
//                TxtVeiPla.setText(rs.getString(2));
//                TxtVeiMar.setText(rs.getString(3));
//                TxtVeiMod.setText(rs.getString(4));
//                TxtVeiCor.setText(rs.getString(5));
//                TxtVeiAno.setText(rs.getString(6));
//                TxtVeiRen.setText(rs.getString(7));
//                TxtVeiCha.setText(rs.getString(8));
//                TxtVeiObs.setText(rs.getString(9));
//                TxtVeiQui.setText(rs.getString(10));
//                TxtVeiAqu.setText(rs.getString(11));
//            } else {
//                JOptionPane.showMessageDialog(null, "Veiculo não cadastrado");
//                TxtVeiId.setText(null);
//                TxtVeiPla.setText(null);
//                TxtVeiMar.setText(null);
//                TxtVeiMod.setText(null);
//                TxtVeiCor.setText(null);
//                TxtVeiAno.setText(null);
//                TxtVeiRen.setText(null);
//                TxtVeiCha.setText(null);
//                TxtVeiObs.setText(null);
//                TxtVeiQui.setText(null);
//                TxtVeiAqu.setText(null);
//            }
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
    private void adicionar() {
        String sql = "insert into veiculo(placa, marca, modelo, cor, ano, renavam, chassi, observacao, quilom, aquisicao) values (?,?,?,?,?,?,?,?,?,?)";
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja adicionar este veículo?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, TxtVeiPla.getText());
                pst.setString(2, TxtVeiMar.getText());
                pst.setString(3, TxtVeiMod.getText());
                pst.setString(4, TxtVeiCor.getText());
                pst.setString(5, TxtVeiAno.getText());
                pst.setString(6, TxtVeiRen.getText());
                pst.setString(7, TxtVeiCha.getText());
                pst.setString(8, TxtVeiObs.getText());
                pst.setString(9, TxtVeiQui.getText());
                pst.setString(10, TxtVeiAqu.getText());
                //validação dos campos obrigatórios
                if ((((TxtVeiPla.getText().isEmpty()))
                        || (TxtVeiMar.getText().isEmpty())) || (TxtVeiMod.getText().isEmpty()) || (TxtVeiCor.getText().isEmpty()) || (TxtVeiAno.getText().isEmpty()) || (TxtVeiRen.getText().isEmpty()) || (TxtVeiCha.getText().isEmpty()) || (TxtVeiQui.getText().isEmpty()) || (TxtVeiAqu.getText().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
                } else {
                    // a linha abaixo atualiza com os dados do formulario
                    int adicionado = pst.executeUpdate();
                    if (adicionado > 0);
                    {
                        JOptionPane.showMessageDialog(null, "Veículo adicionado com sucesso");
                        limpar();
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void editar() {
        String sql = "update veiculo set placa=?, marca=?, modelo=?, cor=?, ano=?, renavam=?, chassi=?, observacao=?, quilom=?, aquisicao=? where id_veiculo = ?";
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja editar este veículo?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, TxtVeiPla.getText());
                pst.setString(2, TxtVeiMar.getText());
                pst.setString(3, TxtVeiMod.getText());
                pst.setString(4, TxtVeiCor.getText());
                pst.setString(5, TxtVeiAno.getText());
                pst.setString(6, TxtVeiRen.getText());
                pst.setString(7, TxtVeiCha.getText());
                pst.setString(8, TxtVeiObs.getText());
                pst.setString(9, TxtVeiQui.getText());
                pst.setString(10, TxtVeiAqu.getText());
                pst.setString(11, TxtVeiId.getText());

                if ((((TxtVeiPla.getText().isEmpty()))
                        || (TxtVeiMar.getText().isEmpty())) || (TxtVeiMod.getText().isEmpty()) || (TxtVeiCor.getText().isEmpty()) || (TxtVeiAno.getText().isEmpty()) || (TxtVeiRen.getText().isEmpty()) || (TxtVeiCha.getText().isEmpty()) || (TxtVeiQui.getText().isEmpty()) || (TxtVeiAqu.getText().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
                } else {
                    int adicionado = pst.executeUpdate();
                    if (adicionado > 0);
                    {
                        JOptionPane.showMessageDialog(null, "Dados do veículo alterados com sucesso");
                        limpar();
                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void remover() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este veículo?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from veiculo where id_veiculo=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, TxtVeiId.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Veiculo removido com sucesso");
                    limpar();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

    
    private void limpar(){
        TxtVeiId.setText(null);
        TxtVeiPla.setText(null);
        TxtVeiMar.setText(null);
        TxtVeiMod.setText(null);
        TxtVeiCor.setText(null);
        TxtVeiAno.setText(null);
        TxtVeiRen.setText(null);
        TxtVeiCha.setText(null);
        TxtVeiObs.setText(null);
        TxtVeiQui.setText(null);
        TxtVeiAqu.setText(null);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TxtVeiId = new javax.swing.JTextField();
        TxtVeiPla = new javax.swing.JTextField();
        TxtVeiMar = new javax.swing.JTextField();
        TxtVeiMod = new javax.swing.JTextField();
        TxtVeiCor = new javax.swing.JTextField();
        TxtVeiAno = new javax.swing.JTextField();
        TxtVeiRen = new javax.swing.JTextField();
        TxtVeiCha = new javax.swing.JTextField();
        TxtVeiObs = new javax.swing.JTextField();
        TxtVeiQui = new javax.swing.JTextField();
        TxtVeiAqu = new javax.swing.JTextField();
        BtnVeiIns = new javax.swing.JButton();
        BtnVeiPes = new javax.swing.JButton();
        BtnVeiEdi = new javax.swing.JButton();
        BtnVeiExc = new javax.swing.JButton();
        BtnVeiLim = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Veiculo");
        setPreferredSize(new java.awt.Dimension(640, 480));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ID Veículo:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Placa:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Marca:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Modelo:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Cor:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Ano:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("RENAVAM:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Chassi:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Observação:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Quilometragem:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Aquisição:");

        TxtVeiId.setEditable(false);
        TxtVeiId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtVeiIdActionPerformed(evt);
            }
        });

        TxtVeiQui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtVeiQuiActionPerformed(evt);
            }
        });

        BtnVeiIns.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/adicionarnovo.png"))); // NOI18N
        BtnVeiIns.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnVeiIns.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnVeiIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVeiInsActionPerformed(evt);
            }
        });

        BtnVeiPes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/pesquisar.png"))); // NOI18N
        BtnVeiPes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnVeiPes.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnVeiPes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVeiPesActionPerformed(evt);
            }
        });

        BtnVeiEdi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/editar.png"))); // NOI18N
        BtnVeiEdi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnVeiEdi.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnVeiEdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVeiEdiActionPerformed(evt);
            }
        });

        BtnVeiExc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/locadorabsl/icones/excluir.png"))); // NOI18N
        BtnVeiExc.setPreferredSize(new java.awt.Dimension(80, 80));
        BtnVeiExc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVeiExcActionPerformed(evt);
            }
        });

        BtnVeiLim.setText("Limpar Campos");
        BtnVeiLim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVeiLimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(2, 2, 2)
                        .addComponent(TxtVeiId, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtVeiPla, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtVeiMar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtVeiRen, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtVeiCha))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtVeiMod, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtVeiCor, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtVeiAno, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(TxtVeiObs, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TxtVeiQui, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TxtVeiAqu, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(75, 75, 75)
                            .addComponent(BtnVeiIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(64, 64, 64)
                            .addComponent(BtnVeiPes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(70, 70, 70)
                            .addComponent(BtnVeiEdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnVeiExc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(BtnVeiLim)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(TxtVeiId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtVeiPla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(TxtVeiMar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtVeiMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(TxtVeiCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(TxtVeiAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TxtVeiRen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(TxtVeiCha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TxtVeiObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(TxtVeiQui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnVeiExc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(TxtVeiAqu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(BtnVeiLim)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnVeiIns, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnVeiPes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnVeiEdi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        setBounds(0, 0, 671, 557);
    }// </editor-fold>//GEN-END:initComponents

    private void TxtVeiIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtVeiIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtVeiIdActionPerformed

    private void TxtVeiQuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtVeiQuiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtVeiQuiActionPerformed

    private void BtnVeiInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVeiInsActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_BtnVeiInsActionPerformed

    private void BtnVeiPesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVeiPesActionPerformed
        // TODO add your handling code here:
        TelaBuscaVeiculo tela = new TelaBuscaVeiculo();
        tela.setVisible(true);
    }//GEN-LAST:event_BtnVeiPesActionPerformed

    private void BtnVeiEdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVeiEdiActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_BtnVeiEdiActionPerformed

    private void BtnVeiExcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVeiExcActionPerformed
        // TODO add your handling code here:
        remover();
    }//GEN-LAST:event_BtnVeiExcActionPerformed

    private void BtnVeiLimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVeiLimActionPerformed
        // TODO add your handling code here:
        TxtVeiId.setText(null);
        TxtVeiPla.setText(null);
        TxtVeiMar.setText(null);
        TxtVeiMod.setText(null);
        TxtVeiCor.setText(null);
        TxtVeiAno.setText(null);
        TxtVeiRen.setText(null);
        TxtVeiCha.setText(null);
        TxtVeiObs.setText(null);
        TxtVeiQui.setText(null);
        TxtVeiAqu.setText(null);
    }//GEN-LAST:event_BtnVeiLimActionPerformed

    public static void veiIdSelecionado(int id) {
        TxtVeiId.setText(String.valueOf(id));
    }

    public static void veiPlaSelecionado(String placa) {
        TxtVeiPla.setText(placa);
    }

    public static void veiMarSelecionado(String marca) {
        TxtVeiMar.setText(marca);
    }

    public static void veiModSelecionado(String modelo) {
        TxtVeiMod.setText(modelo);
    }

    public static void veiCorSelecionado(String cor) {
        TxtVeiCor.setText(cor);
    }

    public static void veiAnoSelecionado(String ano) {
        TxtVeiAno.setText(ano);
    }

    public static void veiRenSelecionado(String renavam) {
        TxtVeiRen.setText(renavam);
    }

    public static void veiChaSelecionado(String chassi) {
        TxtVeiCha.setText(chassi);
    }

    public static void veiObsSelecionado(String observacao) {
        TxtVeiObs.setText(observacao);
    }

    public static void veiQuiSelecionado(float quilometragem) {
        TxtVeiQui.setText(String.valueOf(quilometragem));
    }

    public static void veiAquSelecionado(String aquisicao) {
        TxtVeiAqu.setText(aquisicao);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnVeiEdi;
    private javax.swing.JButton BtnVeiExc;
    private javax.swing.JButton BtnVeiIns;
    private javax.swing.JButton BtnVeiLim;
    private javax.swing.JButton BtnVeiPes;
    private static javax.swing.JTextField TxtVeiAno;
    private static javax.swing.JTextField TxtVeiAqu;
    private static javax.swing.JTextField TxtVeiCha;
    private static javax.swing.JTextField TxtVeiCor;
    private static javax.swing.JTextField TxtVeiId;
    private static javax.swing.JTextField TxtVeiMar;
    private static javax.swing.JTextField TxtVeiMod;
    private static javax.swing.JTextField TxtVeiObs;
    private static javax.swing.JTextField TxtVeiPla;
    private static javax.swing.JTextField TxtVeiQui;
    private static javax.swing.JTextField TxtVeiRen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables

}
