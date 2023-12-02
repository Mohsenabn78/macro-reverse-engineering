package com.arlosoft.macrodroid.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import androidx.appcompat.app.ActionBar;
import androidx.cardview.widget.CardView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.accessibility.AccessibilityServiceSelectionAdapter;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.databinding.ActivityKeepAccessibilityServicesRunningBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.AdbHelperUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.e;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KeepAccessibilityServicesRunningActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nKeepAccessibilityServicesRunningActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KeepAccessibilityServicesRunningActivity.kt\ncom/arlosoft/macrodroid/accessibility/KeepAccessibilityServicesRunningActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,104:1\n262#2,2:105\n*S KotlinDebug\n*F\n+ 1 KeepAccessibilityServicesRunningActivity.kt\ncom/arlosoft/macrodroid/accessibility/KeepAccessibilityServicesRunningActivity\n*L\n52#1:105,2\n*E\n"})
/* loaded from: classes2.dex */
public final class KeepAccessibilityServicesRunningActivity extends MacroDroidBaseActivity implements AccessibilityServiceSelectionAdapter.ServiceStateChangedListener {
    public static final int $stable = 8;

    /* renamed from: f  reason: collision with root package name */
    private ActivityKeepAccessibilityServicesRunningBinding f2053f;

    /* renamed from: g  reason: collision with root package name */
    private AccessibilityServiceSelectionAdapter f2054g;

