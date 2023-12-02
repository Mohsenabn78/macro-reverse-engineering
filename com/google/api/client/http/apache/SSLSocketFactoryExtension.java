package com.google.api.client.http.apache;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* loaded from: classes5.dex */
final class SSLSocketFactoryExtension extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private final javax.net.ssl.SSLSocketFactory f25869a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SSLSocketFactoryExtension(SSLContext sSLContext) throws KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException {
        super((KeyStore) null);
        this.f25869a = sSLContext.getSocketFactory();
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        return this.f25869a.createSocket();
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i4, boolean z3) throws IOException, UnknownHostException {
        SSLSocket sSLSocket = (SSLSocket) this.f25869a.createSocket(socket, str, i4, z3);
        getHostnameVerifier().verify(str, sSLSocket);
        return sSLSocket;
    }
}
