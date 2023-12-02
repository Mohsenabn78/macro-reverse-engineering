package com.google.android.gms.location.places.internal;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.sun.mail.imap.IMAPStore;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "PlaceEntityCreator")
@SafeParcelable.Reserved({1000, 2, 3, 12, 13, 16, 18})
/* loaded from: classes4.dex */
public final class PlaceEntity extends AbstractSafeParcelable implements ReflectedParcelable, Place {
    public static final Parcelable.Creator<PlaceEntity> CREATOR = new zzag();
    @SafeParcelable.Field(getter = "getId", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final String f21052a;
    @SafeParcelable.Field(getter = "getLatLng", id = 4)

    /* renamed from: b  reason: collision with root package name */
    private final LatLng f21053b;
    @SafeParcelable.Field(getter = "getLevelNumber", id = 5)

    /* renamed from: c  reason: collision with root package name */
    private final float f21054c;
    @SafeParcelable.Field(getter = "getViewport", id = 6)

    /* renamed from: d  reason: collision with root package name */
    private final LatLngBounds f21055d;
    @SafeParcelable.Field(getter = "getTimeZoneId", id = 7)

    /* renamed from: e  reason: collision with root package name */
    private final String f21056e;
    @SafeParcelable.Field(getter = "getWebsiteUri", id = 8)

    /* renamed from: f  reason: collision with root package name */
    private final Uri f21057f;
    @SafeParcelable.Field(getter = "isPermanentlyClosed", id = 9)

    /* renamed from: g  reason: collision with root package name */
    private final boolean f21058g;
    @SafeParcelable.Field(getter = "getRating", id = 10)

    /* renamed from: h  reason: collision with root package name */
    private final float f21059h;
    @SafeParcelable.Field(getter = "getPriceLevel", id = 11)

    /* renamed from: i  reason: collision with root package name */
    private final int f21060i;
    @SafeParcelable.Field(getter = "getPlaceTypes", id = 20)

    /* renamed from: j  reason: collision with root package name */
    private final List<Integer> f21061j;
    @SafeParcelable.Field(getter = "getName", id = 19)

    /* renamed from: k  reason: collision with root package name */
    private final String f21062k;
    @SafeParcelable.Field(getter = "getAddress", id = 14)

    /* renamed from: l  reason: collision with root package name */
    private final String f21063l;
    @SafeParcelable.Field(getter = "getPhoneNumber", id = 15)

    /* renamed from: m  reason: collision with root package name */
    private final String f21064m;
    @SafeParcelable.Field(getter = "getAttributionsList", id = 17)

    /* renamed from: n  reason: collision with root package name */
    private final List<String> f21065n;
    @SafeParcelable.Field(getter = "getPlaceOpeningHours", id = 21)

    /* renamed from: o  reason: collision with root package name */
    private final zzal f21066o;
    @SafeParcelable.Field(getter = "getExtendedDetails", id = 22)

    /* renamed from: p  reason: collision with root package name */
    private final zzai f21067p;
    @SafeParcelable.Field(getter = "getAdrAddress", id = 23)

    /* renamed from: q  reason: collision with root package name */
    private final String f21068q;

    /* renamed from: r  reason: collision with root package name */
    private Locale f21069r;

    /* loaded from: classes4.dex */
    public static class zzb {

        /* renamed from: a  reason: collision with root package name */
        private String f21070a;

        /* renamed from: b  reason: collision with root package name */
        private String f21071b;

        /* renamed from: c  reason: collision with root package name */
        private LatLng f21072c;

        /* renamed from: d  reason: collision with root package name */
        private float f21073d;

        /* renamed from: e  reason: collision with root package name */
        private LatLngBounds f21074e;

        /* renamed from: f  reason: collision with root package name */
        private Uri f21075f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f21076g;

        /* renamed from: j  reason: collision with root package name */
        private List<Integer> f21079j;

        /* renamed from: k  reason: collision with root package name */
        private String f21080k;

        /* renamed from: l  reason: collision with root package name */
        private String f21081l;

        /* renamed from: m  reason: collision with root package name */
        private List<String> f21082m;

        /* renamed from: n  reason: collision with root package name */
        private zzal f21083n;

        /* renamed from: o  reason: collision with root package name */
        private zzai f21084o;

        /* renamed from: p  reason: collision with root package name */
        private String f21085p;

        /* renamed from: i  reason: collision with root package name */
        private int f21078i = -1;

        /* renamed from: h  reason: collision with root package name */
        private float f21077h = -1.0f;

        public final zzb zzb(String str) {
            this.f21070a = str;
            return this;
        }

        public final zzb zzc(String str) {
            this.f21071b = str;
            return this;
        }

        public final zzb zzd(String str) {
            this.f21080k = str;
            return this;
        }

        public final zzb zze(String str) {
            this.f21081l = str;
            return this;
        }

        public final zzb zzf(String str) {
            this.f21085p = str;
            return this;
        }

        public final PlaceEntity zzj() {
            return new PlaceEntity(this.f21070a, this.f21079j, this.f21071b, this.f21080k, this.f21081l, this.f21082m, this.f21072c, this.f21073d, this.f21074e, null, this.f21075f, this.f21076g, this.f21077h, this.f21078i, this.f21083n, this.f21084o, this.f21085p);
        }

        public final zzb zzb(LatLng latLng) {
            this.f21072c = latLng;
            return this;
        }

        public final zzb zzc(float f4) {
            this.f21077h = f4;
            return this;
        }

        public final zzb zzd(List<String> list) {
            this.f21082m = list;
            return this;
        }

        public final zzb zzb(float f4) {
            this.f21073d = f4;
            return this;
        }

        public final zzb zzc(int i4) {
            this.f21078i = i4;
            return this;
        }

        public final zzb zzb(LatLngBounds latLngBounds) {
            this.f21074e = latLngBounds;
            return this;
        }

        public final zzb zzc(List<Integer> list) {
            this.f21079j = list;
            return this;
        }

        public final zzb zzb(Uri uri) {
            this.f21075f = uri;
            return this;
        }

        public final zzb zzb(boolean z3) {
            this.f21076g = z3;
            return this;
        }

        public final zzb zzb(zzal zzalVar) {
            this.f21083n = zzalVar;
            return this;
        }

        public final zzb zzb(zzai zzaiVar) {
            this.f21084o = zzaiVar;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public PlaceEntity(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 20) List<Integer> list, @SafeParcelable.Param(id = 19) String str2, @SafeParcelable.Param(id = 14) String str3, @SafeParcelable.Param(id = 15) String str4, @SafeParcelable.Param(id = 17) List<String> list2, @SafeParcelable.Param(id = 4) LatLng latLng, @SafeParcelable.Param(id = 5) float f4, @SafeParcelable.Param(id = 6) LatLngBounds latLngBounds, @SafeParcelable.Param(id = 7) String str5, @SafeParcelable.Param(id = 8) Uri uri, @SafeParcelable.Param(id = 9) boolean z3, @SafeParcelable.Param(id = 10) float f5, @SafeParcelable.Param(id = 11) int i4, @SafeParcelable.Param(id = 21) zzal zzalVar, @SafeParcelable.Param(id = 22) zzai zzaiVar, @SafeParcelable.Param(id = 23) String str6) {
        List<String> emptyList;
        String str7;
        this.f21052a = str;
        this.f21061j = Collections.unmodifiableList(list);
        this.f21062k = str2;
        this.f21063l = str3;
        this.f21064m = str4;
        if (list2 != null) {
            emptyList = list2;
        } else {
            emptyList = Collections.emptyList();
        }
        this.f21065n = emptyList;
        this.f21053b = latLng;
        this.f21054c = f4;
        this.f21055d = latLngBounds;
        if (str5 != null) {
            str7 = str5;
        } else {
            str7 = "UTC";
        }
        this.f21056e = str7;
        this.f21057f = uri;
        this.f21058g = z3;
        this.f21059h = f5;
        this.f21060i = i4;
        this.f21069r = null;
        this.f21066o = zzalVar;
        this.f21067p = zzaiVar;
        this.f21068q = str6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceEntity)) {
            return false;
        }
        PlaceEntity placeEntity = (PlaceEntity) obj;
        if (this.f21052a.equals(placeEntity.f21052a) && Objects.equal(this.f21069r, placeEntity.f21069r)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.location.places.Place
    public final /* synthetic */ CharSequence getAddress() {
        return this.f21063l;
    }

    @Override // com.google.android.gms.location.places.Place
    @Nullable
    public final CharSequence getAttributions() {
        return zzi.zzc(this.f21065n);
    }

    @Override // com.google.android.gms.location.places.Place
    @VisibleForTesting
    public final String getId() {
        return this.f21052a;
    }

    @Override // com.google.android.gms.location.places.Place
    public final LatLng getLatLng() {
        return this.f21053b;
    }

    @Override // com.google.android.gms.location.places.Place
    public final Locale getLocale() {
        return this.f21069r;
    }

    @Override // com.google.android.gms.location.places.Place
    public final /* synthetic */ CharSequence getName() {
        return this.f21062k;
    }

    @Override // com.google.android.gms.location.places.Place
    public final /* synthetic */ CharSequence getPhoneNumber() {
        return this.f21064m;
    }

    @Override // com.google.android.gms.location.places.Place
    public final List<Integer> getPlaceTypes() {
        return this.f21061j;
    }

    @Override // com.google.android.gms.location.places.Place
    public final int getPriceLevel() {
        return this.f21060i;
    }

    @Override // com.google.android.gms.location.places.Place
    public final float getRating() {
        return this.f21059h;
    }

    @Override // com.google.android.gms.location.places.Place
    public final LatLngBounds getViewport() {
        return this.f21055d;
    }

    @Override // com.google.android.gms.location.places.Place
    public final Uri getWebsiteUri() {
        return this.f21057f;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f21052a, this.f21069r);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @VisibleForTesting
    public final void setLocale(Locale locale) {
        this.f21069r = locale;
    }

    @SuppressLint({"DefaultLocale"})
    public final String toString() {
        return Objects.toStringHelper(this).add("id", this.f21052a).add("placeTypes", this.f21061j).add("locale", this.f21069r).add("name", this.f21062k).add(IMAPStore.ID_ADDRESS, this.f21063l).add(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, this.f21064m).add("latlng", this.f21053b).add("viewport", this.f21055d).add("websiteUri", this.f21057f).add("isPermanentlyClosed", Boolean.valueOf(this.f21058g)).add("priceLevel", Integer.valueOf(this.f21060i)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, getLatLng(), i4, false);
        SafeParcelWriter.writeFloat(parcel, 5, this.f21054c);
        SafeParcelWriter.writeParcelable(parcel, 6, getViewport(), i4, false);
        SafeParcelWriter.writeString(parcel, 7, this.f21056e, false);
        SafeParcelWriter.writeParcelable(parcel, 8, getWebsiteUri(), i4, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.f21058g);
        SafeParcelWriter.writeFloat(parcel, 10, getRating());
        SafeParcelWriter.writeInt(parcel, 11, getPriceLevel());
        SafeParcelWriter.writeString(parcel, 14, (String) getAddress(), false);
        SafeParcelWriter.writeString(parcel, 15, (String) getPhoneNumber(), false);
        SafeParcelWriter.writeStringList(parcel, 17, this.f21065n, false);
        SafeParcelWriter.writeString(parcel, 19, (String) getName(), false);
        SafeParcelWriter.writeIntegerList(parcel, 20, getPlaceTypes(), false);
        SafeParcelWriter.writeParcelable(parcel, 21, this.f21066o, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 22, this.f21067p, i4, false);
        SafeParcelWriter.writeString(parcel, 23, this.f21068q, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ Place freeze() {
        return this;
    }
}
