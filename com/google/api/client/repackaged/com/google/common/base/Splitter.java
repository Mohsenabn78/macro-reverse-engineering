package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import com.google.api.client.repackaged.com.google.common.annotations.GwtIncompatible;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.CheckReturnValue;
import net.bytebuddy.pool.TypePool;

@GwtCompatible(emulated = true)
/* loaded from: classes5.dex */
public final class Splitter {

    /* renamed from: a  reason: collision with root package name */
    private final CharMatcher f25970a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f25971b;

    /* renamed from: c  reason: collision with root package name */
    private final Strategy f25972c;

    /* renamed from: d  reason: collision with root package name */
    private final int f25973d;

    @Beta
    /* loaded from: classes5.dex */
    public static final class MapSplitter {

        /* renamed from: a  reason: collision with root package name */
        private final Splitter f25985a;

        /* renamed from: b  reason: collision with root package name */
        private final Splitter f25986b;

        public Map<String, String> split(CharSequence charSequence) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : this.f25985a.split(charSequence)) {
                Iterator e4 = this.f25986b.e(str);
                Preconditions.checkArgument(e4.hasNext(), "Chunk [%s] is not a valid entry", str);
                String str2 = (String) e4.next();
                Preconditions.checkArgument(!linkedHashMap.containsKey(str2), "Duplicate key [%s] found.", str2);
                Preconditions.checkArgument(e4.hasNext(), "Chunk [%s] is not a valid entry", str);
                linkedHashMap.put(str2, (String) e4.next());
                Preconditions.checkArgument(!e4.hasNext(), "Chunk [%s] is not a valid entry", str);
            }
            return Collections.unmodifiableMap(linkedHashMap);
        }

        private MapSplitter(Splitter splitter, Splitter splitter2) {
            this.f25985a = splitter;
            this.f25986b = (Splitter) Preconditions.checkNotNull(splitter2);
        }
    }

    /* loaded from: classes5.dex */
    private static abstract class SplittingIterator extends AbstractIterator<String> {

        /* renamed from: c  reason: collision with root package name */
        final CharSequence f25987c;

        /* renamed from: d  reason: collision with root package name */
        final CharMatcher f25988d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f25989e;

        /* renamed from: f  reason: collision with root package name */
        int f25990f = 0;

        /* renamed from: g  reason: collision with root package name */
        int f25991g;

        protected SplittingIterator(Splitter splitter, CharSequence charSequence) {
            this.f25988d = splitter.f25970a;
            this.f25989e = splitter.f25971b;
            this.f25991g = splitter.f25973d;
            this.f25987c = charSequence;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.api.client.repackaged.com.google.common.base.AbstractIterator
        /* renamed from: d */
        public String a() {
            int f4;
            int i4 = this.f25990f;
            while (true) {
                int i5 = this.f25990f;
                if (i5 != -1) {
                    f4 = f(i5);
                    if (f4 == -1) {
                        f4 = this.f25987c.length();
                        this.f25990f = -1;
                    } else {
                        this.f25990f = e(f4);
                    }
                    int i6 = this.f25990f;
                    if (i6 == i4) {
                        int i7 = i6 + 1;
                        this.f25990f = i7;
                        if (i7 >= this.f25987c.length()) {
                            this.f25990f = -1;
                        }
                    } else {
                        while (i4 < f4 && this.f25988d.matches(this.f25987c.charAt(i4))) {
                            i4++;
                        }
                        while (f4 > i4 && this.f25988d.matches(this.f25987c.charAt(f4 - 1))) {
                            f4--;
                        }
                        if (!this.f25989e || i4 != f4) {
                            break;
                        }
                        i4 = this.f25990f;
                    }
                } else {
                    return b();
                }
            }
            int i8 = this.f25991g;
            if (i8 == 1) {
                f4 = this.f25987c.length();
                this.f25990f = -1;
                while (f4 > i4 && this.f25988d.matches(this.f25987c.charAt(f4 - 1))) {
                    f4--;
                }
            } else {
                this.f25991g = i8 - 1;
            }
            return this.f25987c.subSequence(i4, f4).toString();
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
        this(strategy, false, CharMatcher.NONE, Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Iterator<String> e(CharSequence charSequence) {
        return this.f25972c.a(this, charSequence);
    }

    public static Splitter fixedLength(final int i4) {
        boolean z3;
        if (i4 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "The length may not be less than 1");
        return new Splitter(new Strategy() { // from class: com.google.api.client.repackaged.com.google.common.base.Splitter.4
            @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.Strategy
            /* renamed from: b */
            public SplittingIterator a(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) { // from class: com.google.api.client.repackaged.com.google.common.base.Splitter.4.1
                    @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.SplittingIterator
                    public int f(int i5) {
                        int i6 = i5 + i4;
                        if (i6 >= this.f25987c.length()) {
                            return -1;
                        }
                        return i6;
                    }

                    @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.SplittingIterator
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

    @GwtIncompatible("java.util.regex")
    public static Splitter onPattern(String str) {
        return on(Pattern.compile(str));
    }

    @CheckReturnValue
    public Splitter limit(int i4) {
        boolean z3;
        if (i4 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "must be greater than zero: %s", Integer.valueOf(i4));
        return new Splitter(this.f25972c, this.f25971b, this.f25970a, i4);
    }

    @CheckReturnValue
    public Splitter omitEmptyStrings() {
        return new Splitter(this.f25972c, true, this.f25970a, this.f25973d);
    }

    public Iterable<String> split(final CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return new Iterable<String>() { // from class: com.google.api.client.repackaged.com.google.common.base.Splitter.5
            @Override // java.lang.Iterable
            public Iterator<String> iterator() {
                return Splitter.this.e(charSequence);
            }

            public String toString() {
                Joiner on = Joiner.on(", ");
                StringBuilder sb = new StringBuilder();
                sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
                StringBuilder appendTo = on.appendTo(sb, (Iterable<?>) this);
                appendTo.append(']');
                return appendTo.toString();
            }
        };
    }

    @Beta
    public List<String> splitToList(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Iterator<String> e4 = e(charSequence);
        ArrayList arrayList = new ArrayList();
        while (e4.hasNext()) {
            arrayList.add(e4.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    @CheckReturnValue
    public Splitter trimResults() {
        return trimResults(CharMatcher.WHITESPACE);
    }

    @Beta
    @CheckReturnValue
    public MapSplitter withKeyValueSeparator(String str) {
        return withKeyValueSeparator(on(str));
    }

    private Splitter(Strategy strategy, boolean z3, CharMatcher charMatcher, int i4) {
        this.f25972c = strategy;
        this.f25971b = z3;
        this.f25970a = charMatcher;
        this.f25973d = i4;
    }

    public static Splitter on(final CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(new Strategy() { // from class: com.google.api.client.repackaged.com.google.common.base.Splitter.1
            @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.Strategy
            /* renamed from: b */
            public SplittingIterator a(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) { // from class: com.google.api.client.repackaged.com.google.common.base.Splitter.1.1
                    @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.SplittingIterator
                    int e(int i4) {
                        return i4 + 1;
                    }

                    @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.SplittingIterator
                    int f(int i4) {
                        return CharMatcher.this.indexIn(this.f25987c, i4);
                    }
                };
            }
        });
    }

    @CheckReturnValue
    public Splitter trimResults(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(this.f25972c, this.f25971b, charMatcher, this.f25973d);
    }

    @Beta
    @CheckReturnValue
    public MapSplitter withKeyValueSeparator(char c4) {
        return withKeyValueSeparator(on(c4));
    }

    @Beta
    @CheckReturnValue
    public MapSplitter withKeyValueSeparator(Splitter splitter) {
        return new MapSplitter(splitter);
    }

    public static Splitter on(final String str) {
        Preconditions.checkArgument(str.length() != 0, "The separator may not be the empty string.");
        return new Splitter(new Strategy() { // from class: com.google.api.client.repackaged.com.google.common.base.Splitter.2
            @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.Strategy
            /* renamed from: b */
            public SplittingIterator a(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) { // from class: com.google.api.client.repackaged.com.google.common.base.Splitter.2.1
                    @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.SplittingIterator
                    public int e(int i4) {
                        return i4 + str.length();
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
                        r6 = r6 + 1;
                     */
                    @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.SplittingIterator
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public int f(int r6) {
                        /*
                            r5 = this;
                            com.google.api.client.repackaged.com.google.common.base.Splitter$2 r0 = com.google.api.client.repackaged.com.google.common.base.Splitter.AnonymousClass2.this
                            java.lang.String r0 = r1
                            int r0 = r0.length()
                            java.lang.CharSequence r1 = r5.f25987c
                            int r1 = r1.length()
                            int r1 = r1 - r0
                        Lf:
                            if (r6 > r1) goto L2d
                            r2 = 0
                        L12:
                            if (r2 >= r0) goto L2c
                            java.lang.CharSequence r3 = r5.f25987c
                            int r4 = r2 + r6
                            char r3 = r3.charAt(r4)
                            com.google.api.client.repackaged.com.google.common.base.Splitter$2 r4 = com.google.api.client.repackaged.com.google.common.base.Splitter.AnonymousClass2.this
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
                        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.repackaged.com.google.common.base.Splitter.AnonymousClass2.AnonymousClass1.f(int):int");
                    }
                };
            }
        });
    }

    @GwtIncompatible("java.util.regex")
    public static Splitter on(final Pattern pattern) {
        Preconditions.checkNotNull(pattern);
        Preconditions.checkArgument(!pattern.matcher("").matches(), "The pattern may not match the empty string: %s", pattern);
        return new Splitter(new Strategy() { // from class: com.google.api.client.repackaged.com.google.common.base.Splitter.3
            @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.Strategy
            /* renamed from: b */
            public SplittingIterator a(Splitter splitter, CharSequence charSequence) {
                final Matcher matcher = pattern.matcher(charSequence);
                return new SplittingIterator(splitter, charSequence) { // from class: com.google.api.client.repackaged.com.google.common.base.Splitter.3.1
                    @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.SplittingIterator
                    public int e(int i4) {
                        return matcher.end();
                    }

                    @Override // com.google.api.client.repackaged.com.google.common.base.Splitter.SplittingIterator
                    public int f(int i4) {
                        if (matcher.find(i4)) {
                            return matcher.start();
                        }
                        return -1;
                    }
                };
            }
        });
    }
}
