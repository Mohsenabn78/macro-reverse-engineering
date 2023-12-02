package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.lang.ref.WeakReference;

@GwtCompatible(emulated = true)
/* loaded from: classes5.dex */
final class Platform {
    private Platform() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends Enum<T>> Optional<T> a(Class<T> cls, String str) {
        WeakReference<? extends Enum<?>> weakReference = Enums.a(cls).get(str);
        if (weakReference == null) {
            return Optional.absent();
        }
        return Optional.of(cls.cast(weakReference.get()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CharMatcher b(CharMatcher charMatcher) {
        return charMatcher.e();
    }
}
