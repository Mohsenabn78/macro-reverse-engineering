package com.arlosoft.macrodroid.geofences;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GeofenceManager.kt */
@StabilityInferred(parameters = 0)
@Singleton
@SourceDebugExtension({"SMAP\nGeofenceManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GeofenceManager.kt\ncom/arlosoft/macrodroid/geofences/GeofenceManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,172:1\n2333#2,14:173\n1549#2:188\n1620#2,3:189\n2333#2,14:192\n1#3:187\n*S KotlinDebug\n*F\n+ 1 GeofenceManager.kt\ncom/arlosoft/macrodroid/geofences/GeofenceManager\n*L\n63#1:173,14\n85#1:188\n85#1:189,3\n101#1:192,14\n*E\n"})
/* loaded from: classes3.dex */
public final class GeofenceManager {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f12210a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Cache f12211b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final GeofencingClient f12212c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, List<GeofenceUser>> f12213d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GeofenceManager.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<Void, Unit> {
        final /* synthetic */ GeofenceInfo $geofenceInfo;
        final /* synthetic */ int $updateRateMs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(GeofenceInfo geofenceInfo, int i4) {
            super(1);
            this.$geofenceInfo = geofenceInfo;
            this.$updateRateMs = i4;
        }

        public final void a(Void r4) {
            String name = this.$geofenceInfo.getName();
            SystemLog.logInfo("ENABLED Geofence [" + name + "] - Update rate = " + (this.$updateRateMs / 1000) + "s.", 0L, this.$geofenceInfo.getName());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r12) {
            a(r12);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GeofenceManager.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<Void, Unit> {
        final /* synthetic */ GeofenceInfo $geofenceInfo;
        final /* synthetic */ String $macroName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(GeofenceInfo geofenceInfo, String str) {
            super(1);
            this.$geofenceInfo = geofenceInfo;
            this.$macroName = str;
        }

        public final void a(Void r4) {
            String name = this.$geofenceInfo.getName();
            String str = this.$macroName;
            SystemLog.logInfo("DISABLED Geofence [" + name + "]. Macro: [" + str + "]", 0L, this.$geofenceInfo.getName());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r12) {
            a(r12);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: GeofenceManager.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function1<GeofenceUser, Boolean> {
        final /* synthetic */ long $selectableItemId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(long j4) {
            super(1);
            this.$selectableItemId = j4;
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull GeofenceUser it) {
            boolean z3;
            Intrinsics.checkNotNullParameter(it, "it");
            if (it.getSelectableItemId() == this.$selectableItemId) {
                z3 = true;
            } else {
                z3 = false;
            }
            return Boolean.valueOf(z3);
        }
    }

    @Inject
    public GeofenceManager(@ApplicationContext @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f12210a = context;
        this.f12213d = new LinkedHashMap();
        this.f12211b = MacroDroidApplication.Companion.getInstance().getCache("GeofenceInfo");
        GeofencingClient geofencingClient = LocationServices.getGeofencingClient(context);
        Intrinsics.checkNotNullExpressionValue(geofencingClient, "getGeofencingClient(context)");
        this.f12212c = geofencingClient;
    }

    private final void e(final GeofenceInfo geofenceInfo, int i4) {
        try {
            Task<Void> addGeofences = this.f12212c.addGeofences(j(geofenceInfo, i4), i());
            final a aVar = new a(geofenceInfo, i4);
            addGeofences.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.geofences.f
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    GeofenceManager.f(Function1.this, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.geofences.g
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    GeofenceManager.g(GeofenceInfo.this, this, exc);
                }
            });
        } catch (Exception e4) {
            String name = geofenceInfo.getName();
            SystemLog.logError("Failed to add Geofence [" + name + "]: " + e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(GeofenceInfo geofenceInfo, GeofenceManager this$0, Exception it) {
        Intrinsics.checkNotNullParameter(geofenceInfo, "$geofenceInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        String name = geofenceInfo.getName();
        SystemLog.logError$default("Failed to add Geofence [" + name + "]: " + it, 0L, geofenceInfo.getName(), null, 8, null);
        if ((it instanceof ApiException) && ((ApiException) it).getStatusCode() == 1004) {
            Context context = this$0.f12210a;
            PermissionsHelper.showNeedsSpecialPermission(context, context.getString(R.string.trigger_geofence), 14);
        }
    }

    private final Geofence h(GeofenceInfo geofenceInfo, int i4) {
        Geofence build = new Geofence.Builder().setRequestId(geofenceInfo.getId()).setCircularRegion(geofenceInfo.getLatitude(), geofenceInfo.getLongitude(), geofenceInfo.getRadius()).setNotificationResponsiveness(i4).setExpirationDuration(-1L).setTransitionTypes(3).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder() // Set the req…\n                .build()");
        return build;
    }

    private final PendingIntent i() {
        PendingIntent service = PendingIntent.getService(this.f12210a, 0, new Intent(this.f12210a, GeofenceTransitionService.class), 134217728 | PendingIntentHelper.FLAG_MUTABLE);
        Intrinsics.checkNotNullExpressionValue(service, "getService(context, 0, i…ntentHelper.FLAG_MUTABLE)");
        return service;
    }

    private final GeofencingRequest j(GeofenceInfo geofenceInfo, int i4) {
        GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
        builder.setInitialTrigger(3);
        builder.addGeofence(h(geofenceInfo, i4));
        GeofencingRequest build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    private final void k(final GeofenceInfo geofenceInfo, final String str) {
        List<String> listOf;
        try {
            listOf = kotlin.collections.e.listOf(geofenceInfo.getId());
            Task<Void> removeGeofences = this.f12212c.removeGeofences(listOf);
            final b bVar = new b(geofenceInfo, str);
            removeGeofences.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.geofences.d
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    GeofenceManager.l(Function1.this, obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.geofences.e
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    GeofenceManager.m(GeofenceInfo.this, str, exc);
                }
            });
        } catch (Exception e4) {
            String name = geofenceInfo.getName();
            SystemLog.logError("Failed to remove Geofence [" + name + "]: " + e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(GeofenceInfo geofenceInfo, String macroName, Exception it) {
        Intrinsics.checkNotNullParameter(geofenceInfo, "$geofenceInfo");
        Intrinsics.checkNotNullParameter(macroName, "$macroName");
        Intrinsics.checkNotNullParameter(it, "it");
        String name = geofenceInfo.getName();
        SystemLog.logError$default("Failed to disable Geofence [" + name + "]. Macro: [" + macroName + "]", 0L, geofenceInfo.getName(), null, 8, null);
    }

    public final void addGeofenceSubscription(@NotNull String geofenceId, long j4, int i4, @NotNull String macroName, long j5) {
        List<GeofenceUser> listOf;
        Object obj;
        int i5;
        List mutableList;
        List<GeofenceUser> list;
        Intrinsics.checkNotNullParameter(geofenceId, "geofenceId");
        Intrinsics.checkNotNullParameter(macroName, "macroName");
        GeofenceInfo geofenceInfo = getGeofenceStore().getGeofenceMap().get(geofenceId);
        if (geofenceInfo == null) {
            SystemLog.logError$default("Add Geofence - Requested Geofence does not exist. Macro: [" + macroName + "]", j5, geofenceId, null, 8, null);
            return;
        }
        GeofenceUser geofenceUser = new GeofenceUser(j4, i4);
        String name = geofenceInfo.getName();
        SystemLog.logVerbose("Geofence [" + name + "] - Added subscription. Macro: [" + macroName + "]", j5, geofenceId);
        List<GeofenceUser> list2 = this.f12213d.get(geofenceId);
        if (list2 != null && !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            if (!it.hasNext()) {
                obj = null;
            } else {
                Object next = it.next();
                if (!it.hasNext()) {
                    obj = next;
                } else {
                    int updateRateMs = ((GeofenceUser) next).getUpdateRateMs();
                    do {
                        Object next2 = it.next();
                        int updateRateMs2 = ((GeofenceUser) next2).getUpdateRateMs();
                        if (updateRateMs > updateRateMs2) {
                            next = next2;
                            updateRateMs = updateRateMs2;
                        }
                    } while (it.hasNext());
                    obj = next;
                }
            }
            GeofenceUser geofenceUser2 = (GeofenceUser) obj;
            if (geofenceUser2 != null) {
                i5 = geofenceUser2.getUpdateRateMs();
            } else {
                i5 = i4;
            }
            if (i4 < i5) {
                e(geofenceInfo, i5);
            }
            Map<String, List<GeofenceUser>> map = this.f12213d;
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list2);
            mutableList.add(geofenceUser);
            list = CollectionsKt___CollectionsKt.toList(mutableList);
            map.put(geofenceId, list);
            return;
        }
        Map<String, List<GeofenceUser>> map2 = this.f12213d;
        listOf = kotlin.collections.e.listOf(geofenceUser);
        map2.put(geofenceId, listOf);
        e(geofenceInfo, i4);
    }

    public final int checkInsideStatus(@NotNull String geofenceId) {
        Intrinsics.checkNotNullParameter(geofenceId, "geofenceId");
        GeofenceInfo geofenceInfo = getGeofenceStore().getGeofenceMap().get(geofenceId);
        if (geofenceInfo != null) {
            return geofenceInfo.getInsideStatus();
        }
        return 0;
    }

    @NotNull
    public final String getGeofenceName(@Nullable String str) {
        String name;
        GeofenceInfo geofenceInfo = getGeofenceStore().getGeofenceMap().get(str);
        if (geofenceInfo == null || (name = geofenceInfo.getName()) == null) {
            return "";
        }
        return name;
    }

    @NotNull
    public final GeofenceStore getGeofenceStore() {
        GeofenceStore geofenceStore = (GeofenceStore) this.f12211b.get("GeofenceInfo", GeofenceStore.class);
        if (geofenceStore == null) {
            return new GeofenceStore(null, 1, null);
        }
        return geofenceStore;
    }

    public final void removeGeofenceSubscription(@NotNull String geofenceId, long j4, @NotNull String macroName, long j5) {
        int collectionSizeOrDefault;
        Object obj;
        Object obj2;
        int i4;
        List mutableList;
        List<GeofenceUser> list;
        boolean z3;
        Intrinsics.checkNotNullParameter(geofenceId, "geofenceId");
        Intrinsics.checkNotNullParameter(macroName, "macroName");
        GeofenceInfo geofenceInfo = getGeofenceStore().getGeofenceMap().get(geofenceId);
        if (geofenceInfo == null) {
            SystemLog.logError$default("Remove Geofence - Requested Geofence does not exist. Macro: [" + macroName + "]", j5, geofenceId, null, 8, null);
            return;
        }
        List<GeofenceUser> list2 = this.f12213d.get(geofenceId);
        if (list2 != null) {
            List<GeofenceUser> list3 = list2;
            collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (GeofenceUser geofenceUser : list3) {
                arrayList.add(Long.valueOf(geofenceUser.getSelectableItemId()));
            }
            if (arrayList.contains(Long.valueOf(j4))) {
                Iterator<T> it = list3.iterator();
                while (true) {
                    obj = null;
                    if (it.hasNext()) {
                        obj2 = it.next();
                        if (((GeofenceUser) obj2).getSelectableItemId() == j4) {
                            z3 = true;
                            continue;
                        } else {
                            z3 = false;
                            continue;
                        }
                        if (z3) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                GeofenceUser geofenceUser2 = (GeofenceUser) obj2;
                int i5 = 30000;
                if (geofenceUser2 != null) {
                    i4 = geofenceUser2.getUpdateRateMs();
                } else {
                    i4 = 30000;
                }
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list2);
                kotlin.collections.i.removeAll(mutableList, (Function1) new c(j4));
                list = CollectionsKt___CollectionsKt.toList(mutableList);
                this.f12213d.put(geofenceId, list);
                SystemLog.logVerbose("Geofence [" + geofenceInfo.getName() + "] - Removed subscription. Macro: [" + macroName + "]", j5, geofenceId);
                if (list.isEmpty()) {
                    k(geofenceInfo, macroName);
                    return;
                }
                Iterator<T> it2 = list3.iterator();
                if (it2.hasNext()) {
                    obj = it2.next();
                    if (it2.hasNext()) {
                        int updateRateMs = ((GeofenceUser) obj).getUpdateRateMs();
                        do {
                            Object next = it2.next();
                            int updateRateMs2 = ((GeofenceUser) next).getUpdateRateMs();
                            if (updateRateMs > updateRateMs2) {
                                obj = next;
                                updateRateMs = updateRateMs2;
                            }
                        } while (it2.hasNext());
                    }
                }
                GeofenceUser geofenceUser3 = (GeofenceUser) obj;
                if (geofenceUser3 != null) {
                    i5 = geofenceUser3.getUpdateRateMs();
                }
                if (i4 < i5) {
                    e(geofenceInfo, i5);
                    return;
                }
                return;
            }
        }
        SystemLog.logDebug("Remove Geofence - Attempted to remove geofence from user that has not added. Macro: [" + macroName + "]", j5, geofenceId);
    }
}
