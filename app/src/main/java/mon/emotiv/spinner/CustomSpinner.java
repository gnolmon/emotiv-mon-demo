package mon.emotiv.spinner;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Spinner;


    public class CustomSpinner extends Spinner {

    public CustomSpinner(Context context) {
        super(context);
    }

    public CustomSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomSpinner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    public void setSelection(int position) {
        boolean sameSelected = position == getSelectedItemPosition();
        super.setSelection(position);
        if (sameSelected) {
            if (this.getOnItemSelectedListener() != null)
                getOnItemSelectedListener().onItemSelected(null, null, position, 0);
        }
    }

    @Override
    public void
    setSelection(int position, boolean animate) {
        boolean sameSelected = position == getSelectedItemPosition();

        super.setSelection(position, animate);
        if (sameSelected) {
            getOnItemSelectedListener().onItemSelected(this, getSelectedView(), position, getSelectedItemId());
        }
    }
}
