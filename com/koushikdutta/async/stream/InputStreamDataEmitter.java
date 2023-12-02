package com.koushikdutta.async.stream;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class InputStreamDataEmitter implements DataEmitter {

    /* renamed from: a  reason: collision with root package name */
    AsyncServer f35645a;

    /* renamed from: b  reason: collision with root package name */
    InputStream f35646b;

    /* renamed from: c  reason: collision with root package name */
    DataCallback f35647c;

    /* renamed from: d  reason: collision with root package name */
    boolean f35648d;

    /* renamed from: e  reason: collision with root package name */
    int f35649e = 0;

    /* renamed from: f  reason: collision with root package name */
    ByteBufferList f35650f = new ByteBufferList();

    /* renamed from: g  reason: collision with root package name */
    Runnable f35651g = new b();

    /* renamed from: h  reason: collision with root package name */
    CompletedCallback f35652h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Exception f35653a;

        a(Exception exc) {
            this.f35653a = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Exception e4 = this.f35653a;
            try {
                InputStreamDataEmitter.this.f35646b.close();
            } catch (Exception e5) {
                e4 = e5;
            }
            CompletedCallback completedCallback = InputStreamDataEmitter.this.f35652h;
            if (completedCallback != null) {
                completedCallback.onCompleted(e4);
            }
        }
    }

    /* loaded from: classes6.dex */
    class b implements Runnable {

        /* loaded from: classes6.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                InputStreamDataEmitter inputStreamDataEmitter = InputStreamDataEmitter.this;
                Util.emitAllData(inputStreamDataEmitter, inputStreamDataEmitter.f35650f);
            }
        }

        /* renamed from: com.koushikdutta.async.stream.InputStreamDataEmitter$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class RunnableC0201b implements Runnable {
            RunnableC0201b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                InputStreamDataEmitter inputStreamDataEmitter = InputStreamDataEmitter.this;
                Util.emitAllData(inputStreamDataEmitter, inputStreamDataEmitter.f35650f);
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!InputStreamDataEmitter.this.f35650f.isEmpty()) {
                    InputStreamDataEmitter.this.getServer().run(new a());
                    if (!InputStreamDataEmitter.this.f35650f.isEmpty()) {
                        return;
                    }
                }
                do {
                    ByteBuffer obtain = ByteBufferList.obtain(Math.min(Math.max(InputStreamDataEmitter.this.f35649e, 4096), 262144));
                    int read = InputStreamDataEmitter.this.f35646b.read(obtain.array());
                    if (-1 == read) {
                        InputStreamDataEmitter.this.c(null);
                        return;
                    }
                    InputStreamDataEmitter.this.f35649e = read * 2;
                    obtain.limit(read);
                    InputStreamDataEmitter.this.f35650f.add(obtain);
                    InputStreamDataEmitter.this.getServer().run(new RunnableC0201b());
                    if (InputStreamDataEmitter.this.f35650f.remaining() != 0) {
                        return;
                    }
                } while (!InputStreamDataEmitter.this.isPaused());
            } catch (Exception e4) {
                InputStreamDataEmitter.this.c(e4);
            }
        }
    }

    public InputStreamDataEmitter(AsyncServer asyncServer, InputStream inputStream) {
        this.f35645a = asyncServer;
        this.f35646b = inputStream;
        b();
    }

    private void b() {
        new Thread(this.f35651g).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Exception exc) {
        getServer().post(new a(exc));
    }

    @Override // com.koushikdutta.async.DataEmitter
    public String charset() {
        return null;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void close() {
        c(null);
        try {
            this.f35646b.close();
        } catch (Exception unused) {
        }
    }

    @Override // com.koushikdutta.async.DataEmitter
    public DataCallback getDataCallback() {
        return this.f35647c;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public CompletedCallback getEndCallback() {
        return this.f35652h;
    }

    @Override // com.koushikdutta.async.DataEmitter, com.koushikdutta.async.DataSink
    public AsyncServer getServer() {
        return this.f35645a;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isChunked() {
        return false;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isPaused() {
        return this.f35648d;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void pause() {
        this.f35648d = true;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void resume() {
        this.f35648d = false;
        b();
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void setDataCallback(DataCallback dataCallback) {
        this.f35647c = dataCallback;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void setEndCallback(CompletedCallback completedCallback) {
        this.f35652h = completedCallback;
    }
}
