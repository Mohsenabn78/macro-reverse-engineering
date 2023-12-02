package com.google.android.gms.internal.mlkit_translate;

import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public abstract class zzat {
    private static final zzat zza;
    private static final zzat zzb;
    private static final zzat zzc;
    private static final zzat zzd;
    private static final zzat zze;

    static {
        Character valueOf = Character.valueOf(SignatureVisitor.INSTANCEOF);
        zza = new zzaq("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", valueOf);
        zzb = new zzaq("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", valueOf);
        zzc = new zzas("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", valueOf);
        zzd = new zzas("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", valueOf);
        zze = new zzap("base16()", "0123456789ABCDEF");
    }

    public static zzat zzd() {
        return zza;
    }

    abstract int zza(byte[] bArr, CharSequence charSequence) throws zzar;

    abstract int zzb(int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence zzc(CharSequence charSequence) {
        throw null;
    }

    public final byte[] zze(CharSequence charSequence) {
        try {
            CharSequence zzc2 = zzc(charSequence);
            int zzb2 = zzb(zzc2.length());
            byte[] bArr = new byte[zzb2];
            int zza2 = zza(bArr, zzc2);
            if (zza2 != zzb2) {
                byte[] bArr2 = new byte[zza2];
                System.arraycopy(bArr, 0, bArr2, 0, zza2);
                return bArr2;
            }
            return bArr;
        } catch (zzar e4) {
            throw new IllegalArgumentException(e4);
        }
    }
}
