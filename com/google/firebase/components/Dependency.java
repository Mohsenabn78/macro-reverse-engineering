package com.google.firebase.components;

/* loaded from: classes5.dex */
public final class Dependency {

    /* renamed from: a  reason: collision with root package name */
    private final Qualified<?> f29209a;

    /* renamed from: b  reason: collision with root package name */
    private final int f29210b;

    /* renamed from: c  reason: collision with root package name */
    private final int f29211c;

    private Dependency(Class<?> cls, int i4, int i5) {
        this(Qualified.unqualified(cls), i4, i5);
    }

    private static String a(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    return "deferred";
                }
                throw new AssertionError("Unsupported injection: " + i4);
            }
            return "provider";
        }
        return "direct";
    }

    public static Dependency deferred(Class<?> cls) {
        return new Dependency(cls, 0, 2);
    }

    @Deprecated
    public static Dependency optional(Class<?> cls) {
        return new Dependency(cls, 0, 0);
    }

    public static Dependency optionalProvider(Class<?> cls) {
        return new Dependency(cls, 0, 1);
    }

    public static Dependency required(Class<?> cls) {
        return new Dependency(cls, 1, 0);
    }

    public static Dependency requiredProvider(Class<?> cls) {
        return new Dependency(cls, 1, 1);
    }

    public static Dependency setOf(Class<?> cls) {
        return new Dependency(cls, 2, 0);
    }

    public static Dependency setOfProvider(Class<?> cls) {
        return new Dependency(cls, 2, 1);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Dependency)) {
            return false;
        }
        Dependency dependency = (Dependency) obj;
        if (!this.f29209a.equals(dependency.f29209a) || this.f29210b != dependency.f29210b || this.f29211c != dependency.f29211c) {
            return false;
        }
        return true;
    }

    public Qualified<?> getInterface() {
        return this.f29209a;
    }

    public int hashCode() {
        return ((((this.f29209a.hashCode() ^ 1000003) * 1000003) ^ this.f29210b) * 1000003) ^ this.f29211c;
    }

    public boolean isDeferred() {
        if (this.f29211c == 2) {
            return true;
        }
        return false;
    }

    public boolean isDirectInjection() {
        if (this.f29211c == 0) {
            return true;
        }
        return false;
    }

    public boolean isRequired() {
        if (this.f29210b == 1) {
            return true;
        }
        return false;
    }

    public boolean isSet() {
        if (this.f29210b == 2) {
            return true;
        }
        return false;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f29209a);
        sb.append(", type=");
        int i4 = this.f29210b;
        if (i4 == 1) {
            str = "required";
        } else if (i4 == 0) {
            str = "optional";
        } else {
            str = "set";
        }
        sb.append(str);
        sb.append(", injection=");
        sb.append(a(this.f29211c));
        sb.append("}");
        return sb.toString();
    }

    private Dependency(Qualified<?> qualified, int i4, int i5) {
        this.f29209a = (Qualified) Preconditions.checkNotNull(qualified, "Null dependency anInterface.");
        this.f29210b = i4;
        this.f29211c = i5;
    }

    public static Dependency deferred(Qualified<?> qualified) {
        return new Dependency(qualified, 0, 2);
    }

    public static Dependency optionalProvider(Qualified<?> qualified) {
        return new Dependency(qualified, 0, 1);
    }

    public static Dependency required(Qualified<?> qualified) {
        return new Dependency(qualified, 1, 0);
    }

    public static Dependency requiredProvider(Qualified<?> qualified) {
        return new Dependency(qualified, 1, 1);
    }

    public static Dependency setOf(Qualified<?> qualified) {
        return new Dependency(qualified, 2, 0);
    }

    public static Dependency setOfProvider(Qualified<?> qualified) {
        return new Dependency(qualified, 2, 1);
    }
}
