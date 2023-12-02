package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import java.util.Map;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
interface FilteredMultimap<K, V> extends Multimap<K, V> {
    Multimap<K, V> a();

    Predicate<? super Map.Entry<K, V>> c();
}
