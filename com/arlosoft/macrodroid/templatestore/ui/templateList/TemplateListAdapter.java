package com.arlosoft.macrodroid.templatestore.ui.templateList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.database.room.MacroSubscription;
import com.arlosoft.macrodroid.database.room.UserSubscription;
import com.arlosoft.macrodroid.templatestore.common.FlagProvider;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import com.arlosoft.macrodroid.templatestore.translation.TemplatesTranslationHelper;
import com.arlosoft.macrodroid.templatestore.ui.TemplateItemPresenter;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TemplateListAdapter.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nTemplateListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplateListAdapter.kt\ncom/arlosoft/macrodroid/templatestore/ui/templateList/TemplateListAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,62:1\n1549#2:63\n1620#2,3:64\n1549#2:67\n1620#2,3:68\n*S KotlinDebug\n*F\n+ 1 TemplateListAdapter.kt\ncom/arlosoft/macrodroid/templatestore/ui/templateList/TemplateListAdapter\n*L\n50#1:63\n50#1:64,3\n51#1:67\n51#1:68,3\n*E\n"})
/* loaded from: classes3.dex */
public final class TemplateListAdapter extends PagedListAdapter<MacroTemplate, TemplateItemViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final TemplateItemPresenter f13966a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ProfileImageProvider f13967b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final LocalTemplateOverrideStore f13968c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final UserProvider f13969d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final FlagProvider f13970e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f13971f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f13972g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f13973h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final TemplatesTranslationHelper f13974i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private List<MacroSubscription> f13975j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private List<UserSubscription> f13976k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final List<MacroTemplate> f13977l;

    /* compiled from: TemplateListAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class TemplateDiffCallback extends DiffUtil.ItemCallback<MacroTemplate> {
        public static final int $stable = 0;

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(@NotNull MacroTemplate oldItem, @NotNull MacroTemplate newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(@NotNull MacroTemplate oldItem, @NotNull MacroTemplate newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getId() == newItem.getId();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateListAdapter(@NotNull TemplateItemPresenter presenter, @NotNull ProfileImageProvider profileImageProvider, @NotNull LocalTemplateOverrideStore templateOverrideStore, @NotNull UserProvider userProvider, @NotNull FlagProvider flagProvider, boolean z3, boolean z4, boolean z5, @Nullable TemplatesTranslationHelper templatesTranslationHelper, @NotNull List<MacroSubscription> macroSubscriptions, @NotNull List<UserSubscription> userSubscriptions) {
        super(new TemplateDiffCallback());
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(profileImageProvider, "profileImageProvider");
        Intrinsics.checkNotNullParameter(templateOverrideStore, "templateOverrideStore");
        Intrinsics.checkNotNullParameter(userProvider, "userProvider");
        Intrinsics.checkNotNullParameter(flagProvider, "flagProvider");
        Intrinsics.checkNotNullParameter(macroSubscriptions, "macroSubscriptions");
        Intrinsics.checkNotNullParameter(userSubscriptions, "userSubscriptions");
        this.f13966a = presenter;
        this.f13967b = profileImageProvider;
        this.f13968c = templateOverrideStore;
        this.f13969d = userProvider;
        this.f13970e = flagProvider;
        this.f13971f = z3;
        this.f13972g = z4;
        this.f13973h = z5;
        this.f13974i = templatesTranslationHelper;
        this.f13975j = macroSubscriptions;
        this.f13976k = userSubscriptions;
        this.f13977l = new ArrayList();
    }

    public final void updateMacroSubscriptions(@NotNull List<MacroSubscription> macroSubscriptions) {
        Intrinsics.checkNotNullParameter(macroSubscriptions, "macroSubscriptions");
        this.f13975j = macroSubscriptions;
    }

    public final void updateUserSubscriptions(@NotNull List<UserSubscription> userSubscriptions) {
        Intrinsics.checkNotNullParameter(userSubscriptions, "userSubscriptions");
        this.f13976k = userSubscriptions;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull TemplateItemViewHolder holder, int i4) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        MacroTemplate item = getItem(i4);
        Intrinsics.checkNotNull(item);
        MacroTemplate macroTemplate = item;
        MacroTemplate localOverride = this.f13968c.getLocalOverride(macroTemplate.getId());
        List<MacroSubscription> list = this.f13975j;
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (MacroSubscription macroSubscription : list) {
            arrayList.add(Integer.valueOf(macroSubscription.getMacroId()));
        }
        boolean contains = arrayList.contains(Integer.valueOf(macroTemplate.getId()));
        List<UserSubscription> list2 = this.f13976k;
        collectionSizeOrDefault2 = kotlin.collections.f.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        for (UserSubscription userSubscription : list2) {
            arrayList2.add(Integer.valueOf(userSubscription.getUserId()));
        }
        boolean contains2 = arrayList2.contains(Integer.valueOf(macroTemplate.getUserId()));
        if (localOverride != null) {
            macroTemplate = localOverride;
        }
        holder.bind(macroTemplate, i4 % 2 == 0, contains, contains2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public TemplateItemViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_template_macro, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new TemplateItemViewHolder(view, this.f13966a, this.f13967b, this.f13969d, this.f13970e, this.f13971f, this.f13977l, this.f13972g, this.f13973h, this.f13974i);
    }
}
