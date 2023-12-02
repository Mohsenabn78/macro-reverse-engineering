package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafy  reason: invalid package */
/* loaded from: classes4.dex */
public abstract class zzafy implements Iterable, Serializable {
    private static final Comparator zza;
    public static final zzafy zzb = new zzafv(zzahj.zzd);
    private static final zzafx zzd;
    private int zzc = 0;

    static {
        int i4 = zzafk.zza;
        zzd = new zzafx(null);
        zza = new zzafq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(int i4, int i5, int i6) {
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

    public static zzafy zzn(byte[] bArr, int i4, int i5) {
        zzl(i4, i4 + i5, bArr.length);
        byte[] bArr2 = new byte[i5];
        System.arraycopy(bArr, i4, bArr2, 0, i5);
        return new zzafv(bArr2);
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
        return new zzafp(this);
    }

    public final String toString() {
        String concat;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        if (zzd() <= 50) {
            concat = zzajj.zza(this);
        } else {
            concat = zzajj.zza(zzg(0, 47)).concat("...");
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

    public abstract zzafy zzg(int i4, int i5);

    public abstract zzage zzh();

    protected abstract String zzi(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzj(zzafo zzafoVar) throws IOException;

    public abstract boolean zzk();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzm() {
        return this.zzc;
    }

    public final String zzo(Charset charset) {
        if (zzd() == 0) {
            return "";
        }
        return zzi(charset);
    }

    public final boolean zzp() {
        if (zzd() == 0) {
            return true;
        }
        return false;
    }

    public final byte[] zzq() {
        int zzd2 = zzd();
        if (zzd2 == 0) {
            return zzahj.zzd;
        }
        byte[] bArr = new byte[zzd2];
        zze(bArr, 0, 0, zzd2);
        return bArr;
    }
}
