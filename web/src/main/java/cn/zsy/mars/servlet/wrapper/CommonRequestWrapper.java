package cn.zsy.mars.servlet.wrapper;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public final class CommonRequestWrapper extends HttpServletRequestWrapper {

    private final String requestBody;

    public CommonRequestWrapper(HttpServletRequest request) {
        super(request);
        StringBuilder builder = new StringBuilder();
        String line = null;
        BufferedReader reader = null;
        try {
            reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        requestBody = builder.toString();
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream inputStream =
            new ByteArrayInputStream(requestBody.getBytes(Charset.forName("UTF-8")));
        return new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return inputStream.read();
            }
        };
    }

    public String requestBody() {
        return requestBody;
    }

}
