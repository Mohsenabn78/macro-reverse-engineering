package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;

@SafeParcelable.Class(creator = "CapCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class Cap extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Cap> CREATOR = new zzb();

    /* renamed from: d  reason: collision with root package name */
    private static final String f21288d = "Cap";
    @SafeParcelable.Field(getter = "getType", id = 2)

    /* renamed from: a  reason: collision with root package name */
    private final int f21289a;
    @Nullable
    @SafeParcelable.Field(getter = "getWrappedBitmapDescriptorImplBinder", id = 3, type = "android.os.IBinder")

    /* renamed from: b  reason: collision with root package name */
    private final BitmapDescriptor f21290b;
    @Nullable
    @SafeParcelable.Field(getter = "getBitmapRefWidth", id = 4)

    /* renamed from: c  reason: collision with root package name */
    private final Float f21291c;

    private Cap(int i4, @Nullable BitmapDescriptor bitmapDescriptor, @Nullable Float f4) {
        Preconditions.checkArgument(i4 != 3 || (bitmapDescriptor != null && (f4 != null && (f4.floatValue() > 0.0f ? 1 : (f4.floatValue() == 0.0f ? 0 : -1)) > 0)), String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", Integer.valueOf(i4), bitmapDescriptor, f4));
        this.f21289a = i4;
        this.f21290b = bitmapDescriptor;
        this.f21291c = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Cap b() {
        int i4 = this.f21289a;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        String str = f21288d;
                        StringBuilder sb = new StringBuilder(29);
                        sb.append("Unknown Cap type: ");
                        sb.append(i4);
                        Log.w(str, sb.toString());
                        return this;
                    }
                    return new CustomCap(this.f21290b, this.f21291c.floatValue());
                }
                return new RoundCap();
            }
            return new SquareCap();
        }
        return new ButtCap();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cap)) {
            return false;
        }
        Cap cap = (Cap) obj;
        if (this.f21289a == cap.f21289a && Objects.equal(this.f21290b, cap.f21290b) && Objects.equal(this.f21291c, cap.f21291c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f21289a), this.f21290b, this.f21291c);
    }

    public String toString() {
        int i4 = this.f21289a;
        StringBuilder sb = new StringBuilder(23);
        sb.append("[Cap: type=");
        sb.append(i4);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        IBinder asBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.f21289a);
        BitmapDescriptor bitmapDescriptor = this.f21290b;
        if (bitmapDescriptor == null) {
            asBinder = null;
        } else {
            asBinder = bitmapDescriptor.zzb().asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 3, asBinder, false);
        SafeParcelWriter.writeFloatObject(parcel, 4, this.f21291c, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public Cap(@SafeParcelable.Param(id = 2) int i4, @Nullable @SafeParcelable.Param(id = 3) IBinder iBinder, @Nullable @SafeParcelable.Param(id = 4) Float f4) {
        this(i4, iBinder == null ? null : new BitmapDescriptor(IObjectWrapper.Stub.asInterface(iBinder)), f4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Cap(@NonNull BitmapDescriptor bitmapDescriptor, float f4) {
        this(3, bitmapDescriptor, Float.valueOf(f4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Cap(int i4) {
        this(i4, (BitmapDescriptor) null, (Float) null);
    }
}
