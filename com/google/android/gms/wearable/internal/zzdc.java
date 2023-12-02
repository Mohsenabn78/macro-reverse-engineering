package com.google.android.gms.wearable.internal;

import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzdc implements DataEvent {

    /* renamed from: a  reason: collision with root package name */
    private final int f22744a;

    /* renamed from: b  reason: collision with root package name */
    private final DataItem f22745b;

    public zzdc(DataEvent dataEvent) {
        this.f22744a = dataEvent.getType();
        this.f22745b = new zzdh(dataEvent.getDataItem());
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public final DataItem getDataItem() {
        return this.f22745b;
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public final int getType() {
        return this.f22744a;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        String str;
        int i4 = this.f22744a;
        if (i4 == 1) {
            str = "changed";
        } else if (i4 == 2) {
            str = "deleted";
        } else {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        String obj = this.f22745b.toString();
        return "DataEventEntity{ type=" + str + ", dataitem=" + obj + " }";
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ DataEvent freeze() {
        return this;
    }
}
