package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.SecurityUtils;
import com.google.api.client.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Beta
/* loaded from: classes5.dex */
public class GooglePublicKeysManager {

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f25587h = Pattern.compile("\\s*max-age\\s*=\\s*(\\d+)\\s*");

    /* renamed from: a  reason: collision with root package name */
    private final JsonFactory f25588a;

    /* renamed from: b  reason: collision with root package name */
    private List<PublicKey> f25589b;

    /* renamed from: c  reason: collision with root package name */
    private long f25590c;

    /* renamed from: d  reason: collision with root package name */
    private final HttpTransport f25591d;

    /* renamed from: e  reason: collision with root package name */
    private final Lock f25592e;

    /* renamed from: f  reason: collision with root package name */
    private final Clock f25593f;

    /* renamed from: g  reason: collision with root package name */
    private final String f25594g;

    @Beta
    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: b  reason: collision with root package name */
        final HttpTransport f25596b;

        /* renamed from: c  reason: collision with root package name */
        final JsonFactory f25597c;

        /* renamed from: a  reason: collision with root package name */
        Clock f25595a = Clock.SYSTEM;

        /* renamed from: d  reason: collision with root package name */
        String f25598d = GoogleOAuthConstants.DEFAULT_PUBLIC_CERTS_ENCODED_URL;

        public Builder(HttpTransport httpTransport, JsonFactory jsonFactory) {
            this.f25596b = (HttpTransport) Preconditions.checkNotNull(httpTransport);
            this.f25597c = (JsonFactory) Preconditions.checkNotNull(jsonFactory);
        }

        public GooglePublicKeysManager build() {
            return new GooglePublicKeysManager(this);
        }

        public final Clock getClock() {
            return this.f25595a;
        }

        public final JsonFactory getJsonFactory() {
            return this.f25597c;
        }

        public final String getPublicCertsEncodedUrl() {
            return this.f25598d;
        }

        public final HttpTransport getTransport() {
            return this.f25596b;
        }

        public Builder setClock(Clock clock) {
            this.f25595a = (Clock) Preconditions.checkNotNull(clock);
            return this;
        }

        public Builder setPublicCertsEncodedUrl(String str) {
            this.f25598d = (String) Preconditions.checkNotNull(str);
            return this;
        }
    }

    public GooglePublicKeysManager(HttpTransport httpTransport, JsonFactory jsonFactory) {
        this(new Builder(httpTransport, jsonFactory));
    }

    long a(HttpHeaders httpHeaders) {
        long j4;
        if (httpHeaders.getCacheControl() != null) {
            for (String str : httpHeaders.getCacheControl().split(",")) {
                Matcher matcher = f25587h.matcher(str);
                if (matcher.matches()) {
                    j4 = Long.valueOf(matcher.group(1)).longValue();
                    break;
                }
            }
        }
        j4 = 0;
        if (httpHeaders.getAge() != null) {
            j4 -= httpHeaders.getAge().longValue();
        }
        return Math.max(0L, j4);
    }

    public final Clock getClock() {
        return this.f25593f;
    }

    public final long getExpirationTimeMilliseconds() {
        return this.f25590c;
    }

    public final JsonFactory getJsonFactory() {
        return this.f25588a;
    }

    public final String getPublicCertsEncodedUrl() {
        return this.f25594g;
    }

    public final List<PublicKey> getPublicKeys() throws GeneralSecurityException, IOException {
        this.f25592e.lock();
        try {
            if (this.f25589b == null || this.f25593f.currentTimeMillis() + 300000 > this.f25590c) {
                refresh();
            }
            return this.f25589b;
        } finally {
            this.f25592e.unlock();
        }
    }

    public final HttpTransport getTransport() {
        return this.f25591d;
    }

    public GooglePublicKeysManager refresh() throws GeneralSecurityException, IOException {
        boolean z3;
        this.f25592e.lock();
        try {
            this.f25589b = new ArrayList();
            CertificateFactory x509CertificateFactory = SecurityUtils.getX509CertificateFactory();
            HttpResponse execute = this.f25591d.createRequestFactory().buildGetRequest(new GenericUrl(this.f25594g)).execute();
            this.f25590c = this.f25593f.currentTimeMillis() + (a(execute.getHeaders()) * 1000);
            JsonParser createJsonParser = this.f25588a.createJsonParser(execute.getContent());
            JsonToken currentToken = createJsonParser.getCurrentToken();
            if (currentToken == null) {
                currentToken = createJsonParser.nextToken();
            }
            if (currentToken == JsonToken.START_OBJECT) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            while (createJsonParser.nextToken() != JsonToken.END_OBJECT) {
                createJsonParser.nextToken();
                this.f25589b.add(((X509Certificate) x509CertificateFactory.generateCertificate(new ByteArrayInputStream(StringUtils.getBytesUtf8(createJsonParser.getText())))).getPublicKey());
            }
            this.f25589b = Collections.unmodifiableList(this.f25589b);
            createJsonParser.close();
            return this;
        } finally {
            this.f25592e.unlock();
        }
    }

    protected GooglePublicKeysManager(Builder builder) {
        this.f25592e = new ReentrantLock();
        this.f25591d = builder.f25596b;
        this.f25588a = builder.f25597c;
        this.f25593f = builder.f25595a;
        this.f25594g = builder.f25598d;
    }
}
