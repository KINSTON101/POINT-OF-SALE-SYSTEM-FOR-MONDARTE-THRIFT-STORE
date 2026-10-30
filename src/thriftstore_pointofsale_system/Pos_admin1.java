/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package thriftstore_pointofsale_system;

import javax.swing.JOptionPane;
import thriftstore_pointofsale_system.Pos_login;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import thriftstore_pointofsale_system.DBConnection2;
import javax.swing.JTextField;
import java.awt.KeyboardFocusManager;


/**
 *
 * @author Kinston
 */

public class Pos_admin1 extends javax.swing.JFrame {

    /**
     * Creates new form Pos_homepage
     */
    public Pos_admin1() {
        
        initComponents();
        
        startRealtimeMonitoring();
        loadStaffData();
        loadAdminTable();
        loadMonthlyReportTable();
        loadDailyLogsTable();
        
        
       

        
        addPlaceholder(jtxt_admin_staff_firstname, "Enter First Name");
        addPlaceholder(jtxt_admin_staff_lastname, "Enter Last Name ");
        addPlaceholder(jtxt_admin_staff_username, "Enter Username");
        addPlaceholder(jtxt_admin_staff_pin, "Enter 4 Digit Pin");
        
        
        addPlaceholder(jtxt_admin_firstname,"Enter First Name");
        addPlaceholder(jtxt_admin_lastname, "Enter Last Name ");
        addPlaceholder(jtxt_admin_username, "Enter Username");
        addPlaceholder(jtxt_admin_password, "Enter 4 Digit Pin");
        

jTablePane_admin1.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTablePane_admin1MouseClicked(evt);
    }
});        // ==================== TABBED PANE UI BORDER ====================
        // ==================== TABBED PANE STYLING ====================
jTabbedPane_admin.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
    @Override
    protected void paintTabBorder(java.awt.Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        g.setColor(new java.awt.Color(255, 140, 0)); // Orange color
        g.drawRect(x, y, w - 1, h - 1);
    }

    @Override
    protected void paintContentBorder(java.awt.Graphics g, int tabPlacement, int selectedIndex) {
        g.setColor(new java.awt.Color(255, 140, 0)); // Orange color
        g.drawRect(0, 0, jTabbedPane_admin.getWidth() - 1, jTabbedPane_admin.getHeight() - 1);
    }
});
jTabbedPane_admin.setBackground(new java.awt.Color(50, 50, 50));


jTablePane_admin2.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = jTablePane_admin2.getSelectedRow();
        
        if (selectedRow != -1) {
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTablePane_admin2.getModel();
            
            // Siguruha nga sakto ang column index base sa imong table columns:
            // Column 0: Admin ID, Column 1: First Name, Column 2: Last Name, Column 3: Username, Column 4: Password/PIN
            String firstName = model.getValueAt(selectedRow, 1).toString();
            String lastName = model.getValueAt(selectedRow, 2).toString();
            String username = model.getValueAt(selectedRow, 3).toString();
            String pin = model.getValueAt(selectedRow, 4).toString();
            
            // I-set sa mga text fields
            jtxt_admin_firstname.setText(firstName);
            jtxt_admin_lastname.setText(lastName);
            jtxt_admin_username.setText(username);
            jtxt_admin_password.setText(pin);
            
            // Kuhaa ang kulay o i-set nga normal text color
            jtxt_admin_firstname.setForeground(java.awt.Color.BLACK);
            jtxt_admin_lastname.setForeground(java.awt.Color.BLACK);
            jtxt_admin_username.setForeground(java.awt.Color.BLACK);
            jtxt_admin_password.setForeground(java.awt.Color.BLACK);
        }
    }
});

// ==================== REUSABLE RENDERERS (HEADER & DATA) ====================


javax.swing.table.DefaultTableCellRenderer darkHeaderRenderer = new javax.swing.table.DefaultTableCellRenderer() {
    @Override
    public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        javax.swing.JLabel lbl = (javax.swing.JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        lbl.setBackground(new java.awt.Color(25, 25, 25));
        lbl.setForeground(java.awt.Color.WHITE);
        lbl.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        lbl.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 140, 0)));
        lbl.setHorizontalAlignment(javax.swing.JLabel.CENTER); // Header sa Gitna
        return lbl;
    }
};


javax.swing.table.DefaultTableCellRenderer centerCellRenderer = new javax.swing.table.DefaultTableCellRenderer();
centerCellRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER); // Data Cells sa Gitna


// ==================== STYLING FOR TABLE 1 (Staff) ====================
jTablePane_admin1.setBackground(new java.awt.Color(40, 40, 40));
jTablePane_admin1.setForeground(java.awt.Color.WHITE);
jTablePane_admin1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
jTablePane_admin1.setRowHeight(28);
jTablePane_admin1.setShowGrid(false);
jTablePane_admin1.setSelectionBackground(new java.awt.Color(255, 140, 0));
jTablePane_admin1.setSelectionForeground(java.awt.Color.BLACK);

jTablePane_admin1.getTableHeader().setOpaque(false);
jTablePane_admin1.getTableHeader().setDefaultRenderer(darkHeaderRenderer);


for (int i = 0; i < jTablePane_admin1.getColumnCount(); i++) {
    jTablePane_admin1.getColumnModel().getColumn(i).setCellRenderer(centerCellRenderer);
}

jScrollPane1.getViewport().setBackground(new java.awt.Color(40, 40, 40));
jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 140, 0), 1));


// ==================== STYLING FOR TABLE 2 (Admin) ====================
jTablePane_admin2.setBackground(new java.awt.Color(40, 40, 40));
jTablePane_admin2.setForeground(java.awt.Color.WHITE);
jTablePane_admin2.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
jTablePane_admin2.setRowHeight(28);
jTablePane_admin2.setShowGrid(false);
jTablePane_admin2.setSelectionBackground(new java.awt.Color(255, 140, 0));
jTablePane_admin2.setSelectionForeground(java.awt.Color.BLACK);

jTablePane_admin2.getTableHeader().setOpaque(false);
jTablePane_admin2.getTableHeader().setDefaultRenderer(darkHeaderRenderer);


for (int i = 0; i < jTablePane_admin2.getColumnCount(); i++) {
    jTablePane_admin2.getColumnModel().getColumn(i).setCellRenderer(centerCellRenderer);
}

jScrollPane2.getViewport().setBackground(new java.awt.Color(40, 40, 40));
jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 140, 0), 1));


// ==================== STYLING FOR TABLE 3 (Daily Logs) ====================
jTablePane_admin3.setBackground(new java.awt.Color(40, 40, 40));
jTablePane_admin3.setForeground(java.awt.Color.WHITE);
jTablePane_admin3.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
jTablePane_admin3.setRowHeight(28);
jTablePane_admin3.setShowGrid(false);
jTablePane_admin3.setSelectionBackground(new java.awt.Color(255, 140, 0));
jTablePane_admin3.setSelectionForeground(java.awt.Color.BLACK);

jTablePane_admin3.getTableHeader().setOpaque(false);
jTablePane_admin3.getTableHeader().setDefaultRenderer(darkHeaderRenderer);


for (int i = 0; i < jTablePane_admin3.getColumnCount(); i++) {
    jTablePane_admin3.getColumnModel().getColumn(i).setCellRenderer(centerCellRenderer);
}

jScrollPane3.getViewport().setBackground(new java.awt.Color(40, 40, 40));
jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 140, 0), 1));



// ==================== STYLING FOR TABLE 3 (Daily Logs) ====================
jTablePane_admin4.setBackground(new java.awt.Color(40, 40, 40));
jTablePane_admin4.setForeground(java.awt.Color.WHITE);
jTablePane_admin4.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12));
jTablePane_admin4.setRowHeight(28);
jTablePane_admin4.setShowGrid(false);
jTablePane_admin4.setSelectionBackground(new java.awt.Color(255, 140, 0));
jTablePane_admin4.setSelectionForeground(java.awt.Color.BLACK);

jTablePane_admin4.getTableHeader().setOpaque(false);
jTablePane_admin4.getTableHeader().setDefaultRenderer(darkHeaderRenderer);


for (int i = 0; i < jTablePane_admin4.getColumnCount(); i++) {
    jTablePane_admin4.getColumnModel().getColumn(i).setCellRenderer(centerCellRenderer);
}

jScrollPane4.getViewport().setBackground(new java.awt.Color(40, 40, 40));
jScrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 140, 0), 1));

    }
    
    

    
    public void addPlaceholder(javax.swing.text.JTextComponent field, String placeholder) {
    boolean isPassword = field instanceof javax.swing.JPasswordField;
    char echoChar = isPassword ? ((javax.swing.JPasswordField) field).getEchoChar() : 0;

    if (isPassword) ((javax.swing.JPasswordField) field).setEchoChar((char) 0);
    field.setText(placeholder);
    field.setForeground(java.awt.Color.GRAY);

    field.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (field.getText().equals(placeholder)) {
                field.setText("");
                if (isPassword) ((javax.swing.JPasswordField) field).setEchoChar(echoChar);
            }
            // I-force dayon nga itom ang kolor basta mo-focus ang user
            field.setForeground(java.awt.Color.BLACK);
        }

        @Override
        public void focusLost(java.awt.event.FocusEvent evt) {
            if (field.getText().trim().isEmpty() || field.getText().equals(placeholder)) {
                if (isPassword) ((javax.swing.JPasswordField) field).setEchoChar((char) 0);
                field.setText(placeholder);
                field.setForeground(java.awt.Color.GRAY);
            } else {
                field.setForeground(java.awt.Color.BLACK);
            }
        }
    });
}


public boolean validateInputs() {
    String firstName = jtxt_admin_firstname.getText().trim();
    String lastName = jtxt_admin_lastname.getText().trim();
    String username = jtxt_admin_username.getText().trim();
    String password = jtxt_admin_password.getText().trim();

    if (firstName.isEmpty() || firstName.equals("Enter First Name") ||
        lastName.isEmpty() || lastName.equals("Enter Last Name") ||
        username.isEmpty() || username.equals("Enter Username") ||
        password.isEmpty() || password.equals("Enter 4 Digit Pin")) {
        
        javax.swing.JOptionPane.showMessageDialog(this, "Please Input all Information on the Fields!");
        return false; // Ibalik ang false kung naay blangko o placeholder
    }
    return true; // Ibalik ang true kung limpyo ug sakto ang gi-input
}    
    
    
    
    
    
private int lastSeenTransactionId = 0;
private javax.swing.Timer transactionTimer;    
    
    
    


public void startRealtimeMonitoring() {
    initLastTransactionId();
    loadDailyLogsTable();

   
    transactionTimer = new javax.swing.Timer(3000, e -> checkForNewTransactions());
    transactionTimer.start();
}

