package com.arlosoft.macrodroid.uiinteraction;

import android.content.pm.PackageManager;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.databinding.ListItemUiInteractionBinding;
import com.arlosoft.macrodroid.extensions.SpannableExtensionsKt;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.description.type.TypeDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UiInteractionAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class UiInteractionAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<UiInteraction> f15864a;

    /* compiled from: UiInteractionAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class VarDescriptor {
        public static final int $stable = 0;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final String f15865a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final String f15866b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private final String f15867c;

        public VarDescriptor(@NotNull String identifier, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.f15865a = identifier;
            this.f15866b = str;
            this.f15867c = str2;
        }

        public static /* synthetic */ VarDescriptor copy$default(VarDescriptor varDescriptor, String str, String str2, String str3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = varDescriptor.f15865a;
            }
            if ((i4 & 2) != 0) {
                str2 = varDescriptor.f15866b;
            }
            if ((i4 & 4) != 0) {
                str3 = varDescriptor.f15867c;
            }
            return varDescriptor.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return this.f15865a;
        }

        @Nullable
        public final String component2() {
            return this.f15866b;
        }

        @Nullable
        public final String component3() {
            return this.f15867c;
        }

        @NotNull
        public final VarDescriptor copy(@NotNull String identifier, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            return new VarDescriptor(identifier, str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VarDescriptor)) {
                return false;
            }
            VarDescriptor varDescriptor = (VarDescriptor) obj;
            if (Intrinsics.areEqual(this.f15865a, varDescriptor.f15865a) && Intrinsics.areEqual(this.f15866b, varDescriptor.f15866b) && Intrinsics.areEqual(this.f15867c, varDescriptor.f15867c)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String getDescription() {
            return this.f15867c;
        }

        @NotNull
        public final String getIdentifier() {
            return this.f15865a;
        }

        @Nullable
        public final String getName() {
            return this.f15866b;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.f15865a.hashCode() * 31;
            String str = this.f15866b;
            int i4 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i5 = (hashCode2 + hashCode) * 31;
            String str2 = this.f15867c;
            if (str2 != null) {
                i4 = str2.hashCode();
            }
            return i5 + i4;
        }

        @NotNull
        public String toString() {
            String str = this.f15865a;
            String str2 = this.f15866b;
            String str3 = this.f15867c;
            return "VarDescriptor(identifier=" + str + ", name=" + str2 + ", description=" + str3 + ")";
        }

        public /* synthetic */ VarDescriptor(String str, String str2, String str3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i4 & 2) != 0 ? null : str2, (i4 & 4) != 0 ? null : str3);
        }
    }

    /* compiled from: UiInteractionAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ListItemUiInteractionBinding f15868a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: UiInteractionAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function0<SpannableString> {
            final /* synthetic */ String $appName;
            final /* synthetic */ UiInteraction $event;
            final /* synthetic */ String $eventType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, UiInteraction uiInteraction, String str2) {
                super(0);
                this.$appName = str;
                this.$event = uiInteraction;
                this.$eventType = str2;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            /* renamed from: a */
            public final SpannableString invoke() {
                String str = this.$appName;
                SpannableString bold = SpannableExtensionsKt.bold(SpannableExtensionsKt.color(-16777216, str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR));
                int i4 = this.$event.getScreenXY().x;
                int i5 = this.$event.getScreenXY().y;
                SpannableString plus = SpannableExtensionsKt.plus(bold, SpannableExtensionsKt.color(-3355444, i4 + "," + i5 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR));
                String str2 = this.$eventType;
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                SpannableString plus2 = SpannableExtensionsKt.plus(plus, SpannableExtensionsKt.color(-16776961, sb.toString()));
                String contentDescription = this.$event.getContentDescription();
                SpannableString plus3 = SpannableExtensionsKt.plus(plus2, SpannableExtensionsKt.color(-16711936, contentDescription + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR));
                String viewText = this.$event.getViewText();
                SpannableString plus4 = SpannableExtensionsKt.plus(plus3, SpannableExtensionsKt.color(SupportMenu.CATEGORY_MASK, viewText + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR));
                String viewIdResourceName = this.$event.getViewIdResourceName();
                SpannableString plus5 = SpannableExtensionsKt.plus(plus4, SpannableExtensionsKt.color(-65281, viewIdResourceName + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR));
                long timestamp = this.$event.getTimestamp();
                return SpannableExtensionsKt.plus(plus5, SpannableExtensionsKt.color(-12303292, timestamp + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull ListItemUiInteractionBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f15868a = binding;
        }

        private final String a(int i4) {
            if (i4 != 1) {
                if (i4 != 2) {
                    return TypeDescription.Generic.OfWildcardType.SYMBOL;
                }
                String string = this.itemView.getContext().getString(R.string.ui_interaction_long_click);
                Intrinsics.checkNotNullExpressionValue(string, "itemView.context.getStri…i_interaction_long_click)");
                return string;
            }
            String string2 = this.itemView.getContext().getString(R.string.ui_interaction_click);
            Intrinsics.checkNotNullExpressionValue(string2, "itemView.context.getStri…ing.ui_interaction_click)");
            return string2;
        }

        public final void bind(@NotNull UiInteraction event) {
            Intrinsics.checkNotNullParameter(event, "event");
            PackageManager packageManager = this.f15868a.getRoot().getContext().getPackageManager();
            this.f15868a.interactionName.setText(SpannableExtensionsKt.spannable(new a(packageManager.getApplicationLabel(packageManager.getApplicationInfo(event.getPackageName(), 128)).toString(), event, a(event.getEventType()))));
        }
    }

    public UiInteractionAdapter(@NotNull List<UiInteraction> events) {
        Intrinsics.checkNotNullParameter(events, "events");
        this.f15864a = events;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f15864a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f15864a.get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ListItemUiInteractionBinding inflate = ListItemUiInteractionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ViewHolder(inflate);
    }
}
