/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package thriftstore_pointofsale_system;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author Kinston
 */
public class Pos_admin2 extends javax.swing.JFrame {

    /**
     * Creates new form Pos_homepage
     */
    private javax.swing.JTextField activeField = null;
    
    public Pos_admin2() {
        initComponents();
        loadProductsToAdminTable();
         
        styleAdminTable();
        
         

        
        
        jtxt_admin2_search.addKeyListener(new java.awt.event.KeyAdapter() {
    @Override
    public void keyReleased(java.awt.event.KeyEvent evt) {
        searchProducts(jtxt_admin2_search.getText().trim());
    }
});
        
        jTablePane_admin5.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTablePane_admin5MouseClicked(evt);
            
            
            
        }
    });

        
        jtxt_admin2_productdiscount.addFocusListener(new java.awt.event.FocusAdapter() {
    @Override
    public void focusGained(java.awt.event.FocusEvent evt) {
        activeField = jtxt_admin2_productdiscount;
    }
});
        
        jtxt_admin2_productprice.addFocusListener(new java.awt.event.FocusAdapter() {
    @Override
    public void focusGained(java.awt.event.FocusEvent evt) {
        activeField = jtxt_admin2_productprice;
    }
});

// 4. IDUGANG KINI: Validation aron numero ug decimal ra ang madawat sa discount ug price
jtxt_admin2_productdiscount.addKeyListener(new java.awt.event.KeyAdapter() {
    @Override
    public void keyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '.') {
            evt.consume();
        }
        if (c == '.' && jtxt_admin2_productdiscount.getText().contains(".")) {
            evt.consume();
        }
    }
});

jtxt_admin2_productprice.addKeyListener(new java.awt.event.KeyAdapter() {
    @Override
    public void keyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '.') {
            evt.consume();
        }
        if (c == '.' && jtxt_admin2_productprice.getText().contains(".")) {
            evt.consume();
        }
    }
});
    }
    
    
    
    
