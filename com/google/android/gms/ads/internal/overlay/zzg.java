package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.util.zzas;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
final class zzg extends RelativeLayout {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    final zzas f19218a;
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    boolean f19219b;

    public zzg(Context context, String str, String str2, String str3) {
        super(context);
        zzas zzasVar = new zzas(context, str);
        this.f19218a = zzasVar;
        zzasVar.zzo(str2);
        zzasVar.zzn(str3);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f19219b) {
            this.f19218a.zzm(motionEvent);
            return false;
        }
        return false;
    }
}
