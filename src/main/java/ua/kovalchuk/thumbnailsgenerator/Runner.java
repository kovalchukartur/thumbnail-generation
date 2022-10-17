package ua.kovalchuk.thumbnailsgenerator;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("Running");
        ClassPathResource classPathResource = new ClassPathResource("pic.png");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        Thumbnails.of(classPathResource.getInputStream())
            .size(100, 100)
            .toOutputStream(byteArrayOutputStream);

        String encodedToString = Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());

        log.info("Result = {}", "data:image;base64," + encodedToString);
    }
}
