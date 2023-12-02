package com.google.android.gms.internal.wearable;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public abstract class zzaw implements Iterable, Serializable {
    private static final Comparator zza;
    public static final zzaw zzb = new zzat(zzcd.zzd);
    private static final zzav zzd;
    private int zzc = 0;

    static {
        int i4 = zzai.zza;
        zzd = new zzav(null);
        zza = new zzao();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i4, int i5, int i6) {
        int i7 = i5 - i4;
        if ((i4 | i5 | i7 | (i6 - i5)) < 0) {
            if (i4 >= 0) {
                if (i5 < i4) {
                    throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i4 + ", " + i5);
                }
                throw new IndexOutOfBoundsException("End index: " + i5 + " >= " + i6);
            }
            throw new IndexOutOfBoundsException("Beginning index: " + i4 + " < 0");
        }
        return i7;
    }

    public static zzaw zzm(byte[] bArr) {
        return zzn(bArr, 0, bArr.length);
    }

    public static zzaw zzn(byte[] bArr, int i4, int i5) {
        zzk(i4, i4 + i5, bArr.length);
        byte[] bArr2 = new byte[i5];
        System.arraycopy(bArr, i4, bArr2, 0, i5);
        return new zzat(bArr2);
    }

    public static zzaw zzo(String str) {
        return new zzat(str.getBytes(zzcd.zzb));
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i4 = this.zzc;
        if (i4 == 0) {
            int zzd2 = zzd();
            i4 = zzf(zzd2, 0, zzd2);
            if (i4 == 0) {
                i4 = 1;
            }
            this.zzc = i4;
        }
        return i4;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzan(this);
    }

    public final String toString() {
        String concat;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        if (zzd() <= 50) {
            concat = zzec.zza(this);
        } else {
            concat = zzec.zza(zzg(0, 47)).concat("...");
        }
        objArr[2] = concat;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte zzb(int i4);

    public abstract int zzd();

    protected abstract void zze(byte[] bArr, int i4, int i5, int i6);

    protected abstract int zzf(int i4, int i5, int i6);

    public abstract zzaw zzg(int i4, int i5);

    protected abstract String zzh(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzi(zzam zzamVar) throws IOException;

    public abstract boolean zzj();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzl() {
        return this.zzc;
    }

    public final String zzp(Charset charset) {
        if (zzd() == 0) {
            return "";
        }
        return zzh(charset);
    }

    public final byte[] zzq() {
        int zzd2 = zzd();
        if (zzd2 == 0) {
            return zzcd.zzd;
        }
        byte[] bArr = new byte[zzd2];
        zze(bArr, 0, 0, zzd2);
        return bArr;
    }
}
