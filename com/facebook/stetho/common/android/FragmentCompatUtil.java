package com.facebook.stetho.common.android;

import android.app.Activity;
import android.view.View;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public final class FragmentCompatUtil {
    private FragmentCompatUtil() {
    }

    @Nullable
    public static Object findFragmentForView(View view) {
        Activity tryGetActivity = ViewUtil.tryGetActivity(view);
        if (tryGetActivity == null) {
            return null;
        }
        return findFragmentForViewInActivity(tryGetActivity, view);
    }

    @Nullable
    private static Object findFragmentForViewInActivity(Activity activity, View view) {
        Object findFragmentForViewInActivity;
        Object findFragmentForViewInActivity2;
        FragmentCompat supportLibInstance = FragmentCompat.getSupportLibInstance();
        if (supportLibInstance == null || !supportLibInstance.getFragmentActivityClass().isInstance(activity) || (findFragmentForViewInActivity2 = findFragmentForViewInActivity(supportLibInstance, activity, view)) == null) {
            FragmentCompat frameworkInstance = FragmentCompat.getFrameworkInstance();
            if (frameworkInstance == null || (findFragmentForViewInActivity = findFragmentForViewInActivity(frameworkInstance, activity, view)) == null) {
                return null;
            }
            return findFragmentForViewInActivity;
        }
        return findFragmentForViewInActivity2;
    }

    @Nullable
    private static Object findFragmentForViewInFragment(FragmentCompat fragmentCompat, Object obj, View view) {
        FragmentAccessor forFragment = fragmentCompat.forFragment();
        if (forFragment.getView(obj) == view) {
            return obj;
        }
        Object childFragmentManager = forFragment.getChildFragmentManager(obj);
        if (childFragmentManager != null) {
            return findFragmentForViewInFragmentManager(fragmentCompat, childFragmentManager, view);
        }
        return null;
    }

    @Nullable
    private static Object findFragmentForViewInFragmentManager(FragmentCompat fragmentCompat, Object obj, View view) {
        List addedFragments = fragmentCompat.forFragmentManager().getAddedFragments(obj);
        if (addedFragments != null) {
            int size = addedFragments.size();
            for (int i4 = 0; i4 < size; i4++) {
                Object findFragmentForViewInFragment = findFragmentForViewInFragment(fragmentCompat, addedFragments.get(i4), view);
                if (findFragmentForViewInFragment != null) {
                    return findFragmentForViewInFragment;
                }
            }
            return null;
        }
        return null;
    }

    public static boolean isDialogFragment(Object obj) {
        FragmentCompat supportLibInstance = FragmentCompat.getSupportLibInstance();
        if (supportLibInstance != null && supportLibInstance.getDialogFragmentClass().isInstance(obj)) {
            return true;
        }
        FragmentCompat frameworkInstance = FragmentCompat.getFrameworkInstance();
        if (frameworkInstance != null && frameworkInstance.getDialogFragmentClass().isInstance(obj)) {
            return true;
        }
        return false;
    }

    private static Object findFragmentForViewInActivity(FragmentCompat fragmentCompat, Activity activity, View view) {
        Object fragmentManager = fragmentCompat.forFragmentActivity().getFragmentManager(activity);
        if (fragmentManager != null) {
            return findFragmentForViewInFragmentManager(fragmentCompat, fragmentManager, view);
        }
        return null;
    }
}
