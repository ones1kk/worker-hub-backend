package com.breakingbad.workerhub.core.api.url;

import com.breakingbad.workerhub.constant.APIUrls;
import com.breakingbad.workerhub.constant.RequestProperties;
import com.breakingbad.workerhub.core.parser.JsonParser;
import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import static org.springframework.util.CollectionUtils.isEmpty;

@RequiredArgsConstructor
public class Caller {

    private final APIUrls apiUrl;

    private final APICallerConfiguration configuration;

    public APIResponseHandlerFactory call() throws IOException {
        HttpURLConnection connection = createConnection(configuration);
        int responseCode = connection.getResponseCode();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        if (responseCode < 200 || responseCode > 300) {
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        }

        String json = JsonParser.toJson(bufferedReader);
        connection.disconnect();

        return new APIResponseHandlerFactory(apiUrl, json);
    }

    private HttpURLConnection createConnection(APICallerConfiguration configuration) throws IOException, MalformedURLException {
        String requestURL = apiUrl.getRequestURL();
        Map<String, Object> params = configuration.getParams();
        List<String> paths = configuration.getPaths();
        String result = makeUrl(requestURL, params, paths);

        HttpURLConnection connection = (HttpURLConnection) new URL(result).openConnection();
        configureConnection(connection, configuration);

        return connection;
    }

    private String makeUrl(String requestURL, Map<String, Object> params, List<String> paths) {
        URIBuilder uriBuilder = new URIBuilder(requestURL);

        if (!isEmpty(paths)) {
            paths.forEach(uriBuilder::addPath);
        }

        if (!isEmpty(params)) {
            params.forEach(uriBuilder::param);
        }

        return uriBuilder.getURI();
    }

    private void configureConnection(HttpURLConnection connection, APICallerConfiguration configuration) throws ProtocolException {
        if(configuration.getMethod() != null) {
            connection.setRequestMethod(configuration.getMethod().getValue());
        }

        RequestProperties requestProperties = configuration.getRequestProperties();
        if(requestProperties != null) {
            String property = requestProperties.getProperty();
            String value = requestProperties.getValue();
            connection.setRequestProperty(property, value);
        }

        if (configuration.getAuthenticator() != null) {
            connection.setAuthenticator(configuration.getAuthenticator());
        }

        if (configuration.getConnectionTimeout() != null) {
            connection.setConnectTimeout(configuration.getConnectionTimeout());
        }

        if (configuration.getChunkedStreamingMode() != null) {
            connection.setChunkedStreamingMode(configuration.getChunkedStreamingMode());
        }

        if (configuration.getFixedLengthStreamingMode() != null) {
            connection.setFixedLengthStreamingMode(configuration.getFixedLengthStreamingMode());
        }

        if (configuration.getAllowUserInteraction() != null) {
            connection.setAllowUserInteraction(configuration.getAllowUserInteraction());
        }

        if (configuration.getInstanceFollowRedirects() != null) {
            connection.setInstanceFollowRedirects(configuration.getInstanceFollowRedirects());
        }

        if (configuration.getDefaultUseCaches() != null) {
            connection.setDefaultUseCaches(configuration.getDefaultUseCaches());
        }

        if (configuration.getDoInput() != null) {
            connection.setDoInput(configuration.getDoInput());
        }

        if (configuration.getIfModifiedSince() != null) {
            connection.setIfModifiedSince(configuration.getIfModifiedSince());
        }

        if (configuration.getReadTimeout() != null) {
            connection.setReadTimeout(configuration.getReadTimeout());
        }

        if (configuration.getUseCaches() != null) {
            connection.setUseCaches(configuration.getUseCaches());
        }

    }

}
