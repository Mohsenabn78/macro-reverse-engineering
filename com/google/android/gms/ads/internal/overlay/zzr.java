package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzbzr;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzr extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final ImageButton f19243a;

    /* renamed from: b  reason: collision with root package name */
    private final zzad f19244b;

    public zzr(Context context, zzq zzqVar, @Nullable zzad zzadVar) {
        super(context);
        zzp zzpVar;
        this.f19244b = zzadVar;
        setOnClickListener(this);
        ImageButton imageButton = new ImageButton(context);
        this.f19243a = imageButton;
        b();
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(this);
        zzay.zzb();
        int zzx = zzbzk.zzx(context, zzqVar.zza);
        zzay.zzb();
        int zzx2 = zzbzk.zzx(context, 0);
        zzay.zzb();
        int zzx3 = zzbzk.zzx(context, zzqVar.zzb);
        zzay.zzb();
        imageButton.setPadding(zzx, zzx2, zzx3, zzbzk.zzx(context, zzqVar.zzc));
        imageButton.setContentDescription("Interstitial close button");
        zzay.zzb();
        int zzx4 = zzbzk.zzx(context, zzqVar.zzd + zzqVar.zza + zzqVar.zzb);
        zzay.zzb();
        addView(imageButton, new FrameLayout.LayoutParams(zzx4, zzbzk.zzx(context, zzqVar.zzd + zzqVar.zzc), 17));
        long longValue = ((Long) zzba.zzc().zzb(zzbbm.zzaZ)).longValue();
        if (longValue <= 0) {
            return;
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzba)).booleanValue()) {
            zzpVar = new zzp(this);
        } else {
            zzpVar = null;
        }
        imageButton.setAlpha(0.0f);
        imageButton.animate().alpha(1.0f).setDuration(longValue).setListener(zzpVar);
    }

    private final void b() {
        String str = (String) zzba.zzc().zzb(zzbbm.zzaY);
        if (PlatformVersion.isAtLeastLollipop() && !TextUtils.isEmpty(str) && !"default".equals(str)) {
            Resources zzd = com.google.android.gms.ads.internal.zzt.zzo().zzd();
            if (zzd != null) {
                Drawable drawable = null;
                try {
                    if ("white".equals(str)) {
                        drawable = zzd.getDrawable(R.drawable.admob_close_button_white_circle_black_cross);
                    } else if ("black".equals(str)) {
                        drawable = zzd.getDrawable(R.drawable.admob_close_button_black_circle_white_cross);
                    }
                } catch (Resources.NotFoundException unused) {
                    zzbzr.zze("Close button resource not found, falling back to default.");
                }
                if (drawable == null) {
                    this.f19243a.setImageResource(17301527);
                    return;
                }
                this.f19243a.setImageDrawable(drawable);
                this.f19243a.setScaleType(ImageView.ScaleType.CENTER);
                return;
            }
            this.f19243a.setImageResource(17301527);
            return;
        }
        this.f19243a.setImageResource(17301527);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        zzad zzadVar = this.f19244b;
        if (zzadVar != null) {
            zzadVar.zzj();
        }
    }

    public final void zzb(boolean z3) {
        if (z3) {
            this.f19243a.setVisibility(8);
            if (((Long) zzba.zzc().zzb(zzbbm.zzaZ)).longValue() > 0) {
                this.f19243a.animate().cancel();
                this.f19243a.clearAnimation();
                return;
            }
            return;
        }
        this.f19243a.setVisibility(0);
    }
}
