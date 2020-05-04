import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Image theImage = new Image("file:images/full.jpg");
        ImageView viewTheImage = new ImageView(theImage);
        HBox theImageHBox = new HBox(viewTheImage);
        theImageHBox.setAlignment(Pos.CENTER);

        VBox pictureVBox = new VBox(theImageHBox);
        pictureVBox.setSpacing(70);


        ComboBox cityComboBox = new ComboBox();
        cityComboBox.getItems().addAll("Acton", "Agoura Hills", "Alhambra", "Altadena", "Arcadia", "Artesia",
                "Avalon", "Azusa", "Baldwin Park", "Bell Gardens", "Bellflower", "Beverly Hills", "Burbank",
                "Calabasas", "Canoga Park", "Carson", "Cerritos", "Claremont", "Compton", "Covina",
                "Culver City", "Diamond Bar", "Downey", "Duarte", "El Monte", "El Segundo", "Encino", "Gardena",
                "Glendale", "Glendora", "Hacienda Heights", "Harbor City", "Hawthorne", "Hermosa Beach", "Inglewood",
                "La Mirada", "La Puente", "La Verne", "Lake Hughes", "Lakewood", "Lancaster", "Littlerock", "Lomita",
                "Long Beach", "Los Angeles", "Malibu", "Marina Del Rey", "Maywood", "Mission Hills", "Monrovia",
                "Montebello", "Monterey Park", "Newhall", "North Hills", "North Hollywood", "Northridge", "Norwalk",
                "Palmdale", "Panorama City", "Paramount", "Pasadena", "Pico Rivera", "Playa Del Rey", "Playa Vista",
                "Pomona", "Porter Ranch", "Redondo Beach", "Reseda", "Rosemead", "San Dimas", "San Gabriel",
                "San Marino", "San Pedro", "Santa Clarita", "Santa Monica", "Sherman Oaks",
                "Sierra Madre", "South El Monte", "South Gate", "South Pasadena", "Studio City", "Sun Valley",
                "Sunland", "Sylmar", "Temple City", "Topanga", "Torrance", "Valencia",
                "Van Nuys", "Venice", "Walnut", "West Covina", "West Hollywood", "Whittier");

        cityComboBox.getSelectionModel().select("Los Angeles");
        cityComboBox.setPrefWidth(240);
        cityComboBox.setStyle("-fx-font-size: 16pt;");

        HBox cityComboHBox = new HBox(cityComboBox);
        cityComboHBox.setPadding(new Insets(45,0,0,380));


        TextField searchBar = new TextField();
        searchBar.setFocusTraversable(false);
        searchBar.setPromptText("Search craigslist");
        searchBar.setStyle("-fx-font-size: 16pt");
        searchBar.setPrefWidth(530);


        HBox searchBarHBox = new HBox(searchBar);
        searchBarHBox.setPadding(new Insets(32, 0, 0, 25));

        ComboBox<String> languageComboBox = new ComboBox<>();
        // Top 10 languages used on the web 2020
        languageComboBox.getItems().addAll("ENG", "CHN", "SPN", "ARA", "POR", "IND", "MAL", "JPN", "RUS", "FRA", "DEU");
        languageComboBox.getSelectionModel().selectFirst();
        languageComboBox.setPrefWidth(120);
        languageComboBox.setStyle("-fx-font-size: 16pt");

//        // changing color of combobox text still does not work
//        languageComboBox.setOnMouseEntered(new EventHandler<MouseEvent>() {
//
//            @Override
//            public void handle(MouseEvent event) {
//                languageComboBox.setStyle("-fx-fill: orange; -fx-font-size: 16pt");
//            }
//
//        });
//        languageComboBox.setOnMouseExited(new EventHandler<MouseEvent>() {
//
//            @Override
//            public void handle(MouseEvent event) {
//                languageComboBox.setStyle("-fx-font-size: 16pt");
//            }
//        });

        HBox langComboHBox = new HBox(languageComboBox);
        langComboHBox.setAlignment(Pos.TOP_RIGHT);
        langComboHBox.setPadding(new Insets(33,0,0,500));


        HBox topRowHBox = new HBox(cityComboHBox, searchBarHBox, langComboHBox);

        StackPane stack = new StackPane(pictureVBox, topRowHBox);

        Scene scene = new Scene(stack, 1800, 1000);

        scene.getStylesheets().add("style.css");

        primaryStage.setScene(scene);

        primaryStage.setTitle("Craigslist Redesign");

        primaryStage.show();
    }
}
