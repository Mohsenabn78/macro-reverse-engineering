package com.google.api.client.json.webtoken;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.webtoken.JsonWebToken;
import com.google.api.client.util.Base64;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.SecurityUtils;
import com.google.api.client.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes5.dex */
public class JsonWebSignature extends JsonWebToken {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f25906c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f25907d;

    /* loaded from: classes5.dex */
    public static class Header extends JsonWebToken.Header {
        @Key("alg")
        private String algorithm;
        @Key("crit")
        private List<String> critical;
        @Key("jwk")
        private String jwk;
        @Key("jku")
        private String jwkUrl;
        @Key("kid")
        private String keyId;
        @Key("x5c")
        private List<String> x509Certificates;
        @Key("x5t")
        private String x509Thumbprint;
        @Key("x5u")
        private String x509Url;

        public final String getAlgorithm() {
            return this.algorithm;
        }

        public final List<String> getCritical() {
            return this.critical;
        }

        public final String getJwk() {
            return this.jwk;
        }

        public final String getJwkUrl() {
            return this.jwkUrl;
        }

        public final String getKeyId() {
            return this.keyId;
        }

        @Deprecated
        public final String getX509Certificate() {
            List<String> list = this.x509Certificates;
            if (list != null && !list.isEmpty()) {
                return this.x509Certificates.get(0);
            }
            return null;
        }

        public final List<String> getX509Certificates() {
            return this.x509Certificates;
        }

        public final String getX509Thumbprint() {
            return this.x509Thumbprint;
        }

        public final String getX509Url() {
            return this.x509Url;
        }

        public Header setAlgorithm(String str) {
            this.algorithm = str;
            return this;
        }

        public Header setCritical(List<String> list) {
            this.critical = list;
            return this;
        }

        public Header setJwk(String str) {
            this.jwk = str;
            return this;
        }

        public Header setJwkUrl(String str) {
            this.jwkUrl = str;
            return this;
        }

        public Header setKeyId(String str) {
            this.keyId = str;
            return this;
        }

        @Deprecated
        public Header setX509Certificate(String str) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            this.x509Certificates = arrayList;
            return this;
        }

        public Header setX509Certificates(List<String> list) {
            this.x509Certificates = list;
            return this;
        }

        public Header setX509Thumbprint(String str) {
            this.x509Thumbprint = str;
            return this;
        }

        public Header setX509Url(String str) {
            this.x509Url = str;
            return this;
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Header
        public Header setType(String str) {
            super.setType(str);
            return this;
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Header, com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
        public Header set(String str, Object obj) {
            return (Header) super.set(str, obj);
        }

        @Override // com.google.api.client.json.webtoken.JsonWebToken.Header, com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
        public Header clone() {
            return (Header) super.clone();
        }
    }

    /* loaded from: classes5.dex */
    public static final class Parser {

        /* renamed from: a  reason: collision with root package name */
        private final JsonFactory f25908a;

        /* renamed from: b  reason: collision with root package name */
        private Class<? extends Header> f25909b = Header.class;

        /* renamed from: c  reason: collision with root package name */
        private Class<? extends JsonWebToken.Payload> f25910c = JsonWebToken.Payload.class;

        public Parser(JsonFactory jsonFactory) {
            this.f25908a = (JsonFactory) Preconditions.checkNotNull(jsonFactory);
        }

        public Class<? extends Header> getHeaderClass() {
            return this.f25909b;
        }

        public JsonFactory getJsonFactory() {
            return this.f25908a;
        }

        public Class<? extends JsonWebToken.Payload> getPayloadClass() {
            return this.f25910c;
        }

        public JsonWebSignature parse(String str) throws IOException {
            boolean z3;
            boolean z4;
            boolean z5;
            int indexOf = str.indexOf(46);
            boolean z6 = true;
            if (indexOf != -1) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            byte[] decodeBase64 = Base64.decodeBase64(str.substring(0, indexOf));
            int i4 = indexOf + 1;
            int indexOf2 = str.indexOf(46, i4);
            if (indexOf2 != -1) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4);
            int i5 = indexOf2 + 1;
            if (str.indexOf(46, i5) == -1) {
                z5 = true;
            } else {
                z5 = false;
            }
            Preconditions.checkArgument(z5);
            byte[] decodeBase642 = Base64.decodeBase64(str.substring(i4, indexOf2));
            byte[] decodeBase643 = Base64.decodeBase64(str.substring(i5));
            byte[] bytesUtf8 = StringUtils.getBytesUtf8(str.substring(0, indexOf2));
            Header header = (Header) this.f25908a.fromInputStream(new ByteArrayInputStream(decodeBase64), this.f25909b);
            if (header.getAlgorithm() == null) {
                z6 = false;
            }
            Preconditions.checkArgument(z6);
            return new JsonWebSignature(header, (JsonWebToken.Payload) this.f25908a.fromInputStream(new ByteArrayInputStream(decodeBase642), this.f25910c), decodeBase643, bytesUtf8);
        }

        public Parser setHeaderClass(Class<? extends Header> cls) {
            this.f25909b = cls;
            return this;
        }

        public Parser setPayloadClass(Class<? extends JsonWebToken.Payload> cls) {
            this.f25910c = cls;
            return this;
        }
    }

