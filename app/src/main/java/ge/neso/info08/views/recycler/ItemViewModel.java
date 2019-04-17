package ge.neso.info08.views.recycler;

/**
 * Created by mikhailmachablishvili on 01.06.18.
 */

import android.databinding.BaseObservable;


public abstract class ItemViewModel<ITEM_T> extends BaseObservable {

    public abstract void setItem(ITEM_T item);
}