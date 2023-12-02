package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Platform {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f26349a = Logger.getLogger(Platform.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final PatternCompiler f26350b = e();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class JdkPatternCompiler implements PatternCompiler {
        private JdkPatternCompiler() {
        }

        @Override // com.google.common.base.PatternCompiler
        public CommonPattern a(String str) {
            return new JdkPattern(Pattern.compile(str));
        }
    }

    private Platform() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CommonPattern a(String str) {
        Preconditions.checkNotNull(str);
        return f26350b.a(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CheckForNull
    public static String b(@CheckForNull String str) {
        if (h(str)) {
            return null;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(double d4) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends Enum<T>> Optional<T> d(Class<T> cls, String str) {
        WeakReference<? extends Enum<?>> weakReference = Enums.a(cls).get(str);
        if (weakReference == null) {
            return Optional.absent();
        }
        return Optional.of(cls.cast(weakReference.get()));
    }

    private static PatternCompiler e() {
        return new JdkPatternCompiler();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String f(@CheckForNull String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CharMatcher g(CharMatcher charMatcher) {
        return charMatcher.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(@CheckForNull String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }
}
