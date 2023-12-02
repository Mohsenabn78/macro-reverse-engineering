package com.uchuhimo.collections;

import androidx.exifinterface.media.ExifInterface;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.google.common.collect.HashBiMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.s;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MutableBiMaps.kt */
@Metadata(d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\u001a.\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\u001a.\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u001aQ\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\b\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\u0006\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\t\u0010\n\u001a.\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b¨\u0006\r"}, d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/uchuhimo/collections/MutableBiMap;", "Lcom/google/common/collect/BiMap;", "a", "b", "", "Lkotlin/Pair;", "pairs", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "([Lkotlin/Pair;)Lcom/uchuhimo/collections/MutableBiMap;", "", "d", "kotlinx-bimap"}, k = 5, mv = {1, 4, 0}, xs = "com/uchuhimo/collections/BiMapsKt")
/* loaded from: classes6.dex */
public final /* synthetic */ class c {
    @NotNull
    public static final <K, V> com.google.common.collect.BiMap<K, V> a(@NotNull MutableBiMap<K, V> receiver) {
        MutableBiMap<K, V> mutableBiMap;
        com.google.common.collect.BiMap<K, V> delegate$kotlinx_bimap;
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        if (!(receiver instanceof MutableBiMapWrapper)) {
            mutableBiMap = null;
        } else {
            mutableBiMap = receiver;
        }
        MutableBiMapWrapper mutableBiMapWrapper = (MutableBiMapWrapper) mutableBiMap;
        if (mutableBiMapWrapper == null || (delegate$kotlinx_bimap = mutableBiMapWrapper.getDelegate$kotlinx_bimap()) == null) {
            return new GuavaBiMapWrapper(receiver);
        }
        return delegate$kotlinx_bimap;
    }

    @NotNull
    public static final <K, V> MutableBiMap<K, V> b(@NotNull com.google.common.collect.BiMap<K, V> receiver) {
        com.google.common.collect.BiMap<K, V> biMap;
        MutableBiMap<K, V> delegate$kotlinx_bimap;
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        if (!(receiver instanceof GuavaBiMapWrapper)) {
            biMap = null;
        } else {
            biMap = receiver;
        }
        GuavaBiMapWrapper guavaBiMapWrapper = (GuavaBiMapWrapper) biMap;
        if (guavaBiMapWrapper == null || (delegate$kotlinx_bimap = guavaBiMapWrapper.getDelegate$kotlinx_bimap()) == null) {
            return new MutableBiMapWrapper(receiver);
        }
        return delegate$kotlinx_bimap;
    }

    @NotNull
    public static final <K, V> MutableBiMap<K, V> c(@NotNull Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        HashBiMap create = HashBiMap.create(pairs.length);
        Intrinsics.checkExpressionValueIsNotNull(create, "HashBiMap.create<K, V>(pairs.size)");
        MutableBiMap<K, V> asMutableBiMap = BiMapsKt.asMutableBiMap(create);
        s.putAll(asMutableBiMap, pairs);
        return asMutableBiMap;
    }

    @NotNull
    public static final <K, V> MutableBiMap<K, V> d(@NotNull Map<K, ? extends V> receiver) {
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        HashBiMap create = HashBiMap.create(receiver.size());
        Intrinsics.checkExpressionValueIsNotNull(create, "HashBiMap.create<K, V>(size)");
        MutableBiMap<K, V> asMutableBiMap = BiMapsKt.asMutableBiMap(create);
        asMutableBiMap.putAll(receiver);
        return asMutableBiMap;
    }
}
