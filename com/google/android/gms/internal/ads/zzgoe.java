package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import org.slf4j.Marker;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzgoe implements Iterable, Serializable {
    private static final Comparator zza;
    public static final zzgoe zzb = new zzgoa(zzgpw.zzd);
    private static final zzgod zzd;
    private int zzc = 0;

    static {
        int i4 = zzgnp.zza;
        zzd = new zzgod(null);
        zza = new zzgnv();
    }

    private static zzgoe zzc(Iterator it, int i4) {
        if (i4 > 0) {
            if (i4 == 1) {
                return (zzgoe) it.next();
            }
            int i5 = i4 >>> 1;
            zzgoe zzc = zzc(it, i5);
            zzgoe zzc2 = zzc(it, i4 - i5);
            if (Integer.MAX_VALUE - zzc.zzd() >= zzc2.zzd()) {
                return zzgro.zzC(zzc, zzc2);
            }
            int zzd2 = zzc.zzd();
            int zzd3 = zzc2.zzd();
            throw new IllegalArgumentException("ByteString would be too long: " + zzd2 + Marker.ANY_NON_NULL_MARKER + zzd3);
        }
        throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i4)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzq(int i4, int i5, int i6) {
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

    public static zzgob zzt() {
        return new zzgob(128);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzgoe zzu(Iterable iterable) {
        int size;
        if (!(iterable instanceof Collection)) {
            Iterator it = iterable.iterator();
            size = 0;
            while (it.hasNext()) {
                it.next();
                size++;
            }
        } else {
            size = iterable.size();
        }
        if (size == 0) {
            return zzb;
        }
        return zzc(iterable.iterator(), size);
    }

    public static zzgoe zzv(byte[] bArr, int i4, int i5) {
        zzq(i4, i4 + i5, bArr.length);
        byte[] bArr2 = new byte[i5];
        System.arraycopy(bArr, i4, bArr2, 0, i5);
        return new zzgoa(bArr2);
    }

    public static zzgoe zzw(String str) {
        return new zzgoa(str.getBytes(zzgpw.zzb));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzy(int i4, int i5) {
        if (((i5 - (i4 + 1)) | i4) < 0) {
            if (i4 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i4);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i4 + ", " + i5);
        }
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i4 = this.zzc;
        if (i4 == 0) {
            int zzd2 = zzd();
            i4 = zzi(zzd2, 0, zzd2);
            if (i4 == 0) {
                i4 = 1;
            }
            this.zzc = i4;
        }
        return i4;
    }

    public final String toString() {
        String concat;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        if (zzd() <= 50) {
            concat = zzgse.zza(this);
        } else {
            concat = zzgse.zza(zzk(0, 47)).concat("...");
        }
        objArr[2] = concat;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public final byte[] zzA() {
        int zzd2 = zzd();
        if (zzd2 == 0) {
            return zzgpw.zzd;
        }
        byte[] bArr = new byte[zzd2];
        zze(bArr, 0, 0, zzd2);
        return bArr;
    }

    public abstract byte zza(int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte zzb(int i4);

    public abstract int zzd();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void zze(byte[] bArr, int i4, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int zzf();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean zzh();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int zzi(int i4, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int zzj(int i4, int i5, int i6);

    public abstract zzgoe zzk(int i4, int i5);

    public abstract zzgom zzl();

    protected abstract String zzm(Charset charset);

    public abstract ByteBuffer zzn();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzo(zzgnt zzgntVar) throws IOException;

    public abstract boolean zzp();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzr() {
        return this.zzc;
    }

    @Override // java.lang.Iterable
    /* renamed from: zzs */
    public zzgny iterator() {
        return new zzgnu(this);
    }

    public final String zzx(Charset charset) {
        if (zzd() == 0) {
            return "";
        }
        return zzm(charset);
    }

    @Deprecated
    public final void zzz(byte[] bArr, int i4, int i5, int i6) {
        zzq(0, i6, zzd());
        zzq(i5, i5 + i6, bArr.length);
        if (i6 > 0) {
            zze(bArr, 0, i5, i6);
        }
    }
}
