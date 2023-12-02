package com.arlosoft.macrodroid.extras.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.databinding.ViewSubscriptionOptionBinding;
import com.arlosoft.macrodroid.upgrade.billing.SubscriptionPrice;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SubscriptionOptionView.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nSubscriptionOptionView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SubscriptionOptionView.kt\ncom/arlosoft/macrodroid/extras/ui/views/SubscriptionOptionView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,113:1\n262#2,2:114\n262#2,2:116\n262#2,2:118\n262#2,2:120\n262#2,2:122\n262#2,2:124\n262#2,2:126\n262#2,2:128\n262#2,2:130\n262#2,2:132\n262#2,2:134\n262#2,2:136\n*S KotlinDebug\n*F\n+ 1 SubscriptionOptionView.kt\ncom/arlosoft/macrodroid/extras/ui/views/SubscriptionOptionView\n*L\n55#1:114,2\n57#1:116,2\n60#1:118,2\n66#1:120,2\n67#1:122,2\n72#1:124,2\n75#1:126,2\n80#1:128,2\n83#1:130,2\n87#1:132,2\n88#1:134,2\n98#1:136,2\n*E\n"})
/* loaded from: classes3.dex */
public final class SubscriptionOptionView extends FrameLayout implements Checkable {
    public static final int $stable = 8;

