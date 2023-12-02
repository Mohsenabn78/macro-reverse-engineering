package com.google.android.gms.internal.places;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzcq<T> implements zzda<T> {
    private final zzck zzkw;
    private final boolean zzkx;
    private final zzds<?, ?> zzlg;
    private final zzar<?> zzlh;

    private zzcq(zzds<?, ?> zzdsVar, zzar<?> zzarVar, zzck zzckVar) {
        this.zzlg = zzdsVar;
        this.zzkx = zzarVar.zzf(zzckVar);
        this.zzlh = zzarVar;
        this.zzkw = zzckVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzcq<T> zzb(zzds<?, ?> zzdsVar, zzar<?> zzarVar, zzck zzckVar) {
        return new zzcq<>(zzdsVar, zzarVar, zzckVar);
    }

    @Override // com.google.android.gms.internal.places.zzda
    public final boolean equals(T t3, T t4) {
        if (!this.zzlg.zzr(t3).equals(this.zzlg.zzr(t4))) {
            return false;
        }
        if (this.zzkx) {
            return this.zzlh.zzb(t3).equals(this.zzlh.zzb(t4));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.places.zzda
    public final int hashCode(T t3) {
        int hashCode = this.zzlg.zzr(t3).hashCode();
        if (this.zzkx) {
            return (hashCode * 53) + this.zzlh.zzb(t3).hashCode();
        }
        return hashCode;
    }

    @Override // com.google.android.gms.internal.places.zzda
    public final T newInstance() {
        return (T) this.zzkw.zzbl().zzbe();
    }

    @Override // com.google.android.gms.internal.places.zzda
    public final void zzd(T t3, T t4) {
        zzdc.zzb(this.zzlg, t3, t4);
        if (this.zzkx) {
            zzdc.zzb(this.zzlh, t3, t4);
        }
    }

    @Override // com.google.android.gms.internal.places.zzda
    public final int zzn(T t3) {
        zzds<?, ?> zzdsVar = this.zzlg;
        int zzs = zzdsVar.zzs(zzdsVar.zzr(t3)) + 0;
        if (this.zzkx) {
            return zzs + this.zzlh.zzb(t3).zzav();
        }
        return zzs;
    }

    @Override // com.google.android.gms.internal.places.zzda
    public final boolean zzp(T t3) {
        return this.zzlh.zzb(t3).isInitialized();
    }

    @Override // com.google.android.gms.internal.places.zzda
    public final void zzb(T t3, zzel zzelVar) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzlh.zzb(t3).iterator();
        while (it.hasNext()) {
            Map.Entry<?, Object> next = it.next();
            zzax zzaxVar = (zzax) next.getKey();
            if (zzaxVar.zzay() == zzem.MESSAGE && !zzaxVar.zzaz() && !zzaxVar.zzba()) {
                if (next instanceof zzbn) {
                    zzelVar.zzb(zzaxVar.zzaw(), (Object) ((zzbn) next).zzbx().zzv());
                } else {
                    zzelVar.zzb(zzaxVar.zzaw(), next.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        zzds<?, ?> zzdsVar = this.zzlg;
        zzdsVar.zzd(zzdsVar.zzr(t3), zzelVar);
    }

    @Override // com.google.android.gms.internal.places.zzda
    public final void zzd(T t3) {
        this.zzlg.zzd(t3);
        this.zzlh.zzd(t3);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0099 A[EDGE_INSN: B:57:0x0099->B:34:0x0099 ?: BREAK  , SYNTHETIC] */
    @Override // com.google.android.gms.internal.places.zzda
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzb(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.places.zzr r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.places.zzbc r0 = (com.google.android.gms.internal.places.zzbc) r0
            com.google.android.gms.internal.places.zzdr r1 = r0.zzih
            com.google.android.gms.internal.places.zzdr r2 = com.google.android.gms.internal.places.zzdr.zzdh()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.places.zzdr r1 = com.google.android.gms.internal.places.zzdr.zzdi()
            r0.zzih = r1
        L11:
            com.google.android.gms.internal.places.zzbc$zzc r10 = (com.google.android.gms.internal.places.zzbc.zzc) r10
            r10.zzbm()
            r10 = 0
            r0 = r10
        L18:
            if (r12 >= r13) goto La4
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r11, r12, r14)
            int r2 = r14.zzdz
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L51
            r12 = r2 & 7
            if (r12 != r3) goto L4c
            com.google.android.gms.internal.places.zzar<?> r12 = r9.zzlh
            com.google.android.gms.internal.places.zzap r0 = r14.zzec
            com.google.android.gms.internal.places.zzck r3 = r9.zzkw
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zzb(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.places.zzbc$zzf r0 = (com.google.android.gms.internal.places.zzbc.zzf) r0
            if (r0 != 0) goto L43
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.places.zzs.zzb(r2, r3, r4, r5, r6, r7)
            goto L18
        L43:
            com.google.android.gms.internal.places.zzcv.zzcq()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L4c:
            int r12 = com.google.android.gms.internal.places.zzs.zzb(r2, r11, r4, r13, r14)
            goto L18
        L51:
            r12 = 0
            r2 = r10
        L53:
            if (r4 >= r13) goto L99
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r11, r4, r14)
            int r5 = r14.zzdz
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L7b
            r8 = 3
            if (r6 == r8) goto L65
            goto L90
        L65:
            if (r0 != 0) goto L72
            if (r7 != r3) goto L90
            int r4 = com.google.android.gms.internal.places.zzs.zzf(r11, r4, r14)
            java.lang.Object r2 = r14.zzeb
            com.google.android.gms.internal.places.zzw r2 = (com.google.android.gms.internal.places.zzw) r2
            goto L53
        L72:
            com.google.android.gms.internal.places.zzcv.zzcq()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L7b:
            if (r7 != 0) goto L90
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r11, r4, r14)
            int r12 = r14.zzdz
            com.google.android.gms.internal.places.zzar<?> r0 = r9.zzlh
            com.google.android.gms.internal.places.zzap r5 = r14.zzec
            com.google.android.gms.internal.places.zzck r6 = r9.zzkw
            java.lang.Object r0 = r0.zzb(r5, r6, r12)
            com.google.android.gms.internal.places.zzbc$zzf r0 = (com.google.android.gms.internal.places.zzbc.zzf) r0
            goto L53
        L90:
            r6 = 12
            if (r5 == r6) goto L99
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r5, r11, r4, r13, r14)
            goto L53
        L99:
            if (r2 == 0) goto La1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zzc(r12, r2)
        La1:
            r12 = r4
            goto L18
        La4:
            if (r12 != r13) goto La7
            return
        La7:
            com.google.android.gms.internal.places.zzbk r10 = com.google.android.gms.internal.places.zzbk.zzbt()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzcq.zzb(java.lang.Object, byte[], int, int, com.google.android.gms.internal.places.zzr):void");
    }
}
