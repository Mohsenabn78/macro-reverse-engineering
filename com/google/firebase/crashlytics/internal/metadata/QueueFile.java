package com.google.firebase.crashlytics.internal.metadata;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class QueueFile implements Closeable {

    /* renamed from: g  reason: collision with root package name */
    private static final Logger f29563g = Logger.getLogger(QueueFile.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final RandomAccessFile f29564a;

    /* renamed from: b  reason: collision with root package name */
    int f29565b;

    /* renamed from: c  reason: collision with root package name */
    private int f29566c;

    /* renamed from: d  reason: collision with root package name */
    private Element f29567d;

    /* renamed from: e  reason: collision with root package name */
    private Element f29568e;

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f29569f = new byte[16];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class Element {

        /* renamed from: c  reason: collision with root package name */
        static final Element f29573c = new Element(0, 0);

        /* renamed from: a  reason: collision with root package name */
        final int f29574a;

        /* renamed from: b  reason: collision with root package name */
        final int f29575b;

        Element(int i4, int i5) {
            this.f29574a = i4;
            this.f29575b = i5;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f29574a + ", length = " + this.f29575b + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class ElementInputStream extends InputStream {

        /* renamed from: a  reason: collision with root package name */
        private int f29576a;

        /* renamed from: b  reason: collision with root package name */
        private int f29577b;

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i4, int i5) throws IOException {
            QueueFile.m(bArr, "buffer");
            if ((i4 | i5) >= 0 && i5 <= bArr.length - i4) {
                int i6 = this.f29577b;
                if (i6 > 0) {
                    if (i5 > i6) {
                        i5 = i6;
                    }
                    QueueFile.this.t(this.f29576a, bArr, i4, i5);
                    this.f29576a = QueueFile.this.x(this.f29576a + i5);
                    this.f29577b -= i5;
                    return i5;
                }
                return -1;
            }
            throw new ArrayIndexOutOfBoundsException();
        }

        private ElementInputStream(Element element) {
            this.f29576a = QueueFile.this.x(element.f29574a + 4);
            this.f29577b = element.f29575b;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f29577b == 0) {
                return -1;
            }
            QueueFile.this.f29564a.seek(this.f29576a);
            int read = QueueFile.this.f29564a.read();
            this.f29576a = QueueFile.this.x(this.f29576a + 1);
            this.f29577b--;
            return read;
        }
    }

    /* loaded from: classes5.dex */
    public interface ElementReader {
        void read(InputStream inputStream, int i4) throws IOException;
    }

    public QueueFile(File file) throws IOException {
        if (!file.exists()) {
            k(file);
        }
        this.f29564a = n(file);
        p();
    }

    private static void A(byte[] bArr, int... iArr) {
        int i4 = 0;
        for (int i5 : iArr) {
            z(bArr, i4, i5);
            i4 += 4;
        }
    }

    private void i(int i4) throws IOException {
        int i5 = i4 + 4;
        int r4 = r();
        if (r4 >= i5) {
            return;
        }
        int i6 = this.f29565b;
        do {
            r4 += i6;
            i6 <<= 1;
        } while (r4 < i5);
        v(i6);
        Element element = this.f29568e;
        int x3 = x(element.f29574a + 4 + element.f29575b);
        if (x3 < this.f29567d.f29574a) {
            FileChannel channel = this.f29564a.getChannel();
            channel.position(this.f29565b);
            long j4 = x3 - 4;
            if (channel.transferTo(16L, j4, channel) != j4) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i7 = this.f29568e.f29574a;
        int i8 = this.f29567d.f29574a;
        if (i7 < i8) {
            int i9 = (this.f29565b + i7) - 16;
            y(i6, this.f29566c, i8, i9);
            this.f29568e = new Element(i9, this.f29568e.f29575b);
        } else {
            y(i6, this.f29566c, i8, i7);
        }
        this.f29565b = i6;
    }

    private static void k(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile n4 = n(file2);
        try {
            n4.setLength(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
            n4.seek(0L);
            byte[] bArr = new byte[16];
            A(bArr, 4096, 0, 0, 0);
            n4.write(bArr);
            n4.close();
            if (file2.renameTo(file)) {
                return;
            }
            throw new IOException("Rename failed!");
        } catch (Throwable th) {
            n4.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T m(T t3, String str) {
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException(str);
    }

    private static RandomAccessFile n(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    private Element o(int i4) throws IOException {
        if (i4 == 0) {
            return Element.f29573c;
        }
        this.f29564a.seek(i4);
        return new Element(i4, this.f29564a.readInt());
    }

    private void p() throws IOException {
        this.f29564a.seek(0L);
        this.f29564a.readFully(this.f29569f);
        int q4 = q(this.f29569f, 0);
        this.f29565b = q4;
        if (q4 <= this.f29564a.length()) {
            this.f29566c = q(this.f29569f, 4);
            int q5 = q(this.f29569f, 8);
            int q6 = q(this.f29569f, 12);
            this.f29567d = o(q5);
            this.f29568e = o(q6);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f29565b + ", Actual length: " + this.f29564a.length());
    }

    private static int q(byte[] bArr, int i4) {
        return ((bArr[i4] & 255) << 24) + ((bArr[i4 + 1] & 255) << 16) + ((bArr[i4 + 2] & 255) << 8) + (bArr[i4 + 3] & 255);
    }

    private int r() {
        return this.f29565b - w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i4, byte[] bArr, int i5, int i6) throws IOException {
        int x3 = x(i4);
        int i7 = x3 + i6;
        int i8 = this.f29565b;
        if (i7 <= i8) {
            this.f29564a.seek(x3);
            this.f29564a.readFully(bArr, i5, i6);
            return;
        }
        int i9 = i8 - x3;
        this.f29564a.seek(x3);
        this.f29564a.readFully(bArr, i5, i9);
        this.f29564a.seek(16L);
        this.f29564a.readFully(bArr, i5 + i9, i6 - i9);
    }

    private void u(int i4, byte[] bArr, int i5, int i6) throws IOException {
        int x3 = x(i4);
        int i7 = x3 + i6;
        int i8 = this.f29565b;
        if (i7 <= i8) {
            this.f29564a.seek(x3);
            this.f29564a.write(bArr, i5, i6);
            return;
        }
        int i9 = i8 - x3;
        this.f29564a.seek(x3);
        this.f29564a.write(bArr, i5, i9);
        this.f29564a.seek(16L);
        this.f29564a.write(bArr, i5 + i9, i6 - i9);
    }

    private void v(int i4) throws IOException {
        this.f29564a.setLength(i4);
        this.f29564a.getChannel().force(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int x(int i4) {
        int i5 = this.f29565b;
        if (i4 >= i5) {
            return (i4 + 16) - i5;
        }
        return i4;
    }

    private void y(int i4, int i5, int i6, int i7) throws IOException {
        A(this.f29569f, i4, i5, i6, i7);
        this.f29564a.seek(0L);
        this.f29564a.write(this.f29569f);
    }

    private static void z(byte[] bArr, int i4, int i5) {
        bArr[i4] = (byte) (i5 >> 24);
        bArr[i4 + 1] = (byte) (i5 >> 16);
        bArr[i4 + 2] = (byte) (i5 >> 8);
        bArr[i4 + 3] = (byte) i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f29564a.close();
    }

    public void f(byte[] bArr) throws IOException {
        g(bArr, 0, bArr.length);
    }

    public synchronized void g(byte[] bArr, int i4, int i5) throws IOException {
        int x3;
        int i6;
        m(bArr, "buffer");
        if ((i4 | i5) >= 0 && i5 <= bArr.length - i4) {
            i(i5);
            boolean l4 = l();
            if (l4) {
                x3 = 16;
            } else {
                Element element = this.f29568e;
                x3 = x(element.f29574a + 4 + element.f29575b);
            }
            Element element2 = new Element(x3, i5);
            z(this.f29569f, 0, i5);
            u(element2.f29574a, this.f29569f, 0, 4);
            u(element2.f29574a + 4, bArr, i4, i5);
            if (l4) {
                i6 = element2.f29574a;
            } else {
                i6 = this.f29567d.f29574a;
            }
            y(this.f29565b, this.f29566c + 1, i6, element2.f29574a);
            this.f29568e = element2;
            this.f29566c++;
            if (l4) {
                this.f29567d = element2;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public synchronized void h() throws IOException {
        y(4096, 0, 0, 0);
        this.f29566c = 0;
        Element element = Element.f29573c;
        this.f29567d = element;
        this.f29568e = element;
        if (this.f29565b > 4096) {
            v(4096);
        }
        this.f29565b = 4096;
    }

    public synchronized void j(ElementReader elementReader) throws IOException {
        int i4 = this.f29567d.f29574a;
        for (int i5 = 0; i5 < this.f29566c; i5++) {
            Element o4 = o(i4);
            elementReader.read(new ElementInputStream(o4), o4.f29575b);
            i4 = x(o4.f29574a + 4 + o4.f29575b);
        }
    }

    public synchronized boolean l() {
        boolean z3;
        if (this.f29566c == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        return z3;
    }

    public synchronized void s() throws IOException {
        if (!l()) {
            if (this.f29566c == 1) {
                h();
            } else {
                Element element = this.f29567d;
                int x3 = x(element.f29574a + 4 + element.f29575b);
                t(x3, this.f29569f, 0, 4);
                int q4 = q(this.f29569f, 0);
                y(this.f29565b, this.f29566c - 1, x3, this.f29568e.f29574a);
                this.f29566c--;
                this.f29567d = new Element(x3, q4);
            }
        } else {
            throw new NoSuchElementException();
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
        sb.append("fileLength=");
        sb.append(this.f29565b);
        sb.append(", size=");
        sb.append(this.f29566c);
        sb.append(", first=");
        sb.append(this.f29567d);
        sb.append(", last=");
        sb.append(this.f29568e);
        sb.append(", element lengths=[");
        try {
            j(new ElementReader() { // from class: com.google.firebase.crashlytics.internal.metadata.QueueFile.1

                /* renamed from: a  reason: collision with root package name */
                boolean f29570a = true;

                @Override // com.google.firebase.crashlytics.internal.metadata.QueueFile.ElementReader
                public void read(InputStream inputStream, int i4) throws IOException {
                    if (this.f29570a) {
                        this.f29570a = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i4);
                }
            });
        } catch (IOException e4) {
            f29563g.log(Level.WARNING, "read error", (Throwable) e4);
        }
        sb.append("]]");
        return sb.toString();
    }

    public int w() {
        if (this.f29566c == 0) {
            return 16;
        }
        Element element = this.f29568e;
        int i4 = element.f29574a;
        int i5 = this.f29567d.f29574a;
        if (i4 >= i5) {
            return (i4 - i5) + 4 + element.f29575b + 16;
        }
        return (((i4 + 4) + element.f29575b) + this.f29565b) - i5;
    }
}
