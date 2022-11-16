package View;

import Service.ServiceLab2_4_De2;
import ViewModel.KhachHang;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Dialog extends javax.swing.JFrame {

    private final ButtonGroup b;
    private final ServiceLab2_4_De2 sv;
    private DefaultComboBoxModel dcm;

    public Dialog() {
        initComponents();
        this.b = new ButtonGroup();
        this.sv = new ServiceLab2_4_De2();
        this.dcm = new DefaultComboBoxModel();
        b.add(rdoNu);
        b.add(rdoNam);
        this.addComboBox();
    }

    void addComboBox() {
        ArrayList<String> listCBB = new ArrayList<>();
        listCBB.add("Khách thường");
        listCBB.add("VIP");
        listCBB.add("VVIP");

        dcm = (DefaultComboBoxModel) this.cbLoaiKH.getModel();

        for (String item : listCBB) {
            dcm.addElement(item);
        }
        this.cbLoaiKH.setSelectedIndex(0);
    }

    public KhachHang getFormData() {
        String maStr = this.txtMaKH.getText().trim();
        String tenStr = this.txtTenKH.getText().trim();
        String canNangStr = this.txtTuoi.getText().trim();
        boolean gioiTinhStr = true;
        String loaiKHStr = this.cbLoaiKH.getSelectedItem().toString();

        if (maStr.equals("") || tenStr.equals("") || canNangStr.equals("")) {
            JOptionPane.showMessageDialog(this, "Thiếu dữ liệu!");
            return null;
        }

        int canNang = -1;
        try {
            canNang = Integer.parseInt(canNangStr);
            if (canNang < 0) {
                JOptionPane.showMessageDialog(this, "Cân nặng phải > 0!");
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cân nặng phải là số!");
            return null;
        }

        if (this.rdoNam.isSelected()) {
            gioiTinhStr = true;
        }
        if (this.rdoNu.isSelected()) {
            gioiTinhStr = false;
        }

        KhachHang dv = new KhachHang(maStr, tenStr, canNang, gioiTinhStr, loaiKHStr);
        return dv;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtTuoi = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        cbLoaiKH = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Detail khách hàng");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));

        jLabel2.setText("Mã KH");

        jLabel3.setText("Tên KH");

        jLabel4.setText("Tuổi");

        jLabel5.setText("Giới Tính");

        rdoNam.setText("Nam");

        rdoNu.setText("Nữ");

        jLabel6.setText("Loại KH");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)))
                        .addComponent(jLabel5)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTuoi, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(rdoNam)
                        .addGap(82, 82, 82)
                        .addComponent(rdoNu)
                        .addGap(102, 102, 102))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbLoaiKH, 0, 344, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoNam)
                        .addComponent(rdoNu))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Thoát");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(148, 148, 148))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(35, 35, 35)
                                .addComponent(jButton1)
                                .addGap(23, 23, 23))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(btnAdd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Lab2_4_De2 jframe = new Lab2_4_De2();
        jframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.txtMaKH.setText("");
        this.txtTenKH.setText("");
        this.txtTuoi.setText("");
        b.clearSelection();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        KhachHang dv = this.getFormData();

        if (dv == null) {
            return;
        }
        this.sv.addList(dv);
        Lab2_4_De2 jframe = new Lab2_4_De2();
        jframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAddActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JComboBox<String> cbLoaiKH;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
}
