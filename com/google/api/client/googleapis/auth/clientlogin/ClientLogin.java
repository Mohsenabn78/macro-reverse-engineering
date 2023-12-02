package com.google.api.client.googleapis.auth.clientlogin;

import androidx.core.app.NotificationCompat;
import com.arlosoft.macrodroid.action.services.UploadService;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Key;
import com.google.api.client.util.StringUtils;
import com.google.api.client.util.Strings;
import java.io.IOException;

@Beta
/* loaded from: classes5.dex */
public final class ClientLogin {
    @Key
    public String accountType;
    @Key("source")
    public String applicationName;
    @Key(NotificationCompat.CATEGORY_SERVICE)
    public String authTokenType;
    @Key("logincaptcha")
    public String captchaAnswer;
    @Key("logintoken")
    public String captchaToken;
    @Key("Passwd")
    public String password;
    public GenericUrl serverUrl = new GenericUrl("https://www.google.com");
    public HttpTransport transport;
    @Key(UploadService.UPLOAD_EMAIL)
    public String username;

    /* loaded from: classes5.dex */
    public static final class ErrorInfo {
        @Key("CaptchaToken")
        public String captchaToken;
        @Key("CaptchaUrl")
        public String captchaUrl;
        @Key("Error")
        public String error;
        @Key("Url")
        public String url;
    }

    /* loaded from: classes5.dex */
    public static final class Response implements HttpExecuteInterceptor, HttpRequestInitializer {
        @Key("Auth")
        public String auth;

        public String getAuthorizationHeaderValue() {
            return ClientLogin.getAuthorizationHeaderValue(this.auth);
        }

        @Override // com.google.api.client.http.HttpRequestInitializer
        public void initialize(HttpRequest httpRequest) {
            httpRequest.setInterceptor(this);
        }

        @Override // com.google.api.client.http.HttpExecuteInterceptor
        public void intercept(HttpRequest httpRequest) {
            httpRequest.getHeaders().setAuthorization(getAuthorizationHeaderValue());
        }
    }

    public static String getAuthorizationHeaderValue(String str) {
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            return "GoogleLogin auth=".concat(valueOf);
        }
        return new String("GoogleLogin auth=");
    }

    public Response authenticate() throws IOException {
        GenericUrl clone = this.serverUrl.clone();
        clone.appendRawPath("/accounts/ClientLogin");
        HttpRequest buildPostRequest = this.transport.createRequestFactory().buildPostRequest(clone, new UrlEncodedContent(this));
        buildPostRequest.setParser(AuthKeyValueParser.f25553a);
        buildPostRequest.setContentLoggingLimit(0);
        buildPostRequest.setThrowExceptionOnExecuteError(false);
        HttpResponse execute = buildPostRequest.execute();
        if (execute.isSuccessStatusCode()) {
            return (Response) execute.parseAs((Class<Object>) Response.class);
        }
        HttpResponseException.Builder builder = new HttpResponseException.Builder(execute.getStatusCode(), execute.getStatusMessage(), execute.getHeaders());
        ErrorInfo errorInfo = (ErrorInfo) execute.parseAs((Class<Object>) ErrorInfo.class);
        String obj = errorInfo.toString();
        StringBuilder computeMessageBuffer = HttpResponseException.computeMessageBuffer(execute);
        if (!Strings.isNullOrEmpty(obj)) {
            computeMessageBuffer.append(StringUtils.LINE_SEPARATOR);
            computeMessageBuffer.append(obj);
            builder.setContent(obj);
        }
        builder.setMessage(computeMessageBuffer.toString());
        throw new ClientLoginResponseException(builder, errorInfo);
    }
}
