package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.common.Util;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@KeepForSdk
@SafeParcelable.Class(creator = "MethodInvocationCreator")
/* loaded from: classes4.dex */
public class MethodInvocation extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new zan();
    @SafeParcelable.Field(getter = "getMethodKey", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f20472a;
    @SafeParcelable.Field(getter = "getResultStatusCode", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final int f20473b;
    @SafeParcelable.Field(getter = "getConnectionResultStatusCode", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final int f20474c;
    @SafeParcelable.Field(getter = "getStartTimeMillis", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final long f20475d;
    @SafeParcelable.Field(getter = "getEndTimeMillis", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final long f20476e;
    @Nullable
    @SafeParcelable.Field(getter = "getCallingModuleId", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final String f20477f;
    @Nullable
    @SafeParcelable.Field(getter = "getCallingEntryPoint", id = 7)

    /* renamed from: g  reason: collision with root package name */
    private final String f20478g;
    @SafeParcelable.Field(defaultValue = "0", getter = "getServiceId", id = 8)

    /* renamed from: h  reason: collision with root package name */
    private final int f20479h;
    @SafeParcelable.Field(defaultValue = Util.ANY_CONTACT_ID, getter = "getLatencyMillis", id = 9)

    /* renamed from: i  reason: collision with root package name */
    private final int f20480i;

    @KeepForSdk
    @Deprecated
    public MethodInvocation(int i4, int i5, int i6, long j4, long j5, @Nullable String str, @Nullable String str2, int i7) {
        this(i4, i5, i6, j4, j5, str, str2, i7, -1);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f20472a);
        SafeParcelWriter.writeInt(parcel, 2, this.f20473b);
        SafeParcelWriter.writeInt(parcel, 3, this.f20474c);
        SafeParcelWriter.writeLong(parcel, 4, this.f20475d);
        SafeParcelWriter.writeLong(parcel, 5, this.f20476e);
        SafeParcelWriter.writeString(parcel, 6, this.f20477f, false);
        SafeParcelWriter.writeString(parcel, 7, this.f20478g, false);
        SafeParcelWriter.writeInt(parcel, 8, this.f20479h);
        SafeParcelWriter.writeInt(parcel, 9, this.f20480i);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public MethodInvocation(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5, @SafeParcelable.Param(id = 3) int i6, @SafeParcelable.Param(id = 4) long j4, @SafeParcelable.Param(id = 5) long j5, @Nullable @SafeParcelable.Param(id = 6) String str, @Nullable @SafeParcelable.Param(id = 7) String str2, @SafeParcelable.Param(id = 8) int i7, @SafeParcelable.Param(id = 9) int i8) {
        this.f20472a = i4;
        this.f20473b = i5;
        this.f20474c = i6;
        this.f20475d = j4;
        this.f20476e = j5;
        this.f20477f = str;
        this.f20478g = str2;
        this.f20479h = i7;
        this.f20480i = i8;
    }
}
