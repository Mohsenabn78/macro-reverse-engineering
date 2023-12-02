package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import javax.annotation.CheckForNull;

@Beta
@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
/* loaded from: classes5.dex */
public final class FileBackedOutputStream extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final int f28003a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f28004b;

    /* renamed from: c  reason: collision with root package name */
    private final ByteSource f28005c;
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    private OutputStream f28006d;
    @CheckForNull
    @GuardedBy("this")

    /* renamed from: e  reason: collision with root package name */
    private MemoryOutput f28007e;
    @CheckForNull
    @GuardedBy("this")

    /* renamed from: f  reason: collision with root package name */
    private File f28008f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class MemoryOutput extends ByteArrayOutputStream {
        private MemoryOutput() {
        }

        byte[] b() {
            return ((ByteArrayOutputStream) this).buf;
        }

        int getCount() {
            return ((ByteArrayOutputStream) this).count;
        }
    }

    public FileBackedOutputStream(int i4) {
        this(i4, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized InputStream c() throws IOException {
        if (this.f28008f != null) {
            return new FileInputStream(this.f28008f);
        }
        Objects.requireNonNull(this.f28007e);
        return new ByteArrayInputStream(this.f28007e.b(), 0, this.f28007e.getCount());
    }

    @GuardedBy("this")
    private void d(int i4) throws IOException {
        MemoryOutput memoryOutput = this.f28007e;
        if (memoryOutput != null && memoryOutput.getCount() + i4 > this.f28003a) {
            File b4 = TempFileCreator.f28045a.b("FileBackedOutputStream");
            if (this.f28004b) {
                b4.deleteOnExit();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(b4);
                fileOutputStream.write(this.f28007e.b(), 0, this.f28007e.getCount());
                fileOutputStream.flush();
                this.f28006d = fileOutputStream;
                this.f28008f = b4;
                this.f28007e = null;
            } catch (IOException e4) {
                b4.delete();
                throw e4;
            }
        }
    }

    public ByteSource asByteSource() {
        return this.f28005c;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f28006d.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        this.f28006d.flush();
    }

    public synchronized void reset() throws IOException {
        close();
        MemoryOutput memoryOutput = this.f28007e;
        if (memoryOutput == null) {
            this.f28007e = new MemoryOutput();
        } else {
            memoryOutput.reset();
        }
        this.f28006d = this.f28007e;
        File file = this.f28008f;
        if (file != null) {
            this.f28008f = null;
            if (!file.delete()) {
                throw new IOException("Could not delete: " + file);
            }
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i4) throws IOException {
        d(1);
        this.f28006d.write(i4);
    }

    public FileBackedOutputStream(int i4, boolean z3) {
        Preconditions.checkArgument(i4 >= 0, "fileThreshold must be non-negative, but was %s", i4);
        this.f28003a = i4;
        this.f28004b = z3;
        MemoryOutput memoryOutput = new MemoryOutput();
        this.f28007e = memoryOutput;
        this.f28006d = memoryOutput;
        if (z3) {
            this.f28005c = new ByteSource() { // from class: com.google.common.io.FileBackedOutputStream.1
                protected void finalize() {
                    try {
                        FileBackedOutputStream.this.reset();
                    } catch (Throwable th) {
                        th.printStackTrace(System.err);
                    }
                }

                @Override // com.google.common.io.ByteSource
                public InputStream openStream() throws IOException {
                    return FileBackedOutputStream.this.c();
                }
            };
        } else {
            this.f28005c = new ByteSource() { // from class: com.google.common.io.FileBackedOutputStream.2
                @Override // com.google.common.io.ByteSource
                public InputStream openStream() throws IOException {
                    return FileBackedOutputStream.this.c();
                }
            };
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i4, int i5) throws IOException {
        d(i5);
        this.f28006d.write(bArr, i4, i5);
    }
}
