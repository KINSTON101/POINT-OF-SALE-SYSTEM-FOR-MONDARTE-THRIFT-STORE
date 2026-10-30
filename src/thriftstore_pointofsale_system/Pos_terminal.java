/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package thriftstore_pointofsale_system;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.RescaleOp;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Rectangle;








/**
 *
 * @author Kinston
 */
public class Pos_terminal extends javax.swing.JFrame {

    /**
     * Creates new form Pos_homepage
     */
    public Pos_terminal() {
        initComponents();
        loadPricesFromDB();
        loadTerminalPrices();
        
        javax.swing.SpinnerNumberModel spinnerModel = new javax.swing.SpinnerNumberModel(0, 0, 100, 1);
jSpinner_hmpg1.setModel(spinnerModel);
       
        
        
        javax.swing.JTextField tf = ((javax.swing.JSpinner.DefaultEditor) jSpinner_hmpg1.getEditor()).getTextField();
        tf.addKeyListener(new java.awt.event.KeyAdapter() {
    public void keyTyped(java.awt.event.KeyEvent e) {
        if (!Character.isDigit(e.getKeyChar())) {
            e.consume();
            }
    }
});
        

 jSpinner_hmpg1.addChangeListener(new javax.swing.event.ChangeListener() {
    public void stateChanged(javax.swing.event.ChangeEvent evt) {
        int selectedRow = jTable_hmpgMaintable.getSelectedRow();
        if (selectedRow != -1) {
            try {
                int spinnerVal = (Integer) jSpinner_hmpg1.getValue();
                if (spinnerVal > 0) {
                    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable_hmpgMaintable.getModel();
                    
                    // Kuhaon ang unit price
                    int currentQty = Integer.parseInt(model.getValueAt(selectedRow, 1).toString());
                    Object amtObj = model.getValueAt(selectedRow, 2);
                    double currentAmount = Double.parseDouble(amtObj.toString().replace(",", "").replace("PHP", "").trim());
                    double unitPrice = currentAmount / currentQty;
                    
                    // Update table quantity
                    model.setValueAt(spinnerVal, selectedRow, 1);
                    
                    // Update table amount base sa bag-ong spinner value
                    double newAmount = spinnerVal * unitPrice;
                    java.text.DecimalFormat df = new java.text.DecimalFormat("#,##0.00");
                    model.setValueAt(df.format(newAmount), selectedRow, 2);
                    
                    // Recalculate totals
                    calculateTotal();
                }
            } catch (Exception e) {
                // I-ignore lang ang gamay nga conversion error samtang ga-type
            }
        }
    }
});     
     
        
        
        
   
   
   
        
        
// ==================== TABLE MODEL SETUP ====================
javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
    new Object [][] {},
    new String [] { "PRODUCT NAME", "QUANTITY", "AMOUNT(₱)" }
) {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false; 
    }
};

jTable_hmpgMaintable.setModel(model);


// ==================== STYLING FOR jTable_hmpgMaintable ====================


javax.swing.table.DefaultTableCellRenderer darkHeaderRenderer = new javax.swing.table.DefaultTableCellRenderer() {
    @Override
    public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        javax.swing.JLabel lbl = (javax.swing.JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        lbl.setBackground(new java.awt.Color(25, 25, 25)); // Dark background
        lbl.setForeground(java.awt.Color.WHITE);           // White text
        lbl.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        lbl.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 140, 0))); // Orange bottom line
        lbl.setHorizontalAlignment(javax.swing.JLabel.CENTER); // Gitna ang Header Text
        return lbl;
    }
};


javax.swing.table.DefaultTableCellRenderer centerCellRenderer = new javax.swing.table.DefaultTableCellRenderer();
centerCellRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER); // Gitna ang Data Cells



jTable_hmpgMaintable.setBackground(new java.awt.Color(40, 40, 40));
jTable_hmpgMaintable.setForeground(java.awt.Color.WHITE);
jTable_hmpgMaintable.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
jTable_hmpgMaintable.setRowHeight(28);
jTable_hmpgMaintable.setShowGrid(false);
jTable_hmpgMaintable.setSelectionBackground(new java.awt.Color(255, 140, 0)); // Orange highlight
jTable_hmpgMaintable.setSelectionForeground(java.awt.Color.BLACK);


jTable_hmpgMaintable.getTableHeader().setOpaque(false);
jTable_hmpgMaintable.getTableHeader().setDefaultRenderer(darkHeaderRenderer);


for (int i = 0; i < jTable_hmpgMaintable.getColumnCount(); i++) {
    jTable_hmpgMaintable.getColumnModel().getColumn(i).setCellRenderer(centerCellRenderer);
}

jScrollPane2.getViewport().setBackground(new java.awt.Color(40, 40, 40));
jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 140, 0), 1));
    
    }



    
    
    
    
    
