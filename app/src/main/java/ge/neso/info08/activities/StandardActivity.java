package ge.neso.info08.activities;

import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.util.HashMap;
import java.util.Map;

import ge.neso.info08.R;
import ge.neso.info08.conn.MyServerParams;
import ge.neso.info08.conn.ResponseHandler;
import ge.neso.info08.conn.ServerConnection;
import ge.neso.info08.databinding.ActivityTemplateBinding;
import ge.neso.info08.vm.TemplateViewModel;

abstract public class StandardActivity extends AppCompatActivity {

    protected TemplateViewModel vm;
    private ActivityTemplateBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adjustFontScale(getResources().getConfiguration());

        binding = DataBindingUtil.setContentView(this, R.layout.activity_template);
        vm.setBinding(binding);
        binding.setData(vm);
    }

    private void handleRegSuccess() {

        // handle success things
    }

    public TemplateViewModel getVm() {
        return vm;
    }

    // Roll back to default font scale as per design large font scale doesn't fit
    public void adjustFontScale(Configuration configuration) {
        configuration.fontScale = (float) 1.0;
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        metrics.scaledDensity = configuration.fontScale * metrics.density;
        getBaseContext().getResources().updateConfiguration(configuration, metrics);
    }
}
