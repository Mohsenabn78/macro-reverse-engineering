package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcdv extends SSLSocketFactory {
    final SSLSocketFactory zza = (SSLSocketFactory) SSLSocketFactory.getDefault();
    final /* synthetic */ zzcdw zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcdv(zzcdw zzcdwVar) {
        this.zzb = zzcdwVar;
    }

    private final Socket zza(Socket socket) throws SocketException {
        int i4;
        int i5;
        zzcdw zzcdwVar = this.zzb;
        i4 = zzcdwVar.zzr;
        if (i4 > 0) {
            i5 = zzcdwVar.zzr;
            socket.setReceiveBufferSize(i5);
        }
        this.zzb.zzs.add(socket);
        return socket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i4) throws IOException {
        Socket createSocket = this.zza.createSocket(str, i4);
        zza(createSocket);
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.zza.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.zza.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i4, InetAddress inetAddress, int i5) throws IOException {
        Socket createSocket = this.zza.createSocket(str, i4, inetAddress, i5);
        zza(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i4) throws IOException {
        Socket createSocket = this.zza.createSocket(inetAddress, i4);
        zza(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i4, InetAddress inetAddress2, int i5) throws IOException {
        Socket createSocket = this.zza.createSocket(inetAddress, i4, inetAddress2, i5);
        zza(createSocket);
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i4, boolean z3) throws IOException {
        Socket createSocket = this.zza.createSocket(socket, str, i4, z3);
        zza(createSocket);
        return createSocket;
    }
}
