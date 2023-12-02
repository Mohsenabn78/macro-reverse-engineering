package com.takisoft.preferencex;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.preference.EditTextPreferenceDialogFragmentCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceManagerFix;
import java.lang.reflect.Field;
import java.util.HashMap;

/* loaded from: classes6.dex */
public abstract class PreferenceFragmentCompat extends androidx.preference.PreferenceFragmentCompat {

    /* renamed from: b  reason: collision with root package name */
    private static Field f37968b;

    /* renamed from: c  reason: collision with root package name */
    protected static HashMap<Class<? extends Preference>, Class<? extends Fragment>> f37969c;

    static {
        Field[] declaredFields = androidx.preference.PreferenceFragmentCompat.class.getDeclaredFields();
        int length = declaredFields.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            Field field = declaredFields[i4];
            if (field.getType() == PreferenceManager.class) {
                f37968b = field;
                field.setAccessible(true);
                break;
            }
            i4++;
        }
        f37969c = new HashMap<>();
    }

    private void f(PreferenceGroup preferenceGroup) {
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i4 = 0; i4 < preferenceCount; i4++) {
            Preference preference = preferenceGroup.getPreference(i4);
            if (preference instanceof SwitchPreferenceCompat) {
                ((SwitchPreferenceCompat) preference).b();
            } else if (preference instanceof PreferenceGroup) {
                f((PreferenceGroup) preference);
            }
        }
    }

    public static void registerPreferenceFragment(Class<? extends Preference> cls, Class<? extends Fragment> cls2) {
        f37969c.put(cls, cls2);
    }

    protected void b(@NonNull Fragment fragment, @NonNull String str) {
        c(fragment, str, null);
    }

    protected void c(@NonNull Fragment fragment, @NonNull String str, @Nullable Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        if (bundle == null) {
            bundle = new Bundle(1);
        }
        bundle.putString("key", str);
        fragment.setArguments(bundle);
        fragment.setTargetFragment(this, 0);
        if (fragment instanceof DialogFragment) {
            ((DialogFragment) fragment).show(fragmentManager, "androidx.preference.PreferenceFragment.DIALOG");
        } else {
            fragmentManager.beginTransaction().add(fragment, "androidx.preference.PreferenceFragment.DIALOG").commit();
        }
    }

    protected void d(PreferenceGroup preferenceGroup, int i4, int i5, Intent intent) {
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i6 = 0; i6 < preferenceCount; i6++) {
            Preference preference = preferenceGroup.getPreference(i6);
            if (preference instanceof PreferenceActivityResultListener) {
                ((PreferenceActivityResultListener) preference).onActivityResult(i4, i5, intent);
            }
            if (preference instanceof PreferenceGroup) {
                d((PreferenceGroup) preference, i4, i5, intent);
            }
        }
    }

    protected boolean e(PreferenceFragmentCompat preferenceFragmentCompat, Preference preference) {
        FragmentManager requireFragmentManager = preferenceFragmentCompat.requireFragmentManager();
        Bundle extras = preference.getExtras();
        Fragment instantiate = requireFragmentManager.getFragmentFactory().instantiate(requireActivity().getClassLoader(), preference.getFragment());
        instantiate.setArguments(extras);
        instantiate.setTargetFragment(this, 0);
        requireFragmentManager.beginTransaction().setTransition(4097).replace(((View) getView().getParent()).getId(), instantiate).addToBackStack(preference.getKey()).commit();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        d(getPreferenceScreen(), i4, i5, intent);
        super.onActivityResult(i4, i5, intent);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        String str;
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(R.attr.preferenceTheme, typedValue, true);
        int i4 = typedValue.resourceId;
        if (i4 == 0) {
            i4 = R.style.PreferenceThemeOverlay;
        }
        PreferenceManagerFix preferenceManagerFix = new PreferenceManagerFix(new ContextThemeWrapper(getActivity(), i4));
        preferenceManagerFix.setOnNavigateToScreenListener(this);
        try {
            f37968b.set(this, preferenceManagerFix);
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        }
        if (getArguments() != null) {
            str = getArguments().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT");
        } else {
            str = null;
        }
        onCreatePreferencesFix(bundle, str);
    }

    public abstract void onCreatePreferencesFix(@Nullable Bundle bundle, String str);

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnDisplayPreferenceDialogListener
    public void onDisplayPreferenceDialog(Preference preference) {
        if (requireFragmentManager().findFragmentByTag("androidx.preference.PreferenceFragment.DIALOG") == null) {
            if (preference instanceof EditTextPreference) {
                b(new EditTextPreferenceDialogFragmentCompat(), preference.getKey());
            } else if (f37969c.containsKey(preference.getClass())) {
                try {
                    b(f37969c.get(preference.getClass()).newInstance(), preference.getKey());
                } catch (IllegalAccessException e4) {
                    e4.printStackTrace();
                } catch (InstantiationException e5) {
                    e5.printStackTrace();
                }
            } else {
                super.onDisplayPreferenceDialog(preference);
            }
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference preference) {
        boolean z3 = false;
        if (preference.getFragment() != null) {
            if (getCallbackFragment() instanceof PreferenceFragmentCompat.OnPreferenceStartFragmentCallback) {
                z3 = ((PreferenceFragmentCompat.OnPreferenceStartFragmentCallback) getCallbackFragment()).onPreferenceStartFragment(this, preference);
            }
            if (!z3 && (getActivity() instanceof PreferenceFragmentCompat.OnPreferenceStartFragmentCallback)) {
                z3 = ((PreferenceFragmentCompat.OnPreferenceStartFragmentCallback) getActivity()).onPreferenceStartFragment(this, preference);
            }
            if (!z3) {
                z3 = e(this, preference);
            }
        }
        if (!z3) {
            z3 = super.onPreferenceTreeClick(preference);
        }
        if (!z3 && (preference instanceof PreferenceActivityResultListener)) {
            ((PreferenceActivityResultListener) preference).onPreferenceClick(this, preference);
        }
        return z3;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        f(getPreferenceScreen());
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    @Deprecated
    public void onCreatePreferences(@Nullable Bundle bundle, @Nullable String str) {
    }
}
