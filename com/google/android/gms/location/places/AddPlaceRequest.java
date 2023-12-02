package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.sun.mail.imap.IMAPStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SafeParcelable.Class(creator = "AddPlaceRequestCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
/* loaded from: classes4.dex */
public class AddPlaceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AddPlaceRequest> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getName", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f21003a;
    @SafeParcelable.Field(getter = "getLatLng", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final LatLng f21004b;
    @SafeParcelable.Field(getter = "getAddress", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f21005c;
    @SafeParcelable.Field(getter = "getPlaceTypes", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final List<Integer> f21006d;
    @SafeParcelable.Field(getter = "getPhoneNumber", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final String f21007e;
    @SafeParcelable.Field(getter = "getWebsiteUri", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final Uri f21008f;

    @SafeParcelable.Constructor
    public AddPlaceRequest(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) LatLng latLng, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) List<Integer> list, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) Uri uri) {
        this.f21003a = Preconditions.checkNotEmpty(str);
        this.f21004b = (LatLng) Preconditions.checkNotNull(latLng);
        this.f21005c = Preconditions.checkNotEmpty(str2);
        ArrayList arrayList = new ArrayList((Collection) Preconditions.checkNotNull(list));
        this.f21006d = arrayList;
        boolean z3 = true;
        Preconditions.checkArgument(!arrayList.isEmpty(), "At least one place type should be provided.");
        if (TextUtils.isEmpty(str3) && uri == null) {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "One of phone number or URI should be provided.");
        this.f21007e = str3;
        this.f21008f = uri;
    }

    public String getAddress() {
        return this.f21005c;
    }

    public LatLng getLatLng() {
        return this.f21004b;
    }

    public String getName() {
        return this.f21003a;
    }

    @Nullable
    public String getPhoneNumber() {
        return this.f21007e;
    }

    public List<Integer> getPlaceTypes() {
        return this.f21006d;
    }

    @Nullable
    public Uri getWebsiteUri() {
        return this.f21008f;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", this.f21003a).add("latLng", this.f21004b).add(IMAPStore.ID_ADDRESS, this.f21005c).add("placeTypes", this.f21006d).add("phoneNumer", this.f21007e).add("websiteUri", this.f21008f).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, getLatLng(), i4, false);
        SafeParcelWriter.writeString(parcel, 3, getAddress(), false);
        SafeParcelWriter.writeIntegerList(parcel, 4, getPlaceTypes(), false);
        SafeParcelWriter.writeString(parcel, 5, getPhoneNumber(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getWebsiteUri(), i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public AddPlaceRequest(String str, LatLng latLng, String str2, List<Integer> list, String str3) {
        this(str, latLng, str2, list, Preconditions.checkNotEmpty(str3), null);
    }

    public AddPlaceRequest(String str, LatLng latLng, String str2, List<Integer> list, Uri uri) {
        this(str, latLng, str2, list, null, (Uri) Preconditions.checkNotNull(uri));
    }
}
