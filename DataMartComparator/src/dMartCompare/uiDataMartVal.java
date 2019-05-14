package dMartCompare;
import java.awt.Color;

@SuppressWarnings("serial")
public class uiDataMartVal extends javax.swing.JFrame {
    public uiDataMartVal() {
        initComponents();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSelDB = new javax.swing.JLabel();
        txtSrcUserName = new javax.swing.JTextField();
        lblUsrName = new javax.swing.JLabel();
        cmbSrcSelDB = new javax.swing.JComboBox();
        lblPwd = new javax.swing.JLabel();
        txtSrcPwd = new javax.swing.JPasswordField();
        txtSrcHostName = new javax.swing.JTextField();
        lblHostName = new javax.swing.JLabel();
        txtSrcPort = new javax.swing.JTextField();
        lblPort = new javax.swing.JLabel();
        txtSrcSidSerName = new javax.swing.JTextField();
        lblSidSerName = new javax.swing.JLabel();
        lblSrcDB = new javax.swing.JLabel();
        txtTrgHostName = new javax.swing.JTextField();
        txtTrgPort = new javax.swing.JTextField();
        txtTrgSidSerName = new javax.swing.JTextField();
        lblTrgDB = new javax.swing.JLabel();
        txtTrgUserName = new javax.swing.JTextField();
        cmbTrgSelDB = new javax.swing.JComboBox();
        txtTrgPwd = new javax.swing.JPasswordField();
        lblHeader = new javax.swing.JLabel();
        lblSrcFolder = new javax.swing.JLabel();
        txtSrcSqlFolder = new javax.swing.JTextField();
        lblTrgFolder = new javax.swing.JLabel();
        txtTrgSqlFolder = new javax.swing.JTextField();
        btnDataCompare = new javax.swing.JButton();
        lblSqlToRun = new javax.swing.JLabel();
        txtSqlToRun = new javax.swing.JTextField();
        lblInsSql = new javax.swing.JLabel();
        lblInsSql1 = new javax.swing.JLabel();
        lblDisError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DataMart Data Validation");
        setBackground(javax.swing.UIManager.getDefaults().getColor("Button.disabledShadow"));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(255, 255, 255));
        setIconImages(null);
        setLocationByPlatform(true);
        setName("frmDataMartVal"); // NOI18N
        setResizable(false);

        lblSelDB.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblSelDB.setText("Select DataBase:");

        txtSrcUserName.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        lblUsrName.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblUsrName.setText("User Name:");

        cmbSrcSelDB.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cmbSrcSelDB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Oracle", "Sybase" }));

        lblPwd.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblPwd.setText("Password:");

        txtSrcPwd.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        txtSrcHostName.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        lblHostName.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblHostName.setText("Hostname:");

        txtSrcPort.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        lblPort.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblPort.setText("Port:");

        txtSrcSidSerName.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        lblSidSerName.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblSidSerName.setText("SID/Service Name:");

        lblSrcDB.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblSrcDB.setText("Source DataBase");

        txtTrgHostName.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        txtTrgPort.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        txtTrgSidSerName.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        lblTrgDB.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lblTrgDB.setText("Target DataBase");

        txtTrgUserName.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        cmbTrgSelDB.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cmbTrgSelDB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Oracle", "Sybase" }));

        txtTrgPwd.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        lblHeader.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblHeader.setText("DataMart Data Validation");

        lblSrcFolder.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblSrcFolder.setText("Source SQLs Folder:");

        txtSrcSqlFolder.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        lblTrgFolder.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblTrgFolder.setText("Target SQLs Folder:");

