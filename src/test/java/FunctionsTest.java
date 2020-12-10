package src.test.java;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import src.main.java.utils.DataDummy;
import src.main.java.data.Repository;
import src.main.java.model.Mahasiswa;
import src.main.java.data.Functions;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FunctionsTest {
    DataDummy dataDummy;
    Functions functions;
    String searchString = "6706184055";

    @Mock
    Repository repository;

    @Before
    public void setUp() {
        dataDummy = new DataDummy();
        functions = new Functions(repository);
    }

    @Test
    public void insert() {
        // prepare data
        Mahasiswa data1 = new Mahasiswa();
        data1.setNama(dataDummy.dataInsert().get(0).getNama());
        data1.setNim(dataDummy.dataInsert().get(0).getNim());
        data1.setNilai(dataDummy.dataInsert().get(0).getNilai());

        Mahasiswa data2 = new Mahasiswa();
        data2.setNama(dataDummy.dataInsert().get(1).getNama());
        data2.setNim(dataDummy.dataInsert().get(1).getNim());
        data2.setNilai(dataDummy.dataInsert().get(1).getNilai());

        // action
        when(repository.getListMhs()).thenReturn(dataDummy.dataInsert());
        when(repository.insert(data1)).thenReturn(true);
        when(repository.insert(data2)).thenReturn(true);
        boolean result1 = functions.insert(data1);
        boolean result2 = functions.insert(data2);

        // assert
        assertTrue(result1);
        assertTrue(result2);
        assertNotNull(functions.getListMhs());
        assertEquals(2, functions.getListMhs().size());
    }

    @Test
    public void getData() {
        // prepare data
        ArrayList<Mahasiswa> data = dataDummy.dataInsert();

        // action
        when(repository.getListMhs()).thenReturn(data);
        ArrayList<Mahasiswa> result = functions.getListMhs();

        // assert
        assertNotNull(result);
        assertEquals(data, result);
        assertEquals(2, result.size());
        assertEquals(data.get(0).getNama(), result.get(0).getNama());
        assertEquals(data.get(0).getNim(), result.get(0).getNim());
        assertEquals(data.get(0).getNilai(), result.get(0).getNilai());
    }

    @Test
    public void search() {
        // action
        when(repository.search(searchString)).thenReturn(dataDummy.dataCari());
        Mahasiswa result = functions.search(searchString);

        // assert
        assertNotNull(result);
        assertEquals(dataDummy.dataCari().getNama(), result.getNama());
        assertEquals(dataDummy.dataCari().getNim(), result.getNim());
        assertEquals(dataDummy.dataCari().getNilai(), result.getNilai());
    }

    @Test
    public void update() {
        // prepare data
        Mahasiswa data = dataDummy.dataUpdate();

        // action
        when(repository.update(searchString, data)).thenReturn(data);
        Mahasiswa result = functions.update(searchString, data);

        // assert
        assertNotNull(result);
        assertEquals(data.getNim(), result.getNim());
        assertEquals(data.getNama(), result.getNama());
        assertEquals(data.getNilai(), result.getNilai());
    }

    @Test
    public void delete() {
        // action
        when(repository.delete(searchString)).thenReturn(true);
        when(repository.delete("")).thenReturn(false);
        boolean result1 = functions.delete(searchString);
        boolean result2 = functions.delete("");

        // assert
        assertTrue(result1);
        assertTrue(result2);
    }
}
