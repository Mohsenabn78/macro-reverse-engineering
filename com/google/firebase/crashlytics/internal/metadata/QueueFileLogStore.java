package com.google.firebase.crashlytics.internal.metadata;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.metadata.QueueFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;

/* loaded from: classes5.dex */
class QueueFileLogStore implements FileLogStore {

    /* renamed from: d  reason: collision with root package name */
    private static final Charset f29579d = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    private final File f29580a;

    /* renamed from: b  reason: collision with root package name */
    private final int f29581b;

    /* renamed from: c  reason: collision with root package name */
    private QueueFile f29582c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class LogBytes {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f29586a;

        /* renamed from: b  reason: collision with root package name */
        public final int f29587b;

        LogBytes(byte[] bArr, int i4) {
            this.f29586a = bArr;
            this.f29587b = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueueFileLogStore(File file, int i4) {
        this.f29580a = file;
        this.f29581b = i4;
    }

    private void f(long j4, String str) {
        int i4;
        if (this.f29582c == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            if (str.length() > this.f29581b / 4) {
                str = "..." + str.substring(str.length() - i4);
            }
            this.f29582c.f(String.format(Locale.US, "%d %s%n", Long.valueOf(j4), str.replaceAll("\r", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).replaceAll("\n", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)).getBytes(f29579d));
            while (!this.f29582c.l() && this.f29582c.w() > this.f29581b) {
                this.f29582c.s();
            }
        } catch (IOException e4) {
            Logger.getLogger().e("There was a problem writing to the Crashlytics log.", e4);
        }
    }

    private LogBytes g() {
        if (!this.f29580a.exists()) {
            return null;
        }
        h();
        QueueFile queueFile = this.f29582c;
        if (queueFile == null) {
            return null;
        }
        final int[] iArr = {0};
        final byte[] bArr = new byte[queueFile.w()];
        try {
            this.f29582c.j(new QueueFile.ElementReader() { // from class: com.google.firebase.crashlytics.internal.metadata.QueueFileLogStore.1
                @Override // com.google.firebase.crashlytics.internal.metadata.QueueFile.ElementReader
                public void read(InputStream inputStream, int i4) throws IOException {
                    try {
                        inputStream.read(bArr, iArr[0], i4);
                        int[] iArr2 = iArr;
                        iArr2[0] = iArr2[0] + i4;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (IOException e4) {
            Logger.getLogger().e("A problem occurred while reading the Crashlytics log file.", e4);
        }
        return new LogBytes(bArr, iArr[0]);
    }

    private void h() {
        if (this.f29582c == null) {
            try {
                this.f29582c = new QueueFile(this.f29580a);
            } catch (IOException e4) {
                Logger logger = Logger.getLogger();
                logger.e("Could not open log file: " + this.f29580a, e4);
            }
        }
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public byte[] a() {
        LogBytes g4 = g();
        if (g4 == null) {
            return null;
        }
        int i4 = g4.f29587b;
        byte[] bArr = new byte[i4];
        System.arraycopy(g4.f29586a, 0, bArr, 0, i4);
        return bArr;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public void b() {
        d();
        this.f29580a.delete();
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public void c(long j4, String str) {
        h();
        f(j4, str);
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public void d() {
        CommonUtils.closeOrLog(this.f29582c, "There was a problem closing the Crashlytics log file.");
        this.f29582c = null;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
    public String e() {
        byte[] a4 = a();
        if (a4 != null) {
            return new String(a4, f29579d);
        }
        return null;
    }
}
