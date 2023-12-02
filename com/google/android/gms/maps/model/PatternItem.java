package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "PatternItemCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class PatternItem extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PatternItem> CREATOR = new zzi();

    /* renamed from: c  reason: collision with root package name */
    private static final String f21339c = "PatternItem";
    @SafeParcelable.Field(getter = "getType", id = 2)

    /* renamed from: a  reason: collision with root package name */
    private final int f21340a;
    @Nullable
    @SafeParcelable.Field(getter = "getLength", id = 3)

    /* renamed from: b  reason: collision with root package name */
    private final Float f21341b;

    @SafeParcelable.Constructor
    public PatternItem(@SafeParcelable.Param(id = 2) int i4, @Nullable @SafeParcelable.Param(id = 3) Float f4) {
        boolean z3 = true;
        if (i4 != 1 && (f4 == null || f4.floatValue() < 0.0f)) {
            z3 = false;
        }
        String valueOf = String.valueOf(f4);
        StringBuilder sb = new StringBuilder(valueOf.length() + 45);
        sb.append("Invalid PatternItem: type=");
        sb.append(i4);
        sb.append(" length=");
        sb.append(valueOf);
        Preconditions.checkArgument(z3, sb.toString());
        this.f21340a = i4;
        this.f21341b = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static List<PatternItem> b(@Nullable List<PatternItem> list) {
        PatternItem dash;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (PatternItem patternItem : list) {
            if (patternItem == null) {
                patternItem = null;
            } else {
                int i4 = patternItem.f21340a;
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            String str = f21339c;
                            StringBuilder sb = new StringBuilder(37);
                            sb.append("Unknown PatternItem type: ");
                            sb.append(i4);
                            Log.w(str, sb.toString());
                        } else {
                            dash = new Gap(patternItem.f21341b.floatValue());
                        }
                    } else {
                        patternItem = new Dot();
                    }
                } else {
                    dash = new Dash(patternItem.f21341b.floatValue());
                }
                patternItem = dash;
            }
            arrayList.add(patternItem);
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PatternItem)) {
            return false;
        }
        PatternItem patternItem = (PatternItem) obj;
        if (this.f21340a == patternItem.f21340a && Objects.equal(this.f21341b, patternItem.f21341b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f21340a), this.f21341b);
    }

    public String toString() {
        int i4 = this.f21340a;
        String valueOf = String.valueOf(this.f21341b);
        StringBuilder sb = new StringBuilder(valueOf.length() + 39);
        sb.append("[PatternItem: type=");
        sb.append(i4);
        sb.append(" length=");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.f21340a);
        SafeParcelWriter.writeFloatObject(parcel, 3, this.f21341b, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
