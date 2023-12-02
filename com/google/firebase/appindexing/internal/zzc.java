package com.google.firebase.appindexing.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.icing.zzbp;
import com.google.firebase.appindexing.Action;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
@SafeParcelable.Class(creator = "ActionImplCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes5.dex */
public final class zzc extends AbstractSafeParcelable implements Action {
    public static final Parcelable.Creator<zzc> CREATOR = new zzd();
    @SafeParcelable.Field(getter = "getActionType", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f28813a;
    @SafeParcelable.Field(getter = "getObjectName", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final String f28814b;
    @SafeParcelable.Field(getter = "getObjectUrl", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f28815c;
    @SafeParcelable.Field(getter = "getObjectSameAs", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final String f28816d;
    @SafeParcelable.Field(getter = "getMetadata", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final zzb f28817e;
    @SafeParcelable.Field(getter = "getActionStatus", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final String f28818f;
    @SafeParcelable.Field(getter = "getPropertyBundle", id = 7)

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f28819g;

    @SafeParcelable.Constructor
    public zzc(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) String str4, @SafeParcelable.Param(id = 5) zzb zzbVar, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) Bundle bundle) {
        this.f28813a = str;
        this.f28814b = str2;
        this.f28815c = str3;
        this.f28816d = str4;
        this.f28817e = zzbVar;
        this.f28818f = str5;
        if (bundle != null) {
            this.f28819g = bundle;
        } else {
            this.f28819g = Bundle.EMPTY;
        }
        ClassLoader classLoader = zzc.class.getClassLoader();
        zzbp.zza(classLoader);
        this.f28819g.setClassLoader(classLoader);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActionImpl { { actionType: '");
        sb.append(this.f28813a);
        sb.append("' } { objectName: '");
        sb.append(this.f28814b);
        sb.append("' } { objectUrl: '");
        sb.append(this.f28815c);
        sb.append("' } ");
        if (this.f28816d != null) {
            sb.append("{ objectSameAs: '");
            sb.append(this.f28816d);
            sb.append("' } ");
        }
        if (this.f28817e != null) {
            sb.append("{ metadata: '");
            sb.append(this.f28817e.toString());
            sb.append("' } ");
        }
        if (this.f28818f != null) {
            sb.append("{ actionStatus: '");
            sb.append(this.f28818f);
            sb.append("' } ");
        }
        if (!this.f28819g.isEmpty()) {
            sb.append("{ ");
            sb.append(this.f28819g);
            sb.append(" } ");
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f28813a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f28814b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f28815c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f28816d, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.f28817e, i4, false);
        SafeParcelWriter.writeString(parcel, 6, this.f28818f, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.f28819g, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzb zza() {
        return this.f28817e;
    }
}
