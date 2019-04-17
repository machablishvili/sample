package ge.neso.info08.vm;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.databinding.library.baseAdapters.BR;

import ge.neso.info08.activities.BillboardActivity;
import ge.neso.info08.activities.CalendarActivity;
import ge.neso.info08.activities.CitiesActivity;
import ge.neso.info08.activities.ExchangeActivity;
import ge.neso.info08.activities.OrganizationsActivity;
import ge.neso.info08.activities.RegisterActivity;
import ge.neso.info08.activities.SalesActivity;
import ge.neso.info08.activities.StreetsActivity;
import ge.neso.info08.activities.TransportationActivity;
import ge.neso.info08.activities.WeatherActivity;
import ge.neso.info08.auth.Auth;
import ge.neso.info08.databinding.ActivityTemplateBinding;

/**
 * Created by mikhailmachablishvili on 21.05.18.
 */

public class TemplateViewModel extends BaseObservable {

    private static final String TAG = "TemplateViewModel";

    protected Context context;
    private ActivityTemplateBinding binding;
    private boolean showMenu = true;
    private boolean showSpinner = false;
    private boolean showExtraMenu = false;
    private boolean showTopHeader = true;

    public TemplateViewModel(Context cnxt) {
        context = cnxt;
    }

    public void setBinding(ActivityTemplateBinding binding) {
        this.binding = binding;
    }

    public void setContainerContent(View view) {

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        binding.container.addView(view, lp);
    }

    public boolean isShowMenu() {
        return showMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    @Bindable
    public boolean isShowSpinner() {
        return showSpinner;
    }

    public void setShowSpinner(boolean showSpinner) {
        this.showSpinner = showSpinner;
        notifyPropertyChanged(BR.showSpinner);
    }

    @Bindable
    public boolean isShowTopHeader() {
        return showTopHeader;
    }

    public void setShowTopHeader(boolean showTopHeader) {
        this.showTopHeader = showTopHeader;
        notifyPropertyChanged(BR.showTopHeader);
    }

    @Bindable
    public boolean isShowExtraMenu() {
        return showExtraMenu;
    }

    public void setShowExtraMenu(boolean showExtraMenu) {
        this.showExtraMenu = showExtraMenu;
        notifyPropertyChanged(BR.showExtraMenu);
    }

    @Bindable
    public boolean isMenuVisible() {
        return Auth.getInstance().isLoggedIn() && showMenu;
    }


    public View.OnClickListener getExtraMenuClickEvent() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setShowExtraMenu(true);

                Log.d(TAG, "extraMenuClickEvent" + showExtraMenu);

            }
        };
    }

    public View.OnClickListener getGreyAreaClickEvent() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "greyAreaClickEvent");

                setShowExtraMenu(false);
            }
        };
    }

    public View.OnClickListener registerClickEvent() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "registerClickEvent");

                Intent intent = new Intent(context, RegisterActivity.class);
                context.startActivity(intent);
            }
        };
    }

    public View.OnClickListener salesClickEvent() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "SalesClickEvent");

                Intent intent = new Intent(context, SalesActivity.class);
                context.startActivity(intent);
            }
        };
    }

    public View.OnClickListener organizationsClickEvent() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "organizationsClickEvent");

                Intent intent = new Intent(context, OrganizationsActivity.class);
                context.startActivity(intent);
            }
        };
    }

    public View.OnClickListener calendarClickEvent() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "calendarClickEvent");

                Intent intent = new Intent(context, CalendarActivity.class);
                context.startActivity(intent);
            }
        };
    }

    public View.OnClickListener transportationClickEvent() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "transportationClickEvent");

                Intent intent = new Intent(context, TransportationActivity.class);
                context.startActivity(intent);
            }
        };
    }

    public View.OnClickListener streetsClickEvent() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "streetsClickEvent");

                Intent intent = new Intent(context, StreetsActivity.class);
                context.startActivity(intent);
            }
        };
    }

    public View.OnClickListener billboardClickEvent() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "billboardClickEvent");

                Intent intent = new Intent(context, BillboardActivity.class);
                context.startActivity(intent);
            }
        };
    }

    public View.OnClickListener exchangeClickEvent() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "exchangeClickEvent");

                Intent intent = new Intent(context, ExchangeActivity.class);
                context.startActivity(intent);
            }
        };
    }

    public View.OnClickListener weatherClickEvent() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "weatherClickEvent");

                Intent intent = new Intent(context, WeatherActivity.class);
                context.startActivity(intent);
            }
        };
    }

    public View.OnClickListener citiesClickEvent() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "citiesClickEvent");

                Intent intent = new Intent(context, CitiesActivity.class);
                context.startActivity(intent);
            }
        };
    }
}
