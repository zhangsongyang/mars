package cn.zsy.mars.servlet;

import cn.zsy.mars.servlet.wrapper.CommonRequestWrapper;
import cn.zsy.mars.servlet.wrapper.CommonResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class CommonDispatcherServlet extends DispatcherServlet {

    private static final long serialVersionUID = 415098909256827811L;

    private static final Logger logger = LoggerFactory.getLogger(CommonDispatcherServlet.class);

    private static final String space = "        ";

    private static final String newLine = System.lineSeparator();

    @Override
    protected void doService(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        CommonRequestWrapper requestWrapper = new CommonRequestWrapper(request);
        CommonResponseWrapper responseWrapper = new CommonResponseWrapper(response);
        StringBuilder requestBuilder = this.writeRequestInfo(requestWrapper);
        long beginTime = System.currentTimeMillis();
        try {
            super.doService(requestWrapper, responseWrapper);
        } catch (Exception e) {
            logger.error("service has error : ", e);
            throw e;
        }
        long endTime = System.currentTimeMillis();
        StringBuilder responseBuilder = this.writeResponseInfo(responseWrapper, response);
        String usedTime =
            MessageFormat.format("This request used time: {0} ms.", (endTime - beginTime));
        requestBuilder.append(newLine).append(responseBuilder).append(newLine).append(usedTime);
        logger.info(requestBuilder.toString());
    }

    private StringBuilder writeRequestInfo(CommonRequestWrapper requestWrapper) {
        String requestURL = requestWrapper.getRequestURI();
        String method = requestWrapper.getMethod();
        Locale locale = requestWrapper.getLocale();
        StringBuilder requestBuilder = new StringBuilder();
        requestBuilder.append(newLine);
        requestBuilder.append("requestURL : ").append(newLine).append(space).append(requestURL)
            .append(newLine);
        requestBuilder.append("requestMethod : ").append(newLine).append(space).append(method)
            .append(newLine);
        requestBuilder.append("requestLocale : ").append(newLine).append(space).append(locale)
            .append(newLine);
        Enumeration<?> headerNames = requestWrapper.getHeaderNames();
        requestBuilder.append("requestHeader : ").append(newLine);
        while (headerNames.hasMoreElements()) {
            String name = String.valueOf(headerNames.nextElement());
            String value = requestWrapper.getHeader(name);
            requestBuilder.append(space).append(name).append("=").append(value).append(newLine);
        }
        Enumeration<?> attributeNames = requestWrapper.getAttributeNames();
        requestBuilder.append("requestAttribute : ").append(newLine);
        while (attributeNames.hasMoreElements()) {
            String name = String.valueOf(attributeNames.nextElement());
            Object value = requestWrapper.getAttribute(name);
            requestBuilder.append(space).append(name).append("=").append(value).append(newLine);
        }
        Enumeration<?> paramNames = requestWrapper.getParameterNames();
        requestBuilder.append("requestParameter : ").append(newLine);
        while (paramNames.hasMoreElements()) {
            String name = String.valueOf(paramNames.nextElement());
            String value = requestWrapper.getParameter(name);
            requestBuilder.append(space).append(name).append("=").append(value).append(newLine);
        }
        String requestBody = requestWrapper.requestBody();
        requestBuilder.append("requestBody : ").append(newLine).append(space).append(requestBody);
        return requestBuilder;
    }

    private StringBuilder writeResponseInfo(CommonResponseWrapper responseWrapper,
                                            HttpServletResponse response) throws UnsupportedEncodingException, IOException {
        StringBuilder responseBuilder = new StringBuilder();
        Map<String, String> responseHeader = responseWrapper.responseHeader();
        String responseBody = responseWrapper.responseBody();

        responseBuilder.append("responseHeader : ").append(newLine);
        for (Entry<String, String> entry : responseHeader.entrySet()) {
            String name = entry.getKey();
            String value = entry.getValue();
            responseBuilder.append(space).append(name).append("=").append(value).append(newLine);
        }
        responseBuilder.append("responseBody : ").append(newLine).append(space).append(responseBody);
        response.getOutputStream().write(responseBody.getBytes(response.getCharacterEncoding()));
        return responseBuilder;
    }

}
