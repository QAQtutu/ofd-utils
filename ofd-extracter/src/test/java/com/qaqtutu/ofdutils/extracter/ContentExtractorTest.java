package com.qaqtutu.ofdutils.extracter;

import com.qaqtutu.ofdutils.extracter.model.OFDPage;
import org.junit.jupiter.api.Test;
import org.ofdrw.reader.OFDReader;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @description:
 * @author: qaqtutu
 * @create: 2021/06/26 17:01
 */
public class ContentExtractorTest {


    @Test
    public void test() {
        Path src = Paths.get("src/test/resources/999.ofd");
        try (OFDReader reader = new OFDReader(src)) {
            List<OFDPage> ofdPageList = ContentExtractor.extract(reader);
            System.out.println(ofdPageList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}