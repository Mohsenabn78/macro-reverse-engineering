package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.math.RoundingMode;
import javax.annotation.CheckForNull;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public class zztj extends zztk {
    final zzte zzb;
    @CheckForNull
    final Character zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztj(zzte zzteVar, @CheckForNull Character ch) {
        this.zzb = zzteVar;
        boolean z3 = true;
        if (ch != null) {
            ch.charValue();
            if (zzteVar.zzd(SignatureVisitor.INSTANCEOF)) {
                z3 = false;
            }
        }
        zzsj.zzg(z3, "Padding character %s was already in alphabet", ch);
        this.zzc = ch;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zztj) {
            zztj zztjVar = (zztj) obj;
            if (this.zzb.equals(zztjVar.zzb)) {
                Character ch = this.zzc;
                Character ch2 = zztjVar.zzc;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zztk
    public int zza(byte[] bArr, CharSequence charSequence) throws zzth {
        zzte zzteVar;
        CharSequence zzf = zzf(charSequence);
        if (this.zzb.zzc(zzf.length())) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < zzf.length()) {
                long j4 = 0;
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    zzteVar = this.zzb;
                    if (i6 >= zzteVar.zzc) {
                        break;
                    }
                    j4 <<= zzteVar.zzb;
                    if (i4 + i6 < zzf.length()) {
                        j4 |= this.zzb.zzb(zzf.charAt(i7 + i4));
                        i7++;
                    }
                    i6++;
                }
                int i8 = zzteVar.zzd;
                int i9 = i8 * 8;
                int i10 = i7 * zzteVar.zzb;
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
        throw new zzth("Invalid input length " + zzf.length());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zztk
    public void zzb(Appendable appendable, byte[] bArr, int i4, int i5) throws IOException {
        int i6 = 0;
        zzsj.zzh(0, i5, bArr.length);
        while (i6 < i5) {
            zzg(appendable, bArr, i6, Math.min(this.zzb.zzd, i5 - i6));
            i6 += this.zzb.zzd;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zztk
    public final int zzc(int i4) {
        return (int) (((this.zzb.zzb * i4) + 7) / 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zztk
    public final int zzd(int i4) {
        zzte zzteVar = this.zzb;
        return zzteVar.zzc * zztm.zza(i4, zzteVar.zzd, RoundingMode.CEILING);
    }

    @Override // com.google.android.gms.internal.nearby.zztk
    public final zztk zze(String str, int i4) {
        for (int i5 = 0; i5 <= 0; i5++) {
            zzsj.zzg(true ^ this.zzb.zzd(":".charAt(i5)), "Separator (%s) cannot contain alphabet characters", ":");
        }
        Character ch = this.zzc;
        if (ch != null) {
            ch.charValue();
            zzsj.zzg(true, "Separator (%s) cannot contain padding character", ":");
        }
        return new zzti(this, ":", 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zztk
    public final CharSequence zzf(CharSequence charSequence) {
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
    public final void zzg(Appendable appendable, byte[] bArr, int i4, int i5) throws IOException {
        boolean z3;
        zzsj.zzh(i4, i4 + i5, bArr.length);
        int i6 = 0;
        if (i5 <= this.zzb.zzd) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzsj.zzd(z3);
        long j4 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            j4 = (j4 | (bArr[i4 + i7] & 255)) << 8;
        }
        int i8 = ((i5 + 1) * 8) - this.zzb.zzb;
        while (i6 < i5 * 8) {
            zzte zzteVar = this.zzb;
            appendable.append(zzteVar.zza(zzteVar.zza & ((int) (j4 >>> (i8 - i6)))));
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
    public zztj(String str, String str2, @CheckForNull Character ch) {
        this(new zzte(str, str2.toCharArray()), ch);
    }
}
