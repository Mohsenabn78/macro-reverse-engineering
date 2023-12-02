package com.google.android.gms.internal.nearby;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zztg extends zztj {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zztg(java.lang.String r2, java.lang.String r3, @javax.annotation.CheckForNull java.lang.Character r4) {
        /*
            r1 = this;
            com.google.android.gms.internal.nearby.zzte r0 = new com.google.android.gms.internal.nearby.zzte
            char[] r3 = r3.toCharArray()
            r0.<init>(r2, r3)
            r1.<init>(r0, r4)
            char[] r2 = com.google.android.gms.internal.nearby.zzte.zze(r0)
            int r2 = r2.length
            r3 = 64
            if (r2 != r3) goto L17
            r2 = 1
            goto L18
        L17:
            r2 = 0
        L18:
            com.google.android.gms.internal.nearby.zzsj.zzd(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.nearby.zztg.<init>(java.lang.String, java.lang.String, java.lang.Character):void");
    }

    @Override // com.google.android.gms.internal.nearby.zztj, com.google.android.gms.internal.nearby.zztk
    final int zza(byte[] bArr, CharSequence charSequence) throws zzth {
        CharSequence zzf = zzf(charSequence);
        if (this.zzb.zzc(zzf.length())) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < zzf.length()) {
                int i6 = i4 + 1;
                int i7 = i5 + 1;
                int zzb = (this.zzb.zzb(zzf.charAt(i4)) << 18) | (this.zzb.zzb(zzf.charAt(i6)) << 12);
                bArr[i5] = (byte) (zzb >>> 16);
                int i8 = i6 + 1;
                if (i8 < zzf.length()) {
                    int i9 = i8 + 1;
                    int zzb2 = zzb | (this.zzb.zzb(zzf.charAt(i8)) << 6);
                    i5 = i7 + 1;
                    bArr[i7] = (byte) ((zzb2 >>> 8) & 255);
                    if (i9 < zzf.length()) {
                        bArr[i5] = (byte) ((zzb2 | this.zzb.zzb(zzf.charAt(i9))) & 255);
                        i5++;
                        i4 = i9 + 1;
                    } else {
                        i4 = i9;
                    }
                } else {
                    i4 = i8;
                    i5 = i7;
                }
            }
            return i5;
        }
        int length = zzf.length();
        throw new zzth("Invalid input length " + length);
    }

    @Override // com.google.android.gms.internal.nearby.zztj, com.google.android.gms.internal.nearby.zztk
    final void zzb(Appendable appendable, byte[] bArr, int i4, int i5) throws IOException {
        int i6 = 0;
        zzsj.zzh(0, i5, bArr.length);
        for (int i7 = i5; i7 >= 3; i7 -= 3) {
            int i8 = i6 + 1;
            int i9 = i8 + 1;
            int i10 = ((bArr[i6] & 255) << 16) | ((bArr[i8] & 255) << 8) | (bArr[i9] & 255);
            appendable.append(this.zzb.zza(i10 >>> 18));
            appendable.append(this.zzb.zza((i10 >>> 12) & 63));
            appendable.append(this.zzb.zza((i10 >>> 6) & 63));
            appendable.append(this.zzb.zza(i10 & 63));
            i6 = i9 + 1;
        }
        if (i6 < i5) {
            zzg(appendable, bArr, i6, i5 - i6);
        }
    }
}
