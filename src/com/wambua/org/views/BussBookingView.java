package com.wambua.org.views;

import com.wambua.org.dao.javaconnect;
import com.wambua.org.dao.DatabaseAccessObjects;
import com.wambua.org.receiptGenerationService.BusTicketGenerationService;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class BussBookingView extends javax.swing.JFrame {

    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    String busname = "";
    

    public BussBookingView(String deperturePoint,String destination,String busname,String dot) {
        super(busname);
        initComponents();
        conn = javaconnect.ConnectDb();
        this.busname = busname;
        //set deperture origine text
        jTextField13.setText(destination);
        jTextField14.setText(deperturePoint);

        List<JToggleButton> seatButtons = Arrays.asList(
                jToggleButton1, jToggleButton2, jToggleButton4, jToggleButton5, jToggleButton6, jToggleButton7, jToggleButton8, jToggleButton9, jToggleButton10,
                jToggleButton11, jToggleButton12, jToggleButton13, jToggleButton14, jToggleButton15, jToggleButton16, jToggleButton17, jToggleButton18, jToggleButton19, jToggleButton20,
                jToggleButton21, jToggleButton22, jToggleButton23, jToggleButton24, jToggleButton25, jToggleButton26, jToggleButton27, jToggleButton28, jToggleButton29, jToggleButton30,
                jToggleButton31, jToggleButton32, jToggleButton33, jToggleButton34, jToggleButton35, jToggleButton36, jToggleButton37, jToggleButton38
        );

       seatButtons.forEach(toggleButton -> {
            Boolean isBooked = DatabaseAccessObjects.checkBusSeatBookingStatus(Integer.parseInt(toggleButton.getText()),this.busname,dot);
            if (isBooked) {
                toggleButton.setBackground(Color.BLUE);
            } else {
                toggleButton.setBackground(Color.WHITE);
            }
        });

    }

    private boolean validateFields() {
        if (jTextField5.getText().isEmpty() | jTextField6.getText().isEmpty() | jTextField7.getText().isEmpty() | jTextField8.getText().isEmpty() | jTextField9.getText().isEmpty() | jTextField10.getText().isEmpty() | jTextField3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please check that you have entered all the details.");
            return false;
        }
        return true;
    }
    
    private boolean payment(){
         Boolean isValid = false;
         String sql = " select*from payment where PayMethod = ? and uniqcode = ? ";
         try{
         pst=conn.prepareStatement(sql);
          pst.setString(1,(String) jComboBox1.getSelectedItem());
          pst.setString(2, jTextField11.getText());
          rs = pst.executeQuery();
                if (rs.next()) {
                    switch ((String) jComboBox1.getSelectedItem()){
                        case "CASH":
                            
                            break;
                        case "M-PESA":
                            jTextField11.getText();
                            break;
                        default:
                            break;
                    }
                    
                    JOptionPane.showMessageDialog(null, "Your verification code has been accepted you may proceed with booking");
                    isValid = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry your unique code does not match our record please try again");
                }
            } catch (HeadlessException | SQLException e) {
                e.printStackTrace();
                isValid = false;
            } finally {
                try {
                    rs.close();
                    pst.close();
         }catch(Exception e){
             
         }
         return isValid;
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jToggleButton39 = new javax.swing.JToggleButton();
        jToggleButton40 = new javax.swing.JToggleButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jTextField2 = new javax.swing.JTextField();
        jToggleButton7 = new javax.swing.JToggleButton();
        jToggleButton8 = new javax.swing.JToggleButton();
        jToggleButton9 = new javax.swing.JToggleButton();
        jToggleButton10 = new javax.swing.JToggleButton();
        jToggleButton11 = new javax.swing.JToggleButton();
        jToggleButton12 = new javax.swing.JToggleButton();
        jToggleButton13 = new javax.swing.JToggleButton();
        jToggleButton14 = new javax.swing.JToggleButton();
        jToggleButton15 = new javax.swing.JToggleButton();
        jToggleButton16 = new javax.swing.JToggleButton();
        jToggleButton17 = new javax.swing.JToggleButton();
        jToggleButton18 = new javax.swing.JToggleButton();
        jToggleButton19 = new javax.swing.JToggleButton();
        jToggleButton20 = new javax.swing.JToggleButton();
        jToggleButton21 = new javax.swing.JToggleButton();
        jToggleButton22 = new javax.swing.JToggleButton();
        jToggleButton23 = new javax.swing.JToggleButton();
        jToggleButton24 = new javax.swing.JToggleButton();
        jToggleButton25 = new javax.swing.JToggleButton();
        jToggleButton26 = new javax.swing.JToggleButton();
        jToggleButton27 = new javax.swing.JToggleButton();
        jToggleButton28 = new javax.swing.JToggleButton();
        jToggleButton29 = new javax.swing.JToggleButton();
        jToggleButton30 = new javax.swing.JToggleButton();
        jToggleButton31 = new javax.swing.JToggleButton();
        jToggleButton32 = new javax.swing.JToggleButton();
        jToggleButton33 = new javax.swing.JToggleButton();
        jToggleButton34 = new javax.swing.JToggleButton();
        jToggleButton35 = new javax.swing.JToggleButton();
        jToggleButton36 = new javax.swing.JToggleButton();
        jToggleButton37 = new javax.swing.JToggleButton();
        jToggleButton38 = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Title");
        setBackground(new java.awt.Color(0, 204, 204));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(900, 640));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 0, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(51, 51, 255));
        jPanel2.setOpaque(false);

        jLabel4.setBackground(new java.awt.Color(255, 0, 153));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 0));
        jLabel4.setText("Seat Number :");

        jLabel5.setBackground(new java.awt.Color(255, 0, 204));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 255, 0));
        jLabel5.setText("First Name :");

        jLabel6.setBackground(new java.awt.Color(255, 0, 153));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 0));
        jLabel6.setText("Last Name :");

        jLabel7.setBackground(new java.awt.Color(255, 0, 153));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 255, 0));
        jLabel7.setText("Telephone :");

        jLabel8.setBackground(new java.awt.Color(255, 0, 153));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 0));
        jLabel8.setText("ID Number");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 0));
        jLabel9.setText("Email :");

        jTextField5.setEditable(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jToggleButton39.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton39.setToolTipText("");

        jToggleButton40.setBackground(new java.awt.Color(0, 0, 255));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Empty Seat");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Booked Seat");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Payment Method");

        jButton3.setBackground(new java.awt.Color(240, 12, 248));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("SEND");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Payment ID :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CASH", "M-PESA" }));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 255, 51));
        jLabel10.setText("Confirm travel Date:");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))))))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jButton3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jLabel7))
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jToggleButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jToggleButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(330, 20, 630, 510);

        jPanel1.setBackground(new java.awt.Color(255, 0, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Book Your Seat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel1.setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(255, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 51));
        jLabel1.setText("DOOR");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(102, 102, 0));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(204, 0, 0));
        jTextField1.setText("VIP  class");

        jToggleButton1.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton1.setText("1");
        jToggleButton1.setOpaque(true);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton2.setText("2");
        jToggleButton2.setOpaque(true);
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jToggleButton3.setBackground(new java.awt.Color(0, 255, 0));
        jToggleButton3.setForeground(new java.awt.Color(0, 0, 255));
        jToggleButton3.setSelected(true);
        jToggleButton3.setText("X");
        jToggleButton3.setOpaque(true);
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton4.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton4.setText("4");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jToggleButton5.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton5.setText("5");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });

        jToggleButton6.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton6.setText("6");
        jToggleButton6.setOpaque(true);
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(102, 102, 0));
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 0, 0));
        jTextField2.setText("Normal class");

        jToggleButton7.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton7.setText("7");
        jToggleButton7.setOpaque(true);
        jToggleButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton7ActionPerformed(evt);
            }
        });

        jToggleButton8.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton8.setText("8");
        jToggleButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton8ActionPerformed(evt);
            }
        });

        jToggleButton9.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton9.setText("9");
        jToggleButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton9ActionPerformed(evt);
            }
        });

        jToggleButton10.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton10.setText("10");
        jToggleButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton10ActionPerformed(evt);
            }
        });

        jToggleButton11.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton11.setText("11");
        jToggleButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton11ActionPerformed(evt);
            }
        });

        jToggleButton12.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton12.setText("12");
        jToggleButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton12ActionPerformed(evt);
            }
        });

        jToggleButton13.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton13.setText("13");
        jToggleButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton13ActionPerformed(evt);
            }
        });

        jToggleButton14.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton14.setText("14");
        jToggleButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton14ActionPerformed(evt);
            }
        });

        jToggleButton15.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton15.setText("15");
        jToggleButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton15ActionPerformed(evt);
            }
        });

        jToggleButton16.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton16.setText("16");
        jToggleButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton16ActionPerformed(evt);
            }
        });

        jToggleButton17.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton17.setText("17");
        jToggleButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton17ActionPerformed(evt);
            }
        });

        jToggleButton18.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton18.setText("18");
        jToggleButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton18ActionPerformed(evt);
            }
        });

        jToggleButton19.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton19.setText("19");
        jToggleButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton19ActionPerformed(evt);
            }
        });

        jToggleButton20.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton20.setText("20");
        jToggleButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton20ActionPerformed(evt);
            }
        });

        jToggleButton21.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton21.setText("21");
        jToggleButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton21ActionPerformed(evt);
            }
        });

        jToggleButton22.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton22.setText("22");
        jToggleButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton22ActionPerformed(evt);
            }
        });

        jToggleButton23.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton23.setText("23");
        jToggleButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton23ActionPerformed(evt);
            }
        });

        jToggleButton24.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton24.setText("24");
        jToggleButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton24ActionPerformed(evt);
            }
        });

        jToggleButton25.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton25.setText("25");
        jToggleButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton25ActionPerformed(evt);
            }
        });

        jToggleButton26.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton26.setText("26");
        jToggleButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton26ActionPerformed(evt);
            }
        });

        jToggleButton27.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton27.setText("27");
        jToggleButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton27ActionPerformed(evt);
            }
        });

        jToggleButton28.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton28.setText("28");
        jToggleButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton28ActionPerformed(evt);
            }
        });

        jToggleButton29.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton29.setText("29");
        jToggleButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton29ActionPerformed(evt);
            }
        });

        jToggleButton30.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton30.setText("30");
        jToggleButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton30ActionPerformed(evt);
            }
        });

        jToggleButton31.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton31.setText("31");
        jToggleButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton31ActionPerformed(evt);
            }
        });

        jToggleButton32.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton32.setText("32");
        jToggleButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton32ActionPerformed(evt);
            }
        });

        jToggleButton33.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton33.setText("33");
        jToggleButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton33ActionPerformed(evt);
            }
        });

        jToggleButton34.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton34.setText("34");
        jToggleButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton34ActionPerformed(evt);
            }
        });

        jToggleButton35.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton35.setText("35");
        jToggleButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton35ActionPerformed(evt);
            }
        });

        jToggleButton36.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton36.setText("36");
        jToggleButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton36ActionPerformed(evt);
            }
        });

        jToggleButton37.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton37.setText("37");
        jToggleButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton37ActionPerformed(evt);
            }
        });

        jToggleButton38.setBackground(new java.awt.Color(255, 153, 0));
        jToggleButton38.setText("38");
        jToggleButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton38ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToggleButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jToggleButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(jToggleButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToggleButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jToggleButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jToggleButton10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jToggleButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jToggleButton12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton13))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jToggleButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jToggleButton20)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jToggleButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jToggleButton16))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jToggleButton22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jToggleButton23))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jToggleButton26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jToggleButton27)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jToggleButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jToggleButton28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jToggleButton30)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jToggleButton31))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jToggleButton34)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jToggleButton35)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jToggleButton38)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jToggleButton36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jToggleButton32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jToggleButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jToggleButton21, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addComponent(jToggleButton25, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jToggleButton29, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(jToggleButton33, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jToggleButton37)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addGap(4, 4, 4)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jToggleButton6)
                        .addComponent(jToggleButton8)
                        .addComponent(jToggleButton9)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jToggleButton10)
                            .addComponent(jToggleButton11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jToggleButton12)
                            .addComponent(jToggleButton13))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jToggleButton14)
                        .addComponent(jToggleButton15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton18)
                    .addComponent(jToggleButton19)
                    .addComponent(jToggleButton20)
                    .addComponent(jToggleButton21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton22)
                    .addComponent(jToggleButton23)
                    .addComponent(jToggleButton24)
                    .addComponent(jToggleButton25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton26)
                    .addComponent(jToggleButton27)
                    .addComponent(jToggleButton28)
                    .addComponent(jToggleButton29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton30)
                    .addComponent(jToggleButton31)
                    .addComponent(jToggleButton32)
                    .addComponent(jToggleButton33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jToggleButton34)
                        .addComponent(jToggleButton35)
                        .addComponent(jToggleButton37)
                        .addComponent(jToggleButton38)))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 10, 280, 520);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 102));
        jLabel3.setText("please select your pickup point:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 537, 206, 28);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(220, 537, 228, 28);

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("BOOK THIS SEAT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(340, 580, 150, 30);

        jButton2.setBackground(new java.awt.Color(0, 0, 153));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(830, 580, 70, 23);

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("Developed by RodgermajorLtd");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(340, 620, 180, 20);

        jTextField13.setEditable(false);
        jTextField13.setBackground(new java.awt.Color(204, 204, 204));
        jTextField13.setFocusable(false);
        jTextField13.setOpaque(false);
        getContentPane().add(jTextField13);
        jTextField13.setBounds(330, 0, 140, 30);

        jTextField14.setEditable(false);
        jTextField14.setBackground(new java.awt.Color(204, 204, 204));
        jTextField14.setOpaque(false);
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField14);
        jTextField14.setBounds(140, 0, 140, 30);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("TO");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(300, 0, 20, 20);

        jLabel18.setText("BUSBOOKING ...");
        jLabel18.setToolTipText("");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(510, 10, 90, 14);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/wambua/org/Icons/background.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 960, 570);

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 255));
        jMenuBar1.setForeground(new java.awt.Color(0, 204, 0));

        jMenu2.setBackground(new java.awt.Color(0, 204, 204));
        jMenu2.setForeground(new java.awt.Color(0, 204, 204));
        jMenu2.setText("Action");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem1.setForeground(new java.awt.Color(0, 102, 153));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/wambua/org/Icons/back.png"))); // NOI18N
        jMenuItem1.setText("Back");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setForeground(new java.awt.Color(255, 0, 0));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/wambua/org/Icons/Cancel_48px.png"))); // NOI18N
        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add yo ur handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        jTextField5.setText("1");
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        jTextField5.setText("2");
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        jTextField5.setText("4");
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        jTextField5.setText("5");
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
        jTextField5.setText("6");
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jToggleButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton7ActionPerformed
        jTextField5.setText("7");
    }//GEN-LAST:event_jToggleButton7ActionPerformed

    private void jToggleButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton8ActionPerformed
        jTextField5.setText("8");
    }//GEN-LAST:event_jToggleButton8ActionPerformed

    private void jToggleButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton9ActionPerformed
        jTextField5.setText("9");
    }//GEN-LAST:event_jToggleButton9ActionPerformed

    private void jToggleButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton10ActionPerformed
        jTextField5.setText("10");
    }//GEN-LAST:event_jToggleButton10ActionPerformed

    private void jToggleButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton11ActionPerformed
        jTextField5.setText("11");
    }//GEN-LAST:event_jToggleButton11ActionPerformed

    private void jToggleButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton12ActionPerformed
        jTextField5.setText("12");
    }//GEN-LAST:event_jToggleButton12ActionPerformed

    private void jToggleButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton13ActionPerformed
        jTextField5.setText("13");
    }//GEN-LAST:event_jToggleButton13ActionPerformed

    private void jToggleButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton14ActionPerformed
        jTextField5.setText("14");
    }//GEN-LAST:event_jToggleButton14ActionPerformed

    private void jToggleButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton15ActionPerformed
        jTextField5.setText("15");
    }//GEN-LAST:event_jToggleButton15ActionPerformed

    private void jToggleButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton16ActionPerformed
        jTextField5.setText("16");
    }//GEN-LAST:event_jToggleButton16ActionPerformed

    private void jToggleButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton17ActionPerformed
        jTextField5.setText("17");
    }//GEN-LAST:event_jToggleButton17ActionPerformed

    private void jToggleButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton18ActionPerformed
        jTextField5.setText("18");
    }//GEN-LAST:event_jToggleButton18ActionPerformed

    private void jToggleButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton19ActionPerformed
        jTextField5.setText("19");
    }//GEN-LAST:event_jToggleButton19ActionPerformed

    private void jToggleButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton20ActionPerformed
        jTextField5.setText("20");
    }//GEN-LAST:event_jToggleButton20ActionPerformed

    private void jToggleButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton21ActionPerformed
        jTextField5.setText("21");
    }//GEN-LAST:event_jToggleButton21ActionPerformed

    private void jToggleButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton22ActionPerformed
        jTextField5.setText("22");
    }//GEN-LAST:event_jToggleButton22ActionPerformed

    private void jToggleButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton23ActionPerformed
        jTextField5.setText("23");
    }//GEN-LAST:event_jToggleButton23ActionPerformed

    private void jToggleButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton24ActionPerformed
        jTextField5.setText("24");
    }//GEN-LAST:event_jToggleButton24ActionPerformed

    private void jToggleButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton25ActionPerformed
        jTextField5.setText("25");
    }//GEN-LAST:event_jToggleButton25ActionPerformed

    private void jToggleButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton26ActionPerformed
        jTextField5.setText("26");
    }//GEN-LAST:event_jToggleButton26ActionPerformed

    private void jToggleButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton27ActionPerformed
        jTextField5.setText("27");
    }//GEN-LAST:event_jToggleButton27ActionPerformed

    private void jToggleButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton28ActionPerformed
        jTextField5.setText("28");
    }//GEN-LAST:event_jToggleButton28ActionPerformed

    private void jToggleButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton29ActionPerformed
        jTextField5.setText("29");
    }//GEN-LAST:event_jToggleButton29ActionPerformed

    private void jToggleButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton30ActionPerformed
        jTextField5.setText("30");
    }//GEN-LAST:event_jToggleButton30ActionPerformed

    private void jToggleButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton31ActionPerformed
        jTextField5.setText("31");
    }//GEN-LAST:event_jToggleButton31ActionPerformed

    private void jToggleButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton32ActionPerformed
        jTextField5.setText("32");
    }//GEN-LAST:event_jToggleButton32ActionPerformed

    private void jToggleButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton33ActionPerformed
        jTextField5.setText("33");
    }//GEN-LAST:event_jToggleButton33ActionPerformed

    private void jToggleButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton34ActionPerformed
        jTextField5.setText("34");
    }//GEN-LAST:event_jToggleButton34ActionPerformed

    private void jToggleButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton35ActionPerformed
        jTextField5.setText("35");
    }//GEN-LAST:event_jToggleButton35ActionPerformed

    private void jToggleButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton36ActionPerformed
        jTextField5.setText("36");
    }//GEN-LAST:event_jToggleButton36ActionPerformed

    private void jToggleButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton37ActionPerformed
        jTextField5.setText("37");
    }//GEN-LAST:event_jToggleButton37ActionPerformed

    private void jToggleButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton38ActionPerformed
        jTextField5.setText("38");
    }//GEN-LAST:event_jToggleButton38ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

       if (payment()) {
            if (validateFields()) {
                String sql = "Insert into "+busname+"(SeatNo,First_Name,Last_Name,Telephone,ID_Number ,Email,Pickup, TravelDate ) values(?,?,?,?,?,?,?,? )";
                try {
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, jTextField5.getText());
                    pst.setString(2, jTextField6.getText());
                    pst.setString(3, jTextField7.getText());
                    pst.setString(4, jTextField8.getText());
                    pst.setString(5, jTextField9.getText());
                    pst.setString(6, jTextField10.getText());
                    pst.setString(7, jTextField3.getText());
                    pst.setString(8, ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText());
                    pst.execute();

                    JOptionPane.showMessageDialog(null, "You have successfully booked your seat...please keep time ");

                    //update buttons
                    //check which button was selected 
                    switch (jTextField5.getText()) {
                        case "1":
                            jToggleButton1.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(1, true,busname);
                            break;
                        case "2":
                            jToggleButton2.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(2, true,busname);

                            break;
                        case "3":
                            jToggleButton3.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(3, true,busname);
                            break;
                        case "4":
                            jToggleButton4.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(4, true,busname);
                            break;
                        case "5":
                            jToggleButton5.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(5,true,busname);
                            break;
                        case "6":
                            jToggleButton6.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(6,true,busname);
                            break;
                        case "7":
                            jToggleButton7.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(7,true,busname);
                            break;
                        case "8":
                            jToggleButton8.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(8,true,busname);
                            break;
                        case "9":
                            jToggleButton9.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(9,true,busname);
                            break;
                        case "10":
                            jToggleButton10.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(10,true,busname);
                            break;
                        case "11":
                            jToggleButton11.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(11,true,busname);
                            break;
                        case "12":
                            jToggleButton12.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(12,true,busname);
                            break;
                        case "13":
                            jToggleButton13.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(13,true,busname);
                            break;
                        case "14":
                            jToggleButton14.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(14,true,busname);
                            break;
                        case "15":
                            jToggleButton15.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(15,true,busname);
                            break;
                        case "16":
                            jToggleButton16.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(16,true,busname);
                            break;
                        case "17":
                            jToggleButton17.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(17,true,busname);
                            break;
                        case "18":
                            jToggleButton18.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(18,true,busname);
                            break;
                        case "19":
                            jToggleButton19.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(19,true,busname);
                            break;
                        case "20":
                            jToggleButton20.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(20,true,busname);
                            break;
                        case "21":
                            jToggleButton21.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(21,true,busname);
                            break;
                        case "22":
                            jToggleButton22.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(22,true,busname);
                            break;
                        case "23":
                            jToggleButton23.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(23,true,busname);
                            break;
                        case "24":
                            jToggleButton24.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(24,true,busname);
                            break;
                        case "25":
                            jToggleButton25.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(25,true,busname);
                            break;
                        case "26":
                            jToggleButton26.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(26,true,busname);
                            break;
                        case "27":
                            jToggleButton27.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(27,true,busname);
                            break;
                        case "28":
                            jToggleButton28.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(28,true,busname);
                            break;
                        case "29":
                            jToggleButton29.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(29,true,busname);
                            break;
                        case "30":
                            jToggleButton30.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(30,true,busname);
                            break;
                        case "31":
                            jToggleButton31.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(31,true,busname);
                            break;
                        case "32":
                            jToggleButton32.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(32,true,busname);
                            break;
                        case "33":
                            jToggleButton33.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(33,true,busname);
                            break;
                        case "34":
                            jToggleButton34.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(34,true,busname);
                            break;
                        case "35":
                            jToggleButton35.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(35,true,busname);
                            break;
                        case "36":
                            jToggleButton36.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(36,true,busname);
                            break;
                        case "37":
                            jToggleButton37.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(37,true,busname);
                            break;
                        case "38":
                            jToggleButton38.setBackground(Color.BLUE);
                            DatabaseAccessObjects.updateCoachSeatBookingStatus(38,true,busname);
                            break;
                        default:
                            break;

                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
                   BusTicketGenerationService.generateTicketDetailsPdf();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
        ClientHome ob = new ClientHome();
        ob.setLocationRelativeTo(null);
        ob.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        payment();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         setVisible(false);
         ClientHome ob = new ClientHome();
         ob.setLocationRelativeTo(null);
         ob.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(BussBookingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BussBookingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BussBookingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BussBookingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BussBookingView("mombassa","nairobi","busName","2017-01-11").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton10;
    private javax.swing.JToggleButton jToggleButton11;
    private javax.swing.JToggleButton jToggleButton12;
    private javax.swing.JToggleButton jToggleButton13;
    private javax.swing.JToggleButton jToggleButton14;
    private javax.swing.JToggleButton jToggleButton15;
    private javax.swing.JToggleButton jToggleButton16;
    private javax.swing.JToggleButton jToggleButton17;
    private javax.swing.JToggleButton jToggleButton18;
    private javax.swing.JToggleButton jToggleButton19;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton20;
    private javax.swing.JToggleButton jToggleButton21;
    private javax.swing.JToggleButton jToggleButton22;
    private javax.swing.JToggleButton jToggleButton23;
    private javax.swing.JToggleButton jToggleButton24;
    private javax.swing.JToggleButton jToggleButton25;
    private javax.swing.JToggleButton jToggleButton26;
    private javax.swing.JToggleButton jToggleButton27;
    private javax.swing.JToggleButton jToggleButton28;
    private javax.swing.JToggleButton jToggleButton29;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton30;
    private javax.swing.JToggleButton jToggleButton31;
    private javax.swing.JToggleButton jToggleButton32;
    private javax.swing.JToggleButton jToggleButton33;
    private javax.swing.JToggleButton jToggleButton34;
    private javax.swing.JToggleButton jToggleButton35;
    private javax.swing.JToggleButton jToggleButton36;
    private javax.swing.JToggleButton jToggleButton37;
    private javax.swing.JToggleButton jToggleButton38;
    private javax.swing.JToggleButton jToggleButton39;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton40;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JToggleButton jToggleButton8;
    private javax.swing.JToggleButton jToggleButton9;
    // End of variables declaration//GEN-END:variables
}
