package guru.qa.dz;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import guru.qa.dz.domain.Hero;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.assertj.core.api.Assertions.assertThat;

public class DzFileParsingTest {

    @Test
    public void parsePdfTest() throws Exception {
        ZipFile zipFile = new ZipFile("src/test/resources/files2/dz/Zip with files.zip");
        ZipEntry zipEntry = zipFile.getEntry("junit-user-guide-5.8.2.pdf");
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        PDF pdf = new PDF(inputStream);
        assertThat(pdf.title).contains("JUnit 5 User Guide");
    }

    @Test
    public void parseXlsxTest() throws Exception {
        ZipFile zipFile = new ZipFile("src/test/resources/files2/dz/Zip with files.zip");
        ZipEntry zipEntry = zipFile.getEntry("ExampleXLSX.xlsx");
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        XLS xls = new XLS(inputStream);
        assertThat(xls.excel
                .getSheetAt(0)
                .getRow(8)
                .getCell(0)
                .getStringCellValue()).contains("слойка");
    }

    @Test
    public void parseCsvTest() throws Exception {
        ZipFile zipFile = new ZipFile("src/test/resources/files2/dz/Zip with files.zip");
        ZipEntry zipEntry = zipFile.getEntry("business-financial-data-sep-2021-quarter.csv");
        try (InputStream inputStream = zipFile.getInputStream(zipEntry);
             CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream))) {
            List<String[]> content = csvReader.readAll();
            assertThat(content.get(1)).contains(
                    "BDCQ.SF1AA2CA",
                    "2016.06",
                    "1116.386",
                    "",
                    "F",
                    "Dollars",
                    "6",
                    "Business Data Collection - BDC",
                    "Industry by financial variable (NZSIOC Level 2)",
                    "Sales (operating income)",
                    "Forestry and Logging",
                    "Current prices",
                    "Unadjusted");
        }
    }

    @Test
    void jsonTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Hero hero = objectMapper.readValue(Paths.get("src/test/resources/files2/dz/simple.json").toFile(), Hero.class);
        assertThat(hero.age).isEqualTo(29);
        assertThat(hero.powers).contains("Radiation resistance");
    }
}
