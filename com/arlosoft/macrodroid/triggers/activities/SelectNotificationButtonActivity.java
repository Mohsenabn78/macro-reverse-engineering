package com.arlosoft.macrodroid.triggers.activities;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.BuildConfig;
import com.arlosoft.macrodroid.MacroDroidDialogBaseActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.NotificationButton;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.FileUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class SelectNotificationButtonActivity extends MacroDroidDialogBaseActivity {
    public static final String EXTRA_COLLAPSE_ON_PRESS = "collapse_on_press";

    private void l(MotionEvent motionEvent, View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    layoutParams.topMargin = ((int) motionEvent.getRawY()) - view.getHeight();
                    layoutParams.leftMargin = ((int) motionEvent.getRawX()) - (view.getWidth() / 2);
                    view.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            layoutParams.topMargin = ((int) motionEvent.getRawY()) - view.getHeight();
            layoutParams.leftMargin = ((int) motionEvent.getRawX()) - (view.getWidth() / 2);
            view.setLayoutParams(layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
    }

    private boolean m() {
        if ((getResources().getConfiguration().uiMode & 48) == 32) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean n(View view, MotionEvent motionEvent) {
        l(motionEvent, view);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(NotificationButton notificationButton, RadioButton radioButton, View view) {
        Intent intent = new Intent();
        intent.putExtra(Util.NOTIFICATION_BUTTON_EXTRA, notificationButton.getId());
        intent.putExtra(EXTRA_COLLAPSE_ON_PRESS, radioButton.isChecked());
        setResult(-1, intent);
        finish();
    }

    @Override // com.arlosoft.macrodroid.MacroDroidDialogBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i4;
        int color;
        int i5;
        super.onCreate(bundle);
        setContentView(R.layout.select_notificaton_button);
        setTitle(R.string.select_button);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setAttributes(attributes);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.button_layout);
        linearLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.arlosoft.macrodroid.triggers.activities.t
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean n4;
                n4 = SelectNotificationButtonActivity.this.n(view, motionEvent);
                return n4;
            }
        });
        boolean booleanExtra = getIntent().getBooleanExtra(EXTRA_COLLAPSE_ON_PRESS, true);
        final RadioButton radioButton = (RadioButton) findViewById(R.id.select_notification_button_collapse);
        radioButton.setChecked(booleanExtra);
        ((RadioButton) findViewById(R.id.select_notification_button_dont_collapse)).setChecked(!booleanExtra);
        ArrayList arrayList = new ArrayList();
        arrayList.add((ImageView) findViewById(R.id.button1));
        arrayList.add((ImageView) findViewById(R.id.button2));
        arrayList.add((ImageView) findViewById(R.id.button3));
        arrayList.add((ImageView) findViewById(R.id.button4));
        arrayList.add((ImageView) findViewById(R.id.button5));
        arrayList.add((ImageView) findViewById(R.id.button6));
        arrayList.add((ImageView) findViewById(R.id.button7));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add((ViewGroup) findViewById(R.id.button_frame_1));
        arrayList2.add((ViewGroup) findViewById(R.id.button_frame_2));
        arrayList2.add((ViewGroup) findViewById(R.id.button_frame_3));
        arrayList2.add((ViewGroup) findViewById(R.id.button_frame_4));
        arrayList2.add((ViewGroup) findViewById(R.id.button_frame_5));
        arrayList2.add((ViewGroup) findViewById(R.id.button_frame_6));
        arrayList2.add((ViewGroup) findViewById(R.id.button_frame_7));
        List<NotificationButton> notificationButtons = Settings.getNotificationButtons(this);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final ImageView imageView = (ImageView) it.next();
            imageView.setImageResource(0);
            imageView.setVisibility(8);
            registerForContextMenu(imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    imageView.showContextMenu();
                }
            });
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            ((ViewGroup) it2.next()).setVisibility(8);
        }
        int buttonBarIconTint = Settings.getButtonBarIconTint(this);
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            final ImageView imageView2 = (ImageView) it3.next();
            imageView2.setImageResource(R.drawable.drawable_transparent);
            imageView2.setVisibility(8);
            registerForContextMenu(imageView2);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    imageView2.showContextMenu();
                }
            });
        }
        Iterator it4 = arrayList2.iterator();
        while (it4.hasNext()) {
            ((ViewGroup) it4.next()).setVisibility(8);
        }
        if (Settings.getButtonBarBlackBg(this)) {
            color = -16777216;
        } else {
            if (m()) {
                i4 = R.color.default_background;
            } else {
                i4 = R.color.notification_bar_background;
            }
            color = ContextCompat.getColor(this, i4);
        }
        linearLayout.setBackgroundColor(color);
        for (int i6 = 0; i6 < notificationButtons.size() && i6 < arrayList2.size(); i6++) {
            final NotificationButton notificationButton = notificationButtons.get(i6);
            if (notificationButton.getImageUri() != null) {
                ((ViewGroup) arrayList2.get(i6)).setVisibility(0);
                ((ImageView) arrayList.get(i6)).setVisibility(0);
                ((ImageView) arrayList.get(i6)).setImageURI(notificationButton.getImageUri());
            } else {
                ((ImageView) arrayList.get(i6)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.w
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SelectNotificationButtonActivity.this.q(notificationButton, radioButton, view);
                    }
                });
                Drawable drawableFromPackageWithName = Util.getDrawableFromPackageWithName(this, notificationButton.getImageResourcePackage(), notificationButton.getImageResourceName());
                if (drawableFromPackageWithName == null) {
                    drawableFromPackageWithName = Util.getDrawableFromPackage(this, notificationButton.getImageResourcePackage(), notificationButton.getImageResourceId());
                }
                if (drawableFromPackageWithName == null) {
                    if (notificationButton.getImageResourcePackage() != null && notificationButton.getImageResourcePackage().equals(Constants.USER_ICON_OPTION_PACKAGE)) {
                        Bitmap decodeBitmapFromUserIconFile = FileUtils.decodeBitmapFromUserIconFile(notificationButton.getImageResourceName());
                        ((ViewGroup) arrayList2.get(i6)).setVisibility(0);
                        ((ImageView) arrayList.get(i6)).setVisibility(0);
                        if (decodeBitmapFromUserIconFile != null) {
                            ((ImageView) arrayList.get(i6)).setImageBitmap(decodeBitmapFromUserIconFile);
                        } else {
                            ((ImageView) arrayList.get(i6)).setImageResource(R.drawable.launcher_no_border);
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
                        ((ViewGroup) arrayList2.get(i6)).setVisibility(0);
                        ((ImageView) arrayList.get(i6)).setVisibility(0);
                        Drawable drawable = getResources().getDrawable(i5);
                        if (drawable != null) {
                            if (notificationButton.getImageResourcePackage() == null || (notificationButton.getImageResourcePackage().equals(BuildConfig.APPLICATION_ID) && !notificationButton.getImageResourceName().equals(BuildConfig.APPLICATION_ID))) {
                                ((ImageView) arrayList.get(i6)).setImageTintList(ColorStateList.valueOf(buttonBarIconTint));
                            }
                            ((ImageView) arrayList.get(i6)).setImageDrawable(drawable);
                        }
                    }
                } else {
                    ((ViewGroup) arrayList2.get(i6)).setVisibility(0);
                    ((ImageView) arrayList.get(i6)).setVisibility(0);
                    ((ImageView) arrayList.get(i6)).setImageDrawable(drawableFromPackageWithName);
                    if (notificationButton.getImageResourcePackage() == null || (notificationButton.getImageResourcePackage().equals(BuildConfig.APPLICATION_ID) && !notificationButton.getImageResourceName().equals(BuildConfig.APPLICATION_ID))) {
                        ((ImageView) arrayList.get(i6)).setImageTintList(ColorStateList.valueOf(buttonBarIconTint));
                    }
                }
            }
        }
    }
}
