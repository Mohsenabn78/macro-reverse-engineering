package com.miguelbcr.ui.rx_paparazzo2.interactors;

import com.miguelbcr.ui.rx_paparazzo2.entities.Ignore;
import com.miguelbcr.ui.rx_paparazzo2.entities.PermissionDeniedException;
import com.miguelbcr.ui.rx_paparazzo2.entities.TargetUi;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;

/* loaded from: classes6.dex */
public final class GrantPermissions extends com.miguelbcr.ui.rx_paparazzo2.interactors.a<Ignore> {

    /* renamed from: a  reason: collision with root package name */
    private final TargetUi f36213a;

    /* renamed from: b  reason: collision with root package name */
    private String[] f36214b;

    /* loaded from: classes6.dex */
    class a implements Function<List<Integer>, SingleSource<Ignore>> {
        a() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public SingleSource<Ignore> apply(List<Integer> list) throws Exception {
            int i4 = -1;
            for (Integer num : list) {
                int intValue = num.intValue();
                if (intValue > i4) {
                    i4 = intValue;
                }
            }
            if (i4 == -1) {
                return Single.just(Ignore.Get);
            }
            return Single.error(new PermissionDeniedException(i4));
        }
    }

    /* loaded from: classes6.dex */
    class b implements Function<Permission, ObservableSource<Integer>> {
        b() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public ObservableSource<Integer> apply(Permission permission) throws Exception {
            if (!permission.granted && !"android.permission.READ_EXTERNAL_STORAGE".equals(permission.name)) {
                if (permission.shouldShowRequestPermissionRationale) {
                    return Observable.just(2);
                }
                return Observable.just(3);
            }
            return Observable.just(-1);
        }
    }

    public GrantPermissions(TargetUi targetUi) {
        this.f36213a = targetUi;
    }

    public Observable<Ignore> react() {
        if (this.f36214b.length == 0) {
            return Observable.just(Ignore.Get);
        }
        return new RxPermissions(this.f36213a.activity()).requestEach(this.f36214b).buffer(this.f36214b.length).flatMapIterable(new c()).concatMap(new b()).toList().flatMap(new a()).toObservable();
    }

    public GrantPermissions with(String... strArr) {
        this.f36214b = strArr;
        return this;
    }

    /* loaded from: classes6.dex */
    class c implements Function<List<Permission>, Iterable<Permission>> {
        c() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public Iterable<Permission> apply(List<Permission> list) throws Exception {
            return list;
        }
    }
}
