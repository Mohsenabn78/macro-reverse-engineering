package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public interface zzoz {
    int zza(zzam zzamVar);

    long zzb(boolean z3);

    zzch zzc();

    zzoh zzd(zzam zzamVar);

    void zze(zzam zzamVar, int i4, @Nullable int[] iArr) throws zzou;

    void zzf();

    void zzg();

    void zzh();

    void zzi();

    void zzj() throws zzoy;

    void zzk();

    void zzl(zzk zzkVar);

    void zzm(int i4);

    void zzn(zzl zzlVar);

    void zzo(zzow zzowVar);

    void zzp(zzch zzchVar);

    void zzq(@Nullable zzoc zzocVar);

    @RequiresApi(23)
    void zzr(@Nullable AudioDeviceInfo audioDeviceInfo);

    void zzs(boolean z3);

    void zzt(float f4);

    boolean zzu(ByteBuffer byteBuffer, long j4, int i4) throws zzov, zzoy;

    boolean zzv();

    boolean zzw();

    boolean zzx(zzam zzamVar);
}
