package com.koushikdutta.async;

import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.util.StreamUtility;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* loaded from: classes6.dex */
public class FileDataEmitter extends DataEmitterBase {

    /* renamed from: d  reason: collision with root package name */
    AsyncServer f34774d;

    /* renamed from: e  reason: collision with root package name */
    File f34775e;

    /* renamed from: f  reason: collision with root package name */
    DataCallback f34776f;

    /* renamed from: g  reason: collision with root package name */
    boolean f34777g;

    /* renamed from: i  reason: collision with root package name */
    FileChannel f34779i;

    /* renamed from: h  reason: collision with root package name */
    ByteBufferList f34778h = new ByteBufferList();

    /* renamed from: j  reason: collision with root package name */
    Runnable f34780j = new a();

    /* loaded from: classes6.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                FileDataEmitter fileDataEmitter = FileDataEmitter.this;
                if (fileDataEmitter.f34779i == null) {
                    fileDataEmitter.f34779i = new FileInputStream(FileDataEmitter.this.f34775e).getChannel();
                }
                if (!FileDataEmitter.this.f34778h.isEmpty()) {
                    FileDataEmitter fileDataEmitter2 = FileDataEmitter.this;
                    Util.emitAllData(fileDataEmitter2, fileDataEmitter2.f34778h);
                    if (!FileDataEmitter.this.f34778h.isEmpty()) {
                        return;
                    }
                }
                do {
                    ByteBuffer obtain = ByteBufferList.obtain(8192);
                    if (-1 == FileDataEmitter.this.f34779i.read(obtain)) {
                        FileDataEmitter.this.a(null);
                        return;
                    }
                    obtain.flip();
                    FileDataEmitter.this.f34778h.add(obtain);
                    FileDataEmitter fileDataEmitter3 = FileDataEmitter.this;
                    Util.emitAllData(fileDataEmitter3, fileDataEmitter3.f34778h);
                    if (FileDataEmitter.this.f34778h.remaining() != 0) {
                        return;
                    }
                } while (!FileDataEmitter.this.isPaused());
            } catch (Exception e4) {
                FileDataEmitter.this.a(e4);
            }
        }
    }

    public FileDataEmitter(AsyncServer asyncServer, File file) {
        this.f34774d = asyncServer;
        this.f34775e = file;
        boolean z3 = !asyncServer.isAffinityThread();
        this.f34777g = z3;
        if (!z3) {
            b();
        }
    }

    private void b() {
        this.f34774d.post(this.f34780j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.koushikdutta.async.DataEmitterBase
    public void a(Exception exc) {
        StreamUtility.closeQuietly(this.f34779i);
        super.a(exc);
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void close() {
        try {
            this.f34779i.close();
        } catch (Exception unused) {
        }
    }

    @Override // com.koushikdutta.async.DataEmitterBase, com.koushikdutta.async.DataEmitter
    public DataCallback getDataCallback() {
        return this.f34776f;
    }

    @Override // com.koushikdutta.async.DataEmitter, com.koushikdutta.async.DataSink
    public AsyncServer getServer() {
        return this.f34774d;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isChunked() {
        return false;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public boolean isPaused() {
        return this.f34777g;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void pause() {
        this.f34777g = true;
    }

    @Override // com.koushikdutta.async.DataEmitter
    public void resume() {
        this.f34777g = false;
        b();
    }

    @Override // com.koushikdutta.async.DataEmitterBase, com.koushikdutta.async.DataEmitter
    public void setDataCallback(DataCallback dataCallback) {
        this.f34776f = dataCallback;
    }
}
