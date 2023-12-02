package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
final class zzic implements zzil {
    private final zzhy zza;
    private final zzjf zzb;
    private final boolean zzc;
    private final zzga zzd;

    private zzic(zzjf zzjfVar, zzga zzgaVar, zzhy zzhyVar) {
        this.zzb = zzjfVar;
        this.zzc = zzgaVar.zzj(zzhyVar);
        this.zzd = zzgaVar;
        this.zza = zzhyVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzic zzc(zzjf zzjfVar, zzga zzgaVar, zzhy zzhyVar) {
        return new zzic(zzjfVar, zzgaVar, zzhyVar);
    }

    @Override // com.google.android.recaptcha.internal.zzil
    public final int zza(Object obj) {
        zzjf zzjfVar = this.zzb;
        int zzb = zzjfVar.zzb(zzjfVar.zzd(obj));
        if (this.zzc) {
            return zzb + this.zzd.zzb(obj).zzb();
        }
        return zzb;
    }

    @Override // com.google.android.recaptcha.internal.zzil
    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        if (this.zzc) {
            return (hashCode * 53) + this.zzd.zzb(obj).zza.hashCode();
        }
        return hashCode;
    }

    @Override // com.google.android.recaptcha.internal.zzil
    public final Object zze() {
        zzhy zzhyVar = this.zza;
        if (zzhyVar instanceof zzgo) {
            return ((zzgo) zzhyVar).zzs();
        }
        return zzhyVar.zzV().zzk();
    }

    @Override // com.google.android.recaptcha.internal.zzil
    public final void zzf(Object obj) {
        this.zzb.zzm(obj);
        this.zzd.zzf(obj);
    }

