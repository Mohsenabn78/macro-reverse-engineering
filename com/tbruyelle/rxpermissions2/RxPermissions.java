package com.tbruyelle.rxpermissions2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class RxPermissions {

    /* renamed from: b  reason: collision with root package name */
    static final String f37991b = "RxPermissions";

    /* renamed from: c  reason: collision with root package name */
    static final Object f37992c = new Object();
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    Lazy<RxPermissionsFragment> f37993a;

    @FunctionalInterface
    /* loaded from: classes6.dex */
    public interface Lazy<V> {
        V get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Lazy<RxPermissionsFragment> {

        /* renamed from: a  reason: collision with root package name */
        private RxPermissionsFragment f37994a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FragmentManager f37995b;

        a(FragmentManager fragmentManager) {
            this.f37995b = fragmentManager;
        }

        @Override // com.tbruyelle.rxpermissions2.RxPermissions.Lazy
        /* renamed from: a */
        public synchronized RxPermissionsFragment get() {
            if (this.f37994a == null) {
                this.f37994a = RxPermissions.this.f(this.f37995b);
            }
            return this.f37994a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes6.dex */
    public class b<T> implements ObservableTransformer<T, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String[] f37997a;

        /* loaded from: classes6.dex */
        class a implements Function<List<Permission>, ObservableSource<Boolean>> {
            a() {
            }

            @Override // io.reactivex.functions.Function
            /* renamed from: a */
            public ObservableSource<Boolean> apply(List<Permission> list) {
                if (list.isEmpty()) {
                    return Observable.empty();
                }
                for (Permission permission : list) {
                    if (!permission.granted) {
                        return Observable.just(Boolean.FALSE);
                    }
                }
                return Observable.just(Boolean.TRUE);
            }
        }

        b(String[] strArr) {
            this.f37997a = strArr;
        }

        @Override // io.reactivex.ObservableTransformer
        public ObservableSource<Boolean> apply(Observable<T> observable) {
            return RxPermissions.this.j(observable, this.f37997a).buffer(this.f37997a.length).flatMap(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes6.dex */
    public class c<T> implements ObservableTransformer<T, Permission> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String[] f38000a;

        c(String[] strArr) {
            this.f38000a = strArr;
        }

        @Override // io.reactivex.ObservableTransformer
        public ObservableSource<Permission> apply(Observable<T> observable) {
            return RxPermissions.this.j(observable, this.f38000a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes6.dex */
    public class d<T> implements ObservableTransformer<T, Permission> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String[] f38002a;

        /* loaded from: classes6.dex */
        class a implements Function<List<Permission>, ObservableSource<Permission>> {
            a() {
            }

            @Override // io.reactivex.functions.Function
            /* renamed from: a */
            public ObservableSource<Permission> apply(List<Permission> list) {
                if (list.isEmpty()) {
                    return Observable.empty();
                }
                return Observable.just(new Permission(list));
            }
        }

        d(String[] strArr) {
            this.f38002a = strArr;
        }

        @Override // io.reactivex.ObservableTransformer
        public ObservableSource<Permission> apply(Observable<T> observable) {
            return RxPermissions.this.j(observable, this.f38002a).buffer(this.f38002a.length).flatMap(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e implements Function<Object, Observable<Permission>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String[] f38005a;

        e(String[] strArr) {
            this.f38005a = strArr;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public Observable<Permission> apply(Object obj) {
            return RxPermissions.this.k(this.f38005a);
        }
    }

    public RxPermissions(@NonNull FragmentActivity fragmentActivity) {
        this.f37993a = e(fragmentActivity.getSupportFragmentManager());
    }

    private RxPermissionsFragment d(@NonNull FragmentManager fragmentManager) {
        return (RxPermissionsFragment) fragmentManager.findFragmentByTag(f37991b);
    }

    @NonNull
    private Lazy<RxPermissionsFragment> e(@NonNull FragmentManager fragmentManager) {
        return new a(fragmentManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RxPermissionsFragment f(@NonNull FragmentManager fragmentManager) {
        boolean z3;
        RxPermissionsFragment d4 = d(fragmentManager);
        if (d4 == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            RxPermissionsFragment rxPermissionsFragment = new RxPermissionsFragment();
            fragmentManager.beginTransaction().add(rxPermissionsFragment, f37991b).commitNow();
            return rxPermissionsFragment;
        }
        return d4;
    }

    private Observable<?> h(Observable<?> observable, Observable<?> observable2) {
        if (observable == null) {
            return Observable.just(f37992c);
        }
        return Observable.merge(observable, observable2);
    }

    private Observable<?> i(String... strArr) {
        for (String str : strArr) {
            if (!this.f37993a.get().containsByPermission(str)) {
                return Observable.empty();
            }
        }
        return Observable.just(f37992c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Observable<Permission> j(Observable<?> observable, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            return h(observable, i(strArr)).flatMap(new e(strArr));
        }
        throw new IllegalArgumentException("RxPermissions.request/requestEach requires at least one input permission");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    public Observable<Permission> k(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        ArrayList arrayList2 = new ArrayList();
        for (String str : strArr) {
            this.f37993a.get().d("Requesting permission " + str);
            if (isGranted(str)) {
                arrayList.add(Observable.just(new Permission(str, true, false)));
            } else if (isRevoked(str)) {
                arrayList.add(Observable.just(new Permission(str, false, false)));
            } else {
                PublishSubject<Permission> subjectByPermission = this.f37993a.get().getSubjectByPermission(str);
                if (subjectByPermission == null) {
                    arrayList2.add(str);
                    subjectByPermission = PublishSubject.create();
                    this.f37993a.get().setSubjectForPermission(str, subjectByPermission);
                }
                arrayList.add(subjectByPermission);
            }
        }
        if (!arrayList2.isEmpty()) {
            l((String[]) arrayList2.toArray(new String[arrayList2.size()]));
        }
        return Observable.concat(Observable.fromIterable(arrayList));
    }

    @TargetApi(23)
    private boolean m(Activity activity, String... strArr) {
        boolean shouldShowRequestPermissionRationale;
        for (String str : strArr) {
            if (!isGranted(str)) {
                shouldShowRequestPermissionRationale = activity.shouldShowRequestPermissionRationale(str);
                if (!shouldShowRequestPermissionRationale) {
                    return false;
                }
            }
        }
        return true;
    }

    public <T> ObservableTransformer<T, Boolean> ensure(String... strArr) {
        return new b(strArr);
    }

    public <T> ObservableTransformer<T, Permission> ensureEach(String... strArr) {
        return new c(strArr);
    }

    public <T> ObservableTransformer<T, Permission> ensureEachCombined(String... strArr) {
        return new d(strArr);
    }

    boolean g() {
        if (Build.VERSION.SDK_INT >= 23) {
            return true;
        }
        return false;
    }

    public boolean isGranted(String str) {
        if (g() && !this.f37993a.get().b(str)) {
            return false;
        }
        return true;
    }

    public boolean isRevoked(String str) {
        if (g() && this.f37993a.get().c(str)) {
            return true;
        }
        return false;
    }

    @TargetApi(23)
    void l(String[] strArr) {
        this.f37993a.get().d("requestPermissionsFromFragment " + TextUtils.join(", ", strArr));
        this.f37993a.get().f(strArr);
    }

    public Observable<Boolean> request(String... strArr) {
        return Observable.just(f37992c).compose(ensure(strArr));
    }

    public Observable<Permission> requestEach(String... strArr) {
        return Observable.just(f37992c).compose(ensureEach(strArr));
    }

    public Observable<Permission> requestEachCombined(String... strArr) {
        return Observable.just(f37992c).compose(ensureEachCombined(strArr));
    }

    public void setLogging(boolean z3) {
        this.f37993a.get().setLogging(z3);
    }

    public Observable<Boolean> shouldShowRequestPermissionRationale(Activity activity, String... strArr) {
        if (!g()) {
            return Observable.just(Boolean.FALSE);
        }
        return Observable.just(Boolean.valueOf(m(activity, strArr)));
    }

    public RxPermissions(@NonNull Fragment fragment) {
        this.f37993a = e(fragment.getChildFragmentManager());
    }
}
