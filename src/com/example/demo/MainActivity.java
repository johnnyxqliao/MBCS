package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final String TAG = "This is a wrong";
    private static final boolean D = true;
    private BluetoothAdapter mBluetoothAdapter = null;
    private BluetoothSocket btSocket = null;
    private OutputStream outStream = null;
    private List<String> msgList=new ArrayList<String>();  
    private ArrayAdapter<String> mAdapter;
    private ListView mListView; 
    private readThread mreadThread = null;
    private TextView textview=null;
    Context mContext;
    Button mButtonF;
    Button mButtonB;
    Button mButtonL;
    Button mButtonR;
    Button mButtonS;
    
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static String address = "98:D3:35:70:F0:B9";
    /** Called when the activity is first created. */
	@SuppressLint({ "ClickableViewAccessibility", "ShowToast" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    
//ǰ��
	    
						mButtonF=(Button)findViewById(R.id.btnF);
		                mButtonF.setOnTouchListener(new Button.OnTouchListener(){
			@SuppressLint("ClickableViewAccessibility")
			public boolean onTouch (View v, MotionEvent event) {
	            mreadThread = new readThread();  
	            mreadThread.start();
				   // TODO Auto-generated method stub
	            
	            
	            textview=(TextView)findViewById(R.id.textView1);
	            
	            
				mAdapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, msgList);  
	            mListView = (ListView) findViewById(R.id.mListView);  
	            mListView.setAdapter(mAdapter); 
			      String message;
			      byte[] msgBuffer;
			      int action = event.getAction();
			      switch (action) {
			      case MotionEvent.ACTION_DOWN:
			          try {
			              outStream = btSocket.getOutputStream();
			              } 
			          catch (IOException e)  {
			              Log.e(TAG, "front is wrong", e);
			              }
			          message = "front";
			          msgBuffer = message.getBytes();
			          try {
			              outStream.write(msgBuffer);
			              } 
			          catch (IOException e) {
			              Log.e(TAG, "front1 is wrong", e);
			              }
			          break;
			          case MotionEvent.ACTION_UP:
			              try {
			                  outStream = btSocket.getOutputStream();
			                  } 
			              catch (IOException e) {
			                  Log.e (TAG,"ON RESUME: Output stream creation failed.", e);
			                  }
			              message="";
			              msgBuffer = message.getBytes();
			              try {
			                  outStream.write(msgBuffer);
			                  }
			              catch (IOException e) {
			                  Log.e (TAG, "ON RESUME: Exception during write.", e);
			                  }
			              break;
			              }
			      return false;
			      }
		      });       
//ǰ��
		
		                
//����
		                mButtonB=(Button) findViewById (R.id.btnB);
		                mButtonB.setOnTouchListener(new Button.OnTouchListener(){
		                    public boolean onTouch (View v,MotionEvent event) {
		                        String message;
		                        byte[] msgBuffer;
		                        int action = event.getAction();
		                        switch(action)
		                        {
		                            case MotionEvent.ACTION_DOWN:
		                                try {
		                                    outStream = btSocket.getOutputStream();
		                                    } 
		                                catch (IOException e) {
		                                    Log.e(TAG, "ON RESUME: Output stream creation failed.", e);
		                                    }
		                                message = "back";
		                                msgBuffer = message.getBytes();
		                                try {
		                                    outStream.write(msgBuffer);
		                                    }
		                                catch (IOException e) {
		                                    Log.e(TAG, "ON RESUME: Exception during write.", e);
		                                    }
		                                break;
		                                case MotionEvent.ACTION_UP:
		                                    try {
		                                        outStream = btSocket.getOutputStream();
		                                        } catch (IOException e) {
		                                            Log.e(TAG, "ON RESUME: Output stream creation failed.", e);
		                                            }
		                                    message = "";
		                                    msgBuffer = message.getBytes();
		                                    try {
		                                        outStream.write(msgBuffer);
		                                        } catch (IOException e) {
		                                            Log.e(TAG,"ON RESUME:Exception during write.",e);
		                                            }
		                                    break;
		                                    }
		                        return false;
		                        }
		                    });
//����
		    		                
//��ת		                
		                mButtonL=(Button)findViewById(R.id.btnL);
		                mButtonL.setOnTouchListener(new Button.OnTouchListener(){
		                    public boolean onTouch(View v, MotionEvent event) {
		                        String message;
		                        byte[] msgBuffer;
		                        int action = event.getAction();
		                        switch(action)
		                        {
		                            case MotionEvent.ACTION_DOWN:
		                                try {
		                                    outStream = btSocket.getOutputStream();
		                                    }
		                                catch (IOException e) {
		                                    Log.e(TAG, "ON RESUME: Output stream creation failed.", e);
		                                    }
		                                message = "left";
		                                msgBuffer = message.getBytes();
		                                try {
		                                    outStream.write(msgBuffer);
		                                    }
		                                catch (IOException e) {
		                                        Log.e(TAG, "ON RESUME: Exception during write.", e);
		                                        }
		                                break;
		                                case MotionEvent.ACTION_UP:
		                                    try {
		                                        outStream = btSocket.getOutputStream();
		                                        }
		                                    catch (IOException e) {
		                                            Log.e(TAG, "ON RESUME: Output stream creation failed.", e);
		                                            }
		                                    message = "";
		                                    msgBuffer = message.getBytes();
		                                    try {
		                                        outStream.write(msgBuffer);
		                                        }
		                                    catch (IOException e) {
		                                            Log.e(TAG, "ON RESUME: Exception during write.", e);
		                                            }
		                                    break;
		                                    }
		                        return false;
		                        }
		                    });             
//��ת				                
		 
		                
//��ת
   		                mButtonR=(Button)findViewById(R.id.btnR);
		                mButtonR.setOnTouchListener(new Button.OnTouchListener(){
		                    public boolean onTouch(View v, MotionEvent event) {
		                        String message;
		                        byte[] msgBuffer;
		                        int action = event.getAction();
		                        switch(action)
		                        {
		                            case MotionEvent.ACTION_DOWN:
		                                try {
		                                    outStream = btSocket.getOutputStream();
		                                    }
		                                catch (IOException e) {
		                                        Log.e(TAG, "ON RESUME: Output stream creation failed.", e);
		                                        }
		                                message = "right";
		                                msgBuffer = message.getBytes();
		                                try {
		                                    outStream.write(msgBuffer);
		                                    }
		                                catch (IOException e) {
		                                        Log.e(TAG, "ON RESUME: Exception during write.", e);
		                                        }
		                                break;
		                                case MotionEvent.ACTION_UP:
		                                    try {
		                                        outStream = btSocket.getOutputStream();
		                                        }
		                                    catch (IOException e) {
		                                            Log.e(TAG, "ON RESUME: Output stream creation failed.", e);
		                                            }
		                                    message = "";
		                                    msgBuffer = message.getBytes();
		                                    try {
		                                        outStream.write(msgBuffer);
		                                        }
		                                    catch (IOException e) {
		                                            Log.e(TAG, "ON RESUME: Exception during write.", e);
		                                            }
		                                    break;
		                                    }
		                        return false;
		                        }
		                    });
//��ת
		                
		                
//ֹͣ		                

   		                mButtonS=(Button)findViewById(R.id.btnS);
		                mButtonS.setOnTouchListener(new Button.OnTouchListener(){
		                    public boolean onTouch(View v, MotionEvent event) {
		                        String message;
		                        byte[] msgBuffer;
		                        int action = event.getAction();
		                        switch(action)
		                        {
		                            case MotionEvent.ACTION_DOWN:
		                                try {
		                                    outStream = btSocket.getOutputStream();
		                                    }
		                                catch (IOException e) {
		                                        Log.e(TAG, "ON RESUME: Output stream creation failed.", e);
		                                        }
		                                message = "stop";
		                                msgBuffer = message.getBytes();
		                                try {
		                                    outStream.write(msgBuffer);
		                                    }
		                                catch (IOException e) {
		                                        Log.e(TAG, "ON RESUME: Exception during write.", e);
		                                        }
		                                break;
		                                case MotionEvent.ACTION_UP:
		                                    try {
		                                        outStream = btSocket.getOutputStream();
		                                        }
		                                    catch (IOException e) {
		                                            Log.e(TAG, "ON RESUME: Output stream creation failed.", e);
		                                            }
		                                    message = "";
		                                    msgBuffer = message.getBytes();
		                                    try {
		                                        outStream.write(msgBuffer);
		                                        }
		                                    catch (IOException e) {
		                                            Log.e(TAG, "ON RESUME: Exception during write.", e);
		                                            }
		                                    break;
		                                    }
		                        return false;
		                        }
		                    });
//ֹͣ
		                
		                
		                if (D)
		                    Log.e(TAG, "+++ ON CREATE +++");
		                mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		                if (mBluetoothAdapter == null) {
		                    Toast.makeText(this, "�޷��������", 2000).show();
		                    finish();
		                    return;
		                    }
		                if (!mBluetoothAdapter.isEnabled()) {
		                    Toast.makeText(this, "��ȷ����������豸�Ѿ��򿪣���������������", 2000).show();
		                    finish();
		                    return;
		                    }
		                if (D)
		                    Log.e(TAG, "+++ DONE IN ON CREATE, GOT LOCAL BT ADAPTER +++");
		               
		                    }
	//�˴�Ϊ��һ��������������
	
	
	
    private class readThread extends Thread {   
        @Override  
        public void run() {  

            byte[] buffer = new byte[4096];  
            int bytes;  
            InputStream mmInStream = null;  
            String s="";
            try {  
                mmInStream = btSocket.getInputStream();  
            } catch (IOException e1) {  
                // TODO Auto-generated catch block  
                e1.printStackTrace();  
            }     
            while (D) {  
                try {  
                    // Read from the InputStream  
                    if( (bytes = mmInStream.read(buffer)) > 0 )  
                    {  
                        byte[] buf_data = new byte[bytes];  
                        for(int i=0; i<bytes; i++)  
                        {  
                            buf_data[i] = buffer[i];
//                            result += buf_data[i];
//                            result=(String)result;
                        }  
                        s = new String(buf_data);  
                        s = (String)s;
                        s.replace('\n','v');
                        Message msg = new Message();  
                        msg.obj = (String)s;  
//                        msg.obj.replace("\n", "");
                        msg.what = 1;  
                        LinkDetectedHandler.sendMessage(msg);
                    }  
                    
                } catch (IOException e) {  
                    try {  
                        mmInStream.close();  
                    } catch (IOException e1) {  
                        // TODO Auto-generated catch block  
                        e1.printStackTrace();  
                    } 
                    break;  
                } 
//                finally {
//                    textview.setText(s);	
//                } 
            }  
        }  
    }
