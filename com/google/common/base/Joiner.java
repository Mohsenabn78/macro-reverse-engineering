package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class Joiner {

    /* renamed from: a  reason: collision with root package name */
    private final String f26329a;

    /* loaded from: classes5.dex */
    public static final class MapJoiner {

        /* renamed from: a  reason: collision with root package name */
        private final Joiner f26336a;

        /* renamed from: b  reason: collision with root package name */
        private final String f26337b;

        @CanIgnoreReturnValue
        public <A extends Appendable> A appendTo(A a4, Map<?, ?> map) throws IOException {
            return (A) appendTo((MapJoiner) a4, (Iterable<? extends Map.Entry<?, ?>>) map.entrySet());
        }

        public String join(Map<?, ?> map) {
            return join(map.entrySet());
        }

        public MapJoiner useForNull(String str) {
            return new MapJoiner(this.f26336a.useForNull(str), this.f26337b);
        }

        private MapJoiner(Joiner joiner, String str) {
            this.f26336a = joiner;
            this.f26337b = (String) Preconditions.checkNotNull(str);
        }

        @CanIgnoreReturnValue
        public StringBuilder appendTo(StringBuilder sb, Map<?, ?> map) {
            return appendTo(sb, (Iterable<? extends Map.Entry<?, ?>>) map.entrySet());
        }

        public String join(Iterable<? extends Map.Entry<?, ?>> iterable) {
            return join(iterable.iterator());
        }

        @CanIgnoreReturnValue
        public <A extends Appendable> A appendTo(A a4, Iterable<? extends Map.Entry<?, ?>> iterable) throws IOException {
            return (A) appendTo((MapJoiner) a4, iterable.iterator());
        }

        public String join(Iterator<? extends Map.Entry<?, ?>> it) {
            return appendTo(new StringBuilder(), it).toString();
        }

        @CanIgnoreReturnValue
        public <A extends Appendable> A appendTo(A a4, Iterator<? extends Map.Entry<?, ?>> it) throws IOException {
            Preconditions.checkNotNull(a4);
            if (it.hasNext()) {
                Map.Entry<?, ?> next = it.next();
                a4.append(this.f26336a.c(next.getKey()));
                a4.append(this.f26337b);
                a4.append(this.f26336a.c(next.getValue()));
                while (it.hasNext()) {
                    a4.append(this.f26336a.f26329a);
                    Map.Entry<?, ?> next2 = it.next();
                    a4.append(this.f26336a.c(next2.getKey()));
                    a4.append(this.f26337b);
                    a4.append(this.f26336a.c(next2.getValue()));
                }
            }
            return a4;
        }

        @CanIgnoreReturnValue
        public StringBuilder appendTo(StringBuilder sb, Iterable<? extends Map.Entry<?, ?>> iterable) {
            return appendTo(sb, iterable.iterator());
        }

        @CanIgnoreReturnValue
        public StringBuilder appendTo(StringBuilder sb, Iterator<? extends Map.Entry<?, ?>> it) {
            try {
                appendTo((MapJoiner) sb, it);
                return sb;
            } catch (IOException e4) {
                throw new AssertionError(e4);
            }
        }
    }

    private static Iterable<Object> b(@CheckForNull final Object obj, @CheckForNull final Object obj2, final Object[] objArr) {
        Preconditions.checkNotNull(objArr);
        return new AbstractList<Object>() { // from class: com.google.common.base.Joiner.3
            @Override // java.util.AbstractList, java.util.List
            @CheckForNull
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

    @CanIgnoreReturnValue
    public <A extends Appendable> A appendTo(A a4, Iterable<? extends Object> iterable) throws IOException {
        return (A) appendTo((Joiner) a4, iterable.iterator());
    }

    CharSequence c(@CheckForNull Object obj) {
        java.util.Objects.requireNonNull(obj);
        if (obj instanceof CharSequence) {
            return (CharSequence) obj;
        }
        return obj.toString();
    }

    public final String join(Iterable<? extends Object> iterable) {
        return join(iterable.iterator());
    }

    public Joiner skipNulls() {
        return new Joiner(this) { // from class: com.google.common.base.Joiner.2
            @Override // com.google.common.base.Joiner
            public <A extends Appendable> A appendTo(A a4, Iterator<? extends Object> it) throws IOException {
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
                        a4.append(Joiner.this.f26329a);
                        a4.append(Joiner.this.c(next2));
                    }
                }
                return a4;
            }

            @Override // com.google.common.base.Joiner
            public Joiner useForNull(String str) {
                throw new UnsupportedOperationException("already specified skipNulls");
            }

            @Override // com.google.common.base.Joiner
            public MapJoiner withKeyValueSeparator(String str) {
                throw new UnsupportedOperationException("can't use .skipNulls() with maps");
            }
        };
    }

    public Joiner useForNull(final String str) {
        Preconditions.checkNotNull(str);
        return new Joiner(this) { // from class: com.google.common.base.Joiner.1
            @Override // com.google.common.base.Joiner
            CharSequence c(@CheckForNull Object obj) {
                if (obj == null) {
                    return str;
                }
                return Joiner.this.c(obj);
            }

            @Override // com.google.common.base.Joiner
            public Joiner skipNulls() {
                throw new UnsupportedOperationException("already specified useForNull");
            }

            @Override // com.google.common.base.Joiner
            public Joiner useForNull(String str2) {
                throw new UnsupportedOperationException("already specified useForNull");
            }
        };
    }

    public MapJoiner withKeyValueSeparator(char c4) {
        return withKeyValueSeparator(String.valueOf(c4));
    }

    private Joiner(String str) {
        this.f26329a = (String) Preconditions.checkNotNull(str);
    }

    public static Joiner on(char c4) {
        return new Joiner(String.valueOf(c4));
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A appendTo(A a4, Iterator<? extends Object> it) throws IOException {
        Preconditions.checkNotNull(a4);
        if (it.hasNext()) {
            a4.append(c(it.next()));
            while (it.hasNext()) {
                a4.append(this.f26329a);
                a4.append(c(it.next()));
            }
        }
        return a4;
    }

    public final String join(Iterator<? extends Object> it) {
        return appendTo(new StringBuilder(), it).toString();
    }

    public MapJoiner withKeyValueSeparator(String str) {
        return new MapJoiner(str);
    }

    public final String join(Object[] objArr) {
        return join(Arrays.asList(objArr));
    }

    private Joiner(Joiner joiner) {
        this.f26329a = joiner.f26329a;
    }

    public final String join(@CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) {
        return join(b(obj, obj2, objArr));
    }

    @CanIgnoreReturnValue
    public final <A extends Appendable> A appendTo(A a4, Object[] objArr) throws IOException {
        return (A) appendTo((Joiner) a4, (Iterable<? extends Object>) Arrays.asList(objArr));
    }

    @CanIgnoreReturnValue
    public final <A extends Appendable> A appendTo(A a4, @CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) throws IOException {
        return (A) appendTo((Joiner) a4, b(obj, obj2, objArr));
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb, Iterable<? extends Object> iterable) {
        return appendTo(sb, iterable.iterator());
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb, Iterator<? extends Object> it) {
        try {
            appendTo((Joiner) sb, it);
            return sb;
        } catch (IOException e4) {
            throw new AssertionError(e4);
        }
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb, Object[] objArr) {
        return appendTo(sb, (Iterable<? extends Object>) Arrays.asList(objArr));
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder sb, @CheckForNull Object obj, @CheckForNull Object obj2, Object... objArr) {
        return appendTo(sb, b(obj, obj2, objArr));
    }
}
