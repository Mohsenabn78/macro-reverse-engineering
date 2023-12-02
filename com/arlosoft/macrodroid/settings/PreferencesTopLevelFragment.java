package com.arlosoft.macrodroid.settings;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;
import com.afollestad.materialdialogs.MaterialDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseFragment;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.triggers.LocationTrigger;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;

/* loaded from: classes3.dex */
public class PreferencesTopLevelFragment extends MacroDroidBaseFragment implements PreferenceFragmentCompat.OnPreferenceStartScreenCallback {

    /* renamed from: b  reason: collision with root package name */
    private Toolbar f13454b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f13455c;

    /* loaded from: classes3.dex */
    class a implements FragmentManager.OnBackStackChangedListener {
        a() {
        }

        @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
        public /* synthetic */ void onBackStackChangeCommitted(Fragment fragment, boolean z3) {
            androidx.fragment.app.t.a(this, fragment, z3);
        }

        @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
        public /* synthetic */ void onBackStackChangeStarted(Fragment fragment, boolean z3) {
            androidx.fragment.app.t.b(this, fragment, z3);
        }

        @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
        public void onBackStackChanged() {
            if (PreferencesTopLevelFragment.this.getChildFragmentManager().getBackStackEntryCount() == 0) {
                PreferencesTopLevelFragment.this.f13454b.setNavigationIcon((Drawable) null);
                PreferencesTopLevelFragment.this.f13455c.setText(R.string.settings);
                PreferencesTopLevelFragment.this.f13455c.setGravity(1);
                return;
            }
            List<Fragment> fragments = PreferencesTopLevelFragment.this.getChildFragmentManager().getFragments();
            PreferencesTopLevelFragment.this.f13455c.setText(fragments.get(fragments.size() - 1).getTag());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        getChildFragmentManager().popBackStack();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FirebaseAnalyticsEventLogger.logScreenView(requireActivity(), "TemplateTopLevelFragment");
        Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag(PreferencesFragment.FRAGMENT_TAG);
        if (findFragmentByTag == null) {
            findFragmentByTag = new PreferencesFragment();
        }
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.content, findFragmentByTag, PreferencesFragment.FRAGMENT_TAG);
        beginTransaction.commit();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        if (i4 == 2 && i5 == -1) {
            double doubleExtra = intent.getDoubleExtra(LocationTrigger.LATITUDE_EXTRA, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            double doubleExtra2 = intent.getDoubleExtra(LocationTrigger.LONGITUDE_EXTRA, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            FragmentActivity requireActivity = requireActivity();
            Settings.setWeatherLatLon(requireActivity, "lat=" + doubleExtra + "&lon=" + doubleExtra2);
        } else if (i4 == 3 && i5 == -1) {
            double doubleExtra3 = intent.getDoubleExtra(LocationTrigger.LATITUDE_EXTRA, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            double doubleExtra4 = intent.getDoubleExtra(LocationTrigger.LONGITUDE_EXTRA, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            FragmentActivity requireActivity2 = requireActivity();
            Settings.setSunriseSunsetLatLon(requireActivity2, doubleExtra3 + "," + doubleExtra4);
        } else {
            super.onActivityResult(i4, i5, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_top_level_preferences, viewGroup, false);
        this.f13455c = (TextView) inflate.findViewById(R.id.title);
        getChildFragmentManager().addOnBackStackChangedListener(new a());
        Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
        this.f13454b = toolbar;
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.settings.d2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PreferencesTopLevelFragment.this.e(view);
            }
        });
        return inflate;
    }

    @Override // androidx.preference.PreferenceFragmentCompat.OnPreferenceStartScreenCallback
    public boolean onPreferenceStartScreen(PreferenceFragmentCompat preferenceFragmentCompat, PreferenceScreen preferenceScreen) {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        PreferencesFragment preferencesFragment = new PreferencesFragment();
        Bundle bundle = new Bundle();
        bundle.putString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT", preferenceScreen.getKey());
        preferencesFragment.setArguments(bundle);
        beginTransaction.replace(R.id.content, preferencesFragment, preferenceScreen.getTitle().toString());
        beginTransaction.addToBackStack(preferenceScreen.getTitle().toString());
        beginTransaction.commit();
        this.f13454b.setNavigationIcon(R.drawable.material_ic_arrow_back_24px_svg);
        this.f13455c.setText(preferenceScreen.getTitle());
        this.f13455c.setGravity(GravityCompat.START);
        return true;
    }

    public void setTitle(String str) {
        this.f13455c.setText(str);
        this.f13455c.setGravity(GravityCompat.START);
    }

    /* loaded from: classes3.dex */
    public static class SetupRootTask extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        private transient MaterialDialog f13456a;

        /* renamed from: b  reason: collision with root package name */
        private final Activity f13457b;

        public SetupRootTask(Activity activity) {
            this.f13457b = activity;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            Util.runAsRoot(new String[]{"DUMMY_COMMAND"});
            try {
                Thread.sleep(2500L);
            } catch (InterruptedException unused) {
            }
            Util.copySocatBinary(this.f13457b);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r12) {
            MaterialDialog materialDialog = this.f13456a;
            if (materialDialog != null) {
                try {
                    materialDialog.dismiss();
                    this.f13456a = null;
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            try {
                this.f13456a = new MaterialDialog.Builder(this.f13457b).title(R.string.please_wait).content(R.string.enabling_root_functionality).progress(true, 0).cancelable(false).show();
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Void... voidArr) {
        }
    }
}