//
//	
    
    private Handler LinkDetectedHandler = new Handler() {  
        @Override  
public void handleMessage(Message msg) {  
            //Toast.makeText(mContext, (String)msg.obj, Toast.LENGTH_SHORT).show();  
//        	 msg.obj = s;  
//             msg.what = 1;
        	
        	if(msg.what==1)  
            {  
                msgList.add((String)msg.obj);  
            }  
            else  
            {  
                msgList.add((String)msg.obj);  
            }  
            mAdapter.notifyDataSetChanged();  
            mListView.setSelection(msgList.size() - 1);  
        }  
    };  
    
	
    public void onStart() {
        super.onStart();
        if (D)
            Log.e(TAG, "++ ON START ++");
        }
        public void onResume() {
        super.onResume();
        if (D) {
            Log.e(TAG, "+ ON RESUME +");
            Log.e(TAG, "+ ABOUT TO ATTEMPT CLIENT CONNECT +");
            }
        BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
        try {
            btSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
            }
        catch (IOException e) {
                Log.e(TAG, "ON RESUME: Socket creation failed.", e);
                }

        mBluetoothAdapter.cancelDiscovery();
        try {
            btSocket.connect();

            Log.e(TAG, "ON RESUME: BT connection established, data transfer link open.");
            }
        catch (IOException e) {
            try {

                    btSocket.close();
                    }
            catch (IOException e2) {
                        Log .e(TAG,"ON RESUME: Unable to close socket during connection failure", e2);
                        }
                }
        // Create a data stream so we can talk to server.
        if (D)
            Log.e(TAG, "+ ABOUT TO SAY SOMETHING TO SERVER +");
        }
    public void onPause() {
        super.onPause();
        if (D)
            Log.e(TAG, "- ON PAUSE -");
        if (outStream!= null) {
            try {
                outStream.flush();
                }
            catch (IOException e) {
                    Log.e(TAG, "ON PAUSE: Couldn't flush output stream.", e);
                    }
            }
                try {
            btSocket.close();

            }
        catch (IOException e2) {
                Log.e(TAG, "ON PAUSE: Unable to close socket.", e2);
                }
        }
    public void onStop() {
        super.onStop();
        if (D)
        	Log.e(TAG, "-- ON STOP --");
        }
    public void onDestroy() {
        super.onDestroy();
        if (D) 
        	Log.e(TAG, "--- ON DESTROY ---");
        }

    
		@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
