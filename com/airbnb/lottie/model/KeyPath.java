package com.airbnb.lottie.model;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class KeyPath {
    public static final KeyPath COMPOSITION = new KeyPath("COMPOSITION");

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f1601a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private KeyPathElement f1602b;

    public KeyPath(String... strArr) {
        this.f1601a = Arrays.asList(strArr);
    }

    private boolean a() {
        List<String> list = this.f1601a;
        return list.get(list.size() - 1).equals("**");
    }

    private boolean b(String str) {
        return "__container".equals(str);
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPath addKey(String str) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.f1601a.add(str);
        return keyPath;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean fullyResolvesTo(String str, int i4) {
        boolean z3;
        boolean z4;
        boolean z5;
        if (i4 >= this.f1601a.size()) {
            return false;
        }
        if (i4 == this.f1601a.size() - 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        String str2 = this.f1601a.get(i4);
        if (!str2.equals("**")) {
            if (!str2.equals(str) && !str2.equals("*")) {
                z5 = false;
            } else {
                z5 = true;
            }
            if ((!z3 && (i4 != this.f1601a.size() - 2 || !a())) || !z5) {
                return false;
            }
            return true;
        }
        if (!z3 && this.f1601a.get(i4 + 1).equals(str)) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            if (i4 != this.f1601a.size() - 2 && (i4 != this.f1601a.size() - 3 || !a())) {
                return false;
            }
            return true;
        } else if (z3) {
            return true;
        } else {
            int i5 = i4 + 1;
            if (i5 < this.f1601a.size() - 1) {
                return false;
            }
            return this.f1601a.get(i5).equals(str);
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPathElement getResolvedElement() {
        return this.f1602b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int incrementDepthBy(String str, int i4) {
        if (b(str)) {
            return 0;
        }
        if (!this.f1601a.get(i4).equals("**")) {
            return 1;
        }
        if (i4 == this.f1601a.size() - 1 || !this.f1601a.get(i4 + 1).equals(str)) {
            return 0;
        }
        return 2;
    }

    public String keysToString() {
        return this.f1601a.toString();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean matches(String str, int i4) {
        if (b(str)) {
            return true;
        }
        if (i4 >= this.f1601a.size()) {
            return false;
        }
        if (this.f1601a.get(i4).equals(str) || this.f1601a.get(i4).equals("**") || this.f1601a.get(i4).equals("*")) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean propagateToChildren(String str, int i4) {
        if ("__container".equals(str) || i4 < this.f1601a.size() - 1 || this.f1601a.get(i4).equals("**")) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public KeyPath resolve(KeyPathElement keyPathElement) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.f1602b = keyPathElement;
        return keyPath;
    }

    public String toString() {
        boolean z3;
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f1601a);
        sb.append(",resolved=");
        if (this.f1602b != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        sb.append(z3);
        sb.append('}');
        return sb.toString();
    }

    private KeyPath(KeyPath keyPath) {
        this.f1601a = new ArrayList(keyPath.f1601a);
        this.f1602b = keyPath.f1602b;
    }
}
