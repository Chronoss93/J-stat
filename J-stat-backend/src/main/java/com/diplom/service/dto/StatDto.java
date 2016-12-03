package com.diplom.service.dto;

/**
 * Created by Igor on 13.11.2016.
 */
public class StatDto {
    //used for appropriate Json Conversion
    private class InnerData {
        private String[] rowHeaders;
        private String[] columnHeaders;
        private String[][] kyf;

        InnerData(String[] rowHeaders, String[] columnHeaders, String[][] kyf) {
            this.rowHeaders = rowHeaders;
            this.columnHeaders = columnHeaders;
            this.kyf = kyf;
        }

        public String[] getRowHeaders() {
            return rowHeaders;
        }

        public void setRowHeaders(String[] rowHeaders) {
            this.rowHeaders = rowHeaders;
        }

        public String[] getColumnHeaders() {
            return columnHeaders;
        }

        public void setColumnHeaders(String[] columnHeaders) {
            this.columnHeaders = columnHeaders;
        }

        public String[][] getKyf() {
            return kyf;
        }

        public void setKyf(String[][] kyf) {
            this.kyf = kyf;
        }
    }

    private InnerData data;

    public StatDto(String[] rowHeaders, String[] columnHeaders, String[][] kyfs) {
        this.data = new InnerData(rowHeaders, columnHeaders, kyfs);
    }

    public InnerData getData() {
        return data;
    }

    public void setData(InnerData data) {
        this.data = data;
    }
}
