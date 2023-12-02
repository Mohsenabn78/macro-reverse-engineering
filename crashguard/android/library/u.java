package crashguard.android.library;

import com.google.mlkit.nl.translate.TranslateLanguage;
import java.io.ByteArrayInputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import net.bytebuddy.asm.Advice;

/* loaded from: classes6.dex */
final class u extends g0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public u(String str, ByteArrayInputStream byteArrayInputStream) throws Exception {
        super(str);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) this.f38746a;
        httpsURLConnection.setSSLSocketFactory(f(byteArrayInputStream));
        httpsURLConnection.setHostnameVerifier(new l0(httpsURLConnection.getURL().getHost()));
    }

    private static SSLSocketFactory f(ByteArrayInputStream byteArrayInputStream) throws Exception {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        char[] cArr = {'T', 'h', 'i', Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, 'P', 'a', Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, 'w', 'o', Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'I', Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, 'I', 'n', Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, 'i', 'g', 'n', 'i', 'f', 'i', 'c', 'a', 'n', Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, 'R', 'e', 'a', 'l', 'l', 'y'};
        keyStore.load(null, cArr);
        keyStore.setCertificateEntry(TranslateLanguage.CATALAN, certificateFactory.generateCertificate(byteArrayInputStream));
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, cArr);
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        SSLContext sSLContext = SSLContext.getInstance(org.apache.http.conn.ssl.SSLSocketFactory.TLS);
        sSLContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());
        return sSLContext.getSocketFactory();
    }
}
