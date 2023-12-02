package com.google.android.gms.internal.ads;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzapg implements Runnable {
    private zzapg() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzapg(zzapf zzapfVar) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzaph.zzc(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5));
            countDownLatch = zzaph.zzb;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzaph.zzb;
        } catch (Throwable th) {
            zzaph.zzb.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }
}
