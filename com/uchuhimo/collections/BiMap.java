package com.uchuhimo.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: BiMap.kt */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003R\u001e\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/uchuhimo/collections/BiMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "inverse", "getInverse", "()Lcom/uchuhimo/collections/BiMap;", "values", "", "getValues", "()Ljava/util/Set;", "kotlinx-bimap"}, k = 1, mv = {1, 1, 11})
/* loaded from: classes6.dex */
public interface BiMap<K, V> extends Map<K, V>, KMappedMarker {
    @NotNull
    BiMap<V, K> getInverse();

    @NotNull
    Set<V> getValues();
}
