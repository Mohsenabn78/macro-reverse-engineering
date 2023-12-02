package com.arlosoft.macrodroid.templatestore.ui.subscription;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.macros.MyMacroSubscriptionsFragment;
import com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.users.MyUserSubscriptionsFragment;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MySubscriptionsActivity.kt */
/* loaded from: classes3.dex */
public final class b extends FragmentStateAdapter {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final MySubscriptionsActivity f13877a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull MySubscriptionsActivity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f13877a = activity;
    }

    @NotNull
    public final String a(int i4) {
        if (i4 == 0) {
            String string = this.f13877a.getString(R.string.list_macros);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.list_macros)");
            return string;
        }
        String string2 = this.f13877a.getString(R.string.subscription_type_users);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.str….subscription_type_users)");
        return string2;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NotNull
    public Fragment createFragment(int i4) {
        if (i4 == 0) {
            return MyMacroSubscriptionsFragment.Companion.newInstance();
        }
        return MyUserSubscriptionsFragment.Companion.newInstance();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 2;
    }
}
