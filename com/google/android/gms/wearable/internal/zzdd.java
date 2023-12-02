package com.google.android.gms.wearable.internal;

import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzdd extends DataBufferRef implements DataEvent {

    /* renamed from: d  reason: collision with root package name */
    private final int f22746d;

    public zzdd(DataHolder dataHolder, int i4, int i5) {
        super(dataHolder, i4);
        this.f22746d = i5;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ DataEvent freeze() {
        return new zzdc(this);
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public final DataItem getDataItem() {
        return new zzdk(this.f20368a, this.f20369b, this.f22746d);
    }

    @Override // com.google.android.gms.wearable.DataEvent
    public final int getType() {
        return d("event_type");
    }

    public final String toString() {
        String str;
        if (d("event_type") == 1) {
            str = "changed";
        } else if (d("event_type") == 2) {
            str = "deleted";
        } else {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        String obj = getDataItem().toString();
        return "DataEventRef{ type=" + str + ", dataitem=" + obj + " }";
    }
}
