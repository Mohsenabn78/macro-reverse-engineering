package com.arlosoft.macrodroid.settings.drawer;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.CheckBoxPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.drawer.DrawerOverlayHandleService;
import com.arlosoft.macrodroid.drawer.model.DrawerConfiguration;
import com.arlosoft.macrodroid.events.DrawerHandleUpdateEvent;
import com.arlosoft.macrodroid.events.DrawerRefreshEvent;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.settings.InfoCardPreference;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.settings.drawer.DrawerPreferencesFragment;
import com.thebluealliance.spectrum.SpectrumDialog;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DrawerPreferencesFragment.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class DrawerPreferencesFragment extends PreferenceFragmentCompat {
    public static final int $stable = 0;

    private final void m() {
        final CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference(Settings.PREFERENCE_DRAWER_ENABLED);
        if (checkBoxPreference != null) {
            checkBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: k0.a
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean n4;
                    n4 = DrawerPreferencesFragment.n(DrawerPreferencesFragment.this, checkBoxPreference, preference, obj);
                    return n4;
                }
            });
        }
        final InfoCardPreference infoCardPreference = (InfoCardPreference) findPreference("preferences:drawer_info_card");
        if (infoCardPreference != null) {
            if (Settings.shouldHideInfoCardDrawer(getActivity())) {
                infoCardPreference.setVisible(false);
            } else {
                String string = getString(R.string.action_macrodroid_drawer);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.action_macrodroid_drawer)");
                String string2 = getString(R.string.drawer_info_card);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.drawer_info_card)");
                infoCardPreference.configureInfoCard(string, string2, new View.OnClickListener() { // from class: k0.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DrawerPreferencesFragment.o(DrawerPreferencesFragment.this, infoCardPreference, view);
                    }
                });
            }
        }
        Preference findPreference = findPreference("preferences:drawer_swipe_area");
        if (findPreference != null) {
            findPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: k0.d
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean p4;
                    p4 = DrawerPreferencesFragment.p(DrawerPreferencesFragment.this, preference);
                    return p4;
                }
            });
        }
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) findPreference("preferences:drawer_show_on_lock_screen");
        if (checkBoxPreference2 != null) {
            checkBoxPreference2.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: k0.e
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    boolean q4;
                    q4 = DrawerPreferencesFragment.q(DrawerPreferencesFragment.this, preference, obj);
                    return q4;
                }
            });
            if (Build.VERSION.SDK_INT >= 26) {
                checkBoxPreference2.setVisible(false);
            }
        }
        Preference findPreference2 = findPreference("preferences:drawer_background_color");
        if (findPreference2 != null) {
            final DrawerConfiguration drawerConfiguration = Settings.getDrawerConfiguration(getActivity());
            findPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: k0.f
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean r4;
                    r4 = DrawerPreferencesFragment.r(DrawerPreferencesFragment.this, drawerConfiguration, preference);
                    return r4;
                }
            });
        }
        Preference findPreference3 = findPreference("preferences:drawer_header_color");
        if (findPreference3 != null) {
            final DrawerConfiguration drawerConfiguration2 = Settings.getDrawerConfiguration(getActivity());
            findPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: k0.g
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    boolean t3;
                    t3 = DrawerPreferencesFragment.t(DrawerPreferencesFragment.this, drawerConfiguration2, preference);
                    return t3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(DrawerPreferencesFragment this$0, CheckBoxPreference checkBoxPreference, Preference preference, Object newValue) {
        boolean canDrawOverlays;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        if (Intrinsics.areEqual(newValue.toString(), "true")) {
            if (Build.VERSION.SDK_INT >= 23) {
                canDrawOverlays = android.provider.Settings.canDrawOverlays(this$0.getActivity());
                if (!canDrawOverlays) {
                    PermissionsHelper.showCanDrawOverlaysRequiredDialog(this$0.getActivity(), false, false);
                    checkBoxPreference.setChecked(false);
                    return false;
                }
            }
            if (Settings.getMacroDroidEnabled(this$0.getContext())) {
                this$0.requireContext().stopService(new Intent(this$0.getContext(), DrawerOverlayHandleService.class));
                this$0.requireContext().startService(new Intent(this$0.getContext(), DrawerOverlayHandleService.class));
                return true;
            }
            ToastCompat.makeText(this$0.requireContext().getApplicationContext(), (int) R.string.macrodroid_disabled, 0).show();
            return true;
        }
        this$0.requireContext().stopService(new Intent(this$0.getContext(), DrawerOverlayHandleService.class));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(DrawerPreferencesFragment this$0, InfoCardPreference infoCardPreference, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Settings.hideInfoCardDrawer(this$0.getActivity());
        infoCardPreference.setVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(DrawerPreferencesFragment this$0, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(DrawerPreferencesFragment this$0, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Settings.isDrawerEnabled(this$0.getActivity())) {
            this$0.requireContext().stopService(new Intent(this$0.getContext(), DrawerOverlayHandleService.class));
            this$0.requireContext().startService(new Intent(this$0.getContext(), DrawerOverlayHandleService.class));
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(final DrawerPreferencesFragment this$0, DrawerConfiguration drawerConfiguration, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SpectrumDialog build = new SpectrumDialog.Builder(this$0.getContext()).setTitle(R.string.select_color).setColors(R.array.drawer_bg_colors).setSelectedColor(drawerConfiguration.backgroundColor).setDismissOnColorSelected(true).setOutlineWidth(1).setOnColorSelectedListener(new SpectrumDialog.OnColorSelectedListener() { // from class: k0.h
            @Override // com.thebluealliance.spectrum.SpectrumDialog.OnColorSelectedListener
            public final void onColorSelected(boolean z3, int i4) {
                DrawerPreferencesFragment.s(DrawerPreferencesFragment.this, z3, i4);
            }
        }).build();
        FragmentActivity activity = this$0.getActivity();
        Intrinsics.checkNotNull(activity);
        build.show(activity.getSupportFragmentManager(), "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(DrawerPreferencesFragment this$0, boolean z3, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DrawerConfiguration drawerConfiguration = Settings.getDrawerConfiguration(this$0.getActivity());
        if (z3) {
            drawerConfiguration.backgroundColor = i4;
            Settings.setDrawerConfiguration(this$0.getActivity(), drawerConfiguration);
            EventBusUtils.getEventBus().post(new DrawerRefreshEvent(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean t(final DrawerPreferencesFragment this$0, DrawerConfiguration drawerConfiguration, Preference preference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SpectrumDialog build = new SpectrumDialog.Builder(this$0.getContext()).setTitle(R.string.select_color).setColors(R.array.drawer_bg_colors).setSelectedColor(drawerConfiguration.headerColor).setDismissOnColorSelected(true).setOutlineWidth(1).setOnColorSelectedListener(new SpectrumDialog.OnColorSelectedListener() { // from class: k0.k
            @Override // com.thebluealliance.spectrum.SpectrumDialog.OnColorSelectedListener
            public final void onColorSelected(boolean z3, int i4) {
                DrawerPreferencesFragment.u(DrawerPreferencesFragment.this, z3, i4);
            }
        }).build();
        FragmentActivity activity = this$0.getActivity();
        Intrinsics.checkNotNull(activity);
        build.show(activity.getSupportFragmentManager(), "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(DrawerPreferencesFragment this$0, boolean z3, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DrawerConfiguration drawerConfiguration = Settings.getDrawerConfiguration(this$0.getActivity());
        if (z3) {
            drawerConfiguration.headerColor = i4;
            Settings.setDrawerConfiguration(this$0.getActivity(), drawerConfiguration);
            EventBusUtils.getEventBus().post(new DrawerRefreshEvent(0));
        }
    }

    private final void v() {
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.drawer_swipe_area);
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_drawer_swipe_area, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        final DrawerConfiguration drawerConfiguration = Settings.getDrawerConfiguration(getActivity());
        RadioButton radioButton = (RadioButton) viewGroup.findViewById(R.id.left);
        final ImageView imageView = (ImageView) viewGroup.findViewById(R.id.color_image);
        final SeekBar seekBar = (SeekBar) viewGroup.findViewById(R.id.seek_bar_width);
        final SeekBar seekBar2 = (SeekBar) viewGroup.findViewById(R.id.seek_bar_visible_width);
        final SeekBar seekBar3 = (SeekBar) viewGroup.findViewById(R.id.seek_bar_opacity);
        final SeekBar seekBar4 = (SeekBar) viewGroup.findViewById(R.id.seek_bar_height);
        final SeekBar seekBar5 = (SeekBar) viewGroup.findViewById(R.id.seek_bar_offset);
        seekBar.setProgress(drawerConfiguration.swipeAreaWidth - 2);
        seekBar2.setProgress(drawerConfiguration.getVisibleWidth() - 2);
        seekBar3.setProgress(drawerConfiguration.swipeAreaOpacity);
        seekBar4.setProgress(drawerConfiguration.swipeAreaHeight);
        seekBar5.setProgress(drawerConfiguration.swipeAreaOffset);
        Drawable background = imageView.getBackground();
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) background).setColor(drawerConfiguration.swipeAreaColor);
        radioButton.setChecked(drawerConfiguration.leftSide);
        ((RadioButton) viewGroup.findViewById(R.id.right)).setChecked(!drawerConfiguration.leftSide);
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: k0.i
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                DrawerPreferencesFragment.y(DrawerConfiguration.this, this, compoundButton, z3);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: k0.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DrawerPreferencesFragment.w(DrawerPreferencesFragment.this, drawerConfiguration, imageView, view);
            }
        });
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.arlosoft.macrodroid.settings.drawer.DrawerPreferencesFragment$showDrawerSwipeAreaDialog$seekBarListener$1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(@NotNull SeekBar seekBar6, int i4, boolean z3) {
                Intrinsics.checkNotNullParameter(seekBar6, "seekBar");
                if (seekBar6 == seekBar && seekBar2.getProgress() > i4) {
                    seekBar2.setProgress(i4);
                    drawerConfiguration.visibleSwipeAreaWidth = seekBar2.getProgress() + 2;
                }
                drawerConfiguration.swipeAreaWidth = seekBar.getProgress() + 2;
                drawerConfiguration.swipeAreaOpacity = seekBar3.getProgress();
                drawerConfiguration.swipeAreaHeight = seekBar4.getProgress();
                drawerConfiguration.swipeAreaOffset = seekBar5.getProgress();
                Settings.setDrawerConfiguration(this.getActivity(), drawerConfiguration);
                EventBusUtils.getEventBus().post(new DrawerHandleUpdateEvent(drawerConfiguration));
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(@NotNull SeekBar seekBar6) {
                Intrinsics.checkNotNullParameter(seekBar6, "seekBar");
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(@NotNull SeekBar seekBar6) {
                Intrinsics.checkNotNullParameter(seekBar6, "seekBar");
            }
        };
        seekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);
        seekBar3.setOnSeekBarChangeListener(onSeekBarChangeListener);
        seekBar4.setOnSeekBarChangeListener(onSeekBarChangeListener);
        seekBar5.setOnSeekBarChangeListener(onSeekBarChangeListener);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.arlosoft.macrodroid.settings.drawer.DrawerPreferencesFragment$showDrawerSwipeAreaDialog$3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(@NotNull SeekBar seekBar6, int i4, boolean z3) {
                Intrinsics.checkNotNullParameter(seekBar6, "seekBar");
                if (seekBar.getProgress() < i4) {
                    seekBar.setProgress(i4);
                    drawerConfiguration.swipeAreaWidth = seekBar.getProgress() + 2;
                }
                drawerConfiguration.visibleSwipeAreaWidth = seekBar2.getProgress() + 2;
                Settings.setDrawerConfiguration(this.getActivity(), drawerConfiguration);
                EventBusUtils.getEventBus().post(new DrawerHandleUpdateEvent(drawerConfiguration));
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(@NotNull SeekBar seekBar6) {
                Intrinsics.checkNotNullParameter(seekBar6, "seekBar");
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(@NotNull SeekBar seekBar6) {
                Intrinsics.checkNotNullParameter(seekBar6, "seekBar");
            }
        });
        builder.setView(viewGroup);
        builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(final DrawerPreferencesFragment this$0, final DrawerConfiguration drawerConfiguration, final ImageView imageView, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SpectrumDialog build = new SpectrumDialog.Builder(this$0.getContext()).setTitle(R.string.select_color).setColors(R.array.notification_colors).setSelectedColor(drawerConfiguration.swipeAreaColor).setDismissOnColorSelected(true).setOutlineWidth(1).setOnColorSelectedListener(new SpectrumDialog.OnColorSelectedListener() { // from class: k0.b
            @Override // com.thebluealliance.spectrum.SpectrumDialog.OnColorSelectedListener
            public final void onColorSelected(boolean z3, int i4) {
                DrawerPreferencesFragment.x(DrawerConfiguration.this, this$0, imageView, z3, i4);
            }
        }).build();
        FragmentActivity activity = this$0.getActivity();
        Intrinsics.checkNotNull(activity);
        build.show(activity.getSupportFragmentManager(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(DrawerConfiguration drawerConfiguration, DrawerPreferencesFragment this$0, ImageView imageView, boolean z3, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z3) {
            drawerConfiguration.swipeAreaColor = i4;
            Settings.setDrawerConfiguration(this$0.getActivity(), drawerConfiguration);
            EventBusUtils.getEventBus().post(new DrawerHandleUpdateEvent(drawerConfiguration));
            Drawable background = imageView.getBackground();
            Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            ((GradientDrawable) background).setColor(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(DrawerConfiguration drawerConfiguration, DrawerPreferencesFragment this$0, CompoundButton compoundButton, boolean z3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        drawerConfiguration.leftSide = z3;
        Settings.setDrawerConfiguration(this$0.getActivity(), drawerConfiguration);
        EventBusUtils.getEventBus().post(new DrawerHandleUpdateEvent(drawerConfiguration));
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(@Nullable Bundle bundle, @Nullable String str) {
        setPreferencesFromResource(R.xml.preference_drawer, str);
        m();
    }
}
