package com.wambua.org.views;

import com.wambua.org.dao.DatabaseAccessObjects;
import com.wambua.org.dao.javaconnect;
import com.wambua.org.services.BusBookingService;
import com.wambua.org.utils.DataProcessingUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ClientHome extends javax.swing.JFrame {

    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    String busname;
    Boolean proceedWithBooking = false;
    Boolean bussIsFilled = false;
    String depertureDate;
    String normal_fare;
    String vip_fare;
    String regNumber;
    String vipSeat;
    String normalSeat;
    String destination;
    String from;

    //procedure call
    public ClientHome() {
        super("Home");
        initComponents();
        conn = javaconnect.ConnectrDb();
        busname = (String) busNameCombo.getSelectedItem();

    }

    public void Search() {
        from = (String) fromComboBox.getSelectedItem();
        destination = (String) destinationCombo.getSelectedItem();
        depertureDate = ((JTextField) dateOfTravelDateChooser.getDateEditor().getUiComponent()).getText();
        System.err.println(depertureDate);
        /**
         * A method to ensure that booking does not exceed before the date of travel is selected in JDAteChooser
         */

        if(depertureDate.equals("")){
            JOptionPane.showConfirmDialog(null,"Please select travel Date","Warning", JOptionPane.ERROR_MESSAGE);
            
        }

        else if (DatabaseAccessObjects.isBookingExists(depertureDate)) {
            /**
             * Obtain available buses for selected date and populate in combo
             */
            HashSet<String> busNamesSet = DatabaseAccessObjects.getBussNamesBasedOnTravelDate(depertureDate);
            busNamesSet.forEach(busName -> busNameCombo.addItem(busName));
           
            
        } else {
            /**
             * Populate new buss booking and allow user to book
             */
            List<String> busNames = DatabaseAccessObjects.getBussNamesBasedOnTravelDateAndDestination(from, destination, depertureDate);
            List<String> uniqueBusNames = DataProcessingUtils.getUniqueList(busNames);
            //uniqueBusNames.forEach(System.out::println); //java 8 streams and lambdas
            uniqueBusNames.forEach( e -> {
                busNameCombo.addItem(e);
            });
           // BusBookingService.openBookingView(depertureDate, busname, destination, depertureDate);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        depertureTimeTextField = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        selectButton = new javax.swing.JButton();
        fromComboBox = new javax.swing.JComboBox<>();
        destinationCombo = new javax.swing.JComboBox<>();
        busNameCombo = new javax.swing.JComboBox<>();
        dateOfTravelDateChooser = new com.toedter.calendar.JDateChooser();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Please enter your search details below", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("FROM :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("DESTINATION :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("DATE OF TRAVEL :");

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Search");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.setMargin(new java.awt.Insets(2, 0, 2, 14));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Bus Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Departure");

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Normal Fare");

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("VIP fare");

        depertureTimeTextField.setEditable(false);
        depertureTimeTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextField7.setEditable(false);
        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        selectButton.setBackground(new java.awt.Color(0, 0, 204));
        selectButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        selectButton.setText("SELECT");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        fromComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MOMBASA", "NAIROBI", "KAKAMEGA" }));

        destinationCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NAIROBI", "MOMBASA", "kAKAMEGA" }));

        busNameCombo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                busNameComboPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        dateOfTravelDateChooser.setDateFormatString("yyyy-MM-dd ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(busNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(depertureTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(32, 32, 32)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100)
                        .addComponent(selectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fromComboBox, 0, 222, Short.MAX_VALUE)
                                    .addComponent(destinationCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(dateOfTravelDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(fromComboBox))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(destinationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dateOfTravelDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(busNameCombo)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(depertureTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField7)
                    .addComponent(selectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jButton1.getAccessibleContext().setAccessibleDescription("");

        jMenuBar1.setBackground(new java.awt.Color(0, 255, 0));

        jMenu1.setForeground(new java.awt.Color(255, 0, 0));
        jMenu1.setText("File");

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem2.setText("Log Out");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(255, 0, 0));
        jMenu2.setText("Contact Us");

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem3.setText("about");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Search();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        String deperturePoint = fromComboBox.getSelectedItem().toString();
        String busName = busNameCombo.getSelectedItem().toString();
        String destination = destinationCombo.getSelectedItem().toString();
        String depertureDate = ((JTextField) dateOfTravelDateChooser.getDateEditor().getUiComponent()).getText();
        String depture= depertureTimeTextField.getText();
        /**
         * Check if the bus is selected from Combo if not do not proceed booking
         */
        if(depture.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please select the Bus before you can proceed");
        }else{
             
            
        
       BusBookingService.openBookingView(deperturePoint, busName, destination, depertureDate);
//        DatabaseAccessObjects.updateCoachSeatBookingStatus(WIDTH, bussIsFilled, busname);
// DatabaseAccessObjects.checkBusSeatBookingStatus(WIDTH, busName, from);
setVisible(false);
//        Calendar calendar = jDateChooser1.getCalendar();
//
//        /**
//         * No buses available for selected date --ensure date is in the future
//         * not past -if future - make db entry with date to initialize booking
//         */
//        if (DateAndTimeUtils.parseCalendarToLocalDate(calendar).isBefore(LocalDate.now())) {
//            JOptionPane.showMessageDialog(null, "Sorry no buses available for the submitted details ! ! !");
//            proceedWithBooking = false;
//        } else if (DateAndTimeUtils.parseCalendarToLocalDate(calendar).isAfter(LocalDate.now())) {
//            //make new booking entry in db
//            HashMap<String, String> bussBookingDetails = new HashMap<>();
//            bussBookingDetails.put("from", from);
//            bussBookingDetails.put("destination", destination);
//            bussBookingDetails.put("depature", depertureTimeTextField.getText());
//            bussBookingDetails.put("vip_fare", vip_fare);
//            bussBookingDetails.put("normal_fare", normal_fare);
//            bussBookingDetails.put("bus_name", busname);
//            bussBookingDetails.put("regno", regNumber);
//            bussBookingDetails.put("dot", ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText());
//            bussBookingDetails.put("vip_seat", vipSeat);
//            bussBookingDetails.put("normal_seat", normalSeat);
//            DatabaseAccessObjects.createBussBookingEntry(bussBookingDetails);
//            proceedWithBooking = true;
//        } else if (DateAndTimeUtils.parseCalendarToLocalDate(calendar).isEqual(LocalDate.now())) {
//            //proceed with booking
//            proceedWithBooking = true;
//        } else if (bussIsFilled) {
//            // inform user to select another bus
//        } else {
//            //log error message-- unexpected data--
//            proceedWithBooking = false;
//        }
//
//        if (depertureTimeTextField.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Please select the bus first ! ! !");
//        } else if (proceedWithBooking.equals(false)) {
//
//        } else if (proceedWithBooking) {
//            String deperturePoint = (String) jComboBox1.getSelectedItem();
//            String destination = (String) jComboBox2.getSelectedItem();
//            busname = (String) jComboBox3.getSelectedItem();
//            BusBookingService.openBookingView(deperturePoint, busname, destination, depertureDate);
//            
//            setVisible(false);
//        } else {
//
//        }
    }//GEN-LAST:event_selectButtonActionPerformed
    }
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        setVisible(false);
        loginn ob = new loginn();
        ob.setLocationRelativeTo(null);
        ob.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        setVisible(false);
        About ob = new About();
        ob.setLocationRelativeTo(null);
        ob.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void busNameComboPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_busNameComboPopupMenuWillBecomeInvisible
        String theBus = (String) busNameCombo.getSelectedItem();
        String sql = "Select * from buses where Bus_Name= ? ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, theBus);
            rs = pst.executeQuery();
            if (rs.next()) {
                depertureDate = rs.getString("Departure");
                depertureTimeTextField.setText(depertureDate);
                normal_fare = rs.getString("Normal_fare");
                busname = rs.getString("bus_name");
                regNumber = rs.getString("regno");
                System.out.println(regNumber);
                vipSeat = rs.getString("vip_seat");
                normalSeat = rs.getString("normal_seat");
                jTextField6.setText(normal_fare);
                vip_fare = rs.getString("VIP_fare");
                jTextField7.setText(vip_fare);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_busNameComboPopupMenuWillBecomeInvisible

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
            java.util.logging.Logger.getLogger(ClientHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> busNameCombo;
    private com.toedter.calendar.JDateChooser dateOfTravelDateChooser;
    private javax.swing.JTextField depertureTimeTextField;
    private javax.swing.JComboBox<String> destinationCombo;
    private javax.swing.JComboBox<String> fromComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JButton selectButton;
    // End of variables declaration//GEN-END:variables
}
