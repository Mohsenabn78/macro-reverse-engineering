package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;

@SafeParcelable.Class(creator = "AutocompleteFilterCreator")
@Deprecated
/* loaded from: classes4.dex */
public class AutocompleteFilter extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AutocompleteFilter> CREATOR = new zzd();
    public static final int TYPE_FILTER_ADDRESS = 2;
    public static final int TYPE_FILTER_CITIES = 5;
    public static final int TYPE_FILTER_ESTABLISHMENT = 34;
    public static final int TYPE_FILTER_GEOCODE = 1007;
    public static final int TYPE_FILTER_NONE = 0;
    public static final int TYPE_FILTER_REGIONS = 4;
    @SafeParcelable.VersionField(id = 1000)

    /* renamed from: a  reason: collision with root package name */
    private final int f21009a;
    @SafeParcelable.Field(id = 1)

    /* renamed from: b  reason: collision with root package name */
    private final boolean f21010b;
    @SafeParcelable.Field(id = 2)

    /* renamed from: c  reason: collision with root package name */
    private final List<Integer> f21011c;
    @SafeParcelable.Field(id = 3)

    /* renamed from: d  reason: collision with root package name */
    private final String f21012d;

    /* renamed from: e  reason: collision with root package name */
    private final int f21013e;

    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f21014a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f21015b = 0;

        /* renamed from: c  reason: collision with root package name */
        private String f21016c = "";

        public final AutocompleteFilter build() {
            return new AutocompleteFilter(1, false, Arrays.asList(Integer.valueOf(this.f21015b)), this.f21016c);
        }

        public final Builder setCountry(String str) {
            this.f21016c = str;
            return this;
        }

        public final Builder setTypeFilter(int i4) {
            this.f21015b = i4;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AutocompleteFilter(@SafeParcelable.Param(id = 1000) int i4, @SafeParcelable.Param(id = 1) boolean z3, @SafeParcelable.Param(id = 2) List<Integer> list, @SafeParcelable.Param(id = 3) String str) {
        int i5;
        this.f21009a = i4;
        this.f21011c = list;
        if (list != null && !list.isEmpty()) {
            i5 = list.iterator().next().intValue();
        } else {
            i5 = 0;
        }
        this.f21013e = i5;
        this.f21012d = str;
        if (i4 <= 0) {
            this.f21010b = !z3;
        } else {
            this.f21010b = z3;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutocompleteFilter)) {
            return false;
        }
        AutocompleteFilter autocompleteFilter = (AutocompleteFilter) obj;
        if (this.f21013e == autocompleteFilter.f21013e && this.f21010b == autocompleteFilter.f21010b && this.f21012d == autocompleteFilter.f21012d) {
            return true;
        }
        return false;
    }

    public int getTypeFilter() {
        return this.f21013e;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.f21010b), Integer.valueOf(this.f21013e), this.f21012d);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("includeQueryPredictions", Boolean.valueOf(this.f21010b)).add("typeFilter", Integer.valueOf(this.f21013e)).add("country", this.f21012d).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.f21010b);
        SafeParcelWriter.writeIntegerList(parcel, 2, this.f21011c, false);
        SafeParcelWriter.writeString(parcel, 3, this.f21012d, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.f21009a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
