package com.jobsity.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileInputReader implements InputReader{
    @Override
    public List<String> readSource(String sourcePath) throws IOException {
        return Files.readAllLines(Paths.get(sourcePath));
    }
}
