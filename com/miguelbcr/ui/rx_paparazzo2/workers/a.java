package com.miguelbcr.ui.rx_paparazzo2.workers;

import com.miguelbcr.ui.rx_paparazzo2.entities.PermissionDeniedException;
import com.miguelbcr.ui.rx_paparazzo2.entities.Response;
import com.miguelbcr.ui.rx_paparazzo2.entities.TargetUi;
import com.miguelbcr.ui.rx_paparazzo2.entities.UserCanceledException;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Worker.java */
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private final TargetUi f36288a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Worker.java */
    /* renamed from: com.miguelbcr.ui.rx_paparazzo2.workers.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0207a<T> implements ObservableTransformer<T, T> {

        /* compiled from: Worker.java */
        /* renamed from: com.miguelbcr.ui.rx_paparazzo2.workers.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class C0208a implements Function<Throwable, ObservableSource<? extends T>> {
            C0208a() {
            }

            @Override // io.reactivex.functions.Function
            /* renamed from: a */
            public ObservableSource<? extends T> apply(Throwable th) throws Exception {
                if (th instanceof UserCanceledException) {
                    return Observable.just(new Response(a.this.f36288a.ui(), null, 0));
                }
                if (th instanceof PermissionDeniedException) {
                    return Observable.just(new Response(a.this.f36288a.ui(), null, ((PermissionDeniedException) th).getCode()));
                }
                throw Exceptions.propagate(th);
            }
        }

        C0207a() {
        }

        @Override // io.reactivex.ObservableTransformer
        public ObservableSource<T> apply(Observable<T> observable) {
            return observable.onErrorResumeNext(new C0208a());
        }
    }

    public a(TargetUi targetUi) {
        this.f36288a = targetUi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> ObservableTransformer<T, T> b() {
        return new C0207a();
    }
}
