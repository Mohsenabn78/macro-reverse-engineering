package com.google.android.gms.location;

import android.location.Location;
import androidx.annotation.Nullable;
import com.google.android.gms.location.Geofence;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes4.dex */
public class GeofencingEvent {

    /* renamed from: a  reason: collision with root package name */
    private final int f20915a;
    @Geofence.GeofenceTransition

    /* renamed from: b  reason: collision with root package name */
    private final int f20916b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final List f20917c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final Location f20918d;

    private GeofencingEvent(int i4, @Geofence.GeofenceTransition int i5, @Nullable List list, @Nullable Location location) {
        this.f20915a = i4;
        this.f20916b = i5;
        this.f20917c = list;
        this.f20918d = location;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002b  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.location.GeofencingEvent fromIntent(@androidx.annotation.NonNull android.content.Intent r12) {
        /*
            r0 = 0
            if (r12 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = "gms_error_code"
            r2 = -1
            int r1 = r12.getIntExtra(r1, r2)
            java.lang.String r3 = "com.google.android.location.intent.extra.transition"
            int r3 = r12.getIntExtra(r3, r2)
            if (r3 != r2) goto L15
        L13:
            r3 = -1
            goto L1f
        L15:
            r4 = 1
            if (r3 == r4) goto L1f
            r4 = 2
            if (r3 == r4) goto L1f
            r4 = 4
            if (r3 != r4) goto L13
            r3 = 4
        L1f:
            java.lang.String r4 = "com.google.android.location.intent.extra.geofence_list"
            java.io.Serializable r4 = r12.getSerializableExtra(r4)
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            if (r4 != 0) goto L2b
            r5 = r0
            goto L5e
        L2b:
            java.util.ArrayList r5 = new java.util.ArrayList
            int r6 = r4.size()
            r5.<init>(r6)
            int r6 = r4.size()
            r7 = 0
            r8 = 0
        L3a:
            if (r8 >= r6) goto L5e
            java.lang.Object r9 = r4.get(r8)
            byte[] r9 = (byte[]) r9
            android.os.Parcel r10 = android.os.Parcel.obtain()
            int r11 = r9.length
            r10.unmarshall(r9, r7, r11)
            r10.setDataPosition(r7)
            android.os.Parcelable$Creator<com.google.android.gms.internal.location.zzdh> r9 = com.google.android.gms.internal.location.zzdh.CREATOR
            java.lang.Object r9 = r9.createFromParcel(r10)
            com.google.android.gms.internal.location.zzdh r9 = (com.google.android.gms.internal.location.zzdh) r9
            r10.recycle()
            r5.add(r9)
            int r8 = r8 + 1
            goto L3a
        L5e:
            java.lang.String r4 = "com.google.android.location.intent.extra.triggering_location"
            android.os.Parcelable r12 = r12.getParcelableExtra(r4)
            android.location.Location r12 = (android.location.Location) r12
            if (r5 != 0) goto L6b
            if (r1 != r2) goto L6b
            return r0
        L6b:
            com.google.android.gms.location.GeofencingEvent r0 = new com.google.android.gms.location.GeofencingEvent
            r0.<init>(r1, r3, r5, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.GeofencingEvent.fromIntent(android.content.Intent):com.google.android.gms.location.GeofencingEvent");
    }

    public int getErrorCode() {
        return this.f20915a;
    }

    @Geofence.GeofenceTransition
    public int getGeofenceTransition() {
        return this.f20916b;
    }

    @Nullable
    public List<Geofence> getTriggeringGeofences() {
        return this.f20917c;
    }

    @Nullable
    public Location getTriggeringLocation() {
        return this.f20918d;
    }

    public boolean hasError() {
        if (this.f20915a != -1) {
            return true;
        }
        return false;
    }
}
