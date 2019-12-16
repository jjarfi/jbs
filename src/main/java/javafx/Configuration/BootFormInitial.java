package javafx.Configuration;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSourceAware;

public interface BootFormInitial extends Initializable, ApplicationContextAware, MessageSourceAware {
    public void initConstruct();
    public void stage(Stage primaryStage);
    public Node initView();
}