double priceTshirt = 100.0;
double priceShorts = 100.0;
double priceShoes = 100.0;
double priceSandals = 100.0;
    
    
    
    
    
     private String lastProductName = "";
     private double lastProductPrice = 0.0;
    

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
        jbtn_hmpg8 = new javax.swing.JButton();
        jbtn_hmpg9 = new javax.swing.JButton();
        jbtn_hmpg5 = new javax.swing.JButton();
        jbtn_hmpg7 = new javax.swing.JButton();
        jbtn_hmpg6 = new javax.swing.JButton();
        jbtn_hmpg1 = new javax.swing.JButton();
        jbtn_hmpg2 = new javax.swing.JButton();
        jbtn_hmpg4 = new javax.swing.JButton();
        jbtn_hmpgClearentry = new javax.swing.JButton();
        jbtn_hmpg0 = new javax.swing.JButton();
        jbtn_hmpgDelete = new javax.swing.JButton();
        jbtn_hmpg3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jtxthmpg_Change = new javax.swing.JTextField();
        jtxthmpg_Subtotal = new javax.swing.JTextField();
        jtxthmpg_Cash = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jtxthmpg_Discount = new javax.swing.JTextField();
        jtxthmpg_Total = new javax.swing.JTextField();
        jScrollPane_hmpg1 = new javax.swing.JScrollPane();
        jPanel_hmpg_1 = new javax.swing.JPanel();
        jbtnhmpg_adult_cloth2 = new javax.swing.JButton();
        jbtnhmpg_adult_cloth3 = new javax.swing.JButton();
        jbtnhmpg_adult_cloth4 = new javax.swing.JButton();
        jbtnhmpg_adult_cloth1 = new javax.swing.JButton();
        lbl_hmpg_adult_cloth2 = new javax.swing.JLabel();
        lbl_hmpg_adult_cloth3 = new javax.swing.JLabel();
        lbl_hmpg_adult_cloth1 = new javax.swing.JLabel();
        lbl_hmpg_adult_clothprice1 = new javax.swing.JLabel();
        jbtnhmpg_children_cloth1 = new javax.swing.JButton();
        lbl_hmpg_adult_clothprice3 = new javax.swing.JLabel();
        lbl_hmpg_adult_clothprice4 = new javax.swing.JLabel();
        lbl_hmpg_adult_clothprice2 = new javax.swing.JLabel();
        jbtnhmpg_adult_cloth9 = new javax.swing.JButton();
        jbtnhmpg_adult_cloth5 = new javax.swing.JButton();
        jbtnhmpg_adult_cloth7 = new javax.swing.JButton();
        jbtnhmpg_adult_cloth8 = new javax.swing.JButton();
        lbl_hmpg_adult_clothprice6 = new javax.swing.JLabel();
        lbl_hmpg_adult_clothprice5 = new javax.swing.JLabel();
        lbl_hmpg_adult_cloth5 = new javax.swing.JLabel();
        lbl_hmpg_adult_cloth8 = new javax.swing.JLabel();
        lbl_hmpg_adult_cloth6 = new javax.swing.JLabel();
        lbl_hmpg_adult_clothprice8 = new javax.swing.JLabel();
        lbl_hmpg_adult_cloth7 = new javax.swing.JLabel();
        lbl_hmpg_adult_clothprice7 = new javax.swing.JLabel();
        lbl_hmpg_children_cloth1 = new javax.swing.JLabel();
        lbl_hmpg_children_clothprice1 = new javax.swing.JLabel();
        jbtnhmpg_children_cloth2 = new javax.swing.JButton();
        lbl_hmpg_children_cloth2 = new javax.swing.JLabel();
        lbl_hmpg_children_clothprice2 = new javax.swing.JLabel();
        jbtnhmpg_children_cloth3 = new javax.swing.JButton();
        lbl_hmpg_children_cloth3 = new javax.swing.JLabel();
        lbl_hmpg_children_clothprice3 = new javax.swing.JLabel();
        jbtnhmpg_children_cloth4 = new javax.swing.JButton();
        lbl_hmpg_children_cloth4 = new javax.swing.JLabel();
        lbl_hmpg_children_clothprice4 = new javax.swing.JLabel();
        jbtnhmpg_children_cloth5 = new javax.swing.JButton();
        lbl_hmpg_children_cloth5 = new javax.swing.JLabel();
        lbl_hmpg_children_clothprice5 = new javax.swing.JLabel();
        jbtnhmpg_children_cloth6 = new javax.swing.JButton();
        lbl_hmpg_children_cloth6 = new javax.swing.JLabel();
        lbl_hmpg_children_clothprice6 = new javax.swing.JLabel();
        jbtnhmpg_children_cloth7 = new javax.swing.JButton();
        lbl_hmpg_children_cloth7 = new javax.swing.JLabel();
        lbl_hmpg_children_clothprice7 = new javax.swing.JLabel();
        jbtnhmpg_children_cloth8 = new javax.swing.JButton();
        lbl_hmpg_children_cloth8 = new javax.swing.JLabel();
        jbtnhmpg_adult_shoe1 = new javax.swing.JButton();
        lbl_hmpg_adult_shoe1 = new javax.swing.JLabel();
        lbl_hmpg_adult_shoeprice1 = new javax.swing.JLabel();
        jbtnhmpg_adult_shoe2 = new javax.swing.JButton();
        lbl_hmpg_adult_shoe2 = new javax.swing.JLabel();
        lbl_hmpg_adult_shoeprice2 = new javax.swing.JLabel();
        jbtnhmpg_adult_shoe3 = new javax.swing.JButton();
        lbl_hmpg_adult_shoe3 = new javax.swing.JLabel();
        lbl_hmpg_adult_shoeprice3 = new javax.swing.JLabel();
        jbtnhmpg_adult_shoe4 = new javax.swing.JButton();
        lbl_hmpg_adult_shoe4 = new javax.swing.JLabel();
        lbl_hmpg_adult_shoeprice4 = new javax.swing.JLabel();
        jbtnhmpg_adult_shoe5 = new javax.swing.JButton();
        lbl_hmpg_adult_shoe5 = new javax.swing.JLabel();
        lbl_hmpg_adult_shoeprice5 = new javax.swing.JLabel();
        jbtnhmpg_adult_shoe6 = new javax.swing.JButton();
        lbl_hmpg_adult_shoe6 = new javax.swing.JLabel();
        lbl_hmpg_adult_shoeprice6 = new javax.swing.JLabel();
        jbtnhmpg_adult_shoe7 = new javax.swing.JButton();
        lbl_hmpg_adult_shoe7 = new javax.swing.JLabel();
        lbl_hmpg_adult_shoeprice7 = new javax.swing.JLabel();
        jbtnhmpg_adult_shoe8 = new javax.swing.JButton();
        lbl_hmpg_adult_shoe8 = new javax.swing.JLabel();
        lbl_hmpg_adult_shoeprice8 = new javax.swing.JLabel();
        jbtnhmpg_children_shoe1 = new javax.swing.JButton();
        lbl_hmpg_children_shoe1 = new javax.swing.JLabel();
        lbl_hmpg_children_shoeprice1 = new javax.swing.JLabel();
        jbtnhmpg_children_shoe2 = new javax.swing.JButton();
        lbl_hmpg_children_shoe2 = new javax.swing.JLabel();
        lbl_hmpg_children_shoeprice2 = new javax.swing.JLabel();
        jbtnhmpg_children_shoe3 = new javax.swing.JButton();
        lbl_hmpg_children_shoe3 = new javax.swing.JLabel();
        lbl_hmpg_children_shoeprice3 = new javax.swing.JLabel();
        jbtnhmpg_children_shoe4 = new javax.swing.JButton();
        lbl_hmpg_children_shoe4 = new javax.swing.JLabel();
        lbl_hmpg_children_shoeprice4 = new javax.swing.JLabel();
        jbtnhmpg_children_shoe5 = new javax.swing.JButton();
        lbl_hmpg_children_shoe5 = new javax.swing.JLabel();
        lbl_hmpg_children_shoeprice5 = new javax.swing.JLabel();
        jbtnhmpg_children_shoe6 = new javax.swing.JButton();
        lbl_hmpg_children_shoe6 = new javax.swing.JLabel();
        lbl_hmpg_children_shoeprice6 = new javax.swing.JLabel();
        jbtnhmpg_children_shoe7 = new javax.swing.JButton();
        lbl_hmpg_children_shoe7 = new javax.swing.JLabel();
        lbl_hmpg_children_shoeprice7 = new javax.swing.JLabel();
        jbtnhmpg_children_shoe8 = new javax.swing.JButton();
        lbl_hmpg_children_shoe8 = new javax.swing.JLabel();
        lbl_hmpg_children_shoeprice8 = new javax.swing.JLabel();
        lbl_hmpg_adult_cloth4 = new javax.swing.JLabel();
        lbl_hmpg_children_clothprice8 = new javax.swing.JLabel();
        jComboBox_hmpg1 = new javax.swing.JComboBox<>();
        jSpinner_hmpg1 = new javax.swing.JSpinner();
        jLabel53 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jbtnhmpg_deletequantity = new javax.swing.JButton();
        jbtnhmpg_addquantity1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jbtn_hmpgReset = new javax.swing.JButton();
        jbtn_hmpgPay = new javax.swing.JButton();
        jbtn_hmpgPrintReceipt = new javax.swing.JButton();
        jbtn_hmpgRemove = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_hmpgMaintable = new javax.swing.JTable();
        jbtn_hmpgLogout = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(30, 32, 40));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(30, 32, 40));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 5, true));

        jbtn_hmpg8.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_hmpg8.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jbtn_hmpg8.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_hmpg8.setText("8");
        jbtn_hmpg8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_hmpg8ActionPerformed(evt);
            }
        });

        jbtn_hmpg9.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_hmpg9.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jbtn_hmpg9.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_hmpg9.setText("9");
        jbtn_hmpg9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_hmpg9ActionPerformed(evt);
            }
        });

        jbtn_hmpg5.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_hmpg5.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jbtn_hmpg5.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_hmpg5.setText("5");
        jbtn_hmpg5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_hmpg5ActionPerformed(evt);
            }
        });

        jbtn_hmpg7.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_hmpg7.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 0, 36)); // NOI18N
        jbtn_hmpg7.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_hmpg7.setText("7");
        jbtn_hmpg7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_hmpg7ActionPerformed(evt);
            }
        });

        jbtn_hmpg6.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_hmpg6.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jbtn_hmpg6.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_hmpg6.setText("6");
        jbtn_hmpg6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_hmpg6ActionPerformed(evt);
            }
        });

        jbtn_hmpg1.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_hmpg1.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jbtn_hmpg1.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_hmpg1.setText("1");
        jbtn_hmpg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_hmpg1ActionPerformed(evt);
            }
        });

        jbtn_hmpg2.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_hmpg2.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jbtn_hmpg2.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_hmpg2.setText("2");
        jbtn_hmpg2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_hmpg2ActionPerformed(evt);
            }
        });

        jbtn_hmpg4.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_hmpg4.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jbtn_hmpg4.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_hmpg4.setText("4");
        jbtn_hmpg4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_hmpg4ActionPerformed(evt);
            }
        });

        jbtn_hmpgClearentry.setBackground(new java.awt.Color(255, 255, 0));
        jbtn_hmpgClearentry.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jbtn_hmpgClearentry.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_hmpgClearentry.setText("CE");
        jbtn_hmpgClearentry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_hmpgClearentryActionPerformed(evt);
            }
        });

        jbtn_hmpg0.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_hmpg0.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jbtn_hmpg0.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_hmpg0.setText("0");
        jbtn_hmpg0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_hmpg0ActionPerformed(evt);
            }
        });

        jbtn_hmpgDelete.setBackground(new java.awt.Color(204, 0, 0));
        jbtn_hmpgDelete.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jbtn_hmpgDelete.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_hmpgDelete.setText("DEL");
        jbtn_hmpgDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_hmpgDeleteActionPerformed(evt);
            }
        });

        jbtn_hmpg3.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_hmpg3.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        jbtn_hmpg3.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_hmpg3.setText("3");
        jbtn_hmpg3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_hmpg3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtn_hmpg4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_hmpg7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_hmpgClearentry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_hmpg1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jbtn_hmpg8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtn_hmpg9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jbtn_hmpg5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtn_hmpg6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jbtn_hmpg0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtn_hmpgDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jbtn_hmpg2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtn_hmpg3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_hmpg9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_hmpg7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_hmpg8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_hmpg5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_hmpg6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_hmpg4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_hmpg1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_hmpg2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_hmpg3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_hmpgClearentry, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_hmpg0, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_hmpgDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(30, 32, 40));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 5, true));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(30, 32, 40));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel82.setBackground(new java.awt.Color(255, 255, 255));
        jLabel82.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setText("SUB TOTAL:");
        jPanel2.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel83.setBackground(new java.awt.Color(255, 255, 255));
        jLabel83.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setText("DISCOUNT:");
        jPanel2.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel84.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setText("AMOUNT RECEIVE:");
        jPanel2.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        jLabel85.setBackground(new java.awt.Color(255, 255, 255));
        jLabel85.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setText("CHANGE:");
        jPanel2.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, 30));

        jtxthmpg_Change.setEditable(false);
        jtxthmpg_Change.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jPanel2.add(jtxthmpg_Change, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 280, 34));

        jtxthmpg_Subtotal.setEditable(false);
        jtxthmpg_Subtotal.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jPanel2.add(jtxthmpg_Subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 280, 34));

        jtxthmpg_Cash.setEditable(false);
        jtxthmpg_Cash.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jtxthmpg_Cash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxthmpg_CashActionPerformed(evt);
            }
        });
        jtxthmpg_Cash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxthmpg_CashKeyTyped(evt);
            }
        });
        jPanel2.add(jtxthmpg_Cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 280, 34));

        jLabel87.setBackground(new java.awt.Color(255, 255, 255));
        jLabel87.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 102, 0));
        jLabel87.setText(" TOTAL:");
        jPanel2.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 100, 30));

        jtxthmpg_Discount.setEditable(false);
        jtxthmpg_Discount.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jPanel2.add(jtxthmpg_Discount, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 280, 34));

        jtxthmpg_Total.setEditable(false);
        jtxthmpg_Total.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jPanel2.add(jtxthmpg_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 280, 34));

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 710, 260));

        jScrollPane_hmpg1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel_hmpg_1.setBackground(new java.awt.Color(30, 32, 40));

        jbtnhmpg_adult_cloth2.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_adult_cloth2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\ADULT CLOTHES\\ADULT_CLOTH2.png")); // NOI18N
        jbtnhmpg_adult_cloth2.setName("Khaki Crew"); // NOI18N
        jbtnhmpg_adult_cloth2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_adult_cloth2ActionPerformed(evt);
            }
        });

        jbtnhmpg_adult_cloth3.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_adult_cloth3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\ADULT CLOTHES\\ADULT_CLOTH3.png")); // NOI18N
        jbtnhmpg_adult_cloth3.setName("Peregrine"); // NOI18N
        jbtnhmpg_adult_cloth3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_adult_cloth3ActionPerformed(evt);
            }
        });

        jbtnhmpg_adult_cloth4.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_adult_cloth4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\ADULT CLOTHES\\ADULT_CLOTH4.png")); // NOI18N
        jbtnhmpg_adult_cloth4.setName("Ivory Sleeve"); // NOI18N
        jbtnhmpg_adult_cloth4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_adult_cloth4ActionPerformed(evt);
            }
        });

        jbtnhmpg_adult_cloth1.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_adult_cloth1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\ADULT CLOTHES\\ADULT_CLOTH1.png")); // NOI18N
        jbtnhmpg_adult_cloth1.setName("Gilda Shirt"); // NOI18N
        jbtnhmpg_adult_cloth1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_adult_cloth1ActionPerformed(evt);
            }
        });

        lbl_hmpg_adult_cloth2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_cloth2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_adult_cloth2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_cloth2.setText(" Khaki Crew");

        lbl_hmpg_adult_cloth3.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_cloth3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_adult_cloth3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_cloth3.setText(" Peregrine ");

        lbl_hmpg_adult_cloth1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_cloth1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_adult_cloth1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_cloth1.setText("Gilda Shirt ");

        lbl_hmpg_adult_clothprice1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_clothprice1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_adult_clothprice1.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_adult_clothprice1.setText("100 PHP");

        jbtnhmpg_children_cloth1.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_children_cloth1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\CHILDREN CLOTHES\\CHILDREN_CLOTH1.png")); // NOI18N
        jbtnhmpg_children_cloth1.setName("Sleeve Toddler"); // NOI18N
        jbtnhmpg_children_cloth1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_children_cloth1ActionPerformed(evt);
            }
        });

        lbl_hmpg_adult_clothprice3.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_clothprice3.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_adult_clothprice3.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_adult_clothprice3.setText("100 PHP");

        lbl_hmpg_adult_clothprice4.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_clothprice4.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_adult_clothprice4.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_adult_clothprice4.setText("100 PHP");

        lbl_hmpg_adult_clothprice2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_clothprice2.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_adult_clothprice2.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_adult_clothprice2.setText("100 PHP");

        jbtnhmpg_adult_cloth9.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_adult_cloth9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\ADULT CLOTHES\\ADULT_CLOTH8.png")); // NOI18N
        jbtnhmpg_adult_cloth9.setName("Salomon Sleeve"); // NOI18N
        jbtnhmpg_adult_cloth9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_adult_cloth9ActionPerformed(evt);
            }
        });

        jbtnhmpg_adult_cloth5.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_adult_cloth5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\ADULT CLOTHES\\ADULT_CLOTH5.png")); // NOI18N
        jbtnhmpg_adult_cloth5.setName("Rugby Sleeve"); // NOI18N
        jbtnhmpg_adult_cloth5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_adult_cloth5ActionPerformed(evt);
            }
        });

        jbtnhmpg_adult_cloth7.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_adult_cloth7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\ADULT CLOTHES\\ADULT_CLOTH6.png")); // NOI18N
        jbtnhmpg_adult_cloth7.setName("Oakley Brown"); // NOI18N
        jbtnhmpg_adult_cloth7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_adult_cloth7ActionPerformed(evt);
            }
        });

        jbtnhmpg_adult_cloth8.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_adult_cloth8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\ADULT CLOTHES\\ADULT_CLOTH7.png")); // NOI18N
        jbtnhmpg_adult_cloth8.setName("Adidas Hoodie"); // NOI18N
        jbtnhmpg_adult_cloth8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_adult_cloth8ActionPerformed(evt);
            }
        });

        lbl_hmpg_adult_clothprice6.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_clothprice6.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_adult_clothprice6.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_adult_clothprice6.setText("100 PHP");

        lbl_hmpg_adult_clothprice5.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_clothprice5.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_adult_clothprice5.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_adult_clothprice5.setText("100 PHP");

        lbl_hmpg_adult_cloth5.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_cloth5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_adult_cloth5.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_cloth5.setText("Rugby Sleeve");

        lbl_hmpg_adult_cloth8.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_cloth8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_adult_cloth8.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_cloth8.setText("Salomon Sleeve");

        lbl_hmpg_adult_cloth6.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_cloth6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_adult_cloth6.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_cloth6.setText("Oakley Brown ");

        lbl_hmpg_adult_clothprice8.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_clothprice8.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_adult_clothprice8.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_adult_clothprice8.setText("100 PHP");

        lbl_hmpg_adult_cloth7.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_cloth7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_adult_cloth7.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_cloth7.setText(" Adidas Hoodie");

        lbl_hmpg_adult_clothprice7.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_clothprice7.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_adult_clothprice7.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_adult_clothprice7.setText("100 PHP");

        lbl_hmpg_children_cloth1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_cloth1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_children_cloth1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_cloth1.setText("Sleeve Toddler");

        lbl_hmpg_children_clothprice1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_clothprice1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_children_clothprice1.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_children_clothprice1.setText("100 PHP");

        jbtnhmpg_children_cloth2.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_children_cloth2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\CHILDREN CLOTHES\\CHILDREN_CLOTH2.png")); // NOI18N
        jbtnhmpg_children_cloth2.setName("Baby Blouse"); // NOI18N
        jbtnhmpg_children_cloth2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_children_cloth2ActionPerformed(evt);
            }
        });

        lbl_hmpg_children_cloth2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_cloth2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_children_cloth2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_cloth2.setText("Baby Blouse");

        lbl_hmpg_children_clothprice2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_clothprice2.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_children_clothprice2.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_children_clothprice2.setText("100 PHP");

        jbtnhmpg_children_cloth3.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_children_cloth3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\CHILDREN CLOTHES\\CHILDREN_CLOTH3.png")); // NOI18N
        jbtnhmpg_children_cloth3.setName("Peter Pan"); // NOI18N
        jbtnhmpg_children_cloth3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_children_cloth3ActionPerformed(evt);
            }
        });

        lbl_hmpg_children_cloth3.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_cloth3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_children_cloth3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_cloth3.setText("Peter Pan");

        lbl_hmpg_children_clothprice3.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_clothprice3.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_children_clothprice3.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_children_clothprice3.setText("100 PHP");

        jbtnhmpg_children_cloth4.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_children_cloth4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\CHILDREN CLOTHES\\CHILDREN_CLOTH4.png")); // NOI18N
        jbtnhmpg_children_cloth4.setName("Pink Button"); // NOI18N
        jbtnhmpg_children_cloth4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_children_cloth4ActionPerformed(evt);
            }
        });

        lbl_hmpg_children_cloth4.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_cloth4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_children_cloth4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_cloth4.setText("Pink Button");

        lbl_hmpg_children_clothprice4.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_clothprice4.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_children_clothprice4.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_children_clothprice4.setText("100 PHP");

        jbtnhmpg_children_cloth5.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_children_cloth5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\CHILDREN CLOTHES\\CHILDREN_CLOTH5.png")); // NOI18N
        jbtnhmpg_children_cloth5.setName("Baby Flounce"); // NOI18N
        jbtnhmpg_children_cloth5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_children_cloth5ActionPerformed(evt);
            }
        });

        lbl_hmpg_children_cloth5.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_cloth5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_children_cloth5.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_cloth5.setText("Baby Flounce");

        lbl_hmpg_children_clothprice5.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_clothprice5.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_children_clothprice5.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_children_clothprice5.setText("100 PHP");

        jbtnhmpg_children_cloth6.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_children_cloth6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\CHILDREN CLOTHES\\CHILDREN_CLOTH6.png")); // NOI18N
        jbtnhmpg_children_cloth6.setName("Navy Collar"); // NOI18N
        jbtnhmpg_children_cloth6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_children_cloth6ActionPerformed(evt);
            }
        });

        lbl_hmpg_children_cloth6.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_cloth6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_children_cloth6.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_cloth6.setText("Navy Collar");

        lbl_hmpg_children_clothprice6.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_clothprice6.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_children_clothprice6.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_children_clothprice6.setText("100 PHP");

        jbtnhmpg_children_cloth7.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_children_cloth7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\CHILDREN CLOTHES\\CHILDREN_CLOTH7.png")); // NOI18N
        jbtnhmpg_children_cloth7.setName("Cyrillus Dress"); // NOI18N
        jbtnhmpg_children_cloth7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_children_cloth7ActionPerformed(evt);
            }
        });

        lbl_hmpg_children_cloth7.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_cloth7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_children_cloth7.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_cloth7.setText(" Cyrillus Dress");

        lbl_hmpg_children_clothprice7.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_clothprice7.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_children_clothprice7.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_children_clothprice7.setText("100 PHP");

        jbtnhmpg_children_cloth8.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_children_cloth8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\CHILDREN CLOTHES\\CHILDREN_CLOTH8.png")); // NOI18N
        jbtnhmpg_children_cloth8.setName("Burgundy"); // NOI18N
        jbtnhmpg_children_cloth8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_children_cloth8ActionPerformed(evt);
            }
        });

        lbl_hmpg_children_cloth8.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_cloth8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_children_cloth8.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_cloth8.setText("Burgundy");

        jbtnhmpg_adult_shoe1.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_adult_shoe1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\ADULT SHOES\\ADULT_SHOE1.png")); // NOI18N
        jbtnhmpg_adult_shoe1.setName("Nike Air Force"); // NOI18N
        jbtnhmpg_adult_shoe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_adult_shoe1ActionPerformed(evt);
            }
        });

        lbl_hmpg_adult_shoe1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoe1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_adult_shoe1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoe1.setText("Nike Air Force ");

        lbl_hmpg_adult_shoeprice1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoeprice1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_adult_shoeprice1.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_adult_shoeprice1.setText("100 PHP");

        jbtnhmpg_adult_shoe2.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_adult_shoe2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\ADULT SHOES\\ADULT_SHOE2.png")); // NOI18N
        jbtnhmpg_adult_shoe2.setName("Peak Parker"); // NOI18N
        jbtnhmpg_adult_shoe2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_adult_shoe2ActionPerformed(evt);
            }
        });

        lbl_hmpg_adult_shoe2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoe2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_adult_shoe2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoe2.setText(" Peak Parker");

        lbl_hmpg_adult_shoeprice2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoeprice2.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_adult_shoeprice2.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_adult_shoeprice2.setText("100 PHP");

        jbtnhmpg_adult_shoe3.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_adult_shoe3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\ADULT SHOES\\ADULT_SHOE3.png")); // NOI18N
        jbtnhmpg_adult_shoe3.setName("Air Wolf Pro"); // NOI18N
        jbtnhmpg_adult_shoe3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_adult_shoe3ActionPerformed(evt);
            }
        });

        lbl_hmpg_adult_shoe3.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoe3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_adult_shoe3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoe3.setText("Air Wolf Pro");
        lbl_hmpg_adult_shoe3.setName("Air Wolf Pro"); // NOI18N

        lbl_hmpg_adult_shoeprice3.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoeprice3.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_adult_shoeprice3.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_adult_shoeprice3.setText("100 PHP");

        jbtnhmpg_adult_shoe4.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_adult_shoe4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\ADULT SHOES\\ADULT_SHOE4.png")); // NOI18N
        jbtnhmpg_adult_shoe4.setName("Adidas Dame"); // NOI18N
        jbtnhmpg_adult_shoe4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_adult_shoe4ActionPerformed(evt);
            }
        });

        lbl_hmpg_adult_shoe4.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoe4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_adult_shoe4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoe4.setText("Adidas Dame");

        lbl_hmpg_adult_shoeprice4.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoeprice4.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_adult_shoeprice4.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_adult_shoeprice4.setText("100 PHP");

        jbtnhmpg_adult_shoe5.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_adult_shoe5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\ADULT SHOES\\ADULT_SHOE5.png")); // NOI18N
        jbtnhmpg_adult_shoe5.setName("Under Armour"); // NOI18N
        jbtnhmpg_adult_shoe5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_adult_shoe5ActionPerformed(evt);
            }
        });

        lbl_hmpg_adult_shoe5.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoe5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_adult_shoe5.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoe5.setText("Under Armour");

        lbl_hmpg_adult_shoeprice5.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoeprice5.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_adult_shoeprice5.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_adult_shoeprice5.setText("100 PHP");

        jbtnhmpg_adult_shoe6.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_adult_shoe6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\ADULT SHOES\\ADULT_SHOE6.png")); // NOI18N
        jbtnhmpg_adult_shoe6.setName("Nike Hype"); // NOI18N
        jbtnhmpg_adult_shoe6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_adult_shoe6ActionPerformed(evt);
            }
        });

        lbl_hmpg_adult_shoe6.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoe6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_adult_shoe6.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoe6.setText("Nike Hype");

        lbl_hmpg_adult_shoeprice6.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoeprice6.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_adult_shoeprice6.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_adult_shoeprice6.setText("100 PHP");

        jbtnhmpg_adult_shoe7.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_adult_shoe7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\ADULT SHOES\\ADULT_SHOE7.png")); // NOI18N
        jbtnhmpg_adult_shoe7.setName("Air Jordan"); // NOI18N
        jbtnhmpg_adult_shoe7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_adult_shoe7ActionPerformed(evt);
            }
        });

        lbl_hmpg_adult_shoe7.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoe7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_adult_shoe7.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoe7.setText(" Air Jordan");

        lbl_hmpg_adult_shoeprice7.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoeprice7.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_adult_shoeprice7.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_adult_shoeprice7.setText("100 PHP");

        jbtnhmpg_adult_shoe8.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_adult_shoe8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\ADULT SHOES\\ADULT_SHOE8.png")); // NOI18N
        jbtnhmpg_adult_shoe8.setName("Adidas Star"); // NOI18N
        jbtnhmpg_adult_shoe8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_adult_shoe8ActionPerformed(evt);
            }
        });

        lbl_hmpg_adult_shoe8.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoe8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_adult_shoe8.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoe8.setText("Adidas Star");

        lbl_hmpg_adult_shoeprice8.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_shoeprice8.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_adult_shoeprice8.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_adult_shoeprice8.setText("100 PHP");

        jbtnhmpg_children_shoe1.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_children_shoe1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\CHILDREN SHOES\\CHILDREN_SHOE1.png")); // NOI18N
        jbtnhmpg_children_shoe1.setName("Nike Max"); // NOI18N
        jbtnhmpg_children_shoe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_children_shoe1ActionPerformed(evt);
            }
        });

        lbl_hmpg_children_shoe1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoe1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_children_shoe1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoe1.setText("Nike Max");

        lbl_hmpg_children_shoeprice1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoeprice1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_children_shoeprice1.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_children_shoeprice1.setText("100 PHP");

        jbtnhmpg_children_shoe2.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_children_shoe2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\CHILDREN SHOES\\CHILDREN_SHOE2.png")); // NOI18N
        jbtnhmpg_children_shoe2.setName("Air Tailwind"); // NOI18N
        jbtnhmpg_children_shoe2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_children_shoe2ActionPerformed(evt);
            }
        });

        lbl_hmpg_children_shoe2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoe2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_children_shoe2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoe2.setText("Air Tailwind");

        lbl_hmpg_children_shoeprice2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoeprice2.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_children_shoeprice2.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_children_shoeprice2.setText("100 PHP");

        jbtnhmpg_children_shoe3.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_children_shoe3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\CHILDREN SHOES\\CHILDREN_SHOE3.png")); // NOI18N
        jbtnhmpg_children_shoe3.setName("Toddler Nike"); // NOI18N
        jbtnhmpg_children_shoe3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_children_shoe3ActionPerformed(evt);
            }
        });

        lbl_hmpg_children_shoe3.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoe3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_children_shoe3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoe3.setText("Toddler Nike");

        lbl_hmpg_children_shoeprice3.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoeprice3.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_children_shoeprice3.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_children_shoeprice3.setText("100 PHP");

        jbtnhmpg_children_shoe4.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_children_shoe4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\CHILDREN SHOES\\CHILDREN_SHOE4.png")); // NOI18N
        jbtnhmpg_children_shoe4.setName("Kid Sneakers"); // NOI18N
        jbtnhmpg_children_shoe4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_children_shoe4ActionPerformed(evt);
            }
        });

        lbl_hmpg_children_shoe4.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoe4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_children_shoe4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoe4.setText("Kid Sneakers");

        lbl_hmpg_children_shoeprice4.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoeprice4.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_children_shoeprice4.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_children_shoeprice4.setText("100 PHP");

        jbtnhmpg_children_shoe5.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_children_shoe5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\CHILDREN SHOES\\CHILDREN_SHOE5.png")); // NOI18N
        jbtnhmpg_children_shoe5.setName("Air Max"); // NOI18N
        jbtnhmpg_children_shoe5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_children_shoe5ActionPerformed(evt);
            }
        });

        lbl_hmpg_children_shoe5.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoe5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_children_shoe5.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoe5.setText("Air Max");

        lbl_hmpg_children_shoeprice5.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoeprice5.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_children_shoeprice5.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_children_shoeprice5.setText("100 PHP");

        jbtnhmpg_children_shoe6.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_children_shoe6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\CHILDREN SHOES\\CHILDREN_SHOE6.png")); // NOI18N
        jbtnhmpg_children_shoe6.setName("Baby Tiny Nike"); // NOI18N
        jbtnhmpg_children_shoe6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_children_shoe6ActionPerformed(evt);
            }
        });

        lbl_hmpg_children_shoe6.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoe6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_children_shoe6.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoe6.setText("Baby Tiny Nike");

        lbl_hmpg_children_shoeprice6.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoeprice6.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_children_shoeprice6.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_children_shoeprice6.setText("100 PHP");

        jbtnhmpg_children_shoe7.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_children_shoe7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\CHILDREN SHOES\\CHILDREN_SHOE7.png")); // NOI18N
        jbtnhmpg_children_shoe7.setName("PUMA Heart"); // NOI18N
        jbtnhmpg_children_shoe7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_children_shoe7ActionPerformed(evt);
            }
        });

        lbl_hmpg_children_shoe7.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoe7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_children_shoe7.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoe7.setText("PUMA Heart");

        lbl_hmpg_children_shoeprice7.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoeprice7.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_children_shoeprice7.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_children_shoeprice7.setText("100 PHP");

        jbtnhmpg_children_shoe8.setBackground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_children_shoe8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\PRODUCT IMAGES\\CHILDREN SHOES\\CHILDREN_SHOE8.png")); // NOI18N
        jbtnhmpg_children_shoe8.setName("Air Max SC"); // NOI18N
        jbtnhmpg_children_shoe8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_children_shoe8ActionPerformed(evt);
            }
        });

        lbl_hmpg_children_shoe8.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoe8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_children_shoe8.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoe8.setText(" Air Max SC");

        lbl_hmpg_children_shoeprice8.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_shoeprice8.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_children_shoeprice8.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_children_shoeprice8.setText("100 PHP");

        lbl_hmpg_adult_cloth4.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_cloth4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_hmpg_adult_cloth4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_adult_cloth4.setText("Ivory Sleeve");

        lbl_hmpg_children_clothprice8.setBackground(new java.awt.Color(255, 255, 255));
        lbl_hmpg_children_clothprice8.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lbl_hmpg_children_clothprice8.setForeground(new java.awt.Color(204, 153, 0));
        lbl_hmpg_children_clothprice8.setText("100 PHP");

        javax.swing.GroupLayout jPanel_hmpg_1Layout = new javax.swing.GroupLayout(jPanel_hmpg_1);
        jPanel_hmpg_1.setLayout(jPanel_hmpg_1Layout);
        jPanel_hmpg_1Layout.setHorizontalGroup(
            jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_hmpg_1Layout.createSequentialGroup()
                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnhmpg_adult_shoe5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnhmpg_adult_shoe1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnhmpg_children_cloth5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_hmpg_adult_clothprice1)
                                    .addComponent(lbl_hmpg_adult_cloth1)))
                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(lbl_hmpg_adult_shoeprice5))
                                    .addComponent(lbl_hmpg_adult_shoe5)))
                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lbl_hmpg_adult_shoe1))
                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(lbl_hmpg_adult_shoeprice1))
                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(lbl_hmpg_children_clothprice5))
                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lbl_hmpg_children_cloth1))
                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(lbl_hmpg_children_clothprice1))
                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(lbl_hmpg_adult_clothprice5))
                                    .addComponent(lbl_hmpg_adult_cloth5))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbtnhmpg_adult_shoe2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtnhmpg_children_cloth6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbl_hmpg_adult_shoe6)
                                            .addComponent(lbl_hmpg_adult_shoeprice6)))
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(lbl_hmpg_adult_shoeprice2))
                                            .addComponent(lbl_hmpg_adult_shoe2)))
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(lbl_hmpg_adult_clothprice2))
                                            .addComponent(lbl_hmpg_adult_cloth2)))
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(lbl_hmpg_children_clothprice2))
                                            .addComponent(lbl_hmpg_children_cloth2))))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addComponent(lbl_hmpg_children_clothprice7))
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbl_hmpg_children_cloth3)
                                            .addComponent(lbl_hmpg_children_clothprice3))
                                        .addGap(95, 95, 95)
                                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(lbl_hmpg_children_clothprice4))
                                            .addComponent(lbl_hmpg_children_cloth4)))
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_hmpg_adult_cloth3)
                                            .addComponent(lbl_hmpg_adult_clothprice3))
                                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                .addGap(101, 101, 101)
                                                .addComponent(lbl_hmpg_adult_clothprice4))
                                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                .addGap(92, 92, 92)
                                                .addComponent(lbl_hmpg_adult_cloth4))))
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_hmpg_adult_shoe3)
                                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(lbl_hmpg_adult_shoeprice3)))
                                        .addGap(53, 53, 53)
                                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jbtnhmpg_children_cloth4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jbtnhmpg_children_cloth8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jbtnhmpg_adult_cloth9, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jbtnhmpg_adult_cloth4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jbtnhmpg_adult_shoe4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jbtnhmpg_adult_shoe8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jbtnhmpg_children_shoe4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jbtnhmpg_children_shoe8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                        .addGap(12, 12, 12)
                                                        .addComponent(lbl_hmpg_adult_clothprice8))
                                                    .addComponent(lbl_hmpg_adult_cloth8))))))
                                .addGap(103, 103, 103))
                            .addComponent(jbtnhmpg_adult_shoe6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_hmpg_children_shoe5)
                                    .addComponent(lbl_hmpg_children_shoeprice5))
                                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(lbl_hmpg_children_shoe6))
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addComponent(lbl_hmpg_children_shoeprice6)))
                                .addGap(76, 76, 76)
                                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_hmpg_children_shoe7)
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(lbl_hmpg_children_shoeprice7)))
                                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(lbl_hmpg_children_shoeprice8))
                                            .addComponent(lbl_hmpg_children_shoe8)))
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addComponent(lbl_hmpg_adult_shoeprice4))
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addComponent(lbl_hmpg_adult_shoe4))))
                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                            .addGap(27, 27, 27)
                                            .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lbl_hmpg_children_shoe1)
                                                .addComponent(lbl_hmpg_children_shoeprice1))
                                            .addGap(84, 84, 84)
                                            .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbl_hmpg_children_shoe2)
                                                .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                    .addGap(12, 12, 12)
                                                    .addComponent(lbl_hmpg_children_shoeprice2))))
                                        .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                            .addComponent(jbtnhmpg_children_shoe1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jbtnhmpg_children_shoe2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(lbl_hmpg_children_cloth5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(lbl_hmpg_children_clothprice6))
                                            .addComponent(lbl_hmpg_children_cloth6))
                                        .addGap(25, 25, 25)))
                                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_hmpg_children_shoe3)
                                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(lbl_hmpg_children_shoeprice3)))
                                        .addGap(81, 81, 81)
                                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_hmpg_children_shoe4)
                                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(lbl_hmpg_children_shoeprice4))))
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(lbl_hmpg_adult_cloth7))
                                            .addComponent(jbtnhmpg_adult_shoe7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jbtnhmpg_children_shoe3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jbtnhmpg_adult_shoe3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jbtnhmpg_children_cloth7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jbtnhmpg_children_cloth3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jbtnhmpg_adult_cloth8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jbtnhmpg_adult_cloth3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                        .addGap(12, 12, 12)
                                                        .addComponent(lbl_hmpg_adult_shoeprice7))
                                                    .addComponent(lbl_hmpg_adult_shoe7)))
                                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(lbl_hmpg_children_cloth7))
                                            .addComponent(jbtnhmpg_children_shoe7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                .addGap(72, 72, 72)
                                                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lbl_hmpg_children_clothprice8)
                                                    .addComponent(lbl_hmpg_children_cloth8)))
                                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                .addGap(68, 68, 68)
                                                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbl_hmpg_adult_shoeprice8)
                                                    .addComponent(lbl_hmpg_adult_shoe8)))))))
                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addComponent(jbtnhmpg_adult_cloth1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jbtnhmpg_adult_cloth2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addComponent(jbtnhmpg_children_cloth1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbtnhmpg_children_cloth2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addComponent(jbtnhmpg_adult_cloth5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jbtnhmpg_adult_cloth7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                                        .addGap(12, 12, 12)
                                                        .addComponent(lbl_hmpg_adult_clothprice6))
                                                    .addComponent(lbl_hmpg_adult_cloth6))))))
                                .addGap(68, 68, 68)
                                .addComponent(lbl_hmpg_adult_clothprice7))
                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                .addComponent(jbtnhmpg_children_shoe5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnhmpg_children_shoe6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel_hmpg_1Layout.setVerticalGroup(
            jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtnhmpg_adult_cloth2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnhmpg_adult_cloth3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnhmpg_adult_cloth4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnhmpg_adult_cloth1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_hmpg_adult_cloth3)
                    .addComponent(lbl_hmpg_adult_cloth2)
                    .addComponent(lbl_hmpg_adult_cloth1)
                    .addComponent(lbl_hmpg_adult_cloth4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_hmpg_adult_clothprice1)
                    .addComponent(lbl_hmpg_adult_clothprice2)
                    .addComponent(lbl_hmpg_adult_clothprice3)
                    .addComponent(lbl_hmpg_adult_clothprice4))
                .addGap(99, 99, 99)
                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnhmpg_adult_cloth7, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnhmpg_adult_cloth5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnhmpg_adult_cloth8, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnhmpg_adult_cloth9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lbl_hmpg_adult_cloth5))
                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_hmpg_adult_cloth6)
                            .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_hmpg_adult_cloth7)
                                .addComponent(lbl_hmpg_adult_cloth8)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_hmpg_adult_clothprice5)
                    .addComponent(lbl_hmpg_adult_clothprice6)
                    .addComponent(lbl_hmpg_adult_clothprice7)
                    .addComponent(lbl_hmpg_adult_clothprice8))
                .addGap(102, 102, 102)
                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnhmpg_children_cloth1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnhmpg_children_cloth2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnhmpg_children_cloth3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnhmpg_children_cloth4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lbl_hmpg_children_cloth1)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_hmpg_children_clothprice1)
                            .addComponent(lbl_hmpg_children_clothprice2)))
                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_hmpg_children_cloth3)
                                .addComponent(lbl_hmpg_children_cloth4))
                            .addComponent(lbl_hmpg_children_cloth2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_hmpg_children_clothprice3)
                            .addComponent(lbl_hmpg_children_clothprice4))))
                .addGap(135, 135, 135)
                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnhmpg_children_cloth5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnhmpg_children_cloth6, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnhmpg_children_cloth7, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnhmpg_children_cloth8, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lbl_hmpg_children_cloth7)
                                .addGap(3, 3, 3)
                                .addComponent(lbl_hmpg_children_clothprice7))
                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addComponent(lbl_hmpg_children_cloth5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_hmpg_children_clothprice5))
                                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                        .addComponent(lbl_hmpg_children_cloth6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_hmpg_children_clothprice6))))))
                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(lbl_hmpg_children_cloth8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_children_clothprice8)))
                .addGap(105, 105, 105)
                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnhmpg_adult_shoe1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnhmpg_adult_shoe2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnhmpg_adult_shoe3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnhmpg_adult_shoe4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                        .addComponent(lbl_hmpg_adult_shoe1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_adult_shoeprice1))
                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                        .addComponent(lbl_hmpg_adult_shoe2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_adult_shoeprice2))
                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                        .addComponent(lbl_hmpg_adult_shoe4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_adult_shoeprice4))
                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                        .addComponent(lbl_hmpg_adult_shoe3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_adult_shoeprice3)))
                .addGap(98, 98, 98)
                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                        .addComponent(jbtnhmpg_adult_shoe5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_hmpg_adult_shoe5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_adult_shoeprice5))
                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jbtnhmpg_adult_shoe6, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_hmpg_1Layout.createSequentialGroup()
                                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jbtnhmpg_adult_shoe8, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtnhmpg_adult_shoe7, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)))
                        .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                .addComponent(lbl_hmpg_adult_shoe6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_hmpg_adult_shoeprice6))
                            .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_hmpg_adult_shoe7)
                                    .addComponent(lbl_hmpg_adult_shoe8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_hmpg_adult_shoeprice7)
                                    .addComponent(lbl_hmpg_adult_shoeprice8))))))
                .addGap(81, 81, 81)
                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                        .addComponent(jbtnhmpg_children_shoe1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_children_shoe1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_children_shoeprice1))
                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                        .addComponent(jbtnhmpg_children_shoe2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_children_shoe2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_children_shoeprice2))
                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                        .addComponent(jbtnhmpg_children_shoe3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_children_shoe3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_children_shoeprice3))
                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                        .addComponent(jbtnhmpg_children_shoe4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_children_shoe4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_children_shoeprice4)))
                .addGap(97, 97, 97)
                .addGroup(jPanel_hmpg_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                        .addComponent(jbtnhmpg_children_shoe5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_children_shoe5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_children_shoeprice5))
                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                        .addComponent(jbtnhmpg_children_shoe6, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_children_shoe6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_children_shoeprice6))
                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                        .addComponent(jbtnhmpg_children_shoe7, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_children_shoe7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_children_shoeprice7))
                    .addGroup(jPanel_hmpg_1Layout.createSequentialGroup()
                        .addComponent(jbtnhmpg_children_shoe8, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_children_shoe8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_hmpg_children_shoeprice8)))
                .addContainerGap(201, Short.MAX_VALUE))
        );

        jScrollPane_hmpg1.setViewportView(jPanel_hmpg_1);

        jPanel5.add(jScrollPane_hmpg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 720, 350));

        jComboBox_hmpg1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBox_hmpg1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADULT CLOTHES", "CHILDREN CLOTHES", "ADULT SHOES", "CHILDREN SHOES", " " }));
        jComboBox_hmpg1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_hmpg1ItemStateChanged(evt);
            }
        });
        jComboBox_hmpg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_hmpg1ActionPerformed(evt);
            }
        });
        jPanel5.add(jComboBox_hmpg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 240, 50));

        jSpinner_hmpg1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jSpinner_hmpg1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 0));
        jSpinner_hmpg1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_hmpg1StateChanged(evt);
            }
        });
        jSpinner_hmpg1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jSpinner_hmpg1PropertyChange(evt);
            }
        });
        jPanel5.add(jSpinner_hmpg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 220, 50));

        jLabel53.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("PRODUCT CATEGORY:");
        jPanel5.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        jLabel55.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("PRODUCT QUANTITY:");
        jPanel5.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, -1, -1));

        jbtnhmpg_deletequantity.setBackground(new java.awt.Color(204, 0, 0));
        jbtnhmpg_deletequantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnhmpg_deletequantity.setForeground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_deletequantity.setText("DEL");
        jbtnhmpg_deletequantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_deletequantityActionPerformed(evt);
            }
        });
        jPanel5.add(jbtnhmpg_deletequantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, 90, 50));

        jbtnhmpg_addquantity1.setBackground(new java.awt.Color(51, 153, 0));
        jbtnhmpg_addquantity1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnhmpg_addquantity1.setForeground(new java.awt.Color(255, 255, 255));
        jbtnhmpg_addquantity1.setText("ADD");
        jbtnhmpg_addquantity1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnhmpg_addquantity1ActionPerformed(evt);
            }
        });
        jPanel5.add(jbtnhmpg_addquantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, 90, 50));

        jPanel7.setBackground(new java.awt.Color(30, 32, 40));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 5, true));

        jbtn_hmpgReset.setBackground(new java.awt.Color(102, 102, 102));
        jbtn_hmpgReset.setFont(new java.awt.Font("Segoe UI", 1, 49)); // NOI18N
        jbtn_hmpgReset.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_hmpgReset.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\MAIN TERMINALBUTTONS\\reseticon96px.png")); // NOI18N
        jbtn_hmpgReset.setText("RESET");
        jbtn_hmpgReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_hmpgResetActionPerformed(evt);
            }
        });

        jbtn_hmpgPay.setBackground(new java.awt.Color(51, 153, 0));
        jbtn_hmpgPay.setFont(new java.awt.Font("Segoe UI", 1, 55)); // NOI18N
        jbtn_hmpgPay.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_hmpgPay.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\MAIN TERMINALBUTTONS\\payicon96px.png")); // NOI18N
        jbtn_hmpgPay.setText("PAY");
        jbtn_hmpgPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_hmpgPayActionPerformed(evt);
            }
        });

        jbtn_hmpgPrintReceipt.setBackground(new java.awt.Color(0, 102, 204));
        jbtn_hmpgPrintReceipt.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jbtn_hmpgPrintReceipt.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_hmpgPrintReceipt.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\MAIN TERMINALBUTTONS\\printicon96px.png")); // NOI18N
        jbtn_hmpgPrintReceipt.setText("PRINT RECEIPT");
        jbtn_hmpgPrintReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_hmpgPrintReceiptActionPerformed(evt);
            }
        });

        jbtn_hmpgRemove.setBackground(new java.awt.Color(204, 0, 0));
        jbtn_hmpgRemove.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbtn_hmpgRemove.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_hmpgRemove.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\MAIN TERMINALBUTTONS\\removeicon96px.png")); // NOI18N
        jbtn_hmpgRemove.setText("REMOVE");
        jbtn_hmpgRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_hmpgRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtn_hmpgPay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_hmpgRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtn_hmpgReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_hmpgPrintReceipt, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtn_hmpgPay, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jbtn_hmpgReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtn_hmpgRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_hmpgPrintReceipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTable_hmpgMaintable.setBackground(new java.awt.Color(30, 32, 40));
        jTable_hmpgMaintable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 5, true));
        jTable_hmpgMaintable.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jTable_hmpgMaintable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCT NAME", "QUANTITY", "AMOUNT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_hmpgMaintable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable_hmpgMaintableMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_hmpgMaintable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1500, 730));

        jbtn_hmpgLogout.setBackground(new java.awt.Color(255, 0, 0));
        jbtn_hmpgLogout.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbtn_hmpgLogout.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_hmpgLogout.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\MAIN TERMINALBUTTONS\\icons8-logout-48.png")); // NOI18N
        jbtn_hmpgLogout.setText("LOGOUT");
        jbtn_hmpgLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_hmpgLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(jbtn_hmpgLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, 350, 90));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\GUI_bg_homepage1920x1080.jpg")); // NOI18N
        jLabel4.setText("\n");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel4.setMaximumSize(new java.awt.Dimension(1920, 1080));
        jLabel4.setMinimumSize(new java.awt.Dimension(1920, 1080));
        jLabel4.setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 520, -1, 1080));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\GUI_bg_homepage1920x1080.jpg")); // NOI18N
        jLabel5.setText(" ");
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

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\GUI_bg_homepage1920x1080.jpg")); // NOI18N
        jLabel6.setText("\n");
        jLabel6.setMaximumSize(new java.awt.Dimension(1920, 1080));
        jLabel6.setMinimumSize(new java.awt.Dimension(1920, 1080));
        jLabel6.setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, 1380, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public class ImageUtils {

    public static ImageIcon enhanceAndScale(ImageIcon sourceIcon, int targetWidth, int targetHeight) {
        if (sourceIcon == null) {
            return null;
        }

        if (targetWidth <= 0) targetWidth = sourceIcon.getIconWidth();
        if (targetHeight <= 0) targetHeight = sourceIcon.getIconHeight();

        // 1. High-quality Bicubic Resizing
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedImage.createGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawImage(sourceIcon.getImage(), 0, 0, targetWidth, targetHeight, null);
        g2d.dispose();

        // 2. Apply Sharpening Filter (Edge Clarity)
        float[] sharpenMatrix = {
             0.0f, -0.25f,  0.0f,
            -0.25f,  2.0f, -0.25f,
             0.0f, -0.25f,  0.0f
        };
        Kernel kernel = new Kernel(3, 3, sharpenMatrix);
        ConvolveOp sharpenOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        BufferedImage sharpenedImage = sharpenOp.filter(resizedImage, null);

        // 3. Contrast & Brightness Enhancement (1.05x contrast, +5 brightness offset)
        RescaleOp contrastOp = new RescaleOp(1.05f, 5.0f, null);
        BufferedImage finalEnhancedImage = contrastOp.filter(sharpenedImage, null);

        return new ImageIcon(finalEnhancedImage);
    }
    }

    
    
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {                                      
    loadTerminalPrices();
}
    
    
   

    
 
   
    
    
    
    
    
    private void loadProductsToGrid() {
    try {
        java.sql.Connection con = DBConnection2.connect();
        String sql = "SELECT product_name, price, discount FROM tbl_products";
        java.sql.PreparedStatement pst = con.prepareStatement(sql);
        java.sql.ResultSet rs = pst.executeQuery();

        // Dito mo ilalagay ang pag-load sa iyong mga product cards o display sa homepage
        // Halimbawa, kung binabasa nito ang database para ipakita ang mga produkto:
        while (rs.next()) {
            String name = rs.getString("product_name");
            double price = rs.getDouble("price");
            double discount = rs.getDouble("discount");
            
            // I-update dito ang mga UI components o labels para sa bawat produkto
        }

        rs.close();
        pst.close();
        con.close();
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error loading products: " + e.getMessage());
    }
}
    
    
    
    
    
    
    
    
   public void loadPricesFromDB() {
    String sql = "SELECT id, product_name, price, discount FROM tbl_products";

    try (Connection con = DBConnection2.connect();
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            int id = rs.getInt("id");
            double price = rs.getDouble("price");
            double discount = rs.getDouble("discount");

            // Dinhi, pwede nimo i-store sa global array o hashmap imbis nga if-else:
            // Pananglitan naa kay arrays: productPrices[id] = price; productDiscounts[id] = discount;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }



    }
    
    
    
    

 
    
   
    
    
    
    
    
   
    
    
    
    
    
    
    private void jbtn_hmpgLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_hmpgLogoutActionPerformed
        int choice = JOptionPane.showConfirmDialog(
        this,"Are you sure you want to Log Out?",
        "Confirmation",JOptionPane.YES_NO_OPTION,
        JOptionPane.WARNING_MESSAGE);

        if (choice == JOptionPane.YES_OPTION) {
        JOptionPane.showMessageDialog(this, "Log Out Successful!");
            new Pos_login().setVisible(true);
            this.dispose();
            
        } else if (choice == JOptionPane.NO_OPTION) {
    
        } 

    }//GEN-LAST:event_jbtn_hmpgLogoutActionPerformed

    private void jbtn_hmpg2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_hmpg2ActionPerformed
        formatCashInput("2");
    }//GEN-LAST:event_jbtn_hmpg2ActionPerformed

   
    
    
    
    
    private void jbtn_hmpgResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_hmpgResetActionPerformed
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable_hmpgMaintable.getModel();
        model.setRowCount(0);
        javax.swing.JOptionPane.showMessageDialog(this, "Already Resetted!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);       
        
        
        jtxthmpg_Subtotal.setText("");
        jtxthmpg_Discount.setText("");
        jtxthmpg_Total.setText("");
        jtxthmpg_Cash.setText("");
        jtxthmpg_Change.setText("");
        jSpinner_hmpg1.setValue(0);
    }//GEN-LAST:event_jbtn_hmpgResetActionPerformed

    private void jbtn_hmpgPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_hmpgPayActionPerformed
       try {
    if (jtxthmpg_Total.getText().trim().isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "No Item In The Table!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    double total = Double.parseDouble(jtxthmpg_Total.getText().replaceAll(",", "").trim());
    double cash = Double.parseDouble(jtxthmpg_Cash.getText().replaceAll(",", "").trim());

    if (cash < total) {
        javax.swing.JOptionPane.showMessageDialog(this, "Insufficient cash!", "PAYMENT ERROR", javax.swing.JOptionPane.WARNING_MESSAGE);
    } else {
        double change = cash - total;
        
        java.text.DecimalFormat formatter = new java.text.DecimalFormat("#,##0.00");
        jtxthmpg_Change.setText(formatter.format(change));

        double subtotal = total; 
        if (!jtxthmpg_Subtotal.getText().trim().isEmpty()) {
            subtotal = Double.parseDouble(jtxthmpg_Subtotal.getText().replaceAll(",", "").trim());
        }
        
        double discount = 0.00;
        if (!jtxthmpg_Discount.getText().trim().isEmpty()) {
            discount = Double.parseDouble(jtxthmpg_Discount.getText().replaceAll(",", "").trim());
        }

        
        String staffUsername = thriftstore_pointofsale_system.UserSession2.getUsername();

        
        String sql = "INSERT INTO tbl_transactions (staff_username, subtotal, discount, total, cash_given, change_amount) VALUES (?, ?, ?, ?, ?, ?)";

        try (java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect();
             java.sql.PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, staffUsername);
            pstmt.setDouble(2, subtotal);
            pstmt.setDouble(3, discount);
            pstmt.setDouble(4, total);
            pstmt.setDouble(5, cash);
            pstmt.setDouble(6, change);

            pstmt.executeUpdate();

            javax.swing.JOptionPane.showMessageDialog(this, 
                "Payment Successful!\nChange: ₱" + formatter.format(change), 
                "SUCCESS", 
                javax.swing.JOptionPane.INFORMATION_MESSAGE);

        } catch (java.sql.SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "DATABASE ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
} catch (NumberFormatException e) {
    javax.swing.JOptionPane.showMessageDialog(this, "Please Input The Right Cash Amount!", "INPUT ERROR", javax.swing.JOptionPane.WARNING_MESSAGE);
}

    }//GEN-LAST:event_jbtn_hmpgPayActionPerformed

    private void jbtn_hmpgPrintReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_hmpgPrintReceiptActionPerformed
    try {
    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable_hmpgMaintable.getModel();
    
    if (model.getRowCount() == 0) {
        javax.swing.JOptionPane.showMessageDialog(this, "No Transaction to Print!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    // === VALIDATION SA AMOUNT RECEIVE OG CHANGE ===
    String amountReceiveStr = jtxthmpg_Cash.getText().trim();
    
    if (amountReceiveStr.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please input the Amount Receive to Print Receipt!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
        jtxthmpg_Cash.requestFocus();
        return;
    }
    
    double amountReceive = 0.0;
    try {
        amountReceive = Double.parseDouble(amountReceiveStr.replace("₱", "").replace(",", "").trim());
    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Invalid format in Amount Receive!", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }
    // ===============================================

    // 2. Kuhaon ang Subtotal ug uban pa
    double subtotal = 0.0;
    int amountColumnIndex = 2; // Siguruha nga column index ni sa Subtotal/Amount sa imong table
    
    for (int i = 0; i < model.getRowCount(); i++) {
        Object value = model.getValueAt(i, amountColumnIndex);
        if (value != null) {
            String cleanVal = value.toString().replace("₱", "").replace(",", "").trim();
            subtotal += Double.parseDouble(cleanVal);
        }
    }

    double discountAmount = 0.0; 
    double total = subtotal - discountAmount;
    
    // Kuhaon ang Change base sa Amount Receive - Total
    double change = amountReceive - total;
    if (change < 0) {
        javax.swing.JOptionPane.showMessageDialog(this, "The Amount Receive is Insufficient to Total!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    // 3. Petsa ug Oras karon (Format para sa created_at sa tbl_transactions)
    String currentDateTime = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    String currentDateOnly = java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    // Kuhaa ang staff username gikan sa imong session
    String staffUsername = "KINSTON101"; // Ilisi kini sa imong actual session variable

    // 1. Database Insertion gamit ang tbl_transactions
    java.sql.Connection con = null;
    String receiptID = "RX-001";
    
    try {
        con = DBConnection2.connect();
        con.setAutoCommit(false);

        // Kuhaon ang pinakabag-o nga transaction_id para sa receipt ID display
        String idSql = "SELECT transaction_id FROM tbl_transactions ORDER BY transaction_id DESC LIMIT 1";
        try (java.sql.PreparedStatement idPst = con.prepareStatement(idSql);
             java.sql.ResultSet idRs = idPst.executeQuery()) {
            
            if (idRs.next()) {
                int lastIdNum = idRs.getInt("transaction_id") + 1;
                receiptID = String.format("RX-%03d", lastIdNum);
            }
        }

        // I-INSERT sa tbl_transactions base sa istruktura sa imong phpMyAdmin screenshot
        String insertSql = "INSERT INTO tbl_transactions (staff_username, subtotal, discount, total, cash_given, change_amount, created_at) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (java.sql.PreparedStatement insertPst = con.prepareStatement(insertSql)) {
            insertPst.setString(1, staffUsername);
            insertPst.setDouble(2, subtotal);
            insertPst.setDouble(3, discountAmount);
            insertPst.setDouble(4, total);
            insertPst.setDouble(5, amountReceive);
            insertPst.setDouble(6, change);
            insertPst.setString(7, currentDateTime);
            insertPst.executeUpdate();
        }

        con.commit();
        con.close();

    } catch (Exception e) {
        if (con != null) {
            try { con.rollback(); } catch (Exception ex) {}
        }
        javax.swing.JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }

    // 4. Header ug Footer para sa Printer
    java.text.MessageFormat header = new java.text.MessageFormat("ID: " + receiptID + " | Date: " + currentDateOnly);
    java.text.MessageFormat footer = new java.text.MessageFormat("Disc: ₱" + String.format("%.2f", discountAmount) + " | Total: ₱" + String.format("%.2f", total) + " | Change: ₱" + String.format("%.2f", change));

    // 5. Pag-print sa Table
    boolean complete = jTable_hmpgMaintable.print(javax.swing.JTable.PrintMode.FIT_WIDTH, header, footer);
    
    if (complete) {
        javax.swing.JOptionPane.showMessageDialog(this, "Receipt printed and saved successfully!", "INFORMATION", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    
} catch (java.awt.print.PrinterException e) {
    javax.swing.JOptionPane.showMessageDialog(this, "Printer Error: " + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
} catch (NumberFormatException e) {
    javax.swing.JOptionPane.showMessageDialog(this, "Error parsing numeric values: " + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
}



    
    
    
    
    }//GEN-LAST:event_jbtn_hmpgPrintReceiptActionPerformed

    public void calculateTotal() {
   
    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable_hmpgMaintable.getModel();
    double subtotal = 0.0;

    // 1. Pagkuha sa Subtotal gikan sa Column 2 (AMOUNT)
    for (int i = 0; i < model.getRowCount(); i++) {
        try {
            Object amtObj = model.getValueAt(i, 2);
            if (amtObj != null) {
                String amtStr = amtObj.toString().replace(",", "").replace("PHP", "").trim();
                subtotal += Double.parseDouble(amtStr);
            }
        } catch (Exception e) {
            System.out.println("Error sa row " + i + ": " + e.getMessage());
        }
    }

    // 2. Fixed nga 5% Discount Percentage
    double discountPercent = 5.0; 

    // 3. Kalkulasyon sa 5% Discount Amount ug Final Total
    double discountAmount = subtotal * (discountPercent / 100.0);
    double finalTotal = subtotal - discountAmount;

    java.text.DecimalFormat df = new java.text.DecimalFormat("#,##0.00");

    // 4. I-display ang mga resulta sa UI
    jtxthmpg_Subtotal.setText(df.format(subtotal));
    jtxthmpg_Discount.setText(df.format(discountAmount)); // Ipakita kung pila ang kantidad sa 5%
    jtxthmpg_Total.setText(df.format(finalTotal));



}
    
    private void jtxthmpg_DiscountKeyReleased(java.awt.event.KeyEvent evt) {                                             
    calculateTotal();
}
    
    
    private void formatCashInput(String newCharOrNumber) {
    String currentText = jtxthmpg_Cash.getText().replaceAll(",", "").trim();

    
    if (currentText.equals("0.00") || currentText.equals("0") || currentText.isEmpty()) {
        currentText = "";
    } else if (currentText.endsWith(".00")) {
        
        currentText = currentText.substring(0, currentText.length() - 3);
    }

    
    String rawDigits = currentText + newCharOrNumber;

    
    if (rawDigits.length() > 7) {
        return;
    }

    try {
        long cashValue = Long.parseLong(rawDigits);

        
        java.text.DecimalFormat formatter = new java.text.DecimalFormat("#,##0.00");
        jtxthmpg_Cash.setText(formatter.format(cashValue));

    } catch (NumberFormatException e) {
        jtxthmpg_Cash.setText("0.00");
    }

}
    
    
    private void jbtn_hmpgRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_hmpgRemoveActionPerformed
                                               
    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable_hmpgMaintable.getModel();
 

int[] selectedRows = jTable_hmpgMaintable.getSelectedRows();

if (selectedRows.length > 0) {
   
    int confirm = javax.swing.JOptionPane.showConfirmDialog(
        this, 
        "Are you sure you want to remove the selected item(s)?", 
        "CONFIRMATION REMOVAL", 
        javax.swing.JOptionPane.YES_NO_OPTION,
        javax.swing.JOptionPane.WARNING_MESSAGE
    );

    
    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        
        for (int i = selectedRows.length - 1; i >= 0; i--) {
            model.removeRow(selectedRows[i]);
        }
        
        
        calculateTotal();
        
        
        if (model.getRowCount() == 0) {
            lastProductName = "";
            lastProductPrice = 0.0;
        }
    }
} else {
    javax.swing.JOptionPane.showMessageDialog(
        this, 
        "Please Select an Item in The Table to Remove!", 
        "WARNING", 
        javax.swing.JOptionPane.WARNING_MESSAGE
    );
}




    }//GEN-LAST:event_jbtn_hmpgRemoveActionPerformed

    private void jbtn_hmpg7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_hmpg7ActionPerformed
        formatCashInput("7");
    }//GEN-LAST:event_jbtn_hmpg7ActionPerformed

    private void jbtn_hmpg8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_hmpg8ActionPerformed
        formatCashInput("8");
    }//GEN-LAST:event_jbtn_hmpg8ActionPerformed

    private void jbtn_hmpg9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_hmpg9ActionPerformed
        formatCashInput("9");
    }//GEN-LAST:event_jbtn_hmpg9ActionPerformed

    private void jbtn_hmpg4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_hmpg4ActionPerformed
        formatCashInput("4");
    }//GEN-LAST:event_jbtn_hmpg4ActionPerformed

    private void jbtn_hmpg5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_hmpg5ActionPerformed
        formatCashInput("5");
    }//GEN-LAST:event_jbtn_hmpg5ActionPerformed

    private void jbtn_hmpg6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_hmpg6ActionPerformed
        formatCashInput("6");
    }//GEN-LAST:event_jbtn_hmpg6ActionPerformed

    private void jbtn_hmpg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_hmpg1ActionPerformed
        formatCashInput("1");
    }//GEN-LAST:event_jbtn_hmpg1ActionPerformed

    private void jbtn_hmpg3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_hmpg3ActionPerformed
        formatCashInput("3");
    }//GEN-LAST:event_jbtn_hmpg3ActionPerformed

    private void jbtn_hmpg0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_hmpg0ActionPerformed
        formatCashInput("0");
    }//GEN-LAST:event_jbtn_hmpg0ActionPerformed

    private void jbtn_hmpgClearentryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_hmpgClearentryActionPerformed
        jtxthmpg_Cash.setText("0.00");
    }//GEN-LAST:event_jbtn_hmpgClearentryActionPerformed

    private void jbtn_hmpgDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_hmpgDeleteActionPerformed
       String currentText = jtxthmpg_Cash.getText().replaceAll(",", "").trim();
    
    if (currentText.endsWith(".00")) {
        currentText = currentText.substring(0, currentText.length() - 3);
    }

    
    if (currentText.length() > 1) {
        currentText = currentText.substring(0, currentText.length() - 1);
        
        try {
            long cashValue = Long.parseLong(currentText);
            java.text.DecimalFormat formatter = new java.text.DecimalFormat("#,##0.00");
            jtxthmpg_Cash.setText(formatter.format(cashValue));
        } catch (NumberFormatException e) {
            jtxthmpg_Cash.setText("0.00");
        }
    } else {
       
        jtxthmpg_Cash.setText("0.00");
    }
          

    
    }//GEN-LAST:event_jbtn_hmpgDeleteActionPerformed

    
    
    
    public void addProductToTable(String productName, int quantity, double unitPrice) {
    if (productName == null || productName.trim().isEmpty()) {
        return;
    }

    int qtyToAdd = (quantity <= 0) ? 1 : quantity;
    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable_hmpgMaintable.getModel();
    
    boolean itemExists = false;
    int existingRow = -1;

    java.text.DecimalFormat formatter = new java.text.DecimalFormat("#,##0.00");

    for (int i = 0; i < model.getRowCount(); i++) {
        Object val = model.getValueAt(i, 0);
        if (val != null && val.toString().trim().equalsIgnoreCase(productName.trim())) {
            itemExists = true;
            existingRow = i;
            break;
        }
    }

    // Variable para gunitan ang row nga i-highlight
    int selectedRow;

    if (itemExists) {
        try {
            String currentQtyStr = model.getValueAt(existingRow, 1).toString().trim();
            int currentQty = Integer.parseInt(currentQtyStr);
            int newQty = currentQty + qtyToAdd;
            
            double newAmount = newQty * unitPrice;

            model.setValueAt(newQty, existingRow, 1);
            model.setValueAt(formatter.format(newAmount), existingRow, 2);
            
            selectedRow = existingRow; // Gamiton ang existing row
        } catch (Exception e) {
            System.out.println("Update Error: " + e.getMessage());
            return;
        }
    } else {
        double totalAmount = unitPrice * qtyToAdd;
        model.addRow(new Object[]{productName.trim(), qtyToAdd, formatter.format(totalAmount)});
        
        selectedRow = model.getRowCount() - 1; // Gamiton ang bag-ong gi-add nga row (pinaka-ilalom)
    }

    // --- KINI ANG NAKAPAHIGHLIGHT SA ROW ---
    jTable_hmpgMaintable.setRowSelectionInterval(selectedRow, selectedRow);
    jTable_hmpgMaintable.scrollRectToVisible(jTable_hmpgMaintable.getCellRect(selectedRow, 0, true));

    calculateTotal();

}
     
 
    
    
    private void jComboBox_hmpg1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_hmpg1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_hmpg1ItemStateChanged

    
    
    
    
    
    
    
    
    private void jbtnhmpg_deletequantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_deletequantityActionPerformed
