package za.ac.cput.novacinemaapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class ImageCleanupService {
    @Autowired
    private MovieService movieService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void cleanUpOrphanedImages() {
        File folder = new File("src/main/resources/static/images/");
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();
                boolean imageInUse = movieService.getall().stream()
                        .anyMatch(movie -> movie.getImageURL() != null && movie.getImageURL().contains(fileName));

                if (!imageInUse) {
                    try {
                        Files.delete(file.toPath());
                        System.out.println("Deleted orphaned image: " + fileName);
                    } catch (IOException e) {
                        System.err.println("Error deleting image: " + fileName);
                    }
                }
            }
        }
    }
}

