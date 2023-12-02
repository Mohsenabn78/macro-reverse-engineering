package com.arlosoft.macrodroid.quicksettings;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.BuildConfig;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.QuickSettingsTilesUpdatedEvent;
import com.arlosoft.macrodroid.quicksettings.QuickSettingsActivity;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.activities.selecticon.IconSelectActivity;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService1;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService10;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService11;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService12;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService13;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService14;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService15;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService16;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService2;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService3;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService4;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService5;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService6;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService7;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService8;
import com.arlosoft.macrodroid.triggers.services.quicksettings.MacroDroidTileService9;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class QuickSettingsActivity extends MacroDroidBaseActivity {

    /* renamed from: f  reason: collision with root package name */
    private ImageView f13263f;

    /* renamed from: h  reason: collision with root package name */
    private QuickSettingsData f13265h;
    @BindView(R.id.infoCardDetail)
    TextView infoCardDetail;
    @BindView(R.id.infoCardGotIt)
    Button infoCardGotIt;
    @BindView(R.id.infoCardTitle)
    TextView infoCardTitle;
    @BindView(R.id.infoCardView)
    CardView infoCardView;

    /* renamed from: g  reason: collision with root package name */
    private List<QuickSettingsViewHolder> f13264g = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private final boolean[] f13266i = new boolean[16];

    /* renamed from: j  reason: collision with root package name */
    private final Class[] f13267j = {MacroDroidTileService1.class, MacroDroidTileService2.class, MacroDroidTileService3.class, MacroDroidTileService4.class, MacroDroidTileService5.class, MacroDroidTileService6.class, MacroDroidTileService7.class, MacroDroidTileService8.class, MacroDroidTileService9.class, MacroDroidTileService10.class, MacroDroidTileService11.class, MacroDroidTileService12.class, MacroDroidTileService13.class, MacroDroidTileService14.class, MacroDroidTileService15.class, MacroDroidTileService16.class};

    /* renamed from: k  reason: collision with root package name */
    final Cache f13268k = MacroDroidApplication.getInstance().getCache(QuickSettingsData.QUICK_SETTINGS_CACHE);

    /* loaded from: classes3.dex */
    public class QuickSettingsViewHolder_ViewBinding implements Unbinder {

        /* renamed from: a  reason: collision with root package name */
        private QuickSettingsViewHolder f13273a;

        @UiThread
        public QuickSettingsViewHolder_ViewBinding(QuickSettingsViewHolder quickSettingsViewHolder, View view) {
            this.f13273a = quickSettingsViewHolder;
            quickSettingsViewHolder.container = (CardView) Utils.findRequiredViewAsType(view, R.id.container, "field 'container'", CardView.class);
            quickSettingsViewHolder.image = (ImageView) Utils.findRequiredViewAsType(view, R.id.image, "field 'image'", ImageView.class);
            quickSettingsViewHolder.label = (EditText) Utils.findRequiredViewAsType(view, R.id.tile_label, "field 'label'", EditText.class);
            quickSettingsViewHolder.tileSwitch = (SwitchCompat) Utils.findRequiredViewAsType(view, R.id.tile_switch, "field 'tileSwitch'", SwitchCompat.class);
            quickSettingsViewHolder.buttonLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.button_label, "field 'buttonLabel'", TextView.class);
            quickSettingsViewHolder.buttonOption = (RadioButton) Utils.findRequiredViewAsType(view, R.id.button_option, "field 'buttonOption'", RadioButton.class);
            quickSettingsViewHolder.toggleOption = (RadioButton) Utils.findRequiredViewAsType(view, R.id.toggle_option, "field 'toggleOption'", RadioButton.class);
            quickSettingsViewHolder.enabledState = (TextView) Utils.findRequiredViewAsType(view, R.id.enabled_state, "field 'enabledState'", TextView.class);
            quickSettingsViewHolder.collapseOnPress = (CheckBox) Utils.findRequiredViewAsType(view, R.id.collapse_on_press, "field 'collapseOnPress'", CheckBox.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            QuickSettingsViewHolder quickSettingsViewHolder = this.f13273a;
            if (quickSettingsViewHolder != null) {
                this.f13273a = null;
                quickSettingsViewHolder.container = null;
                quickSettingsViewHolder.image = null;
                quickSettingsViewHolder.label = null;
                quickSettingsViewHolder.tileSwitch = null;
                quickSettingsViewHolder.buttonLabel = null;
                quickSettingsViewHolder.buttonOption = null;
                quickSettingsViewHolder.toggleOption = null;
                quickSettingsViewHolder.enabledState = null;
                quickSettingsViewHolder.collapseOnPress = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes3.dex */
    class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f13274a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ QuickSettingsViewHolder f13275b;

        a(int i4, QuickSettingsViewHolder quickSettingsViewHolder) {
            this.f13274a = i4;
            this.f13275b = quickSettingsViewHolder;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            if (z3) {
                QuickSettingsActivity.this.f13266i[this.f13274a] = false;
            }
            this.f13275b.setEnabledState(z3);
        }
    }

    /* loaded from: classes3.dex */
    class b extends OnBackPressedCallback {
        b(boolean z3) {
            super(z3);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            QuickSettingsActivity.this.handleBackPressed();
        }
    }

    private void o() {
        if (Settings.shouldHideInfoCardQuickSettings(this)) {
            this.infoCardView.setVisibility(8);
            return;
        }
        this.infoCardView.setCardBackgroundColor(ContextCompat.getColor(this, R.color.quick_settings_config_primary));
        this.infoCardTitle.setText(R.string.quick_settings_tiles);
        this.infoCardDetail.setText(R.string.quick_settings_tiles_info);
        this.infoCardGotIt.setOnClickListener(new View.OnClickListener() { // from class: i0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuickSettingsActivity.this.p(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(View view) {
        Settings.hideInfoCardQuickSettingsLog(getApplicationContext());
        this.infoCardView.setVisibility(8);
    }

    public void handleBackPressed() {
        List<QuickSettingButton> qSButtonList = this.f13265h.getQSButtonList();
        qSButtonList.clear();
        for (int i4 = 0; i4 < 16; i4++) {
            QuickSettingsViewHolder quickSettingsViewHolder = this.f13264g.get(i4);
            QuickSettingButton create = QuickSettingButton.create(quickSettingsViewHolder.label.getText().toString(), 0, quickSettingsViewHolder.tileSwitch.isChecked(), quickSettingsViewHolder.toggleOption.isChecked(), this.f13266i[i4], quickSettingsViewHolder.collapseOnPress.isChecked(), (String) quickSettingsViewHolder.image.getTag());
            qSButtonList.add(create);
            PackageManager packageManager = getPackageManager();
            ComponentName componentName = new ComponentName(BuildConfig.APPLICATION_ID, this.f13267j[i4].getName());
            if (create.getEnabled()) {
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            } else {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            }
        }
        this.f13268k.put(QuickSettingsData.QUICK_SETTINGS_DATA_KEY, this.f13265h);
        EventBusUtils.getEventBus().post(new QuickSettingsTilesUpdatedEvent(this.f13265h));
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        if (i5 != 0) {
            int intExtra = intent.getIntExtra(Util.DRAWABLE_ID_EXTRA, 0);
            String stringExtra = intent.getStringExtra(Util.DRAWABLE_NAME_EXTRA);
            ImageView imageView = this.f13263f;
            if (imageView != null) {
                imageView.setImageResource(intExtra);
                this.f13263f.setTag(stringExtra);
            }
        }
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_quick_settings);
        ButterKnife.bind(this);
        setTitle(R.string.quick_settings_tiles);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.buttons_container);
        QuickSettingsData quickSettingsData = (QuickSettingsData) this.f13268k.get(QuickSettingsData.QUICK_SETTINGS_DATA_KEY, QuickSettingsData.class);
        if (quickSettingsData == null) {
            this.f13265h = QuickSettingsData.createDefault();
        } else if (quickSettingsData.getQSButtonList() != null && quickSettingsData.getQSButtonList().size() != 0) {
            quickSettingsData.upddateFrom4or8To16IfRequired();
            this.f13265h = quickSettingsData;
        } else {
            this.f13265h = QuickSettingsData.createDefault();
        }
        String[] strArr = {getString(R.string.macrodroid_tile_1), getString(R.string.macrodroid_tile_2), getString(R.string.macrodroid_tile_3), getString(R.string.macrodroid_tile_4), getString(R.string.macrodroid_tile_5), getString(R.string.macrodroid_tile_6), getString(R.string.macrodroid_tile_7), getString(R.string.macrodroid_tile_8), getString(R.string.macrodroid_tile_9), getString(R.string.macrodroid_tile_10), getString(R.string.macrodroid_tile_11), getString(R.string.macrodroid_tile_12), getString(R.string.macrodroid_tile_13), getString(R.string.macrodroid_tile_14), getString(R.string.macrodroid_tile_15), getString(R.string.macrodroid_tile_16)};
        for (int i4 = 0; i4 < 16; i4++) {
            QuickSettingsViewHolder quickSettingsViewHolder = new QuickSettingsViewHolder(this, LayoutInflater.from(this).inflate(R.layout.list_item_quick_settings, (ViewGroup) linearLayout, false));
            linearLayout.addView(quickSettingsViewHolder.container);
            QuickSettingButton quickSettingButton = this.f13265h.getQSButtonList().get(i4);
            quickSettingsViewHolder.bindView(quickSettingButton, strArr[i4], i4);
            this.f13266i[i4] = quickSettingButton.getToggleOn();
            this.f13264g.add(quickSettingsViewHolder);
            quickSettingsViewHolder.tileSwitch.setOnCheckedChangeListener(new a(i4, quickSettingsViewHolder));
        }
        o();
        this.infoCardGotIt.requestFocus();
        getOnBackPressedDispatcher().addCallback(this, new b(true));
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            handleBackPressed();
            return true;
        }
        return true;
    }

    public void setIcon(ImageView imageView) {
        this.f13263f = imageView;
        Intent intent = new Intent(this, IconSelectActivity.class);
        intent.putExtra(IconSelectActivity.EXTRA_DISPLAY_APP_ICONS, false);
        startActivityForResult(intent, 0);
    }

    /* loaded from: classes3.dex */
    public static class QuickSettingsViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        private final Context f13269a;

        /* renamed from: b  reason: collision with root package name */
        private final QuickSettingsActivity f13270b;
        @BindView(R.id.button_label)
        TextView buttonLabel;
        @BindView(R.id.button_option)
        RadioButton buttonOption;
        @BindView(R.id.collapse_on_press)
        CheckBox collapseOnPress;
        @BindView(R.id.container)
        CardView container;
        @BindView(R.id.enabled_state)
        TextView enabledState;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.tile_label)
        EditText label;
        @BindView(R.id.tile_switch)
        SwitchCompat tileSwitch;
        @BindView(R.id.toggle_option)
        RadioButton toggleOption;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements CompoundButton.OnCheckedChangeListener {
            a() {
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                int i4;
                float f4;
                QuickSettingsViewHolder quickSettingsViewHolder = QuickSettingsViewHolder.this;
                TextView textView = quickSettingsViewHolder.enabledState;
                Context context = quickSettingsViewHolder.f13269a;
                if (z3) {
                    i4 = R.string.enabled;
                } else {
                    i4 = R.string.disabled;
                }
                textView.setText(context.getString(i4));
                TextView textView2 = QuickSettingsViewHolder.this.enabledState;
                if (z3) {
                    f4 = 1.0f;
                } else {
                    f4 = 0.5f;
                }
                textView2.setAlpha(f4);
            }
        }

        public QuickSettingsViewHolder(@NonNull QuickSettingsActivity quickSettingsActivity, @NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.f13269a = view.getContext();
            this.f13270b = quickSettingsActivity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(View view) {
            this.f13270b.setIcon(this.image);
        }

        @TargetApi(24)
        public void bindView(@NonNull QuickSettingButton quickSettingButton, @NonNull String str, int i4) {
            Context context;
            int i5;
            float f4;
            this.buttonLabel.setText(str);
            this.label.setText(quickSettingButton.getLabel());
            this.buttonOption.setChecked(!quickSettingButton.isToggle());
            this.toggleOption.setChecked(quickSettingButton.isToggle());
            this.tileSwitch.setChecked(quickSettingButton.getEnabled());
            try {
                this.image.setImageResource(MacroDroidTileService.getImageResourceId(this.f13269a, quickSettingButton));
            } catch (Resources.NotFoundException unused) {
                this.image.setImageResource(R.drawable.active_icon_new);
            }
            this.image.setTag(quickSettingButton.getImageName());
            TextView textView = this.enabledState;
            if (quickSettingButton.getEnabled()) {
                context = this.f13269a;
                i5 = R.string.enabled;
            } else {
                context = this.f13269a;
                i5 = R.string.disabled;
            }
            textView.setText(context.getString(i5));
            TextView textView2 = this.enabledState;
            if (quickSettingButton.getEnabled()) {
                f4 = 1.0f;
            } else {
                f4 = 0.5f;
            }
            textView2.setAlpha(f4);
            this.collapseOnPress.setChecked(quickSettingButton.getCollapseOnPress());
            this.tileSwitch.setOnCheckedChangeListener(new a());
            this.image.setOnClickListener(new View.OnClickListener() { // from class: i0.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QuickSettingsActivity.QuickSettingsViewHolder.this.c(view);
                }
            });
            this.label.addTextChangedListener(new b());
        }

        public void setEnabledState(boolean z3) {
            int i4;
            float f4;
            TextView textView = this.enabledState;
            Context context = this.f13269a;
            if (z3) {
                i4 = R.string.enabled;
            } else {
                i4 = R.string.disabled;
            }
            textView.setText(context.getString(i4));
            TextView textView2 = this.enabledState;
            if (z3) {
                f4 = 1.0f;
            } else {
                f4 = 0.5f;
            }
            textView2.setAlpha(f4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class b implements TextWatcher {
            b() {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            }
        }
    }
}
