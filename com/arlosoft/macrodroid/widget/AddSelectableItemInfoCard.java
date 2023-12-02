package com.arlosoft.macrodroid.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.settings.Settings;

/* loaded from: classes3.dex */
public class AddSelectableItemInfoCard {

    /* loaded from: classes3.dex */
    public interface InfoCardDismissedListener {
        void onDismissed();
    }

    /* loaded from: classes3.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.infoCardView)
        public View cardView;
        @BindView(R.id.infoCardDetail)
        public TextView detail;
        @BindView(R.id.infoCardGotIt)
        public Button gotIt;
        @BindView(R.id.info_card)
        public ViewGroup infoCard;
        @BindView(R.id.infoCardTitle)
        public TextView title;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* loaded from: classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {

        /* renamed from: a  reason: collision with root package name */
        private ViewHolder f16460a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f16460a = viewHolder;
            viewHolder.cardView = Utils.findRequiredView(view, R.id.infoCardView, "field 'cardView'");
            viewHolder.infoCard = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.info_card, "field 'infoCard'", ViewGroup.class);
            viewHolder.title = (TextView) Utils.findRequiredViewAsType(view, R.id.infoCardTitle, "field 'title'", TextView.class);
            viewHolder.detail = (TextView) Utils.findRequiredViewAsType(view, R.id.infoCardDetail, "field 'detail'", TextView.class);
            viewHolder.gotIt = (Button) Utils.findRequiredViewAsType(view, R.id.infoCardGotIt, "field 'gotIt'", Button.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.f16460a;
            if (viewHolder != null) {
                this.f16460a = null;
                viewHolder.cardView = null;
                viewHolder.infoCard = null;
                viewHolder.title = null;
                viewHolder.detail = null;
                viewHolder.gotIt = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public static void bindInfoCard(final Context context, ViewHolder viewHolder, int i4, boolean z3, final InfoCardDismissedListener infoCardDismissedListener) {
        int i5;
        viewHolder.infoCard.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        if (i4 != 0) {
            if (i4 != 1) {
                viewHolder.title.setText(R.string.constraints);
                viewHolder.detail.setText(R.string.info_card_constraints_description);
                ViewGroup viewGroup = viewHolder.infoCard;
                if (z3) {
                    i5 = R.color.condition_primary;
                } else {
                    i5 = R.color.constraints_primary;
                }
                viewGroup.setBackgroundColor(ContextCompat.getColor(context, i5));
                viewHolder.gotIt.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.widget.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AddSelectableItemInfoCard.f(context, infoCardDismissedListener, view);
                    }
                });
                return;
            }
            viewHolder.title.setText(R.string.actions);
            viewHolder.detail.setText(R.string.info_card_actions_description);
            viewHolder.infoCard.setBackgroundColor(ContextCompat.getColor(context, R.color.actions_primary));
            viewHolder.gotIt.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.widget.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddSelectableItemInfoCard.e(context, infoCardDismissedListener, view);
                }
            });
            return;
        }
        viewHolder.title.setText(R.string.triggers);
        viewHolder.detail.setText(R.string.info_card_triggers_description);
        viewHolder.infoCard.setBackgroundColor(ContextCompat.getColor(context, R.color.trigger_primary));
        viewHolder.gotIt.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddSelectableItemInfoCard.d(context, infoCardDismissedListener, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(Context context, InfoCardDismissedListener infoCardDismissedListener, View view) {
        Settings.hideInfoCardTrigger(context);
        if (infoCardDismissedListener != null) {
            infoCardDismissedListener.onDismissed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(Context context, InfoCardDismissedListener infoCardDismissedListener, View view) {
        Settings.hideInfoCardAction(context);
        if (infoCardDismissedListener != null) {
            infoCardDismissedListener.onDismissed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(Context context, InfoCardDismissedListener infoCardDismissedListener, View view) {
        Settings.hideInfoCardConstraint(context);
        if (infoCardDismissedListener != null) {
            infoCardDismissedListener.onDismissed();
        }
    }

    public static boolean shouldHideInfoCard(Context context, int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    return true;
                }
                return Settings.shouldHideInfoCardConstraint(context);
            }
            return Settings.shouldHideInfoCardAction(context);
        }
        return Settings.shouldHideInfoCardTrigger(context);
    }
}
