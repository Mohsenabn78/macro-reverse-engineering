package com.google.android.gms.location.places.ui;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.internal.PlaceEntity;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class zzb {
    public static final int RESULT_ERROR = 2;

    public static Place getPlace(Context context, Intent intent) {
        Preconditions.checkNotNull(intent, "intent must not be null");
        Preconditions.checkNotNull(context, "context must not be null");
        return (Place) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "selected_place", PlaceEntity.CREATOR);
    }

    public static Status getStatus(Context context, Intent intent) {
        Preconditions.checkNotNull(intent, "intent must not be null");
        Preconditions.checkNotNull(context, "context must not be null");
        return (Status) SafeParcelableSerializer.deserializeFromIntentExtra(intent, NotificationCompat.CATEGORY_STATUS, Status.CREATOR);
    }
}
