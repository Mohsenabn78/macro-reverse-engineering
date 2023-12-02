package com.google.android.gms.internal.mlkit_translate;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzap extends zzas {
    final char[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzap(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            com.google.android.gms.internal.mlkit_translate.zzao r4 = new com.google.android.gms.internal.mlkit_translate.zzao
            java.lang.String r5 = "0123456789ABCDEF"
            char[] r5 = r5.toCharArray()
            java.lang.String r0 = "base16()"
            r4.<init>(r0, r5)
            r5 = 0
            r3.<init>(r4, r5)
            r5 = 512(0x200, float:7.175E-43)
            char[] r5 = new char[r5]
            r3.zza = r5
            char[] r5 = com.google.android.gms.internal.mlkit_translate.zzao.zze(r4)
            int r5 = r5.length
            r0 = 16
            r1 = 0
            if (r5 != r0) goto L23
            r5 = 1
            goto L24
        L23:
            r5 = 0
        L24:
            com.google.android.gms.internal.mlkit_translate.zzj.zzc(r5)
        L27:
            r5 = 256(0x100, float:3.59E-43)
            if (r1 >= r5) goto L44
            char[] r5 = r3.zza
            int r0 = r1 >>> 4
            char r0 = r4.zza(r0)
            r5[r1] = r0
            char[] r5 = r3.zza
            r0 = r1 | 256(0x100, float:3.59E-43)
            r2 = r1 & 15
            char r2 = r4.zza(r2)
            r5[r0] = r2
            int r1 = r1 + 1
            goto L27
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_translate.zzap.<init>(java.lang.String, java.lang.String):void");
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzas, com.google.android.gms.internal.mlkit_translate.zzat
    final int zza(byte[] bArr, CharSequence charSequence) throws zzar {
        bArr.getClass();
        if (charSequence.length() % 2 != 1) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < charSequence.length()) {
                bArr[i5] = (byte) ((this.zzb.zzb(charSequence.charAt(i4)) << 4) | this.zzb.zzb(charSequence.charAt(i4 + 1)));
                i4 += 2;
                i5++;
            }
            return i5;
        }
        throw new zzar("Invalid input length " + charSequence.length());
    }
}
