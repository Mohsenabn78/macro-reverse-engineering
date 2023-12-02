package com.arlosoft.macrodroid.selectableitemlist;

import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.categories.SelectableItemCategory;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.selectableitemlist.classic.SelectTriggerAdapter;
import com.arlosoft.macrodroid.selectableitemlist.classic.SelectableItemAdapter;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AddTriggerActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class AddTriggerActivity extends AddSelectableItemActivity {
    public static final int $stable = 8;

    /* renamed from: p  reason: collision with root package name */
    private long f13338p;
    @NotNull

    /* renamed from: q  reason: collision with root package name */
    private final Lazy f13339q;
    @NotNull

    /* renamed from: r  reason: collision with root package name */
    private final Lazy f13340r;

    /* compiled from: AddTriggerActivity.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function0<List<? extends SelectableItemCategory>> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a */
        public final List<SelectableItemCategory> invoke() {
            AddTriggerActivity addTriggerActivity = AddTriggerActivity.this;
            List<SelectableItemCategory> categories = Trigger.getCategories(addTriggerActivity);
            Intrinsics.checkNotNullExpressionValue(categories, "getCategories(this)");
            return addTriggerActivity.sortCategories(categories);
        }
    }

    /* compiled from: AddTriggerActivity.kt */
    /* loaded from: classes3.dex */
    static final class b extends Lambda implements Function0<SelectTriggerAdapter> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a */
        public final SelectTriggerAdapter invoke() {
            AddTriggerActivity addTriggerActivity = AddTriggerActivity.this;
            return new SelectTriggerAdapter(addTriggerActivity, addTriggerActivity.getMacro(), !Settings.shouldHideInfoCardTrigger(AddTriggerActivity.this), AddTriggerActivity.this);
        }
    }

    public AddTriggerActivity() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new a());
        this.f13339q = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new b());
        this.f13340r = lazy2;
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    protected void F(@Nullable SelectableItem selectableItem) {
        Intrinsics.checkNotNull(selectableItem, "null cannot be cast to non-null type com.arlosoft.macrodroid.triggers.Trigger");
        ((Trigger) selectableItem).setParentGUID(this.f13338p);
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setTitle(R.string.add_trigger);
        this.f13338p = getIntent().getLongExtra(Constants.EXTRA_PARENT_GUID, 0L);
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    protected int q() {
        return R.color.trigger_primary;
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    @NotNull
    protected List<SelectableItemCategory> r() {
        return (List) this.f13339q.getValue();
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    protected int s() {
        return R.color.trigger_category;
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    public boolean shouldHideInfoCard() {
        return Settings.shouldHideInfoCardTrigger(this);
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    @NotNull
    protected SelectableItemAdapter t() {
        return (SelectableItemAdapter) this.f13340r.getValue();
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    protected int v() {
        return R.style.Theme_App_Dialog_Trigger;
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    protected int w() {
        return 0;
    }
}
