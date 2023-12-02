package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.math.RoundingMode;
import javax.annotation.CheckForNull;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
class zzea extends zzeb {
    final zzdw zzb;
    @CheckForNull
    final Character zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzea(com.google.android.recaptcha.internal.zzdw r4, @javax.annotation.CheckForNull java.lang.Character r5) {
        /*
            r3 = this;
            r3.<init>()
            r3.zzb = r4
            r0 = 0
            r1 = 1
            if (r5 == 0) goto L17
            r5.charValue()
            r2 = 61
            boolean r4 = r4.zzd(r2)
            if (r4 != 0) goto L15
            goto L17
        L15:
            r4 = 0
            goto L18
        L17:
            r4 = 1
        L18:
            if (r4 == 0) goto L1d
            r3.zzc = r5
            return
        L1d:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r5
            java.lang.String r5 = "Padding character %s was already in alphabet"
            java.lang.String r5 = com.google.android.recaptcha.internal.zzdl.zza(r5, r1)
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzea.<init>(com.google.android.recaptcha.internal.zzdw, java.lang.Character):void");
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzea) {
            zzea zzeaVar = (zzea) obj;
            if (this.zzb.equals(zzeaVar.zzb)) {
                Character ch = this.zzc;
                Character ch2 = zzeaVar.zzc;
                if (ch != ch2) {
                    if (ch != null && ch.equals(ch2)) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = this.zzb.hashCode();
        Character ch = this.zzc;
        if (ch == null) {
            hashCode = 0;
        } else {
            hashCode = ch.hashCode();
        }
        return hashCode2 ^ hashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.zzb);
        if (8 % this.zzb.zzb != 0) {
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

    @Override // com.google.android.recaptcha.internal.zzeb
    int zza(byte[] bArr, CharSequence charSequence) throws zzdz {
        zzdw zzdwVar;
        bArr.getClass();
        CharSequence zze = zze(charSequence);
        if (this.zzb.zzc(zze.length())) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < zze.length()) {
                long j4 = 0;
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    zzdwVar = this.zzb;
                    if (i6 >= zzdwVar.zzc) {
                        break;
                    }
                    j4 <<= zzdwVar.zzb;
                    if (i4 + i6 < zze.length()) {
                        j4 |= this.zzb.zzb(zze.charAt(i7 + i4));
                        i7++;
                    }
                    i6++;
                }
                int i8 = zzdwVar.zzd;
                int i9 = i8 * 8;
                int i10 = i7 * zzdwVar.zzb;
                int i11 = (i8 - 1) * 8;
                while (i11 >= i9 - i10) {
                    bArr[i5] = (byte) ((j4 >>> i11) & 255);
                    i11 -= 8;
                    i5++;
                }
                i4 += this.zzb.zzc;
            }
            return i5;
        }
        throw new zzdz("Invalid input length " + zze.length());
    }

    @Override // com.google.android.recaptcha.internal.zzeb
    void zzb(Appendable appendable, byte[] bArr, int i4, int i5) throws IOException {
        int i6 = 0;
        zzdi.zzd(0, i5, bArr.length);
        while (i6 < i5) {
            zzf(appendable, bArr, i6, Math.min(this.zzb.zzd, i5 - i6));
            i6 += this.zzb.zzd;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzeb
    final int zzc(int i4) {
        return (int) (((this.zzb.zzb * i4) + 7) / 8);
    }

    @Override // com.google.android.recaptcha.internal.zzeb
    final int zzd(int i4) {
        zzdw zzdwVar = this.zzb;
        return zzdwVar.zzc * zzed.zza(i4, zzdwVar.zzd, RoundingMode.CEILING);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzeb
    public final CharSequence zze(CharSequence charSequence) {
        charSequence.getClass();
        Character ch = this.zzc;
        if (ch == null) {
            return charSequence;
        }
        ch.charValue();
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
        } while (charSequence.charAt(length) == '=');
        return charSequence.subSequence(0, length + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzf(Appendable appendable, byte[] bArr, int i4, int i5) throws IOException {
        boolean z3;
        zzdi.zzd(i4, i4 + i5, bArr.length);
        int i6 = 0;
        if (i5 <= this.zzb.zzd) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdi.zza(z3);
        long j4 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            j4 = (j4 | (bArr[i4 + i7] & 255)) << 8;
        }
        int i8 = ((i5 + 1) * 8) - this.zzb.zzb;
        while (i6 < i5 * 8) {
            zzdw zzdwVar = this.zzb;
            appendable.append(zzdwVar.zza(zzdwVar.zza & ((int) (j4 >>> (i8 - i6)))));
            i6 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i6 < this.zzb.zzd * 8) {
                this.zzc.charValue();
                appendable.append(SignatureVisitor.INSTANCEOF);
                i6 += this.zzb.zzb;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzea(String str, String str2, @CheckForNull Character ch) {
        this(new zzdw(str, str2.toCharArray()), ch);
    }
}
