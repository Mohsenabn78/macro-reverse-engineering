package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayDeque;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzafi implements zzafk {
    private final byte[] zza = new byte[8];
    private final ArrayDeque zzb = new ArrayDeque();
    private final zzafr zzc = new zzafr();
    private zzafj zzd;
    private int zze;
    private int zzf;
    private long zzg;

    private final long zzd(zzaax zzaaxVar, int i4) throws IOException {
        ((zzaam) zzaaxVar).zzn(this.zza, 0, i4, false);
        long j4 = 0;
        for (int i5 = 0; i5 < i4; i5++) {
            j4 = (j4 << 8) | (this.zza[i5] & 255);
        }
        return j4;
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final void zza(zzafj zzafjVar) {
        this.zzd = zzafjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final void zzb() {
        this.zze = 0;
        this.zzb.clear();
        this.zzc.zze();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0097, code lost:
        if (r0 == 1) goto L39;
     */
    @Override // com.google.android.gms.internal.ads.zzafk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzc(com.google.android.gms.internal.ads.zzaax r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 776
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafi.zzc(com.google.android.gms.internal.ads.zzaax):boolean");
    }
}
