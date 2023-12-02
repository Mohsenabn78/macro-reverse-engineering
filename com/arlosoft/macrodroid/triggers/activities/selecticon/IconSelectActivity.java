package com.arlosoft.macrodroid.triggers.activities.selecticon;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.templatestore.ui.SearchTermListener;
import com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider;
import com.arlosoft.macrodroid.utils.IconPackManager;
import com.arlosoft.macrodroid.utils.IpackKeys;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;

/* loaded from: classes3.dex */
public class IconSelectActivity extends MacroDroidBaseActivity implements SearchTermProvider {
    public static final String EXTRA_BLACK_BACKGROUND = "black_background";
    public static final String EXTRA_DEFAULT_EXTRA_TEXT_ICON = "DefaultExtraTextIcon";
    public static final String EXTRA_DISPLAY_APP_ICONS = "DisplayAppIcons";
    public static final String EXTRA_SHOW_TEXT_ICON = "ShowTextIcon";

    /* renamed from: f  reason: collision with root package name */
    private CardView f14590f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f14591g = true;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<SearchTermListener> f14592h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private IconSelectPagerAdapter f14593i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14594j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f14595k;

    /* renamed from: l  reason: collision with root package name */
    private ViewPager f14596l;

    /* renamed from: m  reason: collision with root package name */
    private SearchView f14597m;

    /* loaded from: classes3.dex */
    class a implements SearchView.OnQueryTextListener {
        a() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            Iterator it = IconSelectActivity.this.f14592h.iterator();
            while (it.hasNext()) {
                ((SearchTermListener) it.next()).onSearchTermUpdated(str);
            }
            return true;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    private void r() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_Action);
        builder.setTitle(R.string.install_new_icon_pack);
        builder.setMessage(R.string.install_ipack_detail);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.selecticon.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                IconSelectActivity.this.t(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.create().show();
    }

