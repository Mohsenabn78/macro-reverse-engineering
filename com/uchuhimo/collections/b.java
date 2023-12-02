package com.uchuhimo.collections;

import androidx.exifinterface.media.ExifInterface;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.f;
import kotlin.collections.r;
import kotlin.collections.s;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BiMaps.kt */
@Metadata(d1 = {"\u00008\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001e\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\u001a.\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u001aQ\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\b\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\u0006\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\t\u0010\n\u001a2\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u001a\"\u0010\u0011\u001a\u00020\u00102\u000e\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0000\u001a\u0018\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0012\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004H\u0000\"*\u0010\u0019\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00158\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/uchuhimo/collections/BiMap;", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "", "f", "", "Lkotlin/Pair;", "pairs", "b", "([Lkotlin/Pair;)Lcom/uchuhimo/collections/BiMap;", "pair", "a", "bimap", "", "other", "", "d", "map", "", "e", "Lcom/uchuhimo/collections/a;", "Lcom/uchuhimo/collections/a;", "getEmptyBiMap$BiMapsKt__BiMapsKt", "()Lcom/uchuhimo/collections/a;", "emptyBiMap", "kotlinx-bimap"}, k = 5, mv = {1, 4, 0}, xs = "com/uchuhimo/collections/BiMapsKt")
/* loaded from: classes6.dex */
public final /* synthetic */ class b {

    /* renamed from: a  reason: collision with root package name */
    private static final a<Object, Object> f38142a;

    static {
        Map emptyMap;
        Map emptyMap2;
        emptyMap = s.emptyMap();
        emptyMap2 = s.emptyMap();
        f38142a = new a<>(emptyMap, emptyMap2);
    }

    @NotNull
    public static final <K, V> BiMap<K, V> a(@NotNull Pair<? extends K, ? extends V> pair) {
        Map mapOf;
        Map mapOf2;
        Intrinsics.checkParameterIsNotNull(pair, "pair");
        mapOf = r.mapOf(pair);
        mapOf2 = r.mapOf(TuplesKt.to(pair.getSecond(), pair.getFirst()));
        return new a(mapOf, mapOf2);
    }

    @NotNull
    public static final <K, V> BiMap<K, V> b(@NotNull Pair<? extends K, ? extends V>... pairs) {
        Map map;
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        map = s.toMap(pairs);
        return BiMapsKt.toBiMap(map);
    }

    @NotNull
    public static final <K, V> BiMap<K, V> c() {
        a<Object, Object> aVar = f38142a;
        if (aVar != null) {
            return aVar;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.uchuhimo.collections.BiMap<K, V>");
    }

    public static final boolean d(@NotNull BiMap<?, ?> bimap, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(bimap, "bimap");
        if (bimap == obj) {
            return true;
        }
        if (!(obj instanceof BiMap) || ((BiMap) obj).size() != bimap.size()) {
            return false;
        }
        for (Map.Entry<?, ?> entry : bimap.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                Map map = (Map) obj;
                if (map.get(key) != null || !map.containsKey(key)) {
                    return false;
                }
            } else if (!Intrinsics.areEqual(value, ((Map) obj).get(key))) {
                return false;
            }
        }
        return true;
    }

    public static final int e(@NotNull Map<?, ?> map) {
        Intrinsics.checkParameterIsNotNull(map, "map");
        Iterator<T> it = map.entrySet().iterator();
        int i4 = 0;
        while (it.hasNext()) {
            i4 += ((Map.Entry) it.next()).hashCode();
        }
        return i4;
    }

    @NotNull
    public static final <K, V> BiMap<K, V> f(@NotNull Map<K, ? extends V> receiver) {
        int collectionSizeOrDefault;
        Map map;
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        if (!receiver.isEmpty()) {
            Set<Map.Entry<K, ? extends V>> entrySet = receiver.entrySet();
            collectionSizeOrDefault = f.collectionSizeOrDefault(entrySet, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                arrayList.add(TuplesKt.to(entry.getValue(), entry.getKey()));
            }
            map = s.toMap(arrayList);
            return new a(receiver, map);
        }
        return BiMapsKt.emptyBiMap();
    }
}