    /* renamed from: a  reason: collision with root package name */
    private ViewSubscriptionOptionBinding f12133a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12134b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12135c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionOptionView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        b(this, null, 1, null);
    }

    private final void a(AttributeSet attributeSet) {
        ViewSubscriptionOptionBinding inflate = ViewSubscriptionOptionBinding.inflate(LayoutInflater.from(getContext()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this, true)");
        this.f12133a = inflate;
        ViewSubscriptionOptionBinding viewSubscriptionOptionBinding = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SubscriptionOptionView, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…criptionOptionView, 0, 0)");
            String string = obtainStyledAttributes.getString(1);
            boolean z3 = obtainStyledAttributes.getBoolean(0, false);
            if (string != null) {
                ViewSubscriptionOptionBinding viewSubscriptionOptionBinding2 = this.f12133a;
                if (viewSubscriptionOptionBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    viewSubscriptionOptionBinding2 = null;
                }
                viewSubscriptionOptionBinding2.periodText.setText(string);
                setChecked(z3);
            }
        }
        ViewSubscriptionOptionBinding viewSubscriptionOptionBinding3 = this.f12133a;
        if (viewSubscriptionOptionBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewSubscriptionOptionBinding3 = null;
        }
        TextView textView = viewSubscriptionOptionBinding3.crossThroughPrice;
        ViewSubscriptionOptionBinding viewSubscriptionOptionBinding4 = this.f12133a;
        if (viewSubscriptionOptionBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewSubscriptionOptionBinding = viewSubscriptionOptionBinding4;
        }
        textView.setPaintFlags(viewSubscriptionOptionBinding.crossThroughPrice.getPaintFlags() | 16);
    }

    static /* synthetic */ void b(SubscriptionOptionView subscriptionOptionView, AttributeSet attributeSet, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            attributeSet = null;
        }
        subscriptionOptionView.a(attributeSet);
    }

    private final void c(int i4, int i5) {
        boolean z3;
        int i6;
        ViewSubscriptionOptionBinding viewSubscriptionOptionBinding = this.f12133a;
        ViewSubscriptionOptionBinding viewSubscriptionOptionBinding2 = null;
        if (viewSubscriptionOptionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewSubscriptionOptionBinding = null;
        }
        TextView textView = viewSubscriptionOptionBinding.freeTrialLabel;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.freeTrialLabel");
        if (i4 <= 0 && i5 <= 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            i6 = 0;
        } else {
            i6 = 8;
        }
        textView.setVisibility(i6);
        if (i4 > 0) {
            ViewSubscriptionOptionBinding viewSubscriptionOptionBinding3 = this.f12133a;
            if (viewSubscriptionOptionBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewSubscriptionOptionBinding3 = null;
            }
            TextView textView2 = viewSubscriptionOptionBinding3.freeTrialLabel;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            ViewSubscriptionOptionBinding viewSubscriptionOptionBinding4 = this.f12133a;
            if (viewSubscriptionOptionBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                viewSubscriptionOptionBinding2 = viewSubscriptionOptionBinding4;
            }
            String string = viewSubscriptionOptionBinding2.checkImage.getContext().getString(R.string.num_days_free_trial);
            Intrinsics.checkNotNullExpressionValue(string, "binding.checkImage.conte…ring.num_days_free_trial)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i4)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView2.setText(format);
        } else if (i5 > 0) {
            ViewSubscriptionOptionBinding viewSubscriptionOptionBinding5 = this.f12133a;
            if (viewSubscriptionOptionBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewSubscriptionOptionBinding5 = null;
            }
            TextView textView3 = viewSubscriptionOptionBinding5.freeTrialLabel;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            ViewSubscriptionOptionBinding viewSubscriptionOptionBinding6 = this.f12133a;
            if (viewSubscriptionOptionBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                viewSubscriptionOptionBinding2 = viewSubscriptionOptionBinding6;
            }
            String string2 = viewSubscriptionOptionBinding2.checkImage.getContext().getString(R.string.num_months_free_trial);
            Intrinsics.checkNotNullExpressionValue(string2, "binding.checkImage.conte…ng.num_months_free_trial)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(i5)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            textView3.setText(format2);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f12134b;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z3) {
        int i4;
        int i5;
        this.f12134b = z3;
        ViewSubscriptionOptionBinding viewSubscriptionOptionBinding = this.f12133a;
        ViewSubscriptionOptionBinding viewSubscriptionOptionBinding2 = null;
        if (viewSubscriptionOptionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewSubscriptionOptionBinding = null;
        }
        ImageView imageView = viewSubscriptionOptionBinding.checkImage;
        if (this.f12134b) {
            i4 = R.drawable.ic_check_circle;
        } else {
            i4 = R.drawable.bg_circle_shape;
        }
        imageView.setImageResource(i4);
        ViewSubscriptionOptionBinding viewSubscriptionOptionBinding3 = this.f12133a;
        if (viewSubscriptionOptionBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewSubscriptionOptionBinding2 = viewSubscriptionOptionBinding3;
        }
        LinearLayout linearLayout = viewSubscriptionOptionBinding2.purchaseContainer;
        if (this.f12134b) {
            i5 = R.drawable.purchase_option_bg_selected;
        } else {
            i5 = R.drawable.purchase_option_bg;
        }
        linearLayout.setBackgroundResource(i5);
    }

    public final void setPrice(@NotNull SubscriptionPrice price) {
        Intrinsics.checkNotNullParameter(price, "price");
        ViewSubscriptionOptionBinding viewSubscriptionOptionBinding = null;
        if (price instanceof SubscriptionPrice.StandardPrice) {
            ViewSubscriptionOptionBinding viewSubscriptionOptionBinding2 = this.f12133a;
            if (viewSubscriptionOptionBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewSubscriptionOptionBinding2 = null;
            }
            viewSubscriptionOptionBinding2.price.setText(((SubscriptionPrice.StandardPrice) price).getPrice());
            ViewSubscriptionOptionBinding viewSubscriptionOptionBinding3 = this.f12133a;
            if (viewSubscriptionOptionBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewSubscriptionOptionBinding3 = null;
            }
            TextView textView = viewSubscriptionOptionBinding3.crossThroughPrice;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.crossThroughPrice");
            textView.setVisibility(8);
            if (this.f12135c) {
                ViewSubscriptionOptionBinding viewSubscriptionOptionBinding4 = this.f12133a;
                if (viewSubscriptionOptionBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    viewSubscriptionOptionBinding4 = null;
                }
                TextView textView2 = viewSubscriptionOptionBinding4.bubbleText;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.bubbleText");
                textView2.setVisibility(0);
                ViewSubscriptionOptionBinding viewSubscriptionOptionBinding5 = this.f12133a;
                if (viewSubscriptionOptionBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    viewSubscriptionOptionBinding5 = null;
                }
                viewSubscriptionOptionBinding5.bubbleText.setText(getContext().getString(R.string.best_value));
            } else {
                ViewSubscriptionOptionBinding viewSubscriptionOptionBinding6 = this.f12133a;
                if (viewSubscriptionOptionBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    viewSubscriptionOptionBinding6 = null;
                }
                TextView textView3 = viewSubscriptionOptionBinding6.bubbleText;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.bubbleText");
                textView3.setVisibility(8);
            }
            c(0, 0);
        } else if (price instanceof SubscriptionPrice.FreeTrialStandardPrice) {
            ViewSubscriptionOptionBinding viewSubscriptionOptionBinding7 = this.f12133a;
            if (viewSubscriptionOptionBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewSubscriptionOptionBinding7 = null;
            }
            SubscriptionPrice.FreeTrialStandardPrice freeTrialStandardPrice = (SubscriptionPrice.FreeTrialStandardPrice) price;
            viewSubscriptionOptionBinding7.price.setText(freeTrialStandardPrice.getPrice());
            ViewSubscriptionOptionBinding viewSubscriptionOptionBinding8 = this.f12133a;
            if (viewSubscriptionOptionBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewSubscriptionOptionBinding8 = null;
            }
            TextView textView4 = viewSubscriptionOptionBinding8.crossThroughPrice;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.crossThroughPrice");
            textView4.setVisibility(8);
            ViewSubscriptionOptionBinding viewSubscriptionOptionBinding9 = this.f12133a;
            if (viewSubscriptionOptionBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewSubscriptionOptionBinding9 = null;
            }
            TextView textView5 = viewSubscriptionOptionBinding9.bubbleText;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.bubbleText");
            textView5.setVisibility(8);
            c(freeTrialStandardPrice.getFreeDays(), freeTrialStandardPrice.getFreeMonths());
        } else if (price instanceof SubscriptionPrice.DiscountedPrice) {
            ViewSubscriptionOptionBinding viewSubscriptionOptionBinding10 = this.f12133a;
            if (viewSubscriptionOptionBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewSubscriptionOptionBinding10 = null;
            }
            SubscriptionPrice.DiscountedPrice discountedPrice = (SubscriptionPrice.DiscountedPrice) price;
            viewSubscriptionOptionBinding10.price.setText(discountedPrice.getDiscountPrice());
            ViewSubscriptionOptionBinding viewSubscriptionOptionBinding11 = this.f12133a;
            if (viewSubscriptionOptionBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewSubscriptionOptionBinding11 = null;
            }
            TextView textView6 = viewSubscriptionOptionBinding11.crossThroughPrice;
            Intrinsics.checkNotNullExpressionValue(textView6, "binding.crossThroughPrice");
            textView6.setVisibility(0);
            ViewSubscriptionOptionBinding viewSubscriptionOptionBinding12 = this.f12133a;
            if (viewSubscriptionOptionBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewSubscriptionOptionBinding12 = null;
            }
            viewSubscriptionOptionBinding12.crossThroughPrice.setText(discountedPrice.getPrice());
            ViewSubscriptionOptionBinding viewSubscriptionOptionBinding13 = this.f12133a;
            if (viewSubscriptionOptionBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewSubscriptionOptionBinding13 = null;
            }
            TextView textView7 = viewSubscriptionOptionBinding13.bubbleText;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getContext().getString(R.string.flash_sale_percentage_off);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…lash_sale_percentage_off)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(discountedPrice.getDiscountPercent())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView7.setText(format);
            ViewSubscriptionOptionBinding viewSubscriptionOptionBinding14 = this.f12133a;
            if (viewSubscriptionOptionBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewSubscriptionOptionBinding14 = null;
            }
            TextView textView8 = viewSubscriptionOptionBinding14.bubbleText;
            Intrinsics.checkNotNullExpressionValue(textView8, "binding.bubbleText");
            textView8.setVisibility(0);
            c(0, 0);
        } else if (price instanceof SubscriptionPrice.FreeTrialWithDiscount) {
            ViewSubscriptionOptionBinding viewSubscriptionOptionBinding15 = this.f12133a;
            if (viewSubscriptionOptionBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewSubscriptionOptionBinding15 = null;
            }
            SubscriptionPrice.FreeTrialWithDiscount freeTrialWithDiscount = (SubscriptionPrice.FreeTrialWithDiscount) price;
            viewSubscriptionOptionBinding15.price.setText(freeTrialWithDiscount.getDiscountPrice());
            ViewSubscriptionOptionBinding viewSubscriptionOptionBinding16 = this.f12133a;
            if (viewSubscriptionOptionBinding16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewSubscriptionOptionBinding16 = null;
            }
            TextView textView9 = viewSubscriptionOptionBinding16.crossThroughPrice;
            Intrinsics.checkNotNullExpressionValue(textView9, "binding.crossThroughPrice");
            textView9.setVisibility(0);
            ViewSubscriptionOptionBinding viewSubscriptionOptionBinding17 = this.f12133a;
            if (viewSubscriptionOptionBinding17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewSubscriptionOptionBinding17 = null;
            }
            viewSubscriptionOptionBinding17.crossThroughPrice.setText(freeTrialWithDiscount.getPrice());
            ViewSubscriptionOptionBinding viewSubscriptionOptionBinding18 = this.f12133a;
            if (viewSubscriptionOptionBinding18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewSubscriptionOptionBinding18 = null;
            }
            TextView textView10 = viewSubscriptionOptionBinding18.bubbleText;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String string2 = getContext().getString(R.string.flash_sale_percentage_off);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…lash_sale_percentage_off)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(freeTrialWithDiscount.getDiscountPercent())}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            textView10.setText(format2);
            ViewSubscriptionOptionBinding viewSubscriptionOptionBinding19 = this.f12133a;
            if (viewSubscriptionOptionBinding19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                viewSubscriptionOptionBinding19 = null;
            }
            TextView textView11 = viewSubscriptionOptionBinding19.bubbleText;
            Intrinsics.checkNotNullExpressionValue(textView11, "binding.bubbleText");
            textView11.setVisibility(0);
            c(freeTrialWithDiscount.getFreeDays(), freeTrialWithDiscount.getFreeMonths());
        }
        ViewSubscriptionOptionBinding viewSubscriptionOptionBinding20 = this.f12133a;
        if (viewSubscriptionOptionBinding20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewSubscriptionOptionBinding20 = null;
        }
        TextView textView12 = viewSubscriptionOptionBinding20.price;
        Intrinsics.checkNotNullExpressionValue(textView12, "binding.price");
        textView12.setVisibility(0);
        ViewSubscriptionOptionBinding viewSubscriptionOptionBinding21 = this.f12133a;
        if (viewSubscriptionOptionBinding21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewSubscriptionOptionBinding = viewSubscriptionOptionBinding21;
        }
        ProgressBar progressBar = viewSubscriptionOptionBinding.priceProgressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.priceProgressBar");
        progressBar.setVisibility(8);
    }

    public final void setShowBestValueLabel(boolean z3) {
        this.f12135c = z3;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f12134b);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionOptionView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        a(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionOptionView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        Intrinsics.checkNotNullParameter(context, "context");
        a(attributeSet);
    }
}
