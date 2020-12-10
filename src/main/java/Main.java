package src.main.java;

import java.util.ArrayList;
import java.util.Scanner;

import src.main.java.data.Functions;
import src.main.java.data.Repository;
import src.main.java.model.Mahasiswa;

public class Main {
    boolean runner = true;
    Scanner scanner = new Scanner(System.in);
    ArrayList<Mahasiswa> listData = new ArrayList<>();
    Repository repository = new Repository(listData);
    Functions functions = new Functions(repository);

    public static void main(String[] args) {
        new Main().setupMain();
    }

    private void setupMain() {
        while (runner) {
            System.out.println("========== Silahkan pilih menu ==========");
            System.out.println("1. Tambah data\n" +
                    "2. Lihat data\n" +
                    "3. Cari data\n" +
                    "4. Hapus data\n" +
                    "5. Edit data\n" +
                    "6. Keluar");
            System.out.print("Silahkan pilih menu : ");
            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    insert();
                    break;
                case 2:
                    getData();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    update();
                    break;
                case 6:
                    runner = false;
                    System.out.println("Terimakasih:)\n");
                    break;
                default:
                    System.out.println("Masukkan input dengan benar!\n");
                    break;
            }
        }
    }

    private void insert() {
        Mahasiswa data = new Mahasiswa();
        System.out.print("Masukkan Nama : ");
        data.setNama(scanner.next());
        System.out.print("Masukkan NIM  : ");
        data.setNim(scanner.next());
        System.out.print("Masukkan Nilai : ");
        data.setNilai(scanner.nextInt());

        boolean insert = functions.insert(data);
        if (insert) {
            System.out.println("Berhasil insert data!\n");

        } else {
            System.out.println("Gagal insert:(\n");
        }
    }

    private void getData() {
        System.out.println("\n==============================\n");
        functions.getListMhs().forEach((data) -> {
            System.out.println("Nama    : " + data.getNama());
            System.out.println("NIM     : " + data.getNim());
            System.out.println("Nilai   : " + data.getNilai());
            System.out.println();
        });
        System.out.println("==============================\n");
    }

    private void search() {
        System.out.print("Masukkan NIM  : ");
        String cari = scanner.next();
        Mahasiswa data = functions.search(cari);

        if (data.getNim() != null) {
            System.out.println("Nama    : " + data.getNama());
            System.out.println("NIM     : " + data.getNim());
            System.out.println("Nilai   : " + data.getNilai());
        } else System.out.println("Data tidak ditemukan!");

        System.out.println();
    }

    private void delete() {
        System.out.print("Masukkan NIM  : ");
        String cari = scanner.next();
        boolean delete = functions.delete(cari);

        if (delete) System.out.println("Data berhasil dihapus!");
        else System.out.println("Data gagal dihapus:(");
        System.out.println();
    }

    private void update() {
        System.out.print("Masukkan NIM  : ");
        String cari = scanner.next();
        Mahasiswa data = new Mahasiswa();
        Mahasiswa searchResult = functions.search(cari);

        if (searchResult.getNim() != null) {
            System.out.print("Masukkan Nama : "); data.setNama(scanner.next());
            System.out.print("Masukkan NIM  : "); data.setNim(scanner.next());
            System.out.print("Masukkan Nilai : "); data.setNilai(scanner.nextInt());
            Mahasiswa resultUpdate = functions.update(cari, data);

            if (resultUpdate.getNim() != null) {
                System.out.println("Berhasil update data!");
            } else System.out.println("Gagal update data:(");
        } else System.out.println("Data tidak ditemukan!");
        System.out.println();
    }
}
