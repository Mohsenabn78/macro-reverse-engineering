package com.obsez.android.lib.filechooser.permissions;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.obsez.android.lib.filechooser.permissions.PermissionsUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class PermissionActivity extends AppCompatActivity {
    public static final String INTENT_EXTRA_PERMISSIONS = "PERMISSIONS";
    public static final String INTENT_EXTRA_REQUEST_CODE = "REQUEST_CODE";
    public int _requestCode;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private PermissionsUtil.OnPermissionListener f36568c;

    /* renamed from: d  reason: collision with root package name */
    private List<String> f36569d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private List<String> f36570e = new ArrayList();

    private String[] h(List<String> list) {
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String[] stringArrayExtra = intent.getStringArrayExtra(INTENT_EXTRA_PERMISSIONS);
        if (stringArrayExtra.length == 0) {
            finish();
        }
        int intExtra = intent.getIntExtra(INTENT_EXTRA_REQUEST_CODE, -1);
        this._requestCode = intExtra;
        if (intExtra == -1) {
            finish();
        }
        this.f36568c = PermissionsUtil.a(this._requestCode);
        for (String str : stringArrayExtra) {
            if (str != null && !str.isEmpty()) {
                if (ContextCompat.checkSelfPermission(this, str) == 0) {
                    this.f36569d.add(str);
                } else {
                    this.f36570e.add(str);
                }
            } else {
                throw new RuntimeException("permission can't be null or empty");
            }
        }
        if (this.f36570e.isEmpty()) {
            if (!this.f36569d.isEmpty()) {
                PermissionsUtil.OnPermissionListener onPermissionListener = this.f36568c;
                if (onPermissionListener != null) {
                    onPermissionListener.onPermissionGranted(h(this.f36569d));
                }
                finish();
                return;
            }
            throw new RuntimeException("there are no permissions");
        }
        ActivityCompat.requestPermissions(this, h(this.f36570e), this._requestCode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            overridePendingTransition(0, 0);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i4, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i4 != this._requestCode) {
            finish();
        }
        this.f36570e.clear();
        for (int length = strArr.length - 1; length >= 0; length--) {
            if (iArr[length] == 0) {
                this.f36569d.add(strArr[length]);
            } else {
                this.f36570e.add(strArr[length]);
            }
        }
        if (this.f36570e.isEmpty()) {
            if (!this.f36569d.isEmpty()) {
                PermissionsUtil.OnPermissionListener onPermissionListener = this.f36568c;
                if (onPermissionListener != null) {
                    onPermissionListener.onPermissionGranted(h(this.f36569d));
                }
                finish();
                return;
            }
            throw new RuntimeException("there are no permissions");
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.f36570e) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, str)) {
                arrayList.add(str);
            }
        }
        PermissionsUtil.OnPermissionListener onPermissionListener2 = this.f36568c;
        if (onPermissionListener2 != null) {
            onPermissionListener2.onPermissionDenied(h(this.f36570e));
            this.f36568c.onShouldShowRequestPermissionRationale(h(arrayList));
        }
        finish();
    }
}
