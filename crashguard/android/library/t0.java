package crashguard.android.library;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import androidx.annotation.RequiresApi;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;
import kotlin.io.encoding.Base64;

@RequiresApi(api = 18)
/* loaded from: classes6.dex */
final class t0 extends i1 {

    /* renamed from: f  reason: collision with root package name */
    private final WeakReference<Context> f39037f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t0(Context context) throws Exception {
        super("AndroidKeyStore", "RSA");
        this.f39037f = new WeakReference<>(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // crashguard.android.library.i1
    public final KeyPair a() throws Exception {
        AlgorithmParameterSpec build;
        KeyGenParameterSpec.Builder certificateSubject;
        KeyGenParameterSpec.Builder blockModes;
        KeyGenParameterSpec.Builder encryptionPaddings;
        KeyGenParameterSpec.Builder keyValidityStart;
        KeyGenParameterSpec.Builder keyValidityEnd;
        KeyGenParameterSpec.Builder keySize;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(this.f38827c, this.f38828d);
        Calendar calendar = Calendar.getInstance();
        calendar.add(1, 100);
        if (Build.VERSION.SDK_INT > 22) {
            certificateSubject = new KeyGenParameterSpec.Builder(this.f38825a, 3).setCertificateSubject(new X500Principal(new String(new byte[]{67, 78, Base64.padSymbol, 108, 111, 99, 97, 108, 104, 111, 115, 116, 44, 32, 79, Base64.padSymbol, 67, 114, 97, 115, 104, 71, 117, 97, 114, 100, 44, 32, 67, Base64.padSymbol, 80, 97, 110, 97, 109, 97})));
            blockModes = certificateSubject.setBlockModes(KeyPropertiesCompact.BLOCK_MODE_ECB);
            encryptionPaddings = blockModes.setEncryptionPaddings(KeyPropertiesCompact.ENCRYPTION_PADDING_RSA_PKCS1);
            keyValidityStart = encryptionPaddings.setKeyValidityStart(Calendar.getInstance().getTime());
            keyValidityEnd = keyValidityStart.setKeyValidityEnd(calendar.getTime());
            keySize = keyValidityEnd.setKeySize(this.f38826b);
            build = keySize.build();
        } else {
            KeyPairGeneratorSpec.Builder builder = new KeyPairGeneratorSpec.Builder(this.f39037f.get());
            builder.setKeySize(this.f38826b);
            build = builder.setAlias(this.f38825a).setSubject(new X500Principal(new String(new byte[]{67, 78, Base64.padSymbol, 108, 111, 99, 97, 108, 104, 111, 115, 116, 44, 32, 79, Base64.padSymbol, 67, 114, 97, 115, 104, 71, 117, 97, 114, 100, 44, 32, 67, Base64.padSymbol, 80, 97, 110, 97, 109, 97}))).setStartDate(Calendar.getInstance().getTime()).setEndDate(calendar.getTime()).setSerialNumber(BigInteger.ONE).build();
        }
        keyPairGenerator.initialize(build, new SecureRandom());
        return keyPairGenerator.generateKeyPair();
    }

    @Override // crashguard.android.library.i1
    final KeyStore b() throws Exception {
        KeyStore keyStore = KeyStore.getInstance(this.f38828d);
        keyStore.load(null);
        return keyStore;
    }
}
