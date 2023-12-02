package com.arlosoft.macrodroid.macrolist;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.IfConditionAction;
import com.arlosoft.macrodroid.action.LoopAction;
import com.arlosoft.macrodroid.categories.Category;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.macrolist.MacroListItem;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.utils.ColorUtils;
import com.arlosoft.macrodroid.utils.MacroListUtils;
import com.arlosoft.macrodroid.widget.AnimatorListenerImpl;
import com.arlosoft.macrodroid.widget.SwitchPlus;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.material.card.MaterialCardView;
import com.varunest.sparkbutton.SparkButton2;
import com.varunest.sparkbutton.SparkEventListener;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractSectionableItem;
import eu.davidea.flexibleadapter.items.IFilterable;
import eu.davidea.viewholders.FlexibleViewHolder;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class MacroListItem extends AbstractSectionableItem<FullMacroViewHolder, MacroListCategoryHeader> implements IFilterable<String> {

    /* renamed from: g  reason: collision with root package name */
    private final Macro f12954g;

    /* renamed from: h  reason: collision with root package name */
    private final View.OnLongClickListener f12955h;

    /* renamed from: i  reason: collision with root package name */
    private final View.OnClickListener f12956i;

    /* renamed from: j  reason: collision with root package name */
    private final FavouriteRemovedListener f12957j;

    /* renamed from: k  reason: collision with root package name */
    private final Category f12958k;

    /* renamed from: l  reason: collision with root package name */
    private final int f12959l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f12960m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f12961n;

    /* renamed from: o  reason: collision with root package name */
    private long f12962o;

    /* renamed from: p  reason: collision with root package name */
    private long f12963p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f12964q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f12965r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f12966s;

    /* renamed from: t  reason: collision with root package name */
    private FlexibleViewHolder f12967t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f12968u;

    /* renamed from: v  reason: collision with root package name */
    private HeadingColorMapper f12969v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f12970w;

    /* renamed from: x  reason: collision with root package name */
    private Set<String> f12971x;

    /* loaded from: classes3.dex */
    public interface FavouriteRemovedListener {
        void favouriteRemoved(MacroListItem macroListItem);
    }

    /* loaded from: classes3.dex */
    public class FilterViewHolder extends FlexibleViewHolder {
        @BindView(R.id.filterEnabledCheckbox)
        CheckBox filterEnabledCheckbox;
        @BindView(R.id.macroName)
        TextView macroName;

        public FilterViewHolder(@NonNull View view, @NonNull FlexibleAdapter flexibleAdapter) {
            super(view, flexibleAdapter);
            ButterKnife.bind(this, view);
        }

        public void bind(@NonNull MacroListItem macroListItem, @Nullable OnFilterChangeListener onFilterChangeListener) {
            this.macroName.setText(macroListItem.f12954g.getName());
        }
    }

    /* loaded from: classes3.dex */
    public class FilterViewHolder_ViewBinding implements Unbinder {

        /* renamed from: a  reason: collision with root package name */
        private FilterViewHolder f12973a;

        @UiThread
        public FilterViewHolder_ViewBinding(FilterViewHolder filterViewHolder, View view) {
            this.f12973a = filterViewHolder;
            filterViewHolder.macroName = (TextView) Utils.findRequiredViewAsType(view, R.id.macroName, "field 'macroName'", TextView.class);
            filterViewHolder.filterEnabledCheckbox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.filterEnabledCheckbox, "field 'filterEnabledCheckbox'", CheckBox.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            FilterViewHolder filterViewHolder = this.f12973a;
            if (filterViewHolder != null) {
                this.f12973a = null;
                filterViewHolder.macroName = null;
                filterViewHolder.filterEnabledCheckbox = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes3.dex */
    public class FullMacroViewHolder_ViewBinding implements Unbinder {

        /* renamed from: a  reason: collision with root package name */
        private FullMacroViewHolder f12984a;

        @UiThread
        public FullMacroViewHolder_ViewBinding(FullMacroViewHolder fullMacroViewHolder, View view) {
            this.f12984a = fullMacroViewHolder;
            fullMacroViewHolder.titleBar = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.macro_title_bar, "field 'titleBar'", ViewGroup.class);
            fullMacroViewHolder.macroName = (TextView) Utils.findRequiredViewAsType(view, R.id.macroNameText, "field 'macroName'", TextView.class);
            fullMacroViewHolder.starIcon = (SparkButton2) Utils.findRequiredViewAsType(view, R.id.starIcon, "field 'starIcon'", SparkButton2.class);
            fullMacroViewHolder.lastInvokedTime = (TextView) Utils.findRequiredViewAsType(view, R.id.lastInvokedTime, "field 'lastInvokedTime'", TextView.class);
            fullMacroViewHolder.lastEditedTime = (TextView) Utils.findRequiredViewAsType(view, R.id.lastEditedTime, "field 'lastEditedTime'", TextView.class);
            fullMacroViewHolder.triggerLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.macroTrigger, "field 'triggerLabel'", TextView.class);
            fullMacroViewHolder.actionsLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.macroActions, "field 'actionsLabel'", TextView.class);
            fullMacroViewHolder.onOffSwitch = (SwitchPlus) Utils.findRequiredViewAsType(view, R.id.enabledSwitch, "field 'onOffSwitch'", SwitchPlus.class);
            fullMacroViewHolder.constraintsLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.macroConstraints, "field 'constraintsLabel'", TextView.class);
            fullMacroViewHolder.description = (TextView) Utils.findRequiredViewAsType(view, R.id.description, "field 'description'", TextView.class);
            fullMacroViewHolder.blocker = Utils.findRequiredView(view, R.id.blocker, "field 'blocker'");
            fullMacroViewHolder.cardView = (MaterialCardView) Utils.findRequiredViewAsType(view, R.id.macroCardView, "field 'cardView'", MaterialCardView.class);
            fullMacroViewHolder.topContainer = Utils.findRequiredView(view, R.id.topContainer, "field 'topContainer'");
            fullMacroViewHolder.cardInfoContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.card_info_container, "field 'cardInfoContainer'", ViewGroup.class);
            fullMacroViewHolder.dividerLine = Utils.findRequiredView(view, R.id.divider_line, "field 'dividerLine'");
            Resources resources = view.getContext().getResources();
            fullMacroViewHolder.marginTiny = resources.getDimensionPixelSize(R.dimen.margin_tiny);
            fullMacroViewHolder.marginSmallMedium = resources.getDimensionPixelSize(R.dimen.margin_small_medium);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            FullMacroViewHolder fullMacroViewHolder = this.f12984a;
            if (fullMacroViewHolder != null) {
                this.f12984a = null;
                fullMacroViewHolder.titleBar = null;
                fullMacroViewHolder.macroName = null;
                fullMacroViewHolder.starIcon = null;
                fullMacroViewHolder.lastInvokedTime = null;
                fullMacroViewHolder.lastEditedTime = null;
                fullMacroViewHolder.triggerLabel = null;
                fullMacroViewHolder.actionsLabel = null;
                fullMacroViewHolder.onOffSwitch = null;
                fullMacroViewHolder.constraintsLabel = null;
                fullMacroViewHolder.description = null;
                fullMacroViewHolder.blocker = null;
                fullMacroViewHolder.cardView = null;
                fullMacroViewHolder.topContainer = null;
                fullMacroViewHolder.cardInfoContainer = null;
                fullMacroViewHolder.dividerLine = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes3.dex */
    public interface OnFilterChangeListener {
        void filterStateChanged(Long l4, boolean z3);
    }

    public MacroListItem(@NonNull MacroListCategoryHeader macroListCategoryHeader, int i4, @NonNull Macro macro, @NonNull Category category, long j4, boolean z3, long j5, boolean z4, boolean z5, boolean z6, @Nullable View.OnClickListener onClickListener, @Nullable View.OnLongClickListener onLongClickListener, @Nullable FavouriteRemovedListener favouriteRemovedListener, boolean z7, HeadingColorMapper headingColorMapper, boolean z8, Set<String> set) {
        super(macroListCategoryHeader);
        this.f12954g = macro;
        this.f12955h = onLongClickListener;
        this.f12956i = onClickListener;
        this.f12957j = favouriteRemovedListener;
        this.f12958k = category;
        this.f12959l = i4;
        this.f12960m = z3;
        this.f12962o = j4;
        this.f12963p = j5;
        this.f12964q = z4;
        this.f12968u = z6;
        this.f12961n = z5;
        this.f12966s = z7;
        this.f12969v = headingColorMapper;
        this.f12970w = z8;
        this.f12971x = set;
    }

    private String b(String str) {
        if (str == null) {
            return null;
        }
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "").toLowerCase();
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem
    public boolean equals(Object obj) {
        if (!(obj instanceof MacroListItem) || this.f12959l != ((MacroListItem) obj).id()) {
            return false;
        }
        return true;
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public int getLayoutRes() {
        return R.layout.macro_list_row;
    }

    public Macro getMacro() {
        return this.f12954g;
    }

    public int hashCode() {
        return this.f12959l;
    }

    @NonNull
    public int id() {
        return this.f12959l;
    }

    public void setDisabledCategory(boolean z3) {
        this.f12965r = z3;
        FlexibleViewHolder flexibleViewHolder = this.f12967t;
        if (flexibleViewHolder != null && (flexibleViewHolder instanceof FullMacroViewHolder)) {
            ((FullMacroViewHolder) flexibleViewHolder).i(z3);
        }
    }

    public void setLastInvokedTime(long j4) {
        this.f12962o = j4;
    }

    public void unbind() {
        this.f12967t = null;
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public void bindViewHolder(FlexibleAdapter flexibleAdapter, FullMacroViewHolder fullMacroViewHolder, int i4, List list) {
        fullMacroViewHolder.bind(this, this.f12954g, this.f12958k, this.f12962o, this.f12960m, this.f12963p, this.f12964q, this.f12961n, this.f12966s, this.f12965r, this.f12968u, this.f12970w, this.f12956i, this.f12955h, this.f12957j);
        this.f12967t = fullMacroViewHolder;
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public FullMacroViewHolder createViewHolder(View view, FlexibleAdapter flexibleAdapter) {
        return new FullMacroViewHolder(view, flexibleAdapter, this.f12969v);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00dc  */
    @Override // eu.davidea.flexibleadapter.items.IFilterable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean filter(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "_"
            boolean r0 = r7.endsWith(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L13
            int r0 = r7.length()
            int r0 = r0 - r1
            java.lang.String r7 = r7.substring(r2, r0)
        L13:
            java.lang.String r7 = r6.b(r7)
            com.arlosoft.macrodroid.macro.Macro r0 = r6.f12954g
            java.lang.String r0 = r0.getName()
            java.lang.String r0 = r6.b(r0)
            com.arlosoft.macrodroid.categories.Category r3 = r6.f12958k
            java.lang.String r3 = r3.getName()
            java.lang.String r3 = r6.b(r3)
            com.arlosoft.macrodroid.macro.Macro r4 = r6.f12954g
            java.lang.String r4 = r4.getDescription()
            java.lang.String r4 = r6.b(r4)
            com.arlosoft.macrodroid.categories.Category r5 = r6.f12958k
            boolean r5 = r5.isLocked()
            if (r5 == 0) goto L48
            java.util.Set<java.lang.String> r5 = r6.f12971x
            boolean r5 = r5.contains(r3)
            if (r5 != 0) goto L48
            r1 = 0
            goto L100
        L48:
            boolean r0 = r0.contains(r7)
            if (r0 != 0) goto L100
            boolean r0 = r3.contains(r7)
            if (r0 != 0) goto L100
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L62
            boolean r0 = r4.contains(r7)
            if (r0 == 0) goto L62
            goto L100
        L62:
            com.arlosoft.macrodroid.macro.Macro r0 = r6.f12954g
            java.util.ArrayList r0 = r0.getTriggerList()
            java.util.Iterator r0 = r0.iterator()
        L6c:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L95
            java.lang.Object r3 = r0.next()
            com.arlosoft.macrodroid.triggers.Trigger r3 = (com.arlosoft.macrodroid.triggers.Trigger) r3
            java.lang.String r4 = r3.getConfiguredName()
            java.lang.String r4 = r6.b(r4)
            java.lang.String r3 = r3.getName()
            java.lang.String r3 = r6.b(r3)
            boolean r4 = r4.contains(r7)
            if (r4 != 0) goto L94
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L6c
        L94:
            r2 = 1
        L95:
            if (r2 != 0) goto Lca
            com.arlosoft.macrodroid.macro.Macro r0 = r6.f12954g
            java.util.ArrayList r0 = r0.getActions()
            java.util.Iterator r0 = r0.iterator()
        La1:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto Lca
            java.lang.Object r3 = r0.next()
            com.arlosoft.macrodroid.action.Action r3 = (com.arlosoft.macrodroid.action.Action) r3
            java.lang.String r4 = r3.getConfiguredName()
            java.lang.String r4 = r6.b(r4)
            java.lang.String r3 = r3.getName()
            java.lang.String r3 = r6.b(r3)
            boolean r4 = r4.contains(r7)
            if (r4 != 0) goto Lc9
            boolean r3 = r3.contains(r7)
            if (r3 == 0) goto La1
        Lc9:
            r2 = 1
        Lca:
            if (r2 != 0) goto Lff
            com.arlosoft.macrodroid.macro.Macro r0 = r6.f12954g
            java.util.List r0 = r0.getConstraints()
            java.util.Iterator r0 = r0.iterator()
        Ld6:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto Lff
            java.lang.Object r3 = r0.next()
            com.arlosoft.macrodroid.constraint.Constraint r3 = (com.arlosoft.macrodroid.constraint.Constraint) r3
            java.lang.String r4 = r3.getConfiguredName()
            java.lang.String r4 = r6.b(r4)
            java.lang.String r3 = r3.getName()
            java.lang.String r3 = r6.b(r3)
            boolean r4 = r4.contains(r7)
            if (r4 != 0) goto L100
            boolean r3 = r3.contains(r7)
            if (r3 == 0) goto Ld6
            goto L100
        Lff:
            r1 = r2
        L100:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.macrolist.MacroListItem.filter(java.lang.String):boolean");
    }

    /* loaded from: classes3.dex */
    public class FullMacroViewHolder extends FlexibleViewHolder {
        @BindView(R.id.macroActions)
        TextView actionsLabel;
        @BindView(R.id.blocker)
        View blocker;
        @BindView(R.id.card_info_container)
        ViewGroup cardInfoContainer;
        @BindView(R.id.macroCardView)
        MaterialCardView cardView;
        @BindView(R.id.macroConstraints)
        TextView constraintsLabel;
        @BindView(R.id.description)
        TextView description;
        @BindView(R.id.divider_line)
        View dividerLine;

        /* renamed from: g  reason: collision with root package name */
        private MacroListItem f12974g;

        /* renamed from: h  reason: collision with root package name */
        private HeadingColorMapper f12975h;
        @BindView(R.id.lastEditedTime)
        TextView lastEditedTime;
        @BindView(R.id.lastInvokedTime)
        TextView lastInvokedTime;
        @BindView(R.id.macroNameText)
        TextView macroName;
        @BindDimen(R.dimen.margin_small_medium)
        int marginSmallMedium;
        @BindDimen(R.dimen.margin_tiny)
        int marginTiny;
        @BindView(R.id.enabledSwitch)
        SwitchPlus onOffSwitch;
        @BindView(R.id.starIcon)
        SparkButton2 starIcon;
        @BindView(R.id.macro_title_bar)
        ViewGroup titleBar;
        @BindView(R.id.topContainer)
        View topContainer;
        @BindView(R.id.macroTrigger)
        TextView triggerLabel;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class b extends AnimatorListenerImpl {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Macro f12981a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f12982b;

            b(Macro macro, boolean z3) {
                this.f12981a = macro;
                this.f12982b = z3;
            }

            @Override // com.arlosoft.macrodroid.widget.AnimatorListenerImpl, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                int i4;
                FullMacroViewHolder.this.blocker.setAlpha(1.0f);
                View view = FullMacroViewHolder.this.blocker;
                if (this.f12981a.isEnabled() && !this.f12982b) {
                    i4 = 8;
                } else {
                    i4 = 0;
                }
                view.setVisibility(i4);
            }
        }

        public FullMacroViewHolder(@NonNull View view, @NonNull FlexibleAdapter flexibleAdapter, HeadingColorMapper headingColorMapper) {
            super(view, flexibleAdapter);
            ButterKnife.bind(this, view);
            this.f12975h = headingColorMapper;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(Macro macro, boolean z3, CompoundButton compoundButton, boolean z4) {
            float f4;
            if (z4) {
                MacroStore.getInstance().enableMacroAndUpdate(macro, true);
            } else {
                MacroStore.getInstance().disableMacroAndUpdate(macro, true);
            }
            this.blocker.setVisibility(0);
            float f5 = 1.0f;
            if (!z4) {
                this.blocker.setAlpha(1.0f);
            } else {
                this.blocker.setAlpha(0.0f);
            }
            View view = this.blocker;
            float[] fArr = new float[2];
            if (z4) {
                f4 = 1.0f;
            } else {
                f4 = 0.0f;
            }
            fArr[0] = f4;
            if (z4) {
                f5 = 0.0f;
            }
            fArr[1] = f5;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", fArr);
            ofFloat.addListener(new b(macro, z3));
            ofFloat.setDuration(300L);
            ofFloat.start();
        }

        private void f(@NonNull Macro macro, @NonNull TextView textView) {
            int endLoopIndex;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            textView.setMaxLines(Settings.getListViewNumLines(getContentView().getContext()));
            ArrayList<Action> actions = macro.getActions();
            if (macro.getActions().size() > 0) {
                int i4 = 0;
                while (i4 < 99) {
                    if (actions.size() > i4) {
                        Action action = actions.get(i4);
                        CharSequence listModeNameCharSequence = action.getListModeNameCharSequence();
                        if (action.isEnabled()) {
                            spannableStringBuilder.append(listModeNameCharSequence);
                        } else {
                            int length = spannableStringBuilder.length();
                            spannableStringBuilder.append(listModeNameCharSequence);
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContentView().getContext(), R.color.disabled_action_color)), length, spannableStringBuilder.length(), 33);
                        }
                        if (!(action instanceof IfConditionAction) ? !(!(action instanceof LoopAction) || (endLoopIndex = MacroListUtils.getEndLoopIndex(actions, i4)) < 0) : (endLoopIndex = MacroListUtils.getEndIfIndex(actions, i4)) >= 0) {
                            i4 = endLoopIndex;
                        }
                        if (i4 < macro.getActions().size() - 1 && i4 < 98) {
                            spannableStringBuilder.append((CharSequence) ", ");
                        }
                    }
                    i4++;
                }
                textView.setText(spannableStringBuilder);
                return;
            }
            textView.setText(R.string.none);
        }

        private void g(@NonNull Macro macro, @NonNull TextView textView) {
            textView.setMaxLines(Settings.getListViewNumLines(getContentView().getContext()));
            if (macro.getConstraints().size() > 0) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                for (int i4 = 0; i4 < 99; i4++) {
                    if (macro.getConstraints().size() > i4) {
                        Constraint constraint = macro.getConstraints().get(i4);
                        CharSequence listModeNameCharSequence = constraint.getListModeNameCharSequence();
                        if (constraint.isEnabled()) {
                            spannableStringBuilder.append(listModeNameCharSequence);
                        } else {
                            int length = spannableStringBuilder.length();
                            spannableStringBuilder.append(listModeNameCharSequence);
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContentView().getContext(), R.color.disabled_action_color)), length, spannableStringBuilder.length(), 33);
                        }
                        if (i4 < macro.getConstraints().size() - 1 && i4 < 98) {
                            spannableStringBuilder.append((CharSequence) ", ");
                        }
                    }
                }
                textView.setText(spannableStringBuilder);
                return;
            }
            textView.setText(R.string.none);
        }

        private void h(@NonNull Macro macro, @NonNull TextView textView) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            textView.setMaxLines(Settings.getListViewNumLines(getContentView().getContext()));
            if (macro.getTriggerList().size() > 0) {
                for (int i4 = 0; i4 < 99; i4++) {
                    if (macro.getTriggerList().size() > i4) {
                        Trigger trigger = macro.getTriggerList().get(i4);
                        CharSequence listModeNameCharSequence = trigger.getListModeNameCharSequence();
                        if (trigger.isEnabled()) {
                            spannableStringBuilder.append(listModeNameCharSequence);
                        } else {
                            int length = spannableStringBuilder.length();
                            spannableStringBuilder.append(listModeNameCharSequence);
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContentView().getContext(), R.color.disabled_trigger_color)), length, spannableStringBuilder.length(), 33);
                        }
                        if (i4 < macro.getTriggerList().size() - 1 && i4 < 98) {
                            spannableStringBuilder.append((CharSequence) ", ");
                        }
                    }
                }
                textView.setText(spannableStringBuilder);
                return;
            }
            textView.setText(R.string.none);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(boolean z3) {
            int i4;
            View view = this.blocker;
            if (MacroListItem.this.f12954g.isEnabled() && !z3) {
                i4 = 8;
            } else {
                i4 = 0;
            }
            view.setVisibility(i4);
            this.onOffSwitch.setEnabled(!z3);
        }

        public void bind(@NonNull MacroListItem macroListItem, @NonNull final Macro macro, @NonNull Category category, long j4, boolean z3, long j5, boolean z4, boolean z5, boolean z6, final boolean z7, boolean z8, boolean z9, @Nullable View.OnClickListener onClickListener, @Nullable View.OnLongClickListener onLongClickListener, @Nullable FavouriteRemovedListener favouriteRemovedListener) {
            MacroListItem macroListItem2 = this.f12974g;
            if (macroListItem2 != null) {
                macroListItem2.unbind();
            }
            this.f12974g = macroListItem;
            this.topContainer.setOnLongClickListener(onLongClickListener);
            this.topContainer.setOnClickListener(onClickListener);
            int headingColor = this.f12975h.getHeadingColor(macro.getHeadingColor());
            this.onOffSwitch.setVisibility(z6 ? 0 : 8);
            ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) this.cardView.getLayoutParams())).bottomMargin = this.cardView.getContext().getResources().getDimensionPixelOffset(z8 ? R.dimen.macro_list_card_margin_large : R.dimen.macro_list_card_margin_small);
            if (!macro.isValid()) {
                this.cardView.setStrokeColor(ContextCompat.getColor(getContentView().getContext(), R.color.macro_error_border));
                this.cardView.setStrokeWidth(getContentView().getContext().getResources().getDimensionPixelOffset(R.dimen.template_error_border_thickness));
            } else {
                this.cardView.setStrokeWidth(0);
            }
            if (headingColor == 0) {
                this.cardView.setCardBackgroundColor(this.f12975h.getHeadingColor(category.getColor()));
                this.onOffSwitch.setOffColor(ColorUtils.darkenOrLightenBasedOnDarkMode(this.itemView.getContext(), category.getColor()));
            } else {
                this.cardView.setCardBackgroundColor(headingColor);
                this.onOffSwitch.setOffColor(ColorUtils.darkenOrLightenBasedOnDarkMode(this.itemView.getContext(), headingColor));
            }
            this.macroName.setTextColor(ContextCompat.getColor(getContentView().getContext(), R.color.text_color_macro_list_name));
            this.lastInvokedTime.setTextColor(ContextCompat.getColor(getContentView().getContext(), R.color.text_color_macro_list_secondary));
            this.lastEditedTime.setTextColor(ContextCompat.getColor(getContentView().getContext(), R.color.text_color_macro_list_secondary));
            this.macroName.setText(macro.getName());
            if (z3) {
                this.lastInvokedTime.setVisibility(0);
                if (j4 == 0) {
                    this.lastInvokedTime.setText(R.string.macro_never_activated);
                } else {
                    TextView textView = this.lastInvokedTime;
                    textView.setText(this.lastInvokedTime.getContext().getString(R.string.last_activated) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + ((Object) DateUtils.getRelativeTimeSpanString(j4)));
                }
            } else {
                this.lastInvokedTime.setVisibility(8);
            }
            if (z4) {
                this.lastEditedTime.setVisibility(0);
                if (j5 == 0) {
                    TextView textView2 = this.lastEditedTime;
                    textView2.setText(String.format(textView2.getContext().getString(R.string.last_edited), this.lastEditedTime.getContext().getString(R.string.last_edited_time_unknown)));
                } else {
                    TextView textView3 = this.lastEditedTime;
                    textView3.setText(String.format(textView3.getContext().getString(R.string.last_edited), DateUtils.getRelativeTimeSpanString(j5)));
                }
            } else {
                this.lastEditedTime.setVisibility(8);
            }
            this.starIcon.setChecked(macro.getIsFavourite());
            ViewExtensionsKt.expandTouchArea(this.starIcon, this.marginSmallMedium);
            this.starIcon.setEventListener(new a(macro, favouriteRemovedListener, macroListItem));
            this.onOffSwitch.setOnCheckedChangeListener(null);
            this.onOffSwitch.setChecked(macro.isEnabled());
            this.onOffSwitch.setEnabled(!z7);
            this.blocker.setVisibility((!z6 || (macro.isEnabled() && !z7)) ? 8 : 0);
            this.onOffSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: d0.l0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    MacroListItem.FullMacroViewHolder.this.e(macro, z7, compoundButton, z10);
                }
            });
            if (z5 && !TextUtils.isEmpty(macro.getDescription())) {
                this.description.setText(macro.getDescription());
                this.description.setVisibility(0);
            } else {
                this.description.setVisibility(8);
            }
            this.cardInfoContainer.setVisibility(z9 ? 0 : 8);
            this.dividerLine.setVisibility(z9 ? 0 : 8);
            if (z9) {
                h(macro, this.triggerLabel);
                f(macro, this.actionsLabel);
                g(macro, this.constraintsLabel);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements SparkEventListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Macro f12977a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ FavouriteRemovedListener f12978b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ MacroListItem f12979c;

            a(Macro macro, FavouriteRemovedListener favouriteRemovedListener, MacroListItem macroListItem) {
                this.f12977a = macro;
                this.f12978b = favouriteRemovedListener;
                this.f12979c = macroListItem;
            }

            @Override // com.varunest.sparkbutton.SparkEventListener
            public void onEvent(ImageView imageView, boolean z3) {
                this.f12977a.setIsFavourite(z3);
                MacroStore.getInstance().updateMacro(this.f12977a);
                if (!z3) {
                    this.f12978b.favouriteRemoved(this.f12979c);
                }
            }

            @Override // com.varunest.sparkbutton.SparkEventListener
            public void onEventAnimationEnd(ImageView imageView, boolean z3) {
                FullMacroViewHolder.this.topContainer.invalidate();
                FullMacroViewHolder.this.topContainer.forceLayout();
            }

            @Override // com.varunest.sparkbutton.SparkEventListener
            public void onEventAnimationStart(ImageView imageView, boolean z3) {
            }
        }
    }
}
