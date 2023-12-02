package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class zzavb {
    @Nullable
    private static MessageDigest zzb;
    protected final Object zza = new Object();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final MessageDigest zza() {
        synchronized (this.zza) {
            MessageDigest messageDigest = zzb;
            if (messageDigest != null) {
                return messageDigest;
            }
            for (int i4 = 0; i4 < 2; i4++) {
                try {
                    zzb = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return zzb;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] zzb(String str);
}
