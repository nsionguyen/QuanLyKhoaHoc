package com.ntn.quanlykhoahoc.controllers;


import com.ntn.quankykhoahoc.Services.KhoaHocDaDangKyServices;
import com.ntn.quankykhoahoc.Services.KhoaHocServices;
import com.ntn.quankykhoahoc.Services.NguoiDungServices;
import com.ntn.quankykhoahoc.pojo.KhoaHoc;
import com.ntn.quanlykhoahoc.App;


import com.ntn.quanlykhoahoc.session.SessionManager;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class DashboardStudentController {
//    @FXML private Label welcomeLabel;
//    @FXML private GridPane coursesGrid;
//    @FXML private ScrollPane coursesScrollPane;
//    @FXML private Button prevPageBtn, nextPageBtn, payButton, removeButton;
//    @FXML private Label pageLabel;
//    @FXML private TableView<String> cartTable;
//    @FXML private TableColumn<String, String> courseColumn;
//
//    private final int ITEMS_PER_PAGE = 12;
//    private int currentPage = 1;
//    private List<KhoaHoc> khoaHocList;
//    private final ObservableList<String> cartCourses = FXCollections.observableArrayList();
//
//    @FXML
//    public void initialize() {
//        setupGrid();
//        khoaHocList = getAllCourses();
//        loadPage(currentPage);
//        setupCartTable();
//
//        String userEmail = SessionManager.getLoggedInEmail();
//        String hoTen = Database.getUserNameByEmail(userEmail);
//        welcomeLabel.setText("Welcome, " + (hoTen != null ? hoTen : "Student"));
//
//        prevPageBtn.setOnAction(e -> changePage(-1));
//        nextPageBtn.setOnAction(e -> changePage(1));
//        payButton.setOnAction(e -> handlePay());
//        removeButton.setOnAction(e -> handleRemove());
//    }
//
//    
//    @FXML
//    private void handleLogout(ActionEvent event) throws IOException {
//        // Lấy cửa sổ hiện tại
//        Window window = ((Node) event.getSource()).getScene().getWindow();
//
//        // Đóng cửa sổ hiện tại
//        if (window instanceof Stage) {
//            ((Stage) window).close();
//        }
//
//        // Mở màn hình đăng nhập
//        Parent root = FXMLLoader.load(getClass().getResource("/com/ntn/quanlykhoahoc/views/Login.fxml"));
//        Stage stage = new Stage();
//        stage.setScene(new Scene(root));
//        stage.setTitle("Đăng nhập");
//        stage.show();
//    }
//
//    private void setupGrid() {
//        coursesGrid.setHgap(20);
//        coursesGrid.setVgap(20);
//        coursesGrid.setStyle("-fx-padding: 15px;");
//    }
//
//    private void loadPage(int page) {
//        coursesGrid.getChildren().clear();
//        int start = (page - 1) * ITEMS_PER_PAGE;
//        int end = Math.min(start + ITEMS_PER_PAGE, khoaHocList.size());
//
//        for (int i = start; i < end; i++) {
//            KhoaHoc khoaHoc = khoaHocList.get(i);
//            VBox courseBox = createCourseBox(khoaHoc);
//            coursesGrid.add(courseBox, i % 5, (i - start) / 5);
//        }
//
//        pageLabel.setText("Page " + page);
//        prevPageBtn.setDisable(page == 1);
//        nextPageBtn.setDisable(end >= khoaHocList.size());
//    }
//
//    private VBox createCourseBox(KhoaHoc khoaHoc) {
//        ImageView courseImage = new ImageView();
//        courseImage.setFitWidth(150);
//        courseImage.setFitHeight(100);
//        courseImage.setPreserveRatio(true);
//
//        try {
//            String imagePath = "/com/ntn/images/" + khoaHoc.getHinhAnh();
//            InputStream imageStream = getClass().getResourceAsStream(imagePath);
//            if (imageStream != null) {
//                courseImage.setImage(new Image(imageStream));
//            } else {
//                courseImage.setImage(new Image("/com/ntn/images/default.png"));
//            }
//        } catch (Exception e) {
//            System.out.println("⚠ Lỗi tải ảnh: " + e.getMessage());
//        }
//
//        Button addButton = new Button("Add");
//        addButton.setOnAction(e -> addToCart(khoaHoc.getTenKhoaHoc()));
//
//        VBox courseBox = new VBox(10, courseImage, new Label(khoaHoc.getTenKhoaHoc()), new Label("Giảng viên: " + khoaHoc.getTenGiangVien()), addButton);
//        courseBox.setStyle("-fx-border-color: #ccc; -fx-border-radius: 10px; -fx-padding: 10px; -fx-background-color: #ecf0f1;");
//        courseBox.setAlignment(javafx.geometry.Pos.CENTER);
//
//        return courseBox;
//    }
//
//    private void changePage(int delta) {
//        int newPage = currentPage + delta;
//        if (newPage >= 1 && newPage <= (int) Math.ceil((double) khoaHocList.size() / ITEMS_PER_PAGE)) {
//            currentPage = newPage;
//            loadPage(currentPage);
//        }
//    }
//
//    private void setupCartTable() {
//        courseColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()));
//        cartTable.setItems(cartCourses);
//    }
//
//    private void addToCart(String courseName) {
//        if (!cartCourses.contains(courseName)) {
//            cartCourses.add(courseName);
//        }
//    }
//
//    private void handlePay() {
//        cartCourses.clear();
//        System.out.println("✅ Thanh toán thành công!");
//    }
//
//    private void handleRemove() {
//        if (!cartCourses.isEmpty()) {
//            cartCourses.remove(cartCourses.size() - 1);
//        }
//    }
//
//    private List<KhoaHoc> getAllCourses() {
//        List<KhoaHoc> khoaHocList = new ArrayList<>();
//        String query = "SELECT k.id, k.tenKhoaHoc, k.moTa, k.gia, k.hinhAnh, n.ho_ten AS tenGiangVien " +
//                       "FROM khoahoc k " +
//                       "JOIN nguoidung n ON k.giangVienId = n.id " +
//                       "WHERE n.loai_nguoi_dung_id = 2"; 
//        try (Connection conn = Database.getConn();
//             PreparedStatement stmt = conn.prepareStatement(query);
//             ResultSet rs = stmt.executeQuery()) {
//
//            while (rs.next()) {
//                khoaHocList.add(new KhoaHoc(
//                    rs.getInt("id"),
//                    rs.getString("tenKhoaHoc"),
//                    rs.getString("moTa"),
//                    rs.getDouble("gia"),
//                    rs.getString("hinhAnh"),
//                    rs.getString("tenGiangVien")
//                ));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return khoaHocList;
//    }
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
    private boolean isMyCoursesMode = false; // them de thay doi add thanh vao hoc ngay

    @FXML
    public void initialize() throws SQLException {
        setupGrid();
        KhoaHocServices kh = new KhoaHocServices();
        this.khoaHocList = kh.getKhoaHocs();
        loadPage(currentPage);
        setupCartTable();
        String s = SessionManager.getLoggedInEmail();
        NguoiDungServices nde = new NguoiDungServices();

        String hoTen = nde.getNguoiDungTheoEmail(s).get(0).getHo_ten();

//        String userEmail = SessionManager.getLoggedInEmail();
//        String hoTen = JdbcUtils.getUserNameByEmail(userEmail);
        welcomeLabel.setText("Welcome, " + (hoTen != null ? hoTen : "Student"));

//        String userEmail = SessionManager.getLoggedInEmail();
//        String hoTen = Database.getUserNameByEmail(userEmail);
//        welcomeLabel.setText("Welcome, " + (hoTen != null ? hoTen : "Student"));
        prevPageBtn.setOnAction(e -> changePage(-1));
        nextPageBtn.setOnAction(e -> changePage(1));
        payButton.setOnAction(e -> handlePay());
        removeButton.setOnAction(e -> handleRemove());
    }

    @FXML
    private void handleLogout(ActionEvent event) throws IOException {
        // Lấy cửa sổ hiện tại
        Window window = ((Node) event.getSource()).getScene().getWindow();

        // Đóng cửa sổ hiện tại
        if (window instanceof Stage) {
            ((Stage) window).close();
        }

        // Mở màn hình đăng nhập
        Parent root = FXMLLoader.load(getClass().getResource("/com/ntn/quanlykhoahoc/views/Login.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Đăng nhập");
        stage.show();
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

        if (isMyCoursesMode) {
            actionButton = new Button("Học ngay");
            actionButton.setOnAction(e -> {
                try {
                    startLearning(khoaHoc.getId());
                } catch (RuntimeException ex) {
                    System.err.println("Lỗi khi mở khóa học: " + ex.getMessage());
                } catch (IOException ex) {
                    Logger.getLogger(DashboardStudentController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(DashboardStudentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        } else {
            actionButton = new Button("Add");
            actionButton.setOnAction(e -> addToCart(khoaHoc.getTenKhoaHoc()));
        }

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

    private void setupCartTable() {
        courseColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()));
        cartTable.setItems(cartCourses);
    }

    private void addToCart(String courseName) {
        if (!cartCourses.contains(courseName)) {
            cartCourses.add(courseName);
        }
    }

    private void handlePay() {
        cartCourses.clear();
        System.out.println("✅ Thanh toán thành công!");
    }

    private void handleRemove() {
        if (!cartCourses.isEmpty()) {
            cartCourses.remove(cartCourses.size() - 1);
        }
    }
// Nguyen them ......................

    public void loadMyCourses(ActionEvent e) throws SQLException {
        KhoaHocDaDangKyServices kh = new KhoaHocDaDangKyServices();

        setupGrid();
        isMyCoursesMode = true;
        String s = SessionManager.getLoggedInEmail();
        NguoiDungServices nde = new NguoiDungServices();

        int id = nde.getNguoiDungTheoEmail(s).get(0).getId();

        this.khoaHocList = kh.getKhoaHocDaDangKyTheoHocVienID(id);
        loadPage(currentPage);
        setupCartTable();

    }

    public void startLearning(int id) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/com/ntn/views/KhoaHoc.fxml"));
       Parent root = fxmlLoader.load(); // Load FXML trước
        
       Scene scene = new Scene(root);
        Stage stage = new Stage();
       stage.setScene(scene);
       stage.show();
        
       KhoaHocController controller = fxmlLoader.getController(); //  Sau khi load mới gọi getController
        controller.setIdKhoaHoc(id); // Truyền ID
        controller.loadData1(); //  Load dữ liệu sau khi đã truyền ID
        controller.loadBaiTaiTheoKhoaHocID();




    }

    public void loadDash(ActionEvent e) throws SQLException {
        isMyCoursesMode = false;
        setupGrid();
        KhoaHocServices kh = new KhoaHocServices();
        this.khoaHocList = kh.getKhoaHocs();

        loadPage(currentPage);
        setupCartTable();
        String s = SessionManager.getLoggedInEmail();
        NguoiDungServices nde = new NguoiDungServices();

        String hoTen = nde.getNguoiDungTheoEmail(s).get(0).getHo_ten();

//        String userEmail = SessionManager.getLoggedInEmail();
//        String hoTen = JdbcUtils.getUserNameByEmail(userEmail);
        welcomeLabel.setText("Welcome, " + (hoTen != null ? hoTen : "Student"));
//        
//    

    }
}
    

