package com.uchuhimo.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MutableBiMap.kt */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\b\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004J\u001f\u0010\f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u000fJ\u001f\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u000fR\u001e\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/uchuhimo/collections/MutableBiMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Lcom/uchuhimo/collections/BiMap;", "inverse", "getInverse", "()Lcom/uchuhimo/collections/MutableBiMap;", "values", "", "getValues", "()Ljava/util/Set;", "forcePut", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "put", "kotlinx-bimap"}, k = 1, mv = {1, 1, 11})
/* loaded from: classes6.dex */
public interface MutableBiMap<K, V> extends Map<K, V>, BiMap<K, V>, KMutableMap {
    @Nullable
    V forcePut(K k4, V v3);

    @Override // com.uchuhimo.collections.BiMap
    @NotNull
    MutableBiMap<V, K> getInverse();

    @Override // com.uchuhimo.collections.BiMap
    @NotNull
    Set<V> getValues();

    @Override // java.util.Map
    @Nullable
    V put(K k4, V v3);
}
