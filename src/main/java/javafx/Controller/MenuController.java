package javafx.Controller;

import javafx.Configuration.BootFormInitial;
import javafx.Function.Fungsi;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class MenuController implements BootFormInitial {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ApplicationContext springContext;


    @Override
    public void initConstruct() {

    }

    @Override
    public void stage(Stage primaryStage) {

    }

    @Override
    public Node initView() {
        try {
            this.logger.info("Load file fxml menu ");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(Fungsi.MENUFORM));
            loader.setController(springContext.getBean(this.getClass()));
            return loader.load();
        } catch (IOException ex) {
            this.logger.error("Load file fxml menu ", ex);
            return null;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void setApplicationContext(ApplicationContext springContext) throws BeansException {
        this.springContext = springContext;

    }

    @Override
    public void setMessageSource(MessageSource messageSource) {

    }
}
