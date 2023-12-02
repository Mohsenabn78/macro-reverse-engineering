package com.arlosoft.macrodroid.beacons;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.beacons.RxBeacon;
import com.arlosoft.macrodroid.beacons.RxBeaconMonitor;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.CompletableSubject;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.MonitorNotifier;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;
import org.jetbrains.annotations.NotNull;

/* compiled from: RxBeacon.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nRxBeacon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RxBeacon.kt\ncom/arlosoft/macrodroid/beacons/RxBeacon\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,136:1\n1#2:137\n*E\n"})
/* loaded from: classes3.dex */
public final class RxBeacon {
    @Nullable
    @org.jetbrains.annotations.Nullable

    /* renamed from: a  reason: collision with root package name */
    private BeaconConsumer f9457a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Context f9458b;
    @org.jetbrains.annotations.Nullable

    /* renamed from: c  reason: collision with root package name */
    private BeaconManager f9459c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final BehaviorSubject<RxBeaconMonitor> f9460d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private CompletableSubject f9461e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final MonitorNotifier f9462f;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: RxBeacon.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RxBeacon with(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new RxBeacon(context);
        }
    }

    /* compiled from: RxBeacon.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function1<Boolean, ObservableSource<? extends RxBeaconRange>> {
        final /* synthetic */ Region $region;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Region region) {
            super(1);
            this.$region = region;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(final RxBeacon this$0, Region region, final ObservableEmitter objectObservableEmitter) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(region, "$region");
            Intrinsics.checkNotNullParameter(objectObservableEmitter, "objectObservableEmitter");
            BeaconManager beaconManager = this$0.f9459c;
            if (beaconManager != null) {
                beaconManager.addRangeNotifier(new RangeNotifier() { // from class: com.arlosoft.macrodroid.beacons.f
                    @Override // org.altbeacon.beacon.RangeNotifier
                    public final void didRangeBeaconsInRegion(Collection collection, Region region2) {
                        RxBeacon.a.f(RxBeacon.this, objectObservableEmitter, collection, region2);
                    }
                });
            }
            BeaconManager beaconManager2 = this$0.f9459c;
            if (beaconManager2 != null) {
                beaconManager2.startRangingBeaconsInRegion(region);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(RxBeacon this$0, ObservableEmitter objectObservableEmitter, Collection collection, Region region) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(objectObservableEmitter, "$objectObservableEmitter");
            Intrinsics.checkNotNullExpressionValue(collection, "collection");
            if (!collection.isEmpty()) {
                BeaconManager beaconManager = this$0.f9459c;
                if (beaconManager != null) {
                    beaconManager.stopRangingBeaconsInRegion(region);
                }
                BeaconManager beaconManager2 = this$0.f9459c;
                if (beaconManager2 != null) {
                    beaconManager2.removeAllRangeNotifiers();
                }
                Intrinsics.checkNotNullExpressionValue(region, "region");
                objectObservableEmitter.onNext(new RxBeaconRange(collection, region));
            }
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c */
        public final ObservableSource<? extends RxBeaconRange> invoke(@NotNull Boolean bool) {
            Intrinsics.checkNotNullParameter(bool, "<anonymous parameter 0>");
            final RxBeacon rxBeacon = RxBeacon.this;
            final Region region = this.$region;
            return Observable.create(new ObservableOnSubscribe() { // from class: com.arlosoft.macrodroid.beacons.e
                @Override // io.reactivex.ObservableOnSubscribe
                public final void subscribe(ObservableEmitter observableEmitter) {
                    RxBeacon.a.e(RxBeacon.this, region, observableEmitter);
                }
            });
        }
    }

    public RxBeacon(@NotNull Context context) {
        List<BeaconParser> beaconParsers;
        List<BeaconParser> beaconParsers2;
        List<BeaconParser> beaconParsers3;
        List<BeaconParser> beaconParsers4;
        List<BeaconParser> beaconParsers5;
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.f9458b = applicationContext;
        BeaconManager instanceForApplication = BeaconManager.getInstanceForApplication(applicationContext);
        this.f9459c = instanceForApplication;
        if (instanceForApplication != null && (beaconParsers5 = instanceForApplication.getBeaconParsers()) != null) {
            beaconParsers5.add(new BeaconParser().setBeaconLayout(RxBeaconParser.IBEACON));
        }
        BeaconManager beaconManager = this.f9459c;
        if (beaconManager != null && (beaconParsers4 = beaconManager.getBeaconParsers()) != null) {
            beaconParsers4.add(new BeaconParser().setBeaconLayout("x,s:0-1=feaa,m:2-2=20,d:3-3,d:4-5,d:6-7,d:8-11,d:12-15"));
        }
        BeaconManager beaconManager2 = this.f9459c;
        if (beaconManager2 != null && (beaconParsers3 = beaconManager2.getBeaconParsers()) != null) {
            beaconParsers3.add(new BeaconParser().setBeaconLayout("s:0-1=feaa,m:2-2=00,p:3-3:-41,i:4-13,i:14-19"));
        }
        BeaconManager beaconManager3 = this.f9459c;
        if (beaconManager3 != null && (beaconParsers2 = beaconManager3.getBeaconParsers()) != null) {
            beaconParsers2.add(new BeaconParser().setBeaconLayout(RxBeaconParser.EDDYSTONE_URL));
        }
        BeaconManager beaconManager4 = this.f9459c;
        if (beaconManager4 != null && (beaconParsers = beaconManager4.getBeaconParsers()) != null) {
            beaconParsers.add(new BeaconParser().setBeaconLayout("m:2-3=beac,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25"));
        }
        BeaconManager beaconManager5 = this.f9459c;
        if (beaconManager5 != null) {
            beaconManager5.setForegroundScanPeriod(5000L);
        }
        BeaconManager beaconManager6 = this.f9459c;
        if (beaconManager6 != null) {
            beaconManager6.setBackgroundBetweenScanPeriod(15000L);
        }
        BehaviorSubject<RxBeaconMonitor> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        this.f9460d = create;
        CompletableSubject create2 = CompletableSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create()");
        this.f9461e = create2;
        this.f9462f = new MonitorNotifier() { // from class: com.arlosoft.macrodroid.beacons.RxBeacon$monitorNotifier$1
            @Override // org.altbeacon.beacon.MonitorNotifier
            public void didDetermineStateForRegion(int i4, @NotNull Region region) {
                Intrinsics.checkNotNullParameter(region, "region");
            }

            @Override // org.altbeacon.beacon.MonitorNotifier
            public void didEnterRegion(@NotNull Region region) {
                Intrinsics.checkNotNullParameter(region, "region");
                RxBeacon.this.getBeaconUpdateSubject().onNext(new RxBeaconMonitor(RxBeaconMonitor.State.ENTER, region));
            }

            @Override // org.altbeacon.beacon.MonitorNotifier
            public void didExitRegion(@NotNull Region region) {
                Intrinsics.checkNotNullParameter(region, "region");
                RxBeacon.this.getBeaconUpdateSubject().onNext(new RxBeaconMonitor(RxBeaconMonitor.State.EXIT, region));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource e(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    private final Observable<Boolean> f() {
        if (this.f9461e.hasComplete()) {
            Observable<Boolean> just = Observable.just(Boolean.TRUE);
            Intrinsics.checkNotNullExpressionValue(just, "{\n            Observable.just(true)\n        }");
            return just;
        }
        return initialise();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final RxBeacon this$0, final ObservableEmitter objectObservableEmitter) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(objectObservableEmitter, "objectObservableEmitter");
        BeaconConsumer beaconConsumer = new BeaconConsumer() { // from class: com.arlosoft.macrodroid.beacons.RxBeacon$initialise$1$1
            @Override // org.altbeacon.beacon.InternalBeaconConsumer
            public boolean bindService(@NotNull Intent intent, @NotNull ServiceConnection serviceConnection, int i4) {
                Context context;
                Intrinsics.checkNotNullParameter(intent, "intent");
                Intrinsics.checkNotNullParameter(serviceConnection, "serviceConnection");
                context = RxBeacon.this.f9458b;
                return context.bindService(intent, serviceConnection, i4);
            }

            @Override // org.altbeacon.beacon.InternalBeaconConsumer
            @NotNull
            public Context getApplicationContext() {
                Context context;
                context = RxBeacon.this.f9458b;
                return context;
            }

            @Override // org.altbeacon.beacon.InternalBeaconConsumer
            public void onBeaconServiceConnect() {
                CompletableSubject completableSubject;
                completableSubject = RxBeacon.this.f9461e;
                completableSubject.onComplete();
                objectObservableEmitter.onNext(Boolean.TRUE);
                BeaconManager beaconManager = RxBeacon.this.f9459c;
                if (beaconManager != null) {
                    beaconManager.addMonitorNotifier(RxBeacon.this.getMonitorNotifier());
                }
            }

            @Override // org.altbeacon.beacon.InternalBeaconConsumer
            public void unbindService(@NotNull ServiceConnection serviceConnection) {
                Context context;
                Intrinsics.checkNotNullParameter(serviceConnection, "serviceConnection");
                context = RxBeacon.this.f9458b;
                context.unbindService(serviceConnection);
            }
        };
        this$0.f9457a = beaconConsumer;
        BeaconManager beaconManager = this$0.f9459c;
        if (beaconManager != null) {
            beaconManager.bind(beaconConsumer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(RxBeacon this$0) {
        BeaconManager beaconManager;
        BeaconManager beaconManager2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BeaconConsumer beaconConsumer = this$0.f9457a;
        if (beaconConsumer != null && (beaconManager2 = this$0.f9459c) != null) {
            beaconManager2.unbind(beaconConsumer);
        }
        if (this$0.f9457a != null && (beaconManager = this$0.f9459c) != null) {
            beaconManager.removeAllMonitorNotifiers();
        }
        CompletableSubject create = CompletableSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        this$0.f9461e = create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(RxBeacon this$0, Region region) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(region, "$region");
        BeaconManager beaconManager = this$0.f9459c;
        if (beaconManager != null) {
            beaconManager.startMonitoringBeaconsInRegion(region);
        }
    }

    @NotNull
    public final Observable<RxBeaconRange> beaconsInRegion(@NotNull Region region) {
        Intrinsics.checkNotNullParameter(region, "region");
        Observable<Boolean> f4 = f();
        final a aVar = new a(region);
        Observable<RxBeaconRange> observeOn = f4.flatMap(new Function() { // from class: com.arlosoft.macrodroid.beacons.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource e4;
                e4 = RxBeacon.e(Function1.this, obj);
                return e4;
            }
        }).timeout(10L, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "fun beaconsInRegion(regi…ulers.mainThread())\n    }");
        return observeOn;
    }

    public final void cleanup() {
        List<BeaconParser> beaconParsers;
        List<BeaconParser> beaconParsers2;
        List<BeaconParser> beaconParsers3;
        List<BeaconParser> beaconParsers4;
        List<BeaconParser> beaconParsers5;
        BeaconManager beaconManager = this.f9459c;
        if (beaconManager != null && (beaconParsers5 = beaconManager.getBeaconParsers()) != null) {
            beaconParsers5.remove(new BeaconParser().setBeaconLayout(RxBeaconParser.IBEACON));
        }
        BeaconManager beaconManager2 = this.f9459c;
        if (beaconManager2 != null && (beaconParsers4 = beaconManager2.getBeaconParsers()) != null) {
            beaconParsers4.remove(new BeaconParser().setBeaconLayout("x,s:0-1=feaa,m:2-2=20,d:3-3,d:4-5,d:6-7,d:8-11,d:12-15"));
        }
        BeaconManager beaconManager3 = this.f9459c;
        if (beaconManager3 != null && (beaconParsers3 = beaconManager3.getBeaconParsers()) != null) {
            beaconParsers3.remove(new BeaconParser().setBeaconLayout("s:0-1=feaa,m:2-2=00,p:3-3:-41,i:4-13,i:14-19"));
        }
        BeaconManager beaconManager4 = this.f9459c;
        if (beaconManager4 != null && (beaconParsers2 = beaconManager4.getBeaconParsers()) != null) {
            beaconParsers2.remove(new BeaconParser().setBeaconLayout(RxBeaconParser.EDDYSTONE_URL));
        }
        BeaconManager beaconManager5 = this.f9459c;
        if (beaconManager5 != null && (beaconParsers = beaconManager5.getBeaconParsers()) != null) {
            beaconParsers.remove(new BeaconParser().setBeaconLayout("m:2-3=beac,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25"));
        }
        BeaconManager beaconManager6 = this.f9459c;
        if (beaconManager6 != null) {
            beaconManager6.removeAllRangeNotifiers();
        }
        this.f9459c = null;
    }

    @NotNull
    public final BehaviorSubject<RxBeaconMonitor> getBeaconUpdateSubject() {
        return this.f9460d;
    }

    @NotNull
    public final MonitorNotifier getMonitorNotifier() {
        return this.f9462f;
    }

    @NotNull
    public final Observable<Boolean> initialise() {
        BeaconManager beaconManager = this.f9459c;
        if (beaconManager != null) {
            beaconManager.setRegionStatePersistenceEnabled(false);
        }
        Observable<Boolean> doOnDispose = Observable.create(new ObservableOnSubscribe() { // from class: com.arlosoft.macrodroid.beacons.c
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                RxBeacon.g(RxBeacon.this, observableEmitter);
            }
        }).doOnDispose(new Action() { // from class: com.arlosoft.macrodroid.beacons.d
            @Override // io.reactivex.functions.Action
            public final void run() {
                RxBeacon.h(RxBeacon.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnDispose, "create<Boolean> { object…reate()\n                }");
        return doOnDispose;
    }

    @NotNull
    public final Completable monitorRegion(@NotNull final Region region) {
        Intrinsics.checkNotNullParameter(region, "region");
        Completable observeOn = this.f9461e.doOnComplete(new Action() { // from class: com.arlosoft.macrodroid.beacons.b
            @Override // io.reactivex.functions.Action
            public final void run() {
                RxBeacon.i(RxBeacon.this, region);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "initCompletable.doOnComp…dSchedulers.mainThread())");
        return observeOn;
    }

    public final void stopMonitorRegion(@NotNull Region region) {
        Intrinsics.checkNotNullParameter(region, "region");
        BeaconManager beaconManager = this.f9459c;
        if (beaconManager != null) {
            beaconManager.stopMonitoringBeaconsInRegion(region);
        }
    }
}
