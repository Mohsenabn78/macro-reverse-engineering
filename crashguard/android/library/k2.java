package crashguard.android.library;

import android.util.Base64;
import com.facebook.stetho.dumpapp.Framer;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes6.dex */
final class k2 {

    /* renamed from: a  reason: collision with root package name */
    static final String f38889a = "AES";

    /* renamed from: b  reason: collision with root package name */
    static final String f38890b = "AES/CBC/PKCS5Padding";

    /* renamed from: c  reason: collision with root package name */
    static final String f38891c = new String(new byte[]{82, 83, 65, 47, 69, 67, 66, 47, 80, 75, 67, 83, Framer.STDOUT_FRAME_PREFIX, 80, 97, 100, 100, 105, 110, 103});

    static {
        StandardCharsets.UTF_8.name();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        return Base64.encodeToString(str.getBytes(), 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(byte[] bArr) {
        return new String(Base64.decode(bArr, 11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(byte[] bArr, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(f38891c);
        cipher.init(1, publicKey);
        return Base64.encodeToString(cipher.doFinal(bArr), 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(byte[] bArr, SecretKey secretKey) throws Exception {
        byte[] bArr2 = new byte[16];
        new SecureRandom().nextBytes(bArr2);
        Cipher cipher = Cipher.getInstance(f38890b);
        cipher.init(1, secretKey, new IvParameterSpec(bArr2));
        byte[] doFinal = cipher.doFinal(bArr);
        ByteBuffer wrap = ByteBuffer.wrap(new byte[doFinal.length + 16]);
        wrap.put(bArr2);
        wrap.put(doFinal);
        return Base64.encodeToString(wrap.array(), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SecretKeySpec e(String str, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(f38891c);
        cipher.init(2, privateKey);
        byte[] doFinal = cipher.doFinal(Base64.decode(str, 2));
        return new SecretKeySpec(doFinal, 0, doFinal.length, f38889a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] f(String str, SecretKey secretKey) throws Exception {
        byte[] decode = Base64.decode(str, 0);
        byte[] bArr = new byte[16];
        if (decode.length > 16) {
            System.arraycopy(decode, 0, bArr, 0, 16);
        }
        int length = decode.length - 16;
        byte[] bArr2 = new byte[length];
        System.arraycopy(decode, 16, bArr2, 0, length);
        Cipher cipher = Cipher.getInstance(f38890b);
        cipher.init(2, secretKey, new IvParameterSpec(bArr));
        return cipher.doFinal(bArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            return String.format("%0" + (digest.length << 1) + "X", new BigInteger(1, digest));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h(String str, SecretKey secretKey) throws Exception {
        return d(String.valueOf(str).getBytes(), secretKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String i(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }
}
