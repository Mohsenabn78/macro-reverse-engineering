package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@SafeParcelable.Class(creator = "ModuleInstallResponseCreator")
/* loaded from: classes4.dex */
public class ModuleInstallResponse extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ModuleInstallResponse> CREATOR = new zad();
    @SafeParcelable.Field(getter = "getSessionId", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f20608a;
    @SafeParcelable.Field(defaultValue = "false", getter = "getShouldUnregisterListener", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final boolean f20609b;

    @KeepForSdk
    public ModuleInstallResponse(int i4) {
        this(i4, false);
    }

    public boolean areModulesAlreadyInstalled() {
        if (this.f20608a == 0) {
            return true;
        }
        return false;
    }

    public int getSessionId() {
        return this.f20608a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getSessionId());
        SafeParcelWriter.writeBoolean(parcel, 2, this.f20609b);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zaa() {
        return this.f20609b;
    }

    @SafeParcelable.Constructor
    public ModuleInstallResponse(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) boolean z3) {
        this.f20608a = i4;
        this.f20609b = z3;
    }
}
