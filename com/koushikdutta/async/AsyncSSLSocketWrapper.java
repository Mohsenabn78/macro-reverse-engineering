package com.koushikdutta.async;

import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.util.Allocator;
import com.koushikdutta.async.wrapper.AsyncSocketWrapper;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.AbstractVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;

/* loaded from: classes6.dex */
public class AsyncSSLSocketWrapper implements AsyncSocketWrapper, AsyncSSLSocket {

    /* renamed from: v  reason: collision with root package name */
    static SSLContext f34634v;

    /* renamed from: a  reason: collision with root package name */
    AsyncSocket f34635a;

    /* renamed from: b  reason: collision with root package name */
    BufferedDataSink f34636b;

    /* renamed from: c  reason: collision with root package name */
    boolean f34637c;

    /* renamed from: d  reason: collision with root package name */
    SSLEngine f34638d;

    /* renamed from: e  reason: collision with root package name */
    boolean f34639e;

    /* renamed from: f  reason: collision with root package name */
    private int f34640f;

    /* renamed from: g  reason: collision with root package name */
    private String f34641g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f34642h;

    /* renamed from: i  reason: collision with root package name */
    HostnameVerifier f34643i;

    /* renamed from: j  reason: collision with root package name */
    HandshakeCallback f34644j;

    /* renamed from: k  reason: collision with root package name */
    X509Certificate[] f34645k;

    /* renamed from: l  reason: collision with root package name */
    WritableCallback f34646l;

    /* renamed from: m  reason: collision with root package name */
    DataCallback f34647m;

    /* renamed from: n  reason: collision with root package name */
    TrustManager[] f34648n;

    /* renamed from: o  reason: collision with root package name */
    boolean f34649o;

    /* renamed from: p  reason: collision with root package name */
    boolean f34650p;

    /* renamed from: q  reason: collision with root package name */
    Exception f34651q;

    /* renamed from: r  reason: collision with root package name */
    final ByteBufferList f34652r = new ByteBufferList();

    /* renamed from: s  reason: collision with root package name */
    final DataCallback f34653s;

    /* renamed from: t  reason: collision with root package name */
    ByteBufferList f34654t;

    /* renamed from: u  reason: collision with root package name */
    CompletedCallback f34655u;

    /* loaded from: classes6.dex */
    public interface HandshakeCallback {
        void onHandshakeCompleted(Exception exc, AsyncSSLSocket asyncSSLSocket);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class b implements CompletedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HandshakeCallback f34656a;

        b(HandshakeCallback handshakeCallback) {
            this.f34656a = handshakeCallback;
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            if (exc != null) {
                this.f34656a.onHandshakeCompleted(exc, null);
            } else {
                this.f34656a.onHandshakeCompleted(new SSLException("socket closed during handshake"), null);
            }
        }
    }

    /* loaded from: classes6.dex */
    class c implements WritableCallback {
        c() {
        }

        @Override // com.koushikdutta.async.callback.WritableCallback
        public void onWriteable() {
            WritableCallback writableCallback = AsyncSSLSocketWrapper.this.f34646l;
            if (writableCallback != null) {
                writableCallback.onWriteable();
            }
        }
    }

    /* loaded from: classes6.dex */
    class d implements CompletedCallback {
        d() {
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            CompletedCallback completedCallback;
            AsyncSSLSocketWrapper asyncSSLSocketWrapper = AsyncSSLSocketWrapper.this;
            if (asyncSSLSocketWrapper.f34650p) {
                return;
            }
            asyncSSLSocketWrapper.f34650p = true;
            asyncSSLSocketWrapper.f34651q = exc;
            if (!asyncSSLSocketWrapper.f34652r.hasRemaining() && (completedCallback = AsyncSSLSocketWrapper.this.f34655u) != null) {
                completedCallback.onCompleted(exc);
            }
        }
    }

    /* loaded from: classes6.dex */
    class e implements DataCallback {

        /* renamed from: a  reason: collision with root package name */
        final Allocator f34659a = new Allocator().setMinAlloc(8192);

        /* renamed from: b  reason: collision with root package name */
        final ByteBufferList f34660b = new ByteBufferList();

        e() {
        }

