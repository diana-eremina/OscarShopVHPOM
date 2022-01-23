package tests.util;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public static Iterator<Object[]> loginNegativeUsingFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/data.csv"))); //путь до файла с данными. Он должен лежать строго в опр-ном месте, иначе не будет работать
        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(",")); // указываем, как раделяются данные в файле
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }
}