package com.google.api.client.http.javanet;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.SecurityUtils;
import com.google.api.client.util.SslUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes5.dex */
public final class NetHttpTransport extends HttpTransport {

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f25879f;

    /* renamed from: c  reason: collision with root package name */
    private final ConnectionFactory f25880c;

    /* renamed from: d  reason: collision with root package name */
    private final SSLSocketFactory f25881d;

    /* renamed from: e  reason: collision with root package name */
    private final HostnameVerifier f25882e;

    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private SSLSocketFactory f25883a;

        /* renamed from: b  reason: collision with root package name */
        private HostnameVerifier f25884b;

        /* renamed from: c  reason: collision with root package name */
        private Proxy f25885c;

        /* renamed from: d  reason: collision with root package name */
        private ConnectionFactory f25886d;

        public NetHttpTransport build() {
            if (this.f25885c == null) {
                return new NetHttpTransport(this.f25886d, this.f25883a, this.f25884b);
            }
            return new NetHttpTransport(this.f25885c, this.f25883a, this.f25884b);
        }

        @Beta
        public Builder doNotValidateCertificate() throws GeneralSecurityException {
            this.f25884b = SslUtils.trustAllHostnameVerifier();
            this.f25883a = SslUtils.trustAllSSLContext().getSocketFactory();
            return this;
        }

        public HostnameVerifier getHostnameVerifier() {
            return this.f25884b;
        }

        public SSLSocketFactory getSslSocketFactory() {
            return this.f25883a;
        }

        public Builder setConnectionFactory(ConnectionFactory connectionFactory) {
            this.f25886d = connectionFactory;
            return this;
        }

        public Builder setHostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.f25884b = hostnameVerifier;
            return this;
        }

        public Builder setProxy(Proxy proxy) {
            this.f25885c = proxy;
            return this;
        }

        public Builder setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.f25883a = sSLSocketFactory;
            return this;
        }

        public Builder trustCertificates(KeyStore keyStore) throws GeneralSecurityException {
            SSLContext tlsSslContext = SslUtils.getTlsSslContext();
            SslUtils.initSslContext(tlsSslContext, keyStore, SslUtils.getPkixTrustManagerFactory());
            return setSslSocketFactory(tlsSslContext.getSocketFactory());
        }

        public Builder trustCertificatesFromJavaKeyStore(InputStream inputStream, String str) throws GeneralSecurityException, IOException {
            KeyStore javaKeyStore = SecurityUtils.getJavaKeyStore();
            SecurityUtils.loadKeyStore(javaKeyStore, inputStream, str);
            return trustCertificates(javaKeyStore);
        }

        public Builder trustCertificatesFromStream(InputStream inputStream) throws GeneralSecurityException, IOException {
            KeyStore javaKeyStore = SecurityUtils.getJavaKeyStore();
            javaKeyStore.load(null, null);
            SecurityUtils.loadKeyStoreFromCertificates(javaKeyStore, SecurityUtils.getX509CertificateFactory(), inputStream);
            return trustCertificates(javaKeyStore);
        }
    }

    static {
        String[] strArr = {"DELETE", "GET", "HEAD", "OPTIONS", "POST", "PUT", "TRACE"};
        f25879f = strArr;
        Arrays.sort(strArr);
    }

    public NetHttpTransport() {
        this((ConnectionFactory) null, (SSLSocketFactory) null, (HostnameVerifier) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.api.client.http.HttpTransport
    /* renamed from: b */
    public NetHttpRequest buildRequest(String str, String str2) throws IOException {
        Preconditions.checkArgument(supportsMethod(str), "HTTP method %s not supported", str);
        HttpURLConnection openConnection = this.f25880c.openConnection(new URL(str2));
        openConnection.setRequestMethod(str);
        if (openConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
            HostnameVerifier hostnameVerifier = this.f25882e;
            if (hostnameVerifier != null) {
                httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            }
            SSLSocketFactory sSLSocketFactory = this.f25881d;
            if (sSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
            }
        }
        return new NetHttpRequest(openConnection);
    }

    @Override // com.google.api.client.http.HttpTransport
    public boolean supportsMethod(String str) {
        if (Arrays.binarySearch(f25879f, str) >= 0) {
            return true;
        }
        return false;
    }

    NetHttpTransport(Proxy proxy, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        this(new DefaultConnectionFactory(proxy), sSLSocketFactory, hostnameVerifier);
    }

    NetHttpTransport(ConnectionFactory connectionFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        this.f25880c = connectionFactory == null ? new DefaultConnectionFactory() : connectionFactory;
        this.f25881d = sSLSocketFactory;
        this.f25882e = hostnameVerifier;
    }
}
