package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdjk {
    private final com.google.android.gms.ads.internal.util.zzbo zza;
    private final Clock zzb;
    private final Executor zzc;

    public zzdjk(com.google.android.gms.ads.internal.util.zzbo zzboVar, Clock clock, Executor executor) {
        this.zza = zzboVar;
        this.zzb = clock;
        this.zzc = executor;
    }

    private final Bitmap zzc(byte[] bArr, BitmapFactory.Options options) {
        long elapsedRealtime = this.zzb.elapsedRealtime();
        boolean z3 = false;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        long elapsedRealtime2 = this.zzb.elapsedRealtime();
        if (decodeByteArray != null) {
            long j4 = elapsedRealtime2 - elapsedRealtime;
            int width = decodeByteArray.getWidth();
            int height = decodeByteArray.getHeight();
            int allocationByteCount = decodeByteArray.getAllocationByteCount();
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                z3 = true;
            }
            com.google.android.gms.ads.internal.util.zze.zza("Decoded image w: " + width + " h:" + height + " bytes: " + allocationByteCount + " time: " + j4 + " on ui thread: " + z3);
        }
        return decodeByteArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Bitmap zza(double d4, boolean z3, zzalg zzalgVar) {
        byte[] bArr = zzalgVar.zzb;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = (int) (d4 * 160.0d);
        if (!z3) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfT)).booleanValue()) {
            options.inJustDecodeBounds = true;
            zzc(bArr, options);
            options.inJustDecodeBounds = false;
            int i4 = options.outWidth * options.outHeight;
            if (i4 > 0) {
                options.inSampleSize = 1 << ((33 - Integer.numberOfLeadingZeros((i4 - 1) / ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfU)).intValue())) / 2);
            }
        }
        return zzc(bArr, options);
    }

    public final zzfwm zzb(String str, final double d4, final boolean z3) {
        return zzfwc.zzl(this.zza.zza(str), new zzfov() { // from class: com.google.android.gms.internal.ads.zzdjj
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj) {
                return zzdjk.this.zza(d4, z3, (zzalg) obj);
            }
        }, this.zzc);
    }
}
