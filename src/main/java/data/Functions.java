package src.main.java.data;

import java.util.ArrayList;

import src.main.java.model.Mahasiswa;

public class Functions {
    Repository repository;

    public Functions(Repository repository) {
        this.repository = repository;
    }

    public ArrayList<Mahasiswa> getListMhs() {
        return repository.getListMhs();
    }

    public boolean insert(Mahasiswa mahasiswa) {
        return repository.insert(mahasiswa);
    }

    public Mahasiswa search(String nim) {
        return repository.search(nim);
    }

    public boolean delete(String nim) {
        return repository.delete(nim);
    }

    public Mahasiswa update(String nim, Mahasiswa mahasiswa) {
        return repository.update(nim, mahasiswa);
    }
}
