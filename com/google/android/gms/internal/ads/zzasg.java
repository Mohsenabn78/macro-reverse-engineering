package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzasg extends zzath {
    private static final zzati zzi = new zzati();
    private final Context zzj;

    public zzasg(zzart zzartVar, String str, String str2, zzanq zzanqVar, int i4, int i5, Context context) {
        super(zzartVar, "x244HDzWeCJXpaVmJz6ZDJ8SomiOjqvEXNm93LF/UprnziaRy0GWl7kRtW31unI7", "QfNmx51vMYu7RTw3f+TZAS23f16Jqr3kM4ALSpqOw0Y=", zzanqVar, i4, 29);
        this.zzj = context;
    }

    @Override // com.google.android.gms.internal.ads.zzath
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzn(ExifInterface.LONGITUDE_EAST);
        AtomicReference zza = zzi.zza(this.zzj.getPackageName());
        if (zza.get() == null) {
            synchronized (zza) {
                if (zza.get() == null) {
                    zza.set((String) this.zzf.invoke(null, this.zzj));
                }
            }
        }
        String str = (String) zza.get();
        synchronized (this.zze) {
            this.zze.zzn(zzapd.zza(str.getBytes(), true));
        }
    }
}
