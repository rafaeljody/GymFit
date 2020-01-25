package com.example.myapplication;

import java.io.Serializable;

public class personalTrainer implements Serializable {


    //Deklarasi String Tambah Trainer

    String nama_trainer,pendidikan_formal, gym_home, on_call_area,
            nomor_telp, akun_sosmed, pengalaman_kerja, tarif_pertemuan, sertifikasi, keahlian;

    private String imgUrl;
    public personalTrainer() {
    }

    public personalTrainer(String nama_trainer, String pendidikan_formal, String gym_home, String on_call_area, String nomor_telp, String akun_sosmed, String pengalaman_kerja, String tarif_pertemuan, String sertifikasi, String keahlian,String imgUrl) {
        this.nama_trainer = nama_trainer;
        this.pendidikan_formal = pendidikan_formal;
        this.gym_home = gym_home;
        this.on_call_area = on_call_area;
        this.nomor_telp = nomor_telp;
        this.akun_sosmed = akun_sosmed;
        this.pengalaman_kerja = pengalaman_kerja;
        this.tarif_pertemuan = tarif_pertemuan;
        this.sertifikasi = sertifikasi;
        this.keahlian = keahlian;
        this.imgUrl = imgUrl;
    }

    public String getNama_trainer() {
        return nama_trainer;
    }

    public void setNama_trainer(String nama_trainer) {
        this.nama_trainer = nama_trainer;
    }

    public String getPendidikan_formal() {
        return pendidikan_formal;
    }

    public void setPendidikan_formal(String pendidikan_formal) {
        this.pendidikan_formal = pendidikan_formal;
    }

    public String getGym_home() {
        return gym_home;
    }

    public void setGym_home(String gym_home) {
        this.gym_home = gym_home;
    }

    public String getOn_call_area() {
        return on_call_area;
    }

    public void setOn_call_area(String on_call_area) {
        this.on_call_area = on_call_area;
    }

    public String getNomor_telp() {
        return nomor_telp;
    }

    public void setNomor_telp(String nomor_telp) {
        this.nomor_telp = nomor_telp;
    }

    public String getAkun_sosmed() {
        return akun_sosmed;
    }

    public void setAkun_sosmed(String akun_sosmed) {
        this.akun_sosmed = akun_sosmed;
    }

    public String getPengalaman_kerja() {
        return pengalaman_kerja;
    }

    public void setPengalaman_kerja(String pengalaman_kerja) {
        this.pengalaman_kerja = pengalaman_kerja;
    }

    public String getTarif_pertemuan() {
        return tarif_pertemuan;
    }

    public void setTarif_pertemuan(String tarif_pertemuan) {
        this.tarif_pertemuan = tarif_pertemuan;
    }

    public String getSertifikasi() {
        return sertifikasi;
    }

    public void setSertifikasi(String sertifikasi) {
        this.sertifikasi = sertifikasi;
    }

    public String getKeahlian() {
        return keahlian;
    }

    public void setKeahlian(String keahlian) {
        this.keahlian = keahlian;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "personalTrainer{" +
                "nama_trainer='" + nama_trainer + '\'' +
                ", pendidikan_formal='" + pendidikan_formal + '\'' +
                ", gym_home='" + gym_home + '\'' +
                ", on_call_area='" + on_call_area + '\'' +
                ", nomor_telp='" + nomor_telp + '\'' +
                ", akun_sosmed='" + akun_sosmed + '\'' +
                ", pengalaman_kerja='" + pengalaman_kerja + '\'' +
                ", tarif_pertemuan='" + tarif_pertemuan + '\'' +
                ", sertifikasi='" + sertifikasi + '\'' +
                ", keahlian='" + keahlian + '\'' +
                ", imgurl='" + imgUrl +'\'' +
                '}';
    }
}