private void styleAdminTable() {
    // 1. Table Header Renderer (Dark theme nga naay orange nga linya sa ilalom)
    javax.swing.table.TableCellRenderer darkHeaderRenderer = new javax.swing.table.DefaultTableCellRenderer() {
        @Override
        public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            javax.swing.JLabel lbl = (javax.swing.JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            lbl.setBackground(new java.awt.Color(30, 30, 30));
            lbl.setForeground(java.awt.Color.WHITE);
            lbl.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
            lbl.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 140, 0)));
            lbl.setHorizontalAlignment(javax.swing.JLabel.CENTER);
            return lbl;
        }
    };

    // 2. Data Cells Renderer (Centered alignment)
    javax.swing.table.DefaultTableCellRenderer centerCellRenderer = new javax.swing.table.DefaultTableCellRenderer();
    centerCellRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);

    // 3. Table Styling (jTablePane_admin5)
    jTablePane_admin5.setBackground(new java.awt.Color(40, 40, 40));
    jTablePane_admin5.setForeground(java.awt.Color.WHITE);
    jTablePane_admin5.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
    jTablePane_admin5.setRowHeight(28);
    jTablePane_admin5.setShowGrid(false);
    jTablePane_admin5.setSelectionBackground(new java.awt.Color(255, 140, 0));
    jTablePane_admin5.setSelectionForeground(java.awt.Color.BLACK);

    jTablePane_admin5.getTableHeader().setOpaque(false);
    jTablePane_admin5.getTableHeader().setDefaultRenderer(darkHeaderRenderer);

    for (int i = 0; i < jTablePane_admin5.getColumnCount(); i++) {
        jTablePane_admin5.getColumnModel().getColumn(i).setCellRenderer(centerCellRenderer);
    }

    // 4. ScrollPane Styling (jScrollPane5) - Naay Orange Border sama sa imong gusto
    jScrollPane5.getViewport().setBackground(new java.awt.Color(40, 40, 40));
    jScrollPane5.setBackground(new java.awt.Color(40, 40, 40));
    jScrollPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 140, 0), 1));
    jScrollPane5.setOpaque(true);
}

    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jtxt_admin2_productprice = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jtxt_admin2_productname = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jtxt_admin2_productdiscount = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTablePane_admin5 = new javax.swing.JTable();
        jLabel66 = new javax.swing.JLabel();
        jtxt_admin2_search = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jbtn_admin2_updateproduct = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jbtn_admin2_7 = new javax.swing.JButton();
        jbtn_admin2_8 = new javax.swing.JButton();
        jbtn_admin2_9 = new javax.swing.JButton();
        jbtn_admin2_4 = new javax.swing.JButton();
        jbtn_admin2_5 = new javax.swing.JButton();
        jbtn_admin2_6 = new javax.swing.JButton();
        jbtn_admin2_1 = new javax.swing.JButton();
        jbtn_admin2_2 = new javax.swing.JButton();
        jbtn_admin2_3 = new javax.swing.JButton();
        jbtn_admin2_Ce = new javax.swing.JButton();
        jbtn_admin2_0 = new javax.swing.JButton();
        jbtn_admin2_Del = new javax.swing.JButton();
        jbtn_adminback = new javax.swing.JButton();
        jbtn_adminpanel4_logout = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(30, 32, 40));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(30, 32, 40));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 5, true));

        jLabel64.setBackground(new java.awt.Color(255, 255, 255));
        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("PRODUCT DISCOUNT :");

        jtxt_admin2_productprice.setBackground(new java.awt.Color(255, 255, 255));
        jtxt_admin2_productprice.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jtxt_admin2_productprice.setForeground(new java.awt.Color(0, 0, 0));
        jtxt_admin2_productprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_admin2_productpriceActionPerformed(evt);
            }
        });

        jLabel68.setBackground(new java.awt.Color(255, 255, 255));
        jLabel68.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("PRODUCT NAME :");

        jtxt_admin2_productname.setBackground(new java.awt.Color(255, 255, 255));
        jtxt_admin2_productname.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jtxt_admin2_productname.setForeground(new java.awt.Color(255, 255, 255));
        jtxt_admin2_productname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_admin2_productnameActionPerformed(evt);
            }
        });

        jLabel65.setBackground(new java.awt.Color(255, 255, 255));
        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("PRODUCT PRICE :");

        jtxt_admin2_productdiscount.setBackground(new java.awt.Color(255, 255, 255));
        jtxt_admin2_productdiscount.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jtxt_admin2_productdiscount.setForeground(new java.awt.Color(0, 0, 0));
        jtxt_admin2_productdiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_admin2_productdiscountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel65)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel68)
                        .addComponent(jLabel64)
                        .addComponent(jtxt_admin2_productname, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                        .addComponent(jtxt_admin2_productprice)
                        .addComponent(jtxt_admin2_productdiscount, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel68)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxt_admin2_productname, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel64)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxt_admin2_productdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jLabel65)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxt_admin2_productprice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 370, 430));

        jPanel5.setBackground(new java.awt.Color(30, 32, 40));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 5, true));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTablePane_admin5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "PRODUCT NAME", "PRODUCT DISCOUNT", "PRODUCT PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTablePane_admin5);

        jPanel5.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 690, 580));

        jLabel66.setBackground(new java.awt.Color(255, 255, 255));
        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("SEARCH PRODUCT HERE:");
        jPanel5.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, -1, -1));

        jtxt_admin2_search.setBackground(new java.awt.Color(255, 255, 255));
        jtxt_admin2_search.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jtxt_admin2_search.setForeground(new java.awt.Color(0, 0, 0));
        jtxt_admin2_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_admin2_searchActionPerformed(evt);
            }
        });
        jPanel5.add(jtxt_admin2_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 630, 330, 40));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 730, 720));

        jPanel7.setBackground(new java.awt.Color(30, 32, 40));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 5, true));

        jbtn_admin2_updateproduct.setBackground(new java.awt.Color(0, 204, 204));
        jbtn_admin2_updateproduct.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbtn_admin2_updateproduct.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_admin2_updateproduct.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\ADMIN ICONS\\icons8-edit-96.png")); // NOI18N
        jbtn_admin2_updateproduct.setText("EDIT PRODUCT DETAILS");
        jbtn_admin2_updateproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin2_updateproductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jbtn_admin2_updateproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jbtn_admin2_updateproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 450, 750, 270));

        jPanel6.setBackground(new java.awt.Color(30, 32, 40));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 5, true));

        jbtn_admin2_7.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_admin2_7.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 48)); // NOI18N
        jbtn_admin2_7.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_admin2_7.setText("7");
        jbtn_admin2_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin2_7ActionPerformed(evt);
            }
        });

        jbtn_admin2_8.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_admin2_8.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 48)); // NOI18N
        jbtn_admin2_8.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_admin2_8.setText("8");
        jbtn_admin2_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin2_8ActionPerformed(evt);
            }
        });

        jbtn_admin2_9.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_admin2_9.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 48)); // NOI18N
        jbtn_admin2_9.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_admin2_9.setText("9");
        jbtn_admin2_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin2_9ActionPerformed(evt);
            }
        });

        jbtn_admin2_4.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_admin2_4.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 48)); // NOI18N
        jbtn_admin2_4.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_admin2_4.setText("4");
        jbtn_admin2_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin2_4ActionPerformed(evt);
            }
        });

        jbtn_admin2_5.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_admin2_5.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 48)); // NOI18N
        jbtn_admin2_5.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_admin2_5.setText("5");
        jbtn_admin2_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin2_5ActionPerformed(evt);
            }
        });

        jbtn_admin2_6.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_admin2_6.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 48)); // NOI18N
        jbtn_admin2_6.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_admin2_6.setText("6");
        jbtn_admin2_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin2_6ActionPerformed(evt);
            }
        });

        jbtn_admin2_1.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_admin2_1.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 48)); // NOI18N
        jbtn_admin2_1.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_admin2_1.setText("1");
        jbtn_admin2_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin2_1ActionPerformed(evt);
            }
        });

        jbtn_admin2_2.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_admin2_2.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 48)); // NOI18N
        jbtn_admin2_2.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_admin2_2.setText("2");
        jbtn_admin2_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin2_2ActionPerformed(evt);
            }
        });

        jbtn_admin2_3.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_admin2_3.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 48)); // NOI18N
        jbtn_admin2_3.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_admin2_3.setText("3");
        jbtn_admin2_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin2_3ActionPerformed(evt);
            }
        });

        jbtn_admin2_Ce.setBackground(new java.awt.Color(255, 255, 0));
        jbtn_admin2_Ce.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 48)); // NOI18N
        jbtn_admin2_Ce.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_admin2_Ce.setText("CE");
        jbtn_admin2_Ce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin2_CeActionPerformed(evt);
            }
        });

        jbtn_admin2_0.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_admin2_0.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 48)); // NOI18N
        jbtn_admin2_0.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_admin2_0.setText("0");
        jbtn_admin2_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin2_0ActionPerformed(evt);
            }
        });

        jbtn_admin2_Del.setBackground(new java.awt.Color(204, 0, 0));
        jbtn_admin2_Del.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jbtn_admin2_Del.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_admin2_Del.setText("DEL");
        jbtn_admin2_Del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin2_DelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jbtn_admin2_7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtn_admin2_8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtn_admin2_9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jbtn_admin2_Ce, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtn_admin2_0, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtn_admin2_Del, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtn_admin2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtn_admin2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbtn_admin2_5, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(jbtn_admin2_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtn_admin2_6, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(jbtn_admin2_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbtn_admin2_8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(jbtn_admin2_7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_admin2_9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbtn_admin2_4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtn_admin2_6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtn_admin2_5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbtn_admin2_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(jbtn_admin2_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_admin2_1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbtn_admin2_0, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_admin2_Ce, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_admin2_Del, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 10, 370, 430));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1500, 730));

        jbtn_adminback.setBackground(new java.awt.Color(30, 32, 40));
        jbtn_adminback.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jbtn_adminback.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_adminback.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\ADMIN ICONS\\icons8-gear-100.png")); // NOI18N
        jbtn_adminback.setText("BACK TO ADMIN PANEL");
        jbtn_adminback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminbackActionPerformed(evt);
            }
        });
        getContentPane().add(jbtn_adminback, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 20, 480, 80));

        jbtn_adminpanel4_logout.setBackground(new java.awt.Color(255, 0, 0));
        jbtn_adminpanel4_logout.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbtn_adminpanel4_logout.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_adminpanel4_logout.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\MAIN TERMINALBUTTONS\\icons8-logout-48.png")); // NOI18N
        jbtn_adminpanel4_logout.setText("LOGOUT");
        jbtn_adminpanel4_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminpanel4_logoutActionPerformed(evt);
            }
        });
        getContentPane().add(jbtn_adminpanel4_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, 370, 90));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\GUI_bg_homepage1920x1080.jpg")); // NOI18N
        jLabel5.setText("\n");
        jLabel5.setMaximumSize(new java.awt.Dimension(1920, 1080));
        jLabel5.setMinimumSize(new java.awt.Dimension(1920, 1080));
        jLabel5.setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 770));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\GUI_bg_homepage1920x1080.jpg")); // NOI18N
        jLabel3.setText("\n");
        jLabel3.setMaximumSize(new java.awt.Dimension(1920, 1080));
        jLabel3.setMinimumSize(new java.awt.Dimension(1920, 1080));
        jLabel3.setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 1240, 770));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\GUI_bg_homepage1920x1080.jpg")); // NOI18N
        jLabel4.setText("\n");
        jLabel4.setMaximumSize(new java.awt.Dimension(1920, 1080));
        jLabel4.setMinimumSize(new java.awt.Dimension(1920, 1080));
        jLabel4.setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 520, -1, 1080));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\GUI_bg_homepage1920x1080.jpg")); // NOI18N
        jLabel6.setText("\n");
        jLabel6.setMaximumSize(new java.awt.Dimension(1920, 1080));
        jLabel6.setMinimumSize(new java.awt.Dimension(1920, 1080));
        jLabel6.setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, 1380, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void appendToActiveField(String val) {
    if (activeField == jtxt_admin2_productdiscount || activeField == jtxt_admin2_productprice) {
        activeField.setText(activeField.getText() + val);
    }
}


    
    
    
    private void jbtn_adminbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminbackActionPerformed
        int choice = JOptionPane.showConfirmDialog(
        this,"Are you sure you want to Go Back to Admin Panel?",
        "Confirmation",JOptionPane.YES_NO_OPTION,
        JOptionPane.WARNING_MESSAGE);

        if (choice == JOptionPane.YES_OPTION) {
            new Pos_admin1().setVisible(true);
            this.dispose();
            
        } else if (choice == JOptionPane.NO_OPTION) {
    
        } 

    }//GEN-LAST:event_jbtn_adminbackActionPerformed

   
    
    
    
    
    

    
    
 
    
    
   
     
 
    
    
    
    
    private void jbtn_adminpanel4_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminpanel4_logoutActionPerformed
        int choice = JOptionPane.showConfirmDialog(
        this,"Are you sure you want to Log Out?",
        "Confirmation",JOptionPane.YES_NO_OPTION,
        JOptionPane.WARNING_MESSAGE);

        if (choice == JOptionPane.YES_OPTION) {
            new Pos_login().setVisible(true);
            this.dispose();
            
        } else if (choice == JOptionPane.NO_OPTION) {
    
        } 
    }//GEN-LAST:event_jbtn_adminpanel4_logoutActionPerformed

    private void jbtn_admin2_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin2_7ActionPerformed
        if (activeField == jtxt_admin2_productdiscount || activeField == jtxt_admin2_productprice) {
        activeField.setText(activeField.getText() + "7");
    }

    }//GEN-LAST:event_jbtn_admin2_7ActionPerformed

    private void jbtn_admin2_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin2_8ActionPerformed
        if (activeField == jtxt_admin2_productdiscount || activeField == jtxt_admin2_productprice) {
        activeField.setText(activeField.getText() + "8");
    }

    }//GEN-LAST:event_jbtn_admin2_8ActionPerformed

    private void jbtn_admin2_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin2_9ActionPerformed
        if (activeField == jtxt_admin2_productdiscount || activeField == jtxt_admin2_productprice) {
        activeField.setText(activeField.getText() + "9");
    }

    }//GEN-LAST:event_jbtn_admin2_9ActionPerformed

    private void jbtn_admin2_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin2_4ActionPerformed
        if (activeField == jtxt_admin2_productdiscount || activeField == jtxt_admin2_productprice) {
        activeField.setText(activeField.getText() + "4");
    }

    }//GEN-LAST:event_jbtn_admin2_4ActionPerformed

    private void jbtn_admin2_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin2_5ActionPerformed
        if (activeField == jtxt_admin2_productdiscount || activeField == jtxt_admin2_productprice) {
        activeField.setText(activeField.getText() + "5");
    }

    }//GEN-LAST:event_jbtn_admin2_5ActionPerformed

    private void jbtn_admin2_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin2_6ActionPerformed
        if (activeField == jtxt_admin2_productdiscount || activeField == jtxt_admin2_productprice) {
        activeField.setText(activeField.getText() + "6");
    }

    }//GEN-LAST:event_jbtn_admin2_6ActionPerformed

    private void jbtn_admin2_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin2_1ActionPerformed
        if (activeField == jtxt_admin2_productdiscount || activeField == jtxt_admin2_productprice) {
        activeField.setText(activeField.getText() + "1");
    }

    }//GEN-LAST:event_jbtn_admin2_1ActionPerformed

    private void jbtn_admin2_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin2_2ActionPerformed
        if (activeField == jtxt_admin2_productdiscount || activeField == jtxt_admin2_productprice) {
        activeField.setText(activeField.getText() + "2");
    }

    }//GEN-LAST:event_jbtn_admin2_2ActionPerformed

    private void jbtn_admin2_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin2_3ActionPerformed
        if (activeField == jtxt_admin2_productdiscount || activeField == jtxt_admin2_productprice) {
        activeField.setText(activeField.getText() + "3");
    }

    }//GEN-LAST:event_jbtn_admin2_3ActionPerformed

    private void jbtn_admin2_CeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin2_CeActionPerformed
        if (activeField == jtxt_admin2_productdiscount || activeField == jtxt_admin2_productprice) {
        activeField.setText("");
    }
        
    }//GEN-LAST:event_jbtn_admin2_CeActionPerformed

    private void jbtn_admin2_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin2_0ActionPerformed
        if (activeField == jtxt_admin2_productdiscount || activeField == jtxt_admin2_productprice) {
        activeField.setText(activeField.getText() + "0");
    }

    }//GEN-LAST:event_jbtn_admin2_0ActionPerformed

    private void jbtn_admin2_DelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin2_DelActionPerformed
        if (activeField == jtxt_admin2_productdiscount || activeField == jtxt_admin2_productprice) {
        String currentText = activeField.getText();
        if (currentText != null && currentText.length() > 0) {
            activeField.setText(currentText.substring(0, currentText.length() - 1));
        }
    }
        
    }//GEN-LAST:event_jbtn_admin2_DelActionPerformed

    private void searchProducts(String keyword) {
    try {
        java.sql.Connection con = DBConnection2.connect();
        String sql = "SELECT product_name, discount, price FROM tbl_products WHERE LOWER(product_name) LIKE ?";
        PreparedStatement pst = con.prepareStatement(sql);
        
        // Ang '%' sa kilid nagpasabot nga bisan asa nga part sa word o first letters mo-match siya
        pst.setString(1, "%" + keyword.toLowerCase() + "%");
        
        ResultSet rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) jTablePane_admin5.getModel();
        model.setRowCount(0); // I-clear ang lumang data

        while (rs.next()) {
            String name = rs.getString("product_name");
            double discount = rs.getDouble("discount");
            double price = rs.getDouble("price");

            model.addRow(new Object[]{name, discount, price});
        }

        rs.close();
        pst.close();
        con.close();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error searching products: " + e.getMessage());
    }
}
    
    
    
    
    private void loadProductsToAdminTable() {
    try {
        String url = "jdbc:mysql://localhost:3306/pointofsale_thriftstore";
        String user = "root";
        String password = "";
        
        java.sql.Connection con = java.sql.DriverManager.getConnection(url, user, password);
        String sql = "SELECT product_name, discount, price FROM tbl_products";
        java.sql.Statement st = con.createStatement();
        java.sql.ResultSet rs = st.executeQuery(sql);

        // Kuhaa ang model sa imong table
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTablePane_admin5.getModel();
        model.setRowCount(0); // I-clear ang lumang data aron dili mag-doble

        while (rs.next()) {
            String name = rs.getString("product_name");
            double discount = rs.getDouble("discount");
            double price = rs.getDouble("price");

            // I-add sa table base sa saktong order sa columns:
            // Column 0: Name, Column 1: Discount, Column 2: Price
            model.addRow(new Object[]{name, discount, price});
        }

        rs.close();
        st.close();
        con.close();

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error loading products: " + e.getMessage());
    }
    
    }
    
    
    private void jTablePane_admin5MouseClicked(java.awt.event.MouseEvent evt) {                                             
   int selectedRow = jTablePane_admin5.getSelectedRow();
    
    if (selectedRow != -1) {
        // I-reset sa null ang activeField sa dili pa mag-load og bag-ong data
        activeField = null; 
        
        DefaultTableModel model = (DefaultTableModel) jTablePane_admin5.getModel();
        
        Object nameObj = model.getValueAt(selectedRow, 0); 
        Object discountObj = model.getValueAt(selectedRow, 1); 
        Object priceObj = model.getValueAt(selectedRow, 2); 
        
        String productName = (nameObj != null) ? nameObj.toString() : "";
        String productDiscount = (discountObj != null) ? discountObj.toString() : "";
        String productPrice = (priceObj != null) ? priceObj.toString() : "";
        
        // I-set sa textfields
        jtxt_admin2_productname.setText(productName);
        jtxt_admin2_productdiscount.setText(productDiscount);
        jtxt_admin2_productprice.setText(productPrice);
        
        jtxt_admin2_productname.setForeground(java.awt.Color.BLACK); 
        jtxt_admin2_productname.setEditable(false); 
        
        System.out.println("Selected Product: " + productName); 
    }
}
    
    
    
    
    
    
    private void jbtn_admin2_updateproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin2_updateproductActionPerformed
    String name = jtxt_admin2_productname.getText().trim();
