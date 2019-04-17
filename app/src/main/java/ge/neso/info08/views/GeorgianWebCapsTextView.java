package ge.neso.info08.views;

import android.support.v7.widget.AppCompatTextView;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by mikhailmachablishvili on 23.05.18.
 */

public class GeorgianWebCapsTextView extends AppCompatTextView {

    public GeorgianWebCapsTextView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public GeorgianWebCapsTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public GeorgianWebCapsTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {

        setTypeface(Typeface.createFromAsset(context.getAssets(),
                "fonts/bpg_web_001.ttf"));
    }
}
