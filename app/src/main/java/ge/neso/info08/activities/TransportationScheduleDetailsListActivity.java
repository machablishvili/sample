package ge.neso.info08.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import ge.neso.info08.R;
import ge.neso.info08.databinding.ContentTransportationScheduleDetailsListBinding;
import ge.neso.info08.vm.TransportationScheduleDetailsListViewModel;

public class TransportationScheduleDetailsListActivity extends StandardActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ContentTransportationScheduleDetailsListBinding binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.content_transportation_schedule_details_list, null, false);
        vm = new TransportationScheduleDetailsListViewModel(this, binding);
        super.onCreate(savedInstanceState);

        vm.setContainerContent(binding.getRoot());
        binding.setData((TransportationScheduleDetailsListViewModel) vm);


        String scheduleId = getIntent().getStringExtra("clickedScheduleId");
        String scTitle = getIntent().getStringExtra("screenTitle");

        if (scheduleId != null) {
            ((TransportationScheduleDetailsListViewModel) vm).loadTransportScheduleDetails(scheduleId);
        }

        if (scTitle != null) {
            ((TransportationScheduleDetailsListViewModel) vm).setScreenTitle(scTitle);
        }


    }


}

