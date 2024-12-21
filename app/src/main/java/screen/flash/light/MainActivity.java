package screen.flash.light;

import screen.flash.light.HomeActivity;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.google.android.material.button.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mrudultora.colorpicker.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends AppCompatActivity {
	
	private FloatingActionButton _fab;
	private double id = 0;
	
	private ArrayList<HashMap<String, Object>> list = new ArrayList<>();
	
	private LinearLayout linear1;
	private MaterialButton materialbutton1;
	private MaterialButton materialbutton2;
	
	private Intent i = new Intent();
	private SharedPreferences setting;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_fab = findViewById(R.id._fab);
		linear1 = findViewById(R.id.linear1);
		materialbutton1 = findViewById(R.id.materialbutton1);
		materialbutton2 = findViewById(R.id.materialbutton2);
		setting = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		materialbutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_floatingaWindow();
				finishAffinity();
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FloatingWindowSetting.stopService(getApplicationContext());
				FloatingWindowSetting.startService(getApplicationContext(), new FloatingWindowSetting.OnDataReturnedListener() {
						@Override
						public void onDataReturned(String color, int brightness) {
								//Handle the returned data from the floating window
								if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
										Window w = MainActivity.this.getWindow();
										w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
										w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(Color.parseColor(color));
								}
								
								float brightnessValue = brightness / 100.0f;
								
								WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
								layoutParams.screenBrightness = brightnessValue;
								getWindow().setAttributes(layoutParams);
								
								linear1.setBackgroundColor(Color.parseColor(color));
								
								//MyToast.show(getApplicationContext(),"Success.....");
						}
				});
				
			}
		});
	}
	
	private void initializeLogic() {
		if (setting.getString("color", "").equals("")) {
			if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
				Window w =MainActivity.this.getWindow();
				w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFFFFFFFF);
			}
			linear1.setBackgroundColor(0xFFFFFFFF);
		} else {
			if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
				Window w =MainActivity.this.getWindow();
				w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(Color.parseColor(setting.getString("color", "")));
			}
			linear1.setBackgroundColor(Color.parseColor(setting.getString("color", "")));
		}
		_permission();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		_permission();
	}
	public void _permission() {
		materialbutton2.setEnabled(false);
		_fab.hide();
		if (!android.provider.Settings.canDrawOverlays(this)) {
				Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
				Uri.parse("package:" + getPackageName()));
				startActivityForResult(intent, 1000);
		} else if (!android.provider.Settings.System.canWrite(this)) {
				Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS);
				intent.setData(Uri.parse("package:" + getPackageName()));
				startActivityForResult(intent, 100);  // Request code 100
		}else{
				
			materialbutton2.setEnabled(true);
			_fab.show();
		}
	}
	
	
	public void _floatingaWindow() {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
				if (android.provider.Settings.canDrawOverlays(getApplicationContext())) {
						
						final int LAYOUT_FLAG = (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)? WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY :WindowManager.LayoutParams.TYPE_PHONE;
						final WindowManager.LayoutParams windowParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, LAYOUT_FLAG, WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH, PixelFormat.TRANSLUCENT);
						
						windowParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
						final  WindowManager _wm_it = (WindowManager) getSystemService(WINDOW_SERVICE);
						
						final WindowContentLayout _frame_main_it = new WindowContentLayout(getApplicationContext());
						_frame_main_it.setClipToOutline(true);
						_frame_main_it.setBackgroundColor(Color.TRANSPARENT);
						_frame_main_it.setOrientation(LinearLayout.VERTICAL);
						//_frame_main_it.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
						
						id++;
				windowParams.x = 100 * (int)id;
				windowParams.y = 100 * (int)id;
				
				final View _customView_it = LayoutInflater.from(MainActivity.this).inflate(R.layout.floating_light, null);
				_frame_main_it.addView(_customView_it);
				final ImageView imageview_setting = (ImageView) _customView_it.findViewById(R.id.imageview_setting);
				final ImageView imageview_bg_size = (ImageView) _customView_it.findViewById(R.id.imageview_bg_size);
				final LinearLayout linear_bg = (LinearLayout) _customView_it.findViewById(R.id.linear_bg);
				imageview_setting.getDrawable().setColorFilter((0xFFFFFFFF), PorterDuff.Mode.SRC_IN);
				imageview_bg_size.getDrawable().setColorFilter((0xFFFFFFFF), PorterDuff.Mode.SRC_IN);
				// Set a listener for resizing the window (if needed)
				imageview_bg_size.setOnTouchListener(new LegendaryTouchListener((LinearLayout) linear_bg, getApplicationContext()));
				
				// Set your desired minimum width & height
				LegendaryTouchListener.setMinWidth(200);
				LegendaryTouchListener.setMinHeight(120);
				
				
				if (setting.getString("color", "").equals("")) {
						linear_bg.setBackgroundColor(Color.parseColor("#FFFFFF"));
				}
				else {
						linear_bg.setBackgroundColor(Color.parseColor(setting.getString("color", "")));
				}
				linear_bg.setOnTouchListener(new OnTouchListener() {
						private int x;
						private int y;
						
						@Override
						public boolean onTouch(View v, MotionEvent event) {
								
								switch (event.getAction()) {
										case MotionEvent.ACTION_DOWN:
										x = (int) event.getRawX();
										y = (int) event.getRawY();
										break;
										case MotionEvent.ACTION_MOVE:
										int nowX = (int) event.getRawX();
										int nowY = (int) event.getRawY();
										int movedX = nowX - x;
										int movedY = nowY - y;
										x = nowX;
										y = nowY;
										windowParams.x = windowParams.x + movedX;
										windowParams.y = windowParams.y + movedY;
										_wm_it.updateViewLayout(_frame_main_it, windowParams);
										break;
										default:
										break;
								}
								return true;
						}
				});
				floatingWindowsMap.put((int)id, _frame_main_it);
				imageview_setting.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
								PopupMenu popup = new PopupMenu(getApplicationContext(), imageview_setting);
						Menu menu = popup.getMenu();
						menu.add("➕ New Window");
						menu.add("✖️ Remove");
						menu.add("✖️ All Remove ");
						menu.add("Full Screen");
						menu.add("Settings");
						popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
							@Override
							public boolean onMenuItemClick(MenuItem item){
								switch (item.getTitle().toString()){
									case "➕ New Window":
									_floatingaWindow();
									break;
									case "✖️ Remove":
									_wm_it.removeView(_frame_main_it);
									break;
									case "✖️ All Remove ":
									try {
										for (Map.Entry<Integer, View> entry : floatingWindowsMap.entrySet()) {
												View viewToRemove = entry.getValue();
												if (viewToRemove != null) {
														_wm_it.removeView(viewToRemove);
												}
										}
										floatingWindowsMap.clear();
										
									} catch (Exception e) {
										_wm_it.removeView(_frame_main_it);
									}
									break;
									case "Full Screen":
									for (Map.Entry<Integer, View> entry : floatingWindowsMap.entrySet()) {
											View viewToRemove = entry.getValue();
											if (viewToRemove != null) {
													_wm_it.removeView(viewToRemove);
											}
									}
									floatingWindowsMap.clear();
									
									i.setClass(getApplicationContext(), MainActivity.class);
									startActivity(i);
									finishAffinity();
									break;
									case "Settings":
									FloatingWindowSetting.stopService(getApplicationContext());
									FloatingWindowSetting.startService(getApplicationContext(), new FloatingWindowSetting.OnDataReturnedListener() {
											@Override
											public void onDataReturned(String color, int brightness) {
													
													float brightnessValue = brightness / 100.0f;
													
													WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) _frame_main_it.getLayoutParams();
													layoutParams.screenBrightness = brightnessValue;
													
													linear_bg.setBackgroundColor(Color.parseColor(color));
													// Apply the updated layout params to the floating window
													_wm_it.updateViewLayout(_frame_main_it, layoutParams);
													
												
											SketchwareUtil.showMessage(getApplicationContext(), "Success...");
										}
									});
									
									break;
								}
								return true;
							}
						});
						popup.show();
						}
				});
						
						_frame_main_it.setFocusListener(new FocusListener(){
								boolean keyboardEnabled = false;
								@Override public void onFocusChanged(boolean b){
										if(keyboardEnabled == b )return;
										keyboardEnabled = b;
										if(b){
												windowParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL|WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
										}else{
												windowParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
										}
										_wm_it.updateViewLayout(_frame_main_it, windowParams);
								}
						});
						_wm_it.addView(_frame_main_it, windowParams);
				} else {
						startActivity( new Intent(android.provider.Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName())));
				}
		}
	}
	
	
	public void _extra() {
	}
	private Map<Integer, View> floatingWindowsMap = new HashMap<>();  // Map to track floating windows by ID
	
	public interface FocusListener {
			public void onFocusChanged(boolean val);
	}
	public class WindowContentLayout extends LinearLayout {
			private FocusListener focusListener;
			public WindowContentLayout(Context context) {
					super(context);
			}
			public void setFocusListener(FocusListener l){
					this.focusListener=l;
			}
			@Override
			public boolean onInterceptTouchEvent(MotionEvent event){
					int e = event.getAction();
					if(e == MotionEvent.ACTION_DOWN)focusListener.onFocusChanged(true);
					if(e == MotionEvent.ACTION_OUTSIDE)focusListener.onFocusChanged(false);
					return super.onInterceptTouchEvent(event);
					
			}
			
			@Override
			public boolean onTouchEvent(MotionEvent event){
					int e = event.getAction();
					if(e == MotionEvent.ACTION_DOWN)focusListener.onFocusChanged(true);
					if(e == MotionEvent.ACTION_OUTSIDE)focusListener.onFocusChanged(false);
					return super.onTouchEvent(event);
			}
	}
	
	{
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}