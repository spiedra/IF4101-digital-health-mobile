// Generated by view binder compiler. Do not edit!
package com.randalljuan.proyecto3_mobile_b95212_b97452.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.randalljuan.proyecto3_mobile_b95212_b97452.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class ActivityGestionBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  private ActivityGestionBinding(@NonNull ConstraintLayout rootView) {
    this.rootView = rootView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityGestionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityGestionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_gestion, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityGestionBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    return new ActivityGestionBinding((ConstraintLayout) rootView);
  }
}