try {
    int selectedRow = jTable_hmpgMaintable.getSelectedRow();
    if (selectedRow == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please choose an item in the table first.");
        return;
    }

    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable_hmpgMaintable.getModel();
    String productName = model.getValueAt(selectedRow, 0).toString().trim();
    int currentQty = Integer.parseInt(model.getValueAt(selectedRow, 1).toString().trim());

    // Mangutana pinaagi sa pop-up box aron walay labad sa spinner focus bug!
    String inputStr = javax.swing.JOptionPane.showInputDialog(this, "How many do you want to delete quantity " + productName + "?\n(Current Quantity: " + currentQty + ")");
    
    if (inputStr == null) {
        return; // Gi-cancel sa user
    }

    int qtyToSubtract = 1;
    try {
        qtyToSubtract = Integer.parseInt(inputStr.trim());
    } catch (NumberFormatException e) {
        qtyToSubtract = 1;
    }

    if (qtyToSubtract <= 0) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please input a Number Greater than zero.");
        return;
    }

    if (qtyToSubtract > currentQty) {
        javax.swing.JOptionPane.showMessageDialog(this, "Not Allowed! The current quantity is" + currentQty);
        return;
    }

    int newQty = currentQty - qtyToSubtract;

    // Kuhaon ang presyo sa database
    double unitPrice = 0.0;
    try (java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect();
         java.sql.PreparedStatement pst = con.prepareStatement("SELECT price FROM tbl_products WHERE product_name = ?")) {
        pst.setString(1, productName);
        try (java.sql.ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                unitPrice = rs.getDouble("price");
            }
        }
    }

    double newAmount = newQty * unitPrice;
    java.text.DecimalFormat formatter = new java.text.DecimalFormat("#,##0.00");

    model.setValueAt(newQty, selectedRow, 1);
    model.setValueAt(formatter.format(newAmount), selectedRow, 2);

    calculateTotal();

} catch (Exception e) {
    javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
}


   
  
   
     
    }//GEN-LAST:event_jbtnhmpg_deletequantityActionPerformed

    
    
    
    
    
    private void jComboBox_hmpg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_hmpg1ActionPerformed
        if (jComboBox_hmpg1.getSelectedItem() == null) return;
    
    String selectedCategory = jComboBox_hmpg1.getSelectedItem().toString();

  
    javax.swing.JScrollBar verticalBar = jScrollPane_hmpg1.getVerticalScrollBar();

  
    switch (selectedCategory) {
        case "ADULT CLOTHES":
            verticalBar.setValue(0); 
            break;
            
        case "CHILDREN CLOTHES":
            verticalBar.setValue(670);
            break;
            
        case "ADULT SHOES":
            verticalBar.setValue(1370); 
            break;
            
        case "CHILDREN SHOES":
            verticalBar.setValue(2025); 
            break;
    }

    }//GEN-LAST:event_jComboBox_hmpg1ActionPerformed

    
    private void loadTerminalPrices() {
    try {
        java.sql.Connection con = DBConnection2.connect();
        String sql = "SELECT id, price FROM tbl_products";
        java.sql.PreparedStatement pst = con.prepareStatement(sql);
        java.sql.ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            double price = rs.getDouble("price");

            switch (id) {
                case 1: lbl_hmpg_adult_clothprice1.setText(price + " PHP"); break;
                case 2: lbl_hmpg_adult_clothprice2.setText(price + " PHP"); break;
                case 3: lbl_hmpg_adult_clothprice3.setText(price + " PHP"); break;
                case 4: lbl_hmpg_adult_clothprice4.setText(price + " PHP"); break;
                case 5: lbl_hmpg_adult_clothprice5.setText(price + " PHP"); break;
                case 6: lbl_hmpg_adult_clothprice6.setText(price + " PHP"); break;
                case 7: lbl_hmpg_adult_clothprice7.setText(price + " PHP"); break;
                case 8: lbl_hmpg_adult_clothprice8.setText(price + " PHP"); break;
                case 9: lbl_hmpg_children_clothprice1.setText(price + " PHP"); break;
                case 10: lbl_hmpg_children_clothprice2.setText(price + " PHP"); break;
                case 11: lbl_hmpg_children_clothprice3.setText(price + " PHP"); break;
                case 12: lbl_hmpg_children_clothprice4.setText(price + " PHP"); break;
                case 13: lbl_hmpg_children_clothprice5.setText(price + " PHP"); break;
                case 14: lbl_hmpg_children_clothprice6.setText(price + " PHP"); break;
                case 15: lbl_hmpg_children_clothprice7.setText(price + " PHP"); break;
                case 16: lbl_hmpg_children_clothprice8.setText(price + " PHP"); break;
                case 17: lbl_hmpg_adult_shoeprice1.setText(price + " PHP"); break;
                case 18: lbl_hmpg_adult_shoeprice2.setText(price + " PHP"); break;
                case 19: lbl_hmpg_adult_shoeprice3.setText(price + " PHP"); break;
                case 20: lbl_hmpg_adult_shoeprice4.setText(price + " PHP"); break;
                case 21: lbl_hmpg_adult_shoeprice5.setText(price + " PHP"); break;
                case 22: lbl_hmpg_adult_shoeprice6.setText(price + " PHP"); break;
                case 23: lbl_hmpg_adult_shoeprice7.setText(price + " PHP"); break;
                case 24: lbl_hmpg_adult_shoeprice8.setText(price + " PHP"); break;
                case 25: lbl_hmpg_children_shoeprice1.setText(price + " PHP"); break;
                case 26: lbl_hmpg_children_shoeprice2.setText(price + " PHP"); break;
                case 27: lbl_hmpg_children_shoeprice3.setText(price + " PHP"); break;
                case 28: lbl_hmpg_children_shoeprice4.setText(price + " PHP"); break;
                case 29: lbl_hmpg_children_shoeprice5.setText(price + " PHP"); break;
                case 30: lbl_hmpg_children_shoeprice6.setText(price + " PHP"); break;
                case 31: lbl_hmpg_children_shoeprice7.setText(price + " PHP"); break;
                case 32: lbl_hmpg_children_shoeprice8.setText(price + " PHP"); break;
            }
        }

        rs.close();
        pst.close();
        con.close();
    } catch (Exception e) {
        System.out.println("Error loading prices: " + e.getMessage());
    }
}
    
    // Kausa ra nimo ni isulat sa imong file!
