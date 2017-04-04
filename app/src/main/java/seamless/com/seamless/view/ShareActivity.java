package seamless.com.seamless.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class ShareActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		String action = intent.getAction();
		String type = intent.getType();

		if (Intent.ACTION_SEND.equals(action) && type != null) {
//			if ("text/plain".equals(type)) {
//				handleSendText(intent); // Handle text being sent
//			} else if (type.startsWith("image/")) {
//				handleSendImage(intent); // Handle single image being sent
//			}
//		} else if (Intent.ACTION_SEND_MULTIPLE.equals(action) && type != null) {
//			if (type.startsWith("image/")) {
//				handleSendMultipleImages(intent); // Handle multiple images being sent
//			}
//		} else {
			Log.d("Handling intent", "Handling intent");
			// Handle other intents, such as being started from the home screen
		}
	}
}