    public JsonWebSignature(Header header, JsonWebToken.Payload payload, byte[] bArr, byte[] bArr2) {
        super(header, payload);
        this.f25906c = (byte[]) Preconditions.checkNotNull(bArr);
        this.f25907d = (byte[]) Preconditions.checkNotNull(bArr2);
    }

    private static X509TrustManager a() {
        TrustManager[] trustManagers;
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
        } catch (KeyStoreException | NoSuchAlgorithmException unused) {
        }
        return null;
    }

    public static JsonWebSignature parse(JsonFactory jsonFactory, String str) throws IOException {
        return parser(jsonFactory).parse(str);
    }

    public static Parser parser(JsonFactory jsonFactory) {
        return new Parser(jsonFactory);
    }

    public static String signUsingRsaSha256(PrivateKey privateKey, JsonFactory jsonFactory, Header header, JsonWebToken.Payload payload) throws GeneralSecurityException, IOException {
        String valueOf = String.valueOf(Base64.encodeBase64URLSafeString(jsonFactory.toByteArray(header)));
        String valueOf2 = String.valueOf(Base64.encodeBase64URLSafeString(jsonFactory.toByteArray(payload)));
        StringBuilder sb = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
        sb.append(valueOf);
        sb.append(".");
        sb.append(valueOf2);
        String sb2 = sb.toString();
        byte[] sign = SecurityUtils.sign(SecurityUtils.getSha256WithRsaSignatureAlgorithm(), privateKey, StringUtils.getBytesUtf8(sb2));
        String valueOf3 = String.valueOf(sb2);
        String valueOf4 = String.valueOf(Base64.encodeBase64URLSafeString(sign));
        StringBuilder sb3 = new StringBuilder(valueOf3.length() + 1 + valueOf4.length());
        sb3.append(valueOf3);
        sb3.append(".");
        sb3.append(valueOf4);
        return sb3.toString();
    }

    public final byte[] getSignatureBytes() {
        return this.f25906c;
    }

    public final byte[] getSignedContentBytes() {
        return this.f25907d;
    }

    public final boolean verifySignature(PublicKey publicKey) throws GeneralSecurityException {
        if ("RS256".equals(getHeader().getAlgorithm())) {
            return SecurityUtils.verify(SecurityUtils.getSha256WithRsaSignatureAlgorithm(), publicKey, this.f25906c, this.f25907d);
        }
        return false;
    }

    @Override // com.google.api.client.json.webtoken.JsonWebToken
    public Header getHeader() {
        return (Header) super.getHeader();
    }

    @Beta
    public final X509Certificate verifySignature(X509TrustManager x509TrustManager) throws GeneralSecurityException {
        List<String> x509Certificates = getHeader().getX509Certificates();
        if (x509Certificates == null || x509Certificates.isEmpty() || !"RS256".equals(getHeader().getAlgorithm())) {
            return null;
        }
        return SecurityUtils.verify(SecurityUtils.getSha256WithRsaSignatureAlgorithm(), x509TrustManager, x509Certificates, this.f25906c, this.f25907d);
    }

    @Beta
    public final X509Certificate verifySignature() throws GeneralSecurityException {
        X509TrustManager a4 = a();
        if (a4 == null) {
            return null;
        }
        return verifySignature(a4);
    }
}