        @Override // com.koushikdutta.async.callback.DataCallback
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            AsyncSSLSocketWrapper asyncSSLSocketWrapper = AsyncSSLSocketWrapper.this;
            if (asyncSSLSocketWrapper.f34637c) {
                return;
            }
            try {
                try {
                    asyncSSLSocketWrapper.f34637c = true;
                    byteBufferList.get(this.f34660b);
                    if (this.f34660b.hasRemaining()) {
                        this.f34660b.add(this.f34660b.getAll());
                    }
                    ByteBuffer byteBuffer = ByteBufferList.EMPTY_BYTEBUFFER;
                    while (true) {
                        if (byteBuffer.remaining() == 0 && this.f34660b.size() > 0) {
                            byteBuffer = this.f34660b.remove();
                        }
                        int remaining = byteBuffer.remaining();
                        int remaining2 = AsyncSSLSocketWrapper.this.f34652r.remaining();
                        ByteBuffer allocate = this.f34659a.allocate();
                        SSLEngineResult unwrap = AsyncSSLSocketWrapper.this.f34638d.unwrap(byteBuffer, allocate);
                        AsyncSSLSocketWrapper asyncSSLSocketWrapper2 = AsyncSSLSocketWrapper.this;
                        asyncSSLSocketWrapper2.c(asyncSSLSocketWrapper2.f34652r, allocate);
                        this.f34659a.track(AsyncSSLSocketWrapper.this.f34652r.remaining() - remaining2);
                        if (unwrap.getStatus() == SSLEngineResult.Status.BUFFER_OVERFLOW) {
                            Allocator allocator = this.f34659a;
                            allocator.setMinAlloc(allocator.getMinAlloc() * 2);
                        } else {
                            if (unwrap.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW) {
                                this.f34660b.addFirst(byteBuffer);
                                if (this.f34660b.size() <= 1) {
                                    break;
                                }
                                this.f34660b.addFirst(this.f34660b.getAll());
                                byteBuffer = ByteBufferList.EMPTY_BYTEBUFFER;
                            }
                            AsyncSSLSocketWrapper.this.e(unwrap.getHandshakeStatus());
                            if (byteBuffer.remaining() != remaining && remaining2 == AsyncSSLSocketWrapper.this.f34652r.remaining()) {
                                this.f34660b.addFirst(byteBuffer);
                                break;
                            }
                        }
                        remaining = -1;
                        AsyncSSLSocketWrapper.this.e(unwrap.getHandshakeStatus());
                        if (byteBuffer.remaining() != remaining) {
                        }
                    }
                    AsyncSSLSocketWrapper.this.onDataAvailable();
                } catch (SSLException e4) {
                    e4.printStackTrace();
                    AsyncSSLSocketWrapper.this.f(e4);
                }
            } finally {
                AsyncSSLSocketWrapper.this.f34637c = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WritableCallback writableCallback = AsyncSSLSocketWrapper.this.f34646l;
            if (writableCallback != null) {
                writableCallback.onWriteable();
            }
        }
    }

    static {
        try {
            f34634v = SSLContext.getInstance("Default");
        } catch (Exception e4) {
            try {
                f34634v = SSLContext.getInstance(SSLSocketFactory.TLS);
                f34634v.init(null, new TrustManager[]{new a()}, null);
            } catch (Exception e5) {
                e4.printStackTrace();
                e5.printStackTrace();
            }
        }
    }

