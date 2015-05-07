package uebung09;

import javax.swing.*;
/*import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.JTextArea;*/

public class MainFrame extends JFrame {
	private JTextField firstPossibleDayField;
	private JTextField lastPossibleDayField;
	private JTextField numberOfNightsField;
	private JButton searchButton;
	private JButton cancelButton;
	private JTextArea outputArea;
	
	public MainFrame() {
		setTitle("Urlaubsbuchung im Jahr " + Date.YEAR);
		setSize(728, 312);
		setResizable(false);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblErsterMglicherUrlaubstag = new JLabel("Erster m\u00F6glicher Urlaubstag:");
		lblErsterMglicherUrlaubstag.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErsterMglicherUrlaubstag.setBounds(65, 65, 196, 14);
		getContentPane().add(lblErsterMglicherUrlaubstag);
		
		JLabel lblAnzahlGewnschterbernachtungen = new JLabel("Anzahl gew\u00FCnschter \u00DCbernachtungen:");
		lblAnzahlGewnschterbernachtungen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAnzahlGewnschterbernachtungen.setBounds(6, 175, 255, 14);
		getContentPane().add(lblAnzahlGewnschterbernachtungen);
		
		JLabel lblLetzterMglicherUrlaubstag = new JLabel("Letzter m\u00F6glicher Urlaubstag:");
		lblLetzterMglicherUrlaubstag.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLetzterMglicherUrlaubstag.setBounds(47, 117, 214, 14);
		getContentPane().add(lblLetzterMglicherUrlaubstag);
		
		JLabel lblttmmyyyy = new JLabel("(TT.MM.)");
		lblttmmyyyy.setBounds(364, 65, 95, 14);
		getContentPane().add(lblttmmyyyy);
		
		JLabel lblttmm = new JLabel("(TT.MM.)");
		lblttmm.setBounds(364, 118, 95, 14);
		getContentPane().add(lblttmm);
		
		firstPossibleDayField = new JTextField();
		firstPossibleDayField.setBounds(268, 62, 86, 20);
		getContentPane().add(firstPossibleDayField);
		firstPossibleDayField.setColumns(10);
		
		lastPossibleDayField = new JTextField();
		lastPossibleDayField.setBounds(268, 115, 86, 20);
		getContentPane().add(lastPossibleDayField);
		lastPossibleDayField.setColumns(10);
		
		numberOfNightsField = new JTextField();
		numberOfNightsField.setBounds(269, 173, 86, 20);
		getContentPane().add(numberOfNightsField);
		numberOfNightsField.setColumns(10);
		
		searchButton = new JButton("Suchen");
		searchButton.setBounds(79, 235, 89, 23);
		getContentPane().add(searchButton);
		
		cancelButton = new JButton("Abbrechen");
		cancelButton.setBounds(258, 235, 102, 23);
		getContentPane().add(cancelButton);
		
		outputArea = new JTextArea();
		outputArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(outputArea);
		scrollPane.setBounds(432, 43, 241, 210);
		getContentPane().add(scrollPane);
		
		JLabel lblVerfgbareApartments = new JLabel("Verf\u00FCgbare Apartments:");
		lblVerfgbareApartments.setBounds(432, 25, 187, 14);
		getContentPane().add(lblVerfgbareApartments);
	}

	public JTextField getFirstPossibleDayField() {
		return firstPossibleDayField;
	}

	public JTextField getLastPossibleDayField() {
		return lastPossibleDayField;
	}

	public JTextField getNumberOfNightsField() {
		return numberOfNightsField;
	}

	public JButton getSearchButton() {
		return searchButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JTextArea getOutputArea() {
		return outputArea;
	}

}
