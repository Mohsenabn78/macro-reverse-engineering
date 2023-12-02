package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes5.dex */
public class Joiner {

    /* renamed from: a  reason: collision with root package name */
    private final String f25948a;

    /* loaded from: classes5.dex */
    public static final class MapJoiner {

        /* renamed from: a  reason: collision with root package name */
        private final Joiner f25955a;

        /* renamed from: b  reason: collision with root package name */
        private final String f25956b;

        public <A extends Appendable> A appendTo(A a4, Map<?, ?> map) throws IOException {
            return (A) appendTo((MapJoiner) a4, (Iterable<? extends Map.Entry<?, ?>>) map.entrySet());
        }

        public String join(Map<?, ?> map) {
            return join(map.entrySet());
        }

        @CheckReturnValue
        public MapJoiner useForNull(String str) {
            return new MapJoiner(this.f25955a.useForNull(str), this.f25956b);
        }

        private MapJoiner(Joiner joiner, String str) {
            this.f25955a = joiner;
            this.f25956b = (String) Preconditions.checkNotNull(str);
        }

        public StringBuilder appendTo(StringBuilder sb, Map<?, ?> map) {
            return appendTo(sb, (Iterable<? extends Map.Entry<?, ?>>) map.entrySet());
        }

        @Beta
        public String join(Iterable<? extends Map.Entry<?, ?>> iterable) {
            return join(iterable.iterator());
        }

        @Beta
        public <A extends Appendable> A appendTo(A a4, Iterable<? extends Map.Entry<?, ?>> iterable) throws IOException {
            return (A) appendTo((MapJoiner) a4, iterable.iterator());
        }

        @Beta
        public String join(Iterator<? extends Map.Entry<?, ?>> it) {
            return appendTo(new StringBuilder(), it).toString();
        }

        @Beta
        public <A extends Appendable> A appendTo(A a4, Iterator<? extends Map.Entry<?, ?>> it) throws IOException {
            Preconditions.checkNotNull(a4);
            if (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                a4.append(this.f25955a.c(next.getKey()));
                a4.append(this.f25956b);
                a4.append(this.f25955a.c(next.getValue()));
                while (it.hasNext()) {
                    a4.append(this.f25955a.f25948a);
                    Map.Entry<?, ?> next2 = it.next();
                    a4.append(this.f25955a.c(next2.getKey()));
                    a4.append(this.f25956b);
                    a4.append(this.f25955a.c(next2.getValue()));
                }
            }
            return a4;
        }

        @Beta
        public StringBuilder appendTo(StringBuilder sb, Iterable<? extends Map.Entry<?, ?>> iterable) {
            return appendTo(sb, iterable.iterator());
        }

        @Beta
        public StringBuilder appendTo(StringBuilder sb, Iterator<? extends Map.Entry<?, ?>> it) {
            try {
                appendTo((MapJoiner) sb, it);
                return sb;
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }
    }

