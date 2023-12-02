package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.location.zzdh;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
@SafeParcelable.Class(creator = "GeofencingRequestCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public class GeofencingRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new zzn();
    public static final int INITIAL_TRIGGER_DWELL = 4;
    public static final int INITIAL_TRIGGER_ENTER = 1;
    public static final int INITIAL_TRIGGER_EXIT = 2;
    @SafeParcelable.Field(getter = "getParcelableGeofences", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final List f20919a;
    @InitialTrigger
    @SafeParcelable.Field(getter = "getInitialTrigger", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final int f20920b;
    @SafeParcelable.Field(defaultValue = "", getter = "getTag", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final String f20921c;
    @Nullable
    @SafeParcelable.Field(getter = "getContextAttributionTag", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final String f20922d;

    /* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final List f20923a = new ArrayList();
        @InitialTrigger

        /* renamed from: b  reason: collision with root package name */
        private int f20924b = 5;

        /* renamed from: c  reason: collision with root package name */
        private String f20925c = "";

        @NonNull
        public Builder addGeofence(@NonNull Geofence geofence) {
            Preconditions.checkNotNull(geofence, "geofence can't be null.");
            Preconditions.checkArgument(geofence instanceof zzdh, "Geofence must be created using Geofence.Builder.");
            this.f20923a.add((zzdh) geofence);
            return this;
        }

        @NonNull
        public Builder addGeofences(@NonNull List<Geofence> list) {
            if (list != null && !list.isEmpty()) {
                for (Geofence geofence : list) {
                    if (geofence != null) {
                        addGeofence(geofence);
                    }
                }
            }
            return this;
        }

        @NonNull
        public GeofencingRequest build() {
            Preconditions.checkArgument(!this.f20923a.isEmpty(), "No geofence has been added to this request.");
            return new GeofencingRequest(this.f20923a, this.f20924b, this.f20925c, null);
        }

        @NonNull
        public Builder setInitialTrigger(@InitialTrigger int i4) {
            this.f20924b = i4 & 7;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
    /* loaded from: classes4.dex */
    public @interface InitialTrigger {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public GeofencingRequest(@SafeParcelable.Param(id = 1) List list, @SafeParcelable.Param(id = 2) @InitialTrigger int i4, @SafeParcelable.Param(id = 3) String str, @Nullable @SafeParcelable.Param(id = 4) String str2) {
        this.f20919a = list;
        this.f20920b = i4;
        this.f20921c = str;
        this.f20922d = str2;
    }

    @NonNull
    public List<Geofence> getGeofences() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f20919a);
        return arrayList;
    }

    @InitialTrigger
    public int getInitialTrigger() {
        return this.f20920b;
    }

    @NonNull
    public String toString() {
        return "GeofencingRequest[geofences=" + this.f20919a + ", initialTrigger=" + this.f20920b + ", tag=" + this.f20921c + ", attributionTag=" + this.f20922d + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.f20919a, false);
        SafeParcelWriter.writeInt(parcel, 2, getInitialTrigger());
        SafeParcelWriter.writeString(parcel, 3, this.f20921c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f20922d, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final GeofencingRequest zza(@Nullable String str) {
        return new GeofencingRequest(this.f20919a, this.f20920b, this.f20921c, str);
    }
}
