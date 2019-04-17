package ge.neso.info08.views.recycler;

/**
 * Created by mikhailmachablishvili on 01.06.18.
 */


import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by flashin on 4/30/17.
 */

public abstract class RecyclerViewAdapter<ITEM_T, VIEW_MODEL_T extends ItemViewModel<ITEM_T>>
        extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder<ITEM_T, VIEW_MODEL_T>> implements ItemTouchHelperAdapter {

    protected final ArrayList<ITEM_T> items;
    private boolean allowSwipe = true;
    private boolean menuVisible = false;
    private ItemTouchHelper itemTouchHelper;
    private RecyclerView recyclerView;

    public RecyclerViewAdapter() {
        items = new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(ItemViewHolder<ITEM_T, VIEW_MODEL_T> holder, int position) {
        holder.setItem(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public static class ItemViewHolder<T, VT extends ItemViewModel<T>>
            extends RecyclerView.ViewHolder {

        protected final VT viewModel;
        private final ViewDataBinding binding;

        public ItemViewHolder(View itemView, ViewDataBinding binding, VT viewModel) {
            super(itemView);
            this.binding = binding;
            this.viewModel = viewModel;
        }

        void setItem(T item) {
            viewModel.setItem(item);
            binding.executePendingBindings();
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }

    public boolean isAllowSwipe() {
        return allowSwipe;
    }

    public void setAllowSwipe(boolean allowSwipe) {

        this.allowSwipe = allowSwipe;
        Log.d("allowSwipe", allowSwipe + "!");
    }

    public ItemTouchHelper getItemTouchHelper() {
        return itemTouchHelper;
    }

    public void setItemTouchHelper(ItemTouchHelper itemTouchHelper) {
        this.itemTouchHelper = itemTouchHelper;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    public void onItemDismiss(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {

        return true;
    }

    public boolean isMenuVisible() {
        return menuVisible;
    }

    public void setMenuVisible(boolean menuVisible) {
        this.menuVisible = menuVisible;
    }

    public void setItems(List<ITEM_T> items) {
        this.items.clear();
        addItems(items);
    }

    public void addItems(List<ITEM_T> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }
}