module ap4b {
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	requires JavaFXSmartGraph;
	
	opens fr.utbm.ap4b.controller to javafx.fxml;
	exports fr.utbm.ap4b to javafx.graphics;
}