    @Override // com.google.android.recaptcha.internal.zzil
    public final void zzg(Object obj, Object obj2) {
        zzin.zzE(this.zzb, obj, obj2);
        if (this.zzc) {
            zzin.zzD(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzil
    public final void zzh(Object obj, zzik zzikVar, zzfz zzfzVar) throws IOException {
        boolean zzO;
        zzjf zzjfVar = this.zzb;
        zzga zzgaVar = this.zzd;
        Object zzc = zzjfVar.zzc(obj);
        zzge zzc2 = zzgaVar.zzc(obj);
        while (zzikVar.zzc() != Integer.MAX_VALUE) {
            try {
                int zzd = zzikVar.zzd();
                if (zzd != 11) {
                    if ((zzd & 7) == 2) {
                        Object zzd2 = zzgaVar.zzd(zzfzVar, this.zza, zzd >>> 3);
                        if (zzd2 != null) {
                            zzgaVar.zzg(zzikVar, zzd2, zzfzVar, zzc2);
                        } else {
                            zzO = zzjfVar.zzr(zzc, zzikVar);
                        }
                    } else {
                        zzO = zzikVar.zzO();
                    }
                    if (!zzO) {
                        return;
                    }
                } else {
                    Object obj2 = null;
                    zzez zzezVar = null;
                    int i4 = 0;
                    while (zzikVar.zzc() != Integer.MAX_VALUE) {
                        int zzd3 = zzikVar.zzd();
                        if (zzd3 == 16) {
                            i4 = zzikVar.zzj();
                            obj2 = zzgaVar.zzd(zzfzVar, this.zza, i4);
                        } else if (zzd3 == 26) {
                            if (obj2 != null) {
                                zzgaVar.zzg(zzikVar, obj2, zzfzVar, zzc2);
                            } else {
                                zzezVar = zzikVar.zzp();
                            }
                        } else if (!zzikVar.zzO()) {
                            break;
                        }
                    }
                    if (zzikVar.zzd() == 12) {
                        if (zzezVar != null) {
                            if (obj2 != null) {
                                zzgaVar.zzh(zzezVar, obj2, zzfzVar, zzc2);
                            } else {
                                zzjfVar.zzk(zzc, i4, zzezVar);
                            }
                        }
                    } else {
                        throw zzgy.zzb();
                    }
                }
            } finally {
                zzjfVar.zzn(obj, zzc);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0088 A[EDGE_INSN: B:56:0x0088->B:34:0x0088 ?: BREAK  , SYNTHETIC] */
    @Override // com.google.android.recaptcha.internal.zzil
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzi(java.lang.Object r10, byte[] r11, int r12, int r13, com.google.android.recaptcha.internal.zzem r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.recaptcha.internal.zzgo r0 = (com.google.android.recaptcha.internal.zzgo) r0
            com.google.android.recaptcha.internal.zzjg r1 = r0.zzc
            com.google.android.recaptcha.internal.zzjg r2 = com.google.android.recaptcha.internal.zzjg.zzc()
            if (r1 != r2) goto L11
            com.google.android.recaptcha.internal.zzjg r1 = com.google.android.recaptcha.internal.zzjg.zzf()
            r0.zzc = r1
        L11:
            com.google.android.recaptcha.internal.zzgk r10 = (com.google.android.recaptcha.internal.zzgk) r10
            r10.zzi()
            r10 = 0
            r0 = r10
        L18:
            if (r12 >= r13) goto L92
            int r4 = com.google.android.recaptcha.internal.zzen.zzj(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L48
            r12 = r2 & 7
            if (r12 != r3) goto L43
            com.google.android.recaptcha.internal.zzga r12 = r9.zzd
            com.google.android.recaptcha.internal.zzfz r0 = r14.zzd
            com.google.android.recaptcha.internal.zzhy r3 = r9.zza
            int r5 = r2 >>> 3
            java.lang.Object r0 = r12.zzd(r0, r3, r5)
            if (r0 != 0) goto L40
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.recaptcha.internal.zzen.zzi(r2, r3, r4, r5, r6, r7)
            goto L18
        L40:
            int r11 = com.google.android.recaptcha.internal.zzih.zza
            throw r10
        L43:
            int r12 = com.google.android.recaptcha.internal.zzen.zzp(r2, r11, r4, r13, r14)
            goto L18
        L48:
            r12 = 0
            r2 = r10
        L4a:
            if (r4 >= r13) goto L88
            int r4 = com.google.android.recaptcha.internal.zzen.zzj(r11, r4, r14)
            int r5 = r14.zza
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L6c
            r8 = 3
            if (r6 == r8) goto L5c
            goto L7f
        L5c:
            if (r0 != 0) goto L69
            if (r7 != r3) goto L7f
            int r4 = com.google.android.recaptcha.internal.zzen.zza(r11, r4, r14)
            java.lang.Object r2 = r14.zzc
            com.google.android.recaptcha.internal.zzez r2 = (com.google.android.recaptcha.internal.zzez) r2
            goto L4a
        L69:
            int r11 = com.google.android.recaptcha.internal.zzih.zza
            throw r10
        L6c:
            if (r7 != 0) goto L7f
            int r4 = com.google.android.recaptcha.internal.zzen.zzj(r11, r4, r14)
            int r12 = r14.zza
            com.google.android.recaptcha.internal.zzga r0 = r9.zzd
            com.google.android.recaptcha.internal.zzfz r5 = r14.zzd
            com.google.android.recaptcha.internal.zzhy r6 = r9.zza
            java.lang.Object r0 = r0.zzd(r5, r6, r12)
            goto L4a
        L7f:
            r6 = 12
            if (r5 == r6) goto L88
            int r4 = com.google.android.recaptcha.internal.zzen.zzp(r5, r11, r4, r13, r14)
            goto L4a
        L88:
            if (r2 == 0) goto L90
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zzj(r12, r2)
        L90:
            r12 = r4
            goto L18
        L92:
            if (r12 != r13) goto L95
            return
        L95:
            com.google.android.recaptcha.internal.zzgy r10 = com.google.android.recaptcha.internal.zzgy.zzg()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzic.zzi(java.lang.Object, byte[], int, int, com.google.android.recaptcha.internal.zzem):void");
    }

    @Override // com.google.android.recaptcha.internal.zzil
    public final void zzj(Object obj, zzjx zzjxVar) throws IOException {
        Iterator zzf = this.zzd.zzb(obj).zzf();
        while (zzf.hasNext()) {
            Map.Entry entry = (Map.Entry) zzf.next();
            zzgd zzgdVar = (zzgd) entry.getKey();
            if (zzgdVar.zze() == zzjw.MESSAGE) {
                zzgdVar.zzg();
                zzgdVar.zzf();
                if (entry instanceof zzhb) {
                    zzjxVar.zzw(zzgdVar.zza(), ((zzhb) entry).zza().zzb());
                } else {
                    zzjxVar.zzw(zzgdVar.zza(), entry.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        zzjf zzjfVar = this.zzb;
        zzjfVar.zzp(zzjfVar.zzd(obj), zzjxVar);
    }

    @Override // com.google.android.recaptcha.internal.zzil
    public final boolean zzk(Object obj, Object obj2) {
        if (!this.zzb.zzd(obj).equals(this.zzb.zzd(obj2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zzb(obj).equals(this.zzd.zzb(obj2));
        }
        return true;
    }

    @Override // com.google.android.recaptcha.internal.zzil
    public final boolean zzl(Object obj) {
        return this.zzd.zzb(obj).zzk();
    }
}
