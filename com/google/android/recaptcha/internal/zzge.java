package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
final class zzge {
    private static final zzge zzb = new zzge(true);
    final zziy zza = new zzio(16);
    private boolean zzc;
    private boolean zzd;

    private zzge() {
    }

    public static int zza(zzgd zzgdVar, Object obj) {
        int zzd;
        int zzy;
        zzjv zzd2 = zzgdVar.zzd();
        int zza = zzgdVar.zza();
        zzgdVar.zzg();
        int zzy2 = zzfk.zzy(zza << 3);
        if (zzd2 == zzjv.zzj) {
            zzhy zzhyVar = (zzhy) obj;
            byte[] bArr = zzgw.zzd;
            if (!(zzhyVar instanceof zzej)) {
                zzy2 += zzy2;
            } else {
                zzej zzejVar = (zzej) zzhyVar;
                throw null;
            }
        }
        zzjw zzjwVar = zzjw.INT;
        int i4 = 4;
        switch (zzd2.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                i4 = 8;
                break;
            case 1:
                ((Float) obj).floatValue();
                break;
            case 2:
                i4 = zzfk.zzz(((Long) obj).longValue());
                break;
            case 3:
                i4 = zzfk.zzz(((Long) obj).longValue());
                break;
            case 4:
                i4 = zzfk.zzu(((Integer) obj).intValue());
                break;
            case 5:
                ((Long) obj).longValue();
                i4 = 8;
                break;
            case 6:
                ((Integer) obj).intValue();
                break;
            case 7:
                ((Boolean) obj).booleanValue();
                i4 = 1;
                break;
            case 8:
                if (obj instanceof zzez) {
                    zzd = ((zzez) obj).zzd();
                    zzy = zzfk.zzy(zzd);
                    i4 = zzy + zzd;
                    break;
                } else {
                    i4 = zzfk.zzx((String) obj);
                    break;
                }
            case 9:
                i4 = ((zzhy) obj).zzn();
                break;
            case 10:
                if (obj instanceof zzhd) {
                    zzd = ((zzhd) obj).zza();
                    zzy = zzfk.zzy(zzd);
                    i4 = zzy + zzd;
                    break;
                } else {
                    i4 = zzfk.zzv((zzhy) obj);
                    break;
                }
            case 11:
                if (obj instanceof zzez) {
                    zzd = ((zzez) obj).zzd();
                    zzy = zzfk.zzy(zzd);
                } else {
                    zzd = ((byte[]) obj).length;
                    zzy = zzfk.zzy(zzd);
                }
                i4 = zzy + zzd;
                break;
            case 12:
                i4 = zzfk.zzy(((Integer) obj).intValue());
                break;
            case 13:
                if (obj instanceof zzgq) {
                    i4 = zzfk.zzu(((zzgq) obj).zza());
                    break;
                } else {
                    i4 = zzfk.zzu(((Integer) obj).intValue());
                    break;
                }
            case 14:
                ((Integer) obj).intValue();
                break;
            case 15:
                ((Long) obj).longValue();
                i4 = 8;
                break;
            case 16:
                int intValue = ((Integer) obj).intValue();
                i4 = zzfk.zzy((intValue >> 31) ^ (intValue + intValue));
                break;
            case 17:
                long longValue = ((Long) obj).longValue();
                i4 = zzfk.zzz((longValue >> 63) ^ (longValue + longValue));
                break;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return zzy2 + i4;
    }

    public static zzge zzd() {
        return zzb;
    }

    private static Object zzl(Object obj) {
        if (obj instanceof zzid) {
            return ((zzid) obj).zzd();
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            return bArr2;
        }
        return obj;
    }

    private final void zzm(Map.Entry entry) {
        zzhy zzj;
        zzgd zzgdVar = (zzgd) entry.getKey();
        Object value = entry.getValue();
        if (!(value instanceof zzhd)) {
            zzgdVar.zzg();
            if (zzgdVar.zze() == zzjw.MESSAGE) {
                Object zze = zze(zzgdVar);
                if (zze == null) {
                    this.zza.put(zzgdVar, zzl(value));
                    return;
                }
                if (zze instanceof zzid) {
                    zzj = zzgdVar.zzc((zzid) zze, (zzid) value);
                } else {
                    zzhx zzW = ((zzhy) zze).zzW();
                    zzgdVar.zzb(zzW, (zzhy) value);
                    zzj = zzW.zzj();
                }
                this.zza.put(zzgdVar, zzj);
                return;
            }
            this.zza.put(zzgdVar, zzl(value));
            return;
        }
        zzhd zzhdVar = (zzhd) value;
        throw null;
    }

    private static boolean zzn(Map.Entry entry) {
        zzgd zzgdVar = (zzgd) entry.getKey();
        if (zzgdVar.zze() != zzjw.MESSAGE) {
            return true;
        }
        zzgdVar.zzg();
        Object value = entry.getValue();
        if (value instanceof zzhz) {
            return ((zzhz) value).zzo();
        }
        if (value instanceof zzhd) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzo(Map.Entry entry) {
        zzgd zzgdVar = (zzgd) entry.getKey();
        Object value = entry.getValue();
        if (zzgdVar.zze() == zzjw.MESSAGE) {
            zzgdVar.zzg();
            zzgdVar.zzf();
            if (value instanceof zzhd) {
                int zzy = zzfk.zzy(((zzgd) entry.getKey()).zza());
                int zza = ((zzhd) value).zza();
                int zzy2 = zzfk.zzy(zza) + zza;
                int zzy3 = zzfk.zzy(24);
                int zzy4 = zzfk.zzy(16);
                int zzy5 = zzfk.zzy(8);
                return zzy5 + zzy5 + zzy4 + zzy + zzy3 + zzy2;
            }
            int zzy6 = zzfk.zzy(((zzgd) entry.getKey()).zza());
            int zzy7 = zzfk.zzy(24) + zzfk.zzv((zzhy) value);
            int zzy8 = zzfk.zzy(16);
            int zzy9 = zzfk.zzy(8);
            return zzy9 + zzy9 + zzy8 + zzy6 + zzy7;
        }
        return zza(zzgdVar, value);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzge)) {
            return false;
        }
        return this.zza.equals(((zzge) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzb() {
        int i4 = 0;
        for (int i5 = 0; i5 < this.zza.zzb(); i5++) {
            i4 += zzo(this.zza.zzg(i5));
        }
        for (Map.Entry entry : this.zza.zzc()) {
            i4 += zzo(entry);
        }
        return i4;
    }

    /* renamed from: zzc */
    public final zzge clone() {
        zzge zzgeVar = new zzge();
        for (int i4 = 0; i4 < this.zza.zzb(); i4++) {
            Map.Entry zzg = this.zza.zzg(i4);
            zzgeVar.zzi((zzgd) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzgeVar.zzi((zzgd) entry.getKey(), entry.getValue());
        }
        zzgeVar.zzd = this.zzd;
        return zzgeVar;
    }

    public final Object zze(zzgd zzgdVar) {
        Object obj = this.zza.get(zzgdVar);
        if (!(obj instanceof zzhd)) {
            return obj;
        }
        zzhd zzhdVar = (zzhd) obj;
        throw null;
    }

    public final Iterator zzf() {
        if (this.zzd) {
            return new zzhc(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    public final void zzg() {
        if (!this.zzc) {
            for (int i4 = 0; i4 < this.zza.zzb(); i4++) {
                Map.Entry zzg = this.zza.zzg(i4);
                if (zzg.getValue() instanceof zzgo) {
                    ((zzgo) zzg.getValue()).zzA();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzh(zzge zzgeVar) {
        for (int i4 = 0; i4 < zzgeVar.zza.zzb(); i4++) {
            zzm(zzgeVar.zza.zzg(i4));
        }
        for (Map.Entry entry : zzgeVar.zza.zzc()) {
            zzm(entry);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
        if ((r7 instanceof com.google.android.recaptcha.internal.zzgq) == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
        if ((r7 instanceof byte[]) == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
        if (r0 == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
        if ((r7 instanceof com.google.android.recaptcha.internal.zzhd) == false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzi(com.google.android.recaptcha.internal.zzgd r6, java.lang.Object r7) {
        /*
            r5 = this;
            r6.zzg()
            com.google.android.recaptcha.internal.zzjv r0 = r6.zzd()
            byte[] r1 = com.google.android.recaptcha.internal.zzgw.zzd
            r7.getClass()
            com.google.android.recaptcha.internal.zzjv r1 = com.google.android.recaptcha.internal.zzjv.zza
            com.google.android.recaptcha.internal.zzjw r1 = com.google.android.recaptcha.internal.zzjw.INT
            com.google.android.recaptcha.internal.zzjw r0 = r0.zza()
            int r0 = r0.ordinal()
            r1 = 1
            switch(r0) {
                case 0: goto L47;
                case 1: goto L44;
                case 2: goto L41;
                case 3: goto L3e;
                case 4: goto L3b;
                case 5: goto L38;
                case 6: goto L2f;
                case 7: goto L26;
                case 8: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L57
        L1d:
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzhy
            if (r0 != 0) goto L4b
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzhd
            if (r0 == 0) goto L57
            goto L4b
        L26:
            boolean r0 = r7 instanceof java.lang.Integer
            if (r0 != 0) goto L4b
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzgq
            if (r0 == 0) goto L57
            goto L4b
        L2f:
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzez
            if (r0 != 0) goto L4b
            boolean r0 = r7 instanceof byte[]
            if (r0 == 0) goto L57
            goto L4b
        L38:
            boolean r0 = r7 instanceof java.lang.String
            goto L49
        L3b:
            boolean r0 = r7 instanceof java.lang.Boolean
            goto L49
        L3e:
            boolean r0 = r7 instanceof java.lang.Double
            goto L49
        L41:
            boolean r0 = r7 instanceof java.lang.Float
            goto L49
        L44:
            boolean r0 = r7 instanceof java.lang.Long
            goto L49
        L47:
            boolean r0 = r7 instanceof java.lang.Integer
        L49:
            if (r0 == 0) goto L57
        L4b:
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzhd
            if (r0 == 0) goto L51
            r5.zzd = r1
        L51:
            com.google.android.recaptcha.internal.zziy r0 = r5.zza
            r0.put(r6, r7)
            return
        L57:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            int r3 = r6.zza()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = 0
            r2[r4] = r3
            com.google.android.recaptcha.internal.zzjv r6 = r6.zzd()
            com.google.android.recaptcha.internal.zzjw r6 = r6.zza()
            r2[r1] = r6
            java.lang.Class r6 = r7.getClass()
            java.lang.String r6 = r6.getName()
            r7 = 2
            r2[r7] = r6
            java.lang.String r6 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r6 = java.lang.String.format(r6, r2)
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzge.zzi(com.google.android.recaptcha.internal.zzgd, java.lang.Object):void");
    }

    public final boolean zzj() {
        return this.zzc;
    }

    public final boolean zzk() {
        for (int i4 = 0; i4 < this.zza.zzb(); i4++) {
            if (!zzn(this.zza.zzg(i4))) {
                return false;
            }
        }
        for (Map.Entry entry : this.zza.zzc()) {
            if (!zzn(entry)) {
                return false;
            }
        }
        return true;
    }

    private zzge(boolean z3) {
        zzg();
        zzg();
    }
}
