package com.google.android.datatransport.runtime.util;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.google.android.datatransport.Priority;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class PriorityMapping {

    /* renamed from: a  reason: collision with root package name */
    private static SparseArray<Priority> f18947a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<Priority, Integer> f18948b;

    static {
        HashMap<Priority, Integer> hashMap = new HashMap<>();
        f18948b = hashMap;
        hashMap.put(Priority.DEFAULT, 0);
        f18948b.put(Priority.VERY_LOW, 1);
        f18948b.put(Priority.HIGHEST, 2);
        for (Priority priority : f18948b.keySet()) {
            f18947a.append(f18948b.get(priority).intValue(), priority);
        }
    }

    public static int toInt(@NonNull Priority priority) {
        Integer num = f18948b.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }

    @NonNull
    public static Priority valueOf(int i4) {
        Priority priority = f18947a.get(i4);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i4);
    }
}
