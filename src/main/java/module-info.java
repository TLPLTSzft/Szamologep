module com.example.szamologep {
	requires javafx.controls;
	requires javafx.fxml;
	
	
	opens com.example.szamologep to javafx.fxml;
	exports com.example.szamologep;
}