    /* renamed from: h  reason: collision with root package name */
    private List<AccessibilityServiceKeepRunningState> f2055h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KeepAccessibilityServicesRunningActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: KeepAccessibilityServicesRunningActivity.kt */
        /* renamed from: com.arlosoft.macrodroid.accessibility.KeepAccessibilityServicesRunningActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0066a extends Lambda implements Function0<Unit> {
            final /* synthetic */ KeepAccessibilityServicesRunningActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0066a(KeepAccessibilityServicesRunningActivity keepAccessibilityServicesRunningActivity) {
                super(0);
                this.this$0 = keepAccessibilityServicesRunningActivity;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.o();
            }
        }

        a(Continuation<? super a> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            List listOf;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                KeepAccessibilityServicesRunningActivity keepAccessibilityServicesRunningActivity = KeepAccessibilityServicesRunningActivity.this;
                listOf = e.listOf("android.permission.WRITE_SECURE_SETTINGS");
                AdbHelperUtil.showAdbHackDetails(keepAccessibilityServicesRunningActivity, listOf, new C0066a(KeepAccessibilityServicesRunningActivity.this));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void n() {
        List<AccessibilityServiceKeepRunningState> mutableList;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) r());
        this.f2055h = mutableList;
        List<AccessibilityServiceKeepRunningState> list = this.f2055h;
        AccessibilityServiceSelectionAdapter accessibilityServiceSelectionAdapter = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceList");
            list = null;
        }
        this.f2054g = new AccessibilityServiceSelectionAdapter(list, this);
        ActivityKeepAccessibilityServicesRunningBinding activityKeepAccessibilityServicesRunningBinding = this.f2053f;
        if (activityKeepAccessibilityServicesRunningBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityKeepAccessibilityServicesRunningBinding = null;
        }
        RecyclerView recyclerView = activityKeepAccessibilityServicesRunningBinding.accessibilityServiceList;
        AccessibilityServiceSelectionAdapter accessibilityServiceSelectionAdapter2 = this.f2054g;
        if (accessibilityServiceSelectionAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            accessibilityServiceSelectionAdapter = accessibilityServiceSelectionAdapter2;
        }
        recyclerView.setAdapter(accessibilityServiceSelectionAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        boolean z3;
        ActivityKeepAccessibilityServicesRunningBinding activityKeepAccessibilityServicesRunningBinding = this.f2053f;
        if (activityKeepAccessibilityServicesRunningBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityKeepAccessibilityServicesRunningBinding = null;
        }
        CardView cardView = activityKeepAccessibilityServicesRunningBinding.adbHackCard;
        Intrinsics.checkNotNullExpressionValue(cardView, "binding.adbHackCard");
        int i4 = 0;
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_SECURE_SETTINGS") != 0 && !RootToolsHelper.isAccessGiven()) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            i4 = 8;
        }
        cardView.setVisibility(i4);
        ActivityKeepAccessibilityServicesRunningBinding activityKeepAccessibilityServicesRunningBinding2 = this.f2053f;
        if (activityKeepAccessibilityServicesRunningBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityKeepAccessibilityServicesRunningBinding2 = null;
        }
        Button button = activityKeepAccessibilityServicesRunningBinding2.adbHackOkButton;
        Intrinsics.checkNotNullExpressionValue(button, "binding.adbHackOkButton");
        ViewExtensionsKt.onClick$default(button, null, new a(null), 1, null);
    }

    private final void p() {
        ActivityKeepAccessibilityServicesRunningBinding activityKeepAccessibilityServicesRunningBinding = null;
        if (Settings.shouldHideKeepAccessibilityRunning(this)) {
            ActivityKeepAccessibilityServicesRunningBinding activityKeepAccessibilityServicesRunningBinding2 = this.f2053f;
            if (activityKeepAccessibilityServicesRunningBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityKeepAccessibilityServicesRunningBinding = activityKeepAccessibilityServicesRunningBinding2;
            }
            activityKeepAccessibilityServicesRunningBinding.infoCard.infoCardView.setVisibility(8);
            return;
        }
        ActivityKeepAccessibilityServicesRunningBinding activityKeepAccessibilityServicesRunningBinding3 = this.f2053f;
        if (activityKeepAccessibilityServicesRunningBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityKeepAccessibilityServicesRunningBinding3 = null;
        }
        activityKeepAccessibilityServicesRunningBinding3.infoCard.infoCardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.quick_settings_config_primary));
        ActivityKeepAccessibilityServicesRunningBinding activityKeepAccessibilityServicesRunningBinding4 = this.f2053f;
        if (activityKeepAccessibilityServicesRunningBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityKeepAccessibilityServicesRunningBinding4 = null;
        }
        activityKeepAccessibilityServicesRunningBinding4.infoCard.infoCardTitle.setText(R.string.keep_accessibility_services_running);
        ActivityKeepAccessibilityServicesRunningBinding activityKeepAccessibilityServicesRunningBinding5 = this.f2053f;
        if (activityKeepAccessibilityServicesRunningBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityKeepAccessibilityServicesRunningBinding5 = null;
        }
        activityKeepAccessibilityServicesRunningBinding5.infoCard.infoCardDetail.setText(R.string.keep_accessibility_services_running_info_card);
        ActivityKeepAccessibilityServicesRunningBinding activityKeepAccessibilityServicesRunningBinding6 = this.f2053f;
        if (activityKeepAccessibilityServicesRunningBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityKeepAccessibilityServicesRunningBinding = activityKeepAccessibilityServicesRunningBinding6;
        }
        activityKeepAccessibilityServicesRunningBinding.infoCard.infoCardGotIt.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.accessibility.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KeepAccessibilityServicesRunningActivity.q(KeepAccessibilityServicesRunningActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(KeepAccessibilityServicesRunningActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Settings.hideInfoCardKeepAccessibilityRunning(this$0.getApplicationContext());
        ActivityKeepAccessibilityServicesRunningBinding activityKeepAccessibilityServicesRunningBinding = this$0.f2053f;
        if (activityKeepAccessibilityServicesRunningBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityKeepAccessibilityServicesRunningBinding = null;
        }
        activityKeepAccessibilityServicesRunningBinding.infoCard.infoCardView.setVisibility(8);
    }

    private final List<AccessibilityServiceKeepRunningState> r() {
        Object systemService = getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        List<AccessibilityServiceInfo> installedAccessibilityServiceList = ((AccessibilityManager) systemService).getInstalledAccessibilityServiceList();
        List<String> accessibilityServicesToKeepRunning = Settings.getAccessibilityServicesToKeepRunning(this);
        ArrayList arrayList = new ArrayList();
        for (AccessibilityServiceInfo accessibilityServiceInfo : installedAccessibilityServiceList) {
            String obj = accessibilityServiceInfo.getResolveInfo().loadLabel(getPackageManager()).toString();
            String id = accessibilityServiceInfo.getId();
            Intrinsics.checkNotNullExpressionValue(id, "service.id");
            arrayList.add(new AccessibilityServiceKeepRunningState(obj, id, accessibilityServicesToKeepRunning.contains(accessibilityServiceInfo.getId())));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityKeepAccessibilityServicesRunningBinding inflate = ActivityKeepAccessibilityServicesRunningBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f2053f = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        setTitle(R.string.keep_accessibility_services_running);
        p();
        n();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == 16908332) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        o();
    }

    @Override // com.arlosoft.macrodroid.accessibility.AccessibilityServiceSelectionAdapter.ServiceStateChangedListener
    public void onServiceStateChanged(@NotNull String serviceid, boolean z3, int i4) {
        List mutableList;
        Intrinsics.checkNotNullParameter(serviceid, "serviceid");
        List<String> accessibilityServicesToKeepRunning = Settings.getAccessibilityServicesToKeepRunning(this);
        Intrinsics.checkNotNullExpressionValue(accessibilityServicesToKeepRunning, "getAccessibilityServicesToKeepRunning(this)");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) accessibilityServicesToKeepRunning);
        if (z3) {
            mutableList.add(serviceid);
        } else {
            mutableList.remove(serviceid);
        }
        Settings.setAccessibilityServicesToKeepRunning(this, mutableList);
        List<AccessibilityServiceKeepRunningState> list = this.f2055h;
        AccessibilityServiceSelectionAdapter accessibilityServiceSelectionAdapter = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceList");
            list = null;
        }
        List<AccessibilityServiceKeepRunningState> list2 = this.f2055h;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceList");
            list2 = null;
        }
        list.set(i4, AccessibilityServiceKeepRunningState.copy$default(list2.get(i4), null, null, z3, 3, null));
        AccessibilityServiceSelectionAdapter accessibilityServiceSelectionAdapter2 = this.f2054g;
        if (accessibilityServiceSelectionAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            accessibilityServiceSelectionAdapter = accessibilityServiceSelectionAdapter2;
        }
        accessibilityServiceSelectionAdapter.notifyItemChanged(i4);
    }
}
