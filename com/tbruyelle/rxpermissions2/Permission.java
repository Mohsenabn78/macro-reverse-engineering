package com.tbruyelle.rxpermissions2;

import io.reactivex.Observable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.List;

/* loaded from: classes6.dex */
public class Permission {
    public final boolean granted;
    public final String name;
    public final boolean shouldShowRequestPermissionRationale;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements BiConsumer<StringBuilder, String> {
        a() {
        }

        @Override // io.reactivex.functions.BiConsumer
        /* renamed from: a */
        public void accept(StringBuilder sb, String str) throws Exception {
            if (sb.length() == 0) {
                sb.append(str);
                return;
            }
            sb.append(", ");
            sb.append(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements Function<Permission, String> {
        b() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public String apply(Permission permission) throws Exception {
            return permission.name;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements Predicate<Permission> {
        c() {
        }

        @Override // io.reactivex.functions.Predicate
        /* renamed from: a */
        public boolean test(Permission permission) throws Exception {
            return permission.granted;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements Predicate<Permission> {
        d() {
        }

        @Override // io.reactivex.functions.Predicate
        /* renamed from: a */
        public boolean test(Permission permission) throws Exception {
            return permission.shouldShowRequestPermissionRationale;
        }
    }

    public Permission(String str, boolean z3) {
        this(str, z3, false);
    }

    private Boolean a(List<Permission> list) {
        return Observable.fromIterable(list).all(new c()).blockingGet();
    }

    private String b(List<Permission> list) {
        return ((StringBuilder) Observable.fromIterable(list).map(new b()).collectInto(new StringBuilder(), new a()).blockingGet()).toString();
    }

    private Boolean c(List<Permission> list) {
        return Observable.fromIterable(list).any(new d()).blockingGet();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Permission permission = (Permission) obj;
        if (this.granted != permission.granted || this.shouldShowRequestPermissionRationale != permission.shouldShowRequestPermissionRationale) {
            return false;
        }
        return this.name.equals(permission.name);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + (this.granted ? 1 : 0)) * 31) + (this.shouldShowRequestPermissionRationale ? 1 : 0);
    }

    public String toString() {
        return "Permission{name='" + this.name + "', granted=" + this.granted + ", shouldShowRequestPermissionRationale=" + this.shouldShowRequestPermissionRationale + '}';
    }

    public Permission(String str, boolean z3, boolean z4) {
        this.name = str;
        this.granted = z3;
        this.shouldShowRequestPermissionRationale = z4;
    }

    public Permission(List<Permission> list) {
        this.name = b(list);
        this.granted = a(list).booleanValue();
        this.shouldShowRequestPermissionRationale = c(list).booleanValue();
    }
}
