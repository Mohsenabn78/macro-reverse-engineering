package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItemAsset;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@KeepName
@SafeParcelable.Class(creator = "DataItemAssetParcelableCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class DataItemAssetParcelable extends AbstractSafeParcelable implements DataItemAsset, ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR = new zzdf();
    @SafeParcelable.Field(getter = "getId", id = 2)

    /* renamed from: a  reason: collision with root package name */
    private final String f22657a;
    @SafeParcelable.Field(getter = "getDataItemKey", id = 3)

    /* renamed from: b  reason: collision with root package name */
    private final String f22658b;

    public DataItemAssetParcelable(@NonNull DataItemAsset dataItemAsset) {
        this.f22657a = (String) Preconditions.checkNotNull(dataItemAsset.getId());
        this.f22658b = (String) Preconditions.checkNotNull(dataItemAsset.getDataItemKey());
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    @NonNull
    public final String getDataItemKey() {
        return this.f22658b;
    }

    @Override // com.google.android.gms.wearable.DataItemAsset
    @NonNull
    public final String getId() {
        return this.f22657a;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @NonNull
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataItemAssetParcelable[@");
        sb.append(Integer.toHexString(hashCode()));
        if (this.f22657a == null) {
            sb.append(",noid");
        } else {
            sb.append(",");
            sb.append(this.f22657a);
        }
        sb.append(", key=");
        sb.append(this.f22658b);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f22657a, false);
        SafeParcelWriter.writeString(parcel, 3, this.f22658b, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public DataItemAssetParcelable(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2) {
        this.f22657a = str;
        this.f22658b = str2;
    }

    @Override // com.google.android.gms.common.data.Freezable
    @NonNull
    public final /* bridge */ /* synthetic */ DataItemAsset freeze() {
        return this;
    }
}
