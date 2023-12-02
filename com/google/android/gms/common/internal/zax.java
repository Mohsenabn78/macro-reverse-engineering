package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@SafeParcelable.Class(creator = "SignInButtonConfigCreator")
/* loaded from: classes4.dex */
public final class zax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zax> CREATOR = new zay();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f20542a;
    @SafeParcelable.Field(getter = "getButtonSize", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final int f20543b;
    @SafeParcelable.Field(getter = "getColorScheme", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final int f20544c;
    @Nullable
    @SafeParcelable.Field(getter = "getScopes", id = 4)
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    private final Scope[] f20545d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zax(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5, @SafeParcelable.Param(id = 3) int i6, @Nullable @SafeParcelable.Param(id = 4) Scope[] scopeArr) {
        this.f20542a = i4;
        this.f20543b = i5;
        this.f20544c = i6;
        this.f20545d = scopeArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f20542a);
        SafeParcelWriter.writeInt(parcel, 2, this.f20543b);
        SafeParcelWriter.writeInt(parcel, 3, this.f20544c);
        SafeParcelWriter.writeTypedArray(parcel, 4, this.f20545d, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
