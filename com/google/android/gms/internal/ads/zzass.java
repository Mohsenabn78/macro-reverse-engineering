package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzass extends zzath {
    private final zzaqw zzi;
    private final long zzj;
    private final long zzk;

    public zzass(zzart zzartVar, String str, String str2, zzanq zzanqVar, int i4, int i5, zzaqw zzaqwVar, long j4, long j5) {
        super(zzartVar, "hDi2yHM1WBnaBo8xfxWY0dwLv3vkmI37udU/dWBh2W+Ynkfo3oZQp4Q+03pBto4q", "2+LdC0cYaqAwYHmCPPvRLMkFDbEQiwTEweQcBW/SUlU=", zzanqVar, i4, 11);
        this.zzi = zzaqwVar;
        this.zzj = j4;
        this.zzk = j5;
    }

    @Override // com.google.android.gms.internal.ads.zzath
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzaqw zzaqwVar = this.zzi;
        if (zzaqwVar != null) {
            zzaqu zzaquVar = new zzaqu((String) this.zzf.invoke(null, zzaqwVar.zzb(), Long.valueOf(this.zzj), Long.valueOf(this.zzk)));
            synchronized (this.zze) {
                this.zze.zzz(zzaquVar.zza.longValue());
                if (zzaquVar.zzb.longValue() >= 0) {
                    this.zze.zzQ(zzaquVar.zzb.longValue());
                }
                if (zzaquVar.zzc.longValue() >= 0) {
                    this.zze.zzf(zzaquVar.zzc.longValue());
                }
            }
        }
    }
}