private void initLastTransactionId() {
    try (java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect();
         java.sql.Statement stmt = con.createStatement();
         java.sql.ResultSet rs = stmt.executeQuery("SELECT MAX(transaction_id) FROM tbl_transactions")) {
        if (rs.next()) {
            lastSeenTransactionId = rs.getInt(1);
        }
    } catch (java.sql.SQLException e) {
        e.printStackTrace();
    }
}


public void loadDailyLogsTable() {
    String sql = "SELECT transaction_id, "
               + "DATE_FORMAT(created_at, '%Y-%m-%d') AS date_log, "
               + "DATE_FORMAT(created_at, '%h:%i %p') AS time_log, "
               + "DATE_FORMAT(created_at, '%W') AS day_log, "
               + "staff_username, subtotal, discount, total "
               + "FROM tbl_transactions ORDER BY transaction_id DESC";

    try (java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect();
         java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
         java.sql.ResultSet rs = pstmt.executeQuery()) {

        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTablePane_admin3.getModel();
        model.setRowCount(0); 

        java.text.DecimalFormat formatter = new java.text.DecimalFormat("#,##0.00");

        while (rs.next()) {
            int txId = rs.getInt("transaction_id");
            String formattedReceiptID = "RX-" + String.format("%03d", txId); // O "2026-" + String.format("%03d", txId)
            String date = rs.getString("date_log");
            String time = rs.getString("time_log");
            String day = rs.getString("day_log");
            String staff = rs.getString("staff_username");
            double subtotal = rs.getDouble("subtotal");
            double discount = rs.getDouble("discount");
            double total = rs.getDouble("total");

            // Siguroha nga ang order sa object array kay gasubay sa imong 8 ka table columns:
            // [0] RECEIPT ID, [1] DATE, [2] TIME, [3] DAY, [4] STAFF USERNAME, [5] SUBTOTAL, [6] DISCOUNT, [7] TOTAL
            model.addRow(new Object[]{
                formattedReceiptID,
                date,
                time,
                day,
                staff,
                "₱" + formatter.format(subtotal),
                "₱" + formatter.format(discount),
                "₱" + formatter.format(total)
            });
        }

    } catch (java.sql.SQLException e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Error sa pag-load sa Daily Logs: " + e.getMessage());
    }

}


