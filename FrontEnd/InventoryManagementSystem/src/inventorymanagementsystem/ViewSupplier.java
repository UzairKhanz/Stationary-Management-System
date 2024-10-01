package inventorymanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewSupplier extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    ViewSupplier() {
        setLayout(null);
        
        JLabel heading = new JLabel("SUPPLIER LIST");
        heading.setFont(new Font("Tahoma", Font.BOLD, 22));
        heading.setForeground(Color.BLUE.darker());
        heading.setBounds(400, 0, 260, 40);
        add(heading);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 80, 960, 400);
        add(scrollPane);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT supplier_id AS \"ID\", supplier_name AS \"Name\", phone AS \"Phone Number\", payment AS \"Supplier Payment\" FROM Supplier ORDER BY payment DESC ;");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        back = new JButton("BACK");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.DARK_GRAY);
        back.setBounds(420, 500, 120, 30);
        back.addActionListener(this);
        add(back);

        setBounds(150, 100, 1000, 600);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new ViewHub();
    }

    public static void main(String[] args) {
        new ViewSupplier();
    }
}