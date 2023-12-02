package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@SafeParcelable.Class(creator = "GoogleCertificatesLookupQueryCreator")
/* loaded from: classes4.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();
    @SafeParcelable.Field(getter = "getCallingPackage", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f20784a;
    @SafeParcelable.Field(getter = "getAllowTestKeys", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final boolean f20785b;
    @SafeParcelable.Field(defaultValue = "false", getter = "getIgnoreTestKeysOverride", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final boolean f20786c;
    @SafeParcelable.Field(getter = "getCallingContextBinder", id = 4, type = "android.os.IBinder")

    /* renamed from: d  reason: collision with root package name */
    private final Context f20787d;
    @SafeParcelable.Field(getter = "getIsChimeraPackage", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final boolean f20788e;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzo(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) boolean z3, @SafeParcelable.Param(id = 3) boolean z4, @SafeParcelable.Param(id = 4) IBinder iBinder, @SafeParcelable.Param(id = 5) boolean z5) {
        this.f20784a = str;
        this.f20785b = z3;
        this.f20786c = z4;
        this.f20787d = (Context) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.f20788e = z5;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.google.android.gms.dynamic.IObjectWrapper, android.os.IBinder] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f20784a, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f20785b);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f20786c);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.f20787d), false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f20788e);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
