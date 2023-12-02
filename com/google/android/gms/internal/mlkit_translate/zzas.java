package com.google.android.gms.internal.mlkit_translate;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
class zzas extends zzat {
    final zzao zzb;
    @CheckForNull
    final Character zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzas(zzao zzaoVar, @CheckForNull Character ch) {
        this.zzb = zzaoVar;
        if (ch == null || !zzaoVar.zzd(ch.charValue())) {
            this.zzc = ch;
            return;
        }
        throw new IllegalArgumentException(zzl.zza("Padding character %s was already in alphabet", ch));
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzas) {
            zzas zzasVar = (zzas) obj;
            if (this.zzb.equals(zzasVar.zzb) && zze.zza(this.zzc, zzasVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode() ^ Arrays.hashCode(new Object[]{this.zzc});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.zzb.toString());
        if (8 % this.zzb.zza != 0) {
            if (this.zzc == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(this.zzc);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzat
    int zza(byte[] bArr, CharSequence charSequence) throws zzar {
        zzao zzaoVar;
        bArr.getClass();
        CharSequence zzc = zzc(charSequence);
        if (this.zzb.zzc(zzc.length())) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < zzc.length()) {
                long j4 = 0;
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    zzaoVar = this.zzb;
                    if (i6 >= zzaoVar.zzb) {
                        break;
                    }
                    j4 <<= zzaoVar.zza;
                    if (i4 + i6 < zzc.length()) {
                        j4 |= this.zzb.zzb(zzc.charAt(i7 + i4));
                        i7++;
                    }
                    i6++;
                }
                int i8 = zzaoVar.zzc;
                int i9 = (i8 * 8) - (i7 * zzaoVar.zza);
                int i10 = (i8 - 1) * 8;
                while (i10 >= i9) {
                    bArr[i5] = (byte) ((j4 >>> i10) & 255);
                    i10 -= 8;
                    i5++;
                }
                i4 += this.zzb.zzb;
            }
            return i5;
        }
        throw new zzar("Invalid input length " + zzc.length());
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzat
    final int zzb(int i4) {
        return (int) (((this.zzb.zza * i4) + 7) / 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.mlkit_translate.zzat
    public final CharSequence zzc(CharSequence charSequence) {
        charSequence.getClass();
        Character ch = this.zzc;
        if (ch == null) {
            return charSequence;
        }
        char charValue = ch.charValue();
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
        } while (charSequence.charAt(length) == charValue);
        return charSequence.subSequence(0, length + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzas(String str, String str2, @CheckForNull Character ch) {
        this(new zzao(str, str2.toCharArray()), ch);
    }
}
