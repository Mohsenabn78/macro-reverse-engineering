package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdia {
    static final ImageView.ScaleType zza = ImageView.ScaleType.CENTER_INSIDE;
    private final com.google.android.gms.ads.internal.util.zzg zzb;
    private final zzfai zzc;
    private final zzdhf zzd;
    private final zzdha zze;
    @Nullable
    private final zzdim zzf;
    @Nullable
    private final zzdiu zzg;
    private final Executor zzh;
    private final Executor zzi;
    private final zzbef zzj;
    private final zzdgx zzk;

    public zzdia(com.google.android.gms.ads.internal.util.zzg zzgVar, zzfai zzfaiVar, zzdhf zzdhfVar, zzdha zzdhaVar, @Nullable zzdim zzdimVar, @Nullable zzdiu zzdiuVar, Executor executor, Executor executor2, zzdgx zzdgxVar) {
        this.zzb = zzgVar;
        this.zzc = zzfaiVar;
        this.zzj = zzfaiVar.zzi;
        this.zzd = zzdhfVar;
        this.zze = zzdhaVar;
        this.zzf = zzdimVar;
        this.zzg = zzdiuVar;
        this.zzh = executor;
        this.zzi = executor2;
        this.zzk = zzdgxVar;
    }

    private static void zzh(RelativeLayout.LayoutParams layoutParams, int i4) {
        if (i4 != 0) {
            if (i4 != 2) {
                if (i4 != 3) {
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    return;
                }
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                return;
            }
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            return;
        }
        layoutParams.addRule(10);
        layoutParams.addRule(9);
    }

    private final boolean zzi(@NonNull ViewGroup viewGroup, boolean z3) {
        View zzg;
        FrameLayout.LayoutParams layoutParams;
        if (z3) {
            zzg = this.zze.zzf();
        } else {
            zzg = this.zze.zzg();
        }
        if (zzg == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (zzg.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzg.getParent()).removeView(zzg);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdA)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(zzg, layoutParams);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(ViewGroup viewGroup) {
        boolean z3;
        zzdha zzdhaVar = this.zze;
        if (zzdhaVar.zzf() != null) {
            if (viewGroup != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (zzdhaVar.zzc() != 2 && zzdhaVar.zzc() != 1) {
                if (zzdhaVar.zzc() == 6) {
                    this.zzb.zzI(this.zzc.zzf, ExifInterface.GPS_MEASUREMENT_2D, z3);
                    this.zzb.zzI(this.zzc.zzf, "1", z3);
                    return;
                }
                return;
            }
            this.zzb.zzI(this.zzc.zzf, String.valueOf(zzdhaVar.zzc()), z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzdiw zzdiwVar) {
        ViewGroup viewGroup;
        View view;
        final ViewGroup viewGroup2;
        zzbeo zza2;
        Drawable drawable;
        Context context = null;
        if (this.zzd.zzf() || this.zzd.zze()) {
            String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, "3011"};
            for (int i4 = 0; i4 < 2; i4++) {
                View zzg = zzdiwVar.zzg(strArr[i4]);
                if (zzg != null && (zzg instanceof ViewGroup)) {
                    viewGroup = (ViewGroup) zzg;
                    break;
                }
            }
        }
        viewGroup = null;
        Context context2 = zzdiwVar.zzf().getContext();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        zzdha zzdhaVar = this.zze;
        if (zzdhaVar.zze() != null) {
            view = zzdhaVar.zze();
            zzbef zzbefVar = this.zzj;
            if (zzbefVar != null && viewGroup == null) {
                zzh(layoutParams, zzbefVar.zze);
                view.setLayoutParams(layoutParams);
            }
        } else if (!(zzdhaVar.zzl() instanceof zzbea)) {
            view = null;
        } else {
            zzbea zzbeaVar = (zzbea) zzdhaVar.zzl();
            if (viewGroup == null) {
                zzh(layoutParams, zzbeaVar.zzc());
            }
            View zzbebVar = new zzbeb(context2, zzbeaVar, layoutParams);
            zzbebVar.setContentDescription((CharSequence) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdy));
            view = zzbebVar;
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(view);
            } else {
                com.google.android.gms.ads.formats.zza zzaVar = new com.google.android.gms.ads.formats.zza(zzdiwVar.zzf().getContext());
                zzaVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                zzaVar.addView(view);
                FrameLayout zzh = zzdiwVar.zzh();
                if (zzh != null) {
                    zzh.addView(zzaVar);
                }
            }
            zzdiwVar.zzq(zzdiwVar.zzk(), view, true);
        }
        zzfsc zzfscVar = zzdhw.zza;
        int size = zzfscVar.size();
        int i5 = 0;
        while (true) {
            if (i5 < size) {
                View zzg2 = zzdiwVar.zzg((String) zzfscVar.get(i5));
                i5++;
                if (zzg2 instanceof ViewGroup) {
                    viewGroup2 = (ViewGroup) zzg2;
                    break;
                }
            } else {
                viewGroup2 = null;
                break;
            }
        }
        this.zzi.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdhx
            @Override // java.lang.Runnable
            public final void run() {
                zzdia.this.zza(viewGroup2);
            }
        });
        if (viewGroup2 != null) {
            if (zzi(viewGroup2, true)) {
                zzdha zzdhaVar2 = this.zze;
                if (zzdhaVar2.zzr() != null) {
                    zzdhaVar2.zzr().zzao(new zzdhz(zzdiwVar, viewGroup2));
                }
            } else if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjg)).booleanValue() && zzi(viewGroup2, false)) {
                zzdha zzdhaVar3 = this.zze;
                if (zzdhaVar3.zzp() != null) {
                    zzdhaVar3.zzp().zzao(new zzdhz(zzdiwVar, viewGroup2));
                }
            } else {
                viewGroup2.removeAllViews();
                View zzf = zzdiwVar.zzf();
                if (zzf != null) {
                    context = zzf.getContext();
                }
                if (context != null && (zza2 = this.zzk.zza()) != null) {
                    try {
                        IObjectWrapper zzi = zza2.zzi();
                        if (zzi != null && (drawable = (Drawable) ObjectWrapper.unwrap(zzi)) != null) {
                            ImageView imageView = new ImageView(context);
                            imageView.setImageDrawable(drawable);
                            IObjectWrapper zzj = zzdiwVar.zzj();
                            if (zzj != null) {
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfV)).booleanValue()) {
                                    imageView.setScaleType((ImageView.ScaleType) ObjectWrapper.unwrap(zzj));
                                    imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                                    viewGroup2.addView(imageView);
                                }
                            }
                            imageView.setScaleType(zza);
                            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                            viewGroup2.addView(imageView);
                        }
                    } catch (RemoteException unused) {
                        zzbzr.zzj("Could not get main image drawable");
                    }
                }
            }
        }
    }

    public final void zzc(@Nullable zzdiw zzdiwVar) {
        if (zzdiwVar == null || this.zzf == null || zzdiwVar.zzh() == null || !this.zzd.zzg()) {
            return;
        }
        try {
            zzdiwVar.zzh().addView(this.zzf.zza());
        } catch (zzcfk e4) {
            com.google.android.gms.ads.internal.util.zze.zzb("web view can not be obtained", e4);
        }
    }

    public final void zzd(@Nullable zzdiw zzdiwVar) {
        if (zzdiwVar == null) {
            return;
        }
        Context context = zzdiwVar.zzf().getContext();
        if (!com.google.android.gms.ads.internal.util.zzbx.zzh(context, this.zzd.zza)) {
            return;
        }
        if (!(context instanceof Activity)) {
            zzbzr.zze("Activity context is needed for policy validator.");
        } else if (this.zzg != null && zzdiwVar.zzh() != null) {
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                windowManager.addView(this.zzg.zza(zzdiwVar.zzh(), windowManager), com.google.android.gms.ads.internal.util.zzbx.zzb());
            } catch (zzcfk e4) {
                com.google.android.gms.ads.internal.util.zze.zzb("web view can not be obtained", e4);
            }
        }
    }

    public final void zze(final zzdiw zzdiwVar) {
        this.zzh.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdhy
            @Override // java.lang.Runnable
            public final void run() {
                zzdia.this.zzb(zzdiwVar);
            }
        });
    }

    public final boolean zzf(@NonNull ViewGroup viewGroup) {
        return zzi(viewGroup, false);
    }

    public final boolean zzg(@NonNull ViewGroup viewGroup) {
        return zzi(viewGroup, true);
    }
}
