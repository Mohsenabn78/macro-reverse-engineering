package com.arlosoft.macrodroid.selectableitemlist;

import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.categories.SelectableItemCategory;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.selectableitemlist.classic.SelectConstraintAdapter;
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

/* compiled from: AddConstraintActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class AddConstraintActivity extends AddSelectableItemActivity {
    public static final int $stable = 8;

    /* renamed from: p  reason: collision with root package name */
    private long f13321p;
    @NotNull

    /* renamed from: q  reason: collision with root package name */
    private final Lazy f13322q;
    @NotNull

    /* renamed from: r  reason: collision with root package name */
    private final Lazy f13323r;
    @NotNull

    /* renamed from: s  reason: collision with root package name */
    private final Lazy f13324s;

    /* compiled from: AddConstraintActivity.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function0<Integer> {

        /* renamed from: d  reason: collision with root package name */
        public static final a f13325d = new a();

        a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Integer invoke() {
            return Integer.valueOf((int) R.color.constraints_primary);
        }
    }

    /* compiled from: AddConstraintActivity.kt */
    /* loaded from: classes3.dex */
    static final class b extends Lambda implements Function0<List<? extends SelectableItemCategory>> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a */
        public final List<SelectableItemCategory> invoke() {
            AddConstraintActivity addConstraintActivity = AddConstraintActivity.this;
            List<SelectableItemCategory> categories = Constraint.getCategories(addConstraintActivity, addConstraintActivity.getMacro(), false);
            Intrinsics.checkNotNullExpressionValue(categories, "getCategories(this, macro,false)");
            return addConstraintActivity.sortCategories(categories);
        }
    }

    /* compiled from: AddConstraintActivity.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function0<SelectConstraintAdapter> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a */
        public final SelectConstraintAdapter invoke() {
            AddConstraintActivity addConstraintActivity = AddConstraintActivity.this;
            return new SelectConstraintAdapter(addConstraintActivity, addConstraintActivity.getMacro(), !Settings.shouldHideInfoCardConstraint(AddConstraintActivity.this), AddConstraintActivity.this);
        }
    }

    public AddConstraintActivity() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new b());
        this.f13322q = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(a.f13325d);
        this.f13323r = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new c());
        this.f13324s = lazy3;
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    protected void F(@Nullable SelectableItem selectableItem) {
        Intrinsics.checkNotNull(selectableItem, "null cannot be cast to non-null type com.arlosoft.macrodroid.constraint.Constraint");
        ((Constraint) selectableItem).setParentGUID(this.f13321p);
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setTitle(R.string.add_constraint);
        this.f13321p = getIntent().getLongExtra(Constants.EXTRA_PARENT_GUID, 0L);
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    protected int q() {
        return ((Number) this.f13323r.getValue()).intValue();
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    @NotNull
    protected List<SelectableItemCategory> r() {
        return (List) this.f13322q.getValue();
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    protected int s() {
        return R.color.constraints_category;
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    public boolean shouldHideInfoCard() {
        return Settings.shouldHideInfoCardConstraint(this);
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    @NotNull
    protected SelectableItemAdapter t() {
        return (SelectableItemAdapter) this.f13324s.getValue();
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    protected int v() {
        return R.style.Theme_App_Dialog_Constraint;
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    protected int w() {
        return 2;
    }
}
