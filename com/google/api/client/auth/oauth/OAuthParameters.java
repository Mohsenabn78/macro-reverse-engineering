package com.google.api.client.auth.oauth;

import androidx.webkit.ProxyConfig;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.util.Beta;
import com.google.api.client.util.escape.PercentEscaper;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

@Beta
/* loaded from: classes5.dex */
public final class OAuthParameters implements HttpExecuteInterceptor, HttpRequestInitializer {

    /* renamed from: a  reason: collision with root package name */
    private static final SecureRandom f25465a = new SecureRandom();

    /* renamed from: b  reason: collision with root package name */
    private static final PercentEscaper f25466b = new PercentEscaper("-_.~", false);
    public String callback;
    public String consumerKey;
    public String nonce;
    public String realm;
    public String signature;
    public String signatureMethod;
    public OAuthSigner signer;
    public String timestamp;
    public String token;
    public String verifier;
    public String version;

    private void a(StringBuilder sb, String str, String str2) {
        if (str2 != null) {
            sb.append(' ');
            sb.append(escape(str));
            sb.append("=\"");
            sb.append(escape(str2));
            sb.append("\",");
        }
    }

    private void b(TreeMap<String, String> treeMap, String str, Object obj) {
        String escape;
        String escape2 = escape(str);
        if (obj == null) {
            escape = null;
        } else {
            escape = escape(obj.toString());
        }
        treeMap.put(escape2, escape);
    }

    private void c(TreeMap<String, String> treeMap, String str, String str2) {
        if (str2 != null) {
            b(treeMap, str, str2);
        }
    }

    public static String escape(String str) {
        return f25466b.escape(str);
    }

    public void computeNonce() {
        this.nonce = Long.toHexString(Math.abs(f25465a.nextLong()));
    }

    public void computeSignature(String str, GenericUrl genericUrl) throws GeneralSecurityException {
        OAuthSigner oAuthSigner = this.signer;
        String signatureMethod = oAuthSigner.getSignatureMethod();
        this.signatureMethod = signatureMethod;
        TreeMap<String, String> treeMap = new TreeMap<>();
        c(treeMap, "oauth_callback", this.callback);
        c(treeMap, "oauth_consumer_key", this.consumerKey);
        c(treeMap, "oauth_nonce", this.nonce);
        c(treeMap, "oauth_signature_method", signatureMethod);
        c(treeMap, "oauth_timestamp", this.timestamp);
        c(treeMap, "oauth_token", this.token);
        c(treeMap, "oauth_verifier", this.verifier);
        c(treeMap, "oauth_version", this.version);
        for (Map.Entry<String, Object> entry : genericUrl.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                String key = entry.getKey();
                if (value instanceof Collection) {
                    for (Object obj : (Collection) value) {
                        b(treeMap, key, obj);
                    }
                } else {
                    b(treeMap, key, value);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean z3 = true;
        for (Map.Entry<String, String> entry2 : treeMap.entrySet()) {
            if (z3) {
                z3 = false;
            } else {
                sb.append(Typography.amp);
            }
            sb.append(entry2.getKey());
            String value2 = entry2.getValue();
            if (value2 != null) {
                sb.append(SignatureVisitor.INSTANCEOF);
                sb.append(value2);
            }
        }
        String sb2 = sb.toString();
        GenericUrl genericUrl2 = new GenericUrl();
        String scheme = genericUrl.getScheme();
        genericUrl2.setScheme(scheme);
        genericUrl2.setHost(genericUrl.getHost());
        genericUrl2.setPathParts(genericUrl.getPathParts());
        int port = genericUrl.getPort();
        if (("http".equals(scheme) && port == 80) || (ProxyConfig.MATCH_HTTPS.equals(scheme) && port == 443)) {
            port = -1;
        }
        genericUrl2.setPort(port);
        String build = genericUrl2.build();
        this.signature = oAuthSigner.computeSignature(escape(str) + Typography.amp + escape(build) + Typography.amp + escape(sb2));
    }

    public void computeTimestamp() {
        this.timestamp = Long.toString(System.currentTimeMillis() / 1000);
    }

    public String getAuthorizationHeader() {
        StringBuilder sb = new StringBuilder("OAuth");
        a(sb, "realm", this.realm);
        a(sb, "oauth_callback", this.callback);
        a(sb, "oauth_consumer_key", this.consumerKey);
        a(sb, "oauth_nonce", this.nonce);
        a(sb, "oauth_signature", this.signature);
        a(sb, "oauth_signature_method", this.signatureMethod);
        a(sb, "oauth_timestamp", this.timestamp);
        a(sb, "oauth_token", this.token);
        a(sb, "oauth_verifier", this.verifier);
        a(sb, "oauth_version", this.version);
        return sb.substring(0, sb.length() - 1);
    }

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void initialize(HttpRequest httpRequest) throws IOException {
        httpRequest.setInterceptor(this);
    }

    @Override // com.google.api.client.http.HttpExecuteInterceptor
    public void intercept(HttpRequest httpRequest) throws IOException {
        computeNonce();
        computeTimestamp();
        try {
            computeSignature(httpRequest.getRequestMethod(), httpRequest.getUrl());
            httpRequest.getHeaders().setAuthorization(getAuthorizationHeader());
        } catch (GeneralSecurityException e4) {
            IOException iOException = new IOException();
            iOException.initCause(e4);
            throw iOException;
        }
    }
}
