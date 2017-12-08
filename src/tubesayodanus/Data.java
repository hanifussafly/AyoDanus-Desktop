/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesayodanus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hanifussafly
 */
public class Data extends javax.swing.JFrame {

    int editId = -1;
    /**
     * Creates new form Main
     */
    public Data() {
        initComponents();
        getData();
    }
    
    public void addTask(Integer hour, Integer minute, Integer second, String message){
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, hour);
        today.set(Calendar.MINUTE, minute);
        today.set(Calendar.SECOND, second);

        // every night at 2am you run your task
        Timer timer = new Timer();
        timer.schedule(new PengingatTask(message), today.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));
    }
    public void getData(){
        Database db = new Database();
        ResultSet rs = db.getData("SELECT * FROM danusan");
        try {
            DefaultTableModel model = (DefaultTableModel) tableJadwal.getModel();
            model.setRowCount(0);
            while(rs.next()){
                model.addRow(new Object[] {
                    rs.getInt("id"),
                    rs.getString("JenisDanus"), 
                    rs.getString("DanusMingguan"), 
                    rs.getString("HariDanus"),
                    rs.getString("JamReminder"),
                    rs.getString("catatan")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void simpan(){
        String jenis = jenisDanus.getItemAt(jenisDanus.getSelectedIndex());
        String hariDanus = "";
        switch(danusMinggu.getSelectedIndex()) {
            case 0:
                hariDanus += danusHari1.getItemAt(danusHari1.getSelectedIndex());
                break;
            case 1:
                hariDanus += danusHari1.getItemAt(danusHari1.getSelectedIndex());
                hariDanus += ",";
                hariDanus += danusHari2.getItemAt(danusHari2.getSelectedIndex());
                break;
            case 2:
                hariDanus += danusHari1.getItemAt(danusHari1.getSelectedIndex());
                hariDanus += ",";
                hariDanus += danusHari2.getItemAt(danusHari2.getSelectedIndex());
                hariDanus += ",";
                hariDanus += danusHari3.getItemAt(danusHari3.getSelectedIndex());
                break;
        }

        //String jamReminder = waktuIngetin.getItemAt(waktuIngetin.getSelectedIndex()) + ":00:00";
        String jamReminder = Jam.getText() + ":" + Menit.getText() +":"+ Detik.getText();
        
        
        String q = "INSERT INTO danusan VALUES(null, '" + jenis + "', " + (danusMinggu.getSelectedIndex() + 1) + ", '" + hariDanus + "', '" + jamReminder + "', '" + catatan.getText() + "')";
        addTask(
                Integer.valueOf(Jam.getText()), 
                Integer.valueOf(Menit.getText()), 
                Integer.valueOf(Detik.getText()),
                catatan.getText()
        );
        Database db = new Database();
        db.query(q);
        getData();
    }
    
    public void update(){
        
        String jenis = jenisDanus.getItemAt(jenisDanus.getSelectedIndex());
        String hariDanus = "";
        switch(danusMinggu.getSelectedIndex()) {
            case 0:
                hariDanus += danusHari1.getItemAt(danusHari1.getSelectedIndex());
                break;
            case 1:
                hariDanus += danusHari1.getItemAt(danusHari1.getSelectedIndex());
                hariDanus += ",";
                hariDanus += danusHari2.getItemAt(danusHari2.getSelectedIndex());
                break;
            case 2:
                hariDanus += danusHari1.getItemAt(danusHari1.getSelectedIndex());
                hariDanus += ",";
                hariDanus += danusHari2.getItemAt(danusHari2.getSelectedIndex());
                hariDanus += ",";
                hariDanus += danusHari3.getItemAt(danusHari3.getSelectedIndex());
                break;
        }

        String jamReminder = Jam.getText() + ":" + Menit.getText() +":"+ Detik.getText();
        
        String q = "UPDATE danusan SET JenisDanus= '" + jenis + "', DanusMingguan=" 
                + (danusMinggu.getSelectedIndex() + 1) + ", HariDanus='" + hariDanus 
                + "', JamReminder='" + jamReminder 
                + "', catatan='" + catatan.getText() + "' WHERE id=" + editId;
        
        Database db = new Database();
        ResultSet rs = db.getData("SELECT * FROM danusan");
        try {
            DefaultTableModel model = (DefaultTableModel) tableJadwal.getModel();
            model.setRowCount(0);
            while(rs.next()){
                model.addRow(new Object[] {
                    rs.getInt("id"),
                    rs.getString("JenisDanus"), 
                    rs.getString("DanusMingguan"), 
                    rs.getString("HariDanus"),
                    rs.getString("JamReminder"),
                    rs.getString("catatan")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        db.query(q);
        getData();
    }
    
    public void clear(){
        editId = -1;
        jenisDanus.setSelectedIndex(0);
        danusMinggu.setSelectedIndex(0);
        danusHari1.setSelectedIndex(0);
        danusHari2.setSelectedIndex(0);
        danusHari3.setSelectedIndex(0);
        
        catatan.setText("");
        Jam.setText("Jam");
        Menit.setText("Menit");
        Detik.setText("Detik");
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jenisDanus = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        danusMinggu = new javax.swing.JComboBox<>();
        danusHari1 = new javax.swing.JComboBox<>();
        danusHari2 = new javax.swing.JComboBox<>();
        danusHari3 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        catatan = new javax.swing.JTextField();
        jFinish = new javax.swing.JButton();
        jBatal = new javax.swing.JButton();
        Menit = new javax.swing.JTextField();
        Detik = new javax.swing.JTextField();
        Jam = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jNoTelp = new javax.swing.JTextField();
        jDivisi = new javax.swing.JTextField();
        jNama = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableJadwal = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        updateTable = new javax.swing.JButton();
        Hapus = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Set Danus");

        jenisDanus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kotak Putih", "JCo", "Panganan Liyane" }));
        jenisDanus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisDanusActionPerformed(evt);
            }
        });

        jLabel8.setText("Set Jadwal");

        danusMinggu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sekali", "Dua Kali", "Tiga Kali" }));
        danusMinggu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                danusMingguItemStateChanged(evt);
            }
        });
        danusMinggu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                danusMingguActionPerformed(evt);
            }
        });

        danusHari1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu" }));
        danusHari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                danusHari1ActionPerformed(evt);
            }
        });

        danusHari2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu" }));
        danusHari2.setEnabled(false);

        danusHari3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu" }));
        danusHari3.setEnabled(false);

        jLabel9.setText("Catatan ");

        catatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catatanActionPerformed(evt);
            }
        });

        jFinish.setText("OK");
        jFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFinishActionPerformed(evt);
            }
        });

        jBatal.setText("Batal");
        jBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBatalActionPerformed(evt);
            }
        });

        Menit.setText("Menit");

        Detik.setText("Detik");
        Detik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetikActionPerformed(evt);
            }
        });

        Jam.setText("Jam");
        Jam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JamActionPerformed(evt);
            }
        });

        jLabel4.setText("Nama");

        jLabel11.setText("Divisi");

        jLabel12.setText("No. Telp");

        jLabel5.setText("Jenis Danus");

        jLabel6.setText("Intensifitas");

        jLabel7.setText("Pilih Hari");

        jNoTelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNoTelpActionPerformed(evt);
            }
        });

        jNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNamaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(danusMinggu, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jenisDanus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jNoTelp, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addComponent(jDivisi)
                        .addComponent(jNama)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(Jam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Menit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Detik, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(danusHari1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(danusHari2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(danusHari3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jFinish)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(catatan, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jDivisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(danusHari1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(danusHari2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(danusHari3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Menit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Detik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Jam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(catatan, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBatal)
                            .addComponent(jFinish)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jenisDanus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(danusMinggu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        tableJadwal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Divisi", "No. Telp", "Jenis Danus", "Danus per Minggu", "Hari Danus", "Jam Reminder", "Catatan"
            }
        ));
        jScrollPane1.setViewportView(tableJadwal);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Jadwal Danus Kamu");

        updateTable.setText("Update");
        updateTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTableActionPerformed(evt);
            }
        });

        Hapus.setText("Hapus");
        Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updateTable)
                .addGap(18, 18, 18)
                .addComponent(Hapus)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateTable)
                    .addComponent(Hapus))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Radical", 1, 18)); // NOI18N
        jLabel3.setText("AYO DANUS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(251, 251, 251))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTableActionPerformed
        editId = (int) tableJadwal.getValueAt(tableJadwal.getSelectedRow(), 0);
        //Jenis Danus
        String jenis = (String) tableJadwal.getValueAt(tableJadwal.getSelectedRow(), 1);
        Integer danus = Integer.parseInt((String) tableJadwal.getValueAt(tableJadwal.getSelectedRow(), 2));
        danus--;
        String[] hari = ((String) tableJadwal.getValueAt(tableJadwal.getSelectedRow(), 3)).split(",");
        
        jenisDanus.setSelectedItem(jenis);
        danusMinggu.setSelectedIndex(danus);
        switch(danus) {
            case 0:
                danusHari1.setSelectedItem(hari[0]);
                break;
            case 1:
                danusHari1.setSelectedItem(hari[0]);
                danusHari2.setSelectedItem(hari[1]);
                break;
            case 2:
                danusHari1.setSelectedItem(hari[0]);
                danusHari2.setSelectedItem(hari[1]);
                danusHari3.setSelectedItem(hari[2]);
                break;
        }
        
        String jam = (String) tableJadwal.getValueAt(tableJadwal.getSelectedRow(), 4);
        String[] js = jam.split(":");
        Jam.setText(js[0]);
        Menit.setText(js[1]);
        Detik.setText(js[2]);
        
        
        catatan.setText((String) tableJadwal.getValueAt(tableJadwal.getSelectedRow(), 5));
    }//GEN-LAST:event_updateTableActionPerformed

    private void HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusActionPerformed
        String q = "Delete from danusan where id=" + tableJadwal.getValueAt(tableJadwal.getSelectedRow(), 0);
        Database db= new Database();
        db.query(q);
        getData();
        clear();
    }//GEN-LAST:event_HapusActionPerformed

    private void jNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNamaActionPerformed

    private void jNoTelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNoTelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNoTelpActionPerformed

    private void JamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JamActionPerformed

    private void DetikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DetikActionPerformed

    private void jBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBatalActionPerformed
        clear();
    }//GEN-LAST:event_jBatalActionPerformed

    private void jFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFinishActionPerformed
        if(editId == -1){
            simpan();
        } else {
            update();
        }

        clear();
    }//GEN-LAST:event_jFinishActionPerformed

    private void catatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_catatanActionPerformed

    private void danusHari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_danusHari1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_danusHari1ActionPerformed

    private void danusMingguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_danusMingguActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_danusMingguActionPerformed

    private void danusMingguItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_danusMingguItemStateChanged
        System.out.println(danusMinggu.getItemAt(danusMinggu.getSelectedIndex()));
        switch(danusMinggu.getSelectedIndex()) {
            case 0:
            danusHari1.setEnabled(true);
            danusHari2.setEnabled(false);
            danusHari3.setEnabled(false);
            break;
            case 1:
            danusHari1.setEnabled(true);
            danusHari2.setEnabled(true);
            danusHari3.setEnabled(false);
            break;
            case 2:
            danusHari1.setEnabled(true);
            danusHari2.setEnabled(true);
            danusHari3.setEnabled(true);
            break;

        }
    }//GEN-LAST:event_danusMingguItemStateChanged

    private void jenisDanusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisDanusActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableJadwal.getModel();
        try{
            jenisDanus.getItemAt(jenisDanus.getSelectedIndex());
        }catch(Exception e){
            System.out.println("Error");
        }
        System.out.println(jenisDanus.getItemAt(jenisDanus.getSelectedIndex()));
    }//GEN-LAST:event_jenisDanusActionPerformed

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
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Detik;
    private javax.swing.JButton Hapus;
    private javax.swing.JTextField Jam;
    private javax.swing.JTextField Menit;
    private javax.swing.JTextField catatan;
    private javax.swing.JComboBox<String> danusHari1;
    private javax.swing.JComboBox<String> danusHari2;
    private javax.swing.JComboBox<String> danusHari3;
    private javax.swing.JComboBox<String> danusMinggu;
    private javax.swing.JButton jBatal;
    private javax.swing.JTextField jDivisi;
    private javax.swing.JButton jFinish;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jNama;
    private javax.swing.JTextField jNoTelp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jenisDanus;
    private javax.swing.JTable tableJadwal;
    private javax.swing.JButton updateTable;
    // End of variables declaration//GEN-END:variables
}
