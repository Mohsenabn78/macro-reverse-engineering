package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;
import androidx.annotation.RequiresApi;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@RequiresApi(17)
/* loaded from: classes4.dex */
public final class zzyx extends Surface {
    private static int zzb;
    private static boolean zzc;
    public final boolean zza;
    private final zzyv zzd;
    private boolean zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzyx(zzyv zzyvVar, SurfaceTexture surfaceTexture, boolean z3, zzyw zzywVar) {
        super(surfaceTexture);
        this.zzd = zzyvVar;
        this.zza = z3;
    }

    public static zzyx zza(Context context, boolean z3) {
        int i4 = 0;
        boolean z4 = true;
        if (z3 && !zzb(context)) {
            z4 = false;
        }
        zzdy.zzf(z4);
        zzyv zzyvVar = new zzyv();
        if (z3) {
            i4 = zzb;
        }
        return zzyvVar.zza(i4);
    }

    public static synchronized boolean zzb(Context context) {
        int i4;
        String eglQueryString;
        int i5;
        synchronized (zzyx.class) {
            if (!zzc) {
                int i6 = zzfj.zza;
                if (i6 >= 24 && ((i6 >= 26 || (!"samsung".equals(zzfj.zzc) && !"XT1650".equals(zzfj.zzd))) && ((i6 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains("EGL_EXT_protected_content")))) {
                    String eglQueryString2 = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                    i5 = 2;
                    if (eglQueryString2 != null && eglQueryString2.contains("EGL_KHR_surfaceless_context")) {
                        i5 = 1;
                    }
                    zzb = i5;
                    zzc = true;
                }
                i5 = 0;
                zzb = i5;
                zzc = true;
            }
            i4 = zzb;
        }
        if (i4 != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.zzd) {
            if (!this.zze) {
                this.zzd.zzb();
                this.zze = true;
            }
        }
    }
}
