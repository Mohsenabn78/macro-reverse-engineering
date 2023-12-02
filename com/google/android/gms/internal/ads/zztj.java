package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zztj extends zzvp {
    private final boolean zzb;
    private final zzcv zzc;
    private final zzct zzd;
    private zzth zze;
    @Nullable
    private zztg zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    public zztj(zztq zztqVar, boolean z3) {
        super(zztqVar);
        boolean z4;
        if (z3) {
            zztqVar.zzu();
            z4 = true;
        } else {
            z4 = false;
        }
        this.zzb = z4;
        this.zzc = new zzcv();
        this.zzd = new zzct();
        zztqVar.zzL();
        this.zze = zzth.zzq(zztqVar.zzI());
    }

    private final Object zzJ(Object obj) {
        Object obj2;
        Object obj3;
        obj2 = this.zze.zzf;
        if (obj2 != null && obj.equals(zzth.zzd)) {
            obj3 = this.zze.zzf;
            return obj3;
        }
        return obj;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    private final void zzK(long j4) {
        zztg zztgVar = this.zzf;
        int zza = this.zze.zza(zztgVar.zza.zza);
        if (zza == -1) {
            return;
        }
        zzth zzthVar = this.zze;
        zzct zzctVar = this.zzd;
        zzthVar.zzd(zza, zzctVar, false);
        long j5 = zzctVar.zze;
        if (j5 != -9223372036854775807L && j4 >= j5) {
            j4 = Math.max(0L, j5 - 1);
        }
        zztgVar.zzs(j4);
    }

    public final zzcw zzB() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzvp
    @Nullable
    protected final zzto zzC(zzto zztoVar) {
        Object obj;
        Object obj2;
        Object obj3 = zztoVar.zza;
        obj = this.zze.zzf;
        if (obj != null) {
            obj2 = this.zze.zzf;
            if (obj2.equals(obj3)) {
                obj3 = zzth.zzd;
            }
        }
        return zztoVar.zzc(obj3);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008c  */
    @Override // com.google.android.gms.internal.ads.zzvp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void zzD(com.google.android.gms.internal.ads.zzcw r15) {
        /*
            r14 = this;
            boolean r0 = r14.zzh
            r1 = 0
            if (r0 == 0) goto L1a
            com.google.android.gms.internal.ads.zzth r0 = r14.zze
            com.google.android.gms.internal.ads.zzth r15 = r0.zzp(r15)
            r14.zze = r15
            com.google.android.gms.internal.ads.zztg r15 = r14.zzf
            if (r15 == 0) goto L9b
            long r2 = r15.zzn()
            r14.zzK(r2)
            goto L9b
        L1a:
            boolean r0 = r15.zzo()
            if (r0 == 0) goto L36
            boolean r0 = r14.zzi
            if (r0 == 0) goto L2b
            com.google.android.gms.internal.ads.zzth r0 = r14.zze
            com.google.android.gms.internal.ads.zzth r15 = r0.zzp(r15)
            goto L33
        L2b:
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzcv.zza
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzth.zzd
            com.google.android.gms.internal.ads.zzth r15 = com.google.android.gms.internal.ads.zzth.zzr(r15, r0, r2)
        L33:
            r14.zze = r15
            goto L9b
        L36:
            com.google.android.gms.internal.ads.zzcv r0 = r14.zzc
            r2 = 0
            r3 = 0
            r15.zze(r2, r0, r3)
            com.google.android.gms.internal.ads.zzcv r0 = r14.zzc
            java.lang.Object r0 = r0.zzc
            com.google.android.gms.internal.ads.zztg r5 = r14.zzf
            if (r5 == 0) goto L62
            long r6 = r5.zzq()
            com.google.android.gms.internal.ads.zzth r8 = r14.zze
            com.google.android.gms.internal.ads.zzto r5 = r5.zza
            java.lang.Object r5 = r5.zza
            com.google.android.gms.internal.ads.zzct r9 = r14.zzd
            r8.zzn(r5, r9)
            com.google.android.gms.internal.ads.zzth r5 = r14.zze
            com.google.android.gms.internal.ads.zzcv r8 = r14.zzc
            r5.zze(r2, r8, r3)
            int r2 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r2 == 0) goto L62
            r12 = r6
            goto L63
        L62:
            r12 = r3
        L63:
            com.google.android.gms.internal.ads.zzcv r9 = r14.zzc
            com.google.android.gms.internal.ads.zzct r10 = r14.zzd
            r11 = 0
            r8 = r15
            android.util.Pair r2 = r8.zzl(r9, r10, r11, r12)
            java.lang.Object r3 = r2.first
            java.lang.Object r2 = r2.second
            java.lang.Long r2 = (java.lang.Long) r2
            long r4 = r2.longValue()
            boolean r2 = r14.zzi
            if (r2 == 0) goto L82
            com.google.android.gms.internal.ads.zzth r0 = r14.zze
            com.google.android.gms.internal.ads.zzth r15 = r0.zzp(r15)
            goto L86
        L82:
            com.google.android.gms.internal.ads.zzth r15 = com.google.android.gms.internal.ads.zzth.zzr(r15, r0, r3)
        L86:
            r14.zze = r15
            com.google.android.gms.internal.ads.zztg r15 = r14.zzf
            if (r15 == 0) goto L9b
            r14.zzK(r4)
            com.google.android.gms.internal.ads.zzto r15 = r15.zza
            java.lang.Object r0 = r15.zza
            java.lang.Object r0 = r14.zzJ(r0)
            com.google.android.gms.internal.ads.zzto r1 = r15.zzc(r0)
        L9b:
            r15 = 1
            r14.zzi = r15
            r14.zzh = r15
            com.google.android.gms.internal.ads.zzth r15 = r14.zze
            r14.zzo(r15)
            if (r1 == 0) goto Laf
            com.google.android.gms.internal.ads.zztg r15 = r14.zzf
            r15.getClass()
            r15.zzr(r1)
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztj.zzD(com.google.android.gms.internal.ads.zzcw):void");
    }

    @Override // com.google.android.gms.internal.ads.zzvp
    public final void zzE() {
        if (!this.zzb) {
            this.zzg = true;
            zzA(null, ((zzvp) this).zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvp, com.google.android.gms.internal.ads.zztq
    public final void zzF(zztm zztmVar) {
        ((zztg) zztmVar).zzt();
        if (zztmVar == this.zzf) {
            this.zzf = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvp, com.google.android.gms.internal.ads.zztq
    /* renamed from: zzG */
    public final zztg zzH(zzto zztoVar, zzxp zzxpVar, long j4) {
        zztg zztgVar = new zztg(zztoVar, zzxpVar, j4);
        zztgVar.zzu(((zzvp) this).zza);
        if (this.zzh) {
            zztgVar.zzr(zztoVar.zzc(zzJ(zztoVar.zza)));
        } else {
            this.zzf = zztgVar;
            if (!this.zzg) {
                this.zzg = true;
                zzA(null, ((zzvp) this).zza);
            }
        }
        return zztgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzsx, com.google.android.gms.internal.ads.zzsp
    public final void zzq() {
        this.zzh = false;
        this.zzg = false;
        super.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzsx, com.google.android.gms.internal.ads.zztq
    public final void zzy() {
    }
}
