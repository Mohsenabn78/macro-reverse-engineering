package com.google.android.gms.internal.nearby;

import java.io.IOException;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public abstract class zztk {
    private static final zztk zza;
    private static final zztk zzb;
    private static final zztk zzc;
    private static final zztk zzd;
    private static final zztk zze;

    static {
        Character valueOf = Character.valueOf(SignatureVisitor.INSTANCEOF);
        zza = new zztg("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", valueOf);
        zzb = new zztg("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", valueOf);
        zzc = new zztj("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", valueOf);
        zzd = new zztj("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", valueOf);
        zze = new zztf("base16()", "0123456789ABCDEF");
    }

    public static zztk zzh() {
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zza(byte[] bArr, CharSequence charSequence) throws zzth;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(Appendable appendable, byte[] bArr, int i4, int i5) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzc(int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzd(int i4);

    public abstract zztk zze(String str, int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence zzf(CharSequence charSequence) {
        throw null;
    }

    public final String zzi(byte[] bArr, int i4, int i5) {
        zzsj.zzh(0, i5, bArr.length);
        StringBuilder sb = new StringBuilder(zzd(i5));
        try {
            zzb(sb, bArr, 0, i5);
            return sb.toString();
        } catch (IOException e4) {
            throw new AssertionError(e4);
        }
    }

    public final byte[] zzj(CharSequence charSequence) {
        try {
            CharSequence zzf = zzf(charSequence);
            int zzc2 = zzc(zzf.length());
            byte[] bArr = new byte[zzc2];
            int zza2 = zza(bArr, zzf);
            if (zza2 != zzc2) {
                byte[] bArr2 = new byte[zza2];
                System.arraycopy(bArr, 0, bArr2, 0, zza2);
                return bArr2;
            }
            return bArr;
        } catch (zzth e4) {
            throw new IllegalArgumentException(e4);
        }
    }
}