    private static Iterable<Object> b(final Object obj, final Object obj2, final Object[] objArr) {
        Preconditions.checkNotNull(objArr);
        return new AbstractList<Object>() { // from class: com.google.api.client.repackaged.com.google.common.base.Joiner.3
            @Override // java.util.AbstractList, java.util.List
            public Object get(int i4) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        return objArr[i4 - 2];
                    }
                    return obj2;
                }
                return obj;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return objArr.length + 2;
            }
        };
    }

    public static Joiner on(String str) {
        return new Joiner(str);
    }

    public <A extends Appendable> A appendTo(A a4, Iterable<?> iterable) throws IOException {
        return (A) appendTo((Joiner) a4, iterable.iterator());
    }

    CharSequence c(Object obj) {
        Preconditions.checkNotNull(obj);
        if (obj instanceof CharSequence) {
            return (CharSequence) obj;
        }
        return obj.toString();
    }

    public final String join(Iterable<?> iterable) {
        return join(iterable.iterator());
    }

    @CheckReturnValue
    public Joiner skipNulls() {
        return new Joiner(this) { // from class: com.google.api.client.repackaged.com.google.common.base.Joiner.2
            @Override // com.google.api.client.repackaged.com.google.common.base.Joiner
            public <A extends Appendable> A appendTo(A a4, Iterator<?> it) throws IOException {
                Preconditions.checkNotNull(a4, "appendable");
                Preconditions.checkNotNull(it, "parts");
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (next != null) {
                        a4.append(Joiner.this.c(next));
                        break;
                    }
                }
                while (it.hasNext()) {
                    Object next2 = it.next();
                    if (next2 != null) {
                        a4.append(Joiner.this.f25948a);
                        a4.append(Joiner.this.c(next2));
                    }
                }
                return a4;
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.Joiner
            public Joiner useForNull(String str) {
                throw new UnsupportedOperationException("already specified skipNulls");
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.Joiner
            public MapJoiner withKeyValueSeparator(String str) {
                throw new UnsupportedOperationException("can't use .skipNulls() with maps");
            }
        };
    }

    @CheckReturnValue
    public Joiner useForNull(final String str) {
        Preconditions.checkNotNull(str);
        return new Joiner(this) { // from class: com.google.api.client.repackaged.com.google.common.base.Joiner.1
            @Override // com.google.api.client.repackaged.com.google.common.base.Joiner
            CharSequence c(@Nullable Object obj) {
                if (obj == null) {
                    return str;
                }
                return Joiner.this.c(obj);
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.Joiner
            public Joiner skipNulls() {
                throw new UnsupportedOperationException("already specified useForNull");
            }

            @Override // com.google.api.client.repackaged.com.google.common.base.Joiner
            public Joiner useForNull(String str2) {
                throw new UnsupportedOperationException("already specified useForNull");
            }
        };
    }

    @CheckReturnValue
    public MapJoiner withKeyValueSeparator(String str) {
        return new MapJoiner(str);
    }

    private Joiner(String str) {
        this.f25948a = (String) Preconditions.checkNotNull(str);
    }

    public static Joiner on(char c4) {
        return new Joiner(String.valueOf(c4));
    }

    public <A extends Appendable> A appendTo(A a4, Iterator<?> it) throws IOException {
        Preconditions.checkNotNull(a4);
        if (it.hasNext()) {
            a4.append(c(it.next()));
            while (it.hasNext()) {
                a4.append(this.f25948a);
                a4.append(c(it.next()));
            }
        }
        return a4;
    }

    public final String join(Iterator<?> it) {
        return appendTo(new StringBuilder(), it).toString();
    }

    public final String join(Object[] objArr) {
        return join(Arrays.asList(objArr));
    }

    private Joiner(Joiner joiner) {
        this.f25948a = joiner.f25948a;
    }

    public final String join(@Nullable Object obj, @Nullable Object obj2, Object... objArr) {
        return join(b(obj, obj2, objArr));
    }

    public final <A extends Appendable> A appendTo(A a4, Object[] objArr) throws IOException {
        return (A) appendTo((Joiner) a4, (Iterable<?>) Arrays.asList(objArr));
    }

    public final <A extends Appendable> A appendTo(A a4, @Nullable Object obj, @Nullable Object obj2, Object... objArr) throws IOException {
        return (A) appendTo((Joiner) a4, b(obj, obj2, objArr));
    }

    public final StringBuilder appendTo(StringBuilder sb, Iterable<?> iterable) {
        return appendTo(sb, iterable.iterator());
    }

    public final StringBuilder appendTo(StringBuilder sb, Iterator<?> it) {
        try {
            appendTo((Joiner) sb, it);
            return sb;
        } catch (IOException e4) {
            throw new AssertionError(e4);
        }
    }

    public final StringBuilder appendTo(StringBuilder sb, Object[] objArr) {
        return appendTo(sb, (Iterable<?>) Arrays.asList(objArr));
    }

    public final StringBuilder appendTo(StringBuilder sb, @Nullable Object obj, @Nullable Object obj2, Object... objArr) {
        return appendTo(sb, b(obj, obj2, objArr));
    }
}
