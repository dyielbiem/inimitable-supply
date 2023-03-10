
import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableCellRenderer;


public class App {

    static Connection objConn;
    static Statement objSQLQuery;
    static final String bgColor = "#303c4c";
    static final String bgColorTxtField = "#5D7A96";
    static final String bgColorInactiveTxtField = "#354554";
    static final String fgColor = "#eeeeee";
    static final String accentColor = "#d9a433";

    static class CustomTableCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            c.setBackground(Color.decode(bgColorTxtField));
            c.setForeground(Color.decode(fgColor));
            

            return c;
        }
    }

    static void setButtonAttributes(JButton button){
        button.setFont(new Font("Sans Serif", Font.BOLD, 14));
        button.setBackground(Color.decode(accentColor));
        button.setForeground(Color.decode(bgColor));
        button.setBorder(BorderFactory.createLineBorder(Color.decode(bgColor), 2));
    }
    
    static void setJTextFieldAttributes(JTextField txtField){
        txtField.setBorder(BorderFactory.createLineBorder(Color.decode(bgColor), 2));
        txtField.setBackground(Color.decode(bgColorTxtField));
        txtField.setForeground(Color.decode(fgColor));
        txtField.setCaretColor(Color.decode(fgColor));
    }

    static void setJInactiveTextFieldAttributes(JTextField txtField){
        txtField.setBorder(BorderFactory.createLineBorder(Color.decode(bgColor), 2));
        txtField.setBackground(Color.decode(bgColorInactiveTxtField));
        txtField.setForeground(Color.decode(fgColor));
        txtField.setCaretColor(Color.decode(fgColor));
    }

    public App(){

        String strDriver = "com.mysql.jdbc.Driver";
        try {
            String strUser = "root";
            String strPass = "yourMySQLPassword";

            Class.forName(strDriver);
            String strConn = "jdbc:mysql://localhost:3306/imfinalproject";
            objConn = DriverManager.getConnection(strConn, strUser, strPass);
            objSQLQuery = objConn.createStatement();

            System.out.println("Database setup complete.");

        } catch (Exception objEx) {
            System.out.println("Database connection failed!");
            System.out.println(objEx);
        }

        //Logo Panel
        JPanel pnlLogo = new JPanel();
        pnlLogo.setBackground(Color.decode(bgColor));
        pnlLogo.setBounds(45,55,389,75);
        pnlLogo.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        JLabel lblCompany = new JLabel("Inimitable Supply, LLC");
        lblCompany.setFont(new Font("Sans Serif", Font.BOLD, 35));
        lblCompany.setForeground(Color.decode(accentColor));
        JLabel lblMotto = new JLabel("We value our customers as our biggest asset.");
        lblMotto.setFont(new Font("Serif", Font.ITALIC, 18));
        lblMotto.setForeground(Color.decode(fgColor));
        pnlLogo.add(lblCompany);
        pnlLogo.add(lblMotto);

        
        //
        // Order Panel
        //
        JPanel pnlOrder = new JPanel();
        pnlOrder.setBackground(Color.decode(bgColor));
        GridBagLayout GBLayout = new GridBagLayout();
        GridBagConstraints bagCons = new GridBagConstraints();
        pnlOrder.setLayout(GBLayout);
        pnlOrder.setBounds(363, 40,450,100);
        JLabel lblOrderNo = new JLabel("Order Number: ");
        lblOrderNo.setForeground(Color.decode(fgColor));
        JTextField txtOrderNo = new JTextField(40);
        setJTextFieldAttributes(txtOrderNo);       
        bagCons.gridx=0;
        bagCons.gridy=0;
        bagCons.ipadx=10;
        pnlOrder.add(lblOrderNo, bagCons);
        bagCons.gridx=1;
        bagCons.gridy=0;
        bagCons.ipadx=196;
        pnlOrder.add(txtOrderNo, bagCons);
        JLabel lblOrderDate = new JLabel("Order Date: ");
        lblOrderDate.setForeground(Color.decode(fgColor));
        JTextField txtOrderDate = new JTextField(40);
        setJTextFieldAttributes(txtOrderDate);
        bagCons.gridx=0;
        bagCons.gridy=1;
        bagCons.ipadx=10;
        pnlOrder.add(lblOrderDate, bagCons);
        bagCons.gridx=1;
        bagCons.gridy=1;
        bagCons.ipadx=196;
        pnlOrder.add(txtOrderDate, bagCons);
        JLabel lblSalesPerson = new JLabel("Sales Person: ");
        lblSalesPerson.setForeground(Color.decode(fgColor));
        JTextField txtSalesPerson = new JTextField(40);
        setJTextFieldAttributes(txtSalesPerson);
        bagCons.gridx=0;
        bagCons.gridy=2;
        bagCons.ipadx=10;
        pnlOrder.add(lblSalesPerson, bagCons);
        bagCons.gridx=1;
        bagCons.gridy=2;
        bagCons.ipadx=196;
        pnlOrder.add(txtSalesPerson, bagCons);
        JLabel lblInvoiceNo = new JLabel("Invoice Number: ");
        lblInvoiceNo.setForeground(Color.decode(fgColor));
        JTextField txtInvoiceNo = new JTextField(40);
        setJTextFieldAttributes(txtInvoiceNo);
        bagCons.gridx=0;
        bagCons.gridy=3;
        bagCons.ipadx=10;
        pnlOrder.add(lblInvoiceNo, bagCons);
        bagCons.gridx=1;
        bagCons.gridy=3;
        bagCons.ipadx=196;
        pnlOrder.add(txtInvoiceNo, bagCons);
        JLabel lblCustomerCode= new JLabel("Customer Code: ");
        lblCustomerCode.setForeground(Color.decode(fgColor));
        JTextField txtCustomerCode = new JTextField(40);
        setJTextFieldAttributes(txtCustomerCode);
        bagCons.gridx=0;
        bagCons.gridy=4;
        bagCons.ipadx=10;
        pnlOrder.add(lblCustomerCode,bagCons);
        bagCons.gridx=1;
        bagCons.gridy=4;
        bagCons.ipadx=196;
        pnlOrder.add(txtCustomerCode,bagCons);

        //
        // Product JTable
        //
        JPanel pnlProd = new JPanel();
        pnlProd.setForeground(Color.GREEN);
        pnlProd.setLayout(null);
        pnlProd.setBounds(40,160,700,123);
        DefaultTableModel tblProdItem = new DefaultTableModel();
        tblProdItem.addColumn("SN");
        tblProdItem.addColumn("Code ID");
        tblProdItem.addColumn("Description");
        tblProdItem.addColumn("Quantity");
        tblProdItem.addColumn("Price/Piece");
        tblProdItem.addColumn("Total");
        JTable tblProd = new JTable(tblProdItem);
        tblProd.setForeground(Color.decode(bgColor));

        TableCellRenderer tableRenderer = new CustomTableCellRenderer();
        tblProd.setDefaultRenderer(Object.class, tableRenderer);
        tblProd.getTableHeader().setBackground(Color.decode(bgColorInactiveTxtField));
        tblProd.getTableHeader().setForeground(Color.decode(fgColor));
        tblProd.setGridColor(Color.decode(fgColor));
        tblProd.setIntercellSpacing(new Dimension(2,2));

        //
        // Edit in 1 Click
        //
        class ComboBoxRenderer extends JComboBox<Object> implements TableCellRenderer
        {
            public ComboBoxRenderer()
            {
                setBorder(null);
            }

            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
            {
                removeAllItems();
                addItem(value);
                return this;
            }
        }

        String strCodeNumber [] = { "","NY 6X1 T", "TFT 10x8", "SWH-15", "WG-12", "AG9-06", "TM1B120"};
        JComboBox<Object> comboCodeNumber = new JComboBox<Object>(strCodeNumber);
        comboCodeNumber.setBackground(Color.decode(bgColor));
        comboCodeNumber.setForeground(Color.decode(fgColor));



        tblProdItem.addRow(new Object[]{"", "" , "", "", "", ""});
        ComboBoxRenderer renderer = new ComboBoxRenderer();

        JTextField disableEdit = new JTextField();
        disableEdit.setEditable(false);
        tblProd.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(disableEdit));
        tblProd.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(disableEdit));
        tblProd.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(disableEdit));
        tblProd.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(disableEdit));

        JTextField txtQnty = new JTextField();
        setJInactiveTextFieldAttributes(txtQnty);
        DefaultCellEditor tblSingleclick = new DefaultCellEditor(txtQnty);
        tblSingleclick.setClickCountToStart(1);
        tblProd.setDefaultEditor(tblProd.getColumnClass(3), tblSingleclick);

        TableColumn clmnCodeNumber = tblProd.getColumnModel().getColumn(1);
        clmnCodeNumber.setCellEditor(new DefaultCellEditor(comboCodeNumber));
        clmnCodeNumber.setCellRenderer(renderer);

        tblProd.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblProd.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblProd.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblProd.setRowHeight(20);
        JScrollPane scrollProd = new JScrollPane(tblProd);
        scrollProd.getViewport().setBackground(Color.decode(fgColor));
        scrollProd.setBounds(0,0,700,123);
        pnlProd.add(scrollProd);

        // 
        // Add Item Button
        // 
        JButton btnAddItem = new JButton("ADD ITEM");
        setButtonAttributes(btnAddItem);
        btnAddItem.setBounds(40,295,125,30);
        btnAddItem.setFocusable(false);

        // 
        //Del Item Button
        // 
        JButton btnDelItem = new JButton("DELETE ITEM");
        setButtonAttributes(btnDelItem);
        btnDelItem.setBounds(180,296,125,30);
        btnDelItem.setFocusable(false);

        // 
        // Total Panel
        // 
        JPanel pnlTotal = new JPanel();
        pnlTotal.setBackground(Color.decode(bgColor));
        pnlTotal.setLayout(GBLayout);
        pnlTotal.setBounds(449, 300,299,60);
        JLabel lblTotalAED = new JLabel("Total AED: ");
        lblTotalAED.setForeground(Color.decode(fgColor));
        JTextField txtTotalAED = new JTextField(40);
        setJInactiveTextFieldAttributes(txtTotalAED);
        txtTotalAED.setEditable(false);
        bagCons.gridx=0;
        bagCons.gridy=0;
        bagCons.ipadx=10;
        pnlTotal.add(lblTotalAED,bagCons);
        bagCons.gridx=1;
        bagCons.gridy=0;
        bagCons.ipadx=197;
        pnlTotal.add(txtTotalAED, bagCons);
        JLabel lblVAT= new JLabel("VAT: ");
        lblVAT.setForeground(Color.decode(fgColor));
        JTextField txtVAT= new JTextField(40);
        setJInactiveTextFieldAttributes(txtVAT);
        txtVAT.setEditable(false);
        bagCons.gridx=0;
        bagCons.gridy=1;
        bagCons.ipadx=10;
        pnlTotal.add(lblVAT, bagCons);
        bagCons.gridx=1;
        bagCons.gridy=1;
        bagCons.ipadx=197;
        pnlTotal.add(txtVAT, bagCons);
        JLabel lblGrandTotal = new JLabel("Grand Total: ");
        lblGrandTotal.setForeground(Color.decode(fgColor));
        JTextField txtGrandTotal = new JTextField(40);
        setJInactiveTextFieldAttributes(txtGrandTotal);
        txtGrandTotal.setEditable(false);
        bagCons.gridx=0;
        bagCons.gridy=2;
        bagCons.ipadx=10;
        pnlTotal.add(lblGrandTotal,bagCons);
        bagCons.gridx=1;
        bagCons.gridy=2;
        bagCons.ipadx=197;
        pnlTotal.add(txtGrandTotal, bagCons);

        // 
        // Personnel Panel
        // 
        JPanel pnlPersonnel = new JPanel();
        pnlPersonnel.setBackground(Color.decode(bgColor));
        pnlPersonnel.setLayout(new GridLayout(4,1));
        pnlPersonnel.setBounds(40,335, 340,76);
        JLabel lblConfirmedBy = new JLabel("Confirmed By: ");
        lblConfirmedBy.setForeground(Color.decode(fgColor));
        JTextField txtConfirmedBy = new JTextField(40);
        setJTextFieldAttributes(txtConfirmedBy);
        JLabel lblSalesExecutive= new JLabel("Sales Executive: ");
        lblSalesExecutive.setForeground(Color.decode(fgColor));
        JTextField txtSalesExecutive = new JTextField(40);
        setJTextFieldAttributes(txtSalesExecutive);
        pnlPersonnel.add(lblConfirmedBy);
        pnlPersonnel.add(txtConfirmedBy);
        pnlPersonnel.add(lblSalesExecutive);
        pnlPersonnel.add(txtSalesExecutive);

        // 
        // Enter Transaction Button
        // 
        JButton btnEnterTransaction = new JButton("ENTER");
        setButtonAttributes(btnEnterTransaction);
        btnEnterTransaction.setBounds(430,380,150, 30);
        btnEnterTransaction.setFocusable(false);

        // Cancel Transaction Button
        JButton btnCancelTransaction = new JButton("CANCEL");
        setButtonAttributes(btnCancelTransaction);
        btnCancelTransaction.setBounds(590,380,150,30);
        btnCancelTransaction.setFocusable(false);

        JFrame frmMain = new JFrame("Inimitable Supply, LLC - Order Form System");
        frmMain.getContentPane().setBackground(Color.decode(bgColor));
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMain.setLocation(280,120);
        frmMain.setLayout(null);
        frmMain.setSize(800,490);
        frmMain.setResizable(false);
        frmMain.add(pnlLogo);
        frmMain.add(pnlOrder);
        frmMain.add(pnlProd);
        frmMain.add(btnAddItem);
        frmMain.add(btnDelItem);
        frmMain.add(pnlTotal);
        frmMain.add(pnlPersonnel);
        frmMain.add(btnEnterTransaction);
        frmMain.add(btnCancelTransaction);
        frmMain.setVisible(true);

        btnAddItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tblProdItem.addRow(new Object[]{"", "" , "", "", "", ""});
                TableColumn clmnCodeNumber = tblProd.getColumnModel().getColumn(1);
                clmnCodeNumber.setCellEditor(new DefaultCellEditor(comboCodeNumber));
            }
        });
        
        // 
        // Customer Left Frame
        // 
        JLabel lblName = new JLabel("* Name:");
        lblName.setForeground(Color.decode(fgColor));
        JLabel lblPhone = new JLabel("Telephone:");
        lblPhone.setForeground(Color.decode(fgColor));
        JLabel lblCompanyName = new JLabel("Company Name:");
        lblCompanyName.setForeground(Color.decode(fgColor));
        JLabel lblFax = new JLabel("Fax:");
        lblFax.setForeground(Color.decode(fgColor));
        JLabel lblAddress = new JLabel("* Address:");
        lblAddress.setForeground(Color.decode(fgColor));
        JLabel lblCell = new JLabel("* Cellphone:");
        lblCell.setForeground(Color.decode(fgColor));
        JLabel lblEmail = new JLabel("* Email");
        lblEmail.setForeground(Color.decode(fgColor));
        JTextField txtName = new JTextField(40);
        setJTextFieldAttributes(txtName);
        JTextField txtPhone = new JTextField(40);
        setJTextFieldAttributes(txtPhone);
        JTextField txtCompanyName = new JTextField(40);
        setJTextFieldAttributes(txtCompanyName);
        JTextField txtFax = new JTextField(40);
        setJTextFieldAttributes(txtFax);
        JTextField txtAddress = new JTextField(40);
        setJTextFieldAttributes(txtAddress);
        JTextField txtCell = new JTextField(40);
        setJTextFieldAttributes(txtCell);
        JTextField txtEmail = new JTextField(40);
        setJTextFieldAttributes(txtEmail);
        JPanel lPnlCustomer = new JPanel();
        lPnlCustomer.setBackground(Color.decode(bgColor));
        lPnlCustomer.setLayout(new GridLayout(6,1));
        lPnlCustomer.setBounds(30,65,300,120);
        JPanel rPnlCustomer = new JPanel();
        rPnlCustomer.setBackground(Color.decode(bgColor));
        rPnlCustomer.setLayout(new GridLayout(8,1));
        rPnlCustomer.setBounds(350,25,300,160);
        JButton btnEnterInfo = new JButton("ENTER");
        setButtonAttributes(btnEnterInfo);
        btnEnterInfo.setBounds(510, 200,140,30);
        btnEnterInfo.setFocusable(false);
        JFrame frmCustomer = new JFrame("New Customer");
        frmCustomer.getContentPane().setBackground(Color.decode(bgColor));
        frmCustomer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmCustomer.setLocation(325,220);
        frmCustomer.setSize(700,295);
        frmCustomer.setLayout(null);
        frmCustomer.setResizable(false);



        btnEnterTransaction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lPnlCustomer.add(lblName);
                lPnlCustomer.add(txtName);
                lPnlCustomer.add(lblCompanyName);
                lPnlCustomer.add(txtCompanyName);
                lPnlCustomer.add(lblAddress);
                lPnlCustomer.add(txtAddress);

                // Customer Right Frame
                rPnlCustomer.add(lblCell);
                rPnlCustomer.add(txtCell);
                rPnlCustomer.add(lblPhone);
                rPnlCustomer.add(txtPhone);
                rPnlCustomer.add(lblFax);
                rPnlCustomer.add(txtFax);
                rPnlCustomer.add(lblEmail);
                rPnlCustomer.add(txtEmail);

                // 
                // Customer Frame
                // 
                frmCustomer.add(lPnlCustomer);
                frmCustomer.add(rPnlCustomer);
                frmCustomer.add(btnEnterInfo);
                frmCustomer.setVisible(false);

                boolean boolCheck =false;
                for(int i = 0;i<tblProd.getModel().getRowCount();i++){
                    if(tblProd.getModel().getValueAt(i, 3).toString().isEmpty()||
                            tblProd.getModel().getValueAt(i, 0).toString().isEmpty()){
                        boolCheck = true;
                        break;
                    }
                }

                try{
                    if(txtOrderNo.getText().trim().trim().isEmpty()||txtOrderDate.getText().trim().isEmpty()||txtSalesPerson.getText().trim().isEmpty()||
                            txtInvoiceNo.getText().trim().isEmpty()||txtCustomerCode.getText().trim().isEmpty()||txtQnty.getText().trim().isEmpty()||
                            txtConfirmedBy.getText().trim().isEmpty()||txtSalesExecutive.getText().trim().isEmpty()||txtTotalAED.getText().trim().isEmpty()||
                            txtVAT.getText().trim().isEmpty()||txtGrandTotal.getText().trim().isEmpty()||boolCheck==true)  {
                        JOptionPane.showMessageDialog(null,"Fill up all the empty field!",
                                "Incomplete Information", JOptionPane.ERROR_MESSAGE);
                    }else{      // Customer JtextField should not empty
                        String tempCustomerCode = txtCustomerCode.getText().toUpperCase().trim();
                        Statement statement = null;
                        statement = objConn.createStatement();


                        ResultSet resultSet = statement.executeQuery("SELECT * FROM tblcustomer WHERE CustomerCode = '"
                                + tempCustomerCode + "';");

                        if(resultSet.next()){                                     // Have existing Customer Code
                            String tempOrderNumber = txtOrderNo.getText().trim();
                            resultSet = statement.executeQuery("SELECT * FROM tblOrder WHERE OrderNumber = '"+
                                    tempOrderNumber + "';");

                            if (resultSet.next()){                                             // Have Existing Order Number
                                boolean boolClear = true;
                                for(int i = 0;i<tblProd.getModel().getRowCount();i++)
                                {
                                    int tempSN = Integer.parseInt(tblProd.getModel().getValueAt(i,0).toString());
                                    String tempCodeNumber = tblProd.getModel().getValueAt(i,1).toString();
                                    int tempQuantity = Integer.parseInt(tblProd.getModel().getValueAt(i,3).toString());
                                    float tempTotal = Float.parseFloat(tblProd.getModel().getValueAt(i,5).toString());

                                    resultSet = statement.executeQuery("SELECT * FROM tblTotal WHERE OrderNumber = '"+
                                            tempOrderNumber + "' AND CodeNumber = '" + tempCodeNumber + "';");

                                    if(resultSet.next()==true){                              // Have Existing Order Number & Code ID
                                        String strMessage = ("Code ID: "+ tempCodeNumber +" and Order Number: "+ tempOrderNumber
                                                + " are already existed!");
                                        JOptionPane.showMessageDialog(null, strMessage, "Existing Transaction", JOptionPane.ERROR_MESSAGE);
                                        boolClear = false;
                                        break;
                                    }else if(!resultSet.next()){                              // Have Existing Order Number but no Code ID
                                        String strSQLInsert = "INSERT INTO tblTotal(OrderNumber, CodeNumber, SerialNumber, Quantity, Total) VALUES"
                                                + String.format("('%s', '%s', '%d', '%d', '%f')", tempOrderNumber, tempCodeNumber, tempSN, tempQuantity, tempTotal);
                                        objSQLQuery.executeUpdate(strSQLInsert);
                                    }
                                }

                                if(boolClear == true){
                                    JOptionPane.showMessageDialog(null, "This transaction is successfully added!",
                                            "Adding Transaction", JOptionPane.INFORMATION_MESSAGE);
                                    txtOrderNo.setText("");
                                    txtOrderDate.setText("");
                                    txtSalesPerson.setText("");
                                    txtInvoiceNo.setText("");
                                    txtCustomerCode.setText("");
                                    txtConfirmedBy.setText("");
                                    txtSalesExecutive.setText("");
                                    txtTotalAED.setText("");
                                    txtVAT.setText("");
                                    txtGrandTotal.setText("");

                                    for(int i = tblProd.getModel().getRowCount() - 1; i >= 0; i--) {
                                        tblProdItem.removeRow(i);
                                    }

                                    tblProdItem.addRow(new Object[]{"", "" , "", "", "", ""});
                                    TableColumn clmnCodeNumber = tblProd.getColumnModel().getColumn(1);
                                    clmnCodeNumber.setCellEditor(new DefaultCellEditor(comboCodeNumber));
                                }



                            }else if (!resultSet.next()){                                     // Have no Existing Order Number
                                String tempOrderDate = txtOrderDate.getText().trim();
                                String tempSalesPerson = txtSalesPerson.getText().trim();
                                String tempInvoiceNumber = txtInvoiceNo.getText().trim();
                                Float tempTotalAED = Float.parseFloat(txtTotalAED.getText().trim());
                                Float tempVAT = Float.parseFloat(txtVAT.getText().trim());
                                Float tempGrandTotal = Float.parseFloat(txtGrandTotal.getText().trim());
                                String tempConfirmed = txtConfirmedBy.getText().trim();
                                String tempSalesExe = txtSalesExecutive.getText().trim();

                                String strSQLInsert = "INSERT INTO tblorder (OrderNumber, OrderDate, SalesPerson, InvoiceNumber, " +
                                        "CustomerCode, TotalAED, VAT, GrandTotal, ConfirmedBY, SalesExecutive)" +
                                        " VALUES" + String.format("('%s', '%s', '%s', '%s', '%s', '%f', '%f', '%f', '%s', '%s')",
                                        tempOrderNumber, tempOrderDate, tempSalesPerson, tempInvoiceNumber, tempCustomerCode,
                                        tempTotalAED, tempVAT, tempGrandTotal, tempConfirmed, tempSalesExe);
                                objSQLQuery.executeUpdate(strSQLInsert);
                            }

                        }else if (!resultSet.next()) {                                         // Have no existing Customer Code
                            frmCustomer.setVisible(true);
                        }

                    }

                }catch (Exception objEx){
                    JOptionPane.showMessageDialog(null, "Please check the input values!",
                            "Error Adding Order", JOptionPane.ERROR_MESSAGE);
                    System.out.println(objEx);
                }
            }
        });



        btnEnterInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{

                    if(txtName.getText().trim().isEmpty()||txtAddress.getText().trim().isEmpty()||txtCell.getText().trim().isEmpty()||
                        txtEmail.getText().trim().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Fill up all the empty marked with asterisk!",
                                "Incomplete Information", JOptionPane.ERROR_MESSAGE);
                    }else{
                        String tempCustomerCode = txtCustomerCode.getText().toUpperCase().trim();
                        String tempCustomerName = txtName.getText().trim();
                        String tempCompanyName = txtCompanyName.getText();
                        String tempPhone = txtPhone.getText().trim();
                        String tempFax = txtFax.getText().trim();
                        String tempAdd = txtAddress.getText().trim();
                        String tempCell = txtCell.getText().trim();
                        String tenpEmail = txtEmail.getText().trim();

                        String strSQLInsert = "INSERT INTO tblcustomer (CustomerCode, Name, CompanyName, Address, PhoneNumber, Fax, CellNumber, Email)" +
                                "VALUES" + String.format("('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                                tempCustomerCode, tempCustomerName, tempCompanyName, tempAdd, tempPhone, tempFax, tempCell, tenpEmail);

                        frmCustomer.dispose();

                        JOptionPane.showMessageDialog(
                                null,
                                "Customer Information Added!",
                                "New Customer",
                                JOptionPane.PLAIN_MESSAGE);

                        txtName.setText("");
                        txtCompanyName.setText("");
                        txtCell.setText("");
                        txtAddress.setText("");
                        txtEmail.setText("");
                        txtFax.setText("");
                        txtPhone.setText("");

                        objSQLQuery.executeUpdate(strSQLInsert);
                    }


                }catch (Exception objEx){

                }
            }
        });

        btnCancelTransaction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        comboCodeNumber.addPopupMenuListener(new PopupMenuListener() {
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            }
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {

                int tempRow = tblProd.getSelectedRow();

                Statement statement = null;
                try {
                    statement = objConn.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM tblcode WHERE CodeNumber = '"
                            + comboCodeNumber.getSelectedItem().toString().trim()+ "';");

                    if(resultSet.next()==false){
                        tblProdItem.setValueAt("", tempRow,0);
                        tblProdItem.setValueAt("", tempRow, 1);
                        tblProdItem.setValueAt("", tempRow, 2);
                        tblProdItem.setValueAt("", tempRow, 3);
                        tblProdItem.setValueAt("", tempRow, 4);
                        tblProdItem.setValueAt("", tempRow, 5);



                        float tempTotalAED = 0, tempVAT = 0, tempGrandTotal = 0;
                        for(int i = 0;i<tblProd.getModel().getRowCount();i++){
                            if (!tblProd.getValueAt(i, 5).toString().isEmpty()&&
                                    !tblProd.getValueAt(i, 1).toString().trim().isEmpty()){
                                float tempSum = Float.parseFloat(tblProd.getValueAt(i, 5).toString());
                                tempTotalAED = tempTotalAED + tempSum;
                            }
                        }
                        tempVAT= tempTotalAED * 0.05f;
                        tempGrandTotal = tempTotalAED + tempVAT;

                        txtTotalAED.setText(String.format("%.2f",tempTotalAED));
                        txtVAT.setText(String.format("%.2f",tempVAT));
                        txtGrandTotal.setText(String.format("%.2f",tempGrandTotal));
                    }else{
                        String tempDescription = resultSet.getString("Description");
                        float tempPricePerPiece = resultSet.getFloat("PricePerPiece");
                        tblProdItem.setValueAt(tempRow+1, tempRow,0);
                        tblProdItem.setValueAt(tempDescription, tempRow, 2);
                        tblProdItem.setValueAt(String.format("%.2f", tempPricePerPiece), tempRow, 4);
                    }

                    if(!tblProd.getValueAt(tempRow, 3).toString().trim().isEmpty()){
                        int tempQnty = Integer.parseInt(txtQnty.getText());
                        Float tempPricePerPiece = Float.parseFloat(tblProd.getValueAt(tempRow, 4).toString());
                        float tempTotal = tempQnty*tempPricePerPiece;
                        tblProd.setValueAt(String.format("%.2f", tempTotal), tempRow, 5);

                        float tempTotalAED = 0, tempVAT = 0, tempGrandTotal = 0;
                        for(int i = 0;i<tblProd.getModel().getRowCount();i++){
                            if (!tblProd.getValueAt(i, 5).toString().isEmpty()){
                                float tempSum = Float.parseFloat(tblProd.getValueAt(i, 5).toString());
                                tempTotalAED = tempTotalAED + tempSum;
                            }
                        }
                        tempVAT= tempTotalAED * 0.05f;
                        tempGrandTotal = tempTotalAED + tempVAT;

                        txtTotalAED.setText(String.format("%.2f",tempTotalAED));
                        txtVAT.setText(String.format("%.2f",tempVAT));
                        txtGrandTotal.setText(String.format("%.2f",tempGrandTotal));
                    }

                } catch (Exception objEx) {
                    System.out.println(objEx);
                }
            }
            public void popupMenuCanceled(PopupMenuEvent e) {
                comboCodeNumber.setSelectedIndex(comboCodeNumber.getSelectedIndex());
            }
        });

        txtQnty.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    int tempRow = tblProd.getSelectedRow();
                    if(!tblProd.getValueAt(tempRow, 4).toString().trim().isEmpty()){
                        int tempQnty = Integer.parseInt(txtQnty.getText());
                        float tempPricePerPiece = Float.parseFloat(tblProd.getValueAt(tempRow, 4).toString());
                        float tempTotal = tempQnty*tempPricePerPiece;
                        tblProd.setValueAt(String.format("%.2f", tempTotal), tempRow, 5);

                        float tempTotalAED = 0, tempVAT = 0, tempGrandTotal = 0;
                        for(int i = 0;i<tblProd.getModel().getRowCount();i++){
                            if (!tblProd.getValueAt(i, 5).toString().trim().isEmpty()){
                                float tempSum = Float.parseFloat(tblProd.getValueAt(i, 5).toString());
                                tempTotalAED = tempTotalAED + tempSum;
                            }
                        }
                        tempVAT= tempTotalAED * 0.05f;
                        tempGrandTotal = tempTotalAED + tempVAT;

                        txtTotalAED.setText(String.format("%.2f",tempTotalAED));
                        txtVAT.setText(String.format("%.2f",tempVAT));
                        txtGrandTotal.setText(String.format("%.2f",tempGrandTotal));

                    }
                }catch (Exception objEx){
                    System.out.println(objEx);
                    JOptionPane.showMessageDialog(null, "Input an Integer Value!",
                            "Incorrect Value", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        btnDelItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    tblProdItem.removeRow(tblProd.getSelectedRow());
                    float tempTotalAED = 0, tempVAT = 0, tempGrandTotal = 0;
                    for(int i = 0;i<tblProd.getModel().getRowCount();i++){
                        if (!tblProd.getValueAt(i, 5).toString().trim().isEmpty()){
                            float tempSum = Float.parseFloat(tblProd.getValueAt(i, 5).toString());
                            tempTotalAED = tempTotalAED + tempSum;
                        }
                    }
                    tempVAT= tempTotalAED * 0.05f;
                    tempGrandTotal = tempTotalAED + tempVAT;

                    txtTotalAED.setText(String.format("%.2f",tempTotalAED));
                    txtVAT.setText(String.format("%.2f",tempVAT));
                    txtGrandTotal.setText(String.format("%.2f",tempGrandTotal));

                    if(tblProd.getRowCount()==0){
                        txtTotalAED.setText("");
                        txtVAT.setText("");
                        txtGrandTotal.setText("");
                    }

                }catch (Exception objEx){
                    System.out.println(objEx);
                }

            }
        });

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                new App();

            }
        });
    }
}