    private AsyncSSLSocketWrapper(AsyncSocket asyncSocket, String str, int i4, SSLEngine sSLEngine, TrustManager[] trustManagerArr, HostnameVerifier hostnameVerifier, boolean z3) {
        e eVar = new e();
        this.f34653s = eVar;
        this.f34654t = new ByteBufferList();
        this.f34635a = asyncSocket;
        this.f34643i = hostnameVerifier;
        this.f34649o = z3;
        this.f34648n = trustManagerArr;
        this.f34638d = sSLEngine;
        this.f34641g = str;
        this.f34640f = i4;
        sSLEngine.setUseClientMode(z3);
        BufferedDataSink bufferedDataSink = new BufferedDataSink(asyncSocket);
        this.f34636b = bufferedDataSink;
        bufferedDataSink.setWriteableCallback(new c());
        this.f34635a.setEndCallback(new d());
        this.f34635a.setDataCallback(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SSLEngineResult.HandshakeStatus handshakeStatus) {
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_TASK) {
            this.f34638d.getDelegatedTask().run();
        }
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
            write(this.f34654t);
        }
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
            this.f34653s.onDataAvailable(this, new ByteBufferList());
        }
        try {
            try {
                if (!this.f34639e) {
                    if (this.f34638d.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING || this.f34638d.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
                        if (this.f34649o) {
                            TrustManager[] trustManagerArr = this.f34648n;
                            if (trustManagerArr == null) {
                                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                                trustManagerFactory.init((KeyStore) null);
                                trustManagerArr = trustManagerFactory.getTrustManagers();
                            }
                            boolean z3 = false;
                            Throwable e4 = null;
                            int i4 = 0;
                            while (true) {
                                if (i4 >= trustManagerArr.length) {
                                    break;
                                }
                                try {
                                    X509TrustManager x509TrustManager = (X509TrustManager) trustManagerArr[i4];
                                    X509Certificate[] x509CertificateArr = (X509Certificate[]) this.f34638d.getSession().getPeerCertificates();
                                    this.f34645k = x509CertificateArr;
                                    x509TrustManager.checkServerTrusted(x509CertificateArr, SSLSocketFactory.SSL);
                                    String str = this.f34641g;
                                    if (str != null) {
                                        HostnameVerifier hostnameVerifier = this.f34643i;
                                        if (hostnameVerifier == null) {
                                            new StrictHostnameVerifier().verify(this.f34641g, AbstractVerifier.getCNs(this.f34645k[0]), AbstractVerifier.getDNSSubjectAlts(this.f34645k[0]));
                                        } else if (!hostnameVerifier.verify(str, this.f34638d.getSession())) {
                                            throw new SSLException("hostname <" + this.f34641g + "> has been denied");
                                        }
                                    }
                                    z3 = true;
                                } catch (GeneralSecurityException | SSLException e5) {
                                    e4 = e5;
                                    i4++;
                                }
                                i4++;
                            }
                            this.f34639e = true;
                            if (!z3) {
                                AsyncSSLException asyncSSLException = new AsyncSSLException(e4);
                                f(asyncSSLException);
                                if (!asyncSSLException.getIgnore()) {
                                    throw asyncSSLException;
                                }
                            }
                        } else {
                            this.f34639e = true;
                        }
                        this.f34644j.onHandshakeCompleted(null, this);
                        this.f34644j = null;
                        this.f34635a.setClosedCallback(null);
                        getServer().post(new f());
                        onDataAvailable();
                    }
                }
            } catch (NoSuchAlgorithmException e6) {
                throw new RuntimeException(e6);
            } catch (GeneralSecurityException e7) {
                f(e7);
            }
        } catch (AsyncSSLException e8) {
            f(e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Exception exc) {
        HandshakeCallback handshakeCallback = this.f34644j;
        if (handshakeCallback != null) {
            this.f34644j = null;
            this.f34635a.setDataCallback(new DataCallback.NullDataCallback());
            this.f34635a.end();
            this.f34635a.setClosedCallback(null);
            this.f34635a.close();
            handshakeCallback.onHandshakeCompleted(exc, null);
            return;
        }
        CompletedCallback endCallback = getEndCallback();
        if (endCallback != null) {
            endCallback.onCompleted(exc);
        }
    }

    public static SSLContext getDefaultSSLContext() {
        return f34634v;
    }

    public static void handshake(AsyncSocket asyncSocket, String str, int i4, SSLEngine sSLEngine, TrustManager[] trustManagerArr, HostnameVerifier hostnameVerifier, boolean z3, HandshakeCallback handshakeCallback) {
        AsyncSSLSocketWrapper asyncSSLSocketWrapper = new AsyncSSLSocketWrapper(asyncSocket, str, i4, sSLEngine, trustManagerArr, hostnameVerifier, z3);
        asyncSSLSocketWrapper.f34644j = handshakeCallback;
        asyncSocket.setClosedCallback(new b(handshakeCallback));
        try {
            asyncSSLSocketWrapper.f34638d.beginHandshake();
            asyncSSLSocketWrapper.e(asyncSSLSocketWrapper.f34638d.getHandshakeStatus());
        } catch (SSLException e4) {
            asyncSSLSocketWrapper.f(e4);
        }
    }

    void c(ByteBufferList byteBufferList, ByteBuffer byteBuffer) {
        byteBuffer.flip();
        if (byteBuffer.hasRemaining()) {
            byteBufferList.add(byteBuffer);
        } else {
            ByteBufferList.reclaim(byteBuffer);
        }
    }

    @Override // com.koushikdutta.async.DataEmitter
    public String charset() {
        return null;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void close() {
        this.f34635a.close();
    }

    int d(int i4) {
        int i5 = (i4 * 3) / 2;
        if (i5 == 0) {
            return 8192;
        }
        return i5;
    }

    @Override // com.koushikdutta.async.DataSink
    public void end() {
        this.f34635a.end();
    }

    @Override // com.koushikdutta.async.DataSink
    public CompletedCallback getClosedCallback() {
        return this.f34635a.getClosedCallback();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public DataCallback getDataCallback() {
        return this.f34647m;
    }

    @Override // com.koushikdutta.async.wrapper.DataEmitterWrapper
    public DataEmitter getDataEmitter() {
        return this.f34635a;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public CompletedCallback getEndCallback() {
        return this.f34655u;
    }

    public String getHost() {
        return this.f34641g;
    }

    @Override // com.koushikdutta.async.AsyncSSLSocket
    public X509Certificate[] getPeerCertificates() {
        return this.f34645k;
    }

    public int getPort() {
        return this.f34640f;
    }

    @Override // com.koushikdutta.async.AsyncSSLSocket
    public SSLEngine getSSLEngine() {
        return this.f34638d;
    }

    @Override // com.koushikdutta.async.AsyncSocket, com.koushikdutta.async.DataEmitter, com.koushikdutta.async.DataSink
    public AsyncServer getServer() {
        return this.f34635a.getServer();
    }

    @Override // com.koushikdutta.async.wrapper.AsyncSocketWrapper
    public AsyncSocket getSocket() {
        return this.f34635a;
    }

    @Override // com.koushikdutta.async.DataSink
    public WritableCallback getWriteableCallback() {
        return this.f34646l;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isChunked() {
        return this.f34635a.isChunked();
    }

    @Override // com.koushikdutta.async.DataSink
    public boolean isOpen() {
        return this.f34635a.isOpen();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isPaused() {
        return this.f34635a.isPaused();
    }

    public void onDataAvailable() {
        CompletedCallback completedCallback;
        Util.emitAllData(this, this.f34652r);
        if (this.f34650p && !this.f34652r.hasRemaining() && (completedCallback = this.f34655u) != null) {
            completedCallback.onCompleted(this.f34651q);
        }
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void pause() {
        this.f34635a.pause();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void resume() {
        this.f34635a.resume();
        onDataAvailable();
    }

    @Override // com.koushikdutta.async.DataSink
    public void setClosedCallback(CompletedCallback completedCallback) {
        this.f34635a.setClosedCallback(completedCallback);
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void setDataCallback(DataCallback dataCallback) {
        this.f34647m = dataCallback;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void setEndCallback(CompletedCallback completedCallback) {
        this.f34655u = completedCallback;
    }

    @Override // com.koushikdutta.async.DataSink
    public void setWriteableCallback(WritableCallback writableCallback) {
        this.f34646l = writableCallback;
    }

    @Override // com.koushikdutta.async.DataSink
    public void write(ByteBufferList byteBufferList) {
        int capacity;
        if (this.f34642h || this.f34636b.remaining() > 0) {
            return;
        }
        this.f34642h = true;
        ByteBuffer obtain = ByteBufferList.obtain(d(byteBufferList.remaining()));
        SSLEngineResult sSLEngineResult = null;
        do {
            if (!this.f34639e || byteBufferList.remaining() != 0) {
                int remaining = byteBufferList.remaining();
                try {
                    ByteBuffer[] allArray = byteBufferList.getAllArray();
                    sSLEngineResult = this.f34638d.wrap(allArray, obtain);
                    byteBufferList.addAll(allArray);
                    obtain.flip();
                    this.f34654t.add(obtain);
                    if (this.f34654t.remaining() > 0) {
                        this.f34636b.write(this.f34654t);
                    }
                    capacity = obtain.capacity();
                } catch (SSLException e4) {
                    e = e4;
                }
                try {
                    if (sSLEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_OVERFLOW) {
                        obtain = ByteBufferList.obtain(capacity * 2);
                        remaining = -1;
                    } else {
                        obtain = ByteBufferList.obtain(d(byteBufferList.remaining()));
                        e(sSLEngineResult.getHandshakeStatus());
                    }
                } catch (SSLException e5) {
                    e = e5;
                    obtain = null;
                    f(e);
                    if (remaining != byteBufferList.remaining()) {
                    }
                    if (this.f34636b.remaining() != 0) {
                        this.f34642h = false;
                        ByteBufferList.reclaim(obtain);
                    }
                }
                if (remaining != byteBufferList.remaining() && (sSLEngineResult == null || sSLEngineResult.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NEED_WRAP)) {
                    break;
                }
            } else {
                break;
            }
        } while (this.f34636b.remaining() != 0);
        this.f34642h = false;
        ByteBufferList.reclaim(obtain);
    }

    /* loaded from: classes6.dex */
    static class a implements X509TrustManager {
        a() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            for (X509Certificate x509Certificate : x509CertificateArr) {
                if (x509Certificate != null && x509Certificate.getCriticalExtensionOIDs() != null) {
                    x509Certificate.getCriticalExtensionOIDs().remove("2.5.29.15");
                }
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }
    }
}
