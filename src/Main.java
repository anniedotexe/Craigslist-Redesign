import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

import java.util.Arrays;
import java.util.List;


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

        // CITIES
        ComboBox<String> cityComboBox = new ComboBox<>();
        cityComboBox.getItems().addAll("Alhambra, CA", "Arcadia, CA", "Azusa, CA", "Baldwin Park, CA",
                "Beverly Hills, CA", "Calabasas, CA", "Compton, CA", "Covina, CA", "Duarte, CA", "El Monte, CA",
                "Glendale, CA", "Glendora, CA", "Harbor City, CA", "Inglewood, CA", "La Puente, CA",
                "Lakewood, CA", "Lancaster, CA", "Lomita, CA", "Los Angeles, CA", "Malibu, CA",
                "Monrovia, CA", "Montebello, CA", "Northridge, CA", "Palmdale, CA", "Pasadena, CA",
                "Pomona, CA", "Rosemead, CA", "San Dimas, CA", "San Gabriel, CA", "San Marino, CA",
                "Santa Monica, CA", "Studio City, CA", "Sunland, CA", "Temple City, CA", "Torrance, CA",
                "Valencia, CA", "Venice, CA", "Walnut, CA", "West Covina, CA", "Whittier, CA");
        cityComboBox.getSelectionModel().select("Los Angeles, CA");
        cityComboBox.setPrefWidth(240);
        cityComboBox.setStyle("-fx-font-size: 16pt;");

        cityComboBox.setOnMouseEntered(event -> cityComboBox.setStyle("-fx-background-color: #C6C8E2; -fx-font-size: 16pt"));
        cityComboBox.setOnMouseExited(event -> cityComboBox.setStyle("-fx-font-size: 16pt"));

        HBox cityComboHBox = new HBox(cityComboBox);
        cityComboHBox.setPadding(new Insets(45,0,0,380));

        // SEARCH BAR
        TextField searchBar = new TextField();
        searchBar.setFocusTraversable(false);
        searchBar.setPromptText("Search craigslist");
        searchBar.setStyle("-fx-font-size: 16pt");
        searchBar.setPrefWidth(530);

        HBox searchBarHBox = new HBox(searchBar);
        searchBarHBox.setPadding(new Insets(32, 0, 0, 20));

        //HELP, ACCOUNT, NEW POST BUTTONS
        Button help = new Button("Help");
        Button account = new Button("Account");
        Button post = new Button("NEW POST");
        post.setStyle("-fx-text-fill: white; -fx-background-color: #243E90");

        help.setOnMouseEntered(event -> help.setStyle("-fx-background-color: #C6C8E2"));
        help.setOnMouseExited(event -> help.setStyle("-fx-text-fill: #243E90; -fx-background-color: white"));

        account.setOnMouseEntered(event -> account.setStyle("-fx-background-color: #C6C8E2"));
        account.setOnMouseExited(event -> account.setStyle("-fx-text-fill: #243E90; -fx-background-color: white"));

        post.setOnMouseEntered(event -> post.setStyle("-fx-background-color: #C6C8E2"));
        post.setOnMouseExited(event -> post.setStyle("-fx-text-fill: white; -fx-background-color: #243E90"));

        HBox buttonsHBox = new HBox(help, account, post);
        buttonsHBox.setSpacing(30);
        buttonsHBox.setPadding(new Insets(34, 0, 0, 150));


        // LANGUAGES
        ComboBox<String> languageComboBox = new ComboBox<>();
        // Top 10 languages used on the web 2020
        languageComboBox.getItems().addAll("ENG", "CHN", "SPN", "ARA", "POR", "IND", "MAL", "JPN", "RUS", "FRA", "DEU");
        languageComboBox.getSelectionModel().selectFirst();
        languageComboBox.setPrefWidth(120);
        languageComboBox.setStyle("-fx-font-size: 16pt");

        languageComboBox.setOnMouseEntered(event -> languageComboBox.setStyle("-fx-background-color: #C6C8E2; -fx-font-size: 16pt"));
        languageComboBox.setOnMouseExited(event -> languageComboBox.setStyle("-fx-font-size: 16pt"));

        HBox langComboHBox = new HBox(languageComboBox);
        langComboHBox.setAlignment(Pos.TOP_RIGHT);
        langComboHBox.setPadding(new Insets(33,0,0,10));

        HBox topRowHBox = new HBox(cityComboHBox, searchBarHBox, buttonsHBox, langComboHBox);

        // CATEGORIES HOVER
        Label forSale = new Label("For Sale");
        Label housing = new Label("Housing");
        Label services = new Label("Services");
        Label jobs = new Label("Jobs");
        Label tempWork = new Label("Temporary Work");
        Label resumes = new Label("Resumes");
        Label community = new Label("Community");
        Label discussions = new Label("Discussions");

        forSale.setOnMouseEntered(event -> forSale.setStyle("-fx-background-color: #C6C8E2"));
        forSale.setOnMouseExited(event -> forSale.setStyle(""));

        VBox categoryLabelsVBox = new VBox(forSale, housing, services, jobs, tempWork, resumes, community, discussions);
        categoryLabelsVBox.setPadding(new Insets(45, 0, 0, 95));
        categoryLabelsVBox.setStyle("-fx-font-size: 18pt;");


        VBox fullVBox = new VBox(topRowHBox, categoryLabelsVBox);

        StackPane stack = new StackPane(pictureVBox, fullVBox);

        Scene scene = new Scene(stack, 1800, 1000);

        scene.getStylesheets().add("style.css");

        primaryStage.setScene(scene);

        primaryStage.setTitle("Craigslist Redesign");

        primaryStage.show();
    }
}
