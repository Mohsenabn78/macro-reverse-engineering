package com.koushikdutta.async;

import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.util.Allocator;
import com.koushikdutta.async.util.StreamUtility;
import com.koushikdutta.async.wrapper.AsyncSocketWrapper;
import com.koushikdutta.async.wrapper.DataEmitterWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class Util {
    public static boolean SUPRESS_DEBUG_EXCEPTIONS = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a implements CompletedCallback {

        /* renamed from: a  reason: collision with root package name */
        boolean f34826a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CompletedCallback f34827b;

        a(CompletedCallback completedCallback) {
            this.f34827b = completedCallback;
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            if (this.f34826a) {
                return;
            }
            this.f34826a = true;
            this.f34827b.onCompleted(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class b implements WritableCallback {

        /* renamed from: a  reason: collision with root package name */
        int f34828a = 0;

        /* renamed from: b  reason: collision with root package name */
        ByteBufferList f34829b = new ByteBufferList();

        /* renamed from: c  reason: collision with root package name */
        Allocator f34830c = new Allocator();

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ DataSink f34831d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ InputStream f34832e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ long f34833f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ CompletedCallback f34834g;

        b(DataSink dataSink, InputStream inputStream, long j4, CompletedCallback completedCallback) {
            this.f34831d = dataSink;
            this.f34832e = inputStream;
            this.f34833f = j4;
            this.f34834g = completedCallback;
        }

        private void a() {
            this.f34831d.setClosedCallback(null);
            this.f34831d.setWriteableCallback(null);
            this.f34829b.recycle();
            StreamUtility.closeQuietly(this.f34832e);
        }

        @Override // com.koushikdutta.async.callback.WritableCallback
        public void onWriteable() {
            do {
                try {
                    if (!this.f34829b.hasRemaining()) {
                        ByteBuffer allocate = this.f34830c.allocate();
                        int read = this.f34832e.read(allocate.array(), 0, (int) Math.min(this.f34833f - this.f34828a, allocate.capacity()));
                        if (read != -1 && this.f34828a != this.f34833f) {
                            this.f34830c.track(read);
                            this.f34828a += read;
                            allocate.position(0);
                            allocate.limit(read);
                            this.f34829b.add(allocate);
                        }
                        a();
                        this.f34834g.onCompleted(null);
                        return;
                    }
                    this.f34831d.write(this.f34829b);
                } catch (Exception e4) {
                    a();
                    this.f34834g.onCompleted(e4);
                    return;
                }
            } while (!this.f34829b.hasRemaining());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class c implements DataCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DataSink f34835a;

        c(DataSink dataSink) {
            this.f34835a = dataSink;
        }

        @Override // com.koushikdutta.async.callback.DataCallback
        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            this.f34835a.write(byteBufferList);
            if (byteBufferList.remaining() > 0) {
                dataEmitter.pause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class d implements WritableCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DataEmitter f34836a;

        d(DataEmitter dataEmitter) {
            this.f34836a = dataEmitter;
        }

        @Override // com.koushikdutta.async.callback.WritableCallback
        public void onWriteable() {
            this.f34836a.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class e implements CompletedCallback {

        /* renamed from: a  reason: collision with root package name */
        boolean f34837a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DataEmitter f34838b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ DataSink f34839c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CompletedCallback f34840d;

        e(DataEmitter dataEmitter, DataSink dataSink, CompletedCallback completedCallback) {
            this.f34838b = dataEmitter;
            this.f34839c = dataSink;
            this.f34840d = completedCallback;
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            if (this.f34837a) {
                return;
            }
            this.f34837a = true;
            this.f34838b.setDataCallback(null);
            this.f34838b.setEndCallback(null);
            this.f34839c.setClosedCallback(null);
            this.f34839c.setWriteableCallback(null);
            this.f34840d.onCompleted(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class f implements CompletedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CompletedCallback f34841a;

        f(CompletedCallback completedCallback) {
            this.f34841a = completedCallback;
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            if (exc == null) {
                exc = new IOException("sink was closed before emitter ended");
            }
            this.f34841a.onCompleted(exc);
        }
    }

    /* loaded from: classes6.dex */
    static class g implements CompletedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ InputStream f34842a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CompletedCallback f34843b;

        g(InputStream inputStream, CompletedCallback completedCallback) {
            this.f34842a = inputStream;
            this.f34843b = completedCallback;
        }

        @Override // com.koushikdutta.async.callback.CompletedCallback
        public void onCompleted(Exception exc) {
            try {
                this.f34842a.close();
                this.f34843b.onCompleted(exc);
            } catch (IOException e4) {
                this.f34843b.onCompleted(e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class h implements WritableCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DataSink f34844a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ByteBufferList f34845b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CompletedCallback f34846c;

        h(DataSink dataSink, ByteBufferList byteBufferList, CompletedCallback completedCallback) {
            this.f34844a = dataSink;
            this.f34845b = byteBufferList;
            this.f34846c = completedCallback;
        }

        @Override // com.koushikdutta.async.callback.WritableCallback
        public void onWriteable() {
            this.f34844a.write(this.f34845b);
            if (this.f34845b.remaining() == 0 && this.f34846c != null) {
                this.f34844a.setWriteableCallback(null);
                this.f34846c.onCompleted(null);
            }
        }
    }

    public static void emitAllData(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        int remaining;
        DataCallback dataCallback = null;
        while (!dataEmitter.isPaused() && (dataCallback = dataEmitter.getDataCallback()) != null && (remaining = byteBufferList.remaining()) > 0) {
            dataCallback.onDataAvailable(dataEmitter, byteBufferList);
            if (remaining == byteBufferList.remaining() && dataCallback == dataEmitter.getDataCallback() && !dataEmitter.isPaused()) {
                PrintStream printStream = System.out;
                printStream.println("handler: " + dataCallback);
                byteBufferList.recycle();
                if (SUPRESS_DEBUG_EXCEPTIONS) {
                    return;
                }
                throw new RuntimeException("mDataHandler failed to consume data, yet remains the mDataHandler.");
            }
        }
        if (byteBufferList.remaining() != 0 && !dataEmitter.isPaused()) {
            PrintStream printStream2 = System.out;
            printStream2.println("handler: " + dataCallback);
            PrintStream printStream3 = System.out;
            printStream3.println("emitter: " + dataEmitter);
            byteBufferList.recycle();
            if (SUPRESS_DEBUG_EXCEPTIONS) {
                return;
            }
            throw new RuntimeException("Not all data was consumed by Util.emitAllData");
        }
    }

    public static void end(DataEmitter dataEmitter, Exception exc) {
        if (dataEmitter == null) {
            return;
        }
        end(dataEmitter.getEndCallback(), exc);
    }

    public static DataEmitter getWrappedDataEmitter(DataEmitter dataEmitter, Class cls) {
        if (cls.isInstance(dataEmitter)) {
            return dataEmitter;
        }
        while (dataEmitter instanceof DataEmitterWrapper) {
            dataEmitter = ((AsyncSocketWrapper) dataEmitter).getSocket();
            if (cls.isInstance(dataEmitter)) {
                return dataEmitter;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends AsyncSocket> T getWrappedSocket(AsyncSocket asyncSocket, Class<T> cls) {
        boolean isInstance = cls.isInstance(asyncSocket);
        AsyncSocketWrapper asyncSocketWrapper = asyncSocket;
        if (isInstance) {
            return asyncSocket;
        }
        while (asyncSocketWrapper instanceof AsyncSocketWrapper) {
            T t3 = (T) asyncSocketWrapper.getSocket();
            boolean isInstance2 = cls.isInstance(t3);
            asyncSocketWrapper = t3;
            if (isInstance2) {
                return t3;
            }
        }
        return null;
    }

    public static void pump(InputStream inputStream, DataSink dataSink, CompletedCallback completedCallback) {
        pump(inputStream, 2147483647L, dataSink, completedCallback);
    }

    public static void stream(AsyncSocket asyncSocket, AsyncSocket asyncSocket2, CompletedCallback completedCallback) {
        pump(asyncSocket, asyncSocket2, completedCallback);
        pump(asyncSocket2, asyncSocket, completedCallback);
    }

    public static void writable(DataSink dataSink) {
        if (dataSink == null) {
            return;
        }
        writable(dataSink.getWriteableCallback());
    }

    public static void writeAll(DataSink dataSink, ByteBufferList byteBufferList, CompletedCallback completedCallback) {
        h hVar = new h(dataSink, byteBufferList, completedCallback);
        dataSink.setWriteableCallback(hVar);
        hVar.onWriteable();
    }

    public static void end(CompletedCallback completedCallback, Exception exc) {
        if (completedCallback != null) {
            completedCallback.onCompleted(exc);
        }
    }

    public static void pump(InputStream inputStream, long j4, DataSink dataSink, CompletedCallback completedCallback) {
        a aVar = new a(completedCallback);
        b bVar = new b(dataSink, inputStream, j4, aVar);
        dataSink.setWriteableCallback(bVar);
        dataSink.setClosedCallback(aVar);
        bVar.onWriteable();
    }

    public static void writable(WritableCallback writableCallback) {
        if (writableCallback != null) {
            writableCallback.onWriteable();
        }
    }

    public static void writeAll(DataSink dataSink, byte[] bArr, CompletedCallback completedCallback) {
        ByteBuffer obtain = ByteBufferList.obtain(bArr.length);
        obtain.put(bArr);
        obtain.flip();
        ByteBufferList byteBufferList = new ByteBufferList();
        byteBufferList.add(obtain);
        writeAll(dataSink, byteBufferList, completedCallback);
    }

    public static void pump(DataEmitter dataEmitter, DataSink dataSink, CompletedCallback completedCallback) {
        dataEmitter.setDataCallback(new c(dataSink));
        dataSink.setWriteableCallback(new d(dataEmitter));
        e eVar = new e(dataEmitter, dataSink, completedCallback);
        dataEmitter.setEndCallback(eVar);
        dataSink.setClosedCallback(new f(eVar));
    }

    public static void pump(File file, DataSink dataSink, CompletedCallback completedCallback) {
        try {
            if (file != null && dataSink != null) {
                FileInputStream fileInputStream = new FileInputStream(file);
                pump(fileInputStream, dataSink, new g(fileInputStream, completedCallback));
                return;
            }
            completedCallback.onCompleted(null);
        } catch (Exception e4) {
            completedCallback.onCompleted(e4);
        }
    }
}
