package src.main.java.utils;

import java.util.ArrayList;

import src.main.java.model.Mahasiswa;

public class DataDummy {
    public ArrayList<Mahasiswa> dataInsert() {
        ArrayList<Mahasiswa> list = new ArrayList<>();
        Mahasiswa data1 = new Mahasiswa();
        data1.setNama("Irgi Ahmad Maulana");
        data1.setNim("6706180041");
        data1.setNilai(92);

        Mahasiswa data2 = new Mahasiswa();
        data2.setNama("Muhamad Azmi Rizkifar");
        data2.setNim("6706184055");
        data2.setNilai(90);

        list.add(data1);
        list.add(data2);

        return list;
    }

    public Mahasiswa dataCari() {
        Mahasiswa data = new Mahasiswa();
        data.setNama("Muhamad Azmi Rizkifar");
        data.setNim("6706184055");
        data.setNilai(90);
        return data;
    }

    public Mahasiswa dataUpdate() {
        Mahasiswa data = new Mahasiswa();
        data.setNama("Muhammad Alfath Abibi");
        data.setNim("6706184054");
        data.setNilai(95);
        return data;
    }

}
