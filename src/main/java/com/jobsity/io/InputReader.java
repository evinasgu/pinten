package com.jobsity.io;

import java.io.IOException;
import java.util.List;

public interface InputReader {
    List<String> readSource(String sourcePath) throws IOException;
}
