package com.example.myapplication;

import android.text.Editable;

import java.io.Serializable;

public class Data implements Serializable {

    //Deklarasi String Detail GYM
    private String namaGym;
    private String alamatGym;

    //Deklarasi Paket Membership
    private String biaya_pendaftaran, biaya_insindental,
            biaya_satuBulan, biaya_duaBulan, biaya_tigaBulan,
            enamBulan, biayaPerpanjangan;

    public String getNamaTrainerGym() {
        return namaTrainerGym;
    }

    public void setNamaTrainerGym(String namaTrainerGym) {
        this.namaTrainerGym = namaTrainerGym;
    }

    //Deklrasi Personal Trainer
    private String biaya_5Pertemuan, biaya_10Pertemuan,
            biaya_15Pertemuan, biaya_20Pertemuan;

    private String namaTrainerGym;

    private String fasilitas,kelas, peralatan_kebugaran, gymmachine ,keunggulan_gym;

    private String imgUrl;

    public Data() {
    }

    public Data(String namaGym, String alamatGym, String biaya_pendaftaran,
                String biaya_insindental, String biaya_satuBulan,
                String biaya_duaBulan, String biaya_tigaBulan,
                String enamBulan, String biayaPerpanjangan,
                String biaya_5Pertemuan, String biaya_10Pertemuan,
                String biaya_15Pertemuan, String biaya_20Pertemuan,String namaTrainerGym,
                String imgUrl, String fasilitas, String kelas, String peralatan_kebugaran, String gymmachine, String keunggulan_gym) {

        this.namaGym = namaGym;
        this.alamatGym = alamatGym;
        this.biaya_pendaftaran = biaya_pendaftaran;
        this.biaya_insindental = biaya_insindental;
        this.biaya_satuBulan = biaya_satuBulan;
        this.biaya_duaBulan = biaya_duaBulan;
        this.biaya_tigaBulan = biaya_tigaBulan;
        this.enamBulan = enamBulan;
        this.biayaPerpanjangan = biayaPerpanjangan;
        this.biaya_5Pertemuan = biaya_5Pertemuan;
        this.biaya_10Pertemuan = biaya_10Pertemuan;
        this.biaya_15Pertemuan = biaya_15Pertemuan;
        this.biaya_20Pertemuan = biaya_20Pertemuan;
        this.namaTrainerGym = namaTrainerGym;
        this.imgUrl = imgUrl;
        this.fasilitas = fasilitas;
        this.kelas = kelas;
        this.peralatan_kebugaran = peralatan_kebugaran;
        this.gymmachine = gymmachine;
        this.keunggulan_gym = keunggulan_gym;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getPeralatan_kebugaran() {
        return peralatan_kebugaran;
    }

    public void setPeralatan_kebugaran(String peralatan_kebugaran) {
        this.peralatan_kebugaran = peralatan_kebugaran;
    }

    public String getGymmachine() {
        return gymmachine;
    }

    public void setGymmachine(String gymmachine) {
        this.gymmachine = gymmachine;
    }

    public String getKeunggulan_gym() {
        return keunggulan_gym;
    }

    public void setKeunggulan_gym(String keunggulan_gym) {
        this.keunggulan_gym = keunggulan_gym;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getNamaGym() {
        return namaGym;
    }

    public void setNamaGym(String namaGym) {
        this.namaGym = namaGym;
    }

    public String getAlamatGym() {
        return alamatGym;
    }

    public void setAlamatGym(String alamatGym) {
        this.alamatGym = alamatGym;
    }


    public String getBiaya_pendaftaran() {
        return biaya_pendaftaran;
    }

    public void setBiaya_pendaftaran(String biaya_pendaftaran) {
        this.biaya_pendaftaran = biaya_pendaftaran;
    }

    public String getBiaya_insindental() {
        return biaya_insindental;
    }

    public void setBiaya_insindental(String biaya_insindental) {
        this.biaya_insindental = biaya_insindental;
    }

    public String getBiaya_satuBulan() {
        return biaya_satuBulan;
    }

    public void setBiaya_satuBulan(String biaya_satuBulan) {
        this.biaya_satuBulan = biaya_satuBulan;
    }

    public String getBiaya_duaBulan() {
        return biaya_duaBulan;
    }

    public void setBiaya_duaBulan(String biaya_duaBulan) {
        this.biaya_duaBulan = biaya_duaBulan;
    }

    public String getBiaya_tigaBulan() {
        return biaya_tigaBulan;
    }

    public void setBiaya_tigaBulan(String biaya_tigaBulan) {
        this.biaya_tigaBulan = biaya_tigaBulan;
    }

    public String getEnamBulan() {
        return enamBulan;
    }

    public void setEnamBulan(String enamBulan) {
        this.enamBulan = enamBulan;
    }

    public String getBiayaPerpanjangan() {
        return biayaPerpanjangan;
    }

    public void setBiayaPerpanjangan(String biayaPerpanjangan) {
        this.biayaPerpanjangan = biayaPerpanjangan;
    }

    public String getBiaya_5Pertemuan() {
        return biaya_5Pertemuan;
    }

    public void setBiaya_5Pertemuan(String biaya_5Pertemuan) {
        this.biaya_5Pertemuan = biaya_5Pertemuan;
    }

    public String getBiaya_10Pertemuan() {
        return biaya_10Pertemuan;
    }

    public void setBiaya_10Pertemuan(String biaya_10Pertemuan) {
        this.biaya_10Pertemuan = biaya_10Pertemuan;
    }

    public String getBiaya_15Pertemuan() {
        return biaya_15Pertemuan;
    }

    public void setBiaya_15Pertemuan(String biaya_15Pertemuan) {
        this.biaya_15Pertemuan = biaya_15Pertemuan;
    }


    public String getBiaya_20Pertemuan() {
        return biaya_20Pertemuan;
    }



    public void setBiaya_20Pertemuan(String biaya_20Pertemuan) {
        this.biaya_20Pertemuan = biaya_20Pertemuan;
    }

    @Override
    public String toString() {
        return "Data{" +
                "namaGym='" + namaGym + '\'' +
                ", alamatGym='" + alamatGym + '\'' +
                ", biaya_pendaftaran='" + biaya_pendaftaran + '\'' +
                ", biaya_insindental='" + biaya_insindental + '\'' +
                ", biaya_satuBulan='" + biaya_satuBulan + '\'' +
                ", biaya_duaBulan='" + biaya_duaBulan + '\'' +
                ", biaya_tigaBulan='" + biaya_tigaBulan + '\'' +
                ", enamBulan='" + enamBulan + '\'' +
                ", biayaPerpanjangan='" + biayaPerpanjangan + '\'' +
                ", biaya_5Pertemuan='" + biaya_5Pertemuan + '\'' +
                ", biaya_10Pertemuan='" + biaya_10Pertemuan + '\'' +
                ", biaya_15Pertemuan='" + biaya_15Pertemuan + '\'' +
                ", biaya_20Pertemuan='" + biaya_20Pertemuan + '\'' +
                ", namaTrainerGym='" + namaTrainerGym + '\'' +
                ", fasilitas='" + fasilitas + '\'' +
                ", kelas='" + kelas + '\'' +
                ", peralatan='" + peralatan_kebugaran + '\'' +
                ", gymmachine='" + gymmachine + '\'' +
                ", keunggulan='" + keunggulan_gym + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
