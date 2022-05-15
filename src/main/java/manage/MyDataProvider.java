package manage;

import model.Board;
import model.Card;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    @DataProvider
    public static Iterator<Object[]> boardData(){
        List<Object[]> list=new ArrayList<>();
        list.add(new Object[]{"test1"});
        list.add(new Object[]{"test2"});
        list.add(new Object[]{"test3"});

        return list.iterator();
    }

    @DataProvider
    public static Object[][]boardDataModel(){
        List<Object[]> list=new ArrayList<>();
        list.add(new Object[]{Board.builder().title("test.1.1").build()});
        list.add(new Object[]{Board.builder().title("test 2.2").build()});
        list.add(new Object[]{Board.builder().title("test 3.3").build()});

        return new Object[][]{};
    }

    @DataProvider
    public static Iterator<Object[]> dataCardCSV() throws IOException {
        List<Object[]> list =new ArrayList<>();
        BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/datacards.csv")));
        reader.readLine();
        String line= reader.readLine();
        while (line!=null){
            String[] split=line.split(",");
            list.add(new Object[]{Card.builder().cardName(split[0]).color(split[1]).build()});
            line= reader.readLine();

        }
        return list.listIterator();
    }
}
