package com.koushikdutta.async;

import android.os.Handler;
import android.util.Log;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.callback.ListenCallback;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.future.TransformFuture;
import com.koushikdutta.async.util.StreamUtility;
import java.io.Closeable;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public class AsyncServer {
    public static final String LOGTAG = "NIO";

    /* renamed from: f  reason: collision with root package name */
    static AsyncServer f34664f = new AsyncServer();

    /* renamed from: g  reason: collision with root package name */
    private static ExecutorService f34665g = k("AsyncServer-worker-");

    /* renamed from: h  reason: collision with root package name */
    private static final Comparator<InetAddress> f34666h = new n();

    /* renamed from: i  reason: collision with root package name */
    private static ExecutorService f34667i = k("AsyncServer-resolver-");

    /* renamed from: j  reason: collision with root package name */
    static final WeakHashMap<Thread, AsyncServer> f34668j = new WeakHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private SelectorWrapper f34669a;

    /* renamed from: b  reason: collision with root package name */
    String f34670b;

    /* renamed from: c  reason: collision with root package name */
    int f34671c;

    /* renamed from: d  reason: collision with root package name */
    PriorityQueue<u> f34672d;

    /* renamed from: e  reason: collision with root package name */
    Thread f34673e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends TransformFuture<InetAddress, InetAddress[]> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.future.TransformFuture
        /* renamed from: l */
        public void k(InetAddress[] inetAddressArr) throws Exception {
            setComplete((a) inetAddressArr[0]);
        }
    }

    /* loaded from: classes6.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f34675a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f34676b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AsyncDatagramSocket f34677c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ DatagramChannel f34678d;

        b(String str, int i4, AsyncDatagramSocket asyncDatagramSocket, DatagramChannel datagramChannel) {
            this.f34675a = str;
            this.f34676b = i4;
            this.f34677c = asyncDatagramSocket;
            this.f34678d = datagramChannel;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f34675a, this.f34676b);
                AsyncServer.this.i(this.f34677c);
                this.f34678d.connect(inetSocketAddress);
            } catch (IOException e4) {
                Log.e(AsyncServer.LOGTAG, "Datagram error", e4);
                StreamUtility.closeQuietly(this.f34678d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f34680a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DatagramChannel f34681b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SocketAddress f34682c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ AsyncDatagramSocket f34683d;

        c(boolean z3, DatagramChannel datagramChannel, SocketAddress socketAddress, AsyncDatagramSocket asyncDatagramSocket) {
            this.f34680a = z3;
            this.f34681b = datagramChannel;
            this.f34682c = socketAddress;
            this.f34683d = asyncDatagramSocket;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f34680a) {
                    this.f34681b.socket().setReuseAddress(this.f34680a);
                }
                this.f34681b.socket().bind(this.f34682c);
                AsyncServer.this.i(this.f34683d);
            } catch (IOException e4) {
                Log.e(AsyncServer.LOGTAG, "Datagram error", e4);
                StreamUtility.closeQuietly(this.f34681b);
            }
        }
    }

    /* loaded from: classes6.dex */
    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AsyncDatagramSocket f34685a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DatagramChannel f34686b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SocketAddress f34687c;

        d(AsyncDatagramSocket asyncDatagramSocket, DatagramChannel datagramChannel, SocketAddress socketAddress) {
            this.f34685a = asyncDatagramSocket;
            this.f34686b = datagramChannel;
            this.f34687c = socketAddress;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                AsyncServer.this.i(this.f34685a);
                this.f34686b.connect(this.f34687c);
            } catch (IOException unused) {
                StreamUtility.closeQuietly(this.f34686b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SelectorWrapper f34689a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PriorityQueue f34690b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, SelectorWrapper selectorWrapper, PriorityQueue priorityQueue) {
            super(str);
            this.f34689a = selectorWrapper;
            this.f34690b = priorityQueue;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AsyncServer.n(AsyncServer.this, this.f34689a, this.f34690b);
        }
    }

    /* loaded from: classes6.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AsyncServer.this.f34669a == null) {
                Log.i(AsyncServer.LOGTAG, "Server dump not possible. No selector?");
                return;
            }
            Log.i(AsyncServer.LOGTAG, "Key Count: " + AsyncServer.this.f34669a.keys().size());
            Iterator<SelectionKey> it = AsyncServer.this.f34669a.keys().iterator();
            while (it.hasNext()) {
                Log.i(AsyncServer.LOGTAG, "Key: " + it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SelectorWrapper f34693a;

        g(SelectorWrapper selectorWrapper) {
            this.f34693a = selectorWrapper;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f34693a.wakeupOnce();
            } catch (Exception unused) {
                Log.i(AsyncServer.LOGTAG, "Selector Exception? L Preview?");
            }
        }
    }

    /* loaded from: classes6.dex */
    class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CompletedCallback f34694a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Exception f34695b;

        h(CompletedCallback completedCallback, Exception exc) {
            this.f34694a = completedCallback;
            this.f34695b = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f34694a.onCompleted(this.f34695b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f34697a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Semaphore f34698b;

        i(Runnable runnable, Semaphore semaphore) {
            this.f34697a = runnable;
            this.f34698b = semaphore;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f34697a.run();
            this.f34698b.release();
        }
    }

    /* loaded from: classes6.dex */
    class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SelectorWrapper f34700a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Semaphore f34701b;

        j(SelectorWrapper selectorWrapper, Semaphore semaphore) {
            this.f34700a = selectorWrapper;
            this.f34701b = semaphore;
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncServer.q(this.f34700a);
            this.f34701b.release();
        }
    }

    /* loaded from: classes6.dex */
    class k implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InetAddress f34703a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f34704b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ListenCallback f34705c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ s f34706d;

        /* loaded from: classes6.dex */
        class a implements AsyncServerSocket {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ServerSocketChannel f34708a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ com.koushikdutta.async.c f34709b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ SelectionKey f34710c;

            a(ServerSocketChannel serverSocketChannel, com.koushikdutta.async.c cVar, SelectionKey selectionKey) {
                this.f34708a = serverSocketChannel;
                this.f34709b = cVar;
                this.f34710c = selectionKey;
            }

            @Override // com.koushikdutta.async.AsyncServerSocket
            public int getLocalPort() {
                return this.f34708a.socket().getLocalPort();
            }

            @Override // com.koushikdutta.async.AsyncServerSocket
            public void stop() {
                StreamUtility.closeQuietly(this.f34709b);
                try {
                    this.f34710c.cancel();
                } catch (Exception unused) {
                }
            }
        }

        k(InetAddress inetAddress, int i4, ListenCallback listenCallback, s sVar) {
            this.f34703a = inetAddress;
            this.f34704b = i4;
            this.f34705c = listenCallback;
            this.f34706d = sVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [T, com.koushikdutta.async.AsyncServerSocket, com.koushikdutta.async.AsyncServer$k$a] */
        @Override // java.lang.Runnable
        public void run() {
            com.koushikdutta.async.c cVar;
            IOException e4;
            ServerSocketChannel serverSocketChannel;
            InetSocketAddress inetSocketAddress;
            try {
                serverSocketChannel = ServerSocketChannel.open();
                try {
                    cVar = new com.koushikdutta.async.c(serverSocketChannel);
                    try {
                        if (this.f34703a == null) {
                            inetSocketAddress = new InetSocketAddress(this.f34704b);
                        } else {
                            inetSocketAddress = new InetSocketAddress(this.f34703a, this.f34704b);
                        }
                        serverSocketChannel.socket().bind(inetSocketAddress);
                        SelectionKey e5 = cVar.e(AsyncServer.this.f34669a.getSelector());
                        e5.attach(this.f34705c);
                        ListenCallback listenCallback = this.f34705c;
                        s sVar = this.f34706d;
                        ?? aVar = new a(serverSocketChannel, cVar, e5);
                        sVar.f34733a = aVar;
                        listenCallback.onListening(aVar);
                    } catch (IOException e6) {
                        e4 = e6;
                        Log.e(AsyncServer.LOGTAG, "wtf", e4);
                        StreamUtility.closeQuietly(cVar, serverSocketChannel);
                        this.f34705c.onCompleted(e4);
                    }
                } catch (IOException e7) {
                    cVar = null;
                    e4 = e7;
                }
            } catch (IOException e8) {
                cVar = null;
                e4 = e8;
                serverSocketChannel = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class l implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q f34712a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ConnectCallback f34713b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ InetSocketAddress f34714c;

        l(q qVar, ConnectCallback connectCallback, InetSocketAddress inetSocketAddress) {
            this.f34712a = qVar;
            this.f34713b = connectCallback;
            this.f34714c = inetSocketAddress;
        }

        @Override // java.lang.Runnable
        public void run() {
            SocketChannel socketChannel;
            if (this.f34712a.isCancelled()) {
                return;
            }
            q qVar = this.f34712a;
            qVar.f34728j = this.f34713b;
            SelectionKey selectionKey = null;
            try {
                socketChannel = SocketChannel.open();
                qVar.f34727i = socketChannel;
            } catch (Throwable th) {
                th = th;
                socketChannel = null;
            }
            try {
                socketChannel.configureBlocking(false);
                selectionKey = socketChannel.register(AsyncServer.this.f34669a.getSelector(), 8);
                selectionKey.attach(this.f34712a);
                socketChannel.connect(this.f34714c);
            } catch (Throwable th2) {
                th = th2;
                if (selectionKey != null) {
                    selectionKey.cancel();
                }
                StreamUtility.closeQuietly(socketChannel);
                this.f34712a.setComplete((Exception) new RuntimeException(th));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class m implements FutureCallback<InetAddress> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConnectCallback f34716a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SimpleFuture f34717b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ InetSocketAddress f34718c;

        m(ConnectCallback connectCallback, SimpleFuture simpleFuture, InetSocketAddress inetSocketAddress) {
            this.f34716a = connectCallback;
            this.f34717b = simpleFuture;
            this.f34718c = inetSocketAddress;
        }

        @Override // com.koushikdutta.async.future.FutureCallback
        /* renamed from: a */
        public void onCompleted(Exception exc, InetAddress inetAddress) {
            if (exc != null) {
                this.f34716a.onConnectCompleted(exc, null);
                this.f34717b.setComplete(exc);
                return;
            }
            this.f34717b.setComplete((Future) AsyncServer.this.h(new InetSocketAddress(inetAddress, this.f34718c.getPort()), this.f34716a));
        }
    }

    /* loaded from: classes6.dex */
    static class n implements Comparator<InetAddress> {
        n() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(InetAddress inetAddress, InetAddress inetAddress2) {
            boolean z3 = inetAddress instanceof Inet4Address;
            if (z3 && (inetAddress2 instanceof Inet4Address)) {
                return 0;
            }
            if ((inetAddress instanceof Inet6Address) && (inetAddress2 instanceof Inet6Address)) {
                return 0;
            }
            if (z3 && (inetAddress2 instanceof Inet6Address)) {
                return -1;
            }
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f34720a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SimpleFuture f34721b;

        /* loaded from: classes6.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ InetAddress[] f34723a;

            a(InetAddress[] inetAddressArr) {
                this.f34723a = inetAddressArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f34721b.setComplete(null, this.f34723a);
            }
        }

        /* loaded from: classes6.dex */
        class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Exception f34725a;

            b(Exception exc) {
                this.f34725a = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f34721b.setComplete(this.f34725a, null);
            }
        }

        o(String str, SimpleFuture simpleFuture) {
            this.f34720a = str;
            this.f34721b = simpleFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                InetAddress[] allByName = InetAddress.getAllByName(this.f34720a);
                Arrays.sort(allByName, AsyncServer.f34666h);
                if (allByName != null && allByName.length != 0) {
                    AsyncServer.this.post(new a(allByName));
                    return;
                }
                throw new HostnameResolutionException("no addresses for host");
            } catch (Exception e4) {
                AsyncServer.this.post(new b(e4));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class p extends IOException {
        public p(Exception exc) {
            super(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class q extends SimpleFuture<AsyncNetworkSocket> {

        /* renamed from: i  reason: collision with root package name */
        SocketChannel f34727i;

        /* renamed from: j  reason: collision with root package name */
        ConnectCallback f34728j;

        private q() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.koushikdutta.async.future.SimpleCancellable
        public void a() {
            super.a();
            try {
                SocketChannel socketChannel = this.f34727i;
                if (socketChannel != null) {
                    socketChannel.close();
                }
            } catch (IOException unused) {
            }
        }

        /* synthetic */ q(AsyncServer asyncServer, g gVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class r implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final ThreadGroup f34730a;

        /* renamed from: b  reason: collision with root package name */
        private final AtomicInteger f34731b = new AtomicInteger(1);

        /* renamed from: c  reason: collision with root package name */
        private final String f34732c;

        r(String str) {
            ThreadGroup threadGroup;
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
            this.f34730a = threadGroup;
            this.f34732c = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.f34730a;
            Thread thread = new Thread(threadGroup, runnable, this.f34732c + this.f34731b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    /* loaded from: classes6.dex */
    private static class s<T> {

        /* renamed from: a  reason: collision with root package name */
        T f34733a;

        private s() {
        }

        /* synthetic */ s(g gVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    private static class t implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        boolean f34734a;

        /* renamed from: b  reason: collision with root package name */
        Runnable f34735b;

        /* renamed from: c  reason: collision with root package name */
        ThreadQueue f34736c;

        /* renamed from: d  reason: collision with root package name */
        Handler f34737d;

        private t() {
        }

        /* synthetic */ t(g gVar) {
            this();
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [com.koushikdutta.async.ThreadQueue, android.os.Handler, java.lang.Runnable] */
        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                if (this.f34734a) {
                    return;
                }
                this.f34734a = true;
                try {
                    this.f34735b.run();
                } finally {
                    this.f34736c.remove(this);
                    this.f34737d.removeCallbacks(this);
                    this.f34736c = null;
                    this.f34737d = null;
                    this.f34735b = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class u {

        /* renamed from: a  reason: collision with root package name */
        public Runnable f34738a;

        /* renamed from: b  reason: collision with root package name */
        public long f34739b;

        public u(Runnable runnable, long j4) {
            this.f34738a = runnable;
            this.f34739b = j4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class v implements Comparator<u> {

        /* renamed from: a  reason: collision with root package name */
        public static v f34740a = new v();

        private v() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(u uVar, u uVar2) {
            long j4 = uVar.f34739b;
            long j5 = uVar2.f34739b;
            if (j4 == j5) {
                return 0;
            }
            if (j4 > j5) {
                return 1;
            }
            return -1;
        }
    }

    public AsyncServer() {
        this(null);
    }

    private boolean g() {
        WeakHashMap<Thread, AsyncServer> weakHashMap = f34668j;
        synchronized (weakHashMap) {
            if (weakHashMap.get(this.f34673e) != null) {
                return false;
            }
            weakHashMap.put(this.f34673e, this);
            return true;
        }
    }

    public static AsyncServer getCurrentThreadServer() {
        return f34668j.get(Thread.currentThread());
    }

    public static AsyncServer getDefault() {
        return f34664f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public q h(InetSocketAddress inetSocketAddress, ConnectCallback connectCallback) {
        q qVar = new q(this, null);
        post(new l(qVar, connectCallback, inetSocketAddress));
        return qVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AsyncNetworkSocket asyncNetworkSocket) throws ClosedChannelException {
        SelectionKey e4 = asyncNetworkSocket.c().e(this.f34669a.getSelector());
        e4.attach(asyncNetworkSocket);
        asyncNetworkSocket.i(this, e4);
    }

    private static long j(AsyncServer asyncServer, PriorityQueue<u> priorityQueue) {
        u uVar;
        long j4 = Long.MAX_VALUE;
        while (true) {
            synchronized (asyncServer) {
                long currentTimeMillis = System.currentTimeMillis();
                uVar = null;
                if (priorityQueue.size() > 0) {
                    u remove = priorityQueue.remove();
                    long j5 = remove.f34739b;
                    if (j5 <= currentTimeMillis) {
                        uVar = remove;
                    } else {
                        priorityQueue.add(remove);
                        j4 = j5 - currentTimeMillis;
                    }
                }
            }
            if (uVar == null) {
                asyncServer.f34671c = 0;
                return j4;
            }
            uVar.f34738a.run();
        }
    }

    private static ExecutorService k(String str) {
        return new ThreadPoolExecutor(1, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new r(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(AsyncServer asyncServer, SelectorWrapper selectorWrapper, PriorityQueue<u> priorityQueue) {
        while (true) {
            try {
                p(asyncServer, selectorWrapper, priorityQueue);
            } catch (p e4) {
                Log.i(LOGTAG, "Selector exception, shutting down", e4);
                try {
                    selectorWrapper.getSelector().close();
                } catch (Exception unused) {
                }
            }
            synchronized (asyncServer) {
                if (!selectorWrapper.isOpen() || (selectorWrapper.keys().size() <= 0 && priorityQueue.size() <= 0)) {
                    break;
                }
            }
        }
        q(selectorWrapper);
        if (asyncServer.f34669a == selectorWrapper) {
            asyncServer.f34672d = new PriorityQueue<>(1, v.f34740a);
            asyncServer.f34669a = null;
            asyncServer.f34673e = null;
        }
        WeakHashMap<Thread, AsyncServer> weakHashMap = f34668j;
        synchronized (weakHashMap) {
            weakHashMap.remove(Thread.currentThread());
        }
    }

    private void o(boolean z3) {
        SelectorWrapper selectorWrapper;
        PriorityQueue<u> priorityQueue;
        boolean z4;
        synchronized (this) {
            if (this.f34669a != null) {
                Log.i(LOGTAG, "Reentrant call");
                selectorWrapper = this.f34669a;
                priorityQueue = this.f34672d;
                z4 = true;
            } else {
                try {
                    SelectorWrapper selectorWrapper2 = new SelectorWrapper(SelectorProvider.provider().openSelector());
                    this.f34669a = selectorWrapper2;
                    PriorityQueue<u> priorityQueue2 = this.f34672d;
                    if (z3) {
                        this.f34673e = new e(this.f34670b, selectorWrapper2, priorityQueue2);
                    } else {
                        this.f34673e = Thread.currentThread();
                    }
                    if (!g()) {
                        try {
                            this.f34669a.close();
                        } catch (Exception unused) {
                        }
                        this.f34669a = null;
                        this.f34673e = null;
                        return;
                    } else if (z3) {
                        this.f34673e.start();
                        return;
                    } else {
                        selectorWrapper = selectorWrapper2;
                        priorityQueue = priorityQueue2;
                        z4 = false;
                    }
                } catch (IOException unused2) {
                    return;
                }
            }
            if (z4) {
                try {
                    p(this, selectorWrapper, priorityQueue);
                    return;
                } catch (p e4) {
                    Log.i(LOGTAG, "Selector closed", e4);
                    try {
                        selectorWrapper.getSelector().close();
                        return;
                    } catch (Exception unused3) {
                        return;
                    }
                }
            }
            n(this, selectorWrapper, priorityQueue);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.nio.channels.SelectionKey] */
    /* JADX WARN: Type inference failed for: r1v20, types: [com.koushikdutta.async.callback.ConnectCallback] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.koushikdutta.async.AsyncNetworkSocket, java.lang.Object, com.koushikdutta.async.AsyncSocket] */
    private static void p(AsyncServer asyncServer, SelectorWrapper selectorWrapper, PriorityQueue<u> priorityQueue) throws p {
        boolean z3;
        SelectionKey selectionKey;
        long j4 = j(asyncServer, priorityQueue);
        try {
            synchronized (asyncServer) {
                if (selectorWrapper.selectNow() == 0) {
                    if (selectorWrapper.keys().size() == 0 && j4 == Long.MAX_VALUE) {
                        return;
                    }
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    if (j4 == Long.MAX_VALUE) {
                        selectorWrapper.select();
                    } else {
                        selectorWrapper.select(j4);
                    }
                }
                Set<SelectionKey> selectedKeys = selectorWrapper.selectedKeys();
                for (SelectionKey selectionKey2 : selectedKeys) {
                    try {
                        SelectionKey selectionKey3 = 0;
                        if (selectionKey2.isAcceptable()) {
                            try {
                                SocketChannel accept = ((ServerSocketChannel) selectionKey2.channel()).accept();
                                if (accept != null) {
                                    try {
                                        accept.configureBlocking(false);
                                        selectionKey3 = accept.register(selectorWrapper.getSelector(), 1);
                                        AsyncNetworkSocket asyncNetworkSocket = new AsyncNetworkSocket();
                                        asyncNetworkSocket.b(accept, (InetSocketAddress) accept.socket().getRemoteSocketAddress());
                                        asyncNetworkSocket.i(asyncServer, selectionKey3);
                                        selectionKey3.attach(asyncNetworkSocket);
                                        ((ListenCallback) selectionKey2.attachment()).onAccepted(asyncNetworkSocket);
                                    } catch (IOException unused) {
                                        selectionKey = selectionKey3;
                                        selectionKey3 = accept;
                                        StreamUtility.closeQuietly(new Closeable[]{selectionKey3});
                                        if (selectionKey != null) {
                                            selectionKey.cancel();
                                        }
                                    }
                                }
                            } catch (IOException unused2) {
                                selectionKey = null;
                            }
                        } else if (selectionKey2.isReadable()) {
                            asyncServer.l(((AsyncNetworkSocket) selectionKey2.attachment()).e());
                        } else if (selectionKey2.isWritable()) {
                            ((AsyncNetworkSocket) selectionKey2.attachment()).onDataWritable();
                        } else if (selectionKey2.isConnectable()) {
                            q qVar = (q) selectionKey2.attachment();
                            SocketChannel socketChannel = (SocketChannel) selectionKey2.channel();
                            selectionKey2.interestOps(1);
                            try {
                                socketChannel.finishConnect();
                                ?? asyncNetworkSocket2 = new AsyncNetworkSocket();
                                asyncNetworkSocket2.i(asyncServer, selectionKey2);
                                asyncNetworkSocket2.b(socketChannel, (InetSocketAddress) socketChannel.socket().getRemoteSocketAddress());
                                selectionKey2.attach(asyncNetworkSocket2);
                                try {
                                    if (qVar.setComplete((q) asyncNetworkSocket2)) {
                                        qVar.f34728j.onConnectCompleted(null, asyncNetworkSocket2);
                                    }
                                } catch (Exception e4) {
                                    throw new RuntimeException(e4);
                                }
                            } catch (IOException e5) {
                                selectionKey2.cancel();
                                StreamUtility.closeQuietly(socketChannel);
                                if (qVar.setComplete((Exception) e5)) {
                                    qVar.f34728j.onConnectCompleted(e5, null);
                                }
                            }
                        } else {
                            Log.i(LOGTAG, "wtf");
                            throw new RuntimeException("Unknown key state.");
                        }
                    } catch (CancelledKeyException unused3) {
                    }
                }
                selectedKeys.clear();
            }
        } catch (Exception e6) {
            throw new p(e6);
        }
    }

    public static void post(Handler handler, Runnable runnable) {
        t tVar = new t(null);
        ThreadQueue a4 = ThreadQueue.a(handler.getLooper().getThread());
        tVar.f34736c = a4;
        tVar.f34737d = handler;
        tVar.f34735b = runnable;
        a4.add((Runnable) tVar);
        handler.post(tVar);
        a4.queueSemaphore.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(SelectorWrapper selectorWrapper) {
        r(selectorWrapper);
        try {
            selectorWrapper.close();
        } catch (Exception unused) {
        }
    }

    private static void r(SelectorWrapper selectorWrapper) {
        try {
            for (SelectionKey selectionKey : selectorWrapper.keys()) {
                StreamUtility.closeQuietly(selectionKey.channel());
                try {
                    selectionKey.cancel();
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
        }
    }

    private static void s(SelectorWrapper selectorWrapper) {
        f34665g.execute(new g(selectorWrapper));
    }

    public AsyncDatagramSocket connectDatagram(String str, int i4) throws IOException {
        DatagramChannel open = DatagramChannel.open();
        AsyncDatagramSocket asyncDatagramSocket = new AsyncDatagramSocket();
        asyncDatagramSocket.a(open);
        run(new b(str, i4, asyncDatagramSocket, open));
        return asyncDatagramSocket;
    }

    public Cancellable connectSocket(InetSocketAddress inetSocketAddress, ConnectCallback connectCallback) {
        if (!inetSocketAddress.isUnresolved()) {
            return h(inetSocketAddress, connectCallback);
        }
        SimpleFuture simpleFuture = new SimpleFuture();
        Future<InetAddress> byName = getByName(inetSocketAddress.getHostName());
        simpleFuture.setParent((Cancellable) byName);
        byName.setCallback(new m(connectCallback, simpleFuture, inetSocketAddress));
        return simpleFuture;
    }

    public void dump() {
        post(new f());
    }

    public Thread getAffinity() {
        return this.f34673e;
    }

    public Future<InetAddress[]> getAllByName(String str) {
        SimpleFuture simpleFuture = new SimpleFuture();
        f34667i.execute(new o(str, simpleFuture));
        return simpleFuture;
    }

    public Future<InetAddress> getByName(String str) {
        return (Future) getAllByName(str).then(new a());
    }

    public boolean isAffinityThread() {
        if (this.f34673e == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public boolean isAffinityThreadOrStopped() {
        Thread thread = this.f34673e;
        if (thread != null && thread != Thread.currentThread()) {
            return false;
        }
        return true;
    }

    public boolean isRunning() {
        if (this.f34669a != null) {
            return true;
        }
        return false;
    }

    public AsyncServerSocket listen(InetAddress inetAddress, int i4, ListenCallback listenCallback) {
        s sVar = new s(null);
        run(new k(inetAddress, i4, listenCallback, sVar));
        return (AsyncServerSocket) sVar.f34733a;
    }

    public AsyncDatagramSocket openDatagram() throws IOException {
        return openDatagram(null, false);
    }

    public Object postDelayed(Runnable runnable, long j4) {
        u uVar;
        synchronized (this) {
            long j5 = 0;
            int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
            try {
                if (i4 > 0) {
                    j5 = System.currentTimeMillis() + j4;
                } else if (i4 == 0) {
                    int i5 = this.f34671c;
                    this.f34671c = i5 + 1;
                    j5 = i5;
                } else if (this.f34672d.size() > 0) {
                    j5 = Math.min(0L, this.f34672d.peek().f34739b - 1);
                }
                PriorityQueue<u> priorityQueue = this.f34672d;
                uVar = new u(runnable, j5);
                priorityQueue.add(uVar);
                if (this.f34669a == null) {
                    o(true);
                }
                if (!isAffinityThread()) {
                    s(this.f34669a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return uVar;
    }

    public Object postImmediate(Runnable runnable) {
        if (Thread.currentThread() == getAffinity()) {
            runnable.run();
            return null;
        }
        return postDelayed(runnable, -1L);
    }

    public void removeAllCallbacks(Object obj) {
        synchronized (this) {
            this.f34672d.remove(obj);
        }
    }

    public void run(Runnable runnable) {
        if (Thread.currentThread() == this.f34673e) {
            post(runnable);
            j(this, this.f34672d);
            return;
        }
        Semaphore semaphore = new Semaphore(0);
        post(new i(runnable, semaphore));
        try {
            semaphore.acquire();
        } catch (InterruptedException e4) {
            Log.e(LOGTAG, "run", e4);
        }
    }

    public void stop() {
        synchronized (this) {
            boolean isAffinityThread = isAffinityThread();
            SelectorWrapper selectorWrapper = this.f34669a;
            if (selectorWrapper == null) {
                return;
            }
            WeakHashMap<Thread, AsyncServer> weakHashMap = f34668j;
            synchronized (weakHashMap) {
                weakHashMap.remove(this.f34673e);
            }
            Semaphore semaphore = new Semaphore(0);
            this.f34672d.add(new u(new j(selectorWrapper, semaphore), 0L));
            selectorWrapper.wakeupOnce();
            r(selectorWrapper);
            this.f34672d = new PriorityQueue<>(1, v.f34740a);
            this.f34669a = null;
            this.f34673e = null;
            if (!isAffinityThread) {
                try {
                    semaphore.acquire();
                } catch (Exception unused) {
                }
            }
        }
    }

    public AsyncServer(String str) {
        this.f34671c = 0;
        this.f34672d = new PriorityQueue<>(1, v.f34740a);
        this.f34670b = str == null ? "AsyncServer" : str;
    }

    public AsyncDatagramSocket openDatagram(SocketAddress socketAddress, boolean z3) throws IOException {
        DatagramChannel open = DatagramChannel.open();
        AsyncDatagramSocket asyncDatagramSocket = new AsyncDatagramSocket();
        asyncDatagramSocket.a(open);
        run(new c(z3, open, socketAddress, asyncDatagramSocket));
        return asyncDatagramSocket;
    }

    public AsyncDatagramSocket connectDatagram(SocketAddress socketAddress) throws IOException {
        DatagramChannel open = DatagramChannel.open();
        AsyncDatagramSocket asyncDatagramSocket = new AsyncDatagramSocket();
        asyncDatagramSocket.a(open);
        run(new d(asyncDatagramSocket, open, socketAddress));
        return asyncDatagramSocket;
    }

    public Cancellable connectSocket(String str, int i4, ConnectCallback connectCallback) {
        return connectSocket(InetSocketAddress.createUnresolved(str, i4), connectCallback);
    }

    public Object post(Runnable runnable) {
        return postDelayed(runnable, 0L);
    }

    public Object post(CompletedCallback completedCallback, Exception exc) {
        return post(new h(completedCallback, exc));
    }

    protected void l(int i4) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(int i4) {
    }
}
