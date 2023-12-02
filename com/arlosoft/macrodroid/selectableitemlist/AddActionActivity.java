package com.arlosoft.macrodroid.selectableitemlist;

import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.categories.SelectableItemCategory;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.selectableitemlist.classic.SelectActionAdapter;
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

/* compiled from: AddActionActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class AddActionActivity extends AddSelectableItemActivity {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private final Lazy f13309p;

    /* renamed from: q  reason: collision with root package name */
    private int f13310q;

    /* renamed from: r  reason: collision with root package name */
    private long f13311r;

    /* renamed from: s  reason: collision with root package name */
    private long f13312s;
    @NotNull

    /* renamed from: t  reason: collision with root package name */
    private final Lazy f13313t;

    /* compiled from: AddActionActivity.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function0<List<? extends SelectableItemCategory>> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a */
        public final List<SelectableItemCategory> invoke() {
            AddActionActivity addActionActivity = AddActionActivity.this;
            List<SelectableItemCategory> categories = Action.getCategories(addActionActivity, addActionActivity.getMacro(), false, false);
            Intrinsics.checkNotNullExpressionValue(categories, "getCategories(this, macro, false, false)");
            return addActionActivity.sortCategories(categories);
        }
    }

    /* compiled from: AddActionActivity.kt */
    /* loaded from: classes3.dex */
    static final class b extends Lambda implements Function0<SelectActionAdapter> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a */
        public final SelectActionAdapter invoke() {
            AddActionActivity addActionActivity = AddActionActivity.this;
            return new SelectActionAdapter(addActionActivity, addActionActivity.getMacro(), !Settings.shouldHideInfoCardAction(AddActionActivity.this), AddActionActivity.this, true);
        }
    }

    public AddActionActivity() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new a());
        this.f13309p = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new b());
        this.f13313t = lazy2;
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        setTitle(R.string.add_action);
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.f13310q = extras.getInt(Constants.EXTRA_NEXT_ACTION_INDEX);
            this.f13311r = extras.getLong(Constants.EXTRA_PARENT_GUID, 0L);
            this.f13312s = extras.getLong(Constants.EXTRA_PARENT_GUID_FOR_INSERT, 0L);
            Action action = (Action) extras.getParcelable(Constants.EXTRA_CURRENT_ACTION);
            if (action != null) {
                SelectableItemInfo info = action.getInfo();
                Intrinsics.checkNotNullExpressionValue(info, "action.info");
                selectableItemChosen(info);
            }
        }
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    protected int q() {
        return R.color.actions_primary;
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    @NotNull
    protected List<SelectableItemCategory> r() {
        return (List) this.f13309p.getValue();
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    protected int s() {
        return R.color.actions_category;
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity, com.arlosoft.macrodroid.selectableitemlist.SelectableItemChosenListener
    public void selectableItemChosen(@NotNull SelectableItemInfo itemInfo) {
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        z(itemInfo.constructItem(this, getMacro()));
        SelectableItem u3 = u();
        Intrinsics.checkNotNull(u3, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.Action");
        ((Action) u3).onItemSelected(this.f13311r, this.f13312s);
        F(u());
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    public boolean shouldHideInfoCard() {
        return Settings.shouldHideInfoCardAction(this);
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    @NotNull
    protected SelectableItemAdapter t() {
        return (SelectableItemAdapter) this.f13313t.getValue();
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    protected int v() {
        return R.style.Theme_App_Dialog_Action;
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity
    protected int w() {
        return 1;
    }
}
