package com.arlosoft.macrodroid.editscreen;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.getpebble.android.kit.Constants;
import com.google.android.material.card.MaterialCardView;
import java.util.Arrays;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt___StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LocalVarsViewHolder.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nLocalVarsViewHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LocalVarsViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/LocalVarsViewHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,98:1\n262#2,2:99\n*S KotlinDebug\n*F\n+ 1 LocalVarsViewHolder.kt\ncom/arlosoft/macrodroid/editscreen/LocalVarsViewHolder\n*L\n46#1:99,2\n*E\n"})
/* loaded from: classes3.dex */
public final class LocalVarsViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Resources f11821a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f11822b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Function1<MacroDroidVariable, Unit> f11823c;
    @BindView(R.id.cardView)
    public MaterialCardView cardView;
    @BindView(R.id.macro_edit_entry_icon)
    public ImageView icon;
    @BindView(R.id.iconText)
    public TextView iconText;
    @BindView(R.id.topLevelContainer)
    public ViewGroup mainContainer;
    @BindView(R.id.macro_edit_entry_name)
    public TextView name;
    @BindView(R.id.macro_edit_entry_detail)
    public TextView value;

    /* compiled from: LocalVarsViewHolder.kt */
    /* loaded from: classes3.dex */
    static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ MacroDroidVariable $variable;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(MacroDroidVariable macroDroidVariable, Continuation<? super a> continuation) {
            super(3, continuation);
            this.$variable = macroDroidVariable;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(this.$variable, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LocalVarsViewHolder.this.f11823c.invoke(this.$variable);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LocalVarsViewHolder(@NotNull View itemView, @NotNull Resources resources, boolean z3, @NotNull Function1<? super MacroDroidVariable, Unit> clickListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.f11821a = resources;
        this.f11822b = z3;
        this.f11823c = clickListener;
        ButterKnife.bind(this, itemView);
        int dimensionPixelSize = itemView.getContext().getResources().getDimensionPixelSize(R.dimen.edit_entry_horizontal_padding);
        getMainContainer$app_standardRelease().setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        getIconText$app_standardRelease().setVisibility(0);
    }

    public final void bind(@NotNull MacroDroidVariable variable) {
        int i4;
        String stringNoMagicText;
        String format;
        String take;
        String str;
        char first;
        char first2;
        char first3;
        char first4;
        boolean z3;
        int i5;
        Intrinsics.checkNotNullParameter(variable, "variable");
        getName$app_standardRelease().setText(variable.getName());
        ViewExtensionsKt.onClick$default(getMainContainer$app_standardRelease(), null, new a(variable, null), 1, null);
        if (this.f11822b) {
            getIcon$app_standardRelease().setBackgroundResource(R.drawable.circular_icon_background_action_dark);
            getCardView().setCardBackgroundColor(ContextCompat.getColor(getIcon$app_standardRelease().getContext(), R.color.actions_primary));
        } else {
            getIcon$app_standardRelease().setBackgroundResource(R.drawable.circular_icon_background_local_variable_dark);
            getCardView().setCardBackgroundColor(ContextCompat.getColor(getIcon$app_standardRelease().getContext(), R.color.local_vars_primary));
        }
        ImageView icon$app_standardRelease = getIcon$app_standardRelease();
        if (variable.isDictionary()) {
            i4 = R.drawable.ic_dictionary;
        } else if (variable.isArray()) {
            i4 = R.drawable.ic_code_brackets;
        } else {
            i4 = 0;
        }
        icon$app_standardRelease.setImageResource(i4);
        if (variable.isBoolean()) {
            Resources resources = this.f11821a;
            if (variable.getBooleanValue()) {
                i5 = R.string.true_label;
            } else {
                i5 = R.string.false_label;
            }
            stringNoMagicText = resources.getString(i5);
        } else {
            stringNoMagicText = variable.toStringNoMagicText();
        }
        Intrinsics.checkNotNullExpressionValue(stringNoMagicText, "if (variable.isBoolean) …ngNoMagicText()\n        }");
        if (!variable.isDictionary() && !variable.isArray()) {
            if (stringNoMagicText.length() == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                format = "<" + this.itemView.getContext().getString(R.string.empty) + ">";
            } else {
                format = variable.toStringNoMagicText();
            }
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = this.f11821a.getString(R.string.variable_multi_entry_num_entries);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…_multi_entry_num_entries)");
            format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(variable.getDictionary().getEntries().size())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        }
        TextView value$app_standardRelease = getValue$app_standardRelease();
        if (!this.f11822b) {
            take = StringsKt___StringsKt.take(format, 300);
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String string2 = this.itemView.getContext().getString(R.string.action_block_variable_default_value);
            Intrinsics.checkNotNullExpressionValue(string2, "itemView.context.getStri…k_variable_default_value)");
            take = String.format(string2, Arrays.copyOf(new Object[]{format}, 1));
            Intrinsics.checkNotNullExpressionValue(take, "format(format, *args)");
        }
        value$app_standardRelease.setText(take);
        TextView iconText$app_standardRelease = getIconText$app_standardRelease();
        if (variable.isBoolean()) {
            String string3 = this.itemView.getContext().getString(R.string.bool);
            Intrinsics.checkNotNullExpressionValue(string3, "itemView.context.getString(R.string.bool)");
            first4 = StringsKt___StringsKt.first(string3);
            str = String.valueOf(first4);
        } else if (variable.isDecimal()) {
            String string4 = this.itemView.getContext().getString(R.string.decimal);
            Intrinsics.checkNotNullExpressionValue(string4, "itemView.context.getString(R.string.decimal)");
            first3 = StringsKt___StringsKt.first(string4);
            str = String.valueOf(first3);
        } else if (variable.isInt()) {
            String string5 = this.itemView.getContext().getString(R.string.integer);
            Intrinsics.checkNotNullExpressionValue(string5, "itemView.context.getString(R.string.integer)");
            first2 = StringsKt___StringsKt.first(string5);
            str = String.valueOf(first2);
        } else if (variable.isString()) {
            String string6 = this.itemView.getContext().getString(R.string.string);
            Intrinsics.checkNotNullExpressionValue(string6, "itemView.context.getString(R.string.string)");
            first = StringsKt___StringsKt.first(string6);
            str = String.valueOf(first);
        } else {
            str = "";
        }
        iconText$app_standardRelease.setText(str);
    }

    @NotNull
    public final MaterialCardView getCardView() {
        MaterialCardView materialCardView = this.cardView;
        if (materialCardView != null) {
            return materialCardView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cardView");
        return null;
    }

    @NotNull
    public final ImageView getIcon$app_standardRelease() {
        ImageView imageView = this.icon;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException(Constants.CUST_ICON);
        return null;
    }

    @NotNull
    public final TextView getIconText$app_standardRelease() {
        TextView textView = this.iconText;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("iconText");
        return null;
    }

    @NotNull
    public final ViewGroup getMainContainer$app_standardRelease() {
        ViewGroup viewGroup = this.mainContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mainContainer");
        return null;
    }

    @NotNull
    public final TextView getName$app_standardRelease() {
        TextView textView = this.name;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("name");
        return null;
    }

    @NotNull
    public final TextView getValue$app_standardRelease() {
        TextView textView = this.value;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("value");
        return null;
    }

    public final void setCardView(@NotNull MaterialCardView materialCardView) {
        Intrinsics.checkNotNullParameter(materialCardView, "<set-?>");
        this.cardView = materialCardView;
    }

    public final void setIcon$app_standardRelease(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.icon = imageView;
    }

    public final void setIconText$app_standardRelease(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.iconText = textView;
    }

    public final void setMainContainer$app_standardRelease(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.mainContainer = viewGroup;
    }

    public final void setName$app_standardRelease(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.name = textView;
    }

    public final void setValue$app_standardRelease(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.value = textView;
    }
}
