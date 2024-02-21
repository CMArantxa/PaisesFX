package com.ceica.CountryJavaFX;

import com.ceica.CountryJavaFX.Models.CountryDTO;
import com.ceica.CountryJavaFX.Service.CountryService;
import com.ceica.CountryJavaFX.Service.FakeCountryService;
import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class RestCountriesController {
  @FXML
    protected ComboBox comboRegions;
  @FXML
    protected TableView<CountryDTO>countryNameTbl;
  @FXML
    protected TableColumn<CountryDTO,String>countryNameColumn;
  @FXML
    protected TextField txtcountryname;
  @FXML
    protected TextField txtcapital;
  @FXML
    protected TextField txtcoin;
  @FXML
    protected TextField txtpoblacion;
  @FXML
  protected Button btnBorrar;
  @FXML
    protected ImageView flagvista;
  @FXML
  ObservableList<CountryDTO>observableList= FXCollections.observableArrayList() ;
  @FXML

    public void btnClear(ActionEvent actionEvent) {
    observableList.clear();
    countryNameTbl.refresh();
    comboRegions.getSelectionModel().clearSelection();
    txtcountryname.clear();
    txtcapital.clear();
    txtcoin.clear();
    txtpoblacion.clear();
    flagvista.setImage(null);
    }
    @FXML
    public void initialize(){
      CountryService fakeCountryService=new CountryService();
      comboRegions.getItems().addAll(fakeCountryService.getRegions());
      countryNameColumn.setCellValueFactory(cell->new SimpleStringProperty(cell.getValue().getName()));
      comboRegions.setOnAction(e->{
        if(comboRegions.getSelectionModel().getSelectedItem()!=null) {
          String region = comboRegions.getSelectionModel().getSelectedItem().toString();
          observableList.clear();
          observableList.addAll(fakeCountryService.getCountriesByRegion(region));
          countryNameTbl.setItems(observableList);
        }
      });
      countryNameTbl.setOnMouseClicked(e->{
        String countryCca3=countryNameTbl.getSelectionModel().getSelectedItem().getCca3();
        CountryDTO countryDTO=fakeCountryService.getCountryByCca3(countryCca3);
        txtcountryname.setText(countryDTO.getName());
        txtcapital.setText(countryDTO.getCapital());
        txtcoin.setText(countryDTO.getCoin());
        txtpoblacion.setText(String.valueOf(countryDTO.getPopulation()));
        Image image=new Image(countryDTO.getFlag());
        flagvista.setImage(image);
      });
      countryNameTbl.setOnKeyPressed(e-> {
                String countryCca3 = countryNameTbl.getSelectionModel().getSelectedItem().getCca3();
                CountryDTO countryDTO = fakeCountryService.getCountryByCca3(countryCca3);
                txtcountryname.setText(countryDTO.getName());
                txtcapital.setText(countryDTO.getCapital());
                txtcoin.setText(countryDTO.getCoin());
                txtpoblacion.setText(String.valueOf(countryDTO.getPopulation()));
                Image image = new Image(countryDTO.getFlag());
                flagvista.setImage(image);
              });
      countryNameColumn.setCellValueFactory(cell->new SimpleStringProperty(cell.getValue().getName()));
    }
}