package com.test.business.service;

import com.test.business.exceptions.FileException;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Lidia Plaza
 * @since 13/07/2017.
 */
@Service
public class FileService {

    /** Codigos de error */
    private Properties errorCodes;

    public FileService() throws IOException {
        this.errorCodes = new Properties();
        errorCodes.load(getClass().getClassLoader().getResourceAsStream("errorCodes.properties"));
    }

    public ByteArrayOutputStream uploadFile(MultipartFile file) throws FileException {
        InputStream inputStream;
        ByteArrayOutputStream outputStream;
        try {
            inputStream = new ByteArrayInputStream(file.getBytes());
            outputStream = new ByteArrayOutputStream();
            IOUtils.copy(inputStream, outputStream);
        } catch (IOException e) {
            throw new FileException(errorCodes.getProperty("file.error.download"));
        }

        return outputStream;

    }
}
