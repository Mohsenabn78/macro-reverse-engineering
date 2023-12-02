package com.koushikdutta.async.http.spdy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: Util.java */
/* loaded from: classes6.dex */
final class m {
    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }
}
