package com.lucasbais.tinyandroidapp.ui.base;

import android.content.Context;
import android.support.v4.app.Fragment;

import butterknife.Unbinder;

/**
 * Created by zehemz on 18/01/2017.
 */

public abstract class BaseFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    protected Unbinder unbinder;

    public interface OnFragmentInteractionListener {
        void onFragmentAttached();
        void onFragmentDetached();
    }

    private void attachListener(Context context) {
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        attachListener(context);
        mListener.onFragmentAttached();
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener.onFragmentDetached();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(unbinder!=null)
            unbinder.unbind();
    }
}
