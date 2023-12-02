package com.arlosoft.macrodroid.triggers.webtrigger;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.triggers.webtrigger.WebTriggerInteractor;
import com.arlosoft.macrodroid.triggers.webtrigger.api.WebTriggerApi;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Publisher;

/* compiled from: WebTriggerInteractor.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class WebTriggerInteractor {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final WebTriggerApi f15717a;

    /* compiled from: WebTriggerInteractor.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function1<Flowable<Throwable>, Publisher<?>> {

        /* renamed from: d  reason: collision with root package name */
        public static final a f15718d = new a();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WebTriggerInteractor.kt */
        /* renamed from: com.arlosoft.macrodroid.triggers.webtrigger.WebTriggerInteractor$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0129a extends Lambda implements Function1<Pair<? extends Integer, ? extends Throwable>, Publisher<? extends Long>> {

            /* renamed from: d  reason: collision with root package name */
            public static final C0129a f15719d = new C0129a();

            C0129a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final Publisher<? extends Long> invoke(@NotNull Pair<Integer, ? extends Throwable> zipOut) {
                Intrinsics.checkNotNullParameter(zipOut, "zipOut");
                if (zipOut.getFirst().intValue() < 4) {
                    return Observable.timer(10L, TimeUnit.SECONDS).toFlowable(BackpressureStrategy.DROP);
                }
                return Flowable.error(zipOut.getSecond());
            }
        }

        a() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Pair e(Throwable throwable, int i4) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            return new Pair(Integer.valueOf(i4), throwable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Publisher f(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (Publisher) tmp0.invoke(obj);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c */
        public final Publisher<?> invoke(@NotNull Flowable<Throwable> errors) {
            Intrinsics.checkNotNullParameter(errors, "errors");
            Flowable<R> zipWith = errors.zipWith(Observable.range(1, 4).toFlowable(BackpressureStrategy.DROP), new BiFunction() { // from class: com.arlosoft.macrodroid.triggers.webtrigger.a
                @Override // io.reactivex.functions.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    Pair e4;
                    e4 = WebTriggerInteractor.a.e((Throwable) obj, ((Integer) obj2).intValue());
                    return e4;
                }
            });
            final C0129a c0129a = C0129a.f15719d;
            return zipWith.flatMap(new Function() { // from class: com.arlosoft.macrodroid.triggers.webtrigger.b
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Publisher f4;
                    f4 = WebTriggerInteractor.a.f(Function1.this, obj);
                    return f4;
                }
            });
        }
    }

    @Inject
    public WebTriggerInteractor(@NotNull WebTriggerApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.f15717a = api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher b(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    @NotNull
    public final Completable exportToken(@NotNull String deviceId, @NotNull String passwordHash) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(passwordHash, "passwordHash");
        Completable observeOn = this.f15717a.urlTriggerExport(deviceId, passwordHash).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "api.urlTriggerExport(dev…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Completable updateDeviceIdToken(@NotNull String deviceId, @NotNull String passwordHash, @NotNull String pushToken) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(passwordHash, "passwordHash");
        Intrinsics.checkNotNullParameter(pushToken, "pushToken");
        Completable observeOn = this.f15717a.urlTriggerDeviceIdPort(deviceId, passwordHash, pushToken).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "api.urlTriggerDeviceIdPo…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Completable uploadTriggerToken(@NotNull String deviceId, @NotNull String alias, @NotNull String pushTokenId, @Nullable String str) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(alias, "alias");
        Intrinsics.checkNotNullParameter(pushTokenId, "pushTokenId");
        WebTriggerApi webTriggerApi = this.f15717a;
        if (str == null) {
            str = "";
        }
        Completable urlTriggerToken = webTriggerApi.urlTriggerToken(deviceId, alias, pushTokenId, str);
        final a aVar = a.f15718d;
        Completable observeOn = urlTriggerToken.retryWhen(new Function() { // from class: u0.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher b4;
                b4 = WebTriggerInteractor.b(Function1.this, obj);
                return b4;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "api.urlTriggerToken(devi…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Completable uploadTriggerTokenNoRetry(@NotNull String deviceId, @NotNull String alias, @NotNull String pushTokenId, @Nullable String str) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(alias, "alias");
        Intrinsics.checkNotNullParameter(pushTokenId, "pushTokenId");
        WebTriggerApi webTriggerApi = this.f15717a;
        if (str == null) {
            str = "";
        }
        Completable observeOn = webTriggerApi.urlTriggerToken(deviceId, alias, pushTokenId, str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "api.urlTriggerToken(devi…dSchedulers.mainThread())");
        return observeOn;
    }
}
