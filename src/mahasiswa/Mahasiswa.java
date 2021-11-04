/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mahasiswa;

import java.io.Serializable;

/**
 *
 * @author elrahmaan
 */
public class Mahasiswa implements Serializable{
    private String nama, nim, kelas, jurusan;
    
    public Mahasiswa(String nama, String nim, String kelas, String jurusan){
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
        this.jurusan = jurusan;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setKelas(String kelas) {
        this.jurusan = kelas;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getKelas() {
        return kelas;
    }
    
    public String getJurusan() {
        return jurusan;
    }
}