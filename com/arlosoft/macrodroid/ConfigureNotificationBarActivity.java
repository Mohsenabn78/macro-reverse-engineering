package com.arlosoft.macrodroid;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.NotificationButton;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.activities.selecticon.IconSelectActivity;
import com.arlosoft.macrodroid.utils.FileUtils;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ConfigureNotificationBarActivity extends MacroDroidDialogBaseActivity implements ColorPickerDialogListener {

    /* renamed from: d  reason: collision with root package name */
    private List<ImageView> f1945d;

    /* renamed from: e  reason: collision with root package name */
    private List<ViewGroup> f1946e;

    /* renamed from: f  reason: collision with root package name */
    private int f1947f;

    /* renamed from: g  reason: collision with root package name */
    private List<NotificationButton> f1948g;

    /* renamed from: h  reason: collision with root package name */
    private int f1949h;

    /* renamed from: i  reason: collision with root package name */
    private List<NotificationButton> f1950i;

    /* renamed from: j  reason: collision with root package name */
    private int f1951j;

    /* renamed from: k  reason: collision with root package name */
    private SwitchCompat f1952k;

    /* renamed from: l  reason: collision with root package name */
    private ImageView f1953l;

    /* loaded from: classes2.dex */
    class a extends OnBackPressedCallback {
        a(boolean z3) {
            super(z3);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            MacroDroidService.updateNotification(ConfigureNotificationBarActivity.this, true, true);
            ConfigureNotificationBarActivity.this.finish();
        }
    }

    private void A() {
        ColorPickerDialog.Builder color = ColorPickerDialog.newBuilder().setColor(Settings.getButtonBarIconTint(this));
        color.setDialogTitle(R.string.select_color);
        color.setCustomButtonText(R.string.icon_tint_custom_color);
        color.setPresetsButtonText(R.string.icon_tint_color_presets);
        color.setShowAlphaSlider(true);
        color.setSelectedButtonText(17039370);
        color.show(this);
    }

    private boolean q() {
        if ((getResources().getConfiguration().uiMode & 48) == 32) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(View view) {
        A();
    }

    private void refresh() {
        boolean z3;
        int i4;
        int i5;
        int buttonBarIconTint = Settings.getButtonBarIconTint(this);
        for (final ImageView imageView : this.f1945d) {
            imageView.setImageResource(R.drawable.drawable_transparent);
            imageView.setVisibility(8);
            registerForContextMenu(imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    imageView.showContextMenu();
                }
            });
        }
        for (ViewGroup viewGroup : this.f1946e) {
            viewGroup.setVisibility(8);
        }
        this.f1948g = Settings.getNotificationButtons(this);
        if (!q() && !this.f1952k.isChecked()) {
            z3 = false;
        } else {
            z3 = true;
        }
        for (int i6 = 0; i6 < this.f1948g.size() && i6 < this.f1946e.size(); i6++) {
            NotificationButton notificationButton = this.f1948g.get(i6);
            if (notificationButton.getImageUri() != null) {
                this.f1946e.get(i6).setVisibility(0);
                this.f1945d.get(i6).setVisibility(0);
                this.f1945d.get(i6).setImageURI(notificationButton.getImageUri());
            } else {
                Drawable drawableFromPackageWithName = Util.getDrawableFromPackageWithName(this, notificationButton.getImageResourcePackage(), notificationButton.getImageResourceName());
                if (drawableFromPackageWithName == null) {
                    drawableFromPackageWithName = Util.getDrawableFromPackage(this, notificationButton.getImageResourcePackage(), notificationButton.getImageResourceId());
                }
                if (drawableFromPackageWithName == null) {
                    if (notificationButton.getImageResourcePackage() != null && notificationButton.getImageResourcePackage().equals(Constants.USER_ICON_OPTION_PACKAGE)) {
                        Bitmap decodeBitmapFromUserIconFile = FileUtils.decodeBitmapFromUserIconFile(notificationButton.getImageResourceName());
                        this.f1946e.get(i6).setVisibility(0);
                        this.f1945d.get(i6).setVisibility(0);
                        if (decodeBitmapFromUserIconFile != null) {
                            this.f1945d.get(i6).setImageBitmap(decodeBitmapFromUserIconFile);
                        } else {
                            this.f1945d.get(i6).setImageResource(R.drawable.launcher_no_border);
                        }
                    } else {
                        if (notificationButton.getImageResourceName() != null) {
                            i5 = Util.getResId(this, notificationButton.getImageResourceName());
                        } else {
                            i5 = -1;
                        }
                        if (i5 == -1) {
                            i5 = R.drawable.ic_settings_white_24dp;
                        }
                        this.f1946e.get(i6).setVisibility(0);
                        this.f1945d.get(i6).setVisibility(0);
                        try {
                            drawableFromPackageWithName = ResourcesCompat.getDrawable(getResources(), i5, null);
                        } catch (Exception e4) {
                            SystemLog.logError("Could not get icon for notificaiton bar: " + e4);
                        }
                        if (drawableFromPackageWithName != null) {
                            if (notificationButton.getImageResourcePackage() == null || (notificationButton.getImageResourcePackage().equals(BuildConfig.APPLICATION_ID) && !notificationButton.getImageResourceName().equals(BuildConfig.APPLICATION_ID))) {
                                this.f1945d.get(i6).setImageTintList(ColorStateList.valueOf(buttonBarIconTint));
                            }
                            this.f1945d.get(i6).setImageDrawable(drawableFromPackageWithName);
                        }
                    }
                } else {
                    this.f1946e.get(i6).setVisibility(0);
                    this.f1945d.get(i6).setVisibility(0);
                    this.f1945d.get(i6).setImageDrawable(drawableFromPackageWithName);
                    if (notificationButton.getImageResourcePackage() == null || (notificationButton.getImageResourcePackage().equals(BuildConfig.APPLICATION_ID) && !notificationButton.getImageResourceName().equals(BuildConfig.APPLICATION_ID))) {
                        this.f1945d.get(i6).setImageTintList(ColorStateList.valueOf(buttonBarIconTint));
                    }
                }
            }
        }
        if (this.f1948g.size() < 7) {
            ImageView imageView2 = this.f1945d.get(this.f1948g.size());
            if (z3) {
                i4 = R.drawable.ic_add_circle_white_48dp;
            } else {
                i4 = R.drawable.ic_add_circle_black_48dp;
            }
            imageView2.setImageResource(i4);
            this.f1946e.get(this.f1948g.size()).setVisibility(0);
            unregisterForContextMenu(imageView2);
            imageView2.setVisibility(0);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConfigureNotificationBarActivity.this.z(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(View view, ViewGroup viewGroup, CompoundButton compoundButton, boolean z3) {
        int i4;
        float f4;
        if (z3) {
            i4 = 8;
        } else {
            i4 = 0;
        }
        view.setVisibility(i4);
        Settings.setShowNotificationButtonBar(this, z3);
        if (z3) {
            f4 = 1.0f;
        } else {
            f4 = 0.4f;
        }
        viewGroup.setAlpha(f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(View view) {
        MacroDroidService.updateNotification(this, true, true);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(View view) {
        Settings.setNotificationButtons(this, this.f1950i);
        Settings.setLatestNotificationButtonId(this, this.f1951j);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(CheckBox checkBox, CompoundButton compoundButton, boolean z3) {
        int i4;
        Settings.setShowMacroDroidIcon(this, z3);
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        checkBox.setVisibility(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(CompoundButton compoundButton, boolean z3) {
        Settings.setShowNotificationCurrentMode(this, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(ViewGroup viewGroup, boolean z3, CompoundButton compoundButton, boolean z4) {
        int i4;
        int color;
        boolean z5 = !Settings.getButtonBarBlackBg(this);
        Settings.setButtonBarBlackBg(this, z5);
        if (z5) {
            color = -16777216;
        } else {
            if (z3) {
                i4 = R.color.default_background;
            } else {
                i4 = R.color.notification_bar_background;
            }
            color = ContextCompat.getColor(this, i4);
        }
        viewGroup.setBackgroundColor(color);
        this.f1953l.setImageTintList(ColorStateList.valueOf(Settings.getButtonBarIconTint(this)));
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(View view) {
        Intent intent = new Intent(this, IconSelectActivity.class);
        intent.putExtra(IconSelectActivity.EXTRA_BLACK_BACKGROUND, true);
        startActivityForResult(intent, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        if (i5 != 0) {
            String stringExtra = intent.getStringExtra(Util.DRAWABLE_NAME_EXTRA);
            String stringExtra2 = intent.getStringExtra(Util.DRAWABLE_PACKAGE_NAME_EXTRA);
            intent.getStringExtra(Util.ICON_TEXT_EXTRA);
            Uri data = intent.getData();
            int intExtra = intent.getIntExtra(Util.DRAWABLE_ID_EXTRA, 0);
            List<NotificationButton> notificationButtons = Settings.getNotificationButtons(this);
            if (i4 == 0) {
                notificationButtons.add(new NotificationButton(this.f1947f, stringExtra, stringExtra2, intExtra, data));
                int i6 = this.f1947f + 1;
                this.f1947f = i6;
                Settings.setLatestNotificationButtonId(this, i6);
                Settings.setNotificationButtons(this, notificationButtons);
                refresh();
            } else if (i4 == 1) {
                NotificationButton notificationButton = notificationButtons.get(this.f1949h);
                notificationButton.setImageResourceName(stringExtra);
                notificationButton.setImageResourcePackage(stringExtra2);
                notificationButton.setImageResourceId(intExtra);
                notificationButton.setImageUri(data);
                Settings.setNotificationButtons(this, notificationButtons);
                refresh();
            }
        }
    }

    @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
    public void onColorSelected(int i4, int i5) {
        this.f1953l.setImageTintList(ColorStateList.valueOf(i5));
        Settings.setButtonBarIconTint(this, i5);
        refresh();
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        int i4;
        int itemId = menuItem.getItemId();
        if (itemId != 0) {
            if (itemId != 1) {
                if (itemId != 2) {
                    if (itemId == 3 && (i4 = this.f1949h) > -1) {
                        this.f1948g.add(this.f1949h + 1, this.f1948g.remove(i4));
                        Settings.setNotificationButtons(this, this.f1948g);
                        refresh();
                    }
                } else {
                    int i5 = this.f1949h;
                    if (i5 > -1) {
                        this.f1948g.add(this.f1949h - 1, this.f1948g.remove(i5));
                        Settings.setNotificationButtons(this, this.f1948g);
                        refresh();
                    }
                }
            } else {
                Intent intent = new Intent(this, IconSelectActivity.class);
                intent.putExtra(IconSelectActivity.EXTRA_BLACK_BACKGROUND, true);
                startActivityForResult(intent, 1);
            }
        } else if (this.f1949h > -1 && this.f1948g.size() > 0 && this.f1949h < this.f1948g.size()) {
            this.f1948g.remove(this.f1949h);
            Settings.setNotificationButtons(this, this.f1948g);
            refresh();
        }
        return true;
    }

    @Override // com.arlosoft.macrodroid.MacroDroidDialogBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i4;
        float f4;
        int i5;
        int i6;
        int color;
        super.onCreate(bundle);
        setContentView(R.layout.configure_notification_buttons_activity);
        setTitle(R.string.configure_button_bar);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setAttributes(attributes);
        Button button = (Button) findViewById(R.id.okButton);
        Button button2 = (Button) findViewById(R.id.cancelButton);
        SwitchCompat switchCompat = (SwitchCompat) findViewById(R.id.configure_notification_Switch);
        this.f1952k = (SwitchCompat) findViewById(R.id.configure_black_bar);
        final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.configure_notification_button_controls);
        final ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.button_layout);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.configure_notification_show_mode);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.configure_notification_show_macrodroid_icon);
        final View findViewById = findViewById(R.id.view_blocker);
        TextView textView = (TextView) findViewById(R.id.android12Warning);
        this.f1953l = (ImageView) findViewById(R.id.icon_tint_button);
        int i7 = 8;
        if (Build.VERSION.SDK_INT >= 31) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        textView.setVisibility(i4);
        button2.setVisibility(8);
        boolean showNotificationButtonBar = Settings.getShowNotificationButtonBar(this);
        this.f1953l.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConfigureNotificationBarActivity.this.r(view);
            }
        });
        if (showNotificationButtonBar) {
            f4 = 1.0f;
        } else {
            f4 = 0.4f;
        }
        viewGroup.setAlpha(f4);
        checkBox2.setChecked(Settings.getShowMacroDroidIcon(this));
        if (checkBox2.isChecked()) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        checkBox.setVisibility(i5);
        checkBox.setChecked(Settings.getShowNotificationCurrentMode(this));
        switchCompat.setChecked(showNotificationButtonBar);
        viewGroup.setEnabled(showNotificationButtonBar);
        if (!showNotificationButtonBar) {
            i7 = 0;
        }
        findViewById.setVisibility(i7);
        final boolean q4 = q();
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                ConfigureNotificationBarActivity.this.s(findViewById, viewGroup, compoundButton, z3);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConfigureNotificationBarActivity.this.t(view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConfigureNotificationBarActivity.this.u(view);
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.g
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                ConfigureNotificationBarActivity.this.v(checkBox, compoundButton, z3);
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.h
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                ConfigureNotificationBarActivity.this.w(compoundButton, z3);
            }
        });
        this.f1952k.setVisibility(0);
        boolean buttonBarBlackBg = Settings.getButtonBarBlackBg(this);
        this.f1952k.setChecked(buttonBarBlackBg);
        if (buttonBarBlackBg) {
            color = -16777216;
        } else {
            if (q4) {
                i6 = R.color.default_background;
            } else {
                i6 = R.color.notification_bar_background;
            }
            color = ContextCompat.getColor(this, i6);
        }
        viewGroup2.setBackgroundColor(color);
        this.f1952k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.i
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                ConfigureNotificationBarActivity.this.x(viewGroup2, q4, compoundButton, z3);
            }
        });
        this.f1951j = Settings.getLatestNotificationButtonId(this);
        this.f1950i = Settings.getNotificationButtons(this);
        ArrayList arrayList = new ArrayList();
        this.f1945d = arrayList;
        arrayList.add((ImageView) findViewById(R.id.button1));
        this.f1945d.add((ImageView) findViewById(R.id.button2));
        this.f1945d.add((ImageView) findViewById(R.id.button3));
        this.f1945d.add((ImageView) findViewById(R.id.button4));
        this.f1945d.add((ImageView) findViewById(R.id.button5));
        this.f1945d.add((ImageView) findViewById(R.id.button6));
        this.f1945d.add((ImageView) findViewById(R.id.button7));
        ArrayList arrayList2 = new ArrayList();
        this.f1946e = arrayList2;
        arrayList2.add((ViewGroup) findViewById(R.id.button_frame_1));
        this.f1946e.add((ViewGroup) findViewById(R.id.button_frame_2));
        this.f1946e.add((ViewGroup) findViewById(R.id.button_frame_3));
        this.f1946e.add((ViewGroup) findViewById(R.id.button_frame_4));
        this.f1946e.add((ViewGroup) findViewById(R.id.button_frame_5));
        this.f1946e.add((ViewGroup) findViewById(R.id.button_frame_6));
        this.f1946e.add((ViewGroup) findViewById(R.id.button_frame_7));
        this.f1947f = Settings.getLatestNotificationButtonId(this);
        this.f1953l.setImageTintList(ColorStateList.valueOf(Settings.getButtonBarIconTint(this)));
        getOnBackPressedDispatcher().addCallback(this, new a(true));
        refresh();
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        this.f1949h = -1;
        Iterator<ImageView> it = this.f1945d.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next() == view) {
                this.f1949h = i4;
                break;
            } else {
                i4++;
            }
        }
        contextMenu.add(0, 0, 0, getString(R.string.delete));
        contextMenu.add(0, 1, 0, getString(R.string.select_icon));
        if (this.f1949h > 0) {
            contextMenu.add(0, 2, 0, getString(R.string.move_left));
        }
        if (this.f1949h < this.f1948g.size() - 1) {
            contextMenu.add(0, 3, 0, getString(R.string.move_right));
        }
    }

    @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
    public void onDialogDismissed(int i4) {
    }
}
