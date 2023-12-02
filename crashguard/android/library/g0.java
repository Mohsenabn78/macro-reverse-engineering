package crashguard.android.library;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes6.dex */
class g0 implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    protected final HttpURLConnection f38746a;

    /* loaded from: classes6.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f38747a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f38748b;

        a(byte[] bArr, int i4) {
            this.f38747a = i4;
            this.f38748b = bArr;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int a() {
            return this.f38747a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final byte[] b() {
            return this.f38748b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g0(String str) throws IOException {
        this.f38746a = (HttpURLConnection) new URL(str).openConnection();
        d();
        e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final a b() throws Exception {
        this.f38746a.setRequestMethod("GET");
        this.f38746a.setDoInput(true);
        HttpURLConnection httpURLConnection = this.f38746a;
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            int responseCode = httpURLConnection.getResponseCode();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[65536];
                while (true) {
                    int read = inputStream.read(bArr, 0, 65536);
                    if (read > 0) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        a aVar = new a(byteArray, responseCode);
                        inputStream.close();
                        return aVar;
                    }
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            InputStream errorStream = httpURLConnection.getErrorStream();
            try {
                if (errorStream != null) {
                    int responseCode2 = httpURLConnection.getResponseCode();
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    byte[] bArr2 = new byte[65536];
                    while (true) {
                        int read2 = errorStream.read(bArr2, 0, 65536);
                        if (read2 > 0) {
                            byteArrayOutputStream2.write(bArr2, 0, read2);
                        } else {
                            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                            byteArrayOutputStream2.close();
                            a aVar2 = new a(byteArray2, responseCode2);
                            errorStream.close();
                            return aVar2;
                        }
                    }
                } else {
                    throw th3;
                }
            } catch (Throwable th4) {
                if (errorStream != null) {
                    try {
                        errorStream.close();
                    } catch (Throwable th5) {
                        th4.addSuppressed(th5);
                    }
                }
                throw th4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final a c(String str, byte[] bArr) throws Exception {
        this.f38746a.setRequestMethod("POST");
        this.f38746a.setRequestProperty("Content-Type", str);
        this.f38746a.setRequestProperty("Content-Length", String.valueOf(bArr.length));
        this.f38746a.setDoOutput(true);
        this.f38746a.setDoInput(true);
        this.f38746a.setFixedLengthStreamingMode(bArr.length);
        this.f38746a.getOutputStream().write(bArr);
        HttpURLConnection httpURLConnection = this.f38746a;
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            int responseCode = httpURLConnection.getResponseCode();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr2 = new byte[65536];
                while (true) {
                    int read = inputStream.read(bArr2, 0, 65536);
                    if (read > 0) {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } else {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        a aVar = new a(byteArray, responseCode);
                        inputStream.close();
                        return aVar;
                    }
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            InputStream errorStream = httpURLConnection.getErrorStream();
            try {
                if (errorStream != null) {
                    int responseCode2 = httpURLConnection.getResponseCode();
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    byte[] bArr3 = new byte[65536];
                    while (true) {
                        int read2 = errorStream.read(bArr3, 0, 65536);
                        if (read2 > 0) {
                            byteArrayOutputStream2.write(bArr3, 0, read2);
                        } else {
                            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                            byteArrayOutputStream2.close();
                            a aVar2 = new a(byteArray2, responseCode2);
                            errorStream.close();
                            return aVar2;
                        }
                    }
                } else {
                    throw th3;
                }
            } catch (Throwable th4) {
                if (errorStream != null) {
                    try {
                        errorStream.close();
                    } catch (Throwable th5) {
                        th4.addSuppressed(th5);
                    }
                }
                throw th4;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        HttpURLConnection httpURLConnection = this.f38746a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    final void d() {
        this.f38746a.setConnectTimeout(15000);
    }

    final void e() {
        this.f38746a.setReadTimeout(30000);
    }

    protected final void finalize() throws Throwable {
        super.finalize();
        HttpURLConnection httpURLConnection = this.f38746a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
