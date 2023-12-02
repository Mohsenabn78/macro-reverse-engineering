package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.afollestad.materialdialogs.MaterialDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.beacons.BeaconList;
import com.arlosoft.macrodroid.beacons.BeaconWithName;
import com.arlosoft.macrodroid.beacons.RxBeacon;
import com.arlosoft.macrodroid.beacons.RxBeaconMonitor;
import com.arlosoft.macrodroid.beacons.RxBeaconRange;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.info.BluetoothBeaconTriggerInfo;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import me.drakeet.support.toast.ToastCompat;
import net.bytebuddy.description.type.TypeDescription;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.Identifier;
import org.altbeacon.beacon.Region;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BluetoothBeaconTrigger.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nBluetoothBeaconTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BluetoothBeaconTrigger.kt\ncom/arlosoft/macrodroid/triggers/BluetoothBeaconTrigger\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,421:1\n1549#2:422\n1620#2,3:423\n37#3,2:426\n262#4,2:428\n262#4,2:430\n*S KotlinDebug\n*F\n+ 1 BluetoothBeaconTrigger.kt\ncom/arlosoft/macrodroid/triggers/BluetoothBeaconTrigger\n*L\n273#1:422\n273#1:423,3\n274#1:426,2\n310#1:428,2\n314#1:430,2\n*E\n"})
/* loaded from: classes3.dex */
public final class BluetoothBeaconTrigger extends Trigger {
    @NotNull
    private static final String BEACON_CACHE = "beacons";
    @NotNull
    private static final String BEACON_WITH_NAME_DATA_KEY = "BeaconData";
    private static final int OPTION_IN_RANGE = 0;
    private static final int OPTION_OUT_OF_RANGE = 1;
    @Nullable
    private static RxBeacon rxBeacon;
    private static int triggerCount;
    private int option;
    @Nullable
    private transient Disposable scanningDisposable;
    @NotNull
    private final ArrayList<BeaconWithName> selectedBeacons;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<BluetoothBeaconTrigger> CREATOR = new Parcelable.Creator<BluetoothBeaconTrigger>() { // from class: com.arlosoft.macrodroid.triggers.BluetoothBeaconTrigger$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public BluetoothBeaconTrigger createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BluetoothBeaconTrigger(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public BluetoothBeaconTrigger[] newArray(int i4) {
            return new BluetoothBeaconTrigger[i4];
        }
    };
    @NotNull
    private static final CompositeDisposable subscriptions = new CompositeDisposable();
    private static int regionId = 1;
    @NotNull
    private static HashMap<String, RegionWithCount> beaconUuidRegionMap = new HashMap<>();

    /* compiled from: BluetoothBeaconTrigger.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function1<Boolean, Unit> {

        /* renamed from: d  reason: collision with root package name */
        public static final a f14332d = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            SystemLog.logVerbose("Bluetooth BeaconManager initialised");
        }
    }

    /* compiled from: BluetoothBeaconTrigger.kt */
    /* loaded from: classes3.dex */
    static final class b extends Lambda implements Function1<Throwable, Unit> {

        /* renamed from: d  reason: collision with root package name */
        public static final b f14333d = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            SystemLog.logError("Bluetooth BeaconManager failed to initialise");
        }
    }

    /* compiled from: BluetoothBeaconTrigger.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function1<RxBeaconMonitor, Unit> {
        c() {
            super(1);
        }

        public final void a(RxBeaconMonitor rxBeaconMonitor) {
            boolean z3;
            BluetoothBeaconTrigger bluetoothBeaconTrigger = BluetoothBeaconTrigger.this;
            Region region = rxBeaconMonitor.getRegion();
            if (rxBeaconMonitor.getState() == RxBeaconMonitor.State.ENTER) {
                z3 = true;
            } else {
                z3 = false;
            }
            bluetoothBeaconTrigger.k0(region, z3);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RxBeaconMonitor rxBeaconMonitor) {
            a(rxBeaconMonitor);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BluetoothBeaconTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class d extends Lambda implements Function1<Throwable, Unit> {
        d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            BeaconWithName j02 = BluetoothBeaconTrigger.this.j0();
            SystemLog.logError("Failed to monitor: " + j02 + ".uuid");
        }
    }

    /* compiled from: BluetoothBeaconTrigger.kt */
    /* loaded from: classes3.dex */
    static final class e extends Lambda implements Function1<RxBeaconRange, Unit> {
        final /* synthetic */ Ref.BooleanRef $cleanupBeaconAfter;
        final /* synthetic */ MaterialDialog $progressDialog;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(MaterialDialog materialDialog, Ref.BooleanRef booleanRef) {
            super(1);
            this.$progressDialog = materialDialog;
            this.$cleanupBeaconAfter = booleanRef;
        }

        public final void a(RxBeaconRange rxBeaconRange) {
            Disposable disposable = BluetoothBeaconTrigger.this.scanningDisposable;
            if (disposable != null) {
                disposable.dispose();
            }
            HashSet hashSet = new HashSet();
            for (Beacon beacon : rxBeaconRange.getBeacons()) {
                hashSet.add(beacon);
            }
            if (hashSet.isEmpty()) {
                ToastCompat.makeText(BluetoothBeaconTrigger.this.getContext().getApplicationContext(), (int) R.string.no_beacons_found, 0).show();
            }
            this.$progressDialog.dismiss();
            BluetoothBeaconTrigger.this.b0(new ArrayList(hashSet));
            if (this.$cleanupBeaconAfter.element) {
                RxBeacon rxBeacon = BluetoothBeaconTrigger.rxBeacon;
                if (rxBeacon != null) {
                    rxBeacon.cleanup();
                }
                BluetoothBeaconTrigger.rxBeacon = null;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RxBeaconRange rxBeaconRange) {
            a(rxBeaconRange);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: BluetoothBeaconTrigger.kt */
    /* loaded from: classes3.dex */
    static final class f extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ MaterialDialog $progressDialog;
        final /* synthetic */ BluetoothBeaconTrigger this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(MaterialDialog materialDialog, BluetoothBeaconTrigger bluetoothBeaconTrigger) {
            super(1);
            this.$progressDialog = materialDialog;
            this.this$0 = bluetoothBeaconTrigger;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            try {
                this.$progressDialog.dismiss();
            } catch (Exception unused) {
            }
            SystemLog.logVerbose("No beacons found - request timed out");
            ToastCompat.makeText(this.this$0.getContext().getApplicationContext(), (int) R.string.no_beacons_found, 0).show();
            this.this$0.b0(new ArrayList(new HashSet()));
        }
    }

    public /* synthetic */ BluetoothBeaconTrigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final List<BeaconWithName> a0(List<? extends Beacon> list, BeaconList beaconList) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Beacon beacon : list) {
            BeaconWithName i02 = i0(beacon, beaconList);
            if (i02 != null) {
                arrayList.add(0, i02);
            } else {
                String identifier = beacon.getId1().toString();
                Intrinsics.checkNotNullExpressionValue(identifier, "beacon.id1.toString()");
                arrayList.add(new BeaconWithName(identifier, null, 2, null));
            }
        }
        Iterator<BeaconWithName> it = beaconList.getBeacons().iterator();
        while (it.hasNext()) {
            BeaconWithName next = it.next();
            if (!arrayList.contains(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v9, types: [T, com.arlosoft.macrodroid.beacons.BeaconList] */
    public final void b0(List<? extends Beacon> list) {
        int collectionSizeOrDefault;
        Object[] plus;
        boolean z3;
        Spanned fromHtml;
        if (!checkActivityAlive()) {
            return;
        }
        final Cache cache = MacroDroidApplication.Companion.getInstance().getCache(BEACON_CACHE);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? r22 = cache.get(BEACON_WITH_NAME_DATA_KEY, BeaconList.class);
        objectRef.element = r22;
        if (r22 == 0) {
            objectRef.element = new BeaconList(null, 1, null);
        }
        T cachedData = objectRef.element;
        Intrinsics.checkNotNullExpressionValue(cachedData, "cachedData");
        final List<BeaconWithName> a02 = a0(list, (BeaconList) cachedData);
        int max = Math.max(0, a02.indexOf(j0()));
        Spanned[] spannedArr = {Html.fromHtml(SelectableItem.r(R.string.add_beacon_manually))};
        List<BeaconWithName> list2 = a02;
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (BeaconWithName beaconWithName : list2) {
            String name = beaconWithName.getName();
            if (name != null && name.length() != 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                String uuid = beaconWithName.getUuid();
                fromHtml = Html.fromHtml("<small><i>" + uuid + "</i></small>");
            } else {
                String name2 = beaconWithName.getName();
                String uuid2 = beaconWithName.getUuid();
                fromHtml = Html.fromHtml("<b>" + name2 + "</b><br/><small><i>" + uuid2 + "</i></small>");
            }
            arrayList.add(fromHtml);
        }
        plus = ArraysKt___ArraysJvmKt.plus((Object[]) spannedArr, arrayList.toArray(new Spanned[0]));
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        builder.setSingleChoiceItems((Spanned[]) plus, max, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.r0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                BluetoothBeaconTrigger.c0(BluetoothBeaconTrigger.this, dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.s0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                BluetoothBeaconTrigger.d0(BluetoothBeaconTrigger.this, a02, cache, objectRef, dialogInterface, i4);
            }
        });
        builder.show().setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.triggers.t0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                BluetoothBeaconTrigger.e0(BluetoothBeaconTrigger.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(BluetoothBeaconTrigger this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(BluetoothBeaconTrigger this$0, List options, Cache cache, Ref.ObjectRef cachedData, DialogInterface dialogInterface, int i4) {
        BeaconWithName beaconWithName;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(options, "$options");
        Intrinsics.checkNotNullParameter(cache, "$cache");
        Intrinsics.checkNotNullParameter(cachedData, "$cachedData");
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
        int checkedItemPosition = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        if (checkedItemPosition == 0) {
            beaconWithName = null;
        } else {
            beaconWithName = (BeaconWithName) options.get(checkedItemPosition - 1);
        }
        T cachedData2 = cachedData.element;
        Intrinsics.checkNotNullExpressionValue(cachedData2, "cachedData");
        this$0.p0(beaconWithName, cache, (BeaconList) cachedData2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(BluetoothBeaconTrigger this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final BeaconWithName i0(Beacon beacon, BeaconList beaconList) {
        Iterator<BeaconWithName> it = beaconList.getBeacons().iterator();
        while (it.hasNext()) {
            BeaconWithName next = it.next();
            if (Intrinsics.areEqual(next.getUuid(), beacon.getId1().toString())) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BeaconWithName j0() {
        if (!this.selectedBeacons.isEmpty() && this.selectedBeacons.get(0) != null) {
            BeaconWithName beaconWithName = this.selectedBeacons.get(0);
            Intrinsics.checkNotNullExpressionValue(beaconWithName, "selectedBeacons[0]");
            return beaconWithName;
        }
        return new BeaconWithName(TypeDescription.Generic.OfWildcardType.SYMBOL, TypeDescription.Generic.OfWildcardType.SYMBOL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(Region region, boolean z3) {
        int i4;
        final ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if (next instanceof BluetoothBeaconTrigger) {
                        BluetoothBeaconTrigger bluetoothBeaconTrigger = (BluetoothBeaconTrigger) next;
                        if (Intrinsics.areEqual(bluetoothBeaconTrigger.j0().getUuid(), region.getId1().toString()) && (((i4 = bluetoothBeaconTrigger.option) == 0 && z3) || (i4 == 1 && !z3))) {
                            macro.setTriggerThatInvoked(next);
                            if (next.constraintsMet() && macro.canInvoke(macro.getTriggerContextInfo())) {
                                arrayList.add(macro);
                                break;
                            }
                        }
                    }
                }
            }
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.q0
            @Override // java.lang.Runnable
            public final void run() {
                BluetoothBeaconTrigger.l0(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(ArrayList macrosToInvoke) {
        Intrinsics.checkNotNullParameter(macrosToInvoke, "$macrosToInvoke");
        Iterator it = macrosToInvoke.iterator();
        while (it.hasNext()) {
            Macro macro = (Macro) it.next();
            macro.invokeActions(macro.getTriggerContextInfo());
        }
    }

    private final void m0(String str) {
        Unit unit;
        Completable monitorRegion;
        RegionWithCount regionWithCount = beaconUuidRegionMap.get(str);
        if (regionWithCount != null) {
            beaconUuidRegionMap.put(str, RegionWithCount.copy$default(regionWithCount, null, regionWithCount.getCount() + 1, 1, null));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            if (j0().getUuid() == null) {
                Long macroGuid = getMacroGuid();
                Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                SystemLog.logError("Cannot monitor bluetooth beacon the UUID is null, please reconfigure the trigger", macroGuid.longValue());
            } else {
                HashMap<String, RegionWithCount> hashMap = beaconUuidRegionMap;
                int i4 = regionId;
                regionId = i4 + 1;
                hashMap.put(str, new RegionWithCount(new Region("Region" + i4, Identifier.parse(j0().getUuid()), null, null), 1));
            }
        }
        RegionWithCount regionWithCount2 = beaconUuidRegionMap.get(str);
        if (regionWithCount2 != null && regionWithCount2.getCount() == 1) {
            SystemLog.logVerbose("Monitoring region for beacon id: " + str);
            RxBeacon rxBeacon2 = rxBeacon;
            if (rxBeacon2 != null && (monitorRegion = rxBeacon2.monitorRegion(regionWithCount2.getRegion())) != null) {
                Action action = new Action() { // from class: com.arlosoft.macrodroid.triggers.u0
                    @Override // io.reactivex.functions.Action
                    public final void run() {
                        BluetoothBeaconTrigger.n0(BluetoothBeaconTrigger.this);
                    }
                };
                final d dVar = new d();
                monitorRegion.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.triggers.v0
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        BluetoothBeaconTrigger.o0(Function1.this, obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(BluetoothBeaconTrigger this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BeaconWithName j02 = this$0.j0();
        SystemLog.logVerbose("Monitoring beacon: " + j02 + ".uuid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void p0(final BeaconWithName beaconWithName, final Cache cache, final BeaconList beaconList) {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_beacon_name);
        if (beaconWithName == null) {
            appCompatDialog.setTitle(R.string.add_beacon_manually);
        } else {
            appCompatDialog.setTitle(beaconWithName.getUuid());
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        Window window2 = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.button_delete);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.uuid);
        final EditText editText2 = (EditText) appCompatDialog.findViewById(R.id.friendly_name);
        if (beaconWithName != null) {
            View findViewById = appCompatDialog.findViewById(R.id.uuid_layout);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            if (editText2 != null) {
                editText2.setText(beaconWithName.getName());
            }
            if (editText != null) {
                editText.setText(beaconWithName.getUuid());
            }
        } else if (button3 != null) {
            button3.setVisibility(8);
        }
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.l0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BluetoothBeaconTrigger.q0(editText, this, beaconList, beaconWithName, editText2, cache, appCompatDialog, view);
                }
            });
        }
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.m0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BluetoothBeaconTrigger.r0(AppCompatDialog.this, view);
                }
            });
        }
        if (button3 != null) {
            button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.n0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BluetoothBeaconTrigger.s0(BeaconList.this, beaconWithName, cache, appCompatDialog, view);
                }
            });
        }
        Window window3 = appCompatDialog.getWindow();
        if (window3 != null) {
            window3.setSoftInputMode(4);
        }
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(EditText editText, BluetoothBeaconTrigger this$0, BeaconList cachedData, BeaconWithName beaconWithName, EditText editText2, Cache cache, AppCompatDialog dialog, View view) {
        Editable editable;
        boolean z3;
        Editable text;
        boolean contains;
        String str;
        Editable text2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cachedData, "$cachedData");
        Intrinsics.checkNotNullParameter(cache, "$cache");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Editable editable2 = null;
        if (editText != null) {
            editable = editText.getText();
        } else {
            editable = null;
        }
        if (String.valueOf(editable).length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            ToastCompat.makeText(this$0.getContext().getApplicationContext(), (int) R.string.beacon_invalid_uuid, 0).show();
            return;
        }
        if (editText != null) {
            try {
                text = editText.getText();
            } catch (Exception unused) {
                ToastCompat.makeText(this$0.getContext().getApplicationContext(), (int) R.string.beacon_invalid_uuid, 0).show();
                return;
            }
        } else {
            text = null;
        }
        Identifier.parse(String.valueOf(text));
        contains = CollectionsKt___CollectionsKt.contains(cachedData.getBeacons(), beaconWithName);
        if (!contains) {
            TypeIntrinsics.asMutableCollection(cachedData.getBeacons()).remove(beaconWithName);
        }
        if (editText2 == null || (text2 = editText2.getText()) == null || (str = text2.toString()) == null) {
            str = TypeDescription.Generic.OfWildcardType.SYMBOL;
        }
        if (editText != null) {
            editable2 = editText.getText();
        }
        this$0.v0(new BeaconWithName(String.valueOf(editable2), str));
        cachedData.getBeacons().add(0, this$0.j0());
        cache.put(BEACON_WITH_NAME_DATA_KEY, cachedData);
        dialog.dismiss();
        this$0.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(BeaconList cachedData, BeaconWithName beaconWithName, Cache cache, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(cachedData, "$cachedData");
        Intrinsics.checkNotNullParameter(cache, "$cache");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        TypeIntrinsics.asMutableCollection(cachedData.getBeacons()).remove(beaconWithName);
        cache.put(BEACON_WITH_NAME_DATA_KEY, cachedData);
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void v0(BeaconWithName beaconWithName) {
        this.selectedBeacons.clear();
        this.selectedBeacons.add(beaconWithName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        RegionWithCount regionWithCount = beaconUuidRegionMap.get(j0().getUuid());
        if (regionWithCount != null) {
            if (regionWithCount.getCount() == 1) {
                BeaconWithName j02 = j0();
                SystemLog.logVerbose("Stopped Monitoring region for beacon id: " + j02 + ".uuid");
                RxBeacon rxBeacon2 = rxBeacon;
                if (rxBeacon2 != null) {
                    rxBeacon2.stopMonitorRegion(regionWithCount.getRegion());
                }
            }
            beaconUuidRegionMap.put(j0().getUuid(), RegionWithCount.copy$default(regionWithCount, null, regionWithCount.getCount() - 1, 1, null));
        }
        if (triggerCount == 0) {
            subscriptions.clear();
            RxBeacon rxBeacon3 = rxBeacon;
            if (rxBeacon3 != null) {
                rxBeacon3.cleanup();
            }
            rxBeacon = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (triggerCount == 0) {
            if (rxBeacon == null) {
                rxBeacon = RxBeacon.Companion.with(MacroDroidApplication.Companion.getInstance());
            }
            CompositeDisposable compositeDisposable = subscriptions;
            RxBeacon rxBeacon2 = rxBeacon;
            Intrinsics.checkNotNull(rxBeacon2);
            Observable<Boolean> initialise = rxBeacon2.initialise();
            final a aVar = a.f14332d;
            Consumer<? super Boolean> consumer = new Consumer() { // from class: com.arlosoft.macrodroid.triggers.j0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    BluetoothBeaconTrigger.f0(Function1.this, obj);
                }
            };
            final b bVar = b.f14333d;
            compositeDisposable.add(initialise.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.triggers.o0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    BluetoothBeaconTrigger.g0(Function1.this, obj);
                }
            }));
            RxBeacon rxBeacon3 = rxBeacon;
            Intrinsics.checkNotNull(rxBeacon3);
            BehaviorSubject<RxBeaconMonitor> beaconUpdateSubject = rxBeacon3.getBeaconUpdateSubject();
            final c cVar = new c();
            compositeDisposable.add(beaconUpdateSubject.subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.triggers.p0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    BluetoothBeaconTrigger.h0(Function1.this, obj);
                }
            }));
        }
        m0(j0().getUuid());
        triggerCount++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getConfiguredName() {
        String str = Companion.a()[this.option];
        Intrinsics.checkNotNullExpressionValue(str, "getOptions()[option]");
        return str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String getExtendedDetail() {
        boolean z3;
        String name = j0().getName();
        if (name != null && name.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            return j0().getName();
        }
        return j0().getUuid();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return BluetoothBeaconTriggerInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String name = getName();
        String truncateIfRequired = MDTextUtils.truncateIfRequired(getExtendedDetail(), 20);
        return name + " (" + truncateIfRequired + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT >= 31) {
            return new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"};
        }
        return new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getSystemLogEntryName(@Nullable TriggerContextInfo triggerContextInfo) {
        String name = getName();
        String extendedDetail = getExtendedDetail();
        return name + " (" + extendedDetail + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] o() {
        return Companion.a();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresLocationServicesEnabled() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        MaterialDialog show = new MaterialDialog.Builder(getActivity()).title(R.string.please_wait).content(R.string.scanning_for_beacons).progress(true, 0).cancelable(false).widgetColorRes(R.color.trigger_accent).show();
        Region region = new Region("Scan for all beacons", null, null, null);
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        if (rxBeacon == null) {
            rxBeacon = RxBeacon.Companion.with(MacroDroidApplication.Companion.getInstance());
            booleanRef.element = true;
        }
        RxBeacon rxBeacon2 = rxBeacon;
        Intrinsics.checkNotNull(rxBeacon2);
        Observable<RxBeaconRange> beaconsInRegion = rxBeacon2.beaconsInRegion(region);
        final e eVar = new e(show, booleanRef);
        Consumer<? super RxBeaconRange> consumer = new Consumer() { // from class: com.arlosoft.macrodroid.triggers.w0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BluetoothBeaconTrigger.t0(Function1.this, obj);
            }
        };
        final f fVar = new f(show, this);
        this.scanningDisposable = beaconsInRegion.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.triggers.k0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BluetoothBeaconTrigger.u0(Function1.this, obj);
            }
        });
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
        if (Build.VERSION.SDK_INT >= 29) {
            out.writeParcelableList(this.selectedBeacons, i4);
            return;
        }
        ArrayList<BeaconWithName> arrayList = this.selectedBeacons;
        Intrinsics.checkNotNull(arrayList, "null cannot be cast to non-null type kotlin.collections.List<com.arlosoft.macrodroid.beacons.BeaconWithName>");
        out.writeList(arrayList);
    }

    public BluetoothBeaconTrigger(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private BluetoothBeaconTrigger() {
        this.selectedBeacons = new ArrayList<>();
    }

    private BluetoothBeaconTrigger(Parcel parcel) {
        super(parcel);
        ArrayList<BeaconWithName> arrayList = new ArrayList<>();
        this.selectedBeacons = arrayList;
        this.option = parcel.readInt();
        if (Build.VERSION.SDK_INT >= 29) {
            parcel.readParcelableList(arrayList, BeaconWithName.class.getClassLoader());
            return;
        }
        Intrinsics.checkNotNull(arrayList, "null cannot be cast to non-null type kotlin.collections.List<com.arlosoft.macrodroid.beacons.BeaconWithName>");
        parcel.readList(arrayList, BeaconWithName.class.getClassLoader());
    }

    /* compiled from: BluetoothBeaconTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String[] a() {
            MacroDroidApplication.Companion companion = MacroDroidApplication.Companion;
            return new String[]{companion.getInstance().getString(R.string.beacon_in_range), companion.getInstance().getString(R.string.beacon_out_of_range)};
        }

        public final int getRegionId() {
            return BluetoothBeaconTrigger.regionId;
        }

        public final void setRegionId(int i4) {
            BluetoothBeaconTrigger.regionId = i4;
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
