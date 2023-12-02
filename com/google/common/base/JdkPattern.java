package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@J2ktIncompatible
@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class JdkPattern extends CommonPattern implements Serializable {
    private static final long serialVersionUID = 0;
    private final Pattern pattern;

    /* loaded from: classes5.dex */
    private static final class JdkMatcher extends CommonMatcher {

        /* renamed from: a  reason: collision with root package name */
        final Matcher f26328a;

        JdkMatcher(Matcher matcher) {
            this.f26328a = (Matcher) Preconditions.checkNotNull(matcher);
        }

        @Override // com.google.common.base.CommonMatcher
        public int a() {
            return this.f26328a.end();
        }

        @Override // com.google.common.base.CommonMatcher
        public boolean b() {
            return this.f26328a.find();
        }

        @Override // com.google.common.base.CommonMatcher
        public boolean c(int i4) {
            return this.f26328a.find(i4);
        }

        @Override // com.google.common.base.CommonMatcher
        public boolean d() {
            return this.f26328a.matches();
        }

        @Override // com.google.common.base.CommonMatcher
        public int e() {
            return this.f26328a.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JdkPattern(Pattern pattern) {
        this.pattern = (Pattern) Preconditions.checkNotNull(pattern);
    }

    @Override // com.google.common.base.CommonPattern
    public int a() {
        return this.pattern.flags();
    }

    @Override // com.google.common.base.CommonPattern
    public CommonMatcher b(CharSequence charSequence) {
        return new JdkMatcher(this.pattern.matcher(charSequence));
    }

    @Override // com.google.common.base.CommonPattern
    public String c() {
        return this.pattern.pattern();
    }

    public String toString() {
        return this.pattern.toString();
    }
}
