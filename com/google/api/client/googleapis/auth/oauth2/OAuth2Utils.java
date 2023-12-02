package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.Beta;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
/* loaded from: classes5.dex */
public class OAuth2Utils {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f25599a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f25600b = Logger.getLogger(OAuth2Utils.class.getName());

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends Throwable> T a(T t3, Throwable th) {
        t3.initCause(th);
        return t3;
    }

    static String b(SystemEnvironmentProvider systemEnvironmentProvider) {
        String a4 = systemEnvironmentProvider.a("GCE_METADATA_HOST");
        if (a4 != null) {
            if (a4.length() != 0) {
                return "http://".concat(a4);
            }
            return new String("http://");
        }
        return "http://169.254.169.254";
    }

    static boolean c(HttpHeaders httpHeaders, String str, String str2) {
        Object obj = httpHeaders.get(str);
        if (obj instanceof Collection) {
            for (Object obj2 : (Collection) obj) {
                if ((obj2 instanceof String) && ((String) obj2).equals(str2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(HttpTransport httpTransport, SystemEnvironmentProvider systemEnvironmentProvider) {
        if (Boolean.parseBoolean(systemEnvironmentProvider.a("NO_GCE_CHECK"))) {
            return false;
        }
        GenericUrl genericUrl = new GenericUrl(b(systemEnvironmentProvider));
        for (int i4 = 1; i4 <= 3; i4++) {
            try {
                HttpRequest buildGetRequest = httpTransport.createRequestFactory().buildGetRequest(genericUrl);
                buildGetRequest.setConnectTimeout(500);
                HttpResponse execute = buildGetRequest.execute();
                boolean c4 = c(execute.getHeaders(), "Metadata-Flavor", "Google");
                execute.disconnect();
                return c4;
            } catch (SocketTimeoutException unused) {
            } catch (IOException e4) {
                f25600b.log(Level.WARNING, "Failed to detect whether we are running on Google Compute Engine.", (Throwable) e4);
            }
        }
        return false;
    }

    public static String getMetadataServerUrl() {
        return b(SystemEnvironmentProvider.f25601a);
    }
}
