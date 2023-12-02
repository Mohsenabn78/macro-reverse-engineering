package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzfj;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzbgh;
import com.google.android.gms.internal.ads.zzbgi;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@SafeParcelable.Class(creator = "AdManagerAdViewOptionsCreator")
/* loaded from: classes4.dex */
public final class AdManagerAdViewOptions extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<AdManagerAdViewOptions> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getManualImpressionsEnabled", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final boolean f19001a;
    @Nullable
    @SafeParcelable.Field(getter = "getDelayedBannerAdListenerBinder", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final IBinder f19002b;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f19003a = false;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private ShouldDelayBannerRenderingListener f19004b;

        @NonNull
        public AdManagerAdViewOptions build() {
            return new AdManagerAdViewOptions(this, (zzb) null);
        }

        @NonNull
        public Builder setManualImpressionsEnabled(boolean z3) {
            this.f19003a = z3;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder setShouldDelayBannerRenderingListener(@NonNull ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
            this.f19004b = shouldDelayBannerRenderingListener;
            return this;
        }
    }

    /* synthetic */ AdManagerAdViewOptions(Builder builder, zzb zzbVar) {
        this.f19001a = builder.f19003a;
        this.f19002b = builder.f19004b != null ? new zzfj(builder.f19004b) : null;
    }

    public boolean getManualImpressionsEnabled() {
        return this.f19001a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getManualImpressionsEnabled());
        SafeParcelWriter.writeIBinder(parcel, 2, this.f19002b, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final zzbgi zza() {
        IBinder iBinder = this.f19002b;
        if (iBinder == null) {
            return null;
        }
        return zzbgh.zzc(iBinder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AdManagerAdViewOptions(@SafeParcelable.Param(id = 1) boolean z3, @Nullable @SafeParcelable.Param(id = 2) IBinder iBinder) {
        this.f19001a = z3;
        this.f19002b = iBinder;
    }
}
