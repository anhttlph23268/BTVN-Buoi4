package View;

import Service.ServiceLab2_4_De2;
import ViewModel.KhachHang;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Lab2_4_De2 extends javax.swing.JFrame {

    private DefaultTableModel dtm;
    private DefaultComboBoxModel dcm;
    private final ServiceLab2_4_De2 sv;
    private final ButtonGroup b;
    private final Dialog dialog;

    public Lab2_4_De2() {
        initComponents();
        setLocationRelativeTo(null);// set Jframe giữa màn hình
        this.dialog = new Dialog();
        this.dtm = new DefaultTableModel();
        this.dcm = new DefaultComboBoxModel();
        this.sv = new ServiceLab2_4_De2();
        b = new ButtonGroup();
        b.add(this.rdoNam);
        b.add(this.rdoNu);
        this.rdoNam.setSelected(true);
        this.addComboBox();
        this.addColums();
        this.loadTable(this.sv.getList());
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

    void addColums() {
        ArrayList<String> listColums = new ArrayList<>();
        listColums.add("Mã KH");
        listColums.add("Tên KH");
        listColums.add("Tuổi");
        listColums.add("Giới Tính");
        listColums.add("Loại khách");
        listColums.add("Trạng Thái");

        dtm = (DefaultTableModel) this.tbStudentList.getModel();
        dtm.setRowCount(0);
        for (String item : listColums) {
            dtm.addColumn(item);
        }
    }

    void loadTable(ArrayList<KhachHang> listDV) {
        dtm = (DefaultTableModel) this.tbStudentList.getModel();
        dtm.setRowCount(0);

        for (KhachHang kh : listDV) {
            Object[] rowData = {
                kh.getMaKH(),
                kh.getTenKH(),
                kh.getTuoi(),
                kh.isGioiTinh(),
                kh.getLoaiKH(),
                kh.trangThai()
            };
            dtm.addRow(rowData);
        }
    }

    void clearForm() {
        this.txtTuoiMin.setText("");
        this.txtTuoiMax.setText("");
        this.txtMaKH.setText("");
        this.txtTenKH.setText("");
        this.txtTuoi.setText("");
        this.rdoNam.setSelected(true);
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

        btnClear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTuoiMin = new javax.swing.JTextField();
        txtTuoiMax = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTuoi = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        cbLoaiKH = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        btnSort = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbStudentList = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel4.setText("Tuổi Min");

        jLabel5.setText("Tuổi Max");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("information"));

        jLabel7.setText("Mã Khách hàng");

        jLabel8.setText("Tên khách hàng");

        jLabel9.setText("Tuổi");

        jLabel10.setText("Giới Tính");

        jLabel11.setText("Loại khách hàng");

        txtMaKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaKHMouseClicked(evt);
            }
        });

        txtTuoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTuoiMouseClicked(evt);
            }
        });

        txtTenKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTenKHMouseClicked(evt);
            }
        });

        rdoNam.setText("Nam");
        rdoNam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoNamMouseClicked(evt);
            }
        });

        rdoNu.setText("Nữ");
        rdoNu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoNuMouseClicked(evt);
            }
        });

        cbLoaiKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbLoaiKHMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(rdoNam)
                                .addGap(148, 148, 148)
                                .addComponent(rdoNu))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cbLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSort.setText("Sort");
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText(" Student List");

        tbStudentList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbStudentList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbStudentListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbStudentList);

        jButton1.setText("List khách vip");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(btnAdd)
                        .addGap(89, 89, 89)
                        .addComponent(jButton1)
                        .addGap(98, 98, 98)
                        .addComponent(btnSort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTuoiMax, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnClear)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTuoiMin, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSearch)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnClear)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTuoiMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTuoiMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(btnSearch)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnExit)
                    .addComponent(btnSort)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        this.clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        int max = Integer.parseInt(this.txtTuoiMax.getText().trim());
        int min = Integer.parseInt(this.txtTuoiMin.getText().trim());
        this.loadTable(this.sv.getListSearch(max, min));
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        KhachHang dv = this.getFormData();

        if (dv == null) {
            return;
        }
        this.sv.addList(dv);
        this.loadTable(this.sv.getList());
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtMaKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaKHMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txtMaKHMouseClicked

    private void txtTenKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTenKHMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txtTenKHMouseClicked

    private void txtTuoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTuoiMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_txtTuoiMouseClicked

    private void cbLoaiKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbLoaiKHMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cbLoaiKHMouseClicked

    private void rdoNamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoNamMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rdoNamMouseClicked

    private void rdoNuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoNuMouseClicked
        this.dialog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rdoNuMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.loadTable(this.sv.getListKhachVIP());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbStudentListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbStudentListMouseClicked
        int row = this.tbStudentList.getSelectedRow();

        if (row == -1) {
            return;
        }

        this.txtMaKH.setText(this.tbStudentList.getValueAt(row, 0).toString());
        this.txtTenKH.setText(this.tbStudentList.getValueAt(row, 1).toString());
        this.txtTuoi.setText(this.tbStudentList.getValueAt(row, 2).toString());
        if (this.tbStudentList.getValueAt(row, 3).toString().equals("true")) {
            this.rdoNam.setSelected(true);
        }
        if (this.tbStudentList.getValueAt(row, 3).toString().equals("false")) {
            this.rdoNu.setSelected(true);
        }
        this.cbLoaiKH.setSelectedItem(this.tbStudentList.getValueAt(row, 4).toString());
    }//GEN-LAST:event_tbStudentListMouseClicked

    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
        ArrayList<KhachHang> listKH = this.sv.getList();
        if (listKH.isEmpty()) {
            System.out.println("!!! Không có khách hàng !!!");
        } else {
            listKH.sort((o1, o2) -> {
                return o1.getTenKH().compareTo(o2.getTenKH());
            });

        }
    }//GEN-LAST:event_btnSortActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Lab2_4_De2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lab2_4_De2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lab2_4_De2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lab2_4_De2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lab2_4_De2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSort;
    private javax.swing.JComboBox<String> cbLoaiKH;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tbStudentList;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTuoi;
    private javax.swing.JTextField txtTuoiMax;
    private javax.swing.JTextField txtTuoiMin;
    // End of variables declaration//GEN-END:variables
}