        txtTrgSqlFolder.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        btnDataCompare.setBackground(new java.awt.Color(51, 102, 255));
        btnDataCompare.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnDataCompare.setForeground(new java.awt.Color(255, 255, 255));
        btnDataCompare.setText("Compare");
        btnDataCompare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataCompareActionPerformed(evt);
            }
        });

        lblSqlToRun.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblSqlToRun.setText("Select SQLs to Run:");

        txtSqlToRun.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        lblInsSql.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        lblInsSql.setText("e.g. All or 001,006,015 etc.");

        lblInsSql1.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        lblInsSql1.setForeground(new java.awt.Color(255, 51, 51));
        lblInsSql1.setText("All fields are mandatory");

        lblDisError.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        lblDisError.setForeground(javax.swing.UIManager.getDefaults().getColor("ToolBar.dockingForeground"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblInsSql1)
                    .addComponent(lblSelDB)
                    .addComponent(lblUsrName)
                    .addComponent(lblPwd)
                    .addComponent(lblHostName)
                    .addComponent(lblPort)
                    .addComponent(lblSidSerName)
                    .addComponent(lblSrcFolder)
                    .addComponent(lblTrgFolder)
                    .addComponent(lblSqlToRun))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDataCompare, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDisError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTrgSqlFolder, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtSrcSqlFolder, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtSrcUserName)
                                            .addComponent(cmbSrcSelDB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtSrcPwd)
                                            .addComponent(txtSrcHostName)
                                            .addComponent(txtSrcPort, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtSrcSidSerName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTrgSidSerName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTrgPort, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTrgHostName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTrgPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTrgUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbTrgSelDB, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(txtSqlToRun, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblInsSql)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSrcDB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTrgDB))
                            .addComponent(lblHeader, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(199, 199, 199))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblHeader)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSrcDB)
                    .addComponent(lblTrgDB)
                    .addComponent(lblInsSql1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelDB)
                    .addComponent(cmbSrcSelDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTrgSelDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSrcUserName)
                    .addComponent(lblUsrName)
                    .addComponent(txtTrgUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPwd)
                    .addComponent(txtSrcPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTrgPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSrcHostName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHostName)
                    .addComponent(txtTrgHostName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSrcPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPort)
                    .addComponent(txtTrgPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSrcSidSerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSidSerName)
                    .addComponent(txtTrgSidSerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSrcSqlFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSrcFolder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTrgSqlFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTrgFolder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSqlToRun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSqlToRun)
                    .addComponent(lblInsSql))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDataCompare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDisError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings({ "unused", "deprecation" })
	private void btnDataCompareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataCompareActionPerformed
        String getSrcDataBase = cmbSrcSelDB.getSelectedItem().toString();
        String getTrgDataBase = cmbTrgSelDB.getSelectedItem().toString();

        String getSrcUserName = txtSrcUserName.getText();
        String getTrgUserName = txtTrgUserName.getText();

        String getSrcPassword = txtSrcPwd.getText();
        String getTrgPassword = txtTrgPwd.getText();

        String getSrcHostName = txtSrcHostName.getText();
        String getTrgHostName = txtTrgHostName.getText();

        String getSrcPortName = txtSrcPort.getText();
        String getTrgPortName = txtTrgPort.getText();

        String getSrcSidServi = txtSrcSidSerName.getText();
        String getTrgSidServi = txtTrgSidSerName.getText();

        String getSrcSQLFoldr = txtSrcSqlFolder.getText();
        String getTrgSQLFoldr = txtTrgSqlFolder.getText();

        String getTotlSQLsRun = txtSqlToRun.getText();

        //check for empty fields
        if (getSrcUserName.trim().equals("") || getTrgUserName.trim().equals("")
                || getSrcPassword.trim().equals("") || getTrgPassword.trim().equals("")
                || getSrcHostName.trim().equals("") || getTrgHostName.trim().equals("")
                || getSrcPortName.trim().equals("") || getTrgPortName.trim().equals("")
                || getSrcSidServi.trim().equals("") || getTrgSidServi.trim().equals("")
                || getSrcSQLFoldr.trim().equals("") || getTrgSQLFoldr.trim().equals("")
                || getTotlSQLsRun.trim().equals("")) {
            lblDisError.setText("All fields are mandatory !!!");
            lblDisError.setForeground(Color.RED);
        } else {
            lblDisError.setText("");
            //openConnections exmp = new openConnections();
            try {
                mainClassComp.runComparator(getSrcUserName, getSrcPassword, getSrcHostName, getSrcPortName, getSrcSidServi,
                        getTrgUserName, getTrgPassword, getTrgHostName, getTrgPortName, getTrgSidServi,
                        getSrcSQLFoldr, getTrgSQLFoldr, getTotlSQLsRun);
            } catch (Exception e) {
                //System.out.println(e);
                String getErr = e.toString();
                lblDisError.setText(getErr);
                lblDisError.setForeground(Color.RED);
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnDataCompareActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(uiDataMartVal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(uiDataMartVal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(uiDataMartVal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(uiDataMartVal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new uiDataMartVal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDataCompare;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox cmbSrcSelDB;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox cmbTrgSelDB;
    private javax.swing.JLabel lblDisError;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblHostName;
    private javax.swing.JLabel lblInsSql;
    private javax.swing.JLabel lblInsSql1;
    private javax.swing.JLabel lblPort;
    private javax.swing.JLabel lblPwd;
    private javax.swing.JLabel lblSelDB;
    private javax.swing.JLabel lblSidSerName;
    private javax.swing.JLabel lblSqlToRun;
    private javax.swing.JLabel lblSrcDB;
    private javax.swing.JLabel lblSrcFolder;
    private javax.swing.JLabel lblTrgDB;
    private javax.swing.JLabel lblTrgFolder;
    private javax.swing.JLabel lblUsrName;
    private javax.swing.JTextField txtSqlToRun;
    private javax.swing.JTextField txtSrcHostName;
    private javax.swing.JTextField txtSrcPort;
    private javax.swing.JPasswordField txtSrcPwd;
    private javax.swing.JTextField txtSrcSidSerName;
    private javax.swing.JTextField txtSrcSqlFolder;
    private javax.swing.JTextField txtSrcUserName;
    private javax.swing.JTextField txtTrgHostName;
    private javax.swing.JTextField txtTrgPort;
    private javax.swing.JPasswordField txtTrgPwd;
    private javax.swing.JTextField txtTrgSidSerName;
    public javax.swing.JTextField txtTrgSqlFolder;
    private javax.swing.JTextField txtTrgUserName;
    // End of variables declaration//GEN-END:variables
}
