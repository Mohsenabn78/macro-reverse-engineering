package com.google.android.gms.internal.mlkit_translate;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzaq extends zzas {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzaq(java.lang.String r2, java.lang.String r3, @javax.annotation.CheckForNull java.lang.Character r4) {
        /*
            r1 = this;
            com.google.android.gms.internal.mlkit_translate.zzao r0 = new com.google.android.gms.internal.mlkit_translate.zzao
            char[] r3 = r3.toCharArray()
            r0.<init>(r2, r3)
            r1.<init>(r0, r4)
            char[] r2 = com.google.android.gms.internal.mlkit_translate.zzao.zze(r0)
            int r2 = r2.length
            r3 = 64
            if (r2 != r3) goto L17
            r2 = 1
            goto L18
        L17:
            r2 = 0
        L18:
            com.google.android.gms.internal.mlkit_translate.zzj.zzc(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_translate.zzaq.<init>(java.lang.String, java.lang.String, java.lang.Character):void");
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzas, com.google.android.gms.internal.mlkit_translate.zzat
    final int zza(byte[] bArr, CharSequence charSequence) throws zzar {
        bArr.getClass();
        CharSequence zzc = zzc(charSequence);
        if (this.zzb.zzc(zzc.length())) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < zzc.length()) {
                int i6 = i4 + 1;
                int i7 = i6 + 1;
                int zzb = (this.zzb.zzb(zzc.charAt(i4)) << 18) | (this.zzb.zzb(zzc.charAt(i6)) << 12);
                int i8 = i5 + 1;
                bArr[i5] = (byte) (zzb >>> 16);
                if (i7 < zzc.length()) {
                    int i9 = i7 + 1;
                    int zzb2 = zzb | (this.zzb.zzb(zzc.charAt(i7)) << 6);
                    int i10 = i8 + 1;
                    bArr[i8] = (byte) ((zzb2 >>> 8) & 255);
                    if (i9 < zzc.length()) {
                        bArr[i10] = (byte) ((zzb2 | this.zzb.zzb(zzc.charAt(i9))) & 255);
                        i4 = i9 + 1;
                        i5 = i10 + 1;
                    } else {
                        i4 = i9;
                        i5 = i10;
                    }
                } else {
                    i5 = i8;
                    i4 = i7;
                }
            }
            return i5;
        }
        throw new zzar("Invalid input length " + zzc.length());
    }
}
