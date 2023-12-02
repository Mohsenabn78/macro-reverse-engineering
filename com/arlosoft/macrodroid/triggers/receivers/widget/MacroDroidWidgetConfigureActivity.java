package com.arlosoft.macrodroid.triggers.receivers.widget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.WidgetPressedTrigger;
import com.arlosoft.macrodroid.triggers.receivers.widget.MacroDroidWidgetConfigureActivity;
import com.arlosoft.macrodroid.utils.IconUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class MacroDroidWidgetConfigureActivity extends MacroDroidBaseActivity {

    /* renamed from: f  reason: collision with root package name */
    private int f15376f = 0;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<Macro> f15377g;

    /* loaded from: classes3.dex */
    public class SelectMacroAdapter extends BaseAdapter {
        public SelectMacroAdapter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(WidgetPressedTrigger widgetPressedTrigger, Macro macro, String str, String str2, Uri uri, View view) {
            MacroDroidWidgetConfigureActivity macroDroidWidgetConfigureActivity = MacroDroidWidgetConfigureActivity.this;
            MacroDroidWidgetConfigureActivity.saveLabelPref(macroDroidWidgetConfigureActivity, macroDroidWidgetConfigureActivity.f15376f, widgetPressedTrigger.getCurrentWidgetLabel());
            MacroDroidWidgetConfigureActivity macroDroidWidgetConfigureActivity2 = MacroDroidWidgetConfigureActivity.this;
            MacroDroidWidgetConfigureActivity.z(macroDroidWidgetConfigureActivity2, macroDroidWidgetConfigureActivity2.f15376f, widgetPressedTrigger.getImageResource());
            MacroDroidWidgetConfigureActivity macroDroidWidgetConfigureActivity3 = MacroDroidWidgetConfigureActivity.this;
            MacroDroidWidgetConfigureActivity.saveImageResourceNamePref(macroDroidWidgetConfigureActivity3, macroDroidWidgetConfigureActivity3.f15376f, widgetPressedTrigger.getImageName());
            MacroDroidWidgetConfigureActivity macroDroidWidgetConfigureActivity4 = MacroDroidWidgetConfigureActivity.this;
            MacroDroidWidgetConfigureActivity.saveImageResourcePackagePref(macroDroidWidgetConfigureActivity4, macroDroidWidgetConfigureActivity4.f15376f, widgetPressedTrigger.getPackageName());
            MacroDroidWidgetConfigureActivity macroDroidWidgetConfigureActivity5 = MacroDroidWidgetConfigureActivity.this;
            MacroDroidWidgetConfigureActivity.A(macroDroidWidgetConfigureActivity5, macroDroidWidgetConfigureActivity5.f15376f, macro.getGUID());
            MacroDroidWidgetConfigureActivity macroDroidWidgetConfigureActivity6 = MacroDroidWidgetConfigureActivity.this;
            MacroDroidWidgetConfigureActivity.saveImageTextIcon(macroDroidWidgetConfigureActivity6, macroDroidWidgetConfigureActivity6.f15376f, widgetPressedTrigger.getIconText());
            if (widgetPressedTrigger.getImageUri() != null) {
                MacroDroidWidgetConfigureActivity macroDroidWidgetConfigureActivity7 = MacroDroidWidgetConfigureActivity.this;
                MacroDroidWidgetConfigureActivity.saveImageResourceUriPref(macroDroidWidgetConfigureActivity7, macroDroidWidgetConfigureActivity7.f15376f, widgetPressedTrigger.getImageUri().toString());
            }
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(MacroDroidWidgetConfigureActivity.this);
            MacroDroidWidgetConfigureActivity macroDroidWidgetConfigureActivity8 = MacroDroidWidgetConfigureActivity.this;
            WidgetProviderCustom.c(macroDroidWidgetConfigureActivity8, appWidgetManager, macroDroidWidgetConfigureActivity8.f15376f, widgetPressedTrigger.getWidgetLabel(), widgetPressedTrigger.getImageResource(), str, str2, uri);
            Intent intent = new Intent();
            intent.putExtra("appWidgetId", MacroDroidWidgetConfigureActivity.this.f15376f);
            MacroDroidWidgetConfigureActivity.this.setResult(-1, intent);
            MacroDroidWidgetConfigureActivity.this.finish();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return MacroDroidWidgetConfigureActivity.this.f15377g.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i4) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i4) {
            return i4;
        }

        @Override // android.widget.Adapter
        public View getView(int i4, View view, ViewGroup viewGroup) {
            View view2;
            if (view == null) {
                view2 = ((LayoutInflater) MacroDroidWidgetConfigureActivity.this.getSystemService("layout_inflater")).inflate(R.layout.custom_widget_selection_list_row, (ViewGroup) null);
            } else {
                view2 = view;
            }
            final Macro macro = (Macro) MacroDroidWidgetConfigureActivity.this.f15377g.get(i4);
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            final WidgetPressedTrigger widgetPressedTrigger = null;
            while (it.hasNext()) {
                Trigger next = it.next();
                if (next instanceof WidgetPressedTrigger) {
                    widgetPressedTrigger = (WidgetPressedTrigger) next;
                }
            }
            ImageView imageView = (ImageView) view2.findViewById(R.id.custom_widget_selection_list_row_widget_image);
            final String imageName = widgetPressedTrigger.getImageName();
            final String packageName = widgetPressedTrigger.getPackageName();
            final Uri imageUri = widgetPressedTrigger.getImageUri();
            IconUtils.setImageOnImageView(MacroDroidWidgetConfigureActivity.this, imageView, imageName, packageName, -1, imageUri, widgetPressedTrigger.getIconText());
            ((TextView) view2.findViewById(R.id.custom_widget_selection_list_row_widget_text)).setText(widgetPressedTrigger.getWidgetLabel());
            ((TextView) view2.findViewById(R.id.custom_widget_selection_list_row_macro_name)).setText(macro.getName());
            view2.setOnClickListener(new View.OnClickListener() { // from class: r0.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    MacroDroidWidgetConfigureActivity.SelectMacroAdapter.this.b(widgetPressedTrigger, macro, imageName, packageName, imageUri, view3);
                }
            });
            return view2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void A(Context context, int i4, long j4) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.arlosoft.macrodroid.triggers.receivers.widget.MacroDroidWidgetConfigureActivity", 0).edit();
        edit.putLong("macro_" + i4, j4);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void q(Context context, int i4) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.arlosoft.macrodroid.triggers.receivers.widget.MacroDroidWidgetConfigureActivity", 0).edit();
        edit.remove("imageResource_" + i4);
        edit.remove("label_" + i4);
        edit.remove("macro_" + i4);
        edit.remove("imageResourceName_" + i4);
        edit.remove("imageResourcePackage_" + i4);
        edit.remove("iconText_" + i4);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean r(Context context, int i4) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.arlosoft.macrodroid.triggers.receivers.widget.MacroDroidWidgetConfigureActivity", 0);
        return sharedPreferences.getBoolean("imageFaded_" + i4, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String s(Context context, int i4) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.arlosoft.macrodroid.triggers.receivers.widget.MacroDroidWidgetConfigureActivity", 0);
        return sharedPreferences.getString("iconText_" + i4, null);
    }

    public static void saveImageFadedPref(Context context, int i4, boolean z3) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.arlosoft.macrodroid.triggers.receivers.widget.MacroDroidWidgetConfigureActivity", 0).edit();
        edit.putBoolean("imageFaded_" + i4, z3);
        edit.apply();
    }

    public static void saveImageResourceNamePref(Context context, int i4, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.arlosoft.macrodroid.triggers.receivers.widget.MacroDroidWidgetConfigureActivity", 0).edit();
        edit.putString("imageResourceName_" + i4, str);
        edit.apply();
    }

    public static void saveImageResourcePackagePref(Context context, int i4, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.arlosoft.macrodroid.triggers.receivers.widget.MacroDroidWidgetConfigureActivity", 0).edit();
        edit.putString("imageResourcePackage_" + i4, str);
        edit.apply();
    }

    public static void saveImageResourceUriPref(Context context, int i4, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.arlosoft.macrodroid.triggers.receivers.widget.MacroDroidWidgetConfigureActivity", 0).edit();
        edit.putString("imageResourceURI_" + i4, str);
        edit.apply();
    }

    public static void saveImageTextIcon(Context context, int i4, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.arlosoft.macrodroid.triggers.receivers.widget.MacroDroidWidgetConfigureActivity", 0).edit();
        edit.putString("iconText_" + i4, str);
        edit.apply();
    }

    public static void saveLabelPref(Context context, int i4, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.arlosoft.macrodroid.triggers.receivers.widget.MacroDroidWidgetConfigureActivity", 0).edit();
        edit.putString("label_" + i4, str);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String t(Context context, int i4) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.arlosoft.macrodroid.triggers.receivers.widget.MacroDroidWidgetConfigureActivity", 0);
        return sharedPreferences.getString("imageResourceName_" + i4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String u(Context context, int i4) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.arlosoft.macrodroid.triggers.receivers.widget.MacroDroidWidgetConfigureActivity", 0);
        return sharedPreferences.getString("imageResourcePackage_" + i4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(Context context, int i4) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.arlosoft.macrodroid.triggers.receivers.widget.MacroDroidWidgetConfigureActivity", 0);
        return sharedPreferences.getInt("imageResource_" + i4, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String w(Context context, int i4) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.arlosoft.macrodroid.triggers.receivers.widget.MacroDroidWidgetConfigureActivity", 0);
        return sharedPreferences.getString("imageResourceURI_" + i4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String x(Context context, int i4) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.arlosoft.macrodroid.triggers.receivers.widget.MacroDroidWidgetConfigureActivity", 0);
        String string = sharedPreferences.getString("label_" + i4, null);
        if (string != null) {
            return string;
        }
        return "Button";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long y(Context context, int i4) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.arlosoft.macrodroid.triggers.receivers.widget.MacroDroidWidgetConfigureActivity", 0);
        return sharedPreferences.getLong("macro_" + i4, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void z(Context context, int i4, int i5) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.arlosoft.macrodroid.triggers.receivers.widget.MacroDroidWidgetConfigureActivity", 0).edit();
        edit.putInt("imageResource_" + i4, i5);
        edit.apply();
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setResult(0);
        setContentView(R.layout.custom_widget_selection);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setTitle(R.string.trigger_widget_pressed_select);
        ListView listView = (ListView) findViewById(R.id.custom_widget_selection_list);
        ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.view_flipper);
        this.f15377g = new ArrayList<>();
        for (Macro macro : MacroStore.getInstance().getAllCompletedMacrosIncludingExtras()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if ((next instanceof WidgetPressedTrigger) && ((WidgetPressedTrigger) next).getWidgetType() == 4) {
                        this.f15377g.add(macro);
                        break;
                    }
                }
            }
        }
        if (this.f15377g.isEmpty()) {
            viewFlipper.setDisplayedChild(1);
        } else {
            listView.setAdapter((ListAdapter) new SelectMacroAdapter());
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f15376f = extras.getInt("appWidgetId", 0);
        }
        if (this.f15376f == 0) {
            finish();
        }
    }
}
