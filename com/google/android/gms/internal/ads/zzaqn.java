package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;
import androidx.annotation.VisibleForTesting;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaqn {
    @VisibleForTesting
    protected volatile Boolean zzb;
    private final zzart zze;
    private static final ConditionVariable zzc = new ConditionVariable();
    @VisibleForTesting
    protected static volatile zzfld zza = null;
    private static volatile Random zzd = null;

    public zzaqn(zzart zzartVar) {
        this.zze = zzartVar;
        zzartVar.zzk().execute(new zzaqm(this));
    }

    public static final int zzd() {
        try {
            return ThreadLocalRandom.current().nextInt();
        } catch (RuntimeException unused) {
            return zze().nextInt();
        }
    }

    private static Random zze() {
        if (zzd == null) {
            synchronized (zzaqn.class) {
                if (zzd == null) {
                    zzd = new Random();
                }
            }
        }
        return zzd;
    }

    public final void zzc(int i4, int i5, long j4, String str, Exception exc) {
        try {
            zzc.block();
            if (this.zzb.booleanValue() && zza != null) {
                zzanc zza2 = zzang.zza();
                zza2.zza(this.zze.zza.getPackageName());
                zza2.zze(j4);
                if (str != null) {
                    zza2.zzb(str);
                }
                if (exc != null) {
                    StringWriter stringWriter = new StringWriter();
                    exc.printStackTrace(new PrintWriter(stringWriter));
                    zza2.zzf(stringWriter.toString());
                    zza2.zzd(exc.getClass().getName());
                }
                zzflc zza3 = zza.zza(((zzang) zza2.zzal()).zzax());
                zza3.zza(i4);
                if (i5 != -1) {
                    zza3.zzb(i5);
                }
                zza3.zzc();
            }
        } catch (Exception unused) {
        }
    }
}
