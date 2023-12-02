package com.google.android.gms.common.moduleinstall;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@SafeParcelable.Class(creator = "ModuleInstallIntentResponseCreator")
/* loaded from: classes4.dex */
public class ModuleInstallIntentResponse extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ModuleInstallIntentResponse> CREATOR = new zab();
    @Nullable
    @SafeParcelable.Field(getter = "getPendingIntent", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final PendingIntent f20601a;

    @SafeParcelable.Constructor
    @KeepForSdk
    public ModuleInstallIntentResponse(@Nullable @SafeParcelable.Param(id = 1) PendingIntent pendingIntent) {
        this.f20601a = pendingIntent;
    }

    @Nullable
    public PendingIntent getPendingIntent() {
        return this.f20601a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getPendingIntent(), i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
