package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzca;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzbgh;
import com.google.android.gms.internal.ads.zzbgi;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@SafeParcelable.Class(creator = "PublisherAdViewOptionsCreator")
@Deprecated
/* loaded from: classes4.dex */
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzf();
    @SafeParcelable.Field(getter = "getManualImpressionsEnabled", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final boolean f19021a;
    @Nullable
    @SafeParcelable.Field(getter = "getAppEventListenerBinder", id = 2, type = "android.os.IBinder")

    /* renamed from: b  reason: collision with root package name */
    private final zzcb f19022b;
    @Nullable
    @SafeParcelable.Field(getter = "getDelayedBannerAdListenerBinder", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final IBinder f19023c;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public static final class Builder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private ShouldDelayBannerRenderingListener f19024a;

        @NonNull
        @KeepForSdk
        public Builder setShouldDelayBannerRenderingListener(@NonNull ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
            this.f19024a = shouldDelayBannerRenderingListener;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public PublisherAdViewOptions(@SafeParcelable.Param(id = 1) boolean z3, @Nullable @SafeParcelable.Param(id = 2) IBinder iBinder, @Nullable @SafeParcelable.Param(id = 3) IBinder iBinder2) {
        zzcb zzcbVar;
        this.f19021a = z3;
        if (iBinder != null) {
            zzcbVar = zzca.zzd(iBinder);
        } else {
            zzcbVar = null;
        }
        this.f19022b = zzcbVar;
        this.f19023c = iBinder2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        IBinder asBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.f19021a);
        zzcb zzcbVar = this.f19022b;
        if (zzcbVar == null) {
            asBinder = null;
        } else {
            asBinder = zzcbVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 2, asBinder, false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.f19023c, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final zzcb zza() {
        return this.f19022b;
    }

    @Nullable
    public final zzbgi zzb() {
        IBinder iBinder = this.f19023c;
        if (iBinder == null) {
            return null;
        }
        return zzbgh.zzc(iBinder);
    }

    public final boolean zzc() {
        return this.f19021a;
    }
}
