package screen.flash.light;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.appbar.AppBarLayout;
import com.mrudultora.colorpicker.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class HomeActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private DrawerLayout _drawer;
	private double id = 0;
	private double number = 0;
	
	private LinearLayout linear1;
	private LinearLayout linear3;
	private CardView cardview3;
	private CardView cardview1;
	private CardView cardview2;
	private LinearLayout linear2;
	private ImageView imageview1;
	private TextView textview1;
	private LinearLayout linear4;
	private ImageView imageview2;
	private TextView textview2;
	private LinearLayout linear5;
	private ImageView imageview3;
	private TextView textview3;
	private LinearLayout _drawer_linear1;
	private LinearLayout _drawer_linear2;
	private LinearLayout _drawer_linear3;
	private LinearLayout _drawer_linear4;
	private ImageView _drawer_imageview1;
	private TextView _drawer_textview1;
	private TextView _drawer_textview2;
	private LinearLayout _drawer_linear_1;
	private LinearLayout _drawer_linear_2;
	private LinearLayout _drawer_linear_3;
	private LinearLayout _drawer_linear_line;
	private TextView _drawer_textview6;
	private LinearLayout _drawer_linear_4;
	private LinearLayout _drawer_linear_5;
	private LinearLayout _drawer_linear_6;
	private ImageView _drawer_imageview2;
	private TextView _drawer_textview3;
	private ImageView _drawer_imageview3;
	private TextView _drawer_textview4;
	private ImageView _drawer_imageview4;
	private TextView _drawer_textview5;
	private ImageView _drawer_imageview5;
	private TextView _drawer_textview7;
	private ImageView _drawer_imageview6;
	private TextView _drawer_textview8;
	private ImageView _drawer_imageview7;
	private TextView _drawer_textview9;
	
	private Intent intent = new Intent();
	private SharedPreferences setting;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(HomeActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		linear1 = findViewById(R.id.linear1);
		linear3 = findViewById(R.id.linear3);
		cardview3 = findViewById(R.id.cardview3);
		cardview1 = findViewById(R.id.cardview1);
		cardview2 = findViewById(R.id.cardview2);
		linear2 = findViewById(R.id.linear2);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		linear4 = findViewById(R.id.linear4);
		imageview2 = findViewById(R.id.imageview2);
		textview2 = findViewById(R.id.textview2);
		linear5 = findViewById(R.id.linear5);
		imageview3 = findViewById(R.id.imageview3);
		textview3 = findViewById(R.id.textview3);
		_drawer_linear1 = _nav_view.findViewById(R.id.linear1);
		_drawer_linear2 = _nav_view.findViewById(R.id.linear2);
		_drawer_linear3 = _nav_view.findViewById(R.id.linear3);
		_drawer_linear4 = _nav_view.findViewById(R.id.linear4);
		_drawer_imageview1 = _nav_view.findViewById(R.id.imageview1);
		_drawer_textview1 = _nav_view.findViewById(R.id.textview1);
		_drawer_textview2 = _nav_view.findViewById(R.id.textview2);
		_drawer_linear_1 = _nav_view.findViewById(R.id.linear_1);
		_drawer_linear_2 = _nav_view.findViewById(R.id.linear_2);
		_drawer_linear_3 = _nav_view.findViewById(R.id.linear_3);
		_drawer_linear_line = _nav_view.findViewById(R.id.linear_line);
		_drawer_textview6 = _nav_view.findViewById(R.id.textview6);
		_drawer_linear_4 = _nav_view.findViewById(R.id.linear_4);
		_drawer_linear_5 = _nav_view.findViewById(R.id.linear_5);
		_drawer_linear_6 = _nav_view.findViewById(R.id.linear_6);
		_drawer_imageview2 = _nav_view.findViewById(R.id.imageview2);
		_drawer_textview3 = _nav_view.findViewById(R.id.textview3);
		_drawer_imageview3 = _nav_view.findViewById(R.id.imageview3);
		_drawer_textview4 = _nav_view.findViewById(R.id.textview4);
		_drawer_imageview4 = _nav_view.findViewById(R.id.imageview4);
		_drawer_textview5 = _nav_view.findViewById(R.id.textview5);
		_drawer_imageview5 = _nav_view.findViewById(R.id.imageview5);
		_drawer_textview7 = _nav_view.findViewById(R.id.textview7);
		_drawer_imageview6 = _nav_view.findViewById(R.id.imageview6);
		_drawer_textview8 = _nav_view.findViewById(R.id.textview8);
		_drawer_imageview7 = _nav_view.findViewById(R.id.imageview7);
		_drawer_textview9 = _nav_view.findViewById(R.id.textview9);
		setting = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		linear2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), MainActivity.class);
				startActivity(intent);
			}
		});
		
		linear4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try {
					_permission();
					_floatingaWindow();
				} catch (Exception e) {
					 
				}
			}
		});
		
		linear5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (getPackageManager().hasSystemFeature(android.content.pm.PackageManager.FEATURE_CAMERA_FLASH)) {
					if(number == 0){
							android.hardware.camera2.CameraManager cameraManager = (android.hardware.camera2.CameraManager) getSystemService(Context.CAMERA_SERVICE);
						try {
								String cameraId = cameraManager.getCameraIdList()[0];
								cameraManager.setTorchMode(cameraId, true);
								textview3.setText("Flash Light OFF");
							imageview3.setImageResource(R.drawable.ic_flash_on_black);
						} catch (android.hardware.camera2.CameraAccessException e) {
								 
						}
						
							number = 1;
					} else {
							android.hardware.camera2.CameraManager cameraManager = (android.hardware.camera2.CameraManager) getSystemService(Context.CAMERA_SERVICE);
						try {
								String cameraId = cameraManager.getCameraIdList()[0];
								cameraManager.setTorchMode(cameraId, false);
								textview3.setText("Flash Light ON");
							imageview3.setImageResource(R.drawable.ic_flash_off_black);
						} catch (android.hardware.camera2.CameraAccessException e) {
								textview3.setText("Flash Light ON");
							imageview3.setImageResource(R.drawable.ic_flash_off_black);
						}
						
							number = 0;
					}
				} else {
					textview3.setText("Flash Light not available this device.");
					imageview3.setImageResource(R.drawable.ic_flash_off_black);
				}
			}
		});
		
		_drawer_linear_1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		_drawer_linear_2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		_drawer_linear_3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		_drawer_linear_4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		_drawer_linear_5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		_drawer_linear_6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
	}
	
	private void initializeLogic() {
		_permission();
		_DrawerUi();
	}
	
	@Override
	public void onBackPressed() {
		if (_drawer.isDrawerOpen(GravityCompat.START)) {
			_drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}
	public void _DrawerUi() {
		LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view);  androidx.drawerlayout.widget.DrawerLayout .LayoutParams params = (androidx.drawerlayout.widget.DrawerLayout .LayoutParams)_nav_view.getLayoutParams();  params.width = (int)getDip((int)300);  params.height = androidx.drawerlayout.widget.DrawerLayout .LayoutParams.MATCH_PARENT;  _nav_view.setLayoutParams(params);
		 _nav_view.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
		{
			android.graphics.drawable.GradientDrawable iT = new android.graphics.drawable.GradientDrawable();
			iT.setColor(0xFF8569AC);
			float lt = getDip((int)0);
			float rt = getDip((int)20);
			float rb = getDip((int)20);
			float lb = getDip ((int)0);
			iT.setCornerRadii(new float[]{lt,lt,rt ,rt,rb,rb ,lb,lb });
			
			iT.setStroke((int)0,(int)Color.TRANSPARENT);
			_drawer_linear1.setElevation((int)0);
			_drawer_linear1.setBackground(iT);
		}
		{
			android.graphics.drawable.GradientDrawable iT = new android.graphics.drawable.GradientDrawable();
			iT.setColor(0xFFF3E5F5);
			float lt = getDip((int)0);
			float rt = getDip((int)20);
			float rb = getDip((int)0);
			float lb = getDip ((int)0);
			iT.setCornerRadii(new float[]{lt,lt,rt ,rt,rb,rb ,lb,lb });
			
			iT.setStroke((int)0,(int)Color.TRANSPARENT);
			_drawer_linear3.setElevation((int)0);
			_drawer_linear3.setBackground(iT);
		}
		{
			android.graphics.drawable.GradientDrawable iT = new android.graphics.drawable.GradientDrawable();
			iT.setColor(0xFFF3E5F5);
			iT.setCornerRadius((int)20);
			iT.setStroke((int)0,(int)Color.TRANSPARENT);
			_drawer_linear_1.setElevation((int)0);
			
			android.content.res.ColorStateList iT1 = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFF3E5F5});
			android.graphics.drawable.RippleDrawable IndianTeam = new android.graphics.drawable.RippleDrawable(iT1,iT, null);
			_drawer_linear_1.setClickable(true);
			_drawer_linear_1.setBackground(IndianTeam);
		}
	}
	
	
	public void _permission() {
		if (!android.provider.Settings.canDrawOverlays(this)) {
				Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
				Uri.parse("package:" + getPackageName()));
				startActivityForResult(intent, 1000);
		} else if (!android.provider.Settings.System.canWrite(this)) {
				Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_WRITE_SETTINGS);
				intent.setData(Uri.parse("package:" + getPackageName()));
				startActivityForResult(intent, 100);  // Request code 100
		}else{
				
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
				
				final View _customView_it = LayoutInflater.from(HomeActivity.this).inflate(R.layout.floating_light, null);
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
									
									intent.setClass(getApplicationContext(), MainActivity.class);
									startActivity(intent);
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