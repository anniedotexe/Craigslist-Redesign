import javafx.application.Application;
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

        Image topWithSearchBar = new Image("file:images/top-with-search.png");
        ImageView viewTopWithSearchBar = new ImageView(topWithSearchBar);
        HBox topWithSearchBarHBox = new HBox(viewTopWithSearchBar);
        topWithSearchBarHBox.setAlignment(Pos.CENTER);

        VBox pictureVBox = new VBox(topWithSearchBarHBox);
        pictureVBox.setSpacing(70);


        ComboBox<String> languageComboBox = new ComboBox<>();
        // Top 10 languages used on the web 2020
        languageComboBox.getItems().addAll("ENG", "CHN", "SPN", "ARA", "POR", "IND", "MAL", "JPN", "RUS", "FRA", "DEU");
        languageComboBox.getSelectionModel().selectFirst();
        languageComboBox.setPrefWidth(115);
        languageComboBox.setStyle("-fx-font-size: 15pt");

        HBox langComboHBox = new HBox(languageComboBox);
        langComboHBox.setAlignment(Pos.TOP_RIGHT);
        langComboHBox.setPadding(new Insets(10,0,0,510));

        TextField searchBar = new TextField();
        searchBar.setFocusTraversable(false);
        searchBar.setPromptText("Search craigslist");
        searchBar.setStyle("-fx-font-size: 16pt;");
        searchBar.setPrefWidth(350);


        HBox searchHBox = new HBox(searchBar);
        searchHBox.setPadding(new Insets(10, 0, 0, 315));

        HBox searchAndLangHBox = new HBox(searchHBox, langComboHBox);


        ComboBox cityComboBox = new ComboBox();
        cityComboBox.getItems().addAll("Acton", "Agoura Hills", "Alhambra", "Altadena", "Arcadia", "Artesia",
                "Avalon", "Azusa", "Baldwin Park", "Bell Gardens", "Bellflower", "Beverly Hills", "Burbank",
                "Calabasas", "Canoga Park", "Canyon Country", "Carson", "Castaic", "Cerritos", "Chatsworth",
                "Claremont", "Compton", "Covina", "Culver City", "Diamond Bar", "Downey", "Duarte", "El Monte",
                "El Segundo", "Encino", "Gardena", "Glendale", "Glendora", "Granada Hills", "Hacienda Heights",
                "Harbor City", "Hawaiian Gardens", "Hawthorne", "Hermosa Beach", "Huntington Park", "Inglewood",
                "La Canada Flintridge", "La Crescenta", "La Mirada", "La Puente", "La Verne", "Lake Hughes",
                "Lakewood", "Lancaster", "Lawndale", "Littlerock", "Llano", "Lomita", "Long Beach", "Los Angeles",
                "Lynwood", "Malibu", "Manhattan Beach", "Marina Del Rey", "Maywood", "Mission Hills", "Monrovia",
                "Montebello", "Monterey Park", "Montrose", "Mount Wilson", "Newhall", "North Hills", "North Hollywood",
                "Northridge", "Norwalk", "Pacific Palisades", "Pacoima", "Palmdale", "Palos Verdes Peninsula",
                "Panorama City", "Paramount", "Pasadena", "Pearblossom", "Pico Rivera", "Playa Del Rey", "Playa Vista",
                "Pomona", "Porter Ranch", "Rancho Palos Verdes", "Redondo Beach", "Reseda", "Rosemead",
                "Rowland Heights", "San Dimas", "San Fernando", "San Gabriel", "San Marino", "San Pedro",
                "Santa Clarita", "Santa Fe Springs", "Santa Monica", "Sherman Oaks", "Sierra Madre", "Signal Hill",
                "South El Monte", "South Gate", "South Pasadena", "Stevenson Ranch", "Studio City", "Sun Valley",
                "Sunland", "Sylmar", "Tarzana", "Temple City", "Topanga", "Torrance", "Tujunga", "Valencia",
                "Valley Village", "Valyermo", "Van Nuys", "Venice", "Verdugo City", "Walnut", "West Covina",
                "West Hills", "West Hollywood", "Whittier", "Wilmington", "Winnetka", "Woodland Hills");
        cityComboBox.getSelectionModel().select("Los Angeles");
        cityComboBox.setPrefWidth(195);

        HBox cityComboHBox = new HBox(cityComboBox);
        cityComboHBox.setPadding(new Insets(10,0,0,40));
        cityComboHBox.setStyle("-fx-font-size: 11pt");

        VBox javafxVBox = new VBox(searchAndLangHBox, cityComboHBox);

        StackPane stack = new StackPane(pictureVBox, javafxVBox);
        stack.setPadding(new Insets(20, 0, 0, 0));

        Scene scene = new Scene(stack, 1300, 800);

        scene.getStylesheets().add("style.css");

        primaryStage.setScene(scene);

        primaryStage.setTitle("Craigslist Redesign");

        primaryStage.show();
    }
}
