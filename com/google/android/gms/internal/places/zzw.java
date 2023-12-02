package com.google.android.gms.internal.places;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes4.dex */
public abstract class zzw implements Serializable, Iterable<Byte> {
    public static final zzw zzeg = new zzag(zzbd.zziz);
    private static final zzac zzeh;
    private static final Comparator<zzw> zzej;
    private int zzei = 0;

    static {
        zzac zzaaVar;
        if (zzp.zzy()) {
            zzaaVar = new zzaf(null);
        } else {
            zzaaVar = new zzaa(null);
        }
        zzeh = zzaaVar;
        zzej = new zzy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzb(byte b4) {
        return b4 & 255;
    }

    public static zzw zzc(byte[] bArr, int i4, int i5) {
        zzc(i4, i4 + i5, bArr.length);
        return new zzag(zzeh.zzd(bArr, i4, i5));
    }

    public static zzw zzi(String str) {
        return new zzag(str.getBytes(zzbd.UTF_8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzae zzk(int i4) {
        return new zzae(i4, null);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i4 = this.zzei;
        if (i4 == 0) {
            int size = size();
            i4 = zzb(size, 0, size);
            if (i4 == 0) {
                i4 = 1;
            }
            this.zzei = i4;
        }
        return i4;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzv(this);
    }

    public abstract int size();

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return zzbd.zziz;
        }
        byte[] bArr = new byte[size];
        zzb(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public final String zzad() {
        Charset charset = zzbd.UTF_8;
        if (size() == 0) {
            return "";
        }
        return zzb(charset);
    }

    public abstract boolean zzae();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzaf() {
        return this.zzei;
    }

    protected abstract int zzb(int i4, int i5, int i6);

    public abstract zzw zzb(int i4, int i5);

    protected abstract String zzb(Charset charset);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(zzt zztVar) throws IOException;

    protected abstract void zzb(byte[] bArr, int i4, int i5, int i6);

    public abstract byte zzi(int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte zzj(int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i4, int i5, int i6) {
        int i7 = i5 - i4;
        if ((i4 | i5 | i7 | (i6 - i5)) < 0) {
            if (i4 < 0) {
                StringBuilder sb = new StringBuilder(32);
                sb.append("Beginning index: ");
                sb.append(i4);
                sb.append(" < 0");
                throw new IndexOutOfBoundsException(sb.toString());
            } else if (i5 < i4) {
                StringBuilder sb2 = new StringBuilder(66);
                sb2.append("Beginning index larger than ending index: ");
                sb2.append(i4);
                sb2.append(", ");
                sb2.append(i5);
                throw new IndexOutOfBoundsException(sb2.toString());
            } else {
                StringBuilder sb3 = new StringBuilder(37);
                sb3.append("End index: ");
                sb3.append(i5);
                sb3.append(" >= ");
                sb3.append(i6);
                throw new IndexOutOfBoundsException(sb3.toString());
            }
        }
        return i7;
    }
}
