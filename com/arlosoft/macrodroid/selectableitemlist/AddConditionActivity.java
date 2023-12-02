package com.arlosoft.macrodroid.selectableitemlist;

import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.categories.SelectableItemCategory;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.selectableitemlist.classic.SelectConditionAdapter;
import com.arlosoft.macrodroid.selectableitemlist.classic.SelectableItemAdapter;
import com.arlosoft.macrodroid.settings.Settings;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AddConditionActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class AddConditionActivity extends AddSelectableItemActivity {
    public static final int $stable = 8;

    /* renamed from: p  reason: collision with root package name */
    private long f13314p;
    @NotNull

    /* renamed from: q  reason: collision with root package name */
    private final Lazy f13315q;
    @NotNull

    /* renamed from: r  reason: collision with root package name */
    private final Lazy f13316r;

    /* renamed from: s  reason: collision with root package name */
    private final int f13317s;
    @NotNull

    /* renamed from: t  reason: collision with root package name */
    private final Lazy f13318t;

    /* renamed from: u  reason: collision with root package name */
    private final boolean f13319u;

    /* compiled from: AddConditionActivity.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function0<Integer> {

        /* renamed from: d  reason: collision with root package name */
        public static final a f13320d = new a();

        a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Integer invoke() {
            return Integer.valueOf((int) R.color.condition_primary);
        }
    }

    /* compiled from: AddConditionActivity.kt */
    /* loaded from: classes3.dex */
    static final class b extends Lambda implements Function0<List<? extends SelectableItemCategory>> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a */
        public final List<SelectableItemCategory> invoke() {
            AddConditionActivity addConditionActivity = AddConditionActivity.this;
            List<SelectableItemCategory> categories = Constraint.getCategories(addConditionActivity, addConditionActivity.getMacro(), false);
            Intrinsics.checkNotNullExpressionValue(categories, "getCategories(this, macro,false)");
            return addConditionActivity.sortCategories(categories);
        }
    }

    /* compiled from: AddConditionActivity.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function0<SelectConditionAdapter> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a */
        public final SelectConditionAdapter invoke() {
            AddConditionActivity addConditionActivity = AddConditionActivity.this;
            return new SelectConditionAdapter(addConditionActivity, addConditionActivity.getMacro(), !Settings.shouldHideInfoCardConstraint(AddConditionActivity.this), AddConditionActivity.this);
        }
    }

    public AddConditionActivity() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new b());
        this.f13315q = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(a.f13320d);
        this.f13316r = lazy2;
        this.f13317s = R.color.condition_category;
        lazy3 = LazyKt__LazyJVMKt.lazy(new c());
        this.f13318t = lazy3;
        this.f13319u = true;
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    protected void F(@Nullable SelectableItem selectableItem) {
        Intrinsics.checkNotNull(selectableItem, "null cannot be cast to non-null type com.arlosoft.macrodroid.constraint.Constraint");
        ((Constraint) selectableItem).setParentGUID(this.f13314p);
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    public boolean isCondition() {
        return this.f13319u;
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setTitle(R.string.add_condition);
        this.f13314p = getIntent().getLongExtra(Constants.EXTRA_PARENT_GUID, 0L);
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    protected int q() {
        return ((Number) this.f13316r.getValue()).intValue();
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    @NotNull
    protected List<SelectableItemCategory> r() {
        return (List) this.f13315q.getValue();
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    protected int s() {
        return this.f13317s;
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    public boolean shouldHideInfoCard() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    @NotNull
    protected SelectableItemAdapter t() {
        return (SelectableItemAdapter) this.f13318t.getValue();
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    protected int v() {
        return R.style.Theme_App_Dialog_Condition;
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    protected int w() {
        return 2;
    }
}
