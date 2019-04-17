package ge.neso.info08.views.recycler;

/**
 * Created by mikhailmachablishvili on 01.06.18.
 */


import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

public class ViewModelBindings {

    @BindingAdapter("recyclerViewViewModel")
    public static void setRecyclerViewViewModel(RecyclerView recyclerView,
                                                RecyclerViewViewModel viewModel) {
        viewModel.setupRecyclerView(recyclerView);
    }
}
