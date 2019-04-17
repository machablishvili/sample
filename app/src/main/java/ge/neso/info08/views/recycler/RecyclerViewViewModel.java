package ge.neso.info08.views.recycler;

/**
 * Created by mikhailmachablishvili on 01.06.18.
 */


import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.databinding.BaseObservable;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;


/**
 * Created by flashin on 4/30/17.
 */

public abstract class RecyclerViewViewModel extends BaseObservable {

    RecyclerView.LayoutManager layoutManager;

    protected abstract RecyclerViewAdapter getAdapter();

    protected abstract RecyclerView.LayoutManager createLayoutManager();

    protected RecyclerView recyclerView;

    // page number for continous scrolling
    protected int currentPage = 1;
    private int tmpItemPosition = -1;
    private int selectedItemPosition = -1;
    private RecyclerView.OnItemTouchListener onItemTouchListner;
    private View bottomLayer;

    /**
     * interface for swiping event
     */
    public interface OnSwipeEvent {

        public void onSwipe(int position);
    }

    public final void setupRecyclerView(RecyclerView recyclerView) {
        layoutManager = createLayoutManager();
        recyclerView.setAdapter(getAdapter());
        recyclerView.setLayoutManager(layoutManager);
        this.recyclerView = recyclerView;

        if (getAdapter().getItemTouchHelper() != null) {
            getAdapter().getItemTouchHelper().attachToRecyclerView(recyclerView);
        }
    }

    private void disableScrolling() {

        Log.d("scroll", "disabled");
        onItemTouchListner = new RecyclerView.SimpleOnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                // Stop only scrolling.
                Log.d("scroll dis", rv.getScrollState() + "!");
                return rv.getScrollState() == RecyclerView.SCROLL_STATE_DRAGGING || rv.getScrollState() == RecyclerView.SCROLL_STATE_IDLE;
            }
        };
        recyclerView.addOnItemTouchListener(onItemTouchListner);
    }

    /**
     * sets continuous scrolling for the recyclerview
     *
     * @param handler
     */
    public void setContinuesScrolling(final ContinuousScrollingListener handler) {

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            private int previousTotal = 0; // The total number of items in the dataset after the last load
            private boolean loading = true; // True if we are still waiting for the last set of data to load.
            private int visibleThreshold = 1; // The minimum amount of items to have below your current scroll position before loading more.
            private int firstVisibleItem, visibleItemCount, totalItemCount;
            private RecyclerView.LayoutManager myManager = recyclerView.getLayoutManager();

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                visibleItemCount = recyclerView.getChildCount();

                totalItemCount = myManager.getItemCount();
                if (myManager instanceof LinearLayoutManager) {
                    firstVisibleItem = ((LinearLayoutManager) myManager).findFirstVisibleItemPosition();
                } else if (myManager instanceof GridLayoutManager) {
                    firstVisibleItem = ((GridLayoutManager) myManager).findFirstVisibleItemPosition();
                }

                if (loading) {
                    if (totalItemCount > previousTotal) {
                        loading = false;
                        previousTotal = totalItemCount;
                    }
                }
                if (!loading && (totalItemCount - visibleItemCount)
                        <= (firstVisibleItem + visibleThreshold)) {
                    // End has been reached

                    // Do something
                    currentPage++;

                    if (handler != null) {
                        handler.onLoadMore(currentPage);
                    }

                    loading = true;
                }
            }
        });
    }

    /**
     * interface to load more data
     */
    public interface ContinuousScrollingListener {

        public void onLoadMore(int currentPage);
    }
}