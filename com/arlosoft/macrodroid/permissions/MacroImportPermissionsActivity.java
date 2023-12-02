package com.arlosoft.macrodroid.permissions;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class MacroImportPermissionsActivity extends AppCompatActivity {
    public static final String EXTRA_CHECK_IMPORT_PERMISSIONS = "check_import_permissions";

    /* renamed from: c  reason: collision with root package name */
    private boolean f13038c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f13039d;

    private void h() {
        List<Macro> allCompletedMacros = MacroStore.getInstance().getAllCompletedMacros();
        if (!this.f13038c) {
            List<String> i4 = i(allCompletedMacros);
            if (i4.size() > 0) {
                ActivityCompat.requestPermissions(this, (String[]) i4.toArray(new String[0]), 0);
                return;
            }
            this.f13038c = true;
            if (!this.f13039d) {
                j(allCompletedMacros);
            }
        } else if (!this.f13039d) {
            j(allCompletedMacros);
        }
    }

    private List<String> i(List<Macro> list) {
        String[] requiredPermissions;
        ArrayList arrayList = new ArrayList();
        for (Macro macro : list) {
            if (this.f13039d) {
                requiredPermissions = macro.getRequiredPermissionsOnImport();
            } else {
                requiredPermissions = macro.getRequiredPermissions();
            }
            for (String str : requiredPermissions) {
                if (!arrayList.contains(str) && ContextCompat.checkSelfPermission(this, str) != 0) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    private void j(List<Macro> list) {
        for (Macro macro : list) {
            Iterator<Trigger> it = macro.getTriggerList().iterator();
            while (it.hasNext()) {
                if (!PermissionsHelper.checkForSpecialPermissions(this, it.next(), true, true)) {
                    return;
                }
            }
            Iterator<Action> it2 = macro.getActions().iterator();
            while (it2.hasNext()) {
                Action next = it2.next();
                if (!PermissionsHelper.checkForSpecialPermissions(this, next, true, true)) {
                    return;
                }
                for (Constraint constraint : next.getConstraints()) {
                    if (!PermissionsHelper.checkForSpecialPermissions(this, constraint, true, true)) {
                        return;
                    }
                }
            }
            for (Constraint constraint2 : macro.getConstraints()) {
                if (!PermissionsHelper.checkForSpecialPermissions(this, constraint2, true, true)) {
                    return;
                }
            }
        }
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f13039d = getIntent().getBooleanExtra(EXTRA_CHECK_IMPORT_PERMISSIONS, false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (Settings.getMacroDroidEnabled(this)) {
            Macro.setMacroDroidEnabledState(false);
            MacroStore.getInstance().updateEnabledStateOfAllCompletedMacros();
            Macro.setMacroDroidEnabledState(true);
            MacroStore.getInstance().updateEnabledStateOfAllCompletedMacros();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i4, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i4 != 0) {
            super.onRequestPermissionsResult(i4, strArr, iArr);
            return;
        }
        boolean z3 = true;
        if (this.f13039d) {
            int length = iArr.length;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    break;
                } else if (iArr[i6] != 0) {
                    z3 = false;
                    break;
                } else {
                    i6++;
                }
            }
            if (z3) {
                i5 = -1;
            }
            setResult(i5);
            finish();
            return;
        }
        this.f13038c = true;
        j(MacroStore.getInstance().getAllCompletedMacros());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        h();
    }
}
