package com.google.android.gms.location.places;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ShowFirstParty
/* loaded from: classes4.dex */
public abstract class zzb extends AbstractSafeParcelable {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> List<E> b(@Nullable Collection<E> collection) {
        if (collection != null && !collection.isEmpty()) {
            return new ArrayList(collection);
        }
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Set<E> c(List<E> list) {
        if (list != null && !list.isEmpty()) {
            return Collections.unmodifiableSet(new HashSet(list));
        }
        return Collections.emptySet();
    }

    public abstract Set<String> getPlaceIds();

    public boolean isRestrictedToPlacesOpenNow() {
        return false;
    }
}