String discountStr = jtxt_admin2_productdiscount.getText().trim();
String priceStr = jtxt_admin2_productprice.getText().trim();

// 1. I-check kung blangko ba ang mga fields
if (name.isEmpty() || discountStr.isEmpty() || priceStr.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Palihug pun-i ang tanang fields!", "WARNING", JOptionPane.WARNING_MESSAGE);
    return;
}

try {
    // 2. I-convert ngadto sa Double ug i-validate ang mga numero
    double discount = Double.parseDouble(discountStr);
    double price = Double.parseDouble(priceStr);
    
    // 3. I-check kung negatibo ba ang discount o presyo
    if (discount < 0 || price < 0) {
        JOptionPane.showMessageDialog(this, "Ang discount o presyo dili mahimong negatibo!", "WARNING", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // 4. LIMIT VALIDATION: Dili pwede molapas sa 900 ang presyo para dili ma-break ang cards
    if (price > 900.0) {
        JOptionPane.showMessageDialog(this, "Ang pinakataas nga presyo kay 900 lamang aron dili ma-destruktir ang imong display cards!", "WARNING", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // 5. Database Update Connection
    Connection con = DBConnection2.connect();
    String sql = "UPDATE tbl_products SET discount = ?, price = ? WHERE product_name = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    
    pst.setDouble(1, discount);
    pst.setDouble(2, price);
    pst.setString(3, name);
    
    int rowsUpdated = pst.executeUpdate();
    if (rowsUpdated > 0) {
        JOptionPane.showMessageDialog(this, "Product updated successfully!");
        loadProductsToAdminTable(); 
    } else {
        JOptionPane.showMessageDialog(this, "Walay nakit-an nga produkto nga gi-update.", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    pst.close();
    con.close();
    
} catch (NumberFormatException e) {
    // Kung ang gi-type sa user kay dili tinuod nga numero (pananglitan naay mga letra)
    JOptionPane.showMessageDialog(this, "Palihug isulat ang saktong numero para sa Discount ug Price!", "ERROR", JOptionPane.ERROR_MESSAGE);
} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
}



    }//GEN-LAST:event_jbtn_admin2_updateproductActionPerformed

    private void jtxt_admin2_productnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_admin2_productnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_admin2_productnameActionPerformed

    private void jtxt_admin2_productpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_admin2_productpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_admin2_productpriceActionPerformed

    private void jtxt_admin2_productdiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_admin2_productdiscountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_admin2_productdiscountActionPerformed

    private void jtxt_admin2_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_admin2_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_admin2_searchActionPerformed

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
            java.util.logging.Logger.getLogger(Pos_admin2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pos_admin2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pos_admin2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pos_admin2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pos_admin2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTablePane_admin5;
    private javax.swing.JButton jbtn_admin2_0;
    private javax.swing.JButton jbtn_admin2_1;
    private javax.swing.JButton jbtn_admin2_2;
    private javax.swing.JButton jbtn_admin2_3;
    private javax.swing.JButton jbtn_admin2_4;
    private javax.swing.JButton jbtn_admin2_5;
    private javax.swing.JButton jbtn_admin2_6;
    private javax.swing.JButton jbtn_admin2_7;
    private javax.swing.JButton jbtn_admin2_8;
    private javax.swing.JButton jbtn_admin2_9;
    private javax.swing.JButton jbtn_admin2_Ce;
    private javax.swing.JButton jbtn_admin2_Del;
    private javax.swing.JButton jbtn_admin2_updateproduct;
    private javax.swing.JButton jbtn_adminback;
    private javax.swing.JButton jbtn_adminpanel4_logout;
    private javax.swing.JTextField jtxt_admin2_productdiscount;
    private javax.swing.JTextField jtxt_admin2_productname;
    private javax.swing.JTextField jtxt_admin2_productprice;
    private javax.swing.JTextField jtxt_admin2_search;
    // End of variables declaration//GEN-END:variables
}
