package cordova.plugin.greatdayatt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.json.JSONException;

/**
 * This class echoes a string called from JavaScript.
 */
public class GreatdayAtt extends CordovaPlugin {
  public CallbackContext context;

  @Override
  public boolean execute(String action, String args, final CallbackContext callbackContext) throws JSONException {
    this.context = callbackContext;
    if (action.equals("add")) {

      Context context = cordova.getActivity().getApplicationContext();
      this.openNewActivity(context, args);
      return true;
    } else if (action.equals("test")) {
      return true;
    }
    return false;
  }

  private void openNewActivity(Context context, String args) {
    Log.v("args log ", "ssss" + args);
    String value = "hallo haahha";
    Intent intent = new Intent(context, cordova.plugin.greatdayatt.AttActivity.class);
    intent.putExtra("value", args);
    cordova.startActivityForResult((CordovaPlugin) this, intent, 0);
  }


  @Override
  public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
    if (resultCode == cordova.getActivity().RESULT_OK) {
      Bundle extras = data.getExtras();// Get data sent by the Intent
      String information = extras.getString("result");
      Log.d("on Result ", information);
      PluginResult result = new PluginResult(PluginResult.Status.OK, information);
      this.context.sendPluginResult(result);
    } else if (resultCode == cordova.getActivity().RESULT_CANCELED) {
      PluginResult resultado = new PluginResult(PluginResult.Status.OK, "canceled action, process this in javascript");
    }
    super.onActivityResult(requestCode, resultCode, data);
  }


}

