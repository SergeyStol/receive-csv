package dev.sstol.receivecsv.slices.api;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Stol
 * 2022-02-20
 */
@RestController
public class CsvController {
    @PutMapping
    void foo(@RequestParam("file") MultipartFile multipart) {
        BufferedReader br;
        List<String> result = new ArrayList<>();
        try {

            String line;
            InputStream is = multipart.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
//                line.split(",");
                result.add(line);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        result.forEach(System.out::println);
    }
}
