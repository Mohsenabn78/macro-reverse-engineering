package com.arlosoft.macrodroid.geofences;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GeofenceStore.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
@Parcelize
/* loaded from: classes3.dex */
public final class GeofenceStore implements Parcelable {
    public static final int $stable = 8;
    @NotNull
    public static final Parcelable.Creator<GeofenceStore> CREATOR = new Creator();
    @NotNull
    private final Map<String, GeofenceInfo> geofenceMap;

    /* compiled from: GeofenceStore.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<GeofenceStore> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GeofenceStore createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i4 = 0; i4 != readInt; i4++) {
                linkedHashMap.put(parcel.readString(), GeofenceInfo.CREATOR.createFromParcel(parcel));
            }
            return new GeofenceStore(linkedHashMap);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GeofenceStore[] newArray(int i4) {
            return new GeofenceStore[i4];
        }
    }

    public GeofenceStore() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GeofenceStore copy$default(GeofenceStore geofenceStore, Map map, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            map = geofenceStore.geofenceMap;
        }
        return geofenceStore.copy(map);
    }

    @NotNull
    public final Map<String, GeofenceInfo> component1() {
        return this.geofenceMap;
    }

    @NotNull
    public final GeofenceStore copy(@NotNull Map<String, GeofenceInfo> geofenceMap) {
        Intrinsics.checkNotNullParameter(geofenceMap, "geofenceMap");
        return new GeofenceStore(geofenceMap);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof GeofenceStore) && Intrinsics.areEqual(this.geofenceMap, ((GeofenceStore) obj).geofenceMap)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<GeofenceInfo> getGeofenceList() {
        ArrayList arrayList = new ArrayList(this.geofenceMap.values());
        kotlin.collections.h.sort(arrayList);
        return arrayList;
    }

    @NotNull
    public final Map<String, GeofenceInfo> getGeofenceMap() {
        return this.geofenceMap;
    }

    public int hashCode() {
        return this.geofenceMap.hashCode();
    }

    public final void removeGeofence(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.geofenceMap.remove(id);
    }

    public final void setGeofence(@NotNull String id, @NotNull GeofenceInfo geofence) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(geofence, "geofence");
        this.geofenceMap.put(id, geofence);
    }

    @NotNull
    public String toString() {
        Map<String, GeofenceInfo> map = this.geofenceMap;
        return "GeofenceStore(geofenceMap=" + map + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        Map<String, GeofenceInfo> map = this.geofenceMap;
        out.writeInt(map.size());
        for (Map.Entry<String, GeofenceInfo> entry : map.entrySet()) {
            out.writeString(entry.getKey());
            entry.getValue().writeToParcel(out, i4);
        }
    }

    public GeofenceStore(@NotNull Map<String, GeofenceInfo> geofenceMap) {
        Intrinsics.checkNotNullParameter(geofenceMap, "geofenceMap");
        this.geofenceMap = geofenceMap;
    }

    public /* synthetic */ GeofenceStore(Map map, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? new ArrayMap() : map);
    }
}