    private void s(String str) {
        try {
            File file = new File(str);
            FileUtils.copyFile(file, getFilesDir());
            Intent intent = new Intent();
            intent.putExtra(Util.DRAWABLE_NAME_EXTRA, file);
            setResult(-1, intent);
            finish();
        } catch (IOException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(DialogInterface dialogInterface, int i4) {
        try {
            startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse("https://play.google.com/store/search?q=Ipack&c=apps")));
        } catch (ActivityNotFoundException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(View view) {
        Settings.setIconSelectInfoCardHide(getApplicationContext(), true);
        this.f14590f.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(View view) {
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(View view) {
        y();
    }

    private void x() {
        try {
            startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse("https://play.google.com/store/search?q=adw%20icon%20pack&c=apps")));
        } catch (ActivityNotFoundException unused) {
        }
    }

    private void y() {
        boolean z3 = !this.f14591g;
        this.f14591g = z3;
        if (z3) {
            this.f14595k.setBackgroundColor(ContextCompat.getColor(this, R.color.icon_picker_select_bg));
            this.f14595k.setTextColor(ContextCompat.getColor(this, R.color.black));
            this.f14596l.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
            return;
        }
        this.f14595k.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
        this.f14595k.setTextColor(ContextCompat.getColor(this, R.color.white));
        this.f14596l.setBackgroundColor(ContextCompat.getColor(this, R.color.icon_picker_select_bg));
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider
    public void addSearchTermListener(SearchTermListener searchTermListener) {
        this.f14592h.add(searchTermListener);
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider
    @NonNull
    public String getSearchTerm() {
        return this.f14597m.getQuery().toString();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        if (i4 == 4282) {
            if (i5 == -1) {
                Uri data = intent.getData();
                Intent intent2 = new Intent();
                intent2.putExtra(Util.DRAWABLE_ID_EXTRA, 0);
                intent2.putExtra(Util.DRAWABLE_NAME_EXTRA, "");
                intent2.putExtra(Util.DRAWABLE_PACKAGE_NAME_EXTRA, "");
                intent2.setData(Uri.parse(IpackKeys.ANDROID_RESOURCE_PREFIX + data.getHost() + RemoteSettings.FORWARD_SLASH_STRING + intent.getExtras().getInt(IpackKeys.Extras.ICON_ID)));
                setResult(-1, intent2);
                finish();
            }
        } else if (i5 == -1) {
            String string = intent.getExtras().getString(Util.FILE_SELECTION_EXTRA);
            File file = new File(string);
            if (i4 == 47) {
                Settings.setImportExportDir(this, file.getParent());
                s(string);
            }
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.select_icon_top_level);
        setTitle(R.string.select_icon);
        IconPackManager iconPackManager = new IconPackManager();
        iconPackManager.setContext(getApplicationContext());
        HashMap<String, IconPackManager.IconPack> availableIconPacks = iconPackManager.getAvailableIconPacks(true);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : availableIconPacks.keySet()) {
            arrayList.add(str);
            arrayList2.add(availableIconPacks.get(str).name);
        }
        this.f14594j = getIntent().getBooleanExtra(EXTRA_DISPLAY_APP_ICONS, true);
        long longExtra = getIntent().getLongExtra(Constants.EXTRA_MACRO_GUID, 0L);
        boolean booleanExtra = getIntent().getBooleanExtra(EXTRA_SHOW_TEXT_ICON, false);
        String stringExtra = getIntent().getStringExtra(EXTRA_DEFAULT_EXTRA_TEXT_ICON);
        this.f14596l = (ViewPager) findViewById(R.id.select_icon_top_level_view_pager);
        this.f14597m = (SearchView) findViewById(R.id.searchView);
        IconSelectPagerAdapter iconSelectPagerAdapter = new IconSelectPagerAdapter(this, getSupportFragmentManager(), this.f14594j, arrayList, arrayList2, true, stringExtra, longExtra, booleanExtra);
        this.f14593i = iconSelectPagerAdapter;
        this.f14596l.setAdapter(iconSelectPagerAdapter);
        this.f14590f = (CardView) findViewById(R.id.infoCardView);
        ((Button) findViewById(R.id.infoCardGotIt)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.selecticon.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IconSelectActivity.this.u(view);
            }
        });
        ((Button) findViewById(R.id.info_card_search)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.selecticon.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IconSelectActivity.this.v(view);
            }
        });
        this.f14597m.setOnQueryTextListener(new a());
        if (this.f14594j && !Settings.getIconSelectInfoCardHide(getApplicationContext())) {
            this.f14590f.setVisibility(0);
        } else {
            this.f14590f.setVisibility(8);
        }
        ((TabLayout) findViewById(R.id.tabs)).setupWithViewPager(this.f14596l);
        TextView textView = (TextView) findViewById(R.id.toggle_bg_color);
        this.f14595k = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.selecticon.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IconSelectActivity.this.w(view);
            }
        });
        if ((getResources().getConfiguration().uiMode & 48) != 32) {
            y();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.f14594j) {
            getMenuInflater().inflate(R.menu.icon_select_menu, menu);
            if (!Settings.getIconSelectInfoCardHide(getApplicationContext())) {
                menu.findItem(R.id.menu_show_info_card).setVisible(false);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                finish();
                return true;
            case R.id.menu_icon_pack_search /* 2131363398 */:
                x();
                return true;
            case R.id.menu_install_new_icon_pack /* 2131363402 */:
                r();
                return true;
            case R.id.menu_show_info_card /* 2131363433 */:
                this.f14590f.setVisibility(0);
                return true;
            case R.id.menu_use_icon_pack /* 2131363444 */:
                try {
                    int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ipack_icon_size);
                    int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ipack_cell_size);
                    Intent intent = new Intent(IpackKeys.Actions.ICON_SELECT);
                    intent.putExtra(IpackKeys.Extras.ICON_DISPLAY_SIZE, dimensionPixelSize);
                    intent.putExtra(IpackKeys.Extras.CELL_SIZE, dimensionPixelSize2);
                    startActivityForResult(Intent.createChooser(intent, getString(R.string.icon_selection_choose_ipack)), 4282);
                    return true;
                } catch (ActivityNotFoundException unused) {
                    r();
                    return true;
                }
            default:
                return true;
        }
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f14597m.setFocusable(false);
        this.f14597m.clearFocus();
    }

    @Override // com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider
    public void removeSearchTermListener(SearchTermListener searchTermListener) {
        this.f14592h.remove(searchTermListener);
    }
}
