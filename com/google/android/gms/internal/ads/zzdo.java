package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdo {
    private final zzfsc zza;
    private final List zzb = new ArrayList();
    private ByteBuffer[] zzc = new ByteBuffer[0];
    private zzdp zzd;
    private zzdp zze;
    private boolean zzf;

    public zzdo(zzfsc zzfscVar) {
        this.zza = zzfscVar;
        zzdp zzdpVar = zzdp.zza;
        this.zzd = zzdpVar;
        this.zze = zzdpVar;
        this.zzf = false;
    }

    private final int zzi() {
        return this.zzc.length - 1;
    }

    private final void zzj(ByteBuffer byteBuffer) {
        boolean z3;
        ByteBuffer byteBuffer2;
        do {
            z3 = false;
            for (int i4 = 0; i4 <= zzi(); i4++) {
                if (!this.zzc[i4].hasRemaining()) {
                    zzdr zzdrVar = (zzdr) this.zzb.get(i4);
                    if (zzdrVar.zzh()) {
                        if (!this.zzc[i4].hasRemaining() && i4 < zzi()) {
                            ((zzdr) this.zzb.get(i4 + 1)).zzd();
                        }
                    } else {
                        if (i4 > 0) {
                            byteBuffer2 = this.zzc[i4 - 1];
                        } else if (byteBuffer.hasRemaining()) {
                            byteBuffer2 = byteBuffer;
                        } else {
                            byteBuffer2 = zzdr.zza;
                        }
                        zzdrVar.zze(byteBuffer2);
                        this.zzc[i4] = zzdrVar.zzb();
                        boolean z4 = true;
                        if (byteBuffer2.remaining() - byteBuffer2.remaining() <= 0 && !this.zzc[i4].hasRemaining()) {
                            z4 = false;
                        }
                        z3 |= z4;
                    }
                }
            }
        } while (z3);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdo)) {
            return false;
        }
        zzdo zzdoVar = (zzdo) obj;
        if (this.zza.size() != zzdoVar.zza.size()) {
            return false;
        }
        for (int i4 = 0; i4 < this.zza.size(); i4++) {
            if (this.zza.get(i4) != zzdoVar.zza.get(i4)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final zzdp zza(zzdp zzdpVar) throws zzdq {
        if (!zzdpVar.equals(zzdp.zza)) {
            for (int i4 = 0; i4 < this.zza.size(); i4++) {
                zzdr zzdrVar = (zzdr) this.zza.get(i4);
                zzdp zza = zzdrVar.zza(zzdpVar);
                if (zzdrVar.zzg()) {
                    zzdy.zzf(!zza.equals(zzdp.zza));
                    zzdpVar = zza;
                }
            }
            this.zze = zzdpVar;
            return zzdpVar;
        }
        throw new zzdq("Unhandled input format:", zzdpVar);
    }

    public final ByteBuffer zzb() {
        if (!zzh()) {
            return zzdr.zza;
        }
        ByteBuffer byteBuffer = this.zzc[zzi()];
        if (!byteBuffer.hasRemaining()) {
            zzj(zzdr.zza);
        }
        return byteBuffer;
    }

    public final void zzc() {
        this.zzb.clear();
        this.zzd = this.zze;
        this.zzf = false;
        for (int i4 = 0; i4 < this.zza.size(); i4++) {
            zzdr zzdrVar = (zzdr) this.zza.get(i4);
            zzdrVar.zzc();
            if (zzdrVar.zzg()) {
                this.zzb.add(zzdrVar);
            }
        }
        this.zzc = new ByteBuffer[this.zzb.size()];
        for (int i5 = 0; i5 <= zzi(); i5++) {
            this.zzc[i5] = ((zzdr) this.zzb.get(i5)).zzb();
        }
    }

    public final void zzd() {
        if (zzh() && !this.zzf) {
            this.zzf = true;
            ((zzdr) this.zzb.get(0)).zzd();
        }
    }

    public final void zze(ByteBuffer byteBuffer) {
        if (zzh() && !this.zzf) {
            zzj(byteBuffer);
        }
    }

    public final void zzf() {
        for (int i4 = 0; i4 < this.zza.size(); i4++) {
            zzdr zzdrVar = (zzdr) this.zza.get(i4);
            zzdrVar.zzc();
            zzdrVar.zzf();
        }
        this.zzc = new ByteBuffer[0];
        zzdp zzdpVar = zzdp.zza;
        this.zzd = zzdpVar;
        this.zze = zzdpVar;
        this.zzf = false;
    }

    public final boolean zzg() {
        if (this.zzf && ((zzdr) this.zzb.get(zzi())).zzh() && !this.zzc[zzi()].hasRemaining()) {
            return true;
        }
        return false;
    }

    public final boolean zzh() {
        if (!this.zzb.isEmpty()) {
            return true;
        }
        return false;
    }
}
