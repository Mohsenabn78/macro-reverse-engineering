package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;
import net.bytebuddy.pool.TypePool;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Splitter {

    /* renamed from: a  reason: collision with root package name */
    private final CharMatcher f26361a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f26362b;

    /* renamed from: c  reason: collision with root package name */
    private final Strategy f26363c;

    /* renamed from: d  reason: collision with root package name */
    private final int f26364d;

    /* loaded from: classes5.dex */
    public static final class MapSplitter {

        /* renamed from: a  reason: collision with root package name */
        private final Splitter f26375a;

        /* renamed from: b  reason: collision with root package name */
        private final Splitter f26376b;

        public Map<String, String> split(CharSequence charSequence) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : this.f26375a.split(charSequence)) {
                Iterator f4 = this.f26376b.f(str);
                Preconditions.checkArgument(f4.hasNext(), "Chunk [%s] is not a valid entry", str);
                String str2 = (String) f4.next();
                Preconditions.checkArgument(!linkedHashMap.containsKey(str2), "Duplicate key [%s] found.", str2);
                Preconditions.checkArgument(f4.hasNext(), "Chunk [%s] is not a valid entry", str);
                linkedHashMap.put(str2, (String) f4.next());
                Preconditions.checkArgument(!f4.hasNext(), "Chunk [%s] is not a valid entry", str);
            }
            return Collections.unmodifiableMap(linkedHashMap);
        }

        private MapSplitter(Splitter splitter, Splitter splitter2) {
            this.f26375a = splitter;
            this.f26376b = (Splitter) Preconditions.checkNotNull(splitter2);
        }
    }

    /* loaded from: classes5.dex */
    private static abstract class SplittingIterator extends AbstractIterator<String> {

        /* renamed from: c  reason: collision with root package name */
        final CharSequence f26377c;

        /* renamed from: d  reason: collision with root package name */
        final CharMatcher f26378d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f26379e;

        /* renamed from: f  reason: collision with root package name */
        int f26380f = 0;

        /* renamed from: g  reason: collision with root package name */
        int f26381g;

        protected SplittingIterator(Splitter splitter, CharSequence charSequence) {
            this.f26378d = splitter.f26361a;
            this.f26379e = splitter.f26362b;
            this.f26381g = splitter.f26364d;
            this.f26377c = charSequence;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.AbstractIterator
        @CheckForNull
        /* renamed from: d */
        public String a() {
            int f4;
            int i4 = this.f26380f;
            while (true) {
                int i5 = this.f26380f;
                if (i5 != -1) {
                    f4 = f(i5);
                    if (f4 == -1) {
                        f4 = this.f26377c.length();
                        this.f26380f = -1;
                    } else {
                        this.f26380f = e(f4);
                    }
                    int i6 = this.f26380f;
                    if (i6 == i4) {
                        int i7 = i6 + 1;
                        this.f26380f = i7;
                        if (i7 > this.f26377c.length()) {
                            this.f26380f = -1;
                        }
                    } else {
                        while (i4 < f4 && this.f26378d.matches(this.f26377c.charAt(i4))) {
                            i4++;
                        }
                        while (f4 > i4 && this.f26378d.matches(this.f26377c.charAt(f4 - 1))) {
                            f4--;
                        }
                        if (!this.f26379e || i4 != f4) {
                            break;
                        }
                        i4 = this.f26380f;
                    }
                } else {
                    return b();
                }
            }
            int i8 = this.f26381g;
            if (i8 == 1) {
                f4 = this.f26377c.length();
                this.f26380f = -1;
                while (f4 > i4 && this.f26378d.matches(this.f26377c.charAt(f4 - 1))) {
                    f4--;
                }
            } else {
                this.f26381g = i8 - 1;
            }
            return this.f26377c.subSequence(i4, f4).toString();
        }

        abstract int e(int i4);

        abstract int f(int i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface Strategy {
        Iterator<String> a(Splitter splitter, CharSequence charSequence);
    }

    private Splitter(Strategy strategy) {
        this(strategy, false, CharMatcher.none(), Integer.MAX_VALUE);
    }

    private static Splitter e(final CommonPattern commonPattern) {
        Preconditions.checkArgument(!commonPattern.b("").d(), "The pattern may not match the empty string: %s", commonPattern);
        return new Splitter(new Strategy() { // from class: com.google.common.base.Splitter.3
            @Override // com.google.common.base.Splitter.Strategy
            /* renamed from: b */
            public SplittingIterator a(Splitter splitter, CharSequence charSequence) {
                final CommonMatcher b4 = CommonPattern.this.b(charSequence);
                return new SplittingIterator(this, splitter, charSequence) { // from class: com.google.common.base.Splitter.3.1
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int e(int i4) {
                        return b4.a();
                    }

                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int f(int i4) {
                        if (b4.c(i4)) {
                            return b4.e();
                        }
                        return -1;
                    }
                };
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Iterator<String> f(CharSequence charSequence) {
        return this.f26363c.a(this, charSequence);
    }

    public static Splitter fixedLength(final int i4) {
        boolean z3;
        if (i4 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "The length may not be less than 1");
        return new Splitter(new Strategy() { // from class: com.google.common.base.Splitter.4
            @Override // com.google.common.base.Splitter.Strategy
            /* renamed from: b */
            public SplittingIterator a(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) { // from class: com.google.common.base.Splitter.4.1
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int f(int i5) {
                        int i6 = i5 + i4;
                        if (i6 >= this.f26377c.length()) {
                            return -1;
                        }
                        return i6;
                    }

                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int e(int i5) {
                        return i5;
                    }
                };
            }
        });
    }

    public static Splitter on(char c4) {
        return on(CharMatcher.is(c4));
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static Splitter onPattern(String str) {
        return e(Platform.a(str));
    }

    public Splitter limit(int i4) {
        boolean z3;
        if (i4 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "must be greater than zero: %s", i4);
        return new Splitter(this.f26363c, this.f26362b, this.f26361a, i4);
    }

    public Splitter omitEmptyStrings() {
        return new Splitter(this.f26363c, true, this.f26361a, this.f26364d);
    }

    public Iterable<String> split(final CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return new Iterable<String>() { // from class: com.google.common.base.Splitter.5
            @Override // java.lang.Iterable
            public Iterator<String> iterator() {
                return Splitter.this.f(charSequence);
            }

            public String toString() {
                Joiner on = Joiner.on(", ");
                StringBuilder sb = new StringBuilder();
                sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
                StringBuilder appendTo = on.appendTo(sb, (Iterable<? extends Object>) this);
                appendTo.append(']');
                return appendTo.toString();
            }
        };
    }

    public List<String> splitToList(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Iterator<String> f4 = f(charSequence);
        ArrayList arrayList = new ArrayList();
        while (f4.hasNext()) {
            arrayList.add(f4.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Splitter trimResults() {
        return trimResults(CharMatcher.whitespace());
    }

    public MapSplitter withKeyValueSeparator(String str) {
        return withKeyValueSeparator(on(str));
    }

    private Splitter(Strategy strategy, boolean z3, CharMatcher charMatcher, int i4) {
        this.f26363c = strategy;
        this.f26362b = z3;
        this.f26361a = charMatcher;
        this.f26364d = i4;
    }

    public static Splitter on(final CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(new Strategy() { // from class: com.google.common.base.Splitter.1
            @Override // com.google.common.base.Splitter.Strategy
            /* renamed from: b */
            public SplittingIterator a(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) { // from class: com.google.common.base.Splitter.1.1
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    int e(int i4) {
                        return i4 + 1;
                    }

                    @Override // com.google.common.base.Splitter.SplittingIterator
                    int f(int i4) {
                        return CharMatcher.this.indexIn(this.f26377c, i4);
                    }
                };
            }
        });
    }

    public Splitter trimResults(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(this.f26363c, this.f26362b, charMatcher, this.f26364d);
    }

    public MapSplitter withKeyValueSeparator(char c4) {
        return withKeyValueSeparator(on(c4));
    }

    public MapSplitter withKeyValueSeparator(Splitter splitter) {
        return new MapSplitter(splitter);
    }

    public static Splitter on(final String str) {
        Preconditions.checkArgument(str.length() != 0, "The separator may not be the empty string.");
        if (str.length() == 1) {
            return on(str.charAt(0));
        }
        return new Splitter(new Strategy() { // from class: com.google.common.base.Splitter.2
            @Override // com.google.common.base.Splitter.Strategy
            /* renamed from: b */
            public SplittingIterator a(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) { // from class: com.google.common.base.Splitter.2.1
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int e(int i4) {
                        return i4 + str.length();
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
                        r6 = r6 + 1;
                     */
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public int f(int r6) {
                        /*
                            r5 = this;
                            com.google.common.base.Splitter$2 r0 = com.google.common.base.Splitter.AnonymousClass2.this
                            java.lang.String r0 = r1
                            int r0 = r0.length()
                            java.lang.CharSequence r1 = r5.f26377c
                            int r1 = r1.length()
                            int r1 = r1 - r0
                        Lf:
                            if (r6 > r1) goto L2d
                            r2 = 0
                        L12:
                            if (r2 >= r0) goto L2c
                            java.lang.CharSequence r3 = r5.f26377c
                            int r4 = r2 + r6
                            char r3 = r3.charAt(r4)
                            com.google.common.base.Splitter$2 r4 = com.google.common.base.Splitter.AnonymousClass2.this
                            java.lang.String r4 = r1
                            char r4 = r4.charAt(r2)
                            if (r3 == r4) goto L29
                            int r6 = r6 + 1
                            goto Lf
                        L29:
                            int r2 = r2 + 1
                            goto L12
                        L2c:
                            return r6
                        L2d:
                            r6 = -1
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Splitter.AnonymousClass2.AnonymousClass1.f(int):int");
                    }
                };
            }
        });
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static Splitter on(Pattern pattern) {
        return e(new JdkPattern(pattern));
    }
}
