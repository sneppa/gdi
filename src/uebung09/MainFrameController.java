package uebung09;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameController implements ActionListener {

	private MainFrame frame;
	private Matcher matcher;
	private Apartment[] apartments;

	public MainFrameController(MainFrame frame) {
		this.frame = frame;
		frame.getSearchButton().addActionListener(this);
		frame.getCancelButton().addActionListener(this);
		this.matcher = new MatcherImplementation();
		this.apartments = matcher.readApartments("apartmentsEinfach.txt");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == frame.getSearchButton()) {
			boolean inputOk = true;
			
			Date from = null;
			try {
				String[] parts = frame.getFirstPossibleDayField().getText().split("\\.");
				int day = Integer.parseInt(parts[0]);
				int month = Integer.parseInt(parts[1]);
				from = new Date(day, month);
				frame.getFirstPossibleDayField().setBackground(Color.WHITE);
			} catch (Exception e1) {
				frame.getFirstPossibleDayField().setBackground(Color.RED);
				inputOk = false;
			}
			
			Date to = null;
			try {
				String[] parts = frame.getLastPossibleDayField().getText().split("\\.");
				int day = Integer.parseInt(parts[0]);
				int month = Integer.parseInt(parts[1]);
				to = new Date(day, month);
				frame.getLastPossibleDayField().setBackground(Color.WHITE);
			} catch (Exception e1) {
				frame.getLastPossibleDayField().setBackground(Color.RED);
				inputOk = false;
			}
			
			int numberOfNights = 0;
			try {
				numberOfNights = Integer.parseInt(frame.getNumberOfNightsField().getText());
				frame.getNumberOfNightsField().setBackground(Color.WHITE);
			} catch (NumberFormatException e1) {
				frame.getNumberOfNightsField().setBackground(Color.RED);
				inputOk = false;
			}
			
			if (inputOk) {
				Match[] matches = matcher.determineAvailableApartments(apartments, 
						from, to, numberOfNights);

				String output = "";
				for (int i = 0; i < matches.length; i++)
					output += matches[i] + "\n";
				frame.getOutputArea().setText(output);
			}
		} else if (e.getSource() == frame.getCancelButton()) {
			frame.dispose();
		}
	}

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		new MainFrameController(frame);
		
		frame.setVisible(true);
	}

}
