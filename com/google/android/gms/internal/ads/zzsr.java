package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzsr implements zzuh {
    private final zzabd zza;
    @Nullable
    private zzaaw zzb;
    @Nullable
    private zzaax zzc;

    public zzsr(zzabd zzabdVar) {
        this.zza = zzabdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzuh
    public final int zza(zzabs zzabsVar) throws IOException {
        zzaaw zzaawVar = this.zzb;
        zzaawVar.getClass();
        zzaax zzaaxVar = this.zzc;
        zzaaxVar.getClass();
        return zzaawVar.zza(zzaaxVar, zzabsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuh
    public final long zzb() {
        zzaax zzaaxVar = this.zzc;
        if (zzaaxVar != null) {
            return zzaaxVar.zzf();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzuh
    public final void zzc() {
        zzaaw zzaawVar = this.zzb;
        if (zzaawVar instanceof zzafx) {
            ((zzafx) zzaawVar).zze();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
        if (r6.zzf() != r11) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0062, code lost:
        if (r6.zzf() != r11) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
        r1 = false;
     */
    @Override // com.google.android.gms.internal.ads.zzuh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd(com.google.android.gms.internal.ads.zzt r8, android.net.Uri r9, java.util.Map r10, long r11, long r13, com.google.android.gms.internal.ads.zzaaz r15) throws java.io.IOException {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzaam r6 = new com.google.android.gms.internal.ads.zzaam
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.zzc = r6
            com.google.android.gms.internal.ads.zzaaw r8 = r7.zzb
            if (r8 == 0) goto L10
            return
        L10:
            com.google.android.gms.internal.ads.zzabd r8 = r7.zza
            com.google.android.gms.internal.ads.zzaaw[] r8 = r8.zza(r9, r10)
            int r10 = r8.length
            r13 = 0
            r14 = 1
            if (r10 != r14) goto L21
            r8 = r8[r13]
            r7.zzb = r8
            goto Lb6
        L21:
            r0 = 0
        L22:
            if (r0 >= r10) goto L71
            r1 = r8[r0]
            boolean r2 = r1.zzd(r6)     // Catch: java.lang.Throwable -> L42 java.io.EOFException -> L57
            if (r2 == 0) goto L35
            r7.zzb = r1     // Catch: java.lang.Throwable -> L42 java.io.EOFException -> L57
            com.google.android.gms.internal.ads.zzdy.zzf(r14)
            r6.zzj()
            goto L71
        L35:
            com.google.android.gms.internal.ads.zzaaw r1 = r7.zzb
            if (r1 != 0) goto L67
            long r1 = r6.zzf()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L65
            goto L67
        L42:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzaaw r9 = r7.zzb
            if (r9 != 0) goto L4f
            long r9 = r6.zzf()
            int r15 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r15 != 0) goto L50
        L4f:
            r13 = 1
        L50:
            com.google.android.gms.internal.ads.zzdy.zzf(r13)
            r6.zzj()
            throw r8
        L57:
            com.google.android.gms.internal.ads.zzaaw r1 = r7.zzb
            if (r1 != 0) goto L67
            long r1 = r6.zzf()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L65
            goto L67
        L65:
            r1 = 0
            goto L68
        L67:
            r1 = 1
        L68:
            com.google.android.gms.internal.ads.zzdy.zzf(r1)
            r6.zzj()
            int r0 = r0 + 1
            goto L22
        L71:
            com.google.android.gms.internal.ads.zzaaw r10 = r7.zzb
            if (r10 != 0) goto Lb6
            com.google.android.gms.internal.ads.zzvo r10 = new com.google.android.gms.internal.ads.zzvo
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
        L7c:
            int r12 = r8.length
            if (r13 >= r12) goto L98
            r14 = r8[r13]
            java.lang.Class r14 = r14.getClass()
            java.lang.String r14 = r14.getSimpleName()
            r11.append(r14)
            int r12 = r12 + (-1)
            if (r13 >= r12) goto L95
            java.lang.String r12 = ", "
            r11.append(r12)
        L95:
            int r13 = r13 + 1
            goto L7c
        L98:
            java.lang.String r8 = r11.toString()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "None of the available extractors ("
            r11.append(r12)
            r11.append(r8)
            java.lang.String r8 = ") could read the stream."
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            r10.<init>(r8, r9)
            throw r10
        Lb6:
            com.google.android.gms.internal.ads.zzaaw r8 = r7.zzb
            r8.zzb(r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsr.zzd(com.google.android.gms.internal.ads.zzt, android.net.Uri, java.util.Map, long, long, com.google.android.gms.internal.ads.zzaaz):void");
    }

    @Override // com.google.android.gms.internal.ads.zzuh
    public final void zze() {
        if (this.zzb != null) {
            this.zzb = null;
        }
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzuh
    public final void zzf(long j4, long j5) {
        zzaaw zzaawVar = this.zzb;
        zzaawVar.getClass();
        zzaawVar.zzc(j4, j5);
    }
}
