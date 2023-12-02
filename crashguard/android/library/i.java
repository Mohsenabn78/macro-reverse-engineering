package crashguard.android.library;

import com.facebook.stetho.dumpapp.Framer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes6.dex */
abstract class i {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a extends GZIPOutputStream {
        a(ByteArrayOutputStream byteArrayOutputStream, int i4) throws IOException {
            super(byteArrayOutputStream);
            ((GZIPOutputStream) this).def.setLevel(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getBaseUrl() {
        return "https://catch.crashguard.me";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getSignatureHeader() {
        return new String(new byte[]{88, Framer.STDIN_FRAME_PREFIX, 67, 82, 65, 83, 72, 71, 85, 65, 82, 68, Framer.STDIN_FRAME_PREFIX, 83, 73, 71, 78, 65, 84, 85, 82, 69});
    }

    byte[] gzip(String str) throws IOException {
        return gzip(str.getBytes());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] gzip(String str, int i4) throws IOException {
        return gzip(str.getBytes(), i4);
    }

    byte[] gzip(byte[] bArr) throws IOException {
        return gzip(bArr, -1);
    }

    byte[] gzip(byte[] bArr, int i4) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a aVar = new a(byteArrayOutputStream, i4);
            aVar.write(bArr);
            aVar.flush();
            aVar.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
