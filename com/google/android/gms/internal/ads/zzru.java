package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzru extends Exception {
    public final String zza;
    public final boolean zzb;
    @Nullable
    public final zzrs zzc;
    @Nullable
    public final String zzd;
    @Nullable
    public final zzru zze;

    public zzru(zzam zzamVar, @Nullable Throwable th, boolean z3, int i4) {
        this("Decoder init failed: [" + i4 + "], " + String.valueOf(zzamVar), th, zzamVar.zzm, false, null, "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_neg_" + Math.abs(i4), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzru zza(zzru zzruVar, zzru zzruVar2) {
        return new zzru(zzruVar.getMessage(), zzruVar.getCause(), zzruVar.zza, false, zzruVar.zzc, zzruVar.zzd, zzruVar2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzru(com.google.android.gms.internal.ads.zzam r11, @androidx.annotation.Nullable java.lang.Throwable r12, boolean r13, com.google.android.gms.internal.ads.zzrs r14) {
        /*
            r10 = this;
            java.lang.String r13 = r14.zza
            java.lang.String r0 = java.lang.String.valueOf(r11)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Decoder init failed: "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r13 = ", "
            r1.append(r13)
            r1.append(r0)
            java.lang.String r3 = r1.toString()
            java.lang.String r5 = r11.zzm
            int r11 = com.google.android.gms.internal.ads.zzfj.zza
            r13 = 21
            r0 = 0
            if (r11 < r13) goto L35
            boolean r11 = r12 instanceof android.media.MediaCodec.CodecException
            if (r11 == 0) goto L35
            r11 = r12
            android.media.MediaCodec$CodecException r11 = (android.media.MediaCodec.CodecException) r11
            java.lang.String r11 = r11.getDiagnosticInfo()
            r8 = r11
            goto L36
        L35:
            r8 = r0
        L36:
            r6 = 0
            r9 = 0
            r2 = r10
            r4 = r12
            r7 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzru.<init>(com.google.android.gms.internal.ads.zzam, java.lang.Throwable, boolean, com.google.android.gms.internal.ads.zzrs):void");
    }

    private zzru(String str, @Nullable Throwable th, String str2, boolean z3, @Nullable zzrs zzrsVar, @Nullable String str3, @Nullable zzru zzruVar) {
        super(str, th);
        this.zza = str2;
        this.zzb = false;
        this.zzc = zzrsVar;
        this.zzd = str3;
        this.zze = zzruVar;
    }
}
