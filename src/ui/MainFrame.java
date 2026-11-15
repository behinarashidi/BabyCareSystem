package ui;

import model.*;
import data.VaccineData;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class MainFrame extends JFrame {
    private JTextField nameField, ageField, weightField;
    private JTextArea resultArea;
    private Baby currentBaby;
    private List<Vaccine> currentVaccines;

    public MainFrame() {
        setTitle("🍼 پنل مدیریت واکسیناسیون نوزاد");
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 15));

        Font labelFont = new Font("Tahoma", Font.BOLD, 14);
        Font inputFont = new Font("Tahoma", Font.PLAIN, 14);

        JPanel pnlInput = new JPanel(new GridLayout(3, 2, 10, 15));
        pnlInput.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        pnlInput.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        pnlInput.add(createLabel("نام نوزاد:", labelFont));
        nameField = createTextField(inputFont);
        pnlInput.add(nameField);

        pnlInput.add(createLabel("سن (ماه):", labelFont));
        ageField = createTextField(inputFont);
        pnlInput.add(ageField);

        pnlInput.add(createLabel("وزن (kg):", labelFont));
        weightField = createTextField(inputFont);
        pnlInput.add(weightField);

        JPanel pnlButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        pnlButtons.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

        JButton btnShow = new JButton("مشاهده گزارش");
        btnShow.setPreferredSize(new Dimension(150, 40));
        btnShow.addActionListener(e -> generateReportAction());

        JButton btnSave = new JButton("ذخیره در فایل");
        btnSave.setPreferredSize(new Dimension(150, 40));
        btnSave.addActionListener(e -> saveToFileAction());

        pnlButtons.add(btnShow);
        pnlButtons.add(btnSave);

        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(pnlInput, BorderLayout.CENTER);
        northPanel.add(pnlButtons, BorderLayout.SOUTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
        resultArea.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        resultArea.setMargin(new Insets(10, 10, 10, 10));
        JScrollPane scroll = new JScrollPane(resultArea);

        add(northPanel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        return label;
    }

    private JTextField createTextField(Font font) {
        JTextField tf = new JTextField();
        tf.setFont(font);
        tf.setHorizontalAlignment(JTextField.RIGHT);
        return tf;
    }

    private void generateReportAction() {
        try {
            String name = nameField.getText().trim();
            int age = Integer.parseInt(ageField.getText().trim());
            double weight = Double.parseDouble(weightField.getText().trim());

            currentBaby = new Baby(name, age, weight);
            VaccineSchedule schedule = new VaccineSchedule(VaccineData.getAllVaccines());
            currentVaccines = schedule.getVaccinesForMonth(age);

            resultArea.setText(currentBaby.generateFullReport(currentVaccines));
            resultArea.setCaretPosition(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "لطفاً تمام فیلدها را با اعداد درست پر کنید.", "خطا", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveToFileAction() {
        if (currentBaby == null) {
            JOptionPane.showMessageDialog(this, "ابتدا گزارش را تولید کنید.");
            return;
        }

        String fileName = currentBaby.getName() + "_Report.txt";
        try (Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileName), StandardCharsets.UTF_8))) {
            out.write(currentBaby.generateFullReport(currentVaccines));
            JOptionPane.showMessageDialog(this, "فایل با موفقیت ذخیره شد:\n" + fileName);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "خطا در دسترسی به فایل!");
        }
    }
}
