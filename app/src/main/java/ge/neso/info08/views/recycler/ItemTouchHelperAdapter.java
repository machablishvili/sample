package ge.neso.info08.views.recycler;

/**
 * Created by mikhailmachablishvili on 01.06.18.
 */

public interface ItemTouchHelperAdapter {

    boolean onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}