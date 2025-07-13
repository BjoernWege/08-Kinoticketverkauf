package de.uni_hamburg.informatik.swt.se2.kino.ui.platzverkauf;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import de.uni_hamburg.informatik.swt.se2.kino.model.wertobjekte.Geldbetrag;

public class BezahlController
{
    private BezahlView _view;
    private Geldbetrag _zahlBetrag;
    private boolean _wurdeBestaetigt;

    public BezahlController()
    {
        _view = new BezahlView();
        // wenn man dies annimmt, muss man keinen Event Handler für 
        // Weg-X-en und Abbruch schreiben, sondern nur für OK.
        _wurdeBestaetigt = false;
        registriereUIAktionen();
    }

    /**
     *  Blockiert durch den JDialog zur Rückgeldberechnung andere Eingaben,
     *  bis er geschlossen wird.
     * @param geld Der zu zahlende Preis.
     * @return Ob OK gedrückt, oder der Dialog anders verlassen wurde.
     */
    public boolean fuehreBezahlungDurch(Geldbetrag zahlBetrag)
    {
        _zahlBetrag = zahlBetrag;

        _view._dialog.setVisible(true);
        // der Dialog wird geschlossen
        return _wurdeBestaetigt;
    }

    private void registriereUIAktionen()
    {
        _view._OKButton.addActionListener(e -> {
            _view._dialog.setVisible(false);
            _wurdeBestaetigt = true;
        });
        _view._abbrechenButton.addActionListener(e -> {
            _view._dialog.setVisible(false);
            _wurdeBestaetigt = false;
        });
        _view._eingabefeld.addKeyListener(new KeyAdapter()
        {
            public void keyTyped(KeyEvent e)
            {
                aktualisiereAusgabe();
            }
        });
    }

    private void aktualisiereAusgabe()
    {
        /*
        String eingabe = _view._eingabefeld.getText();
        if (Geldbetrag.istEingabeGueltig(eingabe)) {
        	Geldbetrag bezahlt = Geldbetrag.fromString(eingabe);
        	if (true) {
        		_view._ausgabeLabel.setText("");
        	}
        } else {
        	_view._ausgabeLabel.setText("");
        }
        */
    }

}
