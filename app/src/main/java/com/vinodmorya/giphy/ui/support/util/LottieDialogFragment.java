package com.vinodmorya.giphy.ui.support.util;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;

import com.airbnb.lottie.LottieAnimationView;
import com.vinodmorya.giphy.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class LottieDialogFragment extends DialogFragment
  {

	 private LottieProgressDialog progressDialog;


	 public LottieDialogFragment newInstance(String jsonFileName, boolean isLoopEnabled)
		{

		  LottieDialogFragment fragment = new LottieDialogFragment();

		  Bundle args = new Bundle();
		  args.putString("jsonFileName", jsonFileName);
		  args.putBoolean("isLoopEnabled", isLoopEnabled);
		  fragment.setArguments(args);
		  return fragment;
		}

	 @Override
	 public void onCreate(Bundle savedInstanceState)
		{
		  super.onCreate(savedInstanceState);

		  String jsonFileName = getArguments().getString("jsonFileName");
		  boolean isLoopEnabled = getArguments().getBoolean("isLoopEnabled");

		  if(jsonFileName == null)
		  {
			 jsonFileName = "spinner_loading.json";
		  }
		  progressDialog = new LottieProgressDialog(getActivity());
		  progressDialog.setJsonFileName(jsonFileName);
		  progressDialog.setLoop(isLoopEnabled);
		}

	 @Override
	 public Dialog onCreateDialog(@NonNull Bundle savedInstanceState)
		{
		  return progressDialog;
		}

	 private class LottieProgressDialog extends AlertDialog
		{
		  private LottieAnimationView lavProgress;
		  private String jsonFileName;
		  private boolean loop = true;

		  private LottieProgressDialog(Context context)
			 {
				super(context);
			 }

		  @Override
		  protected void onCreate(Bundle savedInstanceState)
			 {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.dialog_lottie);

				Window currentWindow = this.getWindow();

				if(currentWindow != null)
				{
				  currentWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
				}

				lavProgress = findViewById(R.id.lavProgress);

				lavProgress.setAnimation(jsonFileName);
				lavProgress.setRepeatCount(ValueAnimator.INFINITE);
				lavProgress.playAnimation();
			 }

		  @Override
		  public void dismiss()
			 {
				if(lavProgress != null)
				{
				  lavProgress.cancelAnimation();
				}
				super.dismiss();
			 }

		  private void setJsonFileName(String jsonFileName)
			 {
				this.jsonFileName = jsonFileName;
			 }

		  private void setLoop(boolean loop)
			 {
				this.loop = loop;
			 }
		}
  }