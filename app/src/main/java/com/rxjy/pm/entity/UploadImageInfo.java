package com.rxjy.pm.entity;

import com.luck.picture.lib.entity.LocalMedia;

import java.util.List;

/**
 * Created by AAA on 2018/2/1.
 */

public class UploadImageInfo {
    private String icCardUp;
    private String icCardDown;
    private String bankCardUp;
    private List<LocalMedia>  medicalExaminationReport;
    private String artisticPhoto;
    private String identificationPhoto;

    public String getIcCardUp() {
        return icCardUp;
    }

    public void setIcCardUp(String icCardUp) {
        this.icCardUp = icCardUp;
    }

    public String getIcCardDown() {
        return icCardDown;
    }

    public void setIcCardDown(String icCardDown) {
        this.icCardDown = icCardDown;
    }

    public String getBankCardUp() {
        return bankCardUp;
    }

    public void setBankCardUp(String bankCardUp) {
        this.bankCardUp = bankCardUp;
    }

    public List<LocalMedia> getMedicalExaminationReport() {
        return medicalExaminationReport;
    }

    public void setMedicalExaminationReport(List<LocalMedia> medicalExaminationReport) {
        this.medicalExaminationReport = medicalExaminationReport;
    }

    public String getArtisticPhoto() {
        return artisticPhoto;
    }

    public void setArtisticPhoto(String artisticPhoto) {
        this.artisticPhoto = artisticPhoto;
    }

    public String getIdentificationPhoto() {
        return identificationPhoto;
    }

    public void setIdentificationPhoto(String identificationPhoto) {
        this.identificationPhoto = identificationPhoto;
    }
}
