package com.haulmont.testtask.components;

import com.haulmont.testtask.controllers.DoctorController;
import com.haulmont.testtask.entities.Doctor;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.navigator.View;
import com.vaadin.ui.Composite;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class StatisticComponent extends Composite implements View {
    private VerticalLayout fullNameLayout = new VerticalLayout();
    private VerticalLayout signedByDoctor = new VerticalLayout();
    private VerticalLayout percentageOfTotal = new VerticalLayout();
    private VerticalLayout percentageOfValid = new VerticalLayout();
    private Label fullname = new Label();
    private Label signed = new Label();
    private Label ofTotal = new Label();
    private Label valid = new Label();
    private static StatisticComponent statisticComponent = null;
    private HorizontalLayout mainLayout = new HorizontalLayout();

    private DoctorController doctorController = DoctorController.getInstance();
    ListDataProvider<Doctor> provider = DataProvider.ofCollection(doctorController.getAllDoctors());


    public StatisticComponent(){

        mainLayout.addComponents(fullNameLayout, signedByDoctor, percentageOfTotal, percentageOfValid);

        fullNameLayout.addComponents(new Label("Имя:"), fullname);
        signedByDoctor.addComponents(new Label("Подписано доктором:"), signed);
        percentageOfTotal.addComponents(new Label("Процент от общего числа:"), ofTotal);
        percentageOfValid.addComponents(new Label("Действительны:"), valid);

        HorizontalLayout subcontent = new HorizontalLayout(fullNameLayout, signedByDoctor, percentageOfTotal, percentageOfValid);

        VerticalLayout mainContent = new VerticalLayout(subcontent);
        subcontent.setSizeFull();
        mainContent.setHeight("100%");
        mainContent.setWidth("1000px");
        setCompositionRoot(mainContent);


    }


    public void setDoctorToPanel(String fullname, int signed, int oftotal, int valid){
        this.fullname.setCaption(fullname);
        this.signed.setCaption(String.valueOf(signed));
        this.ofTotal.setCaption(String.valueOf(oftotal) + "%");
        this.valid.setCaption(String.valueOf(valid));

    }
}
