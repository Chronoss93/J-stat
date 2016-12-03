package com.diplom.service;

import java.io.IOException;

/**
 * Created by chronoss on 24.10.15.
 */
public interface CsvDataHandler {
    void handleMessage(String text) throws IOException;
}
