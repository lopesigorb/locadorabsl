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
    
    private void pesquisar() {
    String sql = "select * from locacao where id_locacao=?";
    try{
        pst=conexao.prepareStatement(sql);
        pst.setString(1,TxtLocId.getText());
        rs=pst.executeQuery();
        if (rs.next()) {
        TxtLocCpf.setText(rs.getString(2));
        TxtLocIdv.setText(rs.getString(3));
        TxtLocPer.setText(rs.getString(4));
        TxtLocVal.setText(rs.getString(5));
        TxtLocFun.setText(rs.getString(6));
        } else{
            JOptionPane.showMessageDialog(null, "Locação não cadastrada");
            TxtLocId.setText(null);
            TxtLocCpf.setText(null);
            TxtLocIdv.setText(null);
            TxtLocPer.setText(null);
            TxtLocVal.setText(null);
            TxtLocFun.setText(null);      
        
        }
    }catch (Exception e ){
        JOptionPane.showMessageDialog(null, e);
    } 
}
    
    private void adicionar(){
    String sql = "insert into locacao(cpf_cliente, id_veiculo, periodo, valor, id_func) values(?,?,?,?,?)";
    try {
        pst=conexao.prepareStatement(sql);
        pst.setString(1, TxtLocCpf.getText());
        pst.setString(2, TxtLocIdv.getText());
        pst.setString(3, TxtLocPer.getText());
        pst.setString(4, TxtLocVal.getText());
        pst.setString(5, TxtLocFun.getText());
        // validação dos campos obrigatórios
        if ((((TxtLocCpf.getText().isEmpty()) || (TxtLocIdv.getText().isEmpty())) || 
        (TxtLocPer.getText().isEmpty())) || (TxtLocVal.getText().isEmpty()) || (TxtLocFun.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
        } else {
        
        // a linha abaixo atualiza com os dados do formulario
        int adicionado = pst.executeUpdate();
        if(adicionado >0);{
        JOptionPane.showMessageDialog(null, "Locação adicionada com sucesso");
            TxtLocId.setText(null);
            TxtLocCpf.setText(null);
            TxtLocIdv.setText(null);
            TxtLocPer.setText(null);
            TxtLocVal.setText(null);
            TxtLocFun.setText(null);
    }
        }    
    }catch(Exception e) {
        JOptionPane.showMessageDialog(null,e);
    }
}

    private void editar(){
    String sql="update locacao set cpf_cliente=?, id_veiculo=?, periodo=?, valor=?, id_func=? where id_locacao=?";
    try{
        pst=conexao.prepareStatement(sql);
        pst.setString(1, TxtLocCpf.getText());
        pst.setString(2, TxtLocIdv.getText());
        pst.setString(3, TxtLocPer.getText());
        pst.setString(4, TxtLocVal.getText());
        pst.setString(5, TxtLocFun.getText());
       
        
        if ((((TxtLocCpf.getText().isEmpty()) || (TxtLocIdv.getText().isEmpty())) || 
        (TxtLocPer.getText().isEmpty())) || (TxtLocVal.getText().isEmpty()) || (TxtLocFun.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
        } else{
            int adicionado = pst.executeUpdate();
            
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados da locação alterados com sucesso");
                TxtLocId.setText(null);
                TxtLocCpf.setText(null);
                TxtLocIdv.setText(null);
                TxtLocPer.setText(null);
                TxtLocVal.setText(null);
                TxtLocFun.setText(null);
                
            }
        }
        }catch(Exception e) {
        JOptionPane.showMessageDialog(null,e);
    
    }
}
    
        private void remover () {
    int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esta locação?", "Atenção", JOptionPane.YES_NO_OPTION);
    if (confirma == JOptionPane.YES_OPTION) {
        String sql = "delete from locacao where id_locacao=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, TxtLocId.getText());
            int apagado = pst.executeUpdate();
            if (apagado > 0) {
                JOptionPane.showMessageDialog(null, "Locação removida com sucesso");
            
                TxtLocId.setText(null);
                TxtLocCpf.setText(null);
                TxtLocIdv.setText(null);
                TxtLocPer.setText(null);
                TxtLocVal.setText(null);
                TxtLocFun.setText(null);
            
            }           
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

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
        TxtLocIdv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtLocPer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtLocVal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtLocFun = new javax.swing.JTextField();
        BtnLocIns = new javax.swing.JButton();
        BtnLocEdi = new javax.swing.JButton();
        BtnLocExc = new javax.swing.JButton();
        BtnLocPes = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Veículo");

        TxtLocIdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtLocIdvActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Período");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Valor");

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

        jButton1.setText("Buscar CPF");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TxtLocCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))
                            .addComponent(TxtLocId, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnLocIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(BtnLocPes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(BtnLocEdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(BtnLocExc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtLocIdv, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtLocFun, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtLocPer, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtLocVal, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtLocId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtLocCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtLocIdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtLocFun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxtLocPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TxtLocVal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(128, 128, 128)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnLocIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnLocPes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnLocEdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnLocExc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        setBounds(0, 0, 671, 557);
    }// </editor-fold>//GEN-END:initComponents

    private void TxtLocIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtLocIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtLocIdActionPerformed

    private void TxtLocIdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtLocIdvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtLocIdvActionPerformed

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
        pesquisar();
    }//GEN-LAST:event_BtnLocPesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnLocEdi;
    private javax.swing.JButton BtnLocExc;
    private javax.swing.JButton BtnLocIns;
    private javax.swing.JButton BtnLocPes;
    private javax.swing.JTextField TxtLocCpf;
    private javax.swing.JTextField TxtLocFun;
    private javax.swing.JTextField TxtLocId;
    private javax.swing.JTextField TxtLocIdv;
    private javax.swing.JTextField TxtLocPer;
    private javax.swing.JTextField TxtLocVal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