private void checkForNewTransactions() {
    String sql = "SELECT * FROM tbl_transactions WHERE transaction_id > ? ORDER BY transaction_id ASC";

    try (java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect();
         java.sql.PreparedStatement pstmt = con.prepareStatement(sql)) {

        pstmt.setInt(1, lastSeenTransactionId);
        java.sql.ResultSet rs = pstmt.executeQuery();

        boolean hasNew = false;

        while (rs.next()) {
            hasNew = true;
            lastSeenTransactionId = rs.getInt("transaction_id");
            String staff = rs.getString("staff_username");
            double total = rs.getDouble("total");

            java.text.DecimalFormat formatter = new java.text.DecimalFormat("#,##0.00");

            
            javax.swing.JOptionPane.showMessageDialog(this,
                "NEW TRANSACTION COMPLETED!\n\nStaff: " + staff + "\nTotal Amount: ₱" + formatter.format(total),
                "NEW SALE ALERT",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }

        
        if (hasNew) {
            loadDailyLogsTable();
        }

    } catch (java.sql.SQLException ex) {
        ex.printStackTrace();
    }
}
 
 
 
 
 


    

public void loadStaffData() {
   try (java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect();
         java.sql.Statement st = con.createStatement();
         java.sql.ResultSet rs = st.executeQuery("SELECT user_id, first_name, last_name, username, pin FROM tbl_staff_info")) {
        
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTablePane_admin1.getModel();
        model.setRowCount(0); // I-clear ang tibuok table sa dili pa i-load og usab
        
        while (rs.next()) {
            String id = "STF-" + String.format("%03d", rs.getInt("user_id"));
            String fname = rs.getString("first_name");
            String lname = rs.getString("last_name");
            String uname = rs.getString("username");
            String pin = rs.getString("pin");
            
            model.addRow(new Object[]{id, fname, lname, uname, pin});
        }
    } catch (java.sql.SQLException e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}


public void loadAdminTable() {
    try {
        java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect();
        String sql = "SELECT admin_id, first_name, last_name, admin_username, admin_pin FROM tbl_admin_info";
        java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
        java.sql.ResultSet rs = pstmt.executeQuery();
        
        // Gigamit diretso ang jTablePane_admin2 kay table na diay siya
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTablePane_admin2.getModel();
        model.setRowCount(0); // Limpyohan sa una ang table
        
        while (rs.next()) {
            int id = rs.getInt("admin_id"); // 1. Kuhaon nato ang integer ID gikan sa database
            String formattedId = String.format("ADM-%03d", id); // 2. I-format kini aron mahimong adm-001, adm-002, etc.
            
            Object[] row = {
                formattedId, // 3. Gigamit na nato ang gi-format nga ID diri
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("admin_username"),
                rs.getString("admin_pin")
            };
            model.addRow(row);
        }
    } catch (java.sql.SQLException e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Error loading in the table: " + e.getMessage());
    }

}







public void loadMonthlyReportTable() {
    // SQL query aron i-group ug i-sum ang mga baligya kada buwan
    String sql = "SELECT DATE_FORMAT(created_at, '%Y-%m') AS monthly_period, "
               + "COUNT(transaction_id) AS total_transactions, "
               + "SUM(subtotal) AS monthly_subtotal, "
               + "SUM(discount) AS monthly_discount, "
               + "SUM(total) AS monthly_net_sales "
               + "FROM tbl_transactions "
               + "GROUP BY DATE_FORMAT(created_at, '%Y-%m') "
               + "ORDER BY monthly_period DESC";

    try (java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect();
         java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
         java.sql.ResultSet rs = pstmt.executeQuery()) {

        // ILISI ang 'jTable_monthly' sa eksaktong variable name sa imong Monthly Report JTable
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTablePane_admin4.getModel();
        model.setRowCount(0); 

        java.text.DecimalFormat formatter = new java.text.DecimalFormat("#,##0.00");

        while (rs.next()) {
            String monthYear = rs.getString("monthly_period");
            int transCount = rs.getInt("total_transactions");
            double subtotalSum = rs.getDouble("monthly_subtotal");
            double discountSum = rs.getDouble("monthly_discount");
            double netSalesSum = rs.getDouble("monthly_net_sales");

            model.addRow(new Object[]{
                monthYear,
                transCount,
                "₱" + formatter.format(subtotalSum),
                "₱" + formatter.format(discountSum),
                "₱" + formatter.format(netSalesSum)
            });
        }

    } catch (java.sql.SQLException e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Error loading Monthly Report: " + e.getMessage());
    }
}







 private void jTablePane_admin1MouseClicked(java.awt.event.MouseEvent evt) {                                               
                                                
    int selectedRow = jTablePane_admin1.getSelectedRow();
    if (selectedRow != -1) {
        // Kuhaon ang mga values ug i-set sa mga text fields
        jtxt_admin_staff_firstname.setText(jTablePane_admin1.getValueAt(selectedRow, 1).toString());
        jtxt_admin_staff_lastname.setText(jTablePane_admin1.getValueAt(selectedRow, 2).toString());
        jtxt_admin_staff_username.setText(jTablePane_admin1.getValueAt(selectedRow, 3).toString());
        jtxt_admin_staff_pin.setText(jTablePane_admin1.getValueAt(selectedRow, 4).toString());
        
        // I-set ang kolor sa text ngadto sa itom
        jtxt_admin_staff_firstname.setForeground(java.awt.Color.BLACK);
        jtxt_admin_staff_lastname.setForeground(java.awt.Color.BLACK);
        jtxt_admin_staff_username.setForeground(java.awt.Color.BLACK);
        jtxt_admin_staff_pin.setForeground(java.awt.Color.BLACK);
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

        jbtn_hmpgLogout = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane_admin = new javax.swing.JTabbedPane();
        jPanel_admin1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtxt_admin_staff_firstname = new javax.swing.JTextField();
        jtxt_admin_staff_lastname = new javax.swing.JTextField();
        jbtn_admin_newstaff = new javax.swing.JButton();
        jbtn_admin_updatestaff = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jbtn_adminregistraion7 = new javax.swing.JButton();
        jbtn_adminregistraion8 = new javax.swing.JButton();
        jbtn_adminregistraion9 = new javax.swing.JButton();
        jbtn_adminregistraion4 = new javax.swing.JButton();
        jbtn_adminregistraion5 = new javax.swing.JButton();
        jbtn_adminregistraion6 = new javax.swing.JButton();
        jbtn_adminregistraion1 = new javax.swing.JButton();
        jbtn_adminregistraion2 = new javax.swing.JButton();
        jbtn_adminregistraion3 = new javax.swing.JButton();
        jbtn_adminregistraion0 = new javax.swing.JButton();
        jbtn_adminregistraionCe = new javax.swing.JButton();
        jbtn_adminregistraionDel = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtxt_admin_staff_username = new javax.swing.JTextField();
        jtxt_admin_staff_pin = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePane_admin1 = new javax.swing.JTable();
        jbtn_admin_removestaff = new javax.swing.JButton();
        jPanel_admin2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePane_admin2 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jtxt_admin_firstname = new javax.swing.JTextField();
        jtxt_admin_lastname = new javax.swing.JTextField();
        jtxt_admin_username = new javax.swing.JTextField();
        jtxt_admin_password = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jbtn_adminuser7 = new javax.swing.JButton();
        jbtn_adminuser8 = new javax.swing.JButton();
        jbtn_adminuser9 = new javax.swing.JButton();
        jbtn_adminuser4 = new javax.swing.JButton();
        jbtn_adminuser5 = new javax.swing.JButton();
        jbtn_adminuser6 = new javax.swing.JButton();
        jbtn_adminuser1 = new javax.swing.JButton();
        jbtn_adminuser2 = new javax.swing.JButton();
        jbtn_adminuser3 = new javax.swing.JButton();
        jbtn_adminuser0 = new javax.swing.JButton();
        jbtn_adminuserCe = new javax.swing.JButton();
        jbtn_adminuserDel = new javax.swing.JButton();
        jbtn_admin_addadmin = new javax.swing.JButton();
        jbtn_admin_updateadmin = new javax.swing.JButton();
        jbtn_admin_removeadmin = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel_admin3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePane_admin3 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jbtn_admin_printdaily = new javax.swing.JButton();
        jbtn_admin_removedaily = new javax.swing.JButton();
        jbtn_admin_deletealldaily = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jPanel_admin4 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTablePane_admin4 = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jbtn_admin_printmonthly = new javax.swing.JButton();
        jbtn_admin_deleteallmonthly = new javax.swing.JButton();
        jbtn_admin_removemonthly = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jPanel_admin5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jbtn_admin_terminal1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel1.setBackground(new java.awt.Color(30, 32, 40));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(30, 32, 40));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 0), 5, true));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane_admin.setBackground(new java.awt.Color(102, 255, 0));
        jTabbedPane_admin.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane_admin.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane_admin.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 36)); // NOI18N

        jPanel_admin1.setBackground(new java.awt.Color(30, 32, 40));
        jPanel_admin1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("REGISTRATION:");
        jPanel_admin1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CURRENT STAFF:");
        jPanel_admin1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jPanel6.setBackground(new java.awt.Color(30, 32, 40));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 3));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("STAFF PASSWORD PIN:");

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("STAFF USERNAME:");

        jtxt_admin_staff_firstname.setBackground(new java.awt.Color(255, 255, 255));
        jtxt_admin_staff_firstname.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jtxt_admin_staff_firstname.setForeground(new java.awt.Color(0, 0, 0));

        jtxt_admin_staff_lastname.setBackground(new java.awt.Color(255, 255, 255));
        jtxt_admin_staff_lastname.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jtxt_admin_staff_lastname.setForeground(new java.awt.Color(0, 0, 0));
        jtxt_admin_staff_lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_admin_staff_lastnameActionPerformed(evt);
            }
        });

        jbtn_admin_newstaff.setBackground(new java.awt.Color(51, 153, 0));
        jbtn_admin_newstaff.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbtn_admin_newstaff.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_admin_newstaff.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\ADMIN ICONS\\icons8-admin-60.png")); // NOI18N
        jbtn_admin_newstaff.setText("ADD NEW STAFF");
        jbtn_admin_newstaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin_newstaffActionPerformed(evt);
            }
        });

        jbtn_admin_updatestaff.setBackground(new java.awt.Color(0, 153, 153));
        jbtn_admin_updatestaff.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbtn_admin_updatestaff.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_admin_updatestaff.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\ADMIN ICONS\\icons8-update-48.png")); // NOI18N
        jbtn_admin_updatestaff.setText("UPDATE STAFF ");
        jbtn_admin_updatestaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin_updatestaffActionPerformed(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(30, 32, 40));
        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 5, true));

        jbtn_adminregistraion7.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_adminregistraion7.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminregistraion7.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminregistraion7.setText("7");
        jbtn_adminregistraion7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminregistraion7ActionPerformed(evt);
            }
        });

        jbtn_adminregistraion8.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_adminregistraion8.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminregistraion8.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminregistraion8.setText("8");
        jbtn_adminregistraion8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminregistraion8ActionPerformed(evt);
            }
        });

        jbtn_adminregistraion9.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_adminregistraion9.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminregistraion9.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminregistraion9.setText("9");
        jbtn_adminregistraion9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminregistraion9ActionPerformed(evt);
            }
        });

        jbtn_adminregistraion4.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_adminregistraion4.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminregistraion4.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminregistraion4.setText("4");
        jbtn_adminregistraion4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminregistraion4ActionPerformed(evt);
            }
        });

        jbtn_adminregistraion5.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_adminregistraion5.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminregistraion5.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminregistraion5.setText("5");
        jbtn_adminregistraion5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminregistraion5ActionPerformed(evt);
            }
        });

        jbtn_adminregistraion6.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_adminregistraion6.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminregistraion6.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminregistraion6.setText("6");
        jbtn_adminregistraion6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminregistraion6ActionPerformed(evt);
            }
        });

        jbtn_adminregistraion1.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_adminregistraion1.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminregistraion1.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminregistraion1.setText("1");
        jbtn_adminregistraion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminregistraion1ActionPerformed(evt);
            }
        });

        jbtn_adminregistraion2.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_adminregistraion2.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminregistraion2.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminregistraion2.setText("2");
        jbtn_adminregistraion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminregistraion2ActionPerformed(evt);
            }
        });

        jbtn_adminregistraion3.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_adminregistraion3.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminregistraion3.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminregistraion3.setText("3");
        jbtn_adminregistraion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminregistraion3ActionPerformed(evt);
            }
        });

        jbtn_adminregistraion0.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_adminregistraion0.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminregistraion0.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminregistraion0.setText("0");
        jbtn_adminregistraion0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminregistraion0ActionPerformed(evt);
            }
        });

        jbtn_adminregistraionCe.setBackground(new java.awt.Color(255, 255, 0));
        jbtn_adminregistraionCe.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminregistraionCe.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminregistraionCe.setText("CE");
        jbtn_adminregistraionCe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminregistraionCeActionPerformed(evt);
            }
        });

        jbtn_adminregistraionDel.setBackground(new java.awt.Color(204, 0, 0));
        jbtn_adminregistraionDel.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminregistraionDel.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminregistraionDel.setText("DEL");
        jbtn_adminregistraionDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminregistraionDelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jbtn_adminregistraion7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtn_adminregistraion8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtn_adminregistraion9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jbtn_adminregistraion4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtn_adminregistraion5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jbtn_adminregistraion1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtn_adminregistraionCe, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbtn_adminregistraion0, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtn_adminregistraion2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtn_adminregistraion3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtn_adminregistraion6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtn_adminregistraionDel, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtn_adminregistraion7, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(jbtn_adminregistraion8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_adminregistraion9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtn_adminregistraion5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jbtn_adminregistraion4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_adminregistraion6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtn_adminregistraion1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(jbtn_adminregistraion3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_adminregistraion2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtn_adminregistraionDel, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(jbtn_adminregistraionCe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn_adminregistraion0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("STAFF LAST NAME:");

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("STAFF FIRST NAME:");

        jtxt_admin_staff_username.setBackground(new java.awt.Color(255, 255, 255));
        jtxt_admin_staff_username.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jtxt_admin_staff_username.setForeground(new java.awt.Color(0, 0, 0));

        jtxt_admin_staff_pin.setBackground(new java.awt.Color(255, 255, 255));
        jtxt_admin_staff_pin.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jtxt_admin_staff_pin.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxt_admin_staff_firstname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxt_admin_staff_lastname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxt_admin_staff_username, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jtxt_admin_staff_pin, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtn_admin_newstaff, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jbtn_admin_updatestaff, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jtxt_admin_staff_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxt_admin_staff_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_admin_staff_username, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxt_admin_staff_pin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(55, 55, 55)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jbtn_admin_newstaff, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jbtn_admin_updatestaff, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(59, Short.MAX_VALUE))))
        );

        jPanel_admin1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 560, 640));

        jPanel13.setBackground(new java.awt.Color(30, 32, 40));
        jPanel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 3, true));

        jTablePane_admin1.setBackground(new java.awt.Color(30, 32, 40));
        jTablePane_admin1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0), 5));
        jTablePane_admin1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        jTablePane_admin1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " ID", " FIRSTNAME", " LASTNAME", " USERNAME", " PASSWORD "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTablePane_admin1);

        jbtn_admin_removestaff.setBackground(new java.awt.Color(204, 0, 0));
        jbtn_admin_removestaff.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jbtn_admin_removestaff.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_admin_removestaff.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\ADMIN ICONS\\icons8-fired-96.png")); // NOI18N
        jbtn_admin_removestaff.setText("REMOVE STAFF RECORDS");
        jbtn_admin_removestaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin_removestaffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_admin_removestaff, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jbtn_admin_removestaff)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jPanel_admin1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 470, 640));

        jTabbedPane_admin.addTab("REGISTRATION", jPanel_admin1);

        jPanel_admin2.setBackground(new java.awt.Color(30, 32, 40));
        jPanel_admin2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(30, 32, 40));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 5));

        jTablePane_admin2.setBackground(new java.awt.Color(30, 32, 40));
        jTablePane_admin2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0), 5));
        jTablePane_admin2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        jTablePane_admin2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ADMIN ID", "ADMIN FIRST NAME", "ADMIN LAST NAME", "ADMIN USERNAME", "ADMIN PASSWORD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTablePane_admin2);

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("CURRENT ADMIN:");

        jPanel3.setBackground(new java.awt.Color(30, 32, 40));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 5));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText(" ADMIN FIRSTNAME:");

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText(" ADMIN LASTNAME:");

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText(" ADMIN USERNAME:");

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText(" ADMIN PASSWORD:");

        jtxt_admin_firstname.setBackground(new java.awt.Color(255, 255, 255));
        jtxt_admin_firstname.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jtxt_admin_firstname.setForeground(new java.awt.Color(0, 0, 0));

        jtxt_admin_lastname.setBackground(new java.awt.Color(255, 255, 255));
        jtxt_admin_lastname.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jtxt_admin_lastname.setForeground(new java.awt.Color(0, 0, 0));
        jtxt_admin_lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_admin_lastnameActionPerformed(evt);
            }
        });

        jtxt_admin_username.setBackground(new java.awt.Color(255, 255, 255));
        jtxt_admin_username.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jtxt_admin_username.setForeground(new java.awt.Color(0, 0, 0));

        jtxt_admin_password.setBackground(new java.awt.Color(255, 255, 255));
        jtxt_admin_password.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jtxt_admin_password.setForeground(new java.awt.Color(0, 0, 0));

        jPanel16.setBackground(new java.awt.Color(30, 32, 40));
        jPanel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 5, true));

        jbtn_adminuser7.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_adminuser7.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminuser7.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminuser7.setText("7");
        jbtn_adminuser7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminuser7ActionPerformed(evt);
            }
        });

        jbtn_adminuser8.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_adminuser8.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminuser8.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminuser8.setText("8");
        jbtn_adminuser8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminuser8ActionPerformed(evt);
            }
        });

        jbtn_adminuser9.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_adminuser9.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminuser9.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminuser9.setText("9");
        jbtn_adminuser9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminuser9ActionPerformed(evt);
            }
        });

        jbtn_adminuser4.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_adminuser4.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminuser4.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminuser4.setText("4");
        jbtn_adminuser4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminuser4ActionPerformed(evt);
            }
        });

        jbtn_adminuser5.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_adminuser5.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminuser5.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminuser5.setText("5");
        jbtn_adminuser5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminuser5ActionPerformed(evt);
            }
        });

        jbtn_adminuser6.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_adminuser6.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminuser6.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminuser6.setText("6");
        jbtn_adminuser6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminuser6ActionPerformed(evt);
            }
        });

        jbtn_adminuser1.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_adminuser1.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminuser1.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminuser1.setText("1");
        jbtn_adminuser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminuser1ActionPerformed(evt);
            }
        });

        jbtn_adminuser2.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_adminuser2.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminuser2.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminuser2.setText("2");
        jbtn_adminuser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminuser2ActionPerformed(evt);
            }
        });

        jbtn_adminuser3.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_adminuser3.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminuser3.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminuser3.setText("3");
        jbtn_adminuser3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminuser3ActionPerformed(evt);
            }
        });

        jbtn_adminuser0.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_adminuser0.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminuser0.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminuser0.setText("0");
        jbtn_adminuser0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminuser0ActionPerformed(evt);
            }
        });

        jbtn_adminuserCe.setBackground(new java.awt.Color(255, 255, 0));
        jbtn_adminuserCe.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminuserCe.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminuserCe.setText("CE");
        jbtn_adminuserCe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminuserCeActionPerformed(evt);
            }
        });

        jbtn_adminuserDel.setBackground(new java.awt.Color(204, 0, 0));
        jbtn_adminuserDel.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        jbtn_adminuserDel.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_adminuserDel.setText("DEL");
        jbtn_adminuserDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_adminuserDelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jbtn_adminuser7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtn_adminuser8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtn_adminuser9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jbtn_adminuser4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtn_adminuser5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtn_adminuser6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jbtn_adminuser1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtn_adminuser2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtn_adminuser3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jbtn_adminuserCe, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtn_adminuser0, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtn_adminuserDel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_adminuser7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_adminuser8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_adminuser9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_adminuser4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_adminuser5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_adminuser6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_adminuser2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_adminuser1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_adminuser3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtn_adminuserDel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtn_adminuser0, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbtn_adminuserCe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jbtn_admin_addadmin.setBackground(new java.awt.Color(51, 153, 0));
        jbtn_admin_addadmin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jbtn_admin_addadmin.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_admin_addadmin.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\ADMIN ICONS\\icons8-addadmin-96.png")); // NOI18N
        jbtn_admin_addadmin.setText("ADD ADMIN");
        jbtn_admin_addadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin_addadminActionPerformed(evt);
            }
        });

        jbtn_admin_updateadmin.setBackground(new java.awt.Color(0, 153, 153));
        jbtn_admin_updateadmin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jbtn_admin_updateadmin.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_admin_updateadmin.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\ADMIN ICONS\\icons8-adminupdate-96.png")); // NOI18N
        jbtn_admin_updateadmin.setText("UPDATE ADMIN");
        jbtn_admin_updateadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin_updateadminActionPerformed(evt);
            }
        });

        jbtn_admin_removeadmin.setBackground(new java.awt.Color(204, 0, 0));
        jbtn_admin_removeadmin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jbtn_admin_removeadmin.setForeground(new java.awt.Color(0, 0, 0));
        jbtn_admin_removeadmin.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\ADMIN ICONS\\icons8-remove-administrator-96.png")); // NOI18N
        jbtn_admin_removeadmin.setText("REMOVE ADMIN");
        jbtn_admin_removeadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin_removeadminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxt_admin_password, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jtxt_admin_firstname)
                    .addComponent(jtxt_admin_lastname)
                    .addComponent(jtxt_admin_username))
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtn_admin_updateadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_admin_removeadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_admin_addadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addGap(9, 9, 9)
                            .addComponent(jtxt_admin_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel18)
                            .addGap(9, 9, 9)
                            .addComponent(jtxt_admin_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtxt_admin_username, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel21)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtxt_admin_password, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jbtn_admin_addadmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtn_admin_updateadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtn_admin_removeadmin)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_admin2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1020, 600));

        jLabel14.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 48)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("MONDARTE THRIFT STORE");
        jPanel_admin2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\ADMIN ICONS\\icons8-admin-100.png")); // NOI18N
        jPanel_admin2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 99));

        jLabel16.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 48)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("ADMIN:");
        jPanel_admin2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        jTabbedPane_admin.addTab("ADMIN USERS", jPanel_admin2);

        jPanel_admin3.setBackground(new java.awt.Color(30, 32, 40));
        jPanel_admin3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(30, 32, 40));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 3));

        jTablePane_admin3.setBackground(new java.awt.Color(30, 32, 40));
        jTablePane_admin3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0), 5));
        jTablePane_admin3.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        jTablePane_admin3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RECEIPT ID", "DATE", "TIME", "DAY", "STAFF USERNAME", "SUBTOTAL", "DISCOUNT", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTablePane_admin3);

        jPanel9.setBackground(new java.awt.Color(30, 32, 40));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 5));

        jbtn_admin_printdaily.setBackground(new java.awt.Color(51, 153, 0));
        jbtn_admin_printdaily.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jbtn_admin_printdaily.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_admin_printdaily.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\MAIN TERMINALBUTTONS\\printicon96px.png")); // NOI18N
        jbtn_admin_printdaily.setText("PRINT DAILY REPORT");
        jbtn_admin_printdaily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin_printdailyActionPerformed(evt);
            }
        });

        jbtn_admin_removedaily.setBackground(new java.awt.Color(204, 0, 0));
        jbtn_admin_removedaily.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jbtn_admin_removedaily.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_admin_removedaily.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\MAIN TERMINALBUTTONS\\removeicon96px.png")); // NOI18N
        jbtn_admin_removedaily.setText("REMOVE DAILY LOG");
        jbtn_admin_removedaily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin_removedailyActionPerformed(evt);
            }
        });

        jbtn_admin_deletealldaily.setBackground(new java.awt.Color(204, 0, 0));
        jbtn_admin_deletealldaily.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jbtn_admin_deletealldaily.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_admin_deletealldaily.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\ADMIN ICONS\\icons8-dailyremove-96.png")); // NOI18N
        jbtn_admin_deletealldaily.setText("DELETE ALL  LOGS");
        jbtn_admin_deletealldaily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin_deletealldailyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jbtn_admin_removedaily, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtn_admin_deletealldaily, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(jbtn_admin_printdaily, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jbtn_admin_printdaily)
                .addGap(32, 32, 32)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_admin_deletealldaily)
                    .addComponent(jbtn_admin_removedaily, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1019, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_admin3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1040, 650));

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("DAILY LOGS:");
        jPanel_admin3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTabbedPane_admin.addTab("DAILY REPORT", jPanel_admin3);

        jPanel_admin4.setBackground(new java.awt.Color(30, 32, 40));
        jPanel_admin4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setBackground(new java.awt.Color(30, 32, 40));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 3));

        jTablePane_admin4.setBackground(new java.awt.Color(30, 32, 40));
        jTablePane_admin4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0), 5));
        jTablePane_admin4.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 18)); // NOI18N
        jTablePane_admin4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MONTH/YEAR", "TOTAL TRANS", "TOTAL SUBTOTAL", "TOTAL DISCOUNT", "TOTAL SALES"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTablePane_admin4);

        jPanel18.setBackground(new java.awt.Color(30, 32, 40));
        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 5));
        jPanel18.setForeground(new java.awt.Color(255, 255, 255));

        jbtn_admin_printmonthly.setBackground(new java.awt.Color(51, 153, 0));
        jbtn_admin_printmonthly.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jbtn_admin_printmonthly.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_admin_printmonthly.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\MAIN TERMINALBUTTONS\\printicon96px.png")); // NOI18N
        jbtn_admin_printmonthly.setText("PRINT MONTHLY REPORT");
        jbtn_admin_printmonthly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin_printmonthlyActionPerformed(evt);
            }
        });

        jbtn_admin_deleteallmonthly.setBackground(new java.awt.Color(204, 0, 0));
        jbtn_admin_deleteallmonthly.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jbtn_admin_deleteallmonthly.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_admin_deleteallmonthly.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\ADMIN ICONS\\icons8-dailyremove-96.png")); // NOI18N
        jbtn_admin_deleteallmonthly.setText("DELETE ALL  REPORT");
        jbtn_admin_deleteallmonthly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin_deleteallmonthlyActionPerformed(evt);
            }
        });

        jbtn_admin_removemonthly.setBackground(new java.awt.Color(204, 0, 0));
        jbtn_admin_removemonthly.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jbtn_admin_removemonthly.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_admin_removemonthly.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\MAIN TERMINALBUTTONS\\removeicon96px.png")); // NOI18N
        jbtn_admin_removemonthly.setText("REMOVE MOTHLY REPORT ");
        jbtn_admin_removemonthly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin_removemonthlyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtn_admin_deleteallmonthly, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jbtn_admin_removemonthly)
                .addGap(30, 30, 30))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jbtn_admin_printmonthly, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jbtn_admin_printmonthly)
                .addGap(31, 31, 31)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_admin_removemonthly, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_admin_deleteallmonthly))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1002, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_admin4.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1030, 650));

        jLabel22.setBackground(new java.awt.Color(0, 0, 0));
        jLabel22.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("MONTHLY REPORT:");
        jPanel_admin4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTabbedPane_admin.addTab("MONTHLY REPORT", jPanel_admin4);

        jPanel_admin5.setBackground(new java.awt.Color(30, 32, 40));
        jPanel_admin5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(30, 32, 40));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 3));

        jPanel11.setBackground(new java.awt.Color(30, 32, 40));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 10));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\ADMIN ICONS\\icons8-lock-144.png")); // NOI18N
        jLabel17.setText("ADMIN MODE ACCESS");

        jPanel15.setBackground(new java.awt.Color(102, 102, 102));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 5));

        jbtn_admin_terminal1.setBackground(new java.awt.Color(51, 153, 0));
        jbtn_admin_terminal1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jbtn_admin_terminal1.setForeground(new java.awt.Color(255, 255, 255));
        jbtn_admin_terminal1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\ADMIN ICONS\\icons8-panel-100.png")); // NOI18N
        jbtn_admin_terminal1.setText("OPEN MAIN POS TERMINAL TO UPDATE PRODUCTS");
        jbtn_admin_terminal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_admin_terminal1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtn_admin_terminal1, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jbtn_admin_terminal1)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel_admin5.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1040, 630));

        jTabbedPane_admin.addTab("POS TERMINAL", jPanel_admin5);

        jPanel5.add(jTabbedPane_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 710));
        jTabbedPane_admin.getAccessibleContext().setAccessibleName("REGISTRATION");

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 720));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 1340, 730));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kinston\\Pictures\\JAVA THRIF STORE POINT OF SALE SYSTEM\\MONDARTE THRIFT STORE\\LOGO ADMIN PANEL.png")); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 120));

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

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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


    private void clearStaffFields() {
    jtxt_admin_staff_firstname.setText("");
    jtxt_admin_staff_lastname.setText("");
    jtxt_admin_staff_username.setText("");
    jtxt_admin_staff_pin.setText("Enter 4 Digit Pin");
    jtxt_admin_staff_pin.setForeground(new java.awt.Color(153, 153, 153));
    
    // Kung naay gipili sa table, i-clear sab ang selection
    jTablePane_admin1.clearSelection();
}
    
    
    private void jbtn_admin_newstaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin_newstaffActionPerformed
  String firstName = jtxt_admin_staff_firstname.getText().trim();
