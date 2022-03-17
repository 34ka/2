package guru.qa.lesson;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


import static com.codeborne.pdftest.assertj.Assertions.assertThat;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.nio.charset.StandardCharsets.*;

public class SelenideFileTest {

    @Test
    public void selenideDownloadTest() throws Exception {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloadedFile = $("#raw-url").download();

        try(InputStream is = new FileInputStream(downloadedFile)) {
            assertThat(new String(is.readAllBytes(), UTF_8))
                    .contains("This repository is the home of the next generation of JUnit");
        }
        //тоже самое, что и блок c try
        //String readString = Files.readString(downloadedFile.toPath(), UTF_8);
    }

    @Test
    public void selenideUploadTest() {
        open("https://the-internet.herokuapp.com/upload");
        $("input[type='file']")
                //.uploadFile(new File("D:\\qa.guru\\9\\Lesson-9\\src\\test\\resources\\files\\1.txt"));//bad practice
                .uploadFromClasspath("files/1.txt");//bad practice
        $("#file-submit").click();
        $("div.example").shouldHave(text("File Uploaded!"));
        $("#uploaded-files").shouldHave(text("1.txt"));
    }
}
