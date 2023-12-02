package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzasz extends zzath {
    private final StackTraceElement[] zzi;

    public zzasz(zzart zzartVar, String str, String str2, zzanq zzanqVar, int i4, int i5, StackTraceElement[] stackTraceElementArr) {
        super(zzartVar, "qzPpYppPAZhPHZoGToPEj4gLCkf1GlGnviIXlGI2ic/egZu+qobDN2aG3wSrxpBD", "7Q6sBeEdJYI+qvX8cIFUZRRQ8J+ckQm34FYdYCYSS2Q=", zzanqVar, i4, 45);
        this.zzi = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.zzath
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        StackTraceElement[] stackTraceElementArr = this.zzi;
        if (stackTraceElementArr != null) {
            int i4 = 1;
            zzark zzarkVar = new zzark((String) this.zzf.invoke(null, stackTraceElementArr));
            synchronized (this.zze) {
                this.zze.zzF(zzarkVar.zza.longValue());
                if (zzarkVar.zzb.booleanValue()) {
                    zzanq zzanqVar = this.zze;
                    if (true != zzarkVar.zzc.booleanValue()) {
                        i4 = 2;
                    }
                    zzanqVar.zzac(i4);
                } else {
                    this.zze.zzac(3);
                }
            }
        }
    }
}
