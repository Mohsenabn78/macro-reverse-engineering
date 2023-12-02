package com.takisoft.preferencex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.SwitchCompat;
import androidx.preference.PreferenceDataStore;
import androidx.preference.PreferenceScreen;

/* loaded from: classes6.dex */
public abstract class PreferenceFragmentCompatMasterSwitch extends PreferenceFragmentCompat {

    /* renamed from: d  reason: collision with root package name */
    private MasterSwitch f37970d = g();

    /* loaded from: classes6.dex */
    public class MasterSwitch {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f37971a;

        /* renamed from: b  reason: collision with root package name */
        private View f37972b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f37973c;

        /* renamed from: d  reason: collision with root package name */
        private SwitchCompat f37974d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private PreferenceDataStore f37975e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f37976f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f37977g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private OnMasterSwitchChangeListener f37978h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MasterSwitch.this.n(view);
            }
        }

        private boolean f(boolean z3) {
            OnMasterSwitchChangeListener onMasterSwitchChangeListener = this.f37978h;
            if (onMasterSwitchChangeListener != null && !onMasterSwitchChangeListener.onMasterSwitchChange(z3)) {
                return false;
            }
            return true;
        }

        private String g() {
            return PreferenceFragmentCompatMasterSwitch.this.getPreferenceScreen().getKey();
        }

        private boolean h(boolean z3) {
            if (!s()) {
                return z3;
            }
            PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
            if (preferenceDataStore != null) {
                return preferenceDataStore.getBoolean(g(), z3);
            }
            return PreferenceFragmentCompatMasterSwitch.this.getPreferenceManager().getSharedPreferences().getBoolean(g(), z3);
        }

        private void i() {
            t();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            if (viewGroup.findViewById(R.id.pref_master_switch_view) != null) {
                return;
            }
            TypedValue typedValue = new TypedValue();
            PreferenceFragmentCompatMasterSwitch.this.requireContext().getTheme().resolveAttribute(R.attr.pref_masterSwitchStyle, typedValue, true);
            Context requireContext = PreferenceFragmentCompatMasterSwitch.this.requireContext();
            int i4 = typedValue.resourceId;
            if (i4 == 0) {
                i4 = R.style.PreferenceMasterSwitch;
            }
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(requireContext, i4);
            View inflate = layoutInflater.cloneInContext(contextThemeWrapper).inflate(R.layout.preference_list_master_switch, viewGroup, false);
            this.f37972b = inflate;
            this.f37973c = (TextView) inflate.findViewById(16908310);
            this.f37974d = (SwitchCompat) this.f37972b.findViewById(R.id.switchWidget);
            q(contextThemeWrapper);
            this.f37972b.setOnClickListener(new a());
            viewGroup.addView(this.f37972b, 0, new ViewGroup.LayoutParams(-1, -2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l() {
            this.f37972b = null;
            this.f37973c = null;
            this.f37974d = null;
            this.f37976f = false;
        }

        private void m() {
            j();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(View view) {
            m();
            t();
        }

        private boolean o(boolean z3) {
            if (!s()) {
                return false;
            }
            if (z3 == h(!z3)) {
                return true;
            }
            PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
            if (preferenceDataStore != null) {
                preferenceDataStore.putBoolean(g(), z3);
            } else {
                SharedPreferences.Editor edit = PreferenceFragmentCompatMasterSwitch.this.getPreferenceManager().getSharedPreferences().edit();
                edit.putBoolean(g(), z3);
                edit.apply();
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p() {
            PreferenceScreen preferenceScreen = PreferenceFragmentCompatMasterSwitch.this.getPreferenceScreen();
            if (preferenceScreen == null) {
                return;
            }
            boolean h4 = h(false);
            if (h4 != this.f37977g || !this.f37976f) {
                this.f37976f = true;
                this.f37977g = h4;
                TextView textView = this.f37973c;
                if (textView != null) {
                    textView.setText(preferenceScreen.getTitle());
                }
                PreferenceFragmentCompatMasterSwitch.this.getPreferenceScreen().notifyDependencyChange(r());
            }
            t();
        }

        private void q(@NonNull Context context) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.f37971a);
            int color = obtainStyledAttributes.getColor(obtainStyledAttributes.getIndex(0), 0);
            int color2 = obtainStyledAttributes.getColor(obtainStyledAttributes.getIndex(1), 0);
            obtainStyledAttributes.recycle();
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842913}, new ColorDrawable(color));
            stateListDrawable.addState(new int[0], new ColorDrawable(color2));
            this.f37972b.setBackgroundDrawable(stateListDrawable);
        }

        private boolean r() {
            if ((!this.f37977g) || PreferenceFragmentCompatMasterSwitch.this.getPreferenceScreen().shouldDisableDependents()) {
                return true;
            }
            return false;
        }

        private boolean s() {
            if (PreferenceFragmentCompatMasterSwitch.this.getPreferenceManager() != null && PreferenceFragmentCompatMasterSwitch.this.getPreferenceScreen().isPersistent() && PreferenceFragmentCompatMasterSwitch.this.getPreferenceScreen().hasKey()) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t() {
            int i4;
            if (this.f37972b != null && PreferenceFragmentCompatMasterSwitch.this.getPreferenceScreen() != null) {
                View findViewById = this.f37972b.findViewById(androidx.preference.R.id.icon_frame);
                if (PreferenceFragmentCompatMasterSwitch.this.getPreferenceScreen().isIconSpaceReserved()) {
                    i4 = 0;
                } else {
                    i4 = 8;
                }
                findViewById.setVisibility(i4);
            }
            TextView textView = this.f37973c;
            if (textView != null) {
                textView.setText(getTitle());
                this.f37973c.setSingleLine(isSingleLineTitle());
            }
            View view = this.f37972b;
            if (view != null) {
                ((ImageView) view.findViewById(16908294)).setImageDrawable(getIcon());
            }
            View view2 = this.f37972b;
            if (view2 != null && this.f37974d != null) {
                view2.setSelected(this.f37977g);
                this.f37974d.setChecked(this.f37977g);
            }
        }

        @Nullable
        public Drawable getIcon() {
            if (PreferenceFragmentCompatMasterSwitch.this.getPreferenceScreen() != null) {
                return PreferenceFragmentCompatMasterSwitch.this.getPreferenceScreen().getIcon();
            }
            return null;
        }

        public OnMasterSwitchChangeListener getOnPreferenceChangeListener() {
            return this.f37978h;
        }

        @Nullable
        public PreferenceDataStore getPreferenceDataStore() {
            return this.f37975e;
        }

        @Nullable
        public CharSequence getTitle() {
            if (PreferenceFragmentCompatMasterSwitch.this.getPreferenceScreen() != null) {
                return PreferenceFragmentCompatMasterSwitch.this.getPreferenceScreen().getTitle();
            }
            return null;
        }

        public boolean isChecked() {
            return this.f37977g;
        }

        public boolean isSingleLineTitle() {
            if (PreferenceFragmentCompatMasterSwitch.this.getPreferenceScreen() != null && PreferenceFragmentCompatMasterSwitch.this.getPreferenceScreen().isSingleLineTitle()) {
                return true;
            }
            return false;
        }

        protected void j() {
            boolean z3 = !isChecked();
            if (f(z3)) {
                setChecked(z3);
            }
        }

        public void setChecked(boolean z3) {
            boolean z4;
            if (this.f37977g != z3) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                this.f37977g = z3;
                o(z3);
                PreferenceFragmentCompatMasterSwitch.this.getPreferenceScreen().notifyDependencyChange(r());
                i();
            }
        }

        public void setOnPreferenceChangeListener(OnMasterSwitchChangeListener onMasterSwitchChangeListener) {
            this.f37978h = onMasterSwitchChangeListener;
        }

        public void setPreferenceDataStore(@Nullable PreferenceDataStore preferenceDataStore) {
            this.f37975e = preferenceDataStore;
        }

        private MasterSwitch() {
            this.f37971a = new int[]{R.attr.pref_masterSwitchBackgroundOn, R.attr.pref_masterSwitchBackgroundOff};
        }
    }

    /* loaded from: classes6.dex */
    public interface OnMasterSwitchChangeListener {
        boolean onMasterSwitchChange(boolean z3);
    }

    protected MasterSwitch g() {
        return new MasterSwitch();
    }

    public MasterSwitch getMasterSwitch() {
        return this.f37970d;
    }

    @Override // com.takisoft.preferencex.PreferenceFragmentCompat, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (onCreateView instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) onCreateView;
            MasterSwitch masterSwitch = this.f37970d;
            if (masterSwitch != null) {
                masterSwitch.k(layoutInflater, viewGroup2);
                this.f37970d.p();
            }
            return onCreateView;
        }
        throw new IllegalArgumentException("The root element must be an instance of ViewGroup");
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MasterSwitch masterSwitch = this.f37970d;
        if (masterSwitch != null) {
            masterSwitch.l();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        MasterSwitch masterSwitch = this.f37970d;
        if (masterSwitch != null) {
            masterSwitch.t();
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void setPreferenceScreen(PreferenceScreen preferenceScreen) {
        super.setPreferenceScreen(preferenceScreen);
        MasterSwitch masterSwitch = this.f37970d;
        if (masterSwitch != null) {
            masterSwitch.p();
        }
    }
}
