package crashguard.android.library;

import android.media.MediaDrm;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.facebook.stetho.dumpapp.Framer;
import java.io.Closeable;
import java.security.MessageDigest;
import java.util.UUID;

@RequiresApi(api = 18)
/* loaded from: classes6.dex */
final class v4 implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private MediaDrm f39082a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v4() throws Throwable {
        int i4 = 0;
        UUID[] uuidArr = {new UUID(-1301668207276963122L, -6645017420763422227L), new UUID(1186680826959645954L, -5988876978535335093L), new UUID(-2129748144642739255L, 8654423357094679310L), new UUID(-7348484286925749626L, -6083546864340672619L)};
        while (true) {
            if (i4 >= 4) {
                break;
            }
            UUID uuid = uuidArr[i4];
            if (MediaDrm.isCryptoSchemeSupported(uuid)) {
                this.f39082a = new MediaDrm(uuid);
                break;
            }
            i4++;
        }
        if (this.f39082a != null) {
            return;
        }
        throw new Exception();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String b() throws Throwable {
        byte[] propertyByteArray = this.f39082a.getPropertyByteArray("deviceUniqueId");
        MessageDigest messageDigest = MessageDigest.getInstance(new String(new byte[]{83, 72, 65, Framer.STDIN_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 53, 54}));
        messageDigest.update(propertyByteArray);
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        int length = digest.length;
        for (int i4 = 0; i4 < length; i4++) {
            sb.append(String.format("%02x", Byte.valueOf(digest[i4])));
        }
        return sb.toString();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (Build.VERSION.SDK_INT > 27) {
            this.f39082a.close();
        } else {
            this.f39082a.release();
        }
    }
}