String lastName = jtxt_admin_staff_lastname.getText().trim();
String username = jtxt_admin_staff_username.getText().trim().toLowerCase();
String pin = jtxt_admin_staff_pin.getText().trim();

// 1. Validation: Susiha kung naay walay sulod
if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || pin.isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(this, "Please Input all fields!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

// 2. Validation para sa Placeholders
if (firstName.startsWith("Enter") || lastName.startsWith("Enter") || username.startsWith("Enter") || pin.startsWith("Enter")) {
    javax.swing.JOptionPane.showMessageDialog(this, "Please Input all fields with Information!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

// 3. Validation sa Firstname ug Lastname (Dapat letters lamang)
if (!firstName.matches("[a-zA-ZñÑ\\s]+") || !lastName.matches("[a-zA-ZñÑ\\s]+")) {
    javax.swing.JOptionPane.showMessageDialog(this, "The Firstname and Lastname must be the same and No Number included!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

// DILI PWEDE MAGPAREHO ANG FIRSTNAME OG LASTNAME
if (firstName.equalsIgnoreCase(lastName)) {
    javax.swing.JOptionPane.showMessageDialog(this, "The Firstname and Lastname cannot be the same!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

// 4. Validation sa Username (Dapat naay letters UG naay numbers apil, 4-20 characters, walay space)
if (!username.matches("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z0-9]{4,20}$")) {
    javax.swing.JOptionPane.showMessageDialog(this, "The Username must be 20 characters with combination of Letter and Numbers!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

// 5. Validation sa PIN (Dapat eksaktong 4 ka numero lamang)
if (!pin.matches("\\d{4}")) {
    javax.swing.JOptionPane.showMessageDialog(this, "The PIN must be exactly 4 Numbers only!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

try (java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect()) {
    
    // 6. Duplicate Username Check sa Database
    String checkSql = "SELECT * FROM tbl_staff_info WHERE LOWER(username) = ?";
try (java.sql.PreparedStatement checkPst = con.prepareStatement(checkSql)) {
    checkPst.setString(1, username); // Ang username variable nimo kay naka-lowercased na daan gikan sa taas (.toLowerCase())
    try (java.sql.ResultSet rs = checkPst.executeQuery()) {
        if (rs.next()) {
            javax.swing.JOptionPane.showMessageDialog(this, "This username is already exist cannot be duplicated!", "DUPLICATE ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}

    // SQL Query para sa pag-insert ngadto sa database
    String sql = "INSERT INTO tbl_staff_info (first_name, last_name, username, pin, role) VALUES (?, ?, ?, ?, 'STAFF')";

    try (java.sql.PreparedStatement pst = con.prepareStatement(sql)) {
        pst.setString(1, firstName);
        pst.setString(2, lastName);
        pst.setString(3, username); 
        pst.setString(4, pin);

        int rowsInserted = pst.executeUpdate();
        if (rowsInserted > 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "New staff has been added!", "SUCCESS", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            loadStaffData(); // I-refresh ang table display
            
            jtxt_admin_staff_firstname.setText("");
            jtxt_admin_staff_lastname.setText("");
            jtxt_admin_staff_username.setText("");
            jtxt_admin_staff_pin.setText("Enter 4 Digit Pin");
            jtxt_admin_staff_pin.setForeground(new java.awt.Color(153, 153, 153));
        }
    }
} catch (java.sql.SQLException e) {
    e.printStackTrace();
    javax.swing.JOptionPane.showMessageDialog(this, "Error adding staff: " + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
}
     

    }//GEN-LAST:event_jbtn_admin_newstaffActionPerformed

    private void jbtn_admin_removestaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin_removestaffActionPerformed
   int selectedRow = jTablePane_admin1.getSelectedRow();

if (selectedRow == -1) {
    javax.swing.JOptionPane.showMessageDialog(this, "Please choose a staff you want to remove from the table!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to remove this staff record?", "CONFIRM DELETE", javax.swing.JOptionPane.YES_NO_OPTION);
if (confirm != javax.swing.JOptionPane.YES_OPTION) {
    return;
}

// Kuhaa ang username ug i-trim para mawala ang extra spaces
String usernameToDelete = jTablePane_admin1.getValueAt(selectedRow, 3).toString().trim();

try (java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect()) {
    
    // 1. I-check una kung 1 na lang ka staff ang nabilin aron dili ma-zero ang sistema
    String sqlCount = "SELECT COUNT(*) FROM tbl_staff_info";
    try (java.sql.PreparedStatement pstCount = con.prepareStatement(sqlCount);
         java.sql.ResultSet rsCount = pstCount.executeQuery()) {
        if (rsCount.next()) {
            int totalStaff = rsCount.getInt(1);
            if (totalStaff <= 1) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Not allowed atleast one existing backup account for POS terminal!", 
                    "CANNOT DELETE", javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
    }

    // 2. Ilisi ang 'username' sa saktong column name sa imong database kung laing pangalan niya (e.g., admin_username)
    String sql = "DELETE FROM tbl_staff_info WHERE username = ?";
    
    try (java.sql.PreparedStatement pst = con.prepareStatement(sql)) {
        pst.setString(1, usernameToDelete);
        
        int rowsDeleted = pst.executeUpdate();
        if (rowsDeleted > 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Successfully removed staff record!", "SUCCESS", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            loadStaffData(); 
            clearStaffFields(); 
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "No record same for username: " + usernameToDelete, "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }
} catch (java.sql.SQLException e) {
    e.printStackTrace();
    javax.swing.JOptionPane.showMessageDialog(this, "Error for removing staff: " + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
// I-clear ang mga text fields
      
   
    
    }//GEN-LAST:event_jbtn_admin_removestaffActionPerformed


    }
    
    
    private void jbtn_admin_updatestaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin_updatestaffActionPerformed
   int selectedRow = jTablePane_admin1.getSelectedRow();
if (selectedRow == -1) {
    javax.swing.JOptionPane.showMessageDialog(this, "Please choose a staff to update from the table!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

String formattedStaffId = jTablePane_admin1.getValueAt(selectedRow, 0).toString();

String inputFirstName = jtxt_admin_staff_firstname.getText().trim();
String inputLastName = jtxt_admin_staff_lastname.getText().trim();
String inputUsername = jtxt_admin_staff_username.getText().trim().toLowerCase();
String inputPin = jtxt_admin_staff_pin.getText().trim();

if (inputFirstName.isEmpty() && inputLastName.isEmpty() && inputUsername.isEmpty() && inputPin.isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(this, "Please Input all fields to update!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

if (inputFirstName.startsWith("Enter") || 
    inputLastName.startsWith("Enter") || 
    inputUsername.startsWith("Enter") || 
    inputPin.startsWith("Enter")) {
    javax.swing.JOptionPane.showMessageDialog(this, "Please Input All Fields with Information!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

// Validation sa Firstname ug Lastname kung giusab (Letters lamang)
if ((!inputFirstName.isEmpty() && !inputFirstName.matches("[a-zA-ZñÑ\\s]+")) || 
    (!inputLastName.isEmpty() && !inputLastName.matches("[a-zA-ZñÑ\\s]+"))) {
    javax.swing.JOptionPane.showMessageDialog(this, "The Firstname and Lastname must be letters!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

// Validation sa Username kung giusab (4-20 chars, letters ug numbers)
if (!inputUsername.isEmpty() && !inputUsername.matches("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z0-9]{4,20}$")) {
    javax.swing.JOptionPane.showMessageDialog(this, "The Username must be 20 characters with combination of Letter and Numbers!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

// Validation sa PIN kung giusab (Eksaktong 4 ka numero)
if (!inputPin.isEmpty() && !inputPin.matches("\\d{4}")) {
    javax.swing.JOptionPane.showMessageDialog(this, "The PIN must be exactly 4 Numbers only!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

// Kuhaon ang daang data gikan sa table columns
String currentFirstName = jTablePane_admin1.getValueAt(selectedRow, 1).toString();
String currentLastName = jTablePane_admin1.getValueAt(selectedRow, 2).toString();
String currentUsername = jTablePane_admin1.getValueAt(selectedRow, 3).toString();
String currentPin = jTablePane_admin1.getValueAt(selectedRow, 4).toString();

// Partial update logic: Kung blangko ang gi-input, gamiton ang daang data
String firstName = inputFirstName.isEmpty() ? currentFirstName : inputFirstName;
String lastName = inputLastName.isEmpty() ? currentLastName : inputLastName;
String username = inputUsername.isEmpty() ? currentUsername : inputUsername;
String pin = inputPin.isEmpty() ? currentPin : inputPin;

try {
    String numericIdStr = formattedStaffId.replaceAll("[^0-9]", "");
    int staffId = Integer.parseInt(numericIdStr);

    // I-check ang duplicate kung giusab ang username
    if (!inputUsername.isEmpty() && !inputUsername.equals(currentUsername)) {
        String checkSql = "SELECT * FROM tbl_staff_info WHERE username = ?";
        try (java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect();
             java.sql.PreparedStatement checkPst = con.prepareStatement(checkSql)) {
            checkPst.setString(1, username);
            try (java.sql.ResultSet rs = checkPst.executeQuery()) {
                if (rs.next()) {
                    javax.swing.JOptionPane.showMessageDialog(this, "This username is used by another credentials please create a unique one!", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
    }

    String sql = "UPDATE tbl_staff_info SET first_name = ?, last_name = ?, username = ?, pin = ? WHERE user_id = ?";

    try (java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect();
         java.sql.PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setString(1, firstName);
        pst.setString(2, lastName);
        pst.setString(3, username);
        pst.setString(4, pin);
        pst.setInt(5, staffId);

        int rowsUpdated = pst.executeUpdate();

        if (rowsUpdated > 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Successfully Updated record staff!", "SUCCESS", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            loadStaffData(); // I-refresh ang table display
            
            // I-clear ang fields
            jtxt_admin_staff_firstname.setText("");
            jtxt_admin_staff_lastname.setText("");
            jtxt_admin_staff_username.setText("");
            jtxt_admin_staff_pin.setText("Enter 4 Digit Pin");
            jtxt_admin_staff_pin.setForeground(new java.awt.Color(153, 153, 153));
        }
    }
} catch (NumberFormatException | java.sql.SQLException e) {
    e.printStackTrace();
    javax.swing.JOptionPane.showMessageDialog(this, "Error for updating: " + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
}



   

    
    
    
                                                     
   
    }//GEN-LAST:event_jbtn_admin_updatestaffActionPerformed

    private void jbtn_adminregistraion7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminregistraion7ActionPerformed
        if (jtxt_admin_staff_pin.getText().equals("Enter 4 Digit Pin")) {
    jtxt_admin_staff_pin.setText("");
}
jtxt_admin_staff_pin.setForeground(java.awt.Color.BLACK); 
jtxt_admin_staff_pin.setText(jtxt_admin_staff_pin.getText() + "7");
    
    }//GEN-LAST:event_jbtn_adminregistraion7ActionPerformed

    private void jbtn_adminregistraion8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminregistraion8ActionPerformed
        if (jtxt_admin_staff_pin.getText().equals("Enter 4 Digit Pin")) {
    jtxt_admin_staff_pin.setText("");
}
jtxt_admin_staff_pin.setForeground(java.awt.Color.BLACK); 
jtxt_admin_staff_pin.setText(jtxt_admin_staff_pin.getText() + "8");


    }//GEN-LAST:event_jbtn_adminregistraion8ActionPerformed

    private void jbtn_adminregistraion9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminregistraion9ActionPerformed
       if (jtxt_admin_staff_pin.getText().equals("Enter 4 Digit Pin")) {
    jtxt_admin_staff_pin.setText("");
}
jtxt_admin_staff_pin.setForeground(java.awt.Color.BLACK); 
jtxt_admin_staff_pin.setText(jtxt_admin_staff_pin.getText() + "9");
    }//GEN-LAST:event_jbtn_adminregistraion9ActionPerformed

    private void jbtn_adminregistraion4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminregistraion4ActionPerformed
        if (jtxt_admin_staff_pin.getText().equals("Enter 4 Digit Pin")) {
    jtxt_admin_staff_pin.setText("");
}
jtxt_admin_staff_pin.setForeground(java.awt.Color.BLACK); 
jtxt_admin_staff_pin.setText(jtxt_admin_staff_pin.getText() + "4");
    }//GEN-LAST:event_jbtn_adminregistraion4ActionPerformed

    private void jbtn_adminregistraion5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminregistraion5ActionPerformed
        if (jtxt_admin_staff_pin.getText().equals("Enter 4 Digit Pin")) {
    jtxt_admin_staff_pin.setText("");
}
jtxt_admin_staff_pin.setForeground(java.awt.Color.BLACK); 
jtxt_admin_staff_pin.setText(jtxt_admin_staff_pin.getText() + "5");
    }//GEN-LAST:event_jbtn_adminregistraion5ActionPerformed

    private void jbtn_adminregistraion6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminregistraion6ActionPerformed
       if (jtxt_admin_staff_pin.getText().equals("Enter 4 Digit Pin")) {
    jtxt_admin_staff_pin.setText("");
}
jtxt_admin_staff_pin.setForeground(java.awt.Color.BLACK); 
jtxt_admin_staff_pin.setText(jtxt_admin_staff_pin.getText() + "6");
     
    }//GEN-LAST:event_jbtn_adminregistraion6ActionPerformed

    private void jbtn_adminregistraion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminregistraion1ActionPerformed
        if (jtxt_admin_staff_pin.getText().equals("Enter 4 Digit Pin")) {
    jtxt_admin_staff_pin.setText("");
}
jtxt_admin_staff_pin.setForeground(java.awt.Color.BLACK); 
jtxt_admin_staff_pin.setText(jtxt_admin_staff_pin.getText() + "1");
     
    }//GEN-LAST:event_jbtn_adminregistraion1ActionPerformed

    private void jbtn_adminregistraion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminregistraion2ActionPerformed
        if (jtxt_admin_staff_pin.getText().equals("Enter 4 Digit Pin")) {
    jtxt_admin_staff_pin.setText("");
}
jtxt_admin_staff_pin.setForeground(java.awt.Color.BLACK); 
jtxt_admin_staff_pin.setText(jtxt_admin_staff_pin.getText() + "2");
     
    }//GEN-LAST:event_jbtn_adminregistraion2ActionPerformed

    private void jbtn_adminregistraion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminregistraion3ActionPerformed
        if (jtxt_admin_staff_pin.getText().equals("Enter 4 Digit Pin")) {
    jtxt_admin_staff_pin.setText("");
}
jtxt_admin_staff_pin.setForeground(java.awt.Color.BLACK); 
jtxt_admin_staff_pin.setText(jtxt_admin_staff_pin.getText() + "3");
    
    }//GEN-LAST:event_jbtn_adminregistraion3ActionPerformed

    private void jbtn_adminregistraion0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminregistraion0ActionPerformed
        if (jtxt_admin_staff_pin.getText().equals("Enter 4 Digit Pin")) {
    jtxt_admin_staff_pin.setText("");
}
jtxt_admin_staff_pin.setForeground(java.awt.Color.BLACK); 
jtxt_admin_staff_pin.setText(jtxt_admin_staff_pin.getText() + "0");
    
    }//GEN-LAST:event_jbtn_adminregistraion0ActionPerformed

    private void jbtn_adminregistraionCeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminregistraionCeActionPerformed
    jtxt_admin_staff_pin.setText("Enter 4 Digit Pin");
jtxt_admin_staff_pin.setForeground(new java.awt.Color(153, 153, 153));

    }//GEN-LAST:event_jbtn_adminregistraionCeActionPerformed

    private void jbtn_adminregistraionDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminregistraionDelActionPerformed
   String currentPin = jtxt_admin_staff_pin.getText();

// Kung dili pa placeholder ug naay sulod, tangtangon ang pinakalisud sa tuo
if (!currentPin.equals("Enter 4 Digit Pin") && !currentPin.isEmpty()) {
    if (currentPin.length() > 1) {
        jtxt_admin_staff_pin.setText(currentPin.substring(0, currentPin.length() - 1));
    } else {
        // Kung nahabilin nalang ug isa ka digit ug gi-delete, ibalik sa placeholder
        jtxt_admin_staff_pin.setText("Enter 4 Digit Pin");
        jtxt_admin_staff_pin.setForeground(new java.awt.Color(153, 153, 153));
    }
}

    }//GEN-LAST:event_jbtn_adminregistraionDelActionPerformed

    private void jbtn_admin_terminal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin_terminal1ActionPerformed
        int choice = JOptionPane.showConfirmDialog(
            this,"Are you sure you want to Go to Main Terminal?",
            "Confirmation",JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);

        if (choice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Entering Main Terminal");
            new Pos_admin2().setVisible(true);
            this.dispose();

        } else if (choice == JOptionPane.NO_OPTION) {

        }
    
    }//GEN-LAST:event_jbtn_admin_terminal1ActionPerformed

    private void jbtn_adminuser7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminuser7ActionPerformed
        if (jtxt_admin_password.getText().equals("Enter 4 Digit Pin")) {
    jtxt_admin_password.setText("");
    jtxt_admin_password.setForeground(java.awt.Color.BLACK);
}
jtxt_admin_password.setText(jtxt_admin_password.getText() + "7");

    }//GEN-LAST:event_jbtn_adminuser7ActionPerformed

    private void jbtn_adminuser8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminuser8ActionPerformed
        if (jtxt_admin_password.getText().equals("Enter 4 Digit Pin")) {
    jtxt_admin_password.setText("");
    jtxt_admin_password.setForeground(java.awt.Color.BLACK);
}
jtxt_admin_password.setText(jtxt_admin_password.getText() + "8");
    }//GEN-LAST:event_jbtn_adminuser8ActionPerformed

    private void jbtn_adminuser9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminuser9ActionPerformed
        if (jtxt_admin_password.getText().equals("Enter 4 Digit Pin")) {
    jtxt_admin_password.setText("");
    jtxt_admin_password.setForeground(java.awt.Color.BLACK);
}
jtxt_admin_password.setText(jtxt_admin_password.getText() + "9");


    }//GEN-LAST:event_jbtn_adminuser9ActionPerformed

    private void jbtn_adminuser4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminuser4ActionPerformed
        if (jtxt_admin_password.getText().equals("Enter 4 Digit Pin")) {
    jtxt_admin_password.setText("");
    jtxt_admin_password.setForeground(java.awt.Color.BLACK);
}
jtxt_admin_password.setText(jtxt_admin_password.getText() + "4");
    }//GEN-LAST:event_jbtn_adminuser4ActionPerformed

    private void jbtn_adminuser5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminuser5ActionPerformed
        if (jtxt_admin_password.getText().equals("Enter 4 Digit Pin")) {
    jtxt_admin_password.setText("");
    jtxt_admin_password.setForeground(java.awt.Color.BLACK);
}
jtxt_admin_password.setText(jtxt_admin_password.getText() + "5");
    }//GEN-LAST:event_jbtn_adminuser5ActionPerformed

    private void jbtn_adminuser6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminuser6ActionPerformed
        if (jtxt_admin_password.getText().equals("Enter 4 Digit Pin")) {
    jtxt_admin_password.setText("");
    jtxt_admin_password.setForeground(java.awt.Color.BLACK);
}
jtxt_admin_password.setText(jtxt_admin_password.getText() + "6");
    }//GEN-LAST:event_jbtn_adminuser6ActionPerformed

    private void jbtn_adminuser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminuser1ActionPerformed
        if (jtxt_admin_password.getText().equals("Enter 4 Digit Pin")) {
    jtxt_admin_password.setText("");
    jtxt_admin_password.setForeground(java.awt.Color.BLACK);
}
jtxt_admin_password.setText(jtxt_admin_password.getText() + "1");
    }//GEN-LAST:event_jbtn_adminuser1ActionPerformed

    private void jbtn_adminuser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminuser2ActionPerformed
        if (jtxt_admin_password.getText().equals("Enter 4 Digit Pin")) {
    jtxt_admin_password.setText("");
    jtxt_admin_password.setForeground(java.awt.Color.BLACK);
}
jtxt_admin_password.setText(jtxt_admin_password.getText() + "2");
    }//GEN-LAST:event_jbtn_adminuser2ActionPerformed

    private void jbtn_adminuser3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminuser3ActionPerformed
        if (jtxt_admin_password.getText().equals("Enter 4 Digit Pin")) {
    jtxt_admin_password.setText("");
    jtxt_admin_password.setForeground(java.awt.Color.BLACK);
}
jtxt_admin_password.setText(jtxt_admin_password.getText() + "3");
    }//GEN-LAST:event_jbtn_adminuser3ActionPerformed

    private void jbtn_adminuser0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminuser0ActionPerformed
        if (jtxt_admin_password.getText().equals("Enter 4 Digit Pin")) {
    jtxt_admin_password.setText("");
    jtxt_admin_password.setForeground(java.awt.Color.BLACK);
}
jtxt_admin_password.setText(jtxt_admin_password.getText() + "0");
    }//GEN-LAST:event_jbtn_adminuser0ActionPerformed

    private void jbtn_adminuserCeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminuserCeActionPerformed
        jtxt_admin_password.setText("");



    }//GEN-LAST:event_jbtn_adminuserCeActionPerformed

    private void jbtn_adminuserDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_adminuserDelActionPerformed
        String currentText = jtxt_admin_password.getText();
if (currentText.length() > 0) {
    jtxt_admin_password.setText(currentText.substring(0, currentText.length() - 1));

}

    }//GEN-LAST:event_jbtn_adminuserDelActionPerformed

    private void jtxt_admin_lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_admin_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_admin_lastnameActionPerformed

    private void jbtn_admin_addadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin_addadminActionPerformed
 String firstName = jtxt_admin_firstname.getText().trim();
String lastName = jtxt_admin_lastname.getText().trim();
String username = jtxt_admin_username.getText().trim().toLowerCase();
String pin = jtxt_admin_password.getText().trim(); // Ilisi sa jtxt_admin_pin kung mao na imong ginagamit

// 1. Validation: Susiha kung naay walay sulod
if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || pin.isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(this, "Please Input all fields!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

// 2. Validation para sa Placeholders
if (firstName.startsWith("Enter") || lastName.startsWith("Enter") || username.startsWith("Enter") || pin.startsWith("Enter")) {
    javax.swing.JOptionPane.showMessageDialog(this, "Please Input fields with Complete Information!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

// 3. Validation sa Firstname ug Lastname (Dapat letters lamang)
if (!firstName.matches("[a-zA-ZñÑ\\s]+") || !lastName.matches("[a-zA-ZñÑ\\s]+")) {
    javax.swing.JOptionPane.showMessageDialog(this, "The First Name and Last Name must be letters and cannot be included with numbers!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

// DILI PWEDE MAGPAREHO ANG FIRSTNAME OG LASTNAME
if (firstName.equalsIgnoreCase(lastName)) {
    javax.swing.JOptionPane.showMessageDialog(this, "The First Name and Last Name Cannot be the same!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

// 4. Validation sa Username (Dapat naay letters UG naay numbers apil, 4-20 characters, walay space)
if (!username.matches("^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z0-9]{4,20}$")) {
    javax.swing.JOptionPane.showMessageDialog(this, "The Username must be 20 characters with combination of Letter and Numbers!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

// 5. Validation sa PIN (Dapat eksaktong 4 ka numero lamang)
if (!pin.matches("\\d{4}")) {
    javax.swing.JOptionPane.showMessageDialog(this, "The PIN must be exactly 4 Numbers only!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

try (java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect()) {
    
    // 6. Duplicate Username Check sa Database (tbl_admin_info)
    String checkSql = "SELECT * FROM tbl_admin_info WHERE LOWER(admin_username) = ?";
    try (java.sql.PreparedStatement checkPst = con.prepareStatement(checkSql)) {
        checkPst.setString(1, username);
        try (java.sql.ResultSet rs = checkPst.executeQuery()) {
            if (rs.next()) {
                javax.swing.JOptionPane.showMessageDialog(this, "This admin username is already exist cannot be duplicated!", "DUPLICATE ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }

    // SQL Query para sa pag-insert ngadto sa tbl_admin_info
    String sql = "INSERT INTO tbl_admin_info (first_name, last_name, admin_username, admin_pin) VALUES (?, ?, ?, ?)";

    try (java.sql.PreparedStatement pst = con.prepareStatement(sql)) {
        pst.setString(1, firstName);
        pst.setString(2, lastName);
        pst.setString(3, username); 
        pst.setString(4, pin);

        int rowsInserted = pst.executeUpdate();
        if (rowsInserted > 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Successfully added Trusted admin!", "SUCCESS", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            loadAdminTable(); // I-refresh ang admin table display (ilisi sa imong method name)
            
            jtxt_admin_firstname.setText("");
            jtxt_admin_lastname.setText("");
            jtxt_admin_username.setText("");
            jtxt_admin_password.setText("Enter 4 Digit Pin"); // Ilisi sa jtxt_admin_pin kung mao na imong textfield
            jtxt_admin_password.setForeground(new java.awt.Color(153, 153, 153));
        }
    }
} catch (java.sql.SQLException e) {
    e.printStackTrace();
    javax.swing.JOptionPane.showMessageDialog(this, "Error for adding in admin: " + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_jbtn_admin_addadminActionPerformed

    
    
    private void jbtn_admin_updateadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin_updateadminActionPerformed
   int selectedRow = jTablePane_admin2.getSelectedRow();
if (selectedRow == -1) {
    javax.swing.JOptionPane.showMessageDialog(this, "Please choose an Admin from the table to update!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

String formattedAdminId = jTablePane_admin2.getValueAt(selectedRow, 0).toString();

String inputFirstName = jtxt_admin_firstname.getText().trim();
String inputLastName = jtxt_admin_lastname.getText().trim();
String inputUsername = jtxt_admin_username.getText().trim();
String inputPin = jtxt_admin_password.getText().trim();

if (inputFirstName.isEmpty() && inputLastName.isEmpty() && inputUsername.isEmpty() && inputPin.isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(this, "Please input all fields with new Information to Update!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

if (inputFirstName.equalsIgnoreCase("Enter First Name") || 
    inputLastName.equalsIgnoreCase("Enter Last Name") || 
    inputUsername.equalsIgnoreCase("Enter Username") || 
    inputPin.equalsIgnoreCase("Enter Password")) {
    javax.swing.JOptionPane.showMessageDialog(this, "Please input all fields with complete information!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

// Validation sa Username kung giusab
if (!inputUsername.isEmpty() && !inputUsername.matches("[a-zA-Z0-9]{4,20}")) {
    javax.swing.JOptionPane.showMessageDialog(this, "The Username must be 20 characters with combination of Letter and Numbers!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

// Validation sa PIN kung giusab
if (!inputPin.isEmpty() && !inputPin.matches("\\d{4}")) {
    javax.swing.JOptionPane.showMessageDialog(this, "The PIN must be 4 Digit Number only!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

String currentFirstName = jTablePane_admin2.getValueAt(selectedRow, 1).toString();
String currentLastName = jTablePane_admin2.getValueAt(selectedRow, 2).toString();
String currentUsername = jTablePane_admin2.getValueAt(selectedRow, 3).toString();
String currentPin = jTablePane_admin2.getValueAt(selectedRow, 4).toString();

String firstName = inputFirstName.isEmpty() ? currentFirstName : inputFirstName;
String lastName = inputLastName.isEmpty() ? currentLastName : inputLastName;
String username = inputUsername.isEmpty() ? currentUsername : inputUsername;
String pin = inputPin.isEmpty() ? currentPin : inputPin;

try {
    String numericIdStr = formattedAdminId.replaceAll("[^0-9]", "");
    int adminId = Integer.parseInt(numericIdStr);

    // I-check ang duplicate kung giusab ang username
    if (!inputUsername.isEmpty() && !inputUsername.equals(currentUsername)) {
        String checkSql = "SELECT * FROM tbl_admin_info WHERE admin_username = ?";
        try (java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect();
             java.sql.PreparedStatement checkPst = con.prepareStatement(checkSql)) {
            checkPst.setString(1, username);
            try (java.sql.ResultSet rs = checkPst.executeQuery()) {
                if (rs.next()) {
                    javax.swing.JOptionPane.showMessageDialog(this, "The Username Already Used Please create a unique one!", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
    }

    String sql = "UPDATE tbl_admin_info SET first_name = ?, last_name = ?, admin_username = ?, admin_pin = ? WHERE admin_id = ?";

    try (java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect();
         java.sql.PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setString(1, firstName);
        pst.setString(2, lastName);
        pst.setString(3, username);
        pst.setString(4, pin);
        pst.setInt(5, adminId);

        int rowsUpdated = pst.executeUpdate();

        if (rowsUpdated > 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Successfully updated record in admin!", "SUCCESS", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            loadAdminTable(); 
            
            jtxt_admin_firstname.setText("");
            jtxt_admin_lastname.setText("");
            jtxt_admin_username.setText("");
            jtxt_admin_password.setText("");
        }
    }
} catch (NumberFormatException | java.sql.SQLException e) {
    e.printStackTrace();
    javax.swing.JOptionPane.showMessageDialog(this, "Error sa pag-update: " + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_jbtn_admin_updateadminActionPerformed

    private void jbtn_admin_removeadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin_removeadminActionPerformed
   int selectedRow = jTablePane_admin2.getSelectedRow();
if (selectedRow == -1) {
    javax.swing.JOptionPane.showMessageDialog(this, "Please choose an admin in the table to remove!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

String formattedAdminId = jTablePane_admin2.getValueAt(selectedRow, 0).toString();

int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this admin record?", "Confirm Delete", javax.swing.JOptionPane.YES_NO_OPTION);

if (confirm == javax.swing.JOptionPane.YES_OPTION) {
    try {
        String numericIdStr = formattedAdminId.replaceAll("[^0-9]", "");
        int adminId = Integer.parseInt(numericIdStr);

        try (java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect()) {
            
            // 1. I-check una kung pila ka admin ang nabilin sa table
            String sqlCount = "SELECT COUNT(*) FROM tbl_admin_info";
            try (java.sql.PreparedStatement pstCount = con.prepareStatement(sqlCount);
                 java.sql.ResultSet rsCount = pstCount.executeQuery()) {
                if (rsCount.next()) {
                    int totalAdmins = rsCount.getInt(1);
                    // Kung 1 o ubos pa ang nahabilin, ayaw tugoti i-delete!
                    if (totalAdmins <= 1) {
                        javax.swing.JOptionPane.showMessageDialog(this, 
                            "Cannot delete all Admin, Need atleast one Admin to Access The System(1)!", 
                            "CANNOT DELETE", javax.swing.JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
            }

            // 2. Kung 2 o kapin pa ang admin, dayonon ang pag-delete
            String sqlDelete = "DELETE FROM tbl_admin_info WHERE admin_id = ?";
            try (java.sql.PreparedStatement pstDelete = con.prepareStatement(sqlDelete)) {
                pstDelete.setInt(1, adminId);
                int rowsDeleted = pstDelete.executeUpdate();

                if (rowsDeleted > 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Succesfully Deleted Record Admin!", "SUCCESS", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    loadAdminTable(); // Mo-refresh dayon ang table
                }
            }
        }
    } catch (NumberFormatException | java.sql.SQLException e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Error for deletion: " + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
    }

    

}


    }//GEN-LAST:event_jbtn_admin_removeadminActionPerformed

    private void jbtn_admin_printmonthlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin_printmonthlyActionPerformed
        try {
    // 1. I-set ang header ug footer para sa print page
    java.text.MessageFormat header = new java.text.MessageFormat("MONTHLY REPORT");
    java.text.MessageFormat footer = new java.text.MessageFormat("Page {0,number,integer}");

    // 2. Tawagon ang print function sa JTable (gisuportahan na kini sa Java Swing)
    boolean complete = jTablePane_admin4.print(javax.swing.JTable.PrintMode.FIT_WIDTH, header, footer);

    if (complete) {
        // Kung nahuman na o na-save na sa printer/PDF
        javax.swing.JOptionPane.showMessageDialog(this, "Successfuly print the Daily Report!", "SUCCESS", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    } else {
        // Kung gi-cancel sa user
        javax.swing.JOptionPane.showMessageDialog(this, "Print Cancelled.", "INFO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

} catch (java.awt.print.PrinterException e) {
    e.printStackTrace();
    javax.swing.JOptionPane.showMessageDialog(this, "Error for print: " + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_jbtn_admin_printmonthlyActionPerformed

    private void jtxt_admin_staff_lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_admin_staff_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_admin_staff_lastnameActionPerformed

    private void jbtn_admin_removedailyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin_removedailyActionPerformed
        int selectedRow = jTablePane_admin3.getSelectedRow();

if (selectedRow == -1) {
    javax.swing.JOptionPane.showMessageDialog(this, "Please Select a Row to Delete!", "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

int confirm = javax.swing.JOptionPane.showConfirmDialog(this,
    "Arre you sure you want to delete this log?",
    "Confirm Delete", javax.swing.JOptionPane.YES_NO_OPTION);

if (confirm == javax.swing.JOptionPane.YES_OPTION) {
    try {
        // Kuhaon ang transaction_id gikan sa unang column (Index 0) sa table
        // Siguruha nga ang Column 0 sa imong jTablePane_admin3 mao ang transaction_id o receipt ID number
        Object idObj = jTablePane_admin3.getValueAt(selectedRow, 0);
        
        if (idObj == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Invalid ID row!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kung ang format sa table kay "RX-013", i-convert nato siya aron makuha ang numero (13)
        // O kung integer ra daan (pananglitan 13), direktang gamiton ra nimo.
        String idStr = idObj.toString().replace("RX-", "").trim();
        int transactionId = Integer.parseInt(idStr);

        // Gigamit ang transaction_id kay mao ni ang primary key sa tbl_transactions
        String sql = "DELETE FROM tbl_transactions WHERE transaction_id = ?";

        try (java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect();
             java.sql.PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, transactionId);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Log Deleted!");
                loadDailyLogsTable(); // I-refresh ang Table
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Cannot get Record from Database.", "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
            }

        } catch (java.sql.SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error deleting log: " + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error parsing Transaction ID: " + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}
    
    }//GEN-LAST:event_jbtn_admin_removedailyActionPerformed

    private void jbtn_admin_deletealldailyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin_deletealldailyActionPerformed
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this,
        "WARNING: Are you sure you want to clear all Daily Logs?",
        "Confirm Delete All", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);

    if (confirm == javax.swing.JOptionPane.YES_OPTION) {
        String sql = "TRUNCATE TABLE tbl_transactions";

        try (java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect();
             java.sql.PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.executeUpdate();
            javax.swing.JOptionPane.showMessageDialog(this, "all Daily Logs has been cleared!");
            loadDailyLogsTable(); // I-refresh ang Table

        } catch (java.sql.SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error clearing logs: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_jbtn_admin_deletealldailyActionPerformed

    private void jbtn_admin_printdailyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin_printdailyActionPerformed
        try {
            java.text.MessageFormat header = new java.text.MessageFormat("DAILY LOGS REPORT");
            java.text.MessageFormat footer = new java.text.MessageFormat("Page {0,number,integer}");

            boolean complete = jTablePane_admin3.print(javax.swing.JTable.PrintMode.FIT_WIDTH, header, footer);

            if (complete) {
                javax.swing.JOptionPane.showMessageDialog(this, "Printing Completed / Saved successfully!");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Printing Cancelled!");
            }
        } catch (java.awt.print.PrinterException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Print Error: " + e.getMessage());
        }
    }//GEN-LAST:event_jbtn_admin_printdailyActionPerformed

    
    private void loadMonthlyReportData() {
    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTablePane_admin4.getModel();
    model.setRowCount(0); // I-clear ang table sa dili pa i-load ang bag-ong data
    
    try (java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect();
         java.sql.Statement stmt = con.createStatement();
         java.sql.ResultSet rs = stmt.executeQuery("SELECT * FROM tbl_monthly_report")) { // Usba ang 'tbl_monthly_report' kung lahi ang table name nimo
         
        while (rs.next()) {
            String monthYear = rs.getString("month_year"); // Usba ang column name kung kinahanglan
            int totalTrans = rs.getInt("total_trans");
            double totalSubtotal = rs.getDouble("total_subtotal");
            double totalDiscount = rs.getDouble("total_discount");
            double totalSales = rs.getDouble("total_sales");
            
            // I-add ang row sa table
            model.addRow(new Object[]{monthYear, totalTrans, totalSubtotal, totalDiscount, totalSales});
        }
        
    } catch (java.sql.SQLException e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Error sa pag-load sa report: " + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}
    
    
    
    
    private void jbtn_admin_deleteallmonthlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin_deleteallmonthlyActionPerformed
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to delete all Monthly Report?", "CONFIRM DELETE ALL", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);

if (confirm != javax.swing.JOptionPane.YES_OPTION) {
    return;
}

try (java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect()) {
    // SQL query para ma-delete ang tanang records sa table
    String sql = "DELETE FROM tbl_monthly_report";
    
    try (java.sql.PreparedStatement pst = con.prepareStatement(sql)) {
        int rowsDeleted = pst.executeUpdate();
        
        javax.swing.JOptionPane.showMessageDialog(this, "All Records has been cleared!", "SUCCESS", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        
        // I-refresh ang table display
        loadMonthlyReportData(); 
    }
} catch (java.sql.SQLException e) {
    e.printStackTrace();
    javax.swing.JOptionPane.showMessageDialog(this, "Error records: " + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_jbtn_admin_deleteallmonthlyActionPerformed

    
    
    private void jbtn_admin_removemonthlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_admin_removemonthlyActionPerformed
        int selectedRow = jTablePane_admin4.getSelectedRow();

// 1. Susiha kung naay gipili sa table
if (selectedRow == -1) {
    javax.swing.JOptionPane.showMessageDialog(this, "Please choose a record to remove!", "WARNING", javax.swing.JOptionPane.WARNING_MESSAGE);
    return;
}

// 2. Kumpirmasyon gikan sa user
int confirm = javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to remove this monthly report record?", "CONFIRM DELETE", javax.swing.JOptionPane.YES_NO_OPTION);
if (confirm != javax.swing.JOptionPane.YES_OPTION) {
    return;
}

// 3. Kuhaa ang Month/Year gikan sa Column 0 (base sa imong table design)
String monthYearToDelete = jTablePane_admin4.getValueAt(selectedRow, 0).toString();

try (java.sql.Connection con = thriftstore_pointofsale_system.DBConnection2.connect()) {
    // I-adjust ang 'tbl_monthly_report' ug 'month_year' kolum depende sa ngalan sa imong database
    String sql = "DELETE FROM tbl_monthly_report WHERE month_year = ?";
    
    try (java.sql.PreparedStatement pst = con.prepareStatement(sql)) {
        pst.setString(1, monthYearToDelete);
        
        int rowsDeleted = pst.executeUpdate();
        if (rowsDeleted > 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Succesfully remove monthly report record!", "SUCCESS", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            // Tawga dinhi ang imong method sa pag-load sa table (pananglitan loadMonthlyReportData();)
            loadMonthlyReportData(); 
        }
    }
} catch (java.sql.SQLException e) {
    e.printStackTrace();
    javax.swing.JOptionPane.showMessageDialog(this, "Error for removal: " + e.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_jbtn_admin_removemonthlyActionPerformed
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(Pos_admin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pos_admin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pos_admin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pos_admin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pos_admin1().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel_admin1;
    private javax.swing.JPanel jPanel_admin2;
    private javax.swing.JPanel jPanel_admin3;
    private javax.swing.JPanel jPanel_admin4;
    private javax.swing.JPanel jPanel_admin5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane_admin;
    private javax.swing.JTable jTablePane_admin1;
    private javax.swing.JTable jTablePane_admin2;
    private javax.swing.JTable jTablePane_admin3;
    private javax.swing.JTable jTablePane_admin4;
    private javax.swing.JButton jbtn_admin_addadmin;
    private javax.swing.JButton jbtn_admin_deletealldaily;
    private javax.swing.JButton jbtn_admin_deleteallmonthly;
    private javax.swing.JButton jbtn_admin_newstaff;
    private javax.swing.JButton jbtn_admin_printdaily;
    private javax.swing.JButton jbtn_admin_printmonthly;
    private javax.swing.JButton jbtn_admin_removeadmin;
    private javax.swing.JButton jbtn_admin_removedaily;
    private javax.swing.JButton jbtn_admin_removemonthly;
    private javax.swing.JButton jbtn_admin_removestaff;
    private javax.swing.JButton jbtn_admin_terminal1;
    private javax.swing.JButton jbtn_admin_updateadmin;
    private javax.swing.JButton jbtn_admin_updatestaff;
    private javax.swing.JButton jbtn_adminregistraion0;
    private javax.swing.JButton jbtn_adminregistraion1;
    private javax.swing.JButton jbtn_adminregistraion2;
    private javax.swing.JButton jbtn_adminregistraion3;
    private javax.swing.JButton jbtn_adminregistraion4;
    private javax.swing.JButton jbtn_adminregistraion5;
    private javax.swing.JButton jbtn_adminregistraion6;
    private javax.swing.JButton jbtn_adminregistraion7;
    private javax.swing.JButton jbtn_adminregistraion8;
    private javax.swing.JButton jbtn_adminregistraion9;
    private javax.swing.JButton jbtn_adminregistraionCe;
    private javax.swing.JButton jbtn_adminregistraionDel;
    private javax.swing.JButton jbtn_adminuser0;
    private javax.swing.JButton jbtn_adminuser1;
    private javax.swing.JButton jbtn_adminuser2;
    private javax.swing.JButton jbtn_adminuser3;
    private javax.swing.JButton jbtn_adminuser4;
    private javax.swing.JButton jbtn_adminuser5;
    private javax.swing.JButton jbtn_adminuser6;
    private javax.swing.JButton jbtn_adminuser7;
    private javax.swing.JButton jbtn_adminuser8;
    private javax.swing.JButton jbtn_adminuser9;
    private javax.swing.JButton jbtn_adminuserCe;
    private javax.swing.JButton jbtn_adminuserDel;
    private javax.swing.JButton jbtn_hmpgLogout;
    private javax.swing.JTextField jtxt_admin_firstname;
    private javax.swing.JTextField jtxt_admin_lastname;
    private javax.swing.JTextField jtxt_admin_password;
    private javax.swing.JTextField jtxt_admin_staff_firstname;
    private javax.swing.JTextField jtxt_admin_staff_lastname;
    private javax.swing.JTextField jtxt_admin_staff_pin;
    private javax.swing.JTextField jtxt_admin_staff_username;
    private javax.swing.JTextField jtxt_admin_username;
    // End of variables declaration//GEN-END:variables
}
