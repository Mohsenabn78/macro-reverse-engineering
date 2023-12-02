package com.google.android.gms.wearable;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public interface DataItem extends Freezable<DataItem> {
    @NonNull
    Map<String, DataItemAsset> getAssets();

    @Nullable
    @Pure
    byte[] getData();

    @NonNull
    Uri getUri();

    @NonNull
    DataItem setData(@Nullable byte[] bArr);
}
