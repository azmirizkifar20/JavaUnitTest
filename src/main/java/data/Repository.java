package src.main.java.data;

import java.util.ArrayList;

import src.main.java.model.Mahasiswa;

public class Repository {
    ArrayList<Mahasiswa> listMhs;

    public Repository(ArrayList<Mahasiswa> listMhs) {
        this.listMhs = listMhs;
    }

    public boolean insert(Mahasiswa mahasiswa) {
        if (mahasiswa != null) {
            listMhs.add(mahasiswa);
            return true;
        } else return false;
    }

    public ArrayList<Mahasiswa> getListMhs() {
        return listMhs;
    }

    public Mahasiswa search(String nim) {
        Mahasiswa data = new Mahasiswa();
        for (int i = 0; i < listMhs.size(); i++) {
            if (listMhs.get(i).getNim().equals(nim)) {
                data = listMhs.get(i);
                break;
            }
        }

        return data;
    }

    public Mahasiswa update(String nim, Mahasiswa mahasiswa) {
        int choosenIndex = -1;
        for (int i = 0; i < listMhs.size(); i++) {
            if (listMhs.get(i).getNim().equals(nim)) {
                choosenIndex = i;
                break;
            }
        }

        if (choosenIndex != -1) {
            listMhs.set(choosenIndex, mahasiswa);
            return listMhs.get(choosenIndex);
        } else return new Mahasiswa();
    }

    public boolean delete(String nim) {
        int choosenIndex = -1;
        for (int i = 0; i < listMhs.size(); i++) {
            if (listMhs.get(i).getNim().equals(nim)) {
                choosenIndex = i;
                break;
            }
        }

        if (choosenIndex != -1) {
            listMhs.remove(choosenIndex);
            return true;
        } else return false;
    }
}
