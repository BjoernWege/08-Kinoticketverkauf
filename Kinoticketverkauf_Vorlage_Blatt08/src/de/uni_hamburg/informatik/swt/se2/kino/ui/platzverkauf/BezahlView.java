package de.uni_hamburg.informatik.swt.se2.kino.ui.platzverkauf;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.*;

public class BezahlView {
	public final JDialog _dialog;
	public final JLabel _summeLabel;
	public final JTextField _eingabefeld;
	public final JLabel _ausgabeLabel;
	public final JPanel _buttonPanel;
	public final JButton _OKButton;
	public final JButton _abbrechenButton;

	
	public BezahlView() {
		Frame parent = null; // fragwürdig
		_dialog = new JDialog(parent,"Barzahlung",true);
		
		_summeLabel = new JLabel();
		_eingabefeld = new JTextField();
		_ausgabeLabel = new JLabel();
		_buttonPanel = new JPanel();
		
		_OKButton = new JButton("OK");
		_abbrechenButton = new JButton("Abbrechen");
		
		dialogStrukturieren();
		buttonPanelStrukturieren();		
	}
	
	public void dialogStrukturieren() {
		GridLayout einzelSpalte = new GridLayout(4, 1); 
		_dialog.setLayout(einzelSpalte);
		_dialog.add(_summeLabel);
		_dialog.add(_eingabefeld);
		_dialog.add(_ausgabeLabel);
		_dialog.add(_buttonPanel);
	}
	
	public void buttonPanelStrukturieren() {
		_buttonPanel.setLayout(new FlowLayout());
		_buttonPanel.add(_OKButton);
		_buttonPanel.add(_abbrechenButton);
	}
	
	
}
