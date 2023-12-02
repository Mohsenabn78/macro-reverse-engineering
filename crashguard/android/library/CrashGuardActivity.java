package crashguard.android.library;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

/* loaded from: classes6.dex */
public class CrashGuardActivity extends AppCompatActivity {
    private static String i(ApplicationInfo applicationInfo, PackageManager packageManager) {
        CharSequence loadLabel = applicationInfo.loadLabel(packageManager);
        if (loadLabel != null) {
            String trim = loadLabel.toString().trim();
            if (trim.length() > 0) {
                return trim;
            }
        }
        String str = applicationInfo.name;
        if (str != null) {
            String trim2 = str.trim();
            if (trim2.length() > 0) {
                return trim2;
            }
        }
        String str2 = applicationInfo.packageName;
        String[] split = str2.split("\\\\.");
        if (split.length > 1) {
            return split[split.length - 1].trim();
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        finishAffinity();
    }

    private void k(Button button) {
        button.setOnClickListener(new View.OnClickListener() { // from class: crashguard.android.library.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CrashGuardActivity.this.j(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_crash_guard);
        CrashGuard crashGuard = CrashGuard.getInstance(getApplicationContext());
        String e4 = crashGuard.e();
        TextView textView = (TextView) findViewById(R.id.crashguard_title);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        if (e4 == null) {
            textView.setText(i(getApplicationInfo(), getPackageManager()));
        } else {
            textView.setText(e4);
        }
        int a4 = crashGuard.a();
        ImageView imageView = (ImageView) findViewById(R.id.crashguard_image);
        try {
            Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), a4);
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
            }
        } catch (Throwable unused) {
            imageView.setVisibility(8);
        }
        String b4 = crashGuard.b();
        TextView textView2 = (TextView) findViewById(R.id.crashguard_text);
        if (b4 == null) {
            textView2.setText(getString(R.string.crashguard_text, i(getApplicationInfo(), getPackageManager())));
        } else {
            textView2.setText(b4);
        }
        k((Button) findViewById(R.id.crashguard_ok_button));
    }
}
