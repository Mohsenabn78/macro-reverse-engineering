package com.arlosoft.macrodroid.troubleshooting.problem;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.interfaces.FileReconfigurationCandidate;
import com.arlosoft.macrodroid.interfaces.HasAndroid10FilePathIssues;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.troubleshooting.problem.Problem;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import xyz.kumaraswamy.autostart.Autostart;

/* compiled from: ProblemViewModel.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nProblemViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProblemViewModel.kt\ncom/arlosoft/macrodroid/troubleshooting/problem/ProblemViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,215:1\n1#2:216\n*E\n"})
/* loaded from: classes3.dex */
public final class ProblemViewModel extends ViewModel implements LifecycleObserver {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f15839a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final PermissionChecker f15840b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final MutableLiveData<List<Problem>> f15841c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final LiveData<List<Problem>> f15842d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProblemViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        final /* synthetic */ List<Problem> $problemList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List<Problem> list) {
            super(1);
            this.$problemList = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z3) {
            if (z3) {
                this.$problemList.add(new Problem.PermissionsWillBeDisabled());
            }
        }
    }

    @Inject
    public ProblemViewModel(@ApplicationContext @NotNull Context context, @NotNull PermissionChecker permissionChecker) {
        List emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permissionChecker, "permissionChecker");
        this.f15839a = context;
        this.f15840b = permissionChecker;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        MutableLiveData<List<Problem>> mutableLiveData = new MutableLiveData<>(emptyList);
        this.f15841c = mutableLiveData;
        this.f15842d = mutableLiveData;
    }

    private final void b(List<Problem> list, Problem problem, Macro macro) {
        Object obj;
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((Problem) obj).getClass(), problem.getClass())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Problem problem2 = (Problem) obj;
        if (problem2 == null) {
            list.add(problem);
        } else {
            problem = problem2;
        }
        problem.getMacroList().add(macro);
    }

    private final List<Problem> c() {
        ArrayList arrayList = new ArrayList();
        List<Macro> enabledMacros = MacroStore.getInstance().getEnabledMacros();
        HashMap hashMap = new HashMap();
        for (Macro macro : enabledMacros) {
            Iterator<Action> it = macro.getActions().iterator();
            while (it.hasNext()) {
                Action next = it.next();
                if (((next instanceof HasAndroid10FilePathIssues) && ((HasAndroid10FilePathIssues) next).isBrokenOnAndroid10()) || ((next instanceof FileReconfigurationCandidate) && ((FileReconfigurationCandidate) next).requiresFileReconfiguration())) {
                    if (!hashMap.containsKey(next.getName())) {
                        String name = next.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "action.name");
                        hashMap.put(name, new ArrayList());
                    }
                    List list = (List) hashMap.get(next.getName());
                    if (list != null) {
                        Intrinsics.checkNotNullExpressionValue(macro, "macro");
                        list.add(macro);
                    }
                }
            }
        }
        for (String actionName : hashMap.keySet()) {
            Intrinsics.checkNotNullExpressionValue(actionName, "actionName");
            Problem.RequiresFilePathReconfiguration requiresFilePathReconfiguration = new Problem.RequiresFilePathReconfiguration(actionName);
            List<Macro> macroList = requiresFilePathReconfiguration.getMacroList();
            Object obj = hashMap.get(actionName);
            Intrinsics.checkNotNull(obj);
            macroList.addAll((Collection) obj);
            arrayList.add(requiresFilePathReconfiguration);
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x01a4, code lost:
        if (r3 != false) goto L80;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<com.arlosoft.macrodroid.troubleshooting.problem.Problem> d() {
        /*
            Method dump skipped, instructions count: 589
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.troubleshooting.problem.ProblemViewModel.d():java.util.List");
    }

    private final List<Problem> e() {
        ArrayList arrayList = new ArrayList();
        if (i()) {
            arrayList.add(new Problem.NotificationsDisabled());
        }
        if (j()) {
            arrayList.add(new Problem.DontKeepActivitiesEnabled());
        }
        if (h()) {
            arrayList.add(new Problem.BatteryOptimizationIsEnabled());
        }
        if (k()) {
            arrayList.add(new Problem.ForceHideIconEnabled());
        }
        arrayList.addAll(c());
        arrayList.addAll(d());
        isPermissionRemoverEnabled(new a(arrayList));
        try {
            if (new Autostart(this.f15839a).getAutoStartState() == Autostart.State.DISABLED) {
                arrayList.add(new Problem.MiuiAutoStartNotEnabled());
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    private final boolean f() {
        if ((ContextCompat.checkSelfPermission(this.f15839a, "android.permission.ACCESS_FINE_LOCATION") != 0 && ContextCompat.checkSelfPermission(this.f15839a, "android.permission.ACCESS_COARSE_LOCATION") != 0) || ContextCompat.checkSelfPermission(this.f15839a, "android.permission.ACCESS_BACKGROUND_LOCATION") == 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ListenableFuture future, Function1 result) {
        boolean z3;
        boolean z4;
        Intrinsics.checkNotNullParameter(future, "$future");
        Intrinsics.checkNotNullParameter(result, "$result");
        Integer num = (Integer) future.get();
        boolean z5 = false;
        if ((num == null || num.intValue() != 0) && ((num == null || num.intValue() != 1) && (num == null || num.intValue() != 2))) {
            if ((num != null && num.intValue() == 3) || (num != null && num.intValue() == 4)) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3 || (num != null && num.intValue() == 5)) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                z5 = true;
            }
        }
        result.invoke(Boolean.valueOf(z5));
    }

    private final boolean h() {
        boolean isIgnoringBatteryOptimizations;
        if (Build.VERSION.SDK_INT >= 23) {
            Object systemService = this.f15839a.getSystemService("power");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            isIgnoringBatteryOptimizations = ((PowerManager) systemService).isIgnoringBatteryOptimizations(this.f15839a.getPackageName());
            return !isIgnoringBatteryOptimizations;
        }
        return false;
    }

    private final boolean i() {
        if (Build.VERSION.SDK_INT >= 26 && !NotificationManagerCompat.from(this.f15839a).areNotificationsEnabled()) {
            return true;
        }
        return false;
    }

    private final boolean j() {
        if (Settings.Global.getInt(this.f15839a.getContentResolver(), "always_finish_activities", 0) == 0) {
            return false;
        }
        return true;
    }

    private final boolean k() {
        if (Build.VERSION.SDK_INT < 26 && com.arlosoft.macrodroid.settings.Settings.getForceHideIcon(this.f15839a)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final LiveData<List<Problem>> getProblemList() {
        return this.f15842d;
    }

    public final void isPermissionRemoverEnabled(@NotNull final Function1<? super Boolean, Unit> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (!com.arlosoft.macrodroid.settings.Settings.getHidePermissionRemoverWarning(this.f15839a) && !this.f15840b.isDeviceAdminEnabled()) {
            final ListenableFuture<Integer> unusedAppRestrictionsStatus = PackageManagerCompat.getUnusedAppRestrictionsStatus(this.f15839a);
            Intrinsics.checkNotNullExpressionValue(unusedAppRestrictionsStatus, "getUnusedAppRestrictionsStatus(context)");
            unusedAppRestrictionsStatus.addListener(new Runnable() { // from class: com.arlosoft.macrodroid.troubleshooting.problem.c
                @Override // java.lang.Runnable
                public final void run() {
                    ProblemViewModel.g(ListenableFuture.this, result);
                }
            }, ContextCompat.getMainExecutor(this.f15839a));
            return;
        }
        result.invoke(Boolean.FALSE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        this.f15841c.postValue(e());
    }
}