private void handleProductButtonClick(String productName) {
     double productPrice = 0.0;
    double productDiscount = 0.0; // Kuhaon nato ang discount

    try {
        // Gigamit nato ang imong DBConnection2 aron consistency sa imong codebase
        java.sql.Connection con = DBConnection2.connect();

        // Giapil nato ang discount sa SQL query
        String sql = "SELECT price, discount FROM tbl_products WHERE product_name = ?";
        java.sql.PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, productName); 
        java.sql.ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            productPrice = rs.getDouble("price");
            productDiscount = rs.getDouble("discount"); // Kuhaon ang discount gikan sa database
            
            // I-save sa global variables kung kinahanglan pa nimo sa uban
            this.lastProductName = productName;
            this.lastProductPrice = productPrice;
            
            // I-display dayon sa imong mga textfields sa POS homepage!
            jtxthmpg_Subtotal.setText(String.valueOf(productPrice));
            jtxthmpg_Discount.setText(String.valueOf(productDiscount)); // Mo-reflect na ang discount nga gi-set ni admin
            
            double total = productPrice - productDiscount;
            jtxthmpg_Total.setText(String.valueOf(total));
            
        } else {
            System.out.println("Product not found in database: " + productName);
        }

        rs.close();
        pst.close();
        con.close();

        System.out.println("Fetched Price for " + productName + ": " + productPrice + " | Discount: " + productDiscount);

        // Diretso ra gihapon sa pag-add sa table
        addProductToTable(productName, 1, productPrice);

    } catch (Exception e) {
        System.out.println("DB Fetch Error: " + e.getMessage());
    }
}

    
    
    
    
    
    
    private void jtxthmpg_CashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxthmpg_CashActionPerformed
        
    }//GEN-LAST:event_jtxthmpg_CashActionPerformed

    private void jbtnhmpg_adult_cloth8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_adult_cloth8ActionPerformed
        handleProductButtonClick("Adidas Hoodie");
    }//GEN-LAST:event_jbtnhmpg_adult_cloth8ActionPerformed

    private void jbtnhmpg_adult_cloth7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_adult_cloth7ActionPerformed
        handleProductButtonClick("Oakley Brown");
    }//GEN-LAST:event_jbtnhmpg_adult_cloth7ActionPerformed

    private void jbtnhmpg_adult_cloth5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_adult_cloth5ActionPerformed
        handleProductButtonClick("Rugby Sleeve");
    }//GEN-LAST:event_jbtnhmpg_adult_cloth5ActionPerformed

    private void jbtnhmpg_adult_cloth9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_adult_cloth9ActionPerformed
        handleProductButtonClick("Salomon Sleeve");
    }//GEN-LAST:event_jbtnhmpg_adult_cloth9ActionPerformed

    private void jbtnhmpg_children_cloth1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_children_cloth1ActionPerformed
        handleProductButtonClick("Sleeve Toddler");
    }//GEN-LAST:event_jbtnhmpg_children_cloth1ActionPerformed

    private void jbtnhmpg_adult_cloth1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_adult_cloth1ActionPerformed
       handleProductButtonClick("Gilda Shirt");
    }//GEN-LAST:event_jbtnhmpg_adult_cloth1ActionPerformed

    private void jbtnhmpg_adult_cloth4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_adult_cloth4ActionPerformed
        handleProductButtonClick("Ivory Sleeve");
    }//GEN-LAST:event_jbtnhmpg_adult_cloth4ActionPerformed

    private void jbtnhmpg_adult_cloth3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_adult_cloth3ActionPerformed
       handleProductButtonClick("Peregrine");
    }//GEN-LAST:event_jbtnhmpg_adult_cloth3ActionPerformed

    private void jbtnhmpg_adult_cloth2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_adult_cloth2ActionPerformed
       handleProductButtonClick("Khaki Crew");
    }//GEN-LAST:event_jbtnhmpg_adult_cloth2ActionPerformed

    private void jbtnhmpg_children_cloth2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_children_cloth2ActionPerformed
        handleProductButtonClick("Baby Blouse");
    }//GEN-LAST:event_jbtnhmpg_children_cloth2ActionPerformed

    private void jbtnhmpg_children_cloth3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_children_cloth3ActionPerformed
        handleProductButtonClick("Peter Pan");
    }//GEN-LAST:event_jbtnhmpg_children_cloth3ActionPerformed

    private void jbtnhmpg_children_cloth4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_children_cloth4ActionPerformed
        handleProductButtonClick("Pink Button");
    }//GEN-LAST:event_jbtnhmpg_children_cloth4ActionPerformed

    private void jbtnhmpg_children_cloth5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_children_cloth5ActionPerformed
        handleProductButtonClick("Baby Flounce");
    }//GEN-LAST:event_jbtnhmpg_children_cloth5ActionPerformed

    private void jbtnhmpg_children_cloth6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_children_cloth6ActionPerformed
        handleProductButtonClick("Navy Collar");
    }//GEN-LAST:event_jbtnhmpg_children_cloth6ActionPerformed

    private void jbtnhmpg_children_cloth7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_children_cloth7ActionPerformed
        handleProductButtonClick("Cyrillus Dress");
    }//GEN-LAST:event_jbtnhmpg_children_cloth7ActionPerformed

    private void jbtnhmpg_children_cloth8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_children_cloth8ActionPerformed
        handleProductButtonClick("Burgundy");

    }//GEN-LAST:event_jbtnhmpg_children_cloth8ActionPerformed

    private void jbtnhmpg_adult_shoe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_adult_shoe1ActionPerformed
        handleProductButtonClick("Nike Air Force");
    }//GEN-LAST:event_jbtnhmpg_adult_shoe1ActionPerformed

    private void jbtnhmpg_adult_shoe2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_adult_shoe2ActionPerformed
        handleProductButtonClick("Peak Parker");
    }//GEN-LAST:event_jbtnhmpg_adult_shoe2ActionPerformed

    private void jbtnhmpg_adult_shoe3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_adult_shoe3ActionPerformed
        handleProductButtonClick("Air Wolf Pro");
    }//GEN-LAST:event_jbtnhmpg_adult_shoe3ActionPerformed

    private void jbtnhmpg_adult_shoe4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_adult_shoe4ActionPerformed
        handleProductButtonClick("Adidas Dame");
    }//GEN-LAST:event_jbtnhmpg_adult_shoe4ActionPerformed

    private void jbtnhmpg_adult_shoe5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_adult_shoe5ActionPerformed
        handleProductButtonClick("Under Armour");
    }//GEN-LAST:event_jbtnhmpg_adult_shoe5ActionPerformed

    private void jbtnhmpg_adult_shoe6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_adult_shoe6ActionPerformed
        handleProductButtonClick("Nike Hype");
    }//GEN-LAST:event_jbtnhmpg_adult_shoe6ActionPerformed

    private void jbtnhmpg_adult_shoe7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_adult_shoe7ActionPerformed
        handleProductButtonClick("Air Jordan");
    }//GEN-LAST:event_jbtnhmpg_adult_shoe7ActionPerformed

    private void jbtnhmpg_adult_shoe8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_adult_shoe8ActionPerformed
        handleProductButtonClick("Adidas Star");
    }//GEN-LAST:event_jbtnhmpg_adult_shoe8ActionPerformed

    private void jbtnhmpg_children_shoe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_children_shoe1ActionPerformed
        handleProductButtonClick("Nike Max");
    }//GEN-LAST:event_jbtnhmpg_children_shoe1ActionPerformed

    private void jbtnhmpg_children_shoe2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_children_shoe2ActionPerformed
        handleProductButtonClick("Air Tailwind");
    }//GEN-LAST:event_jbtnhmpg_children_shoe2ActionPerformed

    private void jbtnhmpg_children_shoe3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_children_shoe3ActionPerformed
        handleProductButtonClick("Toddler Nike");
    }//GEN-LAST:event_jbtnhmpg_children_shoe3ActionPerformed

    private void jbtnhmpg_children_shoe4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_children_shoe4ActionPerformed
        handleProductButtonClick("Kid Sneakers");
    }//GEN-LAST:event_jbtnhmpg_children_shoe4ActionPerformed

    private void jbtnhmpg_children_shoe5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_children_shoe5ActionPerformed
        handleProductButtonClick("Air Max");
    }//GEN-LAST:event_jbtnhmpg_children_shoe5ActionPerformed

    private void jbtnhmpg_children_shoe6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_children_shoe6ActionPerformed
        handleProductButtonClick("Baby Tiny Nike");
    }//GEN-LAST:event_jbtnhmpg_children_shoe6ActionPerformed

    private void jbtnhmpg_children_shoe7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_children_shoe7ActionPerformed
        handleProductButtonClick("PUMA Heart");
    }//GEN-LAST:event_jbtnhmpg_children_shoe7ActionPerformed

    private void jbtnhmpg_children_shoe8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_children_shoe8ActionPerformed
       handleProductButtonClick("Air Max SC");
    }//GEN-LAST:event_jbtnhmpg_children_shoe8ActionPerformed

    private void jbtnhmpg_addquantity1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnhmpg_addquantity1ActionPerformed
 try {
    int selectedRow = jTable_hmpgMaintable.getSelectedRow();
    if (selectedRow == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please choose an item first in the table.");
        return;
    }

    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable_hmpgMaintable.getModel();
    String productName = model.getValueAt(selectedRow, 0).toString().trim();

    // Kunin ang quantity na idadagdag nang may proteksyon
    int qtyToAdd = 1;
    try {
        jSpinner_hmpg1.commitEdit();
        Object val = jSpinner_hmpg1.getValue();
        if (val != null) {
            qtyToAdd = Integer.parseInt(val.toString().trim());
        }
    } catch (Exception ex) {
        qtyToAdd = 1;
    }

    if (qtyToAdd <= 0) {
        qtyToAdd = 1;
    }

    int currentQty = Integer.parseInt(model.getValueAt(selectedRow, 1).toString().trim());
    int newQty = currentQty + qtyToAdd; // Siguradong mag-aadd

    // Kunin ang presyo mula sa database
    double unitPrice = 0.0;
    try (java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect();
         java.sql.PreparedStatement pst = con.prepareStatement("SELECT price FROM tbl_products WHERE product_name = ?")) {
        pst.setString(1, productName);
        try (java.sql.ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                unitPrice = rs.getDouble("price");
            }
        }
    }

    double newAmount = newQty * unitPrice;
    java.text.DecimalFormat formatter = new java.text.DecimalFormat("#,##0.00");

    model.setValueAt(newQty, selectedRow, 1);
    model.setValueAt(formatter.format(newAmount), selectedRow, 2);

    calculateTotal();
    jSpinner_hmpg1.setValue(0); 

} catch (Exception e) {
    javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
}

        
        
        
        
        
    }//GEN-LAST:event_jbtnhmpg_addquantity1ActionPerformed

    private void jtxthmpg_CashKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxthmpg_CashKeyTyped
                                            
    char c = evt.getKeyChar();

    // I-check kung numero ba ang gi-type (0-9)
    if (Character.isDigit(c)) {
        formatCashInput(String.valueOf(c));
        evt.consume();
    } 
    else if (c == java.awt.event.KeyEvent.VK_BACK_SPACE) {
        String currentText = jtxthmpg_Cash.getText().replaceAll(",", "").replace(".00", "").trim();
        if (currentText.length() > 1) {
            currentText = currentText.substring(0, currentText.length() - 1);
            formatCashInput(currentText);
        } else {
            jtxthmpg_Cash.setText("0.00");
        }
        evt.consume();
    } 
    else {
        evt.consume();
    }

    }//GEN-LAST:event_jtxthmpg_CashKeyTyped

    private void jSpinner_hmpg1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_hmpg1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinner_hmpg1StateChanged

    private void jTable_hmpgMaintableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_hmpgMaintableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_hmpgMaintableMousePressed

    private void jSpinner_hmpg1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSpinner_hmpg1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinner_hmpg1PropertyChange


    
    
    
    
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(Pos_terminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pos_terminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pos_terminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pos_terminal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pos_terminal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox_hmpg1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel_hmpg_1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane_hmpg1;
    private javax.swing.JSpinner jSpinner_hmpg1;
    private javax.swing.JTable jTable_hmpgMaintable;
    private javax.swing.JButton jbtn_hmpg0;
    private javax.swing.JButton jbtn_hmpg1;
    private javax.swing.JButton jbtn_hmpg2;
    private javax.swing.JButton jbtn_hmpg3;
    private javax.swing.JButton jbtn_hmpg4;
    private javax.swing.JButton jbtn_hmpg5;
    private javax.swing.JButton jbtn_hmpg6;
    private javax.swing.JButton jbtn_hmpg7;
    private javax.swing.JButton jbtn_hmpg8;
    private javax.swing.JButton jbtn_hmpg9;
    private javax.swing.JButton jbtn_hmpgClearentry;
    private javax.swing.JButton jbtn_hmpgDelete;
    private javax.swing.JButton jbtn_hmpgLogout;
    private javax.swing.JButton jbtn_hmpgPay;
    private javax.swing.JButton jbtn_hmpgPrintReceipt;
    private javax.swing.JButton jbtn_hmpgRemove;
    private javax.swing.JButton jbtn_hmpgReset;
    private javax.swing.JButton jbtnhmpg_addquantity1;
    private javax.swing.JButton jbtnhmpg_adult_cloth1;
    private javax.swing.JButton jbtnhmpg_adult_cloth2;
    private javax.swing.JButton jbtnhmpg_adult_cloth3;
    private javax.swing.JButton jbtnhmpg_adult_cloth4;
    private javax.swing.JButton jbtnhmpg_adult_cloth5;
    private javax.swing.JButton jbtnhmpg_adult_cloth7;
    private javax.swing.JButton jbtnhmpg_adult_cloth8;
    private javax.swing.JButton jbtnhmpg_adult_cloth9;
    private javax.swing.JButton jbtnhmpg_adult_shoe1;
    private javax.swing.JButton jbtnhmpg_adult_shoe2;
    private javax.swing.JButton jbtnhmpg_adult_shoe3;
    private javax.swing.JButton jbtnhmpg_adult_shoe4;
    private javax.swing.JButton jbtnhmpg_adult_shoe5;
    private javax.swing.JButton jbtnhmpg_adult_shoe6;
    private javax.swing.JButton jbtnhmpg_adult_shoe7;
    private javax.swing.JButton jbtnhmpg_adult_shoe8;
    private javax.swing.JButton jbtnhmpg_children_cloth1;
    private javax.swing.JButton jbtnhmpg_children_cloth2;
    private javax.swing.JButton jbtnhmpg_children_cloth3;
    private javax.swing.JButton jbtnhmpg_children_cloth4;
    private javax.swing.JButton jbtnhmpg_children_cloth5;
    private javax.swing.JButton jbtnhmpg_children_cloth6;
    private javax.swing.JButton jbtnhmpg_children_cloth7;
    private javax.swing.JButton jbtnhmpg_children_cloth8;
    private javax.swing.JButton jbtnhmpg_children_shoe1;
    private javax.swing.JButton jbtnhmpg_children_shoe2;
    private javax.swing.JButton jbtnhmpg_children_shoe3;
    private javax.swing.JButton jbtnhmpg_children_shoe4;
    private javax.swing.JButton jbtnhmpg_children_shoe5;
    private javax.swing.JButton jbtnhmpg_children_shoe6;
    private javax.swing.JButton jbtnhmpg_children_shoe7;
    private javax.swing.JButton jbtnhmpg_children_shoe8;
    private javax.swing.JButton jbtnhmpg_deletequantity;
    private javax.swing.JTextField jtxthmpg_Cash;
    private javax.swing.JTextField jtxthmpg_Change;
    private javax.swing.JTextField jtxthmpg_Discount;
    private javax.swing.JTextField jtxthmpg_Subtotal;
    private javax.swing.JTextField jtxthmpg_Total;
    private javax.swing.JLabel lbl_hmpg_adult_cloth1;
    private javax.swing.JLabel lbl_hmpg_adult_cloth2;
    private javax.swing.JLabel lbl_hmpg_adult_cloth3;
    private javax.swing.JLabel lbl_hmpg_adult_cloth4;
    private javax.swing.JLabel lbl_hmpg_adult_cloth5;
    private javax.swing.JLabel lbl_hmpg_adult_cloth6;
    private javax.swing.JLabel lbl_hmpg_adult_cloth7;
    private javax.swing.JLabel lbl_hmpg_adult_cloth8;
    private javax.swing.JLabel lbl_hmpg_adult_clothprice1;
    private javax.swing.JLabel lbl_hmpg_adult_clothprice2;
    private javax.swing.JLabel lbl_hmpg_adult_clothprice3;
    private javax.swing.JLabel lbl_hmpg_adult_clothprice4;
    private javax.swing.JLabel lbl_hmpg_adult_clothprice5;
    private javax.swing.JLabel lbl_hmpg_adult_clothprice6;
    private javax.swing.JLabel lbl_hmpg_adult_clothprice7;
    private javax.swing.JLabel lbl_hmpg_adult_clothprice8;
    private javax.swing.JLabel lbl_hmpg_adult_shoe1;
    private javax.swing.JLabel lbl_hmpg_adult_shoe2;
    private javax.swing.JLabel lbl_hmpg_adult_shoe3;
    private javax.swing.JLabel lbl_hmpg_adult_shoe4;
    private javax.swing.JLabel lbl_hmpg_adult_shoe5;
    private javax.swing.JLabel lbl_hmpg_adult_shoe6;
    private javax.swing.JLabel lbl_hmpg_adult_shoe7;
    private javax.swing.JLabel lbl_hmpg_adult_shoe8;
    private javax.swing.JLabel lbl_hmpg_adult_shoeprice1;
    private javax.swing.JLabel lbl_hmpg_adult_shoeprice2;
    private javax.swing.JLabel lbl_hmpg_adult_shoeprice3;
    private javax.swing.JLabel lbl_hmpg_adult_shoeprice4;
    private javax.swing.JLabel lbl_hmpg_adult_shoeprice5;
    private javax.swing.JLabel lbl_hmpg_adult_shoeprice6;
    private javax.swing.JLabel lbl_hmpg_adult_shoeprice7;
    private javax.swing.JLabel lbl_hmpg_adult_shoeprice8;
    private javax.swing.JLabel lbl_hmpg_children_cloth1;
    private javax.swing.JLabel lbl_hmpg_children_cloth2;
    private javax.swing.JLabel lbl_hmpg_children_cloth3;
    private javax.swing.JLabel lbl_hmpg_children_cloth4;
    private javax.swing.JLabel lbl_hmpg_children_cloth5;
    private javax.swing.JLabel lbl_hmpg_children_cloth6;
    private javax.swing.JLabel lbl_hmpg_children_cloth7;
    private javax.swing.JLabel lbl_hmpg_children_cloth8;
    private javax.swing.JLabel lbl_hmpg_children_clothprice1;
    private javax.swing.JLabel lbl_hmpg_children_clothprice2;
    private javax.swing.JLabel lbl_hmpg_children_clothprice3;
    private javax.swing.JLabel lbl_hmpg_children_clothprice4;
    private javax.swing.JLabel lbl_hmpg_children_clothprice5;
    private javax.swing.JLabel lbl_hmpg_children_clothprice6;
    private javax.swing.JLabel lbl_hmpg_children_clothprice7;
    private javax.swing.JLabel lbl_hmpg_children_clothprice8;
    private javax.swing.JLabel lbl_hmpg_children_shoe1;
    private javax.swing.JLabel lbl_hmpg_children_shoe2;
    private javax.swing.JLabel lbl_hmpg_children_shoe3;
    private javax.swing.JLabel lbl_hmpg_children_shoe4;
    private javax.swing.JLabel lbl_hmpg_children_shoe5;
    private javax.swing.JLabel lbl_hmpg_children_shoe6;
    private javax.swing.JLabel lbl_hmpg_children_shoe7;
    private javax.swing.JLabel lbl_hmpg_children_shoe8;
    private javax.swing.JLabel lbl_hmpg_children_shoeprice1;
    private javax.swing.JLabel lbl_hmpg_children_shoeprice2;
    private javax.swing.JLabel lbl_hmpg_children_shoeprice3;
    private javax.swing.JLabel lbl_hmpg_children_shoeprice4;
    private javax.swing.JLabel lbl_hmpg_children_shoeprice5;
    private javax.swing.JLabel lbl_hmpg_children_shoeprice6;
    private javax.swing.JLabel lbl_hmpg_children_shoeprice7;
    private javax.swing.JLabel lbl_hmpg_children_shoeprice8;
    // End of variables declaration//GEN-END:variables
}
