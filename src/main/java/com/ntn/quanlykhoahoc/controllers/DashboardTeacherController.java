/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.ntn.quanlykhoahoc.controllers;


import com.ntn.quankykhoahoc.Services.KhoaHocServices;
import com.ntn.quankykhoahoc.Services.NguoiDungServices;
import com.ntn.quankykhoahoc.pojo.KhoaHoc;
import com.ntn.quanlykhoahoc.session.SessionManager;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class DashboardTeacherController implements Initializable {

    @FXML
    private Label welcomeLabel;
    @FXML
    private GridPane coursesGrid;
    @FXML
    private ScrollPane coursesScrollPane;
    @FXML
    private Button prevPageBtn, nextPageBtn, payButton, removeButton;
    @FXML
    private Label pageLabel;
    @FXML
    private TableView<String> cartTable;
    @FXML
    private TableColumn<String, String> courseColumn;

    private final int ITEMS_PER_PAGE = 12;
    private int currentPage = 1;
    private List<KhoaHoc> khoaHocList;
    private final ObservableList<String> cartCourses = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            setupGrid();
            KhoaHocServices kh = new KhoaHocServices();
            String s = SessionManager.getLoggedInEmail();
            NguoiDungServices nde = new NguoiDungServices();

            String hoTen = nde.getNguoiDungTheoEmail(s).get(0).getHo_ten();
            int id = nde.getNguoiDungTheoEmail(s).get(0).getId();
            this.khoaHocList = kh.getKhoaHocGiangVienID(id);
            loadPage(currentPage);


            welcomeLabel.setText("Welcome, " + (hoTen != null ? hoTen : "Student"));

//        String userEmail = SessionManager.getLoggedInEmail();
//        String hoTen = Database.getUserNameByEmail(userEmail);
       
            prevPageBtn.setOnAction(e -> changePage(-1));
            nextPageBtn.setOnAction(e -> changePage(1));
        } catch (SQLException ex) {
            Logger.getLogger(DashboardTeacherController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setupGrid() {
        coursesGrid.setHgap(20);
        coursesGrid.setVgap(20);
        coursesGrid.setStyle("-fx-padding: 15px;");
    }

    private void loadPage(int page) {
        coursesGrid.getChildren().clear();
        int start = (page - 1) * ITEMS_PER_PAGE;
        int end = Math.min(start + ITEMS_PER_PAGE, khoaHocList.size());

        for (int i = start; i < end; i++) {
            KhoaHoc khoaHoc = khoaHocList.get(i);
            VBox courseBox = createCourseBox(khoaHoc);
            coursesGrid.add(courseBox, i % 5, (i - start) / 5);
        }

        pageLabel.setText("Page " + page);
        prevPageBtn.setDisable(page == 1);
        nextPageBtn.setDisable(end >= khoaHocList.size());
    }

    private VBox createCourseBox(KhoaHoc khoaHoc) {
        ImageView courseImage = new ImageView();
        courseImage.setFitWidth(150);
        courseImage.setFitHeight(100);
        courseImage.setPreserveRatio(true);

        try {
            String imagePath = "/com/ntn/images/" + khoaHoc.getHinhAnh();
            InputStream imageStream = getClass().getResourceAsStream(imagePath);
            if (imageStream != null) {
                courseImage.setImage(new Image(imageStream));
            } else {
                courseImage.setImage(new Image("/com/ntn/images/default.png"));
            }
        } catch (Exception e) {
            System.out.println("⚠ Lỗi tải ảnh: " + e.getMessage());
        }

//        Button addButton = new Button("Add");
//        addButton.setOnAction(e -> addToCart(khoaHoc.getTenKhoaHoc()));
        Button actionButton;

        actionButton = new Button("Vào Khóa Học");
        actionButton.setOnAction(e -> vaoKhoaHoc());

        VBox courseBox = new VBox(10, courseImage, new Label(khoaHoc.getTenKhoaHoc()), new Label("Giảng viên: "), actionButton);
        courseBox.setStyle("-fx-border-color: #ccc; -fx-border-radius: 10px; -fx-padding: 10px; -fx-background-color: #ecf0f1;");
        courseBox.setAlignment(javafx.geometry.Pos.CENTER);

        return courseBox;
    }

    private void changePage(int delta) {
        int newPage = currentPage + delta;
        if (newPage >= 1 && newPage <= (int) Math.ceil((double) khoaHocList.size() / ITEMS_PER_PAGE)) {
            currentPage = newPage;
            loadPage(currentPage);
        }
    }

    public void vaoKhoaHoc() {

    }
    
    public void loadDash(ActionEvent e){
        
    }
    public  void loadMyCourses(ActionEvent e) {
    
            
    }
    
    public void handleLogout(ActionEvent e){
        
    }
}