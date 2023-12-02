package com.google.android.gms.ads.nativead;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbfl;
import com.google.android.gms.internal.ads.zzbzr;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public class MediaView extends FrameLayout {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private MediaContent f19470a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f19471b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView.ScaleType f19472c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f19473d;

    /* renamed from: e  reason: collision with root package name */
    private zzb f19474e;

    /* renamed from: f  reason: collision with root package name */
    private zzc f19475f;

    public MediaView(@NonNull Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void a(zzb zzbVar) {
        this.f19474e = zzbVar;
        if (this.f19471b) {
            zzbVar.zza.b(this.f19470a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void b(zzc zzcVar) {
        this.f19475f = zzcVar;
        if (this.f19473d) {
            zzcVar.zza.c(this.f19472c);
        }
    }

    @Nullable
    public MediaContent getMediaContent() {
        return this.f19470a;
    }

    public void setImageScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.f19473d = true;
        this.f19472c = scaleType;
        zzc zzcVar = this.f19475f;
        if (zzcVar != null) {
            zzcVar.zza.c(scaleType);
        }
    }

    public void setMediaContent(@Nullable MediaContent mediaContent) {
        boolean zzr;
        this.f19471b = true;
        this.f19470a = mediaContent;
        zzb zzbVar = this.f19474e;
        if (zzbVar != null) {
            zzbVar.zza.b(mediaContent);
        }
        if (mediaContent == null) {
            return;
        }
        try {
            zzbfl zza = mediaContent.zza();
            if (zza != null) {
                if (mediaContent.hasVideoContent()) {
                    zzr = zza.zzs(ObjectWrapper.wrap(this));
                } else {
                    if (mediaContent.zzb()) {
                        zzr = zza.zzr(ObjectWrapper.wrap(this));
                    }
                    removeAllViews();
                }
                if (zzr) {
                    return;
                }
                removeAllViews();
            }
        } catch (RemoteException e4) {
            removeAllViews();
            zzbzr.zzh("", e4);
        }
    }

    public MediaView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    @TargetApi(21)
    public MediaView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }
}
