package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcdr extends zzcdl implements zzhg {
    private String zzd;
    private final zzcbz zze;
    private boolean zzf;
    private final zzcdq zzg;
    private final zzccw zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private final Object zzk;
    private final String zzl;
    private final int zzm;
    private boolean zzn;

    public zzcdr(zzcca zzccaVar, zzcbz zzcbzVar) {
        super(zzccaVar);
        String str;
        int i4;
        this.zze = zzcbzVar;
        this.zzg = new zzcdq();
        this.zzh = new zzccw();
        this.zzk = new Object();
        if (zzccaVar != null) {
            str = zzccaVar.zzbl();
        } else {
            str = null;
        }
        this.zzl = (String) zzfpd.zzd(str).zzb("");
        if (zzccaVar != null) {
            i4 = zzccaVar.zzf();
        } else {
            i4 = 0;
        }
        this.zzm = i4;
    }

    protected static final String zzm(String str) {
        return "cache:".concat(String.valueOf(zzbzk.zze(str)));
    }

    private final void zzv() {
        boolean z3;
        int zza = (int) this.zzg.zza();
        int zza2 = (int) this.zzh.zza(this.zzi);
        int position = this.zzi.position();
        int round = Math.round(zza2 * (position / zza));
        int zzs = zzcbr.zzs();
        int zzu = zzcbr.zzu();
        String str = this.zzd;
        String zzm = zzm(str);
        long j4 = round;
        if (round > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzn(str, zzm, position, zza, j4, zza2, z3, zzs, zzu);
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zzd(zzge zzgeVar, zzgj zzgjVar, boolean z3) {
        if (zzgeVar instanceof zzgr) {
            this.zzg.zzb((zzgr) zzgeVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdl
    public final void zzf() {
        this.zzf = true;
    }

    public final String zzi() {
        return this.zzd;
    }

    public final ByteBuffer zzk() {
        synchronized (this.zzk) {
            ByteBuffer byteBuffer = this.zzi;
            if (byteBuffer != null && !this.zzj) {
                byteBuffer.flip();
                this.zzj = true;
            }
            this.zzf = true;
        }
        return this.zzi;
    }

    public final boolean zzl() {
        return this.zzn;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x00a7, code lost:
        r21.zzn = true;
        zzj(r22, r4, (int) r21.zzh.zza(r21.zzi));
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d8, code lost:
        return true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:? -> B:45:0x0142). Please submit an issue!!! */
    @Override // com.google.android.gms.internal.ads.zzcdl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzt(java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcdr.zzt(java.lang.String):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zzb(zzge zzgeVar, zzgj zzgjVar, boolean z3) {
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zzc(zzge zzgeVar, zzgj zzgjVar, boolean z3) {
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zza(zzge zzgeVar, zzgj zzgjVar, boolean z3, int i4) {
    }
}
