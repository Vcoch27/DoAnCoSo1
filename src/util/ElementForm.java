package util;import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jnafilechooser.api.JnaFileChooser;


public class ElementForm extends JFrame {
    private JTextField kiHieuHoaHocField;
    private JTextField soHieuNguyenTuField;
    private JTextField soKhoiField;
    private JTextField phanLoaiField;
    private JTextField tenNguyenTuField;
    private JTextField idDanhPhapField;
    private JTextArea moTaArea;
    private JButton submitButton;
    private JButton chooseImageButton;
    private File selectedImageFile;

    public ElementForm() {
        setTitle("Element Input Form");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2));

        panel.add(new JLabel("Kí Hiệu Hóa Học:"));
        kiHieuHoaHocField = new JTextField();
        panel.add(kiHieuHoaHocField);

        panel.add(new JLabel("Số Hiệu Nguyên Tử:"));
        soHieuNguyenTuField = new JTextField();
        panel.add(soHieuNguyenTuField);

        panel.add(new JLabel("Số Khối:"));
        soKhoiField = new JTextField();
        panel.add(soKhoiField);

        panel.add(new JLabel("Phân Loại:"));
        phanLoaiField = new JTextField();
        panel.add(phanLoaiField);

        panel.add(new JLabel("Tên Nguyên Tử:"));
        tenNguyenTuField = new JTextField();
        panel.add(tenNguyenTuField);

        panel.add(new JLabel("ID Danh Pháp:"));
        idDanhPhapField = new JTextField();
        panel.add(idDanhPhapField);

        panel.add(new JLabel("Mô Tả:"));
        moTaArea = new JTextArea();
        panel.add(new JScrollPane(moTaArea));

        chooseImageButton = new JButton("Chọn Hình Ảnh Minh Họa");
        panel.add(chooseImageButton);
        chooseImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseImage();
            }
        });

        submitButton = new JButton("Submit");
        panel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertData();
            }
        });

        add(panel);
    }

    private void chooseImage() {
        JFrame frame = new JFrame();
        JnaFileChooser ch = new JnaFileChooser();
        boolean action = ch.showOpenDialog(frame);
        if (action) {
            selectedImageFile = ch.getSelectedFile();
            JOptionPane.showMessageDialog(this, "Selected file: " + selectedImageFile.getAbsolutePath());
        }
    }

    private void insertData() {
        String kiHieuHoaHoc = kiHieuHoaHocField.getText();
        String soHieuNguyenTu = soHieuNguyenTuField.getText();
        String soKhoi = soKhoiField.getText();
        String phanLoai = phanLoaiField.getText();
        String tenNguyenTu = tenNguyenTuField.getText();
        String idDanhPhap = idDanhPhapField.getText();
        String moTa = moTaArea.getText();
        byte[] imageBytes = null;

        if (selectedImageFile != null) {
            try (FileInputStream fis = new FileInputStream(selectedImageFile)) {
                imageBytes = fis.readAllBytes();
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error reading image file: " + e.getMessage());
                return;
            }
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Librarian", "root", "PHW#84#jeor");
            String sql = "INSERT INTO element (KiHieuHoaHoc, SoHieuNguyenTu, SoKhoi, PhanLoai, TenNguyenTu, MoTa, IDDanhPhap, HinhMinhHoa) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, kiHieuHoaHoc);
            preparedStatement.setString(2, soHieuNguyenTu);
            preparedStatement.setString(3, soKhoi);
            preparedStatement.setString(4, phanLoai);
            preparedStatement.setString(5, tenNguyenTu);
            preparedStatement.setString(6, moTa);
            preparedStatement.setString(7, idDanhPhap);
            if (imageBytes != null) {
                preparedStatement.setBytes(8, imageBytes);
            } else {
                preparedStatement.setNull(8, java.sql.Types.BLOB);
            }
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data inserted successfully");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error inserting data: " + ex.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ElementForm().setVisible(true);
            }
        });
    }
}
