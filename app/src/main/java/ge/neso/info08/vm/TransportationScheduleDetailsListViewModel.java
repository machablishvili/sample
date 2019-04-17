package ge.neso.info08.vm;

import android.content.Context;
import android.content.Intent;
import android.databinding.Bindable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import ge.neso.info08.activities.TransportMapActivity;
import ge.neso.info08.adapters.TransportScheduleDetailsItemAdapter;
import ge.neso.info08.databinding.ContentTransportationScheduleDetailsListBinding;
import ge.neso.info08.managers.TransportationManager;
import ge.neso.info08.models.TransportScheduleDetailsItem;

public class TransportationScheduleDetailsListViewModel extends TemplateViewModel {

    private ContentTransportationScheduleDetailsListBinding binding;
    private TransportScheduleDetailsItemAdapter adapter;
    private Context context;
    private String screenTitle;
    private static final String TAG = "TransSchedDetailListVM";
    private TransportScheduleDetailsItem scheduleItem;

    public TransportationScheduleDetailsListViewModel(Context cnxt, ContentTransportationScheduleDetailsListBinding binding) {
        super(cnxt);
        this.binding = binding;
        this.context = cnxt;

        setShowTopHeader(false);

        adapter = new TransportScheduleDetailsItemAdapter(context);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);

        binding.transportScheduleDetailsListRecycler.setAdapter(adapter);
        binding.transportScheduleDetailsListRecycler.setLayoutManager(linearLayoutManager);
    }

    public TransportScheduleDetailsItem getScheduleItem() {
        return scheduleItem;
    }

    public void setScheduleItem(TransportScheduleDetailsItem scheduleItem) {
        this.scheduleItem = scheduleItem;
    }

    @Bindable
    public String getScreenTitle() {
        return screenTitle;
    }

    public void setScreenTitle(String screenTitle) {
        this.screenTitle = screenTitle;
        notifyChange();
    }


    public void loadTransportScheduleDetails(String id) {

        String url = "transport/transports/schedule/" + id;


        // vm.setShowSpinner(true);
        TransportationManager.getTransportScheduleDetails(context, url, new TransportationManager.TransportScheduleDetailsHandler() {
            @Override
            public void onSuccess(TransportScheduleDetailsItem item) {
                // vm.setShowSpinner(false);
                adapter.setItems(item.getSchedule());
                setScheduleItem(item);
            }

            @Override
            public void onError(int errorCode) {
                //vm.setShowSpinner(false);
                MyAlert.alertSuccessWin(context, "Error", "No Transport Schedule Detail Items");

            }
        });
    }


    public View.OnClickListener TransportMapClickEvent() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "TransportMapClickEvent");

                TransportScheduleDetailsItem detailsItem = getScheduleItem();

                Intent intent = new Intent(context, TransportMapActivity.class);

                if (detailsItem != null) {
                    intent.putExtra("scheduleItem", TransportScheduleDetailsItem.fromJson(detailsItem));
                }

                context.startActivity(intent);
            }
        };
    }
}
