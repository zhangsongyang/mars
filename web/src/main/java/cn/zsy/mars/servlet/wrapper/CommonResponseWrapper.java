package cn.zsy.mars.servlet.wrapper;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class CommonResponseWrapper extends HttpServletResponseWrapper {

    private ByteArrayOutputStream outputStream = null;
    private ServletOutputStream servletOutputStream = null;
    private PrintWriter writer = null;
    private Map<String, String> headerMap = null;

    public CommonResponseWrapper(HttpServletResponse response) throws IOException {
        super(response);
        outputStream = new ByteArrayOutputStream();
        servletOutputStream = new WapperedOutputStream(outputStream);
        writer = new PrintWriter(new OutputStreamWriter(outputStream, this.getCharacterEncoding()));
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return servletOutputStream;
    }

    @Override
    public PrintWriter getWriter() throws UnsupportedEncodingException {
        return writer;
    }

    @Override
    public void flushBuffer() throws IOException {
        if (servletOutputStream != null) {
            servletOutputStream.flush();
        }
        if (writer != null) {
            writer.flush();
        }
    }

    @Override
    public void addHeader(String name, String value) {
        super.addHeader(name, value);
        if (headerMap == null) {
            headerMap = new HashMap<String, String>();
        }
        headerMap.put(name, value);
    }

    @Override
    public void reset() {
        outputStream.reset();
    }

    public Map<String, String> responseHeader() {
        if (headerMap == null) {
            return new HashMap<String, String>();
        }
        return headerMap;
    }

    public String responseBody() {
        String responseBody = null;
        try {
            flushBuffer();
            responseBody = new String(outputStream.toByteArray(), this.getCharacterEncoding());
        } catch (IOException e) {
            responseBody = "Logger responseBody has a Exception : " + e;
        }
        return responseBody;
    }

    private class WapperedOutputStream extends ServletOutputStream {

        private ByteArrayOutputStream byteArrayOutputStream = null;

        public WapperedOutputStream(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.byteArrayOutputStream = byteArrayOutputStream;
        }

        @Override
        public void write(int b) throws IOException {
            byteArrayOutputStream.write(b);
        }

        @Override
        public void write(byte[] b) throws IOException {
            byteArrayOutputStream.write(b, 0, b.length);
        }
    }

}
