package javafx.Controller;


import javafx.Configuration.BootFormInitial;
import javafx.Function.Fungsi;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class AppsController implements BootFormInitial {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private ApplicationContext springContext = null;

    @FXML
    protected StackPane menuform,listForm,toolbarForm;


    @Autowired
    private MenuController menuController;
    @Autowired
    private ListController listController;
    @Autowired
    private ToolbarController toolbarController;


    private void setNodeMenu(Node node) {
        menuform.getChildren().clear();
        menuform.getChildren().add(node);
        menuform.autosize();
    }
    private void setNodeList(Node node) {
        listForm.getChildren().clear();
        listForm.getChildren().add(node);
        listForm.autosize();
    }
    private void setNodeToolbar(Node node) {
        toolbarForm.getChildren().clear();
        toolbarForm.getChildren().add(node);
        toolbarForm.autosize();
    }



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
            loader.setLocation(getClass().getResource(Fungsi.APPMAINFORM));
            loader.setController(springContext.getBean(this.getClass()));
            return loader.load();
        } catch (IOException ex) {
            this.logger.error("Load file fxml menu ", ex);
            return null;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadMenu();
        loadList();
        loadToolbar();

    }

    @Override
    public void setApplicationContext(ApplicationContext springContext) throws BeansException {
        this.springContext = springContext;

    }

    @Override
    public void setMessageSource(MessageSource messageSource) {

    }

    private void loadMenu() {
        try {
            setNodeMenu(menuController.initView());
            menuController.initConstruct();
        } catch (Exception e) {
            this.logger.error("Error di ", e);
        }
    }
    private void loadList(){
        try {
            setNodeList(listController.initView());
            listController.initConstruct();
        } catch (Exception e) {
            this.logger.error("Error di ", e);
        }
    }
    private void loadToolbar(){
        try {
            setNodeToolbar(toolbarController.initView());
            toolbarController.initConstruct();
        } catch (Exception e) {
            this.logger.error("Error di ", e);
        }
    }

}
