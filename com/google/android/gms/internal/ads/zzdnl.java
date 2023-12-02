package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdnl extends FrameLayout {
    private final com.google.android.gms.ads.internal.util.zzas zza;

    public zzdnl(Context context, @NonNull View view, @NonNull com.google.android.gms.ads.internal.util.zzas zzasVar) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(view);
        this.zza = zzasVar;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.zza.zzm(motionEvent);
        return false;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if (childAt != null && (childAt instanceof zzcez)) {
                arrayList.add((zzcez) childAt);
            }
        }
        super.removeAllViews();
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((zzcez) arrayList.get(i5)).destroy();
        }
    }
}
