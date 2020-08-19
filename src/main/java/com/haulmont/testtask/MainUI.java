package com.haulmont.testtask;

import com.haulmont.testtask.components.DoctorComponent;
import com.haulmont.testtask.components.PatientComponent;
import com.haulmont.testtask.components.PrescriptionComponent;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.PushStateNavigation;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;


@PushStateNavigation
@Theme(ValoTheme.THEME_NAME)
public class MainUI extends UI {

    private PrescriptionComponent prescriptionComponent = new PrescriptionComponent();
    private PatientComponent patientComponent = new PatientComponent();
    private DoctorComponent doctorComponent = new DoctorComponent();

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout mainLayout = new VerticalLayout();
        TabSheet tabSheet = new TabSheet();
        tabSheet.addTab(patientComponent, "Пациенты");
        tabSheet.addTab(doctorComponent, "Доктора");
        tabSheet.addTab(prescriptionComponent, "Рецепты");
        mainLayout.addComponent(tabSheet);

        tabSheet.addSelectedTabChangeListener(selectedTabChangeEvent -> {
            if (tabSheet.getSelectedTab() instanceof PrescriptionComponent ||  tabSheet.getSelectedTab() instanceof PatientComponent){
                doctorComponent.hideStatistic();
            }
        });

        tabSheet.setSizeFull();
        mainLayout.setSizeFull();
        setContent(mainLayout);

    }



}