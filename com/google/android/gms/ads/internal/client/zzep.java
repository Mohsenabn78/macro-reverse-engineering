package com.google.android.gms.ads.internal.client;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbeo;
import com.google.android.gms.internal.ads.zzbfl;
import com.google.android.gms.internal.ads.zzbzr;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzep implements MediaContent {

    /* renamed from: a  reason: collision with root package name */
    private final zzbeo f19186a;

    /* renamed from: b  reason: collision with root package name */
    private final VideoController f19187b = new VideoController();
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final zzbfl f19188c;

    public zzep(zzbeo zzbeoVar, @Nullable zzbfl zzbflVar) {
        this.f19186a = zzbeoVar;
        this.f19188c = zzbflVar;
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final float getAspectRatio() {
        try {
            return this.f19186a.zze();
        } catch (RemoteException e4) {
            zzbzr.zzh("", e4);
            return 0.0f;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final float getCurrentTime() {
        try {
            return this.f19186a.zzf();
        } catch (RemoteException e4) {
            zzbzr.zzh("", e4);
            return 0.0f;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final float getDuration() {
        try {
            return this.f19186a.zzg();
        } catch (RemoteException e4) {
            zzbzr.zzh("", e4);
            return 0.0f;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    @Nullable
    public final Drawable getMainImage() {
        try {
            IObjectWrapper zzi = this.f19186a.zzi();
            if (zzi != null) {
                return (Drawable) ObjectWrapper.unwrap(zzi);
            }
            return null;
        } catch (RemoteException e4) {
            zzbzr.zzh("", e4);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final VideoController getVideoController() {
        try {
            if (this.f19186a.zzh() != null) {
                this.f19187b.zzb(this.f19186a.zzh());
            }
        } catch (RemoteException e4) {
            zzbzr.zzh("Exception occurred while getting video controller", e4);
        }
        return this.f19187b;
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final boolean hasVideoContent() {
        try {
            return this.f19186a.zzl();
        } catch (RemoteException e4) {
            zzbzr.zzh("", e4);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final void setMainImage(@Nullable Drawable drawable) {
        try {
            this.f19186a.zzj(ObjectWrapper.wrap(drawable));
        } catch (RemoteException e4) {
            zzbzr.zzh("", e4);
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    @Nullable
    public final zzbfl zza() {
        return this.f19188c;
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final boolean zzb() {
        try {
            return this.f19186a.zzk();
        } catch (RemoteException e4) {
            zzbzr.zzh("", e4);
            return false;
        }
    }

    public final zzbeo zzc() {
        return this.f19186a;
    }
}
