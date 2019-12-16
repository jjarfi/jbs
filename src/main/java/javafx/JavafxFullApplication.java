package javafx;

import javafx.Controller.AppsController;
import javafx.Function.Fungsi;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JavafxFullApplication  extends Application {

	private final Logger loger = LoggerFactory.getLogger(this.getClass());

	private ApplicationContext springContext = null;

	private static String[] argumen;



	@Override
	public void start(Stage primaryStage) {
		Task<Object> task = new Task<Object>() {
			@Override
			protected Object call() {
				springContext = SpringApplication.run(JavafxFullApplication.class, argumen);
				return null;
			}

		};

		task.setOnSucceeded(e -> {
			this.loger.info("Running Application Success ....");
			AppsController con  = springContext.getBean(AppsController.class);
			Parent parent = (Parent) con.initView();
			Scene scene = new Scene(parent);
			primaryStage.setScene(scene);
			primaryStage.setTitle(Fungsi.APPNAME);
			primaryStage.getIcons().add(new Image(getClass().getResource(Fungsi.ICON).toExternalForm()));
			primaryStage.setResizable(true);
			primaryStage.show();
		});
		task.setOnFailed(e -> {
			this.loger.error("Application Stop ...");
			System.exit(0);
			Platform.exit();
		});

		task.run();
	}

	public static void main(String[] args) {
		JavafxFullApplication.argumen = args;
		launch(args);

	}
}
