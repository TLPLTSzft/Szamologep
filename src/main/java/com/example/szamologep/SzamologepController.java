package com.example.szamologep;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SzamologepController {
	@FXML
	private TextField elsoSzam;
	@FXML
	private TextField masodikSzam;
	@FXML
	private Button osszeadasGomb;
	@FXML
	private Button kivonasGomb;
	@FXML
	private Button szorzasGomb;
	@FXML
	private Button osztasGomb;
	@FXML
	private Button szazalekGomb;
	@FXML
	private Label eredmeny;
	
	Double elsoSzamErtek;
	Double masodikSzamErtek;
	String hiba;
	Boolean helyesE;
	
	private boolean szamHelyesE() {
		helyesE = true;
		hiba = "";
		if (elsoSzam.getText().length() == 0) {
			hiba += "\n'1. szám' megadása kötelező";
		} else {
			try {
				elsoSzamErtek = Double.parseDouble(elsoSzam.getText());
			} catch (NumberFormatException e) {
				hiba += "\n'1. szám' csak szám lehet";
			}
		}
		if (masodikSzam.getText().length() == 0) {
			hiba += "\n'2. szám' megadása kötelező";
		} else {
			try {
				masodikSzamErtek = Double.parseDouble(masodikSzam.getText());
			} catch (NumberFormatException e) {
				hiba += "\n'2. szám' csak szám lehet";
			}
		}
		if (!hiba.equals("")) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setContentText(hiba);
			alert.show();
			helyesE = false;
		}
		return helyesE;
	}
	
	@FXML
	public void osszeadas(ActionEvent actionEvent) {
		if (szamHelyesE()) {
			eredmeny.setText(String.format("%.2f", elsoSzamErtek + masodikSzamErtek));
		}
	}
	
	@FXML
	public void kivonas(ActionEvent actionEvent) {
		if (szamHelyesE()) {
			eredmeny.setText(String.format("%.2f", elsoSzamErtek - masodikSzamErtek));
		}
	}
	
	@FXML
	public void szorzas(ActionEvent actionEvent) {
		if (szamHelyesE()) {
			eredmeny.setText(String.format("%.2f", elsoSzamErtek * masodikSzamErtek));
		}
	}
	
	@FXML
	public void osztas(ActionEvent actionEvent) {
		if (szamHelyesE()) {
			eredmeny.setText(String.format("%.2f", elsoSzamErtek / masodikSzamErtek));
		}
	}
	
	@FXML
	public void maradekosOsztas(ActionEvent actionEvent) {
		if (szamHelyesE()) {
			eredmeny.setText(String.format("%.2f", elsoSzamErtek % masodikSzamErtek));
		}
	}
	
	@FXML
	public void eredmenyTorlese(Event event) {
		eredmeny.setText("");
	}
	
}