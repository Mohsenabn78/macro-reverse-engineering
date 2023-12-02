package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzatg {
    protected static final String zza = "zzatg";
    private final zzart zzb;
    private final String zzc;
    private final String zzd;
    private final Class[] zzf;
    private volatile Method zze = null;
    private final CountDownLatch zzg = new CountDownLatch(1);

    public zzatg(zzart zzartVar, String str, String str2, Class... clsArr) {
        this.zzb = zzartVar;
        this.zzc = str;
        this.zzd = str2;
        this.zzf = clsArr;
        zzartVar.zzk().submit(new zzatf(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzb(zzatg zzatgVar) {
        CountDownLatch countDownLatch;
        Class<?> loadClass;
        try {
            zzart zzartVar = zzatgVar.zzb;
            loadClass = zzartVar.zzi().loadClass(zzatgVar.zzc(zzartVar.zzu(), zzatgVar.zzc));
        } catch (zzaqx | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException unused) {
        } catch (NullPointerException unused2) {
            countDownLatch = zzatgVar.zzg;
        } catch (Throwable th) {
            zzatgVar.zzg.countDown();
            throw th;
        }
        if (loadClass == null) {
            countDownLatch = zzatgVar.zzg;
        } else {
            zzatgVar.zze = loadClass.getMethod(zzatgVar.zzc(zzatgVar.zzb.zzu(), zzatgVar.zzd), zzatgVar.zzf);
            if (zzatgVar.zze == null) {
                countDownLatch = zzatgVar.zzg;
            }
            countDownLatch = zzatgVar.zzg;
        }
        countDownLatch.countDown();
    }

    private final String zzc(byte[] bArr, String str) throws zzaqx, UnsupportedEncodingException {
        return new String(this.zzb.zze().zzb(bArr, str), "UTF-8");
    }

    public final Method zza() {
        if (this.zze != null) {
            return this.zze;
        }
        try {
            if (!this.zzg.await(2L, TimeUnit.SECONDS)) {
                return null;
            }
            return this.zze;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
