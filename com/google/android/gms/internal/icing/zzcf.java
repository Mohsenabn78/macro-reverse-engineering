package com.google.android.gms.internal.icing;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public abstract class zzcf implements Iterable<Byte>, Serializable {
    public static final zzcf zzb = new zzcd(zzdh.zzc);
    private static final Comparator<zzcf> zzc;
    private static final zzce zzd;
    private int zza = 0;

    static {
        int i4 = zzbu.zza;
        zzd = new zzce(null);
        zzc = new zzby();
    }

    public static zzcf zzj(String str) {
        return new zzcd(str.getBytes(zzdh.zza));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(int i4, int i5, int i6) {
        if (((i6 - i5) | i5) >= 0) {
            return i5;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("End index: ");
        sb.append(i5);
        sb.append(" >= ");
        sb.append(i6);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i4 = this.zza;
        if (i4 == 0) {
            int zzc2 = zzc();
            i4 = zzi(zzc2, 0, zzc2);
            if (i4 == 0) {
                i4 = 1;
            }
            this.zza = i4;
        }
        return i4;
    }

    @Override // java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return new zzbx(this);
    }

    public final String toString() {
        String concat;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzc());
        if (zzc() <= 50) {
            concat = zzfb.zza(this);
        } else {
            concat = String.valueOf(zzfb.zza(zze(0, 47))).concat("...");
        }
        objArr[2] = concat;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte zzb(int i4);

    public abstract int zzc();

    public abstract zzcf zze(int i4, int i5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzf(zzbw zzbwVar) throws IOException;

    protected abstract String zzg(Charset charset);

    public abstract boolean zzh();

    protected abstract int zzi(int i4, int i5, int i6);

    public final String zzk(Charset charset) {
        if (zzc() == 0) {
            return "";
        }
        return zzg(charset);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int zzl() {
        return this.zza;
    }
}
