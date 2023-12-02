package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzgvp implements Iterator, Closeable, zzamx {
    private static final zzamw zza = new zzgvo("eof ");
    private static final zzgvw zzb = zzgvw.zzb(zzgvp.class);
    protected zzamt zzc;
    protected zzgvq zzd;
    zzamw zze = null;
    long zzf = 0;
    long zzg = 0;
    private final List zzh = new ArrayList();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zzamw zzamwVar = this.zze;
        if (zzamwVar == zza) {
            return false;
        }
        if (zzamwVar != null) {
            return true;
        }
        try {
            this.zze = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zze = zza;
            return false;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i4 = 0; i4 < this.zzh.size(); i4++) {
            if (i4 > 0) {
                sb.append(";");
            }
            sb.append(((zzamw) this.zzh.get(i4)).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.Iterator
    /* renamed from: zzd */
    public final zzamw next() {
        zzamw zzb2;
        zzamw zzamwVar = this.zze;
        if (zzamwVar != null && zzamwVar != zza) {
            this.zze = null;
            return zzamwVar;
        }
        zzgvq zzgvqVar = this.zzd;
        if (zzgvqVar != null && this.zzf < this.zzg) {
            try {
                synchronized (zzgvqVar) {
                    this.zzd.zze(this.zzf);
                    zzb2 = this.zzc.zzb(this.zzd, this);
                    this.zzf = this.zzd.zzb();
                }
                return zzb2;
            } catch (EOFException unused) {
                throw new NoSuchElementException();
            } catch (IOException unused2) {
                throw new NoSuchElementException();
            }
        }
        this.zze = zza;
        throw new NoSuchElementException();
    }

    public final List zze() {
        if (this.zzd != null && this.zze != zza) {
            return new zzgvv(this.zzh, this);
        }
        return this.zzh;
    }

    public final void zzf(zzgvq zzgvqVar, long j4, zzamt zzamtVar) throws IOException {
        this.zzd = zzgvqVar;
        this.zzf = zzgvqVar.zzb();
        zzgvqVar.zze(zzgvqVar.zzb() + j4);
        this.zzg = zzgvqVar.zzb();
        this.zzc = zzamtVar;
    }

    public void close() throws IOException {
    }
}
